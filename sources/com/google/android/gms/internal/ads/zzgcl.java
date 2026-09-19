package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcl extends zzgcj {
    private static zzgcl zzd;

    private zzgcl(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzgcl zzh(Context context) {
        zzgcl zzgclVar;
        synchronized (zzgcl.class) {
            if (zzd == null) {
                zzd = new zzgcl(context);
            }
            zzgclVar = zzd;
        }
        return zzgclVar;
    }

    public final zzgcg zzi(long j, boolean z) throws IOException {
        synchronized (zzgcl.class) {
            if (this.zzc.zzc()) {
                return zza(null, null, j, z);
            }
            return new zzgcg();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzgcl.class) {
            if (zzg(false)) {
                zzc(false);
            }
        }
    }
}
