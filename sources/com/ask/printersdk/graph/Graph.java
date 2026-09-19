package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import kotlin.Metadata;

/* JADX INFO: compiled from: Graph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u0000 =2\u00020\u0001:\u0001=J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J8\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J0\u0010#\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H&J \u0010'\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J \u0010(\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0015H&J \u0010+\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J \u0010,\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u00020.H&J\b\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u000201H&J\b\u00104\u001a\u00020\u0005H&J\b\u00105\u001a\u00020\u0005H&J\b\u00106\u001a\u00020\u0005H&J\b\u00107\u001a\u00020\u0005H&J\b\u00108\u001a\u00020\u0005H&J\b\u00109\u001a\u00020\u0005H&J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020%H&J\b\u0010<\u001a\u00020%H&¨\u0006>"}, d2 = {"Lcom/ask/printersdk/graph/Graph;", "", "getId", "", "setId", "", "id", "getIsLock", "", "setDrawBoardInfo", "boardStyle", "Lcom/ask/printersdk/graph/BoardStyle;", "reset", "rotate", "getBound", "Landroid/graphics/RectF;", "getBound2Board", "getScalePoint", "Landroid/graphics/PointF;", "moveGraph", "distanceX", "", "distanceY", "scaleGraph", "startX", "startY", "endX", "endY", "drawBound", "context", "Landroid/content/Context;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onDrawScaleLine", "viewWidth", "", "viewHeight", "drawScalePoint", "isTouchScalePoint", "x", "y", "onDraw", "onPrintingDraw", "initStyle", "Lcom/ask/printersdk/graph/Style;", "getStyle", "saveState", "", "restoreState", "json", "onAlignLeftCurGraph", "onAlignRightCurGraph", "onAlignTopCurGraph", "onAlignMiddle2HoriCurGraph", "onAlignMiddleCurGraph", "onAlignBottomCurGraph", "onMoveStep", DevicePublicKeyStringDef.DIRECT, "getOrderBy", "Companion", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Graph {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void drawBound(Context context, Canvas canvas, Paint paint);

    void drawScalePoint(Context context, Canvas canvas, Paint paint);

    RectF getBound();

    RectF getBound2Board();

    long getId();

    boolean getIsLock();

    int getOrderBy();

    PointF getScalePoint();

    Style getStyle();

    Style initStyle();

    boolean isTouchScalePoint(Context context, float x, float y);

    void moveGraph(float distanceX, float distanceY);

    void onAlignBottomCurGraph();

    void onAlignLeftCurGraph();

    void onAlignMiddle2HoriCurGraph();

    void onAlignMiddleCurGraph();

    void onAlignRightCurGraph();

    void onAlignTopCurGraph();

    void onDraw(Context context, Canvas canvas, Paint paint);

    void onDrawScaleLine(Context context, Canvas canvas, Paint paint, int viewWidth, int viewHeight);

    void onMoveStep(int direct);

    void onPrintingDraw(Context context, Canvas canvas, Paint paint);

    void reset();

    void restoreState(String json);

    void rotate();

    String saveState();

    void scaleGraph(float startX, float startY, float endX, float endY, float distanceX, float distanceY);

    void setDrawBoardInfo(BoardStyle boardStyle);

    void setId(long id);

    /* JADX INFO: compiled from: Graph.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ask/printersdk/graph/Graph$Companion;", "", "<init>", "()V", "radiusDip", "", "getRadiusDip", "()I", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int radiusDip = 6;

        private Companion() {
        }

        public final int getRadiusDip() {
            return radiusDip;
        }
    }
}
