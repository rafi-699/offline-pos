package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogModifyDateBinding extends ViewDataBinding {
    public final ConstraintLayout dateContent;
    public final TextView dateTitle;
    public final DateWheelLayout dateWheel;
    public final ConstraintLayout formattedContent;
    public final OptionWheelLayout formattedWheel;
    public final TextView realTime;
    public final TextView showTimeText;
    public final LinearLayout tabLayout;
    public final SwitchCompat timeSwitch;
    public final TextView timeTitle;

    protected DialogModifyDateBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, DateWheelLayout dateWheelLayout, ConstraintLayout constraintLayout2, OptionWheelLayout optionWheelLayout, TextView textView2, TextView textView3, LinearLayout linearLayout, SwitchCompat switchCompat, TextView textView4) {
        super(obj, view, i);
        this.dateContent = constraintLayout;
        this.dateTitle = textView;
        this.dateWheel = dateWheelLayout;
        this.formattedContent = constraintLayout2;
        this.formattedWheel = optionWheelLayout;
        this.realTime = textView2;
        this.showTimeText = textView3;
        this.tabLayout = linearLayout;
        this.timeSwitch = switchCompat;
        this.timeTitle = textView4;
    }

    public static DialogModifyDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogModifyDateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_modify_date, viewGroup, z, obj);
    }

    public static DialogModifyDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyDateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogModifyDateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_modify_date, null, false, obj);
    }

    public static DialogModifyDateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogModifyDateBinding bind(View view, Object obj) {
        return (DialogModifyDateBinding) bind(obj, view, R.layout.dialog_modify_date);
    }
}
