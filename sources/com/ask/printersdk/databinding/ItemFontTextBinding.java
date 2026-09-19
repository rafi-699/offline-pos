package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemFontTextBinding extends ViewDataBinding {
    public final ImageView imageCopyright;
    public final ImageView imageDownload;
    public final ImageView imageSel;
    public final ImageView nameImage;
    public final TextView text;

    protected ItemFontTextBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView) {
        super(obj, view, i);
        this.imageCopyright = imageView;
        this.imageDownload = imageView2;
        this.imageSel = imageView3;
        this.nameImage = imageView4;
        this.text = textView;
    }

    public static ItemFontTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFontTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFontTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_font_text, viewGroup, z, obj);
    }

    public static ItemFontTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFontTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFontTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_font_text, null, false, obj);
    }

    public static ItemFontTextBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFontTextBinding bind(View view, Object obj) {
        return (ItemFontTextBinding) bind(obj, view, R.layout.item_font_text);
    }
}
