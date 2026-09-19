package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FloatMenuItemBinding extends ViewDataBinding {
    public final ImageView contentIcon;
    public final TextView contentText;
    public final ImageView statusSelect;

    protected FloatMenuItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2) {
        super(obj, view, i);
        this.contentIcon = imageView;
        this.contentText = textView;
        this.statusSelect = imageView2;
    }

    public static FloatMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FloatMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FloatMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.float_menu_item, viewGroup, z, obj);
    }

    public static FloatMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FloatMenuItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FloatMenuItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.float_menu_item, null, false, obj);
    }

    public static FloatMenuItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FloatMenuItemBinding bind(View view, Object obj) {
        return (FloatMenuItemBinding) bind(obj, view, R.layout.float_menu_item);
    }
}
