package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzck {
    private final Context zza;
    private final Map zzb = new HashMap();

    public zzck(Context context) {
        this.zza = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences.Editor zzd(String str) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, this.zza.getSharedPreferences(str, 0).edit());
        }
        return (SharedPreferences.Editor) this.zzb.get(str);
    }

    public final void zzb() {
        Iterator it = this.zzb.values().iterator();
        while (it.hasNext()) {
            ((SharedPreferences.Editor) it.next()).apply();
        }
    }

    public final boolean zzc(String str, Object obj) {
        zzcj zzcjVarZza = zzcl.zza(this.zza, str);
        if (zzcjVarZza == null) {
            return false;
        }
        SharedPreferences.Editor editorZzd = zzd(zzcjVarZza.zza);
        if (obj instanceof Integer) {
            editorZzd.putInt(zzcjVarZza.zzb, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Long) {
            editorZzd.putLong(zzcjVarZza.zzb, ((Long) obj).longValue());
            return true;
        }
        if (obj instanceof Double) {
            editorZzd.putFloat(zzcjVarZza.zzb, ((Double) obj).floatValue());
            return true;
        }
        if (obj instanceof Float) {
            editorZzd.putFloat(zzcjVarZza.zzb, ((Float) obj).floatValue());
            return true;
        }
        if (obj instanceof Boolean) {
            editorZzd.putBoolean(zzcjVarZza.zzb, ((Boolean) obj).booleanValue());
            return true;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        editorZzd.putString(zzcjVarZza.zzb, (String) obj);
        return true;
    }
}
