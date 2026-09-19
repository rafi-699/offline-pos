package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001e\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/google/android/gms/identitycredentials/CallingAppInfoParcelable;", "Landroid/os/Parcelable;", "packageName", "", "packageCertificates", "", "", "origin", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getPackageCertificates", "()Ljava/util/List;", "getOrigin", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "describeContents", "writeByteArrayList", "list", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallingAppInfoParcelable implements Parcelable {
    private final String origin;
    private final List<byte[]> packageCertificates;
    private final String packageName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CallingAppInfoParcelable> CREATOR = new Parcelable.Creator<CallingAppInfoParcelable>() { // from class: com.google.android.gms.identitycredentials.CallingAppInfoParcelable$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallingAppInfoParcelable createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            String string = source.readString();
            ArrayList byteArrayList = CallingAppInfoParcelable.INSTANCE.readByteArrayList(source);
            String string2 = source.readString();
            if (string == null || byteArrayList == null) {
                return null;
            }
            return new CallingAppInfoParcelable(string, byteArrayList, string2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallingAppInfoParcelable[] newArray(int size) {
            return new CallingAppInfoParcelable[size];
        }
    };

    /* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/android/gms/identitycredentials/CallingAppInfoParcelable$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/google/android/gms/identitycredentials/CallingAppInfoParcelable;", "readByteArrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "source", "Landroid/os/Parcel;", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ArrayList<byte[]> readByteArrayList(Parcel source) {
            int i = source.readInt();
            if (i < 0) {
                return null;
            }
            if (i == 0) {
                return new ArrayList<>();
            }
            ArrayList<byte[]> arrayList = new ArrayList<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr = new byte[source.readInt()];
                source.readByteArray(bArr);
                arrayList.add(bArr);
            }
            return arrayList;
        }
    }

    public CallingAppInfoParcelable(String packageName, List<byte[]> packageCertificates, String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(packageCertificates, "packageCertificates");
        this.packageName = packageName;
        this.packageCertificates = packageCertificates;
        this.origin = str;
    }

    private final void writeByteArrayList(List<byte[]> list, Parcel dest) {
        dest.writeInt(list.size());
        for (byte[] bArr : list) {
            dest.writeInt(bArr.length);
            dest.writeByteArray(bArr);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final List<byte[]> getPackageCertificates() {
        return this.packageCertificates;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.packageName);
        writeByteArrayList(this.packageCertificates, dest);
        dest.writeString(this.origin);
    }
}
