package com.ask.printersdk.base.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import com.ask.printersdk.R;
import com.ask.printersdk.base.BaseExtendsKt;
import com.ask.printersdk.databinding.DialogCommPopBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommPopDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00105\u001a\u00020$H\u0014J\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u00107\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u00107\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u001bJ\u0016\u00108\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00109\u001a\u00020$J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0012J\u001a\u0010:\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00122\n\b\u0002\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0012J\u0016\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>J\b\u0010@\u001a\u00020\tH\u0014J)\u0010A\u001a\u00020\u00002!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005J)\u0010B\u001a\u00020\u00002!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006C"}, d2 = {"Lcom/ask/printersdk/base/dialog/CommPopDialog;", "Lcom/ask/printersdk/base/dialog/CenterDialogFragment;", "<init>", "()V", "okCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dialog", "", "getOkCallback", "()Lkotlin/jvm/functions/Function1;", "setOkCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancelCallback", "getCancelCallback", "setCancelCallback", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "descSpannable", "Landroid/text/Spannable;", "getDescSpannable", "()Landroid/text/Spannable;", "setDescSpannable", "(Landroid/text/Spannable;)V", "subDesc", "getSubDesc", "setSubDesc", "subDescColor", "", "getSubDescColor", "()I", "setSubDescColor", "(I)V", "ok", "getOk", "setOk", "cancelTxt", "getCancelTxt", "setCancelTxt", "okBtnDrawable", "Landroid/graphics/drawable/Drawable;", "getOkBtnDrawable", "()Landroid/graphics/drawable/Drawable;", "setOkBtnDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setLayoutId", "setTitleTxt", "setDescTxt", "setSubDescTxt", "colorId", "setOkTxt", "cancel", "setCancelEnable", "backKeyDismiss", "", "outsideTouchDismiss", "initData", "setOnOkCallback", "setOnCancelCallback", "printersdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommPopDialog extends CenterDialogFragment {
    private Function1<? super CommPopDialog, Unit> cancelCallback;
    private Spannable descSpannable;
    private Drawable okBtnDrawable;
    private Function1<? super CommPopDialog, Unit> okCallback;
    private String title = "";
    private String desc = "";
    private String subDesc = "";
    private int subDescColor = R.color.color_333;
    private String ok = "";
    private String cancelTxt = "";

    public final Function1<CommPopDialog, Unit> getOkCallback() {
        return this.okCallback;
    }

    public final void setOkCallback(Function1<? super CommPopDialog, Unit> function1) {
        this.okCallback = function1;
    }

    public final Function1<CommPopDialog, Unit> getCancelCallback() {
        return this.cancelCallback;
    }

    public final void setCancelCallback(Function1<? super CommPopDialog, Unit> function1) {
        this.cancelCallback = function1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final Spannable getDescSpannable() {
        return this.descSpannable;
    }

    public final void setDescSpannable(Spannable spannable) {
        this.descSpannable = spannable;
    }

    public final String getSubDesc() {
        return this.subDesc;
    }

    public final void setSubDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subDesc = str;
    }

    public final int getSubDescColor() {
        return this.subDescColor;
    }

    public final void setSubDescColor(int i) {
        this.subDescColor = i;
    }

    public final String getOk() {
        return this.ok;
    }

    public final void setOk(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ok = str;
    }

    public final String getCancelTxt() {
        return this.cancelTxt;
    }

    /* JADX INFO: renamed from: setCancelTxt, reason: collision with other method in class */
    public final void m555setCancelTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cancelTxt = str;
    }

    public final Drawable getOkBtnDrawable() {
        return this.okBtnDrawable;
    }

    public final void setOkBtnDrawable(Drawable drawable) {
        this.okBtnDrawable = drawable;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected int setLayoutId() {
        return R.layout.dialog_comm_pop;
    }

    public final CommPopDialog setTitleTxt(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }

    public final CommPopDialog setDescTxt(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.desc = desc;
        return this;
    }

    public final CommPopDialog setDescTxt(Spannable desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.descSpannable = desc;
        return this;
    }

    public final CommPopDialog setSubDescTxt(String desc, int colorId) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.subDesc = desc;
        this.subDescColor = colorId;
        return this;
    }

    public final CommPopDialog setSubDescTxt(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.subDesc = desc;
        return this;
    }

    public static /* synthetic */ CommPopDialog setOkTxt$default(CommPopDialog commPopDialog, String str, Drawable drawable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOkTxt");
        }
        if ((i & 2) != 0) {
            drawable = null;
        }
        return commPopDialog.setOkTxt(str, drawable);
    }

    public final CommPopDialog setOkTxt(String ok, Drawable okBtnDrawable) {
        Intrinsics.checkNotNullParameter(ok, "ok");
        this.ok = ok;
        this.okBtnDrawable = okBtnDrawable;
        return this;
    }

    public final CommPopDialog setCancelTxt(String cancel) {
        Intrinsics.checkNotNullParameter(cancel, "cancel");
        this.cancelTxt = cancel;
        return this;
    }

    public final CommPopDialog setCancelEnable(boolean backKeyDismiss, boolean outsideTouchDismiss) {
        setCancelable(backKeyDismiss);
        setCanceledOnTouchOutside(outsideTouchDismiss);
        return this;
    }

    @Override // com.ask.printersdk.base.dialog.BaseDialogFragment
    protected void initData() {
        DialogCommPopBinding dialogCommPopBinding = (DialogCommPopBinding) DataBindingUtil.bind(this.rootView);
        if (dialogCommPopBinding == null) {
            return;
        }
        if (StringsKt.isBlank(this.title)) {
            dialogCommPopBinding.textTitle.setVisibility(8);
        } else {
            dialogCommPopBinding.textTitle.setText(this.title);
            dialogCommPopBinding.textTitle.setVisibility(0);
        }
        TextView textDesc = dialogCommPopBinding.textDesc;
        Intrinsics.checkNotNullExpressionValue(textDesc, "textDesc");
        if (this.descSpannable == null && StringsKt.isBlank(this.desc)) {
            textDesc.setVisibility(8);
        } else {
            Spannable spannable = this.descSpannable;
            if (spannable != null) {
                textDesc.setText(spannable);
            } else {
                textDesc.setText(this.desc);
            }
            textDesc.setVisibility(0);
        }
        TextView textDesc2 = dialogCommPopBinding.textDesc2;
        Intrinsics.checkNotNullExpressionValue(textDesc2, "textDesc2");
        if (StringsKt.isBlank(this.subDesc)) {
            textDesc2.setVisibility(8);
        } else {
            textDesc2.setText(this.subDesc);
            textDesc2.setVisibility(0);
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            textDesc2.setTextColor(ContextCompat.getColor(context, this.subDescColor));
        }
        Button btnOk = dialogCommPopBinding.btnOk;
        Intrinsics.checkNotNullExpressionValue(btnOk, "btnOk");
        if (!StringsKt.isBlank(this.ok)) {
            btnOk.setText(this.ok);
        }
        Button btnCancel = dialogCommPopBinding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
        if (!StringsKt.isBlank(this.cancelTxt)) {
            btnCancel.setText(this.cancelTxt);
        }
        BaseExtendsKt.click(btnCancel, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.base.dialog.CommPopDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CommPopDialog.initData$lambda$0(this.f$0, (View) obj);
            }
        });
        Drawable drawable = this.okBtnDrawable;
        if (drawable != null) {
            btnOk.setBackground(drawable);
        }
        BaseExtendsKt.click(btnOk, (Function1<? super View, Unit>) new Function1() { // from class: com.ask.printersdk.base.dialog.CommPopDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CommPopDialog.initData$lambda$2(this.f$0, (View) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$0(CommPopDialog commPopDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Function1<? super CommPopDialog, Unit> function1 = commPopDialog.cancelCallback;
        if (function1 == null) {
            commPopDialog.dismissAllowingStateLoss();
        } else if (function1 != null) {
            function1.invoke(commPopDialog);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(CommPopDialog commPopDialog, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Function1<? super CommPopDialog, Unit> function1 = commPopDialog.okCallback;
        if (function1 == null) {
            commPopDialog.dismissAllowingStateLoss();
        } else if (function1 != null) {
            function1.invoke(commPopDialog);
        }
        return Unit.INSTANCE;
    }

    public final CommPopDialog setOnOkCallback(Function1<? super CommPopDialog, Unit> okCallback) {
        Intrinsics.checkNotNullParameter(okCallback, "okCallback");
        this.okCallback = okCallback;
        return this;
    }

    public final CommPopDialog setOnCancelCallback(Function1<? super CommPopDialog, Unit> cancelCallback) {
        Intrinsics.checkNotNullParameter(cancelCallback, "cancelCallback");
        this.cancelCallback = cancelCallback;
        return this;
    }
}
