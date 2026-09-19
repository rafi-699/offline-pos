package cn.lailaixiong.funnyprint.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Base64;
import androidx.core.view.ViewCompat;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: ImageUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcn/lailaixiong/funnyprint/util/ImageUtil;", "", "<init>", "()V", "Companion", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ImageUtil.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J*\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0002J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010'\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0016J\u001e\u0010*\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u001e\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u0016\u0010-\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/J\u0018\u00100\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\bJ\u0010\u00102\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u001e\u00103\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020/2\u0006\u0010\t\u001a\u00020/J\u000e\u00104\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u00106\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005¨\u00067"}, d2 = {"Lcn/lailaixiong/funnyprint/util/ImageUtil$Companion;", "", "<init>", "()V", "scaleAndCropImage", "Landroid/graphics/Bitmap;", "image", "targetWidth", "", "targetHeight", "scaleAndCropImageHigh", "rotateImage", "toRotation", "defaultGrayImage", "grayImage", "brightGrayImage", "threshold", "value", "ditherImageToBinaryBuffer", "", "ditherImage", "booleanArrayToBinaryBuffer", "Ljava/nio/ByteBuffer;", "bits", "", "extractGrayscaleArray", "", "bitmap", "applyFloydSteinbergDithering", "grayscale", "width", "height", "diffuseError", "", "buffer", FirebaseAnalytics.Param.INDEX, "error", "factor", "bitmapToBase64String", "bitmapToBinaryBuffer", "sw", "byteBufferToBase64String", "binaryBufferToGrayImage", "binaryBase64ToBitmap", "binaryBase64", "increaseContrast", "contrast", "", "sharpenImage", "sharpenValue", "ensureInRange", "scaleLabelImage", "transparentToWhite", "toSketchImage", "toTextImage", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int ensureInRange(int value) {
            if (value > 255) {
                return 255;
            }
            if (value < 0) {
                return 0;
            }
            return value;
        }

        private Companion() {
        }

        public final Bitmap scaleAndCropImage(Bitmap image, int targetWidth, int targetHeight) {
            Intrinsics.checkNotNullParameter(image, "image");
            int height = (int) (((double) targetWidth) * (((double) image.getHeight()) / ((double) image.getWidth())));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(targetWidth, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setFilterBitmap(false);
            paint.setDither(false);
            paint.setAntiAlias(false);
            canvas.drawBitmap(image, (Rect) null, new RectF(0.0f, 0.0f, targetWidth, height), paint);
            if (11 > targetHeight || targetHeight >= height) {
                return bitmapCreateBitmap;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, (height - targetHeight) / 2, targetWidth, targetHeight);
            Intrinsics.checkNotNull(bitmapCreateBitmap2);
            return bitmapCreateBitmap2;
        }

        public final Bitmap scaleAndCropImageHigh(Bitmap image, int targetWidth, int targetHeight) {
            Intrinsics.checkNotNullParameter(image, "image");
            int height = (int) (((double) targetWidth) * (((double) image.getHeight()) / ((double) image.getWidth())));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(targetWidth, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setDither(true);
            paint.setAntiAlias(true);
            canvas.drawBitmap(image, (Rect) null, new RectF(0.0f, 0.0f, targetWidth, height), paint);
            if (11 > targetHeight || targetHeight >= height) {
                return bitmapCreateBitmap;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, (height - targetHeight) / 2, targetWidth, targetHeight);
            Intrinsics.checkNotNull(bitmapCreateBitmap2);
            return bitmapCreateBitmap2;
        }

        public final Bitmap rotateImage(Bitmap image, int toRotation) {
            Intrinsics.checkNotNullParameter(image, "image");
            int width = image.getWidth();
            int height = image.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(toRotation);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image, 0, 0, width, height, matrix, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            return bitmapCreateBitmap;
        }

        public final Bitmap defaultGrayImage(Bitmap image) {
            Intrinsics.checkNotNullParameter(image, "image");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(image, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap;
        }

        public final Bitmap grayImage(Bitmap image) {
            Intrinsics.checkNotNullParameter(image, "image");
            int width = image.getWidth();
            int height = image.getHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            int i = width * height;
            int[] iArr = new int[i];
            image.getPixels(iArr, 0, width, 0, 0, width, height);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                int iAlpha = Color.alpha(i3);
                if (iAlpha < 10) {
                    iArr[i2] = -1;
                } else {
                    int iRed = (int) ((((double) Color.red(i3)) * 0.3d) + (((double) Color.green(i3)) * 0.59d) + (((double) Color.blue(i3)) * 0.11d));
                    iArr[i2] = Color.argb(iAlpha, iRed, iRed, iRed);
                }
            }
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        }

        public final Bitmap brightGrayImage(Bitmap image, int threshold, int value) {
            Intrinsics.checkNotNullParameter(image, "image");
            int width = image.getWidth();
            int height = image.getHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            int i = width * height;
            int[] iArr = new int[i];
            image.getPixels(iArr, 0, width, 0, 0, width, height);
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                int iAlpha = Color.alpha(i3);
                if (iAlpha < 10) {
                    iArr[i2] = -1;
                } else {
                    int iRed = (int) ((((double) Color.red(i3)) * 0.3d) + (((double) Color.green(i3)) * 0.59d) + (((double) Color.blue(i3)) * 0.11d));
                    if (iRed < threshold) {
                        iRed = ensureInRange(iRed + value);
                    }
                    iArr[i2] = Color.argb(iAlpha, iRed, iRed, iRed);
                }
            }
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        }

        public static /* synthetic */ String ditherImageToBinaryBuffer$default(Companion companion, Bitmap bitmap, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 128;
            }
            return companion.ditherImageToBinaryBuffer(bitmap, i);
        }

        public final String ditherImageToBinaryBuffer(Bitmap image, int threshold) {
            Intrinsics.checkNotNullParameter(image, "image");
            return byteBufferToBase64String(booleanArrayToBinaryBuffer(applyFloydSteinbergDithering(extractGrayscaleArray(image), image.getWidth(), image.getHeight(), threshold)));
        }

        public final Bitmap ditherImage(Bitmap image) {
            Intrinsics.checkNotNullParameter(image, "image");
            int width = image.getWidth();
            int height = image.getHeight();
            boolean[] zArrApplyFloydSteinbergDithering$default = applyFloydSteinbergDithering$default(this, extractGrayscaleArray(image), width, height, 0, 8, null);
            int[] iArr = new int[width * height];
            int length = zArrApplyFloydSteinbergDithering$default.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = zArrApplyFloydSteinbergDithering$default[i] ? ViewCompat.MEASURED_STATE_MASK : -1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            return bitmapCreateBitmap;
        }

        private final ByteBuffer booleanArrayToBinaryBuffer(boolean[] bits) {
            int length = (bits.length + 7) / 8;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            int length2 = bits.length;
            for (int i = 0; i < length2; i++) {
                if (bits[i]) {
                    int i2 = i / 8;
                    byteBufferAllocate.put(i2, (byte) (((byte) (1 << (7 - (i % 8)))) | byteBufferAllocate.get(i2)));
                }
            }
            byteBufferAllocate.position(length);
            byteBufferAllocate.flip();
            Intrinsics.checkNotNull(byteBufferAllocate);
            return byteBufferAllocate;
        }

        private final byte[] extractGrayscaleArray(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) Color.red(iArr[i2]);
            }
            return bArr;
        }

        static /* synthetic */ boolean[] applyFloydSteinbergDithering$default(Companion companion, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 8) != 0) {
                i3 = 128;
            }
            return companion.applyFloydSteinbergDithering(bArr, i, i2, i3);
        }

        private final boolean[] applyFloydSteinbergDithering(byte[] grayscale, int width, int height, int threshold) {
            boolean[] zArr = new boolean[width * height];
            for (int i = 0; i < height; i++) {
                int i2 = 0;
                while (i2 < width) {
                    int i3 = (i * width) + i2;
                    int i4 = grayscale[i3] & 255;
                    int i5 = i4 < threshold ? 0 : 255;
                    zArr[i3] = i5 == 0;
                    int i6 = i4 - i5;
                    int i7 = i2 + 1;
                    if (i7 < width) {
                        diffuseError(grayscale, i3 + 1, i6, 7);
                    }
                    if (i2 > 0 && i + 1 < height) {
                        diffuseError(grayscale, (i3 + width) - 1, i6, 3);
                    }
                    int i8 = i + 1;
                    if (i8 < height) {
                        diffuseError(grayscale, i3 + width, i6, 5);
                    }
                    if (i7 < width && i8 < height) {
                        diffuseError(grayscale, i3 + width + 1, i6, 1);
                    }
                    i2 = i7;
                }
            }
            return zArr;
        }

        private final void diffuseError(byte[] buffer, int index, int error, int factor) {
            buffer[index] = (byte) RangesKt.coerceIn((buffer[index] & 255) + ((error * factor) / 16), 0, 255);
        }

        public final String bitmapToBase64String(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        public final ByteBuffer bitmapToBinaryBuffer(Bitmap bitmap, int sw) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((i + 7) / 8);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                i3 <<= 1;
                if (Color.red(iArr[i4]) < sw) {
                    i3 |= 1;
                }
                i2++;
                if (i2 == 8) {
                    byteBufferAllocate.put((byte) i3);
                    i2 = 0;
                    i3 = 0;
                }
            }
            if (i2 > 0) {
                byteBufferAllocate.put((byte) (i3 << (8 - i2)));
            }
            byteBufferAllocate.flip();
            Intrinsics.checkNotNull(byteBufferAllocate);
            return byteBufferAllocate;
        }

        public final String byteBufferToBase64String(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            String strEncodeToString = Base64.encodeToString(bArr, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        public final Bitmap binaryBufferToGrayImage(ByteBuffer buffer, int width, int height) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < height; i3++) {
                for (int i4 = 0; i4 < width; i4++) {
                    if (i2 == 0) {
                        i = buffer.get();
                        if (i < 0) {
                            i += 256;
                        }
                        i2 = 8;
                    }
                    int i5 = (i & 128) == 128 ? 255 : 0;
                    bitmapCreateBitmap.setPixel(i4, i3, Color.rgb(i5, i5, i5));
                    i <<= 1;
                    i2--;
                }
            }
            return bitmapCreateBitmap;
        }

        public final Bitmap binaryBase64ToBitmap(String binaryBase64, int width, int height) {
            Intrinsics.checkNotNullParameter(binaryBase64, "binaryBase64");
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(Base64.decode(binaryBase64, 2));
            Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
            return binaryBufferToGrayImage(byteBufferWrap, width, height);
        }

        public final Bitmap increaseContrast(Bitmap bitmap, float contrast) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{contrast, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, contrast, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, contrast, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap;
        }

        public static /* synthetic */ Bitmap sharpenImage$default(Companion companion, Bitmap bitmap, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 15;
            }
            return companion.sharpenImage(bitmap, i);
        }

        public final Bitmap sharpenImage(Bitmap bitmap, int sharpenValue) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int[] iArr2 = new int[i];
            int[][] iArr3 = {new int[]{-1, -1, -1}, new int[]{-1, sharpenValue, -1}, new int[]{-1, -1, -1}};
            int i2 = height - 1;
            for (int i3 = 1; i3 < i2; i3++) {
                int i4 = width - 1;
                for (int i5 = 1; i5 < i4; i5++) {
                    int iRed = 0;
                    int iGreen = 0;
                    int iBlue = 0;
                    for (int i6 = 0; i6 < 3; i6++) {
                        for (int i7 = 0; i7 < 3; i7++) {
                            int i8 = iArr[(((i3 + i6) - 1) * width) + ((i5 + i7) - 1)];
                            int i9 = iArr3[i6][i7];
                            iRed += Color.red(i8) * i9;
                            iGreen += Color.green(i8) * i9;
                            iBlue += Color.blue(i8) * i9;
                        }
                    }
                    iArr2[(i3 * width) + i5] = Color.rgb(RangesKt.coerceIn(iRed, 0, 255), RangesKt.coerceIn(iGreen, 0, 255), RangesKt.coerceIn(iBlue, 0, 255));
                }
            }
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
            bitmapCreateBitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        }

        public final Bitmap scaleLabelImage(Bitmap image, float targetWidth, float targetHeight) {
            Intrinsics.checkNotNullParameter(image, "image");
            float f = 384;
            float fFloor = (float) Math.floor(((double) (targetWidth * f)) / 50.0d);
            int iFloor = (int) Math.floor((targetHeight * fFloor) / targetWidth);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(384, iFloor, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            float f2 = targetWidth < 50.0f ? f - fFloor : 0.0f;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawBitmap(image, new Rect(0, 0, image.getWidth(), image.getHeight()), new Rect((int) f2, 0, (int) (f2 + fFloor), iFloor), paint);
            return bitmapCreateBitmap;
        }

        public final Bitmap transparentToWhite(Bitmap image) {
            Intrinsics.checkNotNullParameter(image, "image");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(image, 0.0f, 0.0f, new Paint());
            return bitmapCreateBitmap;
        }

        public final Bitmap toSketchImage(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Mat mat = new Mat(bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC1);
            Utils.bitmapToMat(bitmap, mat);
            Mat mat2 = new Mat();
            Imgproc.cvtColor(mat, mat2, 6);
            mat.release();
            Mat mat3 = new Mat();
            Imgproc.GaussianBlur(mat2, mat3, new Size(3.0d, 3.0d), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE);
            mat2.release();
            Mat mat4 = new Mat();
            Imgproc.Laplacian(mat3, mat4, 0, 5);
            mat3.release();
            Mat mat5 = new Mat();
            Imgproc.threshold(mat4, mat5, 200.0d, 255.0d, 1);
            mat4.release();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mat5.cols(), mat5.rows(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Utils.matToBitmap(mat5, bitmapCreateBitmap);
            mat5.release();
            return bitmapCreateBitmap;
        }

        public final Bitmap toTextImage(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Mat mat = new Mat(bitmap.getWidth(), bitmap.getHeight(), CvType.CV_8UC1);
            Utils.bitmapToMat(bitmap, mat);
            Mat mat2 = new Mat();
            Imgproc.cvtColor(mat, mat2, 6);
            mat.release();
            Mat mat3 = new Mat();
            Imgproc.blur(mat2, mat3, new Size(30.0d, 30.0d));
            Mat mat4 = new Mat();
            Core.divide(mat2, mat3, mat4, 255.0d, 0);
            mat3.release();
            mat2.release();
            Mat mat5 = new Mat();
            Imgproc.bilateralFilter(mat4, mat5, 5, 10, ((double) 5) / ((double) 2));
            Imgproc.adaptiveThreshold(mat5, mat5, 255.0d, 1, 0, 49, 10);
            Mat mat6 = new Mat();
            Imgproc.threshold(mat5, mat6, 230.0d, 255.0d, 0);
            mat5.release();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mat6.cols(), mat6.rows(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Utils.matToBitmap(mat6, bitmapCreateBitmap);
            mat6.release();
            return bitmapCreateBitmap;
        }
    }
}
