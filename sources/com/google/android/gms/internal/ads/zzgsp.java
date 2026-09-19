package com.google.android.gms.internal.ads;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgsp {
    public static final Deferred zza(CoroutineScope coroutineScope, zzgsm coroutineSequence, Function2 block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineSequence, "coroutineSequence");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new zzgso(coroutineSequence, block, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zzd(Mutex mutex, Continuation continuation) {
        Object objLock = mutex.lock(null, continuation);
        return objLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zze(Mutex mutex, Continuation continuation) {
        zzgsn zzgsnVar = zzgsn.zza;
        if ((!(zzgsnVar instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(zzgsnVar, mutex, continuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(zzgsnVar, 2)).invoke(mutex, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            IntrinsicsKt.intercepted(continuation).resumeWith(Result.m1405constructorimpl(Unit.INSTANCE));
        }
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
