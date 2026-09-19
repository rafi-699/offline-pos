package com.reactnativedocumentpicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MetadataGetter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ3\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001d0\"H\u0002¢\u0006\u0002\u0010#R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/reactnativedocumentpicker/MetadataGetter;", "", "uriMap", "", "", "Landroid/net/Uri;", "<init>", "(Ljava/util/Map;)V", "processPickedFileUris", "Lcom/facebook/react/bridge/ReadableArray;", "context", "Landroid/content/Context;", "uris", "", "pickOptions", "Lcom/reactnativedocumentpicker/PickOptions;", "(Landroid/content/Context;Ljava/util/List;Lcom/reactnativedocumentpicker/PickOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadataForUri", "Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", "sourceUri", "(Landroid/content/Context;Landroid/net/Uri;Lcom/reactnativedocumentpicker/PickOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryContentResolverMetadata", "", "contentResolver", "Landroid/content/ContentResolver;", "metadataBuilder", "couldBeVirtualFile", "", "getCursorValue", "T", "cursor", "Landroid/database/Cursor;", "columnName", "valueType", "Ljava/lang/Class;", "(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "react-native-documents_picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MetadataGetter {
    private final Map<String, Uri> uriMap;

    public MetadataGetter(Map<String, Uri> uriMap) {
        Intrinsics.checkNotNullParameter(uriMap, "uriMap");
        this.uriMap = uriMap;
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetadataGetter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/facebook/react/bridge/WritableArray;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.MetadataGetter$processPickedFileUris$2", f = "MetadataGetter.kt", i = {0, 0}, l = {27}, m = "invokeSuspend", n = {"results", "uri"}, s = {"L$0", "L$2"})
    static final class C01502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableArray>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ PickOptions $pickOptions;
        final /* synthetic */ List<Uri> $uris;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MetadataGetter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01502(List<? extends Uri> list, MetadataGetter metadataGetter, Context context, PickOptions pickOptions, Continuation<? super C01502> continuation) {
            super(2, continuation);
            this.$uris = list;
            this.this$0 = metadataGetter;
            this.$context = context;
            this.$pickOptions = pickOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01502(this.$uris, this.this$0, this.$context, this.$pickOptions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WritableArray> continuation) {
            return ((C01502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0038  */
        /* JADX WARN: Code duplicated, block: B:13:0x0056 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0054 -> B:14:0x0057). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r8.L$2
                android.net.Uri r1 = (android.net.Uri) r1
                java.lang.Object r3 = r8.L$1
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r8.L$0
                com.facebook.react.bridge.WritableArray r4 = (com.facebook.react.bridge.WritableArray) r4
                kotlin.ResultKt.throwOnFailure(r9)
                goto L57
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                com.facebook.react.bridge.WritableArray r9 = com.facebook.react.bridge.Arguments.createArray()
                java.util.List<android.net.Uri> r1 = r8.$uris
                java.util.Iterator r1 = r1.iterator()
                r4 = r9
                r3 = r1
            L32:
                boolean r9 = r3.hasNext()
                if (r9 == 0) goto L6e
                java.lang.Object r9 = r3.next()
                r1 = r9
                android.net.Uri r1 = (android.net.Uri) r1
                com.reactnativedocumentpicker.MetadataGetter r9 = r8.this$0
                android.content.Context r5 = r8.$context
                com.reactnativedocumentpicker.PickOptions r6 = r8.$pickOptions
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r4
                r8.L$1 = r3
                r8.L$2 = r1
                r8.label = r2
                java.lang.Object r9 = com.reactnativedocumentpicker.MetadataGetter.access$getMetadataForUri(r9, r5, r1, r6, r7)
                if (r9 != r0) goto L57
                return r0
            L57:
                com.reactnativedocumentpicker.DocumentMetadataBuilder r9 = (com.reactnativedocumentpicker.DocumentMetadataBuilder) r9
                com.reactnativedocumentpicker.MetadataGetter r5 = r8.this$0
                java.util.Map r5 = com.reactnativedocumentpicker.MetadataGetter.access$getUriMap$p(r5)
                java.lang.String r6 = r1.toString()
                r5.put(r6, r1)
                com.facebook.react.bridge.ReadableMap r9 = r9.build()
                r4.pushMap(r9)
                goto L32
            L6e:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativedocumentpicker.MetadataGetter.C01502.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object processPickedFileUris(Context context, List<? extends Uri> list, PickOptions pickOptions, Continuation<? super ReadableArray> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C01502(list, this, context, pickOptions, null), continuation);
    }

    /* JADX INFO: renamed from: com.reactnativedocumentpicker.MetadataGetter$getMetadataForUri$2, reason: invalid class name */
    /* JADX INFO: compiled from: MetadataGetter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/reactnativedocumentpicker/DocumentMetadataBuilder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativedocumentpicker.MetadataGetter$getMetadataForUri$2", f = "MetadataGetter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DocumentMetadataBuilder>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ PickOptions $pickOptions;
        final /* synthetic */ Uri $sourceUri;
        int label;
        final /* synthetic */ MetadataGetter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Uri uri, PickOptions pickOptions, MetadataGetter metadataGetter, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$sourceUri = uri;
            this.$pickOptions = pickOptions;
            this.this$0 = metadataGetter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$sourceUri, this.$pickOptions, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DocumentMetadataBuilder> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ContentResolver contentResolver = this.$context.getContentResolver();
            DocumentMetadataBuilder documentMetadataBuilder = new DocumentMetadataBuilder(this.$sourceUri);
            documentMetadataBuilder.mimeType(contentResolver.getType(this.$sourceUri));
            if (this.$pickOptions.getAllowVirtualFiles()) {
                documentMetadataBuilder.openableMimeTypes(contentResolver.getStreamTypes(this.$sourceUri, "*/*"));
            }
            if (this.$pickOptions.getRequestLongTermAccess()) {
                try {
                    this.$context.getContentResolver().takePersistableUriPermission(this.$sourceUri, 3);
                    documentMetadataBuilder.bookmark(this.$sourceUri);
                } catch (Exception e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null && (localizedMessage = e.getMessage()) == null) {
                        localizedMessage = "Unknown error with takePersistableUriPermission";
                    }
                    documentMetadataBuilder.bookmarkError(localizedMessage);
                }
            }
            boolean z = this.$pickOptions.getAllowVirtualFiles() && DocumentsContract.isDocumentUri(this.$context, this.$sourceUri);
            MetadataGetter metadataGetter = this.this$0;
            Intrinsics.checkNotNull(contentResolver);
            metadataGetter.queryContentResolverMetadata(contentResolver, documentMetadataBuilder, z);
            return documentMetadataBuilder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getMetadataForUri(Context context, Uri uri, PickOptions pickOptions, Continuation<? super DocumentMetadataBuilder> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, uri, pickOptions, this, null), continuation);
    }

    public final void queryContentResolverMetadata(ContentResolver contentResolver, DocumentMetadataBuilder metadataBuilder, boolean couldBeVirtualFile) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(metadataBuilder, "metadataBuilder");
        Uri uri = metadataBuilder.getUri();
        boolean z = false;
        List listMutableListOf = CollectionsKt.mutableListOf("mime_type", "_display_name", "_size");
        if (couldBeVirtualFile) {
            listMutableListOf.add("flags");
        }
        Cursor cursorQuery = contentResolver.query(uri, (String[]) listMutableListOf.toArray(new String[0]), null, null, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor != null && cursor.moveToFirst()) {
                metadataBuilder.name((String) getCursorValue(cursor, "_display_name", String.class));
                if (!metadataBuilder.hasMime()) {
                    metadataBuilder.mimeType((String) getCursorValue(cursor, "mime_type", String.class));
                }
                if (couldBeVirtualFile) {
                    Integer num = (Integer) getCursorValue(cursor, "flags", Integer.TYPE);
                    if (((num != null ? num.intValue() : 0) & 512) != 0) {
                        z = true;
                    }
                }
                metadataBuilder.virtual(z);
                metadataBuilder.size((Long) getCursorValue(cursor, "_size", Long.TYPE));
            } else {
                metadataBuilder.metadataReadingError("Could not read file metadata");
            }
            CloseableKt.closeFinally(cursorQuery, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final <T> T getCursorValue(Cursor cursor, String columnName, Class<T> valueType) {
        Object objM1405constructorimpl;
        Float fValueOf;
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            MetadataGetter metadataGetter = this;
            if (Intrinsics.areEqual(valueType, String.class)) {
                fValueOf = cursor.getString(columnIndex);
            } else if (Intrinsics.areEqual(valueType, Integer.TYPE)) {
                fValueOf = Integer.valueOf(cursor.getInt(columnIndex));
            } else if (Intrinsics.areEqual(valueType, Long.TYPE)) {
                fValueOf = Long.valueOf(cursor.getLong(columnIndex));
            } else if (Intrinsics.areEqual(valueType, Double.TYPE)) {
                fValueOf = Double.valueOf(cursor.getDouble(columnIndex));
            } else {
                fValueOf = Intrinsics.areEqual(valueType, Float.TYPE) ? Float.valueOf(cursor.getFloat(columnIndex)) : null;
            }
            objM1405constructorimpl = Result.m1405constructorimpl(fValueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM1405constructorimpl = Result.m1405constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1411isFailureimpl(objM1405constructorimpl)) {
            return null;
        }
        return (T) objM1405constructorimpl;
    }
}
