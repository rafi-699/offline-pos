package io.invertase.googlemobileads;

import android.app.Activity;
import android.content.ContextWrapper;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¨\u0006\u001b"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "buildRequestConfiguration", "Lcom/google/android/gms/ads/RequestConfiguration;", "requestConfiguration", "Lcom/facebook/react/bridge/ReadableMap;", "initialize", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "setRequestConfiguration", "openAdInspector", "openDebugMenu", OutOfContextTestingActivity.AD_UNIT_KEY, "setAppVolume", "volume", "", "setAppMuted", "muted", "", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNGoogleMobileAdsModule";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGoogleMobileAdsModule";
    }

    private final RequestConfiguration buildRequestConfiguration(ReadableMap requestConfiguration) {
        String string;
        RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
        if (requestConfiguration.hasKey("testDeviceIdentifiers")) {
            ReadableArray array = requestConfiguration.getArray("testDeviceIdentifiers");
            if (array == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                if (Intrinsics.areEqual(str, "EMULATOR")) {
                    str = AdRequest.DEVICE_ID_EMULATOR;
                }
                arrayList2.add(str);
            }
            builder.setTestDeviceIds(arrayList2);
        }
        if (requestConfiguration.hasKey("maxAdContentRating") && (string = requestConfiguration.getString("maxAdContentRating")) != null) {
            int iHashCode = string.hashCode();
            if (iHashCode != 71) {
                if (iHashCode != 84) {
                    if (iHashCode != 2452) {
                        if (iHashCode == 2551 && string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_PG)) {
                            builder.setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_PG);
                        }
                    } else if (string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_MA)) {
                        builder.setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_MA);
                    }
                } else if (string.equals("T")) {
                    builder.setMaxAdContentRating("T");
                }
            } else if (string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                builder.setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
            }
        }
        if (requestConfiguration.hasKey("tagForChildDirectedTreatment")) {
            builder.setTagForChildDirectedTreatment(requestConfiguration.getBoolean("tagForChildDirectedTreatment") ? 1 : 0);
        } else {
            builder.setTagForChildDirectedTreatment(-1);
        }
        if (requestConfiguration.hasKey("tagForUnderAgeOfConsent")) {
            builder.setTagForUnderAgeOfConsent(requestConfiguration.getBoolean("tagForUnderAgeOfConsent") ? 1 : 0);
        } else {
            builder.setTagForUnderAgeOfConsent(-1);
        }
        RequestConfiguration requestConfigurationBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(requestConfigurationBuild, "build(...)");
        return requestConfigurationBuild;
    }

    @ReactMethod
    public final void initialize(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ContextWrapper currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = getReactApplicationContext();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "getReactApplicationContext(...)");
        }
        MobileAds.initialize(currentActivity, new OnInitializationCompleteListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                ReactNativeGoogleMobileAdsModule.initialize$lambda$1(promise, initializationStatus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$1(Promise promise, InitializationStatus initializationStatus) {
        Intrinsics.checkNotNullParameter(initializationStatus, "initializationStatus");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Map<String, AdapterStatus> adapterStatusMap = initializationStatus.getAdapterStatusMap();
        Intrinsics.checkNotNullExpressionValue(adapterStatusMap, "getAdapterStatusMap(...)");
        for (Map.Entry<String, AdapterStatus> entry : adapterStatusMap.entrySet()) {
            String key = entry.getKey();
            AdapterStatus value = entry.getValue();
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("name", key);
            writableMapCreateMap.putInt(ServerProtocol.DIALOG_PARAM_STATE, value.getInitializationState().ordinal());
            writableMapCreateMap.putString("description", value.getDescription());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        promise.resolve(writableArrayCreateArray);
    }

    @ReactMethod
    public final void setRequestConfiguration(ReadableMap requestConfiguration, Promise promise) {
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(promise, "promise");
        MobileAds.setRequestConfiguration(buildRequestConfiguration(requestConfiguration));
        promise.resolve(null);
    }

    @ReactMethod
    public final void openAdInspector(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("null-activity", "Ad Inspector attempted to open but the current Activity was null.");
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReactNativeGoogleMobileAdsModule.openAdInspector$lambda$3(this.f$0, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAdInspector$lambda$3(ReactNativeGoogleMobileAdsModule reactNativeGoogleMobileAdsModule, final Promise promise) {
        MobileAds.openAdInspector(reactNativeGoogleMobileAdsModule.getReactApplicationContext(), new OnAdInspectorClosedListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.ads.OnAdInspectorClosedListener
            public final void onAdInspectorClosed(AdInspectorError adInspectorError) {
                ReactNativeGoogleMobileAdsModule.openAdInspector$lambda$3$lambda$2(promise, adInspectorError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAdInspector$lambda$3$lambda$2(Promise promise, AdInspectorError adInspectorError) {
        String str;
        if (adInspectorError != null) {
            int code = adInspectorError.getCode();
            if (code == 0) {
                str = "INTERNAL_ERROR";
            } else if (code == 1) {
                str = "FAILED_TO_LOAD";
            } else if (code == 2) {
                str = "NOT_IN_TEST_MODE";
            } else if (code == 3) {
                str = "ALREADY_OPEN";
            } else {
                str = "";
            }
            promise.reject(str, adInspectorError.getMessage());
            return;
        }
        promise.resolve(null);
    }

    @ReactMethod
    public final void openDebugMenu(final String adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ReactNativeGoogleMobileAdsModule.openDebugMenu$lambda$4(this.f$0, adUnit);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openDebugMenu$lambda$4(ReactNativeGoogleMobileAdsModule reactNativeGoogleMobileAdsModule, String str) {
        Activity currentActivity = reactNativeGoogleMobileAdsModule.getReactApplicationContext().getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        MobileAds.openDebugMenu(currentActivity, str);
    }

    @ReactMethod
    public final void setAppVolume(float volume) {
        MobileAds.setAppVolume(volume);
    }

    @ReactMethod
    public final void setAppMuted(boolean muted) {
        MobileAds.setAppMuted(muted);
    }
}
