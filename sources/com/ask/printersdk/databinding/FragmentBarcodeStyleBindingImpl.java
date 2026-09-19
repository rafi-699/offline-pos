package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.ui.BarCodeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentBarcodeStyleBindingImpl extends FragmentBarcodeStyleBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback22;
    private final View.OnClickListener mCallback23;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private final View.OnClickListener mCallback26;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView2;
    private final TextView mboundView3;
    private final ImageView mboundView7;
    private final TextView mboundView8;
    private final ImageView mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.code_style_wrapper, 12);
    }

    public FragmentBarcodeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragmentBarcodeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[12], (CheckBox) objArr[10], (CheckBox) objArr[11], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.colorBlack.setTag(null);
        this.colorRed.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.mboundView7 = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.mboundView8 = textView3;
        textView3.setTag(null);
        ImageView imageView3 = (ImageView) objArr[9];
        this.mboundView9 = imageView3;
        imageView3.setTag(null);
        this.styleBottom.setTag(null);
        this.styleCenter.setTag(null);
        this.styleTop.setTag(null);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 6);
        this.mCallback28 = new OnClickListener(this, 7);
        this.mCallback25 = new OnClickListener(this, 4);
        this.mCallback26 = new OnClickListener(this, 5);
        this.mCallback23 = new OnClickListener(this, 2);
        this.mCallback24 = new OnClickListener(this, 3);
        this.mCallback22 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        setData((BarCodeStyleFragment.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.FragmentBarcodeStyleBinding
    public void setData(BarCodeStyleFragment.Data data) {
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
        return onChangeData((BarCodeStyleFragment.Data) obj, i2);
    }

    private boolean onChangeData(BarCodeStyleFragment.Data data, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == BR.contentTxt) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == BR.codeFormat) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i != BR.fontSize) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        boolean z;
        long j2;
        boolean z2;
        boolean isRedTintColor;
        boolean z3;
        String strValueOf;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BarCodeStyleFragment.Data data = this.mData;
        String codeFormat = null;
        if ((31 & j) != 0) {
            if ((j & 17) != 0) {
                isRedTintColor = data != null ? data.getIsRedTintColor() : false;
                z3 = !isRedTintColor;
            } else {
                isRedTintColor = false;
                z3 = false;
            }
            if ((j & 25) != 0) {
                strValueOf = String.valueOf(data != null ? data.getFontSize() : 0);
            } else {
                strValueOf = null;
            }
            String contentTxt = ((j & 19) == 0 || data == null) ? null : data.getContentTxt();
            if ((j & 21) != 0 && data != null) {
                codeFormat = data.getCodeFormat();
            }
            str = codeFormat;
            codeFormat = contentTxt;
            z2 = isRedTintColor;
            str2 = strValueOf;
            z = z3;
            j2 = 0;
        } else {
            str = null;
            str2 = null;
            z = false;
            j2 = 0;
            z2 = false;
        }
        if ((17 & j) != j2) {
            CompoundButtonBindingAdapter.setChecked(this.colorBlack, z);
            CompoundButtonBindingAdapter.setChecked(this.colorRed, z2);
        }
        if ((j & 19) != j2) {
            TextViewBindingAdapter.setText(this.mboundView1, codeFormat);
        }
        if ((16 & j) != j2) {
            BaseExtendsKt.click(this.mboundView1, this.mCallback22);
            BaseExtendsKt.click(this.mboundView2, this.mCallback23);
            BaseExtendsKt.click(this.mboundView7, this.mCallback27);
            BaseExtendsKt.click(this.mboundView9, this.mCallback28);
            this.styleBottom.setOnClickListener(this.mCallback24);
            this.styleCenter.setOnClickListener(this.mCallback25);
            this.styleTop.setOnClickListener(this.mCallback26);
        }
        if ((j & 21) != j2) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
        if ((j & 25) != j2) {
            TextViewBindingAdapter.setText(this.mboundView8, str2);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                BarCodeStyleFragment.Data data = this.mData;
                if (data != null) {
                    data.changeText(view);
                }
                break;
            case 2:
                BarCodeStyleFragment.Data data2 = this.mData;
                if (data2 != null) {
                    data2.scanCode(view);
                }
                break;
            case 3:
                BarCodeStyleFragment.Data data3 = this.mData;
                if (data3 != null) {
                    data3.changeStyle(2);
                }
                break;
            case 4:
                BarCodeStyleFragment.Data data4 = this.mData;
                if (data4 != null) {
                    data4.changeStyle(1);
                }
                break;
            case 5:
                BarCodeStyleFragment.Data data5 = this.mData;
                if (data5 != null) {
                    data5.changeStyle(0);
                }
                break;
            case 6:
                BarCodeStyleFragment.Data data6 = this.mData;
                if (data6 != null) {
                    data6.onFontSizeMinus(view);
                }
                break;
            case 7:
                BarCodeStyleFragment.Data data7 = this.mData;
                if (data7 != null) {
                    data7.onFontSizeAdd(view);
                }
                break;
        }
    }
}
