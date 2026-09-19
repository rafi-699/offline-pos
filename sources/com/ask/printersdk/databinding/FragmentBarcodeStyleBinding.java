package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.BarCodeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentBarcodeStyleBinding extends ViewDataBinding {
    public final LinearLayout codeStyleWrapper;
    public final CheckBox colorBlack;
    public final CheckBox colorRed;

    @Bindable
    protected BarCodeStyleFragment.Data mData;
    public final ImageView styleBottom;
    public final ImageView styleCenter;
    public final ImageView styleTop;

    public abstract void setData(BarCodeStyleFragment.Data data);

    protected FragmentBarcodeStyleBinding(Object obj, View view, int i, LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.codeStyleWrapper = linearLayout;
        this.colorBlack = checkBox;
        this.colorRed = checkBox2;
        this.styleBottom = imageView;
        this.styleCenter = imageView2;
        this.styleTop = imageView3;
    }

    public BarCodeStyleFragment.Data getData() {
        return this.mData;
    }

    public static FragmentBarcodeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBarcodeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBarcodeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_barcode_style, viewGroup, z, obj);
    }

    public static FragmentBarcodeStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBarcodeStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBarcodeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_barcode_style, null, false, obj);
    }

    public static FragmentBarcodeStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBarcodeStyleBinding bind(View view, Object obj) {
        return (FragmentBarcodeStyleBinding) bind(obj, view, R.layout.fragment_barcode_style);
    }
}
