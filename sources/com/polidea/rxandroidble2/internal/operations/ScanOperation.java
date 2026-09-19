package com.polidea.rxandroidble2.internal.operations;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ScanOperation<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends QueueOperation<SCAN_RESULT_TYPE> {
    final RxBleAdapterWrapper rxBleAdapterWrapper;

    abstract SCAN_CALLBACK_TYPE createScanCallback(ObservableEmitter<SCAN_RESULT_TYPE> observableEmitter);

    abstract boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);

    abstract void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);

    ScanOperation(RxBleAdapterWrapper rxBleAdapterWrapper) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    protected final void protectedRun(ObservableEmitter<SCAN_RESULT_TYPE> observableEmitter, QueueReleaseInterface queueReleaseInterface) {
        final SCAN_CALLBACK_TYPE scan_callback_typeCreateScanCallback = createScanCallback(observableEmitter);
        try {
            observableEmitter.setCancellable(new Cancellable() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperation.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.functions.Cancellable
                public void cancel() {
                    RxBleLog.i("Scan operation is requested to stop.", new Object[0]);
                    ScanOperation scanOperation = ScanOperation.this;
                    scanOperation.stopScan(scanOperation.rxBleAdapterWrapper, scan_callback_typeCreateScanCallback);
                }
            });
            RxBleLog.i("Scan operation is requested to start.", new Object[0]);
            if (!startScan(this.rxBleAdapterWrapper, scan_callback_typeCreateScanCallback)) {
                observableEmitter.tryOnError(new BleScanException(0));
            }
            queueReleaseInterface.release();
        } catch (Throwable th) {
            try {
                RxBleLog.w(th, "Error while calling the start scan function", new Object[0]);
                observableEmitter.tryOnError(new BleScanException(0, th));
            } finally {
                queueReleaseInterface.release();
            }
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    protected BleException provideException(DeadObjectException deadObjectException) {
        return new BleScanException(1, deadObjectException);
    }
}
