package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzidu {
    DOUBLE(0, 1, zziev.DOUBLE),
    FLOAT(1, 1, zziev.FLOAT),
    INT64(2, 1, zziev.LONG),
    UINT64(3, 1, zziev.LONG),
    INT32(4, 1, zziev.INT),
    FIXED64(5, 1, zziev.LONG),
    FIXED32(6, 1, zziev.INT),
    BOOL(7, 1, zziev.BOOLEAN),
    STRING(8, 1, zziev.STRING),
    MESSAGE(9, 1, zziev.MESSAGE),
    BYTES(10, 1, zziev.BYTE_STRING),
    UINT32(11, 1, zziev.INT),
    ENUM(12, 1, zziev.ENUM),
    SFIXED32(13, 1, zziev.INT),
    SFIXED64(14, 1, zziev.LONG),
    SINT32(15, 1, zziev.INT),
    SINT64(16, 1, zziev.LONG),
    GROUP(17, 1, zziev.MESSAGE),
    DOUBLE_LIST(18, 2, zziev.DOUBLE),
    FLOAT_LIST(19, 2, zziev.FLOAT),
    INT64_LIST(20, 2, zziev.LONG),
    UINT64_LIST(21, 2, zziev.LONG),
    INT32_LIST(22, 2, zziev.INT),
    FIXED64_LIST(23, 2, zziev.LONG),
    FIXED32_LIST(24, 2, zziev.INT),
    BOOL_LIST(25, 2, zziev.BOOLEAN),
    STRING_LIST(26, 2, zziev.STRING),
    MESSAGE_LIST(27, 2, zziev.MESSAGE),
    BYTES_LIST(28, 2, zziev.BYTE_STRING),
    UINT32_LIST(29, 2, zziev.INT),
    ENUM_LIST(30, 2, zziev.ENUM),
    SFIXED32_LIST(31, 2, zziev.INT),
    SFIXED64_LIST(32, 2, zziev.LONG),
    SINT32_LIST(33, 2, zziev.INT),
    SINT64_LIST(34, 2, zziev.LONG),
    DOUBLE_LIST_PACKED(35, 3, zziev.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zziev.FLOAT),
    INT64_LIST_PACKED(37, 3, zziev.LONG),
    UINT64_LIST_PACKED(38, 3, zziev.LONG),
    INT32_LIST_PACKED(39, 3, zziev.INT),
    FIXED64_LIST_PACKED(40, 3, zziev.LONG),
    FIXED32_LIST_PACKED(41, 3, zziev.INT),
    BOOL_LIST_PACKED(42, 3, zziev.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zziev.INT),
    ENUM_LIST_PACKED(44, 3, zziev.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zziev.INT),
    SFIXED64_LIST_PACKED(46, 3, zziev.LONG),
    SINT32_LIST_PACKED(47, 3, zziev.INT),
    SINT64_LIST_PACKED(48, 3, zziev.LONG),
    GROUP_LIST(49, 2, zziev.MESSAGE),
    MAP(50, 4, zziev.VOID);

    private static final zzidu[] zzaa;
    private final int zzZ;

    static {
        zzidu[] zziduVarArrValues = values();
        zzaa = new zzidu[zziduVarArrValues.length];
        for (zzidu zziduVar : zziduVarArrValues) {
            zzaa[zziduVar.zzZ] = zziduVar;
        }
    }

    zzidu(int i, int i2, zziev zzievVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzievVar.zza();
        }
        if (i2 == 1) {
            zziev zzievVar2 = zziev.VOID;
            zzievVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
