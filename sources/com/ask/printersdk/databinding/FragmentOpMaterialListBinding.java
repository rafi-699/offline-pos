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
public abstract class FragmentOpMaterialListBinding extends ViewDataBinding {
    public final TabLayout tabLayout;
    public final ViewPager viewPager;

    protected FragmentOpMaterialListBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    public static FragmentOpMaterialListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOpMaterialListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentOpMaterialListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_op_material_list, viewGroup, z, obj);
    }

    public static FragmentOpMaterialListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOpMaterialListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentOpMaterialListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_op_material_list, null, false, obj);
    }

    public static FragmentOpMaterialListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOpMaterialListBinding bind(View view, Object obj) {
        return (FragmentOpMaterialListBinding) bind(obj, view, R.layout.fragment_op_material_list);
    }
}
