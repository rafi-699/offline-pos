package io.invertase.googlemobileads;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsNativeModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RNGoogleMobileAdsNativeModule")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bH\u0017J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\bR2\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tR\u00020\u00000\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tR\u00020\u0000`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeModule;", "Lio/invertase/googlemobileads/NativeGoogleMobileAdsNativeModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "adHolders", "Ljava/util/HashMap;", "", "Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder;", "Lkotlin/collections/HashMap;", "getName", "load", "", "adUnitId", "requestOptions", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "destroy", "responseId", "invalidate", "getNativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "NativeAdHolder", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsNativeModule extends NativeGoogleMobileAdsNativeModuleSpec {
    public static final String NAME = "RNGoogleMobileAdsNativeModule";
    private final HashMap<String, NativeAdHolder> adHolders;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.adHolders = new HashMap<>();
    }

    @Override // io.invertase.googlemobileads.NativeGoogleMobileAdsNativeModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGoogleMobileAdsNativeModule";
    }

    @Override // io.invertase.googlemobileads.NativeGoogleMobileAdsNativeModuleSpec
    @ReactMethod
    public void load(String adUnitId, ReadableMap requestOptions, final Promise promise) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final NativeAdHolder nativeAdHolder = new NativeAdHolder(this, adUnitId, requestOptions);
        nativeAdHolder.loadAd(new NativeAd.OnNativeAdLoadedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsNativeModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public final void onNativeAdLoaded(NativeAd nativeAd) {
                ReactNativeGoogleMobileAdsNativeModule.load$lambda$5(this.f$0, nativeAdHolder, promise, nativeAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void load$lambda$5(ReactNativeGoogleMobileAdsNativeModule reactNativeGoogleMobileAdsNativeModule, NativeAdHolder nativeAdHolder, Promise promise, NativeAd nativeAd) {
        String responseId;
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        ResponseInfo responseInfo = nativeAd.getResponseInfo();
        if (responseInfo == null || (responseId = responseInfo.getResponseId()) == null) {
            return;
        }
        reactNativeGoogleMobileAdsNativeModule.adHolders.put(responseId, nativeAdHolder);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("responseId", responseId);
        writableMapCreateMap.putString("advertiser", nativeAd.getAdvertiser());
        writableMapCreateMap.putString("body", nativeAd.getBody());
        writableMapCreateMap.putString("callToAction", nativeAd.getCallToAction());
        writableMapCreateMap.putString("headline", nativeAd.getHeadline());
        writableMapCreateMap.putString(FirebaseAnalytics.Param.PRICE, nativeAd.getPrice());
        writableMapCreateMap.putString("store", nativeAd.getStore());
        Double starRating = nativeAd.getStarRating();
        if (starRating != null) {
            writableMapCreateMap.putDouble("starRating", starRating.doubleValue());
        } else {
            writableMapCreateMap.putNull("starRating");
        }
        NativeAd.Image icon = nativeAd.getIcon();
        if (icon != null) {
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putDouble("scale", icon.getScale());
            writableMapCreateMap2.putString("url", String.valueOf(icon.getUri()));
            writableMapCreateMap.putMap("icon", writableMapCreateMap2);
        } else {
            writableMapCreateMap.putNull("icon");
        }
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        MediaContent mediaContent = nativeAd.getMediaContent();
        if (mediaContent != null) {
            writableMapCreateMap3.putDouble(ViewProps.ASPECT_RATIO, mediaContent.getAspectRatio());
            writableMapCreateMap3.putBoolean("hasVideoContent", mediaContent.hasVideoContent());
            writableMapCreateMap3.putDouble("duration", mediaContent.getDuration());
            writableMapCreateMap.putMap("mediaContent", writableMapCreateMap3);
        }
        promise.resolve(writableMapCreateMap);
    }

    @Override // io.invertase.googlemobileads.NativeGoogleMobileAdsNativeModuleSpec
    @ReactMethod
    public void destroy(String responseId) {
        Intrinsics.checkNotNullParameter(responseId, "responseId");
        NativeAdHolder nativeAdHolder = this.adHolders.get(responseId);
        if (nativeAdHolder != null) {
            nativeAdHolder.destroy();
        }
        this.adHolders.remove(responseId);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        super.invalidate();
        Collection<NativeAdHolder> collectionValues = this.adHolders.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((NativeAdHolder) it.next()).destroy();
        }
        this.adHolders.clear();
    }

    public final NativeAd getNativeAd(String responseId) {
        Intrinsics.checkNotNullParameter(responseId, "responseId");
        NativeAdHolder nativeAdHolder = this.adHolders.get(responseId);
        if (nativeAdHolder != null) {
            return nativeAdHolder.getNativeAd();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ReactNativeGoogleMobileAdsNativeModule.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u001c\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder;", "", "adUnitId", "", "requestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "<init>", "(Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeModule;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "value", "Lcom/google/android/gms/ads/nativead/NativeAd;", "nativeAd", "getNativeAd", "()Lcom/google/android/gms/ads/nativead/NativeAd;", "adListener", "Lcom/google/android/gms/ads/AdListener;", "videoLifecycleCallbacks", "Lcom/google/android/gms/ads/VideoController$VideoLifecycleCallbacks;", "loadAd", "", "loadedListener", "Lcom/google/android/gms/ads/nativead/NativeAd$OnNativeAdLoadedListener;", "destroy", "emitAdEvent", "type", "eventData", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class NativeAdHolder {
        private final AdListener adListener;
        private final String adUnitId;
        private NativeAd nativeAd;
        private final ReadableMap requestOptions;
        final /* synthetic */ ReactNativeGoogleMobileAdsNativeModule this$0;
        private final VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks;

        public NativeAdHolder(ReactNativeGoogleMobileAdsNativeModule reactNativeGoogleMobileAdsNativeModule, String adUnitId, ReadableMap requestOptions) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
            this.this$0 = reactNativeGoogleMobileAdsNativeModule;
            this.adUnitId = adUnitId;
            this.requestOptions = requestOptions;
            this.adListener = new AdListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder$adListener$1
                @Override // com.google.android.gms.ads.AdListener
                public void onAdImpression() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, "impression", null, 2, null);
                }

                @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
                public void onAdClicked() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLICKED, null, 2, null);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdOpened() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_OPENED, null, 2, null);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED, null, 2, null);
                }
            };
            this.videoLifecycleCallbacks = new VideoController.VideoLifecycleCallbacks() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder$videoLifecycleCallbacks$1
                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoPlay() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, "video_played", null, 2, null);
                }

                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoPause() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, "video_paused", null, 2, null);
                }

                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoEnd() {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(this.this$0, "video_ended", null, 2, null);
                }

                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoMute(boolean isMuted) {
                    String str;
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder nativeAdHolder = this.this$0;
                    if (isMuted) {
                        str = "video_muted";
                    } else {
                        str = "video_unmuted";
                    }
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.emitAdEvent$default(nativeAdHolder, str, null, 2, null);
                }
            };
        }

        public final NativeAd getNativeAd() {
            return this.nativeAd;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0046  */
        public final void loadAd(final NativeAd.OnNativeAdLoadedListener loadedListener) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(loadedListener, "loadedListener");
            int i3 = 0;
            if (!this.requestOptions.hasKey(ViewProps.ASPECT_RATIO) || (i2 = this.requestOptions.getInt(ViewProps.ASPECT_RATIO)) == 1) {
                i = 1;
            } else if (i2 == 2) {
                i = 2;
            } else if (i2 != 3) {
                i = 4;
                if (i2 != 4) {
                    i = 0;
                }
            } else {
                i = 3;
            }
            if (this.requestOptions.hasKey("adChoicesPlacement")) {
                int i4 = this.requestOptions.getInt("adChoicesPlacement");
                if (i4 != 0) {
                    if (i4 == 1) {
                        i3 = 1;
                    } else if (i4 == 2) {
                        i3 = 2;
                    } else if (i4 != 3) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                }
            } else {
                i3 = 1;
            }
            VideoOptions videoOptionsBuild = new VideoOptions.Builder().setStartMuted(this.requestOptions.hasKey("startVideoMuted") ? this.requestOptions.getBoolean("startVideoMuted") : true).build();
            Intrinsics.checkNotNullExpressionValue(videoOptionsBuild, "build(...)");
            NativeAdOptions nativeAdOptionsBuild = new NativeAdOptions.Builder().setMediaAspectRatio(i).setAdChoicesPlacement(i3).setVideoOptions(videoOptionsBuild).build();
            Intrinsics.checkNotNullExpressionValue(nativeAdOptionsBuild, "build(...)");
            AdLoader adLoaderBuild = new AdLoader.Builder(this.this$0.getReactApplicationContext(), this.adUnitId).withNativeAdOptions(nativeAdOptionsBuild).withAdListener(this.adListener).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public final void onNativeAdLoaded(NativeAd nativeAd) {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.loadAd$lambda$1(this.f$0, loadedListener, nativeAd);
                }
            }).build();
            Intrinsics.checkNotNullExpressionValue(adLoaderBuild, "build(...)");
            adLoaderBuild.loadAd(ReactNativeGoogleMobileAdsCommon.buildAdRequest(this.requestOptions));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void loadAd$lambda$1(final NativeAdHolder nativeAdHolder, NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener, NativeAd nativeAd) {
            VideoController videoController;
            Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
            nativeAdHolder.nativeAd = nativeAd;
            MediaContent mediaContent = nativeAd.getMediaContent();
            if (mediaContent != null && (videoController = mediaContent.getVideoController()) != null) {
                videoController.setVideoLifecycleCallbacks(nativeAdHolder.videoLifecycleCallbacks);
            }
            nativeAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsNativeModule$NativeAdHolder$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.ads.OnPaidEventListener
                public final void onPaidEvent(AdValue adValue) {
                    ReactNativeGoogleMobileAdsNativeModule.NativeAdHolder.loadAd$lambda$1$lambda$0(this.f$0, adValue);
                }
            });
            onNativeAdLoadedListener.onNativeAdLoaded(nativeAd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void loadAd$lambda$1$lambda$0(NativeAdHolder nativeAdHolder, AdValue adValue) {
            Intrinsics.checkNotNullParameter(adValue, "adValue");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("value", adValue.getValueMicros() * 1.0E-6d);
            writableMapCreateMap.putInt("precision", adValue.getPrecisionType());
            writableMapCreateMap.putString(FirebaseAnalytics.Param.CURRENCY, adValue.getCurrencyCode());
            nativeAdHolder.emitAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_PAID, writableMapCreateMap);
        }

        public final void destroy() {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                nativeAd.destroy();
            }
            this.nativeAd = null;
        }

        static /* synthetic */ void emitAdEvent$default(NativeAdHolder nativeAdHolder, String str, ReadableMap readableMap, int i, Object obj) {
            if ((i & 2) != 0) {
                readableMap = null;
            }
            nativeAdHolder.emitAdEvent(str, readableMap);
        }

        private final void emitAdEvent(String type, ReadableMap eventData) {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd == null) {
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            if (eventData != null) {
                writableMapCreateMap.merge(eventData);
            }
            ResponseInfo responseInfo = nativeAd.getResponseInfo();
            writableMapCreateMap.putString("responseId", responseInfo != null ? responseInfo.getResponseId() : null);
            writableMapCreateMap.putString("type", type);
            this.this$0.emitOnAdEvent(writableMapCreateMap);
        }
    }
}
