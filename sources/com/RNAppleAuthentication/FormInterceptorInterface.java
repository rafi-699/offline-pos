package com.RNAppleAuthentication;

import android.webkit.JavascriptInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormInterceptorInterface.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/RNAppleAuthentication/FormInterceptorInterface;", "", "expectedState", "", "callback", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "processFormData", "formData", "Companion", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormInterceptorInterface {
    private static final String CODE = "code";
    private static final String FORM_DATA_SEPARATOR = "|";
    private static final String KEY_VALUE_SEPARATOR = "=";
    public static final String NAME = "FormInterceptorInterface";
    private static final String STATE = "state";
    private static final String TOKEN = "id_token";
    private static final String USER = "user";
    private final Function1<SignInWithAppleResult, Unit> callback;
    private final String expectedState;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String JS_TO_INJECT = "function parseForm(form){\n\n    var values = '';\n    for(var i=0 ; i< form.elements.length; i++){\n        values +=\n            form.elements[i].name +\n            '=' +\n            form.elements[i].value +\n            '|'\n    }\n    FormInterceptorInterface.processFormData(values);\n}\n\n\nfor(var i=0 ; i< document.forms.length ; i++){\n    parseForm(document.forms[i]);\n}";

    /* JADX WARN: Multi-variable type inference failed */
    public FormInterceptorInterface(String expectedState, Function1<? super SignInWithAppleResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(expectedState, "expectedState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.expectedState = expectedState;
        this.callback = callback;
    }

    @JavascriptInterface
    public final void processFormData(String formData) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Intrinsics.checkNotNullParameter(formData, "formData");
        List listSplit$default = StringsKt.split$default((CharSequence) formData, new String[]{FORM_DATA_SEPARATOR}, false, 0, 6, (Object) null);
        Iterator it = listSplit$default.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.startsWith$default((String) next, "id_token", false, 2, (Object) null));
        String str = (String) next;
        Iterator it2 = listSplit$default.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!StringsKt.startsWith$default((String) next2, CODE, false, 2, (Object) null));
        String str2 = (String) next2;
        Iterator it3 = listSplit$default.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (!StringsKt.startsWith$default((String) next3, "state", false, 2, (Object) null));
        String str3 = (String) next3;
        Iterator it4 = listSplit$default.iterator();
        do {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
        } while (!StringsKt.startsWith$default((String) next4, USER, false, 2, (Object) null));
        String str4 = (String) next4;
        if (str3 != null && (str2 != null || str != null || str4 != null)) {
            String strSubstringAfter$default = StringsKt.substringAfter$default(str3, KEY_VALUE_SEPARATOR, (String) null, 2, (Object) null);
            String strSubstringAfter$default2 = str2 != null ? StringsKt.substringAfter$default(str2, KEY_VALUE_SEPARATOR, (String) null, 2, (Object) null) : null;
            String strSubstringAfter$default3 = str != null ? StringsKt.substringAfter$default(str, KEY_VALUE_SEPARATOR, (String) null, 2, (Object) null) : null;
            String strSubstringAfter$default4 = str4 != null ? StringsKt.substringAfter$default(str4, KEY_VALUE_SEPARATOR, (String) null, 2, (Object) null) : null;
            if (Intrinsics.areEqual(strSubstringAfter$default, this.expectedState)) {
                Function1<SignInWithAppleResult, Unit> function1 = this.callback;
                if (strSubstringAfter$default2 == null) {
                    strSubstringAfter$default2 = "";
                }
                if (strSubstringAfter$default3 == null) {
                    strSubstringAfter$default3 = "";
                }
                if (strSubstringAfter$default4 == null) {
                    strSubstringAfter$default4 = "";
                }
                function1.invoke(new SignInWithAppleResult.Success(strSubstringAfter$default2, strSubstringAfter$default3, strSubstringAfter$default, strSubstringAfter$default4));
                return;
            }
            this.callback.invoke(new SignInWithAppleResult.Failure(new IllegalArgumentException("state does not match")));
            return;
        }
        this.callback.invoke(SignInWithAppleResult.Cancel.INSTANCE);
    }

    /* JADX INFO: compiled from: FormInterceptorInterface.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/RNAppleAuthentication/FormInterceptorInterface$Companion;", "", "<init>", "()V", "NAME", "", "STATE", "CODE", "TOKEN", "USER", "FORM_DATA_SEPARATOR", "KEY_VALUE_SEPARATOR", "JS_TO_INJECT", "getJS_TO_INJECT", "()Ljava/lang/String;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJS_TO_INJECT() {
            return FormInterceptorInterface.JS_TO_INJECT;
        }
    }
}
