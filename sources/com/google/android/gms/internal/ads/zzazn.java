package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzazn implements Runnable {
    private zzazn() {
        throw null;
    }

    /* synthetic */ zzazn(byte[] bArr) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzazo.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzazo.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzazo.zzb;
        } catch (Throwable th) {
            zzazo.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
