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
import android.widget.ImageView;
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
import com.ask.printersdk.databinding.FragmentBarcodeStyleBinding;
import com.ask.printersdk.graph.BarCodeGraph;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageStyle;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.graph.style.BarCodeStyle;
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

/* JADX INFO: compiled from: BarCodeStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bJ\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002J\"\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020.J\u000e\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0016\u001a\u00060\u0017R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/ask/printersdk/ui/BarCodeStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "binding", "Lcom/ask/printersdk/databinding/FragmentBarcodeStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentBarcodeStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentBarcodeStyleBinding;)V", "FONT_SIZE_MAX", "", "getFONT_SIZE_MAX", "()I", "FONT_SIZE_MIN", "getFONT_SIZE_MIN", "data", "Lcom/ask/printersdk/ui/BarCodeStyleFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/BarCodeStyleFragment$Data;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "onCheckColor", "isRed", "", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "modifyCodeFormat", "codeFormat", "", "modifyContentTxt", "contentTxt", "modifyFontSize", "fontSize", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BarCodeStyleFragment extends Fragment {
    private FragmentBarcodeStyleBinding binding;
    private PrintEditViewModel viewModel;
    private final int FONT_SIZE_MAX = 90;
    private final int FONT_SIZE_MIN = 6;
    private final Data data = new Data();

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    protected final FragmentBarcodeStyleBinding getBinding() {
        return this.binding;
    }

    protected final void setBinding(FragmentBarcodeStyleBinding fragmentBarcodeStyleBinding) {
        this.binding = fragmentBarcodeStyleBinding;
    }

    public final int getFONT_SIZE_MAX() {
        return this.FONT_SIZE_MAX;
    }

    public final int getFONT_SIZE_MIN() {
        return this.FONT_SIZE_MIN;
    }

    public final Data getData() {
        return this.data;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_barcode_style, container, false);
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
        FragmentBarcodeStyleBinding fragmentBarcodeStyleBinding = (FragmentBarcodeStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentBarcodeStyleBinding == null) {
            return;
        }
        this.binding = fragmentBarcodeStyleBinding;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            BarCodeGraph barCodeGraph = curSelectGraph instanceof BarCodeGraph ? (BarCodeGraph) curSelectGraph : null;
            if (barCodeGraph != null) {
                ImageStyle style = barCodeGraph.getStyle();
                Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.style.BarCodeStyle");
                BarCodeStyle barCodeStyle = (BarCodeStyle) style;
                this.data.setRedTintColor(barCodeStyle.getIsRedTintColor());
                this.data.setCodeFormat(barCodeStyle.getCodeType());
                this.data.setContentTxt(barCodeStyle.getContentText());
                this.data.setFontSize((int) barCodeStyle.getTextFontSize());
                this.data.changeStyle(barCodeStyle.getPositionStyle());
            }
        }
        fragmentBarcodeStyleBinding.setData(this.data);
        fragmentBarcodeStyleBinding.colorRed.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.BarCodeStyleFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(true);
            }
        });
        fragmentBarcodeStyleBinding.colorBlack.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.BarCodeStyleFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(false);
            }
        });
        fragmentBarcodeStyleBinding.codeStyleWrapper.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.BarCodeStyleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BarCodeStyleFragment.initView$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(final BarCodeStyleFragment barCodeStyleFragment, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        FloatMenuDialog floatMenuDialog = new FloatMenuDialog();
        floatMenuDialog.setDataSource(CollectionsKt.listOf((Object[]) new String[]{"CODE_128", "UPC_A", "UPC_E", "EAN_8", "EAN_13", "CODE_93", "CODE_39"}));
        floatMenuDialog.setSelectText(barCodeStyleFragment.data.getCodeFormat());
        floatMenuDialog.setViewSize(new Size(PUtil.dip2px(barCodeStyleFragment.getContext(), 150.0f), PUtil.dip2px(barCodeStyleFragment.getContext(), 150.0f)));
        floatMenuDialog.setViewMargin(new Rect(0, (i - PUtil.dip2px(barCodeStyleFragment.getContext(), 10.0f)) - floatMenuDialog.getViewSize().getHeight(), PUtil.dip2px(barCodeStyleFragment.getContext(), 20.0f), 0));
        FragmentManager childFragmentManager = barCodeStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        floatMenuDialog.show(childFragmentManager, "FloatMenuDialog");
        floatMenuDialog.setCallback(new Function1() { // from class: com.ask.printersdk.ui.BarCodeStyleFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BarCodeStyleFragment.initView$lambda$5$lambda$4(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5$lambda$4(BarCodeStyleFragment barCodeStyleFragment, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        barCodeStyleFragment.modifyCodeFormat(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckColor(boolean isRed) {
        CheckBox checkBox;
        CheckBox checkBox2;
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateBarCodeRedTintColor(isRed);
        }
        this.data.setRedTintColor(isRed);
        FragmentBarcodeStyleBinding fragmentBarcodeStyleBinding = this.binding;
        if (fragmentBarcodeStyleBinding != null && (checkBox2 = fragmentBarcodeStyleBinding.colorBlack) != null) {
            checkBox2.setChecked(!isRed);
        }
        FragmentBarcodeStyleBinding fragmentBarcodeStyleBinding2 = this.binding;
        if (fragmentBarcodeStyleBinding2 == null || (checkBox = fragmentBarcodeStyleBinding2.colorRed) == null) {
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
        graphManger.updateBarCodeFormat(codeFormat);
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
        graphManger.updateBarCodeContentText(contentTxt);
    }

    public final void modifyFontSize(int fontSize) {
        GraphManger graphManger;
        this.data.setFontSize(fontSize);
        this.data.notifyPropertyChanged(BR.fontSize);
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateBarCodeFontSize(fontSize);
    }

    /* JADX INFO: compiled from: BarCodeStyleFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ask/printersdk/ui/BarCodeStyleFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/BarCodeStyleFragment;)V", "isRedTintColor", "", "()Z", "setRedTintColor", "(Z)V", "fontSize", "", "getFontSize", "()I", "setFontSize", "(I)V", "contentTxt", "", "getContentTxt", "()Ljava/lang/String;", "setContentTxt", "(Ljava/lang/String;)V", "codeFormat", "getCodeFormat", "setCodeFormat", "changeText", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "scanCode", "changeStyle", "codeStyle", "onFontSizeAdd", "onFontSizeMinus", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {

        @Bindable
        private boolean isRedTintColor;

        @Bindable
        private int fontSize = 14;

        @Bindable
        private String contentTxt = "123456";

        @Bindable
        private String codeFormat = "CODE_128";

        public Data() {
        }

        /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
        public final boolean getIsRedTintColor() {
            return this.isRedTintColor;
        }

        public final void setRedTintColor(boolean z) {
            this.isRedTintColor = z;
        }

        public final int getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(int i) {
            this.fontSize = i;
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
            final BarCodeStyleFragment barCodeStyleFragment = BarCodeStyleFragment.this;
            textInputDialog.addCallback(new Function1() { // from class: com.ask.printersdk.ui.BarCodeStyleFragment$Data$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BarCodeStyleFragment.Data.changeText$lambda$0(barCodeStyleFragment, (String) obj);
                }
            }).show(BarCodeStyleFragment.this.getChildFragmentManager(), "TextInputDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit changeText$lambda$0(BarCodeStyleFragment barCodeStyleFragment, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            barCodeStyleFragment.modifyContentTxt(it);
            return Unit.INSTANCE;
        }

        public final void scanCode(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BarCodeStyleFragment barCodeStyleFragment = BarCodeStyleFragment.this;
            Intrinsics.checkNotNull(barCodeStyleFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            IntentIntegrator intentIntegratorForSupportFragment = IntentIntegrator.forSupportFragment(barCodeStyleFragment);
            intentIntegratorForSupportFragment.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
            intentIntegratorForSupportFragment.setPrompt(BarCodeStyleFragment.this.getString(R.string.scan_barcode));
            intentIntegratorForSupportFragment.setCameraId(0);
            intentIntegratorForSupportFragment.setOrientationLocked(false);
            intentIntegratorForSupportFragment.setBarcodeImageEnabled(true);
            intentIntegratorForSupportFragment.initiateScan();
        }

        public final void changeStyle(int codeStyle) {
            GraphManger graphManger;
            ImageView imageView;
            ImageView[] imageViewArr = new ImageView[3];
            FragmentBarcodeStyleBinding binding = BarCodeStyleFragment.this.getBinding();
            imageViewArr[0] = binding != null ? binding.styleTop : null;
            FragmentBarcodeStyleBinding binding2 = BarCodeStyleFragment.this.getBinding();
            imageViewArr[1] = binding2 != null ? binding2.styleCenter : null;
            FragmentBarcodeStyleBinding binding3 = BarCodeStyleFragment.this.getBinding();
            imageViewArr[2] = binding3 != null ? binding3.styleBottom : null;
            for (int i = 0; i < 3; i++) {
                ImageView imageView2 = imageViewArr[i];
                if (imageView2 != null) {
                    imageView2.setSelected(false);
                }
                if (i == codeStyle && (imageView = imageViewArr[i]) != null) {
                    imageView.setSelected(true);
                }
            }
            PrintEditViewModel viewModel = BarCodeStyleFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return;
            }
            graphManger.updateBarCodeStyle(codeStyle);
        }

        public final void onFontSizeAdd(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int i = this.fontSize + 1;
            this.fontSize = i;
            if (i >= BarCodeStyleFragment.this.getFONT_SIZE_MAX()) {
                this.fontSize = BarCodeStyleFragment.this.getFONT_SIZE_MAX();
            }
            BarCodeStyleFragment.this.modifyFontSize(this.fontSize);
        }

        public final void onFontSizeMinus(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int i = this.fontSize - 1;
            this.fontSize = i;
            if (i <= BarCodeStyleFragment.this.getFONT_SIZE_MIN()) {
                this.fontSize = BarCodeStyleFragment.this.getFONT_SIZE_MIN();
            }
            BarCodeStyleFragment.this.modifyFontSize(this.fontSize);
        }
    }
}
