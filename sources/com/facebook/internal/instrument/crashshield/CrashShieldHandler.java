package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.react.uimanager.ViewProps;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrashShieldHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0007J\u001a\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0001H\u0007J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", "", "()V", "crashingObjects", "", "kotlin.jvm.PlatformType", "", "debugCrashScheduled", "", ViewProps.ENABLED, "isDebug", "isDebug$annotations", "()Z", "setDebug", "(Z)V", "disable", "", "enable", "handleThrowable", "e", "", "o", "isObjectCrashing", "methodFinished", "reset", "resetCrashingObjects", "scheduleCrashInDebug", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean debugCrashScheduled;
    private static boolean enabled;
    private static boolean isDebug;

    @JvmStatic
    public static /* synthetic */ void isDebug$annotations() {
    }

    @JvmStatic
    public static final void methodFinished(Object o) {
    }

    private CrashShieldHandler() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    @JvmStatic
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void handleThrowable(Throwable e, Object o) {
        Intrinsics.checkNotNullParameter(o, "o");
        if (enabled) {
            crashingObjects.add(o);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(e);
                InstrumentData.Builder.build(e, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(e);
        }
    }

    @JvmStatic
    public static final boolean isObjectCrashing(Object o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return crashingObjects.contains(o);
    }

    @JvmStatic
    public static final void reset() {
        resetCrashingObjects();
        debugCrashScheduled = false;
        isDebug = false;
    }

    @JvmStatic
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    public static final boolean isDebug() {
        return isDebug;
    }

    public static final void setDebug(boolean z) {
        isDebug = z;
    }

    @JvmStatic
    public static final void scheduleCrashInDebug(Throwable e) {
        if (!isDebug || debugCrashScheduled) {
            return;
        }
        debugCrashScheduled = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1
            final /* synthetic */ Throwable $e;

            AnonymousClass1() {
                th = e;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    throw new RuntimeException(th);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.facebook.internal.instrument.crashshield.CrashShieldHandler$scheduleCrashInDebug$1 */
    /* JADX INFO: compiled from: CrashShieldHandler.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/facebook/internal/instrument/crashshield/CrashShieldHandler$scheduleCrashInDebug$1", "Ljava/lang/Runnable;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Throwable $e;

        AnonymousClass1() {
            th = e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                throw new RuntimeException(th);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
