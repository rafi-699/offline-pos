package com.google.android.gms.identitycredentials.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.identitycredentials.ClearCreationOptionsRequest;
import com.google.android.gms.identitycredentials.ClearCredentialStateRequest;
import com.google.android.gms.identitycredentials.ClearRegistryRequest;
import com.google.android.gms.identitycredentials.CreateCredentialRequest;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.identitycredentials.ImportCredentialsRequest;
import com.google.android.gms.identitycredentials.RegisterCreationOptionsRequest;
import com.google.android.gms.identitycredentials.RegisterExportRequest;
import com.google.android.gms.identitycredentials.RegistrationRequest;
import com.google.android.gms.identitycredentials.SignalCredentialStateRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public interface IIdentityCredentialService extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    public static abstract class Stub extends com.google.android.gms.internal.identity_credentials.zzb implements IIdentityCredentialService {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
        public static class Proxy extends com.google.android.gms.internal.identity_credentials.zza implements IIdentityCredentialService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.identitycredentials.internal.IIdentityCredentialService");
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void clearCreationOptions(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearCreationOptionsRequest clearCreationOptionsRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, clearCreationOptionsRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(15, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void clearCredentialState(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearCredentialStateRequest clearCredentialStateRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, clearCredentialStateRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(9, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void clearRegistry(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearRegistryRequest clearRegistryRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, clearRegistryRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void createCredential(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, CreateCredentialRequest createCredentialRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, createCredentialRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(6, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void getCredential(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, GetCredentialRequest getCredentialRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, getCredentialRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void importCredentials(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ImportCredentialsRequest importCredentialsRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, importCredentialsRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(4, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void registerCreationOptions(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegisterCreationOptionsRequest registerCreationOptionsRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, registerCreationOptionsRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(8, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void registerCredentials(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegistrationRequest registrationRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, registrationRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void registerExport(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegisterExportRequest registerExportRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, registerExportRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(5, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void signalCredentialState(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, SignalCredentialStateRequest signalCredentialStateRequest, ApiMetadata apiMetadata) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                com.google.android.gms.internal.identity_credentials.zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, signalCredentialStateRequest);
                com.google.android.gms.internal.identity_credentials.zzc.zzb(parcelObtainAndWriteInterfaceToken, apiMetadata);
                transactAndReadExceptionReturnVoid(10, parcelObtainAndWriteInterfaceToken);
            }
        }

        public static IIdentityCredentialService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identitycredentials.internal.IIdentityCredentialService");
            return iInterfaceQueryLocalInterface instanceof IIdentityCredentialService ? (IIdentityCredentialService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            throw null;
        }
    }

    void clearCreationOptions(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearCreationOptionsRequest clearCreationOptionsRequest, ApiMetadata apiMetadata) throws RemoteException;

    void clearCredentialState(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearCredentialStateRequest clearCredentialStateRequest, ApiMetadata apiMetadata) throws RemoteException;

    void clearRegistry(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearRegistryRequest clearRegistryRequest, ApiMetadata apiMetadata) throws RemoteException;

    void createCredential(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, CreateCredentialRequest createCredentialRequest, ApiMetadata apiMetadata) throws RemoteException;

    void getCredential(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, GetCredentialRequest getCredentialRequest, ApiMetadata apiMetadata) throws RemoteException;

    void importCredentials(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ImportCredentialsRequest importCredentialsRequest, ApiMetadata apiMetadata) throws RemoteException;

    void registerCreationOptions(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegisterCreationOptionsRequest registerCreationOptionsRequest, ApiMetadata apiMetadata) throws RemoteException;

    void registerCredentials(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegistrationRequest registrationRequest, ApiMetadata apiMetadata) throws RemoteException;

    void registerExport(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegisterExportRequest registerExportRequest, ApiMetadata apiMetadata) throws RemoteException;

    void signalCredentialState(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, SignalCredentialStateRequest signalCredentialStateRequest, ApiMetadata apiMetadata) throws RemoteException;
}
