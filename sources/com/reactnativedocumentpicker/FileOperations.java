package com.reactnativedocumentpicker;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.FileUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.util.RNLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FileOperations.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J2\u0010\u0017\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002J\"\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020&R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/reactnativedocumentpicker/FileOperations;", "", "uriMap", "", "", "Landroid/net/Uri;", "<init>", "(Ljava/util/Map;)V", "copyFilesToLocalStorage", "Lcom/facebook/react/bridge/ReadableArray;", "context", "Lcom/facebook/react/bridge/ReactContext;", "filesToCopy", "copyTo", "Lcom/reactnativedocumentpicker/CopyDestination;", "(Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/ReadableArray;Lcom/reactnativedocumentpicker/CopyDestination;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copySingleFile", "Lcom/facebook/react/bridge/ReadableMap;", "map", "destinationDir", "Ljava/io/File;", "getUniqueDir", "Landroid/content/Context;", "copyFile", "from", "fileName", "convertVirtualFileAsType", "getInputStreamForVirtualFile", "Ljava/io/InputStream;", "contentResolver", "Landroid/content/ContentResolver;", "safeGetDestination", "destFile", "expectedDir", "writeDocumentImpl", "Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", "sourceUri", "targetUriString", "Lcom/facebook/react/bridge/ReactApplicationContext;", "copyStreamToAnother", "Lkotlin/Function2;", "Ljava/io/OutputStream;", "", "getCopyStreamToAnother", "()Lkotlin/jvm/functions/Function2;", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileOperations {
    private final Function2<InputStream, OutputStream, Long> copyStreamToAnother;
    private final Map<String, Uri> uriMap;

    public FileOperations(Map<String, Uri> uriMap) {
        Intrinsics.checkNotNullParameter(uriMap, "uriMap");
        this.uriMap = uriMap;
        this.copyStreamToAnother = new Function2() { // from class: com.reactnativedocumentpicker.FileOperations$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(FileOperations.copyStreamToAnother$lambda$3((InputStream) obj, (OutputStream) obj2));
            }
        };
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileOperations.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/facebook/react/bridge/WritableArray;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2", f = "FileOperations.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"results"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableArray>, Object> {
        final /* synthetic */ ReactContext $context;
        final /* synthetic */ CopyDestination $copyTo;
        final /* synthetic */ ReadableArray $filesToCopy;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ReactContext reactContext, CopyDestination copyDestination, ReadableArray readableArray, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = reactContext;
            this.$copyTo = copyDestination;
            this.$filesToCopy = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = FileOperations.this.new AnonymousClass2(this.$context, this.$copyTo, this.$filesToCopy, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WritableArray> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            WritableArray writableArray;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                File uniqueDir = FileOperations.this.getUniqueDir(this.$context, this.$copyTo);
                IntRange intRangeUntil = RangesKt.until(0, this.$filesToCopy.size());
                ReadableArray readableArray = this.$filesToCopy;
                FileOperations fileOperations = FileOperations.this;
                ReactContext reactContext = this.$context;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1 fileOperations$copyFilesToLocalStorage$2$copyJobs$1$1 = new FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(readableArray, ((IntIterator) it).nextInt(), fileOperations, reactContext, uniqueDir, null);
                    ReactContext reactContext2 = reactContext;
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, fileOperations$copyFilesToLocalStorage$2$copyJobs$1$1, 3, null));
                    readableArray = readableArray;
                    fileOperations = fileOperations;
                    reactContext = reactContext2;
                }
                WritableArray writableArrayCreateArray = Arguments.createArray();
                this.L$0 = writableArrayCreateArray;
                this.label = 1;
                Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                writableArray = writableArrayCreateArray;
                obj = objAwaitAll;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                writableArray = (WritableArray) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Iterator it2 = ((Iterable) obj).iterator();
            while (it2.hasNext()) {
                writableArray.pushMap((WritableMap) it2.next());
            }
            return writableArray;
        }
    }

    public final Object copyFilesToLocalStorage(ReactContext reactContext, ReadableArray readableArray, CopyDestination copyDestination, Continuation<? super ReadableArray> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(reactContext, copyDestination, readableArray, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMap copySingleFile(ReadableMap map, ReactContext context, File destinationDir) throws IOException {
        String string = map.getString("uri");
        if (string == null) {
            throw new IllegalArgumentException("URI is missing");
        }
        String string2 = map.getString("fileName");
        if (string2 == null) {
            throw new IllegalArgumentException("fileName is missing");
        }
        String string3 = map.getString("convertVirtualFileToType");
        Uri uri = this.uriMap.get(string);
        if (uri == null) {
            RNLog.w(context, "keepLocalCopy: You're trying to copy a file \"" + string2 + "\" that wasn't picked with this module. This can lead to permission errors because the file reference is transient to your activity's current lifecycle. See https://developer.android.com/guide/components/intents-common#GetFile . Please use the result from the picker directly.");
        }
        ReactContext reactContext = context;
        if (uri == null) {
            uri = Uri.parse(string);
        }
        Uri uri2 = uri;
        Intrinsics.checkNotNull(uri2);
        File fileCopyFile = copyFile(reactContext, uri2, destinationDir, string2, string3);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("status", "success");
        writableMapCreateMap.putString("localUri", Uri.fromFile(fileCopyFile).toString());
        writableMapCreateMap.putString("sourceUri", string);
        return writableMapCreateMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getUniqueDir(Context context, CopyDestination copyTo) throws IOException {
        File file = new File(copyTo == CopyDestination.DOCUMENT_DIRECTORY ? context.getFilesDir() : context.getCacheDir(), UUID.randomUUID().toString());
        if (file.mkdir()) {
            return file;
        }
        throw new IOException("Failed to create directory at " + file.getAbsolutePath());
    }

    private final File copyFile(Context context, Uri from, File destinationDir, String fileName, String convertVirtualFileAsType) throws IOException {
        final File fileSafeGetDestination = safeGetDestination(new File(destinationDir, fileName), destinationDir);
        Function1 function1 = new Function1() { // from class: com.reactnativedocumentpicker.FileOperations$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileOperations.copyFile$lambda$0(this.f$0, fileSafeGetDestination, (InputStream) obj);
            }
        };
        if (convertVirtualFileAsType == null) {
            function1.invoke(context.getContentResolver().openInputStream(from));
            return fileSafeGetDestination;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        function1.invoke(getInputStreamForVirtualFile(contentResolver, from, convertVirtualFileAsType));
        return fileSafeGetDestination;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyFile$lambda$0(FileOperations fileOperations, File file, InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new FileNotFoundException("No input stream was found for the source file");
        }
        if (fileOperations.copyStreamToAnother.invoke(inputStream, new FileOutputStream(file)).longValue() == 0) {
            throw new IOException("No data was copied to the destination file");
        }
        return Unit.INSTANCE;
    }

    private final InputStream getInputStreamForVirtualFile(ContentResolver contentResolver, Uri from, String convertVirtualFileAsType) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(from, convertVirtualFileAsType, null);
        return assetFileDescriptorOpenTypedAssetFileDescriptor != null ? assetFileDescriptorOpenTypedAssetFileDescriptor.createInputStream() : null;
    }

    private final File safeGetDestination(File destFile, File expectedDir) throws IOException {
        String canonicalPath = destFile.getCanonicalPath();
        Intrinsics.checkNotNull(canonicalPath);
        String canonicalPath2 = expectedDir.getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "getCanonicalPath(...)");
        if (StringsKt.startsWith$default(canonicalPath, canonicalPath2, false, 2, (Object) null)) {
            return destFile;
        }
        throw new IllegalArgumentException("The copied file is attempting to write outside of the target directory.");
    }

    public final DocumentMetadataBuilder writeDocumentImpl(Uri sourceUri, String targetUriString, ReactApplicationContext context) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sourceUri == null) {
            throw new IllegalArgumentException("The source URI is null. Call saveDocument() before writeDocument()");
        }
        Uri uri = this.uriMap.get(targetUriString);
        if (uri == null) {
            RNLog.e(context, "writeDocument: You're trying to write from Uri \"" + targetUriString + "\" that wasn't picked with this module. Please use the result from saveDocument()");
            throw new IllegalArgumentException("The provided URI is not known");
        }
        DocumentMetadataBuilder documentMetadataBuilder = new DocumentMetadataBuilder(uri);
        ContentResolver contentResolver = context.getContentResolver();
        documentMetadataBuilder.mimeType(contentResolver.getType(uri));
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(sourceUri);
        if (inputStreamOpenInputStream == null) {
            return documentMetadataBuilder.metadataReadingError("No input stream found for source file");
        }
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            return documentMetadataBuilder.metadataReadingError("No output stream found for destination file");
        }
        if (this.copyStreamToAnother.invoke(inputStreamOpenInputStream, outputStreamOpenOutputStream).longValue() == 0) {
            documentMetadataBuilder.metadataReadingError("No data was copied to the destination file");
        }
        return documentMetadataBuilder;
    }

    public final Function2<InputStream, OutputStream, Long> getCopyStreamToAnother() {
        return this.copyStreamToAnother;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long copyStreamToAnother$lambda$3(InputStream inputStream, OutputStream outputStream) {
        long jCopyTo$default;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        InputStream inputStream2 = inputStream;
        try {
            OutputStream outputStream2 = outputStream;
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    jCopyTo$default = FileUtils.copy(inputStream, outputStream);
                } else {
                    jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream, outputStream, 0, 2, null);
                }
                CloseableKt.closeFinally(outputStream2, null);
                CloseableKt.closeFinally(inputStream2, null);
                return jCopyTo$default;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream2, th3);
                throw th4;
            }
        }
    }
}
