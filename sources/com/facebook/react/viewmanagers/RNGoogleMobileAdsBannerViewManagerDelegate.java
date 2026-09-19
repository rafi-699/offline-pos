package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsBannerViewManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class RNGoogleMobileAdsBannerViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNGoogleMobileAdsBannerViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNGoogleMobileAdsBannerViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1323285827:
                if (str.equals("manualImpressionsEnabled")) {
                    b = 0;
                }
                break;
            case -840527425:
                if (str.equals("unitId")) {
                    b = 1;
                }
                break;
            case 1095692943:
                if (str.equals("request")) {
                    b = 2;
                }
                break;
            case 1708690083:
                if (str.equals("sizeConfig")) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).setManualImpressionsEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).setUnitId(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).setRequest(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).setSizeConfig(t, (ReadableMap) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("recordManualImpression")) {
            ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).recordManualImpression(t);
        } else if (str.equals("load")) {
            ((RNGoogleMobileAdsBannerViewManagerInterface) this.mViewManager).load(t);
        }
    }
}
