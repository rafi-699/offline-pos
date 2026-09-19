package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzfxg {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfxg(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzfxg zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfxc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzfxg.zza;
                    taskCompletionSource.setResult(zzfzc.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfxe
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzfxg.zza;
                    taskCompletionSource.setResult(zzfzc.zzc());
                }
            });
        }
        return new zzfxg(context, executor, taskCompletionSource.getTask(), z);
    }

    static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfxf.zza);
        }
        Context context = this.zzb;
        final zzaws zzawsVarZza = zzaww.zza();
        zzawsVarZza.zza(context.getPackageName());
        zzawsVarZza.zzb(j);
        zzawsVarZza.zzg(zzf);
        if (exc != null) {
            int i2 = zzgug.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzawsVarZza.zzc(stringWriter.toString());
            zzawsVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzawsVarZza.zze(str2);
        }
        if (str != null) {
            zzawsVarZza.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfxd
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i3 = zzfxg.zza;
                if (!task.isSuccessful()) {
                    return false;
                }
                int i4 = i;
                zzfzb zzfzbVarZza = ((zzfzc) task.getResult()).zza(((zzaww) zzawsVarZza.zzbu()).zzaN());
                zzfzbVarZza.zzc(i4);
                zzfzbVarZza.zza();
                return true;
            }
        });
    }

    public Task zzb(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }

    public Task zze(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }
}
