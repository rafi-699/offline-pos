package com.ask.printersdk.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.ask.printersdk.BR;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.generated.callback.OnClickListener;
import com.ask.printersdk.ui.ShapeStyleFragment;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentShapeStyleBindingImpl extends FragmentShapeStyleBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback30;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final ImageView mboundView3;
    private final TextView mboundView4;
    private final ImageView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.recycler_view, 6);
        sparseIntArray.put(R.id.shape_line, 7);
        sparseIntArray.put(R.id.shape_dash_line, 8);
    }

    public FragmentShapeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentShapeStyleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[1], (CheckBox) objArr[2], (RecyclerView) objArr[6], (ImageView) objArr[8], (ImageView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.colorBlack.setTag(null);
        this.colorRed.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.mboundView3 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.mboundView5 = imageView2;
        imageView2.setTag(null);
        setRootTag(view);
        this.mCallback30 = new OnClickListener(this, 2);
        this.mCallback29 = new OnClickListener(this, 1);
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
        setData((ShapeStyleFragment.Data) obj);
        return true;
    }

    @Override // com.ask.printersdk.databinding.FragmentShapeStyleBinding
    public void setData(ShapeStyleFragment.Data data) {
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
        return onChangeData((ShapeStyleFragment.Data) obj, i2);
    }

    private boolean onChangeData(ShapeStyleFragment.Data data, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i != BR.lineWeightString) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d A[PHI: r9
  0x002d: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v3 java.lang.String) binds: [B:6:0x0013, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ShapeStyleFragment.Data data = this.mData;
        long j2 = 7 & j;
        boolean isRedTintColor = false;
        String lineWeightString = null;
        if (j2 == 0) {
            z = false;
        } else {
            lineWeightString = data != null ? data.getLineWeightString() : null;
            if ((j & 5) != 0) {
                isRedTintColor = data != null ? data.getIsRedTintColor() : false;
                boolean z2 = isRedTintColor;
                isRedTintColor = !isRedTintColor;
                z = z2;
            } else {
                z = false;
            }
        }
        if ((5 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.colorBlack, isRedTintColor);
            CompoundButtonBindingAdapter.setChecked(this.colorRed, z);
        }
        if ((j & 4) != 0) {
            BaseExtendsKt.click(this.mboundView3, this.mCallback29);
            BaseExtendsKt.click(this.mboundView5, this.mCallback30);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, lineWeightString);
        }
    }

    @Override // com.ask.printersdk.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ShapeStyleFragment.Data data;
        if (i != 1) {
            if (i == 2 && (data = this.mData) != null) {
                data.onLineWeightAdd(view);
                return;
            }
            return;
        }
        ShapeStyleFragment.Data data2 = this.mData;
        if (data2 != null) {
            data2.onLineWeightMinus(view);
        }
    }
}
