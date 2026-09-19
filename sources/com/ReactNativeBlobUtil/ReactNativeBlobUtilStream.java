package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.load.Key;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = "base64";
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    void readStream(String str, String str2, int i, int i2, String str3, ReactApplicationContext reactApplicationContext) {
        ?? r12;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String str4 = strNormalizePath != null ? strNormalizePath : str;
        try {
            try {
                int i3 = str2.equalsIgnoreCase("base64") ? 4095 : 4096;
                if (i > 0) {
                    i3 = i;
                }
                InputStream inputStreamOpenInputStream = (strNormalizePath == null || !str4.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) ? strNormalizePath == null ? ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str4)) : new FileInputStream(new File(str4)) : ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str4.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                r12 = -1;
                int i4 = -1;
                int i5 = 0;
                try {
                    if (str2.equalsIgnoreCase(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenInputStream, Charset.forName(Key.STRING_CHARSET_NAME));
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, i3);
                        char[] cArr = new char[i3];
                        while (true) {
                            int i6 = bufferedReader.read(cArr, i5, i3);
                            if (i6 == i4) {
                                break;
                            }
                            emitStreamEvent(str3, "data", new String(cArr, i5, i6));
                            if (i2 > 0) {
                                SystemClock.sleep(i2);
                            }
                            i4 = -1;
                            i5 = 0;
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                    } else {
                        if (!str2.equalsIgnoreCase("ascii")) {
                            if (str2.equalsIgnoreCase("base64")) {
                                byte[] bArr = new byte[i3];
                                while (true) {
                                    int i7 = inputStreamOpenInputStream.read(bArr);
                                    if (i7 == -1) {
                                        break;
                                    }
                                    if (i7 < i3) {
                                        byte[] bArr2 = new byte[i7];
                                        System.arraycopy(bArr, 0, bArr2, 0, i7);
                                        emitStreamEvent(str3, "data", Base64.encodeToString(bArr2, 2));
                                    } else {
                                        emitStreamEvent(str3, "data", Base64.encodeToString(bArr, 2));
                                    }
                                    if (i2 > 0) {
                                        String str5 = str4;
                                        SystemClock.sleep(i2);
                                        str4 = str5;
                                    }
                                }
                            } else {
                                r12 = str4;
                                emitStreamEvent(str3, "error", "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                            }
                            inputStreamOpenInputStream.close();
                        }
                        byte[] bArr3 = new byte[i3];
                        while (true) {
                            int i8 = inputStreamOpenInputStream.read(bArr3);
                            if (i8 == -1) {
                                break;
                            }
                            WritableArray writableArrayCreateArray = Arguments.createArray();
                            for (int i9 = 0; i9 < i8; i9++) {
                                writableArrayCreateArray.pushInt(bArr3[i9]);
                            }
                            emitStreamEvent(str3, "data", writableArrayCreateArray);
                            if (i2 > 0) {
                                SystemClock.sleep(i2);
                            }
                        }
                    }
                    r12 = str4;
                    emitStreamEvent(str3, "end", "");
                    inputStreamOpenInputStream.close();
                } catch (FileNotFoundException unused) {
                    emitStreamEvent(str3, "error", "ENOENT", "No such file '" + r12 + "'");
                }
            } catch (FileNotFoundException unused2) {
                r12 = str4;
            }
        } catch (Exception e) {
            emitStreamEvent(str3, "error", "EUNSPECIFIED", "Failed to convert data to " + str2 + " encoded string. This might be because this encoding cannot be used for this data.");
            e.printStackTrace();
        }
    }

    void writeStream(String str, String str2, boolean z, Callback callback) {
        OutputStream outputStreamOpenOutputStream;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (strNormalizePath != null) {
            str = strNormalizePath;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (strNormalizePath == null || file.exists()) {
                if (file.isDirectory()) {
                    callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                    return;
                }
            } else if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                return;
            } else if (!file.createNewFile()) {
                callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                return;
            }
            if (strNormalizePath == null || !str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
                outputStreamOpenOutputStream = strNormalizePath == null ? ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openOutputStream(Uri.parse(str)) : new FileOutputStream(str, z);
            } else {
                outputStreamOpenOutputStream = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).createOutputStream();
            }
            this.encoding = str2;
            String string = UUID.randomUUID().toString();
            fileStreams.put(string, this);
            this.writeStreamInstance = outputStreamOpenOutputStream;
            callback.invoke(null, null, string);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> map = fileStreams;
            OutputStream outputStream = map.get(str).writeStreamInstance;
            map.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString("detail", str3);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putArray("detail", writableArray);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString("code", str3);
        writableMapCreateMap.putString("detail", str4);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }
}
