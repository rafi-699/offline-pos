package io.invertase.googlemobileads.interfaces;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeError {
    String getErrorCode();

    String getErrorMessage();

    WritableMap getUserInfo();
}
