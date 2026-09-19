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
public abstract class ItemFunPickerBinding extends ViewDataBinding {
    public final ImageView image;
    public final TextView text;

    protected ItemFunPickerBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.image = imageView;
        this.text = textView;
    }

    public static ItemFunPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFunPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fun_picker, viewGroup, z, obj);
    }

    public static ItemFunPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFunPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fun_picker, null, false, obj);
    }

    public static ItemFunPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFunPickerBinding bind(View view, Object obj) {
        return (ItemFunPickerBinding) bind(obj, view, R.layout.item_fun_picker);
    }
}
