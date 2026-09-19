package com.ask.printersdk.graph.style;

import com.ask.printersdk.graph.ImageStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BarCodeStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ask/printersdk/graph/style/BarCodeStyle;", "Lcom/ask/printersdk/graph/ImageStyle;", "<init>", "()V", "isRedTintColor", "", "()Z", "setRedTintColor", "(Z)V", "contentText", "", "getContentText", "()Ljava/lang/String;", "setContentText", "(Ljava/lang/String;)V", "codeType", "getCodeType", "setCodeType", "positionStyle", "", "getPositionStyle", "()I", "setPositionStyle", "(I)V", "textFontSize", "", "getTextFontSize", "()F", "setTextFontSize", "(F)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BarCodeStyle extends ImageStyle {
    private boolean isRedTintColor;
    private String contentText = "123456";
    private String codeType = "CODE_128";
    private int positionStyle = 2;
    private float textFontSize = 14.0f;

    /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
    public final boolean getIsRedTintColor() {
        return this.isRedTintColor;
    }

    public final void setRedTintColor(boolean z) {
        this.isRedTintColor = z;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final void setContentText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contentText = str;
    }

    public final String getCodeType() {
        return this.codeType;
    }

    public final void setCodeType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.codeType = str;
    }

    public final int getPositionStyle() {
        return this.positionStyle;
    }

    public final void setPositionStyle(int i) {
        this.positionStyle = i;
    }

    public final float getTextFontSize() {
        return this.textFontSize;
    }

    public final void setTextFontSize(float f) {
        this.textFontSize = f;
    }
}
