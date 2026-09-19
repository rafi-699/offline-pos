package androidx.credentials.provider;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProviderClearCredentialStateRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "<init>", "(Landroidx/credentials/provider/CallingAppInfo;)V", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderClearCredentialStateRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CallingAppInfo callingAppInfo;

    @JvmStatic
    public static final Bundle asBundle(ProviderClearCredentialStateRequest providerClearCredentialStateRequest) {
        return INSTANCE.asBundle(providerClearCredentialStateRequest);
    }

    @JvmStatic
    public static final ProviderClearCredentialStateRequest fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: compiled from: ProviderClearCredentialStateRequest.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Landroidx/credentials/provider/ProviderClearCredentialStateRequest$Companion;", "", "<init>", "()V", "asBundle", "Landroid/os/Bundle;", "request", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "fromBundle", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle asBundle(ProviderClearCredentialStateRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Bundle bundle = new Bundle();
            CallingAppInfo.INSTANCE.setCallingAppInfo$credentials(bundle, request.getCallingAppInfo());
            return bundle;
        }

        @JvmStatic
        public final ProviderClearCredentialStateRequest fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            CallingAppInfo callingAppInfoExtractCallingAppInfo = CallingAppInfo.INSTANCE.extractCallingAppInfo(bundle);
            if (callingAppInfoExtractCallingAppInfo == null) {
                throw new IllegalArgumentException("Bundle was missing CallingAppInfo.");
            }
            return new ProviderClearCredentialStateRequest(callingAppInfoExtractCallingAppInfo);
        }
    }

    public ProviderClearCredentialStateRequest(CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
        this.callingAppInfo = callingAppInfo;
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }
}
