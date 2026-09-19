package org.opencv.video;

import org.opencv.dnn.Net;

/* JADX INFO: loaded from: classes5.dex */
public class TrackerGOTURN extends Tracker {
    private static native long create_0(long j);

    private static native long create_1();

    private static native long create_2(long j);

    private static native void delete(long j);

    protected TrackerGOTURN(long j) {
        super(j);
    }

    public static TrackerGOTURN __fromPtr__(long j) {
        return new TrackerGOTURN(j);
    }

    public static TrackerGOTURN create(TrackerGOTURN_Params trackerGOTURN_Params) {
        return __fromPtr__(create_0(trackerGOTURN_Params.getNativeObjAddr()));
    }

    public static TrackerGOTURN create() {
        return __fromPtr__(create_1());
    }

    public static TrackerGOTURN create(Net net) {
        return __fromPtr__(create_2(net.getNativeObjAddr()));
    }

    @Override // org.opencv.video.Tracker
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
