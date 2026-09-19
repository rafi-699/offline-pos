package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgce implements zzgau {
    private final CoroutineScope zza;
    private final zzgsm zzb;
    private final Mutex zzc;
    private final Mutex zzd;
    private final Mutex zze;
    private boolean zzf;
    private zzgas zzg;
    private boolean zzh;
    private final DataStore zzi;
    private final zzdww zzj;

    public zzgce(DataStore adQualityDataStore, zzgbg coroutineScopeProvider, zzdww dataPinger, zzgbd clock) {
        Intrinsics.checkNotNullParameter(adQualityDataStore, "adQualityDataStore");
        Intrinsics.checkNotNullParameter(coroutineScopeProvider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(dataPinger, "dataPinger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.zzj = dataPinger;
        this.zza = coroutineScopeProvider.zza();
        this.zzb = new zzgsm();
        this.zzc = MutexKt.Mutex$default(false, 1, null);
        this.zzd = MutexKt.Mutex$default(false, 1, null);
        this.zze = MutexKt.Mutex$default(false, 1, null);
        this.zzi = adQualityDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzA(Continuation continuation) throws Throwable {
        zzgbm zzgbmVar;
        Mutex mutex;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof zzgbm) {
            zzgbmVar = (zzgbm) continuation;
            int i = zzgbmVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbmVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzgbmVar = new zzgbm(this, continuation);
            }
        } else {
            zzgbmVar = new zzgbm(this, continuation);
        }
        Object obj = zzgbmVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbmVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zze;
                zzgbmVar.zza = mutex;
                zzgbmVar.zzd = 1;
                if (mutex.lock(null, zzgbmVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) zzgbmVar.zza;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) zzgbmVar.zza;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            DataStore dataStore = this.zzi;
            zzgbn zzgbnVar = new zzgbn(null);
            zzgbmVar.zza = mutex;
            zzgbmVar.zzd = 2;
            Object objUpdateData = dataStore.updateData(zzgbnVar, zzgbmVar);
            if (objUpdateData != coroutine_suspended) {
                mutex2 = mutex;
                obj = objUpdateData;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzB(long j, Continuation continuation) {
        zzgbl zzgblVar;
        Mutex mutex;
        if (continuation instanceof zzgbl) {
            zzgblVar = (zzgbl) continuation;
            int i = zzgblVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgblVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgblVar = new zzgbl(this, continuation);
            }
        } else {
            zzgblVar = new zzgbl(this, continuation);
        }
        Object obj = zzgblVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgblVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            zzgblVar.zzb = mutex2;
            zzgblVar.zza = j;
            zzgblVar.zze = 1;
            if (mutex2.lock(null, zzgblVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzgblVar.zza;
            mutex = (Mutex) zzgblVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgas zzgasVar2 = this.zzg;
            if (zzgasVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar2 = null;
            }
            long jZzi = j - zzgasVar2.zzi();
            zzgas zzgasVar3 = this.zzg;
            if (zzgasVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar3 = null;
            }
            zzgasVar.zzb(jZzi - zzgasVar3.zzg());
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzC(Continuation continuation) throws Throwable {
        zzgbq zzgbqVar;
        Mutex mutex;
        Mutex mutex2;
        zzgat zzgatVar;
        Mutex mutex3;
        if (continuation instanceof zzgbq) {
            zzgbqVar = (zzgbq) continuation;
            int i = zzgbqVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbqVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbqVar = new zzgbq(this, continuation);
            }
        } else {
            zzgbqVar = new zzgbq(this, continuation);
        }
        Object objUpdateData = zzgbqVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbqVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objUpdateData);
                mutex = this.zzc;
                zzgbqVar.zza = mutex;
                zzgbqVar.zze = 1;
                if (mutex.lock(null, zzgbqVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex3 = (Mutex) zzgbqVar.zza;
                    try {
                        ResultKt.throwOnFailure(objUpdateData);
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        mutex3.unlock(null);
                        throw th;
                    }
                }
                mutex2 = (Mutex) zzgbqVar.zzb;
                zzgatVar = (zzgat) zzgbqVar.zza;
                ResultKt.throwOnFailure(objUpdateData);
                try {
                    DataStore dataStore = this.zzi;
                    zzgbr zzgbrVar = new zzgbr(zzgatVar, null);
                    zzgbqVar.zza = mutex2;
                    zzgbqVar.zzb = null;
                    zzgbqVar.zze = 3;
                    objUpdateData = dataStore.updateData(zzgbrVar, zzgbqVar);
                    if (objUpdateData != coroutine_suspended) {
                        mutex3 = mutex2;
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    mutex3 = mutex2;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            mutex = (Mutex) zzgbqVar.zza;
            ResultKt.throwOnFailure(objUpdateData);
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgat zzgatVar2 = (zzgat) zzgasVar.zzbu();
            mutex.unlock(null);
            Intrinsics.checkNotNull(zzgatVar2);
            mutex2 = this.zze;
            zzgbqVar.zza = zzgatVar2;
            zzgbqVar.zzb = mutex2;
            zzgbqVar.zze = 2;
            if (mutex2.lock(null, zzgbqVar) != coroutine_suspended) {
                zzgatVar = zzgatVar2;
                DataStore dataStore2 = this.zzi;
                zzgbr zzgbrVar2 = new zzgbr(zzgatVar, null);
                zzgbqVar.zza = mutex2;
                zzgbqVar.zzb = null;
                zzgbqVar.zze = 3;
                objUpdateData = dataStore2.updateData(zzgbrVar2, zzgbqVar);
                if (objUpdateData != coroutine_suspended) {
                    mutex3 = mutex2;
                    mutex3.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex.unlock(null);
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    private static final boolean zzD(zzgat zzgatVar) {
        boolean z;
        List listZzk = zzgatVar.zzk();
        Long l = listZzk != null ? (Long) CollectionsKt.lastOrNull(listZzk) : null;
        boolean z2 = zzgatVar.zzl() > zzgatVar.zzm() && !zzgatVar.zzd();
        if (l != null) {
            if (zzgatVar.zzi() - l.longValue() > 5000) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z2 || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
    
        if (zzA(r0) == r1) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.internal.ads.zzgce] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzs(kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgce.zzs(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzt(String str, Continuation continuation) {
        zzgbt zzgbtVar;
        String str2;
        Mutex mutex;
        long j;
        if (continuation instanceof zzgbt) {
            zzgbtVar = (zzgbt) continuation;
            int i = zzgbtVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbtVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbtVar = new zzgbt(this, continuation);
            }
        } else {
            zzgbtVar = new zzgbt(this, continuation);
        }
        Object obj = zzgbtVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbtVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbtVar.zzf = str;
            zzgbtVar.zza = mutex2;
            zzgbtVar.zzb = jCurrentTimeMillis;
            zzgbtVar.zze = 1;
            if (mutex2.lock(null, zzgbtVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzgbtVar.zzb;
            mutex = (Mutex) zzgbtVar.zza;
            str2 = zzgbtVar.zzf;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.zzf) {
                return Unit.INSTANCE;
            }
            this.zzf = true;
            zzidy zzidyVarZzcc = zzgat.zzp().zzcc();
            Intrinsics.checkNotNullExpressionValue(zzidyVarZzcc, "toBuilder(...)");
            zzgas zzgasVar = (zzgas) zzidyVarZzcc;
            this.zzg = zzgasVar;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgasVar.zza(str2);
            zzgasVar.zzj(j);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x0089 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:31:0x0085, B:33:0x0089, B:34:0x008f), top: B:50:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a6, code lost:
    
        if (zzC(r0) != r1) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzu(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.android.gms.internal.ads.zzgbp
            if (r0 == 0) goto L13
            r0 = r11
            com.google.android.gms.internal.ads.zzgbp r0 = (com.google.android.gms.internal.ads.zzgbp) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzgbp r0 = new com.google.android.gms.internal.ads.zzgbp
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L52
            if (r2 == r6) goto L4a
            if (r2 == r5) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            kotlin.ResultKt.throwOnFailure(r11)
            goto La8
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            goto La0
        L40:
            long r5 = r0.zzb
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L85
        L4a:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L61
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzd
            r0.zza = r2
            r0.zze = r6
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
        L61:
            boolean r11 = r10.zzh     // Catch: java.lang.Throwable -> Lb0
            if (r11 == 0) goto L6b
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            return r11
        L6b:
            r10.zzh = r6     // Catch: java.lang.Throwable -> Lb0
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzc
            long r8 = java.lang.System.currentTimeMillis()
            r0.zza = r2
            r0.zzb = r8
            r0.zze = r5
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
            r5 = r8
        L85:
            com.google.android.gms.internal.ads.zzgas r11 = r10.zzg     // Catch: java.lang.Throwable -> Lab
            if (r11 != 0) goto L8f
            java.lang.String r11 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch: java.lang.Throwable -> Lab
            r11 = r7
        L8f:
            r11.zzo(r5)     // Catch: java.lang.Throwable -> Lab
            r2.unlock(r7)
            r0.zza = r7
            r0.zze = r4
            java.lang.Object r11 = r10.zzB(r5, r0)
            if (r11 != r1) goto La0
            goto Lb5
        La0:
            r0.zze = r3
            java.lang.Object r11 = r10.zzC(r0)
            if (r11 == r1) goto Lb5
        La8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lab:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb0:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgce.zzu(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x007e A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008a A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008e A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00dd A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00fd A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010d A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzv(Continuation continuation) {
        zzgcd zzgcdVar;
        Mutex mutex;
        Mutex mutex2;
        long j;
        zzgas zzgasVar;
        zzgas zzgasVar2;
        zzgas zzgasVar3;
        zzgas zzgasVar4;
        zzgas zzgasVar5;
        zzgas zzgasVar6;
        long jLongValue;
        zzgas zzgasVar7;
        zzgas zzgasVar8;
        if (continuation instanceof zzgcd) {
            zzgcdVar = (zzgcd) continuation;
            int i = zzgcdVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgcdVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgcdVar = new zzgcd(this, continuation);
            }
        } else {
            zzgcdVar = new zzgcd(this, continuation);
        }
        Object obj = zzgcdVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgcdVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzd;
                zzgcdVar.zza = mutex;
                zzgcdVar.zze = 1;
                if (mutex.lock(null, zzgcdVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                mutex = (Mutex) zzgcdVar.zza;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = zzgcdVar.zzb;
                mutex2 = (Mutex) zzgcdVar.zza;
                ResultKt.throwOnFailure(obj);
            }
            try {
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar = null;
                }
                if (zzgasVar.zzr() > 0) {
                    zzgasVar6 = this.zzg;
                    if (zzgasVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar6 = null;
                    }
                    List listZzq = zzgasVar6.zzq();
                    Intrinsics.checkNotNullExpressionValue(listZzq, "getAdClickTimestampsMsList(...)");
                    Object objLast = CollectionsKt.last((List<? extends Object>) listZzq);
                    Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                    jLongValue = j - ((Number) objLast).longValue();
                    zzgasVar7 = this.zzg;
                    if (zzgasVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar7 = null;
                    }
                    zzgasVar7.zzt();
                    if (jLongValue < 5000) {
                        zzgasVar8 = this.zzg;
                        if (zzgasVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar8 = null;
                        }
                        zzgasVar8.zzd(zzgasVar8.zzc() + 1);
                    }
                }
                zzgasVar2 = this.zzg;
                if (zzgasVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar2 = null;
                }
                if (zzgasVar2.zzn() > 0) {
                    zzgasVar4 = this.zzg;
                    if (zzgasVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar4 = null;
                    }
                    List listZzm = zzgasVar4.zzm();
                    Intrinsics.checkNotNullExpressionValue(listZzm, "getAppBackgroundTimestampsMsList(...)");
                    Object objLast2 = CollectionsKt.last((List<? extends Object>) listZzm);
                    Intrinsics.checkNotNullExpressionValue(objLast2, "last(...)");
                    long jLongValue2 = j - ((Number) objLast2).longValue();
                    zzgasVar5 = this.zzg;
                    if (zzgasVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar5 = null;
                    }
                    zzgasVar5.zzh(zzgasVar5.zzg() + jLongValue2);
                }
                zzgasVar3 = this.zzg;
                if (zzgasVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar3 = null;
                }
                zzgasVar3.zzp(j);
                return Unit.INSTANCE;
            } finally {
                mutex2.unlock(null);
            }
            if (!this.zzh) {
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return unit;
            }
            this.zzh = false;
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            Mutex mutex3 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgcdVar.zza = mutex3;
            zzgcdVar.zzb = jCurrentTimeMillis;
            zzgcdVar.zze = 2;
            if (mutex3.lock(null, zzgcdVar) != coroutine_suspended) {
                mutex2 = mutex3;
                j = jCurrentTimeMillis;
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar = null;
                }
                if (zzgasVar.zzr() > 0) {
                    zzgasVar6 = this.zzg;
                    if (zzgasVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar6 = null;
                    }
                    List listZzq2 = zzgasVar6.zzq();
                    Intrinsics.checkNotNullExpressionValue(listZzq2, "getAdClickTimestampsMsList(...)");
                    Object objLast3 = CollectionsKt.last((List<? extends Object>) listZzq2);
                    Intrinsics.checkNotNullExpressionValue(objLast3, "last(...)");
                    jLongValue = j - ((Number) objLast3).longValue();
                    zzgasVar7 = this.zzg;
                    if (zzgasVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar7 = null;
                    }
                    zzgasVar7.zzt();
                    if (jLongValue < 5000) {
                        zzgasVar8 = this.zzg;
                        if (zzgasVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar8 = null;
                        }
                        zzgasVar8.zzd(zzgasVar8.zzc() + 1);
                    }
                }
                zzgasVar2 = this.zzg;
                if (zzgasVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar2 = null;
                }
                if (zzgasVar2.zzn() > 0) {
                    zzgasVar4 = this.zzg;
                    if (zzgasVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar4 = null;
                    }
                    List listZzm2 = zzgasVar4.zzm();
                    Intrinsics.checkNotNullExpressionValue(listZzm2, "getAppBackgroundTimestampsMsList(...)");
                    Object objLast4 = CollectionsKt.last((List<? extends Object>) listZzm2);
                    Intrinsics.checkNotNullExpressionValue(objLast4, "last(...)");
                    long jLongValue3 = j - ((Number) objLast4).longValue();
                    zzgasVar5 = this.zzg;
                    if (zzgasVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar5 = null;
                    }
                    zzgasVar5.zzh(zzgasVar5.zzg() + jLongValue3);
                }
                zzgasVar3 = this.zzg;
                if (zzgasVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzgasVar3 = null;
                }
                zzgasVar3.zzp(j);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0091 A[Catch: all -> 0x00fc, TRY_ENTER, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0099 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
    
        if (zzz(r14, r0) == r1) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzw(kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgce.zzw(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0090 A[Catch: all -> 0x0106, TRY_ENTER, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0098 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c1 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0100, code lost:
    
        if (zzz(r15, r0) == r1) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzx(kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgce.zzx(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzy(Continuation continuation) {
        zzgbv zzgbvVar;
        Mutex mutex;
        long j;
        if (continuation instanceof zzgbv) {
            zzgbvVar = (zzgbv) continuation;
            int i = zzgbvVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbvVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbvVar = new zzgbv(this, continuation);
            }
        } else {
            zzgbvVar = new zzgbv(this, continuation);
        }
        Object obj = zzgbvVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbvVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbvVar.zzb = mutex2;
            zzgbvVar.zza = jCurrentTimeMillis;
            zzgbvVar.zze = 1;
            if (mutex2.lock(null, zzgbvVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzgbvVar.zza;
            mutex = (Mutex) zzgbvVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgasVar.zzs(j);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzz(String str, Continuation continuation) throws Throwable {
        zzgbj zzgbjVar;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof zzgbj) {
            zzgbjVar = (zzgbj) continuation;
            int i = zzgbjVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbjVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbjVar = new zzgbj(this, continuation);
            }
        } else {
            zzgbjVar = new zzgbj(this, continuation);
        }
        Object obj = zzgbjVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbjVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zze;
                zzgbjVar.zza = str;
                zzgbjVar.zzb = mutex;
                zzgbjVar.zze = 1;
                if (mutex.lock(null, zzgbjVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) zzgbjVar.zza;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) zzgbjVar.zzb;
            String str2 = (String) zzgbjVar.zza;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            str = str2;
            DataStore dataStore = this.zzi;
            zzgbk zzgbkVar = new zzgbk(str, null);
            zzgbjVar.zza = mutex;
            zzgbjVar.zzb = null;
            zzgbjVar.zze = 2;
            Object objUpdateData = dataStore.updateData(zzgbkVar, zzgbjVar);
            if (objUpdateData != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objUpdateData;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zza() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzgby(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzb(String gwsQueryId) {
        Intrinsics.checkNotNullParameter(gwsQueryId, "gwsQueryId");
        zzgsp.zza(this.zza, this.zzb, new zzgbs(this, gwsQueryId, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzc() {
        zzgsp.zza(this.zza, this.zzb, new zzgbo(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzd() {
        zzgsp.zza(this.zza, this.zzb, new zzgcc(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zze() {
        zzgsp.zza(this.zza, this.zzb, new zzgbw(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzf() {
        zzgsp.zza(this.zza, this.zzb, new zzgca(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzg() {
        zzgsp.zza(this.zza, this.zzb, new zzgbu(this, null));
    }
}
