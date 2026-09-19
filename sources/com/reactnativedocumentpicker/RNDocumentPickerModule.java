package com.reactnativedocumentpicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RNDocumentPickerModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010*\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0003J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u0019H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/reactnativedocumentpicker/RNDocumentPickerModule;", "Lcom/reactnativedocumentpicker/NativeDocumentPickerSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "currentPickOptions", "Lcom/reactnativedocumentpicker/PickOptions;", "currentUriOfFileBeingExported", "Landroid/net/Uri;", "promiseWrapper", "Lcom/reactnativedocumentpicker/PromiseWrapper;", "pickedFilesUriMap", "", "", "metadataGetter", "Lcom/reactnativedocumentpicker/MetadataGetter;", "fileOps", "Lcom/reactnativedocumentpicker/FileOperations;", "fileCopyingCoroutine", "Lkotlinx/coroutines/CoroutineScope;", "activityEventListener", "Lcom/facebook/react/bridge/ActivityEventListener;", "invalidate", "", "pick", "opts", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "saveDocument", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "pickDirectory", "keepLocalCopy", "isKnownType", "Lcom/facebook/react/bridge/WritableMap;", "kind", "value", "releaseSecureAccess", "uris", "Lcom/facebook/react/bridge/ReadableArray;", "releaseLongTermAccess", "processDirectoryPickerResult", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "writeDocuments", "processSaveAsResult", "processFilePickerResult", "onHostResume", "onHostPause", "onHostDestroy", "Companion", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNDocumentPickerModule extends NativeDocumentPickerSpec implements LifecycleEventListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String E_INVALID_DATA_RETURNED = "INVALID_DATA_RETURNED";
    private static final String E_OTHER_PRESENTING_ERROR = "OTHER_PRESENTING_ERROR";
    private static final int PICK_DIR_REQUEST_CODE = 42;
    private static final int PICK_FILES_REQUEST_CODE = 41;
    private static final String PRESENTER_IS_NULL = "NULL_PRESENTER";
    private static final int SAVE_DOC_REQUEST_CODE = 43;
    private static final String UNABLE_TO_OPEN_FILE_TYPE = "UNABLE_TO_OPEN_FILE_TYPE";
    private final ActivityEventListener activityEventListener;
    private PickOptions currentPickOptions;
    private Uri currentUriOfFileBeingExported;
    private final CoroutineScope fileCopyingCoroutine;
    private final FileOperations fileOps;
    private final MetadataGetter metadataGetter;
    private final Map<String, Uri> pickedFilesUriMap;
    private final PromiseWrapper promiseWrapper;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNDocumentPickerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.promiseWrapper = new PromiseWrapper(NativeDocumentPickerSpec.NAME);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.pickedFilesUriMap = linkedHashMap;
        this.metadataGetter = new MetadataGetter(linkedHashMap);
        this.fileOps = new FileOperations(linkedHashMap);
        this.fileCopyingCoroutine = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        BaseActivityEventListener baseActivityEventListener = new BaseActivityEventListener() { // from class: com.reactnativedocumentpicker.RNDocumentPickerModule$activityEventListener$1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (requestCode == 41 || requestCode == 42 || requestCode == 43) {
                    if (resultCode != -1) {
                        if (resultCode == 0) {
                            this.this$0.promiseWrapper.rejectAsUserCancelledOperation();
                            return;
                        } else {
                            this.this$0.promiseWrapper.reject("UNEXPECTED_ACTIVITY_RESULT", "Unknown activity result: " + resultCode, null);
                            return;
                        }
                    }
                    if (data == null) {
                        this.this$0.promiseWrapper.reject("INVALID_DATA_RETURNED", "Data from document picker is null");
                        return;
                    }
                    switch (requestCode) {
                        case 41:
                            this.this$0.processFilePickerResult(data);
                            break;
                        case 42:
                            this.this$0.processDirectoryPickerResult(data);
                            break;
                        case 43:
                            this.this$0.processSaveAsResult(data);
                            break;
                        default:
                            this.this$0.promiseWrapper.reject("UNEXPECTED_ACTIVITY_RESULT", "Unknown activity result: " + resultCode, null);
                            break;
                    }
                }
            }
        };
        this.activityEventListener = baseActivityEventListener;
        reactContext.addActivityEventListener(baseActivityEventListener);
        reactContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        CoroutineScopeKt.cancel$default(this.fileCopyingCoroutine, "module invalidated", null, 2, null);
        getReactApplicationContext().removeActivityEventListener(this.activityEventListener);
        super.invalidate();
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void pick(ReadableMap opts, Promise promise) {
        Intrinsics.checkNotNullParameter(opts, "opts");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            INSTANCE.rejectWithNullActivity(promise);
            return;
        }
        if (this.promiseWrapper.trySetPromiseRejectingIncoming(promise, "pick")) {
            PickOptions pickOptions = PickOptionsKt.parsePickOptions(opts);
            this.currentPickOptions = pickOptions;
            try {
                currentActivity.startActivityForResult(IntentFactory.INSTANCE.getPickIntent(pickOptions), 41);
            } catch (ActivityNotFoundException e) {
                this.promiseWrapper.reject(UNABLE_TO_OPEN_FILE_TYPE, e);
            } catch (Exception e2) {
                this.promiseWrapper.reject(E_OTHER_PRESENTING_ERROR, e2);
            }
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void saveDocument(ReadableMap options, Promise promise) {
        String type;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            INSTANCE.rejectWithNullActivity(promise);
            return;
        }
        if (this.promiseWrapper.trySetPromiseRejectingIncoming(promise, "saveDocuments")) {
            try {
                ReadableArray array = options.getArray("sourceUris");
                Intrinsics.checkNotNull(array);
                Uri uri = Uri.parse(array.getString(0));
                this.currentUriOfFileBeingExported = uri;
                if (options.hasKey("mimeType")) {
                    type = options.getString("mimeType");
                } else {
                    type = getReactApplicationContext().getContentResolver().getType(uri);
                    if (type == null) {
                        throw new IllegalStateException("MIME type could not be determined from the URI");
                    }
                }
                String string = options.hasKey("fileName") ? options.getString("fileName") : null;
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType(type);
                if (string != null) {
                    intent.putExtra("android.intent.extra.TITLE", string);
                }
                if (Build.VERSION.SDK_INT >= 26 && options.hasKey("initialUri")) {
                    intent.putExtra("android.provider.extra.INITIAL_URI", options.getString("initialUri"));
                }
                currentActivity.startActivityForResult(intent, 43);
            } catch (ActivityNotFoundException e) {
                this.promiseWrapper.reject(UNABLE_TO_OPEN_FILE_TYPE, e);
            } catch (Exception e2) {
                this.promiseWrapper.reject(E_OTHER_PRESENTING_ERROR, e2);
            }
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void pickDirectory(ReadableMap opts, Promise promise) {
        Intrinsics.checkNotNullParameter(opts, "opts");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            INSTANCE.rejectWithNullActivity(promise);
            return;
        }
        if (this.promiseWrapper.trySetPromiseRejectingIncoming(promise, "pickDirectory")) {
            PickOptions pickOptions = PickOptionsKt.parsePickOptions(opts);
            this.currentPickOptions = pickOptions;
            try {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                if (Build.VERSION.SDK_INT >= 26 && pickOptions.getInitialDirectoryUrl() != null) {
                    intent.putExtra("android.provider.extra.INITIAL_URI", pickOptions.getInitialDirectoryUrl());
                }
                currentActivity.startActivityForResult(intent, 42);
            } catch (ActivityNotFoundException e) {
                this.promiseWrapper.reject(UNABLE_TO_OPEN_FILE_TYPE, e);
            } catch (Exception e2) {
                this.promiseWrapper.reject(E_OTHER_PRESENTING_ERROR, e2);
            }
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    @ReactMethod
    public void keepLocalCopy(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ReadableArray array = options.getArray("files");
        String string = options.getString("destination");
        if (string != null && array != null) {
            BuildersKt__Builders_commonKt.launch$default(this.fileCopyingCoroutine, null, null, new AnonymousClass1(array, string, promise, null), 3, null);
        } else {
            promise.reject("keepLocalCopy", "You did not provide the correct options. Expected 'files' and 'destination', got: " + options.toHashMap().keySet());
        }
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$keepLocalCopy$1, reason: invalid class name */
    /* JADX INFO: compiled from: RNDocumentPickerModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$keepLocalCopy$1", f = "RNDocumentPickerModule.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $copyTo;
        final /* synthetic */ ReadableArray $filesToCopy;
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReadableArray readableArray, String str, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$filesToCopy = readableArray;
            this.$copyTo = str;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RNDocumentPickerModule.this.new AnonymousClass1(this.$filesToCopy, this.$copyTo, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FileOperations fileOperations = RNDocumentPickerModule.this.fileOps;
                ReactApplicationContext reactApplicationContext = RNDocumentPickerModule.this.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                this.label = 1;
                obj = fileOperations.copyFilesToLocalStorage(reactApplicationContext, this.$filesToCopy, CopyDestination.INSTANCE.fromPath(this.$copyTo), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$promise.resolve((ReadableArray) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public WritableMap isKnownType(String kind, String value) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(value, "value");
        return IsKnownTypeImpl.INSTANCE.isKnownType(kind, value);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void releaseSecureAccess(ReadableArray uris, Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(null);
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void releaseLongTermAccess(ReadableArray uris, Promise promise) {
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        int size = uris.size();
        for (int i = 0; i < size; i++) {
            String string = uris.getString(i);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("uri", string);
            try {
                contentResolver.releasePersistableUriPermission(Uri.parse(string), 3);
                writableMapCreateMap.putString("status", "success");
            } catch (Exception e) {
                writableMapCreateMap.putString("status", "error");
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                writableMapCreateMap.putString("errorMessage", message);
            }
            writableArrayCreateArray.pushMap(writableMapCreateMap);
        }
        promise.resolve(writableArrayCreateArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processDirectoryPickerResult(Intent intent) {
        Uri data = intent.getData();
        PickOptions pickOptions = this.currentPickOptions;
        if (data == null || pickOptions == null) {
            this.promiseWrapper.reject(E_INVALID_DATA_RETURNED, "Data from document picker is null");
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", data.toString());
        if (pickOptions.getRequestLongTermAccess()) {
            try {
                getReactApplicationContext().getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 3);
                String string = data.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String strEncodeToString = Base64.encodeToString(bytes, 0);
                writableMapCreateMap.putString("bookmarkStatus", "success");
                writableMapCreateMap.putString("bookmark", strEncodeToString);
            } catch (Exception e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null && (localizedMessage = e.getMessage()) == null) {
                    localizedMessage = "Unknown error with takePersistableUriPermission";
                }
                writableMapCreateMap.putString("bookmarkStatus", "error");
                writableMapCreateMap.putString("bookmarkError", localizedMessage);
            }
        }
        this.promiseWrapper.resolve(writableMapCreateMap);
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$writeDocuments$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RNDocumentPickerModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$writeDocuments$1", f = "RNDocumentPickerModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReadableMap $options;
        final /* synthetic */ Promise $promise;
        int label;
        final /* synthetic */ RNDocumentPickerModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01521(ReadableMap readableMap, RNDocumentPickerModule rNDocumentPickerModule, Promise promise, Continuation<? super C01521> continuation) {
            super(2, continuation);
            this.$options = readableMap;
            this.this$0 = rNDocumentPickerModule;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01521(this.$options, this.this$0, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                String string = this.$options.hasKey("uri") ? this.$options.getString("uri") : null;
                FileOperations fileOperations = this.this$0.fileOps;
                Uri uri = this.this$0.currentUriOfFileBeingExported;
                ReactApplicationContext reactApplicationContext = this.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                DocumentMetadataBuilder documentMetadataBuilderWriteDocumentImpl = fileOperations.writeDocumentImpl(uri, string, reactApplicationContext);
                MetadataGetter metadataGetter = this.this$0.metadataGetter;
                ContentResolver contentResolver = this.this$0.getReactApplicationContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
                metadataGetter.queryContentResolverMetadata(contentResolver, documentMetadataBuilderWriteDocumentImpl, false);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                writableArrayCreateArray.pushMap(documentMetadataBuilderWriteDocumentImpl.build());
                this.$promise.resolve(writableArrayCreateArray);
            } catch (Exception e) {
                this.$promise.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.reactnativedocumentpicker.NativeDocumentPickerSpec
    public void writeDocuments(ReadableMap options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(this.fileCopyingCoroutine, null, null, new C01521(options, this, promise, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSaveAsResult(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            this.pickedFilesUriMap.put(data.toString(), data);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("uri", data.toString());
            this.promiseWrapper.resolve(writableMapCreateMap);
            return;
        }
        this.promiseWrapper.reject(E_INVALID_DATA_RETURNED, "Data from document picker is null");
    }

    public final void processFilePickerResult(Intent intent) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Uri data = intent.getData();
        ClipData clipData = intent.getClipData();
        if (clipData != null && clipData.getItemCount() > 0) {
            IntRange intRangeUntil = RangesKt.until(0, clipData.getItemCount());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(clipData.getItemAt(((IntIterator) it).nextInt()).getUri());
            }
            arrayListEmptyList = arrayList;
        } else if (data != null) {
            arrayListEmptyList = CollectionsKt.listOf(data);
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        BuildersKt__Builders_commonKt.launch$default(this.fileCopyingCoroutine, null, null, new C01511(arrayListEmptyList, null), 3, null);
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.RNDocumentPickerModule$processFilePickerResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RNDocumentPickerModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.RNDocumentPickerModule$processFilePickerResult$1", f = "RNDocumentPickerModule.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
    static final class C01511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $uris;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01511(List<? extends Uri> list, Continuation<? super C01511> continuation) {
            super(2, continuation);
            this.$uris = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RNDocumentPickerModule.this.new C01511(this.$uris, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PickOptions pickOptions = RNDocumentPickerModule.this.currentPickOptions;
                    if (pickOptions != null) {
                        MetadataGetter metadataGetter = RNDocumentPickerModule.this.metadataGetter;
                        ReactApplicationContext reactApplicationContext = RNDocumentPickerModule.this.getReactApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "access$getReactApplicationContext(...)");
                        this.label = 1;
                        obj = metadataGetter.processPickedFileUris(reactApplicationContext, this.$uris, pickOptions, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RNDocumentPickerModule.this.promiseWrapper.resolve((ReadableArray) obj);
            } catch (Exception e) {
                RNDocumentPickerModule.this.promiseWrapper.reject(e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: RNDocumentPickerModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reactnativedocumentpicker/RNDocumentPickerModule$Companion;", "", "<init>", "()V", "rejectWithNullActivity", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "PICK_FILES_REQUEST_CODE", "", "PICK_DIR_REQUEST_CODE", "SAVE_DOC_REQUEST_CODE", "PRESENTER_IS_NULL", "", RNDocumentPickerModule.UNABLE_TO_OPEN_FILE_TYPE, "E_OTHER_PRESENTING_ERROR", "E_INVALID_DATA_RETURNED", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void rejectWithNullActivity(Promise promise) {
            Intrinsics.checkNotNullParameter(promise, "promise");
            promise.reject(RNDocumentPickerModule.PRESENTER_IS_NULL, RNDocumentPickerModule.PRESENTER_IS_NULL);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        CoroutineScopeKt.cancel$default(this.fileCopyingCoroutine, "host destroyed", null, 2, null);
    }
}
