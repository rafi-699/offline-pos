package org.opencv.dnn;

import org.opencv.core.Mat;

/* JADX INFO: loaded from: classes5.dex */
public class SegmentationModel extends Model {
    private static native long SegmentationModel_0(String str, String str2);

    private static native long SegmentationModel_1(String str);

    private static native long SegmentationModel_2(long j);

    private static native void delete(long j);

    private static native void segment_0(long j, long j2, long j3);

    protected SegmentationModel(long j) {
        super(j);
    }

    public static SegmentationModel __fromPtr__(long j) {
        return new SegmentationModel(j);
    }

    public SegmentationModel(String str, String str2) {
        super(SegmentationModel_0(str, str2));
    }

    public SegmentationModel(String str) {
        super(SegmentationModel_1(str));
    }

    public SegmentationModel(Net net) {
        super(SegmentationModel_2(net.getNativeObjAddr()));
    }

    public void segment(Mat mat, Mat mat2) {
        segment_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    @Override // org.opencv.dnn.Model
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
