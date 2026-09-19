package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class ClientComponent_ClientModule_ProvideDisableNotificationValueFactory implements Factory<byte[]> {
    @Override // bleshadow.javax.inject.Provider
    public byte[] get() {
        return provideDisableNotificationValue();
    }

    public static ClientComponent_ClientModule_ProvideDisableNotificationValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static byte[] provideDisableNotificationValue() {
        return (byte[]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideDisableNotificationValue());
    }

    private static final class InstanceHolder {
        private static final ClientComponent_ClientModule_ProvideDisableNotificationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideDisableNotificationValueFactory();

        private InstanceHolder() {
        }
    }
}
