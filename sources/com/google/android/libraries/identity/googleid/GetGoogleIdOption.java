package com.google.android.libraries.identity.googleid;

import android.os.Bundle;
import androidx.credentials.GetCustomCredentialOption;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.identity_googleid.zzg;
import com.google.android.gms.internal.identity_googleid.zzj;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eBw\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "Landroidx/credentials/GetCustomCredentialOption;", "serverClientId", "", "nonce", "filterByAuthorizedAccounts", "", "linkedServiceId", "idTokenDepositionScopes", "", "requestVerifiedPhoneNumber", "autoSelectEnabled", "claims", "Lcom/google/android/libraries/identity/googleid/Claim;", "hostedDomainFilter", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;ZZLjava/util/List;Ljava/lang/String;)V", "getServerClientId", "()Ljava/lang/String;", "getNonce", "getFilterByAuthorizedAccounts", "()Z", "getLinkedServiceId", "getIdTokenDepositionScopes", "()Ljava/util/List;", "getRequestVerifiedPhoneNumber", "getAutoSelectEnabled", "getClaims", "getHostedDomainFilter", "Companion", "Builder", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetGoogleIdOption extends GetCustomCredentialOption {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private final String zzd;
    private final List zze;
    private final boolean zzf;
    private final boolean zzg;
    private final List zzh;
    private final String zzi;

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rJ\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption$Builder;", "", "<init>", "()V", "serverClientId", "", "linkedServiceId", "nonce", "filterByAuthorizedAccounts", "", "requestVerifiedPhoneNumber", "autoSelectEnabled", "idTokenDepositionScopes", "", "claims", "Lcom/google/android/libraries/identity/googleid/Claim;", "hostedDomainFilter", "setServerClientId", "setNonce", "setFilterByAuthorizedAccounts", "setRequestVerifiedPhoneNumber", "setAutoSelectEnabled", "associateLinkedAccounts", "setClaims", "setHostedDomainFilter", InAppPurchaseConstants.METHOD_BUILD, "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private String zzb;
        private String zzc;
        private boolean zze;
        private boolean zzf;
        private List zzg;
        private List zzh;
        private String zzi;
        private String zza = "";
        private boolean zzd = true;

        public final Builder associateLinkedAccounts(String linkedServiceId, List<String> idTokenDepositionScopes) {
            Intrinsics.checkNotNullParameter(linkedServiceId, "linkedServiceId");
            if (linkedServiceId.length() <= 0) {
                throw new IllegalArgumentException("linkedServiceId must be provided if you want to associate linked accounts.");
            }
            this.zzb = linkedServiceId;
            this.zzg = idTokenDepositionScopes != null ? CollectionsKt.toList(idTokenDepositionScopes) : null;
            return this;
        }

        public final GetGoogleIdOption build() {
            return new GetGoogleIdOption(this.zza, this.zzc, this.zzd, this.zzb, this.zzg, this.zze, this.zzf, this.zzh, this.zzi);
        }

        public final Builder setAutoSelectEnabled(boolean autoSelectEnabled) {
            this.zzf = autoSelectEnabled;
            return this;
        }

        public final Builder setClaims(List<Claim> claims) {
            Intrinsics.checkNotNullParameter(claims, "claims");
            this.zzh = claims;
            return this;
        }

        public final Builder setFilterByAuthorizedAccounts(boolean filterByAuthorizedAccounts) {
            this.zzd = filterByAuthorizedAccounts;
            return this;
        }

        public final Builder setHostedDomainFilter(String hostedDomainFilter) {
            this.zzi = hostedDomainFilter;
            return this;
        }

        public final Builder setNonce(String nonce) {
            this.zzc = nonce;
            return this;
        }

        public final Builder setRequestVerifiedPhoneNumber(boolean requestVerifiedPhoneNumber) {
            this.zze = requestVerifiedPhoneNumber;
            return this;
        }

        public final Builder setServerClientId(String serverClientId) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            if (serverClientId.length() <= 0) {
                throw new IllegalArgumentException("serverClientId should not be empty");
            }
            this.zza = serverClientId;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jk\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00052\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010#2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cH\u0007J\u001f\u0010-\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010#2\b\u0010.\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0002\b/R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0003¨\u00060"}, d2 = {"Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption$Companion;", "", "<init>", "()V", "BUNDLE_KEY_SERVER_CLIENT_ID", "", "getBUNDLE_KEY_SERVER_CLIENT_ID$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_NONCE", "getBUNDLE_KEY_NONCE$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", "getBUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_LINKED_SERVICE_ID", "getBUNDLE_KEY_LINKED_SERVICE_ID$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES", "getBUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", "getBUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_AUTO_SELECT_ENABLED", "getBUNDLE_KEY_AUTO_SELECT_ENABLED$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIMS", "getBUNDLE_KEY_CLAIMS$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIM_PREFIX", "getBUNDLE_KEY_CLAIM_PREFIX$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_CLAIMS_SIZE", "getBUNDLE_KEY_CLAIMS_SIZE$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "BUNDLE_KEY_HOSTED_DOMAIN_FILTER", "getBUNDLE_KEY_HOSTED_DOMAIN_FILTER$java_com_google_android_libraries_identity_googleid_granule_granule$annotations", "toBundle", "Landroid/os/Bundle;", "serverClientId", "nonce", "filterByAuthorizedAccounts", "", "linkedServiceId", "idTokenDepositionScopes", "", "requestVerifiedPhoneNumber", "autoSelectEnabled", "claims", "Lcom/google/android/libraries/identity/googleid/Claim;", "hostedDomainFilter", "toBundle$java_com_google_android_libraries_identity_googleid_granule_granule", "createFrom", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "data", "parseClaims", "claimsBundle", "parseClaims$java_com_google_android_libraries_identity_googleid_granule_granule", "java.com.google.android.libraries.identity.googleid.granule_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
            throw null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        public static final Bundle zza(String serverClientId, String str, boolean z, String str2, List list, boolean z2, boolean z3, List list2, String str3) {
            Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID", serverClientId);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE", str);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", z);
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID", str2);
            bundle.putStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES", list == null ? null : new ArrayList<>(list));
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", z2);
            bundle.putBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", z3);
            if (list2 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIMS_SIZE", list2.size());
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    bundle2.putBundle("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_PREFIX" + i, Claim.Companion.zza((Claim) list2.get(i)));
                }
                bundle.putBundle("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIMS", bundle2);
            }
            bundle.putString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_HOSTED_DOMAIN_FILTER", str3);
            return bundle;
        }

        @JvmStatic
        public final GetGoogleIdOption createFrom(Bundle data) throws GoogleIdTokenParsingException {
            zzj zzjVarZzb;
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_SERVER_CLIENT_ID");
                Intrinsics.checkNotNull(string);
                String string2 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_NONCE");
                boolean z = data.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FILTER_BY_AUTHORIZED_ACCOUNTS", true);
                String string3 = data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_LINKED_SERVICE_ID");
                ArrayList<String> stringArrayList = data.getStringArrayList("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN_DEPOSITION_SCOPES");
                boolean z2 = data.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_REQUEST_VERIFIED_PHONE_NUMBER", false);
                boolean z3 = data.getBoolean("com.google.android.libraries.identity.googleid.BUNDLE_KEY_AUTO_SELECT_ENABLED", false);
                Bundle bundle = data.getBundle("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIMS");
                if (bundle == null) {
                    zzjVarZzb = null;
                } else {
                    int i = bundle.getInt("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIMS_SIZE");
                    int i2 = zzj.zzd;
                    zzg zzgVar = new zzg();
                    Intrinsics.checkNotNullExpressionValue(zzgVar, "builder(...)");
                    for (int i3 = 0; i3 < i; i3++) {
                        Bundle bundle2 = bundle.getBundle("com.google.android.libraries.identity.googleid.BUNDLE_KEY_CLAIM_PREFIX" + i3);
                        if (bundle2 != null) {
                            zzgVar.zza(Claim.INSTANCE.createFrom(bundle2));
                        }
                    }
                    zzjVarZzb = zzgVar.zzb();
                }
                return new GetGoogleIdOption(string, string2, z, string3, stringArrayList, z2, z3, zzjVarZzb, data.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_HOSTED_DOMAIN_FILTER"));
            } catch (Exception e) {
                throw new GoogleIdTokenParsingException(e);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId) {
        this(serverClientId, null, false, null, null, false, false, null, null, Videoio.CAP_PROP_XI_DEBOUNCE_POL, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str) {
        this(serverClientId, str, false, null, null, false, false, null, null, Videoio.CAP_PROP_XI_DEBOUNCE_T0, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z) {
        this(serverClientId, str, z, null, null, false, false, null, null, 504, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2) {
        this(serverClientId, str, z, str2, null, false, false, null, null, 496, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2, List<String> list) {
        this(serverClientId, str, z, str2, list, false, false, null, null, Videoio.CAP_PROP_XI_CC_MATRIX_01, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2, List<String> list, boolean z2) {
        this(serverClientId, str, z, str2, list, z2, false, null, null, Videoio.CAP_PROP_XI_WB_KR, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2, List<String> list, boolean z2, boolean z3) {
        this(serverClientId, str, z, str2, list, z2, z3, null, null, 384, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2, List<String> list, boolean z2, boolean z3, List<Claim> list2) {
        this(serverClientId, str, z, str2, list, z2, z3, list2, null, 256, null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetGoogleIdOption(String serverClientId, String str, boolean z, String str2, List<String> list, boolean z2, boolean z3, List<Claim> list2, String str3) {
        super(GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL, Companion.zza(serverClientId, str, z, str2, list, z2, z3, list2, str3), Companion.zza(serverClientId, str, z, str2, list, z2, z3, list2, str3), true, z3, (Set) null, 500, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(serverClientId, "serverClientId");
        this.zza = serverClientId;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = list;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = list2;
        this.zzi = str3;
        if (serverClientId.length() <= 0) {
            throw new IllegalArgumentException("serverClientId should not be empty");
        }
        if (z && z2) {
            throw new IllegalArgumentException("filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true;  the Verified Phone Number feature only works in sign-ups.");
        }
    }

    @JvmStatic
    public static final GetGoogleIdOption createFrom(Bundle bundle) {
        return INSTANCE.createFrom(bundle);
    }

    /* JADX INFO: renamed from: getAutoSelectEnabled, reason: from getter */
    public final boolean getZzg() {
        return this.zzg;
    }

    public final List<Claim> getClaims() {
        return this.zzh;
    }

    /* JADX INFO: renamed from: getFilterByAuthorizedAccounts, reason: from getter */
    public final boolean getZzc() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: getHostedDomainFilter, reason: from getter */
    public final String getZzi() {
        return this.zzi;
    }

    public final List<String> getIdTokenDepositionScopes() {
        return this.zze;
    }

    /* JADX INFO: renamed from: getLinkedServiceId, reason: from getter */
    public final String getZzd() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: getNonce, reason: from getter */
    public final String getZzb() {
        return this.zzb;
    }

    /* JADX INFO: renamed from: getRequestVerifiedPhoneNumber, reason: from getter */
    public final boolean getZzf() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: getServerClientId, reason: from getter */
    public final String getZza() {
        return this.zza;
    }

    public /* synthetic */ GetGoogleIdOption(String str, String str2, boolean z, String str3, List list, boolean z2, boolean z3, List list2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, z | (!((i & 4) == 0)), (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : list, ((i & 32) == 0) & z2, ((i & 64) == 0) & z3, (i & 128) == 0 ? list2 : null, null);
    }
}
