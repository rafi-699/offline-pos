package com.imagepicker;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.function.Function;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes4.dex */
public class Options {
    int conversionQuality;
    Boolean convertToJpeg;
    int durationLimit;
    Boolean includeBase64;
    Boolean includeExtra;
    int maxHeight;
    int maxWidth;
    String mediaType;
    int quality;
    String[] restrictMimeTypes;
    Boolean saveToPhotos;
    int selectionLimit;
    Boolean useFrontCamera;
    int videoQuality;

    Options(ReadableMap readableMap) {
        this.videoQuality = 1;
        this.conversionQuality = 92;
        this.convertToJpeg = true;
        this.useFrontCamera = false;
        this.mediaType = readableMap.getString("mediaType");
        this.restrictMimeTypes = (String[]) readableMap.getArray("restrictMimeTypes").toArrayList().stream().map(new Function() { // from class: com.imagepicker.Options$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return obj.toString();
            }
        }).toArray(new IntFunction() { // from class: com.imagepicker.Options$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return Options.lambda$new$0(i);
            }
        });
        this.selectionLimit = readableMap.getInt("selectionLimit");
        this.includeBase64 = Boolean.valueOf(readableMap.getBoolean("includeBase64"));
        this.includeExtra = Boolean.valueOf(readableMap.getBoolean("includeExtra"));
        String string = readableMap.getString("videoQuality");
        if (!TextUtils.isEmpty(string) && !string.toLowerCase().equals("high")) {
            this.videoQuality = 0;
        }
        if (readableMap.hasKey("conversionQuality")) {
            this.conversionQuality = (int) (readableMap.getDouble("conversionQuality") * 100.0d);
        }
        String string2 = readableMap.getString("assetRepresentationMode");
        if (!TextUtils.isEmpty(string2) && string2.toLowerCase().equals("current")) {
            this.convertToJpeg = false;
        }
        if (readableMap.getString("cameraType").equals("front")) {
            this.useFrontCamera = true;
        }
        this.quality = (int) (readableMap.getDouble("quality") * 100.0d);
        this.maxHeight = readableMap.getInt(ViewProps.MAX_HEIGHT);
        this.maxWidth = readableMap.getInt(ViewProps.MAX_WIDTH);
        this.saveToPhotos = Boolean.valueOf(readableMap.getBoolean("saveToPhotos"));
        this.durationLimit = readableMap.getInt("durationLimit");
    }

    static /* synthetic */ String[] lambda$new$0(int i) {
        return new String[i];
    }
}
