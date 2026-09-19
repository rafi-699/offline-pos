package com.brentvatne.receiver;

import kotlin.Metadata;

/* JADX INFO: compiled from: BecomingNoisyListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/brentvatne/receiver/BecomingNoisyListener;", "", "onAudioBecomingNoisy", "", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BecomingNoisyListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void onAudioBecomingNoisy();

    /* JADX INFO: compiled from: BecomingNoisyListener.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/receiver/BecomingNoisyListener$Companion;", "", "<init>", "()V", "NO_OP", "Lcom/brentvatne/receiver/BecomingNoisyListener;", "getNO_OP", "()Lcom/brentvatne/receiver/BecomingNoisyListener;", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final BecomingNoisyListener NO_OP = new BecomingNoisyListener() { // from class: com.brentvatne.receiver.BecomingNoisyListener$Companion$NO_OP$1
            @Override // com.brentvatne.receiver.BecomingNoisyListener
            public void onAudioBecomingNoisy() {
            }
        };

        private Companion() {
        }

        public final BecomingNoisyListener getNO_OP() {
            return NO_OP;
        }
    }
}
