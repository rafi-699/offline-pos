package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.autofill.HintConstants;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class RNPDFPdfViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNPDFPdfViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNPDFPdfViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2012158909:
                if (str.equals("spacing")) {
                    b = 0;
                }
                break;
            case -1790919953:
                if (str.equals("enablePaging")) {
                    b = 1;
                }
                break;
            case -1379690984:
                if (str.equals("minScale")) {
                    b = 2;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = 3;
                }
                break;
            case -922092170:
                if (str.equals("showsVerticalScrollIndicator")) {
                    b = 4;
                }
                break;
            case -657951334:
                if (str.equals("enableAnnotationRendering")) {
                    b = 5;
                }
                break;
            case -631667225:
                if (str.equals("enableRTL")) {
                    b = 6;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    b = 7;
                }
                break;
            case 3433509:
                if (str.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                    b = 8;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 9;
                }
                break;
            case 396505670:
                if (str.equals("maxScale")) {
                    b = 10;
                }
                break;
            case 902106275:
                if (str.equals("fitPolicy")) {
                    b = Ascii.VT;
                }
                break;
            case 913503991:
                if (str.equals("singlePage")) {
                    b = Ascii.FF;
                }
                break;
            case 1216985755:
                if (str.equals(HintConstants.AUTOFILL_HINT_PASSWORD)) {
                    b = Ascii.CR;
                }
                break;
            case 1308044823:
                if (str.equals("enableAntialiasing")) {
                    b = Ascii.SO;
                }
                break;
            case 1387629604:
                if (str.equals("horizontal")) {
                    b = Ascii.SI;
                }
                break;
            case 1539343426:
                if (str.equals("enableDoubleTapZoom")) {
                    b = Ascii.DLE;
                }
                break;
            case 1915931784:
                if (str.equals("showsHorizontalScrollIndicator")) {
                    b = 17;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setSpacing(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnablePaging(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setMinScale(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 3:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setShowsVerticalScrollIndicator(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableAnnotationRendering(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableRTL(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPage(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 8:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPath(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setScale(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 10:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setMaxScale(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 11:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setFitPolicy(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 12:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setSinglePage(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 13:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setPassword(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableAntialiasing(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 15:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setHorizontal(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setEnableDoubleTapZoom(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNPDFPdfViewManagerInterface) this.mViewManager).setShowsHorizontalScrollIndicator(t, obj != null ? ((Boolean) obj).booleanValue() : false);
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
        if (str.equals("setNativePage")) {
            ((RNPDFPdfViewManagerInterface) this.mViewManager).setNativePage(t, readableArray.getInt(0));
        }
    }
}
