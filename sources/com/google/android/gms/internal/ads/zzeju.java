package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeju {
    private final zzbhp zza;
    private final Context zzb;
    private final zzeiz zzc;
    private final VersionInfoParcel zzd;

    public zzeju(Context context, VersionInfoParcel versionInfoParcel, zzbhp zzbhpVar, zzeiz zzeizVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbhpVar;
        this.zzc = zzeizVar;
    }

    public final void zza(final boolean z) {
        try {
            this.zzc.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejt
                @Override // com.google.android.gms.internal.ads.zzfok
                public final /* synthetic */ Object zza(Object obj) {
                    this.zza.zzb(z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            String message = e.getMessage();
            String.valueOf(message);
            String strValueOf = String.valueOf(message);
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in offline signals database startup: ".concat(strValueOf));
        }
    }

    final /* synthetic */ Void zzb(boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(zzbhv.zzaf.zza.zzk(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zziet e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzo.zzf(e.getMessage());
                }
            }
            cursorQuery.close();
            Context context = this.zzb;
            zzbhv.zzaf.zzc zzcVarZzB = zzbhv.zzaf.zzB();
            zzcVarZzB.zzB(context.getPackageName());
            zzcVarZzB.zzH(Build.MODEL);
            zzcVarZzB.zzo(zzejo.zzc(sQLiteDatabase, 0));
            zzcVarZzB.zzj(arrayList);
            zzcVarZzB.zzs(zzejo.zzc(sQLiteDatabase, 1));
            zzcVarZzB.zzQ(zzejo.zzc(sQLiteDatabase, 3));
            zzcVarZzB.zzw(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
            zzcVarZzB.zzM(zzejo.zzd(sQLiteDatabase, 2));
            final zzbhv.zzaf zzafVarZzbu = zzcVarZzB.zzbu();
            int size = arrayList.size();
            long jZzb = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbhv.zzaf.zza zzaVar = (zzbhv.zzaf.zza) arrayList.get(i2);
                if (zzaVar.zzf() == zzbhv.zzq.ENUM_TRUE && zzaVar.zzb() > jZzb) {
                    jZzb = zzaVar.zzb();
                }
            }
            if (jZzb != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(jZzb));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            zzbhp zzbhpVar = this.zza;
            zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzejr
                @Override // com.google.android.gms.internal.ads.zzbho
                public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar2) {
                    zzaVar2.zzaf(zzafVarZzbu);
                }
            });
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbhv.zzar.zza zzaVarZzs = zzbhv.zzar.zzs();
            zzaVarZzs.zzc(versionInfoParcel.buddyApkVersion);
            zzaVarZzs.zzg(versionInfoParcel.clientJarVersion);
            zzaVarZzs.zzk(true != versionInfoParcel.isClientJar ? 2 : 0);
            final zzbhv.zzar zzarVarZzbu = zzaVarZzs.zzbu();
            zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzejs
                @Override // com.google.android.gms.internal.ads.zzbho
                public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar2) {
                    zzbhv.zzm.zza zzaVarZzcc = zzaVar2.zzG().zzcc();
                    zzaVarZzcc.zzs(zzarVarZzbu);
                    zzaVar2.zzI(zzaVarZzcc);
                }
            });
            zzbhpVar.zzc(Videoio.CAP_PROP_GIGA_FRAME_HEIGH_MAX);
            zzejo.zzb(sQLiteDatabase);
        }
        return null;
    }
}
