package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbcg extends zzbdf {
    private static final zzbdg zzh = new zzbdg();
    private final zzaxf zzi;
    private final Context zzj;
    private final zzazm zzk;

    public zzbcg(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, Context context, zzawy zzawyVar, zzaxf zzaxfVar, zzazm zzazmVar) {
        super(zzbbsVar, "Y4Si1UCd8xFA1yCw6ohazV+GUSwhVa9ffV9ZnN++nWMAkqLsgU7cmmd4wBpbGVgj", "1k+Az7ZOHMkdpE7lGA2cF/gUEsamDqjjLqQDV0dmR3A=", zzaxmVar, i, 27);
        this.zzj = context;
        this.zzi = zzaxfVar;
        this.zzk = zzazmVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzazj zzc() throws IllegalAccessException, InvocationTargetException {
        String str;
        zzbih zzbihVar = zzbiq.zzdE;
        int iZzb = (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue() <= 0 || ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue() >= this.zzi.zzb()) ? this.zzi.zzb() : ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue();
        zzazj zzazjVar = new zzazj((String) this.zze.invoke(null, this.zzj, false, ""));
        zzazm zzazmVar = this.zzk;
        if (zzazmVar == null || zzazmVar.zza() == null) {
            str = ExifInterface.LONGITUDE_EAST;
        } else {
            try {
                str = (String) zzazmVar.zza().get(iZzb, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = ExifInterface.LONGITUDE_EAST;
            }
        }
        zzazjVar.zza = str;
        return zzazjVar;
    }

    private final String zzd() {
        try {
            zzbbs zzbbsVar = this.zza;
            if (zzbbsVar.zzm() != null) {
                zzbbsVar.zzm().get();
            }
            zzaym zzaymVarZzl = zzbbsVar.zzl();
            if (zzaymVarZzl == null || !zzaymVarZzl.zza()) {
                return null;
            }
            return zzaymVarZzl.zzb();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzazj zzazjVarZzc;
        zzazj zzazjVar;
        zzbdg zzbdgVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzbdgVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            zzazj zzazjVar2 = (zzazj) atomicReferenceZza.get();
            if (zzazjVar2 == null || zzbbv.zzc(zzazjVar2.zza) || zzazjVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzazjVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (zzbbv.zzc(null)) {
                    (!zzbbv.zzc(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                if (this.zzk != null) {
                    zzazjVarZzc = zzc();
                } else {
                    if (i == 3 && !this.zzi.zza()) {
                        z = true;
                    }
                    Boolean boolValueOf = Boolean.valueOf(z);
                    Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdq);
                    String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdp)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzi() && zzbbv.zzc(strZzb)) {
                        strZzb = zzd();
                    }
                    zzazj zzazjVar3 = new zzazj((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                    String str = zzazjVar3.zza;
                    if (zzbbv.zzc(str) || str.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String strZzd = zzd();
                            if (!zzbbv.zzc(strZzd)) {
                                zzazjVar3.zza = strZzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzazjVarZzc = zzazjVar3;
                }
                atomicReferenceZza.set(zzazjVarZzc);
            }
            zzazjVar = (zzazj) atomicReferenceZza.get();
        }
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            if (zzazjVar != null) {
                zzaxmVar.zzo(zzazjVar.zza);
                zzaxmVar.zzu(zzazjVar.zzb);
                zzaxmVar.zzt(zzazjVar.zzc);
                zzaxmVar.zzD(zzazjVar.zzd);
                zzaxmVar.zzE(zzazjVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bArrZzb = zzbbv.zzb((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdr));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzb)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzbbv.zzb((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzds)))));
            }
            Context context = this.zzj;
            return zzbdi.zza(context, context.getPackageName(), arrayList, this.zza.zzd());
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
