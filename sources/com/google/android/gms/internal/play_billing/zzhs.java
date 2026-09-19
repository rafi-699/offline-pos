package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzhs {
    DOUBLE(zzht.DOUBLE, 1),
    FLOAT(zzht.FLOAT, 5),
    INT64(zzht.LONG, 0),
    UINT64(zzht.LONG, 0),
    INT32(zzht.INT, 0),
    FIXED64(zzht.LONG, 1),
    FIXED32(zzht.INT, 5),
    BOOL(zzht.BOOLEAN, 0),
    STRING(zzht.STRING, 2),
    GROUP(zzht.MESSAGE, 3),
    MESSAGE(zzht.MESSAGE, 2),
    BYTES(zzht.BYTE_STRING, 2),
    UINT32(zzht.INT, 0),
    ENUM(zzht.ENUM, 0),
    SFIXED32(zzht.INT, 5),
    SFIXED64(zzht.LONG, 1),
    SINT32(zzht.INT, 0),
    SINT64(zzht.LONG, 0);

    private final zzht zzt;
    private final int zzu;

    zzhs(zzht zzhtVar, int i) {
        this.zzt = zzhtVar;
        this.zzu = i;
    }

    public final zzht zza() {
        return this.zzt;
    }
}
