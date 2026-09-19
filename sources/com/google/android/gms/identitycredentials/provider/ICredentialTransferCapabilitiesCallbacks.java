package com.google.android.gms.identitycredentials.provider;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identitycredentials.CredentialTransferCapabilities;
import com.google.android.gms.internal.identity_credentials.zza;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public interface ICredentialTransferCapabilitiesCallbacks extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    public static abstract class Stub extends zzb implements ICredentialTransferCapabilitiesCallbacks {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
        public static class Proxy extends zza implements ICredentialTransferCapabilitiesCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.identitycredentials.provider.ICredentialTransferCapabilitiesCallbacks");
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialTransferCapabilitiesCallbacks
            public void onFailure(String str, String str2) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeString(str);
                parcelObtainAndWriteInterfaceToken.writeString(str2);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICredentialTransferCapabilitiesCallbacks
            public void onSuccess(CredentialTransferCapabilities credentialTransferCapabilities) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, credentialTransferCapabilities);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.identitycredentials.provider.ICredentialTransferCapabilitiesCallbacks");
        }

        public static ICredentialTransferCapabilitiesCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identitycredentials.provider.ICredentialTransferCapabilitiesCallbacks");
            return iInterfaceQueryLocalInterface instanceof ICredentialTransferCapabilitiesCallbacks ? (ICredentialTransferCapabilitiesCallbacks) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                CredentialTransferCapabilities credentialTransferCapabilities = (CredentialTransferCapabilities) zzc.zza(parcel, CredentialTransferCapabilities.CREATOR);
                enforceNoDataAvail(parcel);
                onSuccess(credentialTransferCapabilities);
            } else {
                if (i != 2) {
                    return false;
                }
                String string = parcel.readString();
                String string2 = parcel.readString();
                enforceNoDataAvail(parcel);
                onFailure(string, string2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailure(String str, String str2) throws RemoteException;

    void onSuccess(CredentialTransferCapabilities credentialTransferCapabilities) throws RemoteException;
}
