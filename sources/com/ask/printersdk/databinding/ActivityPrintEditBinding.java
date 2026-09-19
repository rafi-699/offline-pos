package com.ask.printersdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.ui.PrintEditActivity;
import com.ask.printersdk.ui.widget.TextViewDrawable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityPrintEditBinding extends ViewDataBinding {
    public final ImageView btnBoardReset;
    public final DrawingSurfaceView drawingView;
    public final ImageView imageBack;
    public final ImageView imageBackward;
    public final ImageView imageForward;
    public final ImageView imageSetting;
    public final LinearLayout layoutBar;
    public final LinearLayout layoutBottomBar;
    public final RelativeLayout layoutTitleBar;

    @Bindable
    protected PrintEditActivity.Data mData;
    public final TextView textTitle;
    public final TextViewDrawable tvSave;

    public abstract void setData(PrintEditActivity.Data data);

    protected ActivityPrintEditBinding(Object obj, View view, int i, ImageView imageView, DrawingSurfaceView drawingSurfaceView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextViewDrawable textViewDrawable) {
        super(obj, view, i);
        this.btnBoardReset = imageView;
        this.drawingView = drawingSurfaceView;
        this.imageBack = imageView2;
        this.imageBackward = imageView3;
        this.imageForward = imageView4;
        this.imageSetting = imageView5;
        this.layoutBar = linearLayout;
        this.layoutBottomBar = linearLayout2;
        this.layoutTitleBar = relativeLayout;
        this.textTitle = textView;
        this.tvSave = textViewDrawable;
    }

    public PrintEditActivity.Data getData() {
        return this.mData;
    }

    public static ActivityPrintEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrintEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPrintEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_print_edit, viewGroup, z, obj);
    }

    public static ActivityPrintEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrintEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPrintEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_print_edit, null, false, obj);
    }

    public static ActivityPrintEditBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrintEditBinding bind(View view, Object obj) {
        return (ActivityPrintEditBinding) bind(obj, view, R.layout.activity_print_edit);
    }
}
