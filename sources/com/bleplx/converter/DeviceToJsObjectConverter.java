package com.bleplx.converter;

import com.bleplx.adapter.Device;
import com.bleplx.utils.ReadableArrayConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceToJsObjectConverter extends JSObjectConverter<Device> {

    private interface Metadata {
        public static final String ID = "id";
        public static final String IS_CONNECTABLE = "isConnectable";
        public static final String LOCAL_NAME = "localName";
        public static final String MANUFACTURER_DATA = "manufacturerData";
        public static final String MTU = "mtu";
        public static final String NAME = "name";
        public static final String OVERFLOW_SERVICE_UUIDS = "overflowServiceUUIDs";
        public static final String RSSI = "rssi";
        public static final String SERVICE_DATA = "serviceData";
        public static final String SERVICE_UUIDS = "serviceUUIDs";
        public static final String SOLICITED_SERVICE_UUIDS = "solicitedServiceUUIDs";
        public static final String TX_POWER_LEVEL = "txPowerLevel";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(Device device) {
        return super.toJSCallback(device);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(Device device) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", device.getId());
        writableMapCreateMap.putString("name", device.getName());
        if (device.getRssi() != null) {
            writableMapCreateMap.putInt("rssi", device.getRssi().intValue());
        } else {
            writableMapCreateMap.putNull("rssi");
        }
        if (device.getMtu() != null) {
            writableMapCreateMap.putInt("mtu", device.getMtu().intValue());
        } else {
            writableMapCreateMap.putNull("mtu");
        }
        if (device.getServices() != null) {
            writableMapCreateMap.putArray("serviceUUIDs", ReadableArrayConverter.toReadableArray(device.getServicesUUIDs()));
        } else {
            writableMapCreateMap.putNull("serviceUUIDs");
        }
        writableMapCreateMap.putNull("manufacturerData");
        writableMapCreateMap.putNull("serviceData");
        writableMapCreateMap.putNull("localName");
        writableMapCreateMap.putNull("txPowerLevel");
        writableMapCreateMap.putNull("solicitedServiceUUIDs");
        writableMapCreateMap.putNull("isConnectable");
        writableMapCreateMap.putNull("overflowServiceUUIDs");
        return writableMapCreateMap;
    }
}
