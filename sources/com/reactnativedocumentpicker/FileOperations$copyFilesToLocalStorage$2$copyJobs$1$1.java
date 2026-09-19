package com.reactnativedocumentpicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileOperations.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/facebook/react/bridge/WritableMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1", f = "FileOperations.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableMap>, Object> {
    final /* synthetic */ ReactContext $context;
    final /* synthetic */ File $destinationDir;
    final /* synthetic */ ReadableArray $filesToCopy;
    final /* synthetic */ int $i;
    int label;
    final /* synthetic */ FileOperations this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(ReadableArray readableArray, int i, FileOperations fileOperations, ReactContext reactContext, File file, Continuation<? super FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1> continuation) {
        super(2, continuation);
        this.$filesToCopy = readableArray;
        this.$i = i;
        this.this$0 = fileOperations;
        this.$context = reactContext;
        this.$destinationDir = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(this.$filesToCopy, this.$i, this.this$0, this.$context, this.$destinationDir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WritableMap> continuation) {
        return ((FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMap map = this.$filesToCopy.getMap(this.$i);
        try {
            if (map == null) {
                throw new IllegalArgumentException("keepLocalCopy: The file argument is null at index " + this.$i);
            }
            writableMapCreateMap.merge(this.this$0.copySingleFile(map, this.$context, this.$destinationDir));
            return writableMapCreateMap;
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null && (localizedMessage = e.getMessage()) == null) {
                localizedMessage = "Unknown error";
            }
            writableMapCreateMap.putString("status", "error");
            writableMapCreateMap.putString("copyError", localizedMessage);
            writableMapCreateMap.putString("sourceUri", map != null ? map.getString("uri") : null);
            return writableMapCreateMap;
        }
    }
}
