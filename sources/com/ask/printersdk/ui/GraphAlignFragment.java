package com.ask.printersdk.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentGraphAlignBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphAlignFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ask/printersdk/ui/GraphAlignFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/GraphAlignFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/GraphAlignFragment$Data;", "binding", "Lcom/ask/printersdk/databinding/FragmentGraphAlignBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentGraphAlignBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentGraphAlignBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphAlignFragment extends Fragment {
    public FragmentGraphAlignBinding binding;
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

    public final FragmentGraphAlignBinding getBinding() {
        FragmentGraphAlignBinding fragmentGraphAlignBinding = this.binding;
        if (fragmentGraphAlignBinding != null) {
            return fragmentGraphAlignBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentGraphAlignBinding fragmentGraphAlignBinding) {
        Intrinsics.checkNotNullParameter(fragmentGraphAlignBinding, "<set-?>");
        this.binding = fragmentGraphAlignBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_graph_align, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        Graph graph;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        FragmentGraphAlignBinding fragmentGraphAlignBinding = (FragmentGraphAlignBinding) DataBindingUtil.bind(rootView);
        if (fragmentGraphAlignBinding == null) {
            return;
        }
        setBinding(fragmentGraphAlignBinding);
        getBinding().setData(this.data);
        ImageView imageView = getBinding().opLock;
        PrintEditViewModel printEditViewModel = this.viewModel;
        boolean z = false;
        if (printEditViewModel != null && (graph = printEditViewModel.curGraph) != null && graph.getIsLock()) {
            z = true;
        }
        imageView.setSelected(z);
    }

    /* JADX INFO: compiled from: GraphAlignFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/ask/printersdk/ui/GraphAlignFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/GraphAlignFragment;)V", "onReset", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onLock", "onRotate", "onDelete", "onAlignLeft", "onAlignRight", "onAlignTop", "onAlignMiddle2Hori", "onAlignMiddle", "onAlignBottom", "onMoveStep", DevicePublicKeyStringDef.DIRECT, "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        public Data() {
        }

        public final void onReset(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onResetCurGraph();
        }

        public final void onLock(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            GraphAlignFragment.this.getBinding().opLock.setSelected(!GraphAlignFragment.this.getBinding().opLock.isSelected());
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onRLockCurGraph(GraphAlignFragment.this.getBinding().opLock.isSelected());
        }

        public final void onRotate(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onRotateCurGraph();
        }

        public final void onDelete(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onDeleteCurGraph();
        }

        public final void onAlignLeft(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignLeftCurGraph();
        }

        public final void onAlignRight(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignRightCurGraph();
        }

        public final void onAlignTop(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignTopCurGraph();
        }

        public final void onAlignMiddle2Hori(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignMiddle2HoriCurGraph();
        }

        public final void onAlignMiddle(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignMiddleCurGraph();
        }

        public final void onAlignBottom(View view) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onAlignBottomCurGraph();
        }

        public final void onMoveStep(View view, int direct) {
            DrawingSurfaceView drawingSurfaceView;
            GraphManger graphManger;
            Intrinsics.checkNotNullParameter(view, "view");
            PrintEditViewModel viewModel = GraphAlignFragment.this.getViewModel();
            if (viewModel == null || (drawingSurfaceView = viewModel.drawingSurfaceView) == null || (graphManger = drawingSurfaceView.getGraphManger()) == null) {
                return;
            }
            graphManger.onMoveStep(direct);
        }
    }
}
