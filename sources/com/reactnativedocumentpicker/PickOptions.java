package com.reactnativedocumentpicker;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J^\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012¨\u0006*"}, d2 = {"Lcom/reactnativedocumentpicker/PickOptions;", "", "mode", "", "mimeTypes", "", "initialDirectoryUrl", "localOnly", "", "multiple", "requestLongTermAccess", "allowVirtualFiles", "<init>", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getMimeTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getInitialDirectoryUrl", "()Ljava/lang/String;", "getLocalOnly", "()Z", "getMultiple", "getRequestLongTermAccess", "getAllowVirtualFiles", "action", "getAction", "intentFilterTypes", "getIntentFilterTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZZZZ)Lcom/reactnativedocumentpicker/PickOptions;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PickOptions {
    private final boolean allowVirtualFiles;
    private final String initialDirectoryUrl;
    private final boolean localOnly;
    private final String[] mimeTypes;
    private final String mode;
    private final boolean multiple;
    private final boolean requestLongTermAccess;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getMode() {
        return this.mode;
    }

    public static /* synthetic */ PickOptions copy$default(PickOptions pickOptions, String str, String[] strArr, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pickOptions.mode;
        }
        if ((i & 2) != 0) {
            strArr = pickOptions.mimeTypes;
        }
        if ((i & 4) != 0) {
            str2 = pickOptions.initialDirectoryUrl;
        }
        if ((i & 8) != 0) {
            z = pickOptions.localOnly;
        }
        if ((i & 16) != 0) {
            z2 = pickOptions.multiple;
        }
        if ((i & 32) != 0) {
            z3 = pickOptions.requestLongTermAccess;
        }
        if ((i & 64) != 0) {
            z4 = pickOptions.allowVirtualFiles;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        boolean z7 = z2;
        String str3 = str2;
        return pickOptions.copy(str, strArr, str3, z, z7, z5, z6);
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String[] getMimeTypes() {
        return this.mimeTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInitialDirectoryUrl() {
        return this.initialDirectoryUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getLocalOnly() {
        return this.localOnly;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getMultiple() {
        return this.multiple;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getRequestLongTermAccess() {
        return this.requestLongTermAccess;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAllowVirtualFiles() {
        return this.allowVirtualFiles;
    }

    public final PickOptions copy(String mode, String[] mimeTypes, String initialDirectoryUrl, boolean localOnly, boolean multiple, boolean requestLongTermAccess, boolean allowVirtualFiles) {
        Intrinsics.checkNotNullParameter(mimeTypes, "mimeTypes");
        return new PickOptions(mode, mimeTypes, initialDirectoryUrl, localOnly, multiple, requestLongTermAccess, allowVirtualFiles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickOptions)) {
            return false;
        }
        PickOptions pickOptions = (PickOptions) other;
        return Intrinsics.areEqual(this.mode, pickOptions.mode) && Intrinsics.areEqual(this.mimeTypes, pickOptions.mimeTypes) && Intrinsics.areEqual(this.initialDirectoryUrl, pickOptions.initialDirectoryUrl) && this.localOnly == pickOptions.localOnly && this.multiple == pickOptions.multiple && this.requestLongTermAccess == pickOptions.requestLongTermAccess && this.allowVirtualFiles == pickOptions.allowVirtualFiles;
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.mimeTypes)) * 31;
        String str2 = this.initialDirectoryUrl;
        return ((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.localOnly)) * 31) + Boolean.hashCode(this.multiple)) * 31) + Boolean.hashCode(this.requestLongTermAccess)) * 31) + Boolean.hashCode(this.allowVirtualFiles);
    }

    public String toString() {
        return "PickOptions(mode=" + this.mode + ", mimeTypes=" + Arrays.toString(this.mimeTypes) + ", initialDirectoryUrl=" + this.initialDirectoryUrl + ", localOnly=" + this.localOnly + ", multiple=" + this.multiple + ", requestLongTermAccess=" + this.requestLongTermAccess + ", allowVirtualFiles=" + this.allowVirtualFiles + ")";
    }

    public PickOptions(String str, String[] mimeTypes, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(mimeTypes, "mimeTypes");
        this.mode = str;
        this.mimeTypes = mimeTypes;
        this.initialDirectoryUrl = str2;
        this.localOnly = z;
        this.multiple = z2;
        this.requestLongTermAccess = z3;
        this.allowVirtualFiles = z4;
    }

    public final String[] getMimeTypes() {
        return this.mimeTypes;
    }

    public final String getInitialDirectoryUrl() {
        return this.initialDirectoryUrl;
    }

    public final boolean getLocalOnly() {
        return this.localOnly;
    }

    public final boolean getMultiple() {
        return this.multiple;
    }

    public final boolean getRequestLongTermAccess() {
        return this.requestLongTermAccess;
    }

    public final boolean getAllowVirtualFiles() {
        return this.allowVirtualFiles;
    }

    public final String getAction() {
        return Intrinsics.areEqual("open", this.mode) ? "android.intent.action.OPEN_DOCUMENT" : "android.intent.action.GET_CONTENT";
    }

    public final String getIntentFilterTypes() {
        if (Intrinsics.areEqual(getAction(), "android.intent.action.OPEN_DOCUMENT")) {
            return "*/*";
        }
        return ArraysKt.joinToString$default(this.mimeTypes, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
