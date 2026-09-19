package org.opencv.android;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

/* JADX INFO: loaded from: classes5.dex */
public class NativeCameraView extends CameraBridgeViewBase {
    public static final String TAG = "NativeCameraView";
    protected VideoCapture mCamera;
    protected CameraBridgeViewBase.RotatedCameraFrame mFrame;
    private boolean mStopThread;
    private Thread mThread;

    public NativeCameraView(Context context, int i) {
        super(context, i);
    }

    public NativeCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected boolean connectCamera(int i, int i2) {
        if (!initializeCamera(i, i2)) {
            return false;
        }
        Thread thread = new Thread(new CameraWorker());
        this.mThread = thread;
        thread.start();
        return true;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected void disconnectCamera() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                try {
                    this.mStopThread = true;
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.mThread = null;
                this.mStopThread = false;
            } catch (Throwable th) {
                this.mThread = null;
                this.mStopThread = false;
                throw th;
            }
        }
        releaseCamera();
    }

    public static class OpenCvSizeAccessor implements CameraBridgeViewBase.ListItemAccessor {
        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getWidth(Object obj) {
            return (int) ((Size) obj).width;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getHeight(Object obj) {
            return (int) ((Size) obj).height;
        }
    }

    private boolean initializeCamera(int i, int i2) {
        int i3;
        synchronized (this) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i4 = this.mCameraIndex;
            if (this.mCameraIndex == -1) {
                Log.d(TAG, "Try to open default camera");
                i4 = 0;
            } else if (this.mCameraIndex == 99) {
                Log.i(TAG, "Trying to open back camera");
                i3 = 0;
                while (i3 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        i4 = i3;
                        break;
                    }
                    i3++;
                }
            } else if (this.mCameraIndex == 98) {
                Log.i(TAG, "Trying to open front camera");
                i3 = 0;
                while (i3 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        i4 = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (i4 == 99) {
                Log.e(TAG, "Back camera not found!");
                return false;
            }
            if (i4 == 98) {
                Log.e(TAG, "Front camera not found!");
                return false;
            }
            MatOfInt matOfInt = new MatOfInt(3, i, 4, i2);
            Log.d(TAG, "Try to open camera with index " + i4);
            VideoCapture videoCapture = new VideoCapture(i4, 1000, matOfInt);
            this.mCamera = videoCapture;
            if (!videoCapture.isOpened()) {
                return false;
            }
            if (this.mCameraIndex != 99 && this.mCameraIndex != 98) {
                Camera.getCameraInfo(i4, cameraInfo);
            }
            int frameRotation = getFrameRotation(cameraInfo.facing == 1, cameraInfo.orientation);
            this.mFrame = new CameraBridgeViewBase.RotatedCameraFrame(new NativeCameraFrame(this.mCamera), frameRotation);
            if (frameRotation % RotationOptions.ROTATE_180 == 0) {
                this.mFrameWidth = (int) this.mCamera.get(3);
                this.mFrameHeight = (int) this.mCamera.get(4);
            } else {
                this.mFrameWidth = (int) this.mCamera.get(4);
                this.mFrameHeight = (int) this.mCamera.get(3);
            }
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.mScale = Math.min(i2 / this.mFrameHeight, i / this.mFrameWidth);
            } else {
                this.mScale = 0.0f;
            }
            if (this.mFpsMeter != null) {
                this.mFpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
            }
            AllocateCache();
            Log.i(TAG, "Selected camera frame size = (" + this.mFrameWidth + ", " + this.mFrameHeight + ")");
            return true;
        }
    }

    private void releaseCamera() {
        synchronized (this) {
            CameraBridgeViewBase.RotatedCameraFrame rotatedCameraFrame = this.mFrame;
            if (rotatedCameraFrame != null) {
                rotatedCameraFrame.mFrame.release();
                this.mFrame.release();
            }
            VideoCapture videoCapture = this.mCamera;
            if (videoCapture != null) {
                videoCapture.release();
            }
        }
    }

    private static class NativeCameraFrame implements CameraBridgeViewBase.CvCameraViewFrame {
        private VideoCapture mCapture;
        private Mat mGray = new Mat();
        private Mat mRgba = new Mat();

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            this.mCapture.set(6, VideoWriter.fourcc('R', 'G', 'B', '4'));
            this.mCapture.retrieve(this.mRgba);
            Log.d(NativeCameraView.TAG, "Retrieved frame with size " + this.mRgba.cols() + "x" + this.mRgba.rows() + " and channels: " + this.mRgba.channels());
            return this.mRgba;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            this.mCapture.set(6, VideoWriter.fourcc('G', 'R', 'E', 'Y'));
            this.mCapture.retrieve(this.mGray);
            Log.d(NativeCameraView.TAG, "Retrieved frame with size " + this.mGray.cols() + "x" + this.mGray.rows() + " and channels: " + this.mGray.channels());
            return this.mGray;
        }

        public NativeCameraFrame(VideoCapture videoCapture) {
            this.mCapture = videoCapture;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public void release() {
            Mat mat = this.mGray;
            if (mat != null) {
                mat.release();
            }
            Mat mat2 = this.mRgba;
            if (mat2 != null) {
                mat2.release();
            }
        }
    }

    private class CameraWorker implements Runnable {
        private CameraWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (NativeCameraView.this.mCamera.grab()) {
                NativeCameraView nativeCameraView = NativeCameraView.this;
                nativeCameraView.deliverAndDrawFrame(nativeCameraView.mFrame);
                if (NativeCameraView.this.mStopThread) {
                    return;
                }
            }
            Log.e(NativeCameraView.TAG, "Camera frame grab failed");
        }
    }
}
