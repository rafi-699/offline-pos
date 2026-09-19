package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
public final class ClearTypedRegistryOptionCreator implements Parcelable.Creator<ClearRegistryRequest.ClearTypedRegistryOption> {
    static void writeToParcel(ClearRegistryRequest.ClearTypedRegistryOption clearTypedRegistryOption, Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, clearTypedRegistryOption.getDeleteAllForType());
        SafeParcelWriter.writeString(parcel, 2, clearTypedRegistryOption.getType(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, clearTypedRegistryOption.getDeleteIdlessRegistry());
        SafeParcelWriter.writeStringList(parcel, 4, clearTypedRegistryOption.getRegistryIds(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ClearRegistryRequest.ClearTypedRegistryOption createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        boolean z = false;
        boolean z2 = false;
        ArrayList<String> arrayListCreateStringList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                z = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId == 2) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                z2 = SafeParcelReader.readBoolean(parcel, header);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ClearRegistryRequest.ClearTypedRegistryOption(z, strCreateString, z2, arrayListCreateStringList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ClearRegistryRequest.ClearTypedRegistryOption[] newArray(int i) {
        return new ClearRegistryRequest.ClearTypedRegistryOption[i];
    }
}
