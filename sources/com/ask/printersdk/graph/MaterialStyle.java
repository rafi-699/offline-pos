package com.ask.printersdk.graph;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ask/printersdk/graph/MaterialStyle;", "Lcom/ask/printersdk/graph/ImageStyle;", "<init>", "()V", "resName", "", "getResName", "()Ljava/lang/String;", "setResName", "(Ljava/lang/String;)V", "isReverse", "", "()Z", "setReverse", "(Z)V", "isRedTintColor", "setRedTintColor", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaterialStyle extends ImageStyle {
    private boolean isRedTintColor;
    private boolean isReverse;
    private String resName = "";

    public final String getResName() {
        return this.resName;
    }

    public final void setResName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resName = str;
    }

    /* JADX INFO: renamed from: isReverse, reason: from getter */
    public final boolean getIsReverse() {
        return this.isReverse;
    }

    public final void setReverse(boolean z) {
        this.isReverse = z;
    }

    /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
    public final boolean getIsRedTintColor() {
        return this.isRedTintColor;
    }

    public final void setRedTintColor(boolean z) {
        this.isRedTintColor = z;
    }
}
