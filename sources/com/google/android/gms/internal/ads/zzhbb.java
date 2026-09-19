package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbb extends zzhaz {
    private zzhbb() {
        throw null;
    }

    /* synthetic */ zzhbb(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final void zza(zzhbc zzhbcVar, Set set, Set set2) {
        synchronized (zzhbcVar) {
            if (zzhbcVar.seenExceptionsField == null) {
                zzhbcVar.seenExceptionsField = set2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final int zzb(zzhbc zzhbcVar) {
        int i;
        synchronized (zzhbcVar) {
            i = zzhbcVar.remainingField - 1;
            zzhbcVar.remainingField = i;
        }
        return i;
    }
}
