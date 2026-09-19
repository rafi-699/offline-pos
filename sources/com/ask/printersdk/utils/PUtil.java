package com.ask.printersdk.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class PUtil {
    private static final long INTERVAL = 500;
    private static long lastClickTime;

    public static boolean isButtonDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - lastClickTime) <= 500) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }

    public static void initializeWithFragment(FragmentManager fragmentManager, int i, Fragment fragment) {
        try {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(i, fragment, fragment.getClass().getSimpleName());
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replaceFragment(FragmentManager fragmentManager, int i, Fragment fragment) {
        try {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(i, fragment, fragment.getClass().getSimpleName());
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDiskCacheDir(Context context) {
        File externalCacheDir;
        if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && (externalCacheDir = context.getExternalCacheDir()) != null) {
            return externalCacheDir.getPath();
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static InputStream getInputStreamFormUri(Context context, Uri uri) {
        try {
            return context.getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BitmapFactory.Options getImageOptions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    public static BitmapFactory.Options getImageOptions(Context context, Uri uri) {
        InputStream inputStreamFormUri = getInputStreamFormUri(context, uri);
        if (inputStreamFormUri == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStreamFormUri, null, options);
        return options;
    }

    public static BitmapFactory.Options getImageOptions(Context context, Uri uri, String str) {
        BitmapFactory.Options imageOptions = getImageOptions(context, uri);
        return (imageOptions != null || TextUtils.isEmpty(str)) ? imageOptions : getImageOptions(str);
    }

    public static Bitmap getBitmapFromFile(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapFromResource(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static int getPicRotate(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 3) {
                    return RotationOptions.ROTATE_180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return RotationOptions.ROTATE_270;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int getPicRotate(InputStream inputStream) {
        int i = 0;
        try {
            int attributeInt = new ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = RotationOptions.ROTATE_180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = RotationOptions.ROTATE_270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        return i;
    }

    public static Bitmap getBitmapFromUri(Context context, Uri uri) {
        InputStream inputStreamFormUri = getInputStreamFormUri(context, uri);
        Bitmap bitmapDecodeStream = null;
        if (inputStreamFormUri != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamFormUri, null, options);
            try {
                inputStreamFormUri.close();
            } catch (IOException unused) {
            }
        }
        return bitmapDecodeStream;
    }

    public static Bitmap getBitmapFromUri(Context context, Uri uri, String str) {
        int picRotate;
        try {
            Bitmap bitmapFromUri = getBitmapFromUri(context, uri);
            if (bitmapFromUri == null && !TextUtils.isEmpty(str)) {
                bitmapFromUri = getBitmapFromFile(context, str);
            }
            if (bitmapFromUri == null || (picRotate = getPicRotate(getInputStreamFormUri(context, uri))) == 0) {
                return bitmapFromUri;
            }
            Matrix matrix = new Matrix();
            int width = bitmapFromUri.getWidth();
            int height = bitmapFromUri.getHeight();
            matrix.setRotate(picRotate);
            return Bitmap.createBitmap(bitmapFromUri, 0, 0, width, height, matrix, true);
        } catch (Exception e) {
            LogUtil.e("Uri Exception", e.toString());
            return null;
        }
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        ((File) Objects.requireNonNull(file.getParentFile())).mkdirs();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dip(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static int spToPx(float f, Context context) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static void showKeyboard(View view) {
        if (view == null) {
            return;
        }
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
    }

    public static void hideKeyboard(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        }
    }

    public static int saveFileToGallery(Context context, File file) {
        if (!file.exists()) {
            return -1;
        }
        String mimeType = getMimeType(file);
        String name = file.getName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", name);
        contentValues.put("mime_type", mimeType);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            return -2;
        }
        try {
            copy(new FileInputStream(file), contentResolver.openOutputStream(uriInsert));
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int saveFileToDCIM(Context context, File file) {
        if (!file.exists()) {
            return -1;
        }
        String mimeType = getMimeType(file);
        String name = file.getName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", name);
        contentValues.put("mime_type", mimeType);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + context.getApplicationContext().getPackageName());
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            return -2;
        }
        try {
            copy(new FileInputStream(file), contentResolver.openOutputStream(uriInsert));
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if ((inputStream instanceof FileInputStream) && (outputStream instanceof FileOutputStream)) {
            return copy((FileInputStream) inputStream, (FileOutputStream) outputStream);
        }
        return copy2(inputStream, outputStream);
    }

    public static boolean copy(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws Throwable {
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            FileChannel channel2 = fileInputStream.getChannel();
            try {
                channel = fileOutputStream.getChannel();
                try {
                    channel2.transferTo(0L, channel2.size(), channel);
                    close(fileInputStream);
                    close(channel2);
                    close(fileOutputStream);
                    close(channel);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileChannel = channel2;
                    try {
                        e.printStackTrace();
                        close(fileInputStream);
                        close(fileChannel);
                        close(fileOutputStream);
                        close(channel);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        close(fileInputStream);
                        close(fileChannel);
                        close(fileOutputStream);
                        close(channel);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel2;
                    close(fileInputStream);
                    close(fileChannel);
                    close(fileOutputStream);
                    close(channel);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                channel = null;
            } catch (Throwable th3) {
                th = th3;
                channel = null;
            }
        } catch (IOException e3) {
            e = e3;
            channel = null;
        } catch (Throwable th4) {
            th = th4;
            channel = null;
        }
    }

    public static boolean copy2(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        close(inputStream);
                        close(outputStream);
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    close(inputStream);
                    close(outputStream);
                    return false;
                }
            } catch (Throwable th) {
                close(inputStream);
                close(outputStream);
                throw th;
            }
            close(inputStream);
            close(outputStream);
            throw th;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getMimeType(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static int saveBitmapToGallery(Context context, Bitmap bitmap) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", "D_" + System.currentTimeMillis() + ".png");
            contentValues.put("mime_type", "image/png");
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
            }
            Uri uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (TextUtils.isEmpty(uriInsert.toString())) {
                return -1;
            }
            return bitmap.compress(Bitmap.CompressFormat.PNG, 100, context.getContentResolver().openOutputStream(uriInsert)) ? 0 : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getExternalStoragePath(Context context) {
        File externalFilesDir;
        if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getAbsolutePath();
    }

    public static String readJsonFile(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
