package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.R;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;

/* JADX INFO: loaded from: classes2.dex */
public class DialogModifyTimeBindingImpl extends DialogModifyTimeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 1);
        sparseIntArray.put(R.id.date_title, 2);
        sparseIntArray.put(R.id.time_title, 3);
        sparseIntArray.put(R.id.date_content, 4);
        sparseIntArray.put(R.id.show_time_text, 5);
        sparseIntArray.put(R.id.time_switch, 6);
        sparseIntArray.put(R.id.time_wheel, 7);
        sparseIntArray.put(R.id.line, 8);
        sparseIntArray.put(R.id.hour_style_bg, 9);
        sparseIntArray.put(R.id.hour_style, 10);
        sparseIntArray.put(R.id.real_time, 11);
        sparseIntArray.put(R.id.formatted_content, 12);
        sparseIntArray.put(R.id.formatted_wheel, 13);
    }

    public DialogModifyTimeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private DialogModifyTimeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[4], (TextView) objArr[2], (ConstraintLayout) objArr[12], (OptionWheelLayout) objArr[13], (ImageView) objArr[10], (LinearLayout) objArr[9], (View) objArr[8], (TextView) objArr[11], (TextView) objArr[5], (LinearLayout) objArr[1], (SwitchCompat) objArr[6], (TextView) objArr[3], (TimeWheelLayout) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
