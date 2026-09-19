package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.BirthdayFormatter;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class BirthdayPicker extends DatePicker {
    private static final int MAX_AGE = 100;
    private DateEntity defaultValue;
    private boolean initialized;

    public BirthdayPicker(Activity activity) {
        super(activity);
        this.initialized = false;
    }

    public BirthdayPicker(Activity activity, int themeResId) {
        super(activity, themeResId);
        this.initialized = false;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected void initData() {
        super.initData();
        this.initialized = true;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        this.wheelLayout.setRange(DateEntity.target(i - 100, 1, 1), DateEntity.target(i, calendar.get(2) + 1, calendar.get(5)), this.defaultValue);
        this.wheelLayout.setDateMode(0);
        this.wheelLayout.setDateFormatter(new BirthdayFormatter());
    }

    public void setDefaultValue(int year, int month, int day) {
        this.defaultValue = DateEntity.target(year, month, day);
        if (this.initialized) {
            this.wheelLayout.setDefaultValue(this.defaultValue);
        }
    }
}
