package org.opencv.video;

import org.opencv.dnn.Net;

/* JADX INFO: loaded from: classes5.dex */
public class TrackerNano extends Tracker {
    private static native long create_0(long j);

    private static native long create_1();

    private static native long create_2(long j, long j2);

    private static native void delete(long j);

    private static native float getTrackingScore_0(long j);

    protected TrackerNano(long j) {
        super(j);
    }

    public static TrackerNano __fromPtr__(long j) {
        return new TrackerNano(j);
    }

    public static TrackerNano create(TrackerNano_Params trackerNano_Params) {
        return __fromPtr__(create_0(trackerNano_Params.getNativeObjAddr()));
    }

    public static TrackerNano create() {
        return __fromPtr__(create_1());
    }

    public static TrackerNano create(Net net, Net net2) {
        return __fromPtr__(create_2(net.getNativeObjAddr(), net2.getNativeObjAddr()));
    }

    public float getTrackingScore() {
        return getTrackingScore_0(this.nativeObj);
    }

    @Override // org.opencv.video.Tracker
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
