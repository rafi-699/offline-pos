package org.opencv.android;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: loaded from: classes5.dex */
public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {
    private static final int MAGIC_TEXTURE_ID = 10;
    private static final String TAG = "JavaCameraView";
    private byte[] mBuffer;
    protected Camera mCamera;
    protected CameraBridgeViewBase.RotatedCameraFrame[] mCameraFrame;
    private boolean mCameraFrameReady;
    private int mChainIdx;
    private Mat[] mFrameChain;
    private int mPreviewFormat;
    private boolean mStopThread;
    private SurfaceTexture mSurfaceTexture;
    private Thread mThread;

    public static class JavaCameraSizeAccessor implements CameraBridgeViewBase.ListItemAccessor {
        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getWidth(Object obj) {
            return ((Camera.Size) obj).width;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getHeight(Object obj) {
            return ((Camera.Size) obj).height;
        }
    }

    public JavaCameraView(Context context, int i) {
        super(context, i);
        this.mChainIdx = 0;
        this.mPreviewFormat = 17;
        this.mCameraFrameReady = false;
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChainIdx = 0;
        this.mPreviewFormat = 17;
        this.mCameraFrameReady = false;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0129 A[Catch: all -> 0x0317, DONT_GENERATE, TryCatch #1 {, blocks: (B:5:0x0009, B:8:0x0015, B:10:0x001b, B:11:0x003d, B:17:0x0071, B:14:0x0047, B:46:0x0125, B:48:0x0129, B:50:0x012b, B:54:0x013a, B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd, B:103:0x0315, B:102:0x0312, B:18:0x0074, B:20:0x007e, B:21:0x008b, B:23:0x0091, B:26:0x0099, B:37:0x00c1, B:39:0x00cb, B:40:0x00d3, B:41:0x00f5, B:44:0x00fe, B:27:0x009c, B:29:0x00a0, B:30:0x00ad, B:32:0x00b3, B:35:0x00bc), top: B:110:0x0009, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x012b A[Catch: all -> 0x0317, TryCatch #1 {, blocks: (B:5:0x0009, B:8:0x0015, B:10:0x001b, B:11:0x003d, B:17:0x0071, B:14:0x0047, B:46:0x0125, B:48:0x0129, B:50:0x012b, B:54:0x013a, B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd, B:103:0x0315, B:102:0x0312, B:18:0x0074, B:20:0x007e, B:21:0x008b, B:23:0x0091, B:26:0x0099, B:37:0x00c1, B:39:0x00cb, B:40:0x00d3, B:41:0x00f5, B:44:0x00fe, B:27:0x009c, B:29:0x00a0, B:30:0x00ad, B:32:0x00b3, B:35:0x00bc), top: B:110:0x0009, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0137  */
    /* JADX WARN: Code duplicated, block: B:53:0x0139  */
    /* JADX WARN: Code duplicated, block: B:57:0x0153 A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0166 A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01bd A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x020c A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0215 A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x023d A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x024e A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0266 A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x027f A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0286 A[Catch: Exception -> 0x0311, all -> 0x0317, TryCatch #3 {Exception -> 0x0311, blocks: (B:55:0x0140, B:57:0x0153, B:59:0x0166, B:61:0x0170, B:63:0x017a, B:65:0x0184, B:67:0x018e, B:69:0x0198, B:71:0x01a2, B:73:0x01ac, B:76:0x01b7, B:78:0x01c3, B:80:0x020c, B:81:0x020f, B:83:0x0215, B:85:0x021d, B:86:0x0222, B:88:0x023d, B:90:0x025e, B:92:0x0266, B:94:0x026e, B:96:0x0282, B:98:0x0286, B:99:0x028f, B:95:0x027f, B:89:0x024e, B:77:0x01bd), top: B:113:0x0140, outer: #1 }] */
    protected boolean initializeCamera(int i, int i2) {
        int i3;
        int i4;
        Camera.CameraInfo cameraInfo;
        boolean z;
        int frameRotation;
        Camera.Parameters parameters;
        List<Camera.Size> supportedPreviewSizes;
        List<String> supportedFocusModes;
        Camera.Parameters parameters2;
        Log.d(TAG, "Initialize java camera");
        synchronized (this) {
            this.mCamera = null;
            boolean z2 = false;
            if (this.mCameraIndex == -1) {
                i4 = -1;
                boolean z3 = false;
                for (int i5 = 0; i5 < Camera.getNumberOfCameras(); i5++) {
                    Log.d(TAG, "Trying to open camera with new open(" + Integer.valueOf(i5) + ")");
                    try {
                        this.mCamera = Camera.open(i5);
                        i4 = i5;
                        z3 = true;
                    } catch (RuntimeException e) {
                        Log.e(TAG, "Camera #" + i5 + "failed to open: " + e.getLocalizedMessage());
                    }
                    if (z3) {
                        break;
                    }
                }
                if (this.mCamera == null) {
                    return false;
                }
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i4, cameraInfo);
                if (cameraInfo.facing == 1) {
                    z = true;
                } else {
                    z = false;
                }
                frameRotation = getFrameRotation(z, cameraInfo.orientation);
                try {
                    parameters = this.mCamera.getParameters();
                    Log.d(TAG, "getSupportedPreviewSizes()");
                    supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                    if (supportedPreviewSizes != null) {
                        Size sizeCalculateCameraFrameSize = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i, i2);
                        if (!Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
                            parameters.setPreviewFormat(842094169);
                        } else {
                            parameters.setPreviewFormat(17);
                        }
                        this.mPreviewFormat = parameters.getPreviewFormat();
                        Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize.height));
                        parameters.setPreviewSize((int) sizeCalculateCameraFrameSize.width, (int) sizeCalculateCameraFrameSize.height);
                        if (!Build.MODEL.equals("GT-I9100")) {
                            parameters.setRecordingHint(true);
                        }
                        supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            parameters.setFocusMode("continuous-video");
                        }
                        this.mCamera.setParameters(parameters);
                        parameters2 = this.mCamera.getParameters();
                        int i6 = parameters2.getPreviewSize().width;
                        int i7 = parameters2.getPreviewSize().height;
                        if (frameRotation % RotationOptions.ROTATE_180 == 0) {
                            this.mFrameWidth = parameters2.getPreviewSize().width;
                            this.mFrameHeight = parameters2.getPreviewSize().height;
                        } else {
                            this.mFrameWidth = parameters2.getPreviewSize().height;
                            this.mFrameHeight = parameters2.getPreviewSize().width;
                        }
                        if (getLayoutParams().width != -1 && getLayoutParams().height == -1) {
                            this.mScale = Math.min(i2 / this.mFrameHeight, i / this.mFrameWidth);
                        } else {
                            this.mScale = 0.0f;
                        }
                        if (this.mFpsMeter != null) {
                            this.mFpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                        }
                        byte[] bArr = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8];
                        this.mBuffer = bArr;
                        this.mCamera.addCallbackBuffer(bArr);
                        this.mCamera.setPreviewCallbackWithBuffer(this);
                        Mat[] matArr = new Mat[2];
                        this.mFrameChain = matArr;
                        matArr[0] = new Mat((i7 / 2) + i7, i6, CvType.CV_8UC1);
                        this.mFrameChain[1] = new Mat((i7 / 2) + i7, i6, CvType.CV_8UC1);
                        AllocateCache();
                        CameraBridgeViewBase.RotatedCameraFrame[] rotatedCameraFrameArr = new CameraBridgeViewBase.RotatedCameraFrame[2];
                        this.mCameraFrame = rotatedCameraFrameArr;
                        rotatedCameraFrameArr[0] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[0], i6, i7), frameRotation);
                        this.mCameraFrame[1] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[1], i6, i7), frameRotation);
                        SurfaceTexture surfaceTexture = new SurfaceTexture(10);
                        this.mSurfaceTexture = surfaceTexture;
                        this.mCamera.setPreviewTexture(surfaceTexture);
                        Log.d(TAG, "startPreview");
                        this.mCamera.startPreview();
                        z2 = true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return z2;
            }
            int i8 = this.mCameraIndex;
            if (this.mCameraIndex == 99) {
                Log.i(TAG, "Trying to open back camera");
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                i3 = 0;
                while (i3 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i3, cameraInfo2);
                    if (cameraInfo2.facing == 0) {
                        i8 = i3;
                        break;
                    }
                    i3++;
                }
            } else if (this.mCameraIndex == 98) {
                Log.i(TAG, "Trying to open front camera");
                Camera.CameraInfo cameraInfo3 = new Camera.CameraInfo();
                i3 = 0;
                while (i3 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i3, cameraInfo3);
                    if (cameraInfo3.facing == 1) {
                        i8 = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (i8 == 99) {
                Log.e(TAG, "Back camera not found!");
            } else if (i8 == 98) {
                Log.e(TAG, "Front camera not found!");
            } else {
                Log.d(TAG, "Trying to open camera with new open(" + Integer.valueOf(i8) + ")");
                try {
                    this.mCamera = Camera.open(i8);
                    i4 = i8;
                } catch (RuntimeException e3) {
                    Log.e(TAG, "Camera #" + i8 + "failed to open: " + e3.getLocalizedMessage());
                    i4 = -1;
                }
                if (this.mCamera == null) {
                    return false;
                }
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i4, cameraInfo);
                if (cameraInfo.facing == 1) {
                    z = true;
                } else {
                    z = false;
                }
                frameRotation = getFrameRotation(z, cameraInfo.orientation);
                parameters = this.mCamera.getParameters();
                Log.d(TAG, "getSupportedPreviewSizes()");
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    Size sizeCalculateCameraFrameSize2 = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i, i2);
                    if (!Build.FINGERPRINT.startsWith("generic")) {
                        parameters.setPreviewFormat(842094169);
                    } else {
                        parameters.setPreviewFormat(842094169);
                    }
                    this.mPreviewFormat = parameters.getPreviewFormat();
                    Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize2.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize2.height));
                    parameters.setPreviewSize((int) sizeCalculateCameraFrameSize2.width, (int) sizeCalculateCameraFrameSize2.height);
                    if (!Build.MODEL.equals("GT-I9100")) {
                        parameters.setRecordingHint(true);
                    }
                    supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.mCamera.setParameters(parameters);
                    parameters2 = this.mCamera.getParameters();
                    int i9 = parameters2.getPreviewSize().width;
                    int i10 = parameters2.getPreviewSize().height;
                    if (frameRotation % RotationOptions.ROTATE_180 == 0) {
                        this.mFrameWidth = parameters2.getPreviewSize().width;
                        this.mFrameHeight = parameters2.getPreviewSize().height;
                    } else {
                        this.mFrameWidth = parameters2.getPreviewSize().height;
                        this.mFrameHeight = parameters2.getPreviewSize().width;
                    }
                    if (getLayoutParams().width != -1) {
                        this.mScale = 0.0f;
                    } else {
                        this.mScale = 0.0f;
                    }
                    if (this.mFpsMeter != null) {
                        this.mFpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                    }
                    byte[] bArr2 = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8];
                    this.mBuffer = bArr2;
                    this.mCamera.addCallbackBuffer(bArr2);
                    this.mCamera.setPreviewCallbackWithBuffer(this);
                    Mat[] matArr2 = new Mat[2];
                    this.mFrameChain = matArr2;
                    matArr2[0] = new Mat((i10 / 2) + i10, i9, CvType.CV_8UC1);
                    this.mFrameChain[1] = new Mat((i10 / 2) + i10, i9, CvType.CV_8UC1);
                    AllocateCache();
                    CameraBridgeViewBase.RotatedCameraFrame[] rotatedCameraFrameArr2 = new CameraBridgeViewBase.RotatedCameraFrame[2];
                    this.mCameraFrame = rotatedCameraFrameArr2;
                    rotatedCameraFrameArr2[0] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[0], i9, i10), frameRotation);
                    this.mCameraFrame[1] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[1], i9, i10), frameRotation);
                    SurfaceTexture surfaceTexture2 = new SurfaceTexture(10);
                    this.mSurfaceTexture = surfaceTexture2;
                    this.mCamera.setPreviewTexture(surfaceTexture2);
                    Log.d(TAG, "startPreview");
                    this.mCamera.startPreview();
                    z2 = true;
                }
                return z2;
            }
            i4 = -1;
            if (this.mCamera == null) {
                return false;
            }
            cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i4, cameraInfo);
            if (cameraInfo.facing == 1) {
                z = true;
            } else {
                z = false;
            }
            frameRotation = getFrameRotation(z, cameraInfo.orientation);
            parameters = this.mCamera.getParameters();
            Log.d(TAG, "getSupportedPreviewSizes()");
            supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                Size sizeCalculateCameraFrameSize3 = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i, i2);
                if (!Build.FINGERPRINT.startsWith("generic")) {
                    parameters.setPreviewFormat(842094169);
                } else {
                    parameters.setPreviewFormat(842094169);
                }
                this.mPreviewFormat = parameters.getPreviewFormat();
                Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize3.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize3.height));
                parameters.setPreviewSize((int) sizeCalculateCameraFrameSize3.width, (int) sizeCalculateCameraFrameSize3.height);
                if (!Build.MODEL.equals("GT-I9100")) {
                    parameters.setRecordingHint(true);
                }
                supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null) {
                    parameters.setFocusMode("continuous-video");
                }
                this.mCamera.setParameters(parameters);
                parameters2 = this.mCamera.getParameters();
                int i11 = parameters2.getPreviewSize().width;
                int i12 = parameters2.getPreviewSize().height;
                if (frameRotation % RotationOptions.ROTATE_180 == 0) {
                    this.mFrameWidth = parameters2.getPreviewSize().width;
                    this.mFrameHeight = parameters2.getPreviewSize().height;
                } else {
                    this.mFrameWidth = parameters2.getPreviewSize().height;
                    this.mFrameHeight = parameters2.getPreviewSize().width;
                }
                if (getLayoutParams().width != -1) {
                    this.mScale = 0.0f;
                } else {
                    this.mScale = 0.0f;
                }
                if (this.mFpsMeter != null) {
                    this.mFpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                }
                byte[] bArr3 = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8];
                this.mBuffer = bArr3;
                this.mCamera.addCallbackBuffer(bArr3);
                this.mCamera.setPreviewCallbackWithBuffer(this);
                Mat[] matArr3 = new Mat[2];
                this.mFrameChain = matArr3;
                matArr3[0] = new Mat((i12 / 2) + i12, i11, CvType.CV_8UC1);
                this.mFrameChain[1] = new Mat((i12 / 2) + i12, i11, CvType.CV_8UC1);
                AllocateCache();
                CameraBridgeViewBase.RotatedCameraFrame[] rotatedCameraFrameArr3 = new CameraBridgeViewBase.RotatedCameraFrame[2];
                this.mCameraFrame = rotatedCameraFrameArr3;
                rotatedCameraFrameArr3[0] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[0], i11, i12), frameRotation);
                this.mCameraFrame[1] = new CameraBridgeViewBase.RotatedCameraFrame(new JavaCameraFrame(this.mFrameChain[1], i11, i12), frameRotation);
                SurfaceTexture surfaceTexture3 = new SurfaceTexture(10);
                this.mSurfaceTexture = surfaceTexture3;
                this.mCamera.setPreviewTexture(surfaceTexture3);
                Log.d(TAG, "startPreview");
                this.mCamera.startPreview();
                z2 = true;
            }
            return z2;
            throw th;
        }
    }

    protected void releaseCamera() {
        synchronized (this) {
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.stopPreview();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.release();
            }
            this.mCamera = null;
            Mat[] matArr = this.mFrameChain;
            if (matArr != null) {
                matArr[0].release();
                this.mFrameChain[1].release();
            }
            CameraBridgeViewBase.RotatedCameraFrame[] rotatedCameraFrameArr = this.mCameraFrame;
            if (rotatedCameraFrameArr != null) {
                rotatedCameraFrameArr[0].mFrame.release();
                this.mCameraFrame[0].release();
                this.mCameraFrame[1].mFrame.release();
                this.mCameraFrame[1].release();
            }
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected boolean connectCamera(int i, int i2) {
        Log.d(TAG, "Connecting to camera");
        if (!initializeCamera(i, i2)) {
            return false;
        }
        this.mCameraFrameReady = false;
        Log.d(TAG, "Starting processing thread");
        this.mStopThread = false;
        Thread thread = new Thread(new CameraWorker());
        this.mThread = thread;
        thread.start();
        return true;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected void disconnectCamera() {
        Log.d(TAG, "Disconnecting from camera");
        try {
            try {
                this.mStopThread = true;
                Log.d(TAG, "Notify thread");
                synchronized (this) {
                    notify();
                }
                Log.d(TAG, "Waiting for thread");
                Thread thread = this.mThread;
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mThread = null;
            releaseCamera();
            this.mCameraFrameReady = false;
        } catch (Throwable th) {
            this.mThread = null;
            throw th;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.mFrameChain[this.mChainIdx].put(0, 0, bArr);
            this.mCameraFrameReady = true;
            notify();
        }
        Camera camera2 = this.mCamera;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.mBuffer);
        }
    }

    private class JavaCameraFrame implements CameraBridgeViewBase.CvCameraViewFrame {
        private int mHeight;
        private Mat mRgba = new Mat();
        private int mWidth;
        private Mat mYuvFrameData;

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            return this.mYuvFrameData.submat(0, this.mHeight, 0, this.mWidth);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            if (JavaCameraView.this.mPreviewFormat == 17) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 96, 4);
            } else if (JavaCameraView.this.mPreviewFormat == 842094169) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 100, 4);
            } else {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            }
            return this.mRgba;
        }

        public JavaCameraFrame(Mat mat, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mYuvFrameData = mat;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public void release() {
            this.mRgba.release();
        }
    }

    private class CameraWorker implements Runnable {
        private CameraWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.mCameraFrameReady && !JavaCameraView.this.mStopThread) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z = false;
                    if (JavaCameraView.this.mCameraFrameReady) {
                        JavaCameraView javaCameraView = JavaCameraView.this;
                        javaCameraView.mChainIdx = 1 - javaCameraView.mChainIdx;
                        JavaCameraView.this.mCameraFrameReady = false;
                        z = true;
                    }
                }
                if (!JavaCameraView.this.mStopThread && z && !JavaCameraView.this.mFrameChain[1 - JavaCameraView.this.mChainIdx].empty()) {
                    JavaCameraView javaCameraView2 = JavaCameraView.this;
                    javaCameraView2.deliverAndDrawFrame(javaCameraView2.mCameraFrame[1 - JavaCameraView.this.mChainIdx]);
                }
            } while (!JavaCameraView.this.mStopThread);
            Log.d(JavaCameraView.TAG, "Finish processing thread");
        }
    }
}
