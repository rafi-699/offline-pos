package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzheb implements zzhec {
    private final List zza;
    private final Map zzb;

    @Nullable
    private final zzheb zzc;

    private zzheb(List list, Map map) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = map;
        if (zzhkp.zza.zza()) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            boolean zZzd = false;
            while (it.hasNext()) {
                zzhdz zzhdzVar = (zzhdz) it.next();
                if (hashSet.contains(Integer.valueOf(zzhdzVar.zzc()))) {
                    int iZzc = zzhdzVar.zzc();
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + Imgproc.COLOR_YUV2RGBA_YVYU);
                    sb.append("KeyID ");
                    sb.append(iZzc);
                    sb.append(" is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                    throw new GeneralSecurityException(sb.toString());
                }
                hashSet.add(Integer.valueOf(zzhdzVar.zzc()));
                zZzd |= zzhdzVar.zzd();
            }
            if (!zZzd) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        this.zzc = null;
    }

    private zzheb(List list, Map map, zzheb zzhebVar) {
        this.zza = list;
        this.zzb = map;
        this.zzc = zzhebVar;
    }

    /* synthetic */ zzheb(List list, Map map, byte[] bArr) {
        this(list, map);
    }

    static final zzheb zza(zzhsz zzhszVar) throws GeneralSecurityException {
        if (zzhszVar == null || zzhszVar.zzc() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzheb(zzj(zzhszVar), new HashMap());
    }

    public static final zzheb zzg(zzheh zzhehVar) throws GeneralSecurityException {
        zzhdw zzhdwVar = new zzhdw();
        zzhdu zzhduVar = new zzhdu(zzhehVar, null);
        zzhduVar.zzb();
        zzhduVar.zza();
        zzhdwVar.zza(zzhduVar);
        return zzhdwVar.zzb();
    }

    static /* synthetic */ zzheb zzi(final zzheb zzhebVar) {
        final zzhmc zzhmcVar = (zzhmc) zzhebVar.zzf(zzhmc.class);
        if (zzhmcVar == null) {
            return zzhebVar;
        }
        zzhdx zzhdxVar = new zzhdx() { // from class: com.google.android.gms.internal.ads.zzhea
            @Override // com.google.android.gms.internal.ads.zzhdx
            public final /* synthetic */ void zza(zzhdz zzhdzVar) {
                zzhmm.zza().zzb().zza(this.zza, zzhmcVar, "keyset_handle", "get_key");
            }
        };
        List<zzhdz> list = zzhebVar.zza;
        ArrayList arrayList = new ArrayList(list.size());
        for (zzhdz zzhdzVar : list) {
            arrayList.add(new zzhdz(zzhdzVar.zzf(), zzhdzVar.zzj(), zzhdzVar.zzg(), zzhdzVar.zzh(), zzhdzVar.zzi(), zzhdxVar, null));
        }
        return new zzheb(arrayList, zzhebVar.zzb, zzhebVar);
    }

    private static List zzj(zzhsz zzhszVar) throws GeneralSecurityException {
        zzhdq zzhlzVar;
        boolean z;
        ArrayList arrayList = new ArrayList(zzhszVar.zzc());
        for (zzhsy zzhsyVar : zzhszVar.zzb()) {
            int iZzc = zzhsyVar.zzc();
            try {
                zzhnm zzhnmVarZzl = zzl(zzhsyVar);
                zzhmr zzhmrVarZza = zzhmr.zza();
                zzhel zzhelVarZza = zzhel.zza();
                zzhlzVar = !zzhmrVarZza.zzf(zzhnmVarZzl) ? new zzhlz(zzhnmVarZzl, zzhelVarZza) : zzhmrVarZza.zzg(zzhnmVarZzl, zzhelVarZza);
                z = false;
            } catch (GeneralSecurityException e) {
                if (zzhkp.zza.zza()) {
                    throw e;
                }
                zzhlzVar = new zzhlz(zzl(zzhsyVar), zzhel.zza());
                z = true;
            }
            if (zzhkp.zza.zza() && !zzm(zzhsyVar.zzk())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            boolean z2 = false;
            int iZzk = zzhsyVar.zzk();
            if (iZzc == zzhszVar.zza()) {
                z2 = true;
            }
            arrayList.add(new zzhdz(zzhlzVar, iZzk, iZzc, z2, z, zzhdz.zza, null));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private final zzheb zzk() {
        zzheb zzhebVar = this.zzc;
        return zzhebVar == null ? this : zzhebVar;
    }

    private static zzhnm zzl(zzhsy zzhsyVar) throws GeneralSecurityException {
        return zzhnm.zza(zzhsyVar.zzb().zza(), zzhsyVar.zzb().zzb(), zzhsyVar.zzb().zzc(), zzhsyVar.zzd(), zzhsyVar.zzd() == zzhtm.RAW ? null : Integer.valueOf(zzhsyVar.zzc()));
    }

    private static boolean zzm(int i) {
        int i2 = i - 2;
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    public final String toString() {
        zzhsz zzhszVarZzb = zzb();
        int i = zzheo.zza;
        zzhta zzhtaVarZza = zzhtd.zza();
        zzhtaVarZza.zza(zzhszVarZzb.zza());
        for (zzhsy zzhsyVar : zzhszVarZzb.zzb()) {
            zzhtb zzhtbVarZza = zzhtc.zza();
            zzhtbVarZza.zza(zzhsyVar.zzb().zza());
            zzhtbVarZza.zzd(zzhsyVar.zzk());
            zzhtbVarZza.zzc(zzhsyVar.zzd());
            zzhtbVarZza.zzb(zzhsyVar.zzc());
            zzhtaVarZza.zzb((zzhtc) zzhtbVarZza.zzbu());
        }
        return ((zzhtd) zzhtaVarZza.zzbu()).toString();
    }

    final zzhsz zzb() {
        try {
            zzhsw zzhswVarZzh = zzhsz.zzh();
            for (zzhdz zzhdzVar : this.zza) {
                zzhdq zzhdqVarZza = zzhdzVar.zza();
                int iZzj = zzhdzVar.zzj();
                int iZzc = zzhdzVar.zzc();
                zzhnm zzhnmVar = (zzhnm) zzhmr.zza().zzh(zzhdqVarZza, zzhnm.class, zzhel.zza());
                Integer numZzb = zzhdqVarZza.zzb();
                if (numZzb != null && numZzb.intValue() != iZzc) {
                    throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                }
                zzhsx zzhsxVarZze = zzhsy.zze();
                zzhso zzhsoVarZzd = zzhsq.zzd();
                zzhsoVarZzd.zza(zzhnmVar.zzg());
                zzhsoVarZzd.zzb(zzhnmVar.zzb());
                zzhsoVarZzd.zzc(zzhnmVar.zzc());
                zzhsxVarZze.zzb(zzhsoVarZzd);
                zzhsxVarZze.zze(iZzj);
                zzhsxVarZze.zzc(iZzc);
                zzhsxVarZze.zzd(zzhnmVar.zzd());
                zzhswVarZzh.zzb((zzhsy) zzhsxVarZze.zzbu());
                if (zzhdzVar.zzd()) {
                    zzhswVarZzh.zza(zzhdzVar.zzc());
                }
            }
            return (zzhsz) zzhswVarZzh.zzbu();
        } catch (GeneralSecurityException e) {
            throw new zzhny(e);
        }
    }

    public final zzhdz zzc() {
        for (zzhdz zzhdzVar : this.zza) {
            if (zzhdzVar != null && zzhdzVar.zzd()) {
                if (zzhdzVar.zzb() == zzhds.zza) {
                    return zzhdzVar;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    @Override // com.google.android.gms.internal.ads.zzhec
    public final int zzd() {
        return this.zza.size();
    }

    public final zzhdz zze(int i) {
        if (i < 0 || i >= zzd()) {
            int iZzd = zzd();
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34 + String.valueOf(iZzd).length());
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(" for keyset of size ");
            sb.append(iZzd);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        List list = this.zza;
        zzhdz zzhdzVar = (zzhdz) list.get(i);
        if (!zzm(zzhdzVar.zzj())) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 42);
            sb2.append("Keyset-Entry at position ");
            sb2.append(i);
            sb2.append(" has wrong status");
            throw new IllegalStateException(sb2.toString());
        }
        if (!zzhdzVar.zzi()) {
            return (zzhdz) list.get(i);
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 48);
        sb3.append("Keyset-Entry at position ");
        sb3.append(i);
        sb3.append(" didn't parse correctly");
        throw new IllegalStateException(sb3.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhec
    @Nullable
    public final zzhdj zzf(Class cls) {
        return (zzhdj) this.zzb.get(cls);
    }

    public final Object zzh(zzhdn zzhdnVar, Class cls) throws GeneralSecurityException {
        zzhsz zzhszVarZzb = zzk().zzb();
        int i = zzheo.zza;
        int iZza = zzhszVarZzb.zza();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzhsy zzhsyVar : zzhszVarZzb.zzb()) {
            if (zzhsyVar.zzk() == 3) {
                if (!zzhsyVar.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzd() == zzhtm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzhsyVar.zzc())));
                }
                if (zzhsyVar.zzc() == iZza) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzhsyVar.zzb().zzc() == zzhsp.ASYMMETRIC_PUBLIC;
                i2++;
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        for (int i3 = 0; i3 < zzd(); i3++) {
            List list = this.zza;
            if (((zzhdz) list.get(i3)).zzi() || !zzm(((zzhdz) list.get(i3)).zzj())) {
                String strZza = zzhszVarZzb.zzd(i3).zzb().zza();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 44 + String.valueOf(strZza).length() + 32);
                sb.append("Key parsing of key with index ");
                sb.append(i3);
                sb.append(" and type_url ");
                sb.append(strZza);
                sb.append(" failed, unable to get primitive");
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhdnVar.zza(zzk(), cls);
    }
}
