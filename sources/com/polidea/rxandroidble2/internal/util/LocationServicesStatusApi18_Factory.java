package com.polidea.rxandroidble2.internal.util;

import bleshadow.dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationServicesStatusApi18_Factory implements Factory<LocationServicesStatusApi18> {
    @Override // bleshadow.javax.inject.Provider
    public LocationServicesStatusApi18 get() {
        return newInstance();
    }

    public static LocationServicesStatusApi18_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LocationServicesStatusApi18 newInstance() {
        return new LocationServicesStatusApi18();
    }

    private static final class InstanceHolder {
        private static final LocationServicesStatusApi18_Factory INSTANCE = new LocationServicesStatusApi18_Factory();

        private InstanceHolder() {
        }
    }
}
