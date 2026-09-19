package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.graph.common.DrawingSurfaceView;
import com.ask.printersdk.ui.PrintEditActivity;
import com.ask.printersdk.ui.widget.TextViewDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPrintEditBindingImpl extends ActivityPrintEditBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback15;
    private final View.OnClickListener mCallback16;
    private final View.OnClickListener mCallback17;
    private final View.OnClickListener mCallback18;
    private final View.OnClickListener mCallback19;
    private final View.OnClickListener mCallback20;
    private final View.OnClickListener mCallback21;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final TextViewDrawable mboundView7;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_title_bar, 8);
        sparseIntArray.put(R.id.image_back, 9);
        sparseIntArray.put(R.id.text_title, 10);
        sparseIntArray.put(R.id.layout_bar, 11);
        sparseIntArray.put(R.id.drawing_view, 12);
        sparseIntArray.put(R.id.layout_bottom_bar, 13);
    }

    public ActivityPrintEditBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ActivityPrintEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (DrawingSurfaceView) objArr[12], (ImageView) objArr[9], (ImageView) objArr[2], (ImageView) objArr[3], (ImageView) objArr[4], (LinearLayout) objArr[11], (LinearLayout) objArr[13], (RelativeLayout) objArr[8], (TextView) objArr[10], (TextViewDrawable) objArr[6]);
        this.mDirtyFlags = -1L;
        this.btnBoardReset.setTag(null);
        this.imageBackward.setTag(null);
        this.imageForward.setTag(null);
        this.imageSetting.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextViewDrawable textViewDrawable = (TextViewDrawable) objArr[7];
        this.mboundView7 = textViewDrawable;
        textViewDrawable.setTag(null);
        this.tvSave.setTag(null);
        setRootTag(view);
        this.mCallback16 = new OnClickListener(this, 2);
        this.mCallback17 = new OnClickListener(this, 3);
        this.mCallback15 = new OnClickListener(this, 1);
        this.mCallback21 = new OnClickListener(this, 7);
        this.mCallback18 = new OnClickListener(this, 4);
        this.mCallback19 = new OnClickListener(this, 5);
        this.mCallback20 = new OnClickListener(this, 6);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
    public boolean setVariable(int i, Object obj) {
        if (BR.data != i) {
            return false;
        }
        setData((PrintEditActivity.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.ActivityPrintEditBinding
    public void setData(PrintEditActivity.Data data) {
        this.mData = data;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PrintEditActivity.Data data = this.mData;
        if ((j & 2) != 0) {
            BaseExtendsKt.click(this.btnBoardReset, this.mCallback19);
            BaseExtendsKt.click(this.imageBackward, this.mCallback16);
            BaseExtendsKt.click(this.imageForward, this.mCallback17);
            BaseExtendsKt.click(this.imageSetting, this.mCallback18);
            BaseExtendsKt.click(this.mboundView1, this.mCallback15);
            BaseExtendsKt.click(this.mboundView7, this.mCallback21);
            BaseExtendsKt.click(this.tvSave, this.mCallback20);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                PrintEditActivity.Data data = this.mData;
                if (data != null) {
                    data.onClearDrawing(view);
                }
                break;
            case 2:
                PrintEditActivity.Data data2 = this.mData;
                if (data2 != null) {
                    data2.onBackwardStep(view);
                }
                break;
            case 3:
                PrintEditActivity.Data data3 = this.mData;
                if (data3 != null) {
                    data3.onForwardStep(view);
                }
                break;
            case 4:
                PrintEditActivity.Data data4 = this.mData;
                if (data4 != null) {
                    data4.onSetting(view);
                }
                break;
            case 5:
                PrintEditActivity.Data data5 = this.mData;
                if (data5 != null) {
                    data5.onResetBoard(view);
                }
                break;
            case 6:
                PrintEditActivity.Data data6 = this.mData;
                if (data6 != null) {
                    data6.onSaveDraft(view);
                }
                break;
            case 7:
                PrintEditActivity.Data data7 = this.mData;
                if (data7 != null) {
                    data7.onPrinting(view);
                }
                break;
        }
    }
}
