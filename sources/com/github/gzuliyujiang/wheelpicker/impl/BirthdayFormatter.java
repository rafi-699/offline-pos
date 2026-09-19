package com.github.gzuliyujiang.wheelpicker.impl;

/* JADX INFO: loaded from: classes3.dex */
public class BirthdayFormatter extends SimpleDateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int year) {
        return super.formatYear(year) + "年";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int month) {
        return super.formatMonth(month) + "月";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter, com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int day) {
        return super.formatDay(day) + "日";
    }
}
