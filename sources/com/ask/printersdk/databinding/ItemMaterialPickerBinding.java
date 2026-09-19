package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemMaterialPickerBinding extends ViewDataBinding {
    public final ImageView image;

    protected ItemMaterialPickerBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.image = imageView;
    }

    public static ItemMaterialPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMaterialPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMaterialPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_material_picker, viewGroup, z, obj);
    }

    public static ItemMaterialPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMaterialPickerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMaterialPickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_material_picker, null, false, obj);
    }

    public static ItemMaterialPickerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemMaterialPickerBinding bind(View view, Object obj) {
        return (ItemMaterialPickerBinding) bind(obj, view, R.layout.item_material_picker);
    }
}
