package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class ClientComponent_ClientModule_ProvideEnableNotificationValueFactory implements Factory<byte[]> {
    @Override // bleshadow.javax.inject.Provider
    public byte[] get() {
        return provideEnableNotificationValue();
    }

    public static ClientComponent_ClientModule_ProvideEnableNotificationValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static byte[] provideEnableNotificationValue() {
        return (byte[]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideEnableNotificationValue());
    }

    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideEnableNotificationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableNotificationValueFactory();

        private InstanceHolder() {
        }
    }
}
