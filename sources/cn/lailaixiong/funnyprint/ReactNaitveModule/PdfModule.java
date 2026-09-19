package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import com.bleplx.adapter.utils.Constants;
import com.bumptech.glide.load.Key;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/PdfModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "toImages", "", "file", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getName", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PdfModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @ReactMethod
    public final void toImages(String file, Promise promise) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(new File(URLDecoder.decode(file, Key.STRING_CHARSET_NAME)), 268435456));
            ArrayList arrayList = new ArrayList();
            int pageCount = pdfRenderer.getPageCount();
            for (int i = 0; i < pageCount; i++) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i);
                Intrinsics.checkNotNullExpressionValue(pageOpenPage, "openPage(...)");
                float f = 200 / 72.0f;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (pageOpenPage.getWidth() * f), (int) (pageOpenPage.getHeight() * f), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                bitmapCreateBitmap.eraseColor(-1);
                Matrix matrix = new Matrix();
                matrix.setScale(f, f);
                pageOpenPage.render(bitmapCreateBitmap, null, matrix, 1);
                File fileCreateTempFile = File.createTempFile("pdfimage" + i, ".jpg", getReactApplicationContext().getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                arrayList.add(fileCreateTempFile.getAbsolutePath());
                pageOpenPage.close();
            }
            pdfRenderer.close();
            promise.resolve(Arguments.fromList(arrayList));
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(Constants.BluetoothLogLevel.ERROR, "Could not convert PDF to images", e);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PdfModule";
    }
}
