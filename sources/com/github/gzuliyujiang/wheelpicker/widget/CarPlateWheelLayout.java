package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.github.gzuliyujiang.wheelpicker.impl.CarPlateProvider;

/* JADX INFO: loaded from: classes3.dex */
public class CarPlateWheelLayout extends LinkageWheelLayout {
    private CarPlateProvider provider;

    public CarPlateWheelLayout(Context context) {
        super(context);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        super.onInit(context);
        CarPlateProvider carPlateProvider = new CarPlateProvider();
        this.provider = carPlateProvider;
        setData(carPlateProvider);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, AttributeSet attrs) {
        super.onAttributeSet(context, attrs);
        setFirstVisible(this.provider.firstLevelVisible());
        setThirdVisible(this.provider.thirdLevelVisible());
    }
}
