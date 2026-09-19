package com.google.android.gms.identitycredentials.provider;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identitycredentials.CallingAppInfoParcelable;
import com.google.android.gms.identitycredentials.CreateCredentialRequest;
import com.google.android.gms.identitycredentials.ExportCredentialsToDeviceSetupRequest;
import com.google.android.gms.identitycredentials.GetCredentialTransferCapabilitiesRequest;
import com.google.android.gms.identitycredentials.ImportCredentialsForDeviceSetupRequest;
import com.google.android.gms.identitycredentials.SignalCredentialStateRequest;
import com.google.android.gms.internal.identity_credentials.zza;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public interface ICredentialProviderService extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    public static abstract class Stub extends zzb implements ICredentialProviderService {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
        public static class Proxy extends zza implements ICredentialProviderService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.identitycredentials.provider.ICredentialProviderService");
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialProviderService
            public void onCreateCredentialRequest(CreateCredentialRequest createCredentialRequest, CallingAppInfoParcelable callingAppInfoParcelable, ICreateCredentialCallbacks iCreateCredentialCallbacks) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, createCredentialRequest);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, callingAppInfoParcelable);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iCreateCredentialCallbacks);
                transactOneway(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialProviderService
            public void onExportCredentials(ExportCredentialsToDeviceSetupRequest exportCredentialsToDeviceSetupRequest, CallingAppInfoParcelable callingAppInfoParcelable, IExportCredentialsCallbacks iExportCredentialsCallbacks) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, exportCredentialsToDeviceSetupRequest);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, callingAppInfoParcelable);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iExportCredentialsCallbacks);
                transactOneway(4, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialProviderService
            public void onGetCredentialTransferCapabilities(GetCredentialTransferCapabilitiesRequest getCredentialTransferCapabilitiesRequest, CallingAppInfoParcelable callingAppInfoParcelable, ICredentialTransferCapabilitiesCallbacks iCredentialTransferCapabilitiesCallbacks) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, getCredentialTransferCapabilitiesRequest);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, callingAppInfoParcelable);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iCredentialTransferCapabilitiesCallbacks);
                transactOneway(5, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialProviderService
            public void onImportCredentials(ImportCredentialsForDeviceSetupRequest importCredentialsForDeviceSetupRequest, CallingAppInfoParcelable callingAppInfoParcelable, IImportCredentialsCallbacks iImportCredentialsCallbacks) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, importCredentialsForDeviceSetupRequest);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, callingAppInfoParcelable);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iImportCredentialsCallbacks);
                transactOneway(3, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialProviderService
            public void onSignalCredentialStateRequest(SignalCredentialStateRequest signalCredentialStateRequest, CallingAppInfoParcelable callingAppInfoParcelable, ISignalCredentialStateCallbacks iSignalCredentialStateCallbacks) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, signalCredentialStateRequest);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, callingAppInfoParcelable);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iSignalCredentialStateCallbacks);
                transactOneway(2, parcelObtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.identitycredentials.provider.ICredentialProviderService");
        }

        public static ICredentialProviderService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identitycredentials.provider.ICredentialProviderService");
            return iInterfaceQueryLocalInterface instanceof ICredentialProviderService ? (ICredentialProviderService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                CreateCredentialRequest createCredentialRequest = (CreateCredentialRequest) zzc.zza(parcel, CreateCredentialRequest.CREATOR);
                CallingAppInfoParcelable callingAppInfoParcelable = (CallingAppInfoParcelable) zzc.zza(parcel, CallingAppInfoParcelable.CREATOR);
                ICreateCredentialCallbacks iCreateCredentialCallbacksAsInterface = ICreateCredentialCallbacks.Stub.asInterface(parcel.readStrongBinder());
                enforceNoDataAvail(parcel);
                onCreateCredentialRequest(createCredentialRequest, callingAppInfoParcelable, iCreateCredentialCallbacksAsInterface);
            } else if (i == 2) {
                SignalCredentialStateRequest signalCredentialStateRequest = (SignalCredentialStateRequest) zzc.zza(parcel, SignalCredentialStateRequest.CREATOR);
                CallingAppInfoParcelable callingAppInfoParcelable2 = (CallingAppInfoParcelable) zzc.zza(parcel, CallingAppInfoParcelable.CREATOR);
                ISignalCredentialStateCallbacks iSignalCredentialStateCallbacksAsInterface = ISignalCredentialStateCallbacks.Stub.asInterface(parcel.readStrongBinder());
                enforceNoDataAvail(parcel);
                onSignalCredentialStateRequest(signalCredentialStateRequest, callingAppInfoParcelable2, iSignalCredentialStateCallbacksAsInterface);
            } else if (i == 3) {
                ImportCredentialsForDeviceSetupRequest importCredentialsForDeviceSetupRequest = (ImportCredentialsForDeviceSetupRequest) zzc.zza(parcel, ImportCredentialsForDeviceSetupRequest.CREATOR);
                CallingAppInfoParcelable callingAppInfoParcelable3 = (CallingAppInfoParcelable) zzc.zza(parcel, CallingAppInfoParcelable.CREATOR);
                IImportCredentialsCallbacks iImportCredentialsCallbacksAsInterface = IImportCredentialsCallbacks.Stub.asInterface(parcel.readStrongBinder());
                enforceNoDataAvail(parcel);
                onImportCredentials(importCredentialsForDeviceSetupRequest, callingAppInfoParcelable3, iImportCredentialsCallbacksAsInterface);
            } else if (i == 4) {
                ExportCredentialsToDeviceSetupRequest exportCredentialsToDeviceSetupRequest = (ExportCredentialsToDeviceSetupRequest) zzc.zza(parcel, ExportCredentialsToDeviceSetupRequest.CREATOR);
                CallingAppInfoParcelable callingAppInfoParcelable4 = (CallingAppInfoParcelable) zzc.zza(parcel, CallingAppInfoParcelable.CREATOR);
                IExportCredentialsCallbacks iExportCredentialsCallbacksAsInterface = IExportCredentialsCallbacks.Stub.asInterface(parcel.readStrongBinder());
                enforceNoDataAvail(parcel);
                onExportCredentials(exportCredentialsToDeviceSetupRequest, callingAppInfoParcelable4, iExportCredentialsCallbacksAsInterface);
            } else {
                if (i != 5) {
                    return false;
                }
                GetCredentialTransferCapabilitiesRequest getCredentialTransferCapabilitiesRequest = (GetCredentialTransferCapabilitiesRequest) zzc.zza(parcel, GetCredentialTransferCapabilitiesRequest.CREATOR);
                CallingAppInfoParcelable callingAppInfoParcelable5 = (CallingAppInfoParcelable) zzc.zza(parcel, CallingAppInfoParcelable.CREATOR);
                ICredentialTransferCapabilitiesCallbacks iCredentialTransferCapabilitiesCallbacksAsInterface = ICredentialTransferCapabilitiesCallbacks.Stub.asInterface(parcel.readStrongBinder());
                enforceNoDataAvail(parcel);
                onGetCredentialTransferCapabilities(getCredentialTransferCapabilitiesRequest, callingAppInfoParcelable5, iCredentialTransferCapabilitiesCallbacksAsInterface);
            }
            return true;
        }
    }

    void onCreateCredentialRequest(CreateCredentialRequest createCredentialRequest, CallingAppInfoParcelable callingAppInfoParcelable, ICreateCredentialCallbacks iCreateCredentialCallbacks) throws RemoteException;

    void onExportCredentials(ExportCredentialsToDeviceSetupRequest exportCredentialsToDeviceSetupRequest, CallingAppInfoParcelable callingAppInfoParcelable, IExportCredentialsCallbacks iExportCredentialsCallbacks) throws RemoteException;

    void onGetCredentialTransferCapabilities(GetCredentialTransferCapabilitiesRequest getCredentialTransferCapabilitiesRequest, CallingAppInfoParcelable callingAppInfoParcelable, ICredentialTransferCapabilitiesCallbacks iCredentialTransferCapabilitiesCallbacks) throws RemoteException;

    void onImportCredentials(ImportCredentialsForDeviceSetupRequest importCredentialsForDeviceSetupRequest, CallingAppInfoParcelable callingAppInfoParcelable, IImportCredentialsCallbacks iImportCredentialsCallbacks) throws RemoteException;

    void onSignalCredentialStateRequest(SignalCredentialStateRequest signalCredentialStateRequest, CallingAppInfoParcelable callingAppInfoParcelable, ISignalCredentialStateCallbacks iSignalCredentialStateCallbacks) throws RemoteException;
}
