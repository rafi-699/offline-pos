package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaym extends zziee implements zzifq {
    private static final zzaym zzbo;
    private static volatile zzifx zzbp;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzH;
    private long zzI;
    private long zzJ;
    private long zzL;
    private zzayo zzO;
    private int zza;
    private zzayh zzaF;
    private zzayf zzaG;
    private long zzaM;
    private long zzaN;
    private long zzaQ;
    private zzaxw zzaR;
    private zzaxy zzaS;
    private int zzaV;
    private zzayj zzag;
    private zzayl zzai;
    private int zzat;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzazd zzax;
    private int zzb;
    private int zzba;
    private zzaxu zzbb;
    private boolean zzbc;
    private long zzbd;
    private boolean zzbg;
    private long zzbi;
    private zzazb zzbj;
    private int zzc;
    private int zzd;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zze = "";
    private String zzf = "";
    private String zzu = "";
    private String zzE = "";
    private String zzF = "D";
    private String zzG = "";
    private String zzK = "";
    private long zzM = -1;
    private long zzN = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private String zzV = "D";
    private String zzW = "D";
    private long zzX = -1;
    private int zzY = 1000;
    private int zzZ = 1000;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private int zzaf = 1000;
    private zzieq zzah = zzbM();
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private String zzar = "D";
    private long zzas = -1;
    private long zzay = -1;
    private int zzaz = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzieq zzaC = zzbM();
    private int zzaD = 1000;
    private zzieq zzaE = zzbM();
    private String zzaH = "";
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL = -1;
    private long zzaO = -1;
    private String zzaP = "";
    private long zzaT = -1;
    private long zzaU = -1;
    private String zzaW = "";
    private String zzaX = "";
    private long zzaY = -1;
    private long zzaZ = -1;
    private String zzbe = "";
    private int zzbf = 2;
    private String zzbh = "";
    private long zzbk = -1;
    private String zzbl = "";
    private zziem zzbm = zzbC();
    private long zzbn = -1;

    static {
        zzaym zzaymVar = new zzaym();
        zzbo = zzaymVar;
        zziee.zzbu(zzaym.class, zzaymVar);
    }

    private zzaym() {
    }

    public static zzaym zzi(byte[] bArr, zzido zzidoVar) throws zziet {
        return (zzaym) zziee.zzbV(zzbo, bArr, zzidoVar);
    }

    public static zzaxm zzj() {
        return (zzaxm) zzbo.zzbn();
    }

    public static zzaym zzk() {
        return zzbo;
    }

    final /* synthetic */ void zzA(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzG = str;
    }

    final /* synthetic */ void zzB(long j) {
        this.zza |= 33554432;
        this.zzH = j;
    }

    final /* synthetic */ void zzC(long j) {
        this.zza |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.zzI = j;
    }

    final /* synthetic */ void zzD(long j) {
        this.zza |= 134217728;
        this.zzJ = j;
    }

    final /* synthetic */ void zzE(String str) {
        str.getClass();
        this.zza |= 268435456;
        this.zzK = str;
    }

    final /* synthetic */ void zzF(long j) {
        this.zza |= 536870912;
        this.zzL = j;
    }

    final /* synthetic */ void zzG(long j) {
        this.zza |= 1073741824;
        this.zzM = j;
    }

    final /* synthetic */ void zzH(long j) {
        this.zza |= Integer.MIN_VALUE;
        this.zzN = j;
    }

    final /* synthetic */ void zzI(long j) {
        this.zzb |= 2;
        this.zzP = j;
    }

    final /* synthetic */ void zzJ(long j) {
        this.zzb |= 4;
        this.zzQ = j;
    }

    final /* synthetic */ void zzK(long j) {
        this.zzb |= 8;
        this.zzR = j;
    }

    final /* synthetic */ void zzL(long j) {
        this.zzb |= 16;
        this.zzS = j;
    }

    final /* synthetic */ void zzM(long j) {
        this.zzb |= 32;
        this.zzT = j;
    }

    final /* synthetic */ void zzN(long j) {
        this.zzb |= 64;
        this.zzU = j;
    }

    final /* synthetic */ void zzO(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzV = str;
    }

    final /* synthetic */ void zzP(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzW = str;
    }

    final /* synthetic */ void zzQ(long j) {
        this.zzb |= 4096;
        this.zzaa = j;
    }

    final /* synthetic */ void zzR(long j) {
        this.zzb |= 8192;
        this.zzab = j;
    }

    final /* synthetic */ void zzS(long j) {
        this.zzb |= 16384;
        this.zzac = j;
    }

    final /* synthetic */ void zzT(zzayj zzayjVar) {
        zzayjVar.getClass();
        this.zzag = zzayjVar;
        this.zzb |= 262144;
    }

    final /* synthetic */ void zzU(zzayj zzayjVar) {
        zzayjVar.getClass();
        zzieq zzieqVar = this.zzah;
        if (!zzieqVar.zza()) {
            this.zzah = zziee.zzbN(zzieqVar);
        }
        this.zzah.add(zzayjVar);
    }

    final /* synthetic */ void zzV() {
        this.zzah = zzbM();
    }

    final /* synthetic */ void zzW(zzayl zzaylVar) {
        zzaylVar.getClass();
        this.zzai = zzaylVar;
        this.zzb |= 524288;
    }

    final /* synthetic */ void zzX(long j) {
        this.zzb |= 1048576;
        this.zzaj = j;
    }

    final /* synthetic */ void zzY(long j) {
        this.zzb |= 2097152;
        this.zzak = j;
    }

    final /* synthetic */ void zzZ(long j) {
        this.zzb |= 4194304;
        this.zzal = j;
    }

    public final boolean zza() {
        return (this.zza & 4194304) != 0;
    }

    final /* synthetic */ void zzaa(long j) {
        this.zzb |= 8388608;
        this.zzam = j;
    }

    final /* synthetic */ void zzab(long j) {
        this.zzb |= 16777216;
        this.zzan = j;
    }

    final /* synthetic */ void zzac(long j) {
        this.zzb |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.zzap = j;
    }

    final /* synthetic */ void zzad(long j) {
        this.zzb |= 134217728;
        this.zzaq = j;
    }

    final /* synthetic */ void zzae(String str) {
        str.getClass();
        this.zzb |= 268435456;
        this.zzar = str;
    }

    final /* synthetic */ void zzaf(String str) {
        str.getClass();
        this.zzc |= 1024;
        this.zzaH = str;
    }

    final /* synthetic */ void zzag(long j) {
        this.zzc |= 2048;
        this.zzaI = j;
    }

    final /* synthetic */ void zzah(long j) {
        this.zzc |= 4096;
        this.zzaJ = j;
    }

    final /* synthetic */ void zzai(long j) {
        this.zzc |= 8192;
        this.zzaK = j;
    }

    final /* synthetic */ void zzaj(long j) {
        this.zzc |= 16384;
        this.zzaL = j;
    }

    final /* synthetic */ void zzak(String str) {
        str.getClass();
        this.zzc |= 262144;
        this.zzaP = str;
    }

    final /* synthetic */ void zzal(long j) {
        this.zzc |= 8388608;
        this.zzaU = j;
    }

    final /* synthetic */ void zzam(long j) {
        this.zzd |= 32;
        this.zzbi = j;
    }

    final /* synthetic */ void zzan(zzazb zzazbVar) {
        zzazbVar.getClass();
        this.zzbj = zzazbVar;
        this.zzd |= 64;
    }

    final /* synthetic */ void zzap(int i) {
        this.zzY = i - 1;
        this.zzb |= 1024;
    }

    final /* synthetic */ void zzaq(int i) {
        this.zzZ = i - 1;
        this.zzb |= 2048;
    }

    final /* synthetic */ void zzar(int i) {
        this.zzaf = i - 1;
        this.zzb |= 131072;
    }

    final /* synthetic */ void zzas(int i) {
        this.zzaz = i - 1;
        this.zzc |= 16;
    }

    final /* synthetic */ void zzat(int i) {
        this.zzaA = i - 1;
        this.zzc |= 32;
    }

    final /* synthetic */ void zzau(int i) {
        this.zzaV = i - 1;
        this.zzc |= 16777216;
    }

    public final String zzb() {
        return this.zzE;
    }

    public final boolean zzc() {
        return (this.zzb & 1048576) != 0;
    }

    public final long zzd() {
        return this.zzaj;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziek zziekVar = zzaxq.zza;
            zziek zziekVar2 = zzayw.zza;
            return zzbv(zzbo, "\u0001n\u0000\u0004\u0001Įn\u0000\u0004\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ`\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈa\u0019ဂe\u001a᠌b\u001bဈ\u0016\u001cဇc\u001dဈ\u0018\u001eဈd\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉT[ဉU\\ဂV]ဂW^᠌X_᠌@`ဉIaဂPbဈYcဈZdဂ[eဂ\\f᠌]gဂShဉ^iဇ_j'kဂiÉဉfĭဂgĮဈh", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzbd", "zzC", "zzD", "zzbe", "zzbi", "zzbf", zziekVar, "zzE", "zzbg", "zzG", "zzbh", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzah", zzayj.class, "zzT", "zzU", "zzV", "zzW", "zzY", zziekVar2, "zzZ", zziekVar2, "zzag", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", zziekVar2, "zzai", "zzaj", "zzak", "zzal", "zzam", "zzap", "zzaq", "zzas", "zzat", zzayv.zza, "zzau", zzayz.zza, "zzar", "zzaw", zzaxn.zza, "zzax", "zzay", "zzan", "zzao", "zzaz", zziekVar2, "zzX", "zzF", "zzaA", zziekVar2, "zzaB", "zzaC", zzayd.class, "zzaD", zziekVar2, "zzaE", zzaxp.class, "zzaF", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaR", "zzaS", "zzaT", "zzaU", "zzaV", zzaxz.zza, "zzav", zzaxr.zza, "zzaG", "zzaN", "zzaW", "zzaX", "zzaY", "zzaZ", "zzba", zzayb.zza, "zzaQ", "zzbb", "zzbc", "zzbm", "zzbn", "zzbj", "zzbk", "zzbl"});
        }
        if (iOrdinal == 3) {
            return new zzaym();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaxm(bArr);
        }
        if (iOrdinal == 5) {
            return zzbo;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzbp;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzaym.class) {
            zzidzVar = zzbp;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzbo);
                zzbp = zzidzVar;
            }
        }
        return zzidzVar;
    }

    public final long zze() {
        return this.zzan;
    }

    public final boolean zzg() {
        return (this.zzd & 64) != 0;
    }

    public final zzazb zzh() {
        zzazb zzazbVar = this.zzbj;
        return zzazbVar == null ? zzazb.zze() : zzazbVar;
    }

    final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzm(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 4;
        this.zzg = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzi = j;
    }

    final /* synthetic */ void zzp(long j) {
        this.zza |= 32;
        this.zzj = j;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza |= 1024;
        this.zzo = j;
    }

    final /* synthetic */ void zzr(long j) {
        this.zza |= 2048;
        this.zzp = j;
    }

    final /* synthetic */ void zzs(long j) {
        this.zza |= 8192;
        this.zzv = j;
    }

    final /* synthetic */ void zzt(long j) {
        this.zza |= 16384;
        this.zzw = j;
    }

    final /* synthetic */ void zzu(long j) {
        this.zza |= 32768;
        this.zzx = j;
    }

    final /* synthetic */ void zzv(long j) {
        this.zza |= 65536;
        this.zzy = j;
    }

    final /* synthetic */ void zzw(long j) {
        this.zza |= 524288;
        this.zzB = j;
    }

    final /* synthetic */ void zzx(long j) {
        this.zza |= 1048576;
        this.zzC = j;
    }

    final /* synthetic */ void zzy(long j) {
        this.zza |= 2097152;
        this.zzD = j;
    }

    final /* synthetic */ void zzz(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzE = str;
    }
}
