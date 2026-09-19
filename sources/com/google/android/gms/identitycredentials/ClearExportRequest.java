package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/google/android/gms/identitycredentials/ClearExportRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "deleteAll", "", "registryIds", "", "", "<init>", "(ZLjava/util/List;)V", "getDeleteAll", "()Z", "getRegistryIds", "()Ljava/util/List;", "clearRegistryOption", "Lcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;", "getClearRegistryOption", "()Lcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SafeParcelable.Class(creator = "ClearExportRequestCreator")
public final class ClearExportRequest extends AbstractSafeParcelable {
    private final ClearRegistryRequest.ClearTypedRegistryOption clearRegistryOption;

    @SafeParcelable.Field(getter = "getDeleteAll", id = 1)
    private final boolean deleteAll;

    @SafeParcelable.Field(getter = "getRegistryIds", id = 2)
    private final List<String> registryIds;
    public static final Parcelable.Creator<ClearExportRequest> CREATOR = new ClearExportRequestCreator();

    @SafeParcelable.Constructor
    public ClearExportRequest(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) List<String> registryIds) {
        Intrinsics.checkNotNullParameter(registryIds, "registryIds");
        this.deleteAll = z;
        this.registryIds = registryIds;
        this.clearRegistryOption = new ClearRegistryRequest.ClearTypedRegistryOption(z, "androidx.identitycredentials.TYPE_CREDENTIALS_SYNC", false, registryIds);
    }

    public final ClearRegistryRequest.ClearTypedRegistryOption getClearRegistryOption() {
        return this.clearRegistryOption;
    }

    public final boolean getDeleteAll() {
        return this.deleteAll;
    }

    public final List<String> getRegistryIds() {
        return this.registryIds;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ClearExportRequestCreator.writeToParcel(this, dest, flags);
    }
}
