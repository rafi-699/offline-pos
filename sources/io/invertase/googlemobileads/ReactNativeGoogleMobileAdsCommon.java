package io.invertase.googlemobileads;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import io.invertase.googlemobileads.common.ReactNativeAdView;
import io.invertase.googlemobileads.common.ReactNativeEventEmitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeGoogleMobileAdsCommon {
    static AdSize getAdSizeForAdaptiveBanner(String str, ViewGroup viewGroup) {
        try {
            Display defaultDisplay = ((Activity) Objects.requireNonNull(((ReactContext) viewGroup.getContext()).getCurrentActivity())).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float adWidth = ((ReactNativeAdView) viewGroup).getAdWidth();
            int iMin = (int) (displayMetrics.widthPixels / displayMetrics.density);
            if (adWidth > 0.0f) {
                iMin = Math.min(Math.round(adWidth), iMin);
            }
            float maxAdHeight = ((ReactNativeAdView) viewGroup).getMaxAdHeight();
            if ("INLINE_ADAPTIVE_BANNER".equals(str)) {
                if (maxAdHeight > 0.0f) {
                    return AdSize.getInlineAdaptiveBannerAdSize(iMin, Math.round(Math.max(maxAdHeight, 32.0f)));
                }
                return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(viewGroup.getContext(), iMin);
            }
            if ("LARGE_ANCHORED_ADAPTIVE_BANNER".equals(str)) {
                return AdSize.getLargeAnchoredAdaptiveBannerAdSize(viewGroup.getContext(), iMin);
            }
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(viewGroup.getContext(), iMin);
        } catch (Exception unused) {
            return AdSize.BANNER;
        }
    }

    static AdSize getAdSize(String str, ViewGroup viewGroup) {
        if (str.matches("ANCHORED_ADAPTIVE_BANNER|LARGE_ANCHORED_ADAPTIVE_BANNER|INLINE_ADAPTIVE_BANNER")) {
            return getAdSizeForAdaptiveBanner(str, viewGroup);
        }
        return stringToAdSize(str);
    }

    static AdSize stringToAdSize(String str) {
        Matcher matcher = Pattern.compile("([0-9]+)x([0-9]+)").matcher(str);
        if (matcher.find()) {
            return new AdSize(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
        String upperCase = str.toUpperCase();
        switch (upperCase.hashCode()) {
            case -1966536496:
                if (upperCase.equals("LARGE_BANNER")) {
                    return AdSize.LARGE_BANNER;
                }
                break;
            case -1008851236:
                if (upperCase.equals("FULL_BANNER")) {
                    return AdSize.FULL_BANNER;
                }
                break;
            case -96588539:
                if (upperCase.equals("MEDIUM_RECTANGLE")) {
                    return AdSize.MEDIUM_RECTANGLE;
                }
                break;
            case -14796567:
                if (upperCase.equals("WIDE_SKYSCRAPER")) {
                    return AdSize.WIDE_SKYSCRAPER;
                }
                break;
            case 66994602:
                if (upperCase.equals("FLUID")) {
                    return AdSize.FLUID;
                }
                break;
            case 446888797:
                if (upperCase.equals("LEADERBOARD")) {
                    return AdSize.LEADERBOARD;
                }
                break;
            case 1951953708:
                upperCase.equals("BANNER");
                break;
        }
        return AdSize.BANNER;
    }

    static WritableMap errorCodeToMap(int i) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i == 0) {
            writableMapCreateMap.putString("code", "error-code-internal-error");
            writableMapCreateMap.putString("message", "Something happened internally; for instance, an invalid response was received from the ad server.");
            return writableMapCreateMap;
        }
        if (i == 1) {
            writableMapCreateMap.putString("code", "error-code-invalid-request");
            writableMapCreateMap.putString("message", "The ad request was invalid; for instance, the ad unit ID was incorrect.");
            return writableMapCreateMap;
        }
        if (i == 2) {
            writableMapCreateMap.putString("code", "error-code-network-error");
            writableMapCreateMap.putString("message", "The ad request was unsuccessful due to network connectivity.");
            return writableMapCreateMap;
        }
        if (i != 3) {
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("code", "error-code-no-fill");
        writableMapCreateMap.putString("message", "The ad request was successful, but no ad was returned due to lack of ad inventory.");
        return writableMapCreateMap;
    }

    public static AdManagerAdRequest buildAdRequest(ReadableMap readableMap) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("requestNonPersonalizedAdsOnly") && readableMap.getBoolean("requestNonPersonalizedAdsOnly")) {
            bundle.putString("npa", "1");
        }
        if (readableMap.hasKey("networkExtras")) {
            for (Map.Entry<String, Object> entry : readableMap.getMap("networkExtras").toHashMap().entrySet()) {
                bundle.putString(entry.getKey(), (String) entry.getValue());
            }
        }
        if (readableMap.hasKey("publisherProvidedSignals")) {
            ReadableMap map = readableMap.getMap("publisherProvidedSignals");
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                ReadableArray array = map.getArray(strNextKey);
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    arrayList.add(Integer.valueOf(array.getInt(i)));
                }
                bundle.putIntegerArrayList(strNextKey, arrayList);
            }
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        if (readableMap.hasKey("keywords")) {
            Iterator<Object> it = ((ReadableArray) Objects.requireNonNull(readableMap.getArray("keywords"))).toArrayList().iterator();
            while (it.hasNext()) {
                builder.addKeyword((String) it.next());
            }
        }
        if (readableMap.hasKey("contentUrl")) {
            builder.setContentUrl((String) Objects.requireNonNull(readableMap.getString("contentUrl")));
        }
        if (readableMap.hasKey("neighboringContentUrls")) {
            ReadableArray readableArray = (ReadableArray) Objects.requireNonNull(readableMap.getArray("neighboringContentUrls"));
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                arrayList2.add(readableArray.getString(i2));
            }
            builder.setNeighboringContentUrls(arrayList2);
        }
        if (readableMap.hasKey("requestAgent")) {
            builder.setRequestAgent((String) Objects.requireNonNull(readableMap.getString("requestAgent")));
        }
        if (readableMap.hasKey("customTargeting")) {
            for (Map.Entry<String, Object> entry2 : readableMap.getMap("customTargeting").toHashMap().entrySet()) {
                String key = entry2.getKey();
                Object value = entry2.getValue();
                if (value instanceof String) {
                    builder.addCustomTargeting(key, (String) value);
                } else {
                    builder.addCustomTargeting(key, (ArrayList) value);
                }
            }
        }
        if (readableMap.hasKey("publisherProvidedId")) {
            builder.setPublisherProvidedId((String) Objects.requireNonNull(readableMap.getString("publisherProvidedId")));
        }
        return builder.build();
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", str2);
        if (writableMap != null) {
            writableMapCreateMap.putMap("error", writableMap);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, writableMapCreateMap));
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap, @Nullable WritableMap writableMap2) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", str2);
        if (writableMap != null) {
            writableMapCreateMap.putMap("error", writableMap);
        }
        if (writableMap2 != null) {
            writableMapCreateMap.putMap("data", writableMap2);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, writableMapCreateMap));
    }

    public static String[] getCodeAndMessageFromAdError(AdError adError) {
        String str;
        String message = adError.getMessage();
        int code = adError.getCode();
        if (code == 0) {
            str = "internal-error";
        } else if (code == 1) {
            str = "invalid-request";
        } else if (code == 2) {
            str = "network-error";
        } else if (code != 3) {
            switch (code) {
                case 8:
                    str = "app-id-missing";
                    break;
                case 9:
                    str = "mediation-no-fill";
                    break;
                case 10:
                    str = "request-id-mismatch";
                    break;
                case 11:
                    str = "invalid-ad-string";
                    break;
                default:
                    str = "unknown";
                    break;
            }
        } else {
            str = "no-fill";
        }
        return new String[]{str, message};
    }

    public static boolean isAdManagerUnit(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(DomExceptionUtils.SEPARATOR);
    }
}
