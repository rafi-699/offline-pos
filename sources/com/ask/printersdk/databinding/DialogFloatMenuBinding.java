package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogFloatMenuBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected DialogFloatMenuBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static DialogFloatMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFloatMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFloatMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_float_menu, viewGroup, z, obj);
    }

    public static DialogFloatMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFloatMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFloatMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_float_menu, null, false, obj);
    }

    public static DialogFloatMenuBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFloatMenuBinding bind(View view, Object obj) {
        return (DialogFloatMenuBinding) bind(obj, view, R.layout.dialog_float_menu);
    }
}
