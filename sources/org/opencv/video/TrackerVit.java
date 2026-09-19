package org.opencv.video;

import org.opencv.core.Scalar;
import org.opencv.dnn.Net;

/* JADX INFO: loaded from: classes5.dex */
public class TrackerVit extends Tracker {
    private static native long create_0(long j);

    private static native long create_1();

    private static native long create_2(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, float f);

    private static native long create_3(long j, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native long create_4(long j, double d, double d2, double d3, double d4);

    private static native long create_5(long j);

    private static native void delete(long j);

    private static native float getTrackingScore_0(long j);

    protected TrackerVit(long j) {
        super(j);
    }

    public static TrackerVit __fromPtr__(long j) {
        return new TrackerVit(j);
    }

    public static TrackerVit create(TrackerVit_Params trackerVit_Params) {
        return __fromPtr__(create_0(trackerVit_Params.getNativeObjAddr()));
    }

    public static TrackerVit create() {
        return __fromPtr__(create_1());
    }

    public static TrackerVit create(Net net, Scalar scalar, Scalar scalar2, float f) {
        return __fromPtr__(create_2(net.getNativeObjAddr(), scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3], f));
    }

    public static TrackerVit create(Net net, Scalar scalar, Scalar scalar2) {
        return __fromPtr__(create_3(net.getNativeObjAddr(), scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3], scalar2.val[0], scalar2.val[1], scalar2.val[2], scalar2.val[3]));
    }

    public static TrackerVit create(Net net, Scalar scalar) {
        return __fromPtr__(create_4(net.getNativeObjAddr(), scalar.val[0], scalar.val[1], scalar.val[2], scalar.val[3]));
    }

    public static TrackerVit create(Net net) {
        return __fromPtr__(create_5(net.getNativeObjAddr()));
    }

    public float getTrackingScore() {
        return getTrackingScore_0(this.nativeObj);
    }

    @Override // org.opencv.video.Tracker
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
