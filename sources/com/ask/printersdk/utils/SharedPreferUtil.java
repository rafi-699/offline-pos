package com.ask.printersdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class SharedPreferUtil {
    public static void putInt(Context context, String str, int i) {
        putInt(SPType.DEFAULT, context, str, i);
    }

    public static void putInt(SPType sPType, Context context, String str, int i) {
        try {
            context.getSharedPreferences(sPType.fileName, 0).edit().putInt(str, i).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean commitInt(Context context, String str, int i) {
        return commitInt(SPType.DEFAULT, context, str, i);
    }

    public static boolean commitInt(SPType sPType, Context context, String str, int i) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).edit().putInt(str, i).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getInt(Context context, String str, int i) {
        return getInt(SPType.DEFAULT, context, str, i);
    }

    public static int getInt(SPType sPType, Context context, String str, int i) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static void putLong(Context context, String str, long j) {
        putLong(SPType.DEFAULT, context, str, j);
    }

    public static void putLong(SPType sPType, Context context, String str, long j) {
        try {
            context.getSharedPreferences(sPType.fileName, 0).edit().putLong(str, j).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean commitLong(Context context, String str, long j) {
        return commitLong(SPType.DEFAULT, context, str, j);
    }

    public static boolean commitLong(SPType sPType, Context context, String str, long j) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).edit().putLong(str, j).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long getLong(Context context, String str, long j) {
        return getLong(SPType.DEFAULT, context, str, j);
    }

    public static long getLong(SPType sPType, Context context, String str, long j) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).getLong(str, j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static void putString(Context context, String str, String str2) {
        putString(SPType.DEFAULT, context, str, str2);
    }

    public static boolean commitString(Context context, String str, String str2) {
        return commitString(SPType.DEFAULT, context, str, str2);
    }

    public static void putString(SPType sPType, Context context, String str, String str2) {
        try {
            context.getSharedPreferences(sPType.fileName, 0).edit().putString(str, str2).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean commitString(SPType sPType, Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).edit().putString(str, str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getString(Context context, String str, String str2) {
        return getString(SPType.DEFAULT, context, str, str2);
    }

    public static String getString(SPType sPType, Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void putBoolean(Context context, String str, boolean z) {
        putBoolean(SPType.DEFAULT, context, str, z);
    }

    public static void putBoolean(SPType sPType, Context context, String str, boolean z) {
        try {
            context.getSharedPreferences(sPType.fileName, 0).edit().putBoolean(str, z).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean commitBoolean(Context context, String str, boolean z) {
        return commitBoolean(SPType.DEFAULT, context, str, z);
    }

    public static boolean commitBoolean(SPType sPType, Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).edit().putBoolean(str, z).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getBoolean(SPType.DEFAULT, context, str, z);
    }

    public static boolean getBoolean(SPType sPType, Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean contains(SPType sPType, Context context, String str) {
        try {
            return context.getSharedPreferences(sPType.fileName, 0).contains(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void remove(Context context, String str) {
        remove(SPType.DEFAULT, context, str);
    }

    public static void remove(SPType sPType, Context context, String str) {
        try {
            context.getSharedPreferences(sPType.fileName, 0).edit().remove(str).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveLongArray(Context context, String str, long[] jArr) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("MyPrefs", 0).edit();
        StringBuilder sb = new StringBuilder();
        for (long j : jArr) {
            sb.append(j).append(",");
        }
        String string = sb.toString();
        editorEdit.putString(str, string.substring(0, string.length() - 1));
        editorEdit.apply();
    }

    public static long[] loadLongArray(Context context, String str) {
        String string = context.getSharedPreferences("MyPrefs", 0).getString(str, "");
        if (string.isEmpty()) {
            return new long[0];
        }
        String[] strArrSplit = string.split(",");
        long[] jArr = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            jArr[i] = Long.parseLong(strArrSplit[i]);
        }
        return jArr;
    }

    public enum SPType {
        DEFAULT("share_data"),
        USER("share_user");

        String fileName;

        SPType(String str) {
            this.fileName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.fileName;
        }
    }
}
