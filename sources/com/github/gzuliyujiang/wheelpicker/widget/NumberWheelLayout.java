package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NumberWheelLayout extends OptionWheelLayout {
    private OnNumberSelectedListener onNumberSelectedListener;

    public NumberWheelLayout(Context context) {
        super(context);
    }

    public NumberWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NumberWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        super.onAttributeSet(context, attrs);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NumberWheelLayout);
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_minNumber, 0.0f);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_maxNumber, 10.0f);
        float f3 = typedArrayObtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_stepNumber, 1.0f);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.NumberWheelLayout_wheel_isDecimal, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            setRange(f, f2, f3);
        } else {
            setRange((int) f, (int) f2, (int) f3);
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView view, int position) {
        super.onWheelSelected(view, position);
        if (this.onNumberSelectedListener != null) {
            this.onNumberSelectedListener.onNumberSelected(position, (Number) getWheelView().getItem(position));
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setData(List<?> data) {
        throw new UnsupportedOperationException("Use setRange instead");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        throw new UnsupportedOperationException("Use setOnNumberSelectedListener instead");
    }

    public void setOnNumberSelectedListener(OnNumberSelectedListener onNumberSelectedListener) {
        this.onNumberSelectedListener = onNumberSelectedListener;
    }

    public void setRange(int min, int max, int step) {
        int iMin = Math.min(min, max);
        int iMax = Math.max(min, max);
        ArrayList arrayList = new ArrayList((iMax - iMin) / step);
        while (iMin <= iMax) {
            arrayList.add(Integer.valueOf(iMin));
            iMin += step;
        }
        super.setData(arrayList);
    }

    public void setRange(float min, float max, float step) {
        float fMin = Math.min(min, max);
        float fMax = Math.max(min, max);
        ArrayList arrayList = new ArrayList((int) ((fMax - fMin) / step));
        while (fMin <= fMax) {
            arrayList.add(Float.valueOf(fMin));
            fMin += step;
        }
        super.setData(arrayList);
    }
}
