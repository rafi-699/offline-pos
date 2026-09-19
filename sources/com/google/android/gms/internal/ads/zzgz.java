package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgz {
    private final zzgy zza;
    private final ArrayDeque zzb = new ArrayDeque();
    private final ArrayDeque zzc = new ArrayDeque();
    private final PriorityQueue zzd = new PriorityQueue();
    private int zze = -1;
    private zzgx zzf;

    public zzgz(zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    private final void zzf(int i) {
        List list;
        while (true) {
            PriorityQueue priorityQueue = this.zzd;
            if (priorityQueue.size() <= i) {
                return;
            }
            zzgx zzgxVar = (zzgx) priorityQueue.poll();
            String str = zzfl.zza;
            int i2 = 0;
            while (true) {
                list = zzgxVar.zza;
                if (i2 >= list.size()) {
                    break;
                }
                this.zza.zza(zzgxVar.zzb, (zzet) list.get(i2));
                this.zzb.push((zzet) list.get(i2));
                i2++;
            }
            list.clear();
            zzgx zzgxVar2 = this.zzf;
            if (zzgxVar2 != null && zzgxVar2.zzb == zzgxVar.zzb) {
                this.zzf = null;
            }
            this.zzc.push(zzgxVar);
        }
    }

    public final void zza(int i) {
        zzgtj.zzi(i >= 0);
        this.zze = i;
        zzf(i);
    }

    public final int zzb() {
        return this.zze;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r7 < r0.zzb) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(long r7, com.google.android.gms.internal.ads.zzet r9) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 == 0) goto L9e
            int r0 = r6.zze
            if (r0 == 0) goto L9f
            r1 = -1
            if (r0 == r1) goto L2d
            java.util.PriorityQueue r0 = r6.zzd
            int r2 = r0.size()
            int r3 = r6.zze
            if (r2 < r3) goto L2d
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzgx r0 = (com.google.android.gms.internal.ads.zzgx) r0
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfl.zza
            r2 = r0
            com.google.android.gms.internal.ads.zzgx r2 = (com.google.android.gms.internal.ads.zzgx) r2
            long r2 = r0.zzb
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 >= 0) goto L2d
            goto L9f
        L2d:
            java.util.ArrayDeque r0 = r6.zzb
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L3b
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet
            r0.<init>()
            goto L41
        L3b:
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzet r0 = (com.google.android.gms.internal.ads.zzet) r0
        L41:
            int r2 = r9.zzd()
            r0.zza(r2)
            byte[] r2 = r9.zzi()
            int r9 = r9.zzg()
            byte[] r3 = r0.zzi()
            r4 = 0
            int r5 = r0.zzd()
            java.lang.System.arraycopy(r2, r9, r3, r4, r5)
            com.google.android.gms.internal.ads.zzgx r9 = r6.zzf
            if (r9 == 0) goto L6d
            long r2 = r9.zzb
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L67
            goto L6d
        L67:
            java.util.List r7 = r9.zza
            r7.add(r0)
            return
        L6d:
            java.util.ArrayDeque r9 = r6.zzc
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L7b
            com.google.android.gms.internal.ads.zzgx r9 = new com.google.android.gms.internal.ads.zzgx
            r9.<init>()
            goto L81
        L7b:
            java.lang.Object r9 = r9.pop()
            com.google.android.gms.internal.ads.zzgx r9 = (com.google.android.gms.internal.ads.zzgx) r9
        L81:
            java.util.List r2 = r9.zza
            boolean r3 = r2.isEmpty()
            com.google.android.gms.internal.ads.zzgtj.zzi(r3)
            r9.zzb = r7
            r2.add(r0)
            java.util.PriorityQueue r7 = r6.zzd
            r7.add(r9)
            r6.zzf = r9
            int r7 = r6.zze
            if (r7 == r1) goto L9d
            r6.zzf(r7)
        L9d:
            return
        L9e:
            r7 = r0
        L9f:
            com.google.android.gms.internal.ads.zzgy r0 = r6.zza
            r0.zza(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgz.zzc(long, com.google.android.gms.internal.ads.zzet):void");
    }

    public final void zzd() {
        this.zzd.clear();
    }

    public final void zze() {
        zzf(0);
    }
}
