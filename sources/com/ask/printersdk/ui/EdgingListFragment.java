package com.ask.printersdk.ui;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.base.KBaseAdapter;
import com.ask.printersdk.databinding.ItemMaterialPickerBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.graph.common.GraphManger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgingListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ask/printersdk/ui/EdgingListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "datas", "", "", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgingListFragment extends Fragment {
    private List<String> datas = CollectionsKt.emptyList();
    private RecyclerView recyclerView;
    private PrintEditViewModel viewModel;

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    public final List<String> getDatas() {
        return this.datas;
    }

    public final void setDatas(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.datas = list;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_material_list, container, false);
        Intrinsics.checkNotNull(viewInflate);
        initView(viewInflate);
        return viewInflate;
    }

    public final void initView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2);
        Application application = activity2.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.viewModel = (PrintEditViewModel) new ViewModelProvider(activity, companion.getInstance(application)).get(PrintEditViewModel.class);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Intrinsics.checkNotNull(recyclerView);
        new KBaseAdapter.Builder(recyclerView).setData(this.datas).setLayoutId(R.layout.item_material_picker).addBindView(new Function3() { // from class: com.ask.printersdk.ui.EdgingListFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EdgingListFragment.initView$lambda$1(this.f$0, (View) obj, (String) obj2, ((Integer) obj3).intValue());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(final EdgingListFragment edgingListFragment, View itemView, String itemData, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        ItemMaterialPickerBinding itemMaterialPickerBinding = (ItemMaterialPickerBinding) DataBindingUtil.bind(itemView);
        if (itemMaterialPickerBinding == null) {
            return Unit.INSTANCE;
        }
        ImageView image = itemMaterialPickerBinding.image;
        Intrinsics.checkNotNullExpressionValue(image, "image");
        ImageView imageView = image;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.dimensionRatio = "H,160:45";
        imageView.setLayoutParams(layoutParams2);
        final String str = edgingListFragment.datas.get(i);
        Resources resources = edgingListFragment.getResources();
        Context context = edgingListFragment.getContext();
        int identifier = resources.getIdentifier(str, "drawable", context != null ? context.getPackageName() : null);
        if (identifier != 0) {
            itemMaterialPickerBinding.image.setImageResource(identifier);
            View root = itemMaterialPickerBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            BaseExtendsKt.click(root, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.ui.EdgingListFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EdgingListFragment.initView$lambda$1$lambda$0(this.f$0, str, (View) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1$lambda$0(EdgingListFragment edgingListFragment, String str, View it) {
        DrawingSurfaceView drawingSurfaceView;
        GraphManger graphManger;
        Graph graph;
        GraphManger graphManger2;
        Intrinsics.checkNotNullParameter(it, "it");
        PrintEditViewModel printEditViewModel = edgingListFragment.viewModel;
        if (printEditViewModel != null && (graph = printEditViewModel.curGraph) != null && graph.getId() == 0) {
            PrintEditViewModel printEditViewModel2 = edgingListFragment.viewModel;
            if (printEditViewModel2 != null && (graphManger2 = printEditViewModel2.getGraphManger()) != null) {
                graphManger2.addEdgingGraph(str);
            }
        } else {
            PrintEditViewModel printEditViewModel3 = edgingListFragment.viewModel;
            if (printEditViewModel3 != null && (drawingSurfaceView = printEditViewModel3.drawingSurfaceView) != null && (graphManger = drawingSurfaceView.getGraphManger()) != null) {
                graphManger.updateEdgingResId(str);
            }
        }
        return Unit.INSTANCE;
    }
}
