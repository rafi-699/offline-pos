package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.GraphAlignFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentGraphAlignBinding extends ViewDataBinding {

    @Bindable
    protected GraphAlignFragment.Data mData;
    public final ImageView opLock;

    public abstract void setData(GraphAlignFragment.Data data);

    protected FragmentGraphAlignBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.opLock = imageView;
    }

    public GraphAlignFragment.Data getData() {
        return this.mData;
    }

    public static FragmentGraphAlignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraphAlignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentGraphAlignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_graph_align, viewGroup, z, obj);
    }

    public static FragmentGraphAlignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraphAlignBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentGraphAlignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_graph_align, null, false, obj);
    }

    public static FragmentGraphAlignBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGraphAlignBinding bind(View view, Object obj) {
        return (FragmentGraphAlignBinding) bind(obj, view, R.layout.fragment_graph_align);
    }
}
