package com.bleplx.utils;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class ReadableArrayConverter {
    public static String[] toStringArray(ReadableArray readableArray) {
        String[] strArr = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            strArr[i] = readableArray.getString(i);
        }
        return strArr;
    }

    public static ReadableArray toReadableArray(List<UUID> list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<UUID> it = list.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(it.next().toString());
        }
        return writableArrayCreateArray;
    }
}
