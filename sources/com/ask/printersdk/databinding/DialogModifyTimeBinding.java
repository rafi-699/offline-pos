package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogModifyTimeBinding extends ViewDataBinding {
    public final ConstraintLayout dateContent;
    public final TextView dateTitle;
    public final ConstraintLayout formattedContent;
    public final OptionWheelLayout formattedWheel;
    public final ImageView hourStyle;
    public final LinearLayout hourStyleBg;
    public final View line;
    public final TextView realTime;
    public final TextView showTimeText;
    public final LinearLayout tabLayout;
    public final SwitchCompat timeSwitch;
    public final TextView timeTitle;
    public final TimeWheelLayout timeWheel;

    protected DialogModifyTimeBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, OptionWheelLayout optionWheelLayout, ImageView imageView, LinearLayout linearLayout, View view2, TextView textView2, TextView textView3, LinearLayout linearLayout2, SwitchCompat switchCompat, TextView textView4, TimeWheelLayout timeWheelLayout) {
        super(obj, view, i);
        this.dateContent = constraintLayout;
        this.dateTitle = textView;
        this.formattedContent = constraintLayout2;
        this.formattedWheel = optionWheelLayout;
        this.hourStyle = imageView;
        this.hourStyleBg = linearLayout;
        this.line = view2;
        this.realTime = textView2;
        this.showTimeText = textView3;
        this.tabLayout = linearLayout2;
        this.timeSwitch = switchCompat;
        this.timeTitle = textView4;
        this.timeWheel = timeWheelLayout;
    }

    public static DialogModifyTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogModifyTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_modify_time, viewGroup, z, obj);
    }

    public static DialogModifyTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyTimeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogModifyTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_modify_time, null, false, obj);
    }

    public static DialogModifyTimeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyTimeBinding bind(View view, Object obj) {
        return (DialogModifyTimeBinding) bind(obj, view, R.layout.dialog_modify_time);
    }
}
