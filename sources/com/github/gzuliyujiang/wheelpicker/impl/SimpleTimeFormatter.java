package com.github.gzuliyujiang.wheelpicker.impl;

import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleTimeFormatter implements TimeFormatter {
    private final TimeWheelLayout wheelLayout;

    public SimpleTimeFormatter(TimeWheelLayout wheelLayout) {
        this.wheelLayout = wheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatHour(int hour) {
        if (this.wheelLayout.isHour12Mode()) {
            if (hour == 0) {
                hour = 24;
            }
            if (hour > 12) {
                hour -= 12;
            }
        }
        return (hour < 10 ? new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO) : new StringBuilder("")).append(hour).toString();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatMinute(int minute) {
        return (minute < 10 ? new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO) : new StringBuilder("")).append(minute).toString();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter
    public String formatSecond(int second) {
        return (second < 10 ? new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO) : new StringBuilder("")).append(second).toString();
    }
}
