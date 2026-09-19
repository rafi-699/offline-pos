package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.media3.common.C;
import androidx.media3.container.MdtaMetadataEntry;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalt {
    public static void zza(int i, zzap zzapVar, zzt zztVar, zzap zzapVar2, zzap... zzapVarArr) {
        if (zzapVar2 == null) {
            zzapVar2 = new zzap(C.TIME_UNSET, new zzao[0]);
        }
        if (zzapVar != null) {
            zzgwm zzgwmVarZzd = zzapVar.zzd(zzfv.class);
            int size = zzgwmVarZzd.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzfv zzfvVar = (zzfv) zzgwmVarZzd.get(i2);
                if (!zzfvVar.zza.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS) || i == 2) {
                    zzapVar2 = zzapVar2.zzg(zzfvVar);
                }
            }
        }
        for (zzap zzapVar3 : zzapVarArr) {
            zzapVar2 = zzapVar2.zzf(zzapVar3);
        }
        if (zzapVar2.zza() > 0) {
            zztVar.zzl(zzapVar2);
        }
    }

    public static void zzb(int i, zzagr zzagrVar, zzt zztVar) {
        if (i == 1 && zzagrVar.zzb()) {
            zztVar.zzJ(zzagrVar.zza);
            zztVar.zzK(zzagrVar.zzb);
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0288 A[Catch: all -> 0x0200, TryCatch #0 {all -> 0x0200, blocks: (B:9:0x0030, B:11:0x003b, B:13:0x0047, B:16:0x0053, B:19:0x0060, B:22:0x006d, B:25:0x007a, B:28:0x0087, B:30:0x0093, B:38:0x00ae, B:39:0x00cc, B:40:0x00df, B:43:0x00eb, B:46:0x00f8, B:49:0x0105, B:52:0x0112, B:55:0x011f, B:58:0x012c, B:61:0x0139, B:64:0x0146, B:67:0x0153, B:70:0x0163, B:74:0x0177, B:76:0x017d, B:78:0x0192, B:79:0x0199, B:81:0x01a0, B:86:0x01ab, B:91:0x01b7, B:137:0x0288, B:92:0x01cc, B:94:0x01d3, B:96:0x01df, B:97:0x01f3, B:112:0x0220, B:115:0x022d, B:118:0x023a, B:121:0x0247, B:124:0x0253, B:127:0x025f, B:130:0x0269, B:133:0x0275, B:136:0x0281, B:138:0x02a5, B:139:0x02ac), top: B:144:0x0022 }] */
    public static zzao zzc(zzet zzetVar) {
        String str;
        zzao zzajeVar;
        int iZzg = zzetVar.zzg() + zzetVar.zzB();
        int iZzB = zzetVar.zzB();
        int i = (iZzB >> 24) & 255;
        zzao zzaoVarZzd = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzB & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int iZzB2 = zzetVar.zzB();
                    if (zzetVar.zzB() == 1684108385) {
                        zzetVar.zzk(8);
                        String strZzL = zzetVar.zzL(iZzB2 - 16);
                        zzaoVarZzd = new zzaji(C.LANGUAGE_UNDETERMINED, strZzL, strZzL);
                    } else {
                        zzeg.zzc("MetadataUtil", "Failed to parse comment attribute: ".concat(zzfz.zze(iZzB)));
                    }
                } else if (i2 == 7233901 || i2 == 7631467) {
                    zzaoVarZzd = zzd(iZzB, "TIT2", zzetVar);
                } else if (i2 == 6516589 || i2 == 7828084) {
                    zzaoVarZzd = zzd(iZzB, "TCOM", zzetVar);
                } else if (i2 == 6578553) {
                    zzaoVarZzd = zzd(iZzB, "TDRC", zzetVar);
                } else if (i2 == 4280916) {
                    zzaoVarZzd = zzd(iZzB, "TPE1", zzetVar);
                } else if (i2 == 7630703) {
                    zzaoVarZzd = zzd(iZzB, "TSSE", zzetVar);
                } else if (i2 == 6384738) {
                    zzaoVarZzd = zzd(iZzB, "TALB", zzetVar);
                } else if (i2 == 7108978) {
                    zzaoVarZzd = zzd(iZzB, "USLT", zzetVar);
                } else if (i2 == 6776174) {
                    zzaoVarZzd = zzd(iZzB, "TCON", zzetVar);
                } else if (i2 == 6779504) {
                    zzaoVarZzd = zzd(iZzB, "TIT1", zzetVar);
                } else if (i2 == 7173742) {
                    zzaoVarZzd = zzd(iZzB, "MVNM", zzetVar);
                } else if (i2 == 7173737) {
                    zzaoVarZzd = zze(iZzB, "MVIN", zzetVar, true, false);
                } else {
                    String strZze = zzfz.zze(iZzB);
                    StringBuilder sb = new StringBuilder(strZze.length() + 32);
                    sb.append("Skipped unknown metadata entry: ");
                    sb.append(strZze);
                    zzeg.zza("MetadataUtil", sb.toString());
                }
            } else if (iZzB == 1735291493) {
                String strZza = zzajp.zza(zzf(zzetVar) - 1);
                if (strZza != null) {
                    zzajeVar = new zzajt("TCON", null, zzgwm.zzj(strZza));
                    zzaoVarZzd = zzajeVar;
                } else {
                    zzeg.zzc("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzB == 1684632427) {
                zzaoVarZzd = zzg(1684632427, "TPOS", zzetVar);
            } else if (iZzB == 1953655662) {
                zzaoVarZzd = zzg(1953655662, "TRCK", zzetVar);
            } else if (iZzB == 1953329263) {
                zzaoVarZzd = zze(1953329263, "TBPM", zzetVar, true, false);
            } else if (iZzB == 1668311404) {
                zzaoVarZzd = zze(1668311404, "TCMP", zzetVar, true, true);
            } else if (iZzB == 1668249202) {
                int iZzB3 = zzetVar.zzB();
                if (zzetVar.zzB() == 1684108385) {
                    int iZzB4 = zzetVar.zzB();
                    int i3 = zzalj.zza;
                    int i4 = iZzB4 & ViewCompat.MEASURED_SIZE_MASK;
                    if (i4 == 13) {
                        str = "image/jpeg";
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 30);
                        sb2.append("Unrecognized cover art flags: ");
                        sb2.append(i4);
                        zzeg.zzc("MetadataUtil", sb2.toString());
                    } else {
                        zzetVar.zzk(4);
                        int i5 = iZzB3 - 16;
                        byte[] bArr = new byte[i5];
                        zzetVar.zzm(bArr, 0, i5);
                        zzajeVar = new zzaje(str, null, 3, bArr);
                        zzaoVarZzd = zzajeVar;
                    }
                } else {
                    zzeg.zzc("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzB == 1631670868) {
                zzaoVarZzd = zzd(1631670868, "TPE2", zzetVar);
            } else if (iZzB == 1936682605) {
                zzaoVarZzd = zzd(1936682605, "TSOT", zzetVar);
            } else if (iZzB == 1936679276) {
                zzaoVarZzd = zzd(1936679276, "TSOA", zzetVar);
            } else if (iZzB == 1936679282) {
                zzaoVarZzd = zzd(1936679282, "TSOP", zzetVar);
            } else if (iZzB == 1936679265) {
                zzaoVarZzd = zzd(1936679265, "TSO2", zzetVar);
            } else if (iZzB == 1936679791) {
                zzaoVarZzd = zzd(1936679791, "TSOC", zzetVar);
            } else if (iZzB == 1920233063) {
                zzaoVarZzd = zze(1920233063, "ITUNESADVISORY", zzetVar, false, false);
            } else if (iZzB == 1885823344) {
                zzaoVarZzd = zze(1885823344, "ITUNESGAPLESS", zzetVar, false, true);
            } else if (iZzB == 1936683886) {
                zzaoVarZzd = zzd(1936683886, "TVSHOWSORT", zzetVar);
            } else if (iZzB == 1953919848) {
                zzaoVarZzd = zzd(1953919848, "TVSHOW", zzetVar);
            } else if (iZzB == 757935405) {
                int i6 = -1;
                int i7 = -1;
                String strZzL2 = null;
                String strZzL3 = null;
                while (zzetVar.zzg() < iZzg) {
                    int iZzg2 = zzetVar.zzg();
                    int iZzB5 = zzetVar.zzB();
                    int iZzB6 = zzetVar.zzB();
                    zzetVar.zzk(4);
                    if (iZzB6 == 1835360622) {
                        strZzL2 = zzetVar.zzL(iZzB5 - 12);
                    } else {
                        int i8 = iZzB5 - 12;
                        if (iZzB6 == 1851878757) {
                            strZzL3 = zzetVar.zzL(i8);
                        } else {
                            if (iZzB6 == 1684108385) {
                                i7 = iZzB5;
                            }
                            if (iZzB6 == 1684108385) {
                                i6 = iZzg2;
                            }
                            zzetVar.zzk(i8);
                        }
                    }
                }
                if (strZzL2 != null && strZzL3 != null && i6 != -1) {
                    zzetVar.zzh(i6);
                    zzetVar.zzk(16);
                    zzaoVarZzd = new zzajq(strZzL2, strZzL3, zzetVar.zzL(i7 - 16));
                }
            } else {
                String strZze2 = zzfz.zze(iZzB);
                StringBuilder sb3 = new StringBuilder(strZze2.length() + 32);
                sb3.append("Skipped unknown metadata entry: ");
                sb3.append(strZze2);
                zzeg.zza("MetadataUtil", sb3.toString());
            }
            zzetVar.zzh(iZzg);
            return zzaoVarZzd;
        } catch (Throwable th) {
            zzetVar.zzh(iZzg);
            throw th;
        }
    }

    private static zzajt zzd(int i, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            return new zzajt(str, null, zzgwm.zzj(zzetVar.zzL(iZzB - 16)));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse text attribute: ".concat(zzfz.zze(i)));
        return null;
    }

    private static zzajo zze(int i, String str, zzet zzetVar, boolean z, boolean z2) {
        int iZzf = zzf(zzetVar);
        if (z2) {
            iZzf = Math.min(1, iZzf);
        }
        if (iZzf >= 0) {
            return z ? new zzajt(str, null, zzgwm.zzj(Integer.toString(iZzf))) : new zzaji(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iZzf));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzfz.zze(i)));
        return null;
    }

    private static int zzf(zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            int i = iZzB - 16;
            if (i == 1) {
                return zzetVar.zzs();
            }
            if (i == 2) {
                return zzetVar.zzt();
            }
            if (i == 3) {
                return zzetVar.zzx();
            }
            if (i == 4 && (zzetVar.zzn() & 128) == 0) {
                return zzetVar.zzH();
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzajt zzg(int i, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385 && iZzB >= 22) {
            zzetVar.zzk(10);
            int iZzt = zzetVar.zzt();
            if (iZzt > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzt).length());
                sb.append(iZzt);
                String string = sb.toString();
                int iZzt2 = zzetVar.zzt();
                if (iZzt2 > 0) {
                    StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(iZzt2).length());
                    sb2.append(string);
                    sb2.append(DomExceptionUtils.SEPARATOR);
                    sb2.append(iZzt2);
                    string = sb2.toString();
                }
                return new zzajt(str, null, zzgwm.zzj(string));
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzfz.zze(i)));
        return null;
    }
}
