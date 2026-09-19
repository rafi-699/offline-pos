package com.ask.printersdk.ui.dialog;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ask.printersdk.R;
import com.ask.printersdk.base.dialog.BottomDialogFragment;
import com.ask.printersdk.databinding.DialogTextInputBinding;
import com.ask.printersdk.ui.PrintEditViewModel;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextInputDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020)H\u0014J)\u0010*\u001a\u00020\u00002!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001b0\u0018J\b\u0010+\u001a\u00020\u001bH\u0014J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0014J\b\u0010.\u001a\u00020\u001bH\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u00060\u000eR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u0006¨\u00060"}, d2 = {"Lcom/ask/printersdk/ui/dialog/TextInputDialog;", "Lcom/ask/printersdk/base/dialog/BottomDialogFragment;", "<init>", "()V", "text", "", "(Ljava/lang/String;)V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/dialog/TextInputDialog$Data;", "getData", "()Lcom/ask/printersdk/ui/dialog/TextInputDialog$Data;", "binding", "Lcom/ask/printersdk/databinding/DialogTextInputBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/DialogTextInputBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/DialogTextInputBinding;)V", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "setText", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setLayoutId", "", "addCallback", "initImmersionBar", "onStart", "initWindow", "initData", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextInputDialog extends BottomDialogFragment {
    public DialogTextInputBinding binding;
    private Function1<? super String, Unit> callback;
    private final Data data;
    private String text;
    private PrintEditViewModel viewModel;

    public TextInputDialog() {
        this.data = new Data();
        this.text = "";
    }

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final Data getData() {
        return this.data;
    }

    public final DialogTextInputBinding getBinding() {
        DialogTextInputBinding dialogTextInputBinding = this.binding;
        if (dialogTextInputBinding != null) {
            return dialogTextInputBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogTextInputBinding dialogTextInputBinding) {
        Intrinsics.checkNotNullParameter(dialogTextInputBinding, "<set-?>");
        this.binding = dialogTextInputBinding;
    }

    public final Function1<String, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super String, Unit> function1) {
        this.callback = function1;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputDialog(String text) {
        this();
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString("text", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.text = string;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString("text", this.text);
        super.onSaveInstanceState(outState);
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected int setLayoutId() {
        return R.layout.dialog_text_input;
    }

    public final TextInputDialog addCallback(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        return this;
    }

    @Override // com.ask.printersdk.base.dialog.BottomDialogFragment, com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initImmersionBar() {
        ImmersionBar.with((DialogFragment) this).transparentStatusBar().fitsSystemWindows(false).navigationBarColor(R.color.white).statusBarDarkFont(true).navigationBarDarkIcon(true).keyboardEnable(true, 21).setOnKeyboardListener(new OnKeyboardListener() { // from class: com.ask.printersdk.ui.dialog.TextInputDialog$$ExternalSyntheticLambda1
            @Override // com.gyf.immersionbar.OnKeyboardListener
            public final void onKeyboardChange(boolean z, int i) {
                TextInputDialog.initImmersionBar$lambda$1(this.f$0, z, i);
            }
        }).init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initImmersionBar$lambda$1(TextInputDialog textInputDialog, boolean z, int i) {
        if (z) {
            return;
        }
        textInputDialog.dismissAllowingStateLoss();
    }

    @Override // com.ask.printersdk.base.dialog.BottomDialogFragment, com.ask.printersdk.base.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    @Override // com.ask.printersdk.base.dialog.BottomDialogFragment
    protected void initWindow() {
        super.initWindow();
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.dimAmount = 0.0f;
        this.mWindow.setAttributes(attributes);
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initData() {
        super.initData();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        this.data.setEditTxt(this.text);
        DialogTextInputBinding dialogTextInputBinding = (DialogTextInputBinding) DataBindingUtil.bind(this.rootView);
        if (dialogTextInputBinding == null) {
            return;
        }
        setBinding(dialogTextInputBinding);
        getBinding().setData(this.data);
        getBinding().edit.postDelayed(new Runnable() { // from class: com.ask.printersdk.ui.dialog.TextInputDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TextInputDialog.initData$lambda$2(this.f$0);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2(TextInputDialog textInputDialog) {
        PUtil.showKeyboard(textInputDialog.getBinding().edit);
        textInputDialog.getBinding().edit.setSelection(textInputDialog.data.getEditTxt().length());
    }

    /* JADX INFO: compiled from: TextInputDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/ask/printersdk/ui/dialog/TextInputDialog$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/dialog/TextInputDialog;)V", "editTxt", "", "getEditTxt", "()Ljava/lang/String;", "setEditTxt", "(Ljava/lang/String;)V", "onBtnFinish", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {

        @Bindable
        private String editTxt = "";

        public Data() {
        }

        public final String getEditTxt() {
            return this.editTxt;
        }

        public final void setEditTxt(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.editTxt = str;
        }

        public final void onBtnFinish(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PUtil.hideKeyboard(TextInputDialog.this.getBinding().edit);
            Function1<String, Unit> callback = TextInputDialog.this.getCallback();
            if (callback != null) {
                callback.invoke(this.editTxt);
            }
            TextInputDialog.this.dismissAllowingStateLoss();
        }
    }
}
