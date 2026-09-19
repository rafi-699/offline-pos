package com.bleplx.converter;

import com.bleplx.adapter.AdvertisementData;
import com.bleplx.adapter.ScanResult;
import com.bleplx.adapter.utils.Base64Converter;
import com.bleplx.adapter.utils.UUIDConverter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class ScanResultToJsObjectConverter extends JSObjectConverter<ScanResult> {

    interface Metadata {
        public static final String ID = "id";
        public static final String IS_CONNECTABLE = "isConnectable";
        public static final String LOCAL_NAME = "localName";
        public static final String MANUFACTURER_DATA = "manufacturerData";
        public static final String MTU = "mtu";
        public static final String NAME = "name";
        public static final String OVERFLOW_SERVICE_UUIDS = "overflowServiceUUIDs";
        public static final String RAW_SCAN_RECORD = "rawScanRecord";
        public static final String RSSI = "rssi";
        public static final String SERVICE_DATA = "serviceData";
        public static final String SERVICE_UUIDS = "serviceUUIDs";
        public static final String SOLICITED_SERVICE_UUIDS = "solicitedServiceUUIDs";
        public static final String TX_POWER_LEVEL = "txPowerLevel";
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public /* bridge */ /* synthetic */ WritableArray toJSCallback(ScanResult scanResult) {
        return super.toJSCallback(scanResult);
    }

    @Override // com.bleplx.converter.JSObjectConverter
    public WritableMap toJSObject(ScanResult scanResult) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", scanResult.getDeviceId());
        writableMapCreateMap.putString("name", scanResult.getDeviceName());
        writableMapCreateMap.putInt("rssi", scanResult.getRssi());
        writableMapCreateMap.putInt("mtu", scanResult.getMtu());
        writableMapCreateMap.putBoolean("isConnectable", scanResult.isConnectable());
        AdvertisementData advertisementData = scanResult.getAdvertisementData();
        writableMapCreateMap.putString("manufacturerData", advertisementData.getManufacturerData() != null ? Base64Converter.encode(advertisementData.getManufacturerData()) : null);
        if (advertisementData.getServiceData() != null) {
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            for (Map.Entry<UUID, byte[]> entry : advertisementData.getServiceData().entrySet()) {
                writableMapCreateMap2.putString(UUIDConverter.fromUUID(entry.getKey()), Base64Converter.encode(entry.getValue()));
            }
            writableMapCreateMap.putMap("serviceData", writableMapCreateMap2);
        } else {
            writableMapCreateMap.putNull("serviceData");
        }
        if (advertisementData.getServiceUUIDs() != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<UUID> it = advertisementData.getServiceUUIDs().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushString(UUIDConverter.fromUUID(it.next()));
            }
            writableMapCreateMap.putArray("serviceUUIDs", writableArrayCreateArray);
        } else {
            writableMapCreateMap.putNull("serviceUUIDs");
        }
        if (advertisementData.getLocalName() != null) {
            writableMapCreateMap.putString("localName", advertisementData.getLocalName());
        } else {
            writableMapCreateMap.putNull("localName");
        }
        if (advertisementData.getTxPowerLevel() != null) {
            writableMapCreateMap.putInt("txPowerLevel", advertisementData.getTxPowerLevel().intValue());
        } else {
            writableMapCreateMap.putNull("txPowerLevel");
        }
        if (advertisementData.getSolicitedServiceUUIDs() != null) {
            WritableArray writableArrayCreateArray2 = Arguments.createArray();
            Iterator<UUID> it2 = advertisementData.getSolicitedServiceUUIDs().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray2.pushString(UUIDConverter.fromUUID(it2.next()));
            }
            writableMapCreateMap.putArray("solicitedServiceUUIDs", writableArrayCreateArray2);
        } else {
            writableMapCreateMap.putNull("solicitedServiceUUIDs");
        }
        if (advertisementData.getRawScanRecord() != null) {
            writableMapCreateMap.putString(Metadata.RAW_SCAN_RECORD, Base64Converter.encode(advertisementData.getRawScanRecord()));
        } else {
            writableMapCreateMap.putNull(Metadata.RAW_SCAN_RECORD);
        }
        writableMapCreateMap.putNull("overflowServiceUUIDs");
        return writableMapCreateMap;
    }
}
