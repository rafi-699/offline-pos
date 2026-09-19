package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.ShapeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentShapeStyleBinding extends ViewDataBinding {
    public final CheckBox colorBlack;
    public final CheckBox colorRed;

    @Bindable
    protected ShapeStyleFragment.Data mData;
    public final RecyclerView recyclerView;
    public final ImageView shapeDashLine;
    public final ImageView shapeLine;

    public abstract void setData(ShapeStyleFragment.Data data);

    protected FragmentShapeStyleBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, RecyclerView recyclerView, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.colorBlack = checkBox;
        this.colorRed = checkBox2;
        this.recyclerView = recyclerView;
        this.shapeDashLine = imageView;
        this.shapeLine = imageView2;
    }

    public ShapeStyleFragment.Data getData() {
        return this.mData;
    }

    public static FragmentShapeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShapeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentShapeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shape_style, viewGroup, z, obj);
    }

    public static FragmentShapeStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShapeStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentShapeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_shape_style, null, false, obj);
    }

    public static FragmentShapeStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentShapeStyleBinding bind(View view, Object obj) {
        return (FragmentShapeStyleBinding) bind(obj, view, R.layout.fragment_shape_style);
    }
}
