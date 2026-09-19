package org.opencv.objdetect;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;

/* JADX INFO: loaded from: classes5.dex */
public class BarcodeDetector extends GraphicalCodeDetector {
    private static native long BarcodeDetector_0();

    private static native long BarcodeDetector_1(String str, String str2);

    private static native boolean decodeWithType_0(long j, long j2, long j3, List<String> list, List<String> list2);

    private static native void delete(long j);

    private static native boolean detectAndDecodeWithType_0(long j, long j2, List<String> list, List<String> list2, long j3);

    private static native boolean detectAndDecodeWithType_1(long j, long j2, List<String> list, List<String> list2);

    private static native void getDetectorScales_0(long j, long j2);

    private static native double getDownsamplingThreshold_0(long j);

    private static native double getGradientThreshold_0(long j);

    private static native long setDetectorScales_0(long j, long j2);

    private static native long setDownsamplingThreshold_0(long j, double d);

    private static native long setGradientThreshold_0(long j, double d);

    protected BarcodeDetector(long j) {
        super(j);
    }

    public static BarcodeDetector __fromPtr__(long j) {
        return new BarcodeDetector(j);
    }

    public BarcodeDetector() {
        super(BarcodeDetector_0());
    }

    public BarcodeDetector(String str, String str2) {
        super(BarcodeDetector_1(str, str2));
    }

    public boolean decodeWithType(Mat mat, Mat mat2, List<String> list, List<String> list2) {
        return decodeWithType_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, list, list2);
    }

    public boolean detectAndDecodeWithType(Mat mat, List<String> list, List<String> list2, Mat mat2) {
        return detectAndDecodeWithType_0(this.nativeObj, mat.nativeObj, list, list2, mat2.nativeObj);
    }

    public boolean detectAndDecodeWithType(Mat mat, List<String> list, List<String> list2) {
        return detectAndDecodeWithType_1(this.nativeObj, mat.nativeObj, list, list2);
    }

    public double getDownsamplingThreshold() {
        return getDownsamplingThreshold_0(this.nativeObj);
    }

    public BarcodeDetector setDownsamplingThreshold(double d) {
        return new BarcodeDetector(setDownsamplingThreshold_0(this.nativeObj, d));
    }

    public void getDetectorScales(MatOfFloat matOfFloat) {
        getDetectorScales_0(this.nativeObj, matOfFloat.nativeObj);
    }

    public BarcodeDetector setDetectorScales(MatOfFloat matOfFloat) {
        return new BarcodeDetector(setDetectorScales_0(this.nativeObj, matOfFloat.nativeObj));
    }

    public double getGradientThreshold() {
        return getGradientThreshold_0(this.nativeObj);
    }

    public BarcodeDetector setGradientThreshold(double d) {
        return new BarcodeDetector(setGradientThreshold_0(this.nativeObj, d));
    }

    @Override // org.opencv.objdetect.GraphicalCodeDetector
    protected void finalize() throws Throwable {
        delete(this.nativeObj);
    }
}
