package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static boolean canTrimSamplesWithTimestampChange(int i) {
        return i != 1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (trackApply = function.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia))).getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i));
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i));
            } else if (i2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i);
        }
        return metadata;
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < i) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w(TAG, "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> edts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(Atom.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd))).data);
        long jScaleLargeTimestamp = C.TIME_UNSET;
        long j2 = j == C.TIME_UNSET ? tkhd.duration : j;
        long j3 = parseMvhd(leafAtom.data).timescale;
        if (j2 != C.TIME_UNSET) {
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000000L, j3);
        }
        long j4 = jScaleLargeTimestamp;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl));
        Pair<Long, String> mdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_mdhd))).data);
        Atom.LeafAtom leafAtomOfType = containerAtom3.getLeafAtomOfType(Atom.TYPE_stsd);
        if (leafAtomOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafAtomOfType.data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_edts)) == null || (edts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), j3, j4, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14, types: [int] */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28, types: [int] */
    /* JADX WARN: Type inference failed for: r8v29, types: [int] */
    /* JADX WARN: Type inference failed for: r8v30, types: [int] */
    /* JADX WARN: Type inference failed for: r8v47 */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        boolean z2;
        long j;
        long[] jArrCopyOf;
        int i;
        int i2;
        long j2;
        boolean z3;
        int[] iArr;
        long[] jArr;
        int i3;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        long j3;
        int[] iArr6;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_co64));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_stsc))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_stts))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt3 > 0) {
                unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt() - 1;
                z2 = false;
            } else {
                unsignedIntToInt2 = -1;
                z2 = false;
                parsableByteArray4 = null;
            }
        } else {
            unsignedIntToInt2 = -1;
            unsignedIntToInt3 = 0;
            z2 = false;
        }
        int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str = track.format.sampleMimeType;
        boolean z5 = (fixedSampleSize == -1 || !((MimeTypes.AUDIO_RAW.equals(str) || MimeTypes.AUDIO_MLAW.equals(str) || MimeTypes.AUDIO_ALAW.equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt3 == 0)) ? z2 ? 1 : 0 : true;
        SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
        if (z5) {
            long[] jArr2 = new long[chunkIterator.length];
            int[] iArr7 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr2[chunkIterator.index] = chunkIterator.offset;
                iArr7[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr2, iArr7, unsignedIntToInt6);
            long[] jArr3 = resultsRechunk.offsets;
            iArr = resultsRechunk.sizes;
            int i7 = resultsRechunk.maximumSize;
            long[] jArr4 = resultsRechunk.timestamps;
            int[] iArr8 = resultsRechunk.flags;
            j2 = resultsRechunk.duration;
            jArr = jArr3;
            i3 = i7;
            jArrCopyOf = jArr4;
            iArr2 = iArr8;
            j = 0;
        } else {
            long[] jArr5 = new long[sampleCount];
            j = 0;
            int[] iArrCopyOf = new int[sampleCount];
            jArrCopyOf = new long[sampleCount];
            ParsableByteArray parsableByteArray6 = parsableByteArray5;
            int[] iArrCopyOf2 = new int[sampleCount];
            ParsableByteArray parsableByteArray7 = parsableByteArray4;
            int unsignedIntToInt7 = unsignedIntToInt2;
            int i8 = z2 ? 1 : 0;
            int i9 = i8;
            int i10 = i9 == true ? 1 : 0;
            int i11 = i10;
            long j4 = 0;
            long j5 = 0;
            int i12 = unsignedIntToInt;
            int i13 = unsignedIntToInt6;
            int i14 = unsignedIntToInt5;
            int i15 = unsignedIntToInt4;
            int i16 = i11 == true ? 1 : 0;
            while (true) {
                if (i8 >= sampleCount) {
                    boolean z6 = sampleCount == true ? 1 : 0;
                    i = i14;
                    i2 = i10;
                    break;
                }
                long j6 = j5;
                int i17 = i10;
                boolean zMoveNext = true;
                while (i17 == 0) {
                    zMoveNext = chunkIterator.moveNext();
                    if (!zMoveNext) {
                        break;
                    }
                    int i18 = i14;
                    long j7 = chunkIterator.offset;
                    i17 = chunkIterator.numSamples;
                    j6 = j7;
                    i14 = i18;
                    i13 = i13;
                    sampleCount = sampleCount == true ? 1 : 0;
                }
                int i19 = sampleCount;
                i = i14;
                int i20 = i13;
                if (!zMoveNext) {
                    Log.w(TAG, "Unexpected end of chunk data");
                    long[] jArrCopyOf2 = Arrays.copyOf(jArr5, i8);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i8);
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i8);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i8);
                    jArr5 = jArrCopyOf2;
                    sampleCount = i8;
                    i2 = i17;
                    break;
                }
                if (parsableByteArray6 != null) {
                    int unsignedIntToInt8 = i11 == true ? 1 : 0;
                    while (unsignedIntToInt8 == 0 && i12 > 0) {
                        unsignedIntToInt8 = parsableByteArray6.readUnsignedIntToInt();
                        i9 = parsableByteArray6.readInt();
                        i12--;
                    }
                    i11 = unsignedIntToInt8 - 1;
                }
                jArr5[i8] = j6;
                int nextSampleSize = sampleSizeBox.readNextSampleSize();
                iArrCopyOf[i8] = nextSampleSize;
                if (nextSampleSize > i16) {
                    i16 = nextSampleSize;
                }
                jArrCopyOf[i8] = j4 + ((long) i9);
                iArrCopyOf2[i8] = parsableByteArray7 == null ? 1 : z2 ? 1 : 0;
                if (i8 == unsignedIntToInt7) {
                    iArrCopyOf2[i8] = 1;
                    unsignedIntToInt3--;
                    if (unsignedIntToInt3 > 0) {
                        unsignedIntToInt7 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray7)).readUnsignedIntToInt() - 1;
                    }
                }
                j4 += (long) i20;
                int unsignedIntToInt9 = i - 1;
                if (unsignedIntToInt9 != 0 || i15 <= 0) {
                    i13 = i20;
                } else {
                    unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                    i15--;
                    i13 = parsableByteArray3.readInt();
                }
                i14 = unsignedIntToInt9;
                long j8 = j6 + ((long) iArrCopyOf[i8]);
                i10 = i17 - 1;
                i8++;
                j5 = j8;
                sampleCount = i19 == true ? 1 : 0;
            }
            j2 = j4 + ((long) i9);
            if (parsableByteArray6 == null) {
                z3 = true;
                break;
            }
            while (true) {
                if (i12 <= 0) {
                    z3 = true;
                    break;
                }
                if (parsableByteArray6.readUnsignedIntToInt() != 0) {
                    z3 = z2 ? 1 : 0;
                    break;
                }
                parsableByteArray6.readInt();
                i12--;
            }
            if (unsignedIntToInt3 != 0 || i != 0 || i2 != 0 || i15 != 0 || i11 != 0 || !z3) {
                Log.w(TAG, "Inconsistent stbl box for track " + track.id + ": remainingSynchronizationSamples " + unsignedIntToInt3 + ", remainingSamplesAtTimestampDelta " + i + ", remainingSamplesInChunk " + i2 + ", remainingTimestampDeltaChanges " + i15 + ", remainingSamplesAtTimestampOffset " + (i11 == true ? 1 : 0 ? 1 : 0) + (!z3 ? ", ctts invalid" : ""));
            }
            iArr = iArrCopyOf;
            jArr = jArr5;
            i3 = i16 == true ? 1 : 0;
            iArr2 = iArrCopyOf2;
        }
        long j9 = j2;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j9, 1000000L, track.timescale);
        if (track.editListDurations == null) {
            Util.scaleLargeTimestampsInPlace(jArrCopyOf, 1000000L, track.timescale);
            return new TrackSampleTable(track, jArr, iArr, i3 == true ? 1 : 0, jArrCopyOf, iArr2, jScaleLargeTimestamp);
        }
        int i21 = sampleCount;
        int[] iArr9 = iArr;
        if (track.editListDurations.length == 1 && track.type == 1 && jArrCopyOf.length >= 2) {
            long j10 = ((long[]) Assertions.checkNotNull(track.editListMediaTimes))[z2 ? 1 : 0];
            long jScaleLargeTimestamp2 = j10 + Util.scaleLargeTimestamp(track.editListDurations[z2 ? 1 : 0], track.timescale, track.movieTimescale);
            long[] jArr6 = jArr;
            long[] jArr7 = jArrCopyOf;
            jArrCopyOf = jArr7;
            if (canApplyEditWithGaplessInfo(jArr7, j9, j10, jScaleLargeTimestamp2)) {
                long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j10 - jArrCopyOf[z2 ? 1 : 0], track.format.sampleRate, track.timescale);
                long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j9 - jScaleLargeTimestamp2, track.format.sampleRate, track.timescale);
                if (jScaleLargeTimestamp3 != j || jScaleLargeTimestamp4 != j) {
                    iArr3 = iArr9;
                    iArr3 = iArr9;
                    iArr3 = iArr9;
                    j9 = j9;
                    iArr3 = iArr9;
                    iArr3 = iArr9;
                    iArr3 = iArr9;
                    j9 = j9;
                    if (jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                        gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                        gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                        Util.scaleLargeTimestampsInPlace(jArrCopyOf, 1000000L, track.timescale);
                        return new TrackSampleTable(track, jArr6, iArr9, i3 == true ? 1 : 0, jArrCopyOf, iArr2, Util.scaleLargeTimestamp(track.editListDurations[z2 ? 1 : 0], 1000000L, track.movieTimescale));
                    }
                }
            }
            iArr3 = iArr9;
            iArr3 = iArr9;
            iArr3 = iArr9;
            j9 = j9;
            iArr3 = iArr9;
            iArr3 = iArr9;
            iArr3 = iArr9;
            j9 = j9;
            jArr = jArr6;
            iArr3 = iArr9;
        }
        iArr3 = iArr9;
        iArr3 = iArr9;
        iArr3 = iArr9;
        iArr3 = iArr9;
        iArr3 = iArr9;
        iArr3 = iArr9;
        if (track.editListDurations.length == 1 && track.editListDurations[z2 ? 1 : 0] == j) {
            long j11 = ((long[]) Assertions.checkNotNull(track.editListMediaTimes))[z2 ? 1 : 0];
            for (int i22 = z2 ? 1 : 0; i22 < jArrCopyOf.length; i22++) {
                jArrCopyOf[i22] = Util.scaleLargeTimestamp(jArrCopyOf[i22] - j11, 1000000L, track.timescale);
            }
            return new TrackSampleTable(track, jArr, iArr3, i3 == true ? 1 : 0, jArrCopyOf, iArr2, Util.scaleLargeTimestamp(j9 - j11, 1000000L, track.timescale));
        }
        boolean z7 = track.type == 1 ? true : z2 ? 1 : 0;
        int[] iArr10 = new int[track.editListDurations.length];
        int[] iArr11 = new int[track.editListDurations.length];
        long[] jArr8 = (long[]) Assertions.checkNotNull(track.editListMediaTimes);
        int i23 = z2 ? 1 : 0;
        boolean z8 = i23 == true ? 1 : 0;
        int i24 = z8 ? 1 : 0;
        int i25 = i24;
        boolean z9 = z8;
        while (i23 < track.editListDurations.length) {
            int[] iArr12 = iArr10;
            int[] iArr13 = iArr11;
            long j12 = jArr8[i23];
            int i26 = i3;
            if (j12 != -1) {
                long j13 = track.editListDurations[i23];
                int i27 = i23;
                boolean z10 = z9 ? 1 : 0;
                long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j13, track.timescale, track.movieTimescale);
                i4 = i27 == true ? 1 : 0;
                iArr12[i4 == true ? 1 : 0] = Util.binarySearchFloor(jArrCopyOf, j12, true, true);
                long j14 = j12 + jScaleLargeTimestamp5;
                z4 = z2;
                iArr13[i4 == true ? 1 : 0] = Util.binarySearchCeil(jArrCopyOf, j14, z7, z4);
                while (true) {
                    i5 = iArr12[i4 == true ? 1 : 0];
                    i6 = iArr13[i4 == true ? 1 : 0];
                    if (i5 >= i6 || (iArr2[i5] & 1) != 0) {
                        break;
                    }
                    iArr12[i4 == true ? 1 : 0] = i5 + 1;
                }
                i24 += i6 - i5;
                z9 = (z10 ? 1 : 0) | (i25 != i5 ? true : z4 ? 1 : 0);
                i25 = i6;
            } else {
                i4 = i23;
                boolean z11 = z9 ? 1 : 0;
                z4 = z2;
            }
            i3 = i26 == true ? 1 : 0;
            z2 = z4;
            iArr11 = iArr13;
            i23 = i4 + 1;
            iArr10 = iArr12;
            z9 = z9;
        }
        int i28 = i3;
        int[] iArr14 = iArr10;
        int[] iArr15 = iArr11;
        boolean z12 = z2;
        boolean z13 = (z9 ? 1 : 0 ? 1 : 0) | (i24 != i21 ? true : z12);
        long[] jArr9 = z13 != 0 ? new long[i24] : jArr;
        if (z13 != 0) {
            iArr6 = new int[i24];
        } else {
            iArr4 = iArr3;
        }
        boolean z14 = z13 != 0 ? z12 : i28 == true ? 1 : 0;
        if (z13 != 0) {
            iArr4 = iArr6;
            iArr4 = iArr6;
            iArr5 = new int[i24];
        } else {
            iArr4 = iArr6;
            iArr4 = iArr6;
            iArr5 = iArr2;
        }
        long[] jArr10 = new long[i24];
        ?? r12 = z14;
        ?? r8 = z12;
        long j15 = j;
        boolean z15 = z13;
        ?? r3 = iArr3;
        ?? r11 = z12;
        while (r11 < track.editListDurations.length) {
            long j16 = track.editListMediaTimes[r11];
            int i29 = iArr14[r11];
            int i30 = iArr15[r11];
            boolean z16 = z15;
            if (z15 != 0) {
                int i31 = i30 - i29;
                System.arraycopy(jArr, i29, jArr9, r8, i31);
                System.arraycopy(r3, i29, iArr4, r8, i31);
                System.arraycopy(iArr2, i29, iArr5, r8, i31);
            }
            while (i29 < i30) {
                long[] jArr11 = jArr;
                ?? r27 = r3;
                long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j15, 1000000L, track.movieTimescale);
                long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArrCopyOf[i29] - j16, 1000000L, track.timescale);
                long[] jArr12 = jArr9;
                if (canTrimSamplesWithTimestampChange(track.type)) {
                    j3 = j;
                    jScaleLargeTimestamp7 = Math.max(j3, jScaleLargeTimestamp7);
                } else {
                    j3 = j;
                }
                jArr10[r8] = jScaleLargeTimestamp6 + jScaleLargeTimestamp7;
                if (z16 != 0 && iArr4[r8] > r12) {
                    r12 = r27[i29];
                }
                r8++;
                i29++;
                jArr = jArr11;
                j = j3;
                r3 = r27;
                jArr9 = jArr12;
                jArrCopyOf = jArrCopyOf;
            }
            j15 += track.editListDurations[r11];
            jArr = jArr;
            jArr9 = jArr9;
            jArrCopyOf = jArrCopyOf;
            z15 = z16;
            r3 = r3;
            r8 = r8;
            r11++;
            r12 = r12;
        }
        return new TrackSampleTable(track, jArr9, iArr4, r12 == true ? 1 : 0, jArr10, iArr5, Util.scaleLargeTimestamp(j15, 1000000L, track.movieTimescale));
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = C.TIME_UNSET;
            if (i4 < i2) {
                if (parsableByteArray.getData()[position + i4] != -1) {
                    long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt == 0) {
                        break;
                    }
                    j = unsignedInt;
                    break;
                }
                i4++;
            } else {
                parsableByteArray.skipBytes(i2);
                break;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = RotationOptions.ROTATE_270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = RotationOptions.ROTATE_180;
        }
        return new TkhdData(i, j, i3);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i3 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i3);
        int i4 = 0;
        while (i4 < i3) {
            int position = parsableByteArray.getPosition();
            int i5 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i5 > 0, "childAtomSize must be positive");
            int i6 = parsableByteArray.readInt();
            if (i6 == 1635148593 || i6 == 1635148595 || i6 == 1701733238 || i6 == 1831958048 || i6 == 1836070006 || i6 == 1752589105 || i6 == 1751479857 || i6 == 1932670515 || i6 == 1211250227 || i6 == 1987063864 || i6 == 1987063865 || i6 == 1635135537 || i6 == 1685479798 || i6 == 1685479729 || i6 == 1685481573 || i6 == 1685481521) {
                StsdData stsdData2 = stsdData;
                int i7 = i4;
                parseVideoSampleEntry(parsableByteArray, i6, position, i5, i, i2, drmInitData, stsdData2, i7);
                stsdData = stsdData2;
                i4 = i7;
            } else if (i6 == 1836069985 || i6 == 1701733217 || i6 == 1633889587 || i6 == 1700998451 || i6 == 1633889588 || i6 == 1835823201 || i6 == 1685353315 || i6 == 1685353317 || i6 == 1685353320 || i6 == 1685353324 || i6 == 1685353336 || i6 == 1935764850 || i6 == 1935767394 || i6 == 1819304813 || i6 == 1936684916 || i6 == 1953984371 || i6 == 778924082 || i6 == 778924083 || i6 == 1835557169 || i6 == 1835560241 || i6 == 1634492771 || i6 == 1634492791 || i6 == 1970037111 || i6 == 1332770163 || i6 == 1716281667) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, i6, position, i5, i, str, z, drmInitData, stsdData3, i4);
                stsdData = stsdData3;
            } else if (i6 == 1414810956 || i6 == 1954034535 || i6 == 2004251764 || i6 == 1937010800 || i6 == 1664495672) {
                parseTextSampleEntry(parsableByteArray, i6, position, i5, i, str, stsdData);
            } else if (i6 == 1835365492) {
                parseMetaDataSampleEntry(parsableByteArray, i6, position, i, stsdData);
            } else if (i6 == 1667329389) {
                stsdData.format = new Format.Builder().setId(i).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
            }
            parsableByteArray.setPosition(position + i5);
            i4++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableListOf = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        int i7;
        int i8;
        int i9;
        int i10 = i2;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i10 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str2 = MimeTypes.VIDEO_H263;
        if (iIntValue != 1831958048) {
            str = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        } else {
            str = MimeTypes.VIDEO_MPEG;
        }
        float paspFromParent = 1.0f;
        int i12 = 8;
        int i13 = 8;
        List<byte[]> listOf = null;
        String str3 = null;
        byte[] projFromParent = null;
        int i14 = -1;
        int i15 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i16 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        ByteBuffer byteBufferAllocateHdrStaticInfo = null;
        EsdsData esdsFromParent = null;
        boolean z = false;
        while (position - i10 < i11) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i17 = parsableByteArray.readInt();
            if (i17 == 0 && parsableByteArray.getPosition() - i10 == i11) {
                break;
            }
            ExtractorUtil.checkContainerInput(i17 > 0, "childAtomSize must be positive");
            int i18 = parsableByteArray.readInt();
            if (i18 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                List<byte[]> list = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str4 = avcConfig.codecs;
                int i19 = avcConfig.maxNumReorderFrames;
                int i20 = avcConfig.colorSpace;
                int i21 = avcConfig.colorRange;
                int i22 = avcConfig.colorTransfer;
                int i23 = avcConfig.bitdepthLuma;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                position = position;
                iIntValue = iIntValue;
                str2 = str2;
                i15 = i19;
                iIsoColorPrimariesToColorSpace = i20;
                i16 = i21;
                iIsoTransferCharacteristicsToColorTransfer = i22;
                i13 = avcConfig.bitdepthChroma;
                i12 = i23;
                listOf = list;
                str = MimeTypes.VIDEO_H264;
                str3 = str4;
            } else if (i18 == 1752589123) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                List<byte[]> list2 = hevcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = hevcConfig.pixelWidthHeightRatio;
                }
                int i24 = hevcConfig.maxNumReorderPics;
                String str5 = hevcConfig.codecs;
                int i25 = hevcConfig.colorSpace;
                int i26 = hevcConfig.colorRange;
                int i27 = hevcConfig.colorTransfer;
                int i28 = hevcConfig.bitdepthLuma;
                int i29 = hevcConfig.bitdepthChroma;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                position = position;
                i15 = i24;
                iIntValue = iIntValue;
                str2 = str2;
                iIsoColorPrimariesToColorSpace = i25;
                i16 = i26;
                iIsoTransferCharacteristicsToColorTransfer = i27;
                str = MimeTypes.VIDEO_H265;
                i12 = i28;
                str3 = str5;
                listOf = list2;
                i13 = i29;
            } else {
                if (i18 == 1685480259 || i18 == 1685485123) {
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    position = position;
                    iIntValue = iIntValue;
                    str2 = str2;
                    i7 = i12;
                    i8 = iIsoColorPrimariesToColorSpace;
                    i9 = iIsoTransferCharacteristicsToColorTransfer;
                    DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                    if (dolbyVisionConfig != null) {
                        String str6 = dolbyVisionConfig.codecs;
                        str = MimeTypes.VIDEO_DOLBY_VISION;
                        str3 = str6;
                    }
                } else if (i18 == 1987076931) {
                    ExtractorUtil.checkContainerInput(str == null, null);
                    String str7 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                    parsableByteArray.setPosition(position2 + 12);
                    parsableByteArray.skipBytes(2);
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    int i30 = unsignedByte >> 4;
                    boolean z2 = (unsignedByte & 1) != 0;
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte2);
                    i16 = z2 ? 1 : 2;
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte3);
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    position = position;
                    i12 = i30;
                    i13 = i12;
                    iIntValue = iIntValue;
                    str2 = str2;
                    str = str7;
                } else if (i18 == 1635135811) {
                    int i31 = i17 - 8;
                    byte[] bArr = new byte[i31];
                    parsableByteArray.readBytes(bArr, 0, i31);
                    listOf = ImmutableList.of(bArr);
                    parsableByteArray.setPosition(position2 + 8);
                    ColorInfo av1c = parseAv1c(parsableByteArray);
                    int i32 = av1c.lumaBitdepth;
                    int i33 = av1c.chromaBitdepth;
                    int i34 = av1c.colorSpace;
                    int i35 = av1c.colorRange;
                    iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    position = position;
                    iIntValue = iIntValue;
                    str2 = str2;
                    iIsoColorPrimariesToColorSpace = i34;
                    i16 = i35;
                    str = MimeTypes.VIDEO_AV1;
                    i12 = i32;
                    i13 = i33;
                } else if (i18 == 1668050025) {
                    if (byteBufferAllocateHdrStaticInfo == null) {
                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer = byteBufferAllocateHdrStaticInfo;
                    byteBuffer.position(21);
                    byteBuffer.putShort(parsableByteArray.readShort());
                    byteBuffer.putShort(parsableByteArray.readShort());
                    byteBufferAllocateHdrStaticInfo = byteBuffer;
                } else if (i18 == 1835295606) {
                    if (byteBufferAllocateHdrStaticInfo == null) {
                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer2 = byteBufferAllocateHdrStaticInfo;
                    short s = parsableByteArray.readShort();
                    short s2 = parsableByteArray.readShort();
                    short s3 = parsableByteArray.readShort();
                    short s4 = parsableByteArray.readShort();
                    short s5 = parsableByteArray.readShort();
                    short s6 = parsableByteArray.readShort();
                    short s7 = parsableByteArray.readShort();
                    int i36 = i12;
                    short s8 = parsableByteArray.readShort();
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    long unsignedInt2 = parsableByteArray.readUnsignedInt();
                    byteBuffer2.position(1);
                    byteBuffer2.putShort(s5);
                    byteBuffer2.putShort(s6);
                    byteBuffer2.putShort(s);
                    byteBuffer2.putShort(s2);
                    byteBuffer2.putShort(s3);
                    byteBuffer2.putShort(s4);
                    byteBuffer2.putShort(s7);
                    byteBuffer2.putShort(s8);
                    byteBuffer2.putShort((short) (unsignedInt / 10000));
                    byteBuffer2.putShort((short) (unsignedInt2 / 10000));
                    byteBufferAllocateHdrStaticInfo = byteBuffer2;
                    i12 = i36;
                } else {
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    position = position;
                    iIntValue = iIntValue;
                    str2 = str2;
                    i7 = i12;
                    if (i18 == 1681012275) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str = str2;
                    } else if (i18 == 1702061171) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                        String str8 = esdsFromParent.mimeType;
                        byte[] bArr2 = esdsFromParent.initializationData;
                        if (bArr2 != null) {
                            listOf = ImmutableList.of(bArr2);
                        }
                        str = str8;
                    } else if (i18 == 1885434736) {
                        paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                        i12 = i7;
                        z = true;
                    } else if (i18 == 1937126244) {
                        projFromParent = parseProjFromParent(parsableByteArray, position2, i17);
                    } else if (i18 == 1936995172) {
                        int unsignedByte4 = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(3);
                        if (unsignedByte4 == 0) {
                            int unsignedByte5 = parsableByteArray.readUnsignedByte();
                            if (unsignedByte5 == 0) {
                                i14 = 0;
                            } else if (unsignedByte5 == 1) {
                                i14 = 1;
                            } else if (unsignedByte5 == 2) {
                                i14 = 2;
                            } else if (unsignedByte5 == 3) {
                                i14 = 3;
                            }
                        }
                    } else {
                        i8 = iIsoColorPrimariesToColorSpace;
                        if (i18 == 1668246642) {
                            i9 = iIsoTransferCharacteristicsToColorTransfer;
                            if (i8 == -1 && i9 == -1) {
                                int i37 = parsableByteArray.readInt();
                                if (i37 == TYPE_nclx || i37 == TYPE_nclc) {
                                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                    parsableByteArray.skipBytes(2);
                                    boolean z3 = i17 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                    i16 = z3 ? 1 : 2;
                                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                } else {
                                    Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(i37));
                                }
                            }
                            i12 = i7;
                        } else {
                            i9 = iIsoTransferCharacteristicsToColorTransfer;
                        }
                    }
                    i12 = i7;
                }
                iIsoTransferCharacteristicsToColorTransfer = i9;
                iIsoColorPrimariesToColorSpace = i8;
                i12 = i7;
            }
            position += i17;
            i10 = i2;
            i11 = i3;
            stsdData2 = stsdData;
            iIntValue = iIntValue;
            str2 = str2;
            drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        int i38 = i12;
        int i39 = iIsoColorPrimariesToColorSpace;
        int i40 = iIsoTransferCharacteristicsToColorTransfer;
        if (str == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str3).setWidth(unsignedShort).setHeight(unsignedShort2).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i14).setInitializationData(listOf).setMaxNumReorderSamples(i15).setDrmInitData(drmInitData2).setColorInfo(new ColorInfo.Builder().setColorSpace(i39).setColorRange(i16).setColorTransfer(i40).setHdrStaticInfo(byteBufferAllocateHdrStaticInfo != null ? byteBufferAllocateHdrStaticInfo.array() : null).setLumaBitdepth(i38).setChromaBitdepth(i13).build());
        if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= bits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:133:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:139:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:142:0x021b  */
    /* JADX WARN: Code duplicated, block: B:143:0x0220  */
    /* JADX WARN: Code duplicated, block: B:146:0x0230  */
    /* JADX WARN: Code duplicated, block: B:148:0x0235  */
    /* JADX WARN: Code duplicated, block: B:150:0x0240  */
    /* JADX WARN: Code duplicated, block: B:152:0x024a  */
    /* JADX WARN: Code duplicated, block: B:153:0x024f  */
    /* JADX WARN: Code duplicated, block: B:155:0x0264  */
    /* JADX WARN: Code duplicated, block: B:194:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:196:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:197:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:200:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:202:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:204:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:205:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:207:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:225:0x03ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x03ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0090  */
    /* JADX WARN: Code duplicated, block: B:87:0x0140  */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int i6;
        int unsignedShort2;
        int unsignedFixedPoint1616;
        int i7;
        int i8;
        String str2;
        String str3;
        int i9;
        String str4;
        List<byte[]> listOf;
        String str5;
        EsdsData esdsFromParent;
        int i10;
        boolean z2;
        int i11;
        String str6;
        int iFindBoxPosition;
        byte[] bArr;
        char c;
        int unsignedByte;
        byte[] bArr2;
        int unsignedByte2;
        String str7;
        byte[] bArr3;
        ImmutableList immutableListOf;
        int i12 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i2 + 16);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            i6 = 2;
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            i7 = parsableByteArray.readInt();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            i8 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            unsignedShort2 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            boolean z3 = (unsignedIntToInt2 & 1) != 0;
            boolean z4 = (unsignedIntToInt2 & 2) != 0;
            i6 = 2;
            if (z3) {
                if (unsignedIntToInt == 32) {
                    i8 = 4;
                } else {
                    i8 = -1;
                }
            } else if (unsignedIntToInt == 8) {
                i8 = 3;
            } else if (unsignedIntToInt == 16) {
                i8 = z4 ? 268435456 : 2;
            } else if (unsignedIntToInt == 24) {
                i8 = z4 ? C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21;
            } else if (unsignedIntToInt == 32) {
                i8 = z4 ? C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22;
            } else {
                i8 = -1;
            }
            parsableByteArray.skipBytes(8);
            i7 = 0;
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i12);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str8 = MimeTypes.AUDIO_MPEGH_MHM1;
        if (iIntValue == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == 1633889588) {
            str2 = MimeTypes.AUDIO_AC4;
        } else if (iIntValue == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (iIntValue == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (iIntValue == 1935767394) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else {
            str3 = MimeTypes.AUDIO_RAW;
            if (iIntValue == 1936684916) {
                i9 = i6;
            } else if (iIntValue == 1953984371) {
                i9 = 268435456;
            } else if (iIntValue == 1819304813) {
                if (i8 == -1) {
                    i9 = i6;
                } else {
                    i9 = i8;
                }
            } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                str2 = MimeTypes.AUDIO_MPEG;
            } else if (iIntValue == 1835557169) {
                str2 = MimeTypes.AUDIO_MPEGH_MHA1;
            } else if (iIntValue == 1835560241) {
                i9 = i8;
                str3 = MimeTypes.AUDIO_MPEGH_MHM1;
            } else if (iIntValue == 1634492771) {
                str2 = MimeTypes.AUDIO_ALAC;
            } else if (iIntValue == 1634492791) {
                str2 = MimeTypes.AUDIO_ALAW;
            } else if (iIntValue == 1970037111) {
                str2 = MimeTypes.AUDIO_MLAW;
            } else if (iIntValue == 1332770163) {
                str2 = MimeTypes.AUDIO_OPUS;
            } else if (iIntValue == 1716281667) {
                str2 = MimeTypes.AUDIO_FLAC;
            } else if (iIntValue == 1835823201) {
                str2 = MimeTypes.AUDIO_TRUEHD;
            } else {
                i9 = i8;
                str3 = null;
            }
            str4 = str3;
            listOf = null;
            str5 = null;
            esdsFromParent = null;
            while (position - i2 < i12) {
                parsableByteArray.setPosition(position);
                i10 = parsableByteArray.readInt();
                if (i10 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i13 = i9;
                ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
                i11 = parsableByteArray.readInt();
                if (i11 == 1835557187) {
                    parsableByteArray.setPosition(position + 8);
                    parsableByteArray.skipBytes(1);
                    unsignedByte2 = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (Objects.equals(str4, str8)) {
                        str7 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                    } else {
                        str7 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                    }
                    String str9 = str7;
                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                    bArr3 = new byte[unsignedShort3];
                    parsableByteArray.readBytes(bArr3, 0, unsignedShort3);
                    if (listOf == null) {
                        immutableListOf = ImmutableList.of(bArr3);
                    } else {
                        immutableListOf = ImmutableList.of(bArr3, listOf.get(0));
                    }
                    listOf = immutableListOf;
                    str5 = str9;
                } else {
                    if (i11 == 1835557200) {
                        parsableByteArray.setPosition(position + 8);
                        unsignedByte = parsableByteArray.readUnsignedByte();
                        if (unsignedByte > 0) {
                            bArr2 = new byte[unsignedByte];
                            str6 = str8;
                            parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                            if (listOf == null) {
                                listOf = ImmutableList.of(bArr2);
                            } else {
                                listOf = ImmutableList.of(listOf.get(0), bArr2);
                            }
                        }
                    } else {
                        str6 = str8;
                        if (i11 != 1702061171 || (z && i11 == 2002876005)) {
                            if (i11 == 1702061171) {
                                iFindBoxPosition = position;
                            } else {
                                iFindBoxPosition = findBoxPosition(parsableByteArray, Atom.TYPE_esds, position, i10);
                            }
                            if (iFindBoxPosition != -1) {
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                str4 = esdsFromParent.mimeType;
                                bArr = esdsFromParent.initializationData;
                                if (bArr != null) {
                                    if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                        listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                    } else {
                                        if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                            AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                                            int i14 = audioSpecificConfig.sampleRateHz;
                                            int i15 = audioSpecificConfig.channelCount;
                                            str5 = audioSpecificConfig.codecs;
                                            unsignedFixedPoint1616 = i14;
                                            unsignedShort2 = i15;
                                        }
                                        listOf = ImmutableList.of(bArr);
                                    }
                                }
                            }
                        } else {
                            if (i11 == 1684103987) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i11 == 1684366131) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i11 == 1684103988) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i11 == 1684892784) {
                                if (i7 <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i7, null);
                                }
                                unsignedFixedPoint1616 = i7;
                                unsignedShort2 = i6;
                            } else if (i11 == 1684305011 || i11 == 1969517683) {
                                c = 24931;
                                stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                            } else if (i11 == 1682927731) {
                                int i16 = i10 - 8;
                                byte[] bArr4 = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i16);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(bArrCopyOf, bArr4.length, i16);
                                listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                            } else if (i11 == 1684425825) {
                                byte[] bArr5 = new byte[i10 - 8];
                                bArr5[0] = 102;
                                bArr5[1] = 76;
                                bArr5[i6] = 97;
                                bArr5[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr5, 4, i10 - 12);
                                listOf = ImmutableList.of(bArr5);
                            } else {
                                c = 24931;
                                if (i11 == 1634492771) {
                                    int i17 = i10 - 12;
                                    byte[] bArr6 = new byte[i17];
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr6, 0, i17);
                                    Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                    int iIntValue2 = ((Integer) alacAudioSpecificConfig.first).intValue();
                                    int iIntValue3 = ((Integer) alacAudioSpecificConfig.second).intValue();
                                    listOf = ImmutableList.of(bArr6);
                                    unsignedFixedPoint1616 = iIntValue2;
                                    unsignedShort2 = iIntValue3;
                                }
                            }
                            c = 24931;
                        }
                        position += i10;
                        i12 = i3;
                        i9 = i13;
                        str8 = str6;
                    }
                    position += i10;
                    i12 = i3;
                    i9 = i13;
                    str8 = str6;
                }
                str6 = str8;
                position += i10;
                i12 = i3;
                i9 = i13;
                str8 = str6;
            }
            int i18 = i9;
            if (stsdData.format == null || str4 == null) {
            }
            Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setPcmEncoding(i18).setInitializationData(listOf).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
            if (esdsFromParent != null) {
                language.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
            }
            stsdData.format = language.build();
            return;
        }
        str3 = str2;
        i9 = i8;
        str4 = str3;
        listOf = null;
        str5 = null;
        esdsFromParent = null;
        while (position - i2 < i12) {
            parsableByteArray.setPosition(position);
            i10 = parsableByteArray.readInt();
            if (i10 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i19 = i9;
            ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
            i11 = parsableByteArray.readInt();
            if (i11 == 1835557187) {
                parsableByteArray.setPosition(position + 8);
                parsableByteArray.skipBytes(1);
                unsignedByte2 = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(1);
                if (Objects.equals(str4, str8)) {
                    str7 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                } else {
                    str7 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                }
                String str10 = str7;
                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                bArr3 = new byte[unsignedShort4];
                parsableByteArray.readBytes(bArr3, 0, unsignedShort4);
                if (listOf == null) {
                    immutableListOf = ImmutableList.of(bArr3);
                } else {
                    immutableListOf = ImmutableList.of(bArr3, listOf.get(0));
                }
                listOf = immutableListOf;
                str5 = str10;
            } else {
                if (i11 == 1835557200) {
                    parsableByteArray.setPosition(position + 8);
                    unsignedByte = parsableByteArray.readUnsignedByte();
                    if (unsignedByte > 0) {
                        bArr2 = new byte[unsignedByte];
                        str6 = str8;
                        parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                        if (listOf == null) {
                            listOf = ImmutableList.of(bArr2);
                        } else {
                            listOf = ImmutableList.of(listOf.get(0), bArr2);
                        }
                    }
                } else {
                    str6 = str8;
                    if (i11 != 1702061171) {
                        if (i11 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, Atom.TYPE_esds, position, i10);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str4 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                    listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        AacUtil.Config audioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(bArr);
                                        int i110 = audioSpecificConfig2.sampleRateHz;
                                        int i111 = audioSpecificConfig2.channelCount;
                                        str5 = audioSpecificConfig2.codecs;
                                        unsignedFixedPoint1616 = i110;
                                        unsignedShort2 = i111;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    } else {
                        if (i11 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, Atom.TYPE_esds, position, i10);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str4 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                    listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        AacUtil.Config audioSpecificConfig3 = AacUtil.parseAudioSpecificConfig(bArr);
                                        int i112 = audioSpecificConfig3.sampleRateHz;
                                        int i113 = audioSpecificConfig3.channelCount;
                                        str5 = audioSpecificConfig3.codecs;
                                        unsignedFixedPoint1616 = i112;
                                        unsignedShort2 = i113;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    }
                    position += i10;
                    i12 = i3;
                    i9 = i19;
                    str8 = str6;
                }
                position += i10;
                i12 = i3;
                i9 = i19;
                str8 = str6;
            }
            str6 = str8;
            position += i10;
            i12 = i3;
            i9 = i19;
            str8 = str6;
        }
        int i114 = i9;
        if (stsdData.format == null) {
        }
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        long j = unsignedInt2;
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        if (j <= 0) {
            j = -1;
        }
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, j, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!C.CENC_TYPE_cenc.equals(string) && !C.CENC_TYPE_cbc1.equals(string) && !C.CENC_TYPE_cens.equals(string) && !C.CENC_TYPE_cbcs.equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long unsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                unsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                unsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = unsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
