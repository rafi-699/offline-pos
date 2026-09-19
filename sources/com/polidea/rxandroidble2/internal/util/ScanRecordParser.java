package com.polidea.rxandroidble2.internal.util;

import android.os.ParcelUuid;
import android.util.SparseArray;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat;
import com.polidea.rxandroidble2.scan.ScanRecord;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public class ScanRecordParser {
    public static final UUID BASE_UUID = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA_128_BIT = 33;
    private static final int DATA_TYPE_SERVICE_DATA_16_BIT = 22;
    private static final int DATA_TYPE_SERVICE_DATA_32_BIT = 32;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_128_BIT = 21;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_16_BIT = 20;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_32_BIT = 31;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    public static final int UUID_BYTES_128_BIT = 16;
    public static final int UUID_BYTES_16_BIT = 2;
    public static final int UUID_BYTES_32_BIT = 4;

    @Inject
    public ScanRecordParser() {
    }

    public List<UUID> extractUUIDs(byte[] bArr) {
        List<ParcelUuid> serviceUuids = parseFromBytes(bArr).getServiceUuids();
        if (serviceUuids == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ParcelUuid> it = serviceUuids.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUuid());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x0100  */
    public ScanRecord parseFromBytes(byte[] bArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ScanRecordParser scanRecordParser;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        HashMap map = new HashMap();
        int i = 0;
        int i2 = -1;
        byte b = -2147483648;
        ArrayList arrayList6 = arrayList4;
        String str = null;
        while (i < bArr2.length) {
            try {
                int i3 = i + 1;
                int i4 = bArr2[i] & 255;
                if (i4 != 0) {
                    int i5 = i4 - 1;
                    int i6 = i + 2;
                    int i7 = bArr2[i3] & 255;
                    if (i7 != 255) {
                        switch (i7) {
                            case 1:
                                arrayList5 = arrayList5;
                                arrayList3 = arrayList6;
                                i2 = bArr2[i6] & 255;
                                break;
                            case 2:
                            case 3:
                                arrayList5 = arrayList5;
                                arrayList3 = arrayList6;
                                bArr2 = bArr;
                                parseServiceUuid(bArr2, i6, i5, 2, arrayList3);
                                break;
                            case 4:
                            case 5:
                                arrayList3 = arrayList6;
                                parseServiceUuid(bArr, i6, i5, 4, arrayList3);
                                bArr2 = bArr;
                                break;
                            case 6:
                            case 7:
                                arrayList3 = arrayList6;
                                parseServiceUuid(bArr2, i6, i5, 16, arrayList3);
                                bArr2 = bArr;
                                break;
                            case 8:
                            case 9:
                                scanRecordParser = this;
                                str = new String(scanRecordParser.extractBytes(bArr2, i6, i5));
                                arrayList3 = arrayList6;
                                break;
                            case 10:
                                scanRecordParser = this;
                                b = bArr2[i6];
                                arrayList3 = arrayList6;
                                break;
                            default:
                                switch (i7) {
                                    case 20:
                                        scanRecordParser = this;
                                        bArr2 = bArr;
                                        scanRecordParser.parseServiceSolicitationUuid(bArr2, i6, i5, 2, arrayList5);
                                        arrayList3 = arrayList6;
                                        break;
                                    case 21:
                                        parseServiceSolicitationUuid(bArr2, i6, i5, 16, arrayList5);
                                        bArr2 = bArr;
                                        arrayList5 = arrayList5;
                                        arrayList3 = arrayList6;
                                        break;
                                    default:
                                        switch (i7) {
                                            case 31:
                                                scanRecordParser = this;
                                                try {
                                                    scanRecordParser.parseServiceSolicitationUuid(bArr2, i6, i5, 4, arrayList5);
                                                    arrayList3 = arrayList6;
                                                } catch (Exception e) {
                                                    e = e;
                                                }
                                                break;
                                            case 32:
                                            case 33:
                                                break;
                                            default:
                                                arrayList5 = arrayList5;
                                                arrayList3 = arrayList6;
                                                break;
                                        }
                                    case 22:
                                        scanRecordParser = this;
                                        int i8 = i7 == 32 ? 4 : i7 == 33 ? 16 : 2;
                                        map.put(parseUuidFrom(scanRecordParser.extractBytes(bArr2, i6, i8)), scanRecordParser.extractBytes(bArr2, i6 + i8, i5 - i8));
                                        arrayList3 = arrayList6;
                                        break;
                                }
                                break;
                        }
                    } else {
                        arrayList5 = arrayList5;
                        arrayList3 = arrayList6;
                        sparseArray.put(((bArr2[i + 3] & 255) << 8) + (bArr2[i6] & 255), extractBytes(bArr2, i + 4, i4 - 3));
                    }
                    try {
                        i = i6 + i5;
                        arrayList6 = arrayList3;
                        arrayList5 = arrayList5;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    if (arrayList.isEmpty()) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = arrayList;
                    }
                    return new ScanRecordImplCompat(arrayList2, arrayList7, sparseArray, map, i2, b, str, bArr2);
                }
                e = e2;
            } catch (Exception e3) {
                e = e3;
            }
            RxBleLog.e(e, "Unable to parse scan record: %s", LoggerUtil.bytesToHex(bArr));
            return new ScanRecordImplCompat(null, null, null, null, -1, Integer.MIN_VALUE, null, bArr);
        }
        ArrayList arrayList8 = arrayList5;
        arrayList = arrayList6;
        if (arrayList.isEmpty()) {
            arrayList2 = null;
        } else {
            arrayList2 = arrayList;
        }
        return new ScanRecordImplCompat(arrayList2, arrayList8, sparseArray, map, i2, b, str, bArr2);
    }

    private static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
        } else {
            j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
        }
        UUID uuid = BASE_UUID;
        return new ParcelUuid(new UUID(uuid.getMostSignificantBits() + (j << 32), uuid.getLeastSignificantBits()));
    }

    private int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private int parseServiceSolicitationUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
