package com.google.android.gms.identitycredentials.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identitycredentials.ClearCreationOptionsResponse;
import com.google.android.gms.identitycredentials.ClearCredentialStateResponse;
import com.google.android.gms.identitycredentials.ClearExportResponse;
import com.google.android.gms.identitycredentials.ClearRegistryResponse;
import com.google.android.gms.identitycredentials.CreateCredentialHandle;
import com.google.android.gms.identitycredentials.CreateCredentialResponse;
import com.google.android.gms.identitycredentials.CredentialTransferCapabilities;
import com.google.android.gms.identitycredentials.ExportCredentialsToDeviceSetupResponse;
import com.google.android.gms.identitycredentials.ImportCredentialsForDeviceSetupResponse;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.identitycredentials.PendingImportCredentialsHandle;
import com.google.android.gms.identitycredentials.RegisterCreationOptionsResponse;
import com.google.android.gms.identitycredentials.RegisterExportResponse;
import com.google.android.gms.identitycredentials.RegistrationResponse;
import com.google.android.gms.identitycredentials.SignalCredentialStateResponse;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public interface IIdentityCredentialCallbacks extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    public static abstract class Stub extends com.google.android.gms.internal.identity_credentials.zzb implements IIdentityCredentialCallbacks {
        public Stub() {
            super("com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks");
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    Status status = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    PendingGetCredentialHandle pendingGetCredentialHandle = (PendingGetCredentialHandle) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, PendingGetCredentialHandle.CREATOR);
                    enforceNoDataAvail(parcel);
                    onGetCredential(status, pendingGetCredentialHandle);
                    return true;
                case 2:
                    Status status2 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    RegistrationResponse registrationResponse = (RegistrationResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, RegistrationResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onRegisterCredentials(status2, registrationResponse);
                    return true;
                case 3:
                    Status status3 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ClearRegistryResponse clearRegistryResponse = (ClearRegistryResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ClearRegistryResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onClearRegistry(status3, clearRegistryResponse);
                    return true;
                case 4:
                    Status status4 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    PendingImportCredentialsHandle pendingImportCredentialsHandle = (PendingImportCredentialsHandle) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, PendingImportCredentialsHandle.CREATOR);
                    enforceNoDataAvail(parcel);
                    onImportCredentials(status4, pendingImportCredentialsHandle);
                    return true;
                case 5:
                    Status status5 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    RegisterExportResponse registerExportResponse = (RegisterExportResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, RegisterExportResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onRegisterExport(status5, registerExportResponse);
                    return true;
                case 6:
                    Status status6 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    CreateCredentialResponse createCredentialResponse = (CreateCredentialResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, CreateCredentialResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onCreateCredential(status6, createCredentialResponse);
                    return true;
                case 7:
                    Status status7 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    CreateCredentialHandle createCredentialHandle = (CreateCredentialHandle) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, CreateCredentialHandle.CREATOR);
                    enforceNoDataAvail(parcel);
                    onCreateCredentialV2(status7, createCredentialHandle);
                    return true;
                case 8:
                    Status status8 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    RegisterCreationOptionsResponse registerCreationOptionsResponse = (RegisterCreationOptionsResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, RegisterCreationOptionsResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onRegisterCreationOptions(status8, registerCreationOptionsResponse);
                    return true;
                case 9:
                    Status status9 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ClearCredentialStateResponse clearCredentialStateResponse = (ClearCredentialStateResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ClearCredentialStateResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onClearCredentialState(status9, clearCredentialStateResponse);
                    return true;
                case 10:
                    Status status10 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    SignalCredentialStateResponse signalCredentialStateResponse = (SignalCredentialStateResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, SignalCredentialStateResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onSignalCredentialState(status10, signalCredentialStateResponse);
                    return true;
                case 11:
                    Status status11 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ClearExportResponse clearExportResponse = (ClearExportResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ClearExportResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onClearExport(status11, clearExportResponse);
                    return true;
                case 12:
                    Status status12 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ImportCredentialsForDeviceSetupResponse importCredentialsForDeviceSetupResponse = (ImportCredentialsForDeviceSetupResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ImportCredentialsForDeviceSetupResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onImportCredentialsForDeviceSetup(status12, importCredentialsForDeviceSetupResponse);
                    return true;
                case 13:
                    Status status13 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ExportCredentialsToDeviceSetupResponse exportCredentialsToDeviceSetupResponse = (ExportCredentialsToDeviceSetupResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ExportCredentialsToDeviceSetupResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onExportCredentialsToDeviceSetup(status13, exportCredentialsToDeviceSetupResponse);
                    return true;
                case 14:
                    Status status14 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    CredentialTransferCapabilities credentialTransferCapabilities = (CredentialTransferCapabilities) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, CredentialTransferCapabilities.CREATOR);
                    enforceNoDataAvail(parcel);
                    onGetCredentialTransferCapabilities(status14, credentialTransferCapabilities);
                    return true;
                case 15:
                    Status status15 = (Status) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, Status.CREATOR);
                    ClearCreationOptionsResponse clearCreationOptionsResponse = (ClearCreationOptionsResponse) com.google.android.gms.internal.identity_credentials.zzc.zza(parcel, ClearCreationOptionsResponse.CREATOR);
                    enforceNoDataAvail(parcel);
                    onClearCreationOptions(status15, clearCreationOptionsResponse);
                    return true;
                default:
                    return false;
            }
        }
    }

    void onClearCreationOptions(Status status, ClearCreationOptionsResponse clearCreationOptionsResponse) throws RemoteException;

    void onClearCredentialState(Status status, ClearCredentialStateResponse clearCredentialStateResponse) throws RemoteException;

    void onClearExport(Status status, ClearExportResponse clearExportResponse) throws RemoteException;

    void onClearRegistry(Status status, ClearRegistryResponse clearRegistryResponse) throws RemoteException;

    void onCreateCredential(Status status, CreateCredentialResponse createCredentialResponse) throws RemoteException;

    void onCreateCredentialV2(Status status, CreateCredentialHandle createCredentialHandle) throws RemoteException;

    void onExportCredentialsToDeviceSetup(Status status, ExportCredentialsToDeviceSetupResponse exportCredentialsToDeviceSetupResponse) throws RemoteException;

    void onGetCredential(Status status, PendingGetCredentialHandle pendingGetCredentialHandle) throws RemoteException;

    void onGetCredentialTransferCapabilities(Status status, CredentialTransferCapabilities credentialTransferCapabilities) throws RemoteException;

    void onImportCredentials(Status status, PendingImportCredentialsHandle pendingImportCredentialsHandle) throws RemoteException;

    void onImportCredentialsForDeviceSetup(Status status, ImportCredentialsForDeviceSetupResponse importCredentialsForDeviceSetupResponse) throws RemoteException;

    void onRegisterCreationOptions(Status status, RegisterCreationOptionsResponse registerCreationOptionsResponse) throws RemoteException;

    void onRegisterCredentials(Status status, RegistrationResponse registrationResponse) throws RemoteException;

    void onRegisterExport(Status status, RegisterExportResponse registerExportResponse) throws RemoteException;

    void onSignalCredentialState(Status status, SignalCredentialStateResponse signalCredentialStateResponse) throws RemoteException;
}
