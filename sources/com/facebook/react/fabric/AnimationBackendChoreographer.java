package com.facebook.react.fabric;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationBackendChoreographer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/react/fabric/AnimationBackendChoreographer;", "", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "frameCallback", "Lcom/facebook/react/fabric/AnimationFrameCallback;", "getFrameCallback", "()Lcom/facebook/react/fabric/AnimationFrameCallback;", "setFrameCallback", "(Lcom/facebook/react/fabric/AnimationFrameCallback;)V", "lastFrameTimeMs", "", "reactChoreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "choreographerCallback", "Lcom/facebook/react/uimanager/GuardedFrameCallback;", "callbackPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "paused", "resume", "", "pause", "scheduleCallback", "executeFrameCallback", "frameTimeNanos", "", "calculateTimestamp", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnimationBackendChoreographer {
    private final AtomicBoolean callbackPosted;
    private final GuardedFrameCallback choreographerCallback;
    private AnimationFrameCallback frameCallback;
    private double lastFrameTimeMs;
    private final AtomicBoolean paused;
    private final ReactChoreographer reactChoreographer;

    private final double calculateTimestamp(long frameTimeNanos) {
        return frameTimeNanos / 1000000.0d;
    }

    public AnimationBackendChoreographer(final ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactChoreographer = ReactChoreographer.INSTANCE.getInstance();
        this.choreographerCallback = new GuardedFrameCallback(reactApplicationContext, this) { // from class: com.facebook.react.fabric.AnimationBackendChoreographer$choreographerCallback$1
            final /* synthetic */ AnimationBackendChoreographer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(reactApplicationContext);
                this.this$0 = this;
            }

            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            protected void doFrameGuarded(long frameTimeNanos) {
                this.this$0.executeFrameCallback(frameTimeNanos);
            }
        };
        this.callbackPosted = new AtomicBoolean();
        this.paused = new AtomicBoolean(true);
    }

    public final AnimationFrameCallback getFrameCallback() {
        return this.frameCallback;
    }

    public final void setFrameCallback(AnimationFrameCallback animationFrameCallback) {
        this.frameCallback = animationFrameCallback;
    }

    public final void resume() {
        if (this.paused.getAndSet(false)) {
            scheduleCallback();
        }
    }

    public final void pause() {
        synchronized (this.paused) {
            if (!this.paused.getAndSet(true) && this.callbackPosted.getAndSet(false)) {
                this.reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.choreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void scheduleCallback() {
        synchronized (this.paused) {
            if (!this.paused.get() && !this.callbackPosted.getAndSet(true)) {
                this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.choreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeFrameCallback(long frameTimeNanos) {
        AnimationFrameCallback animationFrameCallback;
        this.callbackPosted.set(false);
        double dCalculateTimestamp = calculateTimestamp(frameTimeNanos);
        if (dCalculateTimestamp > this.lastFrameTimeMs && (animationFrameCallback = this.frameCallback) != null) {
            animationFrameCallback.onAnimationFrame(dCalculateTimestamp);
        }
        this.lastFrameTimeMs = dCalculateTimestamp;
        scheduleCallback();
    }
}
