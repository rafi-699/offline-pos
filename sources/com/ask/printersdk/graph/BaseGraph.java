package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.ask.printersdk.R;
import com.ask.printersdk.utils.PUtil;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J0\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020 H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006*"}, d2 = {"Lcom/ask/printersdk/graph/BaseGraph;", "Lcom/ask/printersdk/graph/Graph;", "<init>", "()V", "isLock", "", "()Z", "setLock", "(Z)V", "boardStyle", "Lcom/ask/printersdk/graph/BoardStyle;", "getBoardStyle", "()Lcom/ask/printersdk/graph/BoardStyle;", "setBoardStyle", "(Lcom/ask/printersdk/graph/BoardStyle;)V", "getIsLock", "setDrawBoardInfo", "", "drawBound", "context", "Landroid/content/Context;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "isTouchScalePoint", "x", "", "y", "drawScalePoint", "onDrawScaleLine", "viewWidth", "", "viewHeight", "onAlignLeftCurGraph", "onAlignRightCurGraph", "onAlignTopCurGraph", "onAlignMiddle2HoriCurGraph", "onAlignMiddleCurGraph", "onAlignBottomCurGraph", "onMoveStep", DevicePublicKeyStringDef.DIRECT, "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseGraph implements Graph {
    public BoardStyle boardStyle;
    private boolean isLock;

    public final boolean isLock() {
        return this.isLock;
    }

    public final void setLock(boolean z) {
        this.isLock = z;
    }

    public final BoardStyle getBoardStyle() {
        BoardStyle boardStyle = this.boardStyle;
        if (boardStyle != null) {
            return boardStyle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boardStyle");
        return null;
    }

    public final void setBoardStyle(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "<set-?>");
        this.boardStyle = boardStyle;
    }

    @Override // com.ask.printersdk.graph.Graph
    public boolean getIsLock() {
        return this.isLock;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void setDrawBoardInfo(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "boardStyle");
        setBoardStyle(boardStyle);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void drawBound(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        RectF bound = getBound();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(PUtil.getColor(context, R.color.color_3F74FF));
        canvas.drawRect(bound, paint);
    }

    @Override // com.ask.printersdk.graph.Graph
    public boolean isTouchScalePoint(Context context, float x, float y) {
        Intrinsics.checkNotNullParameter(context, "context");
        PointF scalePoint = getScalePoint();
        float fDip2px = PUtil.dip2px(context, Graph.INSTANCE.getRadiusDip() + 5);
        return new RectF(scalePoint.x - fDip2px, scalePoint.y - fDip2px, scalePoint.x + fDip2px, scalePoint.y + fDip2px).contains(x, y);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void drawScalePoint(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        PointF scalePoint = getScalePoint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(PUtil.getColor(context, R.color.white));
        canvas.drawCircle(scalePoint.x, scalePoint.y, PUtil.dip2px(context, Graph.INSTANCE.getRadiusDip()), paint);
        paint.setColor(PUtil.getColor(context, R.color.color_3F74FF));
        canvas.drawCircle(scalePoint.x, scalePoint.y, PUtil.dip2px(context, Graph.INSTANCE.getRadiusDip() - 1.5f), paint);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onDrawScaleLine(Context context, Canvas canvas, Paint paint, int viewWidth, int viewHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        RectF bound = getBound();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(PUtil.getColor(context, R.color.color_3F74FF));
        paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 20.0f}, 0.0f));
        float f = viewWidth;
        canvas.drawLine(0.0f, bound.top, f, bound.top, paint);
        canvas.drawLine(0.0f, bound.bottom, f, bound.bottom, paint);
        float f2 = viewHeight;
        canvas.drawLine(bound.left, 0.0f, bound.left, f2, paint);
        canvas.drawLine(bound.right, 0.0f, bound.right, f2, paint);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignLeftCurGraph() {
        moveGraph(-getBound2Board().left, 0.0f);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignRightCurGraph() {
        moveGraph(getBoardStyle().getDrawBoardWidth() - getBound2Board().right, 0.0f);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignTopCurGraph() {
        moveGraph(0.0f, -getBound2Board().top);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignMiddle2HoriCurGraph() {
        RectF bound2Board = getBound2Board();
        moveGraph(((getBoardStyle().getDrawBoardWidth() - bound2Board.width()) / 2) - bound2Board.left, 0.0f);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignMiddleCurGraph() {
        RectF bound2Board = getBound2Board();
        float f = 2;
        moveGraph(((getBoardStyle().getDrawBoardWidth() - bound2Board.width()) / f) - bound2Board.left, ((getBoardStyle().getDrawBoardHeight() - bound2Board.height()) / f) - bound2Board.top);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignBottomCurGraph() {
        moveGraph(0.0f, getBoardStyle().getDrawBoardHeight() - getBound2Board().bottom);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onMoveStep(int direct) {
        if (direct == 1) {
            moveGraph(0.0f, -(getBoardStyle().getDrawBoardHeight() / getBoardStyle().getLabelPaperHeight()));
            return;
        }
        if (direct == 2) {
            moveGraph(0.0f, getBoardStyle().getDrawBoardHeight() / getBoardStyle().getLabelPaperHeight());
        } else if (direct == 3) {
            moveGraph(-(getBoardStyle().getDrawBoardWidth() / getBoardStyle().getLabelPaperWidth()), 0.0f);
        } else {
            if (direct != 4) {
                return;
            }
            moveGraph(getBoardStyle().getDrawBoardWidth() / getBoardStyle().getLabelPaperWidth(), 0.0f);
        }
    }
}
