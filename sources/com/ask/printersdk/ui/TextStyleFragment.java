package com.ask.printersdk.ui;

import android.app.Application;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
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
import com.ask.printersdk.databinding.FragmentTextStyleBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.TextGraph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.ask.printersdk.ui.dialog.TextInputDialog;
import com.ask.printersdk.ui.dialog.TextVerticalLayoutDialog;
import com.ask.printersdk.utils.PUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/ask/printersdk/ui/TextStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/TextStyleFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/TextStyleFragment$Data;", "FONT_SIZE_MAX", "", "getFONT_SIZE_MAX", "()I", "FONT_SIZE_MIN", "getFONT_SIZE_MIN", "binding", "Lcom/ask/printersdk/databinding/FragmentTextStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentTextStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentTextStyleBinding;)V", "isShowContentText", "", "()Z", "setShowContentText", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextStyleFragment extends Fragment {
    public FragmentTextStyleBinding binding;
    private PrintEditViewModel viewModel;
    private final Data data = new Data();
    private final int FONT_SIZE_MAX = 90;
    private final int FONT_SIZE_MIN = 6;
    private boolean isShowContentText = true;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final Data getData() {
        return this.data;
    }

    public final int getFONT_SIZE_MAX() {
        return this.FONT_SIZE_MAX;
    }

    public final int getFONT_SIZE_MIN() {
        return this.FONT_SIZE_MIN;
    }

    public final FragmentTextStyleBinding getBinding() {
        FragmentTextStyleBinding fragmentTextStyleBinding = this.binding;
        if (fragmentTextStyleBinding != null) {
            return fragmentTextStyleBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentTextStyleBinding fragmentTextStyleBinding) {
        Intrinsics.checkNotNullParameter(fragmentTextStyleBinding, "<set-?>");
        this.binding = fragmentTextStyleBinding;
    }

    /* JADX INFO: renamed from: isShowContentText, reason: from getter */
    public final boolean getIsShowContentText() {
        return this.isShowContentText;
    }

    public final void setShowContentText(boolean z) {
        this.isShowContentText = z;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_text_style, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        DrawingSurfaceView drawingSurfaceView;
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
        FragmentTextStyleBinding fragmentTextStyleBinding = (FragmentTextStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentTextStyleBinding == null) {
            return;
        }
        setBinding(fragmentTextStyleBinding);
        getBinding().setData(this.data);
        if (this.isShowContentText) {
            getBinding().editLayout.setVisibility(0);
        } else {
            getBinding().editLayout.setVisibility(8);
        }
        getBinding().seekBar.setMax(this.FONT_SIZE_MAX);
        if (Build.VERSION.SDK_INT >= 26) {
            getBinding().seekBar.setMin(this.FONT_SIZE_MIN);
        }
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (drawingSurfaceView = printEditViewModel.drawingSurfaceView) != null && (graphManger = drawingSurfaceView.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            TextGraph textGraph = (TextGraph) curSelectGraph;
            this.data.setEditTxt(textGraph.getText());
            this.data.setFontSize((int) textGraph.getStyle().getPaintTextSize());
            this.data.setBold(textGraph.getStyle().getBold());
            this.data.setUnderLine(textGraph.getStyle().getUnderLine());
            this.data.setItalic(textGraph.getStyle().getItalic());
            this.data.setAlign(textGraph.getStyle().getAlign());
            this.data.setLetterDistance(textGraph.getStyle().getLetterDistance());
            this.data.setLineDistance(textGraph.getStyle().getLineDistance());
            this.data.setVerticalLayoutAlign(textGraph.getStyle().getToBoundLayoutAlign());
            this.data.notifyChange();
            getBinding().seekBar.setProgress(this.data.getFontSize());
            getBinding().autoFontSwitch.setChecked(textGraph.getStyle().getIsAutoFont());
            textGraph.setTextFontSizeChange(new Function1() { // from class: com.ask.printersdk.ui.TextStyleFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextStyleFragment.initView$lambda$2$lambda$1$lambda$0(this.f$0, ((Integer) obj).intValue());
                }
            });
        }
        getBinding().seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.ask.printersdk.ui.TextStyleFragment.initView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DrawingSurfaceView drawingSurfaceView2;
                GraphManger graphManger2;
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                if (fromUser) {
                    TextStyleFragment.this.getData().setFontSize(progress);
                    TextStyleFragment.this.getData().notifyPropertyChanged(BR.fontSize);
                    PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
                    if (viewModel == null || (drawingSurfaceView2 = viewModel.drawingSurfaceView) == null || (graphManger2 = drawingSurfaceView2.getGraphManger()) == null) {
                        return;
                    }
                    graphManger2.updateTextSize(TextStyleFragment.this.getData().getFontSize(), false);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DrawingSurfaceView drawingSurfaceView2;
                GraphManger graphManger2;
                PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
                if (viewModel == null || (drawingSurfaceView2 = viewModel.drawingSurfaceView) == null || (graphManger2 = drawingSurfaceView2.getGraphManger()) == null) {
                    return;
                }
                graphManger2.saveBackwardGraphState();
            }
        });
        getBinding().verticalAlignLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.TextStyleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextStyleFragment.initView$lambda$4(this.f$0, view);
            }
        });
        getBinding().autoFontSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.TextStyleFragment$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TextStyleFragment.initView$lambda$5(this.f$0, compoundButton, z);
            }
        });
        if (this.isShowContentText) {
            this.data.changeText(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2$lambda$1$lambda$0(TextStyleFragment textStyleFragment, int i) {
        textStyleFragment.data.setFontSize(i);
        textStyleFragment.data.notifyPropertyChanged(BR.fontSize);
        textStyleFragment.getBinding().seekBar.setProgress(textStyleFragment.data.getFontSize());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(final TextStyleFragment textStyleFragment, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        TextVerticalLayoutDialog textVerticalLayoutDialog = new TextVerticalLayoutDialog();
        textVerticalLayoutDialog.setSelectIndex(textStyleFragment.data.getVerticalLayoutAlign());
        textVerticalLayoutDialog.setViewSize(new Size(PUtil.dip2px(textStyleFragment.getContext(), 150.0f), PUtil.dip2px(textStyleFragment.getContext(), 100.0f)));
        textVerticalLayoutDialog.setViewMargin(new Rect(0, (i - PUtil.dip2px(textStyleFragment.getContext(), 10.0f)) - textVerticalLayoutDialog.getViewSize().getHeight(), PUtil.dip2px(textStyleFragment.getContext(), 20.0f), 0));
        FragmentManager childFragmentManager = textStyleFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        textVerticalLayoutDialog.show(childFragmentManager, "FloatMenuDialog");
        textVerticalLayoutDialog.setCallback(new Function1() { // from class: com.ask.printersdk.ui.TextStyleFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextStyleFragment.initView$lambda$4$lambda$3(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4$lambda$3(TextStyleFragment textStyleFragment, int i) {
        GraphManger graphManger;
        if (i == 0) {
            textStyleFragment.getBinding().verticalAlignContent.setImageResource(R.drawable.ic_text_align_top);
        } else if (i == 1) {
            textStyleFragment.getBinding().verticalAlignContent.setImageResource(R.drawable.ic_text_align_center);
        } else if (i == 2) {
            textStyleFragment.getBinding().verticalAlignContent.setImageResource(R.drawable.ic_text_align_bottom);
        }
        textStyleFragment.data.setVerticalLayoutAlign(i);
        PrintEditViewModel printEditViewModel = textStyleFragment.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateTextToBoundLayoutAlign(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(TextStyleFragment textStyleFragment, CompoundButton compoundButton, boolean z) {
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = textStyleFragment.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.setAutoFont(z);
    }

    /* JADX INFO: compiled from: TextStyleFragment.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0016\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u00103\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0005H\u0002J\u000e\u00107\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u00109\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u000e\u0010:\u001a\u00020,2\u0006\u0010-\u001a\u00020.R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'¨\u0006;"}, d2 = {"Lcom/ask/printersdk/ui/TextStyleFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/TextStyleFragment;)V", "fontSize", "", "getFontSize", "()I", "setFontSize", "(I)V", "editTxt", "", "getEditTxt", "()Ljava/lang/String;", "setEditTxt", "(Ljava/lang/String;)V", TtmlNode.BOLD, "", "getBold", "()Z", "setBold", "(Z)V", "underLine", "getUnderLine", "setUnderLine", TtmlNode.ITALIC, "getItalic", "setItalic", "align", "getAlign", "setAlign", "verticalLayoutAlign", "getVerticalLayoutAlign", "setVerticalLayoutAlign", "letterDistance", "", "getLetterDistance", "()F", "setLetterDistance", "(F)V", "lineDistance", "getLineDistance", "setLineDistance", "changeText", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onFontBold", "onFontUnderLine", "onFontItalic", "onFontAlign", "onFontSizeAdd", "onFontSizeMinus", "modifyFontSize", "size", "onLetterSpacingAdd", "onLetterSpacingMinus", "onLineSpacingAdd", "onLineSpacingMinus", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        private int align;
        private boolean bold;
        private boolean italic;

        @Bindable
        private float letterDistance;

        @Bindable
        private float lineDistance;
        private boolean underLine;
        private int verticalLayoutAlign;

        @Bindable
        private int fontSize = 14;

        @Bindable
        private String editTxt = "";

        public Data() {
        }

        public final int getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(int i) {
            this.fontSize = i;
        }

        public final String getEditTxt() {
            return this.editTxt;
        }

        public final void setEditTxt(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.editTxt = str;
        }

        public final boolean getBold() {
            return this.bold;
        }

        public final void setBold(boolean z) {
            this.bold = z;
        }

        public final boolean getUnderLine() {
            return this.underLine;
        }

        public final void setUnderLine(boolean z) {
            this.underLine = z;
        }

        public final boolean getItalic() {
            return this.italic;
        }

        public final void setItalic(boolean z) {
            this.italic = z;
        }

        public final int getAlign() {
            return this.align;
        }

        public final void setAlign(int i) {
            this.align = i;
        }

        public final int getVerticalLayoutAlign() {
            return this.verticalLayoutAlign;
        }

        public final void setVerticalLayoutAlign(int i) {
            this.verticalLayoutAlign = i;
        }

        public final float getLetterDistance() {
            return this.letterDistance;
        }

        public final void setLetterDistance(float f) {
            this.letterDistance = f;
        }

        public final float getLineDistance() {
            return this.lineDistance;
        }

        public final void setLineDistance(float f) {
            this.lineDistance = f;
        }

        public final void changeText(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TextInputDialog textInputDialog = new TextInputDialog(this.editTxt);
            final TextStyleFragment textStyleFragment = TextStyleFragment.this;
            textInputDialog.addCallback(new Function1() { // from class: com.ask.printersdk.ui.TextStyleFragment$Data$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextStyleFragment.Data.changeText$lambda$0(this.f$0, textStyleFragment, (String) obj);
                }
            }).show(TextStyleFragment.this.getChildFragmentManager(), "TextInputDialog");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit changeText$lambda$0(Data data, TextStyleFragment textStyleFragment, String it) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(it, "it");
            data.editTxt = it;
            PrintEditViewModel viewModel = textStyleFragment.getViewModel();
            if (viewModel != null && (graphManger = viewModel.getGraphManger()) != null) {
                graphManger.updateCurGraphText(data.editTxt);
            }
            data.notifyPropertyChanged(BR.editTxt);
            return Unit.INSTANCE;
        }

        public final void onFontBold(View view) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.bold = !this.bold;
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextBold(this.bold);
        }

        public final void onFontUnderLine(View view) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.underLine = !this.underLine;
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextUnderLine(this.underLine);
        }

        public final void onFontItalic(View view) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.italic = !this.italic;
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextItalic(this.italic);
        }

        public final void onFontAlign(View view, int align) {
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            if (align == this.align) {
                return;
            }
            this.align = align;
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (graphManger = viewModel.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextAlign(align);
        }

        public final void onFontSizeAdd(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int i = this.fontSize + 1;
            this.fontSize = i;
            if (i >= TextStyleFragment.this.getFONT_SIZE_MAX()) {
                this.fontSize = TextStyleFragment.this.getFONT_SIZE_MAX();
            }
            modifyFontSize(this.fontSize);
        }

        public final void onFontSizeMinus(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int i = this.fontSize - 1;
            this.fontSize = i;
            if (i <= TextStyleFragment.this.getFONT_SIZE_MIN()) {
                this.fontSize = TextStyleFragment.this.getFONT_SIZE_MIN();
            }
            modifyFontSize(this.fontSize);
        }

        private final void modifyFontSize(int size) {
            GraphManger graphManger;
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger2;
            notifyPropertyChanged(BR.fontSize);
            TextStyleFragment.this.getBinding().seekBar.setProgress(this.fontSize);
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel != null && (drawingSurfaceView = viewModel.drawingSurfaceView) != null && (graphManger2 = drawingSurfaceView.getGraphManger()) != null) {
                GraphManger.updateTextSize$default(graphManger2, this.fontSize, false, 2, null);
            }
            PrintEditViewModel viewModel2 = TextStyleFragment.this.getViewModel();
            if (viewModel2 != null && (graphManger = viewModel2.getGraphManger()) != null) {
                graphManger.setAutoFont(false);
            }
            TextStyleFragment.this.getBinding().autoFontSwitch.setChecked(false);
        }

        public final void onLetterSpacingAdd(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.letterDistance += 0.1f;
            String str = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)).format(Float.valueOf(this.letterDistance));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.letterDistance = Float.parseFloat(str);
            notifyPropertyChanged(BR.letterDistance);
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextLetterSpacing(this.letterDistance);
        }

        public final void onLetterSpacingMinus(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.letterDistance -= 0.1f;
            String str = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)).format(Float.valueOf(this.letterDistance));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.letterDistance = Float.parseFloat(str);
            notifyPropertyChanged(BR.letterDistance);
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextLetterSpacing(this.letterDistance);
        }

        public final void onLineSpacingAdd(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.lineDistance += 0.1f;
            String str = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)).format(Float.valueOf(this.lineDistance));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.lineDistance = Float.parseFloat(str);
            notifyPropertyChanged(BR.lineDistance);
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextLineSpacing(this.lineDistance);
        }

        public final void onLineSpacingMinus(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            this.lineDistance -= 0.1f;
            String str = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)).format(Float.valueOf(this.lineDistance));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.lineDistance = Float.parseFloat(str);
            notifyPropertyChanged(BR.lineDistance);
            PrintEditViewModel viewModel = TextStyleFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.updateTextLineSpacing(this.lineDistance);
        }
    }
}
