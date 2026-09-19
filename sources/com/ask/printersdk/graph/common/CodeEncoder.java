package com.ask.printersdk.graph.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodeEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJF\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007JL\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eJ4\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u001a\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0002JB\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fJ6\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\fJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000eH\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006+"}, d2 = {"Lcom/ask/printersdk/graph/common/CodeEncoder;", "", "<init>", "()V", "HINTS", "", "Lcom/google/zxing/EncodeHintType;", "getHINTS", "()Ljava/util/Map;", "syncEncodeQRCode", "Landroid/graphics/Bitmap;", "content", "", "size", "", ViewProps.FOREGROUND_COLOR, "logo", "backgroundColor", "codeFormatText", "border", "context", "Landroid/content/Context;", ViewProps.BORDER_COLOR, "addBorderToQRCode", "src", "addLogoToQRCode", "syncEncodeBarcode", "width", "height", "textSize", ViewProps.POSITION, "showContent", "barcodeBitmap", "getTextWidth", "", "dp2px", "dpValue", "codeFormatTextToBarcodeFormat", "Lcom/google/zxing/BarcodeFormat;", "updateBit", "Lcom/google/zxing/common/BitMatrix;", "matrix", ViewProps.MARGIN, "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeEncoder {
    private static final Map<EncodeHintType, Object> HINTS;
    public static final CodeEncoder INSTANCE = new CodeEncoder();

    public final Bitmap syncEncodeQRCode(String str, int i) {
        return syncEncodeQRCode$default(this, str, i, 0, 0, null, null, 60, null);
    }

    public final Bitmap syncEncodeQRCode(String str, int i, int i2) {
        return syncEncodeQRCode$default(this, str, i, i2, 0, null, null, 56, null);
    }

    public final Bitmap syncEncodeQRCode(String str, int i, int i2, int i3) {
        return syncEncodeQRCode$default(this, str, i, i2, i3, null, null, 48, null);
    }

    public final Bitmap syncEncodeQRCode(String str, int i, int i2, int i3, String codeFormatText) {
        Intrinsics.checkNotNullParameter(codeFormatText, "codeFormatText");
        return syncEncodeQRCode$default(this, str, i, i2, i3, codeFormatText, null, 32, null);
    }

    private CodeEncoder() {
    }

    static {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        HINTS = enumMap;
        enumMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        enumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        enumMap.put(EncodeHintType.MARGIN, 0);
    }

    public final Map<EncodeHintType, Object> getHINTS() {
        return HINTS;
    }

    public final Bitmap syncEncodeQRCode(String content, int size, int foregroundColor, Bitmap logo) {
        return syncEncodeQRCode(content, size, foregroundColor, -1, "QR_CODE", logo);
    }

    public static /* synthetic */ Bitmap syncEncodeQRCode$default(CodeEncoder codeEncoder, String str, int i, int i2, int i3, String str2, Bitmap bitmap, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = ViewCompat.MEASURED_STATE_MASK;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            str2 = "QR_CODE";
        }
        String str3 = str2;
        if ((i4 & 32) != 0) {
            bitmap = null;
        }
        return codeEncoder.syncEncodeQRCode(str, i, i5, i6, str3, bitmap);
    }

    public final Bitmap syncEncodeQRCode(String content, int size, int foregroundColor, int backgroundColor, String codeFormatText, Bitmap logo) {
        Intrinsics.checkNotNullParameter(codeFormatText, "codeFormatText");
        try {
            Map<EncodeHintType, ?> map = HINTS;
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            if (Intrinsics.areEqual(codeFormatText, "PDF_417") || Intrinsics.areEqual(codeFormatText, "AZTEC")) {
                map.put(EncodeHintType.ERROR_CORRECTION, 2);
            }
            BitMatrix bitMatrixEncode = new MultiFormatWriter().encode(content, codeFormatTextToBarcodeFormat(codeFormatText), size, size, map);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int i2 = 0; i2 < width; i2++) {
                    if (bitMatrixEncode.get(i2, i)) {
                        iArr[(i * width) + i2] = foregroundColor;
                    } else {
                        iArr[(i * width) + i2] = backgroundColor;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            return addLogoToQRCode(bitmapCreateBitmap, logo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap syncEncodeQRCode(String content, int size, int foregroundColor, int backgroundColor, Bitmap logo, int border, Context context, int borderColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iDp2px = size - (((int) dp2px(context, 4.0f)) * 2);
        try {
            BitMatrix bitMatrixEncode = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, iDp2px, iDp2px, HINTS);
            int[] iArr = new int[iDp2px * iDp2px];
            for (int i = 0; i < iDp2px; i++) {
                for (int i2 = 0; i2 < iDp2px; i2++) {
                    if (bitMatrixEncode.get(i2, i)) {
                        iArr[(i * iDp2px) + i2] = foregroundColor;
                    } else {
                        iArr[(i * iDp2px) + i2] = backgroundColor;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDp2px, iDp2px, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            bitmapCreateBitmap.setPixels(iArr, 0, iDp2px, 0, 0, iDp2px, iDp2px);
            return addBorderToQRCode(context, addLogoToQRCode(bitmapCreateBitmap, logo), backgroundColor, border, borderColor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Bitmap addBorderToQRCode(Context context, Bitmap src, int backgroundColor, int border, int borderColor) {
        if (src == null) {
            return src;
        }
        if (borderColor == 0) {
            borderColor = Color.parseColor("#63C99B");
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int iDp2px = (int) dp2px(context, 4.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width + iDp2px, height + iDp2px, Bitmap.Config.ARGB_8888);
        try {
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(backgroundColor);
            if (border != 0) {
                Paint paint = new Paint();
                paint.setColor(borderColor);
                paint.setStrokeWidth(iDp2px);
                if (border == 1) {
                    paint.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
                }
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(0.0f, 0.0f, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), paint);
            }
            float f = iDp2px / 2.0f;
            canvas.drawBitmap(src, f, f, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Bitmap addLogoToQRCode(Bitmap src, Bitmap logo) {
        if (logo == null) {
            return src;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = logo.getWidth();
        int height2 = logo.getHeight();
        float f = ((width * 1.0f) / 5) / width2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f, f, width / 2, height / 2);
            canvas.drawBitmap(logo, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
        } catch (Exception e) {
            e.printStackTrace();
            bitmapCreateBitmap = null;
        }
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public final Bitmap syncEncodeBarcode(String content, int width, int height, int textSize, int foregroundColor, int position, String codeFormatText) {
        Intrinsics.checkNotNullParameter(codeFormatText, "codeFormatText");
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 1);
        float textWidth = getTextWidth(textSize, content == null ? "" : content);
        int i = textWidth > ((float) width) ? (int) textWidth : width;
        int color = Color.parseColor("#ffffff");
        try {
            BitMatrix bitMatrixEncode = new MultiFormatWriter().encode(content, codeFormatTextToBarcodeFormat(codeFormatText), i, height, map);
            Intrinsics.checkNotNull(bitMatrixEncode);
            BitMatrix bitMatrixUpdateBit = updateBit(bitMatrixEncode, 0);
            int width2 = bitMatrixUpdateBit.getWidth();
            int height2 = bitMatrixUpdateBit.getHeight();
            int[] iArr = new int[width2 * height2];
            for (int i2 = 0; i2 < height2; i2++) {
                for (int i3 = 0; i3 < width2; i3++) {
                    if (bitMatrixUpdateBit.get(i3, i2)) {
                        iArr[(i2 * width2) + i3] = foregroundColor;
                    } else {
                        iArr[(i2 * width2) + i3] = color;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            bitmapCreateBitmap.setPixels(iArr, 0, width2, 0, 0, width2, height2);
            return textSize > 0 ? showContent(bitmapCreateBitmap, content, textSize, foregroundColor, position) : bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Bitmap showContent(Bitmap barcodeBitmap, String content, int textSize, int foregroundColor, int position) {
        if (TextUtils.isEmpty(content) || barcodeBitmap == null || position == 1) {
            return barcodeBitmap;
        }
        Paint paint = new Paint();
        paint.setColor(foregroundColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
        float fMeasureText = paint.measureText(content);
        float width = (fMeasureText / barcodeBitmap.getWidth()) * 1.0f;
        float height = barcodeBitmap.getHeight() / barcodeBitmap.getWidth();
        int width2 = barcodeBitmap.getWidth();
        int height2 = barcodeBitmap.getHeight();
        Matrix matrix = new Matrix();
        if (width > 1.0f) {
            width2 = (int) fMeasureText;
            height2 = (int) (width2 * height);
            matrix.postScale(width, width);
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int i = (int) (fontMetrics.bottom - fontMetrics.top);
        int i2 = height2 + i;
        double d = ((double) i) * 1.5d;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2 + ((int) d), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas();
        canvas.drawColor(-1);
        canvas.setBitmap(bitmapCreateBitmap);
        if (position == 0) {
            Intrinsics.checkNotNull(content);
            canvas.drawText(content, width2 / 2, i, paint);
            matrix.postTranslate(0.0f, (float) d);
            canvas.drawBitmap(barcodeBitmap, matrix, null);
        } else {
            canvas.drawBitmap(barcodeBitmap, matrix, null);
            Intrinsics.checkNotNull(content);
            canvas.drawText(content, width2 / 2, i2, paint);
        }
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public final float getTextWidth(int textSize, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
        return paint.measureText(content);
    }

    public final float dp2px(Context context, float dpValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (dpValue * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final BarcodeFormat codeFormatTextToBarcodeFormat(String codeFormatText) {
        Intrinsics.checkNotNullParameter(codeFormatText, "codeFormatText");
        switch (codeFormatText.hashCode()) {
            case -1868159152:
                if (codeFormatText.equals("RSS_14")) {
                    return BarcodeFormat.RSS_14;
                }
                break;
            case -1319933914:
                if (codeFormatText.equals("RSS_EXPANDED")) {
                    return BarcodeFormat.RSS_EXPANDED;
                }
                break;
            case -1030320650:
                if (codeFormatText.equals("DATA_MATRIX")) {
                    return BarcodeFormat.DATA_MATRIX;
                }
                break;
            case -84093723:
                if (codeFormatText.equals("CODE_128")) {
                    return BarcodeFormat.CODE_128;
                }
                break;
            case 72827:
                if (codeFormatText.equals("ITF")) {
                    return BarcodeFormat.ITF;
                }
                break;
            case 160877:
                if (codeFormatText.equals("PDF_417")) {
                    return BarcodeFormat.PDF_417;
                }
                break;
            case 62792985:
                if (codeFormatText.equals("AZTEC")) {
                    return BarcodeFormat.AZTEC;
                }
                break;
            case 65737323:
                if (codeFormatText.equals("EAN_8")) {
                    return BarcodeFormat.EAN_8;
                }
                break;
            case 80949962:
                if (codeFormatText.equals("UPC_A")) {
                    return BarcodeFormat.UPC_A;
                }
                break;
            case 80949966:
                if (codeFormatText.equals("UPC_E")) {
                    return BarcodeFormat.UPC_E;
                }
                break;
            case 1310753099:
                if (codeFormatText.equals("QR_CODE")) {
                    return BarcodeFormat.QR_CODE;
                }
                break;
            case 1659855352:
                if (codeFormatText.equals("CODE_39")) {
                    return BarcodeFormat.CODE_39;
                }
                break;
            case 1659855532:
                if (codeFormatText.equals("CODE_93")) {
                    return BarcodeFormat.CODE_93;
                }
                break;
            case 2037856847:
                if (codeFormatText.equals("EAN_13")) {
                    return BarcodeFormat.EAN_13;
                }
                break;
        }
        return BarcodeFormat.CODE_128;
    }

    private final BitMatrix updateBit(BitMatrix matrix, int margin) {
        int i = margin * 2;
        int[] enclosingRectangle = matrix.getEnclosingRectangle();
        int i2 = enclosingRectangle[2] + i;
        int i3 = enclosingRectangle[3] + i;
        BitMatrix bitMatrix = new BitMatrix(i2, i3);
        bitMatrix.clear();
        int i4 = i2 - margin;
        for (int i5 = margin; i5 < i4; i5++) {
            int i6 = i3 - margin;
            for (int i7 = margin; i7 < i6; i7++) {
                if (matrix.get((i5 - margin) + enclosingRectangle[0], (i7 - margin) + enclosingRectangle[1])) {
                    bitMatrix.set(i5, i7);
                }
            }
        }
        return bitMatrix;
    }
}
