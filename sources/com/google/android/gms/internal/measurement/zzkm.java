package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzkm {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();

    @Nullable
    private static volatile zzkh zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicInteger zzh;
    final zzkg zza;
    final String zzb;
    private Object zzg;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(zzkk.zza, "BuildInfo must be non-null");
        zzh = new AtomicInteger();
    }

    /* synthetic */ zzkm(zzkg zzkgVar, String str, Object obj, boolean z, byte[] bArr) {
        if (zzkgVar.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzkgVar;
        this.zzb = str;
        this.zzg = obj;
        this.zzk = false;
    }

    public static void zzb(final Context context) {
        if (zze != null || context == null) {
            return;
        }
        Object obj = zzd;
        synchronized (obj) {
            if (zze == null) {
                synchronized (obj) {
                    zzkh zzkhVar = zze;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzkhVar == null || zzkhVar.zza() != context) {
                        if (zzkhVar != null) {
                            zzjr.zzd();
                            zzko.zzb();
                            zzjy.zzc();
                        }
                        zze = new zzjn(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzkl
                            @Override // com.google.common.base.Supplier
                            public final /* synthetic */ Object get() {
                                int i = zzkm.zzc;
                                return zzjz.zza(context);
                            }
                        }));
                        zzh.incrementAndGet();
                    }
                }
            }
        }
    }

    public static void zzc() {
        zzh.incrementAndGet();
    }

    @Nullable
    abstract Object zza(Object obj);

    /* JADX WARN: Code duplicated, block: B:14:0x0047 A[PHI: r2
  0x0047: PHI (r2v1 com.google.common.base.Optional) = (r2v0 com.google.common.base.Optional), (r2v0 com.google.common.base.Optional), (r2v7 com.google.common.base.Optional) binds: [B:8:0x0016, B:10:0x001c, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final Object zzd() {
        String strZza;
        zzjv zzjvVarZza;
        String strZze;
        Object objZze;
        int i = zzh.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    zzkh zzkhVar = zze;
                    Optional optionalAbsent = Optional.absent();
                    Object objZza = null;
                    if (zzkhVar == null || zzkhVar.zzb() == null) {
                        strZza = null;
                    } else {
                        optionalAbsent = (Optional) ((Supplier) Preconditions.checkNotNull(zzkhVar.zzb())).get();
                        if (optionalAbsent.isPresent()) {
                            zzjt zzjtVar = (zzjt) optionalAbsent.get();
                            zzkg zzkgVar = this.zza;
                            strZza = zzjtVar.zza(zzkgVar.zza, null, zzkgVar.zzc, this.zzb);
                        } else {
                            strZza = null;
                        }
                    }
                    Preconditions.checkState(zzkhVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    zzkg zzkgVar2 = this.zza;
                    Uri uri = zzkgVar2.zza;
                    if (uri != null) {
                        zzjvVarZza = zzka.zza(zzkhVar.zza(), uri) ? zzjr.zza(zzkhVar.zza().getContentResolver(), uri, zzkj.zza) : null;
                    } else {
                        zzjvVarZza = zzko.zza(zzkhVar.zza(), (String) Preconditions.checkNotNull(null), zzki.zza);
                    }
                    Object objZza2 = (zzjvVarZza == null || (objZze = zzjvVarZza.zze(this.zzb)) == null) ? null : zza(objZze);
                    if (objZza2 == null) {
                        if (!zzkgVar2.zzd && (strZze = zzjy.zza(zzkhVar.zza()).zze(this.zzb)) != null) {
                            objZza = zza(strZze);
                        }
                        objZza2 = objZza == null ? this.zzg : objZza;
                    }
                    if (optionalAbsent.isPresent()) {
                        objZza2 = strZza == null ? this.zzg : zza(strZza);
                    }
                    this.zzj = objZza2;
                    this.zzi = i;
                }
            }
        }
        return this.zzj;
    }
}
