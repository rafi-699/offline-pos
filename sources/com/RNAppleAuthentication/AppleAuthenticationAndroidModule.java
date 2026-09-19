package com.RNAppleAuthentication;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppleAuthenticationAndroidModule extends ReactContextBaseJavaModule {
    private static final String E_NOT_CONFIGURED_ERROR = "E_NOT_CONFIGURED_ERROR";
    private static final String E_SIGNIN_CANCELLED_ERROR = "E_SIGNIN_CANCELLED_ERROR";
    private static final String E_SIGNIN_FAILED_ERROR = "E_SIGNIN_FAILED_ERROR";
    private SignInWithAppleConfiguration configuration;
    private final ReactApplicationContext reactContext;

    public AppleAuthenticationAndroidModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNAppleAuthModuleAndroid";
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            stringBuffer.append(Character.forDigit(bArr[i] & Ascii.SI, 16));
        }
        return stringBuffer.toString();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("ALL", SignInWithAppleConfiguration.ResponseType.ALL.toString());
        map.put("CODE", SignInWithAppleConfiguration.ResponseType.CODE.toString());
        map.put("ID_TOKEN", SignInWithAppleConfiguration.ResponseType.ID_TOKEN.toString());
        HashMap map2 = new HashMap();
        map2.put("ALL", SignInWithAppleConfiguration.Scope.ALL.toString());
        map2.put("EMAIL", SignInWithAppleConfiguration.Scope.EMAIL.toString());
        map2.put("NAME", SignInWithAppleConfiguration.Scope.NAME.toString());
        HashMap map3 = new HashMap();
        map3.put(E_NOT_CONFIGURED_ERROR, E_NOT_CONFIGURED_ERROR);
        map3.put(E_SIGNIN_FAILED_ERROR, E_SIGNIN_FAILED_ERROR);
        map3.put(E_SIGNIN_CANCELLED_ERROR, E_SIGNIN_CANCELLED_ERROR);
        map3.put("ResponseType", map);
        map3.put("Scope", map2);
        map3.put("isSupported", true);
        return map3;
    }

    private FragmentManager getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        return ((FragmentActivity) currentActivity).getSupportFragmentManager();
    }

    @ReactMethod
    public void configure(ReadableMap readableMap) {
        String strBytesToHex;
        String string;
        String string2;
        String string3;
        SignInWithAppleConfiguration.Scope scopeValueOf = SignInWithAppleConfiguration.Scope.ALL;
        SignInWithAppleConfiguration.ResponseType responseType = SignInWithAppleConfiguration.ResponseType.ALL;
        String string4 = UUID.randomUUID().toString();
        Boolean boolValueOf = Boolean.valueOf(readableMap.hasKey("nonceEnabled") ? readableMap.getBoolean("nonceEnabled") : true);
        Boolean boolValueOf2 = Boolean.valueOf(readableMap.hasKey("fullScreen") ? readableMap.getBoolean("fullScreen") : true);
        String str = "";
        String string5 = readableMap.hasKey("clientId") ? readableMap.getString("clientId") : "";
        String string6 = readableMap.hasKey("redirectUri") ? readableMap.getString("redirectUri") : "";
        if (readableMap.hasKey("scope") && (string3 = readableMap.getString("scope")) != null) {
            scopeValueOf = SignInWithAppleConfiguration.Scope.valueOf(string3);
        }
        if (readableMap.hasKey("responseType") && (string2 = readableMap.getString("responseType")) != null) {
            SignInWithAppleConfiguration.ResponseType.valueOf(string2);
        }
        if (readableMap.hasKey(ServerProtocol.DIALOG_PARAM_STATE)) {
            string4 = readableMap.getString(ServerProtocol.DIALOG_PARAM_STATE);
        }
        if (boolValueOf.booleanValue()) {
            if (readableMap.hasKey("nonce")) {
                string = readableMap.getString("nonce");
            } else {
                string = UUID.randomUUID().toString();
            }
            str = string;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                strBytesToHex = bytesToHex(messageDigest.digest());
            } catch (Exception unused) {
                strBytesToHex = str;
            }
        } else {
            strBytesToHex = str;
        }
        this.configuration = new SignInWithAppleConfiguration.Builder().clientId(string5).redirectUri(string6).responseType(SignInWithAppleConfiguration.ResponseType.ALL).scope(scopeValueOf).state(string4).rawNonce(str).nonce(strBytesToHex).fullScreen(boolValueOf2.booleanValue()).build();
    }

    @ReactMethod
    public void signIn(final Promise promise) {
        if (this.configuration == null) {
            promise.reject(E_NOT_CONFIGURED_ERROR);
            return;
        }
        FragmentManager fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            promise.reject(E_NOT_CONFIGURED_ERROR);
            return;
        }
        final SignInWithAppleService signInWithAppleService = new SignInWithAppleService(fragmentManagerHelper, "SignInWithAppleButton-$id-SignInWebViewDialogFragment", this.configuration, new SignInWithAppleCallback() { // from class: com.RNAppleAuthentication.AppleAuthenticationAndroidModule.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleSuccess(String str, String str2, String str3, String str4) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("code", str);
                writableMapCreateMap.putString("id_token", str2);
                writableMapCreateMap.putString(ServerProtocol.DIALOG_PARAM_STATE, str3);
                String rawNonce = AppleAuthenticationAndroidModule.this.configuration.getRawNonce();
                if (!rawNonce.isEmpty()) {
                    writableMapCreateMap.putString("nonce", rawNonce);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    if (jSONObject.has("name")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("name");
                        WritableMap writableMapCreateMap3 = Arguments.createMap();
                        if (jSONObject2.has("firstName")) {
                            writableMapCreateMap3.putString("firstName", jSONObject2.getString("firstName"));
                        }
                        if (jSONObject2.has("lastName")) {
                            writableMapCreateMap3.putString("lastName", jSONObject2.getString("lastName"));
                        }
                        if (writableMapCreateMap3.hasKey("firstName") || writableMapCreateMap3.hasKey("lastName")) {
                            writableMapCreateMap2.putMap("name", writableMapCreateMap3);
                        }
                    }
                    if (jSONObject.has("email")) {
                        writableMapCreateMap2.putString("email", jSONObject.getString("email"));
                    }
                    if (writableMapCreateMap2.hasKey("name") || writableMapCreateMap2.hasKey("email")) {
                        writableMapCreateMap.putMap("user", writableMapCreateMap2);
                    }
                } catch (Exception unused) {
                }
                promise.resolve(writableMapCreateMap);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleFailure(Throwable th) {
                promise.reject(AppleAuthenticationAndroidModule.E_SIGNIN_FAILED_ERROR, th);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleCallback
            public void onSignInWithAppleCancel() {
                promise.reject(AppleAuthenticationAndroidModule.E_SIGNIN_CANCELLED_ERROR);
            }
        });
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(new RuntimeException("Activity is not found"));
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.RNAppleAuthentication.AppleAuthenticationAndroidModule.2
                @Override // java.lang.Runnable
                public void run() {
                    signInWithAppleService.show();
                }
            });
        }
    }
}
