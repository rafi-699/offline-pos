package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTimeStyleBinding extends ViewDataBinding {
    public final TextView dateTv;
    public final TextView prefixTv;
    public final SwitchCompat timeSwitch;
    public final TextView timeTv;

    protected FragmentTimeStyleBinding(Object obj, View view, int i, TextView textView, TextView textView2, SwitchCompat switchCompat, TextView textView3) {
        super(obj, view, i);
        this.dateTv = textView;
        this.prefixTv = textView2;
        this.timeSwitch = switchCompat;
        this.timeTv = textView3;
    }

    public static FragmentTimeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTimeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_time_style, viewGroup, z, obj);
    }

    public static FragmentTimeStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTimeStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_time_style, null, false, obj);
    }

    public static FragmentTimeStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTimeStyleBinding bind(View view, Object obj) {
        return (FragmentTimeStyleBinding) bind(obj, view, R.layout.fragment_time_style);
    }
}
