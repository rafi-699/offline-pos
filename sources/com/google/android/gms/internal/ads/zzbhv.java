package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$1 */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zza;

        static {
            int[] iArr = new int[zzied.values().length];
            zza = iArr;
            try {
                iArr[zzied.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                zza[zzied.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                zza[zzied.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                zza[zzied.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                zza[zzied.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                zza[zzied.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                zza[zzied.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zza extends zziee<zza, zzb> implements zzf {
        private static final zza zzB;
        private static volatile zzifx<zza> zzC = null;
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        public static final int zzk = 17;
        private int zzl;
        private int zzm;
        private zzg zzo;
        private zzi zzp;
        private zzk zzv;
        private zzah zzw;
        private zzac zzx;
        private zzx zzy;
        private zzz zzz;
        private int zzn = 1000;
        private zzieq<zzd> zzu = zzbM();
        private zzieq<zzat> zzA = zzbM();

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zza$zza */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum EnumC0021zza implements zziei {
            AD_INITIATER_UNSPECIFIED(0),
            BANNER(1),
            DFP_BANNER(2),
            INTERSTITIAL(3),
            DFP_INTERSTITIAL(4),
            NATIVE_EXPRESS(5),
            AD_LOADER(6),
            REWARD_BASED_VIDEO_AD(7),
            BANNER_SEARCH_ADS(8),
            GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
            APP_OPEN(10),
            REWARDED_INTERSTITIAL(11);

            public static final int zzm = 0;
            public static final int zzn = 1;
            public static final int zzo = 2;
            public static final int zzp = 3;
            public static final int zzq = 4;
            public static final int zzr = 5;
            public static final int zzs = 6;
            public static final int zzt = 7;
            public static final int zzu = 8;
            public static final int zzv = 9;
            public static final int zzw = 10;
            public static final int zzx = 11;
            private static final zziej<EnumC0021zza> zzy = new zziej<EnumC0021zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zza.zza.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public EnumC0021zza zzb(int i) {
                    return EnumC0021zza.zzc(i);
                }
            };
            private final int zzz;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zza$zza$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<EnumC0021zza> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public EnumC0021zza zzb(int i) {
                    return EnumC0021zza.zzc(i);
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zza$zza$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class C0022zza implements zziek {
                static final zziek zza = new C0022zza();

                private C0022zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return EnumC0021zza.zzc(i) != null;
                }
            }

            EnumC0021zza(int i) {
                this.zzz = i;
            }

            public static EnumC0021zza zzc(int i) {
                switch (i) {
                    case 0:
                        return AD_INITIATER_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return DFP_BANNER;
                    case 3:
                        return INTERSTITIAL;
                    case 4:
                        return DFP_INTERSTITIAL;
                    case 5:
                        return NATIVE_EXPRESS;
                    case 6:
                        return AD_LOADER;
                    case 7:
                        return REWARD_BASED_VIDEO_AD;
                    case 8:
                        return BANNER_SEARCH_ADS;
                    case 9:
                        return GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                    case 10:
                        return APP_OPEN;
                    case 11:
                        return REWARDED_INTERSTITIAL;
                    default:
                        return null;
                }
            }

            public static zziej<EnumC0021zza> zzd() {
                return zzy;
            }

            public static zziek zze() {
                return C0022zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzz);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzz;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zzb extends zzidy<zza, zzb> implements zzf {
            private zzb() {
                super(zza.zzB);
            }

            /* synthetic */ zzb(byte[] bArr) {
                this();
            }

            public zzb zzA(int i, zzd zzdVar) {
                zzbg();
                ((zza) this.zza).zzX(i, zzdVar);
                return this;
            }

            public zzb zzB(zzd.zzb zzbVar) {
                zzbg();
                ((zza) this.zza).zzW(zzbVar.zzbu());
                return this;
            }

            public zzb zzC(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zza) this.zza).zzX(i, zzbVar.zzbu());
                return this;
            }

            public zzb zzD(Iterable<? extends zzd> iterable) {
                zzbg();
                ((zza) this.zza).zzaa(iterable);
                return this;
            }

            public zzb zzE() {
                zzbg();
                ((zza) this.zza).zzab();
                return this;
            }

            public zzb zzF(int i) {
                zzbg();
                ((zza) this.zza).zzac(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzG() {
                return ((zza) this.zza).zzG();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzk zzH() {
                return ((zza) this.zza).zzH();
            }

            public zzb zzI(zzk zzkVar) {
                zzbg();
                ((zza) this.zza).zzad(zzkVar);
                return this;
            }

            public zzb zzJ(zzk.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzad(zzaVar.zzbu());
                return this;
            }

            public zzb zzK(zzk zzkVar) {
                zzbg();
                ((zza) this.zza).zzag(zzkVar);
                return this;
            }

            public zzb zzL() {
                zzbg();
                ((zza) this.zza).zzah();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzM() {
                return ((zza) this.zza).zzM();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzah zzN() {
                return ((zza) this.zza).zzN();
            }

            public zzb zzO(zzah zzahVar) {
                zzbg();
                ((zza) this.zza).zzai(zzahVar);
                return this;
            }

            public zzb zzP(zzah.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzai(zzaVar.zzbu());
                return this;
            }

            public zzb zzQ(zzah zzahVar) {
                zzbg();
                ((zza) this.zza).zzaj(zzahVar);
                return this;
            }

            public zzb zzR() {
                zzbg();
                ((zza) this.zza).zzan();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzS() {
                return ((zza) this.zza).zzS();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzac zzT() {
                return ((zza) this.zza).zzT();
            }

            public zzb zzU(zzac zzacVar) {
                zzbg();
                ((zza) this.zza).zzao(zzacVar);
                return this;
            }

            public zzb zzV(zzac.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzao(zzaVar.zzbu());
                return this;
            }

            public zzb zzW(zzac zzacVar) {
                zzbg();
                ((zza) this.zza).zzap(zzacVar);
                return this;
            }

            public zzb zzX() {
                zzbg();
                ((zza) this.zza).zzaq();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzY() {
                return ((zza) this.zza).zzY();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzx zzZ() {
                return ((zza) this.zza).zzZ();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zza() {
                return ((zza) this.zza).zza();
            }

            public zzb zzaa(zzx zzxVar) {
                zzbg();
                ((zza) this.zza).zzar(zzxVar);
                return this;
            }

            public zzb zzab(zzx.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzar(zzaVar.zzbu());
                return this;
            }

            public zzb zzac(zzx zzxVar) {
                zzbg();
                ((zza) this.zza).zzas(zzxVar);
                return this;
            }

            public zzb zzad() {
                zzbg();
                ((zza) this.zza).zzat();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzae() {
                return ((zza) this.zza).zzae();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzz zzaf() {
                return ((zza) this.zza).zzaf();
            }

            public zzb zzag(zzz zzzVar) {
                zzbg();
                ((zza) this.zza).zzau(zzzVar);
                return this;
            }

            public zzb zzah(zzz.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzau(zzaVar.zzbu());
                return this;
            }

            public zzb zzai(zzz zzzVar) {
                zzbg();
                ((zza) this.zza).zzav(zzzVar);
                return this;
            }

            public zzb zzaj() {
                zzbg();
                ((zza) this.zza).zzaw();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public List<zzat> zzak() {
                return Collections.unmodifiableList(((zza) this.zza).zzak());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public int zzal() {
                return ((zza) this.zza).zzal();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzat zzam(int i) {
                return ((zza) this.zza).zzam(i);
            }

            public zzb zzan(int i, zzat zzatVar) {
                zzbg();
                ((zza) this.zza).zzax(i, zzatVar);
                return this;
            }

            public zzb zzao(int i, zzat.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzax(i, zzaVar.zzbu());
                return this;
            }

            public zzb zzap(zzat zzatVar) {
                zzbg();
                ((zza) this.zza).zzay(zzatVar);
                return this;
            }

            public zzb zzaq(int i, zzat zzatVar) {
                zzbg();
                ((zza) this.zza).zzaz(i, zzatVar);
                return this;
            }

            public zzb zzar(zzat.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzay(zzaVar.zzbu());
                return this;
            }

            public zzb zzas(int i, zzat.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzaz(i, zzaVar.zzbu());
                return this;
            }

            public zzb zzat(Iterable<? extends zzat> iterable) {
                zzbg();
                ((zza) this.zza).zzaA(iterable);
                return this;
            }

            public zzb zzau() {
                zzbg();
                ((zza) this.zza).zzaB();
                return this;
            }

            public zzb zzav(int i) {
                zzbg();
                ((zza) this.zza).zzaC(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public EnumC0021zza zzb() {
                return ((zza) this.zza).zzb();
            }

            public zzb zzc(EnumC0021zza enumC0021zza) {
                zzbg();
                ((zza) this.zza).zzF(enumC0021zza);
                return this;
            }

            public zzb zzd() {
                zzbg();
                ((zza) this.zza).zzI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zze() {
                return ((zza) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzq zzf() {
                return ((zza) this.zza).zzf();
            }

            public zzb zzg(zzq zzqVar) {
                zzbg();
                ((zza) this.zza).zzJ(zzqVar);
                return this;
            }

            public zzb zzh() {
                zzbg();
                ((zza) this.zza).zzK();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzi() {
                return ((zza) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzg zzj() {
                return ((zza) this.zza).zzj();
            }

            public zzb zzk(zzg zzgVar) {
                zzbg();
                ((zza) this.zza).zzL(zzgVar);
                return this;
            }

            public zzb zzl(zzg.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzL(zzaVar.zzbu());
                return this;
            }

            public zzb zzm(zzg zzgVar) {
                zzbg();
                ((zza) this.zza).zzO(zzgVar);
                return this;
            }

            public zzb zzn() {
                zzbg();
                ((zza) this.zza).zzP();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public boolean zzo() {
                return ((zza) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzi zzp() {
                return ((zza) this.zza).zzp();
            }

            public zzb zzq(zzi zziVar) {
                zzbg();
                ((zza) this.zza).zzQ(zziVar);
                return this;
            }

            public zzb zzr(zzi.zza zzaVar) {
                zzbg();
                ((zza) this.zza).zzQ(zzaVar.zzbu());
                return this;
            }

            public zzb zzs(zzi zziVar) {
                zzbg();
                ((zza) this.zza).zzR(zziVar);
                return this;
            }

            public zzb zzt() {
                zzbg();
                ((zza) this.zza).zzU();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public List<zzd> zzu() {
                return Collections.unmodifiableList(((zza) this.zza).zzu());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public int zzv() {
                return ((zza) this.zza).zzv();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzf
            public zzd zzw(int i) {
                return ((zza) this.zza).zzw(i);
            }

            public zzb zzx(int i, zzd zzdVar) {
                zzbg();
                ((zza) this.zza).zzV(i, zzdVar);
                return this;
            }

            public zzb zzy(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zza) this.zza).zzV(i, zzbVar.zzbu());
                return this;
            }

            public zzb zzz(zzd zzdVar) {
                zzbg();
                ((zza) this.zza).zzW(zzdVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzB = zzaVar;
            zziee.zzbu(zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzA(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zza) zziee.zzbZ(zzB, zzideVar, zzidoVar);
        }

        public static zzb zzB() {
            return (zzb) zzB.zzbn();
        }

        public static zzb zzC(zza zzaVar) {
            return (zzb) zzB.zzbo(zzaVar);
        }

        public static zza zzD() {
            return zzB;
        }

        public static zzifx<zza> zzE() {
            return zzB.zzbd();
        }

        /* JADX INFO: renamed from: zzaE */
        public void zzF(EnumC0021zza enumC0021zza) {
            this.zzm = enumC0021zza.zza();
            this.zzl |= 1;
        }

        /* JADX INFO: renamed from: zzaF */
        public void zzI() {
            this.zzl &= -2;
            this.zzm = 0;
        }

        /* JADX INFO: renamed from: zzaG */
        public void zzJ(zzq zzqVar) {
            this.zzn = zzqVar.zza();
            this.zzl |= 2;
        }

        /* JADX INFO: renamed from: zzaH */
        public void zzK() {
            this.zzl &= -3;
            this.zzn = 1000;
        }

        /* JADX INFO: renamed from: zzaI */
        public void zzL(zzg zzgVar) {
            zzgVar.getClass();
            this.zzo = zzgVar;
            this.zzl |= 4;
        }

        /* JADX INFO: renamed from: zzaJ */
        public void zzO(zzg zzgVar) {
            zzgVar.getClass();
            zzg zzgVar2 = this.zzo;
            if (zzgVar2 != null && zzgVar2 != zzg.zzz()) {
                zzg.zza zzaVarZzy = zzg.zzy(zzgVar2);
                zzaVarZzy.zzbo(zzgVar);
                zzgVar = zzaVarZzy.zzbt();
            }
            this.zzo = zzgVar;
            this.zzl |= 4;
        }

        /* JADX INFO: renamed from: zzaK */
        public void zzP() {
            this.zzo = null;
            this.zzl &= -5;
        }

        /* JADX INFO: renamed from: zzaL */
        public void zzQ(zzi zziVar) {
            zziVar.getClass();
            this.zzp = zziVar;
            this.zzl |= 8;
        }

        /* JADX INFO: renamed from: zzcA */
        public void zzav(zzz zzzVar) {
            zzzVar.getClass();
            zzz zzzVar2 = this.zzz;
            if (zzzVar2 != null && zzzVar2 != zzz.zzA()) {
                zzz.zza zzaVarZzz = zzz.zzz(zzzVar2);
                zzaVarZzz.zzbo(zzzVar);
                zzzVar = zzaVarZzz.zzbt();
            }
            this.zzz = zzzVar;
            this.zzl |= 256;
        }

        /* JADX INFO: renamed from: zzcB */
        public void zzaw() {
            this.zzz = null;
            this.zzl &= -257;
        }

        private void zzcC() {
            zzieq<zzat> zzieqVar = this.zzA;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzA = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzcD */
        public void zzax(int i, zzat zzatVar) {
            zzatVar.getClass();
            zzcC();
            this.zzA.set(i, zzatVar);
        }

        /* JADX INFO: renamed from: zzcE */
        public void zzay(zzat zzatVar) {
            zzatVar.getClass();
            zzcC();
            this.zzA.add(zzatVar);
        }

        /* JADX INFO: renamed from: zzcF */
        public void zzaz(int i, zzat zzatVar) {
            zzatVar.getClass();
            zzcC();
            this.zzA.add(i, zzatVar);
        }

        /* JADX INFO: renamed from: zzcG */
        public void zzaA(Iterable<? extends zzat> iterable) {
            zzcC();
            zzicj.zzaW(iterable, this.zzA);
        }

        /* JADX INFO: renamed from: zzcH */
        public void zzaB() {
            this.zzA = zzbM();
        }

        /* JADX INFO: renamed from: zzcI */
        public void zzaC(int i) {
            zzcC();
            this.zzA.remove(i);
        }

        /* JADX INFO: renamed from: zzce */
        public void zzR(zzi zziVar) {
            zziVar.getClass();
            zzi zziVar2 = this.zzp;
            if (zziVar2 != null && zziVar2 != zzi.zzD()) {
                zzi.zza zzaVarZzC = zzi.zzC(zziVar2);
                zzaVarZzC.zzbo(zziVar);
                zziVar = zzaVarZzC.zzbt();
            }
            this.zzp = zziVar;
            this.zzl |= 8;
        }

        /* JADX INFO: renamed from: zzcf */
        public void zzU() {
            this.zzp = null;
            this.zzl &= -9;
        }

        private void zzcg() {
            zzieq<zzd> zzieqVar = this.zzu;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzu = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzch */
        public void zzV(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzcg();
            this.zzu.set(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzci */
        public void zzW(zzd zzdVar) {
            zzdVar.getClass();
            zzcg();
            this.zzu.add(zzdVar);
        }

        /* JADX INFO: renamed from: zzcj */
        public void zzX(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzcg();
            this.zzu.add(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzck */
        public void zzaa(Iterable<? extends zzd> iterable) {
            zzcg();
            zzicj.zzaW(iterable, this.zzu);
        }

        /* JADX INFO: renamed from: zzcl */
        public void zzab() {
            this.zzu = zzbM();
        }

        /* JADX INFO: renamed from: zzcm */
        public void zzac(int i) {
            zzcg();
            this.zzu.remove(i);
        }

        /* JADX INFO: renamed from: zzcn */
        public void zzad(zzk zzkVar) {
            zzkVar.getClass();
            this.zzv = zzkVar;
            this.zzl |= 16;
        }

        /* JADX INFO: renamed from: zzco */
        public void zzag(zzk zzkVar) {
            zzkVar.getClass();
            zzk zzkVar2 = this.zzv;
            if (zzkVar2 != null && zzkVar2 != zzk.zzB()) {
                zzk.zza zzaVarZzA = zzk.zzA(zzkVar2);
                zzaVarZzA.zzbo(zzkVar);
                zzkVar = zzaVarZzA.zzbt();
            }
            this.zzv = zzkVar;
            this.zzl |= 16;
        }

        /* JADX INFO: renamed from: zzcp */
        public void zzah() {
            this.zzv = null;
            this.zzl &= -17;
        }

        /* JADX INFO: renamed from: zzcq */
        public void zzai(zzah zzahVar) {
            zzahVar.getClass();
            this.zzw = zzahVar;
            this.zzl |= 32;
        }

        /* JADX INFO: renamed from: zzcr */
        public void zzaj(zzah zzahVar) {
            zzahVar.getClass();
            zzah zzahVar2 = this.zzw;
            if (zzahVar2 != null && zzahVar2 != zzah.zzE()) {
                zzah.zza zzaVarZzB = zzah.zzB(zzahVar2);
                zzaVarZzB.zzbo(zzahVar);
                zzahVar = zzaVarZzB.zzbt();
            }
            this.zzw = zzahVar;
            this.zzl |= 32;
        }

        /* JADX INFO: renamed from: zzcs */
        public void zzan() {
            this.zzw = null;
            this.zzl &= -33;
        }

        /* JADX INFO: renamed from: zzct */
        public void zzao(zzac zzacVar) {
            zzacVar.getClass();
            this.zzx = zzacVar;
            this.zzl |= 64;
        }

        /* JADX INFO: renamed from: zzcu */
        public void zzap(zzac zzacVar) {
            zzacVar.getClass();
            zzac zzacVar2 = this.zzx;
            if (zzacVar2 != null && zzacVar2 != zzac.zzs()) {
                zzac.zza zzaVarZzr = zzac.zzr(zzacVar2);
                zzaVarZzr.zzbo(zzacVar);
                zzacVar = zzaVarZzr.zzbt();
            }
            this.zzx = zzacVar;
            this.zzl |= 64;
        }

        /* JADX INFO: renamed from: zzcv */
        public void zzaq() {
            this.zzx = null;
            this.zzl &= -65;
        }

        /* JADX INFO: renamed from: zzcw */
        public void zzar(zzx zzxVar) {
            zzxVar.getClass();
            this.zzy = zzxVar;
            this.zzl |= 128;
        }

        /* JADX INFO: renamed from: zzcx */
        public void zzas(zzx zzxVar) {
            zzxVar.getClass();
            zzx zzxVar2 = this.zzy;
            if (zzxVar2 != null && zzxVar2 != zzx.zzt()) {
                zzx.zza zzaVarZzs = zzx.zzs(zzxVar2);
                zzaVarZzs.zzbo(zzxVar);
                zzxVar = zzaVarZzs.zzbt();
            }
            this.zzy = zzxVar;
            this.zzl |= 128;
        }

        /* JADX INFO: renamed from: zzcy */
        public void zzat() {
            this.zzy = null;
            this.zzl &= -129;
        }

        /* JADX INFO: renamed from: zzcz */
        public void zzau(zzz zzzVar) {
            zzzVar.getClass();
            this.zzz = zzzVar;
            this.zzl |= 256;
        }

        public static zza zzk(ByteBuffer byteBuffer) throws zziet {
            return (zza) zziee.zzbR(zzB, byteBuffer);
        }

        public static zza zzl(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zza) zziee.zzbQ(zzB, byteBuffer, zzidoVar);
        }

        public static zza zzm(zzida zzidaVar) throws zziet {
            return (zza) zziee.zzbS(zzB, zzidaVar);
        }

        public static zza zzn(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zza) zziee.zzbT(zzB, zzidaVar, zzidoVar);
        }

        public static zza zzq(byte[] bArr) throws zziet {
            return (zza) zziee.zzbU(zzB, bArr);
        }

        public static zza zzr(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zza) zziee.zzbV(zzB, bArr, zzidoVar);
        }

        public static zza zzs(InputStream inputStream) throws IOException {
            return (zza) zziee.zzbW(zzB, inputStream);
        }

        public static zza zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zza) zziee.zzbX(zzB, inputStream, zzidoVar);
        }

        public static zza zzx(InputStream inputStream) throws IOException {
            return (zza) zzca(zzB, inputStream);
        }

        public static zza zzy(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zza) zzcb(zzB, inputStream, zzidoVar);
        }

        public static zza zzz(zzide zzideVar) throws IOException {
            return (zza) zziee.zzbY(zzB, zzideVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzG() {
            return (this.zzl & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzk zzH() {
            zzk zzkVar = this.zzv;
            return zzkVar == null ? zzk.zzB() : zzkVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzM() {
            return (this.zzl & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzah zzN() {
            zzah zzahVar = this.zzw;
            return zzahVar == null ? zzah.zzE() : zzahVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzS() {
            return (this.zzl & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzac zzT() {
            zzac zzacVar = this.zzx;
            return zzacVar == null ? zzac.zzs() : zzacVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzY() {
            return (this.zzl & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzx zzZ() {
            zzx zzxVar = this.zzy;
            return zzxVar == null ? zzx.zzt() : zzxVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zza() {
            return (this.zzl & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzae() {
            return (this.zzl & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzz zzaf() {
            zzz zzzVar = this.zzz;
            return zzzVar == null ? zzz.zzA() : zzzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public List<zzat> zzak() {
            return this.zzA;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public int zzal() {
            return this.zzA.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzat zzam(int i) {
            return this.zzA.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public EnumC0021zza zzb() {
            EnumC0021zza enumC0021zzaZzc = EnumC0021zza.zzc(this.zzm);
            return enumC0021zzaZzc == null ? EnumC0021zza.AD_INITIATER_UNSPECIFIED : enumC0021zzaZzc;
        }

        public List<? extends zze> zzc() {
            return this.zzu;
        }

        public zze zzd(int i) {
            return this.zzu.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzB, "\u0004\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzl", "zzm", EnumC0021zza.zze(), "zzn", zzq.zze(), "zzo", "zzp", "zzu", zzd.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzat.class});
            }
            if (iOrdinal == 3) {
                return new zza();
            }
            if (iOrdinal == 4) {
                return new zzb(null);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zza> zzifxVar = zzC;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zza.class) {
                zzidzVar = zzC;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzB);
                    zzC = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zze() {
            return (this.zzl & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzq zzf() {
            zzq zzqVarZzc = zzq.zzc(this.zzn);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        public List<? extends zzbi> zzg() {
            return this.zzA;
        }

        public zzbi zzh(int i) {
            return this.zzA.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzi() {
            return (this.zzl & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzg zzj() {
            zzg zzgVar = this.zzo;
            return zzgVar == null ? zzg.zzz() : zzgVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public boolean zzo() {
            return (this.zzl & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzi zzp() {
            zzi zziVar = this.zzp;
            return zziVar == null ? zzi.zzD() : zziVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public List<zzd> zzu() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public int zzv() {
            return this.zzu.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzf
        public zzd zzw(int i) {
            return this.zzu.get(i);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzaa extends zzifq {
        boolean zza();

        zzv zzb();

        List<zzan> zzg();

        int zzh();

        zzan zzi(int i);

        boolean zzs();

        zzq zzt();

        boolean zzw();

        zzap zzx();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzab extends zziee<zzab, zza> implements zzae {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzab zzf;
        private static volatile zzifx<zzab> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzab, zza> implements zzae {
            private zza() {
                super(zzab.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzae
            public boolean zza() {
                return ((zzab) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzae
            public zzc zzb() {
                return ((zzab) this.zza).zzb();
            }

            public zza zzc(zzc zzcVar) {
                zzbg();
                ((zzab) this.zza).zzu(zzcVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzab) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzae
            public boolean zze() {
                return ((zzab) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzae
            public zzb zzf() {
                return ((zzab) this.zza).zzf();
            }

            public zza zzg(zzb zzbVar) {
                zzbg();
                ((zzab) this.zza).zzw(zzbVar);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzab) this.zza).zzx();
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzb implements zziei {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);

            public static final int zze = 0;
            public static final int zzf = 1;
            public static final int zzg = 2;
            public static final int zzh = 4;
            private static final zziej<zzb> zzi = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzab.zzb.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            };
            private final int zzj;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzab$zzb$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzb> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzb.zzc(i) != null;
                }
            }

            zzb(int i) {
                this.zzj = i;
            }

            public static zzb zzc(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zziej<zzb> zzd() {
                return zzi;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzj);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzj;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzc implements zziei {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);

            public static final int zzd = 0;
            public static final int zze = 1;
            public static final int zzf = 2;
            private static final zziej<zzc> zzg = new zziej<zzc>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzab.zzc.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzc zzb(int i) {
                    return zzc.zzc(i);
                }
            };
            private final int zzh;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzab$zzc$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzc> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzc zzb(int i) {
                    return zzc.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzc.zzc(i) != null;
                }
            }

            zzc(int i) {
                this.zzh = i;
            }

            public static zzc zzc(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zziej<zzc> zzd() {
                return zzg;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzh);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzf = zzabVar;
            zziee.zzbu(zzab.class, zzabVar);
        }

        private zzab() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzw(zzb zzbVar) {
            this.zze = zzbVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzx() {
            this.zzc &= -3;
            this.zze = 0;
        }

        public static zzab zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzab) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzab zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzab) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzab zzg(zzida zzidaVar) throws zziet {
            return (zzab) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzab zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzab) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzab zzi(byte[] bArr) throws zziet {
            return (zzab) zziee.zzbU(zzf, bArr);
        }

        public static zzab zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzab) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzab zzk(InputStream inputStream) throws IOException {
            return (zzab) zziee.zzbW(zzf, inputStream);
        }

        public static zzab zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzab) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzab zzm(InputStream inputStream) throws IOException {
            return (zzab) zzca(zzf, inputStream);
        }

        public static zzab zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzab) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzab zzo(zzide zzideVar) throws IOException {
            return (zzab) zziee.zzbY(zzf, zzideVar);
        }

        public static zzab zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzab) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzab zzabVar) {
            return (zza) zzf.zzbo(zzabVar);
        }

        public static zzab zzs() {
            return zzf;
        }

        public static zzifx<zzab> zzt() {
            return zzf.zzbd();
        }

        /* JADX INFO: renamed from: zzz */
        public void zzu(zzc zzcVar) {
            this.zzd = zzcVar.zza();
            this.zzc |= 1;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzae
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzae
        public zzc zzb() {
            zzc zzcVarZzc = zzc.zzc(this.zzd);
            return zzcVarZzc == null ? zzc.NETWORKTYPE_UNSPECIFIED : zzcVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", zzc.zze(), "zze", zzb.zze()});
            }
            if (iOrdinal == 3) {
                return new zzab();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzab> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzab.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzae
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzae
        public zzb zzf() {
            zzb zzbVarZzc = zzb.zzc(this.zze);
            return zzbVarZzc == null ? zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED : zzbVarZzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzac extends zziee<zzac, zza> implements zzad {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzac zzf;
        private static volatile zzifx<zzac> zzg;
        private int zzc;
        private int zzd;
        private zzap zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzac, zza> implements zzad {
            private zza() {
                super(zzac.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzad
            public boolean zza() {
                return ((zzac) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzad
            public zzq zzb() {
                return ((zzac) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzac) this.zza).zzu(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzac) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzad
            public boolean zze() {
                return ((zzac) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzad
            public zzap zzf() {
                return ((zzac) this.zza).zzf();
            }

            public zza zzg(zzap zzapVar) {
                zzbg();
                ((zzac) this.zza).zzw(zzapVar);
                return this;
            }

            public zza zzh(zzap.zza zzaVar) {
                zzbg();
                ((zzac) this.zza).zzw(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzap zzapVar) {
                zzbg();
                ((zzac) this.zza).zzx(zzapVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzac) this.zza).zzy();
                return this;
            }
        }

        static {
            zzac zzacVar = new zzac();
            zzf = zzacVar;
            zziee.zzbu(zzac.class, zzacVar);
        }

        private zzac() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzu(zzq zzqVar) {
            this.zzd = zzqVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzw(zzap zzapVar) {
            zzapVar.getClass();
            this.zze = zzapVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzD */
        public void zzx(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zze;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zze = zzapVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzE */
        public void zzy() {
            this.zze = null;
            this.zzc &= -3;
        }

        public static zzac zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzac) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzac zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzac) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzac zzg(zzida zzidaVar) throws zziet {
            return (zzac) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzac zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzac) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzac zzi(byte[] bArr) throws zziet {
            return (zzac) zziee.zzbU(zzf, bArr);
        }

        public static zzac zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzac) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzac zzk(InputStream inputStream) throws IOException {
            return (zzac) zziee.zzbW(zzf, inputStream);
        }

        public static zzac zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzac) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzac zzm(InputStream inputStream) throws IOException {
            return (zzac) zzca(zzf, inputStream);
        }

        public static zzac zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzac) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzac zzo(zzide zzideVar) throws IOException {
            return (zzac) zziee.zzbY(zzf, zzideVar);
        }

        public static zzac zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzac) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzac zzacVar) {
            return (zza) zzf.zzbo(zzacVar);
        }

        public static zzac zzs() {
            return zzf;
        }

        public static zzifx<zzac> zzt() {
            return zzf.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzad
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzad
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzd);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzq.zze(), "zze"});
            }
            if (iOrdinal == 3) {
                return new zzac();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzac> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzac.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzad
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzad
        public zzap zzf() {
            zzap zzapVar = this.zze;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzad extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzap zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzae extends zzifq {
        boolean zza();

        zzab.zzc zzb();

        boolean zze();

        zzab.zzb zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzaf extends zziee<zzaf, zzc> implements zzag {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzaf zzv;
        private static volatile zzifx<zzaf> zzw;
        private int zzi;
        private int zzk;
        private int zzl;
        private long zzm;
        private long zzp;
        private int zzu;
        private zzieq<zza> zzj = zzbM();
        private String zzn = "";
        private String zzo = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zziee<zza, C0023zza> implements zzb {
            private static final zza zzG;
            private static volatile zzifx<zza> zzH = null;
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            public static final int zzd = 4;
            public static final int zze = 5;
            public static final int zzf = 6;
            public static final int zzg = 7;
            public static final int zzh = 8;
            public static final int zzi = 9;
            public static final int zzj = 10;
            public static final int zzk = 11;
            public static final int zzl = 12;
            public static final int zzm = 13;
            private static final zzien<zzd.zza> zzx = new zzien<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaf.zza.1
                AnonymousClass1() {
                }

                @Override // com.google.android.gms.internal.ads.zzien
                /* JADX INFO: renamed from: zza */
                public zzd.zza zzb(int i) {
                    zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                    return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
                }
            };
            private int zzA;
            private int zzB;
            private int zzC;
            private int zzD;
            private int zzE;
            private long zzF;
            private int zzn;
            private long zzo;
            private int zzp;
            private long zzu;
            private long zzv;
            private zziem zzw = zzbC();
            private zzab zzy;
            private int zzz;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzaf$zza$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zzien<zzd.zza> {
                AnonymousClass1() {
                }

                @Override // com.google.android.gms.internal.ads.zzien
                /* JADX INFO: renamed from: zza */
                public zzd.zza zzb(int i) {
                    zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                    return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzaf$zza$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            public final class C0023zza extends zzidy<zza, C0023zza> implements zzb {
                private C0023zza() {
                    super(zza.zzG);
                }

                /* synthetic */ C0023zza(byte[] bArr) {
                    this();
                }

                public C0023zza zzA(zzab.zza zzaVar) {
                    zzbg();
                    ((zza) this.zza).zzad(zzaVar.zzbu());
                    return this;
                }

                public C0023zza zzB(zzab zzabVar) {
                    zzbg();
                    ((zza) this.zza).zzae(zzabVar);
                    return this;
                }

                public C0023zza zzC() {
                    zzbg();
                    ((zza) this.zza).zzaf();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzD() {
                    return ((zza) this.zza).zzD();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzq zzE() {
                    return ((zza) this.zza).zzE();
                }

                public C0023zza zzF(zzq zzqVar) {
                    zzbg();
                    ((zza) this.zza).zzag(zzqVar);
                    return this;
                }

                public C0023zza zzG() {
                    zzbg();
                    ((zza) this.zza).zzah();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzH() {
                    return ((zza) this.zza).zzH();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzq zzI() {
                    return ((zza) this.zza).zzI();
                }

                public C0023zza zzJ(zzq zzqVar) {
                    zzbg();
                    ((zza) this.zza).zzai(zzqVar);
                    return this;
                }

                public C0023zza zzK() {
                    zzbg();
                    ((zza) this.zza).zzaj();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzL() {
                    return ((zza) this.zza).zzL();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzq zzM() {
                    return ((zza) this.zza).zzM();
                }

                public C0023zza zzN(zzq zzqVar) {
                    zzbg();
                    ((zza) this.zza).zzak(zzqVar);
                    return this;
                }

                public C0023zza zzO() {
                    zzbg();
                    ((zza) this.zza).zzal();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzP() {
                    return ((zza) this.zza).zzP();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public int zzQ() {
                    return ((zza) this.zza).zzQ();
                }

                public C0023zza zzR(int i) {
                    zzbg();
                    ((zza) this.zza).zzam(i);
                    return this;
                }

                public C0023zza zzS() {
                    zzbg();
                    ((zza) this.zza).zzan();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzT() {
                    return ((zza) this.zza).zzT();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzq zzU() {
                    return ((zza) this.zza).zzU();
                }

                public C0023zza zzV(zzq zzqVar) {
                    zzbg();
                    ((zza) this.zza).zzao(zzqVar);
                    return this;
                }

                public C0023zza zzW() {
                    zzbg();
                    ((zza) this.zza).zzap();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzX() {
                    return ((zza) this.zza).zzX();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzd zzY() {
                    return ((zza) this.zza).zzY();
                }

                public C0023zza zzZ(zzd zzdVar) {
                    zzbg();
                    ((zza) this.zza).zzaq(zzdVar);
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zza() {
                    return ((zza) this.zza).zza();
                }

                public C0023zza zzaa() {
                    zzbg();
                    ((zza) this.zza).zzar();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzab() {
                    return ((zza) this.zza).zzab();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public long zzac() {
                    return ((zza) this.zza).zzac();
                }

                public C0023zza zzad(long j) {
                    zzbg();
                    ((zza) this.zza).zzas(j);
                    return this;
                }

                public C0023zza zzae() {
                    zzbg();
                    ((zza) this.zza).zzat();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public long zzb() {
                    return ((zza) this.zza).zzb();
                }

                public C0023zza zzc(long j) {
                    zzbg();
                    ((zza) this.zza).zzF(j);
                    return this;
                }

                public C0023zza zzd() {
                    zzbg();
                    ((zza) this.zza).zzG();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zze() {
                    return ((zza) this.zza).zze();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzq zzf() {
                    return ((zza) this.zza).zzf();
                }

                public C0023zza zzg(zzq zzqVar) {
                    zzbg();
                    ((zza) this.zza).zzJ(zzqVar);
                    return this;
                }

                public C0023zza zzh() {
                    zzbg();
                    ((zza) this.zza).zzK();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzi() {
                    return ((zza) this.zza).zzi();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public long zzj() {
                    return ((zza) this.zza).zzj();
                }

                public C0023zza zzk(long j) {
                    zzbg();
                    ((zza) this.zza).zzN(j);
                    return this;
                }

                public C0023zza zzl() {
                    zzbg();
                    ((zza) this.zza).zzO();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzm() {
                    return ((zza) this.zza).zzm();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public long zzn() {
                    return ((zza) this.zza).zzn();
                }

                public C0023zza zzo(long j) {
                    zzbg();
                    ((zza) this.zza).zzR(j);
                    return this;
                }

                public C0023zza zzp() {
                    zzbg();
                    ((zza) this.zza).zzS();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public List<zzd.zza> zzq() {
                    return ((zza) this.zza).zzq();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public int zzr() {
                    return ((zza) this.zza).zzr();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzd.zza zzs(int i) {
                    return ((zza) this.zza).zzs(i);
                }

                public C0023zza zzt(int i, zzd.zza zzaVar) {
                    zzbg();
                    ((zza) this.zza).zzV(i, zzaVar);
                    return this;
                }

                public C0023zza zzu(zzd.zza zzaVar) {
                    zzbg();
                    ((zza) this.zza).zzW(zzaVar);
                    return this;
                }

                public C0023zza zzv(Iterable<? extends zzd.zza> iterable) {
                    zzbg();
                    ((zza) this.zza).zzZ(iterable);
                    return this;
                }

                public C0023zza zzw() {
                    zzbg();
                    ((zza) this.zza).zzaa();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public boolean zzx() {
                    return ((zza) this.zza).zzx();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
                public zzab zzy() {
                    return ((zza) this.zza).zzy();
                }

                public C0023zza zzz(zzab zzabVar) {
                    zzbg();
                    ((zza) this.zza).zzad(zzabVar);
                    return this;
                }
            }

            static {
                zza zzaVar = new zza();
                zzG = zzaVar;
                zziee.zzbu(zza.class, zzaVar);
            }

            private zza() {
            }

            public static C0023zza zzA(zza zzaVar) {
                return (C0023zza) zzG.zzbo(zzaVar);
            }

            public static zza zzB() {
                return zzG;
            }

            public static zzifx<zza> zzC() {
                return zzG.zzbd();
            }

            /* JADX INFO: renamed from: zzaA */
            public void zzO() {
                this.zzn &= -5;
                this.zzu = 0L;
            }

            /* JADX INFO: renamed from: zzaB */
            public void zzR(long j) {
                this.zzn |= 8;
                this.zzv = j;
            }

            /* JADX INFO: renamed from: zzaC */
            public void zzS() {
                this.zzn &= -9;
                this.zzv = 0L;
            }

            private void zzaD() {
                zziem zziemVar = this.zzw;
                if (zziemVar.zza()) {
                    return;
                }
                this.zzw = zziee.zzbD(zziemVar);
            }

            /* JADX INFO: renamed from: zzaE */
            public void zzV(int i, zzd.zza zzaVar) {
                zzaVar.getClass();
                zzaD();
                this.zzw.zzg(i, zzaVar.zza());
            }

            /* JADX INFO: renamed from: zzaF */
            public void zzW(zzd.zza zzaVar) {
                zzaVar.getClass();
                zzaD();
                this.zzw.zzi(zzaVar.zza());
            }

            /* JADX INFO: renamed from: zzaG */
            public void zzZ(Iterable<? extends zzd.zza> iterable) {
                zzaD();
                Iterator<? extends zzd.zza> it = iterable.iterator();
                while (it.hasNext()) {
                    this.zzw.zzi(it.next().zza());
                }
            }

            /* JADX INFO: renamed from: zzaH */
            public void zzaa() {
                this.zzw = zzbC();
            }

            /* JADX INFO: renamed from: zzaI */
            public void zzad(zzab zzabVar) {
                zzabVar.getClass();
                this.zzy = zzabVar;
                this.zzn |= 16;
            }

            /* JADX INFO: renamed from: zzaJ */
            public void zzae(zzab zzabVar) {
                zzabVar.getClass();
                zzab zzabVar2 = this.zzy;
                if (zzabVar2 != null && zzabVar2 != zzab.zzs()) {
                    zzab.zza zzaVarZzr = zzab.zzr(zzabVar2);
                    zzaVarZzr.zzbo(zzabVar);
                    zzabVar = zzaVarZzr.zzbt();
                }
                this.zzy = zzabVar;
                this.zzn |= 16;
            }

            /* JADX INFO: renamed from: zzaK */
            public void zzaf() {
                this.zzy = null;
                this.zzn &= -17;
            }

            /* JADX INFO: renamed from: zzaL */
            public void zzag(zzq zzqVar) {
                this.zzz = zzqVar.zza();
                this.zzn |= 32;
            }

            /* JADX INFO: renamed from: zzav */
            public void zzF(long j) {
                this.zzn |= 1;
                this.zzo = j;
            }

            /* JADX INFO: renamed from: zzaw */
            public void zzG() {
                this.zzn &= -2;
                this.zzo = 0L;
            }

            /* JADX INFO: renamed from: zzax */
            public void zzJ(zzq zzqVar) {
                this.zzp = zzqVar.zza();
                this.zzn |= 2;
            }

            /* JADX INFO: renamed from: zzay */
            public void zzK() {
                this.zzn &= -3;
                this.zzp = 0;
            }

            /* JADX INFO: renamed from: zzaz */
            public void zzN(long j) {
                this.zzn |= 4;
                this.zzu = j;
            }

            public static zza zzc(ByteBuffer byteBuffer) throws zziet {
                return (zza) zziee.zzbR(zzG, byteBuffer);
            }

            /* JADX INFO: renamed from: zzce */
            public void zzah() {
                this.zzn &= -33;
                this.zzz = 0;
            }

            /* JADX INFO: renamed from: zzcf */
            public void zzai(zzq zzqVar) {
                this.zzA = zzqVar.zza();
                this.zzn |= 64;
            }

            /* JADX INFO: renamed from: zzcg */
            public void zzaj() {
                this.zzn &= -65;
                this.zzA = 0;
            }

            /* JADX INFO: renamed from: zzch */
            public void zzak(zzq zzqVar) {
                this.zzB = zzqVar.zza();
                this.zzn |= 128;
            }

            /* JADX INFO: renamed from: zzci */
            public void zzal() {
                this.zzn &= -129;
                this.zzB = 0;
            }

            /* JADX INFO: renamed from: zzcj */
            public void zzam(int i) {
                this.zzn |= 256;
                this.zzC = i;
            }

            /* JADX INFO: renamed from: zzck */
            public void zzan() {
                this.zzn &= -257;
                this.zzC = 0;
            }

            /* JADX INFO: renamed from: zzcl */
            public void zzao(zzq zzqVar) {
                this.zzD = zzqVar.zza();
                this.zzn |= 512;
            }

            /* JADX INFO: renamed from: zzcm */
            public void zzap() {
                this.zzn &= -513;
                this.zzD = 0;
            }

            /* JADX INFO: renamed from: zzcn */
            public void zzaq(zzd zzdVar) {
                this.zzE = zzdVar.zza();
                this.zzn |= 1024;
            }

            /* JADX INFO: renamed from: zzco */
            public void zzar() {
                this.zzn &= -1025;
                this.zzE = 0;
            }

            /* JADX INFO: renamed from: zzcp */
            public void zzas(long j) {
                this.zzn |= 2048;
                this.zzF = j;
            }

            /* JADX INFO: renamed from: zzcq */
            public void zzat() {
                this.zzn &= -2049;
                this.zzF = 0L;
            }

            public static zza zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbQ(zzG, byteBuffer, zzidoVar);
            }

            public static zza zzg(zzida zzidaVar) throws zziet {
                return (zza) zziee.zzbS(zzG, zzidaVar);
            }

            public static zza zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbT(zzG, zzidaVar, zzidoVar);
            }

            public static zza zzk(byte[] bArr) throws zziet {
                return (zza) zziee.zzbU(zzG, bArr);
            }

            public static zza zzl(byte[] bArr, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbV(zzG, bArr, zzidoVar);
            }

            public static zza zzo(InputStream inputStream) throws IOException {
                return (zza) zziee.zzbW(zzG, inputStream);
            }

            public static zza zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zza) zziee.zzbX(zzG, inputStream, zzidoVar);
            }

            public static zza zzt(InputStream inputStream) throws IOException {
                return (zza) zzca(zzG, inputStream);
            }

            public static zza zzu(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zza) zzcb(zzG, inputStream, zzidoVar);
            }

            public static zza zzv(zzide zzideVar) throws IOException {
                return (zza) zziee.zzbY(zzG, zzideVar);
            }

            public static zza zzw(zzide zzideVar, zzido zzidoVar) throws IOException {
                return (zza) zziee.zzbZ(zzG, zzideVar, zzidoVar);
            }

            public static C0023zza zzz() {
                return (C0023zza) zzG.zzbn();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzD() {
                return (this.zzn & 32) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzq zzE() {
                zzq zzqVarZzc = zzq.zzc(this.zzz);
                return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzH() {
                return (this.zzn & 64) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzq zzI() {
                zzq zzqVarZzc = zzq.zzc(this.zzA);
                return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzL() {
                return (this.zzn & 128) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzq zzM() {
                zzq zzqVarZzc = zzq.zzc(this.zzB);
                return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzP() {
                return (this.zzn & 256) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public int zzQ() {
                return this.zzC;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzT() {
                return (this.zzn & 512) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzq zzU() {
                zzq zzqVarZzc = zzq.zzc(this.zzD);
                return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzX() {
                return (this.zzn & 1024) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzd zzY() {
                zzd zzdVarZzc = zzd.zzc(this.zzE);
                return zzdVarZzc == null ? zzd.UNSPECIFIED : zzdVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zza() {
                return (this.zzn & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzab() {
                return (this.zzn & 2048) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public long zzac() {
                return this.zzF;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public long zzb() {
                return this.zzo;
            }

            @Override // com.google.android.gms.internal.ads.zziee
            protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
                zzifx zzidzVar;
                int iOrdinal = zziedVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzbv(zzG, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ࠞ\u0006ဉ\u0004\u0007᠌\u0005\b᠌\u0006\t᠌\u0007\nင\b\u000b᠌\t\f᠌\n\rဂ\u000b", new Object[]{"zzn", "zzo", "zzp", zzq.zze(), "zzu", "zzv", "zzw", zzd.zza.zze(), "zzy", "zzz", zzq.zze(), "zzA", zzq.zze(), "zzB", zzq.zze(), "zzC", "zzD", zzq.zze(), "zzE", zzd.zze(), "zzF"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0023zza(null);
                }
                if (iOrdinal == 5) {
                    return zzG;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzifx<zza> zzifxVar = zzH;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zza.class) {
                    zzidzVar = zzH;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzG);
                        zzH = zzidzVar;
                    }
                }
                return zzidzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zze() {
                return (this.zzn & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzq zzf() {
                zzq zzqVarZzc = zzq.zzc(this.zzp);
                return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzi() {
                return (this.zzn & 4) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public long zzj() {
                return this.zzu;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzm() {
                return (this.zzn & 8) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public long zzn() {
                return this.zzv;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public List<zzd.zza> zzq() {
                return new zzieo(this.zzw, zzx);
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public int zzr() {
                return this.zzw.size();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzd.zza zzs(int i) {
                zzd.zza zzaVarZzc = zzd.zza.zzc(this.zzw.zzf(i));
                return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public boolean zzx() {
                return (this.zzn & 16) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaf.zzb
            public zzab zzy() {
                zzab zzabVar = this.zzy;
                return zzabVar == null ? zzab.zzs() : zzabVar;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public interface zzb extends zzifq {
            boolean zzD();

            zzq zzE();

            boolean zzH();

            zzq zzI();

            boolean zzL();

            zzq zzM();

            boolean zzP();

            int zzQ();

            boolean zzT();

            zzq zzU();

            boolean zzX();

            zzd zzY();

            boolean zza();

            boolean zzab();

            long zzac();

            long zzb();

            boolean zze();

            zzq zzf();

            boolean zzi();

            long zzj();

            boolean zzm();

            long zzn();

            List<zzd.zza> zzq();

            int zzr();

            zzd.zza zzs(int i);

            boolean zzx();

            zzab zzy();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zzc extends zzidy<zzaf, zzc> implements zzag {
            private zzc() {
                super(zzaf.zzv);
            }

            /* synthetic */ zzc(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public zzida zzA() {
                return ((zzaf) this.zza).zzA();
            }

            public zzc zzB(String str) {
                zzbg();
                ((zzaf) this.zza).zzY(str);
                return this;
            }

            public zzc zzC() {
                zzbg();
                ((zzaf) this.zza).zzZ();
                return this;
            }

            public zzc zzD(zzida zzidaVar) {
                zzbg();
                ((zzaf) this.zza).zzaa(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzE() {
                return ((zzaf) this.zza).zzE();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public String zzF() {
                return ((zzaf) this.zza).zzF();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public zzida zzG() {
                return ((zzaf) this.zza).zzG();
            }

            public zzc zzH(String str) {
                zzbg();
                ((zzaf) this.zza).zzab(str);
                return this;
            }

            public zzc zzI() {
                zzbg();
                ((zzaf) this.zza).zzac();
                return this;
            }

            public zzc zzJ(zzida zzidaVar) {
                zzbg();
                ((zzaf) this.zza).zzad(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzK() {
                return ((zzaf) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public long zzL() {
                return ((zzaf) this.zza).zzL();
            }

            public zzc zzM(long j) {
                zzbg();
                ((zzaf) this.zza).zzae(j);
                return this;
            }

            public zzc zzN() {
                zzbg();
                ((zzaf) this.zza).zzaf();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzO() {
                return ((zzaf) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public int zzP() {
                return ((zzaf) this.zza).zzP();
            }

            public zzc zzQ(int i) {
                zzbg();
                ((zzaf) this.zza).zzag(i);
                return this;
            }

            public zzc zzR() {
                zzbg();
                ((zzaf) this.zza).zzah();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public List<zza> zza() {
                return Collections.unmodifiableList(((zzaf) this.zza).zza());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public int zzb() {
                return ((zzaf) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public zza zzc(int i) {
                return ((zzaf) this.zza).zzc(i);
            }

            public zzc zzd(int i, zza zzaVar) {
                zzbg();
                ((zzaf) this.zza).zzI(i, zzaVar);
                return this;
            }

            public zzc zze(int i, zza.C0023zza c0023zza) {
                zzbg();
                ((zzaf) this.zza).zzI(i, c0023zza.zzbu());
                return this;
            }

            public zzc zzf(zza zzaVar) {
                zzbg();
                ((zzaf) this.zza).zzJ(zzaVar);
                return this;
            }

            public zzc zzg(int i, zza zzaVar) {
                zzbg();
                ((zzaf) this.zza).zzM(i, zzaVar);
                return this;
            }

            public zzc zzh(zza.C0023zza c0023zza) {
                zzbg();
                ((zzaf) this.zza).zzJ(c0023zza.zzbu());
                return this;
            }

            public zzc zzi(int i, zza.C0023zza c0023zza) {
                zzbg();
                ((zzaf) this.zza).zzM(i, c0023zza.zzbu());
                return this;
            }

            public zzc zzj(Iterable<? extends zza> iterable) {
                zzbg();
                ((zzaf) this.zza).zzN(iterable);
                return this;
            }

            public zzc zzk() {
                zzbg();
                ((zzaf) this.zza).zzQ();
                return this;
            }

            public zzc zzl(int i) {
                zzbg();
                ((zzaf) this.zza).zzR(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzm() {
                return ((zzaf) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public int zzn() {
                return ((zzaf) this.zza).zzn();
            }

            public zzc zzo(int i) {
                zzbg();
                ((zzaf) this.zza).zzS(i);
                return this;
            }

            public zzc zzp() {
                zzbg();
                ((zzaf) this.zza).zzT();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzq() {
                return ((zzaf) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public int zzr() {
                return ((zzaf) this.zza).zzr();
            }

            public zzc zzs(int i) {
                zzbg();
                ((zzaf) this.zza).zzU(i);
                return this;
            }

            public zzc zzt() {
                zzbg();
                ((zzaf) this.zza).zzV();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzu() {
                return ((zzaf) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public long zzv() {
                return ((zzaf) this.zza).zzv();
            }

            public zzc zzw(long j) {
                zzbg();
                ((zzaf) this.zza).zzW(j);
                return this;
            }

            public zzc zzx() {
                zzbg();
                ((zzaf) this.zza).zzX();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public boolean zzy() {
                return ((zzaf) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzag
            public String zzz() {
                return ((zzaf) this.zza).zzz();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzd implements zziei {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);

            public static final int zzg = 0;
            public static final int zzh = 1;
            public static final int zzi = 2;
            public static final int zzj = 3;
            public static final int zzk = 4;
            public static final int zzl = 5;
            private static final zziej<zzd> zzm = new zziej<zzd>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaf.zzd.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzc(i);
                }
            };
            private final int zzn;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzaf$zzd$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzd> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzd.zzc(i) != null;
                }
            }

            zzd(int i) {
                this.zzn = i;
            }

            public static zzd zzc(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            public static zziej<zzd> zzd() {
                return zzm;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzn);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzn;
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzv = zzafVar;
            zziee.zzbu(zzaf.class, zzafVar);
        }

        private zzaf() {
        }

        public static zzc zzB() {
            return (zzc) zzv.zzbn();
        }

        public static zzc zzC(zzaf zzafVar) {
            return (zzc) zzv.zzbo(zzafVar);
        }

        public static zzaf zzD() {
            return zzv;
        }

        public static zzifx<zzaf> zzH() {
            return zzv.zzbd();
        }

        /* JADX INFO: renamed from: zzaA */
        public void zzac() {
            this.zzi &= -17;
            this.zzo = zzD().zzF();
        }

        /* JADX INFO: renamed from: zzaB */
        public void zzad(zzida zzidaVar) {
            this.zzo = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzi |= 16;
        }

        /* JADX INFO: renamed from: zzaC */
        public void zzae(long j) {
            this.zzi |= 32;
            this.zzp = j;
        }

        /* JADX INFO: renamed from: zzaD */
        public void zzaf() {
            this.zzi &= -33;
            this.zzp = 0L;
        }

        /* JADX INFO: renamed from: zzaE */
        public void zzag(int i) {
            this.zzi |= 64;
            this.zzu = i;
        }

        /* JADX INFO: renamed from: zzaF */
        public void zzah() {
            this.zzi &= -65;
            this.zzu = 0;
        }

        private void zzaj() {
            zzieq<zza> zzieqVar = this.zzj;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzj = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzak */
        public void zzI(int i, zza zzaVar) {
            zzaVar.getClass();
            zzaj();
            this.zzj.set(i, zzaVar);
        }

        /* JADX INFO: renamed from: zzal */
        public void zzJ(zza zzaVar) {
            zzaVar.getClass();
            zzaj();
            this.zzj.add(zzaVar);
        }

        /* JADX INFO: renamed from: zzam */
        public void zzM(int i, zza zzaVar) {
            zzaVar.getClass();
            zzaj();
            this.zzj.add(i, zzaVar);
        }

        /* JADX INFO: renamed from: zzan */
        public void zzN(Iterable<? extends zza> iterable) {
            zzaj();
            zzicj.zzaW(iterable, this.zzj);
        }

        /* JADX INFO: renamed from: zzao */
        public void zzQ() {
            this.zzj = zzbM();
        }

        /* JADX INFO: renamed from: zzap */
        public void zzR(int i) {
            zzaj();
            this.zzj.remove(i);
        }

        /* JADX INFO: renamed from: zzaq */
        public void zzS(int i) {
            this.zzi |= 1;
            this.zzk = i;
        }

        /* JADX INFO: renamed from: zzar */
        public void zzT() {
            this.zzi &= -2;
            this.zzk = 0;
        }

        /* JADX INFO: renamed from: zzas */
        public void zzU(int i) {
            this.zzi |= 2;
            this.zzl = i;
        }

        /* JADX INFO: renamed from: zzat */
        public void zzV() {
            this.zzi &= -3;
            this.zzl = 0;
        }

        /* JADX INFO: renamed from: zzau */
        public void zzW(long j) {
            this.zzi |= 4;
            this.zzm = j;
        }

        /* JADX INFO: renamed from: zzav */
        public void zzX() {
            this.zzi &= -5;
            this.zzm = 0L;
        }

        /* JADX INFO: renamed from: zzaw */
        public void zzY(String str) {
            str.getClass();
            this.zzi |= 8;
            this.zzn = str;
        }

        /* JADX INFO: renamed from: zzax */
        public void zzZ() {
            this.zzi &= -9;
            this.zzn = zzD().zzz();
        }

        /* JADX INFO: renamed from: zzay */
        public void zzaa(zzida zzidaVar) {
            this.zzn = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzi |= 8;
        }

        /* JADX INFO: renamed from: zzaz */
        public void zzab(String str) {
            str.getClass();
            this.zzi |= 16;
            this.zzo = str;
        }

        public static zzaf zzg(ByteBuffer byteBuffer) throws zziet {
            return (zzaf) zziee.zzbR(zzv, byteBuffer);
        }

        public static zzaf zzh(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzaf) zziee.zzbQ(zzv, byteBuffer, zzidoVar);
        }

        public static zzaf zzi(zzida zzidaVar) throws zziet {
            return (zzaf) zziee.zzbS(zzv, zzidaVar);
        }

        public static zzaf zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzaf) zziee.zzbT(zzv, zzidaVar, zzidoVar);
        }

        public static zzaf zzk(byte[] bArr) throws zziet {
            return (zzaf) zziee.zzbU(zzv, bArr);
        }

        public static zzaf zzl(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzaf) zziee.zzbV(zzv, bArr, zzidoVar);
        }

        public static zzaf zzo(InputStream inputStream) throws IOException {
            return (zzaf) zziee.zzbW(zzv, inputStream);
        }

        public static zzaf zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzaf) zziee.zzbX(zzv, inputStream, zzidoVar);
        }

        public static zzaf zzs(InputStream inputStream) throws IOException {
            return (zzaf) zzca(zzv, inputStream);
        }

        public static zzaf zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzaf) zzcb(zzv, inputStream, zzidoVar);
        }

        public static zzaf zzw(zzide zzideVar) throws IOException {
            return (zzaf) zziee.zzbY(zzv, zzideVar);
        }

        public static zzaf zzx(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzaf) zziee.zzbZ(zzv, zzideVar, zzidoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public zzida zzA() {
            return zzida.zzx(this.zzn);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzE() {
            return (this.zzi & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public String zzF() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public zzida zzG() {
            return zzida.zzx(this.zzo);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzK() {
            return (this.zzi & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public long zzL() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzO() {
            return (this.zzi & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public int zzP() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public List<zza> zza() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public int zzb() {
            return this.zzj.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public zza zzc(int i) {
            return this.zzj.get(i);
        }

        public List<? extends zzb> zzd() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzi", "zzj", zza.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu"});
            }
            if (iOrdinal == 3) {
                return new zzaf();
            }
            if (iOrdinal == 4) {
                return new zzc(null);
            }
            if (iOrdinal == 5) {
                return zzv;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzaf> zzifxVar = zzw;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzaf.class) {
                zzidzVar = zzw;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzv);
                    zzw = zzidzVar;
                }
            }
            return zzidzVar;
        }

        public zzb zze(int i) {
            return this.zzj.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzm() {
            return (this.zzi & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public int zzn() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzq() {
            return (this.zzi & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public int zzr() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzu() {
            return (this.zzi & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public long zzv() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public boolean zzy() {
            return (this.zzi & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzag
        public String zzz() {
            return this.zzn;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzag extends zzifq {
        zzida zzA();

        boolean zzE();

        String zzF();

        zzida zzG();

        boolean zzK();

        long zzL();

        boolean zzO();

        int zzP();

        List<zzaf.zza> zza();

        int zzb();

        zzaf.zza zzc(int i);

        boolean zzm();

        int zzn();

        boolean zzq();

        int zzr();

        boolean zzu();

        long zzv();

        boolean zzy();

        String zzz();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzah extends zziee<zzah, zza> implements zzak {
        private static final zzah zzB;
        private static volatile zzifx<zzah> zzC = null;
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        public static final int zzi = 9;
        public static final int zzj = 10;
        public static final int zzk = 11;
        private zzai zzA;
        private int zzl;
        private int zzm = 1000;
        private int zzn = 1000;
        private int zzo;
        private int zzp;
        private int zzu;
        private int zzv;
        private int zzw;
        private int zzx;
        private int zzy;
        private int zzz;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzah, zza> implements zzak {
            private zza() {
                super(zzah.zzB);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            public zza zzA(int i) {
                zzbg();
                ((zzah) this.zza).zzY(i);
                return this;
            }

            public zza zzB() {
                zzbg();
                ((zzah) this.zza).zzZ();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzC() {
                return ((zzah) this.zza).zzC();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzD() {
                return ((zzah) this.zza).zzD();
            }

            public zza zzE(int i) {
                zzbg();
                ((zzah) this.zza).zzaa(i);
                return this;
            }

            public zza zzF() {
                zzbg();
                ((zzah) this.zza).zzab();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzG() {
                return ((zzah) this.zza).zzG();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzH() {
                return ((zzah) this.zza).zzH();
            }

            public zza zzI(int i) {
                zzbg();
                ((zzah) this.zza).zzac(i);
                return this;
            }

            public zza zzJ() {
                zzbg();
                ((zzah) this.zza).zzad();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzK() {
                return ((zzah) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzL() {
                return ((zzah) this.zza).zzL();
            }

            public zza zzM(int i) {
                zzbg();
                ((zzah) this.zza).zzae(i);
                return this;
            }

            public zza zzN() {
                zzbg();
                ((zzah) this.zza).zzaf();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzO() {
                return ((zzah) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public zzai zzP() {
                return ((zzah) this.zza).zzP();
            }

            public zza zzQ(zzai zzaiVar) {
                zzbg();
                ((zzah) this.zza).zzag(zzaiVar);
                return this;
            }

            public zza zzR(zzai.zza zzaVar) {
                zzbg();
                ((zzah) this.zza).zzag(zzaVar.zzbu());
                return this;
            }

            public zza zzS(zzai zzaiVar) {
                zzbg();
                ((zzah) this.zza).zzah(zzaiVar);
                return this;
            }

            public zza zzT() {
                zzbg();
                ((zzah) this.zza).zzai();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zza() {
                return ((zzah) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public zzq zzb() {
                return ((zzah) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzah) this.zza).zzI(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzah) this.zza).zzJ();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zze() {
                return ((zzah) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public zzq zzf() {
                return ((zzah) this.zza).zzf();
            }

            public zza zzg(zzq zzqVar) {
                zzbg();
                ((zzah) this.zza).zzM(zzqVar);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzah) this.zza).zzN();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzi() {
                return ((zzah) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzj() {
                return ((zzah) this.zza).zzj();
            }

            public zza zzk(int i) {
                zzbg();
                ((zzah) this.zza).zzQ(i);
                return this;
            }

            public zza zzl() {
                zzbg();
                ((zzah) this.zza).zzR();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzm() {
                return ((zzah) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzn() {
                return ((zzah) this.zza).zzn();
            }

            public zza zzo(int i) {
                zzbg();
                ((zzah) this.zza).zzS(i);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzah) this.zza).zzT();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzq() {
                return ((zzah) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzr() {
                return ((zzah) this.zza).zzr();
            }

            public zza zzs(int i) {
                zzbg();
                ((zzah) this.zza).zzU(i);
                return this;
            }

            public zza zzt() {
                zzbg();
                ((zzah) this.zza).zzV();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzu() {
                return ((zzah) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzv() {
                return ((zzah) this.zza).zzv();
            }

            public zza zzw(int i) {
                zzbg();
                ((zzah) this.zza).zzW(i);
                return this;
            }

            public zza zzx() {
                zzbg();
                ((zzah) this.zza).zzX();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public boolean zzy() {
                return ((zzah) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzak
            public int zzz() {
                return ((zzah) this.zza).zzz();
            }
        }

        static {
            zzah zzahVar = new zzah();
            zzB = zzahVar;
            zziee.zzbu(zzah.class, zzahVar);
        }

        private zzah() {
        }

        public static zza zzA() {
            return (zza) zzB.zzbn();
        }

        public static zza zzB(zzah zzahVar) {
            return (zza) zzB.zzbo(zzahVar);
        }

        public static zzah zzE() {
            return zzB;
        }

        public static zzifx<zzah> zzF() {
            return zzB.zzbd();
        }

        /* JADX INFO: renamed from: zzaA */
        public void zzac(int i) {
            this.zzl |= 256;
            this.zzy = i;
        }

        /* JADX INFO: renamed from: zzaB */
        public void zzad() {
            this.zzl &= -257;
            this.zzy = 0;
        }

        /* JADX INFO: renamed from: zzaC */
        public void zzae(int i) {
            this.zzl |= 512;
            this.zzz = i;
        }

        /* JADX INFO: renamed from: zzaD */
        public void zzaf() {
            this.zzl &= -513;
            this.zzz = 0;
        }

        /* JADX INFO: renamed from: zzaE */
        public void zzag(zzai zzaiVar) {
            zzaiVar.getClass();
            this.zzA = zzaiVar;
            this.zzl |= 1024;
        }

        /* JADX INFO: renamed from: zzaF */
        public void zzah(zzai zzaiVar) {
            zzaiVar.getClass();
            zzai zzaiVar2 = this.zzA;
            if (zzaiVar2 != null && zzaiVar2 != zzai.zzs()) {
                zzai.zza zzaVarZzr = zzai.zzr(zzaiVar2);
                zzaVarZzr.zzbo(zzaiVar);
                zzaiVar = zzaVarZzr.zzbt();
            }
            this.zzA = zzaiVar;
            this.zzl |= 1024;
        }

        /* JADX INFO: renamed from: zzaG */
        public void zzai() {
            this.zzA = null;
            this.zzl &= -1025;
        }

        /* JADX INFO: renamed from: zzak */
        public void zzI(zzq zzqVar) {
            this.zzm = zzqVar.zza();
            this.zzl |= 1;
        }

        /* JADX INFO: renamed from: zzal */
        public void zzJ() {
            this.zzl &= -2;
            this.zzm = 1000;
        }

        /* JADX INFO: renamed from: zzam */
        public void zzM(zzq zzqVar) {
            this.zzn = zzqVar.zza();
            this.zzl |= 2;
        }

        /* JADX INFO: renamed from: zzan */
        public void zzN() {
            this.zzl &= -3;
            this.zzn = 1000;
        }

        /* JADX INFO: renamed from: zzao */
        public void zzQ(int i) {
            this.zzl |= 4;
            this.zzo = i;
        }

        /* JADX INFO: renamed from: zzap */
        public void zzR() {
            this.zzl &= -5;
            this.zzo = 0;
        }

        /* JADX INFO: renamed from: zzaq */
        public void zzS(int i) {
            this.zzl |= 8;
            this.zzp = i;
        }

        /* JADX INFO: renamed from: zzar */
        public void zzT() {
            this.zzl &= -9;
            this.zzp = 0;
        }

        /* JADX INFO: renamed from: zzas */
        public void zzU(int i) {
            this.zzl |= 16;
            this.zzu = i;
        }

        /* JADX INFO: renamed from: zzat */
        public void zzV() {
            this.zzl &= -17;
            this.zzu = 0;
        }

        /* JADX INFO: renamed from: zzau */
        public void zzW(int i) {
            this.zzl |= 32;
            this.zzv = i;
        }

        /* JADX INFO: renamed from: zzav */
        public void zzX() {
            this.zzl &= -33;
            this.zzv = 0;
        }

        /* JADX INFO: renamed from: zzaw */
        public void zzY(int i) {
            this.zzl |= 64;
            this.zzw = i;
        }

        /* JADX INFO: renamed from: zzax */
        public void zzZ() {
            this.zzl &= -65;
            this.zzw = 0;
        }

        /* JADX INFO: renamed from: zzay */
        public void zzaa(int i) {
            this.zzl |= 128;
            this.zzx = i;
        }

        /* JADX INFO: renamed from: zzaz */
        public void zzab() {
            this.zzl &= -129;
            this.zzx = 0;
        }

        public static zzah zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzah) zziee.zzbR(zzB, byteBuffer);
        }

        public static zzah zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzah) zziee.zzbQ(zzB, byteBuffer, zzidoVar);
        }

        public static zzah zzg(zzida zzidaVar) throws zziet {
            return (zzah) zziee.zzbS(zzB, zzidaVar);
        }

        public static zzah zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzah) zziee.zzbT(zzB, zzidaVar, zzidoVar);
        }

        public static zzah zzk(byte[] bArr) throws zziet {
            return (zzah) zziee.zzbU(zzB, bArr);
        }

        public static zzah zzl(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzah) zziee.zzbV(zzB, bArr, zzidoVar);
        }

        public static zzah zzo(InputStream inputStream) throws IOException {
            return (zzah) zziee.zzbW(zzB, inputStream);
        }

        public static zzah zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzah) zziee.zzbX(zzB, inputStream, zzidoVar);
        }

        public static zzah zzs(InputStream inputStream) throws IOException {
            return (zzah) zzca(zzB, inputStream);
        }

        public static zzah zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzah) zzcb(zzB, inputStream, zzidoVar);
        }

        public static zzah zzw(zzide zzideVar) throws IOException {
            return (zzah) zziee.zzbY(zzB, zzideVar);
        }

        public static zzah zzx(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzah) zziee.zzbZ(zzB, zzideVar, zzidoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzC() {
            return (this.zzl & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzD() {
            return this.zzx;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzG() {
            return (this.zzl & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzH() {
            return this.zzy;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzK() {
            return (this.zzl & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzL() {
            return this.zzz;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzO() {
            return (this.zzl & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public zzai zzP() {
            zzai zzaiVar = this.zzA;
            return zzaiVar == null ? zzai.zzs() : zzaiVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zza() {
            return (this.zzl & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzm);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzB, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzl", "zzm", zzq.zze(), "zzn", zzq.zze(), "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA"});
            }
            if (iOrdinal == 3) {
                return new zzah();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzah> zzifxVar = zzC;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzah.class) {
                zzidzVar = zzC;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzB);
                    zzC = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zze() {
            return (this.zzl & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public zzq zzf() {
            zzq zzqVarZzc = zzq.zzc(this.zzn);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzi() {
            return (this.zzl & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzj() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzm() {
            return (this.zzl & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzn() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzq() {
            return (this.zzl & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzr() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzu() {
            return (this.zzl & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzv() {
            return this.zzv;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public boolean zzy() {
            return (this.zzl & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzak
        public int zzz() {
            return this.zzw;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzai extends zziee<zzai, zza> implements zzaj {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzai zzf;
        private static volatile zzifx<zzai> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzai, zza> implements zzaj {
            private zza() {
                super(zzai.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
            public boolean zza() {
                return ((zzai) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
            public int zzb() {
                return ((zzai) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzai) this.zza).zzu(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzai) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
            public boolean zze() {
                return ((zzai) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
            public int zzf() {
                return ((zzai) this.zza).zzf();
            }

            public zza zzg(int i) {
                zzbg();
                ((zzai) this.zza).zzw(i);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzai) this.zza).zzx();
                return this;
            }
        }

        static {
            zzai zzaiVar = new zzai();
            zzf = zzaiVar;
            zziee.zzbu(zzai.class, zzaiVar);
        }

        private zzai() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzw(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzx() {
            this.zzc &= -3;
            this.zze = 0;
        }

        public static zzai zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzai) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzai zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzai) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzai zzg(zzida zzidaVar) throws zziet {
            return (zzai) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzai zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzai) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzai zzi(byte[] bArr) throws zziet {
            return (zzai) zziee.zzbU(zzf, bArr);
        }

        public static zzai zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzai) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzai zzk(InputStream inputStream) throws IOException {
            return (zzai) zziee.zzbW(zzf, inputStream);
        }

        public static zzai zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzai) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzai zzm(InputStream inputStream) throws IOException {
            return (zzai) zzca(zzf, inputStream);
        }

        public static zzai zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzai) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzai zzo(zzide zzideVar) throws IOException {
            return (zzai) zziee.zzbY(zzf, zzideVar);
        }

        public static zzai zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzai) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzai zzaiVar) {
            return (zza) zzf.zzbo(zzaiVar);
        }

        public static zzai zzs() {
            return zzf;
        }

        public static zzifx<zzai> zzt() {
            return zzf.zzbd();
        }

        /* JADX INFO: renamed from: zzz */
        public void zzu(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
        public int zzb() {
            return this.zzd;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzai();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzai> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzai.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaj
        public int zzf() {
            return this.zze;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzaj extends zzifq {
        boolean zza();

        int zzb();

        boolean zze();

        int zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzak extends zzifq {
        boolean zzC();

        int zzD();

        boolean zzG();

        int zzH();

        boolean zzK();

        int zzL();

        boolean zzO();

        zzai zzP();

        boolean zza();

        zzq zzb();

        boolean zze();

        zzq zzf();

        boolean zzi();

        int zzj();

        boolean zzm();

        int zzn();

        boolean zzq();

        int zzr();

        boolean zzu();

        int zzv();

        boolean zzy();

        int zzz();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzal extends zziee<zzal, zza> implements zzam {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzal zzf;
        private static volatile zzifx<zzal> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzal, zza> implements zzam {
            private zza() {
                super(zzal.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzam
            public boolean zza() {
                return ((zzal) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzam
            public int zzb() {
                return ((zzal) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzal) this.zza).zzu(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzal) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzam
            public boolean zze() {
                return ((zzal) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzam
            public int zzf() {
                return ((zzal) this.zza).zzf();
            }

            public zza zzg(int i) {
                zzbg();
                ((zzal) this.zza).zzw(i);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzal) this.zza).zzx();
                return this;
            }
        }

        static {
            zzal zzalVar = new zzal();
            zzf = zzalVar;
            zziee.zzbu(zzal.class, zzalVar);
        }

        private zzal() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzw(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzx() {
            this.zzc &= -3;
            this.zze = 0;
        }

        public static zzal zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzal) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzal zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzal) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzal zzg(zzida zzidaVar) throws zziet {
            return (zzal) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzal zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzal) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzal zzi(byte[] bArr) throws zziet {
            return (zzal) zziee.zzbU(zzf, bArr);
        }

        public static zzal zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzal) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzal zzk(InputStream inputStream) throws IOException {
            return (zzal) zziee.zzbW(zzf, inputStream);
        }

        public static zzal zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzal) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzal zzm(InputStream inputStream) throws IOException {
            return (zzal) zzca(zzf, inputStream);
        }

        public static zzal zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzal) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzal zzo(zzide zzideVar) throws IOException {
            return (zzal) zziee.zzbY(zzf, zzideVar);
        }

        public static zzal zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzal) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzal zzalVar) {
            return (zza) zzf.zzbo(zzalVar);
        }

        public static zzal zzs() {
            return zzf;
        }

        public static zzifx<zzal> zzt() {
            return zzf.zzbd();
        }

        /* JADX INFO: renamed from: zzz */
        public void zzu(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzam
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzam
        public int zzb() {
            return this.zzd;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzal();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzal> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzal.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzam
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzam
        public int zzf() {
            return this.zze;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzam extends zzifq {
        boolean zza();

        int zzb();

        boolean zze();

        int zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzan extends zziee<zzan, zza> implements zzao {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzan zzh;
        private static volatile zzifx<zzan> zzi;
        private int zzd;
        private String zze = "";
        private int zzf;
        private zzap zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzan, zza> implements zzao {
            private zza() {
                super(zzan.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public boolean zza() {
                return ((zzan) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public String zzb() {
                return ((zzan) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public zzida zzc() {
                return ((zzan) this.zza).zzc();
            }

            public zza zzd(String str) {
                zzbg();
                ((zzan) this.zza).zzy(str);
                return this;
            }

            public zza zze() {
                zzbg();
                ((zzan) this.zza).zzz();
                return this;
            }

            public zza zzf(zzida zzidaVar) {
                zzbg();
                ((zzan) this.zza).zzA(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public boolean zzg() {
                return ((zzan) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public zzq zzh() {
                return ((zzan) this.zza).zzh();
            }

            public zza zzi(zzq zzqVar) {
                zzbg();
                ((zzan) this.zza).zzB(zzqVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzan) this.zza).zzC();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public boolean zzk() {
                return ((zzan) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzao
            public zzap zzl() {
                return ((zzan) this.zza).zzl();
            }

            public zza zzm(zzap zzapVar) {
                zzbg();
                ((zzan) this.zza).zzD(zzapVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbg();
                ((zzan) this.zza).zzD(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbg();
                ((zzan) this.zza).zzE(zzapVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzan) this.zza).zzF();
                return this;
            }
        }

        static {
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zziee.zzbu(zzan.class, zzanVar);
        }

        private zzan() {
        }

        /* JADX INFO: renamed from: zzH */
        public void zzy(String str) {
            str.getClass();
            this.zzd |= 1;
            this.zze = str;
        }

        /* JADX INFO: renamed from: zzI */
        public void zzz() {
            this.zzd &= -2;
            this.zze = zzw().zzb();
        }

        /* JADX INFO: renamed from: zzJ */
        public void zzA(zzida zzidaVar) {
            this.zze = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzd |= 1;
        }

        /* JADX INFO: renamed from: zzK */
        public void zzB(zzq zzqVar) {
            this.zzf = zzqVar.zza();
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzL */
        public void zzC() {
            this.zzd &= -3;
            this.zzf = 0;
        }

        /* JADX INFO: renamed from: zzM */
        public void zzD(zzap zzapVar) {
            zzapVar.getClass();
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzN */
        public void zzE(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzg;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzO */
        public void zzF() {
            this.zzg = null;
            this.zzd &= -5;
        }

        public static zzan zzd(ByteBuffer byteBuffer) throws zziet {
            return (zzan) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzan zze(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzan) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzan zzi(zzida zzidaVar) throws zziet {
            return (zzan) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzan zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzan) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzan zzm(byte[] bArr) throws zziet {
            return (zzan) zziee.zzbU(zzh, bArr);
        }

        public static zzan zzn(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzan) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzan zzo(InputStream inputStream) throws IOException {
            return (zzan) zziee.zzbW(zzh, inputStream);
        }

        public static zzan zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzan) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzan zzq(InputStream inputStream) throws IOException {
            return (zzan) zzca(zzh, inputStream);
        }

        public static zzan zzr(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzan) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzan zzs(zzide zzideVar) throws IOException {
            return (zzan) zziee.zzbY(zzh, zzideVar);
        }

        public static zzan zzt(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzan) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzu() {
            return (zza) zzh.zzbn();
        }

        public static zza zzv(zzan zzanVar) {
            return (zza) zzh.zzbo(zzanVar);
        }

        public static zzan zzw() {
            return zzh;
        }

        public static zzifx<zzan> zzx() {
            return zzh.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public zzida zzc() {
            return zzida.zzx(this.zze);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzq.zze(), "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzan();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzan> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzan.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public boolean zzg() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public zzq zzh() {
            zzq zzqVarZzc = zzq.zzc(this.zzf);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public boolean zzk() {
            return (this.zzd & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzao
        public zzap zzl() {
            zzap zzapVar = this.zzg;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzao extends zzifq {
        boolean zza();

        String zzb();

        zzida zzc();

        boolean zzg();

        zzq zzh();

        boolean zzk();

        zzap zzl();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzap extends zziee<zzap, zza> implements zzaq {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzap zzf;
        private static volatile zzifx<zzap> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzap, zza> implements zzaq {
            private zza() {
                super(zzap.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
            public boolean zza() {
                return ((zzap) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
            public int zzb() {
                return ((zzap) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzap) this.zza).zzu(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzap) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
            public boolean zze() {
                return ((zzap) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
            public int zzf() {
                return ((zzap) this.zza).zzf();
            }

            public zza zzg(int i) {
                zzbg();
                ((zzap) this.zza).zzw(i);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzap) this.zza).zzx();
                return this;
            }
        }

        static {
            zzap zzapVar = new zzap();
            zzf = zzapVar;
            zziee.zzbu(zzap.class, zzapVar);
        }

        private zzap() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzw(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzx() {
            this.zzc &= -3;
            this.zze = 0;
        }

        public static zzap zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzap) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzap zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzap) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzap zzg(zzida zzidaVar) throws zziet {
            return (zzap) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzap zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzap) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzap zzi(byte[] bArr) throws zziet {
            return (zzap) zziee.zzbU(zzf, bArr);
        }

        public static zzap zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzap) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzap zzk(InputStream inputStream) throws IOException {
            return (zzap) zziee.zzbW(zzf, inputStream);
        }

        public static zzap zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzap) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzap zzm(InputStream inputStream) throws IOException {
            return (zzap) zzca(zzf, inputStream);
        }

        public static zzap zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzap) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzap zzo(zzide zzideVar) throws IOException {
            return (zzap) zziee.zzbY(zzf, zzideVar);
        }

        public static zzap zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzap) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzap zzapVar) {
            return (zza) zzf.zzbo(zzapVar);
        }

        public static zzap zzs() {
            return zzf;
        }

        public static zzifx<zzap> zzt() {
            return zzf.zzbd();
        }

        /* JADX INFO: renamed from: zzz */
        public void zzu(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
        public int zzb() {
            return this.zzd;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzap();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzap> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzap.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaq
        public int zzf() {
            return this.zze;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzaq extends zzifq {
        boolean zza();

        int zzb();

        boolean zze();

        int zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzar extends zziee<zzar, zza> implements zzas {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzar zzh;
        private static volatile zzifx<zzar> zzi;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzar, zza> implements zzas {
            private zza() {
                super(zzar.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public boolean zza() {
                return ((zzar) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public int zzb() {
                return ((zzar) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzar) this.zza).zzw(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzar) this.zza).zzx();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public boolean zze() {
                return ((zzar) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public int zzf() {
                return ((zzar) this.zza).zzf();
            }

            public zza zzg(int i) {
                zzbg();
                ((zzar) this.zza).zzy(i);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzar) this.zza).zzz();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public boolean zzi() {
                return ((zzar) this.zza).zzi();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzas
            public int zzj() {
                return ((zzar) this.zza).zzj();
            }

            public zza zzk(int i) {
                zzbg();
                ((zzar) this.zza).zzA(i);
                return this;
            }

            public zza zzl() {
                zzbg();
                ((zzar) this.zza).zzB();
                return this;
            }
        }

        static {
            zzar zzarVar = new zzar();
            zzh = zzarVar;
            zziee.zzbu(zzar.class, zzarVar);
        }

        private zzar() {
        }

        /* JADX INFO: renamed from: zzD */
        public void zzw(int i) {
            this.zzd |= 1;
            this.zze = i;
        }

        /* JADX INFO: renamed from: zzE */
        public void zzx() {
            this.zzd &= -2;
            this.zze = 0;
        }

        /* JADX INFO: renamed from: zzF */
        public void zzy(int i) {
            this.zzd |= 2;
            this.zzf = i;
        }

        /* JADX INFO: renamed from: zzG */
        public void zzz() {
            this.zzd &= -3;
            this.zzf = 0;
        }

        /* JADX INFO: renamed from: zzH */
        public void zzA(int i) {
            this.zzd |= 4;
            this.zzg = i;
        }

        /* JADX INFO: renamed from: zzI */
        public void zzB() {
            this.zzd &= -5;
            this.zzg = 0;
        }

        public static zzar zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzar) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzar zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzar) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzar zzg(zzida zzidaVar) throws zziet {
            return (zzar) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzar zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzar) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzar zzk(byte[] bArr) throws zziet {
            return (zzar) zziee.zzbU(zzh, bArr);
        }

        public static zzar zzl(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzar) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzar zzm(InputStream inputStream) throws IOException {
            return (zzar) zziee.zzbW(zzh, inputStream);
        }

        public static zzar zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzar) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzar zzo(InputStream inputStream) throws IOException {
            return (zzar) zzca(zzh, inputStream);
        }

        public static zzar zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzar) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzar zzq(zzide zzideVar) throws IOException {
            return (zzar) zziee.zzbY(zzh, zzideVar);
        }

        public static zzar zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzar) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzs() {
            return (zza) zzh.zzbn();
        }

        public static zza zzt(zzar zzarVar) {
            return (zza) zzh.zzbo(zzarVar);
        }

        public static zzar zzu() {
            return zzh;
        }

        public static zzifx<zzar> zzv() {
            return zzh.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public int zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzar();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzar> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzar.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public boolean zze() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public int zzf() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public boolean zzi() {
            return (this.zzd & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzas
        public int zzj() {
            return this.zzg;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzas extends zzifq {
        boolean zza();

        int zzb();

        boolean zze();

        int zzf();

        boolean zzi();

        int zzj();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzat extends zziee<zzat, zza> implements zzbi {
        private static final zzat zzL;
        private static volatile zzifx<zzat> zzM = null;
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        public static final int zze = 9;
        public static final int zzf = 10;
        public static final int zzg = 11;
        public static final int zzh = 12;
        public static final int zzi = 13;
        public static final int zzj = 14;
        public static final int zzk = 15;
        public static final int zzl = 16;
        public static final int zzm = 17;
        public static final int zzn = 18;
        public static final int zzo = 19;
        public static final int zzp = 20;
        private zzbc zzA;
        private zzay zzB;
        private int zzC;
        private int zzD;
        private zzap zzE;
        private int zzF;
        private int zzG;
        private int zzH;
        private int zzI;
        private int zzJ;
        private long zzK;
        private int zzu;
        private zzba zzv;
        private zzbe zzw;
        private zzbg zzx;
        private zzbj zzy;
        private zzau zzz;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzat, zza> implements zzbi {
            private zza() {
                super(zzat.zzL);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            public zza zzA(zzau zzauVar) {
                zzbg();
                ((zzat) this.zza).zzT(zzauVar);
                return this;
            }

            public zza zzB(zzau.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzT(zzaVar.zzbu());
                return this;
            }

            public zza zzC(zzau zzauVar) {
                zzbg();
                ((zzat) this.zza).zzW(zzauVar);
                return this;
            }

            public zza zzD() {
                zzbg();
                ((zzat) this.zza).zzX();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzE() {
                return ((zzat) this.zza).zzE();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzbc zzF() {
                return ((zzat) this.zza).zzF();
            }

            public zza zzG(zzbc zzbcVar) {
                zzbg();
                ((zzat) this.zza).zzaa(zzbcVar);
                return this;
            }

            public zza zzH(zzbc.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzaa(zzaVar.zzbu());
                return this;
            }

            public zza zzI(zzbc zzbcVar) {
                zzbg();
                ((zzat) this.zza).zzab(zzbcVar);
                return this;
            }

            public zza zzJ() {
                zzbg();
                ((zzat) this.zza).zzac();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzK() {
                return ((zzat) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzay zzL() {
                return ((zzat) this.zza).zzL();
            }

            public zza zzM(zzay zzayVar) {
                zzbg();
                ((zzat) this.zza).zzad(zzayVar);
                return this;
            }

            public zza zzN(zzay.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzad(zzaVar.zzbu());
                return this;
            }

            public zza zzO(zzay zzayVar) {
                zzbg();
                ((zzat) this.zza).zzag(zzayVar);
                return this;
            }

            public zza zzP() {
                zzbg();
                ((zzat) this.zza).zzah();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzQ() {
                return ((zzat) this.zza).zzQ();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzR() {
                return ((zzat) this.zza).zzR();
            }

            public zza zzS(int i) {
                zzbg();
                ((zzat) this.zza).zzak(i);
                return this;
            }

            public zza zzT() {
                zzbg();
                ((zzat) this.zza).zzal();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzU() {
                return ((zzat) this.zza).zzU();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzV() {
                return ((zzat) this.zza).zzV();
            }

            public zza zzW(int i) {
                zzbg();
                ((zzat) this.zza).zzao(i);
                return this;
            }

            public zza zzX() {
                zzbg();
                ((zzat) this.zza).zzap();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzY() {
                return ((zzat) this.zza).zzY();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzap zzZ() {
                return ((zzat) this.zza).zzZ();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zza() {
                return ((zzat) this.zza).zza();
            }

            public zza zzaA(long j) {
                zzbg();
                ((zzat) this.zza).zzaJ(j);
                return this;
            }

            public zza zzaB() {
                zzbg();
                ((zzat) this.zza).zzaK();
                return this;
            }

            public zza zzaa(zzap zzapVar) {
                zzbg();
                ((zzat) this.zza).zzas(zzapVar);
                return this;
            }

            public zza zzab(zzap.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzas(zzaVar.zzbu());
                return this;
            }

            public zza zzac(zzap zzapVar) {
                zzbg();
                ((zzat) this.zza).zzat(zzapVar);
                return this;
            }

            public zza zzad() {
                zzbg();
                ((zzat) this.zza).zzaw();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzae() {
                return ((zzat) this.zza).zzae();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzaf() {
                return ((zzat) this.zza).zzaf();
            }

            public zza zzag(int i) {
                zzbg();
                ((zzat) this.zza).zzax(i);
                return this;
            }

            public zza zzah() {
                zzbg();
                ((zzat) this.zza).zzaA();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzai() {
                return ((zzat) this.zza).zzai();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzaj() {
                return ((zzat) this.zza).zzaj();
            }

            public zza zzak(int i) {
                zzbg();
                ((zzat) this.zza).zzaB(i);
                return this;
            }

            public zza zzal() {
                zzbg();
                ((zzat) this.zza).zzaC();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzam() {
                return ((zzat) this.zza).zzam();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzan() {
                return ((zzat) this.zza).zzan();
            }

            public zza zzao(int i) {
                zzbg();
                ((zzat) this.zza).zzaD(i);
                return this;
            }

            public zza zzap() {
                zzbg();
                ((zzat) this.zza).zzaE();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzaq() {
                return ((zzat) this.zza).zzaq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzar() {
                return ((zzat) this.zza).zzar();
            }

            public zza zzas(int i) {
                zzbg();
                ((zzat) this.zza).zzaF(i);
                return this;
            }

            public zza zzat() {
                zzbg();
                ((zzat) this.zza).zzaG();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzau() {
                return ((zzat) this.zza).zzau();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public int zzav() {
                return ((zzat) this.zza).zzav();
            }

            public zza zzaw(int i) {
                zzbg();
                ((zzat) this.zza).zzaH(i);
                return this;
            }

            public zza zzax() {
                zzbg();
                ((zzat) this.zza).zzaI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzay() {
                return ((zzat) this.zza).zzay();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public long zzaz() {
                return ((zzat) this.zza).zzaz();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzba zzb() {
                return ((zzat) this.zza).zzb();
            }

            public zza zzc(zzba zzbaVar) {
                zzbg();
                ((zzat) this.zza).zzB(zzbaVar);
                return this;
            }

            public zza zzd(zzba.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzB(zzaVar.zzbu());
                return this;
            }

            public zza zze(zzba zzbaVar) {
                zzbg();
                ((zzat) this.zza).zzC(zzbaVar);
                return this;
            }

            public zza zzf() {
                zzbg();
                ((zzat) this.zza).zzD();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzg() {
                return ((zzat) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzbe zzh() {
                return ((zzat) this.zza).zzh();
            }

            public zza zzi(zzbe zzbeVar) {
                zzbg();
                ((zzat) this.zza).zzG(zzbeVar);
                return this;
            }

            public zza zzj(zzbe.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzG(zzaVar.zzbu());
                return this;
            }

            public zza zzk(zzbe zzbeVar) {
                zzbg();
                ((zzat) this.zza).zzH(zzbeVar);
                return this;
            }

            public zza zzl() {
                zzbg();
                ((zzat) this.zza).zzI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzm() {
                return ((zzat) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzbg zzn() {
                return ((zzat) this.zza).zzn();
            }

            public zza zzo(zzbg zzbgVar) {
                zzbg();
                ((zzat) this.zza).zzJ(zzbgVar);
                return this;
            }

            public zza zzp(zzbg.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzJ(zzaVar.zzbu());
                return this;
            }

            public zza zzq(zzbg zzbgVar) {
                zzbg();
                ((zzat) this.zza).zzM(zzbgVar);
                return this;
            }

            public zza zzr() {
                zzbg();
                ((zzat) this.zza).zzN();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzs() {
                return ((zzat) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzbj zzt() {
                return ((zzat) this.zza).zzt();
            }

            public zza zzu(zzbj zzbjVar) {
                zzbg();
                ((zzat) this.zza).zzO(zzbjVar);
                return this;
            }

            public zza zzv(zzbj.zza zzaVar) {
                zzbg();
                ((zzat) this.zza).zzO(zzaVar.zzbu());
                return this;
            }

            public zza zzw(zzbj zzbjVar) {
                zzbg();
                ((zzat) this.zza).zzP(zzbjVar);
                return this;
            }

            public zza zzx() {
                zzbg();
                ((zzat) this.zza).zzS();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public boolean zzy() {
                return ((zzat) this.zza).zzy();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
            public zzau zzz() {
                return ((zzat) this.zza).zzz();
            }
        }

        static {
            zzat zzatVar = new zzat();
            zzL = zzatVar;
            zziee.zzbu(zzat.class, zzatVar);
        }

        private zzat() {
        }

        public static zzifx<zzat> zzA() {
            return zzL.zzbd();
        }

        public static zzat zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzat) zziee.zzbR(zzL, byteBuffer);
        }

        /* JADX INFO: renamed from: zzcA */
        public void zzal() {
            this.zzu &= -129;
            this.zzC = 0;
        }

        /* JADX INFO: renamed from: zzcB */
        public void zzao(int i) {
            this.zzu |= 256;
            this.zzD = i;
        }

        /* JADX INFO: renamed from: zzcC */
        public void zzap() {
            this.zzu &= -257;
            this.zzD = 0;
        }

        /* JADX INFO: renamed from: zzcD */
        public void zzas(zzap zzapVar) {
            zzapVar.getClass();
            this.zzE = zzapVar;
            this.zzu |= 512;
        }

        /* JADX INFO: renamed from: zzcE */
        public void zzat(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzE;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzE = zzapVar;
            this.zzu |= 512;
        }

        /* JADX INFO: renamed from: zzcF */
        public void zzaw() {
            this.zzE = null;
            this.zzu &= -513;
        }

        /* JADX INFO: renamed from: zzcG */
        public void zzax(int i) {
            this.zzu |= 1024;
            this.zzF = i;
        }

        /* JADX INFO: renamed from: zzcH */
        public void zzaA() {
            this.zzu &= -1025;
            this.zzF = 0;
        }

        /* JADX INFO: renamed from: zzcI */
        public void zzaB(int i) {
            this.zzu |= 2048;
            this.zzG = i;
        }

        /* JADX INFO: renamed from: zzcJ */
        public void zzaC() {
            this.zzu &= -2049;
            this.zzG = 0;
        }

        /* JADX INFO: renamed from: zzcK */
        public void zzaD(int i) {
            this.zzu |= 4096;
            this.zzH = i;
        }

        /* JADX INFO: renamed from: zzcL */
        public void zzaE() {
            this.zzu &= -4097;
            this.zzH = 0;
        }

        /* JADX INFO: renamed from: zzcM */
        public void zzaF(int i) {
            this.zzu |= 8192;
            this.zzI = i;
        }

        /* JADX INFO: renamed from: zzcN */
        public void zzaG() {
            this.zzu &= -8193;
            this.zzI = 0;
        }

        /* JADX INFO: renamed from: zzcO */
        public void zzaH(int i) {
            this.zzu |= 16384;
            this.zzJ = i;
        }

        /* JADX INFO: renamed from: zzcP */
        public void zzaI() {
            this.zzu &= -16385;
            this.zzJ = 0;
        }

        /* JADX INFO: renamed from: zzcQ */
        public void zzaJ(long j) {
            this.zzu |= 32768;
            this.zzK = j;
        }

        /* JADX INFO: renamed from: zzcR */
        public void zzaK() {
            this.zzu &= -32769;
            this.zzK = 0L;
        }

        /* JADX INFO: renamed from: zzce */
        public void zzB(zzba zzbaVar) {
            zzbaVar.getClass();
            this.zzv = zzbaVar;
            this.zzu |= 1;
        }

        /* JADX INFO: renamed from: zzcf */
        public void zzC(zzba zzbaVar) {
            zzbaVar.getClass();
            zzba zzbaVar2 = this.zzv;
            if (zzbaVar2 != null && zzbaVar2 != zzba.zzy()) {
                zzba.zza zzaVarZzx = zzba.zzx(zzbaVar2);
                zzaVarZzx.zzbo(zzbaVar);
                zzbaVar = zzaVarZzx.zzbt();
            }
            this.zzv = zzbaVar;
            this.zzu |= 1;
        }

        /* JADX INFO: renamed from: zzcg */
        public void zzD() {
            this.zzv = null;
            this.zzu &= -2;
        }

        /* JADX INFO: renamed from: zzch */
        public void zzG(zzbe zzbeVar) {
            zzbeVar.getClass();
            this.zzw = zzbeVar;
            this.zzu |= 2;
        }

        /* JADX INFO: renamed from: zzci */
        public void zzH(zzbe zzbeVar) {
            zzbeVar.getClass();
            zzbe zzbeVar2 = this.zzw;
            if (zzbeVar2 != null && zzbeVar2 != zzbe.zzA()) {
                zzbe.zza zzaVarZzz = zzbe.zzz(zzbeVar2);
                zzaVarZzz.zzbo(zzbeVar);
                zzbeVar = zzaVarZzz.zzbt();
            }
            this.zzw = zzbeVar;
            this.zzu |= 2;
        }

        /* JADX INFO: renamed from: zzcj */
        public void zzI() {
            this.zzw = null;
            this.zzu &= -3;
        }

        /* JADX INFO: renamed from: zzck */
        public void zzJ(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzx = zzbgVar;
            this.zzu |= 4;
        }

        /* JADX INFO: renamed from: zzcl */
        public void zzM(zzbg zzbgVar) {
            zzbgVar.getClass();
            zzbg zzbgVar2 = this.zzx;
            if (zzbgVar2 != null && zzbgVar2 != zzbg.zzu()) {
                zzbg.zza zzaVarZzt = zzbg.zzt(zzbgVar2);
                zzaVarZzt.zzbo(zzbgVar);
                zzbgVar = zzaVarZzt.zzbt();
            }
            this.zzx = zzbgVar;
            this.zzu |= 4;
        }

        /* JADX INFO: renamed from: zzcm */
        public void zzN() {
            this.zzx = null;
            this.zzu &= -5;
        }

        /* JADX INFO: renamed from: zzcn */
        public void zzO(zzbj zzbjVar) {
            zzbjVar.getClass();
            this.zzy = zzbjVar;
            this.zzu |= 8;
        }

        /* JADX INFO: renamed from: zzco */
        public void zzP(zzbj zzbjVar) {
            zzbjVar.getClass();
            zzbj zzbjVar2 = this.zzy;
            if (zzbjVar2 != null && zzbjVar2 != zzbj.zzs()) {
                zzbj.zza zzaVarZzr = zzbj.zzr(zzbjVar2);
                zzaVarZzr.zzbo(zzbjVar);
                zzbjVar = zzaVarZzr.zzbt();
            }
            this.zzy = zzbjVar;
            this.zzu |= 8;
        }

        /* JADX INFO: renamed from: zzcp */
        public void zzS() {
            this.zzy = null;
            this.zzu &= -9;
        }

        /* JADX INFO: renamed from: zzcq */
        public void zzT(zzau zzauVar) {
            zzauVar.getClass();
            this.zzz = zzauVar;
            this.zzu |= 16;
        }

        /* JADX INFO: renamed from: zzcr */
        public void zzW(zzau zzauVar) {
            zzauVar.getClass();
            zzau zzauVar2 = this.zzz;
            if (zzauVar2 != null && zzauVar2 != zzau.zzu()) {
                zzau.zza zzaVarZzt = zzau.zzt(zzauVar2);
                zzaVarZzt.zzbo(zzauVar);
                zzauVar = zzaVarZzt.zzbt();
            }
            this.zzz = zzauVar;
            this.zzu |= 16;
        }

        /* JADX INFO: renamed from: zzcs */
        public void zzX() {
            this.zzz = null;
            this.zzu &= -17;
        }

        /* JADX INFO: renamed from: zzct */
        public void zzaa(zzbc zzbcVar) {
            zzbcVar.getClass();
            this.zzA = zzbcVar;
            this.zzu |= 32;
        }

        /* JADX INFO: renamed from: zzcu */
        public void zzab(zzbc zzbcVar) {
            zzbcVar.getClass();
            zzbc zzbcVar2 = this.zzA;
            if (zzbcVar2 != null && zzbcVar2 != zzbc.zzu()) {
                zzbc.zza zzaVarZzt = zzbc.zzt(zzbcVar2);
                zzaVarZzt.zzbo(zzbcVar);
                zzbcVar = zzaVarZzt.zzbt();
            }
            this.zzA = zzbcVar;
            this.zzu |= 32;
        }

        /* JADX INFO: renamed from: zzcv */
        public void zzac() {
            this.zzA = null;
            this.zzu &= -33;
        }

        /* JADX INFO: renamed from: zzcw */
        public void zzad(zzay zzayVar) {
            zzayVar.getClass();
            this.zzB = zzayVar;
            this.zzu |= 64;
        }

        /* JADX INFO: renamed from: zzcx */
        public void zzag(zzay zzayVar) {
            zzayVar.getClass();
            zzay zzayVar2 = this.zzB;
            if (zzayVar2 != null && zzayVar2 != zzay.zzx()) {
                zzay.zza zzaVarZzw = zzay.zzw(zzayVar2);
                zzaVarZzw.zzbo(zzayVar);
                zzayVar = zzaVarZzw.zzbt();
            }
            this.zzB = zzayVar;
            this.zzu |= 64;
        }

        /* JADX INFO: renamed from: zzcy */
        public void zzah() {
            this.zzB = null;
            this.zzu &= -65;
        }

        /* JADX INFO: renamed from: zzcz */
        public void zzak(int i) {
            this.zzu |= 128;
            this.zzC = i;
        }

        public static zzat zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzat) zziee.zzbQ(zzL, byteBuffer, zzidoVar);
        }

        public static zzat zze(zzida zzidaVar) throws zziet {
            return (zzat) zziee.zzbS(zzL, zzidaVar);
        }

        public static zzat zzi(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzat) zziee.zzbT(zzL, zzidaVar, zzidoVar);
        }

        public static zzat zzj(byte[] bArr) throws zziet {
            return (zzat) zziee.zzbU(zzL, bArr);
        }

        public static zzat zzk(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzat) zziee.zzbV(zzL, bArr, zzidoVar);
        }

        public static zzat zzl(InputStream inputStream) throws IOException {
            return (zzat) zziee.zzbW(zzL, inputStream);
        }

        public static zzat zzo(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzat) zziee.zzbX(zzL, inputStream, zzidoVar);
        }

        public static zzat zzp(InputStream inputStream) throws IOException {
            return (zzat) zzca(zzL, inputStream);
        }

        public static zzat zzq(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzat) zzcb(zzL, inputStream, zzidoVar);
        }

        public static zzat zzr(zzide zzideVar) throws IOException {
            return (zzat) zziee.zzbY(zzL, zzideVar);
        }

        public static zzat zzu(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzat) zziee.zzbZ(zzL, zzideVar, zzidoVar);
        }

        public static zza zzv() {
            return (zza) zzL.zzbn();
        }

        public static zza zzw(zzat zzatVar) {
            return (zza) zzL.zzbo(zzatVar);
        }

        public static zzat zzx() {
            return zzL;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzE() {
            return (this.zzu & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzbc zzF() {
            zzbc zzbcVar = this.zzA;
            return zzbcVar == null ? zzbc.zzu() : zzbcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzK() {
            return (this.zzu & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzay zzL() {
            zzay zzayVar = this.zzB;
            return zzayVar == null ? zzay.zzx() : zzayVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzQ() {
            return (this.zzu & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzR() {
            return this.zzC;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzU() {
            return (this.zzu & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzV() {
            return this.zzD;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzY() {
            return (this.zzu & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzap zzZ() {
            zzap zzapVar = this.zzE;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zza() {
            return (this.zzu & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzae() {
            return (this.zzu & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzaf() {
            return this.zzF;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzai() {
            return (this.zzu & 2048) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzaj() {
            return this.zzG;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzam() {
            return (this.zzu & 4096) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzan() {
            return this.zzH;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzaq() {
            return (this.zzu & 8192) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzar() {
            return this.zzI;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzau() {
            return (this.zzu & 16384) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public int zzav() {
            return this.zzJ;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzay() {
            return (this.zzu & 32768) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public long zzaz() {
            return this.zzK;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzba zzb() {
            zzba zzbaVar = this.zzv;
            return zzbaVar == null ? zzba.zzy() : zzbaVar;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzL, "\u0004\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fင\u0007\rင\b\u000eဉ\t\u000fင\n\u0010င\u000b\u0011င\f\u0012င\r\u0013င\u000e\u0014ဃ\u000f", new Object[]{"zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK"});
            }
            if (iOrdinal == 3) {
                return new zzat();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzL;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzat> zzifxVar = zzM;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzat.class) {
                zzidzVar = zzM;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzL);
                    zzM = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzg() {
            return (this.zzu & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzbe zzh() {
            zzbe zzbeVar = this.zzw;
            return zzbeVar == null ? zzbe.zzA() : zzbeVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzm() {
            return (this.zzu & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzbg zzn() {
            zzbg zzbgVar = this.zzx;
            return zzbgVar == null ? zzbg.zzu() : zzbgVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzs() {
            return (this.zzu & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzbj zzt() {
            zzbj zzbjVar = this.zzy;
            return zzbjVar == null ? zzbj.zzs() : zzbjVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public boolean zzy() {
            return (this.zzu & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbi
        public zzau zzz() {
            zzau zzauVar = this.zzz;
            return zzauVar == null ? zzau.zzu() : zzauVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzau extends zziee<zzau, zza> implements zzav {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzau zzh;
        private static volatile zzifx<zzau> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzau, zza> implements zzav {
            private zza() {
                super(zzau.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public boolean zza() {
                return ((zzau) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public zzq zzb() {
                return ((zzau) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzau) this.zza).zzw(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzau) this.zza).zzx();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public boolean zze() {
                return ((zzau) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public zzaw zzf() {
                return ((zzau) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzau) this.zza).zzy(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzau) this.zza).zzy(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzau) this.zza).zzz(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzau) this.zza).zzA();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public boolean zzk() {
                return ((zzau) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzav
            public zzap zzl() {
                return ((zzau) this.zza).zzl();
            }

            public zza zzm(zzap zzapVar) {
                zzbg();
                ((zzau) this.zza).zzB(zzapVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbg();
                ((zzau) this.zza).zzB(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbg();
                ((zzau) this.zza).zzC(zzapVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzau) this.zza).zzD();
                return this;
            }
        }

        static {
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zziee.zzbu(zzau.class, zzauVar);
        }

        private zzau() {
        }

        /* JADX INFO: renamed from: zzF */
        public void zzw(zzq zzqVar) {
            this.zze = zzqVar.zza();
            this.zzd |= 1;
        }

        /* JADX INFO: renamed from: zzG */
        public void zzx() {
            this.zzd &= -2;
            this.zze = 1000;
        }

        /* JADX INFO: renamed from: zzH */
        public void zzy(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzI */
        public void zzz(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzf;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzJ */
        public void zzA() {
            this.zzf = null;
            this.zzd &= -3;
        }

        /* JADX INFO: renamed from: zzK */
        public void zzB(zzap zzapVar) {
            zzapVar.getClass();
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzL */
        public void zzC(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzg;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzM */
        public void zzD() {
            this.zzg = null;
            this.zzd &= -5;
        }

        public static zzau zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzau) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzau zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzau) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzau zzg(zzida zzidaVar) throws zziet {
            return (zzau) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzau zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzau) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzau zzi(byte[] bArr) throws zziet {
            return (zzau) zziee.zzbU(zzh, bArr);
        }

        public static zzau zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzau) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzau zzm(InputStream inputStream) throws IOException {
            return (zzau) zziee.zzbW(zzh, inputStream);
        }

        public static zzau zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzau) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzau zzo(InputStream inputStream) throws IOException {
            return (zzau) zzca(zzh, inputStream);
        }

        public static zzau zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzau) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzau zzq(zzide zzideVar) throws IOException {
            return (zzau) zziee.zzbY(zzh, zzideVar);
        }

        public static zzau zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzau) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzs() {
            return (zza) zzh.zzbn();
        }

        public static zza zzt(zzau zzauVar) {
            return (zza) zzh.zzbo(zzauVar);
        }

        public static zzau zzu() {
            return zzh;
        }

        public static zzifx<zzau> zzv() {
            return zzh.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zze);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zze(), "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzau();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzau> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzau.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public boolean zze() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public zzaw zzf() {
            zzaw zzawVar = this.zzf;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public boolean zzk() {
            return (this.zzd & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzav
        public zzap zzl() {
            zzap zzapVar = this.zzg;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzav extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();

        boolean zzk();

        zzap zzl();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzaw extends zziee<zzaw, zza> implements zzax {
        public static final int zza = 1;
        private static final zzaw zzd;
        private static volatile zzifx<zzaw> zze;
        private int zzb;
        private int zzc;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzaw, zza> implements zzax {
            private zza() {
                super(zzaw.zzd);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzax
            public boolean zza() {
                return ((zzaw) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzax
            public zzb zzb() {
                return ((zzaw) this.zza).zzb();
            }

            public zza zzc(zzb zzbVar) {
                zzbg();
                ((zzaw) this.zza).zzt(zzbVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzaw) this.zza).zzu();
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzb implements zziei {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);

            public static final int zze = 0;
            public static final int zzf = 1;
            public static final int zzg = 2;
            public static final int zzh = 3;
            private static final zziej<zzb> zzi = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaw.zzb.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            };
            private final int zzj;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzaw$zzb$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzb> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzb.zzc(i) != null;
                }
            }

            zzb(int i) {
                this.zzj = i;
            }

            public static zzb zzc(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            public static zziej<zzb> zzd() {
                return zzi;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzj);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzj;
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzd = zzawVar;
            zziee.zzbu(zzaw.class, zzawVar);
        }

        private zzaw() {
        }

        public static zzaw zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzaw) zziee.zzbR(zzd, byteBuffer);
        }

        public static zzaw zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzaw) zziee.zzbQ(zzd, byteBuffer, zzidoVar);
        }

        public static zzaw zze(zzida zzidaVar) throws zziet {
            return (zzaw) zziee.zzbS(zzd, zzidaVar);
        }

        public static zzaw zzg(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzaw) zziee.zzbT(zzd, zzidaVar, zzidoVar);
        }

        public static zzaw zzh(byte[] bArr) throws zziet {
            return (zzaw) zziee.zzbU(zzd, bArr);
        }

        public static zzaw zzi(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzaw) zziee.zzbV(zzd, bArr, zzidoVar);
        }

        public static zzaw zzj(InputStream inputStream) throws IOException {
            return (zzaw) zziee.zzbW(zzd, inputStream);
        }

        public static zzaw zzk(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzaw) zziee.zzbX(zzd, inputStream, zzidoVar);
        }

        public static zzaw zzl(InputStream inputStream) throws IOException {
            return (zzaw) zzca(zzd, inputStream);
        }

        public static zzaw zzm(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzaw) zzcb(zzd, inputStream, zzidoVar);
        }

        public static zzaw zzn(zzide zzideVar) throws IOException {
            return (zzaw) zziee.zzbY(zzd, zzideVar);
        }

        public static zzaw zzo(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzaw) zziee.zzbZ(zzd, zzideVar, zzidoVar);
        }

        public static zza zzp() {
            return (zza) zzd.zzbn();
        }

        public static zza zzq(zzaw zzawVar) {
            return (zza) zzd.zzbo(zzawVar);
        }

        public static zzaw zzr() {
            return zzd;
        }

        public static zzifx<zzaw> zzs() {
            return zzd.zzbd();
        }

        /* JADX INFO: renamed from: zzw */
        public void zzt(zzb zzbVar) {
            this.zzc = zzbVar.zza();
            this.zzb |= 1;
        }

        /* JADX INFO: renamed from: zzx */
        public void zzu() {
            this.zzb &= -2;
            this.zzc = 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzax
        public boolean zza() {
            return (this.zzb & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzax
        public zzb zzb() {
            zzb zzbVarZzc = zzb.zzc(this.zzc);
            return zzbVarZzc == null ? zzb.VIDEO_ERROR_CODE_UNSPECIFIED : zzbVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzd, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzb", "zzc", zzb.zze()});
            }
            if (iOrdinal == 3) {
                return new zzaw();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzd;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzaw> zzifxVar = zze;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzaw.class) {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            }
            return zzidzVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzax extends zzifq {
        boolean zza();

        zzaw.zzb zzb();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzay extends zziee<zzay, zza> implements zzaz {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzay zzj;
        private static volatile zzifx<zzay> zzk;
        private int zze;
        private zzar zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private zzap zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzay, zza> implements zzaz {
            private zza() {
                super(zzay.zzj);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public boolean zza() {
                return ((zzay) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public zzar zzb() {
                return ((zzay) this.zza).zzb();
            }

            public zza zzc(zzar zzarVar) {
                zzbg();
                ((zzay) this.zza).zzz(zzarVar);
                return this;
            }

            public zza zzd(zzar.zza zzaVar) {
                zzbg();
                ((zzay) this.zza).zzz(zzaVar.zzbu());
                return this;
            }

            public zza zze(zzar zzarVar) {
                zzbg();
                ((zzay) this.zza).zzA(zzarVar);
                return this;
            }

            public zza zzf() {
                zzbg();
                ((zzay) this.zza).zzB();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public boolean zzg() {
                return ((zzay) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public zzq zzh() {
                return ((zzay) this.zza).zzh();
            }

            public zza zzi(zzq zzqVar) {
                zzbg();
                ((zzay) this.zza).zzC(zzqVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzay) this.zza).zzD();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public boolean zzk() {
                return ((zzay) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public zzaw zzl() {
                return ((zzay) this.zza).zzl();
            }

            public zza zzm(zzaw zzawVar) {
                zzbg();
                ((zzay) this.zza).zzE(zzawVar);
                return this;
            }

            public zza zzn(zzaw.zza zzaVar) {
                zzbg();
                ((zzay) this.zza).zzE(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzaw zzawVar) {
                zzbg();
                ((zzay) this.zza).zzF(zzawVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzay) this.zza).zzG();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public boolean zzq() {
                return ((zzay) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
            public zzap zzr() {
                return ((zzay) this.zza).zzr();
            }

            public zza zzs(zzap zzapVar) {
                zzbg();
                ((zzay) this.zza).zzH(zzapVar);
                return this;
            }

            public zza zzt(zzap.zza zzaVar) {
                zzbg();
                ((zzay) this.zza).zzH(zzaVar.zzbu());
                return this;
            }

            public zza zzu(zzap zzapVar) {
                zzbg();
                ((zzay) this.zza).zzI(zzapVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzay) this.zza).zzJ();
                return this;
            }
        }

        static {
            zzay zzayVar = new zzay();
            zzj = zzayVar;
            zziee.zzbu(zzay.class, zzayVar);
        }

        private zzay() {
        }

        /* JADX INFO: renamed from: zzL */
        public void zzz(zzar zzarVar) {
            zzarVar.getClass();
            this.zzf = zzarVar;
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzM */
        public void zzA(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzf;
            if (zzarVar2 != null && zzarVar2 != zzar.zzu()) {
                zzar.zza zzaVarZzt = zzar.zzt(zzarVar2);
                zzaVarZzt.zzbo(zzarVar);
                zzarVar = zzaVarZzt.zzbt();
            }
            this.zzf = zzarVar;
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzN */
        public void zzB() {
            this.zzf = null;
            this.zze &= -2;
        }

        /* JADX INFO: renamed from: zzO */
        public void zzC(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zze |= 2;
        }

        /* JADX INFO: renamed from: zzP */
        public void zzD() {
            this.zze &= -3;
            this.zzg = 1000;
        }

        /* JADX INFO: renamed from: zzQ */
        public void zzE(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzh = zzawVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzR */
        public void zzF(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzh;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzh = zzawVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzG() {
            this.zzh = null;
            this.zze &= -5;
        }

        /* JADX INFO: renamed from: zzT */
        public void zzH(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zze |= 8;
        }

        /* JADX INFO: renamed from: zzU */
        public void zzI(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzi = zzapVar;
            this.zze |= 8;
        }

        /* JADX INFO: renamed from: zzV */
        public void zzJ() {
            this.zzi = null;
            this.zze &= -9;
        }

        public static zzay zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzay) zziee.zzbR(zzj, byteBuffer);
        }

        public static zzay zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzay) zziee.zzbQ(zzj, byteBuffer, zzidoVar);
        }

        public static zzay zze(zzida zzidaVar) throws zziet {
            return (zzay) zziee.zzbS(zzj, zzidaVar);
        }

        public static zzay zzi(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzay) zziee.zzbT(zzj, zzidaVar, zzidoVar);
        }

        public static zzay zzj(byte[] bArr) throws zziet {
            return (zzay) zziee.zzbU(zzj, bArr);
        }

        public static zzay zzm(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzay) zziee.zzbV(zzj, bArr, zzidoVar);
        }

        public static zzay zzn(InputStream inputStream) throws IOException {
            return (zzay) zziee.zzbW(zzj, inputStream);
        }

        public static zzay zzo(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzay) zziee.zzbX(zzj, inputStream, zzidoVar);
        }

        public static zzay zzp(InputStream inputStream) throws IOException {
            return (zzay) zzca(zzj, inputStream);
        }

        public static zzay zzs(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzay) zzcb(zzj, inputStream, zzidoVar);
        }

        public static zzay zzt(zzide zzideVar) throws IOException {
            return (zzay) zziee.zzbY(zzj, zzideVar);
        }

        public static zzay zzu(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzay) zziee.zzbZ(zzj, zzideVar, zzidoVar);
        }

        public static zza zzv() {
            return (zza) zzj.zzbn();
        }

        public static zza zzw(zzay zzayVar) {
            return (zza) zzj.zzbo(zzayVar);
        }

        public static zzay zzx() {
            return zzj;
        }

        public static zzifx<zzay> zzy() {
            return zzj.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public boolean zza() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public zzar zzb() {
            zzar zzarVar = this.zzf;
            return zzarVar == null ? zzar.zzu() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzq.zze(), "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzay();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzay> zzifxVar = zzk;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzay.class) {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public boolean zzg() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public zzq zzh() {
            zzq zzqVarZzc = zzq.zzc(this.zzg);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public boolean zzk() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public zzaw zzl() {
            zzaw zzawVar = this.zzh;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public boolean zzq() {
            return (this.zze & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaz
        public zzap zzr() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzaz extends zzifq {
        boolean zza();

        zzar zzb();

        boolean zzg();

        zzq zzh();

        boolean zzk();

        zzaw zzl();

        boolean zzq();

        zzap zzr();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzb extends zziee<zzb, zzc> implements zzc {
        public static final int zza = 1;
        private static final zzb zzc;
        private static volatile zzifx<zzb> zzd;
        private zzieq<zza> zzb = zzbM();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zziee<zza, C0024zza> implements InterfaceC0025zzb {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zza zzh;
            private static volatile zzifx<zza> zzi;
            private int zzd;
            private int zze;
            private zze zzf;
            private zzg zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzb$zza$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            public final class C0024zza extends zzidy<zza, C0024zza> implements InterfaceC0025zzb {
                private C0024zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0024zza(byte[] bArr) {
                    this();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public boolean zza() {
                    return ((zza) this.zza).zza();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public zzd zzb() {
                    return ((zza) this.zza).zzb();
                }

                public C0024zza zzc(zzd zzdVar) {
                    zzbg();
                    ((zza) this.zza).zzw(zzdVar);
                    return this;
                }

                public C0024zza zzd() {
                    zzbg();
                    ((zza) this.zza).zzx();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public boolean zze() {
                    return ((zza) this.zza).zze();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public zze zzf() {
                    return ((zza) this.zza).zzf();
                }

                public C0024zza zzg(zze zzeVar) {
                    zzbg();
                    ((zza) this.zza).zzy(zzeVar);
                    return this;
                }

                public C0024zza zzh(zze.zza zzaVar) {
                    zzbg();
                    ((zza) this.zza).zzy(zzaVar.zzbu());
                    return this;
                }

                public C0024zza zzi(zze zzeVar) {
                    zzbg();
                    ((zza) this.zza).zzz(zzeVar);
                    return this;
                }

                public C0024zza zzj() {
                    zzbg();
                    ((zza) this.zza).zzA();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public boolean zzk() {
                    return ((zza) this.zza).zzk();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
                public zzg zzl() {
                    return ((zza) this.zza).zzl();
                }

                public C0024zza zzm(zzg zzgVar) {
                    zzbg();
                    ((zza) this.zza).zzB(zzgVar);
                    return this;
                }

                public C0024zza zzn(zzg.zza zzaVar) {
                    zzbg();
                    ((zza) this.zza).zzB(zzaVar.zzbu());
                    return this;
                }

                public C0024zza zzo(zzg zzgVar) {
                    zzbg();
                    ((zza) this.zza).zzC(zzgVar);
                    return this;
                }

                public C0024zza zzp() {
                    zzbg();
                    ((zza) this.zza).zzD();
                    return this;
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zziee.zzbu(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: renamed from: zzF */
            public void zzw(zzd zzdVar) {
                this.zze = zzdVar.zza();
                this.zzd |= 1;
            }

            /* JADX INFO: renamed from: zzG */
            public void zzx() {
                this.zzd &= -2;
                this.zze = 0;
            }

            /* JADX INFO: renamed from: zzH */
            public void zzy(zze zzeVar) {
                zzeVar.getClass();
                this.zzf = zzeVar;
                this.zzd |= 2;
            }

            /* JADX INFO: renamed from: zzI */
            public void zzz(zze zzeVar) {
                zzeVar.getClass();
                zze zzeVar2 = this.zzf;
                if (zzeVar2 != null && zzeVar2 != zze.zzs()) {
                    zze.zza zzaVarZzr = zze.zzr(zzeVar2);
                    zzaVarZzr.zzbo(zzeVar);
                    zzeVar = zzaVarZzr.zzbt();
                }
                this.zzf = zzeVar;
                this.zzd |= 2;
            }

            /* JADX INFO: renamed from: zzJ */
            public void zzA() {
                this.zzf = null;
                this.zzd &= -3;
            }

            /* JADX INFO: renamed from: zzK */
            public void zzB(zzg zzgVar) {
                zzgVar.getClass();
                this.zzg = zzgVar;
                this.zzd |= 4;
            }

            /* JADX INFO: renamed from: zzL */
            public void zzC(zzg zzgVar) {
                zzgVar.getClass();
                zzg zzgVar2 = this.zzg;
                if (zzgVar2 != null && zzgVar2 != zzg.zzu()) {
                    zzg.zza zzaVarZzt = zzg.zzt(zzgVar2);
                    zzaVarZzt.zzbo(zzgVar);
                    zzgVar = zzaVarZzt.zzbt();
                }
                this.zzg = zzgVar;
                this.zzd |= 4;
            }

            /* JADX INFO: renamed from: zzM */
            public void zzD() {
                this.zzg = null;
                this.zzd &= -5;
            }

            public static zza zzc(ByteBuffer byteBuffer) throws zziet {
                return (zza) zziee.zzbR(zzh, byteBuffer);
            }

            public static zza zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
            }

            public static zza zzg(zzida zzidaVar) throws zziet {
                return (zza) zziee.zzbS(zzh, zzidaVar);
            }

            public static zza zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbT(zzh, zzidaVar, zzidoVar);
            }

            public static zza zzi(byte[] bArr) throws zziet {
                return (zza) zziee.zzbU(zzh, bArr);
            }

            public static zza zzj(byte[] bArr, zzido zzidoVar) throws zziet {
                return (zza) zziee.zzbV(zzh, bArr, zzidoVar);
            }

            public static zza zzm(InputStream inputStream) throws IOException {
                return (zza) zziee.zzbW(zzh, inputStream);
            }

            public static zza zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zza) zziee.zzbX(zzh, inputStream, zzidoVar);
            }

            public static zza zzo(InputStream inputStream) throws IOException {
                return (zza) zzca(zzh, inputStream);
            }

            public static zza zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zza) zzcb(zzh, inputStream, zzidoVar);
            }

            public static zza zzq(zzide zzideVar) throws IOException {
                return (zza) zziee.zzbY(zzh, zzideVar);
            }

            public static zza zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
                return (zza) zziee.zzbZ(zzh, zzideVar, zzidoVar);
            }

            public static C0024zza zzs() {
                return (C0024zza) zzh.zzbn();
            }

            public static C0024zza zzt(zza zzaVar) {
                return (C0024zza) zzh.zzbo(zzaVar);
            }

            public static zza zzu() {
                return zzh;
            }

            public static zzifx<zza> zzv() {
                return zzh.zzbd();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public boolean zza() {
                return (this.zzd & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public zzd zzb() {
                zzd zzdVarZzc = zzd.zzc(this.zze);
                return zzdVarZzc == null ? zzd.UNSPECIFIED : zzdVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zziee
            protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
                zzifx zzidzVar;
                int iOrdinal = zziedVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzd.zze(), "zzf", "zzg"});
                }
                if (iOrdinal == 3) {
                    return new zza();
                }
                if (iOrdinal == 4) {
                    return new C0024zza(null);
                }
                if (iOrdinal == 5) {
                    return zzh;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzifx<zza> zzifxVar = zzi;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zza.class) {
                    zzidzVar = zzi;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzh);
                        zzi = zzidzVar;
                    }
                }
                return zzidzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public boolean zze() {
                return (this.zzd & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public zze zzf() {
                zze zzeVar = this.zzf;
                return zzeVar == null ? zze.zzs() : zzeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public boolean zzk() {
                return (this.zzd & 4) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.InterfaceC0025zzb
            public zzg zzl() {
                zzg zzgVar = this.zzg;
                return zzgVar == null ? zzg.zzu() : zzgVar;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzb$zzb */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public interface InterfaceC0025zzb extends zzifq {
            boolean zza();

            zzd zzb();

            boolean zze();

            zze zzf();

            boolean zzk();

            zzg zzl();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zzc extends zzidy<zzb, zzc> implements zzc {
            private zzc() {
                super(zzb.zzc);
            }

            /* synthetic */ zzc(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzc
            public List<zza> zza() {
                return Collections.unmodifiableList(((zzb) this.zza).zza());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzc
            public int zzb() {
                return ((zzb) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzc
            public zza zzc(int i) {
                return ((zzb) this.zza).zzc(i);
            }

            public zzc zzd(int i, zza zzaVar) {
                zzbg();
                ((zzb) this.zza).zzw(i, zzaVar);
                return this;
            }

            public zzc zze(int i, zza.C0024zza c0024zza) {
                zzbg();
                ((zzb) this.zza).zzw(i, c0024zza.zzbu());
                return this;
            }

            public zzc zzf(zza zzaVar) {
                zzbg();
                ((zzb) this.zza).zzx(zzaVar);
                return this;
            }

            public zzc zzg(int i, zza zzaVar) {
                zzbg();
                ((zzb) this.zza).zzy(i, zzaVar);
                return this;
            }

            public zzc zzh(zza.C0024zza c0024zza) {
                zzbg();
                ((zzb) this.zza).zzx(c0024zza.zzbu());
                return this;
            }

            public zzc zzi(int i, zza.C0024zza c0024zza) {
                zzbg();
                ((zzb) this.zza).zzy(i, c0024zza.zzbu());
                return this;
            }

            public zzc zzj(Iterable<? extends zza> iterable) {
                zzbg();
                ((zzb) this.zza).zzz(iterable);
                return this;
            }

            public zzc zzk() {
                zzbg();
                ((zzb) this.zza).zzA();
                return this;
            }

            public zzc zzl(int i) {
                zzbg();
                ((zzb) this.zza).zzB(i);
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzd implements zziei {
            UNSPECIFIED(0),
            IN_MEMORY(1);

            public static final int zzc = 0;
            public static final int zzd = 1;
            private static final zziej<zzd> zze = new zziej<zzd>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzb.zzd.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzc(i);
                }
            };
            private final int zzf;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzb$zzd$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzd> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzd zzb(int i) {
                    return zzd.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzd.zzc(i) != null;
                }
            }

            zzd(int i) {
                this.zzf = i;
            }

            public static zzd zzc(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
            }

            public static zziej<zzd> zzd() {
                return zze;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzf);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzf;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zze extends zziee<zze, zza> implements zzf {
            public static final int zza = 1;
            public static final int zzb = 2;
            private static final zze zzf;
            private static volatile zzifx<zze> zzg;
            private int zzc;
            private boolean zzd;
            private int zze;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            public final class zza extends zzidy<zze, zza> implements zzf {
                private zza() {
                    super(zze.zzf);
                }

                /* synthetic */ zza(byte[] bArr) {
                    this();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
                public boolean zza() {
                    return ((zze) this.zza).zza();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
                public boolean zzb() {
                    return ((zze) this.zza).zzb();
                }

                public zza zzc(boolean z) {
                    zzbg();
                    ((zze) this.zza).zzu(z);
                    return this;
                }

                public zza zzd() {
                    zzbg();
                    ((zze) this.zza).zzv();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
                public boolean zze() {
                    return ((zze) this.zza).zze();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
                public int zzf() {
                    return ((zze) this.zza).zzf();
                }

                public zza zzg(int i) {
                    zzbg();
                    ((zze) this.zza).zzw(i);
                    return this;
                }

                public zza zzh() {
                    zzbg();
                    ((zze) this.zza).zzx();
                    return this;
                }
            }

            static {
                zze zzeVar = new zze();
                zzf = zzeVar;
                zziee.zzbu(zze.class, zzeVar);
            }

            private zze() {
            }

            /* JADX INFO: renamed from: zzA */
            public void zzv() {
                this.zzc &= -2;
                this.zzd = false;
            }

            /* JADX INFO: renamed from: zzB */
            public void zzw(int i) {
                this.zzc |= 2;
                this.zze = i;
            }

            /* JADX INFO: renamed from: zzC */
            public void zzx() {
                this.zzc &= -3;
                this.zze = 0;
            }

            public static zze zzc(ByteBuffer byteBuffer) throws zziet {
                return (zze) zziee.zzbR(zzf, byteBuffer);
            }

            public static zze zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
                return (zze) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
            }

            public static zze zzg(zzida zzidaVar) throws zziet {
                return (zze) zziee.zzbS(zzf, zzidaVar);
            }

            public static zze zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
                return (zze) zziee.zzbT(zzf, zzidaVar, zzidoVar);
            }

            public static zze zzi(byte[] bArr) throws zziet {
                return (zze) zziee.zzbU(zzf, bArr);
            }

            public static zze zzj(byte[] bArr, zzido zzidoVar) throws zziet {
                return (zze) zziee.zzbV(zzf, bArr, zzidoVar);
            }

            public static zze zzk(InputStream inputStream) throws IOException {
                return (zze) zziee.zzbW(zzf, inputStream);
            }

            public static zze zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zze) zziee.zzbX(zzf, inputStream, zzidoVar);
            }

            public static zze zzm(InputStream inputStream) throws IOException {
                return (zze) zzca(zzf, inputStream);
            }

            public static zze zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zze) zzcb(zzf, inputStream, zzidoVar);
            }

            public static zze zzo(zzide zzideVar) throws IOException {
                return (zze) zziee.zzbY(zzf, zzideVar);
            }

            public static zze zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
                return (zze) zziee.zzbZ(zzf, zzideVar, zzidoVar);
            }

            public static zza zzq() {
                return (zza) zzf.zzbn();
            }

            public static zza zzr(zze zzeVar) {
                return (zza) zzf.zzbo(zzeVar);
            }

            public static zze zzs() {
                return zzf;
            }

            public static zzifx<zze> zzt() {
                return zzf.zzbd();
            }

            /* JADX INFO: renamed from: zzz */
            public void zzu(boolean z) {
                this.zzc |= 1;
                this.zzd = z;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
            public boolean zza() {
                return (this.zzc & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
            public boolean zzb() {
                return this.zzd;
            }

            @Override // com.google.android.gms.internal.ads.zziee
            protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
                zzifx zzidzVar;
                int iOrdinal = zziedVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzc", "zzd", "zze"});
                }
                if (iOrdinal == 3) {
                    return new zze();
                }
                if (iOrdinal == 4) {
                    return new zza(null);
                }
                if (iOrdinal == 5) {
                    return zzf;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzifx<zze> zzifxVar = zzg;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zze.class) {
                    zzidzVar = zzg;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzf);
                        zzg = zzidzVar;
                    }
                }
                return zzidzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
            public boolean zze() {
                return (this.zzc & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzf
            public int zzf() {
                return this.zze;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public interface zzf extends zzifq {
            boolean zza();

            boolean zzb();

            boolean zze();

            int zzf();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zzg extends zziee<zzg, zza> implements zzh {
            public static final int zza = 1;
            public static final int zzb = 2;
            public static final int zzc = 3;
            private static final zzg zzh;
            private static volatile zzifx<zzg> zzi;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private int zzg;

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            public final class zza extends zzidy<zzg, zza> implements zzh {
                private zza() {
                    super(zzg.zzh);
                }

                /* synthetic */ zza(byte[] bArr) {
                    this();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public boolean zza() {
                    return ((zzg) this.zza).zza();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public boolean zzb() {
                    return ((zzg) this.zza).zzb();
                }

                public zza zzc(boolean z) {
                    zzbg();
                    ((zzg) this.zza).zzw(z);
                    return this;
                }

                public zza zzd() {
                    zzbg();
                    ((zzg) this.zza).zzx();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public boolean zze() {
                    return ((zzg) this.zza).zze();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public boolean zzf() {
                    return ((zzg) this.zza).zzf();
                }

                public zza zzg(boolean z) {
                    zzbg();
                    ((zzg) this.zza).zzy(z);
                    return this;
                }

                public zza zzh() {
                    zzbg();
                    ((zzg) this.zza).zzz();
                    return this;
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public boolean zzi() {
                    return ((zzg) this.zza).zzi();
                }

                @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
                public int zzj() {
                    return ((zzg) this.zza).zzj();
                }

                public zza zzk(int i) {
                    zzbg();
                    ((zzg) this.zza).zzA(i);
                    return this;
                }

                public zza zzl() {
                    zzbg();
                    ((zzg) this.zza).zzB();
                    return this;
                }
            }

            static {
                zzg zzgVar = new zzg();
                zzh = zzgVar;
                zziee.zzbu(zzg.class, zzgVar);
            }

            private zzg() {
            }

            /* JADX INFO: renamed from: zzD */
            public void zzw(boolean z) {
                this.zzd |= 1;
                this.zze = z;
            }

            /* JADX INFO: renamed from: zzE */
            public void zzx() {
                this.zzd &= -2;
                this.zze = false;
            }

            /* JADX INFO: renamed from: zzF */
            public void zzy(boolean z) {
                this.zzd |= 2;
                this.zzf = z;
            }

            /* JADX INFO: renamed from: zzG */
            public void zzz() {
                this.zzd &= -3;
                this.zzf = false;
            }

            /* JADX INFO: renamed from: zzH */
            public void zzA(int i) {
                this.zzd |= 4;
                this.zzg = i;
            }

            /* JADX INFO: renamed from: zzI */
            public void zzB() {
                this.zzd &= -5;
                this.zzg = 0;
            }

            public static zzg zzc(ByteBuffer byteBuffer) throws zziet {
                return (zzg) zziee.zzbR(zzh, byteBuffer);
            }

            public static zzg zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
                return (zzg) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
            }

            public static zzg zzg(zzida zzidaVar) throws zziet {
                return (zzg) zziee.zzbS(zzh, zzidaVar);
            }

            public static zzg zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
                return (zzg) zziee.zzbT(zzh, zzidaVar, zzidoVar);
            }

            public static zzg zzk(byte[] bArr) throws zziet {
                return (zzg) zziee.zzbU(zzh, bArr);
            }

            public static zzg zzl(byte[] bArr, zzido zzidoVar) throws zziet {
                return (zzg) zziee.zzbV(zzh, bArr, zzidoVar);
            }

            public static zzg zzm(InputStream inputStream) throws IOException {
                return (zzg) zziee.zzbW(zzh, inputStream);
            }

            public static zzg zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zzg) zziee.zzbX(zzh, inputStream, zzidoVar);
            }

            public static zzg zzo(InputStream inputStream) throws IOException {
                return (zzg) zzca(zzh, inputStream);
            }

            public static zzg zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
                return (zzg) zzcb(zzh, inputStream, zzidoVar);
            }

            public static zzg zzq(zzide zzideVar) throws IOException {
                return (zzg) zziee.zzbY(zzh, zzideVar);
            }

            public static zzg zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
                return (zzg) zziee.zzbZ(zzh, zzideVar, zzidoVar);
            }

            public static zza zzs() {
                return (zza) zzh.zzbn();
            }

            public static zza zzt(zzg zzgVar) {
                return (zza) zzh.zzbo(zzgVar);
            }

            public static zzg zzu() {
                return zzh;
            }

            public static zzifx<zzg> zzv() {
                return zzh.zzbd();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public boolean zza() {
                return (this.zzd & 1) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public boolean zzb() {
                return this.zze;
            }

            @Override // com.google.android.gms.internal.ads.zziee
            protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
                zzifx zzidzVar;
                int iOrdinal = zziedVar.ordinal();
                if (iOrdinal == 0) {
                    return (byte) 1;
                }
                if (iOrdinal == 2) {
                    return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
                }
                if (iOrdinal == 3) {
                    return new zzg();
                }
                if (iOrdinal == 4) {
                    return new zza(null);
                }
                if (iOrdinal == 5) {
                    return zzh;
                }
                if (iOrdinal != 6) {
                    throw null;
                }
                zzifx<zzg> zzifxVar = zzi;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zzg.class) {
                    zzidzVar = zzi;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzh);
                        zzi = zzidzVar;
                    }
                }
                return zzidzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public boolean zze() {
                return (this.zzd & 2) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public boolean zzf() {
                return this.zzf;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public boolean zzi() {
                return (this.zzd & 4) != 0;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzb.zzh
            public int zzj() {
                return this.zzg;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public interface zzh extends zzifq {
            boolean zza();

            boolean zzb();

            boolean zze();

            boolean zzf();

            boolean zzi();

            int zzj();
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zziee.zzbu(zzb.class, zzbVar);
        }

        private zzb() {
        }

        private void zzD() {
            zzieq<zza> zzieqVar = this.zzb;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzb = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzE */
        public void zzw(int i, zza zzaVar) {
            zzaVar.getClass();
            zzD();
            this.zzb.set(i, zzaVar);
        }

        /* JADX INFO: renamed from: zzF */
        public void zzx(zza zzaVar) {
            zzaVar.getClass();
            zzD();
            this.zzb.add(zzaVar);
        }

        /* JADX INFO: renamed from: zzG */
        public void zzy(int i, zza zzaVar) {
            zzaVar.getClass();
            zzD();
            this.zzb.add(i, zzaVar);
        }

        /* JADX INFO: renamed from: zzH */
        public void zzz(Iterable<? extends zza> iterable) {
            zzD();
            zzicj.zzaW(iterable, this.zzb);
        }

        /* JADX INFO: renamed from: zzI */
        public void zzA() {
            this.zzb = zzbM();
        }

        /* JADX INFO: renamed from: zzJ */
        public void zzB(int i) {
            zzD();
            this.zzb.remove(i);
        }

        public static zzb zzg(ByteBuffer byteBuffer) throws zziet {
            return (zzb) zziee.zzbR(zzc, byteBuffer);
        }

        public static zzb zzh(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzb) zziee.zzbQ(zzc, byteBuffer, zzidoVar);
        }

        public static zzb zzi(zzida zzidaVar) throws zziet {
            return (zzb) zziee.zzbS(zzc, zzidaVar);
        }

        public static zzb zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzb) zziee.zzbT(zzc, zzidaVar, zzidoVar);
        }

        public static zzb zzk(byte[] bArr) throws zziet {
            return (zzb) zziee.zzbU(zzc, bArr);
        }

        public static zzb zzl(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzb) zziee.zzbV(zzc, bArr, zzidoVar);
        }

        public static zzb zzm(InputStream inputStream) throws IOException {
            return (zzb) zziee.zzbW(zzc, inputStream);
        }

        public static zzb zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzb) zziee.zzbX(zzc, inputStream, zzidoVar);
        }

        public static zzb zzo(InputStream inputStream) throws IOException {
            return (zzb) zzca(zzc, inputStream);
        }

        public static zzb zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzb) zzcb(zzc, inputStream, zzidoVar);
        }

        public static zzb zzq(zzide zzideVar) throws IOException {
            return (zzb) zziee.zzbY(zzc, zzideVar);
        }

        public static zzb zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzb) zziee.zzbZ(zzc, zzideVar, zzidoVar);
        }

        public static zzc zzs() {
            return (zzc) zzc.zzbn();
        }

        public static zzc zzt(zzb zzbVar) {
            return (zzc) zzc.zzbo(zzbVar);
        }

        public static zzb zzu() {
            return zzc;
        }

        public static zzifx<zzb> zzv() {
            return zzc.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzc
        public List<zza> zza() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzc
        public int zzb() {
            return this.zzb.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzc
        public zza zzc(int i) {
            return this.zzb.get(i);
        }

        public List<? extends InterfaceC0025zzb> zzd() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zza.class});
            }
            if (iOrdinal == 3) {
                return new zzb();
            }
            if (iOrdinal == 4) {
                return new zzc(null);
            }
            if (iOrdinal == 5) {
                return zzc;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzb> zzifxVar = zzd;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzb.class) {
                zzidzVar = zzd;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzc);
                    zzd = zzidzVar;
                }
            }
            return zzidzVar;
        }

        public InterfaceC0025zzb zze(int i) {
            return this.zzb.get(i);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzba extends zziee<zzba, zza> implements zzbb {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzba zzl;
        private static volatile zzifx<zzba> zzm;
        private int zzf;
        private int zzg = 1000;
        private zzaw zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzba, zza> implements zzbb {
            private zza() {
                super(zzba.zzl);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public boolean zza() {
                return ((zzba) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public zzq zzb() {
                return ((zzba) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzba) this.zza).zzA(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzba) this.zza).zzB();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public boolean zze() {
                return ((zzba) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public zzaw zzf() {
                return ((zzba) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzba) this.zza).zzC(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzba) this.zza).zzC(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzba) this.zza).zzD(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzba) this.zza).zzE();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public boolean zzk() {
                return ((zzba) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public int zzl() {
                return ((zzba) this.zza).zzl();
            }

            public zza zzm(int i) {
                zzbg();
                ((zzba) this.zza).zzF(i);
                return this;
            }

            public zza zzn() {
                zzbg();
                ((zzba) this.zza).zzG();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public boolean zzo() {
                return ((zzba) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public int zzp() {
                return ((zzba) this.zza).zzp();
            }

            public zza zzq(int i) {
                zzbg();
                ((zzba) this.zza).zzH(i);
                return this;
            }

            public zza zzr() {
                zzbg();
                ((zzba) this.zza).zzI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public boolean zzs() {
                return ((zzba) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
            public int zzt() {
                return ((zzba) this.zza).zzt();
            }

            public zza zzu(int i) {
                zzbg();
                ((zzba) this.zza).zzJ(i);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzba) this.zza).zzK();
                return this;
            }
        }

        static {
            zzba zzbaVar = new zzba();
            zzl = zzbaVar;
            zziee.zzbu(zzba.class, zzbaVar);
        }

        private zzba() {
        }

        /* JADX INFO: renamed from: zzM */
        public void zzA(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zzf |= 1;
        }

        /* JADX INFO: renamed from: zzN */
        public void zzB() {
            this.zzf &= -2;
            this.zzg = 1000;
        }

        /* JADX INFO: renamed from: zzO */
        public void zzC(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        /* JADX INFO: renamed from: zzP */
        public void zzD(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzh;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzh = zzawVar;
            this.zzf |= 2;
        }

        /* JADX INFO: renamed from: zzQ */
        public void zzE() {
            this.zzh = null;
            this.zzf &= -3;
        }

        /* JADX INFO: renamed from: zzR */
        public void zzF(int i) {
            this.zzf |= 4;
            this.zzi = i;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzG() {
            this.zzf &= -5;
            this.zzi = 0;
        }

        /* JADX INFO: renamed from: zzT */
        public void zzH(int i) {
            this.zzf |= 8;
            this.zzj = i;
        }

        /* JADX INFO: renamed from: zzU */
        public void zzI() {
            this.zzf &= -9;
            this.zzj = 0;
        }

        /* JADX INFO: renamed from: zzV */
        public void zzJ(int i) {
            this.zzf |= 16;
            this.zzk = i;
        }

        /* JADX INFO: renamed from: zzW */
        public void zzK() {
            this.zzf &= -17;
            this.zzk = 0;
        }

        public static zzba zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzba) zziee.zzbR(zzl, byteBuffer);
        }

        public static zzba zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzba) zziee.zzbQ(zzl, byteBuffer, zzidoVar);
        }

        public static zzba zzg(zzida zzidaVar) throws zziet {
            return (zzba) zziee.zzbS(zzl, zzidaVar);
        }

        public static zzba zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzba) zziee.zzbT(zzl, zzidaVar, zzidoVar);
        }

        public static zzba zzi(byte[] bArr) throws zziet {
            return (zzba) zziee.zzbU(zzl, bArr);
        }

        public static zzba zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzba) zziee.zzbV(zzl, bArr, zzidoVar);
        }

        public static zzba zzm(InputStream inputStream) throws IOException {
            return (zzba) zziee.zzbW(zzl, inputStream);
        }

        public static zzba zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzba) zziee.zzbX(zzl, inputStream, zzidoVar);
        }

        public static zzba zzq(InputStream inputStream) throws IOException {
            return (zzba) zzca(zzl, inputStream);
        }

        public static zzba zzr(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzba) zzcb(zzl, inputStream, zzidoVar);
        }

        public static zzba zzu(zzide zzideVar) throws IOException {
            return (zzba) zziee.zzbY(zzl, zzideVar);
        }

        public static zzba zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzba) zziee.zzbZ(zzl, zzideVar, zzidoVar);
        }

        public static zza zzw() {
            return (zza) zzl.zzbn();
        }

        public static zza zzx(zzba zzbaVar) {
            return (zza) zzl.zzbo(zzbaVar);
        }

        public static zzba zzy() {
            return zzl;
        }

        public static zzifx<zzba> zzz() {
            return zzl.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public boolean zza() {
            return (this.zzf & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzg);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzf", "zzg", zzq.zze(), "zzh", "zzi", "zzj", "zzk"});
            }
            if (iOrdinal == 3) {
                return new zzba();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzba> zzifxVar = zzm;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzba.class) {
                zzidzVar = zzm;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzl);
                    zzm = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public boolean zze() {
            return (this.zzf & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public zzaw zzf() {
            zzaw zzawVar = this.zzh;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public boolean zzk() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public int zzl() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public boolean zzo() {
            return (this.zzf & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public int zzp() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public boolean zzs() {
            return (this.zzf & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbb
        public int zzt() {
            return this.zzk;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbb extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();

        boolean zzk();

        int zzl();

        boolean zzo();

        int zzp();

        boolean zzs();

        int zzt();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzbc extends zziee<zzbc, zza> implements zzbd {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbc zzh;
        private static volatile zzifx<zzbc> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzbc, zza> implements zzbd {
            private zza() {
                super(zzbc.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public boolean zza() {
                return ((zzbc) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public zzq zzb() {
                return ((zzbc) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzbc) this.zza).zzw(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzbc) this.zza).zzx();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public boolean zze() {
                return ((zzbc) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public zzaw zzf() {
                return ((zzbc) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzbc) this.zza).zzy(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzbc) this.zza).zzy(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzbc) this.zza).zzz(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzbc) this.zza).zzA();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public boolean zzk() {
                return ((zzbc) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
            public zzap zzl() {
                return ((zzbc) this.zza).zzl();
            }

            public zza zzm(zzap zzapVar) {
                zzbg();
                ((zzbc) this.zza).zzB(zzapVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbg();
                ((zzbc) this.zza).zzB(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbg();
                ((zzbc) this.zza).zzC(zzapVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzbc) this.zza).zzD();
                return this;
            }
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzh = zzbcVar;
            zziee.zzbu(zzbc.class, zzbcVar);
        }

        private zzbc() {
        }

        /* JADX INFO: renamed from: zzF */
        public void zzw(zzq zzqVar) {
            this.zze = zzqVar.zza();
            this.zzd |= 1;
        }

        /* JADX INFO: renamed from: zzG */
        public void zzx() {
            this.zzd &= -2;
            this.zze = 1000;
        }

        /* JADX INFO: renamed from: zzH */
        public void zzy(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzI */
        public void zzz(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzf;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzJ */
        public void zzA() {
            this.zzf = null;
            this.zzd &= -3;
        }

        /* JADX INFO: renamed from: zzK */
        public void zzB(zzap zzapVar) {
            zzapVar.getClass();
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzL */
        public void zzC(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzg;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzM */
        public void zzD() {
            this.zzg = null;
            this.zzd &= -5;
        }

        public static zzbc zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzbc) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzbc zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzbc) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzbc zzg(zzida zzidaVar) throws zziet {
            return (zzbc) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzbc zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzbc) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzbc zzi(byte[] bArr) throws zziet {
            return (zzbc) zziee.zzbU(zzh, bArr);
        }

        public static zzbc zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzbc) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzbc zzm(InputStream inputStream) throws IOException {
            return (zzbc) zziee.zzbW(zzh, inputStream);
        }

        public static zzbc zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbc) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzbc zzo(InputStream inputStream) throws IOException {
            return (zzbc) zzca(zzh, inputStream);
        }

        public static zzbc zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbc) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzbc zzq(zzide zzideVar) throws IOException {
            return (zzbc) zziee.zzbY(zzh, zzideVar);
        }

        public static zzbc zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzbc) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzs() {
            return (zza) zzh.zzbn();
        }

        public static zza zzt(zzbc zzbcVar) {
            return (zza) zzh.zzbo(zzbcVar);
        }

        public static zzbc zzu() {
            return zzh;
        }

        public static zzifx<zzbc> zzv() {
            return zzh.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zze);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zze(), "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbc();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzbc> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzbc.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public boolean zze() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public zzaw zzf() {
            zzaw zzawVar = this.zzf;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public boolean zzk() {
            return (this.zzd & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbd
        public zzap zzl() {
            zzap zzapVar = this.zzg;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbd extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();

        boolean zzk();

        zzap zzl();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzbe extends zziee<zzbe, zza> implements zzbf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzbe zzn;
        private static volatile zzifx<zzbe> zzo;
        private int zzg;
        private int zzh = 1000;
        private zzaw zzi;
        private int zzj;
        private int zzk;
        private int zzl;
        private long zzm;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzbe, zza> implements zzbf {
            private zza() {
                super(zzbe.zzn);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zza() {
                return ((zzbe) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public zzq zzb() {
                return ((zzbe) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzbe) this.zza).zzC(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzbe) this.zza).zzD();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zze() {
                return ((zzbe) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public zzaw zzf() {
                return ((zzbe) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzbe) this.zza).zzE(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzbe) this.zza).zzE(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzbe) this.zza).zzF(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzbe) this.zza).zzG();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zzk() {
                return ((zzbe) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public int zzl() {
                return ((zzbe) this.zza).zzl();
            }

            public zza zzm(int i) {
                zzbg();
                ((zzbe) this.zza).zzH(i);
                return this;
            }

            public zza zzn() {
                zzbg();
                ((zzbe) this.zza).zzI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zzo() {
                return ((zzbe) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public int zzp() {
                return ((zzbe) this.zza).zzp();
            }

            public zza zzq(int i) {
                zzbg();
                ((zzbe) this.zza).zzJ(i);
                return this;
            }

            public zza zzr() {
                zzbg();
                ((zzbe) this.zza).zzK();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zzs() {
                return ((zzbe) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public int zzt() {
                return ((zzbe) this.zza).zzt();
            }

            public zza zzu(int i) {
                zzbg();
                ((zzbe) this.zza).zzL(i);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzbe) this.zza).zzM();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public boolean zzw() {
                return ((zzbe) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
            public long zzx() {
                return ((zzbe) this.zza).zzx();
            }

            public zza zzy(long j) {
                zzbg();
                ((zzbe) this.zza).zzN(j);
                return this;
            }

            public zza zzz() {
                zzbg();
                ((zzbe) this.zza).zzO();
                return this;
            }
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzn = zzbeVar;
            zziee.zzbu(zzbe.class, zzbeVar);
        }

        private zzbe() {
        }

        public static zzbe zzA() {
            return zzn;
        }

        public static zzifx<zzbe> zzB() {
            return zzn.zzbd();
        }

        /* JADX INFO: renamed from: zzQ */
        public void zzC(zzq zzqVar) {
            this.zzh = zzqVar.zza();
            this.zzg |= 1;
        }

        /* JADX INFO: renamed from: zzR */
        public void zzD() {
            this.zzg &= -2;
            this.zzh = 1000;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzE(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzi = zzawVar;
            this.zzg |= 2;
        }

        /* JADX INFO: renamed from: zzT */
        public void zzF(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzi;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzi = zzawVar;
            this.zzg |= 2;
        }

        /* JADX INFO: renamed from: zzU */
        public void zzG() {
            this.zzi = null;
            this.zzg &= -3;
        }

        /* JADX INFO: renamed from: zzV */
        public void zzH(int i) {
            this.zzg |= 4;
            this.zzj = i;
        }

        /* JADX INFO: renamed from: zzW */
        public void zzI() {
            this.zzg &= -5;
            this.zzj = 0;
        }

        /* JADX INFO: renamed from: zzX */
        public void zzJ(int i) {
            this.zzg |= 8;
            this.zzk = i;
        }

        /* JADX INFO: renamed from: zzY */
        public void zzK() {
            this.zzg &= -9;
            this.zzk = 0;
        }

        /* JADX INFO: renamed from: zzZ */
        public void zzL(int i) {
            this.zzg |= 16;
            this.zzl = i;
        }

        /* JADX INFO: renamed from: zzaa */
        public void zzM() {
            this.zzg &= -17;
            this.zzl = 0;
        }

        /* JADX INFO: renamed from: zzab */
        public void zzN(long j) {
            this.zzg |= 32;
            this.zzm = j;
        }

        /* JADX INFO: renamed from: zzac */
        public void zzO() {
            this.zzg &= -33;
            this.zzm = 0L;
        }

        public static zzbe zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzbe) zziee.zzbR(zzn, byteBuffer);
        }

        public static zzbe zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzbe) zziee.zzbQ(zzn, byteBuffer, zzidoVar);
        }

        public static zzbe zzg(zzida zzidaVar) throws zziet {
            return (zzbe) zziee.zzbS(zzn, zzidaVar);
        }

        public static zzbe zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzbe) zziee.zzbT(zzn, zzidaVar, zzidoVar);
        }

        public static zzbe zzi(byte[] bArr) throws zziet {
            return (zzbe) zziee.zzbU(zzn, bArr);
        }

        public static zzbe zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzbe) zziee.zzbV(zzn, bArr, zzidoVar);
        }

        public static zzbe zzm(InputStream inputStream) throws IOException {
            return (zzbe) zziee.zzbW(zzn, inputStream);
        }

        public static zzbe zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbe) zziee.zzbX(zzn, inputStream, zzidoVar);
        }

        public static zzbe zzq(InputStream inputStream) throws IOException {
            return (zzbe) zzca(zzn, inputStream);
        }

        public static zzbe zzr(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbe) zzcb(zzn, inputStream, zzidoVar);
        }

        public static zzbe zzu(zzide zzideVar) throws IOException {
            return (zzbe) zziee.zzbY(zzn, zzideVar);
        }

        public static zzbe zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzbe) zziee.zzbZ(zzn, zzideVar, zzidoVar);
        }

        public static zza zzy() {
            return (zza) zzn.zzbn();
        }

        public static zza zzz(zzbe zzbeVar) {
            return (zza) zzn.zzbo(zzbeVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zza() {
            return (this.zzg & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzh);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzg", "zzh", zzq.zze(), "zzi", "zzj", "zzk", "zzl", "zzm"});
            }
            if (iOrdinal == 3) {
                return new zzbe();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzn;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzbe> zzifxVar = zzo;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzbe.class) {
                zzidzVar = zzo;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzn);
                    zzo = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zze() {
            return (this.zzg & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public zzaw zzf() {
            zzaw zzawVar = this.zzi;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zzk() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public int zzl() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zzo() {
            return (this.zzg & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public int zzp() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zzs() {
            return (this.zzg & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public int zzt() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public boolean zzw() {
            return (this.zzg & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbf
        public long zzx() {
            return this.zzm;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbf extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();

        boolean zzk();

        int zzl();

        boolean zzo();

        int zzp();

        boolean zzs();

        int zzt();

        boolean zzw();

        long zzx();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzbg extends zziee<zzbg, zza> implements zzbh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzbg zzh;
        private static volatile zzifx<zzbg> zzi;
        private int zzd;
        private int zze = 1000;
        private zzaw zzf;
        private zzap zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzbg, zza> implements zzbh {
            private zza() {
                super(zzbg.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public boolean zza() {
                return ((zzbg) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public zzq zzb() {
                return ((zzbg) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzbg) this.zza).zzw(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzbg) this.zza).zzx();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public boolean zze() {
                return ((zzbg) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public zzaw zzf() {
                return ((zzbg) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzbg) this.zza).zzy(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzbg) this.zza).zzy(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzbg) this.zza).zzz(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzbg) this.zza).zzA();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public boolean zzk() {
                return ((zzbg) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
            public zzap zzl() {
                return ((zzbg) this.zza).zzl();
            }

            public zza zzm(zzap zzapVar) {
                zzbg();
                ((zzbg) this.zza).zzB(zzapVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbg();
                ((zzbg) this.zza).zzB(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbg();
                ((zzbg) this.zza).zzC(zzapVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzbg) this.zza).zzD();
                return this;
            }
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzh = zzbgVar;
            zziee.zzbu(zzbg.class, zzbgVar);
        }

        private zzbg() {
        }

        /* JADX INFO: renamed from: zzF */
        public void zzw(zzq zzqVar) {
            this.zze = zzqVar.zza();
            this.zzd |= 1;
        }

        /* JADX INFO: renamed from: zzG */
        public void zzx() {
            this.zzd &= -2;
            this.zze = 1000;
        }

        /* JADX INFO: renamed from: zzH */
        public void zzy(zzaw zzawVar) {
            zzawVar.getClass();
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzI */
        public void zzz(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zzf;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zzf = zzawVar;
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzJ */
        public void zzA() {
            this.zzf = null;
            this.zzd &= -3;
        }

        /* JADX INFO: renamed from: zzK */
        public void zzB(zzap zzapVar) {
            zzapVar.getClass();
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzL */
        public void zzC(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzg;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzg = zzapVar;
            this.zzd |= 4;
        }

        /* JADX INFO: renamed from: zzM */
        public void zzD() {
            this.zzg = null;
            this.zzd &= -5;
        }

        public static zzbg zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzbg) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzbg zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzbg) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzbg zzg(zzida zzidaVar) throws zziet {
            return (zzbg) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzbg zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzbg) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzbg zzi(byte[] bArr) throws zziet {
            return (zzbg) zziee.zzbU(zzh, bArr);
        }

        public static zzbg zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzbg) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzbg zzm(InputStream inputStream) throws IOException {
            return (zzbg) zziee.zzbW(zzh, inputStream);
        }

        public static zzbg zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbg) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzbg zzo(InputStream inputStream) throws IOException {
            return (zzbg) zzca(zzh, inputStream);
        }

        public static zzbg zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbg) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzbg zzq(zzide zzideVar) throws IOException {
            return (zzbg) zziee.zzbY(zzh, zzideVar);
        }

        public static zzbg zzr(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzbg) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzs() {
            return (zza) zzh.zzbn();
        }

        public static zza zzt(zzbg zzbgVar) {
            return (zza) zzh.zzbo(zzbgVar);
        }

        public static zzbg zzu() {
            return zzh;
        }

        public static zzifx<zzbg> zzv() {
            return zzh.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zze);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzq.zze(), "zzf", "zzg"});
            }
            if (iOrdinal == 3) {
                return new zzbg();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzbg> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzbg.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public boolean zze() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public zzaw zzf() {
            zzaw zzawVar = this.zzf;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public boolean zzk() {
            return (this.zzd & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbh
        public zzap zzl() {
            zzap zzapVar = this.zzg;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbh extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();

        boolean zzk();

        zzap zzl();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbi extends zzifq {
        boolean zzE();

        zzbc zzF();

        boolean zzK();

        zzay zzL();

        boolean zzQ();

        int zzR();

        boolean zzU();

        int zzV();

        boolean zzY();

        zzap zzZ();

        boolean zza();

        boolean zzae();

        int zzaf();

        boolean zzai();

        int zzaj();

        boolean zzam();

        int zzan();

        boolean zzaq();

        int zzar();

        boolean zzau();

        int zzav();

        boolean zzay();

        long zzaz();

        zzba zzb();

        boolean zzg();

        zzbe zzh();

        boolean zzm();

        zzbg zzn();

        boolean zzs();

        zzbj zzt();

        boolean zzy();

        zzau zzz();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzbj extends zziee<zzbj, zza> implements zzbk {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbj zzf;
        private static volatile zzifx<zzbj> zzg;
        private int zzc;
        private int zzd = 1000;
        private zzaw zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzbj, zza> implements zzbk {
            private zza() {
                super(zzbj.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
            public boolean zza() {
                return ((zzbj) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
            public zzq zzb() {
                return ((zzbj) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzbj) this.zza).zzu(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzbj) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
            public boolean zze() {
                return ((zzbj) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
            public zzaw zzf() {
                return ((zzbj) this.zza).zzf();
            }

            public zza zzg(zzaw zzawVar) {
                zzbg();
                ((zzbj) this.zza).zzw(zzawVar);
                return this;
            }

            public zza zzh(zzaw.zza zzaVar) {
                zzbg();
                ((zzbj) this.zza).zzw(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzaw zzawVar) {
                zzbg();
                ((zzbj) this.zza).zzx(zzawVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzbj) this.zza).zzy();
                return this;
            }
        }

        static {
            zzbj zzbjVar = new zzbj();
            zzf = zzbjVar;
            zziee.zzbu(zzbj.class, zzbjVar);
        }

        private zzbj() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzu(zzq zzqVar) {
            this.zzd = zzqVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 1000;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzw(zzaw zzawVar) {
            zzawVar.getClass();
            this.zze = zzawVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzD */
        public void zzx(zzaw zzawVar) {
            zzawVar.getClass();
            zzaw zzawVar2 = this.zze;
            if (zzawVar2 != null && zzawVar2 != zzaw.zzr()) {
                zzaw.zza zzaVarZzq = zzaw.zzq(zzawVar2);
                zzaVarZzq.zzbo(zzawVar);
                zzawVar = zzaVarZzq.zzbt();
            }
            this.zze = zzawVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzE */
        public void zzy() {
            this.zze = null;
            this.zzc &= -3;
        }

        public static zzbj zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzbj) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzbj zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzbj) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzbj zzg(zzida zzidaVar) throws zziet {
            return (zzbj) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzbj zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzbj) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzbj zzi(byte[] bArr) throws zziet {
            return (zzbj) zziee.zzbU(zzf, bArr);
        }

        public static zzbj zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzbj) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzbj zzk(InputStream inputStream) throws IOException {
            return (zzbj) zziee.zzbW(zzf, inputStream);
        }

        public static zzbj zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbj) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzbj zzm(InputStream inputStream) throws IOException {
            return (zzbj) zzca(zzf, inputStream);
        }

        public static zzbj zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbj) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzbj zzo(zzide zzideVar) throws IOException {
            return (zzbj) zziee.zzbY(zzf, zzideVar);
        }

        public static zzbj zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzbj) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzbj zzbjVar) {
            return (zza) zzf.zzbo(zzbjVar);
        }

        public static zzbj zzs() {
            return zzf;
        }

        public static zzifx<zzbj> zzt() {
            return zzf.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzd);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzq.zze(), "zze"});
            }
            if (iOrdinal == 3) {
                return new zzbj();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzbj> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzbj.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbk
        public zzaw zzf() {
            zzaw zzawVar = this.zze;
            return zzawVar == null ? zzaw.zzr() : zzawVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbk extends zzifq {
        boolean zza();

        zzq zzb();

        boolean zze();

        zzaw zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzbl extends zziee<zzbl, zza> implements zzbm {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzbl zzf;
        private static volatile zzifx<zzbl> zzg;
        private int zzc;
        private boolean zzd;
        private int zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzbl, zza> implements zzbm {
            private zza() {
                super(zzbl.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
            public boolean zza() {
                return ((zzbl) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
            public boolean zzb() {
                return ((zzbl) this.zza).zzb();
            }

            public zza zzc(boolean z) {
                zzbg();
                ((zzbl) this.zza).zzu(z);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzbl) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
            public boolean zze() {
                return ((zzbl) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
            public int zzf() {
                return ((zzbl) this.zza).zzf();
            }

            public zza zzg(int i) {
                zzbg();
                ((zzbl) this.zza).zzw(i);
                return this;
            }

            public zza zzh() {
                zzbg();
                ((zzbl) this.zza).zzx();
                return this;
            }
        }

        static {
            zzbl zzblVar = new zzbl();
            zzf = zzblVar;
            zziee.zzbu(zzbl.class, zzblVar);
        }

        private zzbl() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = false;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzw(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzx() {
            this.zzc &= -3;
            this.zze = 0;
        }

        public static zzbl zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzbl) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzbl zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzbl) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzbl zzg(zzida zzidaVar) throws zziet {
            return (zzbl) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzbl zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzbl) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzbl zzi(byte[] bArr) throws zziet {
            return (zzbl) zziee.zzbU(zzf, bArr);
        }

        public static zzbl zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzbl) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzbl zzk(InputStream inputStream) throws IOException {
            return (zzbl) zziee.zzbW(zzf, inputStream);
        }

        public static zzbl zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbl) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzbl zzm(InputStream inputStream) throws IOException {
            return (zzbl) zzca(zzf, inputStream);
        }

        public static zzbl zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzbl) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzbl zzo(zzide zzideVar) throws IOException {
            return (zzbl) zziee.zzbY(zzf, zzideVar);
        }

        public static zzbl zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzbl) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzq() {
            return (zza) zzf.zzbn();
        }

        public static zza zzr(zzbl zzblVar) {
            return (zza) zzf.zzbo(zzblVar);
        }

        public static zzbl zzs() {
            return zzf;
        }

        public static zzifx<zzbl> zzt() {
            return zzf.zzbd();
        }

        /* JADX INFO: renamed from: zzz */
        public void zzu(boolean z) {
            this.zzc |= 1;
            this.zzd = z;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
        public boolean zzb() {
            return this.zzd;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            }
            if (iOrdinal == 3) {
                return new zzbl();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzbl> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzbl.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzbm
        public int zzf() {
            return this.zze;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzbm extends zzifq {
        boolean zza();

        boolean zzb();

        boolean zze();

        int zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzc extends zzifq {
        List<zzb.zza> zza();

        int zzb();

        zzb.zza zzc(int i);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzd extends zziee<zzd, zzb> implements zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzd zzf;
        private static volatile zzifx<zzd> zzg;
        private int zzc;
        private int zzd;
        private zzal zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zza implements zziei {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            public static final int zzl = 0;
            public static final int zzm = 1;
            public static final int zzn = 2;
            public static final int zzo = 3;
            public static final int zzp = 4;
            public static final int zzq = 5;
            public static final int zzr = 6;
            public static final int zzs = 7;
            public static final int zzt = 8;
            public static final int zzu = 9;
            public static final int zzv = 10;
            private static final zziej<zza> zzw = new zziej<zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzd.zza.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zza zzb(int i) {
                    return zza.zzc(i);
                }
            };
            private final int zzx;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzd$zza$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zza> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zza zzb(int i) {
                    return zza.zzc(i);
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzd$zza$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class C0026zza implements zziek {
                static final zziek zza = new C0026zza();

                private C0026zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zza.zzc(i) != null;
                }
            }

            zza(int i) {
                this.zzx = i;
            }

            public static zza zzc(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zziej<zza> zzd() {
                return zzw;
            }

            public static zziek zze() {
                return C0026zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzx);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzx;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zzb extends zzidy<zzd, zzb> implements zze {
            private zzb() {
                super(zzd.zzf);
            }

            /* synthetic */ zzb(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zze
            public boolean zza() {
                return ((zzd) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zze
            public zza zzb() {
                return ((zzd) this.zza).zzb();
            }

            public zzb zzc(zza zzaVar) {
                zzbg();
                ((zzd) this.zza).zzu(zzaVar);
                return this;
            }

            public zzb zzd() {
                zzbg();
                ((zzd) this.zza).zzv();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zze
            public boolean zze() {
                return ((zzd) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zze
            public zzal zzf() {
                return ((zzd) this.zza).zzf();
            }

            public zzb zzg(zzal zzalVar) {
                zzbg();
                ((zzd) this.zza).zzw(zzalVar);
                return this;
            }

            public zzb zzh(zzal.zza zzaVar) {
                zzbg();
                ((zzd) this.zza).zzw(zzaVar.zzbu());
                return this;
            }

            public zzb zzi(zzal zzalVar) {
                zzbg();
                ((zzd) this.zza).zzx(zzalVar);
                return this;
            }

            public zzb zzj() {
                zzbg();
                ((zzd) this.zza).zzy();
                return this;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzf = zzdVar;
            zziee.zzbu(zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: renamed from: zzA */
        public void zzu(zza zzaVar) {
            this.zzd = zzaVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: renamed from: zzB */
        public void zzv() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        /* JADX INFO: renamed from: zzC */
        public void zzw(zzal zzalVar) {
            zzalVar.getClass();
            this.zze = zzalVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzD */
        public void zzx(zzal zzalVar) {
            zzalVar.getClass();
            zzal zzalVar2 = this.zze;
            if (zzalVar2 != null && zzalVar2 != zzal.zzs()) {
                zzal.zza zzaVarZzr = zzal.zzr(zzalVar2);
                zzaVarZzr.zzbo(zzalVar);
                zzalVar = zzaVarZzr.zzbt();
            }
            this.zze = zzalVar;
            this.zzc |= 2;
        }

        /* JADX INFO: renamed from: zzE */
        public void zzy() {
            this.zze = null;
            this.zzc &= -3;
        }

        public static zzd zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzd) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzd zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzd) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzd zzg(zzida zzidaVar) throws zziet {
            return (zzd) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzd zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzd) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzd zzi(byte[] bArr) throws zziet {
            return (zzd) zziee.zzbU(zzf, bArr);
        }

        public static zzd zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzd) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzd zzk(InputStream inputStream) throws IOException {
            return (zzd) zziee.zzbW(zzf, inputStream);
        }

        public static zzd zzl(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzd) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzd zzm(InputStream inputStream) throws IOException {
            return (zzd) zzca(zzf, inputStream);
        }

        public static zzd zzn(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzd) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzd zzo(zzide zzideVar) throws IOException {
            return (zzd) zziee.zzbY(zzf, zzideVar);
        }

        public static zzd zzp(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzd) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zzb zzq() {
            return (zzb) zzf.zzbn();
        }

        public static zzb zzr(zzd zzdVar) {
            return (zzb) zzf.zzbo(zzdVar);
        }

        public static zzd zzs() {
            return zzf;
        }

        public static zzifx<zzd> zzt() {
            return zzf.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zze
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zze
        public zza zzb() {
            zza zzaVarZzc = zza.zzc(this.zzd);
            return zzaVarZzc == null ? zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zza.zze(), "zze"});
            }
            if (iOrdinal == 3) {
                return new zzd();
            }
            if (iOrdinal == 4) {
                return new zzb(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzd> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzd.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zze
        public boolean zze() {
            return (this.zzc & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zze
        public zzal zzf() {
            zzal zzalVar = this.zze;
            return zzalVar == null ? zzal.zzs() : zzalVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zze extends zzifq {
        boolean zza();

        zzd.zza zzb();

        boolean zze();

        zzal zzf();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzf extends zzifq {
        boolean zzG();

        zzk zzH();

        boolean zzM();

        zzah zzN();

        boolean zzS();

        zzac zzT();

        boolean zzY();

        zzx zzZ();

        boolean zza();

        boolean zzae();

        zzz zzaf();

        List<zzat> zzak();

        int zzal();

        zzat zzam(int i);

        zza.EnumC0021zza zzb();

        boolean zze();

        zzq zzf();

        boolean zzi();

        zzg zzj();

        boolean zzo();

        zzi zzp();

        List<zzd> zzu();

        int zzv();

        zzd zzw(int i);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzg extends zziee<zzg, zza> implements zzh {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        private static final zzg zzh;
        private static volatile zzifx<zzg> zzi;
        private int zzd;
        private String zze = "";
        private zzieq<zzd> zzf = zzbM();
        private int zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzg, zza> implements zzh {
            private zza() {
                super(zzg.zzh);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public boolean zza() {
                return ((zzg) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public String zzb() {
                return ((zzg) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public zzida zzc() {
                return ((zzg) this.zza).zzc();
            }

            public zza zzd(String str) {
                zzbg();
                ((zzg) this.zza).zzB(str);
                return this;
            }

            public zza zze() {
                zzbg();
                ((zzg) this.zza).zzC();
                return this;
            }

            public zza zzf(zzida zzidaVar) {
                zzbg();
                ((zzg) this.zza).zzD(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public List<zzd> zzg() {
                return Collections.unmodifiableList(((zzg) this.zza).zzg());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public int zzh() {
                return ((zzg) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public zzd zzi(int i) {
                return ((zzg) this.zza).zzi(i);
            }

            public zza zzj(int i, zzd zzdVar) {
                zzbg();
                ((zzg) this.zza).zzE(i, zzdVar);
                return this;
            }

            public zza zzk(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zzg) this.zza).zzE(i, zzbVar.zzbu());
                return this;
            }

            public zza zzl(zzd zzdVar) {
                zzbg();
                ((zzg) this.zza).zzF(zzdVar);
                return this;
            }

            public zza zzm(int i, zzd zzdVar) {
                zzbg();
                ((zzg) this.zza).zzG(i, zzdVar);
                return this;
            }

            public zza zzn(zzd.zzb zzbVar) {
                zzbg();
                ((zzg) this.zza).zzF(zzbVar.zzbu());
                return this;
            }

            public zza zzo(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zzg) this.zza).zzG(i, zzbVar.zzbu());
                return this;
            }

            public zza zzp(Iterable<? extends zzd> iterable) {
                zzbg();
                ((zzg) this.zza).zzH(iterable);
                return this;
            }

            public zza zzq() {
                zzbg();
                ((zzg) this.zza).zzI();
                return this;
            }

            public zza zzr(int i) {
                zzbg();
                ((zzg) this.zza).zzJ(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public boolean zzs() {
                return ((zzg) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzh
            public zzq zzt() {
                return ((zzg) this.zza).zzt();
            }

            public zza zzu(zzq zzqVar) {
                zzbg();
                ((zzg) this.zza).zzK(zzqVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzg) this.zza).zzL();
                return this;
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzh = zzgVar;
            zziee.zzbu(zzg.class, zzgVar);
        }

        private zzg() {
        }

        public static zzifx<zzg> zzA() {
            return zzh.zzbd();
        }

        /* JADX INFO: renamed from: zzN */
        public void zzB(String str) {
            str.getClass();
            this.zzd |= 1;
            this.zze = str;
        }

        /* JADX INFO: renamed from: zzO */
        public void zzC() {
            this.zzd &= -2;
            this.zze = zzz().zzb();
        }

        /* JADX INFO: renamed from: zzP */
        public void zzD(zzida zzidaVar) {
            this.zze = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzd |= 1;
        }

        private void zzQ() {
            zzieq<zzd> zzieqVar = this.zzf;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzf = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzR */
        public void zzE(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzQ();
            this.zzf.set(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzS */
        public void zzF(zzd zzdVar) {
            zzdVar.getClass();
            zzQ();
            this.zzf.add(zzdVar);
        }

        /* JADX INFO: renamed from: zzT */
        public void zzG(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzQ();
            this.zzf.add(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzU */
        public void zzH(Iterable<? extends zzd> iterable) {
            zzQ();
            zzicj.zzaW(iterable, this.zzf);
        }

        /* JADX INFO: renamed from: zzV */
        public void zzI() {
            this.zzf = zzbM();
        }

        /* JADX INFO: renamed from: zzW */
        public void zzJ(int i) {
            zzQ();
            this.zzf.remove(i);
        }

        /* JADX INFO: renamed from: zzX */
        public void zzK(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zzd |= 2;
        }

        /* JADX INFO: renamed from: zzY */
        public void zzL() {
            this.zzd &= -3;
            this.zzg = 0;
        }

        public static zzg zzj(ByteBuffer byteBuffer) throws zziet {
            return (zzg) zziee.zzbR(zzh, byteBuffer);
        }

        public static zzg zzk(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzg) zziee.zzbQ(zzh, byteBuffer, zzidoVar);
        }

        public static zzg zzl(zzida zzidaVar) throws zziet {
            return (zzg) zziee.zzbS(zzh, zzidaVar);
        }

        public static zzg zzm(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzg) zziee.zzbT(zzh, zzidaVar, zzidoVar);
        }

        public static zzg zzn(byte[] bArr) throws zziet {
            return (zzg) zziee.zzbU(zzh, bArr);
        }

        public static zzg zzo(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzg) zziee.zzbV(zzh, bArr, zzidoVar);
        }

        public static zzg zzp(InputStream inputStream) throws IOException {
            return (zzg) zziee.zzbW(zzh, inputStream);
        }

        public static zzg zzq(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzg) zziee.zzbX(zzh, inputStream, zzidoVar);
        }

        public static zzg zzr(InputStream inputStream) throws IOException {
            return (zzg) zzca(zzh, inputStream);
        }

        public static zzg zzu(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzg) zzcb(zzh, inputStream, zzidoVar);
        }

        public static zzg zzv(zzide zzideVar) throws IOException {
            return (zzg) zziee.zzbY(zzh, zzideVar);
        }

        public static zzg zzw(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzg) zziee.zzbZ(zzh, zzideVar, zzidoVar);
        }

        public static zza zzx() {
            return (zza) zzh.zzbn();
        }

        public static zza zzy(zzg zzgVar) {
            return (zza) zzh.zzbo(zzgVar);
        }

        public static zzg zzz() {
            return zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public boolean zza() {
            return (this.zzd & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public zzida zzc() {
            return zzida.zzx(this.zze);
        }

        public List<? extends zze> zzd() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzd.class, "zzg", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzg();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzh;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzg> zzifxVar = zzi;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzg.class) {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            }
            return zzidzVar;
        }

        public zze zze(int i) {
            return this.zzf.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public List<zzd> zzg() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public int zzh() {
            return this.zzf.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public zzd zzi(int i) {
            return this.zzf.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public boolean zzs() {
            return (this.zzd & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzh
        public zzq zzt() {
            zzq zzqVarZzc = zzq.zzc(this.zzg);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzh extends zzifq {
        boolean zza();

        String zzb();

        zzida zzc();

        List<zzd> zzg();

        int zzh();

        zzd zzi(int i);

        boolean zzs();

        zzq zzt();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzi extends zziee<zzi, zza> implements zzj {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        private static final zzi zzl;
        private static volatile zzifx<zzi> zzm;
        private int zzf;
        private String zzg = "";
        private zzieq<zzd> zzh = zzbM();
        private int zzi = 1000;
        private int zzj = 1000;
        private int zzk = 1000;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzi, zza> implements zzj {
            private zza() {
                super(zzi.zzl);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public boolean zzA() {
                return ((zzi) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public zzq zzB() {
                return ((zzi) this.zza).zzB();
            }

            public zza zzC(zzq zzqVar) {
                zzbg();
                ((zzi) this.zza).zzS(zzqVar);
                return this;
            }

            public zza zzD() {
                zzbg();
                ((zzi) this.zza).zzT();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public boolean zza() {
                return ((zzi) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public String zzb() {
                return ((zzi) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public zzida zzc() {
                return ((zzi) this.zza).zzc();
            }

            public zza zzd(String str) {
                zzbg();
                ((zzi) this.zza).zzF(str);
                return this;
            }

            public zza zze() {
                zzbg();
                ((zzi) this.zza).zzG();
                return this;
            }

            public zza zzf(zzida zzidaVar) {
                zzbg();
                ((zzi) this.zza).zzH(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public List<zzd> zzg() {
                return Collections.unmodifiableList(((zzi) this.zza).zzg());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public int zzh() {
                return ((zzi) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public zzd zzi(int i) {
                return ((zzi) this.zza).zzi(i);
            }

            public zza zzj(int i, zzd zzdVar) {
                zzbg();
                ((zzi) this.zza).zzI(i, zzdVar);
                return this;
            }

            public zza zzk(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zzi) this.zza).zzI(i, zzbVar.zzbu());
                return this;
            }

            public zza zzl(zzd zzdVar) {
                zzbg();
                ((zzi) this.zza).zzJ(zzdVar);
                return this;
            }

            public zza zzm(int i, zzd zzdVar) {
                zzbg();
                ((zzi) this.zza).zzK(i, zzdVar);
                return this;
            }

            public zza zzn(zzd.zzb zzbVar) {
                zzbg();
                ((zzi) this.zza).zzJ(zzbVar.zzbu());
                return this;
            }

            public zza zzo(int i, zzd.zzb zzbVar) {
                zzbg();
                ((zzi) this.zza).zzK(i, zzbVar.zzbu());
                return this;
            }

            public zza zzp(Iterable<? extends zzd> iterable) {
                zzbg();
                ((zzi) this.zza).zzL(iterable);
                return this;
            }

            public zza zzq() {
                zzbg();
                ((zzi) this.zza).zzM();
                return this;
            }

            public zza zzr(int i) {
                zzbg();
                ((zzi) this.zza).zzN(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public boolean zzs() {
                return ((zzi) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public zzq zzt() {
                return ((zzi) this.zza).zzt();
            }

            public zza zzu(zzq zzqVar) {
                zzbg();
                ((zzi) this.zza).zzO(zzqVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzi) this.zza).zzP();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public boolean zzw() {
                return ((zzi) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzj
            public zzq zzx() {
                return ((zzi) this.zza).zzx();
            }

            public zza zzy(zzq zzqVar) {
                zzbg();
                ((zzi) this.zza).zzQ(zzqVar);
                return this;
            }

            public zza zzz() {
                zzbg();
                ((zzi) this.zza).zzR();
                return this;
            }
        }

        static {
            zzi zziVar = new zzi();
            zzl = zziVar;
            zziee.zzbu(zzi.class, zziVar);
        }

        private zzi() {
        }

        public static zza zzC(zzi zziVar) {
            return (zza) zzl.zzbo(zziVar);
        }

        public static zzi zzD() {
            return zzl;
        }

        public static zzifx<zzi> zzE() {
            return zzl.zzbd();
        }

        /* JADX INFO: renamed from: zzV */
        public void zzF(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzg = str;
        }

        /* JADX INFO: renamed from: zzW */
        public void zzG() {
            this.zzf &= -2;
            this.zzg = zzD().zzb();
        }

        /* JADX INFO: renamed from: zzX */
        public void zzH(zzida zzidaVar) {
            this.zzg = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzf |= 1;
        }

        private void zzY() {
            zzieq<zzd> zzieqVar = this.zzh;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzh = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzZ */
        public void zzI(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzY();
            this.zzh.set(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzaa */
        public void zzJ(zzd zzdVar) {
            zzdVar.getClass();
            zzY();
            this.zzh.add(zzdVar);
        }

        /* JADX INFO: renamed from: zzab */
        public void zzK(int i, zzd zzdVar) {
            zzdVar.getClass();
            zzY();
            this.zzh.add(i, zzdVar);
        }

        /* JADX INFO: renamed from: zzac */
        public void zzL(Iterable<? extends zzd> iterable) {
            zzY();
            zzicj.zzaW(iterable, this.zzh);
        }

        /* JADX INFO: renamed from: zzad */
        public void zzM() {
            this.zzh = zzbM();
        }

        /* JADX INFO: renamed from: zzae */
        public void zzN(int i) {
            zzY();
            this.zzh.remove(i);
        }

        /* JADX INFO: renamed from: zzaf */
        public void zzO(zzq zzqVar) {
            this.zzi = zzqVar.zza();
            this.zzf |= 2;
        }

        /* JADX INFO: renamed from: zzag */
        public void zzP() {
            this.zzf &= -3;
            this.zzi = 1000;
        }

        /* JADX INFO: renamed from: zzah */
        public void zzQ(zzq zzqVar) {
            this.zzj = zzqVar.zza();
            this.zzf |= 4;
        }

        /* JADX INFO: renamed from: zzai */
        public void zzR() {
            this.zzf &= -5;
            this.zzj = 1000;
        }

        /* JADX INFO: renamed from: zzaj */
        public void zzS(zzq zzqVar) {
            this.zzk = zzqVar.zza();
            this.zzf |= 8;
        }

        /* JADX INFO: renamed from: zzak */
        public void zzT() {
            this.zzf &= -9;
            this.zzk = 1000;
        }

        public static zzi zzj(ByteBuffer byteBuffer) throws zziet {
            return (zzi) zziee.zzbR(zzl, byteBuffer);
        }

        public static zzi zzk(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzi) zziee.zzbQ(zzl, byteBuffer, zzidoVar);
        }

        public static zzi zzl(zzida zzidaVar) throws zziet {
            return (zzi) zziee.zzbS(zzl, zzidaVar);
        }

        public static zzi zzm(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzi) zziee.zzbT(zzl, zzidaVar, zzidoVar);
        }

        public static zzi zzn(byte[] bArr) throws zziet {
            return (zzi) zziee.zzbU(zzl, bArr);
        }

        public static zzi zzo(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzi) zziee.zzbV(zzl, bArr, zzidoVar);
        }

        public static zzi zzp(InputStream inputStream) throws IOException {
            return (zzi) zziee.zzbW(zzl, inputStream);
        }

        public static zzi zzq(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzi) zziee.zzbX(zzl, inputStream, zzidoVar);
        }

        public static zzi zzr(InputStream inputStream) throws IOException {
            return (zzi) zzca(zzl, inputStream);
        }

        public static zzi zzu(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzi) zzcb(zzl, inputStream, zzidoVar);
        }

        public static zzi zzv(zzide zzideVar) throws IOException {
            return (zzi) zziee.zzbY(zzl, zzideVar);
        }

        public static zzi zzy(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzi) zziee.zzbZ(zzl, zzideVar, zzidoVar);
        }

        public static zza zzz() {
            return (zza) zzl.zzbn();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public boolean zzA() {
            return (this.zzf & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public zzq zzB() {
            zzq zzqVarZzc = zzq.zzc(this.zzk);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public boolean zza() {
            return (this.zzf & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public String zzb() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public zzida zzc() {
            return zzida.zzx(this.zzg);
        }

        public List<? extends zze> zzd() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzf", "zzg", "zzh", zzd.class, "zzi", zzq.zze(), "zzj", zzq.zze(), "zzk", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzi();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzl;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzi> zzifxVar = zzm;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzi.class) {
                zzidzVar = zzm;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzl);
                    zzm = zzidzVar;
                }
            }
            return zzidzVar;
        }

        public zze zze(int i) {
            return this.zzh.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public List<zzd> zzg() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public int zzh() {
            return this.zzh.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public zzd zzi(int i) {
            return this.zzh.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public boolean zzs() {
            return (this.zzf & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public zzq zzt() {
            zzq zzqVarZzc = zzq.zzc(this.zzi);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public boolean zzw() {
            return (this.zzf & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzj
        public zzq zzx() {
            zzq zzqVarZzc = zzq.zzc(this.zzj);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzj extends zzifq {
        boolean zzA();

        zzq zzB();

        boolean zza();

        String zzb();

        zzida zzc();

        List<zzd> zzg();

        int zzh();

        zzd zzi(int i);

        boolean zzs();

        zzq zzt();

        boolean zzw();

        zzq zzx();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzk extends zziee<zzk, zza> implements zzl {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        private static final zzk zzn;
        private static volatile zzifx<zzk> zzo;
        private int zzg;
        private int zzh;
        private zzap zzi;
        private zzap zzj;
        private zzap zzk;
        private zzieq<zzap> zzl = zzbM();
        private int zzm;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzk, zza> implements zzl {
            private zza() {
                super(zzk.zzn);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            public zza zzA(int i, zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzQ(i, zzaVar.zzbu());
                return this;
            }

            public zza zzB(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzR(zzapVar);
                return this;
            }

            public zza zzC(int i, zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzS(i, zzapVar);
                return this;
            }

            public zza zzD(zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzR(zzaVar.zzbu());
                return this;
            }

            public zza zzE(int i, zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzS(i, zzaVar.zzbu());
                return this;
            }

            public zza zzF(Iterable<? extends zzap> iterable) {
                zzbg();
                ((zzk) this.zza).zzT(iterable);
                return this;
            }

            public zza zzG() {
                zzbg();
                ((zzk) this.zza).zzU();
                return this;
            }

            public zza zzH(int i) {
                zzbg();
                ((zzk) this.zza).zzV(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public boolean zzI() {
                return ((zzk) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public int zzJ() {
                return ((zzk) this.zza).zzJ();
            }

            public zza zzK(int i) {
                zzbg();
                ((zzk) this.zza).zzW(i);
                return this;
            }

            public zza zzL() {
                zzbg();
                ((zzk) this.zza).zzX();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public boolean zza() {
                return ((zzk) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public int zzb() {
                return ((zzk) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzk) this.zza).zzD(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzk) this.zza).zzE();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public boolean zze() {
                return ((zzk) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public zzap zzf() {
                return ((zzk) this.zza).zzf();
            }

            public zza zzg(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzF(zzapVar);
                return this;
            }

            public zza zzh(zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzF(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzG(zzapVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzk) this.zza).zzH();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public boolean zzk() {
                return ((zzk) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public zzap zzl() {
                return ((zzk) this.zza).zzl();
            }

            public zza zzm(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzn(zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzK(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzL(zzapVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzk) this.zza).zzM();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public boolean zzq() {
                return ((zzk) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public zzap zzr() {
                return ((zzk) this.zza).zzr();
            }

            public zza zzs(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzN(zzapVar);
                return this;
            }

            public zza zzt(zzap.zza zzaVar) {
                zzbg();
                ((zzk) this.zza).zzN(zzaVar.zzbu());
                return this;
            }

            public zza zzu(zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzO(zzapVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzk) this.zza).zzP();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public List<zzap> zzw() {
                return Collections.unmodifiableList(((zzk) this.zza).zzw());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public int zzx() {
                return ((zzk) this.zza).zzx();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzl
            public zzap zzy(int i) {
                return ((zzk) this.zza).zzy(i);
            }

            public zza zzz(int i, zzap zzapVar) {
                zzbg();
                ((zzk) this.zza).zzQ(i, zzapVar);
                return this;
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzn = zzkVar;
            zziee.zzbu(zzk.class, zzkVar);
        }

        private zzk() {
        }

        public static zza zzA(zzk zzkVar) {
            return (zza) zzn.zzbo(zzkVar);
        }

        public static zzk zzB() {
            return zzn;
        }

        public static zzifx<zzk> zzC() {
            return zzn.zzbd();
        }

        /* JADX INFO: renamed from: zzZ */
        public void zzD(int i) {
            this.zzg |= 1;
            this.zzh = i;
        }

        /* JADX INFO: renamed from: zzaa */
        public void zzE() {
            this.zzg &= -2;
            this.zzh = 0;
        }

        /* JADX INFO: renamed from: zzab */
        public void zzF(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zzg |= 2;
        }

        /* JADX INFO: renamed from: zzac */
        public void zzG(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzi = zzapVar;
            this.zzg |= 2;
        }

        /* JADX INFO: renamed from: zzad */
        public void zzH() {
            this.zzi = null;
            this.zzg &= -3;
        }

        /* JADX INFO: renamed from: zzae */
        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            this.zzj = zzapVar;
            this.zzg |= 4;
        }

        /* JADX INFO: renamed from: zzaf */
        public void zzL(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzj;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzj = zzapVar;
            this.zzg |= 4;
        }

        /* JADX INFO: renamed from: zzag */
        public void zzM() {
            this.zzj = null;
            this.zzg &= -5;
        }

        /* JADX INFO: renamed from: zzah */
        public void zzN(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzg |= 8;
        }

        /* JADX INFO: renamed from: zzai */
        public void zzO(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzk = zzapVar;
            this.zzg |= 8;
        }

        /* JADX INFO: renamed from: zzaj */
        public void zzP() {
            this.zzk = null;
            this.zzg &= -9;
        }

        private void zzak() {
            zzieq<zzap> zzieqVar = this.zzl;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzl = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzal */
        public void zzQ(int i, zzap zzapVar) {
            zzapVar.getClass();
            zzak();
            this.zzl.set(i, zzapVar);
        }

        /* JADX INFO: renamed from: zzam */
        public void zzR(zzap zzapVar) {
            zzapVar.getClass();
            zzak();
            this.zzl.add(zzapVar);
        }

        /* JADX INFO: renamed from: zzan */
        public void zzS(int i, zzap zzapVar) {
            zzapVar.getClass();
            zzak();
            this.zzl.add(i, zzapVar);
        }

        /* JADX INFO: renamed from: zzao */
        public void zzT(Iterable<? extends zzap> iterable) {
            zzak();
            zzicj.zzaW(iterable, this.zzl);
        }

        /* JADX INFO: renamed from: zzap */
        public void zzU() {
            this.zzl = zzbM();
        }

        /* JADX INFO: renamed from: zzaq */
        public void zzV(int i) {
            zzak();
            this.zzl.remove(i);
        }

        /* JADX INFO: renamed from: zzar */
        public void zzW(int i) {
            this.zzg |= 16;
            this.zzm = i;
        }

        /* JADX INFO: renamed from: zzas */
        public void zzX() {
            this.zzg &= -17;
            this.zzm = 0;
        }

        public static zzk zzg(ByteBuffer byteBuffer) throws zziet {
            return (zzk) zziee.zzbR(zzn, byteBuffer);
        }

        public static zzk zzh(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzk) zziee.zzbQ(zzn, byteBuffer, zzidoVar);
        }

        public static zzk zzi(zzida zzidaVar) throws zziet {
            return (zzk) zziee.zzbS(zzn, zzidaVar);
        }

        public static zzk zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzk) zziee.zzbT(zzn, zzidaVar, zzidoVar);
        }

        public static zzk zzm(byte[] bArr) throws zziet {
            return (zzk) zziee.zzbU(zzn, bArr);
        }

        public static zzk zzn(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzk) zziee.zzbV(zzn, bArr, zzidoVar);
        }

        public static zzk zzo(InputStream inputStream) throws IOException {
            return (zzk) zziee.zzbW(zzn, inputStream);
        }

        public static zzk zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzk) zziee.zzbX(zzn, inputStream, zzidoVar);
        }

        public static zzk zzs(InputStream inputStream) throws IOException {
            return (zzk) zzca(zzn, inputStream);
        }

        public static zzk zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzk) zzcb(zzn, inputStream, zzidoVar);
        }

        public static zzk zzu(zzide zzideVar) throws IOException {
            return (zzk) zziee.zzbY(zzn, zzideVar);
        }

        public static zzk zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzk) zziee.zzbZ(zzn, zzideVar, zzidoVar);
        }

        public static zza zzz() {
            return (zza) zzn.zzbn();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public boolean zzI() {
            return (this.zzg & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public int zzJ() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public boolean zza() {
            return (this.zzg & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public int zzb() {
            return this.zzh;
        }

        public List<? extends zzaq> zzc() {
            return this.zzl;
        }

        public zzaq zzd(int i) {
            return this.zzl.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzap.class, "zzm"});
            }
            if (iOrdinal == 3) {
                return new zzk();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzn;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzk> zzifxVar = zzo;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzk.class) {
                zzidzVar = zzo;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzn);
                    zzo = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public boolean zze() {
            return (this.zzg & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public zzap zzf() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public boolean zzk() {
            return (this.zzg & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public zzap zzl() {
            zzap zzapVar = this.zzj;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public boolean zzq() {
            return (this.zzg & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public zzap zzr() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public List<zzap> zzw() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public int zzx() {
            return this.zzl.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzl
        public zzap zzy(int i) {
            return this.zzl.get(i);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzl extends zzifq {
        boolean zzI();

        int zzJ();

        boolean zza();

        int zzb();

        boolean zze();

        zzap zzf();

        boolean zzk();

        zzap zzl();

        boolean zzq();

        zzap zzr();

        List<zzap> zzw();

        int zzx();

        zzap zzy(int i);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzm extends zziee<zzm, zza> implements zzn {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 8;
        private static final zzm zzv;
        private static volatile zzifx<zzm> zzw;
        private int zzi;
        private zzap zzk;
        private int zzl;
        private zzar zzm;
        private int zzn;
        private String zzj = "";
        private int zzo = 1000;
        private int zzp = 1000;
        private int zzu = 1000;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzm, zza> implements zzn {
            private zza() {
                super(zzm.zzv);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzA() {
                return ((zzm) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzq zzB() {
                return ((zzm) this.zza).zzB();
            }

            public zza zzC(zzq zzqVar) {
                zzbg();
                ((zzm) this.zza).zzV(zzqVar);
                return this;
            }

            public zza zzD() {
                zzbg();
                ((zzm) this.zza).zzW();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzE() {
                return ((zzm) this.zza).zzE();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzq zzF() {
                return ((zzm) this.zza).zzF();
            }

            public zza zzG(zzq zzqVar) {
                zzbg();
                ((zzm) this.zza).zzX(zzqVar);
                return this;
            }

            public zza zzH() {
                zzbg();
                ((zzm) this.zza).zzY();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzI() {
                return ((zzm) this.zza).zzI();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzq zzJ() {
                return ((zzm) this.zza).zzJ();
            }

            public zza zzK(zzq zzqVar) {
                zzbg();
                ((zzm) this.zza).zzZ(zzqVar);
                return this;
            }

            public zza zzL() {
                zzbg();
                ((zzm) this.zza).zzaa();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zza() {
                return ((zzm) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public String zzb() {
                return ((zzm) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzida zzc() {
                return ((zzm) this.zza).zzc();
            }

            public zza zzd(String str) {
                zzbg();
                ((zzm) this.zza).zzG(str);
                return this;
            }

            public zza zze() {
                zzbg();
                ((zzm) this.zza).zzH();
                return this;
            }

            public zza zzf(zzida zzidaVar) {
                zzbg();
                ((zzm) this.zza).zzK(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzg() {
                return ((zzm) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzap zzh() {
                return ((zzm) this.zza).zzh();
            }

            public zza zzi(zzap zzapVar) {
                zzbg();
                ((zzm) this.zza).zzL(zzapVar);
                return this;
            }

            public zza zzj(zzap.zza zzaVar) {
                zzbg();
                ((zzm) this.zza).zzL(zzaVar.zzbu());
                return this;
            }

            public zza zzk(zzap zzapVar) {
                zzbg();
                ((zzm) this.zza).zzM(zzapVar);
                return this;
            }

            public zza zzl() {
                zzbg();
                ((zzm) this.zza).zzN();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzm() {
                return ((zzm) this.zza).zzm();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public int zzn() {
                return ((zzm) this.zza).zzn();
            }

            public zza zzo(int i) {
                zzbg();
                ((zzm) this.zza).zzO(i);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzm) this.zza).zzP();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzq() {
                return ((zzm) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public zzar zzr() {
                return ((zzm) this.zza).zzr();
            }

            public zza zzs(zzar zzarVar) {
                zzbg();
                ((zzm) this.zza).zzQ(zzarVar);
                return this;
            }

            public zza zzt(zzar.zza zzaVar) {
                zzbg();
                ((zzm) this.zza).zzQ(zzaVar.zzbu());
                return this;
            }

            public zza zzu(zzar zzarVar) {
                zzbg();
                ((zzm) this.zza).zzR(zzarVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzm) this.zza).zzS();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public boolean zzw() {
                return ((zzm) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzn
            public int zzx() {
                return ((zzm) this.zza).zzx();
            }

            public zza zzy(int i) {
                zzbg();
                ((zzm) this.zza).zzT(i);
                return this;
            }

            public zza zzz() {
                zzbg();
                ((zzm) this.zza).zzU();
                return this;
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzv = zzmVar;
            zziee.zzbu(zzm.class, zzmVar);
        }

        private zzm() {
        }

        public static zzm zzC() {
            return zzv;
        }

        public static zzifx<zzm> zzD() {
            return zzv.zzbd();
        }

        /* JADX INFO: renamed from: zzac */
        public void zzG(String str) {
            str.getClass();
            this.zzi |= 1;
            this.zzj = str;
        }

        /* JADX INFO: renamed from: zzad */
        public void zzH() {
            this.zzi &= -2;
            this.zzj = zzC().zzb();
        }

        /* JADX INFO: renamed from: zzae */
        public void zzK(zzida zzidaVar) {
            this.zzj = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzi |= 1;
        }

        /* JADX INFO: renamed from: zzaf */
        public void zzL(zzap zzapVar) {
            zzapVar.getClass();
            this.zzk = zzapVar;
            this.zzi |= 2;
        }

        /* JADX INFO: renamed from: zzag */
        public void zzM(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzk;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzk = zzapVar;
            this.zzi |= 2;
        }

        /* JADX INFO: renamed from: zzah */
        public void zzN() {
            this.zzk = null;
            this.zzi &= -3;
        }

        /* JADX INFO: renamed from: zzai */
        public void zzO(int i) {
            this.zzi |= 4;
            this.zzl = i;
        }

        /* JADX INFO: renamed from: zzaj */
        public void zzP() {
            this.zzi &= -5;
            this.zzl = 0;
        }

        /* JADX INFO: renamed from: zzak */
        public void zzQ(zzar zzarVar) {
            zzarVar.getClass();
            this.zzm = zzarVar;
            this.zzi |= 8;
        }

        /* JADX INFO: renamed from: zzal */
        public void zzR(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzm;
            if (zzarVar2 != null && zzarVar2 != zzar.zzu()) {
                zzar.zza zzaVarZzt = zzar.zzt(zzarVar2);
                zzaVarZzt.zzbo(zzarVar);
                zzarVar = zzaVarZzt.zzbt();
            }
            this.zzm = zzarVar;
            this.zzi |= 8;
        }

        /* JADX INFO: renamed from: zzam */
        public void zzS() {
            this.zzm = null;
            this.zzi &= -9;
        }

        /* JADX INFO: renamed from: zzan */
        public void zzT(int i) {
            this.zzi |= 16;
            this.zzn = i;
        }

        /* JADX INFO: renamed from: zzao */
        public void zzU() {
            this.zzi &= -17;
            this.zzn = 0;
        }

        /* JADX INFO: renamed from: zzap */
        public void zzV(zzq zzqVar) {
            this.zzo = zzqVar.zza();
            this.zzi |= 32;
        }

        /* JADX INFO: renamed from: zzaq */
        public void zzW() {
            this.zzi &= -33;
            this.zzo = 1000;
        }

        /* JADX INFO: renamed from: zzar */
        public void zzX(zzq zzqVar) {
            this.zzp = zzqVar.zza();
            this.zzi |= 64;
        }

        /* JADX INFO: renamed from: zzas */
        public void zzY() {
            this.zzi &= -65;
            this.zzp = 1000;
        }

        /* JADX INFO: renamed from: zzat */
        public void zzZ(zzq zzqVar) {
            this.zzu = zzqVar.zza();
            this.zzi |= 128;
        }

        /* JADX INFO: renamed from: zzau */
        public void zzaa() {
            this.zzi &= -129;
            this.zzu = 1000;
        }

        public static zzm zzd(ByteBuffer byteBuffer) throws zziet {
            return (zzm) zziee.zzbR(zzv, byteBuffer);
        }

        public static zzm zze(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzm) zziee.zzbQ(zzv, byteBuffer, zzidoVar);
        }

        public static zzm zzi(zzida zzidaVar) throws zziet {
            return (zzm) zziee.zzbS(zzv, zzidaVar);
        }

        public static zzm zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzm) zziee.zzbT(zzv, zzidaVar, zzidoVar);
        }

        public static zzm zzk(byte[] bArr) throws zziet {
            return (zzm) zziee.zzbU(zzv, bArr);
        }

        public static zzm zzl(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzm) zziee.zzbV(zzv, bArr, zzidoVar);
        }

        public static zzm zzo(InputStream inputStream) throws IOException {
            return (zzm) zziee.zzbW(zzv, inputStream);
        }

        public static zzm zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzm) zziee.zzbX(zzv, inputStream, zzidoVar);
        }

        public static zzm zzs(InputStream inputStream) throws IOException {
            return (zzm) zzca(zzv, inputStream);
        }

        public static zzm zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzm) zzcb(zzv, inputStream, zzidoVar);
        }

        public static zzm zzu(zzide zzideVar) throws IOException {
            return (zzm) zziee.zzbY(zzv, zzideVar);
        }

        public static zzm zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzm) zziee.zzbZ(zzv, zzideVar, zzidoVar);
        }

        public static zza zzy() {
            return (zza) zzv.zzbn();
        }

        public static zza zzz(zzm zzmVar) {
            return (zza) zzv.zzbo(zzmVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzA() {
            return (this.zzi & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzq zzB() {
            zzq zzqVarZzc = zzq.zzc(this.zzo);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzE() {
            return (this.zzi & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzq zzF() {
            zzq zzqVarZzc = zzq.zzc(this.zzp);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzI() {
            return (this.zzi & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzq zzJ() {
            zzq zzqVarZzc = zzq.zzc(this.zzu);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zza() {
            return (this.zzi & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public String zzb() {
            return this.zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzida zzc() {
            return zzida.zzx(this.zzj);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzq.zze(), "zzp", zzq.zze(), "zzu", zzq.zze()});
            }
            if (iOrdinal == 3) {
                return new zzm();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzv;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzm> zzifxVar = zzw;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzm.class) {
                zzidzVar = zzw;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzv);
                    zzw = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzg() {
            return (this.zzi & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzap zzh() {
            zzap zzapVar = this.zzk;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzm() {
            return (this.zzi & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public int zzn() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzq() {
            return (this.zzi & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public zzar zzr() {
            zzar zzarVar = this.zzm;
            return zzarVar == null ? zzar.zzu() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public boolean zzw() {
            return (this.zzi & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzn
        public int zzx() {
            return this.zzn;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzn extends zzifq {
        boolean zzA();

        zzq zzB();

        boolean zzE();

        zzq zzF();

        boolean zzI();

        zzq zzJ();

        boolean zza();

        String zzb();

        zzida zzc();

        boolean zzg();

        zzap zzh();

        boolean zzm();

        int zzn();

        boolean zzq();

        zzar zzr();

        boolean zzw();

        int zzx();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzo extends zziee<zzo, zza> implements zzp {
        public static final int zza = 5;
        public static final int zzb = 6;
        public static final int zzc = 7;
        public static final int zzd = 8;
        private static final zzo zzj;
        private static volatile zzifx<zzo> zzk;
        private int zze;
        private int zzf;
        private zzar zzg;
        private String zzh = "";
        private String zzi = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzo, zza> implements zzp {
            private zza() {
                super(zzo.zzj);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public boolean zza() {
                return ((zzo) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public zzb zzb() {
                return ((zzo) this.zza).zzb();
            }

            public zza zzc(zzb zzbVar) {
                zzbg();
                ((zzo) this.zza).zzA(zzbVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzo) this.zza).zzB();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public boolean zze() {
                return ((zzo) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public zzar zzf() {
                return ((zzo) this.zza).zzf();
            }

            public zza zzg(zzar zzarVar) {
                zzbg();
                ((zzo) this.zza).zzC(zzarVar);
                return this;
            }

            public zza zzh(zzar.zza zzaVar) {
                zzbg();
                ((zzo) this.zza).zzC(zzaVar.zzbu());
                return this;
            }

            public zza zzi(zzar zzarVar) {
                zzbg();
                ((zzo) this.zza).zzD(zzarVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzo) this.zza).zzE();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public boolean zzk() {
                return ((zzo) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public String zzl() {
                return ((zzo) this.zza).zzl();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public zzida zzm() {
                return ((zzo) this.zza).zzm();
            }

            public zza zzn(String str) {
                zzbg();
                ((zzo) this.zza).zzF(str);
                return this;
            }

            public zza zzo() {
                zzbg();
                ((zzo) this.zza).zzG();
                return this;
            }

            public zza zzp(zzida zzidaVar) {
                zzbg();
                ((zzo) this.zza).zzH(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public boolean zzq() {
                return ((zzo) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public String zzr() {
                return ((zzo) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzp
            public zzida zzs() {
                return ((zzo) this.zza).zzs();
            }

            public zza zzt(String str) {
                zzbg();
                ((zzo) this.zza).zzI(str);
                return this;
            }

            public zza zzu() {
                zzbg();
                ((zzo) this.zza).zzJ();
                return this;
            }

            public zza zzv(zzida zzidaVar) {
                zzbg();
                ((zzo) this.zza).zzK(zzidaVar);
                return this;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public enum zzb implements zziei {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);

            public static final int zzd = 0;
            public static final int zze = 1;
            public static final int zzf = 2;
            private static final zziej<zzb> zzg = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzo.zzb.1
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            };
            private final int zzh;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzo$zzb$1 */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            class AnonymousClass1 implements zziej<zzb> {
                AnonymousClass1() {
                }

                /* JADX INFO: renamed from: zza */
                public zzb zzb(int i) {
                    return zzb.zzc(i);
                }
            }

            /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
            final class zza implements zziek {
                static final zziek zza = new zza();

                private zza() {
                }

                @Override // com.google.android.gms.internal.ads.zziek
                public boolean zza(int i) {
                    return zzb.zzc(i) != null;
                }
            }

            zzb(int i) {
                this.zzh = i;
            }

            public static zzb zzc(int i) {
                if (i == 0) {
                    return PLATFORM_UNSPECIFIED;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i != 2) {
                    return null;
                }
                return ANDROID;
            }

            public static zziej<zzb> zzd() {
                return zzg;
            }

            public static zziek zze() {
                return zza.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return Integer.toString(this.zzh);
            }

            @Override // com.google.android.gms.internal.ads.zziei
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzj = zzoVar;
            zziee.zzbu(zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: renamed from: zzM */
        public void zzA(zzb zzbVar) {
            this.zzf = zzbVar.zza();
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzN */
        public void zzB() {
            this.zze &= -2;
            this.zzf = 0;
        }

        /* JADX INFO: renamed from: zzO */
        public void zzC(zzar zzarVar) {
            zzarVar.getClass();
            this.zzg = zzarVar;
            this.zze |= 2;
        }

        /* JADX INFO: renamed from: zzP */
        public void zzD(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzg;
            if (zzarVar2 != null && zzarVar2 != zzar.zzu()) {
                zzar.zza zzaVarZzt = zzar.zzt(zzarVar2);
                zzaVarZzt.zzbo(zzarVar);
                zzarVar = zzaVarZzt.zzbt();
            }
            this.zzg = zzarVar;
            this.zze |= 2;
        }

        /* JADX INFO: renamed from: zzQ */
        public void zzE() {
            this.zzg = null;
            this.zze &= -3;
        }

        /* JADX INFO: renamed from: zzR */
        public void zzF(String str) {
            str.getClass();
            this.zze |= 4;
            this.zzh = str;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzG() {
            this.zze &= -5;
            this.zzh = zzy().zzl();
        }

        /* JADX INFO: renamed from: zzT */
        public void zzH(zzida zzidaVar) {
            this.zzh = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzU */
        public void zzI(String str) {
            str.getClass();
            this.zze |= 8;
            this.zzi = str;
        }

        /* JADX INFO: renamed from: zzV */
        public void zzJ() {
            this.zze &= -9;
            this.zzi = zzy().zzr();
        }

        /* JADX INFO: renamed from: zzW */
        public void zzK(zzida zzidaVar) {
            this.zzi = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zze |= 8;
        }

        public static zzo zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzo) zziee.zzbR(zzj, byteBuffer);
        }

        public static zzo zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzo) zziee.zzbQ(zzj, byteBuffer, zzidoVar);
        }

        public static zzo zzg(zzida zzidaVar) throws zziet {
            return (zzo) zziee.zzbS(zzj, zzidaVar);
        }

        public static zzo zzh(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzo) zziee.zzbT(zzj, zzidaVar, zzidoVar);
        }

        public static zzo zzi(byte[] bArr) throws zziet {
            return (zzo) zziee.zzbU(zzj, bArr);
        }

        public static zzo zzj(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzo) zziee.zzbV(zzj, bArr, zzidoVar);
        }

        public static zzo zzn(InputStream inputStream) throws IOException {
            return (zzo) zziee.zzbW(zzj, inputStream);
        }

        public static zzo zzo(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzo) zziee.zzbX(zzj, inputStream, zzidoVar);
        }

        public static zzo zzp(InputStream inputStream) throws IOException {
            return (zzo) zzca(zzj, inputStream);
        }

        public static zzo zzt(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzo) zzcb(zzj, inputStream, zzidoVar);
        }

        public static zzo zzu(zzide zzideVar) throws IOException {
            return (zzo) zziee.zzbY(zzj, zzideVar);
        }

        public static zzo zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzo) zziee.zzbZ(zzj, zzideVar, zzidoVar);
        }

        public static zza zzw() {
            return (zza) zzj.zzbn();
        }

        public static zza zzx(zzo zzoVar) {
            return (zza) zzj.zzbo(zzoVar);
        }

        public static zzo zzy() {
            return zzj;
        }

        public static zzifx<zzo> zzz() {
            return zzj.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public boolean zza() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public zzb zzb() {
            zzb zzbVarZzc = zzb.zzc(this.zzf);
            return zzbVarZzc == null ? zzb.PLATFORM_UNSPECIFIED : zzbVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzj, "\u0004\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zze", "zzf", zzb.zze(), "zzg", "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzo();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzo> zzifxVar = zzk;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzo.class) {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public boolean zze() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public zzar zzf() {
            zzar zzarVar = this.zzg;
            return zzarVar == null ? zzar.zzu() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public boolean zzk() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public String zzl() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public zzida zzm() {
            return zzida.zzx(this.zzh);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public boolean zzq() {
            return (this.zze & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public String zzr() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzp
        public zzida zzs() {
            return zzida.zzx(this.zzi);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzp extends zzifq {
        boolean zza();

        zzo.zzb zzb();

        boolean zze();

        zzar zzf();

        boolean zzk();

        String zzl();

        zzida zzm();

        boolean zzq();

        String zzr();

        zzida zzs();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public enum zzq implements zziei {
        ENUM_FALSE(0),
        ENUM_TRUE(1),
        ENUM_UNKNOWN(1000);

        public static final int zzd = 0;
        public static final int zze = 1;
        public static final int zzf = 1000;
        private static final zziej<zzq> zzg = new zziej<zzq>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzq.1
            AnonymousClass1() {
            }

            /* JADX INFO: renamed from: zza */
            public zzq zzb(int i) {
                return zzq.zzc(i);
            }
        };
        private final int zzh;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzq$1 */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        class AnonymousClass1 implements zziej<zzq> {
            AnonymousClass1() {
            }

            /* JADX INFO: renamed from: zza */
            public zzq zzb(int i) {
                return zzq.zzc(i);
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        final class zza implements zziek {
            static final zziek zza = new zza();

            private zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zzq.zzc(i) != null;
            }
        }

        zzq(int i) {
            this.zzh = i;
        }

        public static zzq zzc(int i) {
            if (i == 0) {
                return ENUM_FALSE;
            }
            if (i == 1) {
                return ENUM_TRUE;
            }
            if (i != 1000) {
                return null;
            }
            return ENUM_UNKNOWN;
        }

        public static zziej<zzq> zzd() {
            return zzg;
        }

        public static zziek zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzh);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzh;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzr extends zziee<zzr, zza> implements zzs {
        private static final zzr zzB;
        private static volatile zzifx<zzr> zzC = null;
        public static final int zza = 7;
        public static final int zzb = 8;
        public static final int zzc = 9;
        public static final int zzd = 10;
        public static final int zze = 11;
        public static final int zzf = 12;
        public static final int zzg = 13;
        public static final int zzh = 14;
        public static final int zzi = 15;
        public static final int zzj = 16;
        private int zzk;
        private int zzl;
        private zzar zzn;
        private int zzo;
        private int zzv;
        private int zzw;
        private static final zzien<zzd.zza> zzy = new zzien<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzr.1
            AnonymousClass1() {
            }

            @Override // com.google.android.gms.internal.ads.zzien
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
            }
        };
        private static final zzien<zzd.zza> zzA = new zzien<zzd.zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzr.2
            AnonymousClass2() {
            }

            @Override // com.google.android.gms.internal.ads.zzien
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
            }
        };
        private String zzm = "";
        private String zzp = "";
        private String zzu = "";
        private zziem zzx = zzbC();
        private zziem zzz = zzbC();

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzr$1 */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        class AnonymousClass1 implements zzien<zzd.zza> {
            AnonymousClass1() {
            }

            @Override // com.google.android.gms.internal.ads.zzien
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzr$2 */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        class AnonymousClass2 implements zzien<zzd.zza> {
            AnonymousClass2() {
            }

            @Override // com.google.android.gms.internal.ads.zzien
            /* JADX INFO: renamed from: zza */
            public zzd.zza zzb(int i) {
                zzd.zza zzaVarZzc = zzd.zza.zzc(i);
                return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzr, zza> implements zzs {
            private zza() {
                super(zzr.zzB);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzA() {
                return ((zzr) this.zza).zzA();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public String zzB() {
                return ((zzr) this.zza).zzB();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzida zzC() {
                return ((zzr) this.zza).zzC();
            }

            public zza zzD(String str) {
                zzbg();
                ((zzr) this.zza).zzac(str);
                return this;
            }

            public zza zzE() {
                zzbg();
                ((zzr) this.zza).zzad();
                return this;
            }

            public zza zzF(zzida zzidaVar) {
                zzbg();
                ((zzr) this.zza).zzae(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzG() {
                return ((zzr) this.zza).zzG();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzab.zzc zzH() {
                return ((zzr) this.zza).zzH();
            }

            public zza zzI(zzab.zzc zzcVar) {
                zzbg();
                ((zzr) this.zza).zzaf(zzcVar);
                return this;
            }

            public zza zzJ() {
                zzbg();
                ((zzr) this.zza).zzag();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzK() {
                return ((zzr) this.zza).zzK();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zza.EnumC0021zza zzL() {
                return ((zzr) this.zza).zzL();
            }

            public zza zzM(zza.EnumC0021zza enumC0021zza) {
                zzbg();
                ((zzr) this.zza).zzah(enumC0021zza);
                return this;
            }

            public zza zzN() {
                zzbg();
                ((zzr) this.zza).zzai();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public List<zzd.zza> zzO() {
                return ((zzr) this.zza).zzO();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public int zzP() {
                return ((zzr) this.zza).zzP();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzd.zza zzQ(int i) {
                return ((zzr) this.zza).zzQ(i);
            }

            public zza zzR(int i, zzd.zza zzaVar) {
                zzbg();
                ((zzr) this.zza).zzaj(i, zzaVar);
                return this;
            }

            public zza zzS(zzd.zza zzaVar) {
                zzbg();
                ((zzr) this.zza).zzak(zzaVar);
                return this;
            }

            public zza zzT(Iterable<? extends zzd.zza> iterable) {
                zzbg();
                ((zzr) this.zza).zzal(iterable);
                return this;
            }

            public zza zzU() {
                zzbg();
                ((zzr) this.zza).zzam();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public List<zzd.zza> zzV() {
                return ((zzr) this.zza).zzV();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public int zzW() {
                return ((zzr) this.zza).zzW();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzd.zza zzX(int i) {
                return ((zzr) this.zza).zzX(i);
            }

            public zza zzY(int i, zzd.zza zzaVar) {
                zzbg();
                ((zzr) this.zza).zzan(i, zzaVar);
                return this;
            }

            public zza zzZ(zzd.zza zzaVar) {
                zzbg();
                ((zzr) this.zza).zzao(zzaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zza() {
                return ((zzr) this.zza).zza();
            }

            public zza zzaa(Iterable<? extends zzd.zza> iterable) {
                zzbg();
                ((zzr) this.zza).zzap(iterable);
                return this;
            }

            public zza zzab() {
                zzbg();
                ((zzr) this.zza).zzaq();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public int zzb() {
                return ((zzr) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzr) this.zza).zzF(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzr) this.zza).zzI();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zze() {
                return ((zzr) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public String zzf() {
                return ((zzr) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzida zzg() {
                return ((zzr) this.zza).zzg();
            }

            public zza zzh(String str) {
                zzbg();
                ((zzr) this.zza).zzJ(str);
                return this;
            }

            public zza zzi() {
                zzbg();
                ((zzr) this.zza).zzM();
                return this;
            }

            public zza zzj(zzida zzidaVar) {
                zzbg();
                ((zzr) this.zza).zzN(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzk() {
                return ((zzr) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzar zzl() {
                return ((zzr) this.zza).zzl();
            }

            public zza zzm(zzar zzarVar) {
                zzbg();
                ((zzr) this.zza).zzR(zzarVar);
                return this;
            }

            public zza zzn(zzar.zza zzaVar) {
                zzbg();
                ((zzr) this.zza).zzR(zzaVar.zzbu());
                return this;
            }

            public zza zzo(zzar zzarVar) {
                zzbg();
                ((zzr) this.zza).zzS(zzarVar);
                return this;
            }

            public zza zzp() {
                zzbg();
                ((zzr) this.zza).zzT();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzq() {
                return ((zzr) this.zza).zzq();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzo.zzb zzr() {
                return ((zzr) this.zza).zzr();
            }

            public zza zzs(zzo.zzb zzbVar) {
                zzbg();
                ((zzr) this.zza).zzU(zzbVar);
                return this;
            }

            public zza zzt() {
                zzbg();
                ((zzr) this.zza).zzY();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public boolean zzu() {
                return ((zzr) this.zza).zzu();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public String zzv() {
                return ((zzr) this.zza).zzv();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzs
            public zzida zzw() {
                return ((zzr) this.zza).zzw();
            }

            public zza zzx(String str) {
                zzbg();
                ((zzr) this.zza).zzZ(str);
                return this;
            }

            public zza zzy() {
                zzbg();
                ((zzr) this.zza).zzaa();
                return this;
            }

            public zza zzz(zzida zzidaVar) {
                zzbg();
                ((zzr) this.zza).zzab(zzidaVar);
                return this;
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzB = zzrVar;
            zziee.zzbu(zzr.class, zzrVar);
        }

        private zzr() {
        }

        public static zzr zzD() {
            return zzB;
        }

        public static zzifx<zzr> zzE() {
            return zzB.zzbd();
        }

        /* JADX INFO: renamed from: zzaA */
        public void zzU(zzo.zzb zzbVar) {
            this.zzo = zzbVar.zza();
            this.zzk |= 8;
        }

        /* JADX INFO: renamed from: zzaB */
        public void zzY() {
            this.zzk &= -9;
            this.zzo = 0;
        }

        /* JADX INFO: renamed from: zzaC */
        public void zzZ(String str) {
            str.getClass();
            this.zzk |= 16;
            this.zzp = str;
        }

        /* JADX INFO: renamed from: zzaD */
        public void zzaa() {
            this.zzk &= -17;
            this.zzp = zzD().zzv();
        }

        /* JADX INFO: renamed from: zzaE */
        public void zzab(zzida zzidaVar) {
            this.zzp = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzk |= 16;
        }

        /* JADX INFO: renamed from: zzaF */
        public void zzac(String str) {
            str.getClass();
            this.zzk |= 32;
            this.zzu = str;
        }

        /* JADX INFO: renamed from: zzaG */
        public void zzad() {
            this.zzk &= -33;
            this.zzu = zzD().zzB();
        }

        /* JADX INFO: renamed from: zzaH */
        public void zzae(zzida zzidaVar) {
            this.zzu = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzk |= 32;
        }

        /* JADX INFO: renamed from: zzaI */
        public void zzaf(zzab.zzc zzcVar) {
            this.zzv = zzcVar.zza();
            this.zzk |= 64;
        }

        /* JADX INFO: renamed from: zzaJ */
        public void zzag() {
            this.zzk &= -65;
            this.zzv = 0;
        }

        /* JADX INFO: renamed from: zzaK */
        public void zzah(zza.EnumC0021zza enumC0021zza) {
            this.zzw = enumC0021zza.zza();
            this.zzk |= 128;
        }

        /* JADX INFO: renamed from: zzaL */
        public void zzai() {
            this.zzk &= -129;
            this.zzw = 0;
        }

        /* JADX INFO: renamed from: zzas */
        public void zzF(int i) {
            this.zzk |= 1;
            this.zzl = i;
        }

        /* JADX INFO: renamed from: zzat */
        public void zzI() {
            this.zzk &= -2;
            this.zzl = 0;
        }

        /* JADX INFO: renamed from: zzau */
        public void zzJ(String str) {
            str.getClass();
            this.zzk |= 2;
            this.zzm = str;
        }

        /* JADX INFO: renamed from: zzav */
        public void zzM() {
            this.zzk &= -3;
            this.zzm = zzD().zzf();
        }

        /* JADX INFO: renamed from: zzaw */
        public void zzN(zzida zzidaVar) {
            this.zzm = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzk |= 2;
        }

        /* JADX INFO: renamed from: zzax */
        public void zzR(zzar zzarVar) {
            zzarVar.getClass();
            this.zzn = zzarVar;
            this.zzk |= 4;
        }

        /* JADX INFO: renamed from: zzay */
        public void zzS(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzn;
            if (zzarVar2 != null && zzarVar2 != zzar.zzu()) {
                zzar.zza zzaVarZzt = zzar.zzt(zzarVar2);
                zzaVarZzt.zzbo(zzarVar);
                zzarVar = zzaVarZzt.zzbt();
            }
            this.zzn = zzarVar;
            this.zzk |= 4;
        }

        /* JADX INFO: renamed from: zzaz */
        public void zzT() {
            this.zzn = null;
            this.zzk &= -5;
        }

        public static zzr zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzr) zziee.zzbR(zzB, byteBuffer);
        }

        private void zzce() {
            zziem zziemVar = this.zzx;
            if (zziemVar.zza()) {
                return;
            }
            this.zzx = zziee.zzbD(zziemVar);
        }

        /* JADX INFO: renamed from: zzcf */
        public void zzaj(int i, zzd.zza zzaVar) {
            zzaVar.getClass();
            zzce();
            this.zzx.zzg(i, zzaVar.zza());
        }

        /* JADX INFO: renamed from: zzcg */
        public void zzak(zzd.zza zzaVar) {
            zzaVar.getClass();
            zzce();
            this.zzx.zzi(zzaVar.zza());
        }

        /* JADX INFO: renamed from: zzch */
        public void zzal(Iterable<? extends zzd.zza> iterable) {
            zzce();
            Iterator<? extends zzd.zza> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzx.zzi(it.next().zza());
            }
        }

        /* JADX INFO: renamed from: zzci */
        public void zzam() {
            this.zzx = zzbC();
        }

        private void zzcj() {
            zziem zziemVar = this.zzz;
            if (zziemVar.zza()) {
                return;
            }
            this.zzz = zziee.zzbD(zziemVar);
        }

        /* JADX INFO: renamed from: zzck */
        public void zzan(int i, zzd.zza zzaVar) {
            zzaVar.getClass();
            zzcj();
            this.zzz.zzg(i, zzaVar.zza());
        }

        /* JADX INFO: renamed from: zzcl */
        public void zzao(zzd.zza zzaVar) {
            zzaVar.getClass();
            zzcj();
            this.zzz.zzi(zzaVar.zza());
        }

        /* JADX INFO: renamed from: zzcm */
        public void zzap(Iterable<? extends zzd.zza> iterable) {
            zzcj();
            Iterator<? extends zzd.zza> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzz.zzi(it.next().zza());
            }
        }

        /* JADX INFO: renamed from: zzcn */
        public void zzaq() {
            this.zzz = zzbC();
        }

        public static zzr zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzr) zziee.zzbQ(zzB, byteBuffer, zzidoVar);
        }

        public static zzr zzh(zzida zzidaVar) throws zziet {
            return (zzr) zziee.zzbS(zzB, zzidaVar);
        }

        public static zzr zzi(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzr) zziee.zzbT(zzB, zzidaVar, zzidoVar);
        }

        public static zzr zzj(byte[] bArr) throws zziet {
            return (zzr) zziee.zzbU(zzB, bArr);
        }

        public static zzr zzm(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzr) zziee.zzbV(zzB, bArr, zzidoVar);
        }

        public static zzr zzn(InputStream inputStream) throws IOException {
            return (zzr) zziee.zzbW(zzB, inputStream);
        }

        public static zzr zzo(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzr) zziee.zzbX(zzB, inputStream, zzidoVar);
        }

        public static zzr zzp(InputStream inputStream) throws IOException {
            return (zzr) zzca(zzB, inputStream);
        }

        public static zzr zzs(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzr) zzcb(zzB, inputStream, zzidoVar);
        }

        public static zzr zzt(zzide zzideVar) throws IOException {
            return (zzr) zziee.zzbY(zzB, zzideVar);
        }

        public static zzr zzx(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzr) zziee.zzbZ(zzB, zzideVar, zzidoVar);
        }

        public static zza zzy() {
            return (zza) zzB.zzbn();
        }

        public static zza zzz(zzr zzrVar) {
            return (zza) zzB.zzbo(zzrVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzA() {
            return (this.zzk & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public String zzB() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzida zzC() {
            return zzida.zzx(this.zzu);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzG() {
            return (this.zzk & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzab.zzc zzH() {
            zzab.zzc zzcVarZzc = zzab.zzc.zzc(this.zzv);
            return zzcVarZzc == null ? zzab.zzc.NETWORKTYPE_UNSPECIFIED : zzcVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzK() {
            return (this.zzk & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zza.EnumC0021zza zzL() {
            zza.EnumC0021zza enumC0021zzaZzc = zza.EnumC0021zza.zzc(this.zzw);
            return enumC0021zzaZzc == null ? zza.EnumC0021zza.AD_INITIATER_UNSPECIFIED : enumC0021zzaZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public List<zzd.zza> zzO() {
            return new zzieo(this.zzx, zzy);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public int zzP() {
            return this.zzx.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzd.zza zzQ(int i) {
            zzd.zza zzaVarZzc = zzd.zza.zzc(this.zzx.zzf(i));
            return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public List<zzd.zza> zzV() {
            return new zzieo(this.zzz, zzA);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public int zzW() {
            return this.zzz.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzd.zza zzX(int i) {
            zzd.zza zzaVarZzc = zzd.zza.zzc(this.zzz.zzf(i));
            return zzaVarZzc == null ? zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzaVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zza() {
            return (this.zzk & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public int zzb() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzB, "\u0004\n\u0000\u0001\u0007\u0010\n\u0000\u0002\u0000\u0007င\u0000\bဈ\u0001\tဉ\u0002\n᠌\u0003\u000bဈ\u0004\fဈ\u0005\r᠌\u0006\u000e᠌\u0007\u000fࠞ\u0010ࠞ", new Object[]{"zzk", "zzl", "zzm", "zzn", "zzo", zzo.zzb.zze(), "zzp", "zzu", "zzv", zzab.zzc.zze(), "zzw", zza.EnumC0021zza.zze(), "zzx", zzd.zza.zze(), "zzz", zzd.zza.zze()});
            }
            if (iOrdinal == 3) {
                return new zzr();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzB;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzr> zzifxVar = zzC;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzr.class) {
                zzidzVar = zzC;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzB);
                    zzC = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zze() {
            return (this.zzk & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public String zzf() {
            return this.zzm;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzida zzg() {
            return zzida.zzx(this.zzm);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzk() {
            return (this.zzk & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzar zzl() {
            zzar zzarVar = this.zzn;
            return zzarVar == null ? zzar.zzu() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzq() {
            return (this.zzk & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzo.zzb zzr() {
            zzo.zzb zzbVarZzc = zzo.zzb.zzc(this.zzo);
            return zzbVarZzc == null ? zzo.zzb.PLATFORM_UNSPECIFIED : zzbVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public boolean zzu() {
            return (this.zzk & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public String zzv() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzs
        public zzida zzw() {
            return zzida.zzx(this.zzp);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzs extends zzifq {
        boolean zzA();

        String zzB();

        zzida zzC();

        boolean zzG();

        zzab.zzc zzH();

        boolean zzK();

        zza.EnumC0021zza zzL();

        List<zzd.zza> zzO();

        int zzP();

        zzd.zza zzQ(int i);

        List<zzd.zza> zzV();

        int zzW();

        zzd.zza zzX(int i);

        boolean zza();

        int zzb();

        boolean zze();

        String zzf();

        zzida zzg();

        boolean zzk();

        zzar zzl();

        boolean zzq();

        zzo.zzb zzr();

        boolean zzu();

        String zzv();

        zzida zzw();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzt extends zziee<zzt, zza> implements zzu {
        private static final zzt zzF;
        private static volatile zzifx<zzt> zzG = null;
        public static final int zza = 9;
        public static final int zzb = 10;
        public static final int zzc = 11;
        public static final int zzd = 12;
        public static final int zze = 13;
        public static final int zzf = 14;
        public static final int zzg = 15;
        public static final int zzh = 16;
        public static final int zzi = 17;
        public static final int zzj = 18;
        public static final int zzk = 19;
        public static final int zzl = 20;
        public static final int zzm = 21;
        private zzab zzA;
        private zza zzB;
        private zzaf zzC;
        private zzbl zzD;
        private zzb zzE;
        private int zzn;
        private int zzo;
        private int zzu;
        private zzar zzw;
        private zzm zzy;
        private zzo zzz;
        private String zzp = "";
        private int zzv = 1000;
        private zziep zzx = zzbE();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzt, zza> implements zzu {
            private zza() {
                super(zzt.zzF);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public long zzA(int i) {
                return ((zzt) this.zza).zzA(i);
            }

            public zza zzB(int i, long j) {
                zzbg();
                ((zzt) this.zza).zzW(i, j);
                return this;
            }

            public zza zzC(long j) {
                zzbg();
                ((zzt) this.zza).zzZ(j);
                return this;
            }

            public zza zzD(Iterable<? extends Long> iterable) {
                zzbg();
                ((zzt) this.zza).zzaa(iterable);
                return this;
            }

            public zza zzE() {
                zzbg();
                ((zzt) this.zza).zzab();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzF() {
                return ((zzt) this.zza).zzF();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzm zzG() {
                return ((zzt) this.zza).zzG();
            }

            public zza zzH(zzm zzmVar) {
                zzbg();
                ((zzt) this.zza).zzac(zzmVar);
                return this;
            }

            public zza zzI(zzm.zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzac(zzaVar.zzbu());
                return this;
            }

            public zza zzJ(zzm zzmVar) {
                zzbg();
                ((zzt) this.zza).zzaf(zzmVar);
                return this;
            }

            public zza zzK() {
                zzbg();
                ((zzt) this.zza).zzag();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzL() {
                return ((zzt) this.zza).zzL();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzo zzM() {
                return ((zzt) this.zza).zzM();
            }

            public zza zzN(zzo zzoVar) {
                zzbg();
                ((zzt) this.zza).zzah(zzoVar);
                return this;
            }

            public zza zzO(zzo.zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzah(zzaVar.zzbu());
                return this;
            }

            public zza zzP(zzo zzoVar) {
                zzbg();
                ((zzt) this.zza).zzai(zzoVar);
                return this;
            }

            public zza zzQ() {
                zzbg();
                ((zzt) this.zza).zzal();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzR() {
                return ((zzt) this.zza).zzR();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzab zzS() {
                return ((zzt) this.zza).zzS();
            }

            public zza zzT(zzab zzabVar) {
                zzbg();
                ((zzt) this.zza).zzam(zzabVar);
                return this;
            }

            public zza zzU(zzab.zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzam(zzaVar.zzbu());
                return this;
            }

            public zza zzV(zzab zzabVar) {
                zzbg();
                ((zzt) this.zza).zzan(zzabVar);
                return this;
            }

            public zza zzW() {
                zzbg();
                ((zzt) this.zza).zzao();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzX() {
                return ((zzt) this.zza).zzX();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zza zzY() {
                return ((zzt) this.zza).zzY();
            }

            public zza zzZ(zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzar(zzaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zza() {
                return ((zzt) this.zza).zza();
            }

            public zza zzaa(zza.zzb zzbVar) {
                zzbg();
                ((zzt) this.zza).zzar(zzbVar.zzbu());
                return this;
            }

            public zza zzab(zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzas(zzaVar);
                return this;
            }

            public zza zzac() {
                zzbg();
                ((zzt) this.zza).zzat();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzad() {
                return ((zzt) this.zza).zzad();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzaf zzae() {
                return ((zzt) this.zza).zzae();
            }

            public zza zzaf(zzaf zzafVar) {
                zzbg();
                ((zzt) this.zza).zzau(zzafVar);
                return this;
            }

            public zza zzag(zzaf.zzc zzcVar) {
                zzbg();
                ((zzt) this.zza).zzau(zzcVar.zzbu());
                return this;
            }

            public zza zzah(zzaf zzafVar) {
                zzbg();
                ((zzt) this.zza).zzav(zzafVar);
                return this;
            }

            public zza zzai() {
                zzbg();
                ((zzt) this.zza).zzaw();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzaj() {
                return ((zzt) this.zza).zzaj();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzbl zzak() {
                return ((zzt) this.zza).zzak();
            }

            public zza zzal(zzbl zzblVar) {
                zzbg();
                ((zzt) this.zza).zzax(zzblVar);
                return this;
            }

            public zza zzam(zzbl.zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzax(zzaVar.zzbu());
                return this;
            }

            public zza zzan(zzbl zzblVar) {
                zzbg();
                ((zzt) this.zza).zzay(zzblVar);
                return this;
            }

            public zza zzao() {
                zzbg();
                ((zzt) this.zza).zzaz();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzap() {
                return ((zzt) this.zza).zzap();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzb zzaq() {
                return ((zzt) this.zza).zzaq();
            }

            public zza zzar(zzb zzbVar) {
                zzbg();
                ((zzt) this.zza).zzaA(zzbVar);
                return this;
            }

            public zza zzas(zzb.zzc zzcVar) {
                zzbg();
                ((zzt) this.zza).zzaA(zzcVar.zzbu());
                return this;
            }

            public zza zzat(zzb zzbVar) {
                zzbg();
                ((zzt) this.zza).zzaB(zzbVar);
                return this;
            }

            public zza zzau() {
                zzbg();
                ((zzt) this.zza).zzaC();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public int zzb() {
                return ((zzt) this.zza).zzb();
            }

            public zza zzc(int i) {
                zzbg();
                ((zzt) this.zza).zzE(i);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzt) this.zza).zzH();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zze() {
                return ((zzt) this.zza).zze();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public String zzf() {
                return ((zzt) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzida zzg() {
                return ((zzt) this.zza).zzg();
            }

            public zza zzh(String str) {
                zzbg();
                ((zzt) this.zza).zzI(str);
                return this;
            }

            public zza zzi() {
                zzbg();
                ((zzt) this.zza).zzJ();
                return this;
            }

            public zza zzj(zzida zzidaVar) {
                zzbg();
                ((zzt) this.zza).zzK(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzk() {
                return ((zzt) this.zza).zzk();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public int zzl() {
                return ((zzt) this.zza).zzl();
            }

            public zza zzm(int i) {
                zzbg();
                ((zzt) this.zza).zzN(i);
                return this;
            }

            public zza zzn() {
                zzbg();
                ((zzt) this.zza).zzO();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzo() {
                return ((zzt) this.zza).zzo();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzq zzp() {
                return ((zzt) this.zza).zzp();
            }

            public zza zzq(zzq zzqVar) {
                zzbg();
                ((zzt) this.zza).zzP(zzqVar);
                return this;
            }

            public zza zzr() {
                zzbg();
                ((zzt) this.zza).zzQ();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public boolean zzs() {
                return ((zzt) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public zzar zzt() {
                return ((zzt) this.zza).zzt();
            }

            public zza zzu(zzar zzarVar) {
                zzbg();
                ((zzt) this.zza).zzT(zzarVar);
                return this;
            }

            public zza zzv(zzar.zza zzaVar) {
                zzbg();
                ((zzt) this.zza).zzT(zzaVar.zzbu());
                return this;
            }

            public zza zzw(zzar zzarVar) {
                zzbg();
                ((zzt) this.zza).zzU(zzarVar);
                return this;
            }

            public zza zzx() {
                zzbg();
                ((zzt) this.zza).zzV();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public List<Long> zzy() {
                return Collections.unmodifiableList(((zzt) this.zza).zzy());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzu
            public int zzz() {
                return ((zzt) this.zza).zzz();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzF = zztVar;
            zziee.zzbu(zzt.class, zztVar);
        }

        private zzt() {
        }

        public static zza zzB(zzt zztVar) {
            return (zza) zzF.zzbo(zztVar);
        }

        public static zzt zzC() {
            return zzF;
        }

        public static zzifx<zzt> zzD() {
            return zzF.zzbd();
        }

        /* JADX INFO: renamed from: zzaE */
        public void zzE(int i) {
            this.zzn |= 1;
            this.zzo = i;
        }

        /* JADX INFO: renamed from: zzaF */
        public void zzH() {
            this.zzn &= -2;
            this.zzo = 0;
        }

        /* JADX INFO: renamed from: zzaG */
        public void zzI(String str) {
            str.getClass();
            this.zzn |= 2;
            this.zzp = str;
        }

        /* JADX INFO: renamed from: zzaH */
        public void zzJ() {
            this.zzn &= -3;
            this.zzp = zzC().zzf();
        }

        /* JADX INFO: renamed from: zzaI */
        public void zzK(zzida zzidaVar) {
            this.zzp = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zzn |= 2;
        }

        /* JADX INFO: renamed from: zzaJ */
        public void zzN(int i) {
            this.zzn |= 4;
            this.zzu = i;
        }

        /* JADX INFO: renamed from: zzaK */
        public void zzO() {
            this.zzn &= -5;
            this.zzu = 0;
        }

        /* JADX INFO: renamed from: zzaL */
        public void zzP(zzq zzqVar) {
            this.zzv = zzqVar.zza();
            this.zzn |= 8;
        }

        public static zzt zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzt) zziee.zzbR(zzF, byteBuffer);
        }

        /* JADX INFO: renamed from: zzcA */
        public void zzav(zzaf zzafVar) {
            zzafVar.getClass();
            zzaf zzafVar2 = this.zzC;
            if (zzafVar2 != null && zzafVar2 != zzaf.zzD()) {
                zzaf.zzc zzcVarZzC = zzaf.zzC(zzafVar2);
                zzcVarZzC.zzbo(zzafVar);
                zzafVar = zzcVarZzC.zzbt();
            }
            this.zzC = zzafVar;
            this.zzn |= 512;
        }

        /* JADX INFO: renamed from: zzcB */
        public void zzaw() {
            this.zzC = null;
            this.zzn &= -513;
        }

        /* JADX INFO: renamed from: zzcC */
        public void zzax(zzbl zzblVar) {
            zzblVar.getClass();
            this.zzD = zzblVar;
            this.zzn |= 1024;
        }

        /* JADX INFO: renamed from: zzcD */
        public void zzay(zzbl zzblVar) {
            zzblVar.getClass();
            zzbl zzblVar2 = this.zzD;
            if (zzblVar2 != null && zzblVar2 != zzbl.zzs()) {
                zzbl.zza zzaVarZzr = zzbl.zzr(zzblVar2);
                zzaVarZzr.zzbo(zzblVar);
                zzblVar = zzaVarZzr.zzbt();
            }
            this.zzD = zzblVar;
            this.zzn |= 1024;
        }

        /* JADX INFO: renamed from: zzcE */
        public void zzaz() {
            this.zzD = null;
            this.zzn &= -1025;
        }

        /* JADX INFO: renamed from: zzcF */
        public void zzaA(zzb zzbVar) {
            zzbVar.getClass();
            this.zzE = zzbVar;
            this.zzn |= 2048;
        }

        /* JADX INFO: renamed from: zzcG */
        public void zzaB(zzb zzbVar) {
            zzbVar.getClass();
            zzb zzbVar2 = this.zzE;
            if (zzbVar2 != null && zzbVar2 != zzb.zzu()) {
                zzb.zzc zzcVarZzt = zzb.zzt(zzbVar2);
                zzcVarZzt.zzbo(zzbVar);
                zzbVar = zzcVarZzt.zzbt();
            }
            this.zzE = zzbVar;
            this.zzn |= 2048;
        }

        /* JADX INFO: renamed from: zzcH */
        public void zzaC() {
            this.zzE = null;
            this.zzn &= -2049;
        }

        /* JADX INFO: renamed from: zzce */
        public void zzQ() {
            this.zzn &= -9;
            this.zzv = 1000;
        }

        /* JADX INFO: renamed from: zzcf */
        public void zzT(zzar zzarVar) {
            zzarVar.getClass();
            this.zzw = zzarVar;
            this.zzn |= 16;
        }

        /* JADX INFO: renamed from: zzcg */
        public void zzU(zzar zzarVar) {
            zzarVar.getClass();
            zzar zzarVar2 = this.zzw;
            if (zzarVar2 != null && zzarVar2 != zzar.zzu()) {
                zzar.zza zzaVarZzt = zzar.zzt(zzarVar2);
                zzaVarZzt.zzbo(zzarVar);
                zzarVar = zzaVarZzt.zzbt();
            }
            this.zzw = zzarVar;
            this.zzn |= 16;
        }

        /* JADX INFO: renamed from: zzch */
        public void zzV() {
            this.zzw = null;
            this.zzn &= -17;
        }

        private void zzci() {
            zziep zziepVar = this.zzx;
            if (zziepVar.zza()) {
                return;
            }
            this.zzx = zziee.zzbF(zziepVar);
        }

        /* JADX INFO: renamed from: zzcj */
        public void zzW(int i, long j) {
            zzci();
            this.zzx.zze(i, j);
        }

        /* JADX INFO: renamed from: zzck */
        public void zzZ(long j) {
            zzci();
            this.zzx.zzd(j);
        }

        /* JADX INFO: renamed from: zzcl */
        public void zzaa(Iterable<? extends Long> iterable) {
            zzci();
            zzicj.zzaW(iterable, this.zzx);
        }

        /* JADX INFO: renamed from: zzcm */
        public void zzab() {
            this.zzx = zzbE();
        }

        /* JADX INFO: renamed from: zzcn */
        public void zzac(zzm zzmVar) {
            zzmVar.getClass();
            this.zzy = zzmVar;
            this.zzn |= 32;
        }

        /* JADX INFO: renamed from: zzco */
        public void zzaf(zzm zzmVar) {
            zzmVar.getClass();
            zzm zzmVar2 = this.zzy;
            if (zzmVar2 != null && zzmVar2 != zzm.zzC()) {
                zzm.zza zzaVarZzz = zzm.zzz(zzmVar2);
                zzaVarZzz.zzbo(zzmVar);
                zzmVar = zzaVarZzz.zzbt();
            }
            this.zzy = zzmVar;
            this.zzn |= 32;
        }

        /* JADX INFO: renamed from: zzcp */
        public void zzag() {
            this.zzy = null;
            this.zzn &= -33;
        }

        /* JADX INFO: renamed from: zzcq */
        public void zzah(zzo zzoVar) {
            zzoVar.getClass();
            this.zzz = zzoVar;
            this.zzn |= 64;
        }

        /* JADX INFO: renamed from: zzcr */
        public void zzai(zzo zzoVar) {
            zzoVar.getClass();
            zzo zzoVar2 = this.zzz;
            if (zzoVar2 != null && zzoVar2 != zzo.zzy()) {
                zzo.zza zzaVarZzx = zzo.zzx(zzoVar2);
                zzaVarZzx.zzbo(zzoVar);
                zzoVar = zzaVarZzx.zzbt();
            }
            this.zzz = zzoVar;
            this.zzn |= 64;
        }

        /* JADX INFO: renamed from: zzcs */
        public void zzal() {
            this.zzz = null;
            this.zzn &= -65;
        }

        /* JADX INFO: renamed from: zzct */
        public void zzam(zzab zzabVar) {
            zzabVar.getClass();
            this.zzA = zzabVar;
            this.zzn |= 128;
        }

        /* JADX INFO: renamed from: zzcu */
        public void zzan(zzab zzabVar) {
            zzabVar.getClass();
            zzab zzabVar2 = this.zzA;
            if (zzabVar2 != null && zzabVar2 != zzab.zzs()) {
                zzab.zza zzaVarZzr = zzab.zzr(zzabVar2);
                zzaVarZzr.zzbo(zzabVar);
                zzabVar = zzaVarZzr.zzbt();
            }
            this.zzA = zzabVar;
            this.zzn |= 128;
        }

        /* JADX INFO: renamed from: zzcv */
        public void zzao() {
            this.zzA = null;
            this.zzn &= -129;
        }

        /* JADX INFO: renamed from: zzcw */
        public void zzar(zza zzaVar) {
            zzaVar.getClass();
            this.zzB = zzaVar;
            this.zzn |= 256;
        }

        /* JADX INFO: renamed from: zzcx */
        public void zzas(zza zzaVar) {
            zzaVar.getClass();
            zza zzaVar2 = this.zzB;
            if (zzaVar2 != null && zzaVar2 != zza.zzD()) {
                zza.zzb zzbVarZzC = zza.zzC(zzaVar2);
                zzbVarZzC.zzbo(zzaVar);
                zzaVar = zzbVarZzC.zzbt();
            }
            this.zzB = zzaVar;
            this.zzn |= 256;
        }

        /* JADX INFO: renamed from: zzcy */
        public void zzat() {
            this.zzB = null;
            this.zzn &= -257;
        }

        /* JADX INFO: renamed from: zzcz */
        public void zzau(zzaf zzafVar) {
            zzafVar.getClass();
            this.zzC = zzafVar;
            this.zzn |= 512;
        }

        public static zzt zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzt) zziee.zzbQ(zzF, byteBuffer, zzidoVar);
        }

        public static zzt zzh(zzida zzidaVar) throws zziet {
            return (zzt) zziee.zzbS(zzF, zzidaVar);
        }

        public static zzt zzi(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzt) zziee.zzbT(zzF, zzidaVar, zzidoVar);
        }

        public static zzt zzj(byte[] bArr) throws zziet {
            return (zzt) zziee.zzbU(zzF, bArr);
        }

        public static zzt zzm(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzt) zziee.zzbV(zzF, bArr, zzidoVar);
        }

        public static zzt zzn(InputStream inputStream) throws IOException {
            return (zzt) zziee.zzbW(zzF, inputStream);
        }

        public static zzt zzq(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzt) zziee.zzbX(zzF, inputStream, zzidoVar);
        }

        public static zzt zzr(InputStream inputStream) throws IOException {
            return (zzt) zzca(zzF, inputStream);
        }

        public static zzt zzu(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzt) zzcb(zzF, inputStream, zzidoVar);
        }

        public static zzt zzv(zzide zzideVar) throws IOException {
            return (zzt) zziee.zzbY(zzF, zzideVar);
        }

        public static zzt zzw(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzt) zziee.zzbZ(zzF, zzideVar, zzidoVar);
        }

        public static zza zzx() {
            return (zza) zzF.zzbn();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public long zzA(int i) {
            return this.zzx.zzc(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzF() {
            return (this.zzn & 32) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzm zzG() {
            zzm zzmVar = this.zzy;
            return zzmVar == null ? zzm.zzC() : zzmVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzL() {
            return (this.zzn & 64) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzo zzM() {
            zzo zzoVar = this.zzz;
            return zzoVar == null ? zzo.zzy() : zzoVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzR() {
            return (this.zzn & 128) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzab zzS() {
            zzab zzabVar = this.zzA;
            return zzabVar == null ? zzab.zzs() : zzabVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzX() {
            return (this.zzn & 256) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zza zzY() {
            zza zzaVar = this.zzB;
            return zzaVar == null ? zza.zzD() : zzaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zza() {
            return (this.zzn & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzad() {
            return (this.zzn & 512) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzaf zzae() {
            zzaf zzafVar = this.zzC;
            return zzafVar == null ? zzaf.zzD() : zzafVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzaj() {
            return (this.zzn & 1024) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzbl zzak() {
            zzbl zzblVar = this.zzD;
            return zzblVar == null ? zzbl.zzs() : zzblVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzap() {
            return (this.zzn & 2048) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzb zzaq() {
            zzb zzbVar = this.zzE;
            return zzbVar == null ? zzb.zzu() : zzbVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public int zzb() {
            return this.zzo;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzF, "\u0004\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzn", "zzo", "zzp", "zzu", "zzv", zzq.zze(), "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE"});
            }
            if (iOrdinal == 3) {
                return new zzt();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzF;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzt> zzifxVar = zzG;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzt.class) {
                zzidzVar = zzG;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzF);
                    zzG = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zze() {
            return (this.zzn & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public String zzf() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzida zzg() {
            return zzida.zzx(this.zzp);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzk() {
            return (this.zzn & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public int zzl() {
            return this.zzu;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzo() {
            return (this.zzn & 8) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzq zzp() {
            zzq zzqVarZzc = zzq.zzc(this.zzv);
            return zzqVarZzc == null ? zzq.ENUM_UNKNOWN : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public boolean zzs() {
            return (this.zzn & 16) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public zzar zzt() {
            zzar zzarVar = this.zzw;
            return zzarVar == null ? zzar.zzu() : zzarVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public List<Long> zzy() {
            return this.zzx;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzu
        public int zzz() {
            return this.zzx.size();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzu extends zzifq {
        long zzA(int i);

        boolean zzF();

        zzm zzG();

        boolean zzL();

        zzo zzM();

        boolean zzR();

        zzab zzS();

        boolean zzX();

        zza zzY();

        boolean zza();

        boolean zzad();

        zzaf zzae();

        boolean zzaj();

        zzbl zzak();

        boolean zzap();

        zzb zzaq();

        int zzb();

        boolean zze();

        String zzf();

        zzida zzg();

        boolean zzk();

        int zzl();

        boolean zzo();

        zzq zzp();

        boolean zzs();

        zzar zzt();

        List<Long> zzy();

        int zzz();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzv extends zziee<zzv, zza> implements zzw {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzv zzj;
        private static volatile zzifx<zzv> zzk;
        private int zze;
        private int zzg;
        private zzap zzi;
        private String zzf = "";
        private zziem zzh = zzbC();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzv, zza> implements zzw {
            private zza() {
                super(zzv.zzj);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public boolean zza() {
                return ((zzv) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public String zzb() {
                return ((zzv) this.zza).zzb();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public zzida zzc() {
                return ((zzv) this.zza).zzc();
            }

            public zza zzd(String str) {
                zzbg();
                ((zzv) this.zza).zzB(str);
                return this;
            }

            public zza zze() {
                zzbg();
                ((zzv) this.zza).zzC();
                return this;
            }

            public zza zzf(zzida zzidaVar) {
                zzbg();
                ((zzv) this.zza).zzD(zzidaVar);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public boolean zzg() {
                return ((zzv) this.zza).zzg();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public zzq zzh() {
                return ((zzv) this.zza).zzh();
            }

            public zza zzi(zzq zzqVar) {
                zzbg();
                ((zzv) this.zza).zzE(zzqVar);
                return this;
            }

            public zza zzj() {
                zzbg();
                ((zzv) this.zza).zzF();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public List<Integer> zzk() {
                return Collections.unmodifiableList(((zzv) this.zza).zzk());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public int zzl() {
                return ((zzv) this.zza).zzl();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public int zzm(int i) {
                return ((zzv) this.zza).zzm(i);
            }

            public zza zzn(int i, int i2) {
                zzbg();
                ((zzv) this.zza).zzG(i, i2);
                return this;
            }

            public zza zzo(int i) {
                zzbg();
                ((zzv) this.zza).zzH(i);
                return this;
            }

            public zza zzp(Iterable<? extends Integer> iterable) {
                zzbg();
                ((zzv) this.zza).zzI(iterable);
                return this;
            }

            public zza zzq() {
                zzbg();
                ((zzv) this.zza).zzJ();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public boolean zzr() {
                return ((zzv) this.zza).zzr();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzw
            public zzap zzs() {
                return ((zzv) this.zza).zzs();
            }

            public zza zzt(zzap zzapVar) {
                zzbg();
                ((zzv) this.zza).zzK(zzapVar);
                return this;
            }

            public zza zzu(zzap.zza zzaVar) {
                zzbg();
                ((zzv) this.zza).zzK(zzaVar.zzbu());
                return this;
            }

            public zza zzv(zzap zzapVar) {
                zzbg();
                ((zzv) this.zza).zzL(zzapVar);
                return this;
            }

            public zza zzw() {
                zzbg();
                ((zzv) this.zza).zzM();
                return this;
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzj = zzvVar;
            zziee.zzbu(zzv.class, zzvVar);
        }

        private zzv() {
        }

        public static zzifx<zzv> zzA() {
            return zzj.zzbd();
        }

        /* JADX INFO: renamed from: zzO */
        public void zzB(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        /* JADX INFO: renamed from: zzP */
        public void zzC() {
            this.zze &= -2;
            this.zzf = zzz().zzb();
        }

        /* JADX INFO: renamed from: zzQ */
        public void zzD(zzida zzidaVar) {
            this.zzf = zzidaVar.zzB(StandardCharsets.UTF_8);
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzR */
        public void zzE(zzq zzqVar) {
            this.zzg = zzqVar.zza();
            this.zze |= 2;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzF() {
            this.zze &= -3;
            this.zzg = 0;
        }

        private void zzT() {
            zziem zziemVar = this.zzh;
            if (zziemVar.zza()) {
                return;
            }
            this.zzh = zziee.zzbD(zziemVar);
        }

        /* JADX INFO: renamed from: zzU */
        public void zzG(int i, int i2) {
            zzT();
            this.zzh.zzg(i, i2);
        }

        /* JADX INFO: renamed from: zzV */
        public void zzH(int i) {
            zzT();
            this.zzh.zzi(i);
        }

        /* JADX INFO: renamed from: zzW */
        public void zzI(Iterable<? extends Integer> iterable) {
            zzT();
            zzicj.zzaW(iterable, this.zzh);
        }

        /* JADX INFO: renamed from: zzX */
        public void zzJ() {
            this.zzh = zzbC();
        }

        /* JADX INFO: renamed from: zzY */
        public void zzK(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzZ */
        public void zzL(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzi = zzapVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzaa */
        public void zzM() {
            this.zzi = null;
            this.zze &= -5;
        }

        public static zzv zzd(ByteBuffer byteBuffer) throws zziet {
            return (zzv) zziee.zzbR(zzj, byteBuffer);
        }

        public static zzv zze(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzv) zziee.zzbQ(zzj, byteBuffer, zzidoVar);
        }

        public static zzv zzi(zzida zzidaVar) throws zziet {
            return (zzv) zziee.zzbS(zzj, zzidaVar);
        }

        public static zzv zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzv) zziee.zzbT(zzj, zzidaVar, zzidoVar);
        }

        public static zzv zzn(byte[] bArr) throws zziet {
            return (zzv) zziee.zzbU(zzj, bArr);
        }

        public static zzv zzo(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzv) zziee.zzbV(zzj, bArr, zzidoVar);
        }

        public static zzv zzp(InputStream inputStream) throws IOException {
            return (zzv) zziee.zzbW(zzj, inputStream);
        }

        public static zzv zzq(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzv) zziee.zzbX(zzj, inputStream, zzidoVar);
        }

        public static zzv zzt(InputStream inputStream) throws IOException {
            return (zzv) zzca(zzj, inputStream);
        }

        public static zzv zzu(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzv) zzcb(zzj, inputStream, zzidoVar);
        }

        public static zzv zzv(zzide zzideVar) throws IOException {
            return (zzv) zziee.zzbY(zzj, zzideVar);
        }

        public static zzv zzw(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzv) zziee.zzbZ(zzj, zzideVar, zzidoVar);
        }

        public static zza zzx() {
            return (zza) zzj.zzbn();
        }

        public static zza zzy(zzv zzvVar) {
            return (zza) zzj.zzbo(zzvVar);
        }

        public static zzv zzz() {
            return zzj;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public boolean zza() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public String zzb() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public zzida zzc() {
            return zzida.zzx(this.zzf);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzq.zze(), "zzh", "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzv();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzv> zzifxVar = zzk;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzv.class) {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public boolean zzg() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public zzq zzh() {
            zzq zzqVarZzc = zzq.zzc(this.zzg);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public List<Integer> zzk() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public int zzl() {
            return this.zzh.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public int zzm(int i) {
            return this.zzh.zzf(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public boolean zzr() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzw
        public zzap zzs() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzw extends zzifq {
        boolean zza();

        String zzb();

        zzida zzc();

        boolean zzg();

        zzq zzh();

        List<Integer> zzk();

        int zzl();

        int zzm(int i);

        boolean zzr();

        zzap zzs();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzx extends zziee<zzx, zza> implements zzy {
        public static final int zza = 1;
        public static final int zzb = 2;
        private static final zzx zzf;
        private static volatile zzifx<zzx> zzg;
        private int zzc;
        private int zzd;
        private zziem zze = zzbC();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzx, zza> implements zzy {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzy
            public boolean zza() {
                return ((zzx) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzy
            public zzq zzb() {
                return ((zzx) this.zza).zzb();
            }

            public zza zzc(zzq zzqVar) {
                zzbg();
                ((zzx) this.zza).zzv(zzqVar);
                return this;
            }

            public zza zzd() {
                zzbg();
                ((zzx) this.zza).zzw();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzy
            public List<Integer> zze() {
                return Collections.unmodifiableList(((zzx) this.zza).zze());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzy
            public int zzf() {
                return ((zzx) this.zza).zzf();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzy
            public int zzg(int i) {
                return ((zzx) this.zza).zzg(i);
            }

            public zza zzh(int i, int i2) {
                zzbg();
                ((zzx) this.zza).zzx(i, i2);
                return this;
            }

            public zza zzi(int i) {
                zzbg();
                ((zzx) this.zza).zzy(i);
                return this;
            }

            public zza zzj(Iterable<? extends Integer> iterable) {
                zzbg();
                ((zzx) this.zza).zzz(iterable);
                return this;
            }

            public zza zzk() {
                zzbg();
                ((zzx) this.zza).zzA();
                return this;
            }
        }

        static {
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zziee.zzbu(zzx.class, zzxVar);
        }

        private zzx() {
        }

        /* JADX INFO: renamed from: zzC */
        public void zzv(zzq zzqVar) {
            this.zzd = zzqVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: renamed from: zzD */
        public void zzw() {
            this.zzc &= -2;
            this.zzd = 0;
        }

        private void zzE() {
            zziem zziemVar = this.zze;
            if (zziemVar.zza()) {
                return;
            }
            this.zze = zziee.zzbD(zziemVar);
        }

        /* JADX INFO: renamed from: zzF */
        public void zzx(int i, int i2) {
            zzE();
            this.zze.zzg(i, i2);
        }

        /* JADX INFO: renamed from: zzG */
        public void zzy(int i) {
            zzE();
            this.zze.zzi(i);
        }

        /* JADX INFO: renamed from: zzH */
        public void zzz(Iterable<? extends Integer> iterable) {
            zzE();
            zzicj.zzaW(iterable, this.zze);
        }

        /* JADX INFO: renamed from: zzI */
        public void zzA() {
            this.zze = zzbC();
        }

        public static zzx zzc(ByteBuffer byteBuffer) throws zziet {
            return (zzx) zziee.zzbR(zzf, byteBuffer);
        }

        public static zzx zzd(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzx) zziee.zzbQ(zzf, byteBuffer, zzidoVar);
        }

        public static zzx zzh(zzida zzidaVar) throws zziet {
            return (zzx) zziee.zzbS(zzf, zzidaVar);
        }

        public static zzx zzi(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzx) zziee.zzbT(zzf, zzidaVar, zzidoVar);
        }

        public static zzx zzj(byte[] bArr) throws zziet {
            return (zzx) zziee.zzbU(zzf, bArr);
        }

        public static zzx zzk(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzx) zziee.zzbV(zzf, bArr, zzidoVar);
        }

        public static zzx zzl(InputStream inputStream) throws IOException {
            return (zzx) zziee.zzbW(zzf, inputStream);
        }

        public static zzx zzm(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzx) zziee.zzbX(zzf, inputStream, zzidoVar);
        }

        public static zzx zzn(InputStream inputStream) throws IOException {
            return (zzx) zzca(zzf, inputStream);
        }

        public static zzx zzo(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzx) zzcb(zzf, inputStream, zzidoVar);
        }

        public static zzx zzp(zzide zzideVar) throws IOException {
            return (zzx) zziee.zzbY(zzf, zzideVar);
        }

        public static zzx zzq(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzx) zziee.zzbZ(zzf, zzideVar, zzidoVar);
        }

        public static zza zzr() {
            return (zza) zzf.zzbn();
        }

        public static zza zzs(zzx zzxVar) {
            return (zza) zzf.zzbo(zzxVar);
        }

        public static zzx zzt() {
            return zzf;
        }

        public static zzifx<zzx> zzu() {
            return zzf.zzbd();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzy
        public boolean zza() {
            return (this.zzc & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzy
        public zzq zzb() {
            zzq zzqVarZzc = zzq.zzc(this.zzd);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zzc", "zzd", zzq.zze(), "zze"});
            }
            if (iOrdinal == 3) {
                return new zzx();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzf;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzx> zzifxVar = zzg;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzx.class) {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzy
        public List<Integer> zze() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzy
        public int zzf() {
            return this.zze.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzy
        public int zzg(int i) {
            return this.zze.zzf(i);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public interface zzy extends zzifq {
        boolean zza();

        zzq zzb();

        List<Integer> zze();

        int zzf();

        int zzg(int i);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
    public final class zzz extends zziee<zzz, zza> implements zzaa {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        private static final zzz zzj;
        private static volatile zzifx<zzz> zzk;
        private int zze;
        private zzv zzf;
        private zzieq<zzan> zzg = zzbM();
        private int zzh;
        private zzap zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
        public final class zza extends zzidy<zzz, zza> implements zzaa {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(byte[] bArr) {
                this();
            }

            public zza zzA(zzap zzapVar) {
                zzbg();
                ((zzz) this.zza).zzO(zzapVar);
                return this;
            }

            public zza zzB() {
                zzbg();
                ((zzz) this.zza).zzP();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public boolean zza() {
                return ((zzz) this.zza).zza();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public zzv zzb() {
                return ((zzz) this.zza).zzb();
            }

            public zza zzc(zzv zzvVar) {
                zzbg();
                ((zzz) this.zza).zzC(zzvVar);
                return this;
            }

            public zza zzd(zzv.zza zzaVar) {
                zzbg();
                ((zzz) this.zza).zzC(zzaVar.zzbu());
                return this;
            }

            public zza zze(zzv zzvVar) {
                zzbg();
                ((zzz) this.zza).zzD(zzvVar);
                return this;
            }

            public zza zzf() {
                zzbg();
                ((zzz) this.zza).zzE();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public List<zzan> zzg() {
                return Collections.unmodifiableList(((zzz) this.zza).zzg());
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public int zzh() {
                return ((zzz) this.zza).zzh();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public zzan zzi(int i) {
                return ((zzz) this.zza).zzi(i);
            }

            public zza zzj(int i, zzan zzanVar) {
                zzbg();
                ((zzz) this.zza).zzF(i, zzanVar);
                return this;
            }

            public zza zzk(int i, zzan.zza zzaVar) {
                zzbg();
                ((zzz) this.zza).zzF(i, zzaVar.zzbu());
                return this;
            }

            public zza zzl(zzan zzanVar) {
                zzbg();
                ((zzz) this.zza).zzG(zzanVar);
                return this;
            }

            public zza zzm(int i, zzan zzanVar) {
                zzbg();
                ((zzz) this.zza).zzH(i, zzanVar);
                return this;
            }

            public zza zzn(zzan.zza zzaVar) {
                zzbg();
                ((zzz) this.zza).zzG(zzaVar.zzbu());
                return this;
            }

            public zza zzo(int i, zzan.zza zzaVar) {
                zzbg();
                ((zzz) this.zza).zzH(i, zzaVar.zzbu());
                return this;
            }

            public zza zzp(Iterable<? extends zzan> iterable) {
                zzbg();
                ((zzz) this.zza).zzI(iterable);
                return this;
            }

            public zza zzq() {
                zzbg();
                ((zzz) this.zza).zzJ();
                return this;
            }

            public zza zzr(int i) {
                zzbg();
                ((zzz) this.zza).zzK(i);
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public boolean zzs() {
                return ((zzz) this.zza).zzs();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public zzq zzt() {
                return ((zzz) this.zza).zzt();
            }

            public zza zzu(zzq zzqVar) {
                zzbg();
                ((zzz) this.zza).zzL(zzqVar);
                return this;
            }

            public zza zzv() {
                zzbg();
                ((zzz) this.zza).zzM();
                return this;
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public boolean zzw() {
                return ((zzz) this.zza).zzw();
            }

            @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
            public zzap zzx() {
                return ((zzz) this.zza).zzx();
            }

            public zza zzy(zzap zzapVar) {
                zzbg();
                ((zzz) this.zza).zzN(zzapVar);
                return this;
            }

            public zza zzz(zzap.zza zzaVar) {
                zzbg();
                ((zzz) this.zza).zzN(zzaVar.zzbu());
                return this;
            }
        }

        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zziee.zzbu(zzz.class, zzzVar);
        }

        private zzz() {
        }

        public static zzz zzA() {
            return zzj;
        }

        public static zzifx<zzz> zzB() {
            return zzj.zzbd();
        }

        /* JADX INFO: renamed from: zzR */
        public void zzC(zzv zzvVar) {
            zzvVar.getClass();
            this.zzf = zzvVar;
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzS */
        public void zzD(zzv zzvVar) {
            zzvVar.getClass();
            zzv zzvVar2 = this.zzf;
            if (zzvVar2 != null && zzvVar2 != zzv.zzz()) {
                zzv.zza zzaVarZzy = zzv.zzy(zzvVar2);
                zzaVarZzy.zzbo(zzvVar);
                zzvVar = zzaVarZzy.zzbt();
            }
            this.zzf = zzvVar;
            this.zze |= 1;
        }

        /* JADX INFO: renamed from: zzT */
        public void zzE() {
            this.zzf = null;
            this.zze &= -2;
        }

        private void zzU() {
            zzieq<zzan> zzieqVar = this.zzg;
            if (zzieqVar.zza()) {
                return;
            }
            this.zzg = zziee.zzbN(zzieqVar);
        }

        /* JADX INFO: renamed from: zzV */
        public void zzF(int i, zzan zzanVar) {
            zzanVar.getClass();
            zzU();
            this.zzg.set(i, zzanVar);
        }

        /* JADX INFO: renamed from: zzW */
        public void zzG(zzan zzanVar) {
            zzanVar.getClass();
            zzU();
            this.zzg.add(zzanVar);
        }

        /* JADX INFO: renamed from: zzX */
        public void zzH(int i, zzan zzanVar) {
            zzanVar.getClass();
            zzU();
            this.zzg.add(i, zzanVar);
        }

        /* JADX INFO: renamed from: zzY */
        public void zzI(Iterable<? extends zzan> iterable) {
            zzU();
            zzicj.zzaW(iterable, this.zzg);
        }

        /* JADX INFO: renamed from: zzZ */
        public void zzJ() {
            this.zzg = zzbM();
        }

        /* JADX INFO: renamed from: zzaa */
        public void zzK(int i) {
            zzU();
            this.zzg.remove(i);
        }

        /* JADX INFO: renamed from: zzab */
        public void zzL(zzq zzqVar) {
            this.zzh = zzqVar.zza();
            this.zze |= 2;
        }

        /* JADX INFO: renamed from: zzac */
        public void zzM() {
            this.zze &= -3;
            this.zzh = 0;
        }

        /* JADX INFO: renamed from: zzad */
        public void zzN(zzap zzapVar) {
            zzapVar.getClass();
            this.zzi = zzapVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzae */
        public void zzO(zzap zzapVar) {
            zzapVar.getClass();
            zzap zzapVar2 = this.zzi;
            if (zzapVar2 != null && zzapVar2 != zzap.zzs()) {
                zzap.zza zzaVarZzr = zzap.zzr(zzapVar2);
                zzaVarZzr.zzbo(zzapVar);
                zzapVar = zzaVarZzr.zzbt();
            }
            this.zzi = zzapVar;
            this.zze |= 4;
        }

        /* JADX INFO: renamed from: zzaf */
        public void zzP() {
            this.zzi = null;
            this.zze &= -5;
        }

        public static zzz zze(ByteBuffer byteBuffer) throws zziet {
            return (zzz) zziee.zzbR(zzj, byteBuffer);
        }

        public static zzz zzj(ByteBuffer byteBuffer, zzido zzidoVar) throws zziet {
            return (zzz) zziee.zzbQ(zzj, byteBuffer, zzidoVar);
        }

        public static zzz zzk(zzida zzidaVar) throws zziet {
            return (zzz) zziee.zzbS(zzj, zzidaVar);
        }

        public static zzz zzl(zzida zzidaVar, zzido zzidoVar) throws zziet {
            return (zzz) zziee.zzbT(zzj, zzidaVar, zzidoVar);
        }

        public static zzz zzm(byte[] bArr) throws zziet {
            return (zzz) zziee.zzbU(zzj, bArr);
        }

        public static zzz zzn(byte[] bArr, zzido zzidoVar) throws zziet {
            return (zzz) zziee.zzbV(zzj, bArr, zzidoVar);
        }

        public static zzz zzo(InputStream inputStream) throws IOException {
            return (zzz) zziee.zzbW(zzj, inputStream);
        }

        public static zzz zzp(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzz) zziee.zzbX(zzj, inputStream, zzidoVar);
        }

        public static zzz zzq(InputStream inputStream) throws IOException {
            return (zzz) zzca(zzj, inputStream);
        }

        public static zzz zzr(InputStream inputStream, zzido zzidoVar) throws IOException {
            return (zzz) zzcb(zzj, inputStream, zzidoVar);
        }

        public static zzz zzu(zzide zzideVar) throws IOException {
            return (zzz) zziee.zzbY(zzj, zzideVar);
        }

        public static zzz zzv(zzide zzideVar, zzido zzidoVar) throws IOException {
            return (zzz) zziee.zzbZ(zzj, zzideVar, zzidoVar);
        }

        public static zza zzy() {
            return (zza) zzj.zzbn();
        }

        public static zza zzz(zzz zzzVar) {
            return (zza) zzj.zzbo(zzzVar);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public boolean zza() {
            return (this.zze & 1) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public zzv zzb() {
            zzv zzvVar = this.zzf;
            return zzvVar == null ? zzv.zzz() : zzvVar;
        }

        public List<? extends zzao> zzc() {
            return this.zzg;
        }

        public zzao zzd(int i) {
            return this.zzg.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zziee
        protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
            zzifx zzidzVar;
            int iOrdinal = zziedVar.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            if (iOrdinal == 2) {
                return zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzan.class, "zzh", zzq.zze(), "zzi"});
            }
            if (iOrdinal == 3) {
                return new zzz();
            }
            if (iOrdinal == 4) {
                return new zza(null);
            }
            if (iOrdinal == 5) {
                return zzj;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            zzifx<zzz> zzifxVar = zzk;
            if (zzifxVar != null) {
                return zzifxVar;
            }
            synchronized (zzz.class) {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            }
            return zzidzVar;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public List<zzan> zzg() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public int zzh() {
            return this.zzg.size();
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public zzan zzi(int i) {
            return this.zzg.get(i);
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public boolean zzs() {
            return (this.zze & 2) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public zzq zzt() {
            zzq zzqVarZzc = zzq.zzc(this.zzh);
            return zzqVarZzc == null ? zzq.ENUM_FALSE : zzqVarZzc;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public boolean zzw() {
            return (this.zze & 4) != 0;
        }

        @Override // com.google.android.gms.internal.ads.zzbhv.zzaa
        public zzap zzx() {
            zzap zzapVar = this.zzi;
            return zzapVar == null ? zzap.zzs() : zzapVar;
        }
    }

    private zzbhv() {
    }

    public static void zza(zzido zzidoVar) {
    }
}
