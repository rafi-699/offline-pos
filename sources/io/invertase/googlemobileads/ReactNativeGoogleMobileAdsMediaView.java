package io.invertase.googlemobileads;

import android.view.View;
import android.widget.ImageView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsMediaView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsMediaView;", "Lcom/google/android/gms/ads/nativead/MediaView;", "context", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "setResponseId", "", "responseId", "", "setResizeMode", ViewProps.RESIZE_MODE, "requestLayout", "measureAndLayout", "Ljava/lang/Runnable;", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsMediaView extends MediaView {
    private final ReactContext context;
    private final Runnable measureAndLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsMediaView(ReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.measureAndLayout = new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsMediaView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactNativeGoogleMobileAdsMediaView.measureAndLayout$lambda$1(this.f$0);
            }
        };
    }

    public final void setResponseId(String responseId) {
        ReactNativeGoogleMobileAdsNativeModule reactNativeGoogleMobileAdsNativeModule = (ReactNativeGoogleMobileAdsNativeModule) this.context.getNativeModule(ReactNativeGoogleMobileAdsNativeModule.class);
        if (reactNativeGoogleMobileAdsNativeModule != null) {
            if (responseId == null) {
                responseId = "";
            }
            NativeAd nativeAd = reactNativeGoogleMobileAdsNativeModule.getNativeAd(responseId);
            if (nativeAd != null) {
                setMediaContent(nativeAd.getMediaContent());
                requestLayout();
            }
        }
    }

    public final void setResizeMode(String resizeMode) {
        if (resizeMode != null) {
            int iHashCode = resizeMode.hashCode();
            if (iHashCode == -1881872635) {
                if (resizeMode.equals("stretch")) {
                    setImageScaleType(ImageView.ScaleType.FIT_XY);
                }
            } else if (iHashCode == 94852023) {
                if (resizeMode.equals("cover")) {
                    setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            } else if (iHashCode == 951526612 && resizeMode.equals("contain")) {
                setImageScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureAndLayout$lambda$1(ReactNativeGoogleMobileAdsMediaView reactNativeGoogleMobileAdsMediaView) {
        reactNativeGoogleMobileAdsMediaView.measure(View.MeasureSpec.makeMeasureSpec(reactNativeGoogleMobileAdsMediaView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(reactNativeGoogleMobileAdsMediaView.getHeight(), 1073741824));
        reactNativeGoogleMobileAdsMediaView.layout(reactNativeGoogleMobileAdsMediaView.getLeft(), reactNativeGoogleMobileAdsMediaView.getTop(), reactNativeGoogleMobileAdsMediaView.getRight(), reactNativeGoogleMobileAdsMediaView.getBottom());
    }
}
