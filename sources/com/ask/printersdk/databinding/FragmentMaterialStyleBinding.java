package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentMaterialStyleBinding extends ViewDataBinding {
    public final CheckBox colorBlack;
    public final CheckBox colorRed;
    public final SwitchCompat reverseSwitch;
    public final SwitchCompat scaleSwitch;

    protected FragmentMaterialStyleBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, SwitchCompat switchCompat, SwitchCompat switchCompat2) {
        super(obj, view, i);
        this.colorBlack = checkBox;
        this.colorRed = checkBox2;
        this.reverseSwitch = switchCompat;
        this.scaleSwitch = switchCompat2;
    }

    public static FragmentMaterialStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMaterialStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMaterialStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_material_style, viewGroup, z, obj);
    }

    public static FragmentMaterialStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMaterialStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMaterialStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_material_style, null, false, obj);
    }

    public static FragmentMaterialStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMaterialStyleBinding bind(View view, Object obj) {
        return (FragmentMaterialStyleBinding) bind(obj, view, R.layout.fragment_material_style);
    }
}
