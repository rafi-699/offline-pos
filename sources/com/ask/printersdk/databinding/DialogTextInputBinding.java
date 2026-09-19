package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.dialog.TextInputDialog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogTextInputBinding extends ViewDataBinding {
    public final EditText edit;

    @Bindable
    protected TextInputDialog.Data mData;
    public final TextView textFinish;

    public abstract void setData(TextInputDialog.Data data);

    protected DialogTextInputBinding(Object obj, View view, int i, EditText editText, TextView textView) {
        super(obj, view, i);
        this.edit = editText;
        this.textFinish = textView;
    }

    public TextInputDialog.Data getData() {
        return this.mData;
    }

    public static DialogTextInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTextInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogTextInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_text_input, viewGroup, z, obj);
    }

    public static DialogTextInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTextInputBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTextInputBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_text_input, null, false, obj);
    }

    public static DialogTextInputBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTextInputBinding bind(View view, Object obj) {
        return (DialogTextInputBinding) bind(obj, view, R.layout.dialog_text_input);
    }
}
