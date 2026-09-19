package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FBLoginSSONoAppDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/FBLoginSSONoAppDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "continueClicked", "", "onContinueListener", "Lkotlin/Function0;", "", "getOnContinueListener", "()Lkotlin/jvm/functions/Function0;", "setOnContinueListener", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "getOnDismissListener", "setOnDismissListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FBLoginSSONoAppDialog extends DialogFragment {
    private static final String ARG_FB4A_OUTDATED = "fb4a_outdated";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "FBLoginSSONoAppDialog";
    private boolean continueClicked;
    private Function0<Unit> onContinueListener;
    private Function0<Unit> onDismissListener;

    @JvmStatic
    public static final FBLoginSSONoAppDialog newInstance(boolean z) {
        return INSTANCE.newInstance(z);
    }

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    public final Function0<Unit> getOnContinueListener() {
        return this.onContinueListener;
    }

    public final void setOnContinueListener(Function0<Unit> function0) {
        this.onContinueListener = function0;
    }

    /* JADX INFO: compiled from: FBLoginSSONoAppDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/FBLoginSSONoAppDialog$Companion;", "", "()V", "ARG_FB4A_OUTDATED", "", "TAG", "newInstance", "Lcom/facebook/login/FBLoginSSONoAppDialog;", "fb4aOutdated", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FBLoginSSONoAppDialog newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        @JvmStatic
        public final FBLoginSSONoAppDialog newInstance(boolean fb4aOutdated) {
            FBLoginSSONoAppDialog fBLoginSSONoAppDialog = new FBLoginSSONoAppDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FBLoginSSONoAppDialog.ARG_FB4A_OUTDATED, fb4aOutdated);
            fBLoginSSONoAppDialog.setArguments(bundle);
            return fBLoginSSONoAppDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, com.facebook.common.R.style.com_facebook_sso_noapp_dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(com.facebook.common.R.layout.com_facebook_sso_noapp_dialog, container, false);
        Bundle arguments = getArguments();
        if (arguments != null ? arguments.getBoolean(ARG_FB4A_OUTDATED, false) : false) {
            ((TextView) view.findViewById(com.facebook.common.R.id.com_facebook_sso_noapp_title)).setText(com.facebook.common.R.string.com_facebook_sso_outdated_title);
            ((TextView) view.findViewById(com.facebook.common.R.id.com_facebook_sso_noapp_body)).setText(com.facebook.common.R.string.com_facebook_sso_outdated_body);
        }
        view.findViewById(com.facebook.common.R.id.com_facebook_sso_noapp_close).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.FBLoginSSONoAppDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FBLoginSSONoAppDialog.onCreateView$lambda$0(this.f$0, view2);
            }
        });
        view.findViewById(com.facebook.common.R.id.com_facebook_sso_noapp_not_now).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.FBLoginSSONoAppDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FBLoginSSONoAppDialog.onCreateView$lambda$1(this.f$0, view2);
            }
        });
        view.findViewById(com.facebook.common.R.id.com_facebook_sso_noapp_continue).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.FBLoginSSONoAppDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FBLoginSSONoAppDialog.onCreateView$lambda$2(this.f$0, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(FBLoginSSONoAppDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(FBLoginSSONoAppDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(FBLoginSSONoAppDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.continueClicked = true;
        Function0<Unit> function0 = this$0.onContinueListener;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        boolean z = getResources().getConfiguration().orientation == 2;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(android.R.color.transparent);
        if (z) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.6d), -2);
            window.setGravity(17);
        } else {
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.continueClicked || (function0 = this.onDismissListener) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.onContinueListener = null;
        this.onDismissListener = null;
    }
}
