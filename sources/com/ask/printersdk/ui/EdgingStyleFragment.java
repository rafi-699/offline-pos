package com.ask.printersdk.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentMaterialStyleBinding;
import com.ask.printersdk.graph.EdgingGraph;
import com.ask.printersdk.graph.EdgingStyle;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageStyle;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgingStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/ask/printersdk/ui/EdgingStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "binding", "Lcom/ask/printersdk/databinding/FragmentMaterialStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentMaterialStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentMaterialStyleBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "onCheckColor", "isRed", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgingStyleFragment extends Fragment {
    private FragmentMaterialStyleBinding binding;
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    protected final FragmentMaterialStyleBinding getBinding() {
        return this.binding;
    }

    protected final void setBinding(FragmentMaterialStyleBinding fragmentMaterialStyleBinding) {
        this.binding = fragmentMaterialStyleBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_material_style, container, false);
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
        FragmentMaterialStyleBinding fragmentMaterialStyleBinding = (FragmentMaterialStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentMaterialStyleBinding == null) {
            return;
        }
        this.binding = fragmentMaterialStyleBinding;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (drawingSurfaceView = printEditViewModel.drawingSurfaceView) != null && (graphManger = drawingSurfaceView.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            ImageStyle style = ((EdgingGraph) curSelectGraph).getStyle();
            Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.EdgingStyle");
            EdgingStyle edgingStyle = (EdgingStyle) style;
            fragmentMaterialStyleBinding.scaleSwitch.setChecked(edgingStyle.getEqualRatioScale());
            fragmentMaterialStyleBinding.reverseSwitch.setChecked(edgingStyle.getIsReverse());
            fragmentMaterialStyleBinding.colorBlack.setChecked(!edgingStyle.getIsRedTintColor());
            fragmentMaterialStyleBinding.colorRed.setChecked(edgingStyle.getIsRedTintColor());
        }
        fragmentMaterialStyleBinding.scaleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.EdgingStyleFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EdgingStyleFragment.initView$lambda$2(this.f$0, compoundButton, z);
            }
        });
        fragmentMaterialStyleBinding.reverseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ask.printersdk.ui.EdgingStyleFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                EdgingStyleFragment.initView$lambda$3(this.f$0, compoundButton, z);
            }
        });
        fragmentMaterialStyleBinding.colorRed.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.EdgingStyleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(true);
            }
        });
        fragmentMaterialStyleBinding.colorBlack.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.EdgingStyleFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(EdgingStyleFragment edgingStyleFragment, CompoundButton compoundButton, boolean z) {
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = edgingStyleFragment.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.setEqualScale(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(EdgingStyleFragment edgingStyleFragment, CompoundButton compoundButton, boolean z) {
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = edgingStyleFragment.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateEdgingReverse(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckColor(boolean isRed) {
        CheckBox checkBox;
        CheckBox checkBox2;
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateEdgingRedTintColor(isRed);
        }
        FragmentMaterialStyleBinding fragmentMaterialStyleBinding = this.binding;
        if (fragmentMaterialStyleBinding != null && (checkBox2 = fragmentMaterialStyleBinding.colorBlack) != null) {
            checkBox2.setChecked(!isRed);
        }
        FragmentMaterialStyleBinding fragmentMaterialStyleBinding2 = this.binding;
        if (fragmentMaterialStyleBinding2 == null || (checkBox = fragmentMaterialStyleBinding2.colorRed) == null) {
            return;
        }
        checkBox.setChecked(isRed);
    }
}
