package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.graph.common.CodeEncoder;
import com.ask.printersdk.graph.style.BarCodeStyle;
import com.ask.printersdk.utils.PUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BarCodeGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/ask/printersdk/graph/BarCodeGraph;", "Lcom/ask/printersdk/graph/ImageGraph;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "drawBarCodeImage", "", "initStyle", "Lcom/ask/printersdk/graph/ImageStyle;", "restoreState", "json", "", "getOrderBy", "", "saveState", "onDraw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onPrintingDraw", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BarCodeGraph extends ImageGraph {
    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 50;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarCodeGraph(Context context) {
        super(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void drawBarCodeImage() {
        ImageStyle style = getStyle();
        Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
        BarCodeStyle barCodeStyle = (BarCodeStyle) style;
        Bitmap bitmapSyncEncodeBarcode = CodeEncoder.INSTANCE.syncEncodeBarcode(barCodeStyle.getContentText(), 300, 80, PUtil.spToPx(barCodeStyle.getTextFontSize(), getContext()), barCodeStyle.getIsRedTintColor() ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK, barCodeStyle.getPositionStyle(), barCodeStyle.getCodeType());
        if (bitmapSyncEncodeBarcode != null) {
            setBitmap(bitmapSyncEncodeBarcode);
        }
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public ImageStyle initStyle() {
        return new BarCodeStyle();
    }

    @Override // com.ask.printersdk.graph.ImageGraph, com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        super.restoreState(json);
        Object object = JSON.parseObject(json, (Class<Object>) BarCodeStyle.class);
        Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        setStyle((ImageStyle) object);
        drawBarCodeImage();
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
        ColorFilter colorFilter = paint.getColorFilter();
        paint.setColorFilter(null);
        canvas.drawBitmap(getBitmap(), getOpMatrix(), paint);
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
        ColorFilter colorFilter = paint.getColorFilter();
        paint.setColorFilter(null);
        canvas.drawBitmap(getBitmap(), getOpMatrix(), paint);
        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
        }
    }
}
