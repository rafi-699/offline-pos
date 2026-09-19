package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzikn extends zziee implements zzifq {
    private static final zzikn zzR;
    private static volatile zzifx zzS;
    private zzikj zzA;
    private zziip zzC;
    private zziih zzE;
    private zziji zzG;
    private int zzH;
    private long zzK;
    private zzikm zzL;
    private zzijn zzM;
    private zzikg zzO;
    private int zza;
    private int zzb;
    private int zzc;
    private zziil zzg;
    private zzijt zzk;
    private boolean zzl;
    private boolean zzo;
    private boolean zzp;
    private zzika zzv;
    private boolean zzw;
    private byte zzQ = 2;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private zzieq zzh = zzbM();
    private zzieq zzi = zzbM();
    private String zzj = "";
    private zzieq zzm = zzbM();
    private String zzn = "";
    private zzida zzu = zzida.zza;
    private String zzx = "";
    private zzieq zzy = zzbM();
    private zzieq zzz = zzbM();
    private zzieq zzB = zzbM();
    private String zzD = "";
    private zzieq zzF = zzbM();
    private zzieq zzI = zzbM();
    private zzieq zzJ = zzbM();
    private String zzN = "";
    private zzieq zzP = zzbM();

    static {
        zzikn zziknVar = new zzikn();
        zzR = zziknVar;
        zziee.zzbu(zzikn.class, zziknVar);
    }

    private zzikn() {
    }

    public static zziij zzg() {
        return (zziij) zzR.zzbn();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final List zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        byte[] bArr = null;
        switch (zziedVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzQ);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzQ = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbv(zzR, "\u0001%\u0000\u0001\u0001%%\u0000\n\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019$ဉ\u001a%\u001b", new Object[]{"zza", "zzd", "zze", "zzf", "zzh", zzijy.class, "zzl", "zzm", "zzn", "zzo", "zzp", "zzb", zziju.zza, "zzc", zziii.zza, "zzg", "zzj", "zzk", "zzu", "zzi", zzikr.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", zzikx.class, "zzC", "zzD", "zzE", "zzF", zziit.class, "zzG", "zzH", zzikh.zza, "zzI", zzijl.class, "zzJ", zzijq.class, "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", zzikd.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzikn();
            case NEW_BUILDER:
                return new zziij(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzR;
            case GET_PARSER:
                zzifx zzifxVar = zzS;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zzikn.class) {
                    zzidzVar = zzS;
                    if (zzidzVar == null) {
                        zzidzVar = new zzidz(zzR);
                        zzS = zzidzVar;
                    }
                    break;
                }
                return zzidzVar;
            default:
                throw null;
        }
    }

    public final String zze() {
        return this.zzj;
    }

    final /* synthetic */ void zzh(String str) {
        this.zza |= 4;
        this.zzd = str;
    }

    final /* synthetic */ void zzi(String str) {
        this.zza |= 8;
        this.zze = str;
    }

    final /* synthetic */ void zzj(zziil zziilVar) {
        zziilVar.getClass();
        this.zzg = zziilVar;
        this.zza |= 32;
    }

    final /* synthetic */ void zzk(zzijy zzijyVar) {
        zzijyVar.getClass();
        zzieq zzieqVar = this.zzh;
        if (!zzieqVar.zza()) {
            this.zzh = zziee.zzbN(zzieqVar);
        }
        this.zzh.add(zzijyVar);
    }

    final /* synthetic */ void zzl(String str) {
        this.zza |= 64;
        this.zzj = str;
    }

    final /* synthetic */ void zzm() {
        this.zza &= -65;
        this.zzj = zzR.zzj;
    }

    final /* synthetic */ void zzn(zzijt zzijtVar) {
        zzijtVar.getClass();
        this.zzk = zzijtVar;
        this.zza |= 128;
    }

    final /* synthetic */ void zzo(zzika zzikaVar) {
        zzikaVar.getClass();
        this.zzv = zzikaVar;
        this.zza |= 8192;
    }

    final /* synthetic */ void zzp(Iterable iterable) {
        zzieq zzieqVar = this.zzy;
        if (!zzieqVar.zza()) {
            this.zzy = zziee.zzbN(zzieqVar);
        }
        zzicj.zzaW(iterable, this.zzy);
    }

    final /* synthetic */ void zzq(Iterable iterable) {
        zzieq zzieqVar = this.zzz;
        if (!zzieqVar.zza()) {
            this.zzz = zziee.zzbN(zzieqVar);
        }
        zzicj.zzaW(iterable, this.zzz);
    }

    final /* synthetic */ void zzs(int i) {
        this.zzb = i - 1;
        this.zza |= 1;
    }
}
