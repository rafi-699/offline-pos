package com.bleplx.adapter.utils;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class IdGeneratorKey {
    private final String deviceAddress;
    private final int id;
    private final UUID uuid;

    public IdGeneratorKey(String str, UUID uuid, int i) {
        this.deviceAddress = str;
        this.uuid = uuid;
        this.id = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IdGeneratorKey idGeneratorKey = (IdGeneratorKey) obj;
        if (this.id == idGeneratorKey.id && this.deviceAddress.equals(idGeneratorKey.deviceAddress)) {
            return this.uuid.equals(idGeneratorKey.uuid);
        }
        return false;
    }

    public int hashCode() {
        return (((this.deviceAddress.hashCode() * 31) + this.uuid.hashCode()) * 31) + this.id;
    }
}
