package com.reactnative.ivpusic.imagepicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
class RealPathUtil {
    RealPathUtil() {
    }

    static String getRealPathFromURI(Context context, Uri uri) throws IOException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static File writeToFile(Context context, String str, Uri uri) {
        String str2 = context.getCacheDir() + "/react-native-image-crop-picker";
        Boolean.valueOf(new File(str2).mkdir());
        File file = new File(new File(str2), str.substring(str.lastIndexOf(47) + 1));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr, 0, 8192);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                } else {
                    fileOutputStream.close();
                    inputStreamOpenInputStream.close();
                    return file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return file;
        }
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data", "_display_name"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("_data");
                        if ((columnIndex > -1 ? cursorQuery.getString(columnIndex) : null) != null) {
                            String string = cursorQuery.getString(columnIndex);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return string;
                        }
                        String absolutePath = writeToFile(context, cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name")), uri).getAbsolutePath();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return absolutePath;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                        throw th;
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static String getPathToNonPrimaryVolume(Context context, String str) {
        String absolutePath;
        int iIndexOf;
        File[] externalCacheDirs = context.getExternalCacheDirs();
        if (externalCacheDirs == null) {
            return null;
        }
        for (File file : externalCacheDirs) {
            if (file != null && (absolutePath = file.getAbsolutePath()) != null && (iIndexOf = absolutePath.indexOf(str)) != -1) {
                return absolutePath.substring(0, iIndexOf) + str;
            }
        }
        return null;
    }
}
