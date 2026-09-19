package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.R;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoardGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 r2\u00020\u0001:\u0001rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00101\u001a\u00020\tH\u0016J&\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015J\u000e\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\tJ\u0016\u0010;\u001a\u0002032\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015J\u0006\u0010<\u001a\u000203J\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020@H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010C\u001a\u000203H\u0016J\b\u0010D\u001a\u000203H\u0016J\b\u0010E\u001a\u00020>H\u0016J\b\u0010F\u001a\u00020>H\u0016J\b\u0010G\u001a\u00020HH\u0016J\u0018\u0010I\u001a\u0002032\u0006\u0010J\u001a\u0002052\u0006\u0010K\u001a\u000205H\u0016J8\u0010L\u001a\u0002032\u0006\u0010M\u001a\u0002052\u0006\u0010N\u001a\u0002052\u0006\u0010O\u001a\u0002052\u0006\u0010P\u001a\u0002052\u0006\u0010J\u001a\u0002052\u0006\u0010K\u001a\u000205H\u0016J&\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u0002052\u0006\u0010U\u001a\u000205J \u0010V\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0016J \u0010Z\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0016J \u0010[\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u000205H\u0016J\b\u0010^\u001a\u00020\u001eH\u0016J \u0010_\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0016J \u0010`\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0016J\u000e\u0010\u001d\u001a\u0002032\u0006\u0010a\u001a\u00020\u001eJ0\u0010b\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u0002032\u0006\u0010h\u001a\u00020fH\u0016J\b\u0010i\u001a\u000203H\u0016J\b\u0010j\u001a\u000203H\u0016J\b\u0010k\u001a\u000203H\u0016J\b\u0010l\u001a\u000203H\u0016J\b\u0010m\u001a\u000203H\u0016J\b\u0010n\u001a\u000203H\u0016J\u0010\u0010o\u001a\u0002032\u0006\u0010p\u001a\u00020\u0015H\u0016J\b\u0010q\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010%\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010*\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0017R\u0011\u0010/\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0017¨\u0006s"}, d2 = {"Lcom/ask/printersdk/graph/BoardGraph;", "Lcom/ask/printersdk/graph/Graph;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "boardStyle", "Lcom/ask/printersdk/graph/BoardStyle;", "getBoardStyle", "()Lcom/ask/printersdk/graph/BoardStyle;", "setBoardStyle", "(Lcom/ask/printersdk/graph/BoardStyle;)V", "mPaint", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mTextPaint", "getMTextPaint", "viewWidth", "", "getViewWidth", "()I", "setViewWidth", "(I)V", "viewHeight", "getViewHeight", "setViewHeight", "showScaleLine", "", "getShowScaleLine", "()Z", "setShowScaleLine", "(Z)V", "scaleStrokeWidth", "getScaleStrokeWidth", "scaleTextStrokeWidth", "getScaleTextStrokeWidth", "scaleLineGap", "getScaleLineGap", "setScaleLineGap", "segmentation", "getSegmentation", "setSegmentation", "scaleTextSize", "getScaleTextSize", "scaleSegmentTextGap", "getScaleSegmentTextGap", "initStyle", "setDrawBoardInfo", "", "left", "", "top", "width", "height", "setDrawBoardData", "style", "setViewSize", "calculateWhiteBoard", "getDrawBound", "Landroid/graphics/RectF;", "getId", "", "setId", "id", "reset", "rotate", "getBound", "getBound2Board", "getScalePoint", "Landroid/graphics/PointF;", "moveGraph", "distanceX", "distanceY", "scaleGraph", "startX", "startY", "endX", "endY", "scaleBoardGraph", ViewProps.SCALE_X, ViewProps.SCALE_Y, "currentFocusX", "currentFocusY", "drawBound", "canvas", "Landroid/graphics/Canvas;", "paint", "drawScalePoint", "isTouchScalePoint", "x", "y", "getIsLock", "onDraw", "onPrintingDraw", "show", "onDrawScaleLine", "getStyle", "Lcom/ask/printersdk/graph/Style;", "saveState", "", "restoreState", "json", "onAlignLeftCurGraph", "onAlignRightCurGraph", "onAlignTopCurGraph", "onAlignMiddle2HoriCurGraph", "onAlignMiddleCurGraph", "onAlignBottomCurGraph", "onMoveStep", DevicePublicKeyStringDef.DIRECT, "getOrderBy", "Companion", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoardGraph implements Graph {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DRAW_BOAED_MAX_SCALE = 4.0f;
    private static final float DRAW_BOAED_MIN_SCALE = 0.1f;
    private BoardStyle boardStyle;
    private final Context context;
    private final Paint mPaint;
    private final Paint mTextPaint;
    private int scaleLineGap;
    private final int scaleSegmentTextGap;
    private final int scaleStrokeWidth;
    private final int scaleTextSize;
    private final int scaleTextStrokeWidth;
    private int segmentation;
    private boolean showScaleLine;
    private int viewHeight;
    private int viewWidth;

    @Override // com.ask.printersdk.graph.Graph
    public long getId() {
        return 1L;
    }

    @Override // com.ask.printersdk.graph.Graph
    public boolean getIsLock() {
        return false;
    }

    @Override // com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 0;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onPrintingDraw(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void setId(long id) {
    }

    public BoardGraph(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.scaleStrokeWidth = PUtil.dip2px(context, 1.0f);
        int iDip2px = PUtil.dip2px(context, 0.5f);
        this.scaleTextStrokeWidth = iDip2px;
        this.scaleLineGap = PUtil.dip2px(context, 5.0f);
        this.segmentation = PUtil.dip2px(context, 4.0f);
        int iDip2px2 = PUtil.dip2px(context, 12.0f);
        this.scaleTextSize = iDip2px2;
        this.scaleSegmentTextGap = PUtil.dip2px(context, 3.0f);
        this.boardStyle = initStyle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(PUtil.dip2px(context, 14.0f));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(PUtil.getColor(context, R.color.color_3F74FF));
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(iDip2px);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(PUtil.getColor(context, R.color.color_A9AEB4));
        paint2.setTextSize(iDip2px2);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: compiled from: BoardGraph.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ask/printersdk/graph/BoardGraph$Companion;", "", "<init>", "()V", "DRAW_BOAED_MAX_SCALE", "", "getDRAW_BOAED_MAX_SCALE", "()F", "DRAW_BOAED_MIN_SCALE", "getDRAW_BOAED_MIN_SCALE", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float getDRAW_BOAED_MAX_SCALE() {
            return BoardGraph.DRAW_BOAED_MAX_SCALE;
        }

        public final float getDRAW_BOAED_MIN_SCALE() {
            return BoardGraph.DRAW_BOAED_MIN_SCALE;
        }
    }

    public final BoardStyle getBoardStyle() {
        return this.boardStyle;
    }

    public final void setBoardStyle(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "<set-?>");
        this.boardStyle = boardStyle;
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final Paint getMTextPaint() {
        return this.mTextPaint;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setViewWidth(int i) {
        this.viewWidth = i;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final void setViewHeight(int i) {
        this.viewHeight = i;
    }

    public final boolean getShowScaleLine() {
        return this.showScaleLine;
    }

    public final void setShowScaleLine(boolean z) {
        this.showScaleLine = z;
    }

    public final int getScaleStrokeWidth() {
        return this.scaleStrokeWidth;
    }

    public final int getScaleTextStrokeWidth() {
        return this.scaleTextStrokeWidth;
    }

    public final int getScaleLineGap() {
        return this.scaleLineGap;
    }

    public final void setScaleLineGap(int i) {
        this.scaleLineGap = i;
    }

    public final int getSegmentation() {
        return this.segmentation;
    }

    public final void setSegmentation(int i) {
        this.segmentation = i;
    }

    public final int getScaleTextSize() {
        return this.scaleTextSize;
    }

    public final int getScaleSegmentTextGap() {
        return this.scaleSegmentTextGap;
    }

    @Override // com.ask.printersdk.graph.Graph
    public BoardStyle initStyle() {
        return new BoardStyle();
    }

    public final void setDrawBoardInfo(float left, float top, int width, int height) {
        if (this.boardStyle.getLabelPaperWidth() == width && this.boardStyle.getLabelPaperHeight() == height) {
            return;
        }
        this.boardStyle.setLabelPaperWidth(width);
        this.boardStyle.setLabelPaperHeight(height);
        calculateWhiteBoard();
    }

    public final void setDrawBoardData(BoardStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.boardStyle = style;
        if (style.getDrawBoardWidth() == 0 || this.boardStyle.getDrawBoardHeight() == 0) {
            calculateWhiteBoard();
            return;
        }
        this.boardStyle.getMatrix().getValues(this.boardStyle.getMatrixValues());
        this.boardStyle.getMatrixValues()[2] = (this.viewWidth - this.boardStyle.getDrawBoardWidth()) / 2;
        this.boardStyle.getMatrixValues()[5] = (this.viewHeight - this.boardStyle.getDrawBoardHeight()) / 2;
        this.boardStyle.getMatrix().setValues(this.boardStyle.getMatrixValues());
    }

    public final void setViewSize(int width, int height) {
        this.viewWidth = width;
        this.viewHeight = height;
        calculateWhiteBoard();
    }

    public final void calculateWhiteBoard() {
        if (this.viewWidth <= 0 || this.boardStyle.getLabelPaperWidth() <= 0) {
            return;
        }
        float f = this.viewWidth / this.viewHeight;
        float labelPaperWidth = this.boardStyle.getLabelPaperWidth() / this.boardStyle.getLabelPaperHeight();
        if (f > labelPaperWidth) {
            this.boardStyle.setDrawBoardHeight((int) (((double) this.viewHeight) * 0.8d));
            BoardStyle boardStyle = this.boardStyle;
            boardStyle.setDrawBoardWidth((int) (boardStyle.getDrawBoardHeight() * labelPaperWidth));
        } else {
            this.boardStyle.setDrawBoardWidth((int) (((double) this.viewWidth) * 0.8d));
            BoardStyle boardStyle2 = this.boardStyle;
            boardStyle2.setDrawBoardHeight((int) (boardStyle2.getDrawBoardWidth() / labelPaperWidth));
        }
        this.boardStyle.getMatrix().getValues(this.boardStyle.getMatrixValues());
        this.boardStyle.getMatrixValues()[2] = (this.viewWidth - this.boardStyle.getDrawBoardWidth()) / 2;
        this.boardStyle.getMatrixValues()[5] = (this.viewHeight - this.boardStyle.getDrawBoardHeight()) / 2;
        this.boardStyle.getMatrix().setValues(this.boardStyle.getMatrixValues());
    }

    public final RectF getDrawBound() {
        return this.boardStyle.getDrawBound();
    }

    @Override // com.ask.printersdk.graph.Graph
    public void setDrawBoardInfo(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "boardStyle");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void reset() {
        this.boardStyle.getMatrix().setValues(this.boardStyle.getMatrixValues());
    }

    @Override // com.ask.printersdk.graph.Graph
    public void rotate() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound2Board() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public PointF getScalePoint() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void moveGraph(float distanceX, float distanceY) {
        this.boardStyle.getMatrix().postTranslate(distanceX, distanceY);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void scaleGraph(float startX, float startY, float endX, float endY, float distanceX, float distanceY) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void scaleBoardGraph(float scaleX, float scaleY, float currentFocusX, float currentFocusY) {
        this.boardStyle.getMatrix().postScale(scaleX, scaleY, currentFocusX, currentFocusY);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void drawBound(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void drawScalePoint(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public boolean isTouchScalePoint(Context context, float x, float y) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onDraw(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawColor(PUtil.getColor(context, R.color.color_f5));
        this.mPaint.setColor(PUtil.getColor(context, R.color.white));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(getDrawBound(), this.mPaint);
    }

    public final void showScaleLine(boolean show) {
        this.showScaleLine = show;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onDrawScaleLine(Context context, Canvas canvas, Paint paint, int viewWidth, int viewHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        RectF drawBound = getDrawBound();
        this.mPaint.setColor(PUtil.getColor(context, R.color.color_A9AEB4));
        this.mPaint.setStrokeWidth(this.scaleStrokeWidth);
        Rect rect = new Rect();
        int i = 0;
        this.mTextPaint.getTextBounds(AppEventsConstants.EVENT_PARAM_VALUE_NO, 0, 1, rect);
        canvas.drawLine(drawBound.left, this.scaleLineGap, drawBound.right, this.scaleLineGap, this.mPaint);
        float fWidth = drawBound.width() / this.boardStyle.getLabelPaperWidth();
        int labelPaperWidth = this.boardStyle.getLabelPaperWidth();
        if (labelPaperWidth >= 0) {
            int i2 = 0;
            while (true) {
                if (i2 % 10 == 0) {
                    float f = fWidth * i2;
                    canvas.drawLine(drawBound.left + f, this.scaleLineGap, drawBound.left + f, (this.segmentation * 3) + this.scaleLineGap, this.mPaint);
                    canvas.drawText(String.valueOf(i2), (drawBound.left + f) - (this.mTextPaint.measureText(String.valueOf(i2)) / 2), this.scaleLineGap + (this.segmentation * 3) + this.scaleSegmentTextGap + rect.height(), this.mTextPaint);
                } else if (i2 % 5 == 0) {
                    float f2 = i2 * fWidth;
                    canvas.drawLine(drawBound.left + f2, this.scaleLineGap, drawBound.left + f2, this.scaleLineGap + (this.segmentation * 2), this.mPaint);
                } else {
                    float f3 = i2 * fWidth;
                    canvas.drawLine(drawBound.left + f3, this.scaleLineGap, drawBound.left + f3, this.segmentation + this.scaleLineGap, this.mPaint);
                }
                if (i2 == labelPaperWidth) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        canvas.drawLine(this.scaleLineGap, drawBound.top, this.scaleLineGap, drawBound.bottom, this.mPaint);
        float fHeight = drawBound.height() / this.boardStyle.getLabelPaperHeight();
        int labelPaperHeight = this.boardStyle.getLabelPaperHeight();
        if (labelPaperHeight >= 0) {
            while (true) {
                if (i % 10 == 0) {
                    float f4 = fHeight * i;
                    canvas.drawLine(this.scaleLineGap, drawBound.top + f4, (this.segmentation * 3) + this.scaleLineGap, drawBound.top + f4, this.mPaint);
                    canvas.drawText(String.valueOf(i), this.scaleLineGap + (this.segmentation * 3) + this.scaleSegmentTextGap, drawBound.top + f4 + (rect.height() / 2), this.mTextPaint);
                } else if (i % 5 == 0) {
                    float f5 = i * fHeight;
                    canvas.drawLine(this.scaleLineGap, drawBound.top + f5, this.scaleLineGap + (this.segmentation * 2), drawBound.top + f5, this.mPaint);
                } else {
                    float f6 = i * fHeight;
                    canvas.drawLine(this.scaleLineGap, drawBound.top + f6, this.scaleLineGap + this.segmentation, drawBound.top + f6, this.mPaint);
                }
                if (i == labelPaperHeight) {
                    break;
                } else {
                    i++;
                }
            }
        }
        canvas.restore();
    }

    @Override // com.ask.printersdk.graph.Graph
    public Style getStyle() {
        return this.boardStyle;
    }

    @Override // com.ask.printersdk.graph.Graph
    public String saveState() {
        String jSONString = JSON.toJSONString(this.boardStyle);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        BoardStyle boardStyle = (BoardStyle) JSON.parseObject(json, BoardStyle.class);
        setDrawBoardInfo(0.0f, 0.0f, boardStyle.getLabelPaperWidth(), boardStyle.getLabelPaperHeight());
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignLeftCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignRightCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignTopCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignMiddle2HoriCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignMiddleCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onAlignBottomCurGraph() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onMoveStep(int direct) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
