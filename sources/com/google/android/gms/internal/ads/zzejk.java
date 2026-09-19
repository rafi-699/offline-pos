package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzejk implements zzhbt {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzejl zzb;

    zzejk(zzejl zzejlVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzejlVar);
        this.zzb = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0070  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:29:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    /* JADX WARN: Code duplicated, block: B:35:0x0091  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listEmptyList;
        List listAsList;
        final ArrayList arrayList;
        Iterator it;
        zzbhv.zzd.zza zzaVar;
        zzejl zzejlVar = this.zzb;
        Bundle bundle = (Bundle) obj;
        if (zzejlVar.zzf()) {
            return;
        }
        Object obj2 = bundle.get("ad_types");
        if (!(obj2 instanceof List)) {
            if (obj2 instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj2);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList();
            it = listEmptyList.iterator();
            while (it.hasNext()) {
                switch ((String) it.next()) {
                    case "banner":
                        zzaVar = zzbhv.zzd.zza.BANNER;
                        break;
                    case "native":
                        zzaVar = zzbhv.zzd.zza.NATIVE_APP_INSTALL;
                        break;
                    case "rewarded":
                        zzaVar = zzbhv.zzd.zza.REWARD_BASED_VIDEO_AD;
                        break;
                    case "interstitial":
                        zzaVar = zzbhv.zzd.zza.INTERSTITIAL;
                        break;
                    default:
                        zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                        break;
                }
                arrayList.add(zzaVar);
            }
            final zzbhv.zzaf.zzd zzdVarZze = zzejl.zze(bundle);
            final zzbhv.zzab zzabVarZzb = zzejlVar.zzb(bundle);
            final boolean z = this.zza;
            zzejlVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejj
                @Override // com.google.android.gms.internal.ads.zzfok
                public final /* synthetic */ Object zza(Object obj3) {
                    zzejl zzejlVar2 = this.zza.zzb;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                    if (zzejlVar2.zzf()) {
                        return null;
                    }
                    zzbhv.zzaf.zzd zzdVar = zzdVarZze;
                    zzbhv.zzab zzabVar = zzabVarZzb;
                    ArrayList arrayList2 = arrayList;
                    boolean z2 = z;
                    byte[] bArrZzc = zzejlVar2.zzc(z2, arrayList2, zzabVar, zzdVar);
                    zzejo.zzf(sQLiteDatabase, z2, true);
                    zzejo.zze(sQLiteDatabase, zzejlVar2.zzd().zzb(), bArrZzc);
                    return null;
                }
            });
        }
        listAsList = (List) obj2;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList();
        it = listEmptyList.iterator();
        while (it.hasNext()) {
            switch ((String) it.next()) {
                case -1396342996:
                    if (!r2.equals("banner")) {
                        zzaVar = zzbhv.zzd.zza.BANNER;
                    } else {
                        zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                    }
                    break;
                case -1052618729:
                    if (!r2.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                        zzaVar = zzbhv.zzd.zza.NATIVE_APP_INSTALL;
                    } else {
                        zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                    }
                    break;
                case -239580146:
                    if (!r2.equals("rewarded")) {
                        zzaVar = zzbhv.zzd.zza.REWARD_BASED_VIDEO_AD;
                    } else {
                        zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                    }
                    break;
                case 604727084:
                    if (!r2.equals("interstitial")) {
                        zzaVar = zzbhv.zzd.zza.INTERSTITIAL;
                    } else {
                        zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                    }
                    break;
                default:
                    zzaVar = zzbhv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                    break;
            }
            arrayList.add(zzaVar);
        }
        final zzbhv.zzaf.zzd zzdVarZze2 = zzejl.zze(bundle);
        final zzbhv.zzab zzabVarZzb2 = zzejlVar.zzb(bundle);
        final boolean z2 = this.zza;
        zzejlVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejj
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj4) {
                zzejl zzejlVar2 = this.zza.zzb;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj4;
                if (zzejlVar2.zzf()) {
                    return null;
                }
                zzbhv.zzaf.zzd zzdVar = zzdVarZze2;
                zzbhv.zzab zzabVar = zzabVarZzb2;
                ArrayList arrayList3 = arrayList;
                boolean z3 = z2;
                byte[] bArrZzc = zzejlVar2.zzc(z3, arrayList3, zzabVar, zzdVar);
                zzejo.zzf(sQLiteDatabase, z3, true);
                zzejo.zze(sQLiteDatabase, zzejlVar2.zzd().zzb(), bArrZzc);
                return null;
            }
        });
    }
}
