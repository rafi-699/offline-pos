package com.ask.printersdk.ui.dialog;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.dialog.CenterDialogFragment;
import com.ask.printersdk.databinding.DialogSettingPaperBinding;
import com.ask.printersdk.graph.BoardGraph;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.ui.PrintEditViewModel;
import com.ask.printersdk.utils.ToastUitl;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingPaperDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/ask/printersdk/ui/dialog/SettingPaperDialog;", "Lcom/ask/printersdk/base/dialog/CenterDialogFragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/dialog/SettingPaperDialog$Data;", "getData", "()Lcom/ask/printersdk/ui/dialog/SettingPaperDialog$Data;", "binding", "Lcom/ask/printersdk/databinding/DialogSettingPaperBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/DialogSettingPaperBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/DialogSettingPaperBinding;)V", "setLayoutId", "", "initData", "", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingPaperDialog extends CenterDialogFragment {
    public DialogSettingPaperBinding binding;
    private final Data data = new Data();
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final Data getData() {
        return this.data;
    }

    public final DialogSettingPaperBinding getBinding() {
        DialogSettingPaperBinding dialogSettingPaperBinding = this.binding;
        if (dialogSettingPaperBinding != null) {
            return dialogSettingPaperBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogSettingPaperBinding dialogSettingPaperBinding) {
        Intrinsics.checkNotNullParameter(dialogSettingPaperBinding, "<set-?>");
        this.binding = dialogSettingPaperBinding;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected int setLayoutId() {
        return R.layout.dialog_setting_paper;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initData() {
        GraphManger graphManger;
        BoardGraph boardGraph;
        super.initData();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        DialogSettingPaperBinding dialogSettingPaperBinding = (DialogSettingPaperBinding) DataBindingUtil.bind(this.rootView);
        if (dialogSettingPaperBinding == null) {
            return;
        }
        setBinding(dialogSettingPaperBinding);
        getBinding().setData(this.data);
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null && (boardGraph = graphManger.getBoardGraph()) != null) {
            this.data.setPaperW(String.valueOf(boardGraph.getBoardStyle().getLabelPaperWidth()));
            this.data.setPaperH(String.valueOf(boardGraph.getBoardStyle().getLabelPaperHeight()));
        }
        ImageView imageClose = getBinding().imageClose;
        Intrinsics.checkNotNullExpressionValue(imageClose, "imageClose");
        BaseExtendsKt.click(imageClose, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.dialog.SettingPaperDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingPaperDialog.initData$lambda$1(this.f$0, (View) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$1(SettingPaperDialog settingPaperDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        settingPaperDialog.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SettingPaperDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ask/printersdk/ui/dialog/SettingPaperDialog$Data;", "", "<init>", "(Lcom/ask/printersdk/ui/dialog/SettingPaperDialog;)V", "paperW", "", "getPaperW", "()Ljava/lang/String;", "setPaperW", "(Ljava/lang/String;)V", "paperH", "getPaperH", "setPaperH", "onOkClick", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data {
        private String paperW = "";
        private String paperH = "";

        public Data() {
        }

        public final String getPaperW() {
            return this.paperW;
        }

        public final void setPaperW(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.paperW = str;
        }

        public final String getPaperH() {
            return this.paperH;
        }

        public final void setPaperH(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.paperH = str;
        }

        public final void onOkClick(View view) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!StringsKt.isBlank(this.paperW) && (Integer.parseInt(this.paperW) < 12 || Integer.parseInt(this.paperW) > 500)) {
                ToastUitl.showCenterToast(SettingPaperDialog.this.getContext(), "must >= 12 and <= 500");
                return;
            }
            if (!StringsKt.isBlank(this.paperH) && (Integer.parseInt(this.paperH) < 12 || Integer.parseInt(this.paperH) > 500)) {
                ToastUitl.showCenterToast(SettingPaperDialog.this.getContext(), "must >= 12 and <= 500");
                return;
            }
            int i = Integer.parseInt(this.paperW);
            int i2 = Integer.parseInt(this.paperH);
            PrintEditViewModel viewModel = SettingPaperDialog.this.getViewModel();
            if (viewModel != null && (graphManger = viewModel.getGraphManger()) != null) {
                graphManger.setDrawBoardSize(i, i2);
            }
            SettingPaperDialog.this.dismissAllowingStateLoss();
        }
    }
}
