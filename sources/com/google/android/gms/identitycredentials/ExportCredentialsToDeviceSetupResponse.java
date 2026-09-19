package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\r\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/google/android/gms/identitycredentials/ExportCredentialsToDeviceSetupResponse;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "responseBundle", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "getResponseBundle", "()Landroid/os/Bundle;", "getProviderAppInfo", "Lcom/google/android/gms/identitycredentials/CallingAppInfoParcelable;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "getNumSuccess", "()Ljava/lang/Integer;", "getNumFailure", "getNumIgnored", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SafeParcelable.Class(creator = "ExportCredentialsToDeviceSetupResponseCreator")
public final class ExportCredentialsToDeviceSetupResponse extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getResponseBundle", id = 1)
    private final Bundle responseBundle;
    public static final Parcelable.Creator<ExportCredentialsToDeviceSetupResponse> CREATOR = new ExportCredentialsToDeviceSetupResponseCreator();

    @SafeParcelable.Constructor
    public ExportCredentialsToDeviceSetupResponse(@SafeParcelable.Param(id = 1) Bundle responseBundle) {
        Intrinsics.checkNotNullParameter(responseBundle, "responseBundle");
        this.responseBundle = responseBundle;
    }

    public final Integer getNumFailure() {
        if (this.responseBundle.containsKey("NUM_FAILURE")) {
            return Integer.valueOf(this.responseBundle.getInt("NUM_FAILURE"));
        }
        return null;
    }

    public final Integer getNumIgnored() {
        if (this.responseBundle.containsKey("NUM_IGNORED")) {
            return Integer.valueOf(this.responseBundle.getInt("NUM_IGNORED"));
        }
        return null;
    }

    public final Integer getNumSuccess() {
        if (this.responseBundle.containsKey("NUM_SUCCESS")) {
            return Integer.valueOf(this.responseBundle.getInt("NUM_SUCCESS"));
        }
        return null;
    }

    public final CallingAppInfoParcelable getProviderAppInfo() {
        return (CallingAppInfoParcelable) this.responseBundle.getParcelable("PROVIDER_APP_INFO");
    }

    public final Bundle getResponseBundle() {
        return this.responseBundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ExportCredentialsToDeviceSetupResponseCreator.writeToParcel(this, dest, flags);
    }
}
