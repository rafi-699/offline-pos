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
import com.facebook.react.uimanager.ViewProps;
import com.gyf.immersionbar.ImmersionBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextVerticalLayoutDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010<\u001a\u000207H\u0016J&\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u000207H\u0004J\u000e\u0010E\u001a\u0002072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010F\u001a\u000207H\u0014J\u0010\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020IH\u0016J\u001a\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010N\u001a\u00020$H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R7\u00102\u001a\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u000207\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006O"}, d2 = {"Lcom/ask/printersdk/ui/dialog/TextVerticalLayoutDialog;", "Lcom/ask/printersdk/base/dialog/BaseDialogFragment;", "<init>", "()V", "wrapperLayout", "Landroid/widget/FrameLayout;", "getWrapperLayout", "()Landroid/widget/FrameLayout;", "setWrapperLayout", "(Landroid/widget/FrameLayout;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "viewMargin", "Landroid/graphics/Rect;", "getViewMargin", "()Landroid/graphics/Rect;", "setViewMargin", "(Landroid/graphics/Rect;)V", "viewSize", "Landroid/util/Size;", "getViewSize", "()Landroid/util/Size;", "setViewSize", "(Landroid/util/Size;)V", "titleList", "", "", "getTitleList", "()Ljava/util/List;", "setTitleList", "(Ljava/util/List;)V", "iconList", "", "getIconList", "setIconList", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ViewProps.POSITION, "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initWindow", "initView", "initImmersionBar", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "setLayoutId", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextVerticalLayoutDialog extends BaseDialogFragment {
    private Function1<? super Integer, Unit> callback;
    private RecyclerView recyclerView;
    private View rootView;
    private int selectIndex;
    private FrameLayout wrapperLayout;
    private Rect viewMargin = new Rect();
    private Size viewSize = new Size(0, 0);
    private List<String> titleList = CollectionsKt.listOf((Object[]) new String[]{"顶部对齐", "中部对齐", "顶部对齐"});
    private List<Integer> iconList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.ic_text_align_top), Integer.valueOf(R.drawable.ic_text_align_center), Integer.valueOf(R.drawable.ic_text_align_bottom)});

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

    public final List<String> getTitleList() {
        return this.titleList;
    }

    public final void setTitleList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.titleList = list;
    }

    public final List<Integer> getIconList() {
        return this.iconList;
    }

    public final void setIconList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.iconList = list;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final void setSelectIndex(int i) {
        this.selectIndex = i;
    }

    public final Function1<Integer, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super Integer, Unit> function1) {
        this.callback = function1;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initWindow();
        FrameLayout frameLayout = this.wrapperLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.TextVerticalLayoutDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextVerticalLayoutDialog.onStart$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(TextVerticalLayoutDialog textVerticalLayoutDialog, View view) {
        if (textVerticalLayoutDialog.canceledOnTouchOutside) {
            textVerticalLayoutDialog.dismissAllowingStateLoss();
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
        new KBaseAdapter.Builder(recyclerView).setData(this.titleList).setLayoutId(R.layout.float_menu_item).addBindView(new Function3() { // from class: com.ask.printersdk.ui.dialog.TextVerticalLayoutDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextVerticalLayoutDialog.initView$lambda$2(this.f$0, (View) obj, (String) obj2, ((Integer) obj3).intValue());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(final TextVerticalLayoutDialog textVerticalLayoutDialog, View itemView, String itemData, final int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        FloatMenuItemBinding floatMenuItemBinding = (FloatMenuItemBinding) DataBindingUtil.bind(itemView);
        if (floatMenuItemBinding == null) {
            return Unit.INSTANCE;
        }
        floatMenuItemBinding.contentText.setText(itemData);
        floatMenuItemBinding.contentIcon.setVisibility(0);
        floatMenuItemBinding.contentIcon.setImageResource(textVerticalLayoutDialog.iconList.get(i).intValue());
        if (textVerticalLayoutDialog.selectIndex == i) {
            floatMenuItemBinding.statusSelect.setVisibility(0);
        } else {
            floatMenuItemBinding.statusSelect.setVisibility(4);
        }
        BaseExtendsKt.click(itemView, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.dialog.TextVerticalLayoutDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextVerticalLayoutDialog.initView$lambda$2$lambda$1(this.f$0, i, (View) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2$lambda$1(TextVerticalLayoutDialog textVerticalLayoutDialog, int i, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        textVerticalLayoutDialog.selectIndex = i;
        Function1<? super Integer, Unit> function1 = textVerticalLayoutDialog.callback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        textVerticalLayoutDialog.dismissAllowingStateLoss();
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
