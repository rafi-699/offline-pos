package com.google.android.gms.identitycredentials;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B'\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/google/android/gms/identitycredentials/ImportCredentialsForDeviceSetupRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "Lcom/google/android/gms/common/internal/ReflectedParcelable;", "requestJson", "", "uri", "Landroid/net/Uri;", "requestData", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Landroid/os/Bundle;)V", "getRequestJson", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "getRequestData", "()Landroid/os/Bundle;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SafeParcelable.Class(creator = "ImportCredentialsForDeviceSetupRequestCreator")
public final class ImportCredentialsForDeviceSetupRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @SafeParcelable.Field(getter = "getRequestData", id = 3)
    private final Bundle requestData;

    @SafeParcelable.Field(getter = "getRequestJson", id = 1)
    private final String requestJson;

    @SafeParcelable.Field(getter = "getUri", id = 2)
    private final Uri uri;
    public static final Parcelable.Creator<ImportCredentialsForDeviceSetupRequest> CREATOR = new ImportCredentialsForDeviceSetupRequestCreator();

    @SafeParcelable.Constructor
    public ImportCredentialsForDeviceSetupRequest(@SafeParcelable.Param(id = 1) String requestJson, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) Bundle requestData) {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        this.requestJson = requestJson;
        this.uri = uri;
        this.requestData = requestData;
    }

    public final Bundle getRequestData() {
        return this.requestData;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ImportCredentialsForDeviceSetupRequestCreator.writeToParcel(this, dest, flags);
    }
}
