package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzav implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzay zza;
    private final Activity zzb;

    public zzav(zzay zzayVar, Activity activity) {
        this.zza = zzayVar;
        this.zzb = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        this.zza.zzb.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzay zzayVar = this.zza;
        if (zzayVar.zzg == null || !zzayVar.zza) {
            return;
        }
        zzayVar.zzg.setOwnerActivity(activity);
        zzay zzayVar2 = this.zza;
        if (zzayVar2.zzc != null) {
            zzayVar2.zzc.zza(activity);
        }
        zzav zzavVar = (zzav) this.zza.zzl.getAndSet(null);
        if (zzavVar != null) {
            zzavVar.zzb();
            zzay zzayVar3 = this.zza;
            zzav zzavVar2 = new zzav(zzayVar3, activity);
            zzayVar3.zzb.registerActivityLifecycleCallbacks(zzavVar2);
            this.zza.zzl.set(zzavVar2);
        }
        zzay zzayVar4 = this.zza;
        if (zzayVar4.zzg != null) {
            zzayVar4.zzg.show();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity != this.zzb) {
            return;
        }
        if (activity.isChangingConfigurations()) {
            zzay zzayVar = this.zza;
            if (zzayVar.zza && zzayVar.zzg != null) {
                zzayVar.zzg.dismiss();
                return;
            }
        }
        this.zza.zzh(new zzg(3, "Activity is destroyed."));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
