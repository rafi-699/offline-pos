package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatimeSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.entity.DatimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleTimeFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DatimeWheelLayout extends BaseWheelLayout {
    private DateWheelLayout dateWheelLayout;
    private DatimeEntity endValue;
    private OnDatimeSelectedListener onDatimeSelectedListener;
    private DatimeEntity startValue;
    private TimeWheelLayout timeWheelLayout;

    public DatimeWheelLayout(Context context) {
        super(context);
    }

    public DatimeWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DatimeWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DatimeWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_datime;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dateWheelLayout.provideWheelViews());
        arrayList.addAll(this.timeWheelLayout.provideWheelViews());
        return arrayList;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.dateWheelLayout = (DateWheelLayout) findViewById(R.id.wheel_picker_date_wheel);
        this.timeWheelLayout = (TimeWheelLayout) findViewById(R.id.wheel_picker_time_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.DatimeWheelLayout);
        setDateMode(typedArrayObtainStyledAttributes.getInt(R.styleable.DatimeWheelLayout_wheel_dateMode, 0));
        setTimeMode(typedArrayObtainStyledAttributes.getInt(R.styleable.DatimeWheelLayout_wheel_timeMode, 0));
        setDateLabel(typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_yearLabel), typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_monthLabel), typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_dayLabel));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_hourLabel);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_minuteLabel);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_secondLabel);
        typedArrayObtainStyledAttributes.recycle();
        setTimeLabel(string, string2, string3);
        setDateFormatter(new SimpleDateFormatter());
        setTimeFormatter(new SimpleTimeFormatter(this.timeWheelLayout));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0 && this.startValue == null && this.endValue == null) {
            setRange(DatimeEntity.now(), DatimeEntity.yearOnFuture(30), DatimeEntity.now());
        }
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView view, int position) {
        this.dateWheelLayout.onWheelSelected(view, position);
        this.timeWheelLayout.onWheelSelected(view, position);
        if (this.onDatimeSelectedListener == null) {
            return;
        }
        this.timeWheelLayout.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DatimeWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DatimeWheelLayout.this.onDatimeSelectedListener.onDatimeSelected(DatimeWheelLayout.this.dateWheelLayout.getSelectedYear(), DatimeWheelLayout.this.dateWheelLayout.getSelectedMonth(), DatimeWheelLayout.this.dateWheelLayout.getSelectedDay(), DatimeWheelLayout.this.timeWheelLayout.getSelectedHour(), DatimeWheelLayout.this.timeWheelLayout.getSelectedMinute(), DatimeWheelLayout.this.timeWheelLayout.getSelectedSecond());
            }
        });
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrolled(WheelView view, int offset) {
        this.dateWheelLayout.onWheelScrolled(view, offset);
        this.timeWheelLayout.onWheelScrolled(view, offset);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView view, int state) {
        this.dateWheelLayout.onWheelScrollStateChanged(view, state);
        this.timeWheelLayout.onWheelScrollStateChanged(view, state);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelLoopFinished(WheelView view) {
        this.dateWheelLayout.onWheelLoopFinished(view);
        this.timeWheelLayout.onWheelLoopFinished(view);
    }

    public void setDateMode(int dateMode) {
        this.dateWheelLayout.setDateMode(dateMode);
    }

    public void setTimeMode(int timeMode) {
        this.timeWheelLayout.setTimeMode(timeMode);
    }

    public void setRange(DatimeEntity startValue, DatimeEntity endValue) {
        setRange(startValue, endValue, null);
    }

    public void setRange(DatimeEntity startValue, DatimeEntity endValue, DatimeEntity defaultValue) {
        if (startValue == null) {
            startValue = DatimeEntity.now();
        }
        if (endValue == null) {
            endValue = DatimeEntity.yearOnFuture(10);
        }
        if (defaultValue == null) {
            defaultValue = startValue;
        }
        this.dateWheelLayout.setRange(startValue.getDate(), endValue.getDate(), defaultValue.getDate());
        this.timeWheelLayout.setRange(null, null, defaultValue.getTime());
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public void setDefaultValue(DatimeEntity defaultValue) {
        if (defaultValue == null) {
            defaultValue = DatimeEntity.now();
        }
        this.dateWheelLayout.setDefaultValue(defaultValue.getDate());
        this.timeWheelLayout.setDefaultValue(defaultValue.getTime());
    }

    public void setDateFormatter(DateFormatter dateFormatter) {
        this.dateWheelLayout.setDateFormatter(dateFormatter);
    }

    public void setTimeFormatter(TimeFormatter timeFormatter) {
        this.timeWheelLayout.setTimeFormatter(timeFormatter);
    }

    public void setDateLabel(CharSequence year, CharSequence month, CharSequence day) {
        this.dateWheelLayout.setDateLabel(year, month, day);
    }

    public void setTimeLabel(CharSequence hour, CharSequence minute, CharSequence second) {
        this.timeWheelLayout.setTimeLabel(hour, minute, second);
    }

    public void setOnDatimeSelectedListener(OnDatimeSelectedListener onDatimeSelectedListener) {
        this.onDatimeSelectedListener = onDatimeSelectedListener;
    }

    public void setResetWhenLinkage(boolean dateResetWhenLinkage, boolean timeResetWhenLinkage) {
        this.dateWheelLayout.setResetWhenLinkage(dateResetWhenLinkage);
        this.timeWheelLayout.setResetWhenLinkage(timeResetWhenLinkage);
    }

    public final DatimeEntity getStartValue() {
        return this.startValue;
    }

    public final DatimeEntity getEndValue() {
        return this.endValue;
    }

    public final DateWheelLayout getDateWheelLayout() {
        return this.dateWheelLayout;
    }

    public final TimeWheelLayout getTimeWheelLayout() {
        return this.timeWheelLayout;
    }

    public final NumberWheelView getYearWheelView() {
        return this.dateWheelLayout.getYearWheelView();
    }

    public final NumberWheelView getMonthWheelView() {
        return this.dateWheelLayout.getMonthWheelView();
    }

    public final NumberWheelView getDayWheelView() {
        return this.dateWheelLayout.getDayWheelView();
    }

    public final NumberWheelView getHourWheelView() {
        return this.timeWheelLayout.getHourWheelView();
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.timeWheelLayout.getMinuteWheelView();
    }

    public final NumberWheelView getSecondWheelView() {
        return this.timeWheelLayout.getSecondWheelView();
    }

    public final WheelView getMeridiemWheelView() {
        return this.timeWheelLayout.getMeridiemWheelView();
    }

    public final TextView getYearLabelView() {
        return this.dateWheelLayout.getYearLabelView();
    }

    public final TextView getMonthLabelView() {
        return this.dateWheelLayout.getMonthLabelView();
    }

    public final TextView getDayLabelView() {
        return this.dateWheelLayout.getDayLabelView();
    }

    public final TextView getHourLabelView() {
        return this.timeWheelLayout.getHourLabelView();
    }

    public final TextView getMinuteLabelView() {
        return this.timeWheelLayout.getMinuteLabelView();
    }

    public final TextView getSecondLabelView() {
        return this.timeWheelLayout.getSecondLabelView();
    }

    public final int getSelectedYear() {
        return this.dateWheelLayout.getSelectedYear();
    }

    public final int getSelectedMonth() {
        return this.dateWheelLayout.getSelectedMonth();
    }

    public final int getSelectedDay() {
        return this.dateWheelLayout.getSelectedDay();
    }

    public final int getSelectedHour() {
        return this.timeWheelLayout.getSelectedHour();
    }

    public final int getSelectedMinute() {
        return this.timeWheelLayout.getSelectedMinute();
    }

    public final int getSelectedSecond() {
        return this.timeWheelLayout.getSelectedSecond();
    }
}
