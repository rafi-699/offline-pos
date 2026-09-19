package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PicProcessModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J8\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J8\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J8\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/PicProcessModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "convertImage1", "", "pic", "toWidth", "", "toHeight", "toRotation", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "convertImage2", "convertImage3", "black", "convertImage4", "convertImage5", "type", "convertImage6", "contrast", "", "convertImage8", "convertImage9", "saveBitmapToGallery", "bitmap", "Landroid/graphics/Bitmap;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PicProcessModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicProcessModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PicProcess";
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1", f = "PicProcessModule.kt", i = {}, l = {59, 63}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, int i2, int i3, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.AnonymousClass1.C00091(r8.$promise, r5, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.AnonymousClass1.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                r3 = 0
                r4 = 2
                if (r1 == 0) goto L22
                if (r1 == r2) goto L1c
                if (r1 != r4) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto L95
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L20
                goto L95
            L20:
                r9 = move-exception
                goto L7a
            L22:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L20
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L20
                int r5 = r9.length     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L20
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L20
                if (r5 == 0) goto L40
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L20
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L20
                int r6 = r8.$toRotation     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r9 = r5.rotateImage(r9, r6)     // Catch: java.lang.Exception -> L20
            L40:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L20
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L20
                int r6 = r8.$toWidth     // Catch: java.lang.Exception -> L20
                int r7 = r8.$toHeight     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r9 = r5.scaleAndCropImage(r9, r6, r7)     // Catch: java.lang.Exception -> L20
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r9 = r5.grayImage(r9)     // Catch: java.lang.Exception -> L20
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L20
                java.lang.String r5 = r5.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L20
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r6 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L20
                java.lang.String r9 = cn.lailaixiong.funnyprint.util.ImageUtil.Companion.ditherImageToBinaryBuffer$default(r6, r9, r1, r4, r3)     // Catch: java.lang.Exception -> L20
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L20
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Exception -> L20
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$1     // Catch: java.lang.Exception -> L20
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L20
                r6.<init>(r7, r5, r9, r3)     // Catch: java.lang.Exception -> L20
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L20
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L20
                r8.label = r2     // Catch: java.lang.Exception -> L20
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r9)     // Catch: java.lang.Exception -> L20
                if (r9 != r0) goto L95
                goto L94
            L7a:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$2 r2 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r2.<init>(r5, r9, r3)
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r2, r9)
                if (r9 != r0) goto L95
            L94:
                return r0
            L95:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $ditheredImage;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00091(Promise promise, String str, String str2, Continuation<? super C00091> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$ditheredImage = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00091(this.$promise, this.$base64Image, this.$ditheredImage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$ditheredImage);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage1$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage1(String pic, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(pic, toRotation, toWidth, toHeight, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1", f = "PicProcessModule.kt", i = {}, l = {93, 97}, m = "invokeSuspend", n = {}, s = {})
    static final class C01031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01031(String str, int i, int i2, int i3, Promise promise, Continuation<? super C01031> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01031(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01031.C00101(r8.$promise, r1, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01031.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto L9e
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto L9e
            L21:
                r9 = move-exception
                goto L83
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r1 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r1 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.rotateImage(r9, r5)     // Catch: java.lang.Exception -> L21
            L41:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.scaleAndCropImage(r9, r5, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.grayImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r1 = r1.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r6 = 122(0x7a, float:1.71E-43)
                java.nio.ByteBuffer r9 = r5.bitmapToBinaryBuffer(r9, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r5.byteBufferToBase64String(r9)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r1, r9, r2)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r4     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto L9e
                goto L9d
            L83:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$2 r4 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r4.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
                if (r9 != r0) goto L9e
            L9d:
                return r0
            L9e:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01031.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $binaryBase64String;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00101(Promise promise, String str, String str2, Continuation<? super C00101> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$binaryBase64String = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00101(this.$promise, this.$base64Image, this.$binaryBase64String, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$binaryBase64String);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage2$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage2(String pic, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01031(pic, toRotation, toWidth, toHeight, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1", f = "PicProcessModule.kt", i = {}, l = {142, 146}, m = "invokeSuspend", n = {}, s = {})
    static final class C01041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $black;
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01041(String str, int i, int i2, int i3, int i4, Promise promise, Continuation<? super C01041> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$black = i4;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01041(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$black, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01041.C00111(r8.$promise, r1, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a9, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01041.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lac
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto Lac
            L21:
                r9 = move-exception
                goto L91
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r1 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r1 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.rotateImage(r9, r5)     // Catch: java.lang.Exception -> L21
            L41:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.scaleAndCropImageHigh(r9, r5, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.transparentToWhite(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r5 = 10
                android.graphics.Bitmap r9 = r1.sharpenImage(r9, r5)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.defaultGrayImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r1 = r1.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                int r6 = r8.$black     // Catch: java.lang.Exception -> L21
                java.nio.ByteBuffer r9 = r5.bitmapToBinaryBuffer(r9, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r5.byteBufferToBase64String(r9)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r1, r9, r2)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r4     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto Lac
                goto Lab
            L91:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$2 r4 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r4.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
                if (r9 != r0) goto Lac
            Lab:
                return r0
            Lac:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01041.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $binaryBase64String;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00111(Promise promise, String str, String str2, Continuation<? super C00111> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$binaryBase64String = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00111(this.$promise, this.$base64Image, this.$binaryBase64String, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$binaryBase64String);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage3$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage3(String pic, int toWidth, int toHeight, int toRotation, int black, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01041(pic, toRotation, toWidth, toHeight, black, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1", f = "PicProcessModule.kt", i = {}, l = {181, 185}, m = "invokeSuspend", n = {}, s = {})
    static final class C01051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01051(String str, int i, int i2, int i3, Promise promise, Continuation<? super C01051> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01051(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0084, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01051.C00121(r8.$promise, r5, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01051.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                r3 = 0
                r4 = 2
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1c
                if (r1 != r4) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto La2
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto La2
            L21:
                r9 = move-exception
                goto L87
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r5 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.rotateImage(r9, r6)     // Catch: java.lang.Exception -> L21
            L41:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r7 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.scaleAndCropImage(r9, r6, r7)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r6 = 9
                android.graphics.Bitmap r9 = r5.sharpenImage(r9, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r6 = 127(0x7f, float:1.78E-43)
                r7 = 15
                android.graphics.Bitmap r9 = r5.brightGrayImage(r9, r6, r7)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r5 = r5.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r6 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = cn.lailaixiong.funnyprint.util.ImageUtil.Companion.ditherImageToBinaryBuffer$default(r6, r9, r1, r4, r3)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r5, r9, r3)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r2     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto La2
                goto La1
            L87:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$2 r2 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r2.<init>(r5, r9, r3)
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r2, r9)
                if (r9 != r0) goto La2
            La1:
                return r0
            La2:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01051.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $ditheredImage;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(Promise promise, String str, String str2, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$ditheredImage = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00121(this.$promise, this.$base64Image, this.$ditheredImage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$ditheredImage);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage4$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage4(String pic, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01051(pic, toRotation, toWidth, toHeight, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1", f = "PicProcessModule.kt", i = {}, l = {227, 231}, m = "invokeSuspend", n = {}, s = {})
    static final class C01061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $black;
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toWidth;
        final /* synthetic */ int $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01061(String str, int i, int i2, int i3, int i4, Promise promise, Continuation<? super C01061> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toWidth = i;
            this.$toHeight = i2;
            this.$type = i3;
            this.$black = i4;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01061(this.$pic, this.$toWidth, this.$toHeight, this.$type, this.$black, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01061.C00131(r8.$promise, r5, r6, null), r8) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00af, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01061.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00b1, code lost:
        
            return r0;
         */
        /* JADX WARN: Type inference failed for: r9v13, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v17, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 1
                r4 = 2
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1c
                if (r1 != r4) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lb2
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto Lb2
            L21:
                r9 = move-exception
                goto L97
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = "PicProcessModule"
                java.lang.String r1 = "convertImage5"
                android.util.Log.d(r9, r1)     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                float r6 = (float) r6     // Catch: java.lang.Exception -> L21
                int r7 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                float r7 = (float) r7     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.scaleLabelImage(r9, r6, r7)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.defaultGrayImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r5 = r5.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Exception -> L21
                r6.<init>()     // Catch: java.lang.Exception -> L21
                java.lang.String r7 = ""
                r6.element = r7     // Catch: java.lang.Exception -> L21
                int r7 = r8.$type     // Catch: java.lang.Exception -> L21
                if (r7 != r4) goto L6a
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r7 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = cn.lailaixiong.funnyprint.util.ImageUtil.Companion.ditherImageToBinaryBuffer$default(r7, r9, r1, r4, r2)     // Catch: java.lang.Exception -> L21
                r6.element = r9     // Catch: java.lang.Exception -> L21
                goto L7c
            L6a:
                if (r7 != r3) goto L7c
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                int r7 = r8.$black     // Catch: java.lang.Exception -> L21
                java.nio.ByteBuffer r9 = r1.bitmapToBinaryBuffer(r9, r7)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r1.byteBufferToBase64String(r9)     // Catch: java.lang.Exception -> L21
                r6.element = r9     // Catch: java.lang.Exception -> L21
            L7c:
                kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$1 r1 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r1.<init>(r7, r5, r6, r2)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Exception -> L21
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L21
                r8.label = r3     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto Lb2
                goto Lb1
            L97:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$2 r3 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r3.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r9)
                if (r9 != r0) goto Lb2
            Lb1:
                return r0
            Lb2:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01061.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ Ref.ObjectRef<String> $binImage;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00131(Promise promise, String str, Ref.ObjectRef<String> objectRef, Continuation<? super C00131> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$binImage = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00131(this.$promise, this.$base64Image, this.$binImage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + ((Object) this.$binImage.element));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage5$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage5(String pic, int toWidth, int toHeight, int type, int black, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01061(pic, toWidth, toHeight, type, black, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1", f = "PicProcessModule.kt", i = {}, l = {276, 280}, m = "invokeSuspend", n = {}, s = {})
    static final class C01071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $contrast;
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01071(String str, int i, float f, int i2, int i3, Promise promise, Continuation<? super C01071> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$contrast = f;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01071(this.$pic, this.$toRotation, this.$contrast, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01071.C00141(r8.$promise, r5, r9, null), r8) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01071.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                r3 = 0
                r4 = 2
                if (r1 == 0) goto L23
                if (r1 == r2) goto L1c
                if (r1 != r4) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto La9
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto La9
            L21:
                r9 = move-exception
                goto L8e
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r5 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.rotateImage(r9, r6)     // Catch: java.lang.Exception -> L21
            L41:
                float r5 = r8.$contrast     // Catch: java.lang.Exception -> L21
                r6 = 0
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 != 0) goto L49
                goto L54
            L49:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                float r6 = r8.$contrast     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.increaseContrast(r9, r6)     // Catch: java.lang.Exception -> L21
            L54:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r7 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.scaleAndCropImage(r9, r6, r7)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r5.grayImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r5 = r5.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r6 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = cn.lailaixiong.funnyprint.util.ImageUtil.Companion.ditherImageToBinaryBuffer$default(r6, r9, r1, r4, r3)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r5, r9, r3)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r2     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto La9
                goto La8
            L8e:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$2 r2 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r2.<init>(r5, r9, r3)
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r2, r9)
                if (r9 != r0) goto La9
            La8:
                return r0
            La9:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01071.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $ditheredImage;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00141(Promise promise, String str, String str2, Continuation<? super C00141> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$ditheredImage = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00141(this.$promise, this.$base64Image, this.$ditheredImage, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$ditheredImage);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage6$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage6(String pic, float contrast, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01071(pic, toRotation, contrast, toWidth, toHeight, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1", f = "PicProcessModule.kt", i = {}, l = {324, 328}, m = "invokeSuspend", n = {}, s = {})
    static final class C01081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01081(String str, int i, int i2, int i3, Promise promise, Continuation<? super C01081> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01081(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01081.C00151(r8.$promise, r1, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01081.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto L9e
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto L9e
            L21:
                r9 = move-exception
                goto L83
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r1 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r1 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.rotateImage(r9, r5)     // Catch: java.lang.Exception -> L21
            L41:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.scaleAndCropImage(r9, r5, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.toSketchImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r1 = r1.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r6 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r7 = 200(0xc8, float:2.8E-43)
                java.nio.ByteBuffer r9 = r6.bitmapToBinaryBuffer(r9, r7)     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r5.byteBufferToBase64String(r9)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r1, r9, r2)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r4     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto L9e
                goto L9d
            L83:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$2 r4 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r4.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
                if (r9 != r0) goto L9e
            L9d:
                return r0
            L9e:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01081.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $binBase64Image;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(Promise promise, String str, String str2, Continuation<? super C00151> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$binBase64Image = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00151(this.$promise, this.$base64Image, this.$binBase64Image, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$binBase64Image);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage8$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage8(String pic, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01081(pic, toRotation, toWidth, toHeight, promise, null), 3, null);
    }

    /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PicProcessModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1", f = "PicProcessModule.kt", i = {}, l = {366, 370}, m = "invokeSuspend", n = {}, s = {})
    static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $pic;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ int $toHeight;
        final /* synthetic */ int $toRotation;
        final /* synthetic */ int $toWidth;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01091(String str, int i, int i2, int i3, Promise promise, Continuation<? super C01091> continuation) {
            super(2, continuation);
            this.$pic = str;
            this.$toRotation = i;
            this.$toWidth = i2;
            this.$toHeight = i3;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01091(this.$pic, this.$toRotation, this.$toWidth, this.$toHeight, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01091.C00161(r8.$promise, r1, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01091.AnonymousClass2(r8.$promise, r9, null), r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.throwOnFailure(r9)
                goto L9e
            L14:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L21
                goto L9e
            L21:
                r9 = move-exception
                goto L83
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.String r9 = r8.$pic     // Catch: java.lang.Exception -> L21
                r1 = 0
                byte[] r9 = android.util.Base64.decode(r9, r1)     // Catch: java.lang.Exception -> L21
                int r5 = r9.length     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeByteArray(r9, r1, r5)     // Catch: java.lang.Exception -> L21
                int r1 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                if (r1 == 0) goto L41
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toRotation     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.rotateImage(r9, r5)     // Catch: java.lang.Exception -> L21
            L41:
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.toTextImage(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                int r5 = r8.$toWidth     // Catch: java.lang.Exception -> L21
                int r6 = r8.$toHeight     // Catch: java.lang.Exception -> L21
                android.graphics.Bitmap r9 = r1.scaleAndCropImage(r9, r5, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r1 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r1 = r1.bitmapToBase64String(r9)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                r6 = 200(0xc8, float:2.8E-43)
                java.nio.ByteBuffer r9 = r5.bitmapToBinaryBuffer(r9, r6)     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.util.ImageUtil$Companion r5 = cn.lailaixiong.funnyprint.util.ImageUtil.INSTANCE     // Catch: java.lang.Exception -> L21
                java.lang.String r9 = r5.byteBufferToBase64String(r9)     // Catch: java.lang.Exception -> L21
                kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L21
                kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Exception -> L21
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$1 r6 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$1     // Catch: java.lang.Exception -> L21
                com.facebook.react.bridge.Promise r7 = r8.$promise     // Catch: java.lang.Exception -> L21
                r6.<init>(r7, r1, r9, r2)     // Catch: java.lang.Exception -> L21
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L21
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Exception -> L21
                r8.label = r4     // Catch: java.lang.Exception -> L21
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)     // Catch: java.lang.Exception -> L21
                if (r9 != r0) goto L9e
                goto L9d
            L83:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
                cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$2 r4 = new cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$2
                com.facebook.react.bridge.Promise r5 = r8.$promise
                r4.<init>(r5, r9, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r9 = r8
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r8.label = r3
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r9)
                if (r9 != r0) goto L9e
            L9d:
                return r0
            L9e:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule.C01091.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$1", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64Image;
            final /* synthetic */ String $binaryBase64String;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00161(Promise promise, String str, String str2, Continuation<? super C00161> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$base64Image = str;
                this.$binaryBase64String = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00161(this.$promise, this.$base64Image, this.$binaryBase64String, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.resolve(this.$base64Image + "|" + this.$binaryBase64String);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PicProcessModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "cn.lailaixiong.funnyprint.ReactNaitveModule.PicProcessModule$convertImage9$1$2", f = "PicProcessModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            final /* synthetic */ Promise $promise;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Promise promise, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$promise = promise;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$promise, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$promise.reject("IMAGE_CONVERT_ERROR", "图片处理失败", this.$e);
                return Unit.INSTANCE;
            }
        }
    }

    @ReactMethod
    public final void convertImage9(String pic, int toWidth, int toHeight, int toRotation, Promise promise) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C01091(pic, toRotation, toWidth, toHeight, promise, null), 3, null);
    }

    public final String saveBitmapToGallery(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = "JPEG_" + str + ".jpg";
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists() ? externalStoragePublicDirectory.mkdirs() : true) {
            File file = new File(externalStoragePublicDirectory, str2);
            String absolutePath = file.getAbsolutePath();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return absolutePath;
            } catch (IOException e) {
                Log.e("saveBitmap", "Saving image failed: " + e.getLocalizedMessage());
            }
        }
        return null;
    }
}
