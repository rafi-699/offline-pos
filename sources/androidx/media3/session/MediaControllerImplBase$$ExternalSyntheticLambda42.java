package androidx.media3.session;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MediaControllerImplBase$$ExternalSyntheticLambda42 implements Runnable {
    public final /* synthetic */ MediaController f$0;

    public /* synthetic */ MediaControllerImplBase$$ExternalSyntheticLambda42(MediaController mediaController) {
        this.f$0 = mediaController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.release();
    }
}
