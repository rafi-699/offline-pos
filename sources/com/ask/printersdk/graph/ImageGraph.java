package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.graph.common.GraphUtil;
import com.ask.printersdk.utils.BitmapUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020)H\u0016J\u000e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020%H\u0016J\b\u00100\u001a\u00020%H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020%2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0016J8\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u0002082\u0006\u0010=\u001a\u0002082\u0006\u0010>\u001a\u0002082\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0016J \u0010?\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J \u0010D\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0006\u0010E\u001a\u00020%J\b\u0010F\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020\u0005H\u0016J\u0010\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0005H\u0016J\u001e\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020MJ\u000e\u0010P\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010Q\u001a\u000202H\u0016J\b\u0010R\u001a\u00020MH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006S"}, d2 = {"Lcom/ask/printersdk/graph/ImageGraph;", "Lcom/ask/printersdk/graph/BaseGraph;", "context", "Landroid/content/Context;", "imagePath", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "opMatrix", "Landroid/graphics/Matrix;", "getOpMatrix", "()Landroid/graphics/Matrix;", "matrix", "getMatrix", "matrixValues", "", "getMatrixValues", "()[F", "style", "Lcom/ask/printersdk/graph/ImageStyle;", "getStyle", "()Lcom/ask/printersdk/graph/ImageStyle;", "setStyle", "(Lcom/ask/printersdk/graph/ImageStyle;)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "setDrawBoardInfo", "", "boardStyle", "Lcom/ask/printersdk/graph/BoardStyle;", "getId", "", "setId", "id", "setEqualScale", "equalRatio", "", "reset", "rotate", "getBound", "Landroid/graphics/RectF;", "getBound2Board", "getScalePoint", "Landroid/graphics/PointF;", "moveGraph", "distanceX", "", "distanceY", "scaleGraph", "startX", "startY", "endX", "endY", "onDraw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onPrintingDraw", "handleOpMatrix", "initStyle", "Lcom/ask/printersdk/graph/Style;", "saveState", "restoreState", "json", "drawRectBitmap", "imageWidth", "", "imageHeight", "color", "drawRedBitmap", "originRect", "getOrderBy", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageGraph extends BaseGraph {
    private Bitmap bitmap;
    private final Context context;
    private String imagePath;
    private final Matrix matrix;
    private final float[] matrixValues;
    private final Matrix opMatrix;
    private ImageStyle style;

    @Override // com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 20;
    }

    public ImageGraph(Context context, String imagePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        this.context = context;
        this.imagePath = imagePath;
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.matrixValues = fArr;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        this.bitmap = bitmapCreateBitmap;
        this.opMatrix = new Matrix();
        this.matrix = new Matrix();
        ImageStyle imageStyleInitStyle = initStyle();
        this.style = imageStyleInitStyle;
        imageStyleInitStyle.setImagePath(this.imagePath);
    }

    public /* synthetic */ ImageGraph(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imagePath = str;
    }

    public final Matrix getOpMatrix() {
        return this.opMatrix;
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    public final float[] getMatrixValues() {
        return this.matrixValues;
    }

    @Override // com.ask.printersdk.graph.Graph
    public final ImageStyle getStyle() {
        return this.style;
    }

    public final void setStyle(ImageStyle imageStyle) {
        Intrinsics.checkNotNullParameter(imageStyle, "<set-?>");
        this.style = imageStyle;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<set-?>");
        this.bitmap = bitmap;
    }

    @Override // com.ask.printersdk.graph.BaseGraph, com.ask.printersdk.graph.Graph
    public void setDrawBoardInfo(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "boardStyle");
        super.setDrawBoardInfo(boardStyle);
        RectF rectFOriginRect = originRect();
        float f = 1.0f;
        if (boardStyle.getDrawBoardWidth() > 0 && boardStyle.getDrawBoardHeight() > 0) {
            float fCalculateInSampleSize = BitmapUtil.calculateInSampleSize(this.bitmap, boardStyle.getDrawBoardWidth(), boardStyle.getDrawBoardHeight());
            if (fCalculateInSampleSize != 1.0f) {
                this.matrix.postScale(fCalculateInSampleSize, fCalculateInSampleSize);
            }
            f = fCalculateInSampleSize;
        }
        if (boardStyle.getIsPictureEditing()) {
            this.matrix.postTranslate((boardStyle.getDrawBoardWidth() - (rectFOriginRect.width() * f)) / 2, boardStyle.getDrawBoardBottom());
        } else {
            float f2 = 2;
            this.matrix.postTranslate((boardStyle.getDrawBoardWidth() - (rectFOriginRect.width() * f)) / f2, (boardStyle.getDrawBoardHeight() - (rectFOriginRect.height() * f)) / f2);
        }
        this.matrix.getValues(this.matrixValues);
    }

    @Override // com.ask.printersdk.graph.Graph
    public long getId() {
        return this.style.getId();
    }

    @Override // com.ask.printersdk.graph.Graph
    public void setId(long id) {
        this.style.setId(id);
    }

    public final void setEqualScale(boolean equalRatio) {
        this.style.setEqualRatioScale(equalRatio);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void reset() {
        this.matrix.setValues(this.matrixValues);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void rotate() {
        RectF rectFOriginRect = originRect();
        this.matrix.mapRect(rectFOriginRect);
        this.matrix.postRotate(90.0f, rectFOriginRect.centerX(), rectFOriginRect.centerY());
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound() {
        RectF rectFOriginRect = originRect();
        handleOpMatrix();
        this.opMatrix.mapRect(rectFOriginRect);
        return rectFOriginRect;
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound2Board() {
        RectF rectFOriginRect = originRect();
        this.matrix.mapRect(rectFOriginRect);
        return rectFOriginRect;
    }

    @Override // com.ask.printersdk.graph.Graph
    public PointF getScalePoint() {
        RectF rectFOriginRect = originRect();
        float[] fArr = {rectFOriginRect.width(), rectFOriginRect.height()};
        handleOpMatrix();
        this.opMatrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void moveGraph(float distanceX, float distanceY) {
        this.matrix.postTranslate(distanceX, distanceY);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void scaleGraph(float startX, float startY, float endX, float endY, float distanceX, float distanceY) {
        RectF rectFOriginRect = originRect();
        float fMatrixWidth = GraphUtil.INSTANCE.matrixWidth(this.matrix, rectFOriginRect.width());
        float fMatrixHeight = GraphUtil.INSTANCE.matrixHeight(this.matrix, rectFOriginRect.height());
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.matrix.getValues(fArr);
        double degrees = Math.toDegrees(Math.atan2(fArr[3], fArr[0]));
        Matrix matrix = new Matrix();
        matrix.preRotate((float) degrees);
        float[] fArr2 = {distanceY, distanceX};
        matrix.mapPoints(fArr2);
        float f = (fArr2[1] + fMatrixWidth) / fMatrixWidth;
        this.matrix.preScale(f, !this.style.getEqualRatioScale() ? (fArr2[0] + fMatrixHeight) / fMatrixHeight : f);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onDraw(Context context, Canvas canvas, Paint paint) {
        ColorFilter colorFilter;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        handleOpMatrix();
        if (this.style.getContrast() != 50) {
            colorFilter = paint.getColorFilter();
            paint.setColorFilter(BitmapUtil.changeBitmapContrast(this.style.getContrast()));
        } else {
            colorFilter = null;
        }
        canvas.drawBitmap(this.bitmap, this.opMatrix, paint);
        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onPrintingDraw(Context context, Canvas canvas, Paint paint) {
        ColorFilter colorFilter;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.matrix);
        if (this.style.getContrast() != 50) {
            colorFilter = paint.getColorFilter();
            paint.setColorFilter(BitmapUtil.changeBitmapContrast(this.style.getContrast()));
        } else {
            colorFilter = null;
        }
        canvas.drawBitmap(this.bitmap, this.opMatrix, paint);
        if (colorFilter != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public final void handleOpMatrix() {
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.matrix);
        this.opMatrix.postConcat(getBoardStyle().getMatrix());
    }

    @Override // com.ask.printersdk.graph.Graph
    public ImageStyle initStyle() {
        return new ImageStyle();
    }

    @Override // com.ask.printersdk.graph.Graph
    public Style getStyle() {
        return this.style;
    }

    @Override // com.ask.printersdk.graph.Graph
    public String saveState() {
        this.matrix.getValues(this.style.getMatrixValues());
        String jSONString = JSON.toJSONString(this.style);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object object = JSON.parseObject(json, (Class<Object>) ImageStyle.class);
        Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        ImageStyle imageStyle = (ImageStyle) object;
        this.style = imageStyle;
        this.matrix.setValues(imageStyle.getMatrixValues());
    }

    public final Bitmap drawRectBitmap(int imageWidth, int imageHeight, int color) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageWidth, imageHeight, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawColor(color);
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public final Bitmap drawRedBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_STATE_MASK, SupportMenu.CATEGORY_MASK));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public RectF originRect() {
        return new RectF(0.0f, 0.0f, this.bitmap.getWidth(), this.bitmap.getHeight());
    }
}
