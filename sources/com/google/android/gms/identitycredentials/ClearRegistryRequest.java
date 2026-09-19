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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u001f\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/google/android/gms/identitycredentials/ClearRegistryRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "deleteAll", "", "clearTypedRegistryOption", "Lcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;", "<init>", "(ZLcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;)V", "()V", "getDeleteAll", "()Z", "getClearTypedRegistryOption", "()Lcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "ClearTypedRegistryOption", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SafeParcelable.Class(creator = "ClearRegistryRequestCreator")
public final class ClearRegistryRequest extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getClearTypedRegistryOption", id = 2)
    private final ClearTypedRegistryOption clearTypedRegistryOption;

    @SafeParcelable.Field(defaultValue = "true", getter = "getDeleteAll", id = 1)
    private final boolean deleteAll;
    public static final Parcelable.Creator<ClearRegistryRequest> CREATOR = new ClearRegistryRequestCreator();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B7\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/google/android/gms/identitycredentials/ClearRegistryRequest$ClearTypedRegistryOption;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "deleteAllForType", "", "type", "", "deleteIdlessRegistry", "registryIds", "", "<init>", "(ZLjava/lang/String;ZLjava/util/List;)V", "getDeleteAllForType", "()Z", "getType", "()Ljava/lang/String;", "getDeleteIdlessRegistry", "getRegistryIds", "()Ljava/util/List;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SafeParcelable.Class(creator = "ClearTypedRegistryOptionCreator")
    public static final class ClearTypedRegistryOption extends AbstractSafeParcelable {

        @SafeParcelable.Field(getter = "getDeleteAllForType", id = 1)
        private final boolean deleteAllForType;

        @SafeParcelable.Field(getter = "getDeleteIdlessRegistry", id = 3)
        private final boolean deleteIdlessRegistry;

        @SafeParcelable.Field(getter = "getRegistryIds", id = 4)
        private final List<String> registryIds;

        @SafeParcelable.Field(getter = "getType", id = 2)
        private final String type;
        public static final Parcelable.Creator<ClearTypedRegistryOption> CREATOR = new ClearTypedRegistryOptionCreator();

        @SafeParcelable.Constructor
        public ClearTypedRegistryOption(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String type, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) List<String> registryIds) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(registryIds, "registryIds");
            this.deleteAllForType = z;
            this.type = type;
            this.deleteIdlessRegistry = z2;
            this.registryIds = registryIds;
        }

        public final boolean getDeleteAllForType() {
            return this.deleteAllForType;
        }

        public final boolean getDeleteIdlessRegistry() {
            return this.deleteIdlessRegistry;
        }

        public final List<String> getRegistryIds() {
            return this.registryIds;
        }

        public final String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            ClearTypedRegistryOptionCreator.writeToParcel(this, dest, flags);
        }
    }

    public ClearRegistryRequest() {
        this(true, null);
    }

    public final ClearTypedRegistryOption getClearTypedRegistryOption() {
        return this.clearTypedRegistryOption;
    }

    public final boolean getDeleteAll() {
        return this.deleteAll;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        ClearRegistryRequestCreator.writeToParcel(this, dest, flags);
    }

    @SafeParcelable.Constructor
    public ClearRegistryRequest(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) ClearTypedRegistryOption clearTypedRegistryOption) {
        this.deleteAll = z;
        this.clearTypedRegistryOption = clearTypedRegistryOption;
    }
}
