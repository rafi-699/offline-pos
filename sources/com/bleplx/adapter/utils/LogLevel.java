package com.bleplx.adapter.utils;

/* JADX INFO: loaded from: classes2.dex */
public class LogLevel {
    public static int toLogLevel(String str) {
        switch (str.hashCode()) {
            case -1505867908:
                return str.equals("Warning") ? 5 : Integer.MAX_VALUE;
            case 2283726:
                return str.equals(Constants.BluetoothLogLevel.INFO) ? 4 : Integer.MAX_VALUE;
            case 2433880:
                str.equals(Constants.BluetoothLogLevel.NONE);
                return Integer.MAX_VALUE;
            case 65906227:
                return str.equals(Constants.BluetoothLogLevel.DEBUG) ? 3 : Integer.MAX_VALUE;
            case 67232232:
                return str.equals(Constants.BluetoothLogLevel.ERROR) ? 6 : Integer.MAX_VALUE;
            case 2015760738:
                return str.equals(Constants.BluetoothLogLevel.VERBOSE) ? 2 : Integer.MAX_VALUE;
            default:
                return Integer.MAX_VALUE;
        }
    }

    public static String fromLogLevel(int i) {
        if (i == 2) {
            return Constants.BluetoothLogLevel.VERBOSE;
        }
        if (i == 3) {
            return Constants.BluetoothLogLevel.DEBUG;
        }
        if (i == 4) {
            return Constants.BluetoothLogLevel.INFO;
        }
        if (i == 5) {
            return "Warning";
        }
        if (i == 6) {
            return Constants.BluetoothLogLevel.ERROR;
        }
        return Constants.BluetoothLogLevel.NONE;
    }
}
