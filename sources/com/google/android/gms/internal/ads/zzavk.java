package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzavk implements zzawe {
    public static final /* synthetic */ zzavk zza;
    public static final /* synthetic */ zzavk zzb;
    public static final /* synthetic */ zzavk zzc;
    public static final /* synthetic */ zzavk zzd;
    public static final /* synthetic */ zzavk zze;
    public static final /* synthetic */ zzavk zzf;
    public static final /* synthetic */ zzavk zzg;
    public static final /* synthetic */ zzavk zzh;
    public static final /* synthetic */ zzavk zzi;
    public static final /* synthetic */ zzavk zzj;
    public static final /* synthetic */ zzavk zzk;
    public static final /* synthetic */ zzavk zzl;
    public static final /* synthetic */ zzavk zzm;
    public static final /* synthetic */ zzavk zzn;
    public static final /* synthetic */ zzavk zzo;
    public static final /* synthetic */ zzavk zzp;
    public static final /* synthetic */ zzavk zzq;
    public static final /* synthetic */ zzavk zzr;
    public static final /* synthetic */ zzavk zzs;
    public static final /* synthetic */ zzavk zzt;
    public static final /* synthetic */ zzavk zzu;
    private final /* synthetic */ int zzv;

    static {
        int i = (((((~574682290) & 203332142) | 828655825) + ((574682290 & 488280686) | 1367367889)) - 2039730118) ^ (1891066487 % 382926234);
        int i2 = (((((~138700754) & 1311190796) | 1098494210) + ((138700754 & 235277837) | 2126145)) - 1303500118) ^ (631340353 % 54449299);
        int i3 = (((((~429857344) & 761470753) | 244716435) + ((429857344 & 862030880) | 1585885407)) - (-1912977126)) ^ (1209597698 % 1200977805);
        int i4 = (((((~353056618) & 587352576) | 1209239528) + ((353056618 & 1728108930) | 1420269559)) - (-1847305937)) ^ (1896236448 % 1127167744);
        int i5 = (((((~899633766) & 123837830) | 368257288) + ((899633766 & 167810182) | 1023429240)) - 1335244442) ^ (2104001379 % 2013966848);
        int i6 = (((((~1451163042) & 1144033732) | 979119168) + ((1451163042 & 1142985108) | 17523737)) - 1635219142) ^ (1178835412 % 674426555);
        int i7 = (((((~2129768394) & 1627076842) | 1930240353) + ((2129768394 & 384997514) | 369722160)) - (-1995771891)) ^ (1450967523 % 42186306);
        zzu = new zzavk((((((~880944650) & 1717883648) | 10231720) + ((880944650 & 1718140932) | 277359766)) - 1470954277) ^ (2122533302 % 1588279465));
        zzt = new zzavk((((((~2105342203) & 63587109) | 1700430907) + ((2105342203 & 42025732) | 358031402)) - 2053339984) ^ (1059789835 % 1012707329));
        zzs = new zzavk((((((~217704412) & 144255288) | 1174857666) + ((217704412 & 1788447288) | 1667270208)) - (-1441824169)) ^ (1234644696 % 220282619));
        zzr = new zzavk(i7);
        zzq = new zzavk(i4);
        zzp = new zzavk(i5);
        zzavk zzavkVar = new zzavk(i6);
        int i8 = (((((~363159161) & 562794784) | 672605403) + ((363159161 & 25727904) | 2081572569)) - (-1616076716)) ^ (912078408 % 135177290);
        int i9 = (((((~1362243428) & 18451060) | 1179867339) + ((1362243428 & 558662325) | 550966467)) - 1623872455) ^ (1106211926 % 327305250);
        int i10 = (((((~1725362297) & 1360741300) | 1109702041) + ((1725362297 & 354116135) | 1147188355)) - (-1834394863)) ^ (1760481135 % 279527351);
        int i11 = (((((~167368542) & 67146177) | 1656237739) + ((167368542 & 1145098568) | 1113671327)) - (-1733089599)) ^ (1999038585 % 574620392);
        int i12 = (((((~1855103807) & 659964675) | 1290440236) + ((1855103807 & 588562691) | 482511980)) - 1987315200) ^ (988506952 % 614340012);
        int i13 = (((((~309667127) & 3230344) | 101519449) + ((309667127 & 607439488) | 793023522)) - 846909944) ^ (1953534826 % 1902736997);
        int i14 = (((((~682736626) & 1985796848) | 208315317) + ((682736626 & 1922324801) | 8464129)) - 2089727599) ^ (649022765 % 608034986);
        int i15 = (((((~2068224547) & 575179716) | 1587938398) + ((2068224547 & 1013484418) | 1605526586)) - (-1152499266)) ^ (1603386966 % 1010764797);
        int i16 = (((((~1281944976) & 1463473736) | 847256033) + ((1281944976 & 1698424328) | 948255187)) - (-1974214194)) ^ (1727952741 % 1091714937);
        zzo = zzavkVar;
        zzn = new zzavk(i3);
        zzm = new zzavk(i8);
        zzl = new zzavk(i9);
        zzk = new zzavk(i10);
        zzj = new zzavk(i2);
        zzi = new zzavk(i11);
        zzh = new zzavk(i12);
        zzg = new zzavk(i13);
        zzf = new zzavk(i);
        zze = new zzavk(i14);
        zzd = new zzavk(i15);
        zzc = new zzavk(i16);
        zzb = new zzavk(1);
        zza = new zzavk(0);
    }

    private /* synthetic */ zzavk(int i) {
        this.zzv = i;
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzauw zzauwVar;
        zzauw zzauwVar2;
        long j = 1;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        switch (this.zzv) {
                                            case 0:
                                                zzawh zzawhVar = (zzawh) obj;
                                                zzawd zzawdVar = zzawhVar.zzb;
                                                long jZzm = zzawdVar.zzc().zzm();
                                                if (zzawdVar.zzc().zzm() != 0) {
                                                    zzawhVar.zzd.zza(jZzm);
                                                }
                                                return Optional.empty();
                                            case 1:
                                                try {
                                                    zzawd zzawdVar2 = ((zzawh) obj).zzb;
                                                    long jZzm2 = zzawdVar2.zzc().zzm();
                                                    zzawm zzawmVarZzc = zzawdVar2.zzc();
                                                    zzawm zzawmVarZzc2 = zzawdVar2.zzc();
                                                    List listZzo = zzawmVarZzc2.zzo();
                                                    if (jZzm2 < 0) {
                                                        jZzm2 += (long) (listZzo.size() + 1);
                                                    }
                                                    if (jZzm2 < 0 || jZzm2 >= listZzo.size() + 1) {
                                                        throw new zzawk();
                                                    }
                                                    listZzo.add((int) jZzm2, zzawmVarZzc);
                                                    zzawdVar2.zzb(zzawmVarZzc2);
                                                    return Optional.empty();
                                                } catch (zzawk unused) {
                                                    zzauwVar = zzauw.zzI;
                                                }
                                                break;
                                            case 2:
                                                zzawh zzawhVar2 = (zzawh) obj;
                                                zzawd zzawdVar3 = zzawhVar2.zzb;
                                                long jZzm3 = zzawdVar3.zzc().zzm();
                                                if (zzawdVar3.zzc().zzm() == 0) {
                                                    zzawhVar2.zzd.zza(jZzm3);
                                                }
                                                return Optional.empty();
                                            case 3:
                                                zzawd zzawdVar4 = ((zzawh) obj).zzb;
                                                zzawdVar4.zzb(zzawm.zzb(zzawdVar4.zzc().zzo().size()));
                                                return Optional.empty();
                                            case 4:
                                                zzawd zzawdVar5 = ((zzawh) obj).zzb;
                                                zzawdVar5.zzb(zzawm.zzb(zzawdVar5.zzc().zzn().zza.length));
                                                return Optional.empty();
                                            case 5:
                                                zzawd zzawdVar6 = ((zzawh) obj).zzb;
                                                zzawdVar6.zzb(zzawm.zzc(Math.log(zzawdVar6.zzc().zzq())));
                                                return Optional.empty();
                                            case 6:
                                                zzawd zzawdVar7 = ((zzawh) obj).zzb;
                                                long jZzm4 = zzawdVar7.zzc().zzm();
                                                long jZzm5 = zzawdVar7.zzc().zzm();
                                                if (jZzm4 == 0 || jZzm5 == 0) {
                                                    j = 0;
                                                }
                                                zzawdVar7.zzb(zzawm.zzb(j));
                                                return Optional.empty();
                                            case 7:
                                                zzawd zzawdVar8 = ((zzawh) obj).zzb;
                                                if (zzawdVar8.zzc().zzm() != 0) {
                                                    j = 0;
                                                }
                                                zzawdVar8.zzb(zzawm.zzb(j));
                                                return Optional.empty();
                                            case 8:
                                                zzawd zzawdVar9 = ((zzawh) obj).zzb;
                                                long jZzm6 = zzawdVar9.zzc().zzm();
                                                long jZzm7 = zzawdVar9.zzc().zzm();
                                                if (jZzm6 == 0 && jZzm7 == 0) {
                                                    j = 0;
                                                }
                                                zzawdVar9.zzb(zzawm.zzb(j));
                                                return Optional.empty();
                                            case 9:
                                                zzawh zzawhVar3 = (zzawh) obj;
                                                zzawd zzawdVar10 = zzawhVar3.zzb;
                                                try {
                                                    int iCompare = new zzawi(false).compare(zzawdVar10.zzc(), zzawdVar10.zzc());
                                                    zzawd zzawdVar11 = zzawhVar3.zzb;
                                                    if (iCompare >= 0) {
                                                        j = 0;
                                                    }
                                                    zzawdVar11.zzb(zzawm.zzb(j));
                                                    return Optional.empty();
                                                } catch (IllegalArgumentException unused2) {
                                                    return Optional.of(zzauw.zzd);
                                                }
                                            case 10:
                                                int[] iArr = {1944216249, 348137722, 926438168, 13122018, 1882968836, -1273372307, 246144337, 1723705710, 1677157265};
                                                int i = iArr[0];
                                                int i2 = iArr[1];
                                                int i3 = iArr[2];
                                                int i4 = iArr[3];
                                                int i5 = iArr[4];
                                                int i6 = iArr[5];
                                                int i7 = iArr[6];
                                                int i8 = iArr[7];
                                                int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
                                                int i10 = i8 % 1677157265;
                                                zzawh zzawhVar4 = (zzawh) obj;
                                                try {
                                                    zzawd zzawdVar12 = zzawhVar4.zzb;
                                                    long jZzm8 = zzawdVar12.zzc().zzm();
                                                    zzavc zzavcVar = zzawhVar4.zza;
                                                    zzawd zzawdVar13 = new zzawd(i10 ^ i9);
                                                    for (int i11 = 0; i11 < zzawdVar12.zzb; i11++) {
                                                        try {
                                                            zzawdVar13.zzb(zzawm.zzj((zzawm) zzawdVar12.zza.get(i11)));
                                                        } catch (zzawc e) {
                                                            throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                                                        }
                                                    }
                                                    zzavv zzavvVar = zzawhVar4.zzd;
                                                    new zzawh(zzavcVar, zzawdVar13, new zzavv(zzavvVar.zzb, zzavvVar.zza, zzavvVar.zzc.zzc(), zzavvVar.zzd)).zzd.zza(jZzm8);
                                                    zzawdVar12.zzb(zzawm.zza(new zzavm()));
                                                    return Optional.empty();
                                                } catch (zzavt | zzavu unused3) {
                                                    zzauwVar = zzauw.zzt;
                                                }
                                                break;
                                            case 11:
                                                try {
                                                    zzawd zzawdVar14 = ((zzawh) obj).zzb;
                                                    zzawdVar14.zzb(zzawm.zza(zzawdVar14.zzc().zzi((Class) zzawdVar14.zzc().zzl())));
                                                    return Optional.empty();
                                                } catch (zzawj unused4) {
                                                    zzauwVar = zzauw.zzp;
                                                }
                                                break;
                                            case 12:
                                                zzawd zzawdVar15 = ((zzawh) obj).zzb;
                                                long jZzm9 = zzawdVar15.zzc().zzm();
                                                long jZzm10 = zzawdVar15.zzc().zzm();
                                                if (jZzm9 == 0) {
                                                    return Optional.of(zzauw.zzF);
                                                }
                                                zzawdVar15.zzb(zzawm.zzb(jZzm10 % jZzm9));
                                                return Optional.empty();
                                            case 13:
                                                zzawd zzawdVar16 = ((zzawh) obj).zzb;
                                                zzawdVar16.zzb(zzawm.zzc(zzawdVar16.zzc().zzq() * zzawdVar16.zzc().zzq()));
                                                return Optional.empty();
                                            case 14:
                                                zzawd zzawdVar17 = ((zzawh) obj).zzb;
                                                zzawdVar17.zzb(zzawm.zzb(zzawdVar17.zzc().zzm() * zzawdVar17.zzc().zzm()));
                                                return Optional.empty();
                                            case 15:
                                                zzawd zzawdVar18 = ((zzawh) obj).zzb;
                                                long jZzm11 = zzawdVar18.zzc().zzm();
                                                ArrayList arrayList = new ArrayList();
                                                for (long j2 = 0; j2 < jZzm11; j2++) {
                                                    arrayList.add(zzawdVar18.zzc());
                                                }
                                                Collections.reverse(arrayList);
                                                zzawdVar18.zzb(zzawm.zze(arrayList));
                                                return Optional.empty();
                                            case 16:
                                                zzawd zzawdVar19 = ((zzawh) obj).zzb;
                                                zzawdVar19.zzb(zzawm.zzc(Math.pow(zzawdVar19.zzc().zzq(), zzawdVar19.zzc().zzq())));
                                                return Optional.empty();
                                            case 17:
                                                ((zzawh) obj).zzb.zzb(zzawm.zza(null));
                                                return Optional.empty();
                                            case 18:
                                                zzawh zzawhVar5 = (zzawh) obj;
                                                ByteBuffer byteBufferWrap = ByteBuffer.wrap(zzawhVar5.zzd.zzf((((((~1201162069L) & 403189074) | 1043752718) + ((1201162069 & 95979632) | 900760100)) - 1766798336) ^ (507611410 % 329370448)).zza());
                                                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                                                zzawhVar5.zzb.zzb(zzawm.zzc(Double.longBitsToDouble(byteBufferWrap.getLong())));
                                                return Optional.empty();
                                            case 19:
                                                zzawh zzawhVar6 = (zzawh) obj;
                                                zzawhVar6.zzb.zzb(zzawm.zzb(zzawhVar6.zzd.zze()));
                                                return Optional.empty();
                                            default:
                                                long j3 = ((((~346030096L) & 203234088) | 575197286) + ((346030096 & 2352425736L) | 2745332883L)) - 1505840317;
                                                long j4 = 1246101662 % 372004513;
                                                long j5 = ((((~1810821955L) & 1747262537) | 563863662) + ((1810821955 & 1295301633) | 94020008)) - 1690999106;
                                                long j6 = 1675644664 % 749217043;
                                                zzawh zzawhVar7 = (zzawh) obj;
                                                zzavv zzavvVar2 = zzawhVar7.zzd;
                                                long jZze = zzavvVar2.zze();
                                                if (jZze < 0 || jZze > (j3 ^ j4)) {
                                                    zzauwVar2 = zzauw.zzz;
                                                } else {
                                                    if (((j5 ^ j6) & jZze) == 0) {
                                                        zzawhVar7.zzb.zzb(zzawm.zzd(zzavvVar2.zzf(jZze)));
                                                        return Optional.empty();
                                                    }
                                                    zzauwVar2 = zzauw.zze;
                                                }
                                                return Optional.of(zzauwVar2);
                                        }
                                    } catch (zzavt e2) {
                                        e = e2;
                                        throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                                    }
                                } catch (zzavt | zzavu unused5) {
                                    zzauwVar = zzauw.zzi;
                                }
                            } catch (zzawc e3) {
                                e = e3;
                                throw new AssertionError(zzavo.zza("CEiv6BFfPnitUE+D"), e);
                            }
                        } catch (zzavs unused6) {
                            zzauwVar = zzauw.zzD;
                        }
                    } catch (zzawb unused7) {
                        zzauwVar = zzauw.zzx;
                    }
                } catch (zzawc unused8) {
                    zzauwVar = zzauw.zza;
                }
            } catch (zzawj unused9) {
                zzauwVar = zzauw.zzy;
            }
        } catch (zzavu unused10) {
            zzauwVar = zzauw.zzz;
        }
        return Optional.of(zzauwVar);
    }
}
