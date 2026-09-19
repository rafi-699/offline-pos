package org.opencv.android;

import android.hardware.Camera;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CameraRenderer extends CameraGLRendererBase {
    public static final String LOGTAG = "CameraRenderer";
    private Camera mCamera;
    private boolean mPreviewStarted;

    CameraRenderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.mPreviewStarted = false;
    }

    @Override // org.opencv.android.CameraGLRendererBase
    protected synchronized void closeCamera() {
        Log.i(LOGTAG, "closeCamera");
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mPreviewStarted = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    protected synchronized void openCamera(int i) {
        try {
            Log.i(LOGTAG, "openCamera");
            closeCamera();
            int i2 = 0;
            if (i == -1) {
                Log.d(LOGTAG, "Trying to open camera with old open()");
                try {
                    this.mCamera = Camera.open();
                } catch (Exception e) {
                    Log.e(LOGTAG, "Camera is not available (in use or does not exist): " + e.getLocalizedMessage());
                }
                if (this.mCamera == null) {
                    boolean z = false;
                    while (i2 < Camera.getNumberOfCameras()) {
                        Log.d(LOGTAG, "Trying to open camera with new open(" + i2 + ")");
                        try {
                            this.mCamera = Camera.open(i2);
                            z = true;
                        } catch (RuntimeException e2) {
                            Log.e(LOGTAG, "Camera #" + i2 + "failed to open: " + e2.getLocalizedMessage());
                        }
                        if (z) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } else {
                int i3 = this.mCameraIndex;
                if (this.mCameraIndex == 99) {
                    Log.i(LOGTAG, "Trying to open BACK camera");
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    while (i2 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i2, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            i3 = i2;
                            break;
                        }
                        i2++;
                    }
                } else if (this.mCameraIndex == 98) {
                    Log.i(LOGTAG, "Trying to open FRONT camera");
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    while (i2 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i2, cameraInfo2);
                        if (cameraInfo2.facing == 1) {
                            i3 = i2;
                            break;
                        }
                        i2++;
                    }
                }
                if (i3 == 99) {
                    Log.e(LOGTAG, "Back camera not found!");
                } else if (i3 == 98) {
                    Log.e(LOGTAG, "Front camera not found!");
                } else {
                    Log.d(LOGTAG, "Trying to open camera with new open(" + i3 + ")");
                    try {
                        this.mCamera = Camera.open(i3);
                    } catch (RuntimeException e3) {
                        Log.e(LOGTAG, "Camera #" + i3 + "failed to open: " + e3.getLocalizedMessage());
                    }
                }
            }
            Camera camera = this.mCamera;
            if (camera == null) {
                Log.e(LOGTAG, "Error: can't open camera");
                return;
            }
            Camera.Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(parameters);
            try {
                this.mCamera.setPreviewTexture(this.mSTexture);
            } catch (IOException e4) {
                Log.e(LOGTAG, "setPreviewTexture() failed: " + e4.getMessage());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void setCameraPreviewSize(int i, int i2) {
        Log.i(LOGTAG, "setCameraPreviewSize: " + i + "x" + i2);
        if (this.mCamera == null) {
            Log.e(LOGTAG, "Camera isn't initialized!");
            return;
        }
        if (this.mMaxCameraWidth > 0 && this.mMaxCameraWidth < i) {
            i = this.mMaxCameraWidth;
        }
        if (this.mMaxCameraHeight > 0 && this.mMaxCameraHeight < i2) {
            i2 = this.mMaxCameraHeight;
        }
        Camera.Parameters parameters = this.mCamera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes.size() > 0) {
            float f = i / i2;
            int i3 = 0;
            int i4 = 0;
            for (Camera.Size size : supportedPreviewSizes) {
                int i5 = size.width;
                int i6 = size.height;
                Log.d(LOGTAG, "checking camera preview size: " + i5 + "x" + i6);
                if (i5 <= i && i6 <= i2 && i5 >= i3 && i6 >= i4 && Math.abs(f - (i5 / i6)) < 0.2d) {
                    i4 = i6;
                    i3 = i5;
                }
            }
            if (i3 <= 0 || i4 <= 0) {
                i3 = supportedPreviewSizes.get(0).width;
                i4 = supportedPreviewSizes.get(0).height;
                Log.e(LOGTAG, "Error: best size was not selected, using " + i3 + " x " + i4);
            } else {
                Log.i(LOGTAG, "Selected best size: " + i3 + " x " + i4);
            }
            if (this.mPreviewStarted) {
                this.mCamera.stopPreview();
                this.mPreviewStarted = false;
            }
            this.mCameraWidth = i3;
            this.mCameraHeight = i4;
            parameters.setPreviewSize(i3, i4);
        }
        parameters.set("orientation", "landscape");
        this.mCamera.setParameters(parameters);
        this.mCamera.startPreview();
        this.mPreviewStarted = true;
    }
}
