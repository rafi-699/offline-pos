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
import com.ask.printersdk.databinding.DialogModifyTimeBinding;
import com.ask.printersdk.utils.DateUtil;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeSelectedListener;
import com.github.gzuliyujiang.wheelpicker.entity.TimeEntity;
import com.gyf.immersionbar.ImmersionBar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifyTimeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010O\u001a\u00020DH\u0016J&\u0010P\u001a\u0004\u0018\u00010\u000b2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020DH\u0004J\u000e\u0010X\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u000205H\u0002J\b\u0010[\u001a\u00020DH\u0002J\u0006\u0010\\\u001a\u00020DJ\b\u0010]\u001a\u00020DH\u0014J\u0010\u0010^\u001a\u00020D2\u0006\u0010_\u001a\u00020`H\u0016J\u001a\u0010a\u001a\u00020D2\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010e\u001a\u00020/H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R$\u0010<\u001a\u0002052\u0006\u0010;\u001a\u000205@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00106\"\u0004\b=\u00108Rv\u0010>\u001a^\u0012\u0013\u0012\u00110$¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b()\u0012\u0013\u0012\u001105¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0013\u0012\u001105¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020D\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006f"}, d2 = {"Lcom/ask/printersdk/ui/dialog/ModifyTimeDialog;", "Lcom/ask/printersdk/base/dialog/BaseDialogFragment;", "<init>", "()V", "wrapperLayout", "Landroid/widget/FrameLayout;", "getWrapperLayout", "()Landroid/widget/FrameLayout;", "setWrapperLayout", "(Landroid/widget/FrameLayout;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "viewMargin", "Landroid/graphics/Rect;", "getViewMargin", "()Landroid/graphics/Rect;", "setViewMargin", "(Landroid/graphics/Rect;)V", "viewSize", "Landroid/util/Size;", "getViewSize", "()Landroid/util/Size;", "setViewSize", "(Landroid/util/Size;)V", "formatArr", "", "", "getFormatArr", "()Ljava/util/List;", "setFormatArr", "(Ljava/util/List;)V", "currentTime", "Ljava/util/Date;", "getCurrentTime", "()Ljava/util/Date;", "setCurrentTime", "(Ljava/util/Date;)V", "currentFormat", "getCurrentFormat", "()Ljava/lang/String;", "setCurrentFormat", "(Ljava/lang/String;)V", "currentFormatSelectIndex", "", "getCurrentFormatSelectIndex", "()I", "setCurrentFormatSelectIndex", "(I)V", "isShowTime", "", "()Z", "setShowTime", "(Z)V", "isRealTime", "setRealTime", "value", "is24Hour", "set24Hour", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "currentDate", "isShowDate", "", "getCallback", "()Lkotlin/jvm/functions/Function4;", "setCallback", "(Lkotlin/jvm/functions/Function4;)V", "binding", "Lcom/ask/printersdk/databinding/DialogModifyTimeBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/DialogModifyTimeBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/DialogModifyTimeBinding;)V", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initWindow", "initView", "refreshTab", "isCheckDate", "refreshFormatData", "changeDateInfo", "initImmersionBar", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "setLayoutId", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifyTimeDialog extends BaseDialogFragment {
    public DialogModifyTimeBinding binding;
    private Function4<? super Date, ? super String, ? super Boolean, ? super Boolean, Unit> callback;
    private boolean is24Hour;
    private boolean isRealTime;
    private View rootView;
    private FrameLayout wrapperLayout;
    private Rect viewMargin = new Rect();
    private Size viewSize = new Size(0, 0);
    private List<String> formatArr = CollectionsKt.listOf((Object[]) new String[]{"HH:mm", "HH:mm:ss", "mm:ss"});
    private Date currentTime = new Date();
    private String currentFormat = "HH:mm:ss";
    private int currentFormatSelectIndex = 1;
    private boolean isShowTime = true;

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

    public final List<String> getFormatArr() {
        return this.formatArr;
    }

    public final void setFormatArr(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.formatArr = list;
    }

    public final Date getCurrentTime() {
        return this.currentTime;
    }

    public final void setCurrentTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.currentTime = date;
    }

    public final String getCurrentFormat() {
        return this.currentFormat;
    }

    public final void setCurrentFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentFormat = str;
    }

    public final int getCurrentFormatSelectIndex() {
        return this.currentFormatSelectIndex;
    }

    public final void setCurrentFormatSelectIndex(int i) {
        this.currentFormatSelectIndex = i;
    }

    /* JADX INFO: renamed from: isShowTime, reason: from getter */
    public final boolean getIsShowTime() {
        return this.isShowTime;
    }

    public final void setShowTime(boolean z) {
        this.isShowTime = z;
    }

    /* JADX INFO: renamed from: isRealTime, reason: from getter */
    public final boolean getIsRealTime() {
        return this.isRealTime;
    }

    public final void setRealTime(boolean z) {
        this.isRealTime = z;
    }

    /* JADX INFO: renamed from: is24Hour, reason: from getter */
    public final boolean getIs24Hour() {
        return this.is24Hour;
    }

    public final void set24Hour(boolean z) {
        List<String> listListOf;
        if (z != this.is24Hour) {
            if (z) {
                listListOf = CollectionsKt.listOf((Object[]) new String[]{"HH:mm", "HH:mm:ss", "mm:ss"});
            } else {
                listListOf = CollectionsKt.listOf((Object[]) new String[]{"hh:mm a", "hh:mm:ss a", "mm:ss a"});
            }
            this.formatArr = listListOf;
        }
        this.is24Hour = z;
    }

    public final Function4<Date, String, Boolean, Boolean, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function4<? super Date, ? super String, ? super Boolean, ? super Boolean, Unit> function4) {
        this.callback = function4;
    }

    public final DialogModifyTimeBinding getBinding() {
        DialogModifyTimeBinding dialogModifyTimeBinding = this.binding;
        if (dialogModifyTimeBinding != null) {
            return dialogModifyTimeBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogModifyTimeBinding dialogModifyTimeBinding) {
        Intrinsics.checkNotNullParameter(dialogModifyTimeBinding, "<set-?>");
        this.binding = dialogModifyTimeBinding;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initWindow();
        FrameLayout frameLayout = this.wrapperLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModifyTimeDialog.onStart$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(ModifyTimeDialog modifyTimeDialog, View view) {
        if (modifyTimeDialog.canceledOnTouchOutside) {
            modifyTimeDialog.dismissAllowingStateLoss();
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
        setBinding((DialogModifyTimeBinding) viewDataBindingBind);
        refreshFormatData();
        getBinding().timeSwitch.setChecked(this.isShowTime);
        getBinding().hourStyle.setSelected(this.is24Hour);
        if (this.is24Hour) {
            getBinding().timeWheel.setTimeMode(1);
        } else {
            getBinding().timeWheel.setTimeMode(3);
        }
        getBinding().timeWheel.setDefaultValue(TimeEntity.target(this.currentTime));
        refreshTab(true);
        getBinding().timeWheel.setOnTimeSelectedListener(new OnTimeSelectedListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda1
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnTimeSelectedListener
            public final void onTimeSelected(int i, int i2, int i3) {
                ModifyTimeDialog.initView$lambda$2(this.f$0, i, i2, i3);
            }
        });
        getBinding().formattedWheel.setOnOptionSelectedListener(new OnOptionSelectedListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda2
            @Override // com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener
            public final void onOptionSelected(int i, Object obj) {
                ModifyTimeDialog.initView$lambda$3(this.f$0, i, obj);
            }
        });
        getBinding().dateTitle.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.refreshTab(true);
            }
        });
        getBinding().timeTitle.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.refreshTab(false);
            }
        });
        getBinding().timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ModifyTimeDialog.initView$lambda$6(this.f$0, compoundButton, z);
            }
        });
        getBinding().hourStyleBg.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.dialog.ModifyTimeDialog$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModifyTimeDialog.initView$lambda$7(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ModifyTimeDialog modifyTimeDialog, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(modifyTimeDialog.currentTime);
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, i2, i3);
        Date time = calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        modifyTimeDialog.currentTime = time;
        modifyTimeDialog.refreshFormatData();
        modifyTimeDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ModifyTimeDialog modifyTimeDialog, int i, Object obj) {
        modifyTimeDialog.currentFormat = modifyTimeDialog.formatArr.get(i);
        modifyTimeDialog.currentFormatSelectIndex = i;
        modifyTimeDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ModifyTimeDialog modifyTimeDialog, CompoundButton compoundButton, boolean z) {
        modifyTimeDialog.isShowTime = z;
        modifyTimeDialog.refreshTab(true);
        modifyTimeDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(ModifyTimeDialog modifyTimeDialog, View view) {
        modifyTimeDialog.getBinding().hourStyle.setSelected(!modifyTimeDialog.getBinding().hourStyle.isSelected());
        modifyTimeDialog.set24Hour(modifyTimeDialog.getBinding().hourStyle.isSelected());
        if (modifyTimeDialog.getBinding().hourStyle.isSelected()) {
            modifyTimeDialog.getBinding().timeWheel.setTimeMode(1);
        } else {
            modifyTimeDialog.getBinding().timeWheel.setTimeMode(3);
        }
        modifyTimeDialog.currentFormat = modifyTimeDialog.formatArr.get(modifyTimeDialog.currentFormatSelectIndex);
        modifyTimeDialog.refreshFormatData();
        modifyTimeDialog.changeDateInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTab(boolean isCheckDate) {
        if (isCheckDate) {
            getBinding().dateTitle.setTextColor(SupportMenu.CATEGORY_MASK);
            getBinding().timeTitle.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            getBinding().dateContent.setVisibility(0);
            getBinding().formattedContent.setVisibility(8);
            if (this.isRealTime) {
                getBinding().realTime.setVisibility(0);
                getBinding().timeWheel.setVisibility(4);
                return;
            }
            getBinding().realTime.setVisibility(8);
            getBinding().timeWheel.setVisibility(0);
            if (this.isShowTime) {
                return;
            }
            getBinding().timeWheel.setVisibility(4);
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
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.formatArr.get(i2);
            if (Intrinsics.areEqual(this.currentFormat, str)) {
                i = i2;
            }
            arrayList.add(DateUtil.INSTANCE.formatDate(this.currentTime, str));
        }
        this.currentFormatSelectIndex = i;
        getBinding().formattedWheel.setData(arrayList);
        getBinding().formattedWheel.setDefaultPosition(i);
    }

    public final void changeDateInfo() {
        Function4<? super Date, ? super String, ? super Boolean, ? super Boolean, Unit> function4 = this.callback;
        if (function4 != null) {
            function4.invoke(this.currentTime, this.currentFormat, Boolean.valueOf(this.isShowTime), Boolean.valueOf(this.is24Hour));
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
        return R.layout.dialog_modify_time;
    }
}
