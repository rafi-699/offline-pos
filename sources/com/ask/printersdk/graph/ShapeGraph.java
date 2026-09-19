package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.utils.PUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J(\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J8\u0010 \u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J0\u0010\"\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Lcom/ask/printersdk/graph/ShapeGraph;", "Lcom/ask/printersdk/graph/ImageGraph;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPaint", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "initStyle", "Lcom/ask/printersdk/graph/ImageStyle;", "restoreState", "", "json", "", "saveState", "onDraw", "canvas", "Landroid/graphics/Canvas;", "paint", "onPrintingDraw", "originRect", "Landroid/graphics/RectF;", "toSquare", "getDrawBound", "isPrinting", "", "drawLine", "style", "Lcom/ask/printersdk/graph/ShapeStyle;", "boundRect", "drawRect", "isCornerRadius", "drawOval", "getOrderBy", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShapeGraph extends ImageGraph {
    private final Paint mPaint;

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 30;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeGraph(Context context) {
        super(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        setEqualScale(false);
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public ImageStyle initStyle() {
        return new ShapeStyle();
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        super.restoreState(json);
        Object object = JSON.parseObject(json, (Class<Object>) ShapeStyle.class);
        Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        setStyle((ImageStyle) object);
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public String saveState() {
        super.saveState();
        String jSONString = JSON.toJSONString(getStyle());
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void onDraw(Context context, Canvas canvas, Paint paint) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        ImageStyle style = getStyle();
        ShapeStyle shapeStyle = style instanceof ShapeStyle ? (ShapeStyle) style : null;
        if (shapeStyle == null) {
            return;
        }
        handleOpMatrix();
        canvas.save();
        RectF drawBound = getDrawBound(false);
        int shapeType = shapeStyle.getShapeType();
        if (shapeType == 1) {
            canvas2 = canvas;
            drawLine(canvas2, this.mPaint, shapeStyle, drawBound);
        } else if (shapeType == 2) {
            canvas2 = canvas;
            drawRect(context, canvas2, this.mPaint, shapeStyle, true, drawBound);
        } else if (shapeType == 3) {
            canvas2 = canvas;
            drawRect(context, canvas2, this.mPaint, shapeStyle, false, drawBound);
        } else if (shapeType == 4) {
            canvas2 = canvas;
            drawOval(context, canvas2, this.mPaint, shapeStyle, drawBound);
        } else if (shapeType != 5) {
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            drawOval(context, canvas2, this.mPaint, shapeStyle, drawBound);
        }
        canvas2.restore();
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void onPrintingDraw(Context context, Canvas canvas, Paint paint) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        getOpMatrix().reset();
        getOpMatrix().postConcat(getMatrix());
        ImageStyle style = getStyle();
        ShapeStyle shapeStyle = style instanceof ShapeStyle ? (ShapeStyle) style : null;
        if (shapeStyle == null) {
            return;
        }
        canvas.save();
        RectF drawBound = getDrawBound(true);
        int shapeType = shapeStyle.getShapeType();
        if (shapeType == 1) {
            canvas2 = canvas;
            drawLine(canvas2, this.mPaint, shapeStyle, drawBound);
        } else if (shapeType == 2) {
            canvas2 = canvas;
            drawRect(context, canvas2, this.mPaint, shapeStyle, true, drawBound);
        } else if (shapeType == 3) {
            canvas2 = canvas;
            drawRect(context, canvas2, this.mPaint, shapeStyle, false, drawBound);
        } else if (shapeType == 4) {
            canvas2 = canvas;
            drawOval(context, canvas2, this.mPaint, shapeStyle, drawBound);
        } else if (shapeType != 5) {
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            drawOval(context, canvas2, this.mPaint, shapeStyle, drawBound);
        }
        canvas2.restore();
    }

    @Override // com.ask.printersdk.graph.ImageGraph
    public RectF originRect() {
        return new RectF(0.0f, 0.0f, 240.0f, 240.0f);
    }

    public final void toSquare() {
        RectF bound = getBound();
        if (bound.width() == bound.height()) {
            return;
        }
        scaleGraph(bound.left, bound.top, bound.left + bound.height(), bound.bottom, bound.height() - bound.width(), 0.0f);
    }

    private final RectF getDrawBound(boolean isPrinting) {
        return isPrinting ? getBound2Board() : getBound();
    }

    private final void drawLine(Canvas canvas, Paint paint, ShapeStyle style, RectF boundRect) {
        float[] fArr = new float[9];
        getOpMatrix().getValues(fArr);
        float degrees = (float) Math.toDegrees(Math.atan2(fArr[3], fArr[4]));
        paint.reset();
        paint.setStrokeWidth((float) style.getLineWeight());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(style.getIsRedTintColor() ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
        if (style.getIsDashed()) {
            paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        }
        int i = (int) degrees;
        if (i == 90 || i == -90) {
            float fWidth = ((boundRect.width() - paint.getStrokeWidth()) / 2.0f) + boundRect.left;
            canvas.drawLine(fWidth, boundRect.top, fWidth, boundRect.bottom, paint);
        } else {
            float fHeight = boundRect.top + ((boundRect.height() - paint.getStrokeWidth()) / 2.0f);
            canvas.drawLine(boundRect.left, fHeight, boundRect.right, fHeight, paint);
        }
    }

    private final void drawRect(Context context, Canvas canvas, Paint paint, ShapeStyle style, boolean isCornerRadius, RectF boundRect) {
        paint.reset();
        paint.setStrokeWidth((float) style.getLineWeight());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(style.getIsRedTintColor() ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
        float fDip2px = isCornerRadius ? PUtil.dip2px(context, 8.0f) : 0.0f;
        float strokeWidth = paint.getStrokeWidth();
        if (style.getIsDashed()) {
            paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        }
        float f = 2 * strokeWidth;
        canvas.drawRoundRect(new RectF(boundRect.left + strokeWidth, boundRect.top + strokeWidth, boundRect.right - f, boundRect.bottom - f), fDip2px, fDip2px, paint);
    }

    private final void drawOval(Context context, Canvas canvas, Paint paint, ShapeStyle style, RectF boundRect) {
        paint.reset();
        paint.setStrokeWidth((float) style.getLineWeight());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(style.getIsRedTintColor() ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
        float strokeWidth = paint.getStrokeWidth();
        if (style.getIsDashed()) {
            paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        }
        float f = 2 * strokeWidth;
        canvas.drawOval(new RectF(boundRect.left + strokeWidth, boundRect.top + strokeWidth, boundRect.right - f, boundRect.bottom - f), paint);
    }
}
