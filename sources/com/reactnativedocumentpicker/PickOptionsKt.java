package com.reactnativedocumentpicker;

import android.content.Intent;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"parsePickOptions", "Lcom/reactnativedocumentpicker/PickOptions;", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "readableArrayToStringArray", "", "", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)[Ljava/lang/String;", "react-native-documents_picker_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PickOptionsKt {
    public static final PickOptions parsePickOptions(ReadableMap readableMap) {
        String[] strArr;
        ReadableArray array;
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        String string = readableMap.getString("mode");
        boolean z = true;
        if (!readableMap.hasKey("type") || readableMap.isNull("type") || (array = readableMap.getArray("type")) == null || (strArr = readableArrayToStringArray(array)) == null) {
            strArr = new String[]{"*/*"};
        }
        String[] strArr2 = strArr;
        String string2 = readableMap.hasKey("initialDirectoryUrl") ? readableMap.getString("initialDirectoryUrl") : null;
        if (!readableMap.hasKey("localOnly") || !readableMap.getBoolean("localOnly")) {
            z = false;
        }
        return new PickOptions(string, strArr2, string2, z, readableMap.hasKey("allowMultiSelection") && readableMap.getBoolean("allowMultiSelection"), (readableMap.hasKey("requestLongTermAccess") && readableMap.getBoolean("requestLongTermAccess")) ? z : false, (readableMap.hasKey("allowVirtualFiles") && readableMap.getBoolean("allowVirtualFiles")) ? z : false);
    }

    public static final String[] readableArrayToStringArray(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "readableArray");
        ArrayList<Object> arrayList = readableArray.toArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            String strNormalizeMimeType = Intent.normalizeMimeType(String.valueOf(it.next()));
            Intrinsics.checkNotNull(strNormalizeMimeType);
            arrayList2.add(strNormalizeMimeType);
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }
}
