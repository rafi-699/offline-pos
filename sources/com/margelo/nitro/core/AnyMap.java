package com.margelo.nitro.core;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.jni.HybridData;
import dalvik.annotation.optimization.FastNative;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\rJ\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\t\u0010\u0016\u001a\u00020\u000fH\u0087 J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0086 ¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010 \u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010#\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0011\u0010&\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0086 J \u0010'\u001a\f\u0012\u0004\u0012\u00020(0\u0018j\u0002`)2\u0006\u0010\u0010\u001a\u00020\rH\u0086 ¢\u0006\u0002\u0010*J!\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020(0\fj\u0002`,2\u0006\u0010\u0010\u001a\u00020\rH\u0086 J\u0011\u0010-\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\rH\u0082 J\u0011\u0010.\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0087 J\u0019\u0010/\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\"H\u0087 J\u0019\u00100\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0014H\u0087 J\u0019\u00101\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020%H\u0087 J\u0019\u00102\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0087 J(\u00103\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020(0\u0018j\u0002`)H\u0086 ¢\u0006\u0002\u00104J)\u00105\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020(0\fj\u0002`,H\u0086 J\u0019\u00106\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020(H\u0082 J\u0011\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0000H\u0086 J\t\u00109\u001a\u00020\bH\u0082 J\u0011\u00109\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/margelo/nitro/core/AnyMap;", "", "<init>", "()V", "preallocatedSize", "", "(I)V", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "toMap", "", "", "setAny", "", SDKConstants.PARAM_KEY, "value", "getAny", "contains", "", "remove", "clear", "getAllKeys", "", "()[Ljava/lang/String;", "isNull", "isDouble", "isBoolean", "isBigInt", "isString", "isArray", "isObject", "getDouble", "", "getBoolean", "getBigInt", "", "getString", "getAnyArray", "Lcom/margelo/nitro/core/AnyValue;", "Lcom/margelo/nitro/core/AnyArray;", "(Ljava/lang/String;)[Lcom/margelo/nitro/core/AnyValue;", "getAnyObject", "Lcom/margelo/nitro/core/AnyObject;", "getAnyValue", "setNull", "setDouble", "setBoolean", "setBigInt", "setString", "setAnyArray", "(Ljava/lang/String;[Lcom/margelo/nitro/core/AnyValue;)V", "setAnyObject", "setAnyValue", "merge", "other", "initHybrid", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyMap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    private final native AnyValue getAnyValue(String key);

    private final native HybridData initHybrid();

    private final native HybridData initHybrid(int preallocatedSize);

    private final native void setAnyValue(String key, AnyValue value);

    @FastNative
    public final native void clear();

    @FastNative
    public final native boolean contains(String key);

    public final native String[] getAllKeys();

    public final native AnyValue[] getAnyArray(String key);

    public final native Map<String, AnyValue> getAnyObject(String key);

    @FastNative
    public final native long getBigInt(String key);

    @FastNative
    public final native boolean getBoolean(String key);

    @FastNative
    public final native double getDouble(String key);

    public final native String getString(String key);

    @FastNative
    public final native boolean isArray(String key);

    @FastNative
    public final native boolean isBigInt(String key);

    @FastNative
    public final native boolean isBoolean(String key);

    @FastNative
    public final native boolean isDouble(String key);

    @FastNative
    public final native boolean isNull(String key);

    @FastNative
    public final native boolean isObject(String key);

    @FastNative
    public final native boolean isString(String key);

    public final native void merge(AnyMap other);

    @FastNative
    public final native void remove(String key);

    public final native void setAnyArray(String key, AnyValue[] value);

    public final native void setAnyObject(String key, Map<String, AnyValue> value);

    @FastNative
    public final native void setBigInt(String key, long value);

    @FastNative
    public final native void setBoolean(String key, boolean value);

    @FastNative
    public final native void setDouble(String key, double value);

    @FastNative
    public final native void setNull(String key);

    @FastNative
    public final native void setString(String key, String value);

    public AnyMap() {
        this.mHybridData = initHybrid();
    }

    public AnyMap(int i) {
        this.mHybridData = initHybrid(i);
    }

    private AnyMap(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* JADX INFO: compiled from: AnyMap.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/margelo/nitro/core/AnyMap$Companion;", "", "<init>", "()V", "fromMap", "Lcom/margelo/nitro/core/AnyMap;", "map", "", "", "ignoreIncompatible", "", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ AnyMap fromMap$default(Companion companion, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromMap(map, z);
        }

        public final AnyMap fromMap(Map<String, ? extends Object> map, boolean ignoreIncompatible) {
            Intrinsics.checkNotNullParameter(map, "map");
            AnyMap anyMap = new AnyMap(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                try {
                    anyMap.setAny(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    if (!ignoreIncompatible) {
                        throw th;
                    }
                }
            }
            return anyMap;
        }
    }

    public final Map<String, Object> toMap() {
        HashMap map = new HashMap();
        for (String str : getAllKeys()) {
            map.put(str, getAny(str));
        }
        return map;
    }

    public final void setAny(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setAnyValue(key, AnyValue.INSTANCE.fromAny(value));
    }

    public final Object getAny(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getAnyValue(key).toAny();
    }
}
