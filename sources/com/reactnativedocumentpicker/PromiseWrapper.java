package com.reactnativedocumentpicker;

import android.util.Log;
import com.facebook.react.bridge.Promise;

/* JADX INFO: loaded from: classes4.dex */
public class PromiseWrapper {
    public static final String ASYNC_OP_IN_PROGRESS = "ASYNC_OP_IN_PROGRESS";
    public static final String E_DOCUMENT_PICKER_CANCELED = "OPERATION_CANCELED";
    private final String MODULE_NAME;
    private String nameOfCallInProgress;
    private Promise promise;

    public PromiseWrapper(String str) {
        this.MODULE_NAME = str;
    }

    public void setPromiseRejectingPrevious(Promise promise, String str) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            rejectPreviousPromiseBecauseNewOneIsInProgress(promise2, str);
        }
        this.promise = promise;
        this.nameOfCallInProgress = str;
    }

    public boolean trySetPromiseRejectingIncoming(Promise promise, String str) {
        if (this.promise != null) {
            rejectNewPromiseBecauseOldOneIsInProgress(promise, str);
            return false;
        }
        this.promise = promise;
        this.nameOfCallInProgress = str;
        return true;
    }

    public void resolve(Object obj) {
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.MODULE_NAME, "cannot resolve promise because it's null");
        } else {
            resetMembers();
            promise.resolve(obj);
        }
    }

    public void reject(String str, Exception exc) {
        String message;
        if (exc.getLocalizedMessage() != null) {
            message = exc.getLocalizedMessage();
        } else {
            message = exc.getMessage() != null ? exc.getMessage() : "unknown error";
        }
        reject(str, message, exc);
    }

    public void reject(Exception exc) {
        String message;
        if (exc.getLocalizedMessage() != null) {
            message = exc.getLocalizedMessage();
        } else {
            message = exc.getMessage() != null ? exc.getMessage() : "unknown error";
        }
        reject(this.nameOfCallInProgress, message, exc);
    }

    public void rejectAsUserCancelledOperation() {
        reject(E_DOCUMENT_PICKER_CANCELED, "user canceled the document picker");
    }

    public void reject(String str, String str2) {
        reject(str, str2, null);
    }

    public void reject(String str, String str2, Exception exc) {
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.MODULE_NAME, "cannot reject promise because it's null");
        } else {
            resetMembers();
            promise.reject(str, str2, exc);
        }
    }

    public String getNameOfCallInProgress() {
        return this.nameOfCallInProgress;
    }

    private void resetMembers() {
        this.nameOfCallInProgress = null;
        this.promise = null;
    }

    private void rejectPreviousPromiseBecauseNewOneIsInProgress(Promise promise, String str) {
        promise.reject("ASYNC_OP_IN_PROGRESS", "Warning: previous promise did not settle and was overwritten. You've called \"" + str + "\" while \"" + getNameOfCallInProgress() + "\" was already in progress and has not completed yet.");
    }

    private void rejectNewPromiseBecauseOldOneIsInProgress(Promise promise, String str) {
        promise.reject("ASYNC_OP_IN_PROGRESS", "Warning: previous promise did not settle and you attempted to overwrite it. You've called \"" + str + "\" while \"" + getNameOfCallInProgress() + "\" was already in progress and has not completed yet.");
    }
}
