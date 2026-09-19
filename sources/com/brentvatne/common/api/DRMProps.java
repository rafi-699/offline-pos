package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DRMProps.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/brentvatne/common/api/DRMProps;", "", "<init>", "()V", "drmType", "", "getDrmType", "()Ljava/lang/String;", "setDrmType", "(Ljava/lang/String;)V", "drmUUID", "Ljava/util/UUID;", "getDrmUUID", "()Ljava/util/UUID;", "setDrmUUID", "(Ljava/util/UUID;)V", "drmLicenseServer", "getDrmLicenseServer", "setDrmLicenseServer", "drmLicenseHeader", "", "getDrmLicenseHeader", "()[Ljava/lang/String;", "setDrmLicenseHeader", "([Ljava/lang/String;)V", "[Ljava/lang/String;", DRMProps.PROP_DRM_MULTI_DRM, "", "getMultiDrm", "()Z", "setMultiDrm", "(Z)V", "equals", "other", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DRMProps {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PROP_DRM_HEADERS = "headers";
    private static final String PROP_DRM_HEADERS_KEY = "key";
    private static final String PROP_DRM_HEADERS_VALUE = "value";
    private static final String PROP_DRM_LICENSE_SERVER = "licenseServer";
    private static final String PROP_DRM_MULTI_DRM = "multiDrm";
    private static final String PROP_DRM_TYPE = "type";
    private String[] drmLicenseHeader = new String[0];
    private String drmLicenseServer;
    private String drmType;
    private UUID drmUUID;
    private boolean multiDrm;

    @JvmStatic
    public static final DRMProps parse(ReadableMap readableMap) {
        return INSTANCE.parse(readableMap);
    }

    public final String getDrmType() {
        return this.drmType;
    }

    public final void setDrmType(String str) {
        this.drmType = str;
    }

    public final UUID getDrmUUID() {
        return this.drmUUID;
    }

    public final void setDrmUUID(UUID uuid) {
        this.drmUUID = uuid;
    }

    public final String getDrmLicenseServer() {
        return this.drmLicenseServer;
    }

    public final void setDrmLicenseServer(String str) {
        this.drmLicenseServer = str;
    }

    public final String[] getDrmLicenseHeader() {
        return this.drmLicenseHeader;
    }

    public final void setDrmLicenseHeader(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.drmLicenseHeader = strArr;
    }

    public final boolean getMultiDrm() {
        return this.multiDrm;
    }

    public final void setMultiDrm(boolean z) {
        this.multiDrm = z;
    }

    public boolean equals(Object other) {
        if (other != null && (other instanceof DRMProps)) {
            DRMProps dRMProps = (DRMProps) other;
            if (Intrinsics.areEqual(this.drmType, dRMProps.drmType) && Intrinsics.areEqual(this.drmLicenseServer, dRMProps.drmLicenseServer) && this.multiDrm == dRMProps.multiDrm && ArraysKt.contentDeepEquals(this.drmLicenseHeader, dRMProps.drmLicenseHeader)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: DRMProps.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/brentvatne/common/api/DRMProps$Companion;", "", "<init>", "()V", "PROP_DRM_TYPE", "", "PROP_DRM_LICENSE_SERVER", "PROP_DRM_HEADERS", "PROP_DRM_HEADERS_KEY", "PROP_DRM_HEADERS_VALUE", "PROP_DRM_MULTI_DRM", "parse", "Lcom/brentvatne/common/api/DRMProps;", "src", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DRMProps parse(ReadableMap src) {
            if (src != null && src.hasKey("type")) {
                DRMProps dRMProps = new DRMProps();
                dRMProps.setDrmType(ReactBridgeUtils.safeGetString(src, "type"));
                dRMProps.setDrmLicenseServer(ReactBridgeUtils.safeGetString(src, DRMProps.PROP_DRM_LICENSE_SERVER));
                dRMProps.setMultiDrm(ReactBridgeUtils.safeGetBool(src, DRMProps.PROP_DRM_MULTI_DRM, false));
                ReadableArray readableArraySafeGetArray = ReactBridgeUtils.safeGetArray(src, DRMProps.PROP_DRM_HEADERS);
                if (dRMProps.getDrmType() != null && dRMProps.getDrmLicenseServer() != null) {
                    if (readableArraySafeGetArray != null) {
                        ArrayList arrayList = new ArrayList();
                        int size = readableArraySafeGetArray.size();
                        for (int i = 0; i < size; i++) {
                            ReadableMap map = readableArraySafeGetArray.getMap(i);
                            arrayList.add(ReactBridgeUtils.safeGetString(map, "key"));
                            arrayList.add(ReactBridgeUtils.safeGetString(map, "value"));
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
                        dRMProps.setDrmLicenseHeader((String[]) array);
                    }
                    return dRMProps;
                }
            }
            return null;
        }
    }
}
