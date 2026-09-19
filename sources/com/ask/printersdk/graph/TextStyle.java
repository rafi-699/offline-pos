package com.ask.printersdk.graph;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0014\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010(\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001a\u00101\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR\u001a\u00104\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u00107\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001a\u0010:\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u001a\u0010<\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001a\u0010?\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010G¨\u0006K"}, d2 = {"Lcom/ask/printersdk/graph/TextStyle;", "Lcom/ask/printersdk/graph/Style;", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "paintColor", "", "getPaintColor", "()I", "setPaintColor", "(I)V", "paintTextSize", "", "getPaintTextSize", "()F", "setPaintTextSize", "(F)V", TtmlNode.BOLD, "", "getBold", "()Z", "setBold", "(Z)V", "underLine", "getUnderLine", "setUnderLine", TtmlNode.ITALIC, "getItalic", "setItalic", "align", "getAlign", "setAlign", "toBoundLayoutAlign", "getToBoundLayoutAlign", "setToBoundLayoutAlign", "fontTypeface", "getFontTypeface", "setFontTypeface", "fontIdentifier", "getFontIdentifier", "setFontIdentifier", "letterDistance", "getLetterDistance", "setLetterDistance", "lineDistance", "getLineDistance", "setLineDistance", "isAutoFont", "setAutoFont", "boundInitWidth2Board", "getBoundInitWidth2Board", "setBoundInitWidth2Board", "boundInitHeight2Board", "getBoundInitHeight2Board", "setBoundInitHeight2Board", "matrixValues", "", "getMatrixValues", "()[F", "setMatrixValues", "([F)V", "boundMatrixValues", "getBoundMatrixValues", "setBoundMatrixValues", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextStyle implements Style {
    private int align;
    private boolean bold;
    private float boundInitHeight2Board;
    private float boundInitWidth2Board;
    private float[] boundMatrixValues;
    private long id;
    private boolean italic;
    private float letterDistance;
    private float[] matrixValues;
    private int paintColor;
    private int toBoundLayoutAlign;
    private boolean underLine;
    private String text = "";
    private float paintTextSize = 14.0f;
    private String fontTypeface = "";
    private String fontIdentifier = "";
    private float lineDistance = 1.0f;
    private boolean isAutoFont = true;

    public TextStyle() {
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.matrixValues = fArr;
        float[] fArr2 = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            fArr2[i2] = 0.0f;
        }
        this.boundMatrixValues = fArr2;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final int getPaintColor() {
        return this.paintColor;
    }

    public final void setPaintColor(int i) {
        this.paintColor = i;
    }

    public final float getPaintTextSize() {
        return this.paintTextSize;
    }

    public final void setPaintTextSize(float f) {
        this.paintTextSize = f;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final void setBold(boolean z) {
        this.bold = z;
    }

    public final boolean getUnderLine() {
        return this.underLine;
    }

    public final void setUnderLine(boolean z) {
        this.underLine = z;
    }

    public final boolean getItalic() {
        return this.italic;
    }

    public final void setItalic(boolean z) {
        this.italic = z;
    }

    public final int getAlign() {
        return this.align;
    }

    public final void setAlign(int i) {
        this.align = i;
    }

    public final int getToBoundLayoutAlign() {
        return this.toBoundLayoutAlign;
    }

    public final void setToBoundLayoutAlign(int i) {
        this.toBoundLayoutAlign = i;
    }

    public final String getFontTypeface() {
        return this.fontTypeface;
    }

    public final void setFontTypeface(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontTypeface = str;
    }

    public final String getFontIdentifier() {
        return this.fontIdentifier;
    }

    public final void setFontIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fontIdentifier = str;
    }

    public final float getLetterDistance() {
        return this.letterDistance;
    }

    public final void setLetterDistance(float f) {
        this.letterDistance = f;
    }

    public final float getLineDistance() {
        return this.lineDistance;
    }

    public final void setLineDistance(float f) {
        this.lineDistance = f;
    }

    /* JADX INFO: renamed from: isAutoFont, reason: from getter */
    public final boolean getIsAutoFont() {
        return this.isAutoFont;
    }

    public final void setAutoFont(boolean z) {
        this.isAutoFont = z;
    }

    public final float getBoundInitWidth2Board() {
        return this.boundInitWidth2Board;
    }

    public final void setBoundInitWidth2Board(float f) {
        this.boundInitWidth2Board = f;
    }

    public final float getBoundInitHeight2Board() {
        return this.boundInitHeight2Board;
    }

    public final void setBoundInitHeight2Board(float f) {
        this.boundInitHeight2Board = f;
    }

    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    public final void setMatrixValues(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.matrixValues = fArr;
    }

    public final float[] getBoundMatrixValues() {
        return this.boundMatrixValues;
    }

    public final void setBoundMatrixValues(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.boundMatrixValues = fArr;
    }
}
