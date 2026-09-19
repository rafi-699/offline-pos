package com.polidea.rxandroidble2.internal;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientScope;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@ClientScope
public class RxBleDeviceProvider {
    private final Map<String, DeviceComponent> cachedDeviceComponents;
    private final Provider<DeviceComponent.Builder> deviceComponentBuilder;

    @Inject
    public RxBleDeviceProvider(DeviceComponentCache deviceComponentCache, Provider<DeviceComponent.Builder> provider) {
        this.cachedDeviceComponents = deviceComponentCache;
        this.deviceComponentBuilder = provider;
    }

    public RxBleDevice getBleDevice(String str) {
        DeviceComponent deviceComponent = this.cachedDeviceComponents.get(str);
        if (deviceComponent != null) {
            return deviceComponent.provideDevice();
        }
        synchronized (this.cachedDeviceComponents) {
            DeviceComponent deviceComponent2 = this.cachedDeviceComponents.get(str);
            if (deviceComponent2 != null) {
                return deviceComponent2.provideDevice();
            }
            DeviceComponent deviceComponentBuild = this.deviceComponentBuilder.get().macAddress(str).build();
            RxBleDevice rxBleDeviceProvideDevice = deviceComponentBuild.provideDevice();
            this.cachedDeviceComponents.put(str, deviceComponentBuild);
            return rxBleDeviceProvideDevice;
        }
    }
}
