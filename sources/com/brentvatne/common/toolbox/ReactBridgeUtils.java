package com.brentvatne.common.toolbox;

import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactBridgeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0007J\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\rH\u0007J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0011\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0012H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0014H\u0007J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0015\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0016H\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0012H\u0007J\"\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0007J \u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0007J\u001c\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0007J-\u0010!\u001a\u00020\r2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H\u0007¢\u0006\u0002\u0010#J<\u0010$\u001a\u00020\r2\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001b2\u0018\u0010&\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001bH\u0007¨\u0006'"}, d2 = {"Lcom/brentvatne/common/toolbox/ReactBridgeUtils;", "", "<init>", "()V", "safeGetString", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", SDKConstants.PARAM_KEY, "fallback", "safeGetDynamic", "Lcom/facebook/react/bridge/Dynamic;", "safeGetBool", "", "safeGetMap", "safeGetArray", "Lcom/facebook/react/bridge/ReadableArray;", "safeGetInt", "", "safeGetDouble", "", "safeGetFloat", "", "safeParseInt", "value", Constants.COLLATION_DEFAULT, "toStringMap", "", "readableMap", "toIntMap", "safeStringEquals", "str1", "str2", "safeStringArrayEquals", "", "([Ljava/lang/String;[Ljava/lang/String;)Z", "safeStringMapEquals", "first", "second", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactBridgeUtils {
    public static final ReactBridgeUtils INSTANCE = new ReactBridgeUtils();

    private ReactBridgeUtils() {
    }

    @JvmStatic
    public static final String safeGetString(ReadableMap map, String key, String fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return map.getString(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final String safeGetString(ReadableMap map, String key) {
        return safeGetString(map, key, null);
    }

    @JvmStatic
    public static final Dynamic safeGetDynamic(ReadableMap map, String key, Dynamic fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return map.getDynamic(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final Dynamic safeGetDynamic(ReadableMap map, String key) {
        return safeGetDynamic(map, key, null);
    }

    @JvmStatic
    public static final boolean safeGetBool(ReadableMap map, String key, boolean fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return map.getBoolean(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final ReadableMap safeGetMap(ReadableMap map, String key) {
        if (map == null) {
            return null;
        }
        Intrinsics.checkNotNull(key);
        if (!map.hasKey(key) || map.isNull(key)) {
            return null;
        }
        return map.getMap(key);
    }

    @JvmStatic
    public static final ReadableArray safeGetArray(ReadableMap map, String key) {
        if (map == null) {
            return null;
        }
        Intrinsics.checkNotNull(key);
        if (!map.hasKey(key) || map.isNull(key)) {
            return null;
        }
        return map.getArray(key);
    }

    @JvmStatic
    public static final int safeGetInt(ReadableMap map, String key, int fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return map.getInt(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final int safeGetInt(ReadableMap map, String key) {
        return safeGetInt(map, key, 0);
    }

    @JvmStatic
    public static final double safeGetDouble(ReadableMap map, String key, double fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return map.getDouble(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final double safeGetDouble(ReadableMap map, String key) {
        return safeGetDouble(map, key, ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE);
    }

    @JvmStatic
    public static final float safeGetFloat(ReadableMap map, String key, float fallback) {
        if (map != null) {
            Intrinsics.checkNotNull(key);
            if (map.hasKey(key) && !map.isNull(key)) {
                return (float) map.getDouble(key);
            }
        }
        return fallback;
    }

    @JvmStatic
    public static final float safeGetFloat(ReadableMap map, String key) {
        return safeGetFloat(map, key, 0.0f);
    }

    @JvmStatic
    public static final int safeParseInt(String value, int i) {
        if (value == null) {
            return i;
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception unused) {
            return i;
        }
    }

    @JvmStatic
    public static final Map<String, String> toStringMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        if (!readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            return null;
        }
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, readableMap.getString(strNextKey));
        }
        return map;
    }

    @JvmStatic
    public static final Map<String, Integer> toIntMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        if (!readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            return null;
        }
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, Integer.valueOf(readableMap.getInt(strNextKey)));
        }
        return map;
    }

    @JvmStatic
    public static final boolean safeStringEquals(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return Intrinsics.areEqual(str1, str2);
    }

    @JvmStatic
    public static final boolean safeStringArrayEquals(String[] str1, String[] str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null || str1.length != str2.length) {
            return false;
        }
        int length = str1.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str1[i], str2[i])) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean safeStringMapEquals(Map<String, String> first, Map<String, String> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null || first.size() != second.size()) {
            return false;
        }
        for (String str : first.keySet()) {
            if (!safeStringEquals(first.get(str), second.get(str))) {
                return false;
            }
        }
        return true;
    }
}
