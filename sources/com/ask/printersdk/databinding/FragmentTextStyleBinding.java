package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.TextStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentTextStyleBinding extends ViewDataBinding {
    public final SwitchCompat autoFontSwitch;
    public final TextView edit;
    public final LinearLayout editLayout;

    @Bindable
    protected TextStyleFragment.Data mData;
    public final SeekBar seekBar;
    public final ImageView verticalAlignContent;
    public final LinearLayout verticalAlignLayout;

    public abstract void setData(TextStyleFragment.Data data);

    protected FragmentTextStyleBinding(Object obj, View view, int i, SwitchCompat switchCompat, TextView textView, LinearLayout linearLayout, SeekBar seekBar, ImageView imageView, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.autoFontSwitch = switchCompat;
        this.edit = textView;
        this.editLayout = linearLayout;
        this.seekBar = seekBar;
        this.verticalAlignContent = imageView;
        this.verticalAlignLayout = linearLayout2;
    }

    public TextStyleFragment.Data getData() {
        return this.mData;
    }

    public static FragmentTextStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextStyleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTextStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_style, viewGroup, z, obj);
    }

    public static FragmentTextStyleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextStyleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTextStyleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_text_style, null, false, obj);
    }

    public static FragmentTextStyleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTextStyleBinding bind(View view, Object obj) {
        return (FragmentTextStyleBinding) bind(obj, view, R.layout.fragment_text_style);
    }
}
