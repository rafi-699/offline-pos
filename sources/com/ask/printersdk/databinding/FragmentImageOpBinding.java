package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.ImageOpFragment;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentImageOpBinding extends ViewDataBinding {

    @Bindable
    protected ImageOpFragment.Data mData;
    public final TabLayout tabLayout;
    public final ViewPager viewPager;

    public abstract void setData(ImageOpFragment.Data data);

    protected FragmentImageOpBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    public ImageOpFragment.Data getData() {
        return this.mData;
    }

    public static FragmentImageOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageOpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentImageOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_image_op, viewGroup, z, obj);
    }

    public static FragmentImageOpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageOpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentImageOpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_image_op, null, false, obj);
    }

    public static FragmentImageOpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageOpBinding bind(View view, Object obj) {
        return (FragmentImageOpBinding) bind(obj, view, R.layout.fragment_image_op);
    }
}
