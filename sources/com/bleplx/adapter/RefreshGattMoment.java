package com.bleplx.adapter;

/* JADX INFO: loaded from: classes2.dex */
public enum RefreshGattMoment {
    ON_CONNECTED("OnConnected");

    final String name;

    RefreshGattMoment(String str) {
        this.name = str;
    }

    public static RefreshGattMoment getByName(String str) {
        for (RefreshGattMoment refreshGattMoment : values()) {
            if (refreshGattMoment.name.equals(str)) {
                return refreshGattMoment;
            }
        }
        return null;
    }
}
