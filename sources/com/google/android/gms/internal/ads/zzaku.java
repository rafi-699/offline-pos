package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaku implements zzakt {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzaku(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i;
    }

    public static zzaku zze(long j, long j2, zzagv zzagvVar, zzet zzetVar) {
        int iZzs;
        zzet zzetVar2 = zzetVar;
        zzetVar2.zzk(6);
        int iZzB = zzetVar2.zzB();
        long j3 = zzagvVar.zzc;
        long j4 = iZzB;
        int iZzB2 = zzetVar2.zzB();
        if (iZzB2 <= 0) {
            return null;
        }
        long jZzt = zzfl.zzt((((long) iZzB2) * ((long) zzagvVar.zzg)) - 1, zzagvVar.zzd);
        int iZzt = zzetVar2.zzt();
        int iZzt2 = zzetVar2.zzt();
        int iZzt3 = zzetVar2.zzt();
        zzetVar2.zzk(2);
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        int i = 0;
        long j5 = j2 + ((long) zzagvVar.zzc);
        while (i < iZzt) {
            long j6 = j3;
            jArr[i] = (((long) i) * jZzt) / ((long) iZzt);
            jArr2[i] = j5;
            if (iZzt3 == 1) {
                iZzs = zzetVar2.zzs();
            } else if (iZzt3 == 2) {
                iZzs = zzetVar2.zzt();
            } else if (iZzt3 == 3) {
                iZzs = zzetVar2.zzx();
            } else {
                if (iZzt3 != 4) {
                    return null;
                }
                iZzs = zzetVar2.zzH();
            }
            j5 += ((long) iZzs) * ((long) iZzt2);
            i++;
            zzetVar2 = zzetVar;
            iZzt = iZzt;
            j3 = j6;
        }
        long j7 = j2 + j3;
        long jMax = j7 + j4;
        if (j != -1 && j != jMax) {
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 27 + String.valueOf(jMax).length());
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(jMax);
            zzeg.zzc("VbriSeeker", sb.toString());
        }
        if (jMax != j5) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(jMax).length() + 43 + String.valueOf(j5).length() + 28);
            sb2.append("VBRI bytes and ToC mismatch (using max): ");
            sb2.append(jMax);
            sb2.append(", ");
            sb2.append(j5);
            sb2.append("\nSeeking will be inaccurate.");
            zzeg.zzc("VbriSeeker", sb2.toString());
            jMax = Math.max(jMax, j5);
        }
        return new zzaku(jArr, jArr2, jZzt, j7, jMax, zzagvVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        long[] jArr = this.zza;
        int iZzo = zzfl.zzo(jArr, j, true, true);
        long j2 = jArr[iZzo];
        long[] jArr2 = this.zzb;
        zzahc zzahcVar = new zzahc(j2, jArr2[iZzo]);
        if (zzahcVar.zzb >= j || iZzo == jArr.length - 1) {
            return new zzagz(zzahcVar, zzahcVar);
        }
        int i = iZzo + 1;
        return new zzagz(zzahcVar, new zzahc(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j) {
        return this.zza[zzfl.zzo(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zze;
    }
}
