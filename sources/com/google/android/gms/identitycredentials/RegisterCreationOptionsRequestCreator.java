package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public final class RegisterCreationOptionsRequestCreator implements Parcelable.Creator<RegisterCreationOptionsRequest> {
    static void writeToParcel(RegisterCreationOptionsRequest registerCreationOptionsRequest, Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, registerCreationOptionsRequest.getCreateOptions(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, registerCreationOptionsRequest.getMatcher(), false);
        SafeParcelWriter.writeString(parcel, 3, registerCreationOptionsRequest.getType(), false);
        SafeParcelWriter.writeString(parcel, 4, registerCreationOptionsRequest.getId(), false);
        SafeParcelWriter.writeString(parcel, 5, registerCreationOptionsRequest.getFulfillmentActionName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RegisterCreationOptionsRequest createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = "";
        byte[] bArrCreateByteArray = null;
        byte[] bArrCreateByteArray2 = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
            } else if (fieldId == 2) {
                bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
            } else if (fieldId == 3) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 4) {
                strCreateString3 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                strCreateString = SafeParcelReader.createString(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new RegisterCreationOptionsRequest(bArrCreateByteArray, bArrCreateByteArray2, strCreateString2, strCreateString3, strCreateString);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RegisterCreationOptionsRequest[] newArray(int i) {
        return new RegisterCreationOptionsRequest[i];
    }
}
