package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DolewaEventEmitter.kt */
/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = "DolewaEventEmitter")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/DolewaEventEmitter;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "ctx", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "addListener", "", "eventName", "removeListeners", "count", "", "eventReceiver", "Landroid/content/BroadcastReceiver;", "initialize", "invalidate", "sendEvent", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/facebook/react/bridge/WritableMap;", "toWritableMap", "map", "", "toWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "list", "", "Companion", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DolewaEventEmitter extends ReactContextBaseJavaModule {
    private static final String ACTION_EVENT_EMITTED = "event-emitted";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ReactApplicationContext ctx;
    private final BroadcastReceiver eventReceiver;

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DolewaEventEmitter(ReactApplicationContext ctx) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        this.eventReceiver = new BroadcastReceiver() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.DolewaEventEmitter$eventReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Serializable serializableExtra;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String stringExtra = intent.getStringExtra("name");
                if (stringExtra == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    serializableExtra = intent.getSerializableExtra("payload", Serializable.class);
                } else {
                    serializableExtra = intent.getSerializableExtra("payload");
                }
                if (serializableExtra instanceof Map) {
                    DolewaEventEmitter dolewaEventEmitter = this.this$0;
                    dolewaEventEmitter.sendEvent(stringExtra, dolewaEventEmitter.toWritableMap((Map) serializableExtra));
                }
            }
        };
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DolewaEventEmitter";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        LocalBroadcastManager.getInstance(getReactApplicationContext()).registerReceiver(this.eventReceiver, new IntentFilter(ACTION_EVENT_EMITTED));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        LocalBroadcastManager.getInstance(getReactApplicationContext()).unregisterReceiver(this.eventReceiver);
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String eventName, WritableMap params) {
        if (getReactApplicationContext().hasActiveReactInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, params);
        }
    }

    /* JADX INFO: compiled from: DolewaEventEmitter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/DolewaEventEmitter$Companion;", "", "<init>", "()V", "ACTION_EVENT_EMITTED", "", "emitEvent", "", "context", "Landroid/content/Context;", "name", "payload", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void emitEvent$default(Companion companion, Context context, String str, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            companion.emitEvent(context, str, map);
        }

        public final void emitEvent(Context context, String name, Map<String, ? extends Object> payload) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(payload, "payload");
            Intent intent = new Intent(DolewaEventEmitter.ACTION_EVENT_EMITTED);
            intent.putExtra("name", name);
            intent.putExtra("payload", new HashMap(payload));
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WritableMap toWritableMap(Map<?, ?> map) {
        String string;
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && (string = key.toString()) != null) {
                if (value == null) {
                    writableMapCreateMap.putNull(string);
                } else if (value instanceof String) {
                    writableMapCreateMap.putString(string, (String) value);
                } else if (value instanceof Boolean) {
                    writableMapCreateMap.putBoolean(string, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    writableMapCreateMap.putInt(string, ((Number) value).intValue());
                } else if (value instanceof Double) {
                    writableMapCreateMap.putDouble(string, ((Number) value).doubleValue());
                } else if (value instanceof Float) {
                    writableMapCreateMap.putDouble(string, ((Number) value).floatValue());
                } else if (value instanceof Long) {
                    writableMapCreateMap.putDouble(string, ((Number) value).longValue());
                } else if (value instanceof Number) {
                    writableMapCreateMap.putDouble(string, ((Number) value).doubleValue());
                } else if (value instanceof Map) {
                    writableMapCreateMap.putMap(string, toWritableMap((Map) value));
                } else if (value instanceof List) {
                    writableMapCreateMap.putArray(string, toWritableArray((List) value));
                } else {
                    writableMapCreateMap.putString(string, value.toString());
                }
            }
        }
        return writableMapCreateMap;
    }

    private final WritableArray toWritableArray(List<?> list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Object obj : list) {
            if (obj == null) {
                writableArrayCreateArray.pushNull();
            } else if (obj instanceof String) {
                writableArrayCreateArray.pushString((String) obj);
            } else if (obj instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableArrayCreateArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Double) {
                writableArrayCreateArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                writableArrayCreateArray.pushDouble(((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                writableArrayCreateArray.pushDouble(((Number) obj).longValue());
            } else if (obj instanceof Number) {
                writableArrayCreateArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Map) {
                writableArrayCreateArray.pushMap(toWritableMap((Map) obj));
            } else if (obj instanceof List) {
                writableArrayCreateArray.pushArray(toWritableArray((List) obj));
            } else {
                writableArrayCreateArray.pushString(obj.toString());
            }
        }
        return writableArrayCreateArray;
    }
}
