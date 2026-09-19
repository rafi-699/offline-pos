package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTextFontBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected FragmentTextFontBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static FragmentTextFontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextFontBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTextFontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_font, viewGroup, z, obj);
    }

    public static FragmentTextFontBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextFontBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTextFontBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_font, null, false, obj);
    }

    public static FragmentTextFontBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextFontBinding bind(View view, Object obj) {
        return (FragmentTextFontBinding) bind(obj, view, R.layout.fragment_text_font);
    }
}
