package com.ask.printersdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.alibaba.fastjson.JSON;
import com.ask.printersdk.graph.state.StateNode;
import com.ask.printersdk.ui.PrintEditActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TagPrintingManger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ask/printersdk/TagPrintingManger;", "", "<init>", "()V", "tagCallback", "Lcom/ask/printersdk/TagPrintingManger$TagCallback;", "getTagCallback", "()Lcom/ask/printersdk/TagPrintingManger$TagCallback;", "setTagCallback", "(Lcom/ask/printersdk/TagPrintingManger$TagCallback;)V", "setup", "", "context", "Landroid/content/Context;", "tagWidth", "", "tagHeight", "title", "", "setOnTagCallback", "node", "Lcom/ask/printersdk/graph/state/StateNode;", "jsonString", "startPictureEditing", "setupTitle", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "destroy", "TagCallback", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagPrintingManger {
    public static final TagPrintingManger INSTANCE = new TagPrintingManger();
    private static TagCallback tagCallback;

    /* JADX INFO: compiled from: TagPrintingManger.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bV\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/ask/printersdk/TagPrintingManger$TagCallback;", "", "onPrinting", "", "bitmap", "Landroid/graphics/Bitmap;", "node", "Lcom/ask/printersdk/graph/state/StateNode;", "onSaveDraft", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TagCallback {
        void onPrinting(Bitmap bitmap, StateNode node);

        void onSaveDraft(StateNode node);
    }

    private TagPrintingManger() {
    }

    public final TagCallback getTagCallback() {
        return tagCallback;
    }

    public final void setTagCallback(TagCallback tagCallback2) {
        tagCallback = tagCallback2;
    }

    public static /* synthetic */ void setup$default(TagPrintingManger tagPrintingManger, Context context, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 50;
        }
        if ((i3 & 4) != 0) {
            i2 = 30;
        }
        tagPrintingManger.setup(context, i, i2, str);
    }

    public final void setup(Context context, int tagWidth, int tagHeight, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent(context, (Class<?>) PrintEditActivity.class);
        intent.putExtra("tagWidth", tagWidth);
        intent.putExtra("tagHeight", tagHeight);
        setupTitle(intent, title);
        context.startActivity(intent);
    }

    public final void setOnTagCallback(TagCallback tagCallback2) {
        Intrinsics.checkNotNullParameter(tagCallback2, "tagCallback");
        tagCallback = tagCallback2;
    }

    public final void setup(Context context, StateNode node, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(title, "title");
        String jSONString = JSON.toJSONString(node);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        setup(context, jSONString, title);
    }

    public final void setup(Context context, String jsonString, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent(context, (Class<?>) PrintEditActivity.class);
        intent.putExtra("StateNode", jsonString);
        setupTitle(intent, title);
        context.startActivity(intent);
    }

    public final void startPictureEditing(Context context, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent(context, (Class<?>) PrintEditActivity.class);
        intent.putExtra("isPictureEditing", true);
        setupTitle(intent, title);
        context.startActivity(intent);
    }

    public final void startPictureEditing(Context context, String jsonString, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent(context, (Class<?>) PrintEditActivity.class);
        intent.putExtra("isPictureEditing", true);
        intent.putExtra("StateNode", jsonString);
        setupTitle(intent, title);
        context.startActivity(intent);
    }

    private final void setupTitle(Intent intent, String title) {
        intent.putExtra("Title", title);
    }

    public final void destroy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        tagCallback = null;
        PrintEditActivity companion = PrintEditActivity.INSTANCE.getInstance();
        if (companion != null) {
            companion.finish();
        }
    }
}
