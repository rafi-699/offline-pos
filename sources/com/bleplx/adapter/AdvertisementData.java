package com.bleplx.adapter;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public class AdvertisementData {
    private static final long BLUETOOTH_BASE_UUID_LSB = -9223371485494954757L;
    private static final int BLUETOOTH_BASE_UUID_MSB = 4096;
    private String localName;
    private byte[] manufacturerData;
    private byte[] rawScanRecord;
    private Map<UUID, byte[]> serviceData;
    private List<UUID> serviceUUIDs;
    private List<UUID> solicitedServiceUUIDs;
    private Integer txPowerLevel;

    public String getLocalName() {
        return this.localName;
    }

    public byte[] getManufacturerData() {
        return this.manufacturerData;
    }

    public Map<UUID, byte[]> getServiceData() {
        return this.serviceData;
    }

    public List<UUID> getServiceUUIDs() {
        return this.serviceUUIDs;
    }

    public Integer getTxPowerLevel() {
        return this.txPowerLevel;
    }

    public List<UUID> getSolicitedServiceUUIDs() {
        return this.solicitedServiceUUIDs;
    }

    public byte[] getRawScanRecord() {
        return this.rawScanRecord;
    }

    private AdvertisementData() {
    }

    public AdvertisementData(byte[] bArr, Map<UUID, byte[]> map, List<UUID> list, String str, Integer num, List<UUID> list2) {
        this.manufacturerData = bArr;
        this.serviceData = map;
        this.serviceUUIDs = list;
        this.localName = str;
        this.txPowerLevel = num;
        this.solicitedServiceUUIDs = list2;
    }

    public static AdvertisementData parseScanResponseData(byte[] bArr) {
        int i;
        AdvertisementData advertisementData = new AdvertisementData();
        advertisementData.rawScanRecord = bArr;
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        while (byteBufferOrder.remaining() >= 2 && (i = byteBufferOrder.get() & 255) != 0) {
            int i2 = i - 1;
            int i3 = byteBufferOrder.get() & 255;
            if (byteBufferOrder.remaining() < i2) {
                break;
            }
            parseAdvertisementData(advertisementData, i3, i2, byteBufferOrder.slice().order(ByteOrder.LITTLE_ENDIAN));
            byteBufferOrder.position(byteBufferOrder.position() + i2);
        }
        return advertisementData;
    }

    private static void parseAdvertisementData(AdvertisementData advertisementData, int i, int i2, ByteBuffer byteBuffer) {
        if (i == 255) {
            parseManufacturerData(advertisementData, i2, byteBuffer);
            return;
        }
        switch (i) {
            case 2:
            case 3:
                parseServiceUUIDs(advertisementData, i2, byteBuffer, 2);
                break;
            case 4:
            case 5:
                parseServiceUUIDs(advertisementData, i2, byteBuffer, 4);
                break;
            case 6:
            case 7:
                parseServiceUUIDs(advertisementData, i2, byteBuffer, 16);
                break;
            case 8:
            case 9:
                parseLocalName(advertisementData, i, i2, byteBuffer);
                break;
            case 10:
                parseTxPowerLevel(advertisementData, i2, byteBuffer);
                break;
            default:
                switch (i) {
                    case 20:
                        parseSolicitedServiceUUIDs(advertisementData, i2, byteBuffer, 2);
                        break;
                    case 21:
                        parseSolicitedServiceUUIDs(advertisementData, i2, byteBuffer, 16);
                        break;
                    case 22:
                        parseServiceData(advertisementData, i2, byteBuffer, 2);
                        break;
                    default:
                        switch (i) {
                            case 31:
                                parseSolicitedServiceUUIDs(advertisementData, i2, byteBuffer, 4);
                                break;
                            case 32:
                                parseServiceData(advertisementData, i2, byteBuffer, 4);
                                break;
                            case 33:
                                parseServiceData(advertisementData, i2, byteBuffer, 16);
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private static void parseLocalName(AdvertisementData advertisementData, int i, int i2, ByteBuffer byteBuffer) {
        if (advertisementData.localName == null || i == 9) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr, 0, i2);
            advertisementData.localName = new String(bArr, Charset.forName(Key.STRING_CHARSET_NAME));
        }
    }

    private static UUID parseUUID(ByteBuffer byteBuffer, int i) {
        long j;
        long j2;
        long j3 = BLUETOOTH_BASE_UUID_LSB;
        if (i == 2) {
            j = ((long) byteBuffer.getShort()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        } else {
            if (i == 4) {
                j = byteBuffer.getInt();
            } else if (i == 16) {
                j3 = byteBuffer.getLong();
                j2 = byteBuffer.getLong();
            } else {
                byteBuffer.position(byteBuffer.position() + i);
                return null;
            }
            return new UUID(j2, j3);
        }
        j2 = (j << 32) + 4096;
        return new UUID(j2, j3);
    }

    private static void parseSolicitedServiceUUIDs(AdvertisementData advertisementData, int i, ByteBuffer byteBuffer, int i2) {
        if (advertisementData.solicitedServiceUUIDs == null) {
            advertisementData.solicitedServiceUUIDs = new ArrayList();
        }
        while (byteBuffer.remaining() >= i2 && byteBuffer.position() < i) {
            advertisementData.solicitedServiceUUIDs.add(parseUUID(byteBuffer, i2));
        }
    }

    private static void parseServiceUUIDs(AdvertisementData advertisementData, int i, ByteBuffer byteBuffer, int i2) {
        if (advertisementData.serviceUUIDs == null) {
            advertisementData.serviceUUIDs = new ArrayList();
        }
        while (byteBuffer.remaining() >= i2 && byteBuffer.position() < i) {
            advertisementData.serviceUUIDs.add(parseUUID(byteBuffer, i2));
        }
    }

    private static void parseServiceData(AdvertisementData advertisementData, int i, ByteBuffer byteBuffer, int i2) {
        if (i < i2) {
            return;
        }
        if (advertisementData.serviceData == null) {
            advertisementData.serviceData = new HashMap();
        }
        UUID uuid = parseUUID(byteBuffer, i2);
        int i3 = i - i2;
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr, 0, i3);
        advertisementData.serviceData.put(uuid, bArr);
    }

    private static void parseTxPowerLevel(AdvertisementData advertisementData, int i, ByteBuffer byteBuffer) {
        if (i != 1) {
            return;
        }
        advertisementData.txPowerLevel = Integer.valueOf(byteBuffer.get());
    }

    private static void parseManufacturerData(AdvertisementData advertisementData, int i, ByteBuffer byteBuffer) {
        if (i < 2) {
            return;
        }
        byte[] bArr = new byte[i];
        advertisementData.manufacturerData = bArr;
        byteBuffer.get(bArr, 0, i);
    }

    public String toString() {
        return "AdvertisementData{manufacturerData=" + Arrays.toString(this.manufacturerData) + ", serviceData=" + this.serviceData + ", serviceUUIDs=" + this.serviceUUIDs + ", localName='" + this.localName + "', txPowerLevel=" + this.txPowerLevel + ", solicitedServiceUUIDs=" + this.solicitedServiceUUIDs + ", rawScanRecord=" + Arrays.toString(this.rawScanRecord) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdvertisementData advertisementData = (AdvertisementData) obj;
        if (Arrays.equals(this.manufacturerData, advertisementData.manufacturerData) && Objects.equals(this.serviceData, advertisementData.serviceData) && Objects.equals(this.serviceUUIDs, advertisementData.serviceUUIDs) && Objects.equals(this.localName, advertisementData.localName) && Objects.equals(this.txPowerLevel, advertisementData.txPowerLevel) && Objects.equals(this.solicitedServiceUUIDs, advertisementData.solicitedServiceUUIDs)) {
            return Arrays.equals(this.rawScanRecord, advertisementData.rawScanRecord);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.manufacturerData) * 31;
        Map<UUID, byte[]> map = this.serviceData;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<UUID> list = this.serviceUUIDs;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.localName;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.txPowerLevel;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        List<UUID> list2 = this.solicitedServiceUUIDs;
        return ((iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31) + Arrays.hashCode(this.rawScanRecord);
    }
}
