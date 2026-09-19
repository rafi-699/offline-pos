package com.bleplx.converter;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes2.dex */
abstract class JSObjectConverter<T> {
    public abstract WritableMap toJSObject(T t);

    JSObjectConverter() {
    }

    public WritableArray toJSCallback(T t) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushNull();
        writableArrayCreateArray.pushMap(toJSObject(t));
        return writableArrayCreateArray;
    }
}
