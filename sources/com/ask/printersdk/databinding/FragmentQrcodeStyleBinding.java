package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.QRCodeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentQrcodeStyleBinding extends ViewDataBinding {
    public final LinearLayout codeStyleWrapper;
    public final CheckBox colorBlack;
    public final CheckBox colorRed;

    @Bindable
    protected QRCodeStyleFragment.Data mData;

    public abstract void setData(QRCodeStyleFragment.Data data);

    protected FragmentQrcodeStyleBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2) {
        super(obj, view, i);
        this.codeStyleWrapper = linearLayout;
        this.colorBlack = checkBox;
        this.colorRed = checkBox2;
    }

    public QRCodeStyleFragment.Data getData() {
        return this.mData;
    }

    public static FragmentQrcodeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentQrcodeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_qrcode_style, viewGroup, z, obj);
    }

    public static FragmentQrcodeStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentQrcodeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_qrcode_style, null, false, obj);
    }

    public static FragmentQrcodeStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeStyleBinding bind(View view, Object obj) {
        return (FragmentQrcodeStyleBinding) bind(obj, view, R.layout.fragment_qrcode_style);
    }
}
