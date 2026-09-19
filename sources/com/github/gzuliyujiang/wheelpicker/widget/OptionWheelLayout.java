package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class OptionWheelLayout extends BaseWheelLayout {
    private TextView labelView;
    private OnOptionSelectedListener onOptionSelectedListener;
    private WheelView wheelView;

    public OptionWheelLayout(Context context) {
        super(context);
    }

    public OptionWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OptionWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OptionWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_option;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Collections.singletonList(this.wheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.wheelView = (WheelView) findViewById(R.id.wheel_picker_option_wheel);
        this.labelView = (TextView) findViewById(R.id.wheel_picker_option_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.OptionWheelLayout);
        this.labelView.setText(typedArrayObtainStyledAttributes.getString(R.styleable.OptionWheelLayout_wheel_label));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void onWheelSelected(WheelView view, int position) {
        OnOptionSelectedListener onOptionSelectedListener = this.onOptionSelectedListener;
        if (onOptionSelectedListener != null) {
            onOptionSelectedListener.onOptionSelected(position, this.wheelView.getItem(position));
        }
    }

    public void setData(List<?> data) {
        this.wheelView.setData(data);
    }

    public void setDefaultValue(Object value) {
        this.wheelView.setDefaultValue(value);
    }

    public void setDefaultPosition(int position) {
        this.wheelView.setDefaultPosition(position);
    }

    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        this.onOptionSelectedListener = onOptionSelectedListener;
    }

    public final WheelView getWheelView() {
        return this.wheelView;
    }

    public final TextView getLabelView() {
        return this.labelView;
    }
}
