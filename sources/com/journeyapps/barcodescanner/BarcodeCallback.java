package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface BarcodeCallback {
    void barcodeResult(BarcodeResult barcodeResult);

    default void possibleResultPoints(List<ResultPoint> list) {
    }
}
