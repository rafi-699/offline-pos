package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface RNGoogleMobileAdsBannerViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void load(T t);

    void recordManualImpression(T t);

    void setManualImpressionsEnabled(T t, boolean z);

    void setRequest(T t, String str);

    void setSizeConfig(T t, ReadableMap readableMap);

    void setUnitId(T t, String str);
}
