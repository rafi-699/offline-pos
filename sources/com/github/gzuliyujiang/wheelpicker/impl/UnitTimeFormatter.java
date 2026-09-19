package com.github.gzuliyujiang.wheelpicker.impl;

import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class UnitTimeFormatter implements TimeFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatHour(int hour) {
        return hour + "点";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatMinute(int minute) {
        return minute + "分";
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatSecond(int second) {
        return second + "秒";
    }
}
