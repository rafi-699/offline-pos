package com.bleplx.adapter.errors;

import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes2.dex */
public enum BleErrorCode {
    UnknownError(0),
    BluetoothManagerDestroyed(1),
    OperationCancelled(2),
    OperationTimedOut(3),
    OperationStartFailed(4),
    InvalidIdentifiers(5),
    BluetoothUnsupported(100),
    BluetoothUnauthorized(101),
    BluetoothPoweredOff(102),
    BluetoothInUnknownState(103),
    BluetoothResetting(104),
    BluetoothStateChangeFailed(105),
    DeviceConnectionFailed(200),
    DeviceDisconnected(201),
    DeviceRSSIReadFailed(202),
    DeviceAlreadyConnected(203),
    DeviceNotFound(204),
    DeviceNotConnected(205),
    DeviceMTUChangeFailed(206),
    ServicesDiscoveryFailed(300),
    IncludedServicesDiscoveryFailed(Videoio.CAP_PROP_PVAPI_FRAMESTARTTRIGGERMODE),
    ServiceNotFound(Videoio.CAP_PROP_PVAPI_DECIMATIONHORIZONTAL),
    ServicesNotDiscovered(Videoio.CAP_PROP_PVAPI_DECIMATIONVERTICAL),
    CharacteristicsDiscoveryFailed(400),
    CharacteristicWriteFailed(Videoio.CAP_PROP_XI_DATA_FORMAT),
    CharacteristicReadFailed(Videoio.CAP_PROP_XI_OFFSET_X),
    CharacteristicNotifyChangeFailed(Videoio.CAP_PROP_XI_OFFSET_Y),
    CharacteristicNotFound(Videoio.CAP_PROP_XI_TRG_SOURCE),
    CharacteristicsNotDiscovered(Videoio.CAP_PROP_XI_TRG_SOFTWARE),
    CharacteristicInvalidDataFormat(Videoio.CAP_PROP_XI_GPI_SELECTOR),
    DescriptorsDiscoveryFailed(500),
    DescriptorWriteFailed(501),
    DescriptorReadFailed(502),
    DescriptorNotFound(503),
    DescriptorsNotDiscovered(504),
    DescriptorInvalidDataFormat(505),
    DescriptorWriteNotAllowed(506),
    ScanStartFailed(600),
    LocationServicesDisabled(601);

    public final int code;

    BleErrorCode(int i) {
        this.code = i;
    }
}
