package com.reactnativecommunity.cameraroll;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.common.logging.FLog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RNCCameraRoll")
public class CameraRollModule extends NativeCameraRollModuleSpec {
    private static final String ASSET_TYPE_ALL = "All";
    private static final String ASSET_TYPE_PHOTOS = "Photos";
    private static final String ASSET_TYPE_VIDEOS = "Videos";
    private static final int DELETE_REQUEST_CODE = 1001;
    private static final String ERROR_UNABLE_TO_DELETE = "E_UNABLE_TO_DELETE";
    private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    private static final String INCLUDE_ALBUMS = "albums";
    private static final String INCLUDE_FILENAME = "filename";
    private static final String INCLUDE_FILE_EXTENSION = "fileExtension";
    private static final String INCLUDE_FILE_SIZE = "fileSize";
    private static final String INCLUDE_IMAGE_SIZE = "imageSize";
    private static final String INCLUDE_LOCATION = "location";
    private static final String INCLUDE_PLAYABLE_DURATION = "playableDuration";
    private static final String INCLUDE_SOURCE_TYPE = "sourceType";
    public static final String NAME = "RNCCameraRoll";
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    private Promise deletePromise;
    private static final String INCLUDE_ORIENTATION = "orientation";
    private static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "date_added", "date_modified", "width", "height", "_size", "_data", INCLUDE_ORIENTATION};

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    public void addListener(String str) {
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    public void removeListeners(double d) {
    }

    public CameraRollModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new BaseActivityEventListener() { // from class: com.reactnativecommunity.cameraroll.CameraRollModule.1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i != 1001 || CameraRollModule.this.deletePromise == null) {
                    return;
                }
                if (i2 == -1) {
                    CameraRollModule.this.deletePromise.resolve("Files successfully deleted");
                } else {
                    CameraRollModule.this.deletePromise.reject("ERROR", "Deletion was not completed");
                }
                CameraRollModule.this.deletePromise = null;
            }
        });
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCCameraRoll";
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void saveToCameraRoll(String str, ReadableMap readableMap, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), readableMap, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final ReadableMap mOptions;
        private final Promise mPromise;
        private final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, ReadableMap readableMap, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
            this.mOptions = readableMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:101:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.CharSequence, java.lang.String] */
        /* JADX WARN: Type inference failed for: r12v11, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v20 */
        /* JADX WARN: Type inference failed for: r12v21 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v7, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v19, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v20 */
        /* JADX WARN: Type inference failed for: r8v21 */
        /* JADX WARN: Type inference failed for: r8v22 */
        /* JADX WARN: Type inference failed for: r8v23 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) throws Throwable {
            Throwable th;
            ?? r8;
            ?? OpenOutputStream;
            ?? r12;
            ?? r9;
            File externalStoragePublicDirectory;
            String strSubstring;
            Uri uriInsert;
            File file = new File(this.mUri.getPath());
            String mimeType = Utils.getMimeType(this.mUri.toString());
            Boolean boolValueOf = Boolean.valueOf(mimeType != null && mimeType.contains("video"));
            ?? r11 = 0;
             = 0;
            r11 = 0;
            ?? r13 = 0;
            try {
                try {
                    ?? string = this.mOptions.getString("album");
                    boolean zIsEmpty = TextUtils.isEmpty(string);
                    int i = Build.VERSION.SDK_INT;
                    OpenOutputStream = CameraRollModule.ERROR_UNABLE_TO_LOAD;
                    try {
                        if (i >= 29) {
                            ContentValues contentValues = new ContentValues();
                            if (!zIsEmpty) {
                                contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + string);
                            }
                            contentValues.put("mime_type", mimeType);
                            contentValues.put("_display_name", file.getName());
                            contentValues.put("is_pending", (Integer) 1);
                            ContentResolver contentResolver = this.mContext.getContentResolver();
                            if (boolValueOf.booleanValue()) {
                                uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                            } else {
                                uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            }
                            if (uriInsert == null) {
                                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "ContentResolver#insert() returns null, insert failed");
                            }
                            OpenOutputStream = contentResolver.openOutputStream(uriInsert);
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                FileUtils.copy(fileInputStream, (OutputStream) OpenOutputStream);
                                contentValues.clear();
                                contentValues.put("is_pending", (Integer) 0);
                                contentResolver.update(uriInsert, contentValues, null, null);
                                this.mPromise.resolve(getSingleAssetInfo(uriInsert));
                                OpenOutputStream = OpenOutputStream;
                                string = fileInputStream;
                            } catch (IOException e) {
                                e = e;
                                this.mPromise.reject(e);
                                if (r13 != 0) {
                                    try {
                                        r13.close();
                                    } catch (IOException e2) {
                                        FLog.e(ReactConstants.TAG, "Could not close input channel", e2);
                                    }
                                }
                                if (OpenOutputStream == 0) {
                                    return;
                                }
                            }
                        } else {
                            if (!zIsEmpty) {
                                if ("video".equals(this.mOptions.getString("type"))) {
                                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                                } else {
                                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                                }
                            } else {
                                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                            }
                            if (!zIsEmpty) {
                                File file2 = new File(externalStoragePublicDirectory, (String) string);
                                if (!file2.exists() && !file2.mkdirs()) {
                                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Album Directory not created. Did you request WRITE_EXTERNAL_STORAGE?");
                                    return;
                                }
                                externalStoragePublicDirectory = file2;
                            }
                            if (!externalStoragePublicDirectory.isDirectory()) {
                                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "External media storage directory not available");
                                return;
                            }
                            File file3 = new File(externalStoragePublicDirectory, file.getName());
                            String name = file.getName();
                            if (name.indexOf(46) >= 0) {
                                String strSubstring2 = name.substring(0, name.lastIndexOf(46));
                                strSubstring = name.substring(name.lastIndexOf(46));
                                name = strSubstring2;
                            } else {
                                strSubstring = "";
                            }
                            int i2 = 0;
                            while (!file3.createNewFile()) {
                                file3 = new File(externalStoragePublicDirectory, name + "_" + i2 + strSubstring);
                                i2++;
                            }
                            string = new FileInputStream(file);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                fileOutputStream.getChannel().transferFrom(string.getChannel(), 0L, string.getChannel().size());
                                string.close();
                                fileOutputStream.close();
                                MediaScannerConnection.scanFile(this.mContext, new String[]{file3.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.reactnativecommunity.cameraroll.CameraRollModule$SaveToCameraRoll$$ExternalSyntheticLambda2
                                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                    public final void onScanCompleted(String str, Uri uri) {
                                        this.f$0.lambda$doInBackgroundGuarded$0(str, uri);
                                    }
                                });
                                OpenOutputStream = fileOutputStream;
                                string = string;
                            } catch (IOException e3) {
                                e = e3;
                                OpenOutputStream = 0;
                                r13 = string;
                                this.mPromise.reject(e);
                                if (r13 != 0) {
                                    r13.close();
                                }
                                if (OpenOutputStream == 0) {
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                r9 = 0;
                                r12 = string;
                                r11 = r12;
                                r8 = r9;
                                if (r11 != 0) {
                                    try {
                                        r11.close();
                                    } catch (IOException e4) {
                                        FLog.e(ReactConstants.TAG, "Could not close input channel", e4);
                                    }
                                }
                                if (r8 != 0) {
                                    try {
                                        r8.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        FLog.e(ReactConstants.TAG, "Could not close output channel", e5);
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        }
                        try {
                            string.close();
                        } catch (IOException e6) {
                            FLog.e(ReactConstants.TAG, "Could not close input channel", e6);
                        }
                        if (OpenOutputStream == 0) {
                            return;
                        }
                    } catch (IOException e7) {
                        e = e7;
                    } catch (Throwable th3) {
                        th = th3;
                        r9 = OpenOutputStream;
                        r12 = string;
                    }
                } catch (IOException e8) {
                    e = e8;
                    OpenOutputStream = 0;
                } catch (Throwable th4) {
                    th = th4;
                    r8 = 0;
                }
                try {
                    OpenOutputStream.close();
                } catch (IOException e9) {
                    FLog.e(ReactConstants.TAG, "Could not close output channel", e9);
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackgroundGuarded$0(String str, Uri uri) {
            if (uri == null) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
                return;
            }
            try {
                this.mPromise.resolve(getSingleAssetInfo(uri));
            } catch (Exception e) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, e.getMessage());
            }
        }

        private WritableMap getSingleAssetInfo(Uri uri) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            Cursor cursorQuery = contentResolver.query(uri, CameraRollModule.PROJECTION, null, null, null);
            if (cursorQuery == null) {
                throw new RuntimeException("Failed to find the photo that was just saved!");
            }
            cursorQuery.moveToFirst();
            WritableMap writableMapConvertMediaToMap = CameraRollModule.convertMediaToMap(contentResolver, cursorQuery, Utils$$ExternalSyntheticBackport0.m(new Object[]{"location", CameraRollModule.INCLUDE_FILENAME, CameraRollModule.INCLUDE_FILE_SIZE, CameraRollModule.INCLUDE_FILE_EXTENSION, CameraRollModule.INCLUDE_IMAGE_SIZE, CameraRollModule.INCLUDE_PLAYABLE_DURATION, CameraRollModule.INCLUDE_ORIENTATION, CameraRollModule.INCLUDE_ALBUMS, CameraRollModule.INCLUDE_SOURCE_TYPE}));
            cursorQuery.close();
            return writableMapConvertMediaToMap;
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey(TtmlNode.ANNOTATION_POSITION_AFTER) ? readableMap.getString(TtmlNode.ANNOTATION_POSITION_AFTER) : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS;
        long j = readableMap.hasKey("fromTime") ? (long) readableMap.getDouble("fromTime") : 0L;
        long j2 = readableMap.hasKey("toTime") ? (long) readableMap.getDouble("toTime") : 0L;
        new GetMediaTask(getReactApplicationContext(), i, string, string2, readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null, string3, j, j2, readableMap.hasKey("include") ? readableMap.getArray("include") : null, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void deleteMediaFiles(ReadableArray readableArray, Promise promise) {
        ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Uri.parse(readableArray.getString(i)));
        }
        this.deletePromise = promise;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                IntentSender intentSender = MediaStore.createDeleteRequest(contentResolver, arrayList).getIntentSender();
                Activity currentActivity = getCurrentActivity();
                if (currentActivity != null) {
                    currentActivity.startIntentSenderForResult(intentSender, 1001, null, 0, 0, 0);
                    return;
                } else {
                    promise.reject("ERROR", "Activity is null");
                    return;
                }
            } catch (Exception e) {
                promise.reject("ERROR", e.getMessage());
                return;
            }
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentResolver.delete((Uri) it.next(), null, null);
            }
            promise.resolve("Files deleted");
        } catch (Exception e2) {
            promise.reject("ERROR", e2.getMessage());
        }
    }

    private static class GetMediaTask extends GuardedAsyncTask<Void, Void> {

        @Nullable
        private final String mAfter;
        private final String mAssetType;
        private final Context mContext;
        private final int mFirst;
        private final long mFromTime;

        @Nullable
        private final String mGroupName;
        private final Set<String> mInclude;

        @Nullable
        private final ReadableArray mMimeTypes;
        private final Promise mPromise;
        private final long mToTime;

        private GetMediaTask(ReactContext reactContext, int i, @Nullable String str, @Nullable String str2, @Nullable ReadableArray readableArray, String str3, long j, long j2, @Nullable ReadableArray readableArray2, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
            this.mFromTime = j;
            this.mToTime = j2;
            this.mInclude = createSetFromIncludeArray(readableArray2);
        }

        private static Set<String> createSetFromIncludeArray(@Nullable ReadableArray readableArray) {
            HashSet hashSet = new HashSet();
            if (readableArray != null) {
                for (int i = 0; i < readableArray.size(); i++) {
                    String string = readableArray.getString(i);
                    if (string != null) {
                        hashSet.add(string);
                    }
                }
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) {
            Cursor cursorQuery;
            StringBuilder sb = new StringBuilder("1");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_PHOTOS)) {
                sb.append(" AND media_type = 1");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_VIDEOS)) {
                sb.append(" AND media_type = 3");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_ALL)) {
                sb.append(" AND media_type IN (3,1)");
            } else {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + this.mAssetType + "'. Expected one of 'Photos', 'Videos' or 'All'.");
                return;
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            long j = this.mFromTime;
            if (j > 0) {
                sb.append(" AND (datetaken > ? OR ( datetaken IS NULL AND date_added> ? ))");
                arrayList.add(this.mFromTime + "");
                arrayList.add((j / 1000) + "");
            }
            long j2 = this.mToTime;
            if (j2 > 0) {
                sb.append(" AND (datetaken <= ? OR ( datetaken IS NULL AND date_added <= ? ))");
                arrayList.add(this.mToTime + "");
                arrayList.add((j2 / 1000) + "");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                if (Build.VERSION.SDK_INT < 30) {
                    String str = "limit=" + (this.mFirst + 1);
                    if (!TextUtils.isEmpty(this.mAfter)) {
                        str = "limit=" + this.mAfter + "," + (this.mFirst + 1);
                    }
                    cursorQuery = contentResolver.query(MediaStore.Files.getContentUri("external").buildUpon().encodedQuery(str).build(), CameraRollModule.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "date_added DESC, date_modified DESC");
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("android:query-arg-sql-selection", sb.toString());
                    bundle.putStringArray("android:query-arg-sql-selection-args", (String[]) arrayList.toArray(new String[arrayList.size()]));
                    bundle.putString("android:query-arg-sql-sort-order", "date_added DESC, date_modified DESC");
                    bundle.putInt("android:query-arg-limit", this.mFirst + 1);
                    if (!TextUtils.isEmpty(this.mAfter)) {
                        bundle.putInt("android:query-arg-offset", Integer.parseInt(this.mAfter));
                    }
                    cursorQuery = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollModule.PROJECTION, bundle, null);
                }
                if (cursorQuery == null) {
                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Could not get media");
                    return;
                }
                try {
                    CameraRollModule.putEdges(contentResolver, cursorQuery, writableNativeMap, this.mFirst, this.mInclude);
                    CameraRollModule.putPageInfo(cursorQuery, writableNativeMap, this.mFirst, TextUtils.isEmpty(this.mAfter) ? 0 : Integer.parseInt(this.mAfter));
                } finally {
                    cursorQuery.close();
                    this.mPromise.resolve(writableNativeMap);
                }
            } catch (SecurityException e) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", e);
            }
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getAlbums(ReadableMap readableMap, Promise promise) {
        String string = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_ALL;
        StringBuilder sb = new StringBuilder("1");
        ArrayList arrayList = new ArrayList();
        if (string.equals(ASSET_TYPE_PHOTOS)) {
            sb.append(" AND media_type = 1");
        } else if (string.equals(ASSET_TYPE_VIDEOS)) {
            sb.append(" AND media_type = 3");
        } else if (string.equals(ASSET_TYPE_ALL)) {
            sb.append(" AND media_type IN (3,1)");
        } else {
            promise.reject(ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + string + "'. Expected one of 'Photos', 'Videos' or 'All'.");
            return;
        }
        try {
            Cursor cursorQuery = getReactApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"bucket_display_name", "bucket_id"}, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null);
            if (cursorQuery == null) {
                promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media");
                return;
            }
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            try {
                if (cursorQuery.moveToFirst()) {
                    HashMap map = new HashMap();
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("bucket_display_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("bucket_id");
                        if (columnIndex < 0) {
                            throw new IndexOutOfBoundsException();
                        }
                        String string2 = cursorQuery.getString(columnIndex2);
                        String string3 = cursorQuery.getString(columnIndex);
                        if (string3 != null) {
                            Map map2 = (Map) map.get(string3);
                            if (map2 != null) {
                                map2.put("count", Integer.valueOf(((Integer) map2.get("count")).intValue() + 1));
                            } else {
                                map.put(string3, new HashMap<String, Object>(string2) { // from class: com.reactnativecommunity.cameraroll.CameraRollModule.2
                                    final /* synthetic */ String val$albumId;

                                    {
                                        this.val$albumId = string2;
                                        put("id", string2);
                                        put("count", 1);
                                    }
                                });
                            }
                        }
                    } while (cursorQuery.moveToNext());
                    for (Map.Entry entry : map.entrySet()) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        Map map3 = (Map) entry.getValue();
                        writableNativeMap.putString("title", (String) entry.getKey());
                        writableNativeMap.putInt("count", ((Integer) map3.get("count")).intValue());
                        writableNativeMap.putString("id", (String) map3.get("id"));
                        writableNativeArray.pushMap(writableNativeMap);
                    }
                }
                cursorQuery.close();
                promise.resolve(writableNativeArray);
            } catch (Throwable th) {
                cursorQuery.close();
                promise.resolve(writableNativeArray);
                throw th;
            }
        } catch (Exception e) {
            promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            writableNativeMap.putString("end_cursor", Integer.toString(i2 + i));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static WritableMap convertMediaToMap(ContentResolver contentResolver, Cursor cursor, Set<String> set) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        int columnIndex3 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex("date_added");
        int columnIndex6 = cursor.getColumnIndex("date_modified");
        int columnIndex7 = cursor.getColumnIndex("width");
        int columnIndex8 = cursor.getColumnIndex("height");
        int columnIndex9 = cursor.getColumnIndex("_size");
        int columnIndex10 = cursor.getColumnIndex("_data");
        int columnIndex11 = cursor.getColumnIndex(INCLUDE_ORIENTATION);
        boolean zContains = set.contains("location");
        boolean zContains2 = set.contains(INCLUDE_FILENAME);
        boolean zContains3 = set.contains(INCLUDE_FILE_SIZE);
        boolean zContains4 = set.contains(INCLUDE_FILE_EXTENSION);
        boolean zContains5 = set.contains(INCLUDE_IMAGE_SIZE);
        boolean zContains6 = set.contains(INCLUDE_PLAYABLE_DURATION);
        boolean zContains7 = set.contains(INCLUDE_ORIENTATION);
        boolean zContains8 = set.contains(INCLUDE_ALBUMS);
        boolean zContains9 = set.contains(INCLUDE_SOURCE_TYPE);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        if (!putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex2, zContains2, zContains3, zContains4, zContains5, zContains6, zContains7)) {
            return null;
        }
        putBasicNodeInfo(cursor, writableNativeMap2, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, zContains8, zContains9);
        putLocationInfo(cursor, writableNativeMap2, columnIndex10, zContains, columnIndex2, contentResolver);
        writableNativeMap.putMap("node", writableNativeMap2);
        return writableNativeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, Set<String> set) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        cursor.moveToFirst();
        int i2 = 0;
        while (i2 < i && !cursor.isAfterLast()) {
            WritableMap writableMapConvertMediaToMap = convertMediaToMap(contentResolver, cursor, set);
            if (writableMapConvertMediaToMap != null) {
                writableNativeArray.pushMap(writableMapConvertMediaToMap);
            } else {
                i2--;
            }
            cursor.moveToNext();
            i2++;
        }
        writableMap.putArray("edges", writableNativeArray);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        writableMap.putString("id", Long.toString(cursor.getLong(i)));
        writableMap.putString("type", cursor.getString(i2));
        writableMap.putArray("subTypes", Arguments.createArray());
        if (z2) {
            writableMap.putString(INCLUDE_SOURCE_TYPE, "UserLibrary");
        } else {
            writableMap.putNull(INCLUDE_SOURCE_TYPE);
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (z) {
            writableArrayCreateArray.pushString(cursor.getString(i3));
        }
        writableMap.putArray("group_name", writableArrayCreateArray);
        long j = cursor.getLong(i4);
        if (j == 0) {
            j = cursor.getLong(i5) * 1000;
        }
        writableMap.putDouble(SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, j / 1000.0d);
        writableMap.putDouble("modificationTimestamp", cursor.getLong(i6));
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) throws FileNotFoundException {
        Uri uriWithAppendedId;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        int columnIndex = cursor.getColumnIndex("_id");
        long j = columnIndex >= 0 ? cursor.getLong(columnIndex) : -1L;
        String string = cursor.getString(i6);
        boolean z7 = string != null && string.startsWith("video");
        if (z7) {
            uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j);
        } else {
            uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j);
        }
        Uri uri = uriWithAppendedId;
        writableNativeMap.putString("uri", uri.toString());
        boolean zPutImageSize = putImageSize(contentResolver, cursor, writableNativeMap, i, i2, i5, uri, z7, z4);
        boolean zPutPlayableDuration = putPlayableDuration(contentResolver, writableNativeMap, uri, z7, z5);
        if (z) {
            writableNativeMap.putString(INCLUDE_FILENAME, new File(cursor.getString(i4)).getName());
        } else {
            writableNativeMap.putNull(INCLUDE_FILENAME);
        }
        if (z2) {
            writableNativeMap.putDouble(INCLUDE_FILE_SIZE, cursor.getLong(i3));
        } else {
            writableNativeMap.putNull(INCLUDE_FILE_SIZE);
        }
        if (z3) {
            writableNativeMap.putString(ShareConstants.MEDIA_EXTENSION, Utils.getExtension(string));
        } else {
            writableNativeMap.putNull(ShareConstants.MEDIA_EXTENSION);
        }
        if (z6) {
            if (cursor.isNull(i5)) {
                writableNativeMap.putInt(INCLUDE_ORIENTATION, cursor.getInt(i5));
            } else {
                writableNativeMap.putInt(INCLUDE_ORIENTATION, 0);
            }
        } else {
            writableNativeMap.putNull(INCLUDE_ORIENTATION);
        }
        writableMap.putMap("image", writableNativeMap);
        return zPutImageSize && zPutPlayableDuration;
    }

    private static boolean putPlayableDuration(ContentResolver contentResolver, WritableMap writableMap, Uri uri, boolean z, boolean z2) {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        writableMap.putNull(INCLUDE_PLAYABLE_DURATION);
        boolean z3 = true;
        if (z2 && z) {
            boolean z4 = false;
            Integer numValueOf = null;
            try {
                assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e) {
                FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                z3 = false;
                assetFileDescriptorOpenAssetFileDescriptor = null;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                } catch (RuntimeException unused) {
                }
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                    z4 = z3;
                } catch (NumberFormatException e2) {
                    FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused2) {
                }
                z3 = z4;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            if (numValueOf != null) {
                writableMap.putInt(INCLUDE_PLAYABLE_DURATION, numValueOf.intValue());
            }
        }
        return z3;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static boolean putImageSize(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, Uri uri, boolean z, boolean z2) throws FileNotFoundException {
        boolean z3;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        int i4;
        writableMap.putNull("width");
        writableMap.putNull("height");
        boolean z4 = true;
        if (!z2) {
            return true;
        }
        int i5 = cursor.getInt(i);
        int i6 = cursor.getInt(i2);
        if (i5 <= 0 || i6 <= 0) {
            boolean z5 = false;
            try {
                assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                z3 = true;
            } catch (FileNotFoundException e) {
                FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                z3 = false;
                assetFileDescriptorOpenAssetFileDescriptor = null;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                if (z) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                    } catch (RuntimeException unused) {
                    }
                    try {
                        i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        z5 = z3;
                    } catch (NumberFormatException e2) {
                        FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                    }
                    z4 = z5;
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor(), null, options);
                    int i7 = options.outWidth;
                    i6 = options.outHeight;
                    i5 = i7;
                    z4 = z3;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (IOException e3) {
                    FLog.e(ReactConstants.TAG, "Can't close media descriptor " + uri.toString(), e3);
                }
            } else {
                z4 = z3;
            }
        }
        if (!cursor.isNull(i3) && (i4 = cursor.getInt(i3)) >= 0 && i4 % RotationOptions.ROTATE_180 != 0) {
            int i8 = i6;
            i6 = i5;
            i5 = i8;
        }
        writableMap.putInt("width", i5);
        writableMap.putInt("height", i6);
        return z4;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, boolean z, int i2, ContentResolver contentResolver) {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        writableMap.putNull("location");
        if (z) {
            try {
                String string = cursor.getString(i2);
                if (string == null || !string.startsWith("video")) {
                    float[] fArr = new float[2];
                    if (new ExifInterface(cursor.getString(i)).getLatLong(fArr)) {
                        double d = fArr[1];
                        double d2 = fArr[0];
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putDouble("longitude", d);
                        writableNativeMap.putDouble("latitude", d2);
                        writableMap.putMap("location", writableNativeMap);
                        return;
                    }
                    return;
                }
                Uri uri = Uri.parse("file://" + cursor.getString(i));
                try {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                } catch (FileNotFoundException e) {
                    FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                }
                AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptor != null) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
                    } catch (RuntimeException unused) {
                    }
                    try {
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(23);
                        if (strExtractMetadata != null) {
                            String strReplaceAll = strExtractMetadata.replaceAll(DomExceptionUtils.SEPARATOR, "");
                            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                            writableNativeMap2.putDouble("latitude", Double.parseDouble(strReplaceAll.split("[+]|[-]")[1]));
                            writableNativeMap2.putDouble("longitude", Double.parseDouble(strReplaceAll.split("[+]|[-]")[2]));
                            writableMap.putMap("location", writableNativeMap2);
                        }
                    } catch (NumberFormatException e2) {
                        FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                    }
                }
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (IOException e3) {
                FLog.e(ReactConstants.TAG, "Could not read the metadata", e3);
            }
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
        if (readableArray.size() == 0) {
            promise.reject(ERROR_UNABLE_TO_DELETE, "Need at least one URI to delete");
        } else {
            deleteMediaFiles(readableArray, promise);
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotoByInternalID(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoByInternalID", "getPhotoByInternalID is not supported on Android");
    }

    private static class DeletePhotos extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final Promise mPromise;
        private final ReadableArray mUris;

        public DeletePhotos(ReactContext reactContext, ReadableArray readableArray, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUris = readableArray;
            this.mPromise = promise;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            int i = 0;
            String[] strArr = {"_id"};
            String str = "?";
            for (int i2 = 1; i2 < this.mUris.size(); i2++) {
                str = str + ", ?";
            }
            String str2 = "_data IN (" + str + ")";
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = new String[this.mUris.size()];
            for (int i3 = 0; i3 < this.mUris.size(); i3++) {
                strArr2[i3] = Uri.parse(this.mUris.getString(i3)).getPath();
            }
            Cursor cursorQuery = contentResolver.query(uri, strArr, str2, strArr2, null);
            while (cursorQuery.moveToNext()) {
                if (contentResolver.delete(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"))), null, null) == 1) {
                    i++;
                }
            }
            cursorQuery.close();
            if (i == this.mUris.size()) {
                this.mPromise.resolve(true);
            } else {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_DELETE, "Could not delete all media, only deleted " + i + " photos.");
            }
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotoThumbnail(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoThumbnail", "getPhotoThumbnail is not supported on Android");
    }
}
