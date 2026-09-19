package com.github.gzuliyujiang.wheelpicker.impl;

import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleDateFormatter implements DateFormatter {
    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatYear(int year) {
        if (year < 1000) {
            year += 1000;
        }
        return "" + year;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatMonth(int month) {
        return (month < 10 ? new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO) : new StringBuilder("")).append(month).toString();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.DateFormatter
    public String formatDay(int day) {
        return (day < 10 ? new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO) : new StringBuilder("")).append(day).toString();
    }
}
