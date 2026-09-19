package com.ask.printersdk.graph;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoardStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006%"}, d2 = {"Lcom/ask/printersdk/graph/BoardStyle;", "Lcom/ask/printersdk/graph/Style;", "<init>", "()V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "matrixValues", "", "getMatrixValues", "()[F", "drawBoardWidth", "", "getDrawBoardWidth", "()I", "setDrawBoardWidth", "(I)V", "drawBoardHeight", "getDrawBoardHeight", "setDrawBoardHeight", "labelPaperWidth", "getLabelPaperWidth", "setLabelPaperWidth", "labelPaperHeight", "getLabelPaperHeight", "setLabelPaperHeight", "isPictureEditing", "", "()Z", "setPictureEditing", "(Z)V", "drawBoardBottom", "getDrawBoardBottom", "setDrawBoardBottom", "getDrawBound", "Landroid/graphics/RectF;", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoardStyle implements Style {
    private int drawBoardBottom;
    private int drawBoardHeight;
    private int drawBoardWidth;
    private boolean isPictureEditing;
    private int labelPaperHeight;
    private int labelPaperWidth;

    @JSONField(serialize = false)
    private final Matrix matrix = new Matrix();

    @JSONField(serialize = false)
    private final float[] matrixValues;

    public BoardStyle() {
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.matrixValues = fArr;
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    public final int getDrawBoardWidth() {
        return this.drawBoardWidth;
    }

    public final void setDrawBoardWidth(int i) {
        this.drawBoardWidth = i;
    }

    public final int getDrawBoardHeight() {
        return this.drawBoardHeight;
    }

    public final void setDrawBoardHeight(int i) {
        this.drawBoardHeight = i;
    }

    public final int getLabelPaperWidth() {
        return this.labelPaperWidth;
    }

    public final void setLabelPaperWidth(int i) {
        this.labelPaperWidth = i;
    }

    public final int getLabelPaperHeight() {
        return this.labelPaperHeight;
    }

    public final void setLabelPaperHeight(int i) {
        this.labelPaperHeight = i;
    }

    /* JADX INFO: renamed from: isPictureEditing, reason: from getter */
    public final boolean getIsPictureEditing() {
        return this.isPictureEditing;
    }

    public final void setPictureEditing(boolean z) {
        this.isPictureEditing = z;
    }

    public final int getDrawBoardBottom() {
        return this.drawBoardBottom;
    }

    public final void setDrawBoardBottom(int i) {
        this.drawBoardBottom = i;
    }

    @JSONField(serialize = false)
    public final RectF getDrawBound() {
        RectF rectF = new RectF(0.0f, 0.0f, this.drawBoardWidth, this.drawBoardHeight);
        this.matrix.mapRect(rectF);
        return rectF;
    }
}
