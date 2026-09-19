package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberPickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.NumberWheelLayout;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class NumberPicker extends ModalDialog {
    private OnNumberPickedListener onNumberPickedListener;
    protected NumberWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public NumberPicker(Activity activity) {
        super(activity);
    }

    public NumberPicker(Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        NumberWheelLayout numberWheelLayout = new NumberWheelLayout(this.activity);
        this.wheelLayout = numberWheelLayout;
        return numberWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onNumberPickedListener != null) {
            this.onNumberPickedListener.onNumberPicked(this.wheelLayout.getWheelView().getCurrentPosition(), (Number) this.wheelLayout.getWheelView().getCurrentItem());
        }
    }

    public void setFormatter(WheelFormatter formatter) {
        this.wheelLayout.getWheelView().setFormatter(formatter);
    }

    public void setRange(int min, int max, int step) {
        this.wheelLayout.setRange(min, max, step);
    }

    public void setRange(float min, float max, float step) {
        this.wheelLayout.setRange(min, max, step);
    }

    public void setDefaultValue(Object item) {
        this.wheelLayout.setDefaultValue(item);
    }

    public void setDefaultPosition(int position) {
        this.wheelLayout.setDefaultPosition(position);
    }

    public final void setOnNumberPickedListener(OnNumberPickedListener onNumberPickedListener) {
        this.onNumberPickedListener = onNumberPickedListener;
    }

    public final NumberWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }

    public final WheelView getWheelView() {
        return this.wheelLayout.getWheelView();
    }

    public final TextView getLabelView() {
        return this.wheelLayout.getLabelView();
    }
}
