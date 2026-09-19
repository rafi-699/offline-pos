package com.google.android.gms.internal.identity_googleid;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzi extends zzj {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzj zzc;

    zzi(zzj zzjVar, int i, int i2) {
        Objects.requireNonNull(zzjVar);
        this.zzc = zzjVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zza.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzj, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzf
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzf
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzf
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzj
    /* JADX INFO: renamed from: zzf */
    public final zzj subList(int i, int i2) {
        zza.zzc(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
