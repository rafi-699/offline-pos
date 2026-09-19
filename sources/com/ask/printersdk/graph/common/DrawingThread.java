package com.ask.printersdk.graph.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.ask.printersdk.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DrawingThread extends Thread {
    private Context context;
    private GraphManger graphManger;
    private SurfaceHolder surfaceHolder;
    private volatile boolean isRunning = true;
    private volatile boolean shouldPause = false;
    private long targetFrameTime = 11;

    public DrawingThread(Context context, SurfaceHolder surfaceHolder, GraphManger graphManger) {
        this.context = context;
        this.surfaceHolder = surfaceHolder;
        this.graphManger = graphManger;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.isRunning) {
            if (this.shouldPause) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                draw();
                long jCurrentTimeMillis2 = this.targetFrameTime - (System.currentTimeMillis() - jCurrentTimeMillis);
                if (jCurrentTimeMillis2 > 0) {
                    try {
                        Thread.sleep(jCurrentTimeMillis2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void draw() {
        String str;
        StringBuilder sb;
        if (this.surfaceHolder.getSurface().isValid()) {
            try {
                try {
                    Canvas canvasLockCanvas = this.surfaceHolder.lockCanvas();
                    if (canvasLockCanvas == null) {
                        if (canvasLockCanvas == null || !this.surfaceHolder.getSurface().isValid()) {
                            return;
                        }
                        try {
                            this.surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                            return;
                        } catch (IllegalArgumentException e) {
                            LogUtil.e("DrawingThread", "Canvas unlock failed: " + e.getMessage());
                            return;
                        }
                    }
                    synchronized (this.surfaceHolder) {
                        try {
                            this.graphManger.drawAllGraph(this.context, canvasLockCanvas);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (canvasLockCanvas == null || !this.surfaceHolder.getSurface().isValid()) {
                        return;
                    }
                    try {
                        this.surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        str = "DrawingThread";
                        sb = new StringBuilder("Canvas unlock failed: ");
                        LogUtil.e(str, sb.append(e.getMessage()).toString());
                    }
                } catch (Exception e3) {
                    LogUtil.e("drawAllGraph", e3.toString());
                    if (0 == 0 || !this.surfaceHolder.getSurface().isValid()) {
                        return;
                    }
                    try {
                        this.surfaceHolder.unlockCanvasAndPost(null);
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        str = "DrawingThread";
                        sb = new StringBuilder("Canvas unlock failed: ");
                        LogUtil.e(str, sb.append(e.getMessage()).toString());
                    }
                }
            } catch (Throwable th2) {
                if (0 != 0 && this.surfaceHolder.getSurface().isValid()) {
                    try {
                        this.surfaceHolder.unlockCanvasAndPost(null);
                    } catch (IllegalArgumentException e5) {
                        LogUtil.e("DrawingThread", "Canvas unlock failed: " + e5.getMessage());
                    }
                }
                throw th2;
            }
        }
    }

    public void stopDrawing() {
        this.isRunning = false;
        interrupt();
    }

    public void pauseDrawing() {
        this.shouldPause = true;
    }

    public void resumeDrawing() {
        this.shouldPause = false;
    }
}
