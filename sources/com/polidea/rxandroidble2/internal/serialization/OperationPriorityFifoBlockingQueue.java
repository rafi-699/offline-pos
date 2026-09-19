package com.polidea.rxandroidble2.internal.serialization;

import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
class OperationPriorityFifoBlockingQueue {
    private final PriorityBlockingQueue<FIFORunnableEntry> q = new PriorityBlockingQueue<>();

    OperationPriorityFifoBlockingQueue() {
    }

    public void add(FIFORunnableEntry fIFORunnableEntry) {
        this.q.add(fIFORunnableEntry);
    }

    public FIFORunnableEntry<?> take() throws InterruptedException {
        return this.q.take();
    }

    public FIFORunnableEntry<?> takeNow() {
        return this.q.poll();
    }

    public boolean isEmpty() {
        return this.q.isEmpty();
    }

    public boolean remove(FIFORunnableEntry fIFORunnableEntry) {
        for (FIFORunnableEntry fIFORunnableEntry2 : this.q) {
            if (fIFORunnableEntry2 == fIFORunnableEntry) {
                return this.q.remove(fIFORunnableEntry2);
            }
        }
        return false;
    }
}
