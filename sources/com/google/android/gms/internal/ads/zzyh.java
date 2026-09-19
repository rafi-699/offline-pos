package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzyh implements zzabz, zzwz {
    final /* synthetic */ zzyq zza;
    private final long zzb;
    private final Uri zzc;
    private final zzim zzd;
    private final zzyd zze;
    private final zzagb zzf;
    private final zzds zzg;
    private final zzagy zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzht zzl;
    private zzahk zzm;
    private boolean zzn;

    public zzyh(zzyq zzyqVar, Uri uri, zzhp zzhpVar, zzyd zzydVar, zzagb zzagbVar, zzds zzdsVar) {
        Objects.requireNonNull(zzyqVar);
        this.zza = zzyqVar;
        this.zzc = uri;
        this.zzd = new zzim(zzhpVar);
        this.zze = zzydVar;
        this.zzf = zzagbVar;
        this.zzg = zzdsVar;
        this.zzh = new zzagy();
        this.zzj = true;
        this.zzb = zzxb.zza();
        this.zzl = zzi(0L, null);
    }

    private final zzht zzi(long j, String str) {
        Map mapZzd = zzyq.zzb;
        if (str != null && !str.startsWith("W/")) {
            zzgwo zzgwoVar = new zzgwo();
            zzgwoVar.zzb(mapZzd.entrySet());
            zzgwoVar.zza(HttpHeaders.IF_RANGE, str);
            mapZzd = zzgwoVar.zzd();
        }
        zzhs zzhsVar = new zzhs();
        zzhsVar.zza(this.zzc);
        zzhsVar.zzc(j);
        zzhsVar.zzd(6);
        zzhsVar.zzb(mapZzd);
        return zzhsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzb() {
        this.zzi = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x020c */
    /* JADX WARN: Code duplicated, block: B:111:0x0233  */
    /* JADX WARN: Code duplicated, block: B:113:0x023d  */
    @Override // com.google.android.gms.internal.ads.zzabz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyh.zzc():void");
    }

    final /* synthetic */ void zzd(long j, long j2) {
        this.zzh.zza = j;
        this.zzk = j2;
        this.zzj = true;
        this.zzn = false;
    }

    final /* synthetic */ long zze() {
        return this.zzb;
    }

    final /* synthetic */ zzim zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zzk;
    }

    final /* synthetic */ zzht zzh() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void zza(zzet zzetVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(this.zza.zzI(true), this.zzk);
        int iZzd = zzetVar.zzd();
        zzahk zzahkVar = this.zzm;
        zzahkVar.getClass();
        zzahkVar.zzc(zzetVar, iZzd);
        zzahkVar.zze(jMax, 1, iZzd, 0, null);
        this.zzn = true;
    }
}
