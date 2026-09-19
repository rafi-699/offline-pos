package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.ask.printersdk.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTimeOpBinding extends ViewDataBinding {
    public final TabLayout tabLayout;
    public final ViewPager viewPager;

    protected FragmentTimeOpBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    public static FragmentTimeOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTimeOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_time_op, viewGroup, z, obj);
    }

    public static FragmentTimeOpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeOpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTimeOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_time_op, null, false, obj);
    }

    public static FragmentTimeOpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeOpBinding bind(View view, Object obj) {
        return (FragmentTimeOpBinding) bind(obj, view, R.layout.fragment_time_op);
    }
}
