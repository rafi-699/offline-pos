package com.bleplx;

/* JADX INFO: loaded from: classes2.dex */
public enum Event {
    ScanEvent("ScanEvent"),
    ReadEvent("ReadEvent"),
    StateChangeEvent("StateChangeEvent"),
    RestoreStateEvent("RestoreStateEvent"),
    DisconnectionEvent("DisconnectionEvent");

    public String name;

    Event(String str) {
        this.name = str;
    }
}
