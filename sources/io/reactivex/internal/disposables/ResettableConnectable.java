package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
