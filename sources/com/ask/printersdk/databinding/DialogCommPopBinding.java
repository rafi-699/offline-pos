package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogCommPopBinding extends ViewDataBinding {
    public final Button btnCancel;
    public final Button btnOk;
    public final TextView textDesc;
    public final TextView textDesc2;
    public final TextView textTitle;

    protected DialogCommPopBinding(Object obj, View view, int i, Button button, Button button2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.btnCancel = button;
        this.btnOk = button2;
        this.textDesc = textView;
        this.textDesc2 = textView2;
        this.textTitle = textView3;
    }

    public static DialogCommPopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCommPopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCommPopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_comm_pop, viewGroup, z, obj);
    }

    public static DialogCommPopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCommPopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCommPopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_comm_pop, null, false, obj);
    }

    public static DialogCommPopBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogCommPopBinding bind(View view, Object obj) {
        return (DialogCommPopBinding) bind(obj, view, R.layout.dialog_comm_pop);
    }
}
