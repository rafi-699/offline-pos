package com.polidea.rxandroidble2.internal;

import bleshadow.dagger.BindsInstance;
import bleshadow.dagger.Subcomponent;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.RxBleDevice;

/* JADX INFO: loaded from: classes4.dex */
@DeviceScope
@Subcomponent(modules = {DeviceModule.class})
public interface DeviceComponent {

    @Subcomponent.Builder
    public interface Builder {
        DeviceComponent build();

        @BindsInstance
        Builder macAddress(@Named(DeviceModule.MAC_ADDRESS) String str);
    }

    @DeviceScope
    RxBleDevice provideDevice();
}
