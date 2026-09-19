package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.ui.dialog.SettingPaperDialog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogSettingPaperBinding extends ViewDataBinding {
    public final ImageView imageClose;

    @Bindable
    protected SettingPaperDialog.Data mData;

    public abstract void setData(SettingPaperDialog.Data data);

    protected DialogSettingPaperBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.imageClose = imageView;
    }

    public SettingPaperDialog.Data getData() {
        return this.mData;
    }

    public static DialogSettingPaperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSettingPaperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSettingPaperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_setting_paper, viewGroup, z, obj);
    }

    public static DialogSettingPaperBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSettingPaperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSettingPaperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_setting_paper, null, false, obj);
    }

    public static DialogSettingPaperBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSettingPaperBinding bind(View view, Object obj) {
        return (DialogSettingPaperBinding) bind(obj, view, R.layout.dialog_setting_paper);
    }
}
