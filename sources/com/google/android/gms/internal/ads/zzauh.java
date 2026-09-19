package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzauh extends zzate {
    private final Object zza;
    private final zzatj zzb;

    public zzauh(int i, String str, zzatj zzatjVar, zzati zzatiVar) {
        super(i, str, zzatiVar);
        this.zza = new Object();
        this.zzb = zzatjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzate
    protected final zzatk zzr(zzata zzataVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzataVar.zzb;
            Map map = zzataVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(HttpHeaders.CONTENT_TYPE)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzataVar.zzb);
        }
        return zzatk.zza(str, zzaub.zza(zzataVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzate
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzs(String str) {
        zzatj zzatjVar;
        synchronized (this.zza) {
            zzatjVar = this.zzb;
        }
        zzatjVar.zza(str);
    }
}
