package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentImageConvertBinding extends ViewDataBinding {
    public final SwitchCompat scaleSwitch;
    public final SeekBar seekBar;

    protected FragmentImageConvertBinding(Object obj, View view, int i, SwitchCompat switchCompat, SeekBar seekBar) {
        super(obj, view, i);
        this.scaleSwitch = switchCompat;
        this.seekBar = seekBar;
    }

    public static FragmentImageConvertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageConvertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentImageConvertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_image_convert, viewGroup, z, obj);
    }

    public static FragmentImageConvertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageConvertBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentImageConvertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_image_convert, null, false, obj);
    }

    public static FragmentImageConvertBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentImageConvertBinding bind(View view, Object obj) {
        return (FragmentImageConvertBinding) bind(obj, view, R.layout.fragment_image_convert);
    }
}
