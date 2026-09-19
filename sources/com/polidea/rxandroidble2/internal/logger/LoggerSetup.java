package com.polidea.rxandroidble2.internal.logger;

import com.polidea.rxandroidble2.LogOptions;

/* JADX INFO: loaded from: classes4.dex */
public class LoggerSetup {
    public final int logLevel;
    public final LogOptions.Logger logger;
    public final int macAddressLogSetting;
    public final boolean shouldLogAttributeValues;
    public final boolean shouldLogScannedPeripherals;
    public final int uuidLogSetting;

    public LoggerSetup(int i, int i2, int i3, boolean z, boolean z2, LogOptions.Logger logger) {
        this.logLevel = i;
        this.macAddressLogSetting = i2;
        this.uuidLogSetting = i3;
        this.shouldLogAttributeValues = z;
        this.shouldLogScannedPeripherals = z2;
        this.logger = logger;
    }

    public LoggerSetup merge(LogOptions logOptions) {
        boolean zBooleanValue;
        int iIntValue = logOptions.getLogLevel() != null ? logOptions.getLogLevel().intValue() : this.logLevel;
        int iIntValue2 = logOptions.getMacAddressLogSetting() != null ? logOptions.getMacAddressLogSetting().intValue() : this.macAddressLogSetting;
        int iIntValue3 = logOptions.getUuidLogSetting() != null ? logOptions.getUuidLogSetting().intValue() : this.uuidLogSetting;
        boolean zBooleanValue2 = logOptions.getShouldLogAttributeValues() != null ? logOptions.getShouldLogAttributeValues().booleanValue() : this.shouldLogAttributeValues;
        if (logOptions.getShouldLogScannedPeripherals() != null) {
            zBooleanValue = logOptions.getShouldLogScannedPeripherals().booleanValue();
        } else {
            zBooleanValue = this.shouldLogScannedPeripherals;
        }
        return new LoggerSetup(iIntValue, iIntValue2, iIntValue3, zBooleanValue2, zBooleanValue, logOptions.getLogger() != null ? logOptions.getLogger() : this.logger);
    }

    public String toString() {
        return "LoggerSetup{logLevel=" + this.logLevel + ", macAddressLogSetting=" + this.macAddressLogSetting + ", uuidLogSetting=" + this.uuidLogSetting + ", shouldLogAttributeValues=" + this.shouldLogAttributeValues + ", shouldLogScannedPeripherals=" + this.shouldLogScannedPeripherals + ", logger=" + this.logger + '}';
    }
}
