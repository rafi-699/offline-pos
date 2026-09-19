package com.google.android.gms.identitycredentials.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.identitycredentials.ClearCreationOptionsRequest;
import com.google.android.gms.identitycredentials.ClearCreationOptionsResponse;
import com.google.android.gms.identitycredentials.ClearCredentialStateRequest;
import com.google.android.gms.identitycredentials.ClearCredentialStateResponse;
import com.google.android.gms.identitycredentials.ClearRegistryRequest;
import com.google.android.gms.identitycredentials.ClearRegistryResponse;
import com.google.android.gms.identitycredentials.CreateCredentialHandle;
import com.google.android.gms.identitycredentials.CreateCredentialRequest;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.identitycredentials.IdentityCredentialClient;
import com.google.android.gms.identitycredentials.ImportCredentialsRequest;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.identitycredentials.PendingImportCredentialsHandle;
import com.google.android.gms.identitycredentials.RegisterCreationOptionsRequest;
import com.google.android.gms.identitycredentials.RegisterCreationOptionsResponse;
import com.google.android.gms.identitycredentials.RegisterExportRequest;
import com.google.android.gms.identitycredentials.RegisterExportResponse;
import com.google.android.gms.identitycredentials.RegistrationRequest;
import com.google.android.gms.identitycredentials.RegistrationResponse;
import com.google.android.gms.identitycredentials.SignalCredentialStateRequest;
import com.google.android.gms.identitycredentials.SignalCredentialStateResponse;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00018B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u000f\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u000f\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u000f\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\u0006\u0010\u000f\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\u0006\u0010\u000f\u001a\u00020\u001fH\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r2\u0006\u0010\u000f\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\r2\u0006\u0010\u000f\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\r2\u0006\u0010\u000f\u001a\u00020(H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\r2\u0006\u0010\u000f\u001a\u00020+H\u0016J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\r2\u0006\u0010\u000f\u001a\u00020.H\u0016J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\r2\u0006\u0010\u000f\u001a\u000201H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002030\r2\u0006\u0010\u000f\u001a\u000204H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\r2\u0006\u0010\u000f\u001a\u000207H\u0016¨\u00069"}, d2 = {"Lcom/google/android/gms/identitycredentials/internal/InternalIdentityCredentialClient;", "Lcom/google/android/gms/common/api/GoogleApi;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "Lcom/google/android/gms/identitycredentials/IdentityCredentialClient;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "clientBuilder", "Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;", "Lcom/google/android/gms/identitycredentials/internal/IdentityCredentialClientImpl;", "(Landroid/content/Context;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;)V", "getCredential", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/identitycredentials/PendingGetCredentialHandle;", "request", "Lcom/google/android/gms/identitycredentials/GetCredentialRequest;", "registerCredentials", "Lcom/google/android/gms/identitycredentials/RegistrationResponse;", "Lcom/google/android/gms/identitycredentials/RegistrationRequest;", "registerCreationOptions", "Lcom/google/android/gms/identitycredentials/RegisterCreationOptionsResponse;", "Lcom/google/android/gms/identitycredentials/RegisterCreationOptionsRequest;", "clearCreationOptions", "Lcom/google/android/gms/identitycredentials/ClearCreationOptionsResponse;", "Lcom/google/android/gms/identitycredentials/ClearCreationOptionsRequest;", "clearRegistry", "Lcom/google/android/gms/identitycredentials/ClearRegistryResponse;", "Lcom/google/android/gms/identitycredentials/ClearRegistryRequest;", "importCredentials", "Lcom/google/android/gms/identitycredentials/PendingImportCredentialsHandle;", "Lcom/google/android/gms/identitycredentials/ImportCredentialsRequest;", "registerExport", "Lcom/google/android/gms/identitycredentials/RegisterExportResponse;", "Lcom/google/android/gms/identitycredentials/RegisterExportRequest;", "clearExport", "Lcom/google/android/gms/identitycredentials/ClearExportResponse;", "Lcom/google/android/gms/identitycredentials/ClearExportRequest;", "createCredential", "Lcom/google/android/gms/identitycredentials/CreateCredentialHandle;", "Lcom/google/android/gms/identitycredentials/CreateCredentialRequest;", "exportCredentialsToDeviceSetup", "Lcom/google/android/gms/identitycredentials/ExportCredentialsToDeviceSetupResponse;", "Lcom/google/android/gms/identitycredentials/ExportCredentialsToDeviceSetupRequest;", "importCredentialsForDeviceSetup", "Lcom/google/android/gms/identitycredentials/ImportCredentialsForDeviceSetupResponse;", "Lcom/google/android/gms/identitycredentials/ImportCredentialsForDeviceSetupRequest;", "getCredentialTransferCapabilities", "Lcom/google/android/gms/identitycredentials/CredentialTransferCapabilities;", "Lcom/google/android/gms/identitycredentials/GetCredentialTransferCapabilitiesRequest;", "clearCredentialState", "Lcom/google/android/gms/identitycredentials/ClearCredentialStateResponse;", "Lcom/google/android/gms/identitycredentials/ClearCredentialStateRequest;", "signalCredentialState", "Lcom/google/android/gms/identitycredentials/SignalCredentialStateResponse;", "Lcom/google/android/gms/identitycredentials/SignalCredentialStateRequest;", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InternalIdentityCredentialClient extends GoogleApi<Api.ApiOptions.NoOptions> implements IdentityCredentialClient {
    private static final Api<Api.ApiOptions.NoOptions> API;
    private static final InternalIdentityCredentialClient$Companion$CLIENT_BUILDER$1 CLIENT_BUILDER;
    private static final Api.ClientKey<IdentityCredentialClientImpl> CLIENT_KEY;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$Companion$CLIENT_BUILDER$1] */
    static {
        Api.ClientKey<IdentityCredentialClientImpl> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        ?? r1 = new Api.AbstractClientBuilder<IdentityCredentialClientImpl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$Companion$CLIENT_BUILDER$1
            @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
            public IdentityCredentialClientImpl buildClient(Context context, Looper looper, ClientSettings commonSettings, Api.ApiOptions.NoOptions apiOptions, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(looper, "looper");
                Intrinsics.checkNotNullParameter(commonSettings, "commonSettings");
                Intrinsics.checkNotNullParameter(apiOptions, "apiOptions");
                Intrinsics.checkNotNullParameter(connectedListener, "connectedListener");
                Intrinsics.checkNotNullParameter(connectionFailedListener, "connectionFailedListener");
                return new IdentityCredentialClientImpl(context, looper, commonSettings, connectedListener, connectionFailedListener);
            }
        };
        CLIENT_BUILDER = r1;
        API = new Api<>("IdentityCredentials.API", (Api.AbstractClientBuilder) r1, clientKey);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalIdentityCredentialClient(Context context) {
        super(context, API, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCreationOptions$lambda$3(ClearCreationOptionsRequest clearCreationOptionsRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).clearCreationOptions(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$clearCreationOptions$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onClearCreationOptions(Status status, ClearCreationOptionsResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, clearCreationOptionsRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCredentialState$lambda$12(ClearCredentialStateRequest clearCredentialStateRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).clearCredentialState(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$clearCredentialState$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onClearCredentialState(Status status, ClearCredentialStateResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, clearCredentialStateRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearRegistry$lambda$4(ClearRegistryRequest clearRegistryRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).clearRegistry(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$clearRegistry$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onClearRegistry(Status status, ClearRegistryResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, clearRegistryRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCredential$lambda$8(CreateCredentialRequest createCredentialRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).createCredential(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$createCredential$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onCreateCredentialV2(Status status, CreateCredentialHandle result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, createCredentialRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCredential$lambda$0(GetCredentialRequest getCredentialRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).getCredential(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$getCredential$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onGetCredential(Status status, PendingGetCredentialHandle result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, getCredentialRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importCredentials$lambda$5(ImportCredentialsRequest importCredentialsRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).importCredentials(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$importCredentials$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onImportCredentials(Status status, PendingImportCredentialsHandle result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, importCredentialsRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerCreationOptions$lambda$2(RegisterCreationOptionsRequest registerCreationOptionsRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).registerCreationOptions(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$registerCreationOptions$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onRegisterCreationOptions(Status status, RegisterCreationOptionsResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, registerCreationOptionsRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerCredentials$lambda$1(RegistrationRequest registrationRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).registerCredentials(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$registerCredentials$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onRegisterCredentials(Status status, RegistrationResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, registrationRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerExport$lambda$6(RegisterExportRequest registerExportRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).registerExport(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$registerExport$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onRegisterExport(Status status, RegisterExportResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, registerExportRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void signalCredentialState$lambda$13(SignalCredentialStateRequest signalCredentialStateRequest, IdentityCredentialClientImpl identityCredentialClientImpl, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((IIdentityCredentialService) identityCredentialClientImpl.getService()).signalCredentialState(new IdentityCredentialBaseCallbacks() { // from class: com.google.android.gms.identitycredentials.internal.InternalIdentityCredentialClient$signalCredentialState$1$callback$1
            @Override // com.google.android.gms.identitycredentials.internal.IdentityCredentialBaseCallbacks, com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks
            public void onSignalCredentialState(Status status, SignalCredentialStateResponse result) {
                Intrinsics.checkNotNullParameter(status, "status");
                TaskUtil.setResultOrApiException(status, result, taskCompletionSource);
            }
        }, signalCredentialStateRequest, com.google.android.gms.internal.identity_credentials.zzh.zza(identityCredentialClientImpl.getContext()));
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<ClearCreationOptionsResponse> clearCreationOptions(final ClearCreationOptionsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzd).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.clearCreationOptions$lambda$3(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32714).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<ClearCredentialStateResponse> clearCredentialState(final ClearCredentialStateRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zze).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzh
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.clearCredentialState$lambda$12(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32708).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<ClearRegistryResponse> clearRegistry(final ClearRegistryRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzc).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.clearRegistry$lambda$4(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32703).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<CreateCredentialHandle> createCredential(final CreateCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzf).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.createCredential$lambda$8(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32704).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<PendingGetCredentialHandle> getCredential(final GetCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoRead = doRead(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zza).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.getCredential$lambda$0(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32701).build());
        Intrinsics.checkNotNullExpressionValue(taskDoRead, "doRead(...)");
        return taskDoRead;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<PendingImportCredentialsHandle> importCredentials(final ImportCredentialsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzi).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zze
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.importCredentials$lambda$5(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32706).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<RegisterCreationOptionsResponse> registerCreationOptions(final RegisterCreationOptionsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzb).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.registerCreationOptions$lambda$2(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32707).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<RegistrationResponse> registerCredentials(final RegistrationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzb).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zza
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.registerCredentials$lambda$1(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32702).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<RegisterExportResponse> registerExport(final RegisterExportRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzh).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.registerExport$lambda$6(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32705).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }

    @Override // com.google.android.gms.identitycredentials.IdentityCredentialClient
    public Task<SignalCredentialStateResponse> signalCredentialState(final SignalCredentialStateRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Task taskDoWrite = doWrite(TaskApiCall.builder().setFeatures(com.google.android.gms.internal.identity_credentials.zze.zzj).run(new RemoteCall() { // from class: com.google.android.gms.identitycredentials.internal.zzi
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                InternalIdentityCredentialClient.signalCredentialState$lambda$13(request, (IdentityCredentialClientImpl) obj, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(32709).build());
        Intrinsics.checkNotNullExpressionValue(taskDoWrite, "doWrite(...)");
        return taskDoWrite;
    }
}
