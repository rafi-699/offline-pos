package com.bleplx.utils;

import com.facebook.react.bridge.Promise;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class SafePromise {
    private AtomicBoolean isFinished = new AtomicBoolean();
    private Promise promise;

    public SafePromise(Promise promise) {
        this.promise = promise;
    }

    public void resolve(@Nullable Object obj) {
        if (this.isFinished.compareAndSet(false, true)) {
            this.promise.resolve(obj);
        }
    }

    public void reject(@Nullable String str, @Nullable String str2) {
        if (this.isFinished.compareAndSet(false, true)) {
            if (str == null) {
                str = ErrorDefaults.CODE;
            }
            if (str2 == null) {
                str2 = "";
            }
            this.promise.reject(str, str2);
        }
    }

    public void reject(@Nullable String str, Throwable th) {
        if (this.isFinished.compareAndSet(false, true)) {
            if (str == null) {
                str = ErrorDefaults.CODE;
            }
            this.promise.reject(str, th);
        }
    }

    public void reject(@Nullable String str, @Nullable String str2, Throwable th) {
        if (this.isFinished.compareAndSet(false, true)) {
            if (str == null) {
                str = ErrorDefaults.CODE;
            }
            if (str2 == null) {
                str2 = "";
            }
            this.promise.reject(str, str2, th);
        }
    }

    @Deprecated
    public void reject(@Nullable String str) {
        if (this.isFinished.compareAndSet(false, true)) {
            if (str == null) {
                str = "";
            }
            this.promise.reject(ErrorDefaults.CODE, str);
        }
    }

    public void reject(Throwable th) {
        if (this.isFinished.compareAndSet(false, true)) {
            this.promise.reject(th);
        }
    }
}
