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
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.R;
import com.ask.printersdk.base.dialog.BaseDialogFragment;
import com.ask.printersdk.databinding.DialogModifyDateBinding;
import com.ask.printersdk.utils.DateUtil;
import com.github.gzuliyujiang.wheelpicker.contract.OnDateSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.gyf.immersionbar.ImmersionBar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifyDateDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010@\u001a\u000205H\u0016J&\u0010A\u001a\u0004\u0018\u00010\u000b2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u000205H\u0004J\u000e\u0010I\u001a\u0002052\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020+H\u0002J\b\u0010L\u001a\u000205H\u0002J\u0006\u0010M\u001a\u000205J\b\u0010N\u001a\u000205H\u0014J\u0010\u0010O\u001a\u0002052\u0006\u0010P\u001a\u00020QH\u0016J\u001a\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010V\u001a\u00020WH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.Ra\u00101\u001aI\u0012\u0013\u0012\u00110 ¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110+¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(*\u0012\u0004\u0012\u000205\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006X"}, d2 = {"Lcom/ask/printersdk/ui/dialog/ModifyDateDialog;", "Lcom/ask/printersdk/base/dialog/BaseDialogFragment;", "<init>", "()V", "wrapperLayout", "Landroid/widget/FrameLayout;", "getWrapperLayout", "()Landroid/widget/FrameLayout;", "setWrapperLayout", "(Landroid/widget/FrameLayout;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "viewMargin", "Landroid/graphics/Rect;", "getViewMargin", "()Landroid/graphics/Rect;", "setViewMargin", "(Landroid/graphics/Rect;)V", "viewSize", "Landroid/util/Size;", "getViewSize", "()Landroid/util/Size;", "setViewSize", "(Landroid/util/Size;)V", "formatArr", "", "", "currentDate", "Ljava/util/Date;", "getCurrentDate", "()Ljava/util/Date;", "setCurrentDate", "(Ljava/util/Date;)V", "currentFormat", "getCurrentFormat", "()Ljava/lang/String;", "setCurrentFormat", "(Ljava/lang/String;)V", "isShowDate", "", "()Z", "setShowDate", "(Z)V", "isRealDate", "setRealDate", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "binding", "Lcom/ask/printersdk/databinding/DialogModifyDateBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/DialogModifyDateBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/DialogModifyDateBinding;)V", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initWindow", "initView", "refreshTab", "isCheckDate", "refreshFormatData", "changeDateInfo", "initImmersionBar", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "setLayoutId", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifyDateDialog extends BaseDialogFragment {
    public DialogModifyDateBinding binding;
    private Function3<? super Date, ? super String, ? super Boolean, Unit> callback;
    private boolean isRealDate;
    private View rootView;
    private FrameLayout wrapperLayout;
    private Rect viewMargin = new Rect();
    private Size viewSize = new Size(0, 0);
    private final List<String> formatArr = CollectionsKt.listOf((Object[]) new String[]{"yyyy年MM月dd日", "yyyy年MM月", "MM月dd日", "yyyyMMdd", "yyyy-MM-dd", "yyyy-MM", "MM-dd", "yyyy/MM/dd", "yyyy/MM", "MM/dd", "MM-dd-yyyy", "dd-MM-yyyy", "dd/MM/yyyy", "MMM d,yyyy", "d MMM,yyyy"});
    private Date currentDate = new Date();
    private String currentFormat = "yyyy-MM-dd";
    private boolean isShowDate = true;

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

    public final Date getCurrentDate() {
        return this.currentDate;
    }

    public final void setCurrentDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.currentDate = date;
    }

    public final String getCurrentFormat() {
        return this.currentFormat;
    }

    public final void setCurrentFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentFormat = str;
    }

    /* JADX INFO: renamed from: isShowDate, reason: from getter */
    public final boolean getIsShowDate() {
        return this.isShowDate;
    }

    public final void setShowDate(boolean z) {
        this.isShowDate = z;
    }

    /* JADX INFO: renamed from: isRealDate, reason: from getter */
    public final boolean getIsRealDate() {
        return this.isRealDate;
    }

    public final void setRealDate(boolean z) {
        this.isRealDate = z;
    }

    public final Function3<Date, String, Boolean, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function3<? super Date, ? super String, ? super Boolean, Unit> function3) {
        this.callback = function3;
    }

    public final DialogModifyDateBinding getBinding() {
        DialogModifyDateBinding dialogModifyDateBinding = this.binding;
        if (dialogModifyDateBinding != null) {
            return dialogModifyDateBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogModifyDateBinding dialogModifyDateBinding) {
        Intrinsics.checkNotNullParameter(dialogModifyDateBinding, "<set-?>");
        this.binding = dialogModifyDateBinding;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initWindow();
        FrameLayout frameLayout = this.wrapperLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModifyDateDialog.onStart$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(ModifyDateDialog modifyDateDialog, View view) {
        if (modifyDateDialog.canceledOnTouchOutside) {
            modifyDateDialog.dismissAllowingStateLoss();
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
        ViewDataBinding viewDataBindingBind = DataBindingUtil.bind(rootView);
        Intrinsics.checkNotNull(viewDataBindingBind);
        setBinding((DialogModifyDateBinding) viewDataBindingBind);
        getBinding().dateWheel.setRange(DateEntity.yearOnFuture(-1000), DateEntity.yearOnFuture(1000), DateEntity.target(new Date()));
        refreshFormatData();
        getBinding().timeSwitch.setChecked(this.isShowDate);
        refreshTab(true);
        getBinding().dateWheel.setOnDateSelectedListener(new OnDateSelectedListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda0
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnDateSelectedListener
            public final void onDateSelected(int i, int i2, int i3) {
                ModifyDateDialog.initView$lambda$2(this.f$0, i, i2, i3);
            }
        });
        getBinding().formattedWheel.setOnOptionSelectedListener(new OnOptionSelectedListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda1
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener
            public final void onOptionSelected(int i, Object obj) {
                ModifyDateDialog.initView$lambda$3(this.f$0, i, obj);
            }
        });
        getBinding().dateTitle.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.refreshTab(true);
            }
        });
        getBinding().timeTitle.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.refreshTab(false);
            }
        });
        getBinding().timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.dialog.ModifyDateDialog$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ModifyDateDialog.initView$lambda$6(this.f$0, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ModifyDateDialog modifyDateDialog, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(modifyDateDialog.currentDate);
        calendar.set(i, i2 - 1, i3);
        Date time = calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        modifyDateDialog.currentDate = time;
        modifyDateDialog.refreshFormatData();
        modifyDateDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ModifyDateDialog modifyDateDialog, int i, Object obj) {
        modifyDateDialog.currentFormat = modifyDateDialog.formatArr.get(i);
        modifyDateDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ModifyDateDialog modifyDateDialog, CompoundButton compoundButton, boolean z) {
        modifyDateDialog.isShowDate = z;
        modifyDateDialog.refreshTab(true);
        modifyDateDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTab(boolean isCheckDate) {
        if (isCheckDate) {
            getBinding().dateTitle.setTextColor(SupportMenu.CATEGORY_MASK);
            getBinding().timeTitle.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            getBinding().dateContent.setVisibility(0);
            getBinding().formattedContent.setVisibility(8);
            if (this.isRealDate) {
                getBinding().realTime.setVisibility(0);
                getBinding().dateWheel.setVisibility(8);
                return;
            }
            getBinding().realTime.setVisibility(8);
            getBinding().dateWheel.setVisibility(0);
            if (this.isShowDate) {
                return;
            }
            getBinding().dateWheel.setVisibility(8);
            return;
        }
        getBinding().dateTitle.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        getBinding().timeTitle.setTextColor(SupportMenu.CATEGORY_MASK);
        getBinding().dateContent.setVisibility(8);
        getBinding().formattedContent.setVisibility(0);
    }

    private final void refreshFormatData() {
        ArrayList arrayList = new ArrayList();
        int size = this.formatArr.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.formatArr.get(i2);
            if (Intrinsics.areEqual(this.currentFormat, str)) {
                i = i2;
            }
            arrayList.add(DateUtil.INSTANCE.formatDate(this.currentDate, str));
        }
        getBinding().formattedWheel.setData(arrayList);
        getBinding().formattedWheel.setDefaultPosition(i);
    }

    public final void changeDateInfo() {
        Function3<? super Date, ? super String, ? super Boolean, Unit> function3 = this.callback;
        if (function3 != null) {
            function3.invoke(this.currentDate, this.currentFormat, Boolean.valueOf(this.isShowDate));
        }
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
        return R.layout.dialog_modify_date;
    }
}
