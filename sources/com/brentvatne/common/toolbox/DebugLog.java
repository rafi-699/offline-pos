package com.brentvatne.common.toolbox;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugLog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0003J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\b\u0010\u0018\u001a\u00020\u000bH\u0007J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/brentvatne/common/toolbox/DebugLog;", "", "<init>", "()V", FirebaseAnalytics.Param.LEVEL, "", "displayThread", "", "TAG_PREFIX", "", "setConfig", "", "_level", "_displayThread", "getTag", "tag", "getMsg", "msg", "v", "d", "i", "w", "e", "wtf", "printCallStack", "checkUIThread", "checkNotUIThread", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugLog {
    private static final String TAG_PREFIX = "RNV";
    public static final DebugLog INSTANCE = new DebugLog();
    private static int level = 5;
    private static boolean displayThread = true;

    private DebugLog() {
    }

    @JvmStatic
    public static final void setConfig(int _level, boolean _displayThread) {
        level = _level;
        displayThread = _displayThread;
    }

    @JvmStatic
    private static final String getTag(String tag) {
        return TAG_PREFIX + tag;
    }

    @JvmStatic
    private static final String getMsg(String msg) {
        if (!displayThread) {
            return msg;
        }
        return "[" + Thread.currentThread().getName() + "] " + msg;
    }

    @JvmStatic
    public static final void v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 2) {
            Log.v(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 3) {
            Log.d(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 4) {
            Log.i(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 5) {
            Log.w(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 6) {
            Log.e(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void wtf(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.wtf(getTag(tag), "--------------->" + getMsg(msg));
        printCallStack();
    }

    @JvmStatic
    public static final void printCallStack() {
        if (level <= 2) {
            new Exception().printStackTrace();
        }
    }

    @JvmStatic
    public static final void checkUIThread(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(Thread.currentThread().getName(), "main")) {
            return;
        }
        wtf(tag, "------------------------>" + getMsg(msg));
    }

    @JvmStatic
    public static final void checkNotUIThread(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(Thread.currentThread().getName(), "main")) {
            wtf(tag, "------------------------>" + getMsg(msg));
        }
    }
}
