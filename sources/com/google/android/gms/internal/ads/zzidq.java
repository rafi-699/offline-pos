package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzidq extends zzidp {
    zzidq() {
    }

    @Override // com.google.android.gms.internal.ads.zzidp
    final void zza(Object obj) {
        ((zziea) obj).zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzidp
    final void zzb(zzihi zzihiVar, Map.Entry entry) throws IOException {
        zzieb zziebVar = (zzieb) entry.getKey();
        if (!zziebVar.zzc) {
            zzihg zzihgVar = zzihg.DOUBLE;
            switch (zziebVar.zzb) {
                case DOUBLE:
                    zzihiVar.zzf(zziebVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzihiVar.zze(zziebVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzihiVar.zzc(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzihiVar.zzh(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzihiVar.zzi(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzihiVar.zzj(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzihiVar.zzk(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzihiVar.zzl(zziebVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzihiVar.zzm(zziebVar.zza, (String) entry.getValue());
                    break;
                case GROUP:
                    zzihiVar.zzs(zziebVar.zza, entry.getValue(), zzifz.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzihiVar.zzr(zziebVar.zza, entry.getValue(), zzifz.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzihiVar.zzn(zziebVar.zza, (zzida) entry.getValue());
                    break;
                case UINT32:
                    zzihiVar.zzo(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzihiVar.zzi(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzihiVar.zzb(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzihiVar.zzd(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzihiVar.zzp(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzihiVar.zzq(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzihg zzihgVar2 = zzihg.DOUBLE;
        switch (zziebVar.zzb) {
            case DOUBLE:
                zzigi.zza(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case FLOAT:
                zzigi.zzb(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case INT64:
                zzigi.zzc(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case UINT64:
                zzigi.zzd(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case INT32:
                zzigi.zzh(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case FIXED64:
                zzigi.zzf(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case FIXED32:
                zzigi.zzk(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case BOOL:
                zzigi.zzn(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case STRING:
                zzigi.zzo(zziebVar.zza, (List) entry.getValue(), zzihiVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzigi.zzr(zziebVar.zza, (List) entry.getValue(), zzihiVar, zzifz.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzigi.zzq(zziebVar.zza, (List) entry.getValue(), zzihiVar, zzifz.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzigi.zzp(zziebVar.zza, (List) entry.getValue(), zzihiVar);
                break;
            case UINT32:
                zzigi.zzi(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case ENUM:
                zzigi.zzh(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case SFIXED32:
                zzigi.zzl(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case SFIXED64:
                zzigi.zzg(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case SINT32:
                zzigi.zzj(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case SINT64:
                zzigi.zze(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
        }
    }
}
