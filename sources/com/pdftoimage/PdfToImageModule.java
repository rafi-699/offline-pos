package com.pdftoimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Base64;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "PdfToImage")
public class PdfToImageModule extends ReactContextBaseJavaModule {
    private static final String E_CONVERT_ERROR = "E_CONVERT_ERROR";
    public static final String NAME = "PdfToImage";
    private static final String TAG = "PdfToImage";
    private ReactApplicationContext context;

    public PdfToImageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PdfToImage";
    }

    @ReactMethod
    public void printPDF(String str, Integer num, String str2, Promise promise) {
        try {
            File fileCreateTempFile = File.createTempFile("pdfToImage", "pdf", this.context.getCacheDir());
            fileCreateTempFile.setWritable(true);
            new FileOutputStream(fileCreateTempFile).write(Base64.getDecoder().decode(str2));
            FileInputStream fileInputStream = new FileInputStream(fileCreateTempFile);
            DataOutputStream dataOutputStream = new DataOutputStream(new Socket(str, num.intValue()).getOutputStream());
            byte[] bArr = new byte[3000];
            while (fileInputStream.read(bArr) != -1) {
                dataOutputStream.write(bArr);
            }
            dataOutputStream.flush();
            promise.resolve(1);
        } catch (ConnectException e) {
            Log.e("PdfToImage", e.toString(), e);
            promise.reject(e.toString(), e.getLocalizedMessage());
        } catch (UnknownHostException e2) {
            Log.e("PdfToImage", e2.toString(), e2);
            promise.reject(e2.toString(), e2.getLocalizedMessage());
        } catch (IOException e3) {
            Log.e("PdfToImage", e3.toString(), e3);
            promise.reject(e3.toString(), e3.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void convertB64(String str, int i, Promise promise) {
        try {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            File fileCreateTempFile = File.createTempFile("pdfToImage", "pdf", this.context.getCacheDir());
            fileCreateTempFile.setWritable(true);
            new FileOutputStream(fileCreateTempFile).write(Base64.getDecoder().decode(str));
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(fileCreateTempFile, 268435456));
            int pageCount = pdfRenderer.getPageCount();
            for (int i2 = 0; i2 < pageCount; i2++) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i2);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, (pageOpenPage.getHeight() * i) / pageOpenPage.getWidth(), Bitmap.Config.ARGB_8888);
                new Canvas(bitmapCreateBitmap).drawColor(-1);
                pageOpenPage.render(bitmapCreateBitmap, null, null, 2);
                File fileSaveImage = saveImage(bitmapCreateBitmap, this.context.getCacheDir());
                pageOpenPage.close();
                writableArrayCreateArray.pushString(fileSaveImage.getAbsolutePath());
            }
            writableMapCreateMap.putArray("outputFiles", writableArrayCreateArray);
            promise.resolve(writableMapCreateMap);
            pdfRenderer.close();
            fileCreateTempFile.delete();
        } catch (Exception e) {
            promise.reject(E_CONVERT_ERROR, e);
        }
    }

    @ReactMethod
    public void convert(String str, Promise promise) {
        try {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            PdfRenderer pdfRenderer = new PdfRenderer(this.context.getContentResolver().openFileDescriptor(Uri.parse(str), "r"));
            int pageCount = pdfRenderer.getPageCount();
            for (int i = 0; i < pageCount; i++) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth(), pageOpenPage.getHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(bitmapCreateBitmap).drawColor(-1);
                pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                File fileSaveImage = saveImage(bitmapCreateBitmap, this.context.getCacheDir());
                pageOpenPage.close();
                writableArrayCreateArray.pushString(fileSaveImage.getAbsolutePath());
            }
            writableMapCreateMap.putArray("outputFiles", writableArrayCreateArray);
            promise.resolve(writableMapCreateMap);
            pdfRenderer.close();
        } catch (Exception e) {
            promise.reject(E_CONVERT_ERROR, e);
        }
    }

    private File saveImage(Bitmap bitmap, File file) {
        File file2 = new File(file.getAbsolutePath() + File.separator + System.currentTimeMillis() + "_pdf.png");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
