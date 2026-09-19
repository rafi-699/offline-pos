package com.ask.printersdk.graph.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ask.printersdk.utils.PUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageCache.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/ask/printersdk/graph/common/ImageCache;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "imageMap", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "getImageMap", "()Ljava/util/HashMap;", "getImage", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "resId", "", "getImageSource", "resName", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCache {
    private final Context context;
    private final HashMap<String, Bitmap> imageMap;

    public ImageCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.imageMap = new HashMap<>();
    }

    public final Context getContext() {
        return this.context;
    }

    public final HashMap<String, Bitmap> getImageMap() {
        return this.imageMap;
    }

    public final Bitmap getImage(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.imageMap.containsKey(path)) {
            return this.imageMap.get(path);
        }
        Bitmap bitmapFromFile = PUtil.getBitmapFromFile(this.context, path);
        if (bitmapFromFile == null) {
            return null;
        }
        this.imageMap.put(path, bitmapFromFile);
        return bitmapFromFile;
    }

    public final Bitmap getImage(int resId) {
        String string = new StringBuilder().append(resId).toString();
        if (this.imageMap.containsKey(string)) {
            return this.imageMap.get(string);
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.context.getResources(), resId);
        this.imageMap.put(string, bitmapDecodeResource);
        return bitmapDecodeResource;
    }

    public final Bitmap getImageSource(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        String str = resName;
        if (this.imageMap.containsKey(str)) {
            return this.imageMap.get(str);
        }
        Resources resources = this.context.getResources();
        Context context = this.context;
        int identifier = resources.getIdentifier(resName, "drawable", context != null ? context.getPackageName() : null);
        if (identifier == 0) {
            return null;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.context.getResources(), identifier);
        this.imageMap.put(str, bitmapDecodeResource);
        return bitmapDecodeResource;
    }
}
