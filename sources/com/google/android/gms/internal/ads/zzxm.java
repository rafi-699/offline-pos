package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzxm {
    default void zzA(zzak zzakVar) {
    }

    void zzD(zzxi zzxiVar);

    zzxi zzG(zzxk zzxkVar, zzabl zzablVar, long j);

    default zzbf zzH() {
        return null;
    }

    default boolean zzI() {
        return true;
    }

    zzak zzJ();

    void zzl(Handler handler, zzxv zzxvVar);

    void zzm(zzxv zzxvVar);

    void zzn(Handler handler, zzuj zzujVar);

    void zzo(zzuj zzujVar);

    void zzp(zzxl zzxlVar, zzin zzinVar, zzqf zzqfVar);

    void zzq(zzxl zzxlVar);

    void zzr(zzxl zzxlVar);

    void zzs(zzxl zzxlVar);

    void zzt() throws IOException;
}
