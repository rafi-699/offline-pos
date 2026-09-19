package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzifg {
    private static final zzifn zzb = new zzife();
    private final zzifn zza;

    public zzifg() {
        zzifn zzifnVar = zzb;
        int i = zzicn.zza;
        this.zza = new zziff(zzidx.zza(), zzifnVar);
    }

    public final zzigh zza(Class cls) {
        int i = zzigi.zza;
        if (!zziee.class.isAssignableFrom(cls)) {
            int i2 = zzicn.zza;
        }
        zzifm zzifmVarZzc = this.zza.zzc(cls);
        if (zzifmVarZzc.zza()) {
            int i3 = zzicn.zza;
            return zzift.zzh(zzigi.zzF(), zzidr.zza(), zzifmVarZzc.zzb());
        }
        int i4 = zzicn.zza;
        return zzifs.zzm(cls, zzifmVarZzc, zzifw.zza(), zzifc.zza(), zzigi.zzF(), zzifmVarZzc.zzc() + (-1) != 1 ? zzidr.zza() : null, zzifl.zza());
    }
}
