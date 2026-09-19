package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;
import com.github.gzuliyujiang.wheelpicker.contract.OnDateSelectedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DateWheelLayout extends BaseWheelLayout {
    private TextView dayLabelView;
    private NumberWheelView dayWheelView;
    private DateEntity endValue;
    private TextView monthLabelView;
    private NumberWheelView monthWheelView;
    private OnDateSelectedListener onDateSelectedListener;
    private boolean resetWhenLinkage;
    private Integer selectedDay;
    private Integer selectedMonth;
    private Integer selectedYear;
    private DateEntity startValue;
    private TextView yearLabelView;
    private NumberWheelView yearWheelView;

    public DateWheelLayout(Context context) {
        super(context);
        this.resetWhenLinkage = true;
    }

    public DateWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.resetWhenLinkage = true;
    }

    public DateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.resetWhenLinkage = true;
    }

    public DateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.resetWhenLinkage = true;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_date;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.yearWheelView, this.monthWheelView, this.dayWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.yearWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_year_wheel);
        this.monthWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_month_wheel);
        this.dayWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_day_wheel);
        this.yearLabelView = (TextView) findViewById(R.id.wheel_picker_date_year_label);
        this.monthLabelView = (TextView) findViewById(R.id.wheel_picker_date_month_label);
        this.dayLabelView = (TextView) findViewById(R.id.wheel_picker_date_day_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.DateWheelLayout);
        setDateMode(typedArrayObtainStyledAttributes.getInt(R.styleable.DateWheelLayout_wheel_dateMode, 0));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_yearLabel);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_monthLabel);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_dayLabel);
        typedArrayObtainStyledAttributes.recycle();
        setDateLabel(string, string2, string3);
        setDateFormatter(new SimpleDateFormatter());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0 && this.startValue == null && this.endValue == null) {
            setRange(DateEntity.today(), DateEntity.yearOnFuture(30), DateEntity.today());
        }
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView view, int position) {
        int id = view.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            Integer num = (Integer) this.yearWheelView.getItem(position);
            this.selectedYear = num;
            if (this.resetWhenLinkage) {
                this.selectedMonth = null;
                this.selectedDay = null;
            }
            changeMonth(num.intValue());
            dateSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_date_month_wheel) {
            this.selectedMonth = (Integer) this.monthWheelView.getItem(position);
            if (this.resetWhenLinkage) {
                this.selectedDay = null;
            }
            changeDay(this.selectedYear.intValue(), this.selectedMonth.intValue());
            dateSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_date_day_wheel) {
            this.selectedDay = (Integer) this.dayWheelView.getItem(position);
            dateSelectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView view, int state) {
        int id = view.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            this.monthWheelView.setEnabled(state == 0);
            this.dayWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_date_month_wheel) {
            this.yearWheelView.setEnabled(state == 0);
            this.dayWheelView.setEnabled(state == 0);
        } else if (id == R.id.wheel_picker_date_day_wheel) {
            this.yearWheelView.setEnabled(state == 0);
            this.monthWheelView.setEnabled(state == 0);
        }
    }

    private void dateSelectedCallback() {
        if (this.onDateSelectedListener == null) {
            return;
        }
        this.dayWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DateWheelLayout.this.onDateSelectedListener.onDateSelected(DateWheelLayout.this.selectedYear.intValue(), DateWheelLayout.this.selectedMonth.intValue(), DateWheelLayout.this.selectedDay.intValue());
            }
        });
    }

    public void setDateMode(int dateMode) {
        this.yearWheelView.setVisibility(0);
        this.yearLabelView.setVisibility(0);
        this.monthWheelView.setVisibility(0);
        this.monthLabelView.setVisibility(0);
        this.dayWheelView.setVisibility(0);
        this.dayLabelView.setVisibility(0);
        if (dateMode == -1) {
            this.yearWheelView.setVisibility(8);
            this.yearLabelView.setVisibility(8);
            this.monthWheelView.setVisibility(8);
            this.monthLabelView.setVisibility(8);
            this.dayWheelView.setVisibility(8);
            this.dayLabelView.setVisibility(8);
            return;
        }
        if (dateMode == 2) {
            this.yearWheelView.setVisibility(8);
            this.yearLabelView.setVisibility(8);
        } else if (dateMode == 1) {
            this.dayWheelView.setVisibility(8);
            this.dayLabelView.setVisibility(8);
        }
    }

    public void setRange(DateEntity startValue, DateEntity endValue) {
        setRange(startValue, endValue, null);
    }

    public void setRange(DateEntity startValue, DateEntity endValue, DateEntity defaultValue) {
        if (startValue == null) {
            startValue = DateEntity.today();
        }
        if (endValue == null) {
            endValue = DateEntity.yearOnFuture(30);
        }
        if (endValue.toTimeInMillis() < startValue.toTimeInMillis()) {
            throw new IllegalArgumentException("Ensure the start date is less than the end date");
        }
        this.startValue = startValue;
        this.endValue = endValue;
        if (defaultValue != null) {
            this.selectedYear = Integer.valueOf(defaultValue.getYear());
            this.selectedMonth = Integer.valueOf(defaultValue.getMonth());
            this.selectedDay = Integer.valueOf(defaultValue.getDay());
        } else {
            this.selectedYear = null;
            this.selectedMonth = null;
            this.selectedDay = null;
        }
        changeYear();
    }

    public void setDefaultValue(DateEntity defaultValue) {
        setRange(this.startValue, this.endValue, defaultValue);
    }

    public void setDateFormatter(final DateFormatter dateFormatter) {
        if (dateFormatter == null) {
            return;
        }
        this.yearWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.2
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return dateFormatter.formatYear(((Integer) value).intValue());
            }
        });
        this.monthWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.3
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return dateFormatter.formatMonth(((Integer) value).intValue());
            }
        });
        this.dayWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.4
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object value) {
                return dateFormatter.formatDay(((Integer) value).intValue());
            }
        });
    }

    public void setDateLabel(CharSequence year, CharSequence month, CharSequence day) {
        this.yearLabelView.setText(year);
        this.monthLabelView.setText(month);
        this.dayLabelView.setText(day);
    }

    public void setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener) {
        this.onDateSelectedListener = onDateSelectedListener;
    }

    public void setResetWhenLinkage(boolean resetWhenLinkage) {
        this.resetWhenLinkage = resetWhenLinkage;
    }

    public final DateEntity getStartValue() {
        return this.startValue;
    }

    public final DateEntity getEndValue() {
        return this.endValue;
    }

    public final NumberWheelView getYearWheelView() {
        return this.yearWheelView;
    }

    public final NumberWheelView getMonthWheelView() {
        return this.monthWheelView;
    }

    public final NumberWheelView getDayWheelView() {
        return this.dayWheelView;
    }

    public final TextView getYearLabelView() {
        return this.yearLabelView;
    }

    public final TextView getMonthLabelView() {
        return this.monthLabelView;
    }

    public final TextView getDayLabelView() {
        return this.dayLabelView;
    }

    public final int getSelectedYear() {
        return ((Integer) this.yearWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedMonth() {
        return ((Integer) this.monthWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedDay() {
        return ((Integer) this.dayWheelView.getCurrentItem()).intValue();
    }

    private void changeYear() {
        int iMin = Math.min(this.startValue.getYear(), this.endValue.getYear());
        int iMax = Math.max(this.startValue.getYear(), this.endValue.getYear());
        Integer num = this.selectedYear;
        if (num == null) {
            this.selectedYear = Integer.valueOf(iMin);
        } else {
            Integer numValueOf = Integer.valueOf(Math.max(num.intValue(), iMin));
            this.selectedYear = numValueOf;
            this.selectedYear = Integer.valueOf(Math.min(numValueOf.intValue(), iMax));
        }
        this.yearWheelView.setRange(iMin, iMax, 1);
        this.yearWheelView.setDefaultValue(this.selectedYear);
        changeMonth(this.selectedYear.intValue());
    }

    private void changeMonth(int year) {
        int month;
        int month2;
        if (this.startValue.getYear() == this.endValue.getYear()) {
            month2 = Math.min(this.startValue.getMonth(), this.endValue.getMonth());
            month = Math.max(this.startValue.getMonth(), this.endValue.getMonth());
        } else {
            month = 12;
            if (year == this.startValue.getYear()) {
                month2 = this.startValue.getMonth();
            } else {
                month = year == this.endValue.getYear() ? this.endValue.getMonth() : 12;
                month2 = 1;
            }
        }
        Integer num = this.selectedMonth;
        if (num == null) {
            this.selectedMonth = Integer.valueOf(month2);
        } else {
            Integer numValueOf = Integer.valueOf(Math.max(num.intValue(), month2));
            this.selectedMonth = numValueOf;
            this.selectedMonth = Integer.valueOf(Math.min(numValueOf.intValue(), month));
        }
        this.monthWheelView.setRange(month2, month, 1);
        this.monthWheelView.setDefaultValue(this.selectedMonth);
        changeDay(year, this.selectedMonth.intValue());
    }

    private void changeDay(int year, int month) {
        int totalDaysInMonth;
        int day;
        if (year == this.startValue.getYear() && month == this.startValue.getMonth() && year == this.endValue.getYear() && month == this.endValue.getMonth()) {
            day = this.startValue.getDay();
            totalDaysInMonth = this.endValue.getDay();
        } else if (year == this.startValue.getYear() && month == this.startValue.getMonth()) {
            int day2 = this.startValue.getDay();
            totalDaysInMonth = getTotalDaysInMonth(year, month);
            day = day2;
        } else {
            if (year == this.endValue.getYear() && month == this.endValue.getMonth()) {
                totalDaysInMonth = this.endValue.getDay();
            } else {
                totalDaysInMonth = getTotalDaysInMonth(year, month);
            }
            day = 1;
        }
        Integer num = this.selectedDay;
        if (num == null) {
            this.selectedDay = Integer.valueOf(day);
        } else {
            Integer numValueOf = Integer.valueOf(Math.max(num.intValue(), day));
            this.selectedDay = numValueOf;
            this.selectedDay = Integer.valueOf(Math.min(numValueOf.intValue(), totalDaysInMonth));
        }
        this.dayWheelView.setRange(day, totalDaysInMonth, 1);
        this.dayWheelView.setDefaultValue(this.selectedDay);
    }

    private int getTotalDaysInMonth(int year, int month) {
        if (month == 1) {
            return 31;
        }
        if (month != 2) {
            return (month == 3 || month == 5 || month == 10 || month == 12 || month == 7 || month == 8) ? 31 : 30;
        }
        if (year <= 0) {
            return 29;
        }
        return ((year % 4 != 0 || year % 100 == 0) && year % 400 != 0) ? 28 : 29;
    }
}
