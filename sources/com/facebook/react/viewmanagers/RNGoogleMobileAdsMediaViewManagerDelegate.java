package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNGoogleMobileAdsMediaViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNGoogleMobileAdsMediaViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNGoogleMobileAdsMediaViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        if (str.equals("responseId")) {
            ((RNGoogleMobileAdsMediaViewManagerInterface) this.mViewManager).setResponseId(t, obj != null ? (String) obj : null);
        } else if (str.equals(ViewProps.RESIZE_MODE)) {
            ((RNGoogleMobileAdsMediaViewManagerInterface) this.mViewManager).setResizeMode(t, obj != null ? (String) obj : null);
        } else {
            super.kotlinCompat$setProperty(t, str, obj);
        }
    }
}
