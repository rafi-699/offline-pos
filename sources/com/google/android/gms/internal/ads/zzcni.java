package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.auth0.android.jwt.BuildConfig;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcni implements zzbak {
    private final Context zza;
    private final zzgda zzb;

    zzcni(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdD)).intValue();
        int i = 2;
        if (iIntValue != 1) {
            i = (iIntValue == 2 || iIntValue != 3) ? 3 : 4;
        }
        zzgdw zzgdwVarZze = zzgdx.zze();
        zzgdwVarZze.zza(((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdJ)).floatValue());
        zzgdx zzgdxVar = (zzgdx) zzgdwVarZze.zzbu();
        zzgdy zzgdyVarZzi = zzgdz.zzi();
        zzgdyVarZzi.zza(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdK)).booleanValue());
        zzgdyVarZzi.zzb(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdM)).longValue());
        zzgdz zzgdzVar = (zzgdz) zzgdyVarZzi.zzbu();
        zzgdd zzgddVarZzw = zzgdf.zzw();
        zzgddVarZzw.zzi(i);
        zzgddVarZzw.zzb(versionInfoParcel.afmaVersion);
        zzgddVarZzw.zzj(3);
        zzgddVarZzw.zza(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdk)).booleanValue());
        zzgddVarZzw.zzh(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdA)).intValue() == -1);
        zzgddVarZzw.zzg(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdC)).intValue());
        zzgddVarZzw.zze(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdL)).longValue());
        zzgddVarZzw.zzd(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdB)).intValue());
        zzgddVarZzw.zzc(zzgdxVar);
        zzgddVarZzw.zzf(zzgdzVar);
        zzgda zzgdaVarZza = zzgda.zza(context, zzcfr.zza, (zzgdf) zzgddVarZzw.zzbu());
        this.zzb = zzgdaVarZza;
        zzgdaVarZza.zzb();
    }

    public final String zza() {
        int iZzh = this.zzb.zzh() - 1;
        if (iZzh == 1) {
            return BuildConfig.VERSION_NAME;
        }
        if (iZzh != 2) {
            return iZzh != 3 ? "uns" : "3.0";
        }
        return "2.0";
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzd(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.zzb.zzg(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    @Deprecated
    public final void zze(int i, int i2, int i3) {
        com.google.android.gms.ads.internal.client.zzay.zza();
        Context context = this.zza;
        float fZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i);
        com.google.android.gms.ads.internal.client.zzay.zza();
        float fZzE2 = com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i2);
        zzgda zzgdaVar = this.zzb;
        long j = i3;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, j, 0, fZzE, fZzE2, 0);
        zzgdaVar.zzg(motionEventObtain);
        motionEventObtain.recycle();
        com.google.android.gms.ads.internal.client.zzay.zza();
        float fZzE3 = com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i);
        com.google.android.gms.ads.internal.client.zzay.zza();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, j, 2, fZzE3, com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i2), 0);
        zzgdaVar.zzg(motionEventObtain2);
        motionEventObtain2.recycle();
        com.google.android.gms.ads.internal.client.zzay.zza();
        float fZzE4 = com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i);
        com.google.android.gms.ads.internal.client.zzay.zza();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, j, 1, fZzE4, com.google.android.gms.ads.internal.util.client.zzf.zzE(context, i2), 0);
        zzgdaVar.zzg(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzf(Context context, String str, View view, Activity activity) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzg(Context context, String str, View view) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        this.zzb.zzf(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzj(Context context, View view, Activity activity) {
        return this.zzb.zzd(context, null, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzk(Context context) {
        return this.zzb.zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzl(Context context) {
        return this.zzb.zzc(context);
    }
}
