package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgck extends zzgcj {
    private static zzgck zzd;

    private zzgck(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzgck zzh(Context context) {
        zzgck zzgckVar;
        synchronized (zzgck.class) {
            if (zzd == null) {
                zzd = new zzgck(context);
            }
            zzgckVar = zzd;
        }
        return zzgckVar;
    }

    public final zzgcg zzi(long j, boolean z) throws IOException {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(null, null, j, z);
        }
        return zzgcgVarZza;
    }

    public final zzgcg zzj(String str, String str2, long j, boolean z) throws IOException {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(str, str2, j, z);
        }
        return zzgcgVarZza;
    }

    public final void zzk() throws IOException {
        synchronized (zzgck.class) {
            zzc(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzgck.class) {
            zzc(true);
        }
    }
}
