package com.reactnativegooglesignin.modern;

import android.util.Log;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromiseWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0012\u0010\u000e\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reactnativegooglesignin/modern/PromiseWrapper;", "", "moduleName", "", "<init>", "(Ljava/lang/String;)V", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "nameOfCallInProgress", "setPromiseWithInProgressCheck", "", "fromCallsite", "resolve", "value", "reject", "message", "code", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getNameOfCallInProgress", "resetMembers", "rejectPreviousPromiseBecauseNewOneIsInProgress", "requestedOperation", "Companion", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromiseWrapper {
    public static final String ASYNC_OP_IN_PROGRESS = "ASYNC_OP_IN_PROGRESS";
    private final String moduleName;
    private String nameOfCallInProgress;
    private Promise promise;

    public PromiseWrapper(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.moduleName = moduleName;
    }

    public final void setPromiseWithInProgressCheck(Promise promise, String fromCallsite) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(fromCallsite, "fromCallsite");
        Promise promise2 = this.promise;
        if (promise2 != null) {
            rejectPreviousPromiseBecauseNewOneIsInProgress(promise2, fromCallsite);
        }
        this.nameOfCallInProgress = fromCallsite;
        this.promise = promise;
    }

    public final void resolve(Object value) {
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.moduleName, "cannot resolve promise because it's null");
        } else {
            resetMembers();
            promise.resolve(value);
        }
    }

    public final void reject(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = this.nameOfCallInProgress;
        if (str == null) {
            str = this.moduleName;
        }
        reject(str, message);
    }

    public final void reject(String code, String message) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.moduleName, "cannot reject promise because it's null");
        } else {
            resetMembers();
            promise.reject(code, message);
        }
    }

    public final void reject(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Promise promise = this.promise;
        String str = this.nameOfCallInProgress;
        if (promise == null || str == null) {
            Log.e(this.moduleName, "cannot reject promise because it's null");
            return;
        }
        ErrorDto errorDto = new ErrorDto(e, str);
        resetMembers();
        promise.reject(errorDto.getCode(), errorDto.getMessage(), e);
    }

    public final String getNameOfCallInProgress() {
        return this.nameOfCallInProgress;
    }

    private final void resetMembers() {
        this.nameOfCallInProgress = null;
        this.promise = null;
    }

    private final void rejectPreviousPromiseBecauseNewOneIsInProgress(Promise promise, String requestedOperation) {
        promise.reject("ASYNC_OP_IN_PROGRESS", "Warning: previous promise did not settle and was overwritten. You've called \"" + requestedOperation + "\" while \"" + getNameOfCallInProgress() + "\" was already in progress and has not completed yet.");
    }
}
