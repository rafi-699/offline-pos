package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzarb implements zzaqt {
    final /* synthetic */ zzard zza;
    private final zzes zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzarb(zzard zzardVar, int i) {
        Objects.requireNonNull(zzardVar);
        this.zza = zzardVar;
        this.zzb = new zzes(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzb(zzet zzetVar) {
        int i;
        if (zzetVar.zzs() != 2) {
            return;
        }
        zzard zzardVar = this.zza;
        zzfi zzfiVar = (zzfi) zzardVar.zzh().get(0);
        if ((zzetVar.zzs() & 128) != 0) {
            zzetVar.zzk(1);
            int iZzt = zzetVar.zzt();
            int i2 = 3;
            zzetVar.zzk(3);
            zzes zzesVar = this.zzb;
            zzetVar.zzl(zzesVar, 2);
            zzesVar.zzh(3);
            int i3 = 13;
            zzardVar.zzq(zzesVar.zzj(13));
            zzetVar.zzl(zzesVar, 2);
            int i4 = 4;
            zzesVar.zzh(4);
            int i5 = 12;
            zzetVar.zzk(zzesVar.zzj(12));
            SparseArray sparseArray = this.zzc;
            sparseArray.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int iZzd = zzetVar.zzd();
            while (iZzd > 0) {
                int i6 = 5;
                zzetVar.zzl(zzesVar, 5);
                int iZzj = zzesVar.zzj(8);
                zzesVar.zzh(i2);
                int iZzj2 = zzesVar.zzj(i3);
                zzesVar.zzh(i4);
                int iZzj3 = zzesVar.zzj(i5);
                int iZzg = zzetVar.zzg();
                int i7 = iZzg + iZzj3;
                String str = null;
                ArrayList arrayList = null;
                int i8 = -1;
                int iZzs = 0;
                while (zzetVar.zzg() < i7) {
                    int iZzs2 = zzetVar.zzs();
                    int iZzg2 = zzetVar.zzg() + zzetVar.zzs();
                    if (iZzg2 > i7) {
                        break;
                    }
                    if (iZzs2 == i6) {
                        long jZzz = zzetVar.zzz();
                        if (jZzz == 1094921523) {
                            zzardVar = zzardVar;
                            i8 = 129;
                        } else if (jZzz == 1161904947) {
                            zzardVar = zzardVar;
                            zzesVar = zzesVar;
                            iZzd = iZzd;
                            i8 = 135;
                            iZzg2 = iZzg2;
                        } else if (jZzz == 1094921524) {
                            zzardVar = zzardVar;
                            i8 = 172;
                        } else if (jZzz == 1212503619) {
                            i = 36;
                            i8 = i;
                        }
                    } else if (iZzs2 == 106) {
                        zzardVar = zzardVar;
                        i8 = 129;
                    } else if (iZzs2 == 122) {
                        zzardVar = zzardVar;
                        zzesVar = zzesVar;
                        iZzd = iZzd;
                        i8 = 135;
                        iZzg2 = iZzg2;
                    } else {
                        if (iZzs2 == 127) {
                            int iZzs3 = zzetVar.zzs();
                            if (iZzs3 == 21) {
                                zzardVar = zzardVar;
                                i8 = 172;
                            } else if (iZzs3 == 14) {
                                i = 136;
                            } else if (iZzs3 == 33) {
                                i = 139;
                            }
                        } else if (iZzs2 == 123) {
                            i = 138;
                        } else if (iZzs2 == 10) {
                            String strTrim = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                            iZzs = zzetVar.zzs();
                            str = strTrim;
                        } else if (iZzs2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (zzetVar.zzg() < iZzg2) {
                                int i9 = iZzg2;
                                String strTrim2 = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                                int iZzs4 = zzetVar.zzs();
                                int i10 = iZzd;
                                byte[] bArr = new byte[4];
                                zzetVar.zzm(bArr, 0, 4);
                                arrayList2.add(new zzare(strTrim2, iZzs4, bArr));
                                iZzd = i10;
                                iZzg2 = i9;
                                zzesVar = zzesVar;
                                zzardVar = zzardVar;
                            }
                            zzardVar = zzardVar;
                            iZzg2 = iZzg2;
                            zzesVar = zzesVar;
                            iZzd = iZzd;
                            arrayList = arrayList2;
                            i8 = 89;
                        } else {
                            zzardVar = zzardVar;
                            iZzg2 = iZzg2;
                            zzesVar = zzesVar;
                            iZzd = iZzd;
                            if (iZzs2 == 111) {
                                i8 = 257;
                            }
                        }
                        i8 = i;
                    }
                    zzetVar.zzk(iZzg2 - zzetVar.zzg());
                    iZzd = iZzd;
                    zzesVar = zzesVar;
                    zzardVar = zzardVar;
                    i6 = 5;
                }
                zzard zzardVar2 = zzardVar;
                zzes zzesVar2 = zzesVar;
                int i11 = iZzd;
                zzetVar.zzh(i7);
                zzarf zzarfVar = new zzarf(i8, str, iZzs, arrayList, Arrays.copyOfRange(zzetVar.zzi(), iZzg, i7));
                if (iZzj == 6 || iZzj == 5) {
                    iZzj = zzarfVar.zza;
                }
                iZzd = i11 - (iZzj3 + 5);
                if (!zzardVar2.zzk().get(iZzj2)) {
                    zzari zzariVarZzb = zzardVar2.zzi().zzb(iZzj, zzarfVar);
                    sparseIntArray.put(iZzj2, iZzj2);
                    sparseArray.put(iZzj2, zzariVarZzb);
                }
                i4 = 4;
                zzesVar = zzesVar2;
                zzardVar = zzardVar2;
                i2 = 3;
                i3 = 13;
                i5 = 12;
            }
            zzard zzardVar3 = zzardVar;
            int size = sparseIntArray.size();
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = sparseIntArray.keyAt(i12);
                int iValueAt = sparseIntArray.valueAt(i12);
                zzardVar3.zzk().put(iKeyAt, true);
                zzardVar3.zzl().put(iValueAt, true);
                zzari zzariVar = (zzari) sparseArray.valueAt(i12);
                if (zzariVar != null) {
                    zzariVar.zza(zzfiVar, zzardVar3.zzm(), new zzarh(iZzt, iKeyAt, 8192));
                    zzardVar3.zzj().put(iValueAt, zzariVar);
                }
            }
            zzardVar3.zzj().remove(this.zze);
            zzardVar3.zzo(0);
            if (zzardVar3.zzn() == 0) {
                zzardVar3.zzm().zzv();
                zzardVar3.zzp(true);
            }
        }
    }
}
