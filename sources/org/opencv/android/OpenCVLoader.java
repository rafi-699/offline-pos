package org.opencv.android;

/* JADX INFO: loaded from: classes5.dex */
public class OpenCVLoader {
    public static final String OPENCV_VERSION = "4.12.0";

    @Deprecated
    public static boolean initDebug() {
        return StaticHelper.initOpenCV(false);
    }

    public static boolean initLocal() {
        return StaticHelper.initOpenCV(false);
    }

    @Deprecated
    public static boolean initDebug(boolean z) {
        return StaticHelper.initOpenCV(z);
    }
}
