package com.reactnativedocumentpicker;

import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: DocumentMetadataBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0015\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0016J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u001b\u0010\u000e\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f¢\u0006\u0002\u0010\u0019J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0003J\b\u0010\u001e\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", "", "forUri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "uri", "name", "", "size", "", "Ljava/lang/Long;", "mimeType", "metadataError", "openableMimeTypes", "", "[Ljava/lang/String;", "bookmark", "bookmarkError", "virtual", "", "Ljava/lang/Boolean;", "(Ljava/lang/Long;)Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", "metadataReadingError", "error", "([Ljava/lang/String;)Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", InAppPurchaseConstants.METHOD_BUILD, "Lcom/facebook/react/bridge/ReadableMap;", "hasMime", "getUri", "createReadableMap", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMetadataBuilder {
    private String bookmark;
    private String bookmarkError;
    private String metadataError;
    private String mimeType;
    private String name;
    private String[] openableMimeTypes;
    private Long size;
    private final Uri uri;
    private Boolean virtual;

    public DocumentMetadataBuilder(Uri forUri) {
        Intrinsics.checkNotNullParameter(forUri, "forUri");
        this.uri = forUri;
    }

    public final DocumentMetadataBuilder name(String name) {
        this.name = name;
        return this;
    }

    public final DocumentMetadataBuilder size(Long size) {
        this.size = size;
        return this;
    }

    public final DocumentMetadataBuilder mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public final DocumentMetadataBuilder metadataReadingError(String error) {
        this.metadataError = error;
        return this;
    }

    public final DocumentMetadataBuilder openableMimeTypes(String[] openableMimeTypes) {
        this.openableMimeTypes = openableMimeTypes;
        return this;
    }

    public final DocumentMetadataBuilder bookmark(Uri bookmark) {
        Intrinsics.checkNotNullParameter(bookmark, "bookmark");
        this.bookmark = bookmark.toString();
        return this;
    }

    public final DocumentMetadataBuilder bookmarkError(String bookmarkError) {
        this.bookmarkError = bookmarkError;
        return this;
    }

    public final DocumentMetadataBuilder virtual(boolean virtual) {
        this.virtual = Boolean.valueOf(virtual);
        return this;
    }

    public final ReadableMap build() {
        return createReadableMap();
    }

    public final boolean hasMime() {
        return this.mimeType != null;
    }

    public final Uri getUri() {
        return this.uri;
    }

    private final ReadableMap createReadableMap() {
        String lowerCase;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("name", this.name);
        writableMapCreateMap.putString("uri", this.uri.toString());
        Long l = this.size;
        if (l != null) {
            writableMapCreateMap.putDouble("size", l.longValue());
        } else {
            writableMapCreateMap.putNull("size");
        }
        String str = this.mimeType;
        String lowerCase2 = null;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        writableMapCreateMap.putString("type", lowerCase);
        String str2 = this.mimeType;
        if (str2 != null) {
            lowerCase2 = str2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        }
        writableMapCreateMap.putString("nativeType", lowerCase2);
        String[] strArr = this.openableMimeTypes;
        if (strArr != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str3 : strArr) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                writableMapCreateMap2.putString("mimeType", str3);
                writableMapCreateMap2.putString(ShareConstants.MEDIA_EXTENSION, extensionFromMimeType);
                writableArrayCreateArray.pushMap(writableMapCreateMap2);
            }
            writableMapCreateMap.putArray("convertibleToMimeTypes", writableArrayCreateArray);
        } else {
            writableMapCreateMap.putNull("convertibleToMimeTypes");
        }
        writableMapCreateMap.putString("error", this.metadataError);
        Boolean bool = this.virtual;
        if (bool != null) {
            writableMapCreateMap.putBoolean("isVirtual", bool.booleanValue());
        } else {
            writableMapCreateMap.putNull("isVirtual");
        }
        String str4 = this.bookmark;
        if (str4 != null) {
            byte[] bytes = str4.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strEncodeToString = Base64.encodeToString(bytes, 0);
            writableMapCreateMap.putString("bookmarkStatus", "success");
            writableMapCreateMap.putString("bookmark", strEncodeToString);
        } else {
            String str5 = this.bookmarkError;
            if (str5 != null) {
                writableMapCreateMap.putString("bookmarkStatus", "error");
                writableMapCreateMap.putString("bookmarkError", str5);
            }
        }
        return writableMapCreateMap;
    }
}
