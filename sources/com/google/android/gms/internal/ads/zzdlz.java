package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlz extends zzcxt {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdkc zze;
    private final zzdno zzf;
    private final zzcyo zzg;
    private final zzfxq zzh;
    private final zzdde zzi;
    private final zzcfi zzj;
    private final zzdzl zzk;
    private boolean zzl;

    zzdlz(zzcxs zzcxsVar, Context context, @Nullable zzcku zzckuVar, zzdkc zzdkcVar, zzdno zzdnoVar, zzcyo zzcyoVar, zzfxq zzfxqVar, zzdde zzddeVar, zzcfi zzcfiVar, zzdzl zzdzlVar) {
        super(zzcxsVar);
        this.zzl = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzckuVar);
        this.zze = zzdkcVar;
        this.zzf = zzdnoVar;
        this.zzg = zzcyoVar;
        this.zzh = zzfxqVar;
        this.zzi = zzddeVar;
        this.zzj = zzcfiVar;
        this.zzk = zzdzlVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcku zzckuVar = (zzcku) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhG)).booleanValue()) {
                if (!this.zzl && zzckuVar != null) {
                    zzhcg zzhcgVar = zzcfr.zzf;
                    Objects.requireNonNull(zzckuVar);
                    zzhcgVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdly
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzckuVar.destroy();
                        }
                    });
                }
            } else if (zzckuVar != null) {
                zzckuVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x007d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0098 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:24:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00df  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean zza(boolean z, @Nullable Activity activity) {
        Context context;
        zzfkf zzfkfVarZzC;
        zzdkc zzdkcVar = this.zze;
        zzdkcVar.zza();
        com.google.android.gms.ads.internal.zzt.zzc();
        zzdno zzdnoVar = this.zzf;
        if (com.google.android.gms.ads.internal.util.zzs.zzR(zzdnoVar.zzb())) {
            zzcku zzckuVar = (zzcku) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue()) {
                if (this.zzl) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                    this.zzi.zzc(zzfma.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzl) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdnoVar.zza(z, context, this.zzi);
                    zzdkcVar.zzb();
                    this.zzl = true;
                    return true;
                }
            } else {
                if (this.zzl) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                    this.zzi.zzc(zzfma.zzd(10, null, null));
                }
                context = activity;
                if (!this.zzl) {
                    if (activity == null) {
                        context = this.zzc;
                    }
                    zzdnoVar.zza(z, context, this.zzi);
                    zzdkcVar.zzb();
                    this.zzl = true;
                    return true;
                }
            }
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpc)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzQ(this.zzc, this.zzb, this.zzk);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbm)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                if (com.google.android.gms.ads.internal.util.zzs.zzJ(this.zzc)) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://goo.gle/admob-interstitial-policies");
                    this.zzi.zze();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbn)).booleanValue()) {
                        this.zzh.zza(this.zza.zzb.zzb.zzb);
                    }
                } else {
                    zzcku zzckuVar2 = (zzcku) this.zzd.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue() || zzckuVar2 == null || (zzfkfVarZzC = zzckuVar2.zzC()) == null || !zzfkfVarZzC.zzar || zzfkfVarZzC.zzas == this.zzj.zzj()) {
                        if (this.zzl) {
                            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                            this.zzi.zzc(zzfma.zzd(10, null, null));
                        }
                        context = activity;
                        if (!this.zzl) {
                            if (activity == null) {
                                context = this.zzc;
                            }
                            try {
                                zzdnoVar.zza(z, context, this.zzi);
                                zzdkcVar.zzb();
                                this.zzl = true;
                                return true;
                            } catch (zzdnn e) {
                                this.zzi.zzd(e);
                            }
                        }
                    } else {
                        int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial consent form has been shown.");
                        this.zzi.zzc(zzfma.zzd(12, "The consent form has already been shown.", null));
                    }
                }
            } else {
                zzcku zzckuVar3 = (zzcku) this.zzd.get();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue()) {
                    if (this.zzl) {
                        int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                        this.zzi.zzc(zzfma.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzl) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        zzdnoVar.zza(z, context, this.zzi);
                        zzdkcVar.zzb();
                        this.zzl = true;
                        return true;
                    }
                } else {
                    if (this.zzl) {
                        int i7 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                        this.zzi.zzc(zzfma.zzd(10, null, null));
                    }
                    context = activity;
                    if (!this.zzl) {
                        if (activity == null) {
                            context = this.zzc;
                        }
                        zzdnoVar.zza(z, context, this.zzi);
                        zzdkcVar.zzb();
                        this.zzl = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean zzb() {
        return this.zzg.zzl();
    }
}
