package com.polidea.rxandroidble2.internal.cache;

import bleshadow.dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DeviceComponentCache_Factory implements Factory<DeviceComponentCache> {
    @Override // bleshadow.javax.inject.Provider
    public DeviceComponentCache get() {
        return newInstance();
    }

    public static DeviceComponentCache_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeviceComponentCache newInstance() {
        return new DeviceComponentCache();
    }

    private static final class InstanceHolder {
        private static final DeviceComponentCache_Factory INSTANCE = new DeviceComponentCache_Factory();

        private InstanceHolder() {
        }
    }
}
