package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public final class RegistrationRequestCreator implements Parcelable.Creator<RegistrationRequest> {
    static void writeToParcel(RegistrationRequest registrationRequest, Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, registrationRequest.getCredentials(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, registrationRequest.getMatcher(), false);
        SafeParcelWriter.writeString(parcel, 3, registrationRequest.getType(), false);
        SafeParcelWriter.writeString(parcel, 4, registrationRequest.getRequestType(), false);
        SafeParcelWriter.writeStringList(parcel, 5, registrationRequest.getProtocolTypes(), false);
        SafeParcelWriter.writeString(parcel, 6, registrationRequest.getId(), false);
        SafeParcelWriter.writeString(parcel, 7, registrationRequest.getFulfillmentActionName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RegistrationRequest createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List listEmptyList = Collections.emptyList();
        String strCreateString = "";
        String strCreateString2 = strCreateString;
        String strCreateString3 = strCreateString2;
        String strCreateString4 = strCreateString3;
        byte[] bArrCreateByteArray = null;
        byte[] bArrCreateByteArray2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 2:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    listEmptyList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 6:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new RegistrationRequest(bArrCreateByteArray, bArrCreateByteArray2, strCreateString, strCreateString2, listEmptyList, strCreateString3, strCreateString4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RegistrationRequest[] newArray(int i) {
        return new RegistrationRequest[i];
    }
}
