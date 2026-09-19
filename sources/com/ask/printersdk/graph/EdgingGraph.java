package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.graph.common.ImageCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgingGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/ask/printersdk/graph/EdgingGraph;", "Lcom/ask/printersdk/graph/ImageGraph;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "initStyle", "Lcom/ask/printersdk/graph/ImageStyle;", "updateResName", "", "resName", "", "restoreState", "json", "saveState", "onDraw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onPrintingDraw", "getOrderBy", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgingGraph extends ImageGraph {
    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EdgingGraph(Context context) {
        super(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public ImageStyle initStyle() {
        return new EdgingStyle();
    }

    public final void updateResName(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        ImageStyle style = getStyle();
        Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
        ((EdgingStyle) style).setResName(resName);
        Bitmap imageSource = new ImageCache(getContext()).getImageSource(resName);
        if (imageSource != null) {
            setBitmap(imageSource);
        }
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        super.restoreState(json);
        Object object = JSON.parseObject(json, (Class<Object>) EdgingStyle.class);
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
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        handleOpMatrix();
        ImageStyle style = getStyle();
        Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
        EdgingStyle edgingStyle = (EdgingStyle) style;
        ColorFilter colorFilter = paint.getColorFilter();
        paint.setColorFilter(null);
        Bitmap bitmap = getBitmap();
        if (edgingStyle.getIsRedTintColor()) {
            bitmap = drawRedBitmap(getBitmap());
        }
        if (edgingStyle.getIsReverse()) {
            canvas.drawBitmap(drawRectBitmap(getBitmap().getWidth(), getBitmap().getHeight(), ViewCompat.MEASURED_STATE_MASK), getOpMatrix(), paint);
            paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        }
        canvas.drawBitmap(bitmap, getOpMatrix(), paint);
        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void onPrintingDraw(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        getOpMatrix().reset();
        getOpMatrix().postConcat(getMatrix());
        ImageStyle style = getStyle();
        Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
        EdgingStyle edgingStyle = (EdgingStyle) style;
        ColorFilter colorFilter = paint.getColorFilter();
        paint.setColorFilter(null);
        Bitmap bitmap = getBitmap();
        if (edgingStyle.getIsRedTintColor()) {
            bitmap = drawRedBitmap(getBitmap());
        }
        if (edgingStyle.getIsReverse()) {
            canvas.drawBitmap(drawRectBitmap(getBitmap().getWidth(), getBitmap().getHeight(), ViewCompat.MEASURED_STATE_MASK), getOpMatrix(), paint);
            paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        }
        canvas.drawBitmap(bitmap, getOpMatrix(), paint);
        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
        }
    }
}
