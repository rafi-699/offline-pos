package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaw {
    /* JADX WARN: Code duplicated, block: B:51:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:69:? A[SYNTHETIC] */
    static void zza(zzgu zzguVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        if (zzguVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (!zMoveToFirst) {
                        sQLiteDatabase.execSQL(str2);
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzguVar.zze().zzc("Error querying for table", str, e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
            try {
                HashSet hashSet = new HashSet();
                StringBuilder sb = new StringBuilder(str.length() + 22);
                sb.append("SELECT * FROM ");
                sb.append(str);
                sb.append(" LIMIT 0");
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                try {
                    Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                    cursorRawQuery.close();
                    for (String str4 : str3.split(",")) {
                        if (!hashSet.remove(str4)) {
                            StringBuilder sb2 = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                            sb2.append("Table ");
                            sb2.append(str);
                            sb2.append(" is missing required column: ");
                            sb2.append(str4);
                            throw new SQLiteException(sb2.toString());
                        }
                    }
                    if (strArr != null) {
                        for (int i = 0; i < strArr.length; i += 2) {
                            if (!hashSet.remove(strArr[i])) {
                                sQLiteDatabase.execSQL(strArr[i + 1]);
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        return;
                    }
                    zzguVar.zze().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                } catch (Throwable th3) {
                    cursorRawQuery.close();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzguVar.zzb().zzb("Failed to verify columns on table that was just created", str);
                throw e3;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursorQuery;
            if (cursor != null) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    static void zzb(zzgu zzguVar, SQLiteDatabase sQLiteDatabase) {
        if (zzguVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        com.google.android.gms.internal.measurement.zzbv.zza();
        String path = sQLiteDatabase.getPath();
        int i = com.google.android.gms.internal.measurement.zzca.zzb;
        File file = new File(path);
        if (!file.setReadable(false, false)) {
            zzguVar.zze().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzguVar.zze().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzguVar.zze().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzguVar.zze().zza("Failed to turn on database write permission for owner");
    }
}
