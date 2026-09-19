package com.brentvatne.common.api;

import androidx.webkit.Profile;
import com.brentvatne.common.toolbox.DebugLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BufferingStrategy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/brentvatne/common/api/BufferingStrategy;", "", "<init>", "()V", "BufferingStrategyEnum", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BufferingStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BufferingStrategy";

    /* JADX INFO: compiled from: BufferingStrategy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/brentvatne/common/api/BufferingStrategy$BufferingStrategyEnum;", "", "<init>", "(Ljava/lang/String;I)V", Profile.DEFAULT_PROFILE_NAME, "DisableBuffering", "DependingOnMemory", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum BufferingStrategyEnum {
        Default,
        DisableBuffering,
        DependingOnMemory;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<BufferingStrategyEnum> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: BufferingStrategy.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/brentvatne/common/api/BufferingStrategy$Companion;", "", "<init>", "()V", "TAG", "", "parse", "Lcom/brentvatne/common/api/BufferingStrategy$BufferingStrategyEnum;", "src", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BufferingStrategyEnum parse(String src) {
            if (src == null) {
                return BufferingStrategyEnum.Default;
            }
            try {
                return BufferingStrategyEnum.valueOf(src);
            } catch (Exception unused) {
                DebugLog.e(BufferingStrategy.TAG, "cannot parse buffering strategy " + src);
                return BufferingStrategyEnum.Default;
            }
        }
    }
}
