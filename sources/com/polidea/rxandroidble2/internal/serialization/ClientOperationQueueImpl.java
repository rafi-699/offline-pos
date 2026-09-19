package com.polidea.rxandroidble2.internal.serialization;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public class ClientOperationQueueImpl implements ClientOperationQueue {
    final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();

    @Inject
    public ClientOperationQueueImpl(@Named(ClientComponent.NamedSchedulers.BLUETOOTH_INTERACTION) final Scheduler scheduler) {
        new Thread(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.1
            /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        FIFORunnableEntry<?> fIFORunnableEntryTake = ClientOperationQueueImpl.this.queue.take();
                        Operation<?> operation = fIFORunnableEntryTake.operation;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        LoggerUtil.logOperationRunning(operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        fIFORunnableEntryTake.run(queueSemaphore, scheduler);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, jCurrentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        RxBleLog.e(e, "Error while processing client operation queue", new Object[0]);
                    }
                }
            }
        }).start();
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue
    public <T> Observable<T> queue(final Operation<T> operation) {
        return Observable.create(new ObservableOnSubscribe<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<T> observableEmitter) {
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation, observableEmitter);
                observableEmitter.setDisposable(Disposables.fromAction(new Action() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2.1
                    @Override // io.reactivex.functions.Action
                    public void run() {
                        if (ClientOperationQueueImpl.this.queue.remove(fIFORunnableEntry)) {
                            LoggerUtil.logOperationRemoved(operation);
                        }
                    }
                }));
                LoggerUtil.logOperationQueued(operation);
                ClientOperationQueueImpl.this.queue.add(fIFORunnableEntry);
            }
        });
    }
}
