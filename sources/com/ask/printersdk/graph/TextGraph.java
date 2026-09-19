package com.ask.printersdk.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.R;
import com.ask.printersdk.graph.common.GraphUtil;
import com.ask.printersdk.utils.PUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextGraph.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010;\u001a\u00020\u000fH\u0016J\u000e\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)J\b\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020CH\u0016J\u000e\u0010F\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020)J\u000e\u0010I\u001a\u0002062\u0006\u0010H\u001a\u00020JJ\u000e\u0010K\u001a\u0002062\u0006\u0010H\u001a\u00020JJ \u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020PJ\u000e\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020PJ\u000e\u0010U\u001a\u0002062\u0006\u0010V\u001a\u00020PJ\u0010\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020)J\u0010\u0010Z\u001a\u0002062\b\b\u0002\u0010Y\u001a\u00020)J\u0010\u0010[\u001a\u0002062\b\b\u0002\u0010Y\u001a\u00020)J\b\u0010\\\u001a\u000206H\u0003J\u0010\u0010]\u001a\u00020P2\u0006\u0010^\u001a\u00020\u0005H\u0002J\u000e\u0010_\u001a\u00020J2\u0006\u0010`\u001a\u00020\u001dJ\b\u0010a\u001a\u000206H\u0016J\b\u0010b\u001a\u000206H\u0016J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020dH\u0016J\b\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u0002062\u0006\u0010i\u001a\u00020J2\u0006\u0010j\u001a\u00020JH\u0016J8\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020J2\u0006\u0010o\u001a\u00020J2\u0006\u0010i\u001a\u00020J2\u0006\u0010j\u001a\u00020JH\u0016J\u0010\u0010p\u001a\u00020J2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u000206H\u0002J \u0010t\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0016J\u001e\u0010y\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010u\u001a\u00020v2\u0006\u0010z\u001a\u00020dJ \u0010{\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010\u0010\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020\u0005H\u0016J\u0010\u0010~\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u0005H\u0016J\t\u0010\u0080\u0001\u001a\u00020)H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R7\u00101\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u000206\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006\u0081\u0001"}, d2 = {"Lcom/ask/printersdk/graph/TextGraph;", "Lcom/ask/printersdk/graph/BaseGraph;", "context", "Landroid/content/Context;", "text", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "style", "Lcom/ask/printersdk/graph/TextStyle;", "getStyle", "()Lcom/ask/printersdk/graph/TextStyle;", "setStyle", "(Lcom/ask/printersdk/graph/TextStyle;)V", "opMatrix", "Landroid/graphics/Matrix;", "getOpMatrix", "()Landroid/graphics/Matrix;", "matrix", "getMatrix", "boundMatrix", "getBoundMatrix", "textLayout", "Landroid/text/StaticLayout;", "getTextLayout", "()Landroid/text/StaticLayout;", "setTextLayout", "(Landroid/text/StaticLayout;)V", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "setTextPaint", "(Landroid/text/TextPaint;)V", "boundInitWidth", "", "getBoundInitWidth", "()I", "setBoundInitWidth", "(I)V", "boundInitHeight", "getBoundInitHeight", "setBoundInitHeight", "textFontSizeChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "fontSize", "", "getTextFontSizeChange", "()Lkotlin/jvm/functions/Function1;", "setTextFontSizeChange", "(Lkotlin/jvm/functions/Function1;)V", "initStyle", "measureTextWidth", "boardMaxWidth", "getDrawText", "setDrawBoardInfo", "boardStyle", "Lcom/ask/printersdk/graph/BoardStyle;", "getId", "", "setId", "id", "updateText", "updateTextSize", "size", "updateTextLetterSpacing", "", "updateTextLineSpacing", "updateTextTypeface", "fontTypeface", "fontIdentifier", "isLocal", "", "updateTextBold", TtmlNode.BOLD, "updateTextUnderLine", "underLine", "updateTextItalic", TtmlNode.ITALIC, "getTextAlign", "Landroid/text/Layout$Alignment;", "align", "updateTextAlign", "updateToBoundLayoutAlign", "handleTextTypeface", "isFontExists", "fontName", "getTextRealWidth", "staticLayout", "reset", "rotate", "getBound", "Landroid/graphics/RectF;", "getBound2Board", "getScalePoint", "Landroid/graphics/PointF;", "moveGraph", "distanceX", "distanceY", "scaleGraph", "startX", "startY", "endX", "endY", "createStaticLayout", "rect", "Landroid/graphics/Rect;", "handleOpMatrix", "onDraw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "onPictureDraw", "contentBounds", "onPrintingDraw", "Lcom/ask/printersdk/graph/Style;", "saveState", "restoreState", "json", "getOrderBy", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextGraph extends BaseGraph {
    private int boundInitHeight;
    private int boundInitWidth;
    private final Matrix boundMatrix;
    private final Context context;
    private final Matrix matrix;
    private final Matrix opMatrix;
    private TextStyle style;
    private String text;
    private Function1<? super Integer, Unit> textFontSizeChange;
    private StaticLayout textLayout;
    private TextPaint textPaint;

    @Override // com.ask.printersdk.graph.Graph
    public int getOrderBy() {
        return 80;
    }

    public TextGraph(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        this.context = context;
        this.text = text;
        TextStyle textStyleInitStyle = initStyle();
        this.style = textStyleInitStyle;
        textStyleInitStyle.setText(this.text);
        this.style.setPaintColor(PUtil.getColor(context, R.color.color_000));
        this.opMatrix = new Matrix();
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setColor(this.style.getPaintColor());
        if (Build.VERSION.SDK_INT >= 29) {
            this.textPaint.underlineColor = this.style.getPaintColor();
        }
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(PUtil.dip2px(context, this.style.getPaintTextSize()));
        this.matrix = new Matrix();
        this.boundMatrix = new Matrix();
    }

    public /* synthetic */ TextGraph(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @Override // com.ask.printersdk.graph.Graph
    public final TextStyle getStyle() {
        return this.style;
    }

    public final void setStyle(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.style = textStyle;
    }

    public final Matrix getOpMatrix() {
        return this.opMatrix;
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    public final Matrix getBoundMatrix() {
        return this.boundMatrix;
    }

    public final StaticLayout getTextLayout() {
        return this.textLayout;
    }

    public final void setTextLayout(StaticLayout staticLayout) {
        this.textLayout = staticLayout;
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final void setTextPaint(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "<set-?>");
        this.textPaint = textPaint;
    }

    public final int getBoundInitWidth() {
        return this.boundInitWidth;
    }

    public final void setBoundInitWidth(int i) {
        this.boundInitWidth = i;
    }

    public final int getBoundInitHeight() {
        return this.boundInitHeight;
    }

    public final void setBoundInitHeight(int i) {
        this.boundInitHeight = i;
    }

    public final Function1<Integer, Unit> getTextFontSizeChange() {
        return this.textFontSizeChange;
    }

    public final void setTextFontSizeChange(Function1<? super Integer, Unit> function1) {
        this.textFontSizeChange = function1;
    }

    @Override // com.ask.printersdk.graph.Graph
    public TextStyle initStyle() {
        return new TextStyle();
    }

    public final int measureTextWidth(int boardMaxWidth) {
        float f = 0.0f;
        for (String str : StringsKt.split$default((CharSequence) getDrawText(), new String[]{"\n"}, false, 0, 6, (Object) null)) {
            TextPaint textPaint = this.textPaint;
            Intrinsics.checkNotNull(textPaint);
            float fMeasureText = textPaint.measureText(str);
            if (fMeasureText > f) {
                f = fMeasureText;
            }
        }
        return ((float) boardMaxWidth) > f ? (int) f : boardMaxWidth;
    }

    private final String getDrawText() {
        String str = this.text;
        if (str == null || StringsKt.isBlank(str)) {
            return "Input some text";
        }
        return this.text;
    }

    @Override // com.ask.printersdk.graph.BaseGraph, com.ask.printersdk.graph.Graph
    public void setDrawBoardInfo(BoardStyle boardStyle) {
        Intrinsics.checkNotNullParameter(boardStyle, "boardStyle");
        super.setDrawBoardInfo(boardStyle);
        int iMeasureTextWidth = measureTextWidth(boardStyle.getDrawBoardWidth());
        this.textLayout = new StaticLayout(getDrawText(), this.textPaint, iMeasureTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (boardStyle.getIsPictureEditing()) {
            Matrix matrix = this.matrix;
            int drawBoardWidth = boardStyle.getDrawBoardWidth();
            StaticLayout staticLayout = this.textLayout;
            Intrinsics.checkNotNull(staticLayout);
            matrix.postTranslate((drawBoardWidth - staticLayout.getWidth()) / 2, boardStyle.getDrawBoardBottom());
        } else {
            Matrix matrix2 = this.matrix;
            int drawBoardWidth2 = boardStyle.getDrawBoardWidth();
            StaticLayout staticLayout2 = this.textLayout;
            Intrinsics.checkNotNull(staticLayout2);
            float width = drawBoardWidth2 - staticLayout2.getWidth();
            float f = 2;
            int drawBoardHeight = boardStyle.getDrawBoardHeight();
            StaticLayout staticLayout3 = this.textLayout;
            Intrinsics.checkNotNull(staticLayout3);
            matrix2.postTranslate(width / f, (drawBoardHeight - staticLayout3.getHeight()) / f);
        }
        this.matrix.getValues(this.style.getMatrixValues());
        this.boundInitWidth = Math.min(iMeasureTextWidth * 2, boardStyle.getDrawBoardWidth());
        StaticLayout staticLayout4 = this.textLayout;
        Intrinsics.checkNotNull(staticLayout4);
        this.boundInitHeight = staticLayout4.getHeight();
        this.boundMatrix.set(this.matrix);
        this.boundMatrix.getValues(this.style.getBoundMatrixValues());
    }

    @Override // com.ask.printersdk.graph.Graph
    public long getId() {
        return this.style.getId();
    }

    @Override // com.ask.printersdk.graph.Graph
    public void setId(long id) {
        this.style.setId(id);
    }

    public final void updateText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.style.setText(text);
        int iMatrixWidth = (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        int iMatrixHeight = (int) GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        StaticLayout staticLayout = new StaticLayout(getDrawText(), this.textPaint, iMatrixWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.textLayout = staticLayout;
        Intrinsics.checkNotNull(staticLayout);
        int height = staticLayout.getHeight();
        if (height > iMatrixHeight) {
            this.boundMatrix.preScale(1.0f, height / iMatrixHeight);
        }
    }

    public final void updateTextSize(int size) {
        this.style.setPaintTextSize(size);
        this.textPaint.setTextSize(PUtil.dip2px(this.context, this.style.getPaintTextSize()));
        int iMatrixWidth = (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        int iMatrixHeight = (int) GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        StaticLayout staticLayout = new StaticLayout(getDrawText(), this.textPaint, iMatrixWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.textLayout = staticLayout;
        Intrinsics.checkNotNull(staticLayout);
        this.boundMatrix.preScale(1.0f, staticLayout.getHeight() / iMatrixHeight);
    }

    public final void updateTextLetterSpacing(float size) {
        this.style.setLetterDistance(size);
        this.textPaint.setLetterSpacing(size);
        int iMatrixWidth = (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        int iMatrixHeight = (int) GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        StaticLayout staticLayout = new StaticLayout(getDrawText(), this.textPaint, iMatrixWidth, Layout.Alignment.ALIGN_NORMAL, this.style.getLineDistance(), 0.0f, false);
        this.textLayout = staticLayout;
        Intrinsics.checkNotNull(staticLayout);
        this.boundMatrix.preScale(1.0f, staticLayout.getHeight() / iMatrixHeight);
    }

    public final void updateTextLineSpacing(float size) {
        this.style.setLineDistance(size);
        int iMatrixWidth = (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        int iMatrixHeight = (int) GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        StaticLayout staticLayout = new StaticLayout(getDrawText(), this.textPaint, iMatrixWidth, Layout.Alignment.ALIGN_NORMAL, this.style.getLineDistance(), 0.0f, false);
        this.textLayout = staticLayout;
        Intrinsics.checkNotNull(staticLayout);
        this.boundMatrix.preScale(1.0f, staticLayout.getHeight() / iMatrixHeight);
    }

    public static /* synthetic */ void updateTextTypeface$default(TextGraph textGraph, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextTypeface");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        textGraph.updateTextTypeface(str, str2, z);
    }

    public final void updateTextTypeface(String fontTypeface, String fontIdentifier, boolean isLocal) {
        Intrinsics.checkNotNullParameter(fontTypeface, "fontTypeface");
        Intrinsics.checkNotNullParameter(fontIdentifier, "fontIdentifier");
        this.style.setFontTypeface(fontTypeface);
        this.style.setFontIdentifier(fontIdentifier);
        handleTextTypeface();
    }

    public final void updateTextBold(boolean bold) {
        this.style.setBold(bold);
        handleTextTypeface();
    }

    public final void updateTextUnderLine(boolean underLine) {
        this.style.setUnderLine(underLine);
        if (underLine) {
            this.textPaint.setUnderlineText(true);
        } else {
            this.textPaint.setUnderlineText(false);
        }
    }

    public final void updateTextItalic(boolean italic) {
        this.style.setItalic(italic);
        handleTextTypeface();
    }

    public static /* synthetic */ Layout.Alignment getTextAlign$default(TextGraph textGraph, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTextAlign");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return textGraph.getTextAlign(i);
    }

    public final Layout.Alignment getTextAlign(int align) {
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        if (align != 1) {
            return align != 2 ? alignment : Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    public static /* synthetic */ void updateTextAlign$default(TextGraph textGraph, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextAlign");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        textGraph.updateTextAlign(i);
    }

    public final void updateTextAlign(int align) {
        this.style.setAlign(align);
        this.textLayout = new StaticLayout(getDrawText(), this.textPaint, (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth), getTextAlign(align), this.style.getLineDistance(), 0.0f, false);
    }

    public static /* synthetic */ void updateToBoundLayoutAlign$default(TextGraph textGraph, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateToBoundLayoutAlign");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        textGraph.updateToBoundLayoutAlign(i);
    }

    public final void updateToBoundLayoutAlign(int align) {
        this.style.setToBoundLayoutAlign(align);
    }

    private final void handleTextTypeface() {
        int i = this.style.getItalic() ? 2 : 0;
        if (this.style.getBold()) {
            i |= 1;
        }
        if (!StringsKt.isBlank(this.style.getFontTypeface()) && isFontExists(this.style.getFontTypeface())) {
            try {
                this.textPaint.setTypeface(Typeface.create(Typeface.createFromFile(new File(this.context.getFilesDir(), "fonts/" + this.style.getFontTypeface()).getAbsolutePath()), i));
                return;
            } catch (Exception unused) {
                this.textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, i));
                return;
            }
        }
        this.textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, i));
    }

    private final boolean isFontExists(String fontName) {
        return new File(new File(this.context.getFilesDir(), "fonts/" + fontName).getAbsolutePath()).exists();
    }

    public final float getTextRealWidth(StaticLayout staticLayout) {
        Intrinsics.checkNotNullParameter(staticLayout, "staticLayout");
        int lineCount = staticLayout.getLineCount();
        float lineWidth = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            if (lineWidth < staticLayout.getLineWidth(i)) {
                lineWidth = staticLayout.getLineWidth(i);
            }
        }
        return lineWidth;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void reset() {
        RectF rectF = new RectF(0.0f, 0.0f, this.boundInitWidth, this.boundInitHeight);
        this.boundMatrix.mapRect(rectF);
        int iWidth = (int) rectF.width();
        this.textLayout = new StaticLayout(getDrawText(), this.textPaint, iWidth, Layout.Alignment.ALIGN_NORMAL, this.style.getLineDistance(), 0.0f, false);
        this.matrix.reset();
        this.boundMatrix.reset();
        Matrix matrix = this.matrix;
        float f = 2;
        float drawBoardWidth = (getBoardStyle().getDrawBoardWidth() - iWidth) / f;
        int drawBoardHeight = getBoardStyle().getDrawBoardHeight();
        StaticLayout staticLayout = this.textLayout;
        Intrinsics.checkNotNull(staticLayout);
        matrix.postTranslate(drawBoardWidth, (drawBoardHeight - staticLayout.getHeight()) / f);
        this.matrix.getValues(this.style.getMatrixValues());
        this.boundInitWidth = iWidth;
        StaticLayout staticLayout2 = this.textLayout;
        Intrinsics.checkNotNull(staticLayout2);
        this.boundInitHeight = staticLayout2.getHeight();
        this.boundMatrix.set(this.matrix);
        this.boundMatrix.getValues(this.style.getBoundMatrixValues());
    }

    @Override // com.ask.printersdk.graph.Graph
    public void rotate() {
        RectF rectF = new RectF(0.0f, 0.0f, this.boundInitWidth, this.boundInitHeight);
        this.boundMatrix.mapRect(rectF);
        this.matrix.postRotate(90.0f, rectF.centerX(), rectF.centerY());
        this.boundMatrix.postRotate(90.0f, rectF.centerX(), rectF.centerY());
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound() {
        RectF rectF = new RectF(0.0f, 0.0f, this.boundInitWidth, this.boundInitHeight);
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.boundMatrix);
        this.opMatrix.postConcat(getBoardStyle().getMatrix());
        this.opMatrix.mapRect(rectF);
        return rectF;
    }

    @Override // com.ask.printersdk.graph.Graph
    public RectF getBound2Board() {
        RectF rectF = new RectF(0.0f, 0.0f, this.boundInitWidth, this.boundInitHeight);
        this.boundMatrix.mapRect(rectF);
        return rectF;
    }

    @Override // com.ask.printersdk.graph.Graph
    public PointF getScalePoint() {
        float[] fArr = {this.boundInitWidth, this.boundInitHeight};
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.boundMatrix);
        this.opMatrix.postConcat(getBoardStyle().getMatrix());
        this.opMatrix.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void moveGraph(float distanceX, float distanceY) {
        this.matrix.postTranslate(distanceX, distanceY);
        this.boundMatrix.postTranslate(distanceX, distanceY);
    }

    @Override // com.ask.printersdk.graph.Graph
    public void scaleGraph(float startX, float startY, float endX, float endY, float distanceX, float distanceY) {
        float fMatrixWidth = GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        float fMatrixHeight = GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = 0.0f;
        }
        this.boundMatrix.getValues(fArr);
        double degrees = Math.toDegrees(Math.atan2(fArr[3], fArr[0]));
        Matrix matrix = new Matrix();
        matrix.preRotate((float) degrees);
        float[] fArr2 = {distanceY, distanceX};
        matrix.mapPoints(fArr2);
        this.boundMatrix.preScale(Math.max((fArr2[1] + fMatrixWidth) / fMatrixWidth, 0.05f), Math.max((fArr2[0] + fMatrixHeight) / fMatrixHeight, 0.05f));
        float fMatrixWidth2 = GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        float fMatrixHeight2 = GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float fAbs = Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom);
        if (fMatrixHeight2 <= fAbs) {
            this.boundMatrix.preScale(1.0f, Math.max(fAbs / fMatrixHeight, 0.05f));
        }
        float fMeasureText = this.textPaint.measureText("好");
        if (fMatrixWidth2 <= fMeasureText) {
            this.boundMatrix.preScale(Math.max(fMeasureText / fMatrixWidth, 0.05f), 1.0f);
        }
        if (this.style.getIsAutoFont()) {
            fMatrixWidth2 = GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
            this.textPaint.setTextSize(Math.min(createStaticLayout(new Rect(0, 0, (int) fMatrixWidth2, (int) GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight))), PUtil.dip2px(this.context, 90.0f)));
            this.style.setPaintTextSize(PUtil.px2dip(this.context, this.textPaint.getTextSize()));
            Function1<? super Integer, Unit> function1 = this.textFontSizeChange;
            if (function1 != null) {
                function1.invoke(Integer.valueOf((int) this.style.getPaintTextSize()));
            }
        }
        this.textLayout = new StaticLayout(getDrawText(), this.textPaint, measureTextWidth((int) fMatrixWidth2), Layout.Alignment.ALIGN_NORMAL, this.style.getLineDistance(), 0.0f, false);
    }

    private final float createStaticLayout(Rect rect) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(textPaint.getTypeface());
        textPaint.setLetterSpacing(textPaint.getLetterSpacing());
        float fHeight = rect.height() * 2;
        float f = 10.0f;
        while (f < fHeight) {
            textPaint.setTextSize(f);
            if (new StaticLayout(getDrawText(), textPaint, rect.width(), Layout.Alignment.ALIGN_NORMAL, this.style.getLineDistance(), 0.0f, false).getHeight() > rect.height() - 10) {
                return f - 0.3f;
            }
            f += 0.3f;
        }
        return f - 0.3f;
    }

    private final void handleOpMatrix() {
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.matrix);
        this.opMatrix.postConcat(getBoardStyle().getMatrix());
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onDraw(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        handleOpMatrix();
        canvas.setMatrix(this.opMatrix);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            int toBoundLayoutAlign = this.style.getToBoundLayoutAlign();
            if (toBoundLayoutAlign == 1) {
                canvas.translate(0.0f, (getBound2Board().height() - staticLayout.getHeight()) / 2.0f);
            } else if (toBoundLayoutAlign == 2) {
                canvas.translate(0.0f, getBound2Board().height() - staticLayout.getHeight());
            }
            staticLayout.draw(canvas);
        }
        canvas.restore();
    }

    public final void onPictureDraw(Context context, Canvas canvas, RectF contentBounds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(contentBounds, "contentBounds");
        canvas.save();
        handleOpMatrix();
        this.opMatrix.postTranslate(-contentBounds.left, -contentBounds.top);
        canvas.setMatrix(this.opMatrix);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            int toBoundLayoutAlign = this.style.getToBoundLayoutAlign();
            if (toBoundLayoutAlign == 1) {
                canvas.translate(0.0f, (getBound2Board().height() - staticLayout.getHeight()) / 2.0f);
            } else if (toBoundLayoutAlign == 2) {
                canvas.translate(0.0f, getBound2Board().height() - staticLayout.getHeight());
            }
            staticLayout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // com.ask.printersdk.graph.Graph
    public void onPrintingDraw(Context context, Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.save();
        this.opMatrix.reset();
        this.opMatrix.postConcat(this.matrix);
        canvas.setMatrix(this.opMatrix);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // com.ask.printersdk.graph.Graph
    public Style getStyle() {
        return this.style;
    }

    @Override // com.ask.printersdk.graph.Graph
    public String saveState() {
        this.matrix.getValues(this.style.getMatrixValues());
        this.boundMatrix.getValues(this.style.getBoundMatrixValues());
        this.style.setBoundInitWidth2Board(this.boundInitWidth / getBoardStyle().getDrawBoardWidth());
        this.style.setBoundInitHeight2Board(this.boundInitHeight / getBoardStyle().getDrawBoardHeight());
        String jSONString = JSON.toJSONString(this.style);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }

    @Override // com.ask.printersdk.graph.Graph
    public void restoreState(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object object = JSON.parseObject(json, (Class<Object>) TextStyle.class);
        Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        TextStyle textStyle = (TextStyle) object;
        this.style = textStyle;
        this.textPaint.setTextSize(PUtil.dip2px(this.context, textStyle.getPaintTextSize()));
        handleTextTypeface();
        if (this.style.getUnderLine()) {
            this.textPaint.setUnderlineText(true);
        } else {
            this.textPaint.setUnderlineText(false);
        }
        this.matrix.setValues(this.style.getMatrixValues());
        this.boundMatrix.setValues(this.style.getBoundMatrixValues());
        this.boundInitWidth = (int) (this.style.getBoundInitWidth2Board() * getBoardStyle().getDrawBoardWidth());
        this.boundInitHeight = (int) (this.style.getBoundInitHeight2Board() * getBoardStyle().getDrawBoardHeight());
        int iMatrixWidth = (int) GraphUtil.INSTANCE.matrixWidth(this.boundMatrix, this.boundInitWidth);
        GraphUtil.INSTANCE.matrixHeight(this.boundMatrix, this.boundInitHeight);
        this.textLayout = new StaticLayout(getDrawText(), this.textPaint, iMatrixWidth, getTextAlign(this.style.getAlign()), this.style.getLineDistance(), 0.0f, false);
    }
}
