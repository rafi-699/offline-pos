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
import androidx.viewpager.widget.ViewPager;
import com.ask.printersdk.R;
import com.ask.printersdk.databinding.FragmentImageOpBinding;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageOpFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ask/printersdk/ui/ImageOpFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ask/printersdk/ui/PrintEditViewModel;", "getViewModel", "()Lcom/ask/printersdk/ui/PrintEditViewModel;", "setViewModel", "(Lcom/ask/printersdk/ui/PrintEditViewModel;)V", "data", "Lcom/ask/printersdk/ui/ImageOpFragment$Data;", "getData", "()Lcom/ask/printersdk/ui/ImageOpFragment$Data;", "binding", "Lcom/ask/printersdk/databinding/FragmentImageOpBinding;", "getBinding", "()Lcom/ask/printersdk/databinding/FragmentImageOpBinding;", "setBinding", "(Lcom/ask/printersdk/databinding/FragmentImageOpBinding;)V", "tabs", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "rootView", "Adapter", "Data", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageOpFragment extends Fragment {
    public FragmentImageOpBinding binding;
    private final Data data = new Data();
    private List<String> tabs;
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

    public final FragmentImageOpBinding getBinding() {
        FragmentImageOpBinding fragmentImageOpBinding = this.binding;
        if (fragmentImageOpBinding != null) {
            return fragmentImageOpBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentImageOpBinding fragmentImageOpBinding) {
        Intrinsics.checkNotNullParameter(fragmentImageOpBinding, "<set-?>");
        this.binding = fragmentImageOpBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.tabs = CollectionsKt.listOf((Object[]) new String[]{getString(R.string.image), getString(R.string.align_mirror)});
        View viewInflate = inflater.inflate(R.layout.fragment_image_op, container, false);
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
        FragmentImageOpBinding fragmentImageOpBinding = (FragmentImageOpBinding) DataBindingUtil.bind(rootView);
        if (fragmentImageOpBinding == null) {
            return;
        }
        setBinding(fragmentImageOpBinding);
        getBinding().setData(this.data);
        ViewPager viewPager = getBinding().viewPager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        viewPager.setAdapter(new Adapter(this, childFragmentManager));
        getBinding().tabLayout.setupWithViewPager(getBinding().viewPager);
    }

    /* JADX INFO: compiled from: ImageOpFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/ask/printersdk/ui/ImageOpFragment$Adapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Lcom/ask/printersdk/ui/ImageOpFragment;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", ViewProps.POSITION, "getPageTitle", "", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Adapter extends FragmentStatePagerAdapter {
        final /* synthetic */ ImageOpFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(ImageOpFragment imageOpFragment, FragmentManager fm) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.this$0 = imageOpFragment;
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
            if (position == 0) {
                return new ImageConvertFragment();
            }
            return new GraphAlignFragment();
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

    /* JADX INFO: compiled from: ImageOpFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ask/printersdk/ui/ImageOpFragment$Data;", "Landroidx/databinding/BaseObservable;", "<init>", "(Lcom/ask/printersdk/ui/ImageOpFragment;)V", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Data extends BaseObservable {
        public Data() {
        }
    }
}
