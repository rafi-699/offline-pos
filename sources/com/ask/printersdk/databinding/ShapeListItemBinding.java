package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ShapeListItemBinding extends ViewDataBinding {
    public final ConstraintLayout container;
    public final ImageView image;

    protected ShapeListItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.container = constraintLayout;
        this.image = imageView;
    }

    public static ShapeListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShapeListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShapeListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.shape_list_item, viewGroup, z, obj);
    }

    public static ShapeListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShapeListItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShapeListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.shape_list_item, null, false, obj);
    }

    public static ShapeListItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShapeListItemBinding bind(View view, Object obj) {
        return (ShapeListItemBinding) bind(obj, view, R.layout.shape_list_item);
    }
}
