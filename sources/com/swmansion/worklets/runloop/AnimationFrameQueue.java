package com.swmansion.worklets.runloop;

import android.os.SystemClock;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationFrameQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0017J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\rJ\b\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/worklets/runloop/AnimationFrameQueue;", "", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mFirstUptime", "", "mSlowAnimationsEnabled", "", "lastFrameTimeMs", "", "mAnimationsDragFactor", "", "mReactChoreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "mChoreographerCallback", "Lcom/facebook/react/uimanager/GuardedFrameCallback;", "mCallbackPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPaused", "mFrameCallbacks", "", "Lcom/swmansion/worklets/runloop/AnimationFrameCallback;", "resume", "", "pause", "requestAnimationFrame", "animationFrameCallback", "enableSlowAnimations", "slowAnimationsEnabled", "animationsDragFactor", "scheduleQueueExecution", "executeQueue", "frameTimeNanos", "pullCallbacks", "", "calculateTimestamp", "react-native-worklets_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnimationFrameQueue {
    private double lastFrameTimeMs;
    private int mAnimationsDragFactor;
    private final AtomicBoolean mCallbackPosted;
    private final GuardedFrameCallback mChoreographerCallback;
    private long mFirstUptime;
    private final List<AnimationFrameCallback> mFrameCallbacks;
    private final AtomicBoolean mPaused;
    private final ReactChoreographer mReactChoreographer;
    private boolean mSlowAnimationsEnabled;

    public AnimationFrameQueue(final ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.mFirstUptime = SystemClock.uptimeMillis();
        this.mAnimationsDragFactor = 1;
        this.mReactChoreographer = ReactChoreographer.INSTANCE.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactApplicationContext, this) { // from class: com.swmansion.worklets.runloop.AnimationFrameQueue$mChoreographerCallback$1
            final /* synthetic */ AnimationFrameQueue this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(reactApplicationContext);
                this.this$0 = this;
            }

            @Override // com.facebook.react.uimanager.GuardedFrameCallback
            protected void doFrameGuarded(long frameTimeNanos) {
                this.this$0.executeQueue(frameTimeNanos);
            }
        };
        this.mCallbackPosted = new AtomicBoolean();
        this.mPaused = new AtomicBoolean();
        this.mFrameCallbacks = new ArrayList();
    }

    public final void resume() {
        if (this.mPaused.getAndSet(false)) {
            scheduleQueueExecution();
        }
    }

    public final void pause() {
        synchronized (this.mPaused) {
            if (!this.mPaused.getAndSet(true) && this.mCallbackPosted.getAndSet(false)) {
                this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void requestAnimationFrame(AnimationFrameCallback animationFrameCallback) {
        Intrinsics.checkNotNullParameter(animationFrameCallback, "animationFrameCallback");
        synchronized (this.mFrameCallbacks) {
            this.mFrameCallbacks.add(animationFrameCallback);
        }
        scheduleQueueExecution();
    }

    public final void enableSlowAnimations(boolean slowAnimationsEnabled, int animationsDragFactor) {
        this.mSlowAnimationsEnabled = slowAnimationsEnabled;
        this.mAnimationsDragFactor = animationsDragFactor;
        if (slowAnimationsEnabled) {
            this.mFirstUptime = SystemClock.uptimeMillis();
        }
    }

    private final void scheduleQueueExecution() {
        synchronized (this.mPaused) {
            if (!this.mPaused.get() && !this.mCallbackPosted.getAndSet(true)) {
                this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeQueue(long frameTimeNanos) {
        double dCalculateTimestamp = calculateTimestamp(frameTimeNanos);
        if (dCalculateTimestamp <= this.lastFrameTimeMs) {
            this.mCallbackPosted.set(false);
            scheduleQueueExecution();
            return;
        }
        List<AnimationFrameCallback> listPullCallbacks = pullCallbacks();
        this.mCallbackPosted.set(false);
        this.lastFrameTimeMs = dCalculateTimestamp;
        Iterator<AnimationFrameCallback> it = listPullCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onAnimationFrame(dCalculateTimestamp);
        }
    }

    private final List<AnimationFrameCallback> pullCallbacks() {
        List<AnimationFrameCallback> list;
        synchronized (this.mFrameCallbacks) {
            list = CollectionsKt.toList(this.mFrameCallbacks);
            this.mFrameCallbacks.clear();
        }
        return list;
    }

    private final double calculateTimestamp(long frameTimeNanos) {
        double d = frameTimeNanos / 1000000.0d;
        if (!this.mSlowAnimationsEnabled) {
            return d;
        }
        long j = this.mFirstUptime;
        return j + ((d - j) / ((double) this.mAnimationsDragFactor));
    }
}
