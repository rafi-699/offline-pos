package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleWheelFormatter implements WheelFormatter {
    @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
    public String formatItem(Object item) {
        return item.toString();
    }
}
