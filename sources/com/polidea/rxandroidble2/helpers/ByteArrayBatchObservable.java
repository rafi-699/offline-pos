package com.polidea.rxandroidble2.helpers;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public class ByteArrayBatchObservable extends Flowable<byte[]> {
    final ByteBuffer byteBuffer;
    final int maxBatchSize;

    public ByteArrayBatchObservable(byte[] bArr, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxBatchSize must be > 0 but found: " + i);
        }
        this.byteBuffer = ByteBuffer.wrap(bArr);
        this.maxBatchSize = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super byte[]> subscriber) {
        Flowable.generate(new Consumer<Emitter<byte[]>>() { // from class: com.polidea.rxandroidble2.helpers.ByteArrayBatchObservable.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Emitter<byte[]> emitter) {
                int iMin = Math.min(ByteArrayBatchObservable.this.byteBuffer.remaining(), ByteArrayBatchObservable.this.maxBatchSize);
                if (iMin == 0) {
                    emitter.onComplete();
                    return;
                }
                byte[] bArr = new byte[iMin];
                ByteArrayBatchObservable.this.byteBuffer.get(bArr);
                emitter.onNext(bArr);
            }
        }).subscribe(subscriber);
    }
}
