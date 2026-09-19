package com.ask.printersdk.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapUtil {
    public static float calculateInSampleSize(Bitmap bitmap, float f, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f3 = width;
        if (f3 > f || height > f2) {
            return Math.min(Math.round((f / f3) * 100.0f) / 100.0f, Math.round((f2 / height) * 100.0f) / 100.0f);
        }
        return 1.0f;
    }

    public static Bitmap convertBlack(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = (width * i) + i2;
                int i4 = iArr[i3];
                int i5 = (int) ((((double) ((16711680 & i4) >> 16)) * 0.3d) + (((double) ((65280 & i4) >> 8)) * 0.59d) + (((double) (i4 & 255)) * 0.11d));
                iArr[i3] = i5 | (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i5 << 8);
            }
        }
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public static Bitmap changeBitmapContrast(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        ColorMatrix colorMatrix = new ColorMatrix();
        float f2 = f + 1.0f;
        float f3 = (((-0.5f) * f2) + 0.5f) * 255.0f;
        colorMatrix.set(new float[]{f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, f2, 0.0f, 0.0f, f3, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static ColorFilter changeBitmapContrast(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        float f2 = (((f / 100.0f) * 2.0f) - 1.0f) + 1.0f;
        float f3 = (((-0.5f) * f2) + 0.5f) * 255.0f;
        colorMatrix.set(new float[]{f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, f2, 0.0f, 0.0f, f3, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        return new ColorMatrixColorFilter(colorMatrix);
    }
}
