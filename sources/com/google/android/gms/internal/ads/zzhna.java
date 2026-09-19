package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhna {
    private final Map zza = new HashMap();

    public final zzhna zza(zziaz zziazVar, Object obj) throws GeneralSecurityException {
        List list;
        if (zziazVar.zzd() != 0 && zziazVar.zzd() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        Map map = this.zza;
        if (map.containsKey(zziazVar)) {
            list = (List) map.get(zziazVar);
        } else {
            ArrayList arrayList = new ArrayList();
            map.put(zziazVar, arrayList);
            list = arrayList;
        }
        list.add(obj);
        return this;
    }

    public final zzhnc zzb() {
        return new zzhnc(this.zza, null);
    }
}
