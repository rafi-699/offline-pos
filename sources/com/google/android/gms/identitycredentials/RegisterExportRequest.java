package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/google/android/gms/identitycredentials/RegisterExportRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "matcher", "", "data", "id", "", "<init>", "([B[BLjava/lang/String;)V", "getMatcher", "()[B", "getData", "getId", "()Ljava/lang/String;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SafeParcelable.Class(creator = "RegisterExportRequestCreator")
public final class RegisterExportRequest extends AbstractSafeParcelable {
    public static final String REQUEST_TYPE = "androidx.identitycredentials.TYPE_CREDENTIALS_SYNC";

    @SafeParcelable.Field(getter = "getData", id = 2)
    private final byte[] data;

    @SafeParcelable.Field(getter = "getId", id = 3)
    private final String id;

    @SafeParcelable.Field(getter = "getMatcher", id = 1)
    private final byte[] matcher;
    public static final Parcelable.Creator<RegisterExportRequest> CREATOR = new RegisterExportRequestCreator();

    @SafeParcelable.Constructor
    public RegisterExportRequest(@SafeParcelable.Param(id = 1) byte[] matcher, @SafeParcelable.Param(id = 2) byte[] data, @SafeParcelable.Param(id = 3) String id) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(id, "id");
        this.matcher = matcher;
        this.data = data;
        this.id = id;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getId() {
        return this.id;
    }

    public final byte[] getMatcher() {
        return this.matcher;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        RegisterExportRequestCreator.writeToParcel(this, dest, flags);
    }
}
