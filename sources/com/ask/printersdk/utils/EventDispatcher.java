package com.ask.printersdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class EventDispatcher extends HandlerThread {
    private static final String TAG = "EventDispatcher";
    private Handler handler;
    private Handler mainHandler;

    static class Holder {
        static final EventDispatcher INSTANCE = new EventDispatcher();

        Holder() {
        }
    }

    private EventDispatcher() {
        super(TAG);
        start();
        this.handler = new Handler(getLooper());
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static EventDispatcher getInstance() {
        return Holder.INSTANCE;
    }

    public void postRunnable(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void postRunnable(Runnable runnable, long j) {
        this.handler.postDelayed(runnable, j);
    }

    public void removeRunnable(Runnable runnable) {
        this.handler.removeCallbacks(runnable);
    }

    public void postMainRunnable(Runnable runnable) {
        this.mainHandler.post(runnable);
    }

    public void postMainRunnable(Runnable runnable, int i) {
        this.mainHandler.postDelayed(runnable, i);
    }

    public void removeMainRunnable(Runnable runnable) {
        this.mainHandler.removeCallbacks(runnable);
    }
}
