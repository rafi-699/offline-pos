package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseWheelLayout extends LinearLayout implements OnWheelChangedListener {
    private final List<WheelView> wheelViews;

    protected void onAttributeSet(Context context, AttributeSet attrs) {
    }

    protected void onInit(Context context) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelLoopFinished(WheelView view) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView view, int state) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrolled(WheelView view, int offset) {
    }

    protected abstract int provideLayoutRes();

    protected abstract List<WheelView> provideWheelViews();

    public BaseWheelLayout(Context context) {
        super(context);
        this.wheelViews = new ArrayList();
        init(context, null, R.attr.WheelStyle, R.style.WheelDefault);
    }

    public BaseWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.wheelViews = new ArrayList();
        init(context, attrs, R.attr.WheelStyle, R.style.WheelDefault);
    }

    public BaseWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.wheelViews = new ArrayList();
        init(context, attrs, defStyleAttr, R.style.WheelDefault);
    }

    public BaseWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.wheelViews = new ArrayList();
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        setOrientation(1);
        inflate(context, provideLayoutRes(), this);
        onInit(context);
        this.wheelViews.clear();
        this.wheelViews.addAll(provideWheelViews());
        initAttrs(context, attrs, defStyleAttr, defStyleRes);
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setOnWheelChangedListener(this);
        }
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.BaseWheelLayout, defStyleAttr, defStyleRes);
        setVisibleItemCount(typedArrayObtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArrayObtainStyledAttributes.getString(R.styleable.BaseWheelLayout_wheel_maxWidthText));
        setTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_itemTextColor, -7829368));
        setSelectedTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        float f3 = f2 * 15.0f;
        setTextSize(typedArrayObtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_itemTextSize, f3));
        setSelectedTextSize(typedArrayObtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_itemTextSizeSelected, f3));
        setSelectedTextBold(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_itemTextBoldSelected, false));
        setTextAlign(typedArrayObtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_itemTextAlign, 0));
        setItemSpace(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_indicatorColor, -3552823));
        float f4 = f * 1.0f;
        setIndicatorSize(typedArrayObtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_indicatorSize, f4));
        setCurvedIndicatorSpace(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseWheelLayout_wheel_curvedIndicatorSpace, (int) f4));
        setCurtainEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainCorner(typedArrayObtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_curtainCorner, 0));
        setCurtainRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArrayObtainStyledAttributes.getInteger(R.styleable.BaseWheelLayout_wheel_curvedMaxAngle, 90));
        typedArrayObtainStyledAttributes.recycle();
        onAttributeSet(context, attrs);
    }

    public void setStyle(int style) {
        initAttrs(getContext(), null, R.attr.WheelStyle, style);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(enabled);
        }
    }

    public void setVisibleItemCount(int visibleItemCount) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setVisibleItemCount(visibleItemCount);
        }
    }

    public void setItemSpace(int space) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setItemSpace(space);
        }
    }

    public void setSameWidthEnabled(boolean sameWidthEnabled) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSameWidthEnabled(sameWidthEnabled);
        }
    }

    public void setDefaultItemPosition(int position) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setDefaultPosition(position);
        }
    }

    public void setCurtainEnabled(boolean hasCurtain) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainEnabled(hasCurtain);
        }
    }

    public void setCurtainColor(int color) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainColor(color);
        }
    }

    public void setCurtainCorner(int corner) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainCorner(corner);
        }
    }

    public void setCurtainRadius(float radius) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainRadius(radius);
        }
    }

    public void setAtmosphericEnabled(boolean hasAtmospheric) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setAtmosphericEnabled(hasAtmospheric);
        }
    }

    public void setCurvedEnabled(boolean curved) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedEnabled(curved);
        }
    }

    public void setCurvedMaxAngle(int curvedMaxAngle) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedMaxAngle(curvedMaxAngle);
        }
    }

    public void setCurvedIndicatorSpace(int space) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedIndicatorSpace(space);
        }
    }

    public void setCyclicEnabled(boolean cyclic) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCyclicEnabled(cyclic);
        }
    }

    public void setIndicatorEnabled(boolean hasIndicator) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorEnabled(hasIndicator);
        }
    }

    public void setIndicatorSize(float size) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorSize(size);
        }
    }

    public void setIndicatorColor(int color) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorColor(color);
        }
    }

    public void setMaxWidthText(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setMaxWidthText(text);
        }
    }

    public void setTextSize(float textSize) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextSize(textSize);
        }
    }

    public void setSelectedTextSize(float textSize) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSelectedTextSize(textSize);
        }
    }

    public void setTextColor(int color) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextColor(color);
        }
    }

    public void setSelectedTextColor(int color) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSelectedTextColor(color);
        }
    }

    public void setSelectedTextBold(boolean bold) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSelectedTextBold(bold);
        }
    }

    public void setTextAlign(int align) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextAlign(align);
        }
    }
}
