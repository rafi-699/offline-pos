package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ask.printersdk.BR;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.ui.GraphAlignFragment;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentGraphAlignBindingImpl extends FragmentGraphAlignBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback1;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback14;
    private final View.OnClickListener mCallback2;
    private final View.OnClickListener mCallback3;
    private final View.OnClickListener mCallback4;
    private final View.OnClickListener mCallback5;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView10;
    private final ImageView mboundView11;
    private final ImageView mboundView12;
    private final ImageView mboundView13;
    private final ImageView mboundView14;
    private final ImageView mboundView2;
    private final ImageView mboundView3;
    private final ImageView mboundView5;
    private final ImageView mboundView6;
    private final ImageView mboundView7;
    private final ImageView mboundView8;
    private final ImageView mboundView9;

    public FragmentGraphAlignBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private FragmentGraphAlignBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[10];
        this.mboundView10 = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[11];
        this.mboundView11 = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[12];
        this.mboundView12 = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) objArr[13];
        this.mboundView13 = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) objArr[14];
        this.mboundView14 = imageView6;
        imageView6.setTag(null);
        ImageView imageView7 = (ImageView) objArr[2];
        this.mboundView2 = imageView7;
        imageView7.setTag(null);
        ImageView imageView8 = (ImageView) objArr[3];
        this.mboundView3 = imageView8;
        imageView8.setTag(null);
        ImageView imageView9 = (ImageView) objArr[5];
        this.mboundView5 = imageView9;
        imageView9.setTag(null);
        ImageView imageView10 = (ImageView) objArr[6];
        this.mboundView6 = imageView10;
        imageView10.setTag(null);
        ImageView imageView11 = (ImageView) objArr[7];
        this.mboundView7 = imageView11;
        imageView11.setTag(null);
        ImageView imageView12 = (ImageView) objArr[8];
        this.mboundView8 = imageView12;
        imageView12.setTag(null);
        ImageView imageView13 = (ImageView) objArr[9];
        this.mboundView9 = imageView13;
        imageView13.setTag(null);
        this.opLock.setTag(null);
        setRootTag(view);
        this.mCallback14 = new OnClickListener(this, 14);
        this.mCallback12 = new OnClickListener(this, 12);
        this.mCallback13 = new OnClickListener(this, 13);
        this.mCallback10 = new OnClickListener(this, 10);
        this.mCallback11 = new OnClickListener(this, 11);
        this.mCallback9 = new OnClickListener(this, 9);
        this.mCallback7 = new OnClickListener(this, 7);
        this.mCallback8 = new OnClickListener(this, 8);
        this.mCallback5 = new OnClickListener(this, 5);
        this.mCallback6 = new OnClickListener(this, 6);
        this.mCallback3 = new OnClickListener(this, 3);
        this.mCallback4 = new OnClickListener(this, 4);
        this.mCallback1 = new OnClickListener(this, 1);
        this.mCallback2 = new OnClickListener(this, 2);
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
        setData((GraphAlignFragment.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.FragmentGraphAlignBinding
    public void setData(GraphAlignFragment.Data data) {
        updateRegistration(0, data);
        this.mData = data;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeData((GraphAlignFragment.Data) obj, i2);
    }

    private boolean onChangeData(GraphAlignFragment.Data data, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        GraphAlignFragment.Data data = this.mData;
        if ((j & 2) != 0) {
            BaseExtendsKt.click(this.mboundView1, this.mCallback1);
            BaseExtendsKt.click(this.mboundView10, this.mCallback10);
            BaseExtendsKt.click(this.mboundView11, this.mCallback11);
            BaseExtendsKt.click(this.mboundView12, this.mCallback12);
            BaseExtendsKt.click(this.mboundView13, this.mCallback13);
            BaseExtendsKt.click(this.mboundView14, this.mCallback14);
            BaseExtendsKt.click(this.mboundView2, this.mCallback2);
            BaseExtendsKt.click(this.mboundView3, this.mCallback3);
            BaseExtendsKt.click(this.mboundView5, this.mCallback5);
            BaseExtendsKt.click(this.mboundView6, this.mCallback6);
            BaseExtendsKt.click(this.mboundView7, this.mCallback7);
            BaseExtendsKt.click(this.mboundView8, this.mCallback8);
            BaseExtendsKt.click(this.mboundView9, this.mCallback9);
            BaseExtendsKt.click(this.opLock, this.mCallback4);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                GraphAlignFragment.Data data = this.mData;
                if (data != null) {
                    data.onReset(view);
                }
                break;
            case 2:
                GraphAlignFragment.Data data2 = this.mData;
                if (data2 != null) {
                    data2.onDelete(view);
                }
                break;
            case 3:
                GraphAlignFragment.Data data3 = this.mData;
                if (data3 != null) {
                    data3.onRotate(view);
                }
                break;
            case 4:
                GraphAlignFragment.Data data4 = this.mData;
                if (data4 != null) {
                    data4.onLock(view);
                }
                break;
            case 5:
                GraphAlignFragment.Data data5 = this.mData;
                if (data5 != null) {
                    data5.onAlignLeft(view);
                }
                break;
            case 6:
                GraphAlignFragment.Data data6 = this.mData;
                if (data6 != null) {
                    data6.onAlignMiddle2Hori(view);
                }
                break;
            case 7:
                GraphAlignFragment.Data data7 = this.mData;
                if (data7 != null) {
                    data7.onAlignRight(view);
                }
                break;
            case 8:
                GraphAlignFragment.Data data8 = this.mData;
                if (data8 != null) {
                    data8.onAlignTop(view);
                }
                break;
            case 9:
                GraphAlignFragment.Data data9 = this.mData;
                if (data9 != null) {
                    data9.onAlignMiddle(view);
                }
                break;
            case 10:
                GraphAlignFragment.Data data10 = this.mData;
                if (data10 != null) {
                    data10.onAlignBottom(view);
                }
                break;
            case 11:
                GraphAlignFragment.Data data11 = this.mData;
                if (data11 != null) {
                    data11.onMoveStep(view, 1);
                }
                break;
            case 12:
                GraphAlignFragment.Data data12 = this.mData;
                if (data12 != null) {
                    data12.onMoveStep(view, 3);
                }
                break;
            case 13:
                GraphAlignFragment.Data data13 = this.mData;
                if (data13 != null) {
                    data13.onMoveStep(view, 4);
                }
                break;
            case 14:
                GraphAlignFragment.Data data14 = this.mData;
                if (data14 != null) {
                    data14.onMoveStep(view, 2);
                }
                break;
        }
    }
}
