package com.ask.printersdk.ui;

import android.app.Application;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentQrcodeStyleBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageStyle;
import com.ask.printersdk.graph.QRCodeGraph;
import com.ask.printersdk.graph.QRCodeStyle;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.ui.dialog.FloatMenuDialog;
import com.ask.printersdk.ui.dialog.TextInputDialog;
import com.ask.printersdk.utils.LogUtil;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QRCodeStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010\u0010\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020)R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00060\u0011R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Lcom/ask/printersdk/ui/QRCodeStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "binding", "Lcom/ask/printersdk/databinding/FragmentQrcodeStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentQrcodeStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentQrcodeStyleBinding;)V", "data", "Lcom/ask/printersdk/ui/QRCodeStyleFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/QRCodeStyleFragment$Data;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "onCheckColor", "isRed", "", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "modifyCodeFormat", "codeFormat", "", "modifyContentTxt", "contentTxt", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QRCodeStyleFragment extends Fragment {
    private FragmentQrcodeStyleBinding binding;
    private final Data data = new Data();
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    protected final FragmentQrcodeStyleBinding getBinding() {
        return this.binding;
    }

    protected final void setBinding(FragmentQrcodeStyleBinding fragmentQrcodeStyleBinding) {
        this.binding = fragmentQrcodeStyleBinding;
    }

    public final Data getData() {
        return this.data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_qrcode_style, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        GraphManger graphManger;
        Graph curSelectGraph;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        FragmentQrcodeStyleBinding fragmentQrcodeStyleBinding = (FragmentQrcodeStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentQrcodeStyleBinding == null) {
            return;
        }
        this.binding = fragmentQrcodeStyleBinding;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            QRCodeGraph qRCodeGraph = curSelectGraph instanceof QRCodeGraph ? (QRCodeGraph) curSelectGraph : null;
            if (qRCodeGraph != null) {
                ImageStyle style = qRCodeGraph.getStyle();
                Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.QRCodeStyle");
                QRCodeStyle qRCodeStyle = (QRCodeStyle) style;
                this.data.setRedTintColor(qRCodeStyle.getIsRedTintColor());
                this.data.setCodeFormat(qRCodeStyle.getCodeType());
                this.data.setContentTxt(qRCodeStyle.getContentText());
            }
        }
        fragmentQrcodeStyleBinding.setData(this.data);
        fragmentQrcodeStyleBinding.colorRed.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.QRCodeStyleFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(true);
            }
        });
        fragmentQrcodeStyleBinding.colorBlack.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.QRCodeStyleFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(false);
            }
        });
        fragmentQrcodeStyleBinding.codeStyleWrapper.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.QRCodeStyleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRCodeStyleFragment.initView$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(final QRCodeStyleFragment qRCodeStyleFragment, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        FloatMenuDialog floatMenuDialog = new FloatMenuDialog();
        floatMenuDialog.setDataSource(CollectionsKt.listOf((Object[]) new String[]{"QR_CODE", "PDF_417", "DATA_MATRIX", "AZTEC"}));
        floatMenuDialog.setSelectText(qRCodeStyleFragment.data.getCodeFormat());
        floatMenuDialog.setViewSize(new Size(PUtil.dip2px(qRCodeStyleFragment.getContext(), 150.0f), PUtil.dip2px(qRCodeStyleFragment.getContext(), 100.0f)));
        floatMenuDialog.setViewMargin(new Rect(0, (i - PUtil.dip2px(qRCodeStyleFragment.getContext(), 10.0f)) - floatMenuDialog.getViewSize().getHeight(), PUtil.dip2px(qRCodeStyleFragment.getContext(), 20.0f), 0));
        FragmentManager childFragmentManager = qRCodeStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        floatMenuDialog.show(childFragmentManager, "FloatMenuDialog");
        floatMenuDialog.setCallback(new Function1() { // from class: com.ask.printersdk.ui.QRCodeStyleFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QRCodeStyleFragment.initView$lambda$5$lambda$4(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5$lambda$4(QRCodeStyleFragment qRCodeStyleFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        qRCodeStyleFragment.modifyCodeFormat(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckColor(boolean isRed) {
        CheckBox checkBox;
        CheckBox checkBox2;
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateQRCodeRedTintColor(isRed);
        }
        this.data.setRedTintColor(isRed);
        FragmentQrcodeStyleBinding fragmentQrcodeStyleBinding = this.binding;
        if (fragmentQrcodeStyleBinding != null && (checkBox2 = fragmentQrcodeStyleBinding.colorBlack) != null) {
            checkBox2.setChecked(!isRed);
        }
        FragmentQrcodeStyleBinding fragmentQrcodeStyleBinding2 = this.binding;
        if (fragmentQrcodeStyleBinding2 == null || (checkBox = fragmentQrcodeStyleBinding2.colorRed) == null) {
            return;
        }
        checkBox.setChecked(isRed);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 49374 && resultCode == -1) {
            IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (activityResult != null) {
                LogUtil.e("result: " + activityResult);
                if (activityResult.getContents() != null) {
                    String formatName = activityResult.getFormatName();
                    Intrinsics.checkNotNullExpressionValue(formatName, "getFormatName(...)");
                    modifyCodeFormat(formatName);
                    String contents = activityResult.getContents();
                    Intrinsics.checkNotNullExpressionValue(contents, "getContents(...)");
                    modifyContentTxt(contents);
                    return;
                }
                return;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private final void modifyCodeFormat(String codeFormat) {
        GraphManger graphManger;
        this.data.setCodeFormat(codeFormat);
        this.data.notifyPropertyChanged(BR.codeFormat);
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateQRCodeFormat(codeFormat);
    }

    public final void modifyContentTxt(String contentTxt) {
        GraphManger graphManger;
        Intrinsics.checkNotNullParameter(contentTxt, "contentTxt");
        this.data.setContentTxt(contentTxt);
        this.data.notifyPropertyChanged(BR.contentTxt);
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateQRCodeContentText(contentTxt);
    }

    /* JADX INFO: compiled from: QRCodeStyleFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/ask/printersdk/ui/QRCodeStyleFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/QRCodeStyleFragment;)V", "isRedTintColor", "", "()Z", "setRedTintColor", "(Z)V", "contentTxt", "", "getContentTxt", "()Ljava/lang/String;", "setContentTxt", "(Ljava/lang/String;)V", "codeFormat", "getCodeFormat", "setCodeFormat", "changeText", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "scanCode", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {

        @Bindable
        private boolean isRedTintColor;

        @Bindable
        private String contentTxt = "123456";

        @Bindable
        private String codeFormat = "QR_CODE";

        public Data() {
        }

        /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
        public final boolean getIsRedTintColor() {
            return this.isRedTintColor;
        }

        public final void setRedTintColor(boolean z) {
            this.isRedTintColor = z;
        }

        public final String getContentTxt() {
            return this.contentTxt;
        }

        public final void setContentTxt(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contentTxt = str;
        }

        public final String getCodeFormat() {
            return this.codeFormat;
        }

        public final void setCodeFormat(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.codeFormat = str;
        }

        public final void changeText(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TextInputDialog textInputDialog = new TextInputDialog(this.contentTxt);
            final QRCodeStyleFragment qRCodeStyleFragment = QRCodeStyleFragment.this;
            textInputDialog.addCallback(new Function1() { // from class: com.ask.printersdk.ui.QRCodeStyleFragment$Data$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QRCodeStyleFragment.Data.changeText$lambda$0(qRCodeStyleFragment, (String) obj);
                }
            }).show(QRCodeStyleFragment.this.getChildFragmentManager(), "TextInputDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit changeText$lambda$0(QRCodeStyleFragment qRCodeStyleFragment, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            qRCodeStyleFragment.modifyContentTxt(it);
            return Unit.INSTANCE;
        }

        public final void scanCode(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QRCodeStyleFragment qRCodeStyleFragment = QRCodeStyleFragment.this;
            Intrinsics.checkNotNull(qRCodeStyleFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            IntentIntegrator intentIntegratorForSupportFragment = IntentIntegrator.forSupportFragment(qRCodeStyleFragment);
            intentIntegratorForSupportFragment.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
            intentIntegratorForSupportFragment.setPrompt(QRCodeStyleFragment.this.getString(R.string.scan_qrcode));
            intentIntegratorForSupportFragment.setCameraId(0);
            intentIntegratorForSupportFragment.setOrientationLocked(false);
            intentIntegratorForSupportFragment.setBarcodeImageEnabled(true);
            intentIntegratorForSupportFragment.initiateScan();
        }
    }
}
