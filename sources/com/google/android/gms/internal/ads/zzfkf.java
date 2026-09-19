package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkf {
    public final zzcdk zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final int zzQ;
    public final int zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final String zzU;
    public final zzflb zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final int zzY;
    public final String zzZ;
    public final List zza;
    public final List zzaA;
    public final boolean zzaB;
    public final List zzaC;
    public final boolean zzaD;
    public final int zzaE;
    public final Bundle zzaF;
    public final boolean zzaG;
    public final JSONArray zzaH;
    public final int zzaI;
    public final int zzaa;
    public final String zzab;
    public final boolean zzac;
    public final zzbzh zzad;
    public final com.google.android.gms.ads.internal.client.zzt zzae;
    public final String zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final String zzal;
    public final boolean zzam;
    public final String zzan;
    public final String zzao;
    public final String zzap;
    public final boolean zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final boolean zzav;
    public final Map zzaw;
    public final com.google.android.gms.ads.internal.util.client.zzv zzax;
    public final com.google.android.gms.ads.internal.util.client.zzw zzay;
    public final double zzaz;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final int zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final String zzj;
    public final String zzk;
    public final zzccb zzl;
    public final List zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final int zzq;
    public final List zzr;
    public final zzfkk zzs;
    public final List zzt;
    public final List zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARN: Code duplicated, block: B:303:0x0949 A[PHI: r23 r25
  0x0949: PHI (r23v95 java.util.List) = 
  (r23v5 java.util.List)
  (r23v6 java.util.List)
  (r23v7 java.util.List)
  (r23v8 java.util.List)
  (r23v9 java.util.List)
  (r23v10 java.util.List)
  (r23v11 java.util.List)
  (r23v12 java.util.List)
  (r23v13 java.util.List)
  (r23v14 java.util.List)
  (r23v15 java.util.List)
  (r23v16 java.util.List)
  (r23v17 java.util.List)
  (r23v18 java.util.List)
  (r23v19 java.util.List)
  (r23v20 java.util.List)
  (r23v21 java.util.List)
  (r23v22 java.util.List)
  (r23v23 java.util.List)
  (r23v24 java.util.List)
  (r23v25 java.util.List)
  (r23v26 java.util.List)
  (r23v27 java.util.List)
  (r23v28 java.util.List)
  (r23v29 java.util.List)
  (r23v30 java.util.List)
  (r23v31 java.util.List)
  (r23v32 java.util.List)
  (r23v33 java.util.List)
  (r23v34 java.util.List)
  (r23v35 java.util.List)
  (r23v36 java.util.List)
  (r23v37 java.util.List)
  (r23v38 java.util.List)
  (r23v39 java.util.List)
  (r23v40 java.util.List)
  (r23v41 java.util.List)
  (r23v42 java.util.List)
  (r23v43 java.util.List)
  (r23v44 java.util.List)
  (r23v45 java.util.List)
  (r23v46 java.util.List)
  (r23v47 java.util.List)
  (r23v48 java.util.List)
  (r23v49 java.util.List)
  (r23v50 java.util.List)
  (r23v51 java.util.List)
  (r23v52 java.util.List)
  (r23v53 java.util.List)
  (r23v54 java.util.List)
  (r23v55 java.util.List)
  (r23v56 java.util.List)
  (r23v57 java.util.List)
  (r23v58 java.util.List)
  (r23v59 java.util.List)
  (r23v60 java.util.List)
  (r23v61 java.util.List)
  (r23v62 java.util.List)
  (r23v63 java.util.List)
  (r23v64 java.util.List)
  (r23v65 java.util.List)
  (r23v66 java.util.List)
  (r23v67 java.util.List)
  (r23v68 java.util.List)
  (r23v69 java.util.List)
  (r23v70 java.util.List)
  (r23v71 java.util.List)
  (r23v72 java.util.List)
  (r23v73 java.util.List)
  (r23v74 java.util.List)
  (r23v75 java.util.List)
  (r23v76 java.util.List)
  (r23v77 java.util.List)
  (r23v78 java.util.List)
  (r23v79 java.util.List)
  (r23v80 java.util.List)
  (r23v81 java.util.List)
  (r23v82 java.util.List)
  (r23v83 java.util.List)
  (r23v84 java.util.List)
  (r23v85 java.util.List)
  (r23v86 java.util.List)
  (r23v87 java.util.List)
  (r23v88 java.util.List)
  (r23v89 java.util.List)
  (r23v90 java.util.List)
  (r23v91 java.util.List)
  (r23v92 java.util.List)
  (r23v93 java.util.List)
  (r23v96 java.util.List)
 binds: [B:301:0x0941, B:298:0x092b, B:295:0x0915, B:289:0x08e8, B:286:0x08d4, B:283:0x08be, B:280:0x08a8, B:274:0x087b, B:271:0x0861, B:268:0x084d, B:265:0x0839, B:262:0x0823, B:259:0x0809, B:256:0x07f5, B:250:0x07c9, B:247:0x07af, B:244:0x0799, B:241:0x0783, B:238:0x076d, B:235:0x0757, B:232:0x0741, B:229:0x072b, B:226:0x0715, B:223:0x06ff, B:220:0x06e5, B:217:0x06cf, B:214:0x06ba, B:211:0x06a1, B:208:0x068b, B:205:0x0677, B:202:0x0663, B:199:0x064f, B:196:0x0637, B:193:0x0623, B:190:0x060f, B:187:0x05fb, B:181:0x05d2, B:178:0x05bc, B:175:0x05a2, B:172:0x058e, B:169:0x0578, B:166:0x0562, B:163:0x054c, B:160:0x0536, B:157:0x0523, B:154:0x050d, B:151:0x04f9, B:148:0x04e3, B:145:0x04cd, B:142:0x04b7, B:140:0x04a7, B:135:0x0486, B:132:0x0470, B:129:0x045c, B:126:0x0446, B:123:0x0432, B:120:0x041e, B:117:0x0408, B:114:0x03f2, B:111:0x03dc, B:108:0x03c6, B:105:0x03b2, B:96:0x037e, B:93:0x0368, B:90:0x034f, B:84:0x0326, B:81:0x0312, B:78:0x02f9, B:75:0x02e5, B:72:0x02d2, B:69:0x02bc, B:66:0x02a6, B:63:0x0290, B:60:0x027c, B:54:0x0253, B:51:0x023e, B:48:0x022b, B:45:0x0218, B:42:0x0205, B:39:0x01f2, B:36:0x01dd, B:31:0x01c5, B:28:0x01b0, B:25:0x019b, B:22:0x0188, B:19:0x0173, B:16:0x015d, B:13:0x0147, B:11:0x0135, B:399:0x0949] A[DONT_GENERATE, DONT_INLINE]
  0x0949: PHI (r25v93 java.util.List) = 
  (r25v2 java.util.List)
  (r25v3 java.util.List)
  (r25v4 java.util.List)
  (r25v5 java.util.List)
  (r25v6 java.util.List)
  (r25v7 java.util.List)
  (r25v8 java.util.List)
  (r25v9 java.util.List)
  (r25v10 java.util.List)
  (r25v11 java.util.List)
  (r25v12 java.util.List)
  (r25v13 java.util.List)
  (r25v14 java.util.List)
  (r25v15 java.util.List)
  (r25v16 java.util.List)
  (r25v17 java.util.List)
  (r25v18 java.util.List)
  (r25v19 java.util.List)
  (r25v20 java.util.List)
  (r25v21 java.util.List)
  (r25v22 java.util.List)
  (r25v23 java.util.List)
  (r25v24 java.util.List)
  (r25v25 java.util.List)
  (r25v26 java.util.List)
  (r25v27 java.util.List)
  (r25v28 java.util.List)
  (r25v29 java.util.List)
  (r25v30 java.util.List)
  (r25v31 java.util.List)
  (r25v32 java.util.List)
  (r25v33 java.util.List)
  (r25v34 java.util.List)
  (r25v35 java.util.List)
  (r25v36 java.util.List)
  (r25v37 java.util.List)
  (r25v38 java.util.List)
  (r25v39 java.util.List)
  (r25v40 java.util.List)
  (r25v41 java.util.List)
  (r25v42 java.util.List)
  (r25v43 java.util.List)
  (r25v44 java.util.List)
  (r25v45 java.util.List)
  (r25v46 java.util.List)
  (r25v47 java.util.List)
  (r25v48 java.util.List)
  (r25v49 java.util.List)
  (r25v50 java.util.List)
  (r25v51 java.util.List)
  (r25v52 java.util.List)
  (r25v53 java.util.List)
  (r25v54 java.util.List)
  (r25v55 java.util.List)
  (r25v56 java.util.List)
  (r25v57 java.util.List)
  (r25v58 java.util.List)
  (r25v59 java.util.List)
  (r25v60 java.util.List)
  (r25v61 java.util.List)
  (r25v62 java.util.List)
  (r25v63 java.util.List)
  (r25v64 java.util.List)
  (r25v65 java.util.List)
  (r25v66 java.util.List)
  (r25v67 java.util.List)
  (r25v68 java.util.List)
  (r25v69 java.util.List)
  (r25v70 java.util.List)
  (r25v71 java.util.List)
  (r25v72 java.util.List)
  (r25v73 java.util.List)
  (r25v74 java.util.List)
  (r25v75 java.util.List)
  (r25v76 java.util.List)
  (r25v77 java.util.List)
  (r25v78 java.util.List)
  (r25v79 java.util.List)
  (r25v80 java.util.List)
  (r25v81 java.util.List)
  (r25v82 java.util.List)
  (r25v83 java.util.List)
  (r25v84 java.util.List)
  (r25v85 java.util.List)
  (r25v86 java.util.List)
  (r25v87 java.util.List)
  (r25v88 java.util.List)
  (r25v89 java.util.List)
  (r25v90 java.util.List)
  (r25v94 java.util.List)
 binds: [B:301:0x0941, B:298:0x092b, B:295:0x0915, B:289:0x08e8, B:286:0x08d4, B:283:0x08be, B:280:0x08a8, B:274:0x087b, B:271:0x0861, B:268:0x084d, B:265:0x0839, B:262:0x0823, B:259:0x0809, B:256:0x07f5, B:250:0x07c9, B:247:0x07af, B:244:0x0799, B:241:0x0783, B:238:0x076d, B:235:0x0757, B:232:0x0741, B:229:0x072b, B:226:0x0715, B:223:0x06ff, B:220:0x06e5, B:217:0x06cf, B:214:0x06ba, B:211:0x06a1, B:208:0x068b, B:205:0x0677, B:202:0x0663, B:199:0x064f, B:196:0x0637, B:193:0x0623, B:190:0x060f, B:187:0x05fb, B:181:0x05d2, B:178:0x05bc, B:175:0x05a2, B:172:0x058e, B:169:0x0578, B:166:0x0562, B:163:0x054c, B:160:0x0536, B:157:0x0523, B:154:0x050d, B:151:0x04f9, B:148:0x04e3, B:145:0x04cd, B:142:0x04b7, B:140:0x04a7, B:135:0x0486, B:132:0x0470, B:129:0x045c, B:126:0x0446, B:123:0x0432, B:120:0x041e, B:117:0x0408, B:114:0x03f2, B:111:0x03dc, B:108:0x03c6, B:105:0x03b2, B:96:0x037e, B:93:0x0368, B:90:0x034f, B:84:0x0326, B:81:0x0312, B:78:0x02f9, B:75:0x02e5, B:72:0x02d2, B:69:0x02bc, B:66:0x02a6, B:63:0x0290, B:60:0x027c, B:54:0x0253, B:51:0x023e, B:48:0x022b, B:45:0x0218, B:42:0x0205, B:39:0x01f2, B:36:0x01dd, B:31:0x01c5, B:28:0x01b0, B:25:0x019b, B:22:0x0188, B:19:0x0173, B:16:0x015d, B:13:0x0147, B:11:0x0135, B:399:0x0949] A[DONT_GENERATE, DONT_INLINE]] */
    zzfkf(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List list;
        List list2;
        List listEmptyList = Collections.emptyList();
        List listEmptyList2 = Collections.emptyList();
        List listEmptyList3 = Collections.emptyList();
        List listEmptyList4 = Collections.emptyList();
        List listEmptyList5 = Collections.emptyList();
        List listEmptyList6 = Collections.emptyList();
        List listEmptyList7 = Collections.emptyList();
        List listEmptyList8 = Collections.emptyList();
        List listEmptyList9 = Collections.emptyList();
        List listEmptyList10 = Collections.emptyList();
        List listEmptyList11 = Collections.emptyList();
        List listEmptyList12 = Collections.emptyList();
        List listEmptyList13 = Collections.emptyList();
        List listEmptyList14 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        zzgwm.zzi();
        zzgwm zzgwmVarZzi = zzgwm.zzi();
        HashMap map = new HashMap();
        zzgwm zzgwmVarZzi2 = zzgwm.zzi();
        zzgwm zzgwmVarZzi3 = zzgwm.zzi();
        Bundle bundle = new Bundle();
        jsonReader.beginObject();
        JSONObject jSONObjectZzd = jSONObject2;
        JSONObject jSONObjectZzd2 = jSONObject3;
        JSONObject jSONObjectZzd3 = jSONObject4;
        JSONObject jSONObjectZzd4 = jSONObject5;
        JSONObject jSONObjectZzd5 = jSONObject6;
        List listZzb = zzgwmVarZzi;
        Map mapZzc = map;
        List listZzb2 = zzgwmVarZzi2;
        zzgwm zzgwmVarZza = zzgwmVarZzi3;
        Bundle bundle2 = bundle;
        zzfkk zzfkkVar = null;
        zzcdk zzcdkVarZza = null;
        zzbzh zzbzhVarZza = null;
        com.google.android.gms.ads.internal.client.zzt zztVarZza = null;
        String strNextString = null;
        com.google.android.gms.ads.internal.util.client.zzv zzvVarZzb = null;
        com.google.android.gms.ads.internal.util.client.zzw zzwVarZzd = null;
        JSONArray jSONArrayZze = null;
        boolean zNextBoolean = true;
        int iZze = -1;
        int iNextInt = -1;
        int iNextInt2 = -1;
        int iNextInt3 = 0;
        boolean zNextBoolean2 = false;
        boolean zNextBoolean3 = false;
        boolean zNextBoolean4 = false;
        boolean zNextBoolean5 = false;
        boolean zNextBoolean6 = false;
        boolean zNextBoolean7 = false;
        boolean zNextBoolean8 = false;
        int iNextInt4 = 0;
        boolean zNextBoolean9 = false;
        boolean zNextBoolean10 = false;
        boolean zNextBoolean11 = false;
        int iNextInt5 = 0;
        boolean zNextBoolean12 = false;
        boolean zNextBoolean13 = false;
        boolean zNextBoolean14 = false;
        boolean zNextBoolean15 = false;
        boolean zNextBoolean16 = false;
        boolean zNextBoolean17 = false;
        boolean zNextBoolean18 = false;
        boolean zNextBoolean19 = false;
        int iNextInt6 = 0;
        boolean zNextBoolean20 = false;
        boolean zNextBoolean21 = false;
        boolean zNextBoolean22 = false;
        int iZza = 2;
        double dNextDouble = 0.0d;
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String string = strNextString4;
        String strNextString5 = string;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        String strNextString8 = strNextString7;
        String strNextString9 = strNextString8;
        String strNextString10 = strNextString9;
        String strNextString11 = strNextString10;
        String strNextString12 = strNextString11;
        String strNextString13 = strNextString12;
        String strNextString14 = strNextString13;
        String strNextString15 = strNextString14;
        String strNextString16 = strNextString15;
        String strNextString17 = strNextString16;
        String strNextString18 = strNextString17;
        List listZzb3 = listEmptyList11;
        List listZza = listEmptyList12;
        List listZzb4 = listEmptyList13;
        List listZza2 = listEmptyList14;
        JSONObject jSONObjectZzd6 = jSONObject;
        zzccb zzccbVarZza = null;
        int iZzc = 0;
        int iZzd = 0;
        String strNextString19 = strNextString18;
        String strNextString20 = strNextString19;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String str = strNextName == null ? "" : strNextName;
            switch (str.hashCode()) {
                case -2138196627:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_source_instance_name")) {
                        strNextString13 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1980587809:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("debug_signals")) {
                        jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1965512151:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("omid_settings")) {
                        jSONObjectZzd3 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1964744830:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("offline_ad_config") && ((Boolean) zzbiq.zzjR.zzg()).booleanValue()) {
                        zzwVarZzd = com.google.android.gms.ads.internal.util.client.zzw.zzd(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1871425831:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("recursive_server_response_data")) {
                        strNextString16 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1843156475:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_consent")) {
                        zNextBoolean19 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1840512279:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("presentation_urls")) {
                        listZzb2 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1828733410:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("network_ping_config") && ((Boolean) zzbiq.zzjP.zzg()).booleanValue()) {
                        zzvVarZzb = com.google.android.gms.ads.internal.util.client.zzv.zzb(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1812055556:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("play_prewarm_options")) {
                        zzbzhVarZza = zzbzh.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1785028569:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("parallel_key")) {
                        strNextString18 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1776946669:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_source_name")) {
                        strNextString11 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1662989631:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_interscroller")) {
                        zNextBoolean13 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1620552059:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("preload_sort_type")) {
                        iZza = zzftl.zza(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1620470467:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("backend_query_id")) {
                        strNextString8 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1550155393:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (!str.equals("nofill_urls")) {
                        listEmptyList10 = list2;
                        listEmptyList9 = list;
                    } else {
                        listEmptyList9 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                        listEmptyList10 = list2;
                    }
                    break;
                case -1440104884:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_custom_close_blocked")) {
                        zNextBoolean7 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1439500848:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("orientation")) {
                        iZze = zze(jsonReader.nextString());
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1428969291:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("enable_omid")) {
                        zNextBoolean9 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1406227629:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("buffer_click_url_as_ready_to_ping")) {
                        zNextBoolean17 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1403779768:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("showable_impression_type")) {
                        iNextInt5 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1375413093:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_cover")) {
                        jSONObjectZzd4 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1360811658:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_sizes")) {
                        listZza2 = zzfkg.zza(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1306015996:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("adapters")) {
                        listZzb4 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1303332046:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("test_mode_enabled")) {
                        zNextBoolean6 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1289032093:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("extras")) {
                        jSONObjectZzd2 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1240082064:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_event_value")) {
                        zztVarZza = com.google.android.gms.ads.internal.client.zzt.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1234181075:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("allow_pub_rendered_attribution")) {
                        zNextBoolean2 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1168140544:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("presentation_error_urls")) {
                        listEmptyList10 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                        listEmptyList10 = list2;
                    }
                    listEmptyList9 = list;
                    break;
                case -1152230954:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
                        iZzc = zzc(jsonReader.nextString());
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1146534047:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_scroll_aware")) {
                        zNextBoolean11 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1115838944:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("fill_urls")) {
                        listEmptyList8 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1081936678:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("allocation_id")) {
                        strNextString2 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1078050970:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("video_complete_urls")) {
                        listEmptyList7 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -1051269058:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("active_view")) {
                        string = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader).toString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -982608540:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("valid_from_timestamp")) {
                        strNextString19 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -972056451:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_source_instance_id")) {
                        strNextString14 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -776859333:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("click_urls")) {
                        listEmptyList2 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -652881372:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("on_device_storage_configs") && ((Boolean) zzbiq.zziK.zzg()).booleanValue()) {
                        zzgwmVarZza = zzeap.zza(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -570101180:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("late_load_urls")) {
                        listZzb = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -544216775:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("safe_browsing")) {
                        zzcdkVarZza = zzcdk.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -437057161:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("imp_urls")) {
                        listEmptyList3 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -404433734:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("rtb_native_required_assets")) {
                        jSONObjectZzd5 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -404326515:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("render_timeout_ms")) {
                        iNextInt4 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -397704715:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_close_time_ms")) {
                        iNextInt = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -388807511:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals(ShareConstants.STORY_DEEP_LINK_URL)) {
                        strNextString = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -369773488:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_close_button_enabled")) {
                        jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -213449460:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("force_disable_hardware_acceleration")) {
                        zNextBoolean16 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -213424028:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("watermark")) {
                        strNextString7 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -180214626:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("native_required_asset_viewability")) {
                        zNextBoolean15 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -154616268:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_offline_ad")) {
                        zNextBoolean14 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case -29338502:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("allow_custom_click_gesture")) {
                        zNextBoolean4 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 3107:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad")) {
                        zzfkkVar = new zzfkk(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 3355:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("id")) {
                        strNextString3 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 3076010:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("data")) {
                        jSONObjectZzd6 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 37109963:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals(SDKAnalyticsEvents.PARAMETER_REQUEST_ID)) {
                        strNextString15 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 63195984:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("render_test_label")) {
                        zNextBoolean5 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 107433883:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("qdata")) {
                        strNextString4 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 230323073:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_load_urls")) {
                        listEmptyList4 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 281223176:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_secondary_analytics_logging_enabled")) {
                        zNextBoolean = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 418392395:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_closable_area_disabled")) {
                        zNextBoolean8 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 542250332:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("consent_form_action_identifier")) {
                        iNextInt6 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 549176928:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("presentation_error_timeout_ms")) {
                        iNextInt3 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 597473788:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("debug_dialog_string")) {
                        strNextString5 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 639133141:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("response_info_extras_override") && ((Boolean) zzbiq.zzhL.zzg()).booleanValue()) {
                        try {
                            Bundle bundleZzl = com.google.android.gms.ads.internal.util.zzbp.zzl(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                            if (bundleZzl != null) {
                                bundle2 = bundleZzl;
                            }
                        } catch (IllegalStateException unused) {
                            jsonReader.skipValue();
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 754887508:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("container_sizes")) {
                        listZza = zzfkg.zza(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 791122864:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("impression_type")) {
                        iZzd = zzd(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 805095541:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("analytics_event_name_to_parameters_map") && ((Boolean) zzbiq.zzaO.zzg()).booleanValue()) {
                        mapZzc = com.google.android.gms.ads.internal.util.zzbp.zzc(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1010584092:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        strNextString20 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1100650276:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("rewards")) {
                        zzccbVarZza = zzccb.zza(com.google.android.gms.ads.internal.util.zzbp.zze(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1141602460:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("adapter_response_info_key")) {
                        strNextString17 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1186014765:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("cache_hit_urls")) {
                        com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1303622534:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("preload_sort_value")) {
                        dNextDouble = jsonReader.nextDouble();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1321720943:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("allow_pub_owned_ad_view")) {
                        zNextBoolean3 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1422388341:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_collapsible")) {
                        zNextBoolean18 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1437255331:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_source_id")) {
                        strNextString12 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1556932485:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("post_click_lifecycle_monitoring_duration_ms") && ((Boolean) zzbiq.zzop.zzg()).booleanValue()) {
                        iNextInt2 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1565514205:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("adapter_only_third_party_impression")) {
                        zNextBoolean22 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1637553475:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("bid_response")) {
                        strNextString6 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1638957285:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("video_start_urls")) {
                        listEmptyList5 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1686319423:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("ad_network_class_name")) {
                        strNextString10 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1688341040:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("video_reward_urls")) {
                        listEmptyList6 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1799285870:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("use_third_party_container_height")) {
                        zNextBoolean12 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1839650832:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("renderers")) {
                        listEmptyList = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 1875425491:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("is_analytics_logging_enabled")) {
                        zNextBoolean10 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2004337096:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("recursive_signal_collection")) {
                        jSONArrayZze = com.google.android.gms.ads.internal.util.zzbp.zze(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2068142375:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("rule_line_external_id")) {
                        strNextString9 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2072888499:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("manual_tracking_urls")) {
                        listZzb3 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2075506442:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    if (str.equals("render_serially")) {
                        zNextBoolean20 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                case 2117205836:
                    list2 = listEmptyList10;
                    list = listEmptyList9;
                    if (str.equals("flow_control")) {
                        zNextBoolean21 = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
                default:
                    list = listEmptyList9;
                    list2 = listEmptyList10;
                    jsonReader.skipValue();
                    listEmptyList10 = list2;
                    listEmptyList9 = list;
                    break;
            }
        }
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzb = iZzc;
        this.zzc = listEmptyList2;
        this.zzd = listEmptyList3;
        this.zzf = listEmptyList4;
        this.zze = iZzd;
        this.zzg = listEmptyList5;
        this.zzh = listEmptyList6;
        this.zzi = listEmptyList7;
        this.zzj = strNextString20;
        this.zzk = strNextString19;
        this.zzl = zzccbVarZza;
        this.zzm = listEmptyList8;
        this.zzn = listEmptyList9;
        this.zzo = listEmptyList10;
        this.zzp = listZzb3;
        this.zzq = iNextInt3;
        this.zzr = listZza;
        this.zzs = zzfkkVar;
        this.zzt = listZzb4;
        this.zzu = listZza2;
        this.zzw = strNextString2;
        this.zzv = jSONObjectZzd6;
        this.zzx = strNextString3;
        this.zzy = strNextString4;
        this.zzz = string;
        this.zzA = zzcdkVarZza;
        this.zzB = strNextString5;
        this.zzC = jSONObjectZzd;
        this.zzD = jSONObjectZzd2;
        this.zzJ = zNextBoolean2;
        this.zzK = zNextBoolean3;
        this.zzL = zNextBoolean4;
        this.zzM = zNextBoolean5;
        this.zzN = zNextBoolean6;
        this.zzO = zNextBoolean7;
        this.zzP = zNextBoolean8;
        this.zzQ = iZze;
        this.zzR = iNextInt4;
        this.zzT = zNextBoolean9;
        this.zzU = strNextString6;
        this.zzV = new zzflb(jSONObjectZzd3);
        this.zzW = zNextBoolean10;
        this.zzX = zNextBoolean11;
        this.zzY = iNextInt5;
        this.zzZ = strNextString7;
        this.zzaa = iNextInt;
        this.zzab = strNextString8;
        this.zzac = zNextBoolean12;
        this.zzad = zzbzhVarZza;
        this.zzae = zztVarZza;
        this.zzaf = strNextString9;
        this.zzag = zNextBoolean13;
        this.zzah = jSONObjectZzd4;
        this.zzE = strNextString10;
        this.zzF = strNextString11;
        this.zzG = strNextString12;
        this.zzH = strNextString13;
        this.zzI = strNextString14;
        this.zzai = zNextBoolean14;
        this.zzaj = jSONObjectZzd5;
        this.zzak = zNextBoolean15;
        this.zzal = strNextString;
        this.zzam = zNextBoolean16;
        this.zzS = zNextBoolean17;
        this.zzan = strNextString15;
        this.zzao = strNextString16;
        this.zzap = strNextString17;
        this.zzaq = zNextBoolean18;
        this.zzar = zNextBoolean19;
        this.zzas = iNextInt6;
        this.zzau = listZzb;
        this.zzat = strNextString18;
        this.zzav = zNextBoolean20;
        this.zzaw = mapZzc;
        this.zzax = zzvVarZzb;
        this.zzay = zzwVarZzd;
        this.zzaz = dNextDouble;
        this.zzaI = iZza;
        this.zzaA = listZzb2;
        this.zzaB = zNextBoolean21;
        this.zzaC = zzgwmVarZza;
        this.zzaD = zNextBoolean22;
        this.zzaE = iNextInt2;
        this.zzaF = bundle2;
        this.zzaG = zNextBoolean;
        this.zzaH = jSONArrayZze;
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzc(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzd(int i) {
        if (i == 0 || i == 1 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    private static int zze(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }

    public final boolean zzb() {
        return this.zzai || this.zzay != null;
    }
}
