package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeap {
    public final long zza;
    public final int[] zzb;

    private zzeap(long j, int[] iArr) {
        this.zza = j;
        this.zzb = iArr;
    }

    public static zzgwm zza(JsonReader jsonReader) throws IOException {
        int[] iArr;
        int i = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzgwm zzgwmVarZzi = zzgwm.zzi();
            jsonReader.beginObject();
            zzeap zzeapVar = null;
            Long lValueOf = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Objects.equals(strNextName, "id")) {
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(strNextName, "event_types")) {
                    zzgwj zzgwjVar2 = new zzgwj();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzgwjVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzgwmVarZzi = zzgwjVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (lValueOf != null && !zzgwmVarZzi.isEmpty()) {
                long jLongValue = lValueOf.longValue();
                if (zzgwmVarZzi == null) {
                    iArr = new int[0];
                } else {
                    int[] iArr2 = new int[zzgwmVarZzi.size()];
                    for (int i2 = 0; i2 < zzgwmVarZzi.size(); i2++) {
                        iArr2[i2] = ((Integer) zzgwmVarZzi.get(i2)).intValue();
                    }
                    iArr = iArr2;
                }
                zzeapVar = new zzeap(jLongValue, iArr);
            }
            if (zzeapVar != null) {
                zzgwjVar.zzf(zzeapVar);
            }
        }
        jsonReader.endArray();
        return zzgwjVar.zzi();
    }
}
