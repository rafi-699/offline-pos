package com.reactnativedocumentpicker;

import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IsKnownTypeImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/reactnativedocumentpicker/IsKnownTypeImpl;", "", "<init>", "()V", "Companion", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsKnownTypeImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: IsKnownTypeImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J$\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/reactnativedocumentpicker/IsKnownTypeImpl$Companion;", "", "<init>", "()V", "isKnownType", "Lcom/facebook/react/bridge/WritableMap;", "kind", "", "value", "createMap", "isKnown", "", "preferredFilenameExtension", "mimeType", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WritableMap isKnownType(String kind, String value) {
            boolean z;
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(kind, "mimeType")) {
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(value);
                z = extensionFromMimeType != null;
                if (extensionFromMimeType == null) {
                    value = null;
                }
                return createMap(z, extensionFromMimeType, value);
            }
            if (Intrinsics.areEqual(kind, ShareConstants.MEDIA_EXTENSION)) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(value);
                z = mimeTypeFromExtension != null;
                if (mimeTypeFromExtension == null) {
                    value = null;
                }
                return createMap(z, value, mimeTypeFromExtension);
            }
            return createMap(false, null, null);
        }

        private final WritableMap createMap(boolean isKnown, String preferredFilenameExtension, String mimeType) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putNull("UTType");
            writableMapCreateMap.putBoolean("isKnown", isKnown);
            writableMapCreateMap.putString("preferredFilenameExtension", preferredFilenameExtension);
            writableMapCreateMap.putString("mimeType", mimeType);
            return writableMapCreateMap;
        }
    }
}
