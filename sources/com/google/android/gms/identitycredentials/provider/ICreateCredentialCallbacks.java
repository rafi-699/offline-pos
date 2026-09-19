package com.google.android.gms.identitycredentials.provider;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identitycredentials.CreateCredentialResponse;
import com.google.android.gms.internal.identity_credentials.zza;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public interface ICreateCredentialCallbacks extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    public static abstract class Stub extends zzb implements ICreateCredentialCallbacks {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
        public static class Proxy extends zza implements ICreateCredentialCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks");
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks
            public void onFailure(String str, String str2) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                parcelObtainAndWriteInterfaceToken.writeString(str);
                parcelObtainAndWriteInterfaceToken.writeString(str2);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks
            public void onSuccess(CreateCredentialResponse createCredentialResponse) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, createCredentialResponse);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks
            public void onSuccessV2(CreateCredentialResponse createCredentialResponse, PendingIntent pendingIntent) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, createCredentialResponse);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, pendingIntent);
                transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks");
        }

        public static ICreateCredentialCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identitycredentials.provider.ICreateCredentialCallbacks");
            return iInterfaceQueryLocalInterface instanceof ICreateCredentialCallbacks ? (ICreateCredentialCallbacks) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                CreateCredentialResponse createCredentialResponse = (CreateCredentialResponse) zzc.zza(parcel, CreateCredentialResponse.CREATOR);
                enforceNoDataAvail(parcel);
                onSuccess(createCredentialResponse);
            } else if (i == 2) {
                String string = parcel.readString();
                String string2 = parcel.readString();
                enforceNoDataAvail(parcel);
                onFailure(string, string2);
            } else {
                if (i != 3) {
                    return false;
                }
                CreateCredentialResponse createCredentialResponse2 = (CreateCredentialResponse) zzc.zza(parcel, CreateCredentialResponse.CREATOR);
                PendingIntent pendingIntent = (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR);
                enforceNoDataAvail(parcel);
                onSuccessV2(createCredentialResponse2, pendingIntent);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailure(String str, String str2) throws RemoteException;

    void onSuccess(CreateCredentialResponse createCredentialResponse) throws RemoteException;

    void onSuccessV2(CreateCredentialResponse createCredentialResponse, PendingIntent pendingIntent) throws RemoteException;
}
