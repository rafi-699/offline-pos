package com.google.zxing.datamatrix.encoder;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, PsExtractor.VIDEO_STREAM_MASK, 92, 254}, new int[]{28, 24, 185, 166, 223, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 116, 255, Videoio.CAP_PROP_OPENNI2_SYNC, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, Imgproc.COLOR_RGBA2YUV_YVYU, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, TsExtractor.TS_PACKET_SIZE, 75, 66, 61, 241, 213, 109, 129, 94, 254, JfifUtil.MARKER_APP1, 48, 90, TsExtractor.TS_PACKET_SIZE}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, TsExtractor.TS_PACKET_SIZE, 160, Imgproc.COLOR_RGBA2YUV_YVYU, 145, 253, 79, 108, 82, 27, 174, 186, TsExtractor.TS_STREAM_TYPE_AC4}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, TsExtractor.TS_STREAM_TYPE_AC4, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, Imgproc.COLOR_YUV2RGBA_YVYU, 17, 138, Videoio.CAP_PROP_OPENNI2_SYNC, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, JfifUtil.MARKER_SOS, 130, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, JfifUtil.MARKER_APP1, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, Imgproc.COLOR_RGBA2YUV_YVYU, 247, 105, Imgproc.COLOR_YUV2BGRA_YVYU, 2, 245, Imgproc.COLOR_RGBA2YUV_YV12, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, Imgproc.COLOR_YUV2RGBA_YVYU, 21, 1, 253, 57, 54, 101, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 202, 69, 50, Imgproc.COLOR_BGR2YUV_YVYU, 177, 226, 5, 9, 5}, new int[]{245, Imgproc.COLOR_BGR2YUV_YV12, TsExtractor.TS_STREAM_TYPE_AC4, 223, 96, 32, Imgproc.COLOR_YUV2RGB_YVYU, 22, 238, Imgproc.COLOR_RGBA2YUV_YV12, 238, 231, 205, TsExtractor.TS_PACKET_SIZE, 237, 87, 191, 106, 16, 147, Imgproc.COLOR_YUV2BGR_YVYU, 23, 37, 90, 170, 205, Imgproc.COLOR_RGB2YUV_YV12, 88, 120, 100, 66, 138, 186, PsExtractor.VIDEO_STREAM_MASK, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, JfifUtil.MARKER_APP1, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, JfifUtil.MARKER_RST0, 100, 29, 175, 170, 230, 192, JfifUtil.MARKER_RST7, 235, Imgproc.COLOR_BGR2YUV_YVYU, 159, 36, 223, 38, 200, Imgproc.COLOR_BGR2YUV_YV12, 54, 228, 146, JfifUtil.MARKER_SOS, 234, Imgproc.COLOR_YUV2RGB_YVYU, 203, 29, 232, 144, 238, 22, Imgproc.COLOR_BGR2YUV_YVYU, 201, Imgproc.COLOR_YUV2RGB_YVYU, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, Imgproc.COLOR_YUV2BGR_YVYU, 202, TsExtractor.TS_PACKET_SIZE, 201, PsExtractor.PRIVATE_STREAM_1, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, JfifUtil.MARKER_SOS, 51, 63, 87, 10, 40, 130, TsExtractor.TS_PACKET_SIZE, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, Imgproc.COLOR_RGB2YUV_YVYU, 159, 56, 89, 33, 147, 244, Imgproc.COLOR_BGRA2YUV_YVYU, 36, 73, 127, 213, 136, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, RotationOptions.ROTATE_180, 234, 197, 158, 177, 68, Imgproc.COLOR_YUV2BGRA_YVYU, 93, 213, 15, 160, 227, 236, 66, 139, Imgproc.COLOR_RGBA2YUV_YVYU, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, TsExtractor.TS_STREAM_TYPE_AC4, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, Imgproc.COLOR_RGBA2YUV_YVYU, Imgproc.COLOR_BGR2YUV_YV12, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, strCreateECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            }
            if (iArr[i4] == i) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i)));
        }
        int[] iArr2 = FACTORS[i4];
        char[] cArr = new char[i];
        for (int i5 = 0; i5 < i; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            int i7 = i - 1;
            int iCharAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (iCharAt != 0 && (i3 = iArr2[i7]) != 0) {
                    char c = cArr[i7 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i7] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i3]) % 255] ^ c);
                } else {
                    cArr[i7] = cArr[i7 - 1];
                }
                i7--;
            }
            if (iCharAt != 0 && (i2 = iArr2[0]) != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i2]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i];
        for (int i8 = 0; i8 < i; i8++) {
            cArr2[i8] = cArr[(i - i8) - 1];
        }
        return String.valueOf(cArr2);
    }
}
