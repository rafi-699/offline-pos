package androidx.credentials.provider;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.credentials.provider.utils.PrivilegedApp;
import androidx.credentials.provider.utils.RequestValidationUtil;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallingAppInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\u000bB+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\rH\u0002J\u0016\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 H\u0002J\u0013\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b8\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo;", "", "packageName", "", "origin", "signingInfoCompat", "Landroidx/credentials/provider/SigningInfoCompat;", "signingInfo", "Landroid/content/pm/SigningInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/credentials/provider/SigningInfoCompat;Landroid/content/pm/SigningInfo;)V", "(Ljava/lang/String;Landroid/content/pm/SigningInfo;Ljava/lang/String;)V", "signatures", "", "Landroid/content/pm/Signature;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getOrigin$credentials", "getSigningInfoCompat", "()Landroidx/credentials/provider/SigningInfoCompat;", "value", "getSigningInfo", "()Landroid/content/pm/SigningInfo;", "getOrigin", "privilegedAllowlist", "isOriginPopulated", "", "isAppPrivileged", "candidateApps", "Landroidx/credentials/provider/utils/PrivilegedApp;", "candidateFingerprints", "", "equals", "other", "hashCode", "", "Companion", "SignatureVerifier", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallingAppInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_CREDENTIAL_REQUEST_ORIGIN = "androidx.credentials.provider.extra.CREDENTIAL_REQUEST_ORIGIN";
    private static final String EXTRA_CREDENTIAL_REQUEST_PACKAGE_NAME = "androidx.credentials.provider.extra.CREDENTIAL_REQUEST_PACKAGE_NAME";
    private static final String EXTRA_CREDENTIAL_REQUEST_SIGNATURES = "androidx.credentials.provider.extra.CREDENTIAL_REQUEST_SIGNATURES";
    private static final String EXTRA_CREDENTIAL_REQUEST_SIGNING_INFO = "androidx.credentials.provider.extra.CREDENTIAL_REQUEST_SIGNING_INFO";
    private final String origin;
    private final String packageName;
    private SigningInfo signingInfo;
    private final SigningInfoCompat signingInfoCompat;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String packageName, SigningInfo signingInfo) {
        this(packageName, signingInfo, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String packageName, List<? extends Signature> signatures) {
        this(packageName, signatures, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
    }

    private CallingAppInfo(String str, String str2, SigningInfoCompat signingInfoCompat, SigningInfo signingInfo) {
        this.packageName = str;
        this.origin = str2;
        this.signingInfoCompat = signingInfoCompat;
        if (Build.VERSION.SDK_INT >= 28) {
            Intrinsics.checkNotNull(signingInfo);
            this.signingInfo = signingInfo;
        }
        if (str.length() <= 0) {
            throw new IllegalArgumentException("packageName must not be empty".toString());
        }
    }

    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: getOrigin$credentials, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    public final SigningInfoCompat getSigningInfoCompat() {
        return this.signingInfoCompat;
    }

    public final SigningInfo getSigningInfo() {
        SigningInfo signingInfo = this.signingInfo;
        if (signingInfo != null) {
            return signingInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("signingInfo");
        return null;
    }

    public /* synthetic */ CallingAppInfo(String str, SigningInfo signingInfo, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, signingInfo, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String packageName, SigningInfo signingInfo, String str) {
        this(packageName, str, SigningInfoCompat.INSTANCE.fromSigningInfo(signingInfo), signingInfo);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
    }

    public /* synthetic */ CallingAppInfo(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (List<? extends Signature>) list, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallingAppInfo(String packageName, List<? extends Signature> signatures, String str) {
        this(packageName, str, SigningInfoCompat.INSTANCE.fromSignatures(signatures), null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
    }

    /* JADX INFO: compiled from: CallingAppInfo.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0014H\u0007R\u000e\u0010\u000e\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo$Companion;", "", "<init>", "()V", "create", "Landroidx/credentials/provider/CallingAppInfo;", "packageName", "", "signingInfo", "Landroid/content/pm/SigningInfo;", "origin", "signatures", "", "Landroid/content/pm/Signature;", "EXTRA_CREDENTIAL_REQUEST_ORIGIN", "EXTRA_CREDENTIAL_REQUEST_PACKAGE_NAME", "EXTRA_CREDENTIAL_REQUEST_SIGNING_INFO", "EXTRA_CREDENTIAL_REQUEST_SIGNATURES", "setCallingAppInfo", "", "Landroid/os/Bundle;", "info", "setCallingAppInfo$credentials", "extractCallingAppInfo", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CallingAppInfo create$default(Companion companion, String str, SigningInfo signingInfo, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.create(str, signingInfo, str2);
        }

        public final CallingAppInfo create(String packageName, SigningInfo signingInfo, String origin) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
            return new CallingAppInfo(packageName, signingInfo, origin);
        }

        public static /* synthetic */ CallingAppInfo create$default(Companion companion, String str, List list, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.create(str, (List<? extends Signature>) list, str2);
        }

        public final CallingAppInfo create(String packageName, List<? extends Signature> signatures, String origin) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(signatures, "signatures");
            return new CallingAppInfo(packageName, signatures, origin);
        }

        public final void setCallingAppInfo$credentials(Bundle bundle, CallingAppInfo info) {
            Intrinsics.checkNotNullParameter(bundle, "<this>");
            Intrinsics.checkNotNullParameter(info, "info");
            bundle.putString(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_ORIGIN, info.getOrigin());
            bundle.putString(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_PACKAGE_NAME, info.getPackageName());
            if (Build.VERSION.SDK_INT >= 28) {
                bundle.putParcelable(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_SIGNING_INFO, info.getSigningInfo());
            } else {
                bundle.putParcelableArray(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_SIGNATURES, (Parcelable[]) info.getSigningInfoCompat().getSigningCertificateHistory().toArray(new Signature[0]));
            }
        }

        public final CallingAppInfo extractCallingAppInfo(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_ORIGIN);
            String string2 = bundle.getString(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_PACKAGE_NAME);
            if (string2 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = (SigningInfo) bundle.getParcelable(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_SIGNING_INFO);
                if (signingInfo == null) {
                    return null;
                }
                return create(string2, signingInfo, string);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_SIGNATURES);
            if (parcelableArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type android.content.pm.Signature");
                arrayList.add((Signature) parcelable);
            }
            return create(string2, arrayList, string);
        }
    }

    public final String getOrigin(String privilegedAllowlist) {
        Intrinsics.checkNotNullParameter(privilegedAllowlist, "privilegedAllowlist");
        if (!RequestValidationUtil.INSTANCE.isValidJSON(privilegedAllowlist)) {
            throw new IllegalArgumentException("privilegedAllowlist must not be empty, and must be a valid JSON");
        }
        String str = this.origin;
        if (str == null) {
            return str;
        }
        try {
            if (isAppPrivileged(PrivilegedApp.INSTANCE.extractPrivilegedApps$credentials(new JSONObject(privilegedAllowlist)))) {
                return this.origin;
            }
            throw new IllegalStateException("Origin is not being returned as the calling app did notmatch the privileged allowlist");
        } catch (JSONException unused) {
            throw new IllegalArgumentException("privilegedAllowlist must be formatted properly");
        }
    }

    public final boolean isOriginPopulated() {
        return this.origin != null;
    }

    private final boolean isAppPrivileged(List<PrivilegedApp> candidateApps) {
        for (PrivilegedApp privilegedApp : candidateApps) {
            if (Intrinsics.areEqual(privilegedApp.getPackageName(), this.packageName)) {
                return isAppPrivileged(privilegedApp.getFingerprints());
            }
        }
        return false;
    }

    private final boolean isAppPrivileged(Set<String> candidateFingerprints) {
        return new SignatureVerifier(this.signingInfoCompat).verifySignatureFingerprints(candidateFingerprints);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CallingAppInfo.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo$SignatureVerifier;", "", "signingInfoCompat", "Landroidx/credentials/provider/SigningInfoCompat;", "<init>", "(Landroidx/credentials/provider/SigningInfoCompat;)V", "getSignatureFingerprints", "", "", "convertToFingerprints", "signatures", "", "Landroid/content/pm/Signature;", "verifySignatureFingerprints", "", "candidateSigFingerprints", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class SignatureVerifier {
        private final SigningInfoCompat signingInfoCompat;

        public SignatureVerifier(SigningInfoCompat signingInfoCompat) {
            Intrinsics.checkNotNullParameter(signingInfoCompat, "signingInfoCompat");
            this.signingInfoCompat = signingInfoCompat;
        }

        private final Set<String> getSignatureFingerprints() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            List<Signature> apkContentsSigners = this.signingInfoCompat.getApkContentsSigners();
            if (this.signingInfoCompat.getHasMultipleSigners() && !apkContentsSigners.isEmpty()) {
                linkedHashSet.addAll(convertToFingerprints(apkContentsSigners));
                return linkedHashSet;
            }
            if (!this.signingInfoCompat.getSigningCertificateHistory().isEmpty()) {
                linkedHashSet.addAll(convertToFingerprints(CollectionsKt.listOf(this.signingInfoCompat.getSigningCertificateHistory().get(0))));
            }
            return linkedHashSet;
        }

        private final Set<String> convertToFingerprints(List<? extends Signature> signatures) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<? extends Signature> it = signatures.iterator();
            while (it.hasNext()) {
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(it.next().toByteArray());
                Intrinsics.checkNotNull(bArrDigest);
                linkedHashSet.add(ArraysKt.joinToString$default(bArrDigest, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: androidx.credentials.provider.CallingAppInfo$SignatureVerifier$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CallingAppInfo.SignatureVerifier.convertToFingerprints$lambda$0(((Byte) obj).byteValue());
                    }
                }, 30, (Object) null));
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence convertToFingerprints$lambda$0(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final boolean verifySignatureFingerprints(Set<String> candidateSigFingerprints) {
            Intrinsics.checkNotNullParameter(candidateSigFingerprints, "candidateSigFingerprints");
            Set<String> signatureFingerprints = getSignatureFingerprints();
            if (this.signingInfoCompat.getHasMultipleSigners()) {
                return candidateSigFingerprints.containsAll(signatureFingerprints);
            }
            return !CollectionsKt.intersect(candidateSigFingerprints, signatureFingerprints).isEmpty();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallingAppInfo)) {
            return false;
        }
        CallingAppInfo callingAppInfo = (CallingAppInfo) other;
        return Intrinsics.areEqual(this.packageName, callingAppInfo.packageName) && Intrinsics.areEqual(this.origin, callingAppInfo.origin) && Intrinsics.areEqual(this.signingInfoCompat, callingAppInfo.signingInfoCompat);
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode() * 31;
        String str = this.origin;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.signingInfoCompat.hashCode();
    }
}
