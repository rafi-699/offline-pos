package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.TextOpFragment;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTextOpBinding extends ViewDataBinding {

    @Bindable
    protected TextOpFragment.Data mData;
    public final TabLayout tabLayout;
    public final ViewPager viewPager;

    public abstract void setData(TextOpFragment.Data data);

    protected FragmentTextOpBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    public TextOpFragment.Data getData() {
        return this.mData;
    }

    public static FragmentTextOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTextOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_op, viewGroup, z, obj);
    }

    public static FragmentTextOpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextOpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTextOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_op, null, false, obj);
    }

    public static FragmentTextOpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextOpBinding bind(View view, Object obj) {
        return (FragmentTextOpBinding) bind(obj, view, R.layout.fragment_text_op);
    }
}
