package io.invertase.firebase.interfaces;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeEvent {
    WritableMap getEventBody();

    String getEventName();

    String getFirebaseAppName();
}
