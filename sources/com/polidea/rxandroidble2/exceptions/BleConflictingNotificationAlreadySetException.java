package com.polidea.rxandroidble2.exceptions;

import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class BleConflictingNotificationAlreadySetException extends BleException {
    private final boolean alreadySetIsIndication;
    private final UUID characteristicUuid;

    public BleConflictingNotificationAlreadySetException(UUID uuid, boolean z) {
        super("Characteristic " + uuid + " notification already set to " + (z ? "indication" : "notification"));
        this.characteristicUuid = uuid;
        this.alreadySetIsIndication = z;
    }

    public UUID getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public boolean indicationAlreadySet() {
        return this.alreadySetIsIndication;
    }

    public boolean notificationAlreadySet() {
        return !this.alreadySetIsIndication;
    }
}
