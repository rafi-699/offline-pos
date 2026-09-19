package com.bleplx.adapter.utils;

import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DisposableMap {
    private final Map<String, Disposable> subscriptions = new HashMap();

    public synchronized void replaceSubscription(String str, Disposable disposable) {
        Disposable disposablePut = this.subscriptions.put(str, disposable);
        if (disposablePut != null && !disposablePut.isDisposed()) {
            disposablePut.dispose();
        }
    }

    public synchronized boolean removeSubscription(String str) {
        Disposable disposableRemove = this.subscriptions.remove(str);
        if (disposableRemove == null) {
            return false;
        }
        if (!disposableRemove.isDisposed()) {
            disposableRemove.dispose();
        }
        return true;
    }

    public synchronized void removeAllSubscriptions() {
        Iterator<Map.Entry<String, Disposable>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            Disposable value = it.next().getValue();
            it.remove();
            if (!value.isDisposed()) {
                value.dispose();
            }
        }
    }
}
