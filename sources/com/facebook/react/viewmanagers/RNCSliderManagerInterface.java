package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface RNCSliderManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setAccessibilityIncrements(T t, ReadableArray readableArray);

    void setAccessibilityUnits(T t, String str);

    void setDisabled(T t, boolean z);

    void setInverted(T t, boolean z);

    void setLowerLimit(T t, float f);

    void setMaximumTrackImage(T t, ReadableMap readableMap);

    void setMaximumTrackTintColor(T t, Integer num);

    void setMaximumValue(T t, double d);

    void setMinimumTrackImage(T t, ReadableMap readableMap);

    void setMinimumTrackTintColor(T t, Integer num);

    void setMinimumValue(T t, double d);

    void setStep(T t, double d);

    void setTapToSeek(T t, boolean z);

    void setTestID(T t, String str);

    void setThumbImage(T t, ReadableMap readableMap);

    void setThumbTintColor(T t, Integer num);

    void setTrackImage(T t, ReadableMap readableMap);

    void setUpperLimit(T t, float f);

    void setValue(T t, float f);

    void setVertical(T t, boolean z);
}
