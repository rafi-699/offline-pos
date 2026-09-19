package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzibg {
    @Deprecated
    public zzibg() {
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzicf zzicfVar = new zzicf(zzica.zza(sb));
            zzicfVar.zza(zzibl.LENIENT);
            zzicb.zza.zza(zzicfVar, this);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String zzd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzibi zze() {
        if (this instanceof zzibi) {
            return (zzibi) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final zzibf zzf() {
        if (this instanceof zzibf) {
            return (zzibf) this;
        }
        throw new IllegalStateException("Not a JSON Array: ".concat(toString()));
    }

    public final zzibk zzg() {
        if (this instanceof zzibk) {
            return (zzibk) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: ".concat(toString()));
    }
}
