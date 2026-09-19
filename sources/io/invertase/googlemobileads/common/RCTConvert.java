package io.invertase.googlemobileads.common;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class RCTConvert {
    private static String TAG = "RCTConvert";

    public static WritableMap mapPutValue(String str, @Nullable Object obj, WritableMap writableMap) {
        if (obj == null) {
            writableMap.putNull(str);
            return writableMap;
        }
        String name = obj.getClass().getName();
        name.hashCode();
        switch (name) {
            case "java.lang.Integer":
                writableMap.putInt(str, ((Integer) obj).intValue());
                break;
            case "java.lang.Float":
                writableMap.putDouble(str, ((Float) obj).floatValue());
                break;
            case "java.lang.Boolean":
                writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
                break;
            case "java.lang.Long":
                writableMap.putDouble(str, ((Long) obj).longValue());
                break;
            case "java.lang.Double":
                writableMap.putDouble(str, ((Double) obj).doubleValue());
                break;
            case "java.lang.String":
                writableMap.putString(str, (String) obj);
                break;
            case "org.json.JSONObject$1":
                writableMap.putString(str, obj.toString());
                break;
            default:
                if (List.class.isAssignableFrom(obj.getClass())) {
                    writableMap.putArray(str, Arguments.makeNativeArray((List<?>) obj));
                    break;
                } else {
                    if (Map.class.isAssignableFrom(obj.getClass())) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            mapPutValue((String) entry.getKey(), entry.getValue(), writableMapCreateMap);
                        }
                        writableMap.putMap(str, writableMapCreateMap);
                    } else {
                        Log.d(TAG, "utils:mapPutValue:unknownType:" + name);
                        writableMap.putNull(str);
                    }
                    break;
                }
                break;
        }
        return writableMap;
    }

    public static WritableMap readableMapToWritableMap(ReadableMap readableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.merge(readableMap);
        return writableMapCreateMap;
    }

    public static Map<String, Object> toHashMap(ReadableMap readableMap) {
        return readableMap.toHashMap();
    }

    public static List<Object> toArrayList(ReadableArray readableArray) {
        return readableArray.toArrayList();
    }
}
