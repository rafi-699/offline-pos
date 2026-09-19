package androidx.credentials.provider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.credentials.CredentialOption;
import android.os.Build;
import android.os.Bundle;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.GetCredentialRequest;
import android.util.Log;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.Credential;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.internal.ConversionUtilsKt;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PendingIntentHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler;", "", "<init>", "()V", "Companion", "Api23Impl", "Api34Impl", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PendingIntentHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PendingIntentHandler";

    @JvmStatic
    public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
        return INSTANCE.retrieveBeginGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final CreateCredentialException retrieveCreateCredentialException(Intent intent) {
        return INSTANCE.retrieveCreateCredentialException(intent);
    }

    @JvmStatic
    public static final CreateCredentialResponse retrieveCreateCredentialResponse(String str, Intent intent) {
        return INSTANCE.retrieveCreateCredentialResponse(str, intent);
    }

    @JvmStatic
    public static final GetCredentialException retrieveGetCredentialException(Intent intent) {
        return INSTANCE.retrieveGetCredentialException(intent);
    }

    @JvmStatic
    public static final GetCredentialResponse retrieveGetCredentialResponse(Intent intent) {
        return INSTANCE.retrieveGetCredentialResponse(intent);
    }

    @JvmStatic
    public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
        return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
    }

    @JvmStatic
    public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
        return INSTANCE.retrieveProviderGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
        INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
    }

    @JvmStatic
    public static final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
        INSTANCE.setCreateCredentialException(intent, createCredentialException);
    }

    @JvmStatic
    public static final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
        INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
    }

    @JvmStatic
    public static final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
        INSTANCE.setGetCredentialException(intent, getCredentialException);
    }

    @JvmStatic
    public static final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
        INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
    }

    /* JADX INFO: compiled from: PendingIntentHandler.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001eH\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Companion;", "", "<init>", "()V", "TAG", "", "retrieveProviderCreateCredentialRequest", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "retrieveBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "setCreateCredentialResponse", "", "response", "Landroidx/credentials/CreateCredentialResponse;", "retrieveCreateCredentialResponse", "type", "retrieveProviderGetCredentialRequest", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "setGetCredentialResponse", "Landroidx/credentials/GetCredentialResponse;", "retrieveGetCredentialResponse", "setBeginGetCredentialResponse", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "setGetCredentialException", "exception", "Landroidx/credentials/exceptions/GetCredentialException;", "retrieveGetCredentialException", "setCreateCredentialException", "Landroidx/credentials/exceptions/CreateCredentialException;", "retrieveCreateCredentialException", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.retrieveProviderCreateCredentialRequest(intent);
            }
            return Api23Impl.INSTANCE.retrieveProviderCreateCredentialRequest(intent);
        }

        @JvmStatic
        public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.retrieveBeginGetCredentialRequest(intent);
            }
            return Api23Impl.INSTANCE.retrieveBeginGetCredentialRequest(intent);
        }

        @JvmStatic
        public final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.INSTANCE.setCreateCredentialResponse(intent, response);
            } else {
                Api23Impl.INSTANCE.setCreateCredentialResponse(intent, response);
            }
        }

        @JvmStatic
        public final CreateCredentialResponse retrieveCreateCredentialResponse(String type, Intent intent) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.extractCreateCredentialResponse(type, intent);
            }
            return Api23Impl.INSTANCE.extractCreateCredentialResponse(intent);
        }

        @JvmStatic
        public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.retrieveProviderGetCredentialRequest(intent);
            }
            return Api23Impl.INSTANCE.retrieveProviderGetCredentialRequest(intent);
        }

        @JvmStatic
        public final void setGetCredentialResponse(Intent intent, GetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.INSTANCE.setGetCredentialResponse(intent, response);
            } else {
                Api23Impl.INSTANCE.setGetCredentialResponse(intent, response);
            }
        }

        @JvmStatic
        public final GetCredentialResponse retrieveGetCredentialResponse(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.extractGetCredentialResponse(intent);
            }
            return Api23Impl.INSTANCE.extractGetCredentialResponse(intent);
        }

        @JvmStatic
        public final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.INSTANCE.setBeginGetCredentialResponse(intent, response);
            } else {
                Api23Impl.INSTANCE.setBeginGetCredentialResponse(intent, response);
            }
        }

        @JvmStatic
        public final void setGetCredentialException(Intent intent, GetCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.INSTANCE.setGetCredentialException(intent, exception);
            } else {
                Api23Impl.INSTANCE.setGetCredentialException(intent, exception);
            }
        }

        @JvmStatic
        public final GetCredentialException retrieveGetCredentialException(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.extractGetCredentialException(intent);
            }
            return Api23Impl.INSTANCE.extractGetCredentialException(intent);
        }

        @JvmStatic
        public final void setCreateCredentialException(Intent intent, CreateCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.INSTANCE.setCreateCredentialException(intent, exception);
            } else {
                Api23Impl.INSTANCE.setCreateCredentialException(intent, exception);
            }
        }

        @JvmStatic
        public final CreateCredentialException retrieveCreateCredentialException(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.INSTANCE.extractCreateCredentialException(intent);
            }
            return Api23Impl.INSTANCE.extractCreateCredentialException(intent);
        }
    }

    /* JADX INFO: compiled from: PendingIntentHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Api23Impl;", "", "<init>", "()V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Api23Impl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String EXTRA_BEGIN_GET_CREDENTIAL_REQUEST = "android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST";
        private static final String EXTRA_BEGIN_GET_CREDENTIAL_RESPONSE = "android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE";
        private static final String EXTRA_CREATE_CREDENTIAL_EXCEPTION = "android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION";
        private static final String EXTRA_CREATE_CREDENTIAL_REQUEST = "android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST";
        private static final String EXTRA_CREATE_CREDENTIAL_RESPONSE = "android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE";
        private static final String EXTRA_GET_CREDENTIAL_EXCEPTION = "android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION";
        private static final String EXTRA_GET_CREDENTIAL_REQUEST = "android.service.credentials.extra.GET_CREDENTIAL_REQUEST";
        private static final String EXTRA_GET_CREDENTIAL_RESPONSE = "android.service.credentials.extra.GET_CREDENTIAL_RESPONSE";

        @JvmStatic
        public static final BeginGetCredentialResponse extractBeginGetCredentialResponse(Intent intent) {
            return INSTANCE.extractBeginGetCredentialResponse(intent);
        }

        @JvmStatic
        public static final CreateCredentialException extractCreateCredentialException(Intent intent) {
            return INSTANCE.extractCreateCredentialException(intent);
        }

        @JvmStatic
        public static final CreateCredentialResponse extractCreateCredentialResponse(Intent intent) {
            return INSTANCE.extractCreateCredentialResponse(intent);
        }

        @JvmStatic
        public static final GetCredentialException extractGetCredentialException(Intent intent) {
            return INSTANCE.extractGetCredentialException(intent);
        }

        @JvmStatic
        public static final GetCredentialResponse extractGetCredentialResponse(Intent intent) {
            return INSTANCE.extractGetCredentialResponse(intent);
        }

        @JvmStatic
        public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
            return INSTANCE.retrieveBeginGetCredentialRequest(intent);
        }

        @JvmStatic
        public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
            return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
        }

        @JvmStatic
        public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
            return INSTANCE.retrieveProviderGetCredentialRequest(intent);
        }

        @JvmStatic
        public static final void setBeginGetCredentialRequest(Intent intent, BeginGetCredentialRequest beginGetCredentialRequest) {
            INSTANCE.setBeginGetCredentialRequest(intent, beginGetCredentialRequest);
        }

        @JvmStatic
        public static final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
            INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
        }

        @JvmStatic
        public static final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
            INSTANCE.setCreateCredentialException(intent, createCredentialException);
        }

        @JvmStatic
        public static final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
            INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
        }

        @JvmStatic
        public static final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
            INSTANCE.setGetCredentialException(intent, getCredentialException);
        }

        @JvmStatic
        public static final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
            INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
        }

        @JvmStatic
        public static final void setProviderCreateCredentialRequest(Intent intent, ProviderCreateCredentialRequest providerCreateCredentialRequest) {
            INSTANCE.setProviderCreateCredentialRequest(intent, providerCreateCredentialRequest);
        }

        @JvmStatic
        public static final void setProviderGetCredentialRequest(Intent intent, ProviderGetCredentialRequest providerGetCredentialRequest) {
            INSTANCE.setProviderGetCredentialRequest(intent, providerGetCredentialRequest);
        }

        /* JADX INFO: compiled from: PendingIntentHandler.kt */
        @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0018H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001cH\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020 H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020$H\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020)H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Api23Impl$Companion;", "", "<init>", "()V", "EXTRA_CREATE_CREDENTIAL_REQUEST", "", "setProviderCreateCredentialRequest", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "request", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "retrieveProviderCreateCredentialRequest", "EXTRA_BEGIN_GET_CREDENTIAL_REQUEST", "setBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "retrieveBeginGetCredentialRequest", "EXTRA_CREATE_CREDENTIAL_RESPONSE", "extractCreateCredentialResponse", "Landroidx/credentials/CreateCredentialResponse;", "setCreateCredentialResponse", "response", "EXTRA_GET_CREDENTIAL_REQUEST", "setProviderGetCredentialRequest", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "retrieveProviderGetCredentialRequest", "EXTRA_GET_CREDENTIAL_RESPONSE", "extractGetCredentialResponse", "Landroidx/credentials/GetCredentialResponse;", "setGetCredentialResponse", "EXTRA_BEGIN_GET_CREDENTIAL_RESPONSE", "extractBeginGetCredentialResponse", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "setBeginGetCredentialResponse", "EXTRA_GET_CREDENTIAL_EXCEPTION", "extractGetCredentialException", "Landroidx/credentials/exceptions/GetCredentialException;", "setGetCredentialException", "exception", "EXTRA_CREATE_CREDENTIAL_EXCEPTION", "extractCreateCredentialException", "Landroidx/credentials/exceptions/CreateCredentialException;", "setCreateCredentialException", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final void setProviderCreateCredentialRequest(Intent intent, ProviderCreateCredentialRequest request) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(request, "request");
                intent.putExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_REQUEST, ProviderCreateCredentialRequest.INSTANCE.asBundle(request));
            }

            @JvmStatic
            public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                try {
                    ProviderCreateCredentialRequest.Companion companion = ProviderCreateCredentialRequest.INSTANCE;
                    Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_REQUEST);
                    if (bundleExtra == null) {
                        return null;
                    }
                    return companion.fromBundle(bundleExtra);
                } catch (Exception unused) {
                    return null;
                }
            }

            @JvmStatic
            public final void setBeginGetCredentialRequest(Intent intent, BeginGetCredentialRequest request) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(request, "request");
                intent.putExtra(Api23Impl.EXTRA_BEGIN_GET_CREDENTIAL_REQUEST, BeginGetCredentialRequest.INSTANCE.asBundle(request));
            }

            @JvmStatic
            public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                BeginGetCredentialRequest.Companion companion = BeginGetCredentialRequest.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_BEGIN_GET_CREDENTIAL_REQUEST);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final CreateCredentialResponse extractCreateCredentialResponse(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                CreateCredentialResponse.Companion companion = CreateCredentialResponse.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_RESPONSE);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_RESPONSE, CreateCredentialResponse.INSTANCE.asBundle(response));
            }

            @JvmStatic
            public final void setProviderGetCredentialRequest(Intent intent, ProviderGetCredentialRequest request) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(request, "request");
                intent.putExtra(Api23Impl.EXTRA_GET_CREDENTIAL_REQUEST, ProviderGetCredentialRequest.INSTANCE.asBundle(request));
            }

            @JvmStatic
            public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                try {
                    ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.INSTANCE;
                    Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_GET_CREDENTIAL_REQUEST);
                    if (bundleExtra == null) {
                        return null;
                    }
                    return companion.fromBundle(bundleExtra);
                } catch (Exception unused) {
                    return null;
                }
            }

            @JvmStatic
            public final GetCredentialResponse extractGetCredentialResponse(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                GetCredentialResponse.Companion companion = GetCredentialResponse.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_GET_CREDENTIAL_RESPONSE);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final void setGetCredentialResponse(Intent intent, GetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra(Api23Impl.EXTRA_GET_CREDENTIAL_RESPONSE, GetCredentialResponse.INSTANCE.asBundle(response));
            }

            @JvmStatic
            public final BeginGetCredentialResponse extractBeginGetCredentialResponse(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                BeginGetCredentialResponse.Companion companion = BeginGetCredentialResponse.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_BEGIN_GET_CREDENTIAL_RESPONSE);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra(Api23Impl.EXTRA_BEGIN_GET_CREDENTIAL_RESPONSE, BeginGetCredentialResponse.INSTANCE.asBundle(response));
            }

            @JvmStatic
            public final GetCredentialException extractGetCredentialException(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                GetCredentialException.Companion companion = GetCredentialException.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_GET_CREDENTIAL_EXCEPTION);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final void setGetCredentialException(Intent intent, GetCredentialException exception) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(exception, "exception");
                intent.putExtra(Api23Impl.EXTRA_GET_CREDENTIAL_EXCEPTION, GetCredentialException.INSTANCE.asBundle(exception));
            }

            @JvmStatic
            public final CreateCredentialException extractCreateCredentialException(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                CreateCredentialException.Companion companion = CreateCredentialException.INSTANCE;
                Bundle bundleExtra = intent.getBundleExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_EXCEPTION);
                if (bundleExtra == null) {
                    return null;
                }
                return companion.fromBundle(bundleExtra);
            }

            @JvmStatic
            public final void setCreateCredentialException(Intent intent, CreateCredentialException exception) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(exception, "exception");
                intent.putExtra(Api23Impl.EXTRA_CREATE_CREDENTIAL_EXCEPTION, CreateCredentialException.INSTANCE.asBundle(exception));
            }
        }
    }

    /* JADX INFO: compiled from: PendingIntentHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Api34Impl;", "", "<init>", "()V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Api34Impl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final CreateCredentialException extractCreateCredentialException(Intent intent) {
            return INSTANCE.extractCreateCredentialException(intent);
        }

        @JvmStatic
        public static final CreateCredentialResponse extractCreateCredentialResponse(String str, Intent intent) {
            return INSTANCE.extractCreateCredentialResponse(str, intent);
        }

        @JvmStatic
        public static final GetCredentialException extractGetCredentialException(Intent intent) {
            return INSTANCE.extractGetCredentialException(intent);
        }

        @JvmStatic
        public static final GetCredentialResponse extractGetCredentialResponse(Intent intent) {
            return INSTANCE.extractGetCredentialResponse(intent);
        }

        @JvmStatic
        public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
            return INSTANCE.retrieveBeginGetCredentialRequest(intent);
        }

        @JvmStatic
        public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
            return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
        }

        @JvmStatic
        public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
            return INSTANCE.retrieveProviderGetCredentialRequest(intent);
        }

        @JvmStatic
        public static final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse beginGetCredentialResponse) {
            INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
        }

        @JvmStatic
        public static final void setCreateCredentialException(Intent intent, CreateCredentialException createCredentialException) {
            INSTANCE.setCreateCredentialException(intent, createCredentialException);
        }

        @JvmStatic
        public static final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse createCredentialResponse) {
            INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
        }

        @JvmStatic
        public static final void setGetCredentialException(Intent intent, GetCredentialException getCredentialException) {
            INSTANCE.setGetCredentialException(intent, getCredentialException);
        }

        @JvmStatic
        public static final void setGetCredentialResponse(Intent intent, GetCredentialResponse getCredentialResponse) {
            INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
        }

        /* JADX INFO: compiled from: PendingIntentHandler.kt */
        @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J6\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u001aH\u0007J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u001dH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020!H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001fH\u0007¨\u0006%"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Api34Impl$Companion;", "", "<init>", "()V", "retrieveProviderCreateCredentialRequest", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "retrieveBiometricPromptResult", "Landroidx/credentials/provider/BiometricPromptResult;", "resultKey", "", "errorKey", "errorMessageKey", "retrieveBiometricPromptResultFallback", "retrieveBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "setCreateCredentialResponse", "", "response", "Landroidx/credentials/CreateCredentialResponse;", "retrieveProviderGetCredentialRequest", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "extractCreateCredentialResponse", "type", "extractGetCredentialResponse", "Landroidx/credentials/GetCredentialResponse;", "setGetCredentialResponse", "setBeginGetCredentialResponse", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "extractCreateCredentialException", "Landroidx/credentials/exceptions/CreateCredentialException;", "extractGetCredentialException", "Landroidx/credentials/exceptions/GetCredentialException;", "setGetCredentialException", "exception", "setCreateCredentialException", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @JvmStatic
            public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                CreateCredentialRequest createCredentialRequest = (CreateCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", CreateCredentialRequest.class);
                if (createCredentialRequest == 0) {
                    Log.i(PendingIntentHandler.TAG, "Request not found in pendingIntent");
                    return (ProviderCreateCredentialRequest) createCredentialRequest;
                }
                BiometricPromptResult biometricPromptResultRetrieveBiometricPromptResult$default = retrieveBiometricPromptResult$default(this, intent, null, null, null, 14, null);
                if (biometricPromptResultRetrieveBiometricPromptResult$default == null) {
                    biometricPromptResultRetrieveBiometricPromptResult$default = retrieveBiometricPromptResultFallback(intent);
                }
                try {
                    androidx.credentials.CreateCredentialRequest.Companion companion = androidx.credentials.CreateCredentialRequest.INSTANCE;
                    String type = createCredentialRequest.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    Bundle data = createCredentialRequest.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                    Bundle data2 = createCredentialRequest.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                    androidx.credentials.CreateCredentialRequest createCredentialRequestCreateFrom = companion.createFrom(type, data, data2, false, createCredentialRequest.getCallingAppInfo().getOrigin());
                    CallingAppInfo.Companion companion2 = CallingAppInfo.INSTANCE;
                    String packageName = createCredentialRequest.getCallingAppInfo().getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                    SigningInfo signingInfo = createCredentialRequest.getCallingAppInfo().getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo, "getSigningInfo(...)");
                    return new ProviderCreateCredentialRequest(createCredentialRequestCreateFrom, companion2.create(packageName, signingInfo, createCredentialRequest.getCallingAppInfo().getOrigin()), biometricPromptResultRetrieveBiometricPromptResult$default, intent.getExtras());
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }

            static /* synthetic */ BiometricPromptResult retrieveBiometricPromptResult$default(Companion companion, Intent intent, String str, String str2, String str3, int i, Object obj) {
                if ((i & 2) != 0) {
                    str = AuthenticationResult.EXTRA_BIOMETRIC_AUTH_RESULT_TYPE;
                }
                if ((i & 4) != 0) {
                    str2 = AuthenticationError.EXTRA_BIOMETRIC_AUTH_ERROR;
                }
                if ((i & 8) != 0) {
                    str3 = AuthenticationError.EXTRA_BIOMETRIC_AUTH_ERROR_MESSAGE;
                }
                return companion.retrieveBiometricPromptResult(intent, str, str2, str3);
            }

            private final BiometricPromptResult retrieveBiometricPromptResult(Intent intent, String resultKey, String errorKey, String errorMessageKey) {
                if (intent.getExtras() == null) {
                    return null;
                }
                Bundle extras = intent.getExtras();
                Intrinsics.checkNotNull(extras);
                if (extras.containsKey(resultKey)) {
                    Bundle extras2 = intent.getExtras();
                    Intrinsics.checkNotNull(extras2);
                    return new BiometricPromptResult(new AuthenticationResult(extras2.getInt(resultKey)));
                }
                Bundle extras3 = intent.getExtras();
                Intrinsics.checkNotNull(extras3);
                if (!extras3.containsKey(errorKey)) {
                    return null;
                }
                Bundle extras4 = intent.getExtras();
                Intrinsics.checkNotNull(extras4);
                int i = extras4.getInt(errorKey);
                Bundle extras5 = intent.getExtras();
                return new BiometricPromptResult(new AuthenticationError(i, extras5 != null ? extras5.getCharSequence(errorMessageKey) : null));
            }

            private final BiometricPromptResult retrieveBiometricPromptResultFallback(Intent intent) {
                if (intent.getExtras() == null) {
                    return null;
                }
                Bundle extras = intent.getExtras();
                Intrinsics.checkNotNull(extras);
                if (!extras.containsKey(AuthenticationResult.EXTRA_BIOMETRIC_AUTH_RESULT_TYPE_FALLBACK)) {
                    Bundle extras2 = intent.getExtras();
                    Intrinsics.checkNotNull(extras2);
                    if (!extras2.containsKey(AuthenticationError.EXTRA_BIOMETRIC_AUTH_ERROR_FALLBACK)) {
                        return null;
                    }
                }
                return retrieveBiometricPromptResult(intent, AuthenticationResult.EXTRA_BIOMETRIC_AUTH_RESULT_TYPE_FALLBACK, AuthenticationError.EXTRA_BIOMETRIC_AUTH_ERROR_FALLBACK, AuthenticationError.EXTRA_BIOMETRIC_AUTH_ERROR_MESSAGE_FALLBACK);
            }

            @JvmStatic
            public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.service.credentials.BeginGetCredentialRequest beginGetCredentialRequest = (android.service.credentials.BeginGetCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", android.service.credentials.BeginGetCredentialRequest.class);
                if (beginGetCredentialRequest != null) {
                    return BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials(beginGetCredentialRequest);
                }
                return null;
            }

            @JvmStatic
            public final void setCreateCredentialResponse(Intent intent, CreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", new android.credentials.CreateCredentialResponse(response.getData()));
            }

            @JvmStatic
            public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                GetCredentialRequest getCredentialRequest = (GetCredentialRequest) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", GetCredentialRequest.class);
                if (getCredentialRequest == null) {
                    Log.i(PendingIntentHandler.TAG, "Get request from framework is null");
                    return null;
                }
                BiometricPromptResult biometricPromptResultRetrieveBiometricPromptResult$default = retrieveBiometricPromptResult$default(this, intent, null, null, null, 14, null);
                if (biometricPromptResultRetrieveBiometricPromptResult$default == null) {
                    biometricPromptResultRetrieveBiometricPromptResult$default = retrieveBiometricPromptResultFallback(intent);
                }
                ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.INSTANCE;
                Stream<CredentialOption> stream = getCredentialRequest.getCredentialOptions().stream();
                final Function1 function1 = new Function1() { // from class: androidx.credentials.provider.PendingIntentHandler$Api34Impl$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PendingIntentHandler.Api34Impl.Companion.retrieveProviderGetCredentialRequest$lambda$0((CredentialOption) obj);
                    }
                };
                Object objCollect = stream.map(new Function() { // from class: androidx.credentials.provider.PendingIntentHandler$Api34Impl$Companion$$ExternalSyntheticLambda1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return PendingIntentHandler.Api34Impl.Companion.retrieveProviderGetCredentialRequest$lambda$1(function1, obj);
                    }
                }).collect(Collectors.toList());
                Intrinsics.checkNotNullExpressionValue(objCollect, "collect(...)");
                CallingAppInfo.Companion companion2 = CallingAppInfo.INSTANCE;
                String packageName = getCredentialRequest.getCallingAppInfo().getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                SigningInfo signingInfo = getCredentialRequest.getCallingAppInfo().getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "getSigningInfo(...)");
                return companion.createFrom$credentials((List) objCollect, companion2.create(packageName, signingInfo, getCredentialRequest.getCallingAppInfo().getOrigin()), biometricPromptResultRetrieveBiometricPromptResult$default, intent.getExtras());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.credentials.CredentialOption retrieveProviderGetCredentialRequest$lambda$1(Function1 function1, Object obj) {
                return (androidx.credentials.CredentialOption) function1.invoke(obj);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.credentials.CredentialOption retrieveProviderGetCredentialRequest$lambda$0(CredentialOption credentialOption) {
                androidx.credentials.CredentialOption.Companion companion = androidx.credentials.CredentialOption.INSTANCE;
                String type = credentialOption.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                Bundle credentialRetrievalData = credentialOption.getCredentialRetrievalData();
                Intrinsics.checkNotNullExpressionValue(credentialRetrievalData, "getCredentialRetrievalData(...)");
                Bundle candidateQueryData = credentialOption.getCandidateQueryData();
                Intrinsics.checkNotNullExpressionValue(candidateQueryData, "getCandidateQueryData(...)");
                boolean zIsSystemProviderRequired = credentialOption.isSystemProviderRequired();
                Set<ComponentName> allowedProviders = credentialOption.getAllowedProviders();
                Intrinsics.checkNotNullExpressionValue(allowedProviders, "getAllowedProviders(...)");
                return companion.createFrom(type, credentialRetrievalData, candidateQueryData, zIsSystemProviderRequired, allowedProviders);
            }

            @JvmStatic
            public final CreateCredentialResponse extractCreateCredentialResponse(String type, Intent intent) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.CreateCredentialResponse createCredentialResponse = (android.credentials.CreateCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", android.credentials.CreateCredentialResponse.class);
                if (createCredentialResponse == null) {
                    return null;
                }
                CreateCredentialResponse.Companion companion = CreateCredentialResponse.INSTANCE;
                Bundle data = createCredentialResponse.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                return companion.createFrom(type, data);
            }

            @JvmStatic
            public final GetCredentialResponse extractGetCredentialResponse(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.GetCredentialResponse getCredentialResponse = (android.credentials.GetCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", android.credentials.GetCredentialResponse.class);
                if (getCredentialResponse == null) {
                    return null;
                }
                Credential.Companion companion = Credential.INSTANCE;
                android.credentials.Credential credential = getCredentialResponse.getCredential();
                Intrinsics.checkNotNullExpressionValue(credential, "getCredential(...)");
                return new GetCredentialResponse(companion.createFrom(credential));
            }

            @JvmStatic
            public final void setGetCredentialResponse(Intent intent, GetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", new android.credentials.GetCredentialResponse(new android.credentials.Credential(response.getCredential().getType(), response.getCredential().getData())));
            }

            @JvmStatic
            public final void setBeginGetCredentialResponse(Intent intent, BeginGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(response, "response");
                intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
            }

            @JvmStatic
            public final CreateCredentialException extractCreateCredentialException(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.CreateCredentialException createCredentialException = (android.credentials.CreateCredentialException) intent.getSerializableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", android.credentials.CreateCredentialException.class);
                if (createCredentialException == null) {
                    return null;
                }
                String type = createCredentialException.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                return ConversionUtilsKt.toJetpackCreateException(type, createCredentialException.getMessage());
            }

            @JvmStatic
            public final GetCredentialException extractGetCredentialException(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                android.credentials.GetCredentialException getCredentialException = (android.credentials.GetCredentialException) intent.getSerializableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", android.credentials.GetCredentialException.class);
                if (getCredentialException == null) {
                    return null;
                }
                String type = getCredentialException.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                return ConversionUtilsKt.toJetpackGetException(type, getCredentialException.getMessage());
            }

            @JvmStatic
            public final void setGetCredentialException(Intent intent, GetCredentialException exception) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(exception, "exception");
                intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", new android.credentials.GetCredentialException(exception.getType(), exception.getMessage()));
            }

            @JvmStatic
            public final void setCreateCredentialException(Intent intent, CreateCredentialException exception) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(exception, "exception");
                intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", new android.credentials.CreateCredentialException(exception.getType(), exception.getMessage()));
            }
        }
    }
}
