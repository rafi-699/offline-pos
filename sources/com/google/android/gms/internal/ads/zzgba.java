package com.google.android.gms.internal.ads;

import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgba implements Serializer {
    public static final zzgba zza = new zzgba();
    private static final zzgax zzb;

    static {
        zzgax zzgaxVarZzd = zzgax.zzd();
        Intrinsics.checkNotNullExpressionValue(zzgaxVarZzd, "getDefaultInstance(...)");
        zzb = zzgaxVarZzd;
    }

    private zzgba() {
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object getDefaultValue() {
        return zzb;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, Continuation continuation) {
        try {
            zzgax zzgaxVarZzc = zzgax.zzc(inputStream);
            Intrinsics.checkNotNull(zzgaxVarZzc);
            return zzgaxVarZzc;
        } catch (Exception unused) {
            return zzb;
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final /* synthetic */ Object writeTo(Object obj, OutputStream outputStream, Continuation continuation) throws IOException {
        ((zzgax) obj).zzaO(outputStream);
        return Unit.INSTANCE;
    }
}
