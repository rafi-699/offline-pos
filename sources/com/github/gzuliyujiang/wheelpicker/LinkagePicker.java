package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout;
import com.github.gzuliyujiang.wheelview.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class LinkagePicker extends ModalDialog {
    private OnLinkagePickedListener onLinkagePickedListener;
    protected LinkageWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public LinkagePicker(Activity activity) {
        super(activity);
    }

    public LinkagePicker(Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        LinkageWheelLayout linkageWheelLayout = new LinkageWheelLayout(this.activity);
        this.wheelLayout = linkageWheelLayout;
        return linkageWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onLinkagePickedListener != null) {
            this.onLinkagePickedListener.onLinkagePicked(this.wheelLayout.getFirstWheelView().getCurrentItem(), this.wheelLayout.getSecondWheelView().getCurrentItem(), this.wheelLayout.getThirdWheelView().getCurrentItem());
        }
    }

    public void setData(LinkageProvider data) {
        this.wheelLayout.setData(data);
    }

    public void setDefaultValue(Object first, Object second, Object third) {
        this.wheelLayout.setDefaultValue(first, second, third);
    }

    public void setOnLinkagePickedListener(OnLinkagePickedListener onLinkagePickedListener) {
        this.onLinkagePickedListener = onLinkagePickedListener;
    }

    public final LinkageWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }

    public final WheelView getFirstWheelView() {
        return this.wheelLayout.getFirstWheelView();
    }

    public final WheelView getSecondWheelView() {
        return this.wheelLayout.getSecondWheelView();
    }

    public final WheelView getThirdWheelView() {
        return this.wheelLayout.getThirdWheelView();
    }

    public final TextView getFirstLabelView() {
        return this.wheelLayout.getFirstLabelView();
    }

    public final TextView getSecondLabelView() {
        return this.wheelLayout.getSecondLabelView();
    }

    public final TextView getThirdLabelView() {
        return this.wheelLayout.getThirdLabelView();
    }

    public final ProgressBar getLoadingView() {
        return this.wheelLayout.getLoadingView();
    }
}
