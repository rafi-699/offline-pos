package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNGoogleMobileAdsNativeViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNGoogleMobileAdsNativeViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNGoogleMobileAdsNativeViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        if (str.equals("responseId")) {
            ((RNGoogleMobileAdsNativeViewManagerInterface) this.mViewManager).setResponseId(t, obj == null ? null : (String) obj);
        } else {
            super.kotlinCompat$setProperty(t, str, obj);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("registerAsset")) {
            ((RNGoogleMobileAdsNativeViewManagerInterface) this.mViewManager).registerAsset(t, readableArray.getString(0), readableArray.getInt(1));
        }
    }
}
