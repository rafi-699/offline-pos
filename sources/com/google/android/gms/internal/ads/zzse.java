package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzse {
    void zzA();

    void zzB();

    void zzC();

    default void zzD() {
    }

    void zza(zzsb zzsbVar);

    default void zzb(zzqf zzqfVar) {
    }

    default void zzc(zzdo zzdoVar) {
    }

    boolean zzd(zzv zzvVar);

    int zze(zzv zzvVar);

    default zzqs zzf(zzv zzvVar) {
        throw null;
    }

    long zzg(boolean z);

    default void zzh(zzrx zzrxVar) throws zzrz {
        throw null;
    }

    void zzi();

    void zzj();

    boolean zzk(ByteBuffer byteBuffer, long j, int i) throws zzsa, zzsd;

    void zzl() throws zzsd;

    boolean zzm();

    boolean zzn();

    void zzo(zzav zzavVar);

    zzav zzp();

    void zzq(boolean z);

    void zzr(zzd zzdVar);

    default zzqh zzs() {
        throw null;
    }

    void zzt(int i);

    void zzu(zze zzeVar);

    default void zzv(AudioDeviceInfo audioDeviceInfo) {
    }

    default void zzw(int i) {
    }

    long zzx();

    default void zzy(int i, int i2) {
    }

    void zzz(float f);
}
