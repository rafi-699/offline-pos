package com.ask.printersdk.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import com.ask.printersdk.utils.LogUtil;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: BaseExtends.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0007\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f\u001aD\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0011*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0015\u001aD\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0011*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0011\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0018\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f\u001a\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0018\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0015\u001a\u001c\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u001a\u0012\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0015\u001a\u0012\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0015¨\u0006!"}, d2 = {"click", "", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View$OnClickListener;", "finishActivity", "Landroidx/fragment/app/Fragment;", "getStringArgument", "", SDKConstants.PARAM_KEY, "def", "getStringArrayArgument", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getIntArgument", "", "getBooleanArgument", "", "getIntArrayArgument", "getLongArgument", "", "Landroid/app/Activity;", "setViewBgRoundCorner", "radius", "", ViewProps.ELEVATION, "visibleOrGone", "show", "visibleOrInvisible", "printersdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BaseExtendsKt {
    public static final void click(final View view, final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Ref.LongRef longRef = new Ref.LongRef();
        final long j = 500;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.base.BaseExtendsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseExtendsKt.click$lambda$0(longRef, j, listener, view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void click$lambda$0(Ref.LongRef longRef, long j, Function1 function1, View view, View view2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - longRef.element > j) {
            longRef.element = jCurrentTimeMillis;
            function1.invoke(view);
        } else {
            LogUtil.w("点击过快，取消触发");
        }
    }

    public static /* synthetic */ void click$default(View view, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            onClickListener = null;
        }
        click(view, onClickListener);
    }

    @BindingAdapter(requireAll = false, value = {"click"})
    public static final void click(final View view, final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.base.BaseExtendsKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseExtendsKt.click$lambda$1(onClickListener, view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void click$lambda$1(View.OnClickListener onClickListener, View view, View view2) {
        if (!PUtil.isButtonDoubleClick()) {
            onClickListener.onClick(view);
        } else {
            LogUtil.w("点击过快，取消触发");
        }
    }

    public static final void finishActivity(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ String getStringArgument$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getStringArgument(fragment, str, str2);
    }

    public static final String getStringArgument(Fragment fragment, String key, String def) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(def, "def");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return def;
        }
        Bundle arguments2 = fragment.getArguments();
        return String.valueOf(arguments2 != null ? arguments2.getString(key) : null);
    }

    public static /* synthetic */ ArrayList getStringArrayArgument$default(Fragment fragment, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = null;
        }
        return getStringArrayArgument(fragment, str, arrayList);
    }

    public static final ArrayList<String> getStringArrayArgument(Fragment fragment, String key, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return arrayList;
        }
        Bundle arguments2 = fragment.getArguments();
        if (arguments2 != null) {
            return arguments2.getStringArrayList(key);
        }
        return null;
    }

    public static /* synthetic */ int getIntArgument$default(Fragment fragment, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return getIntArgument(fragment, str, i);
    }

    public static final int getIntArgument(Fragment fragment, String key, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return i;
        }
        Bundle arguments2 = fragment.getArguments();
        Intrinsics.checkNotNull(arguments2);
        return arguments2.getInt(key, i);
    }

    public static /* synthetic */ boolean getBooleanArgument$default(Fragment fragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getBooleanArgument(fragment, str, z);
    }

    public static final boolean getBooleanArgument(Fragment fragment, String key, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return z;
        }
        Bundle arguments2 = fragment.getArguments();
        Intrinsics.checkNotNull(arguments2);
        return arguments2.getBoolean(key, z);
    }

    public static /* synthetic */ ArrayList getIntArrayArgument$default(Fragment fragment, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = null;
        }
        return getIntArrayArgument(fragment, str, arrayList);
    }

    public static final ArrayList<Integer> getIntArrayArgument(Fragment fragment, String key, ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return arrayList;
        }
        Bundle arguments2 = fragment.getArguments();
        if (arguments2 != null) {
            return arguments2.getIntegerArrayList(key);
        }
        return null;
    }

    public static /* synthetic */ long getLongArgument$default(Fragment fragment, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLongArgument(fragment, str, j);
    }

    public static final long getLongArgument(Fragment fragment, String key, long j) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey(key)) {
            return j;
        }
        Bundle arguments2 = fragment.getArguments();
        Intrinsics.checkNotNull(arguments2);
        return arguments2.getLong(key, j);
    }

    public static /* synthetic */ String getStringArgument$default(Activity activity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getStringArgument(activity, str, str2);
    }

    public static final String getStringArgument(Activity activity, String key, String def) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(def, "def");
        return activity.getIntent().hasExtra(key) ? String.valueOf(activity.getIntent().getStringExtra(key)) : def;
    }

    public static /* synthetic */ long getLongArgument$default(Activity activity, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLongArgument(activity, str, j);
    }

    public static final long getLongArgument(Activity activity, String key, long j) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return activity.getIntent().hasExtra(key) ? activity.getIntent().getLongExtra(key, j) : j;
    }

    public static /* synthetic */ boolean getBooleanArgument$default(Activity activity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getBooleanArgument(activity, str, z);
    }

    public static final boolean getBooleanArgument(Activity activity, String key, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return activity.getIntent().hasExtra(key) ? activity.getIntent().getBooleanExtra(key, z) : z;
    }

    public static /* synthetic */ void setViewBgRoundCorner$default(View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        setViewBgRoundCorner(view, f, f2);
    }

    public static final void setViewBgRoundCorner(View view, final float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.ask.printersdk.base.BaseExtendsKt.setViewBgRoundCorner.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
            }
        });
        view.setElevation(f2);
        view.setClipToOutline(true);
    }

    public static final void visibleOrGone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final void visibleOrInvisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }
}
