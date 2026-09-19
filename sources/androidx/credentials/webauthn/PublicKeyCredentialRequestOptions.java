package androidx.credentials.webauthn;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.polidea.rxandroidble2.ClientComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PublicKeyCredentialRequestOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialRequestOptions;", "", "requestJson", "", "<init>", "(Ljava/lang/String;)V", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", ClientData.KEY_CHALLENGE, "", "getChallenge", "()[B", ClientComponent.NamedSchedulers.TIMEOUT, "", "getTimeout", "()J", "rpId", "getRpId", "()Ljava/lang/String;", "userVerification", "getUserVerification", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PublicKeyCredentialRequestOptions {
    private final byte[] challenge;
    private final JSONObject json;
    private final String rpId;
    private final long timeout;
    private final String userVerification;

    public PublicKeyCredentialRequestOptions(String requestJson) throws JSONException {
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        JSONObject jSONObject = new JSONObject(requestJson);
        this.json = jSONObject;
        String string = jSONObject.getString(ClientData.KEY_CHALLENGE);
        WebAuthnUtils.Companion companion = WebAuthnUtils.INSTANCE;
        Intrinsics.checkNotNull(string);
        this.challenge = companion.b64Decode(string);
        this.timeout = jSONObject.optLong(ClientComponent.NamedSchedulers.TIMEOUT, 0L);
        String strOptString = jSONObject.optString("rpId", "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        this.rpId = strOptString;
        String strOptString2 = jSONObject.optString("userVerification", "preferred");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        this.userVerification = strOptString2;
    }

    public final JSONObject getJson() {
        return this.json;
    }

    public final byte[] getChallenge() {
        return this.challenge;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final String getRpId() {
        return this.rpId;
    }

    public final String getUserVerification() {
        return this.userVerification;
    }
}
