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
import com.ask.printersdk.ui.QRCodeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentQrcodeStyleBindingImpl extends FragmentQrcodeStyleBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback45;
    private final View.OnClickListener mCallback46;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final TextView mboundView1;
    private final ImageView mboundView2;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.code_style_wrapper, 6);
    }

    public FragmentQrcodeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentQrcodeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[6], (CheckBox) objArr[4], (CheckBox) objArr[5]);
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
        setRootTag(view);
        this.mCallback45 = new OnClickListener(this, 1);
        this.mCallback46 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        setData((QRCodeStyleFragment.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.FragmentQrcodeStyleBinding
    public void setData(QRCodeStyleFragment.Data data) {
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
        return onChangeData((QRCodeStyleFragment.Data) obj, i2);
    }

    private boolean onChangeData(QRCodeStyleFragment.Data data, int i) {
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
        if (i != BR.codeFormat) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        QRCodeStyleFragment.Data data = this.mData;
        boolean isRedTintColor = false;
        String codeFormat = null;
        if ((15 & j) != 0) {
            String contentTxt = ((j & 11) == 0 || data == null) ? null : data.getContentTxt();
            if ((j & 9) != 0) {
                isRedTintColor = data != null ? data.getIsRedTintColor() : false;
                z2 = !isRedTintColor;
            } else {
                z2 = false;
            }
            if ((j & 13) != 0 && data != null) {
                codeFormat = data.getCodeFormat();
            }
            String str2 = codeFormat;
            codeFormat = contentTxt;
            str = str2;
            z = isRedTintColor;
            isRedTintColor = z2;
        } else {
            z = false;
            str = null;
        }
        if ((9 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.colorBlack, isRedTintColor);
            CompoundButtonBindingAdapter.setChecked(this.colorRed, z);
        }
        if ((11 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, codeFormat);
        }
        if ((8 & j) != 0) {
            BaseExtendsKt.click(this.mboundView1, this.mCallback45);
            BaseExtendsKt.click(this.mboundView2, this.mCallback46);
        }
        if ((j & 13) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        QRCodeStyleFragment.Data data;
        if (i != 1) {
            if (i == 2 && (data = this.mData) != null) {
                data.scanCode(view);
                return;
            }
            return;
        }
        QRCodeStyleFragment.Data data2 = this.mData;
        if (data2 != null) {
            data2.changeText(view);
        }
    }
}
