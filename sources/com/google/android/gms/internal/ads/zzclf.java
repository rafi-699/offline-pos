package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public class zzclf extends WebViewClient implements zzcms {
    public static final /* synthetic */ int zzc = 0;
    private zzdzl zzA;
    private zzdbn zzB;
    private boolean zzC;
    private boolean zzD;
    private int zzE;
    private boolean zzF;
    private final zzekr zzH;
    private View.OnAttachStateChangeListener zzI;
    protected final zzcku zza;
    protected zzcdn zzb;
    private final zzbhp zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzcmq zzi;
    private zzcmr zzj;
    private zzbog zzk;
    private zzboi zzl;
    private zzdky zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzad zzw;
    private zzbyf zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbya zzz = null;
    private final HashSet zzG = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgH)).split(",")));

    public zzclf(zzcku zzckuVar, zzbhp zzbhpVar, boolean z, zzbyf zzbyfVar, zzbya zzbyaVar, zzekr zzekrVar) {
        this.zzd = zzbhpVar;
        this.zza = zzckuVar;
        this.zzs = z;
        this.zzx = zzbyfVar;
        this.zzH = zzekrVar;
    }

    private final void zzac(final View view, final zzcdn zzcdnVar, final int i) {
        if (!zzcdnVar.zzc() || i <= 0) {
            return;
        }
        zzcdnVar.zzd(view);
        if (zzcdnVar.zzc()) {
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcld
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzU(view, zzcdnVar, i);
                }
            }, 100L);
        }
    }

    private final void zzad() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzI;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zza).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private static WebResourceResponse zzae() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbv)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzaf(String str, Map map) throws Throwable {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                int i2 = zzfzr.zzb;
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.util.zzs zzsVarZzc = com.google.android.gms.ads.internal.zzt.zzc();
                try {
                    zzcku zzckuVar = this.zza;
                    zzsVarZzc.zzb(zzckuVar.getContext(), zzckuVar.zzs().afmaVersion, false, httpURLConnection, false, 60000);
                    WebResourceResponse webResourceResponseZzc = null;
                    com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                    zzlVar.zza(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzlVar.zzc(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        com.google.android.gms.ads.internal.zzt.zzc();
                        com.google.android.gms.ads.internal.zzt.zzc();
                        String contentType = httpURLConnection.getContentType();
                        String strTrim = "";
                        String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                        com.google.android.gms.ads.internal.zzt.zzc();
                        String contentType2 = httpURLConnection.getContentType();
                        if (!TextUtils.isEmpty(contentType2)) {
                            String[] strArrSplit = contentType2.split(";");
                            if (strArrSplit.length != 1) {
                                for (int i3 = 1; i3 < strArrSplit.length; i3++) {
                                    if (strArrSplit[i3].trim().startsWith("charset")) {
                                        String[] strArrSplit2 = strArrSplit[i3].trim().split("=");
                                        if (strArrSplit2.length > 1) {
                                            strTrim = strArrSplit2[1].trim();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        String str2 = strTrim;
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        HashMap map2 = new HashMap(headerFields.size());
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                                map2.put(entry2.getKey(), entry2.getValue().get(0));
                            }
                        }
                        webResourceResponseZzc = com.google.android.gms.ads.internal.zzt.zzf().zzc(strTrim2, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), map2, httpURLConnection.getInputStream());
                    } else {
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        }
                        if (!headerField.startsWith("tel:")) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Protocol is null");
                                webResourceResponseZzc = zzae();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                StringBuilder sb = new StringBuilder(headerField.length() + 15);
                                sb.append("Redirecting to ");
                                sb.append(headerField);
                                String string = sb.toString();
                                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                StringBuilder sb2 = new StringBuilder(protocol.length() + 20);
                                sb2.append("Unsupported scheme: ");
                                sb2.append(protocol);
                                String string2 = sb2.toString();
                                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzi(string2);
                                webResourceResponseZzc = zzae();
                            }
                        }
                    }
                    TrafficStats.clearThreadStatsTag();
                    return webResourceResponseZzc;
                } catch (Throwable th) {
                    th = th;
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public final void zzaa(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                String str3 = (String) map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbpq) it.next()).zza(this.zza, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzah, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzY(boolean z, long j) {
        this.zza.zzu(z, j);
    }

    private static final boolean zzai(zzcku zzckuVar) {
        return zzckuVar.zzC() != null && zzckuVar.zzC().zzb();
    }

    private static final boolean zzaj(boolean z, zzcku zzckuVar) {
        return (!z || zzckuVar.zzN().zzg() || zzckuVar.zzO().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzQ(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            zzcku zzckuVar = this.zza;
            if (zzckuVar.zzX()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                zzckuVar.zzY();
                return;
            }
            this.zzC = true;
            zzcmr zzcmrVar = this.zzj;
            if (zzcmrVar != null) {
                zzcmrVar.zza();
                this.zzj = null;
            }
            zzu();
            zzcku zzckuVar2 = this.zza;
            if (zzckuVar2.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzns)).booleanValue()) {
                    zzckuVar2.zzL().zzz(str);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzL(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case Imgproc.COLOR_YUV2BGR_NV12 /* 91 */:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZzd = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZzd.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZzd.getHost())) {
            zzQ(uriZzd);
        } else {
            if (this.zzn && webView == this.zza.zzD()) {
                String scheme = uriZzd.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzcdn zzcdnVar = this.zzb;
                        if (zzcdnVar != null) {
                            zzcdnVar.zzb(str);
                        }
                        this.zzg = null;
                    }
                    zzdky zzdkyVar = this.zzm;
                    if (zzdkyVar != null) {
                        zzdkyVar.zzdu();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            zzcku zzckuVar = this.zza;
            if (zzckuVar.zzD().willNotDraw()) {
                String.valueOf(str);
                com.google.android.gms.ads.internal.util.client.zzo.zzi("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzbap zzbapVarZzS = zzckuVar.zzS();
                    zzflc zzflcVarZzT = zzckuVar.zzT();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznw)).booleanValue() || zzflcVarZzT == null) {
                        if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                            uriZzd = zzbapVarZzS.zzd(uriZzd, zzckuVar.getContext(), (View) zzckuVar, zzckuVar.zzj());
                        }
                    } else if (zzbapVarZzS != null && zzbapVarZzS.zza(uriZzd)) {
                        uriZzd = zzflcVarZzT.zza(uriZzd, zzckuVar.getContext(), (View) zzckuVar, zzckuVar.zzj());
                    }
                } catch (zzbaq unused) {
                    String.valueOf(str);
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.zzb()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZzd.toString(), null, null, null, null, null, null);
                    zzcku zzckuVar2 = this.zza;
                    zzv(zzcVar, true, false, zzckuVar2 != null ? zzckuVar2.zzn() : "");
                } else {
                    zzbVar.zzc(str);
                }
            }
        }
        return true;
    }

    public final void zzA(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbya zzbyaVar = this.zzz;
        boolean zZzd = zzbyaVar != null ? zzbyaVar.zzd() : false;
        com.google.android.gms.ads.internal.zzt.zzb();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zza.getContext(), adOverlayInfoParcel, !zZzd, this.zzA);
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzcdnVar.zzb(str);
        }
    }

    public final void zzB(String str, zzbpq zzbpqVar) {
        synchronized (this.zzf) {
            HashMap map = this.zze;
            List copyOnWriteArrayList = (List) map.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                map.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzbpqVar);
        }
    }

    public final void zzC(String str, zzbpq zzbpqVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbpqVar);
        }
    }

    public final void zzD(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public final void zzE(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbpq> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbpq zzbpqVar : list) {
                if (predicate.apply(zzbpqVar)) {
                    arrayList.add(zzbpqVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void zzF() {
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcdnVar.zzf();
            this.zzb = null;
        }
        zzad();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzu = false;
            this.zzw = null;
            this.zzy = null;
            this.zzx = null;
            zzbya zzbyaVar = this.zzz;
            if (zzbyaVar != null) {
                zzbyaVar.zzb(true);
                this.zzz = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzG(zzcmq zzcmqVar) {
        this.zzi = zzcmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzH(zzcmr zzcmrVar) {
        this.zzj = zzcmrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final zzdzl zzI() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzJ(zzdbn zzdbnVar) {
        this.zzB = zzdbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final zzdbn zzK() {
        return this.zzB;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0095  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fb A[Catch: all -> 0x01e1, TryCatch #3 {all -> 0x01e1, blocks: (B:59:0x018c, B:61:0x019e, B:62:0x01a5, B:71:0x01e9, B:73:0x01fb, B:74:0x0202), top: B:103:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02bb A[Catch: Exception | NoClassDefFoundError -> 0x02e5, Exception -> 0x02e7, TryCatch #12 {Exception | NoClassDefFoundError -> 0x02e5, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:63:0x01b0, B:43:0x016f, B:88:0x02bb, B:91:0x02cb, B:93:0x02d1, B:95:0x02df, B:76:0x0238, B:77:0x026b, B:75:0x0206, B:42:0x013e, B:27:0x00d3, B:78:0x026c, B:80:0x0276, B:82:0x027c, B:84:0x02af), top: B:106:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02d1 A[Catch: Exception | NoClassDefFoundError -> 0x02e5, Exception -> 0x02e7, TryCatch #12 {Exception | NoClassDefFoundError -> 0x02e5, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:63:0x01b0, B:43:0x016f, B:88:0x02bb, B:91:0x02cb, B:93:0x02d1, B:95:0x02df, B:76:0x0238, B:77:0x026b, B:75:0x0206, B:42:0x013e, B:27:0x00d3, B:78:0x026c, B:80:0x0276, B:82:0x027c, B:84:0x02af), top: B:106:0x000c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    protected final WebResourceResponse zzL(String str, Map map) {
        WebResourceResponse webResourceResponse;
        int i;
        InputStream inputStream;
        InputStream inputStreamZzb;
        Long l;
        final boolean z;
        final boolean z2;
        String string;
        try {
            Map map2 = new HashMap();
            zzcku zzckuVar = this.zza;
            if (zzckuVar.zzC() != null) {
                map2 = zzckuVar.zzC().zzaw;
            }
            String strZza = zzceb.zza(str, zzckuVar.getContext(), this.zzF, map2);
            if (!strZza.equals(str)) {
                return zzaf(strZza, map);
            }
            Parcelable.Creator<zzbhb> creator = zzbhb.CREATOR;
            zzbhb zzbhbVarZza = zzbhb.zza(Uri.parse(str));
            if (zzbhbVarZza != null) {
                HashMap map3 = new HashMap();
                map3.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ProxyConfig.MATCH_ALL_SCHEMES);
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains("range")) {
                    List listZze = zzgty.zza(zzgsx.zzc('-')).zze(uri.getQueryParameter("range"));
                    if (listZze.size() == 2) {
                        int i2 = Integer.parseInt((String) listZze.get(0));
                        int i3 = Integer.parseInt((String) listZze.get(1)) + 1;
                        if (i2 > 0) {
                            zzbhbVarZza.zzh = i2;
                        }
                        i = i3 - i2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                final boolean z3 = "X-Afma-Gcache-CachedBytes";
                webResourceResponse = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfk)).booleanValue()) {
                    zzbhbVarZza.zzi = zzgua.zza(zzckuVar.zzn());
                    zzbhbVarZza.zzj = zzckuVar.zzp();
                    if (zzbhbVarZza.zzg) {
                        l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfm);
                    } else {
                        l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfl);
                    }
                    try {
                        long jLongValue = l.longValue();
                        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
                        com.google.android.gms.ads.internal.zzt.zzz();
                        Future futureZza = zzbhm.zza(zzckuVar.getContext(), zzbhbVarZza);
                        try {
                            zzbhn zzbhnVar = (zzbhn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                            try {
                                try {
                                    map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbhnVar.zzc()));
                                    map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbhnVar.zzd()));
                                    map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbhnVar.zzf()));
                                    map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbhnVar.zze()));
                                    inputStreamZzb = zzbhnVar.zzb();
                                    if (i != -1) {
                                        try {
                                            inputStreamZzb = zzgzm.zzb(inputStreamZzb, i);
                                        } catch (InterruptedException e) {
                                            e = e;
                                            z2 = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            Thread.currentThread().interrupt();
                                            final long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckz
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzX(z2, jElapsedRealtime2);
                                                }
                                            });
                                            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 24);
                                            sb.append("Cache connection took ");
                                            sb.append(jElapsedRealtime2);
                                            sb.append("ms");
                                            string = sb.toString();
                                        } catch (ExecutionException e2) {
                                            e = e2;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzW(z, jElapsedRealtime3);
                                                }
                                            });
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(jElapsedRealtime3).length() + 24);
                                            sb2.append("Cache connection took ");
                                            sb2.append(jElapsedRealtime3);
                                            sb2.append("ms");
                                            string = sb2.toString();
                                        } catch (TimeoutException e3) {
                                            e = e3;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzW(z, jElapsedRealtime4);
                                                }
                                            });
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(jElapsedRealtime4).length() + 24);
                                            sb3.append("Cache connection took ");
                                            sb3.append(jElapsedRealtime4);
                                            sb3.append("ms");
                                            string = sb3.toString();
                                        }
                                    }
                                    final long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                    final boolean z4 = true;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable(z4, jElapsedRealtime5) { // from class: com.google.android.gms.internal.ads.zzckx
                                        private final /* synthetic */ long zzb;

                                        {
                                            this.zzb = jElapsedRealtime5;
                                        }

                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzV(true, this.zzb);
                                        }
                                    });
                                    StringBuilder sb4 = new StringBuilder(String.valueOf(jElapsedRealtime5).length() + 24);
                                    sb4.append("Cache connection took ");
                                    sb4.append(jElapsedRealtime5);
                                    sb4.append("ms");
                                    string = sb4.toString();
                                } catch (InterruptedException e4) {
                                    e = e4;
                                    inputStreamZzb = null;
                                } catch (ExecutionException e5) {
                                    e = e5;
                                    inputStreamZzb = null;
                                    z = true;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                        com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                    }
                                    futureZza.cancel(true);
                                    final long jElapsedRealtime6 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzW(z, jElapsedRealtime6);
                                        }
                                    });
                                    StringBuilder sb5 = new StringBuilder(String.valueOf(jElapsedRealtime6).length() + 24);
                                    sb5.append("Cache connection took ");
                                    sb5.append(jElapsedRealtime6);
                                    sb5.append("ms");
                                    string = sb5.toString();
                                    com.google.android.gms.ads.internal.util.zze.zza(string);
                                    inputStream = inputStreamZzb;
                                    if (inputStream != null) {
                                        return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                                    }
                                } catch (TimeoutException e6) {
                                    e = e6;
                                    inputStreamZzb = null;
                                    z = true;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                        com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                    }
                                    futureZza.cancel(true);
                                    final long jElapsedRealtime7 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzW(z, jElapsedRealtime7);
                                        }
                                    });
                                    StringBuilder sb6 = new StringBuilder(String.valueOf(jElapsedRealtime7).length() + 24);
                                    sb6.append("Cache connection took ");
                                    sb6.append(jElapsedRealtime7);
                                    sb6.append("ms");
                                    string = sb6.toString();
                                    com.google.android.gms.ads.internal.util.zze.zza(string);
                                    inputStream = inputStreamZzb;
                                    if (inputStream != null) {
                                        return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                                    }
                                }
                                com.google.android.gms.ads.internal.util.zze.zza(string);
                            } catch (Throwable th) {
                                th = th;
                                z3 = 1;
                                final long jElapsedRealtime8 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcla
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzY(z3, jElapsedRealtime8);
                                    }
                                });
                                StringBuilder sb7 = new StringBuilder(String.valueOf(jElapsedRealtime8).length() + 24);
                                sb7.append("Cache connection took ");
                                sb7.append(jElapsedRealtime8);
                                sb7.append("ms");
                                com.google.android.gms.ads.internal.util.zze.zza(sb7.toString());
                                throw th;
                            }
                        } catch (InterruptedException e7) {
                            e = e7;
                            inputStreamZzb = null;
                            z2 = false;
                        } catch (ExecutionException e8) {
                            e = e8;
                            inputStreamZzb = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime9 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzW(z, jElapsedRealtime9);
                                }
                            });
                            StringBuilder sb8 = new StringBuilder(String.valueOf(jElapsedRealtime9).length() + 24);
                            sb8.append("Cache connection took ");
                            sb8.append(jElapsedRealtime9);
                            sb8.append("ms");
                            string = sb8.toString();
                            com.google.android.gms.ads.internal.util.zze.zza(string);
                            inputStream = inputStreamZzb;
                            if (inputStream != null) {
                                return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                            }
                        } catch (TimeoutException e9) {
                            e = e9;
                            inputStreamZzb = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfp)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime10 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcky
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzW(z, jElapsedRealtime10);
                                }
                            });
                            StringBuilder sb9 = new StringBuilder(String.valueOf(jElapsedRealtime10).length() + 24);
                            sb9.append("Cache connection took ");
                            sb9.append(jElapsedRealtime10);
                            sb9.append("ms");
                            string = sb9.toString();
                            com.google.android.gms.ads.internal.util.zze.zza(string);
                            inputStream = inputStreamZzb;
                            if (inputStream != null) {
                                return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z3 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    zzbgy zzbgyVarZzc = com.google.android.gms.ads.internal.zzt.zzj().zzc(zzbhbVarZza);
                    if (zzbgyVarZzc == null || !zzbgyVarZzc.zza()) {
                        inputStream = null;
                    } else {
                        map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbgyVarZzc.zzd()));
                        map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbgyVarZzc.zzg()));
                        map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbgyVarZzc.zze()));
                        map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbgyVarZzc.zzf()));
                        inputStreamZzb = zzbgyVarZzc.zzb();
                        if (i != -1) {
                            inputStreamZzb = zzgzm.zzb(inputStreamZzb, i);
                        }
                    }
                    if (inputStream != null) {
                        return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                    }
                }
                inputStream = inputStreamZzb;
                if (inputStream != null) {
                    return new WebResourceResponse("", "", 200, "OK", map3, inputStream);
                }
            } else {
                webResourceResponse = null;
            }
            return (com.google.android.gms.ads.internal.util.client.zzl.zzj() || !((Boolean) zzbkm.zzb.zze()).booleanValue()) ? webResourceResponse : zzaf(str, map);
        } catch (Exception | NoClassDefFoundError e10) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e10, "AdWebViewClient.interceptRequest");
            return zzae();
        }
    }

    public final void zzM(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzN() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclb
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcku zzckuVar = this.zza.zza;
                    zzckuVar.zzah();
                    com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzckuVar.zzL();
                    if (zzmVarZzL != null) {
                        zzmVarZzL.zzv();
                    }
                }
            });
        }
    }

    public final void zzO(boolean z) {
        this.zzF = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzP(int i, int i2) {
        zzbya zzbyaVar = this.zzz;
        if (zzbyaVar != null) {
            zzbyaVar.zze(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzQ(Uri uri) {
        String strValueOf = String.valueOf(uri);
        String.valueOf(strValueOf);
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(strValueOf)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            String strValueOf2 = String.valueOf(uri);
            String.valueOf(strValueOf2);
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(strValueOf2)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhH)).booleanValue() || com.google.android.gms.ads.internal.zzt.zzh().zza() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws Throwable {
                    int i = zzclf.zzc;
                    com.google.android.gms.ads.internal.zzt.zzh().zza().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgG)).booleanValue() && this.zzG.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgI)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzhbw.zzr(com.google.android.gms.ads.internal.zzt.zzc().zzf(uri), new zzckw(this, list, path, uri), zzcfr.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        zzaa(com.google.android.gms.ads.internal.util.zzs.zzT(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzR(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzS(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzT(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    final /* synthetic */ void zzU(View view, zzcdn zzcdnVar, int i) {
        zzac(view, zzcdnVar, i - 1);
    }

    final /* synthetic */ void zzV(boolean z, long j) {
        zzY(true, j);
    }

    final /* synthetic */ void zzZ(View view, zzcdn zzcdnVar, int i) {
        zzac(view, zzcdnVar, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zza(int i, int i2, boolean z) {
        zzbyf zzbyfVar = this.zzx;
        if (zzbyfVar != null) {
            zzbyfVar.zzb(i, i2);
        }
        zzbya zzbyaVar = this.zzz;
        if (zzbyaVar != null) {
            zzbyaVar.zzc(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzab(com.google.android.gms.ads.internal.client.zza zzaVar, zzbog zzbogVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzboi zzboiVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z, zzbpt zzbptVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbyh zzbyhVar, zzcdn zzcdnVar, zzekg zzekgVar, zzfsc zzfscVar, zzdzl zzdzlVar, zzbql zzbqlVar, zzdky zzdkyVar, zzbqk zzbqkVar, zzbqe zzbqeVar, zzbpr zzbprVar, zzctj zzctjVar, zzeao zzeaoVar, zzdbs zzdbsVar, zzdbn zzdbnVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zza.getContext(), zzcdnVar, null) : zzbVar;
        zzcku zzckuVar = this.zza;
        this.zzz = new zzbya(zzckuVar, zzbyhVar);
        this.zzb = zzcdnVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbE)).booleanValue()) {
            zzB("/adMetadata", new zzbof(zzbogVar));
        }
        if (zzboiVar != null) {
            zzB("/appEvent", new zzboh(zzboiVar));
        }
        zzB("/backButton", zzbpp.zzj);
        zzB("/refresh", zzbpp.zzk);
        zzB("/canOpenApp", zzbpp.zzb);
        zzB("/canOpenURLs", zzbpp.zza);
        zzB("/canOpenIntents", zzbpp.zzc);
        zzB("/close", zzbpp.zzd);
        zzB("/customClose", zzbpp.zze);
        zzB("/instrument", zzbpp.zzn);
        zzB("/delayPageLoaded", zzbpp.zzp);
        zzB("/delayPageClosed", zzbpp.zzq);
        zzB("/getLocationInfo", zzbpp.zzr);
        zzB("/log", zzbpp.zzg);
        zzB("/mraid", new zzbpx(zzbVar2, this.zzz, zzbyhVar));
        zzbyf zzbyfVar = this.zzx;
        if (zzbyfVar != null) {
            zzB("/mraidLoaded", zzbyfVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbqd(zzbVar3, this.zzz, zzekgVar, zzdzlVar, zzctjVar, zzdbsVar));
        zzB("/precache", new zzcjb());
        zzB("/touch", zzbpp.zzi);
        zzB("/video", zzbpp.zzl);
        zzB("/videoMeta", zzbpp.zzm);
        if (zzekgVar == null || zzfscVar == null) {
            zzB("/click", zzbpp.zzb(zzdkyVar, zzctjVar));
            zzB("/httpTrack", zzbpp.zzf);
        } else {
            zzB("/click", zzflj.zza(zzekgVar, zzfscVar, zzctjVar, zzdkyVar));
            zzB("/httpTrack", zzflj.zzb(zzekgVar, zzfscVar));
        }
        if (com.google.android.gms.ads.internal.zzt.zzD().zza(zzckuVar.getContext())) {
            Map map = new HashMap();
            if (zzckuVar.zzC() != null) {
                map = zzckuVar.zzC().zzaw;
            }
            zzB("/logScionEvent", new zzbpw(zzckuVar.getContext(), map));
        }
        if (zzbptVar != null) {
            zzB("/setInterstitialProperties", new zzbps(zzbptVar));
        }
        if (zzbqlVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzko)).booleanValue()) {
                zzB("/inspectorNetworkExtras", zzbqlVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkH)).booleanValue() && zzbqkVar != null) {
            zzB("/shareSheet", zzbqkVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziK)).booleanValue() && zzeaoVar != null) {
            zzB("/onDeviceStorageEvent", new zzbpy(zzeaoVar));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkM)).booleanValue() && zzbqeVar != null) {
            zzB("/inspectorOutOfContextTest", zzbqeVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkR)).booleanValue() && zzbprVar != null) {
            zzB("/inspectorStorage", zzbprVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmX)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzbpp.zzu);
            zzB("/presentPlayStoreOverlay", zzbpp.zzv);
            zzB("/expandPlayStoreOverlay", zzbpp.zzw);
            zzB("/collapsePlayStoreOverlay", zzbpp.zzx);
            zzB("/closePlayStoreOverlay", zzbpp.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzej)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzbpp.zzA);
            zzB("/resetPAID", zzbpp.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue() && zzckuVar.zzC() != null && zzckuVar.zzC().zzar) {
            zzB("/writeToLocalStorage", zzbpp.zzB);
            zzB("/clearLocalStorageKeys", zzbpp.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbogVar;
        this.zzl = zzboiVar;
        this.zzw = zzadVar;
        this.zzy = zzbVar3;
        this.zzm = zzdkyVar;
        this.zzA = zzdzlVar;
        this.zzB = zzdbnVar;
        this.zzn = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzb(zzfkf zzfkfVar) {
        zzcku zzckuVar = this.zza;
        if (com.google.android.gms.ads.internal.zzt.zzD().zza(zzckuVar.getContext())) {
            zzD("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbpw(zzckuVar.getContext(), zzfkfVar.zzaw));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzc(zzctj zzctjVar) {
        zzD("/click");
        zzB("/click", zzbpp.zzb(this.zzm, zzctjVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzd(zzctj zzctjVar, zzekg zzekgVar, zzfsc zzfscVar) {
        zzD("/click");
        if (zzekgVar == null || zzfscVar == null) {
            zzB("/click", zzbpp.zzb(this.zzm, zzctjVar));
        } else {
            zzB("/click", zzflj.zza(zzekgVar, zzfscVar, zzctjVar, this.zzm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzdky zzdkyVar = this.zzm;
        if (zzdkyVar != null) {
            zzdkyVar.zzdR();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzdky zzdkyVar = this.zzm;
        if (zzdkyVar != null) {
            zzdkyVar.zzdu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zze(zzctj zzctjVar, zzekg zzekgVar, zzdzl zzdzlVar) {
        zzD("/open");
        zzB("/open", new zzbqd(this.zzy, this.zzz, zzekgVar, zzdzlVar, zzctjVar, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final com.google.android.gms.ads.internal.zzb zzh() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzi(com.google.android.gms.ads.internal.zzb zzbVar) {
        this.zzy = zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzj(zzcdn zzcdnVar) {
        this.zzb = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final boolean zzk() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzo() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzp() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzq() {
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcku zzckuVar = this.zza;
            WebView webViewZzD = zzckuVar.zzD();
            if (ViewCompat.isAttachedToWindow(webViewZzD)) {
                zzac(webViewZzD, zzcdnVar, 10);
                return;
            }
            zzad();
            zzckv zzckvVar = new zzckv(this, zzcdnVar);
            this.zzI = zzckvVar;
            ((View) zzckuVar).addOnAttachStateChangeListener(zzckvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzr() {
        synchronized (this.zzf) {
        }
        this.zzE++;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzs() {
        this.zzE--;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcms
    public final void zzt() {
        zzbhp zzbhpVar = this.zzd;
        if (zzbhpVar != null) {
            zzbhpVar.zzc(Videoio.CAP_PROP_GIGA_FRAME_SENS_WIDTH);
        }
        this.zzD = true;
        this.zzp = Videoio.CAP_PROP_GIGA_FRAME_HEIGH_MAX;
        this.zzq = "Page loaded delay cancel.";
        zzu();
        this.zza.destroy();
    }

    public final void zzu() {
        if (this.zzi != null && ((this.zzC && this.zzE <= 0) || this.zzD || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue()) {
                zzcku zzckuVar = this.zza;
                if (zzckuVar.zzq() != null) {
                    zzbix.zza(zzckuVar.zzq().zzc(), zzckuVar.zzi(), "awfllc");
                }
            }
            this.zzi.zza((this.zzD || this.zzo) ? false : true, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zza.zzap();
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean z3 = false;
        boolean z4 = zzaj(zZzW, zzckuVar) || z2;
        if (z4 || !z) {
            z3 = true;
        }
        zzA(new AdOverlayInfoParcel(zzcVar, z4 ? null : this.zzg, zZzW ? null : this.zzh, this.zzw, zzckuVar.zzs(), zzckuVar, z3 ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i) {
        zzekr zzekrVar = this.zzH;
        zzcku zzckuVar = this.zza;
        zzA(new AdOverlayInfoParcel(zzckuVar, zzckuVar.zzs(), str, str2, 14, zzekrVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbyu] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final void zzx(boolean z, int i, boolean z2) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzdky zzdkyVar;
        zzcku zzckuVar = this.zza;
        boolean zZzaj = zzaj(zzckuVar.zzW(), zzckuVar);
        boolean z3 = true;
        if (!zZzaj && z2) {
            z3 = false;
        }
        if (zZzaj) {
            zzaVar = null;
            zzdkyVar = null;
        } else {
            zzaVar = this.zzg;
            zzdkyVar = null;
        }
        zzdky zzdkyVar2 = zzdkyVar;
        zzA(new AdOverlayInfoParcel(zzaVar, this.zzh, this.zzw, zzckuVar, z, i, zzckuVar.zzs(), z3 ? zzdkyVar2 : this.zzm, zzai(zzckuVar) ? this.zzH : zzdkyVar2));
    }

    public final void zzy(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean zZzaj = zzaj(zZzW, zzckuVar);
        boolean z4 = true;
        if (!zZzaj && z2) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzaj ? null : this.zzg;
        zzcle zzcleVar = zZzW ? null : new zzcle(zzckuVar, this.zzh);
        zzbog zzbogVar = this.zzk;
        zzekr zzekrVar = null;
        zzboi zzboiVar = this.zzl;
        boolean z5 = z4;
        zzcle zzcleVar2 = zzcleVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzckuVar.zzs();
        zzdky zzdkyVar = z5 ? null : this.zzm;
        if (zzai(zzckuVar)) {
            zzekrVar = this.zzH;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzcleVar2, zzbogVar, zzboiVar, zzadVar, zzckuVar, z, i, str, versionInfoParcelZzs, zzdkyVar, zzekrVar, z3));
    }

    public final void zzz(boolean z, int i, String str, String str2, boolean z2) {
        zzcku zzckuVar = this.zza;
        boolean zZzW = zzckuVar.zzW();
        boolean zZzaj = zzaj(zZzW, zzckuVar);
        boolean z3 = true;
        if (!zZzaj && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzaj ? null : this.zzg;
        zzcle zzcleVar = zZzW ? null : new zzcle(zzckuVar, this.zzh);
        zzbog zzbogVar = this.zzk;
        zzekr zzekrVar = null;
        zzboi zzboiVar = this.zzl;
        boolean z4 = z3;
        zzcle zzcleVar2 = zzcleVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzckuVar.zzs();
        zzdky zzdkyVar = z4 ? null : this.zzm;
        if (zzai(zzckuVar)) {
            zzekrVar = this.zzH;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzcleVar2, zzbogVar, zzboiVar, zzadVar, zzckuVar, z, i, str, str2, versionInfoParcelZzs, zzdkyVar, zzekrVar));
    }
}
