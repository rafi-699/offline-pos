package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ask.printersdk.BR;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.ui.dialog.TextInputDialog;

/* JADX INFO: loaded from: classes2.dex */
public class DialogTextInputBindingImpl extends DialogTextInputBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private InverseBindingListener editandroidTextAttrChanged;
    private final View.OnClickListener mCallback47;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    public DialogTextInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private DialogTextInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[1], (TextView) objArr[2]);
        this.editandroidTextAttrChanged = new InverseBindingListener() { // from class: com.ask.printersdk.databinding.DialogTextInputBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(DialogTextInputBindingImpl.this.edit);
                TextInputDialog.Data data = DialogTextInputBindingImpl.this.mData;
                if (data != null) {
                    data.setEditTxt(textString);
                }
            }
        };
        this.mDirtyFlags = -1L;
        this.edit.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        this.textFinish.setTag(null);
        setRootTag(view);
        this.mCallback47 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
        setData((TextInputDialog.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.DialogTextInputBinding
    public void setData(TextInputDialog.Data data) {
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
        return onChangeData((TextInputDialog.Data) obj, i2);
    }

    private boolean onChangeData(TextInputDialog.Data data, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i != BR.editTxt) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
        TextInputDialog.Data data = this.mData;
        long j2 = 7 & j;
        String editTxt = (j2 == 0 || data == null) ? null : data.getEditTxt();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.edit, editTxt);
        }
        if ((j & 4) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.edit, null, null, null, this.editandroidTextAttrChanged);
            BaseExtendsKt.click(this.textFinish, this.mCallback47);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        TextInputDialog.Data data = this.mData;
        if (data != null) {
            data.onBtnFinish(view);
        }
    }
}
