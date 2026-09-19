package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/google/android/libraries/identity/googleid/Claim;", "", "name", "", "essential", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getEssential", "()Z", "equals", "other", "hashCode", "", "Companion", "Builder", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Claim {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String zza;
    private final boolean zzb;

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/android/libraries/identity/googleid/Claim$Builder;", "", "<init>", "()V", "name", "", "essential", "", "setName", "setEssential", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/android/libraries/identity/googleid/Claim;", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private String zza = "";
        private boolean zzb;

        public final Claim build() {
            return new Claim(this.zza, this.zzb);
        }

        public final Builder setEssential(boolean essential) {
            this.zzb = essential;
            return this;
        }

        public final Builder setName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.zza = name;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\u000f"}, d2 = {"Lcom/google/android/libraries/identity/googleid/Claim$Companion;", "", "<init>", "()V", "BUNDLE_KEY_CLAIM_NAME", "", "getBUNDLE_KEY_CLAIM_NAME$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIM_ESSENTIAL", "getBUNDLE_KEY_CLAIM_ESSENTIAL$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "toBundle", "Landroid/os/Bundle;", "claim", "Lcom/google/android/libraries/identity/googleid/Claim;", "createFrom", "data", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
            throw null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        public static final Bundle zza(Claim claim) {
            Intrinsics.checkNotNullParameter(claim, "claim");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_NAME", claim.getZza());
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_ESSENTIAL", claim.getZzb());
            return bundle;
        }

        @JvmStatic
        public final Claim createFrom(Bundle data) throws GoogleIdTokenParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_NAME");
                Intrinsics.checkNotNull(string);
                return new Claim(string, data.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_ESSENTIAL"));
            } catch (Exception e) {
                throw new GoogleIdTokenParsingException(e);
            }
        }
    }

    public Claim(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.zza = name;
        this.zzb = z;
        if (name.length() <= 0) {
            throw new IllegalArgumentException("Claim name should not be empty");
        }
    }

    @JvmStatic
    public static final Claim createFrom(Bundle bundle) {
        return INSTANCE.createFrom(bundle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Claim)) {
            return false;
        }
        Claim claim = (Claim) other;
        return this.zzb == claim.zzb && Intrinsics.areEqual(this.zza, claim.zza);
    }

    /* JADX INFO: renamed from: getEssential, reason: from getter */
    public final boolean getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: getName, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hash(this.zza, Boolean.valueOf(this.zzb));
    }
}
