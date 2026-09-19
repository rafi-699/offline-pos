package com.brentvatne.common.api;

import android.net.Uri;
import android.text.TextUtils;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdsProps.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/brentvatne/common/api/AdsProps;", "", "<init>", "()V", AdsProps.PROP_AD_TAG_URL, "Landroid/net/Uri;", "getAdTagUrl", "()Landroid/net/Uri;", "setAdTagUrl", "(Landroid/net/Uri;)V", AdsProps.PROP_AD_LANGUAGE, "", "getAdLanguage", "()Ljava/lang/String;", "setAdLanguage", "(Ljava/lang/String;)V", "equals", "", "other", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdsProps {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PROP_AD_LANGUAGE = "adLanguage";
    private static final String PROP_AD_TAG_URL = "adTagUrl";
    private String adLanguage;
    private Uri adTagUrl;

    @JvmStatic
    public static final AdsProps parse(ReadableMap readableMap) {
        return INSTANCE.parse(readableMap);
    }

    public final Uri getAdTagUrl() {
        return this.adTagUrl;
    }

    public final void setAdTagUrl(Uri uri) {
        this.adTagUrl = uri;
    }

    public final String getAdLanguage() {
        return this.adLanguage;
    }

    public final void setAdLanguage(String str) {
        this.adLanguage = str;
    }

    public boolean equals(Object other) {
        if (other != null && (other instanceof AdsProps)) {
            AdsProps adsProps = (AdsProps) other;
            if (Intrinsics.areEqual(this.adTagUrl, adsProps.adTagUrl) && Intrinsics.areEqual(this.adLanguage, adsProps.adLanguage)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: AdsProps.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/brentvatne/common/api/AdsProps$Companion;", "", "<init>", "()V", "PROP_AD_TAG_URL", "", "PROP_AD_LANGUAGE", "parse", "Lcom/brentvatne/common/api/AdsProps;", "src", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AdsProps parse(ReadableMap src) {
            AdsProps adsProps = new AdsProps();
            if (src != null) {
                String strSafeGetString = ReactBridgeUtils.safeGetString(src, AdsProps.PROP_AD_TAG_URL);
                if (TextUtils.isEmpty(strSafeGetString)) {
                    adsProps.setAdTagUrl(null);
                } else {
                    adsProps.setAdTagUrl(Uri.parse(strSafeGetString));
                }
                String strSafeGetString2 = ReactBridgeUtils.safeGetString(src, AdsProps.PROP_AD_LANGUAGE);
                if (!TextUtils.isEmpty(strSafeGetString2)) {
                    adsProps.setAdLanguage(strSafeGetString2);
                }
            }
            return adsProps;
        }
    }
}
