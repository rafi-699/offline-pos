package com.github.gzuliyujiang.dialog;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogLog {
    private static final String TAG = "AndroidPicker";
    private static boolean enable = false;

    private DialogLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object log) {
        if (enable) {
            Log.d(TAG, log.toString());
        }
    }
}
