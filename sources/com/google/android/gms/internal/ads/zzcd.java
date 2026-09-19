package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcd {
    private final zzgub zza;
    private final Handler zzb;
    private zzcc zzc;
    private zzd zzd;
    private int zzf;
    private zzch zzh;
    private float zzg = 1.0f;
    private int zze = 0;

    public zzcd(final Context context, Looper looper, zzcc zzccVar) {
        this.zza = zzguf.zza(new zzgub() { // from class: com.google.android.gms.internal.ads.zzcb
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return zzcj.zza(context);
            }
        });
        this.zzc = zzccVar;
        this.zzb = new Handler(looper);
    }

    private final void zzf() {
        int i = this.zze;
        if (i == 1 || i == 0 || this.zzh == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.zza.zza();
        zzch zzchVar = this.zzh;
        if (Build.VERSION.SDK_INT >= 26) {
            audioManager.abandonAudioFocusRequest(zzchVar.zzc());
        } else {
            audioManager.abandonAudioFocus(zzchVar.zzb());
        }
    }

    private final void zzg(int i) {
        if (this.zze == i) {
            return;
        }
        this.zze = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.zzg != f) {
            this.zzg = f;
            zzcc zzccVar = this.zzc;
            if (zzccVar != null) {
                zzccVar.zza(f);
            }
        }
    }

    private final void zzh(int i) {
        zzcc zzccVar = this.zzc;
        if (zzccVar != null) {
            zzccVar.zzb(i);
        }
    }

    public final float zza() {
        return this.zzg;
    }

    public final void zzb(zzd zzdVar) {
        if (Objects.equals(this.zzd, zzdVar)) {
            return;
        }
        this.zzd = zzdVar;
        this.zzf = zzdVar == null ? 0 : 1;
    }

    public final void zzd() {
        this.zzc = null;
        zzf();
        zzg(0);
    }

    public final int zzc(boolean z, int i) {
        int iRequestAudioFocus;
        if (i == 1 || this.zzf != 1) {
            zzf();
            zzg(0);
            return 1;
        }
        int i2 = 3;
        if (!z) {
            int i3 = this.zze;
            if (i3 != 1) {
                return i3 != 3 ? 1 : 0;
            }
            return -1;
        }
        if (this.zze == 2) {
            return 1;
        }
        if (this.zzh == null) {
            zzce zzceVar = new zzce(1);
            zzd zzdVar = this.zzd;
            zzdVar.getClass();
            zzceVar.zzb(zzdVar);
            zzceVar.zzc(true);
            zzceVar.zza(new AudioManager.OnAudioFocusChangeListener() { // from class: com.google.android.gms.internal.ads.zzca
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final /* synthetic */ void onAudioFocusChange(int i4) {
                    this.zza.zze(i4);
                }
            }, this.zzb);
            this.zzh = zzceVar.zzd();
        }
        AudioManager audioManager = (AudioManager) this.zza.zza();
        zzch zzchVar = this.zzh;
        if (Build.VERSION.SDK_INT >= 26) {
            iRequestAudioFocus = audioManager.requestAudioFocus(zzchVar.zzc());
        } else {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListenerZzb = zzchVar.zzb();
            zzd zzdVarZza = zzchVar.zza();
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    int volumeControlStream = zzdVarZza.zza().getVolumeControlStream();
                    if (volumeControlStream != Integer.MIN_VALUE) {
                        i2 = volumeControlStream;
                    }
                } catch (RuntimeException unused) {
                }
            }
            iRequestAudioFocus = audioManager.requestAudioFocus(onAudioFocusChangeListenerZzb, i2, 1);
        }
        if (iRequestAudioFocus == 1 || iRequestAudioFocus == 2) {
            zzg(2);
            return 1;
        }
        zzg(1);
        return -1;
    }

    final /* synthetic */ void zze(int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzg(4);
                return;
            } else {
                zzh(0);
                zzg(3);
                return;
            }
        }
        if (i == -1) {
            zzh(-1);
            zzf();
            zzg(1);
        } else if (i == 1) {
            zzg(2);
            zzh(1);
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            zzeg.zzc("AudioFocusManager", sb.toString());
        }
    }
}
