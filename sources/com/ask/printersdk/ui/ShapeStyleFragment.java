package com.ask.printersdk.ui;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.base.KBaseAdapter;
import com.ask.printersdk.databinding.FragmentShapeStyleBinding;
import com.ask.printersdk.databinding.ShapeListItemBinding;
import com.ask.printersdk.graph.Graph;
import com.ask.printersdk.graph.ImageStyle;
import com.ask.printersdk.graph.ShapeGraph;
import com.ask.printersdk.graph.ShapeStyle;
import com.ask.printersdk.graph.common.GraphManger;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeStyleFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001fJ\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020+H\u0002J\u000e\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u000202H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u00060\u0016R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/ask/printersdk/ui/ShapeStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "binding", "Lcom/ask/printersdk/databinding/FragmentShapeStyleBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentShapeStyleBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentShapeStyleBinding;)V", "datas", "", "", "getDatas", "()Ljava/util/List;", "data", "Lcom/ask/printersdk/ui/ShapeStyleFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/ShapeStyleFragment$Data;", "currentSelect", "getCurrentSelect", "()I", "setCurrentSelect", "(I)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "onCheckColor", "isRed", "", "onCheckLine", "isDash", "modifyLineWeight", "lineWeight", "", "formatLineWeight", "", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShapeStyleFragment extends Fragment {
    private FragmentShapeStyleBinding binding;
    private int currentSelect;
    private PrintEditViewModel viewModel;
    private final List<Integer> datas = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.ic_shape_line), Integer.valueOf(R.drawable.ic_shape_rectangle_round), Integer.valueOf(R.drawable.ic_shape_rectangle), Integer.valueOf(R.drawable.ic_shape_ova), Integer.valueOf(R.drawable.ic_shape_circular)});
    private final Data data = new Data();

    protected final PrintEditViewModel getViewModel() {
        return this.viewModel;
    }

    protected final void setViewModel(PrintEditViewModel printEditViewModel) {
        this.viewModel = printEditViewModel;
    }

    protected final FragmentShapeStyleBinding getBinding() {
        return this.binding;
    }

    protected final void setBinding(FragmentShapeStyleBinding fragmentShapeStyleBinding) {
        this.binding = fragmentShapeStyleBinding;
    }

    public final List<Integer> getDatas() {
        return this.datas;
    }

    public final Data getData() {
        return this.data;
    }

    public final int getCurrentSelect() {
        return this.currentSelect;
    }

    public final void setCurrentSelect(int i) {
        this.currentSelect = i;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_shape_style, container, false);
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
        FragmentShapeStyleBinding fragmentShapeStyleBinding = (FragmentShapeStyleBinding) DataBindingUtil.bind(rootView);
        if (fragmentShapeStyleBinding == null) {
            return;
        }
        this.binding = fragmentShapeStyleBinding;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null && (curSelectGraph = graphManger.getCurSelectGraph()) != null) {
            ShapeGraph shapeGraph = curSelectGraph instanceof ShapeGraph ? (ShapeGraph) curSelectGraph : null;
            if (shapeGraph != null) {
                ImageStyle style = shapeGraph.getStyle();
                Intrinsics.checkNotNull(style, "null cannot be cast to non-null type com.ask.printersdk.graph.ShapeStyle");
                ShapeStyle shapeStyle = (ShapeStyle) style;
                this.data.setRedTintColor(shapeStyle.getIsRedTintColor());
                this.data.setLineWeight(shapeStyle.getLineWeight());
                this.data.setLineWeightString(formatLineWeight());
                this.currentSelect = shapeStyle.getShapeType() - 1;
                fragmentShapeStyleBinding.shapeLine.setSelected(!shapeStyle.getIsDashed());
                fragmentShapeStyleBinding.shapeDashLine.setSelected(shapeStyle.getIsDashed());
            }
        }
        fragmentShapeStyleBinding.setData(this.data);
        fragmentShapeStyleBinding.colorRed.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(true);
            }
        });
        fragmentShapeStyleBinding.colorBlack.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckColor(false);
            }
        });
        fragmentShapeStyleBinding.shapeLine.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckLine(false);
            }
        });
        fragmentShapeStyleBinding.shapeDashLine.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onCheckLine(true);
            }
        });
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        Intrinsics.checkNotNull(recyclerView);
        new KBaseAdapter.Builder(recyclerView).setData(this.datas).setLayoutId(R.layout.shape_list_item).addBindView(new Function3() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ShapeStyleFragment.initView$lambda$7(this.f$0, recyclerView, (View) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7(final ShapeStyleFragment shapeStyleFragment, final RecyclerView recyclerView, View itemView, int i, final int i2) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ShapeListItemBinding shapeListItemBinding = (ShapeListItemBinding) DataBindingUtil.bind(itemView);
        if (shapeListItemBinding == null) {
            return Unit.INSTANCE;
        }
        shapeListItemBinding.image.setImageResource(i);
        if (i2 == shapeStyleFragment.currentSelect) {
            ConstraintLayout constraintLayout = shapeListItemBinding.container;
            Context context = shapeStyleFragment.getContext();
            Intrinsics.checkNotNull(context);
            constraintLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.item_rounded_red));
        } else {
            ConstraintLayout constraintLayout2 = shapeListItemBinding.container;
            Context context2 = shapeStyleFragment.getContext();
            Intrinsics.checkNotNull(context2);
            constraintLayout2.setBackground(ContextCompat.getDrawable(context2, R.drawable.material_item_rounded));
        }
        shapeListItemBinding.container.setOnClickListener(new View.OnClickListener() { // from class: com.ask.printersdk.ui.ShapeStyleFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShapeStyleFragment.initView$lambda$7$lambda$6(i2, shapeStyleFragment, recyclerView, view);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(int i, ShapeStyleFragment shapeStyleFragment, RecyclerView recyclerView, View view) {
        GraphManger graphManger;
        if (i == shapeStyleFragment.currentSelect) {
            return;
        }
        shapeStyleFragment.currentSelect = i;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        PrintEditViewModel printEditViewModel = shapeStyleFragment.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateShapeType(shapeStyleFragment.currentSelect + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckColor(boolean isRed) {
        CheckBox checkBox;
        CheckBox checkBox2;
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateShapeRedTintColor(isRed);
        }
        this.data.setRedTintColor(isRed);
        FragmentShapeStyleBinding fragmentShapeStyleBinding = this.binding;
        if (fragmentShapeStyleBinding != null && (checkBox2 = fragmentShapeStyleBinding.colorBlack) != null) {
            checkBox2.setChecked(!isRed);
        }
        FragmentShapeStyleBinding fragmentShapeStyleBinding2 = this.binding;
        if (fragmentShapeStyleBinding2 == null || (checkBox = fragmentShapeStyleBinding2.colorRed) == null) {
            return;
        }
        checkBox.setChecked(isRed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCheckLine(boolean isDash) {
        ImageView imageView;
        ImageView imageView2;
        GraphManger graphManger;
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel != null && (graphManger = printEditViewModel.getGraphManger()) != null) {
            graphManger.updateShapeDashed(isDash);
        }
        FragmentShapeStyleBinding fragmentShapeStyleBinding = this.binding;
        if (fragmentShapeStyleBinding != null && (imageView2 = fragmentShapeStyleBinding.shapeLine) != null) {
            imageView2.setSelected(!isDash);
        }
        FragmentShapeStyleBinding fragmentShapeStyleBinding2 = this.binding;
        if (fragmentShapeStyleBinding2 == null || (imageView = fragmentShapeStyleBinding2.shapeDashLine) == null) {
            return;
        }
        imageView.setSelected(isDash);
    }

    public final void modifyLineWeight(double lineWeight) {
        GraphManger graphManger;
        this.data.setLineWeight(lineWeight);
        this.data.setLineWeightString(formatLineWeight());
        this.data.notifyPropertyChanged(BR.lineWeightString);
        PrintEditViewModel printEditViewModel = this.viewModel;
        if (printEditViewModel == null || (graphManger = printEditViewModel.getGraphManger()) == null) {
            return;
        }
        graphManger.updateShapeLineWeight(lineWeight);
    }

    private final String formatLineWeight() {
        String str = new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US)).format(this.data.getLineWeight());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: compiled from: ShapeStyleFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/ask/printersdk/ui/ShapeStyleFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/ShapeStyleFragment;)V", "isRedTintColor", "", "()Z", "setRedTintColor", "(Z)V", "lineWeight", "", "getLineWeight", "()D", "setLineWeight", "(D)V", "lineWeightString", "", "getLineWeightString", "()Ljava/lang/String;", "setLineWeightString", "(Ljava/lang/String;)V", "onLineWeightAdd", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onLineWeightMinus", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {

        @Bindable
        private boolean isRedTintColor;
        private double lineWeight = 3.0d;

        @Bindable
        private String lineWeightString = "3.0";

        public Data() {
        }

        /* JADX INFO: renamed from: isRedTintColor, reason: from getter */
        public final boolean getIsRedTintColor() {
            return this.isRedTintColor;
        }

        public final void setRedTintColor(boolean z) {
            this.isRedTintColor = z;
        }

        public final double getLineWeight() {
            return this.lineWeight;
        }

        public final void setLineWeight(double d) {
            this.lineWeight = d;
        }

        public final String getLineWeightString() {
            return this.lineWeightString;
        }

        public final void setLineWeightString(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lineWeightString = str;
        }

        public final void onLineWeightAdd(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            double d = this.lineWeight + 0.1d;
            this.lineWeight = d;
            if (d >= 30.0d) {
                this.lineWeight = 30.0d;
            }
            ShapeStyleFragment.this.modifyLineWeight(this.lineWeight);
        }

        public final void onLineWeightMinus(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            double d = this.lineWeight - 0.1d;
            this.lineWeight = d;
            if (d <= 0.1d) {
                this.lineWeight = 0.1d;
            }
            ShapeStyleFragment.this.modifyLineWeight(this.lineWeight);
        }
    }
}
