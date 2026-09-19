package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzihg {
    DOUBLE(zzihh.DOUBLE, 1),
    FLOAT(zzihh.FLOAT, 5),
    INT64(zzihh.LONG, 0),
    UINT64(zzihh.LONG, 0),
    INT32(zzihh.INT, 0),
    FIXED64(zzihh.LONG, 1),
    FIXED32(zzihh.INT, 5),
    BOOL(zzihh.BOOLEAN, 0),
    STRING(zzihh.STRING, 2),
    GROUP(zzihh.MESSAGE, 3),
    MESSAGE(zzihh.MESSAGE, 2),
    BYTES(zzihh.BYTE_STRING, 2),
    UINT32(zzihh.INT, 0),
    ENUM(zzihh.ENUM, 0),
    SFIXED32(zzihh.INT, 5),
    SFIXED64(zzihh.LONG, 1),
    SINT32(zzihh.INT, 0),
    SINT64(zzihh.LONG, 0);

    private final zzihh zzs;
    private final int zzt;

    zzihg(zzihh zzihhVar, int i) {
        this.zzs = zzihhVar;
        this.zzt = i;
    }

    public final zzihh zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
