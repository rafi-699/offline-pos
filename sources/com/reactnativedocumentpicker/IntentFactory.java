package com.reactnativedocumentpicker;

import android.content.Intent;
import android.os.Build;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/reactnativedocumentpicker/IntentFactory;", "", "<init>", "()V", "getPickIntent", "Landroid/content/Intent;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/reactnativedocumentpicker/PickOptions;", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntentFactory {
    public static final IntentFactory INSTANCE = new IntentFactory();

    private IntentFactory() {
    }

    public final Intent getPickIntent(PickOptions options) {
        String intentFilterTypes;
        Intrinsics.checkNotNullParameter(options, "options");
        Intent intent = new Intent(options.getAction());
        String[] mimeTypes = options.getMimeTypes();
        if (mimeTypes.length > 1) {
            intent.putExtra("android.intent.extra.MIME_TYPES", mimeTypes);
            intentFilterTypes = options.getIntentFilterTypes();
        } else {
            intentFilterTypes = mimeTypes[0];
        }
        intent.setType(intentFilterTypes);
        if (Build.VERSION.SDK_INT >= 26 && options.getInitialDirectoryUrl() != null) {
            intent.putExtra("android.provider.extra.INITIAL_URI", options.getInitialDirectoryUrl());
        }
        if (!options.getAllowVirtualFiles()) {
            intent.addCategory("android.intent.category.OPENABLE");
        }
        intent.putExtra("android.intent.extra.LOCAL_ONLY", options.getLocalOnly());
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", options.getMultiple());
        return intent;
    }
}
