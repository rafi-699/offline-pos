package com.ask.printersdk.ui.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.KBaseAdapter;
import com.ask.printersdk.base.dialog.BaseDialogFragment;
import com.ask.printersdk.databinding.FloatMenuItemBinding;
import com.gyf.immersionbar.ImmersionBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatMenuDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00108\u001a\u000203H\u0016J&\u00109\u001a\u0004\u0018\u00010\u000b2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u000203H\u0004J\u000e\u0010A\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010B\u001a\u000203H\u0014J\u0010\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020EH\u0016J\u001a\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010J\u001a\u00020KH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R7\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u000203\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006L"}, d2 = {"Lcom/ask/printersdk/ui/dialog/FloatMenuDialog;", "Lcom/ask/printersdk/base/dialog/BaseDialogFragment;", "<init>", "()V", "wrapperLayout", "Landroid/widget/FrameLayout;", "getWrapperLayout", "()Landroid/widget/FrameLayout;", "setWrapperLayout", "(Landroid/widget/FrameLayout;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "viewMargin", "Landroid/graphics/Rect;", "getViewMargin", "()Landroid/graphics/Rect;", "setViewMargin", "(Landroid/graphics/Rect;)V", "viewSize", "Landroid/util/Size;", "getViewSize", "()Landroid/util/Size;", "setViewSize", "(Landroid/util/Size;)V", "dataSource", "", "", "getDataSource", "()Ljava/util/List;", "setDataSource", "(Ljava/util/List;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "selectText", "getSelectText", "()Ljava/lang/String;", "setSelectText", "(Ljava/lang/String;)V", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initWindow", "initView", "initImmersionBar", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "setLayoutId", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatMenuDialog extends BaseDialogFragment {
    private Function1<? super String, Unit> callback;
    private RecyclerView recyclerView;
    private View rootView;
    private FrameLayout wrapperLayout;
    private Rect viewMargin = new Rect();
    private Size viewSize = new Size(0, 0);
    private List<String> dataSource = CollectionsKt.emptyList();
    private String selectText = "";

    public final FrameLayout getWrapperLayout() {
        return this.wrapperLayout;
    }

    public final void setWrapperLayout(FrameLayout frameLayout) {
        this.wrapperLayout = frameLayout;
    }

    protected final View getRootView() {
        return this.rootView;
    }

    protected final void setRootView(View view) {
        this.rootView = view;
    }

    public final Rect getViewMargin() {
        return this.viewMargin;
    }

    public final void setViewMargin(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.viewMargin = rect;
    }

    public final Size getViewSize() {
        return this.viewSize;
    }

    public final void setViewSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.viewSize = size;
    }

    public final List<String> getDataSource() {
        return this.dataSource;
    }

    public final void setDataSource(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataSource = list;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final String getSelectText() {
        return this.selectText;
    }

    public final void setSelectText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectText = str;
    }

    public final Function1<String, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super String, Unit> function1) {
        this.callback = function1;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initWindow();
        FrameLayout frameLayout = this.wrapperLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.FloatMenuDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatMenuDialog.onStart$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(FloatMenuDialog floatMenuDialog, View view) {
        if (floatMenuDialog.canceledOnTouchOutside) {
            floatMenuDialog.dismissAllowingStateLoss();
        }
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.wrapperLayout = frameLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.viewSize.getWidth(), this.viewSize.getHeight());
        if (this.viewMargin.left == 0) {
            layoutParams.gravity = 8388661;
        } else {
            layoutParams.gravity = 8388659;
        }
        layoutParams.setMargins(this.viewMargin.left, this.viewMargin.top, this.viewMargin.right, this.viewMargin.bottom);
        Intrinsics.checkNotNull(viewOnCreateView);
        viewOnCreateView.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = this.wrapperLayout;
        Intrinsics.checkNotNull(frameLayout2);
        frameLayout2.addView(viewOnCreateView);
        viewOnCreateView.setClickable(true);
        this.rootView = viewOnCreateView;
        initView(viewOnCreateView);
        return this.wrapperLayout;
    }

    protected final void initWindow() {
        this.mWindow.setGravity(17);
        this.mWindow.setWindowAnimations(R.style.FadeAnimation);
        this.mWindow.setLayout(-1, -1);
        Window window = this.mWindow;
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        window.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.transparent));
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.dimAmount = 0.0f;
        this.mWindow.setAttributes(attributes);
    }

    public final void initView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        Intrinsics.checkNotNull(recyclerView);
        new KBaseAdapter.Builder(recyclerView).setData(this.dataSource).setLayoutId(R.layout.float_menu_item).addBindView(new Function3() { // from class: com.ask.printersdk.ui.dialog.FloatMenuDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FloatMenuDialog.initView$lambda$2(this.f$0, (View) obj, (String) obj2, ((Integer) obj3).intValue());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(final FloatMenuDialog floatMenuDialog, View itemView, final String itemData, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        FloatMenuItemBinding floatMenuItemBinding = (FloatMenuItemBinding) DataBindingUtil.bind(itemView);
        if (floatMenuItemBinding == null) {
            return Unit.INSTANCE;
        }
        floatMenuItemBinding.contentText.setText(itemData);
        if (Intrinsics.areEqual(floatMenuDialog.selectText, itemData)) {
            floatMenuItemBinding.statusSelect.setVisibility(0);
        } else {
            floatMenuItemBinding.statusSelect.setVisibility(4);
        }
        BaseExtendsKt.click(itemView, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.dialog.FloatMenuDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatMenuDialog.initView$lambda$2$lambda$1(this.f$0, itemData, (View) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2$lambda$1(FloatMenuDialog floatMenuDialog, String str, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        floatMenuDialog.selectText = str;
        Function1<? super String, Unit> function1 = floatMenuDialog.callback;
        if (function1 != null) {
            function1.invoke(str);
        }
        floatMenuDialog.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with((DialogFragment) this).navigationBarColor(R.color.transparent).init();
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.mWindow.setLayout(-1, -1);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(tag);
        if (fragmentFindFragmentByTag != null) {
            manager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        try {
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected int setLayoutId() {
        return R.layout.dialog_float_menu;
    }
}
