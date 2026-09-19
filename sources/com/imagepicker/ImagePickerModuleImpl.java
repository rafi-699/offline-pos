package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
public class ImagePickerModuleImpl implements ActivityEventListener {
    static final String NAME = "ImagePicker";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_LIBRARY = 13003;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13002;
    Callback callback;
    Uri cameraCaptureURI;
    private Uri fileUri;
    Options options;
    private ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public void launchCamera(ReadableMap readableMap, Callback callback) {
        Intent intent;
        File fileCreateFile;
        int i;
        if (!Utils.isCameraAvailable(this.reactContext)) {
            callback.invoke(Utils.getErrorMap(Utils.errCameraUnavailable, null));
            return;
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        if (!Utils.isCameraPermissionFulfilled(this.reactContext, currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, Utils.cameraPermissionDescription));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        if (options.saveToPhotos.booleanValue() && Build.VERSION.SDK_INT <= 28 && !Utils.hasPermission(currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errPermission, null));
            return;
        }
        if (this.options.mediaType.equals(Utils.mediaTypeVideo)) {
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", this.options.videoQuality);
            if (this.options.durationLimit > 0) {
                intent.putExtra("android.intent.extra.durationLimit", this.options.durationLimit);
            }
            fileCreateFile = Utils.createFile(this.reactContext, "mp4");
            this.cameraCaptureURI = Utils.createUri(fileCreateFile, this.reactContext);
            i = REQUEST_LAUNCH_VIDEO_CAPTURE;
        } else {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            fileCreateFile = Utils.createFile(this.reactContext, "jpg");
            this.cameraCaptureURI = Utils.createUri(fileCreateFile, this.reactContext);
            i = REQUEST_LAUNCH_IMAGE_CAPTURE;
        }
        if (this.options.useFrontCamera.booleanValue()) {
            Utils.setFrontCamera(intent);
        }
        this.fileUri = Uri.fromFile(fileCreateFile);
        intent.putExtra("output", this.cameraCaptureURI);
        intent.addFlags(3);
        try {
            currentActivity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType;
        ActivityResultContracts.PickMultipleVisualMedia pickMultipleVisualMedia;
        Intent intentCreateIntent2;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        int i = options.selectionLimit;
        boolean z = i == 1;
        boolean zEquals = this.options.mediaType.equals(Utils.mediaTypePhoto);
        boolean zEquals2 = this.options.mediaType.equals(Utils.mediaTypeVideo);
        if (zEquals) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
        } else if (zEquals2) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
        } else {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        PickVisualMediaRequest pickVisualMediaRequestBuild = new PickVisualMediaRequest.Builder().setMediaType(visualMediaType).build();
        if (z) {
            intentCreateIntent2 = new ActivityResultContracts.PickVisualMedia().createIntent(this.reactContext.getApplicationContext(), pickVisualMediaRequestBuild);
        } else {
            if (i > 1) {
                pickMultipleVisualMedia = new ActivityResultContracts.PickMultipleVisualMedia(i);
            } else {
                pickMultipleVisualMedia = new ActivityResultContracts.PickMultipleVisualMedia();
            }
            intentCreateIntent2 = pickMultipleVisualMedia.createIntent(this.reactContext.getApplicationContext(), pickVisualMediaRequestBuild);
        }
        if (this.options.restrictMimeTypes.length > 0) {
            intentCreateIntent2.putExtra("android.intent.extra.MIME_TYPES", this.options.restrictMimeTypes);
        }
        try {
            currentActivity.startActivityForResult(intentCreateIntent2, REQUEST_LAUNCH_LIBRARY);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    void onAssetsObtained(final List<Uri> list) {
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.imagepicker.ImagePickerModuleImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAssetsObtained$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAssetsObtained$0(List list) {
        try {
            this.callback.invoke(Utils.getResponseMap(list, this.options, this.reactContext));
        } catch (RuntimeException e) {
            this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
        } finally {
            this.callback = null;
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (!Utils.isValidRequestCode(i) || this.callback == null) {
            return;
        }
        if (i2 != -1) {
            if (i == 13001) {
                Utils.deleteFile(this.fileUri);
            }
            try {
                try {
                    this.callback.invoke(Utils.getCancelMap());
                    this.callback = null;
                    return;
                } catch (RuntimeException e) {
                    this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
                    this.callback = null;
                }
            } catch (Throwable th) {
                this.callback = null;
                throw th;
            }
        }
        switch (i) {
            case REQUEST_LAUNCH_IMAGE_CAPTURE /* 13001 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_VIDEO_CAPTURE /* 13002 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, "video");
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_LIBRARY /* 13003 */:
                onAssetsObtained(Utils.collectUrisFromData(intent));
                return;
            default:
                return;
        }
    }
}
