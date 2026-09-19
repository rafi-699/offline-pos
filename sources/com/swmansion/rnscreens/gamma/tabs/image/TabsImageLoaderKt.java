package com.swmansion.rnscreens.gamma.tabs.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.swmansion.rnscreens.gamma.tabs.TabScreen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TabsImageLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a,\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0002\u001a\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u000e"}, d2 = {"loadTabImage", "", "context", "Landroid/content/Context;", "uri", "", ViewHierarchyConstants.VIEW_KEY, "Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "loadTabImageInternal", "onLoaded", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "resolveTabImageSource", "Lcom/swmansion/rnscreens/gamma/tabs/image/RNSImageSource;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TabsImageLoaderKt {
    public static final void loadTabImage(Context context, String uri, final TabScreen view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(view, "view");
        loadTabImageInternal(context, uri, new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.image.TabsImageLoaderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsImageLoaderKt.loadTabImage$lambda$1(view, (Drawable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadTabImage$lambda$1(final TabScreen tabScreen, final Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.image.TabsImageLoaderKt$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                tabScreen.setIcon(drawable);
            }
        });
        return Unit.INSTANCE;
    }

    private static final void loadTabImageInternal(final Context context, final String str, final Function1<? super Drawable, Unit> function1) {
        Uri uri;
        RNSImageSource rNSImageSourceResolveTabImageSource = resolveTabImageSource(context, str);
        if (rNSImageSourceResolveTabImageSource == null) {
            return;
        }
        if (rNSImageSourceResolveTabImageSource instanceof RNSImageSource.DrawableRes) {
            uri = Uri.parse("res://" + context.getPackageName() + DomExceptionUtils.SEPARATOR + ((RNSImageSource.DrawableRes) rNSImageSourceResolveTabImageSource).getResId());
        } else {
            if (!(rNSImageSourceResolveTabImageSource instanceof RNSImageSource.UriString)) {
                throw new NoWhenBranchMatchedException();
            }
            uri = Uri.parse(((RNSImageSource.UriString) rNSImageSourceResolveTabImageSource).getUri());
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), context).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.swmansion.rnscreens.gamma.tabs.image.TabsImageLoaderKt.loadTabImageInternal.1
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                CloseableReference<CloseableImage> result;
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished() && (result = dataSource.getResult()) != null) {
                    CloseableImage closeableImage = result.get();
                    Intrinsics.checkNotNullExpressionValue(closeableImage, "get(...)");
                    CloseableImage closeableImage2 = closeableImage;
                    if (closeableImage2 instanceof CloseableStaticBitmap) {
                        Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap();
                        Intrinsics.checkNotNullExpressionValue(underlyingBitmap, "getUnderlyingBitmap(...)");
                        Resources resources = context.getResources();
                        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                        function1.invoke(new BitmapDrawable(resources, underlyingBitmap));
                    }
                    result.close();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Log.e("[RNScreens]", "Error loading image: " + str, dataSource.getFailureCause());
            }
        }, CallerThreadExecutor.getInstance());
    }

    private static final RNSImageSource resolveTabImageSource(Context context, String str) {
        if (StringsKt.startsWith$default(str, "_", false, 2, (Object) null)) {
            int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            if (identifier != 0) {
                return new RNSImageSource.DrawableRes(identifier);
            }
            int identifier2 = context.getResources().getIdentifier(str, "raw", context.getPackageName());
            if (identifier2 != 0) {
                return new RNSImageSource.DrawableRes(identifier2);
            }
            Log.e("[RNScreens]", "Resource not found in drawable or raw: " + str);
            return null;
        }
        return new RNSImageSource.UriString(str);
    }
}
