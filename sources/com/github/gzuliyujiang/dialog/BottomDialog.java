package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BottomDialog extends BaseDialog {
    protected View maskView;

    protected boolean enableMaskView() {
        return true;
    }

    public BottomDialog(Activity activity) {
        super(activity, R.style.DialogTheme_Sheet);
    }

    public BottomDialog(Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setWidth(this.activity.getResources().getDisplayMetrics().widthPixels);
        setGravity(80);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        super.onShow(dialog);
        if (enableMaskView()) {
            addMaskView();
        }
    }

    protected void addMaskView() {
        try {
            getWindow().setDimAmount(0.0f);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            Point point = new Point();
            this.activity.getWindowManager().getDefaultDisplay().getRealSize(point);
            layoutParams.height = point.y - this.activity.getResources().getDimensionPixelSize(this.activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            layoutParams.gravity = 48;
            if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            layoutParams.systemUiVisibility = 1280;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.token = this.activity.getWindow().getDecorView().getWindowToken();
            layoutParams.softInputMode = 18;
            View view = new View(this.activity);
            this.maskView = view;
            view.setBackgroundColor(2130706432);
            this.maskView.setFitsSystemWindows(false);
            this.maskView.setOnKeyListener(new View.OnKeyListener() { // from class: com.github.gzuliyujiang.dialog.BottomDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                    return this.f$0.m1057lambda$addMaskView$0$comgithubgzuliyujiangdialogBottomDialog(view2, i, keyEvent);
                }
            });
            this.activity.getWindowManager().addView(this.maskView, layoutParams);
            DialogLog.print("dialog add mask view");
        } catch (Throwable th) {
            DialogLog.print(th);
        }
    }

    /* JADX INFO: renamed from: lambda$addMaskView$0$com-github-gzuliyujiang-dialog-BottomDialog, reason: not valid java name */
    /* synthetic */ boolean m1057lambda$addMaskView$0$comgithubgzuliyujiangdialogBottomDialog(View view, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        removeMaskView();
        super.onDismiss(dialog);
    }

    protected void removeMaskView() {
        if (this.maskView == null) {
            DialogLog.print("mask view is null");
            return;
        }
        try {
            this.activity.getWindowManager().removeViewImmediate(this.maskView);
            DialogLog.print("dialog remove mask view");
        } catch (Throwable th) {
            DialogLog.print(th);
        }
        this.maskView = null;
    }
}
