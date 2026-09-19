package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.credentials.GetCustomCredentialOption;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.identity_googleid.zzg;
import com.google.android.gms.internal.identity_googleid.zzj;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption;", "Landroidx/credentials/GetCustomCredentialOption;", "serverClientId", "", "hostedDomainFilter", "nonce", "claims", "", "Lcom/google/android/libraries/identity/googleid/Claim;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getServerClientId", "()Ljava/lang/String;", "getHostedDomainFilter", "getNonce", "getClaims", "()Ljava/util/List;", "Companion", "Builder", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSignInWithGoogleOption extends GetCustomCredentialOption {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final List zzd;

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u0014\u0010\f\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption$Builder;", "", "serverClientId", "", "<init>", "(Ljava/lang/String;)V", "hostedDomainFilter", "nonce", "claims", "", "Lcom/google/android/libraries/identity/googleid/Claim;", "setHostedDomainFilter", "setClaims", "setNonce", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption;", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final String zza;
        private String zzb;
        private String zzc;
        private List zzd;

        public Builder(String serverClientId) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            this.zza = serverClientId;
        }

        public final GetSignInWithGoogleOption build() {
            return new GetSignInWithGoogleOption(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public final Builder setClaims(List<Claim> claims) {
            Intrinsics.checkNotNullParameter(claims, "claims");
            this.zzd = claims;
            return this;
        }

        public final Builder setHostedDomainFilter(String hostedDomainFilter) {
            Intrinsics.checkNotNullParameter(hostedDomainFilter, "hostedDomainFilter");
            this.zzb = hostedDomainFilter;
            return this;
        }

        public final Builder setNonce(String nonce) {
            this.zzc = nonce;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0001¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0007J\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\b#R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003¨\u0006$"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption$Companion;", "", "<init>", "()V", "BUNDLE_KEY_SERVER_CLIENT_ID", "", "getBUNDLE_KEY_SERVER_CLIENT_ID$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_NONCE", "getBUNDLE_KEY_NONCE$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_HOSTED_DOMAIN_FILTER", "getBUNDLE_KEY_HOSTED_DOMAIN_FILTER$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_AUTO_SELECT_ENABLED", "getBUNDLE_KEY_AUTO_SELECT_ENABLED$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIMS", "getBUNDLE_KEY_CLAIMS$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIM_PREFIX", "getBUNDLE_KEY_CLAIM_PREFIX$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIMS_SIZE", "getBUNDLE_KEY_CLAIMS_SIZE$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "toBundle", "Landroid/os/Bundle;", "serverClientId", "hostedDomainFilter", "nonce", "autoSelectEnabled", "", "claims", "", "Lcom/google/android/libraries/identity/googleid/Claim;", "toBundle$java_com_google_android_libraries_identity_googleid_granule_granule", "createFrom", "Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption;", "data", "parseClaims", "claimsBundle", "parseClaims$java_com_google_android_libraries_identity_googleid_granule_granule", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
            throw null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        public static final Bundle zza(String serverClientId, String str, String str2, boolean z, List list) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID", serverClientId);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE", str2);
            bundle.putString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER", str);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_AUTO_SELECT_ENABLED", true);
            bundle.putString(GoogleIdTokenCredential.BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE, GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL);
            if (list != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIMS_SIZE", list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundle2.putBundle("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIM_PREFIX" + i, Claim.Companion.zza((Claim) list.get(i)));
                }
                bundle.putBundle("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIMS", bundle2);
            }
            return bundle;
        }

        @JvmStatic
        public final GetSignInWithGoogleOption createFrom(Bundle data) throws GoogleIdTokenParsingException {
            zzj zzjVarZzb;
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_SERVER_CLIENT_ID");
                Intrinsics.checkNotNull(string);
                String string2 = data.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_NONCE");
                String string3 = data.getString("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_HOSTED_DOMAIN_FILTER");
                Bundle bundle = data.getBundle("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIMS");
                if (bundle == null) {
                    zzjVarZzb = null;
                } else {
                    int i = bundle.getInt("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIMS_SIZE");
                    int i2 = zzj.zzd;
                    zzg zzgVar = new zzg();
                    Intrinsics.checkNotNullExpressionValue(zzgVar, "builder(...)");
                    for (int i3 = 0; i3 < i; i3++) {
                        Bundle bundle2 = bundle.getBundle("com.google.android.libraries.identity.googleid.siwg.BUNDLE_KEY_CLAIM_PREFIX" + i3);
                        if (bundle2 != null) {
                            zzgVar.zza(Claim.INSTANCE.createFrom(bundle2));
                        }
                    }
                    zzjVarZzb = zzgVar.zzb();
                }
                return new GetSignInWithGoogleOption(string, string3, string2, zzjVarZzb);
            } catch (Exception e) {
                throw new GoogleIdTokenParsingException(e);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(String serverClientId) {
        this(serverClientId, null, null, null, 14, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(String serverClientId, String str) {
        this(serverClientId, str, null, null, 12, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(String serverClientId, String str, String str2) {
        this(serverClientId, str, str2, null, 8, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSignInWithGoogleOption(String serverClientId, String str, String str2, List<Claim> list) {
        super(GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL, Companion.zza(serverClientId, str, str2, true, list), Companion.zza(serverClientId, str, str2, true, list), true, true, null, 32, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
        this.zza = serverClientId;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = list;
        if (serverClientId.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
    }

    @JvmStatic
    public static final GetSignInWithGoogleOption createFrom(Bundle bundle) {
        return INSTANCE.createFrom(bundle);
    }

    public final List<Claim> getClaims() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: getHostedDomainFilter, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: getNonce, reason: from getter */
    public final String getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: getServerClientId, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    public /* synthetic */ GetSignInWithGoogleOption(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, null);
    }
}
