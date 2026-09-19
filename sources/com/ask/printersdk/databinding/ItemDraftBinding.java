package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemDraftBinding extends ViewDataBinding {
    public final ImageView image;

    protected ItemDraftBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.image = imageView;
    }

    public static ItemDraftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDraftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDraftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_draft, viewGroup, z, obj);
    }

    public static ItemDraftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDraftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDraftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_draft, null, false, obj);
    }

    public static ItemDraftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDraftBinding bind(View view, Object obj) {
        return (ItemDraftBinding) bind(obj, view, R.layout.item_draft);
    }
}
