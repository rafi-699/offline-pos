package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.ui.dialog.SettingPaperDialog;

/* JADX INFO: loaded from: classes2.dex */
public class DialogSettingPaperBindingImpl extends DialogSettingPaperBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback44;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final EditText mboundView1;
    private InverseBindingListener mboundView1androidTextAttrChanged;
    private final EditText mboundView2;
    private InverseBindingListener mboundView2androidTextAttrChanged;
    private final Button mboundView3;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.image_close, 4);
    }

    public DialogSettingPaperBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private DialogSettingPaperBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4]);
        this.mboundView1androidTextAttrChanged = new InverseBindingListener() { // from class: com.ask.printersdk.databinding.DialogSettingPaperBindingImpl.1
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(DialogSettingPaperBindingImpl.this.mboundView1);
                SettingPaperDialog.Data data = DialogSettingPaperBindingImpl.this.mData;
                if (data != null) {
                    data.setPaperW(textString);
                }
            }
        };
        this.mboundView2androidTextAttrChanged = new InverseBindingListener() { // from class: com.ask.printersdk.databinding.DialogSettingPaperBindingImpl.2
            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(DialogSettingPaperBindingImpl.this.mboundView2);
                SettingPaperDialog.Data data = DialogSettingPaperBindingImpl.this.mData;
                if (data != null) {
                    data.setPaperH(textString);
                }
            }
        };
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.mboundView1 = editText;
        editText.setTag(null);
        EditText editText2 = (EditText) objArr[2];
        this.mboundView2 = editText2;
        editText2.setTag(null);
        Button button = (Button) objArr[3];
        this.mboundView3 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback44 = new OnClickListener(this, 1);
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
        setData((SettingPaperDialog.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.DialogSettingPaperBinding
    public void setData(SettingPaperDialog.Data data) {
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
        String paperW;
        String paperH;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingPaperDialog.Data data = this.mData;
        long j2 = 3 & j;
        if (j2 == 0 || data == null) {
            paperW = null;
            paperH = null;
        } else {
            paperH = data.getPaperH();
            paperW = data.getPaperW();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, paperW);
            TextViewBindingAdapter.setText(this.mboundView2, paperH);
        }
        if ((j & 2) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.mboundView1, null, null, null, this.mboundView1androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView2, null, null, null, this.mboundView2androidTextAttrChanged);
            BaseExtendsKt.click(this.mboundView3, this.mCallback44);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        SettingPaperDialog.Data data = this.mData;
        if (data != null) {
            data.onOkClick(view);
        }
    }
}
