package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class UnitDateFormatter implements DateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int year) {
        return year + "年";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int month) {
        return month + "月";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int day) {
        return day + "日";
    }
}
