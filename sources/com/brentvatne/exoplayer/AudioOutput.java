package com.brentvatne.exoplayer;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AudioOutput.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/brentvatne/exoplayer/AudioOutput;", "", "outputName", "", "streamType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getStreamType", "()I", "SPEAKER", "EARPIECE", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AudioOutput {
    SPEAKER("speaker", 3),
    EARPIECE("earpiece", 0);

    private final String outputName;
    private final int streamType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final AudioOutput get(String str) {
        return INSTANCE.get(str);
    }

    public static EnumEntries<AudioOutput> getEntries() {
        return $ENTRIES;
    }

    AudioOutput(String str, int i) {
        this.outputName = str;
        this.streamType = i;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    /* JADX INFO: compiled from: AudioOutput.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/exoplayer/AudioOutput$Companion;", "", "<init>", "()V", "get", "Lcom/brentvatne/exoplayer/AudioOutput;", "name", "", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AudioOutput get(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (AudioOutput audioOutput : AudioOutput.values()) {
                if (StringsKt.equals(audioOutput.outputName, name, true)) {
                    return audioOutput;
                }
            }
            return AudioOutput.SPEAKER;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return getClass().getSimpleName() + "(" + this.outputName + ", " + this.streamType + ")";
    }
}
