package org.opencv.video;

/* JADX INFO: loaded from: classes5.dex */
public class TrackerMIL extends Tracker {
    private static native long create_0(long j);

    private static native long create_1();

    private static native void delete(long j);

    protected TrackerMIL(long j) {
        super(j);
    }

    public static TrackerMIL __fromPtr__(long j) {
        return new TrackerMIL(j);
    }

    public static TrackerMIL create(TrackerMIL_Params trackerMIL_Params) {
        return __fromPtr__(create_0(trackerMIL_Params.getNativeObjAddr()));
    }

    public static TrackerMIL create() {
        return __fromPtr__(create_1());
    }

    @Override // org.opencv.video.Tracker
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
