package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.exceptions.BleException;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectionOperationQueue extends ClientOperationQueue {
    void terminate(BleException bleException);
}
