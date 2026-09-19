package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeMeridiemSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.entity.TimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleTimeFormatter;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TimeWheelLayout extends BaseWheelLayout {
    private TimeEntity defaultValue;
    private TimeEntity endValue;
    private TextView hourLabelView;
    private int hourStep;
    private NumberWheelView hourWheelView;
    private boolean isAnteMeridiem;
    private WheelView meridiemWheelView;
    private TextView minuteLabelView;
    private int minuteStep;
    private NumberWheelView minuteWheelView;
    private OnTimeMeridiemSelectedListener onTimeMeridiemSelectedListener;
    private OnTimeSelectedListener onTimeSelectedListener;
    private boolean resetWhenLinkage;
    private TextView secondLabelView;
    private int secondStep;
    private NumberWheelView secondWheelView;
    private Integer selectedHour;
    private Integer selectedMinute;
    private Integer selectedSecond;
    private TimeEntity startValue;
    private int timeMode;

    public TimeWheelLayout(Context context) {
        super(context);
        this.hourStep = 1;
        this.minuteStep = 1;
        this.secondStep = 1;
        this.resetWhenLinkage = true;
    }

    public TimeWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.hourStep = 1;
        this.minuteStep = 1;
        this.secondStep = 1;
        this.resetWhenLinkage = true;
    }

    public TimeWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.hourStep = 1;
        this.minuteStep = 1;
        this.secondStep = 1;
        this.resetWhenLinkage = true;
    }

    public TimeWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.hourStep = 1;
        this.minuteStep = 1;
        this.secondStep = 1;
        this.resetWhenLinkage = true;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_time;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.hourWheelView, this.minuteWheelView, this.secondWheelView, this.meridiemWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.hourWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_hour_wheel);
        this.minuteWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_minute_wheel);
        this.secondWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_second_wheel);
        this.hourLabelView = (TextView) findViewById(R.id.wheel_picker_time_hour_label);
        this.minuteLabelView = (TextView) findViewById(R.id.wheel_picker_time_minute_label);
        this.secondLabelView = (TextView) findViewById(R.id.wheel_picker_time_second_label);
        this.meridiemWheelView = (WheelView) findViewById(R.id.wheel_picker_time_meridiem_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TimeWheelLayout);
        setTimeMode(typedArrayObtainStyledAttributes.getInt(R.styleable.TimeWheelLayout_wheel_timeMode, 0));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_hourLabel);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_minuteLabel);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_secondLabel);
        typedArrayObtainStyledAttributes.recycle();
        setTimeLabel(string, string2, string3);
        setTimeFormatter(new SimpleTimeFormatter(this));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0 && this.startValue == null && this.endValue == null) {
            setRange(TimeEntity.target(0, 0, 0), TimeEntity.target(23, 59, 59), TimeEntity.now());
        }
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView view, int position) {
        int id = view.getId();
        if (id == R.id.wheel_picker_time_hour_wheel) {
            Integer num = (Integer) this.hourWheelView.getItem(position);
            this.selectedHour = num;
            if (this.resetWhenLinkage) {
                this.selectedMinute = null;
                this.selectedSecond = null;
            }
            changeMinute(num.intValue());
            timeSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_time_minute_wheel) {
            this.selectedMinute = (Integer) this.minuteWheelView.getItem(position);
            if (this.resetWhenLinkage) {
                this.selectedSecond = null;
            }
            changeSecond();
            timeSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_time_second_wheel) {
            this.selectedSecond = (Integer) this.secondWheelView.getItem(position);
            timeSelectedCallback();
        } else if (id == R.id.wheel_picker_time_meridiem_wheel) {
            this.isAnteMeridiem = "AM".equalsIgnoreCase((String) this.meridiemWheelView.getItem(position));
            timeSelectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView view, int state) {
        int id = view.getId();
        if (id == R.id.wheel_picker_time_hour_wheel) {
            this.minuteWheelView.setEnabled(state == 0);
            this.secondWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_time_minute_wheel) {
            this.hourWheelView.setEnabled(state == 0);
            this.secondWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_time_second_wheel) {
            this.hourWheelView.setEnabled(state == 0);
            this.minuteWheelView.setEnabled(state == 0);
        }
    }

    private void timeSelectedCallback() {
        if (this.onTimeSelectedListener != null) {
            this.secondWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    TimeWheelLayout.this.onTimeSelectedListener.onTimeSelected(TimeWheelLayout.this.selectedHour.intValue(), TimeWheelLayout.this.selectedMinute.intValue(), TimeWheelLayout.this.selectedSecond.intValue());
                }
            });
        }
        if (this.onTimeMeridiemSelectedListener != null) {
            this.secondWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TimeWheelLayout.this.onTimeMeridiemSelectedListener.onTimeSelected(TimeWheelLayout.this.selectedHour.intValue(), TimeWheelLayout.this.selectedMinute.intValue(), TimeWheelLayout.this.selectedSecond.intValue(), TimeWheelLayout.this.isAnteMeridiem());
                }
            });
        }
    }

    public void setTimeMode(int timeMode) {
        this.timeMode = timeMode;
        this.hourWheelView.setVisibility(0);
        this.hourLabelView.setVisibility(0);
        this.minuteWheelView.setVisibility(0);
        this.minuteLabelView.setVisibility(0);
        this.secondWheelView.setVisibility(0);
        this.secondLabelView.setVisibility(0);
        this.meridiemWheelView.setVisibility(8);
        if (timeMode == -1) {
            this.hourWheelView.setVisibility(8);
            this.hourLabelView.setVisibility(8);
            this.minuteWheelView.setVisibility(8);
            this.minuteLabelView.setVisibility(8);
            this.secondWheelView.setVisibility(8);
            this.secondLabelView.setVisibility(8);
            this.timeMode = timeMode;
            return;
        }
        if (timeMode == 2 || timeMode == 0) {
            this.secondWheelView.setVisibility(8);
            this.secondLabelView.setVisibility(8);
        }
        if (isHour12Mode()) {
            this.meridiemWheelView.setVisibility(0);
            this.meridiemWheelView.setData(Arrays.asList("AM", "PM"));
        }
    }

    public boolean isHour12Mode() {
        int i = this.timeMode;
        return i == 2 || i == 3;
    }

    public void setRange(TimeEntity startValue, TimeEntity endValue) {
        setRange(startValue, endValue, null);
    }

    public void setRange(TimeEntity timeEntity, TimeEntity timeEntity2, TimeEntity timeEntity3) {
        if (timeEntity == null) {
            timeEntity = TimeEntity.target(isHour12Mode() ? 1 : 0, 0, 0);
        }
        if (timeEntity2 == null) {
            timeEntity2 = TimeEntity.target(isHour12Mode() ? 12 : 23, 59, 59);
        }
        if (timeEntity2.toTimeInMillis() < timeEntity.toTimeInMillis()) {
            throw new IllegalArgumentException("Ensure the start time is less than the time date");
        }
        this.startValue = timeEntity;
        this.endValue = timeEntity2;
        if (timeEntity3 == null) {
            timeEntity3 = timeEntity;
        }
        this.defaultValue = timeEntity3;
        this.isAnteMeridiem = timeEntity3.getHour() < 12 || timeEntity3.getHour() == 24;
        this.selectedHour = Integer.valueOf(fixHour(timeEntity3.getHour()));
        this.selectedMinute = Integer.valueOf(timeEntity3.getMinute());
        this.selectedSecond = Integer.valueOf(timeEntity3.getSecond());
        changeHour();
        changeAnteMeridiem();
    }

    public void setDefaultValue(final TimeEntity defaultValue) {
        setRange(this.startValue, this.endValue, defaultValue);
    }

    public void setTimeFormatter(final TimeFormatter timeFormatter) {
        if (timeFormatter == null) {
            return;
        }
        this.hourWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.3
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return timeFormatter.formatHour(((Integer) value).intValue());
            }
        });
        this.minuteWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.4
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return timeFormatter.formatMinute(((Integer) value).intValue());
            }
        });
        this.secondWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.5
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return timeFormatter.formatSecond(((Integer) value).intValue());
            }
        });
    }

    public void setTimeLabel(CharSequence hour, CharSequence minute, CharSequence second) {
        this.hourLabelView.setText(hour);
        this.minuteLabelView.setText(minute);
        this.secondLabelView.setText(second);
    }

    public void setOnTimeSelectedListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.onTimeSelectedListener = onTimeSelectedListener;
    }

    public void setOnTimeMeridiemSelectedListener(OnTimeMeridiemSelectedListener onTimeMeridiemSelectedListener) {
        this.onTimeMeridiemSelectedListener = onTimeMeridiemSelectedListener;
    }

    public void setResetWhenLinkage(boolean resetWhenLinkage) {
        this.resetWhenLinkage = resetWhenLinkage;
    }

    public void setTimeStep(int hourStep, int minuteStep, int secondStep) {
        this.hourStep = hourStep;
        this.minuteStep = minuteStep;
        this.secondStep = secondStep;
        if (isDataAlready()) {
            setRange(this.startValue, this.endValue, this.defaultValue);
        }
    }

    protected boolean isDataAlready() {
        return (this.startValue == null || this.endValue == null) ? false : true;
    }

    public final TimeEntity getStartValue() {
        return this.startValue;
    }

    public final TimeEntity getEndValue() {
        return this.endValue;
    }

    public final NumberWheelView getHourWheelView() {
        return this.hourWheelView;
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.minuteWheelView;
    }

    public final NumberWheelView getSecondWheelView() {
        return this.secondWheelView;
    }

    public final TextView getHourLabelView() {
        return this.hourLabelView;
    }

    public final TextView getMinuteLabelView() {
        return this.minuteLabelView;
    }

    public final TextView getSecondLabelView() {
        return this.secondLabelView;
    }

    public final WheelView getMeridiemWheelView() {
        return this.meridiemWheelView;
    }

    @Deprecated
    public final TextView getMeridiemLabelView() {
        throw new UnsupportedOperationException("Use getMeridiemWheelView instead");
    }

    public final int getSelectedHour() {
        return fixHour(((Integer) this.hourWheelView.getCurrentItem()).intValue());
    }

    private int fixHour(int hour) {
        if (!isHour12Mode()) {
            return hour;
        }
        if (hour == 0) {
            hour = 24;
        }
        return hour > 12 ? hour - 12 : hour;
    }

    public final int getSelectedMinute() {
        return ((Integer) this.minuteWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedSecond() {
        int i = this.timeMode;
        if (i == 2 || i == 0) {
            return 0;
        }
        return ((Integer) this.secondWheelView.getCurrentItem()).intValue();
    }

    public final boolean isAnteMeridiem() {
        Object currentItem = this.meridiemWheelView.getCurrentItem();
        if (currentItem == null) {
            return this.isAnteMeridiem;
        }
        return "AM".equalsIgnoreCase(currentItem.toString());
    }

    private void changeHour() {
        int iMin = Math.min(this.startValue.getHour(), this.endValue.getHour());
        int iMax = Math.max(this.startValue.getHour(), this.endValue.getHour());
        boolean zIsHour12Mode = isHour12Mode();
        int i = isHour12Mode() ? 12 : 23;
        int iMax2 = Math.max(zIsHour12Mode ? 1 : 0, iMin);
        int iMin2 = Math.min(i, iMax);
        Integer num = this.selectedHour;
        if (num == null) {
            this.selectedHour = Integer.valueOf(iMax2);
        } else {
            Integer numValueOf = Integer.valueOf(Math.max(num.intValue(), iMax2));
            this.selectedHour = numValueOf;
            this.selectedHour = Integer.valueOf(Math.min(numValueOf.intValue(), iMin2));
        }
        this.hourWheelView.setRange(iMax2, iMin2, this.hourStep);
        this.hourWheelView.setDefaultValue(this.selectedHour);
        changeMinute(this.selectedHour.intValue());
    }

    private void changeMinute(int hour) {
        int minute;
        int minute2;
        if (hour == this.startValue.getHour() && hour == this.endValue.getHour()) {
            minute2 = this.startValue.getMinute();
            minute = this.endValue.getMinute();
        } else if (hour == this.startValue.getHour()) {
            minute2 = this.startValue.getMinute();
            minute = 59;
        } else {
            minute = hour == this.endValue.getHour() ? this.endValue.getMinute() : 59;
            minute2 = 0;
        }
        Integer num = this.selectedMinute;
        if (num == null) {
            this.selectedMinute = Integer.valueOf(minute2);
        } else {
            Integer numValueOf = Integer.valueOf(Math.max(num.intValue(), minute2));
            this.selectedMinute = numValueOf;
            this.selectedMinute = Integer.valueOf(Math.min(numValueOf.intValue(), minute));
        }
        this.minuteWheelView.setRange(minute2, minute, this.minuteStep);
        this.minuteWheelView.setDefaultValue(this.selectedMinute);
        changeSecond();
    }

    private void changeSecond() {
        if (this.selectedSecond == null) {
            this.selectedSecond = 0;
        }
        this.secondWheelView.setRange(0, 59, this.secondStep);
        this.secondWheelView.setDefaultValue(this.selectedSecond);
    }

    private void changeAnteMeridiem() {
        this.meridiemWheelView.setDefaultValue(this.isAnteMeridiem ? "AM" : "PM");
    }
}
