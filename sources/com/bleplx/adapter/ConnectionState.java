package com.bleplx.adapter;

/* JADX INFO: loaded from: classes2.dex */
public enum ConnectionState {
    CONNECTING("connecting"),
    CONNECTED("connected"),
    DISCONNECTING("disconnecting"),
    DISCONNECTED("disconnected");

    public final String value;

    ConnectionState(String str) {
        this.value = str;
    }
}
