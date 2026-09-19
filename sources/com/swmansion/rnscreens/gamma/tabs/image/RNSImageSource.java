package com.swmansion.rnscreens.gamma.tabs.image;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsImageLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource;", "", "<init>", "()V", "DrawableRes", "UriString", "Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource$DrawableRes;", "Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource$UriString;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
abstract class RNSImageSource {
    public /* synthetic */ RNSImageSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RNSImageSource() {
    }

    /* JADX INFO: compiled from: TabsImageLoader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource$DrawableRes;", "Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource;", "resId", "", "<init>", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DrawableRes extends RNSImageSource {
        private final int resId;

        public static /* synthetic */ DrawableRes copy$default(DrawableRes drawableRes, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = drawableRes.resId;
            }
            return drawableRes.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        public final DrawableRes copy(int resId) {
            return new DrawableRes(resId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DrawableRes) && this.resId == ((DrawableRes) other).resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "DrawableRes(resId=" + this.resId + ")";
        }

        public final int getResId() {
            return this.resId;
        }

        public DrawableRes(int i) {
            super(null);
            this.resId = i;
        }
    }

    /* JADX INFO: compiled from: TabsImageLoader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource$UriString;", "Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource;", "uri", "", "<init>", "(Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class UriString extends RNSImageSource {
        private final String uri;

        public static /* synthetic */ UriString copy$default(UriString uriString, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uriString.uri;
            }
            return uriString.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        public final UriString copy(String uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new UriString(uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UriString) && Intrinsics.areEqual(this.uri, ((UriString) other).uri);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "UriString(uri=" + this.uri + ")";
        }

        public final String getUri() {
            return this.uri;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UriString(String uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }
    }
}
