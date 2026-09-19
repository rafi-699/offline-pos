package com.bleplx.converter;

import com.bleplx.adapter.Service;
import com.bleplx.adapter.utils.UUIDConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceToJsObjectConverter extends JSObjectConverter<Service> {

    private interface Metadata {
        public static final String DEVICE_ID = "deviceID";
        public static final String ID = "id";
        public static final String IS_PRIMARY = "isPrimary";
        public static final String UUID = "uuid";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Service service) {
        return super.toJSCallback(service);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(Service service) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("id", service.getId());
        writableMapCreateMap.putString("uuid", UUIDConverter.fromUUID(service.getUuid()));
        writableMapCreateMap.putString("deviceID", service.getDeviceID());
        writableMapCreateMap.putBoolean(Metadata.IS_PRIMARY, service.isPrimary());
        return writableMapCreateMap;
    }
}
