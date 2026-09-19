package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafc {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzafc(List list, int i, int i2, int i3, int i4) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0036 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a5 A[Catch: ArrayIndexOutOfBoundsException -> 0x01e7, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x01e7, blocks: (B:3:0x0004, B:15:0x0040, B:17:0x004b, B:19:0x005b, B:22:0x0067, B:24:0x0093, B:26:0x0099, B:28:0x00ae, B:30:0x00b7, B:32:0x00bf, B:34:0x00d4, B:36:0x00e1, B:38:0x00f6, B:40:0x00fc, B:42:0x0111, B:44:0x0117, B:46:0x012c, B:49:0x0135, B:51:0x013e, B:52:0x0141, B:53:0x0146, B:55:0x015c, B:56:0x015f, B:58:0x0168, B:59:0x016b, B:64:0x0178, B:66:0x017e, B:68:0x0183, B:69:0x0186, B:72:0x0191, B:75:0x0198, B:78:0x019f, B:80:0x01a5, B:90:0x01c4, B:94:0x01cc, B:96:0x01dd, B:89:0x01c0, B:62:0x0172), top: B:101:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01bf A[PHI: r1
  0x01bf: PHI (r1v7 int) = (r1v6 int), (r1v6 int), (r1v11 int) binds: [B:81:0x01b1, B:82:0x01b3, B:87:0x01be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d7  */
    public static zzafc zza(byte[] bArr) throws zzat {
        int i;
        int i2;
        int i3;
        int iZzc;
        int iZzj;
        int iZzj2;
        try {
            zzes zzesVar = new zzes(bArr, bArr.length);
            int i4 = 1;
            zzesVar.zzo(1);
            int iZzj3 = zzesVar.zzj(3);
            zzesVar.zzh(6);
            boolean zZzi = zzesVar.zzi();
            boolean zZzi2 = zzesVar.zzi();
            int i5 = 12;
            boolean z = false;
            if (iZzj3 != 2) {
                if (iZzj3 <= 2) {
                    i = -1;
                } else if (true != zZzi) {
                    i = 8;
                } else {
                    i = 10;
                }
            } else if (!zZzi) {
                zZzi = false;
                iZzj3 = 2;
                if (iZzj3 <= 2) {
                    i = -1;
                } else if (true != zZzi) {
                    i = 8;
                } else {
                    i = 10;
                }
            } else if (true != zZzi2) {
                i = 10;
            } else {
                i = 12;
            }
            int i6 = 13;
            zzesVar.zzh(13);
            if (zzesVar.zzc() <= 0) {
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            zzesVar.zzg();
            int iZzj4 = zzesVar.zzj(4);
            if (iZzj4 != 1) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 22);
                sb.append("Unsupported obu_type: ");
                sb.append(iZzj4);
                zzeg.zzb("Av1Config", sb.toString());
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported obu_extension_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            boolean zZzi3 = zzesVar.zzi();
            zzesVar.zzg();
            if (zZzi3 && zzesVar.zzj(8) > 127) {
                zzeg.zzb("Av1Config", "Excessive obu_size");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            int iZzj5 = zzesVar.zzj(3);
            zzesVar.zzg();
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported reduced_still_picture_header");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported timing_info_present_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            if (zzesVar.zzi()) {
                zzeg.zzb("Av1Config", "Unsupported initial_display_delay_present_flag");
                return new zzafc(zzgwm.zzj(bArr), i, -1, -1, -1);
            }
            int iZzj6 = zzesVar.zzj(5);
            int i7 = 0;
            while (i7 <= iZzj6) {
                zzesVar.zzh(i5);
                if (zzesVar.zzj(5) > 7) {
                    zzesVar.zzg();
                }
                i7++;
                i5 = 12;
            }
            int iZzj7 = zzesVar.zzj(4);
            int iZzj8 = zzesVar.zzj(4);
            zzesVar.zzh(iZzj7 + 1);
            zzesVar.zzh(iZzj8 + 1);
            if (zzesVar.zzi()) {
                zzesVar.zzh(7);
            }
            zzesVar.zzh(7);
            boolean zZzi4 = zzesVar.zzi();
            if (zZzi4) {
                zzesVar.zzh(2);
            }
            if (zzesVar.zzi() || zzesVar.zzj(1) > 0) {
                if (!zzesVar.zzi()) {
                    zzesVar.zzh(1);
                }
            }
            if (zZzi4) {
                zzesVar.zzh(3);
            }
            zzesVar.zzh(3);
            boolean zZzi5 = zzesVar.zzi();
            if (iZzj5 != 2) {
                if (iZzj5 == 1) {
                }
                if (zzesVar.zzi()) {
                    int iZzj9 = zzesVar.zzj(8);
                    iZzj = zzesVar.zzj(8);
                    int iZzj10 = zzesVar.zzj(8);
                    if (!z || iZzj9 != 1) {
                        i6 = iZzj;
                        iZzj2 = zzesVar.zzj(1);
                    } else if (iZzj != 13) {
                        iZzj9 = 1;
                        i6 = iZzj;
                        iZzj2 = zzesVar.zzj(1);
                    } else if (iZzj10 == 0) {
                        iZzj9 = 1;
                        iZzj2 = 1;
                    } else {
                        iZzj9 = 1;
                        iZzj2 = zzesVar.zzj(1);
                    }
                    int iZzb = zzi.zzb(iZzj9);
                    if (iZzj2 == 1) {
                        i4 = 2;
                    }
                    iZzc = zzi.zzc(i6);
                    i3 = i4;
                    i2 = iZzb;
                } else {
                    i2 = -1;
                    i3 = -1;
                    iZzc = -1;
                }
                return new zzafc(zzgwm.zzj(bArr), i, i2, i3, iZzc);
            }
            if (zZzi5) {
                zzesVar.zzg();
            }
            if (zzesVar.zzi()) {
                z = true;
            }
            if (zzesVar.zzi()) {
                int iZzj11 = zzesVar.zzj(8);
                iZzj = zzesVar.zzj(8);
                int iZzj12 = zzesVar.zzj(8);
                if (!z) {
                    i6 = iZzj;
                    iZzj2 = zzesVar.zzj(1);
                } else {
                    i6 = iZzj;
                    iZzj2 = zzesVar.zzj(1);
                }
                int iZzb2 = zzi.zzb(iZzj11);
                if (iZzj2 == 1) {
                    i4 = 2;
                }
                iZzc = zzi.zzc(i6);
                i3 = i4;
                i2 = iZzb2;
            } else {
                i2 = -1;
                i3 = -1;
                iZzc = -1;
            }
            return new zzafc(zzgwm.zzj(bArr), i, i2, i3, iZzc);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzat.zzb("Error parsing AV1 config", e);
        }
    }
}
