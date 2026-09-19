package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener, LifecycleEventObserver {
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    protected Activity activity;
    protected View contentView;

    protected abstract View createContentView();

    public BaseDialog(Activity activity) {
        this(activity, R.style.DialogTheme_Base);
    }

    public BaseDialog(Activity activity, int themeResId) {
        super(activity, themeResId);
        init(activity);
    }

    public final View getContentView() {
        return this.contentView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Activity activity) {
        if (activity instanceof LifecycleOwner) {
            ((LifecycleOwner) activity).getLifecycle().addObserver(this);
        }
        this.activity = activity;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        super.setOnShowListener(this);
        super.setOnDismissListener(this);
        Window window = super.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(activity.getResources().getDisplayMetrics().widthPixels, -2);
            window.setGravity(17);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        onInit(null);
        super.create();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            DialogLog.print("dismiss dialog when " + source.getClass().getName() + " on destroy");
            dismiss();
            source.getLifecycle().removeObserver(this);
        }
    }

    @Deprecated
    protected void onInit(Activity activity, Bundle savedInstanceState) {
        DialogLog.print("dialog onInit");
    }

    protected void onInit(Bundle savedInstanceState) {
        onInit(this.activity, savedInstanceState);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogLog.print("dialog onCreate");
        if (this.contentView == null) {
            readyView();
        }
    }

    private void readyView() {
        View viewCreateContentView = createContentView();
        this.contentView = viewCreateContentView;
        viewCreateContentView.setFocusable(true);
        this.contentView.setFocusableInTouchMode(true);
        setContentView(this.contentView);
        initView();
    }

    @Deprecated
    protected void initView(View contentView) {
        DialogLog.print("dialog initView");
    }

    protected void initView() {
        initView(this.contentView);
    }

    public final void disableCancel() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public final void setBackgroundColor(int color) {
        setBackgroundColor(0, color);
    }

    public final void setBackgroundColor(int cornerRound, int color) {
        setBackgroundColor(cornerRound, 20, color);
    }

    public final void setBackgroundColor(int i, int i2, int i3) {
        Drawable colorDrawable;
        View view = this.contentView;
        if (view == null) {
            return;
        }
        float f = view.getResources().getDisplayMetrics().density * i2;
        this.contentView.setLayerType(1, null);
        if (i == 1) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
            shapeDrawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            colorDrawable = shapeDrawable;
        } else if (i == 2) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(f);
            gradientDrawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            colorDrawable = gradientDrawable;
        } else {
            colorDrawable = new ColorDrawable(i3);
        }
        this.contentView.setBackground(colorDrawable);
    }

    public final void setBackgroundResource(int resId) {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(resId);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public final void setLayout(int width, int height) {
        getWindow().setLayout(width, height);
    }

    public final void setWidth(int width) {
        getWindow().setLayout(width, getWindow().getAttributes().height);
    }

    public final void setHeight(int height) {
        getWindow().setLayout(getWindow().getAttributes().width, height);
    }

    public final void setGravity(int gravity) {
        getWindow().setGravity(gravity);
    }

    public final void setDimAmount(float amount) {
        getWindow().setDimAmount(amount);
    }

    public final void setAnimationStyle(int animRes) {
        getWindow().setWindowAnimations(animRes);
    }

    @Override // android.app.Dialog
    public void setOnShowListener(final DialogInterface.OnShowListener listener) {
        if (listener == null) {
            return;
        }
        super.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.github.gzuliyujiang.dialog.BaseDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseDialog.lambda$setOnShowListener$0(this, listener, dialogInterface);
            }
        });
    }

    static /* synthetic */ void lambda$setOnShowListener$0(DialogInterface.OnShowListener onShowListener, DialogInterface.OnShowListener onShowListener2, DialogInterface dialogInterface) {
        onShowListener.onShow(dialogInterface);
        onShowListener2.onShow(dialogInterface);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(final DialogInterface.OnDismissListener listener) {
        if (listener == null) {
            return;
        }
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.github.gzuliyujiang.dialog.BaseDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BaseDialog.lambda$setOnDismissListener$1(this, listener, dialogInterface);
            }
        });
    }

    static /* synthetic */ void lambda$setOnDismissListener$1(DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnDismissListener onDismissListener2, DialogInterface dialogInterface) {
        onDismissListener.onDismiss(dialogInterface);
        onDismissListener2.onDismiss(dialogInterface);
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        showSafe();
    }

    protected void showSafe() {
        try {
            super.show();
            DialogLog.print("dialog show");
        } catch (Throwable th) {
            DialogLog.print(th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            dismissSafe();
        }
    }

    protected void dismissSafe() {
        try {
            super.dismiss();
            DialogLog.print("dialog dismiss");
        } catch (Throwable th) {
            DialogLog.print(th);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        DialogLog.print("dialog attached to window");
        super.onAttachedToWindow();
        initData();
    }

    protected void initData() {
        DialogLog.print("dialog initData");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogLog.print("dialog detached from window");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        DialogLog.print("dialog onShow");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        DialogLog.print("dialog onDismiss");
    }
}
