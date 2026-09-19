package com.ask.printersdk.ui;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.FtsOptions;
import androidx.viewpager.widget.ViewPager;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentOpMaterialListBinding;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgingOpListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/ask/printersdk/ui/EdgingOpListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/EdgingOpListFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/EdgingOpListFragment$Data;", "binding", "Lcom/ask/printersdk/databinding/FragmentOpMaterialListBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentOpMaterialListBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentOpMaterialListBinding;)V", "tabs", "", "", "dataSource", "getDataSource", "()Ljava/util/List;", "dataSource$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "MaterialMenuData", "Adapter", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgingOpListFragment extends Fragment {
    public FragmentOpMaterialListBinding binding;
    private final Data data = new Data();

    /* JADX INFO: renamed from: dataSource$delegate, reason: from kotlin metadata */
    private final Lazy dataSource = LazyKt.lazy(new Function0() { // from class: com.ask.printersdk.ui.EdgingOpListFragment$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EdgingOpListFragment.dataSource_delegate$lambda$0();
        }
    });
    private List<String> tabs;
    private PrintEditViewModel viewModel;

    /* JADX INFO: compiled from: EdgingOpListFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ask/printersdk/ui/EdgingOpListFragment$MaterialMenuData;", "", "prefixText", "", "count", "", "<init>", "(Ljava/lang/String;I)V", "getPrefixText", "()Ljava/lang/String;", "getCount", "()I", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MaterialMenuData {
        private final int count;
        private final String prefixText;

        public MaterialMenuData(String prefixText, int i) {
            Intrinsics.checkNotNullParameter(prefixText, "prefixText");
            this.prefixText = prefixText;
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getPrefixText() {
            return this.prefixText;
        }
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

    public final FragmentOpMaterialListBinding getBinding() {
        FragmentOpMaterialListBinding fragmentOpMaterialListBinding = this.binding;
        if (fragmentOpMaterialListBinding != null) {
            return fragmentOpMaterialListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentOpMaterialListBinding fragmentOpMaterialListBinding) {
        Intrinsics.checkNotNullParameter(fragmentOpMaterialListBinding, "<set-?>");
        this.binding = fragmentOpMaterialListBinding;
    }

    public final List<List<String>> getDataSource() {
        return (List) this.dataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList dataSource_delegate$lambda$0() {
        List listListOf = CollectionsKt.listOf((Object[]) new MaterialMenuData[]{new MaterialMenuData(FtsOptions.TOKENIZER_SIMPLE, 5), new MaterialMenuData("cartoon", 4)});
        ArrayList arrayList = new ArrayList();
        int size = listListOf.size();
        for (int i = 0; i < size; i++) {
            MaterialMenuData materialMenuData = (MaterialMenuData) listListOf.get(i);
            ArrayList arrayList2 = new ArrayList();
            int count = materialMenuData.getCount();
            int i2 = 0;
            while (i2 < count) {
                i2++;
                arrayList2.add(materialMenuData.getPrefixText() + "_" + i2);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.tabs = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.simple), getString(R.string.cartoon)});
        View viewInflate = inflater.inflate(R.layout.fragment_op_material_list, container, false);
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
        FragmentOpMaterialListBinding fragmentOpMaterialListBinding = (FragmentOpMaterialListBinding) DataBindingUtil.bind(rootView);
        if (fragmentOpMaterialListBinding == null) {
            return;
        }
        setBinding(fragmentOpMaterialListBinding);
        ViewPager viewPager = getBinding().viewPager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager.setAdapter(new Adapter(this, childFragmentManager));
        getBinding().tabLayout.setupWithViewPager(getBinding().viewPager);
    }

    /* JADX INFO: compiled from: EdgingOpListFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/ask/printersdk/ui/EdgingOpListFragment$Adapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Lcom/ask/printersdk/ui/EdgingOpListFragment;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", ViewProps.POSITION, "getPageTitle", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Adapter extends FragmentStatePagerAdapter {
        final /* synthetic */ EdgingOpListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(EdgingOpListFragment edgingOpListFragment, FragmentManager fm) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.this$0 = edgingOpListFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List list = this.this$0.tabs;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabs");
                list = null;
            }
            return list.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int position) {
            List<String> list = this.this$0.getDataSource().get(position);
            EdgingListFragment edgingListFragment = new EdgingListFragment();
            edgingListFragment.setDatas(list);
            return edgingListFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            List list = this.this$0.tabs;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabs");
                list = null;
            }
            return (CharSequence) list.get(position);
        }
    }

    /* JADX INFO: compiled from: EdgingOpListFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ask/printersdk/ui/EdgingOpListFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/EdgingOpListFragment;)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        public Data() {
        }
    }
}
