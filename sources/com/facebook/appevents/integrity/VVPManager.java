package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VVPManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002?@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\u0017\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\b\u0010)\u001a\u00020\"H\u0007J\b\u0010*\u001a\u00020\"H\u0007J\b\u0010+\u001a\u00020 H\u0007J\r\u0010,\u001a\u00020\"H\u0000¢\u0006\u0002\b-J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0004H\u0002J\u0017\u00102\u001a\u0004\u0018\u00010\u001b2\u0006\u00103\u001a\u00020\u0004H\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020'H\u0002J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020%072\u0006\u00100\u001a\u00020'H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u00100\u001a\u00020'H\u0002J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010<H\u0007J\u0015\u0010=\u001a\u00020\"2\u0006\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\b>R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/facebook/appevents/integrity/VVPManager;", "", "()V", "CONTENTS_KEY", "", "CONTENT_ID_SANITIZE_KEYS", "", "ENABLED_KEY", "EVENT_NAME_SENTINEL", "IN_SCOPE_EVENT_NAMES_KEY", "IS_SHADOW_ENABLED_KEY", "KEY_NEGATIVE_REGEX_KEY", "KEY_REGEX_KEY", "PLACE_CUSTOM_DATA", "", "PLACE_EVENT_NAME", "PLACE_KEY", "RULES_KEY", "SANITIZED_VALUE", "STANDARD_PARAMS_KEY", "VALUE_REGEX_KEY", "VP_RP", "VP_RP_EV", "VVP_IS_APPLIED_KEY", "VVP_IS_APPLIED_VALUE", "VVP_METADATA_KEY", "<set-?>", "Lcom/facebook/appevents/integrity/VVPManager$VVPConfig;", "config", "getConfig$facebook_core_release", "()Lcom/facebook/appevents/integrity/VVPManager$VVPConfig;", "enabled", "", "clearForTests", "", "clearForTests$facebook_core_release", "compileRule", "Lcom/facebook/appevents/integrity/VVPManager$CompiledRule;", "ruleObj", "Lorg/json/JSONObject;", "compileRule$facebook_core_release", "disable", "enable", "isEnabled", "loadConfig", "loadConfig$facebook_core_release", "optRegex", "Ljava/util/regex/Pattern;", "obj", SDKConstants.PARAM_KEY, "parseConfig", "jsonStr", "parseConfig$facebook_core_release", "parseInScopeEventNames", "parseRules", "", "parseStandardParams", "processParametersForVVP", "eventName", "parameters", "Landroid/os/Bundle;", "scrubIdInContentsArray", "scrubIdInContentsArray$facebook_core_release", "CompiledRule", "VVPConfig", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VVPManager {
    private static final String CONTENTS_KEY = "fb_content";
    private static final String ENABLED_KEY = "enabled";
    private static final String EVENT_NAME_SENTINEL = "1";
    private static final String IN_SCOPE_EVENT_NAMES_KEY = "inScopeEventNames";
    private static final String IS_SHADOW_ENABLED_KEY = "isShadowEnabled";
    private static final String KEY_NEGATIVE_REGEX_KEY = "keyNegativeRegex";
    private static final String KEY_REGEX_KEY = "keyRegex";
    public static final int PLACE_CUSTOM_DATA = 1;
    public static final int PLACE_EVENT_NAME = 3;
    private static final String PLACE_KEY = "place";
    private static final String RULES_KEY = "rules";
    private static final String SANITIZED_VALUE = "_removed_";
    private static final String STANDARD_PARAMS_KEY = "standardParams";
    private static final String VALUE_REGEX_KEY = "valueRegex";
    private static final String VP_RP = "vp_rp";
    private static final String VP_RP_EV = "vp_rp_ev";
    private static final String VVP_IS_APPLIED_KEY = "vvp";
    private static final String VVP_IS_APPLIED_VALUE = "1";
    private static final String VVP_METADATA_KEY = "vvp_md";
    private static volatile VVPConfig config;
    private static boolean enabled;
    public static final VVPManager INSTANCE = new VVPManager();
    private static final Set<String> CONTENT_ID_SANITIZE_KEYS = SetsKt.setOf((Object[]) new String[]{"fb_content_ids", AppEventsConstants.EVENT_PARAM_CONTENT_ID});

    private VVPManager() {
    }

    /* JADX INFO: compiled from: VVPManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/integrity/VVPManager$CompiledRule;", "", VVPManager.PLACE_KEY, "", VVPManager.KEY_REGEX_KEY, "Ljava/util/regex/Pattern;", VVPManager.KEY_NEGATIVE_REGEX_KEY, VVPManager.VALUE_REGEX_KEY, "(ILjava/util/regex/Pattern;Ljava/util/regex/Pattern;Ljava/util/regex/Pattern;)V", "getKeyNegativeRegex", "()Ljava/util/regex/Pattern;", "getKeyRegex", "getPlace", "()I", "getValueRegex", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CompiledRule {
        private final Pattern keyNegativeRegex;
        private final Pattern keyRegex;
        private final int place;
        private final Pattern valueRegex;

        public static /* synthetic */ CompiledRule copy$default(CompiledRule compiledRule, int i, Pattern pattern, Pattern pattern2, Pattern pattern3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = compiledRule.place;
            }
            if ((i2 & 2) != 0) {
                pattern = compiledRule.keyRegex;
            }
            if ((i2 & 4) != 0) {
                pattern2 = compiledRule.keyNegativeRegex;
            }
            if ((i2 & 8) != 0) {
                pattern3 = compiledRule.valueRegex;
            }
            return compiledRule.copy(i, pattern, pattern2, pattern3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPlace() {
            return this.place;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Pattern getKeyRegex() {
            return this.keyRegex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Pattern getKeyNegativeRegex() {
            return this.keyNegativeRegex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Pattern getValueRegex() {
            return this.valueRegex;
        }

        public final CompiledRule copy(int place, Pattern keyRegex, Pattern keyNegativeRegex, Pattern valueRegex) {
            return new CompiledRule(place, keyRegex, keyNegativeRegex, valueRegex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompiledRule)) {
                return false;
            }
            CompiledRule compiledRule = (CompiledRule) other;
            return this.place == compiledRule.place && Intrinsics.areEqual(this.keyRegex, compiledRule.keyRegex) && Intrinsics.areEqual(this.keyNegativeRegex, compiledRule.keyNegativeRegex) && Intrinsics.areEqual(this.valueRegex, compiledRule.valueRegex);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.place) * 31;
            Pattern pattern = this.keyRegex;
            int iHashCode2 = (iHashCode + (pattern == null ? 0 : pattern.hashCode())) * 31;
            Pattern pattern2 = this.keyNegativeRegex;
            int iHashCode3 = (iHashCode2 + (pattern2 == null ? 0 : pattern2.hashCode())) * 31;
            Pattern pattern3 = this.valueRegex;
            return iHashCode3 + (pattern3 != null ? pattern3.hashCode() : 0);
        }

        public String toString() {
            return "CompiledRule(place=" + this.place + ", keyRegex=" + this.keyRegex + ", keyNegativeRegex=" + this.keyNegativeRegex + ", valueRegex=" + this.valueRegex + ')';
        }

        public CompiledRule(int i, Pattern pattern, Pattern pattern2, Pattern pattern3) {
            this.place = i;
            this.keyRegex = pattern;
            this.keyNegativeRegex = pattern2;
            this.valueRegex = pattern3;
        }

        public final int getPlace() {
            return this.place;
        }

        public final Pattern getKeyRegex() {
            return this.keyRegex;
        }

        public final Pattern getKeyNegativeRegex() {
            return this.keyNegativeRegex;
        }

        public final Pattern getValueRegex() {
            return this.valueRegex;
        }
    }

    /* JADX INFO: compiled from: VVPManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/integrity/VVPManager$VVPConfig;", "", VVPManager.RULES_KEY, "", "Lcom/facebook/appevents/integrity/VVPManager$CompiledRule;", VVPManager.STANDARD_PARAMS_KEY, "", "", VVPManager.IN_SCOPE_EVENT_NAMES_KEY, VVPManager.IS_SHADOW_ENABLED_KEY, "", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;Z)V", "getInScopeEventNames", "()Ljava/util/Set;", "()Z", "getRules", "()Ljava/util/List;", "getStandardParams", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VVPConfig {
        private final Set<String> inScopeEventNames;
        private final boolean isShadowEnabled;
        private final List<CompiledRule> rules;
        private final Set<String> standardParams;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VVPConfig copy$default(VVPConfig vVPConfig, List list, Set set, Set set2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = vVPConfig.rules;
            }
            if ((i & 2) != 0) {
                set = vVPConfig.standardParams;
            }
            if ((i & 4) != 0) {
                set2 = vVPConfig.inScopeEventNames;
            }
            if ((i & 8) != 0) {
                z = vVPConfig.isShadowEnabled;
            }
            return vVPConfig.copy(list, set, set2, z);
        }

        public final List<CompiledRule> component1() {
            return this.rules;
        }

        public final Set<String> component2() {
            return this.standardParams;
        }

        public final Set<String> component3() {
            return this.inScopeEventNames;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsShadowEnabled() {
            return this.isShadowEnabled;
        }

        public final VVPConfig copy(List<CompiledRule> rules, Set<String> standardParams, Set<String> inScopeEventNames, boolean isShadowEnabled) {
            Intrinsics.checkNotNullParameter(rules, "rules");
            Intrinsics.checkNotNullParameter(standardParams, "standardParams");
            return new VVPConfig(rules, standardParams, inScopeEventNames, isShadowEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VVPConfig)) {
                return false;
            }
            VVPConfig vVPConfig = (VVPConfig) other;
            return Intrinsics.areEqual(this.rules, vVPConfig.rules) && Intrinsics.areEqual(this.standardParams, vVPConfig.standardParams) && Intrinsics.areEqual(this.inScopeEventNames, vVPConfig.inScopeEventNames) && this.isShadowEnabled == vVPConfig.isShadowEnabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int iHashCode = ((this.rules.hashCode() * 31) + this.standardParams.hashCode()) * 31;
            Set<String> set = this.inScopeEventNames;
            int iHashCode2 = (iHashCode + (set == null ? 0 : set.hashCode())) * 31;
            boolean z = this.isShadowEnabled;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            return "VVPConfig(rules=" + this.rules + ", standardParams=" + this.standardParams + ", inScopeEventNames=" + this.inScopeEventNames + ", isShadowEnabled=" + this.isShadowEnabled + ')';
        }

        public VVPConfig(List<CompiledRule> rules, Set<String> standardParams, Set<String> set, boolean z) {
            Intrinsics.checkNotNullParameter(rules, "rules");
            Intrinsics.checkNotNullParameter(standardParams, "standardParams");
            this.rules = rules;
            this.standardParams = standardParams;
            this.inScopeEventNames = set;
            this.isShadowEnabled = z;
        }

        public final List<CompiledRule> getRules() {
            return this.rules;
        }

        public final Set<String> getStandardParams() {
            return this.standardParams;
        }

        public final Set<String> getInScopeEventNames() {
            return this.inScopeEventNames;
        }

        public final boolean isShadowEnabled() {
            return this.isShadowEnabled;
        }
    }

    public final VVPConfig getConfig$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return config;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(VVPManager.class)) {
            return;
        }
        try {
            VVPManager vVPManager = INSTANCE;
            enabled = true;
            vVPManager.loadConfig$facebook_core_release();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, VVPManager.class);
        }
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(VVPManager.class)) {
            return;
        }
        try {
            enabled = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, VVPManager.class);
        }
    }

    @JvmStatic
    public static final boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(VVPManager.class)) {
            return false;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, VVPManager.class);
            return false;
        }
    }

    public final void loadConfig$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            VVPConfig config$facebook_core_release = null;
            String vvpConfig = fetchedAppSettingsQueryAppSettings != null ? fetchedAppSettingsQueryAppSettings.getVvpConfig() : null;
            String str = vvpConfig;
            if (str != null && str.length() != 0) {
                config$facebook_core_release = parseConfig$facebook_core_release(vvpConfig);
            }
            config = config$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final VVPConfig parseConfig$facebook_core_release(String jsonStr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                if (!jSONObject.optBoolean("enabled", false)) {
                    return null;
                }
                List<CompiledRule> rules = parseRules(jSONObject);
                if (rules.isEmpty()) {
                    return null;
                }
                return new VVPConfig(rules, parseStandardParams(jSONObject), parseInScopeEventNames(jSONObject), jSONObject.optBoolean(IS_SHADOW_ENABLED_KEY, true));
            } catch (JSONException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<CompiledRule> parseRules(JSONObject obj) {
        CompiledRule compiledRuleCompileRule$facebook_core_release;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONArray jSONArrayOptJSONArray = obj.optJSONArray(RULES_KEY);
            if (jSONArrayOptJSONArray == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (compiledRuleCompileRule$facebook_core_release = compileRule$facebook_core_release(jSONObjectOptJSONObject)) != null) {
                    arrayList.add(compiledRuleCompileRule$facebook_core_release);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final CompiledRule compileRule$facebook_core_release(JSONObject ruleObj) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(ruleObj, "ruleObj");
            int iOptInt = ruleObj.optInt(PLACE_KEY, -1);
            if (iOptInt != 1 && iOptInt != 3) {
                return null;
            }
            Pattern patternOptRegex = optRegex(ruleObj, KEY_REGEX_KEY);
            Pattern patternOptRegex2 = optRegex(ruleObj, KEY_NEGATIVE_REGEX_KEY);
            Pattern patternOptRegex3 = optRegex(ruleObj, VALUE_REGEX_KEY);
            if (patternOptRegex == null && patternOptRegex3 == null) {
                return null;
            }
            return new CompiledRule(iOptInt, patternOptRegex, patternOptRegex2, patternOptRegex3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Pattern optRegex(JSONObject obj, String key) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (obj.has(key) && !obj.isNull(key)) {
                String raw = obj.optString(key, "");
                Intrinsics.checkNotNullExpressionValue(raw, "raw");
                if (raw.length() == 0) {
                    return null;
                }
                try {
                    return Pattern.compile(raw, 2);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Set<String> parseStandardParams(JSONObject obj) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObjectOptJSONObject = obj.optJSONObject(STANDARD_PARAMS_KEY);
            if (jSONObjectOptJSONObject == null) {
                return SetsKt.emptySet();
            }
            HashSet hashSet = new HashSet();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObjectOptJSONObject.optBoolean(next, false)) {
                    hashSet.add(next);
                }
            }
            return hashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Set<String> parseInScopeEventNames(JSONObject obj) {
        JSONArray jSONArrayOptJSONArray;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (!obj.has(IN_SCOPE_EVENT_NAMES_KEY) || obj.isNull(IN_SCOPE_EVENT_NAMES_KEY) || (jSONArrayOptJSONArray = obj.optJSONArray(IN_SCOPE_EVENT_NAMES_KEY)) == null) {
                return null;
            }
            HashSet hashSet = new HashSet();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                String s = jSONArrayOptJSONArray.optString(i, "");
                Intrinsics.checkNotNullExpressionValue(s, "s");
                if (s.length() > 0) {
                    hashSet.add(s);
                }
            }
            return hashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void processParametersForVVP(String eventName, Bundle parameters) {
        VVPConfig vVPConfig;
        Matcher matcher;
        String string;
        Matcher matcher2;
        Matcher matcher3;
        Matcher matcher4;
        if (CrashShieldHandler.isObjectCrashing(VVPManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled && parameters != null && !parameters.isEmpty() && (vVPConfig = config) != null) {
                Set<String> inScopeEventNames = vVPConfig.getInScopeEventNames();
                if (inScopeEventNames == null || inScopeEventNames.isEmpty() || inScopeEventNames.contains(eventName)) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    boolean z = false;
                    for (CompiledRule compiledRule : vVPConfig.getRules()) {
                        int place = compiledRule.getPlace();
                        if (place != 1) {
                            if (place == 3 && compiledRule.getKeyRegex() != null && compiledRule.getKeyRegex().matcher(eventName).find()) {
                                Pattern keyNegativeRegex = compiledRule.getKeyNegativeRegex();
                                if (!((keyNegativeRegex == null || (matcher = keyNegativeRegex.matcher(eventName)) == null) ? false : matcher.find())) {
                                    linkedHashSet2.add("1");
                                    z = true;
                                }
                            }
                        } else {
                            Set<String> setKeySet = parameters.keySet();
                            Intrinsics.checkNotNullExpressionValue(setKeySet, "parameters.keySet()");
                            for (String str : CollectionsKt.toList(setKeySet)) {
                                Object obj = parameters.get(str);
                                if (obj != null && (string = obj.toString()) != null) {
                                    Pattern keyRegex = compiledRule.getKeyRegex();
                                    boolean zFind = (keyRegex == null || (matcher4 = keyRegex.matcher(str)) == null) ? true : matcher4.find();
                                    Pattern keyNegativeRegex2 = compiledRule.getKeyNegativeRegex();
                                    boolean z2 = zFind && !((keyNegativeRegex2 == null || (matcher3 = keyNegativeRegex2.matcher(str)) == null) ? false : matcher3.find());
                                    Pattern valueRegex = compiledRule.getValueRegex();
                                    boolean zFind2 = (valueRegex == null || (matcher2 = valueRegex.matcher(string)) == null) ? true : matcher2.find();
                                    if (z2 && zFind2) {
                                        linkedHashSet.add(str);
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                    if (z) {
                        if (!vVPConfig.isShadowEnabled() && !vVPConfig.getStandardParams().isEmpty()) {
                            Set<String> setKeySet2 = parameters.keySet();
                            Intrinsics.checkNotNullExpressionValue(setKeySet2, "parameters.keySet()");
                            for (String str2 : CollectionsKt.toList(setKeySet2)) {
                                if (!vVPConfig.getStandardParams().contains(str2)) {
                                    if (CONTENT_ID_SANITIZE_KEYS.contains(str2)) {
                                        parameters.putString(str2, SANITIZED_VALUE);
                                    } else {
                                        parameters.remove(str2);
                                    }
                                }
                            }
                            INSTANCE.scrubIdInContentsArray$facebook_core_release(parameters);
                        }
                        parameters.putString(VVP_IS_APPLIED_KEY, "1");
                        if (linkedHashSet.isEmpty() && linkedHashSet2.isEmpty()) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (!linkedHashSet.isEmpty()) {
                            jSONObject.put(VP_RP, new JSONArray((Collection) CollectionsKt.toList(linkedHashSet)));
                        }
                        if (!linkedHashSet2.isEmpty()) {
                            jSONObject.put(VP_RP_EV, new JSONArray((Collection) CollectionsKt.toList(linkedHashSet2)));
                        }
                        parameters.putString(VVP_METADATA_KEY, jSONObject.toString());
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, VVPManager.class);
        }
    }

    public final void scrubIdInContentsArray$facebook_core_release(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            String string = parameters.getString("fb_content");
            if (string == null) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("id")) {
                        jSONObjectOptJSONObject.put("id", SANITIZED_VALUE);
                        z = true;
                    }
                }
                if (z) {
                    parameters.putString("fb_content", jSONArray.toString());
                }
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void clearForTests$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            enabled = false;
            config = null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
