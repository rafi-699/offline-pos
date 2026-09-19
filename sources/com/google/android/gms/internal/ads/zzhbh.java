package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbh extends zzhay {
    private List zza;

    zzhbh(zzgwi zzgwiVar, boolean z) {
        super(zzgwiVar, z, true);
        List listEmptyList = zzgwiVar.isEmpty() ? Collections.emptyList() : zzgxm.zzb(zzgwiVar.size());
        for (int i = 0; i < zzgwiVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzA(int i) {
        super.zzA(i);
        this.zza = null;
    }

    abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzw(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzhbg(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzx() {
        List list = this.zza;
        if (list != null) {
            zza(zzD(list));
        }
    }
}
