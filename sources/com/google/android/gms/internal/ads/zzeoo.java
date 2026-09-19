package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeoo {
    private final zzhcp zzc;
    private zzepe zzf;
    private final String zzh;
    private final int zzi;
    private final zzepd zzj;
    private zzfkf zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    zzeoo(zzfkq zzfkqVar, zzepd zzepdVar, zzhcp zzhcpVar) {
        this.zzi = zzfkqVar.zzb.zzb.zzr;
        this.zzj = zzepdVar;
        this.zzc = zzhcpVar;
        this.zzh = zzepk.zzb(zzfkqVar);
        List list = zzfkqVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfkf) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized boolean zze() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfkf) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi && zzf(false)) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzf(boolean z) {
        for (zzfkf zzfkfVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzfkfVar);
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzfkfVar.zzat)) {
                if (numValueOf.intValue() < this.zzg) {
                    return true;
                }
                if (numValueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzfkf) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        return zzf(true) || zzg();
    }

    private final synchronized void zzi() {
        this.zzj.zzd(this.zzk);
        zzepe zzepeVar = this.zzf;
        if (zzepeVar != null) {
            this.zzc.zza(zzepeVar);
        } else {
            this.zzc.zzb(new zzeph(3, this.zzh));
        }
    }

    @Nullable
    final synchronized zzfkf zza() {
        if (zze()) {
            int i = 0;
            while (true) {
                List list = this.zzb;
                if (i >= list.size()) {
                    break;
                }
                zzfkf zzfkfVar = (zzfkf) list.get(i);
                String str = zzfkfVar.zzat;
                Set set = this.zze;
                if (!set.contains(str)) {
                    if (zzfkfVar.zzav) {
                        this.zzl = true;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        set.add(str);
                    }
                    this.zzd.add(zzfkfVar);
                    return (zzfkf) list.remove(i);
                }
                i++;
            }
        }
        return null;
    }

    final synchronized void zzb(zzepe zzepeVar, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        if (zzd()) {
            zzepeVar.zzm();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfkfVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzf(zzfkfVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzf(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = zzepeVar;
        this.zzk = zzfkfVar;
        if (zzh()) {
            return;
        }
        zzi();
    }

    final synchronized void zzc(Throwable th, zzfkf zzfkfVar) {
        this.zzl = false;
        this.zzd.remove(zzfkfVar);
        this.zze.remove(zzfkfVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zzi();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
