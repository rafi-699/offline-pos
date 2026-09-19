package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.media3.common.C;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzatt implements zzasx {
    protected final zzatv zza;
    private final zzats zzb;

    public zzatt(zzats zzatsVar) {
        zzatv zzatvVar = new zzatv(4096);
        this.zzb = zzatsVar;
        this.zza = zzatvVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:102:0x01da  */
    /* JADX WARN: Code duplicated, block: B:116:0x020f  */
    /* JADX WARN: Code duplicated, block: B:143:0x024d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:97:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c1 A[DONT_INVERT] */
    @Override // com.google.android.gms.internal.ads.zzasx
    public zzata zza(zzate zzateVar) throws Throwable {
        byte[] bArr;
        int iZza;
        zzatn zzaszVar;
        String str;
        zzata zzataVar;
        int iZzo;
        Map mapEmptyMap;
        byte[] byteArray;
        byte[] bArrZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            zzauc zzaucVar = null;
            try {
                zzasn zzasnVarZzk = zzateVar.zzk();
                if (zzasnVarZzk == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str2 = zzasnVarZzk.zzb;
                    if (str2 != null) {
                        map.put(HttpHeaders.IF_NONE_MATCH, str2);
                    }
                    long j = zzasnVarZzk.zzd;
                    if (j > 0) {
                        map.put(HttpHeaders.IF_MODIFIED_SINCE, zzaub.zzc(j));
                    }
                    mapEmptyMap = map;
                }
                zzauc zzaucVarZza = this.zzb.zza(zzateVar, mapEmptyMap);
                try {
                    int iZza2 = zzaucVarZza.zza();
                    List listZzb = zzaucVarZza.zzb();
                    if (iZza2 == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        zzasn zzasnVarZzk2 = zzateVar.zzk();
                        if (zzasnVarZzk2 == null) {
                            return new zzata(Videoio.CAP_PROP_PVAPI_BINNINGX, (byte[]) null, true, jElapsedRealtime2, listZzb);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!listZzb.isEmpty()) {
                            Iterator it = listZzb.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzasw) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(listZzb);
                        List list = zzasnVarZzk2.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzasw zzaswVar : zzasnVarZzk2.zzh) {
                                    if (!treeSet.contains(zzaswVar.zza())) {
                                        arrayList.add(zzaswVar);
                                    }
                                }
                            }
                        } else if (!zzasnVarZzk2.zzg.isEmpty()) {
                            for (Map.Entry entry : zzasnVarZzk2.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzasw((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzata(Videoio.CAP_PROP_PVAPI_BINNINGX, zzasnVarZzk2.zza, true, jElapsedRealtime2, (List) arrayList);
                    }
                    InputStream inputStreamZzd = zzaucVarZza.zzd();
                    if (inputStreamZzd != null) {
                        int iZzc = zzaucVarZza.zzc();
                        zzatv zzatvVar = this.zza;
                        zzaug zzaugVar = new zzaug(zzatvVar, iZzc);
                        try {
                            bArrZza = zzatvVar.zza(1024);
                            while (true) {
                                try {
                                    int i = inputStreamZzd.read(bArrZza);
                                    if (i == -1) {
                                        break;
                                    }
                                    zzaugVar.write(bArrZza, 0, i);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        inputStreamZzd.close();
                                    } catch (IOException unused) {
                                        zzatq.zza("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzatvVar.zzb(bArrZza);
                                    zzaugVar.close();
                                    throw th;
                                }
                            }
                            byteArray = zzaugVar.toByteArray();
                            try {
                                inputStreamZzd.close();
                            } catch (IOException unused2) {
                                zzatq.zza("Error occurred when closing InputStream", new Object[0]);
                            }
                            zzatvVar.zzb(bArrZza);
                            zzaugVar.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bArrZza = null;
                        }
                    } else {
                        byteArray = new byte[0];
                    }
                    byte[] bArr2 = byteArray;
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (zzatq.zzb || jElapsedRealtime3 > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                            zzatq.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzateVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : "null", Integer.valueOf(iZza2), Integer.valueOf(zzateVar.zzy().zzb()));
                        }
                        if (iZza2 < 200 || iZza2 > 299) {
                            throw new IOException();
                        }
                        return new zzata(iZza2, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzb);
                    } catch (IOException e) {
                        e = e;
                        zzaucVar = zzaucVarZza;
                        bArr = bArr2;
                        if (e instanceof SocketTimeoutException) {
                            zzaszVar = new zzatm();
                            str = "socket";
                        } else {
                            if (!(e instanceof MalformedURLException)) {
                                String strZzh = zzateVar.zzh();
                                String.valueOf(strZzh);
                                throw new RuntimeException("Bad URL ".concat(String.valueOf(strZzh)), e);
                            }
                            if (zzaucVar != null) {
                                throw new zzatb(e);
                            }
                            iZza = zzaucVar.zza();
                            zzatq.zzc("Unexpected response code %d for %s", Integer.valueOf(iZza), zzateVar.zzh());
                            if (bArr != null) {
                                zzataVar = new zzata(iZza, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaucVar.zzb());
                                if (iZza == 401 && iZza != 403) {
                                    if (iZza < 400 || iZza > 499) {
                                        throw new zzatl(zzataVar);
                                    }
                                    throw new zzasr(zzataVar);
                                }
                                zzaszVar = new zzasm(zzataVar);
                                str = "auth";
                            } else {
                                zzaszVar = new zzasz();
                                str = "network";
                            }
                        }
                        zzass zzassVarZzy = zzateVar.zzy();
                        iZzo = zzateVar.zzo();
                        try {
                            zzassVarZzy.zzc(zzaszVar);
                            zzateVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
                        } catch (zzatn e2) {
                            zzateVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iZzo)));
                            throw e2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                    zzaucVar = zzaucVarZza;
                    if (e instanceof SocketTimeoutException) {
                        zzaszVar = new zzatm();
                        str = "socket";
                    } else {
                        if (!(e instanceof MalformedURLException)) {
                            String strZzh2 = zzateVar.zzh();
                            String.valueOf(strZzh2);
                            throw new RuntimeException("Bad URL ".concat(String.valueOf(strZzh2)), e);
                        }
                        if (zzaucVar != null) {
                            throw new zzatb(e);
                        }
                        iZza = zzaucVar.zza();
                        zzatq.zzc("Unexpected response code %d for %s", Integer.valueOf(iZza), zzateVar.zzh());
                        if (bArr != null) {
                            zzataVar = new zzata(iZza, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaucVar.zzb());
                            if (iZza == 401) {
                            }
                            zzaszVar = new zzasm(zzataVar);
                            str = "auth";
                        } else {
                            zzaszVar = new zzasz();
                            str = "network";
                        }
                    }
                    zzass zzassVarZzy2 = zzateVar.zzy();
                    iZzo = zzateVar.zzo();
                    zzassVarZzy2.zzc(zzaszVar);
                    zzateVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
                }
            } catch (IOException e4) {
                e = e4;
                bArr = null;
            }
            zzateVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
        }
    }
}
