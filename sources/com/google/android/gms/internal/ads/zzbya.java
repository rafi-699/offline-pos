package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbya extends zzbyg {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcku zzj;
    private final Activity zzk;
    private zzcne zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbyh zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbya(zzcku zzckuVar, zzbyh zzbyhVar) {
        super(zzckuVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzckuVar;
        this.zzk = zzckuVar.zzj();
        this.zzo = zzbyhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzf(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzml)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmm)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmn)).booleanValue()) {
                try {
                    ViewGroup viewGroup2 = this.zzr;
                    zzcku zzckuVar = this.zzj;
                    viewGroup2.addView((View) zzckuVar);
                    zzckuVar.zzaf(this.zzl);
                } catch (IllegalStateException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to add webview back to view hierarchy.", e);
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "MraidCallResizeHandler.collapseInternal");
                }
            } else {
                ViewGroup viewGroup3 = this.zzr;
                zzcku zzckuVar2 = this.zzj;
                viewGroup3.addView((View) zzckuVar2);
                zzckuVar2.zzaf(this.zzl);
            }
        }
        if (z) {
            zzk(Constants.COLLATION_DEFAULT);
            zzbyh zzbyhVar = this.zzo;
            if (zzbyhVar != null) {
                zzbyhVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:122:0x0240 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0247 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0264 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0270 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x02a4 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0311  */
    /* JADX WARN: Code duplicated, block: B:137:0x0319 A[Catch: all -> 0x0435, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0320  */
    /* JADX WARN: Code duplicated, block: B:141:0x0328 A[Catch: all -> 0x0435, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x032f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0337 A[Catch: all -> 0x0435, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x033e  */
    /* JADX WARN: Code duplicated, block: B:149:0x0346 A[Catch: all -> 0x0435, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x034d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0355 A[Catch: all -> 0x0435, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x035c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0364  */
    /* JADX WARN: Code duplicated, block: B:159:0x036a A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x03ad A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0420 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01c8 A[Catch: all -> 0x0435, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:9:0x0014, B:11:0x001c, B:12:0x0021, B:14:0x0023, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x003f, B:24:0x0041, B:26:0x004f, B:27:0x0060, B:29:0x006e, B:30:0x007f, B:32:0x008d, B:33:0x009e, B:35:0x00ac, B:36:0x00bd, B:38:0x00cb, B:39:0x00d9, B:41:0x00e7, B:42:0x00e9, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:51:0x00ff, B:55:0x011d, B:61:0x0129, B:122:0x0240, B:123:0x0245, B:125:0x0247, B:127:0x0264, B:129:0x0270, B:131:0x02a7, B:137:0x0319, B:160:0x0370, B:161:0x0388, B:162:0x03a5, B:164:0x03ad, B:165:0x03b4, B:166:0x03db, B:169:0x03de, B:171:0x040c, B:172:0x041e, B:141:0x0328, B:145:0x0337, B:149:0x0346, B:153:0x0355, B:158:0x0366, B:159:0x036a, B:130:0x02a4, B:174:0x0420, B:175:0x0425, B:62:0x0132, B:64:0x0136, B:69:0x0149, B:96:0x01d5, B:98:0x01d8, B:100:0x01dc, B:73:0x0161, B:78:0x017f, B:77:0x0175, B:82:0x018a, B:87:0x019f, B:88:0x01a7, B:92:0x01b3, B:94:0x01c8, B:104:0x01e4, B:105:0x01f3, B:111:0x0219, B:117:0x0229, B:114:0x021f, B:116:0x0227, B:108:0x0211, B:110:0x0217, B:118:0x022e, B:119:0x0236, B:177:0x0427, B:178:0x042c, B:180:0x042e, B:181:0x0433), top: B:186:0x0009, inners: #1 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(Map map) {
        int[] iArr;
        int iZzE;
        int iZzE2;
        ViewParent parent;
        ViewGroup viewGroup;
        PopupWindow popupWindow;
        RelativeLayout.LayoutParams layoutParams;
        String str;
        int i;
        int i2;
        zzbyh zzbyhVar;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        synchronized (this.zzi) {
            Activity activity = this.zzk;
            if (activity == null) {
                zzg("Not an activity context. Cannot resize.");
                return;
            }
            zzcku zzckuVar = this.zzj;
            if (zzckuVar.zzN() == null) {
                zzg("Webview is not yet available, size is not set.");
                return;
            }
            if (zzckuVar.zzN().zzg()) {
                zzg("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (zzckuVar.zzW()) {
                zzg("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzh = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("width"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zze = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("height"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzf = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("offsetX"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzg = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("offsetY"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                this.zzb = Boolean.parseBoolean((String) map.get("allowOffscreen"));
            }
            String str2 = (String) map.get("customClosePosition");
            if (!TextUtils.isEmpty(str2)) {
                this.zza = str2;
            }
            if (this.zzh < 0 || this.zze < 0) {
                zzg("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null) {
                com.google.android.gms.ads.internal.zzt.zzc();
                int[] iArrZzaa = com.google.android.gms.ads.internal.util.zzs.zzaa(activity);
                com.google.android.gms.ads.internal.zzt.zzc();
                int[] iArrZzW = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                int i9 = iArrZzaa[0];
                int i10 = iArrZzaa[1];
                int i11 = this.zzh;
                if (i11 < 50 || i11 > i9) {
                    int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Width is too small or too large.");
                } else {
                    int i13 = this.zze;
                    if (i13 < 50 || i13 > i10) {
                        int i14 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Height is too small or too large.");
                    } else {
                        if (i13 != i10 || i11 != i9) {
                            boolean z = this.zzb;
                            if (z) {
                                String str3 = this.zza;
                                switch (str3) {
                                    case "center":
                                        i5 = ((this.zzc + this.zzf) + (i11 >> 1)) - 25;
                                        i6 = ((this.zzd + this.zzg) + (i13 >> 1)) - 25;
                                        i3 = i5;
                                        i7 = i6;
                                        break;
                                    case "top-left":
                                        i3 = this.zzc + this.zzf;
                                        i4 = this.zzd;
                                    case "bottom-left":
                                        i5 = this.zzc + this.zzf;
                                        i8 = this.zzd;
                                        i6 = ((i8 + this.zzg) + i13) - 50;
                                        i3 = i5;
                                        i7 = i6;
                                        break;
                                    case "bottom-right":
                                        i5 = ((this.zzc + this.zzf) + i11) - 50;
                                        i8 = this.zzd;
                                        i6 = ((i8 + this.zzg) + i13) - 50;
                                        i3 = i5;
                                        i7 = i6;
                                        break;
                                    case "bottom-center":
                                        i5 = ((this.zzc + this.zzf) + (i11 >> 1)) - 25;
                                        i8 = this.zzd;
                                        i6 = ((i8 + this.zzg) + i13) - 50;
                                        i3 = i5;
                                        i7 = i6;
                                        break;
                                    case "top-center":
                                        i3 = ((this.zzc + this.zzf) + (i11 >> 1)) - 25;
                                        i7 = this.zzd + this.zzg;
                                        break;
                                    default:
                                        if (str3.equals(TtmlNode.CENTER)) {
                                            i5 = ((this.zzc + this.zzf) + (i11 >> 1)) - 25;
                                            i6 = ((this.zzd + this.zzg) + (i13 >> 1)) - 25;
                                            i3 = i5;
                                            i7 = i6;
                                            break;
                                        }
                                        i3 = ((this.zzc + this.zzf) + i11) - 50;
                                        i4 = this.zzd;
                                        i7 = i4 + this.zzg;
                                        break;
                                }
                                if (i3 < 0 || i3 + 50 > i9 || i7 < iArrZzW[0] || i7 + 50 > iArrZzW[1]) {
                                }
                                if (iArr == null) {
                                    zzg("Resize location out of screen or close button is not visible.");
                                    return;
                                }
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                iZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zzh);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                iZzE2 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zze);
                                parent = ((View) zzckuVar).getParent();
                                if (!(parent instanceof ViewGroup)) {
                                    zzg("Webview is detached, probably in the middle of a resize or expand.");
                                    return;
                                }
                                viewGroup = (ViewGroup) parent;
                                viewGroup.removeView((View) zzckuVar);
                                popupWindow = this.zzp;
                                if (popupWindow == null) {
                                    this.zzr = viewGroup;
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    ((View) zzckuVar).setDrawingCacheEnabled(true);
                                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) zzckuVar).getDrawingCache());
                                    ((View) zzckuVar).setDrawingCacheEnabled(false);
                                    ImageView imageView = new ImageView(activity);
                                    this.zzm = imageView;
                                    imageView.setImageBitmap(bitmapCreateBitmap);
                                    this.zzl = zzckuVar.zzN();
                                    this.zzr.addView(this.zzm);
                                } else {
                                    popupWindow.dismiss();
                                }
                                RelativeLayout relativeLayout = new RelativeLayout(activity);
                                this.zzq = relativeLayout;
                                relativeLayout.setBackgroundColor(0);
                                this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzE, iZzE2));
                                com.google.android.gms.ads.internal.zzt.zzc();
                                PopupWindow popupWindow2 = new PopupWindow((View) this.zzq, iZzE, iZzE2, false);
                                this.zzp = popupWindow2;
                                popupWindow2.setOutsideTouchable(false);
                                this.zzp.setTouchable(true);
                                this.zzp.setClippingEnabled(!this.zzb);
                                this.zzq.addView((View) zzckuVar, -1, -1);
                                this.zzn = new LinearLayout(activity);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                int iZzE3 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                layoutParams = new RelativeLayout.LayoutParams(iZzE3, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50));
                                str = this.zza;
                                switch (str.hashCode()) {
                                    case -1364013995:
                                        if (!str.equals(TtmlNode.CENTER)) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(13);
                                        }
                                        break;
                                    case -1012429441:
                                        if (!str.equals("top-left")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(9);
                                        }
                                        break;
                                    case -655373719:
                                        if (!str.equals("bottom-left")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(9);
                                        }
                                        break;
                                    case 1163912186:
                                        if (!str.equals("bottom-right")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(11);
                                        }
                                        break;
                                    case 1288627767:
                                        if (!str.equals("bottom-center")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(14);
                                        }
                                        break;
                                    case 1755462605:
                                        if (!str.equals("top-center")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(14);
                                        }
                                        break;
                                    default:
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                        break;
                                }
                                this.zzn.setOnClickListener(new zzbxy(this));
                                this.zzn.setContentDescription("Close button");
                                this.zzq.addView(this.zzn, layoutParams);
                                try {
                                    PopupWindow popupWindow3 = this.zzp;
                                    View decorView = window.getDecorView();
                                    com.google.android.gms.ads.internal.client.zzay.zza();
                                    int iZzE4 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[0]);
                                    com.google.android.gms.ads.internal.client.zzay.zza();
                                    popupWindow3.showAtLocation(decorView, 0, iZzE4, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[1]));
                                    i = iArr[0];
                                    i2 = iArr[1];
                                    zzbyhVar = this.zzo;
                                    if (zzbyhVar != null) {
                                        zzbyhVar.zza(i, i2, this.zzh, this.zze);
                                    }
                                    this.zzj.zzaf(zzcne.zzc(iZzE, iZzE2));
                                    int i15 = iArr[0];
                                    int i16 = iArr[1];
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    zzi(i15, i16 - com.google.android.gms.ads.internal.util.zzs.zzW(this.zzk)[0], this.zzh, this.zze);
                                    zzk("resized");
                                    return;
                                } catch (RuntimeException e) {
                                    String message = e.getMessage();
                                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 26);
                                    sb.append("Cannot show popup window: ");
                                    sb.append(message);
                                    zzg(sb.toString());
                                    RelativeLayout relativeLayout2 = this.zzq;
                                    zzcku zzckuVar2 = this.zzj;
                                    relativeLayout2.removeView((View) zzckuVar2);
                                    ViewGroup viewGroup2 = this.zzr;
                                    if (viewGroup2 != null) {
                                        viewGroup2.removeView(this.zzm);
                                        this.zzr.addView((View) zzckuVar2);
                                        zzckuVar2.zzaf(this.zzl);
                                    }
                                    return;
                                }
                            }
                            if (z) {
                                iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                            } else {
                                com.google.android.gms.ads.internal.zzt.zzc();
                                int[] iArrZzaa2 = com.google.android.gms.ads.internal.util.zzs.zzaa(activity);
                                com.google.android.gms.ads.internal.zzt.zzc();
                                int[] iArrZzW2 = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                                int i17 = iArrZzaa2[0];
                                int i18 = this.zzc + this.zzf;
                                int i19 = this.zzd + this.zzg;
                                if (i18 < 0) {
                                    i18 = 0;
                                } else {
                                    int i20 = this.zzh;
                                    if (i18 + i20 > i17) {
                                        i18 = i17 - i20;
                                    }
                                }
                                int i21 = iArrZzW2[0];
                                if (i19 < i21) {
                                    i19 = i21;
                                } else {
                                    int i22 = this.zze;
                                    int i23 = i19 + i22;
                                    int i24 = iArrZzW2[1];
                                    if (i23 > i24) {
                                        i19 = i24 - i22;
                                    }
                                }
                                iArr = new int[]{i18, i19};
                            }
                            if (iArr == null) {
                                zzg("Resize location out of screen or close button is not visible.");
                                return;
                            }
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            iZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zzh);
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            iZzE2 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zze);
                            parent = ((View) zzckuVar).getParent();
                            if (!(parent instanceof ViewGroup)) {
                                zzg("Webview is detached, probably in the middle of a resize or expand.");
                                return;
                            }
                            viewGroup = (ViewGroup) parent;
                            viewGroup.removeView((View) zzckuVar);
                            popupWindow = this.zzp;
                            if (popupWindow == null) {
                                this.zzr = viewGroup;
                                com.google.android.gms.ads.internal.zzt.zzc();
                                ((View) zzckuVar).setDrawingCacheEnabled(true);
                                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(((View) zzckuVar).getDrawingCache());
                                ((View) zzckuVar).setDrawingCacheEnabled(false);
                                ImageView imageView2 = new ImageView(activity);
                                this.zzm = imageView2;
                                imageView2.setImageBitmap(bitmapCreateBitmap2);
                                this.zzl = zzckuVar.zzN();
                                this.zzr.addView(this.zzm);
                            } else {
                                popupWindow.dismiss();
                            }
                            RelativeLayout relativeLayout3 = new RelativeLayout(activity);
                            this.zzq = relativeLayout3;
                            relativeLayout3.setBackgroundColor(0);
                            this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzE, iZzE2));
                            com.google.android.gms.ads.internal.zzt.zzc();
                            PopupWindow popupWindow4 = new PopupWindow((View) this.zzq, iZzE, iZzE2, false);
                            this.zzp = popupWindow4;
                            popupWindow4.setOutsideTouchable(false);
                            this.zzp.setTouchable(true);
                            this.zzp.setClippingEnabled(!this.zzb);
                            this.zzq.addView((View) zzckuVar, -1, -1);
                            this.zzn = new LinearLayout(activity);
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            int iZzE5 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50);
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            layoutParams = new RelativeLayout.LayoutParams(iZzE5, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50));
                            str = this.zza;
                            switch (str.hashCode()) {
                                case -1364013995:
                                    if (!str.equals(TtmlNode.CENTER)) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(13);
                                    }
                                    break;
                                case -1012429441:
                                    if (!str.equals("top-left")) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(9);
                                    }
                                    break;
                                case -655373719:
                                    if (!str.equals("bottom-left")) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(9);
                                    }
                                    break;
                                case 1163912186:
                                    if (!str.equals("bottom-right")) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(11);
                                    }
                                    break;
                                case 1288627767:
                                    if (!str.equals("bottom-center")) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(14);
                                    }
                                    break;
                                case 1755462605:
                                    if (!str.equals("top-center")) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(14);
                                    }
                                    break;
                                default:
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(11);
                                    break;
                            }
                            this.zzn.setOnClickListener(new zzbxy(this));
                            this.zzn.setContentDescription("Close button");
                            this.zzq.addView(this.zzn, layoutParams);
                            PopupWindow popupWindow5 = this.zzp;
                            View decorView2 = window.getDecorView();
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            int iZzE6 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[0]);
                            com.google.android.gms.ads.internal.client.zzay.zza();
                            popupWindow5.showAtLocation(decorView2, 0, iZzE6, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[1]));
                            i = iArr[0];
                            i2 = iArr[1];
                            zzbyhVar = this.zzo;
                            if (zzbyhVar != null) {
                                zzbyhVar.zza(i, i2, this.zzh, this.zze);
                            }
                            this.zzj.zzaf(zzcne.zzc(iZzE, iZzE2));
                            int i110 = iArr[0];
                            int i111 = iArr[1];
                            com.google.android.gms.ads.internal.zzt.zzc();
                            zzi(i110, i111 - com.google.android.gms.ads.internal.util.zzs.zzW(this.zzk)[0], this.zzh, this.zze);
                            zzk("resized");
                            return;
                        }
                        int i25 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot resize to a full-screen ad.");
                    }
                }
                iArr = null;
                if (iArr == null) {
                    zzg("Resize location out of screen or close button is not visible.");
                    return;
                }
                com.google.android.gms.ads.internal.client.zzay.zza();
                iZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zzh);
                com.google.android.gms.ads.internal.client.zzay.zza();
                iZzE2 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zze);
                parent = ((View) zzckuVar).getParent();
                if (!(parent instanceof ViewGroup)) {
                    zzg("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                viewGroup = (ViewGroup) parent;
                viewGroup.removeView((View) zzckuVar);
                popupWindow = this.zzp;
                if (popupWindow == null) {
                    this.zzr = viewGroup;
                    com.google.android.gms.ads.internal.zzt.zzc();
                    ((View) zzckuVar).setDrawingCacheEnabled(true);
                    Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(((View) zzckuVar).getDrawingCache());
                    ((View) zzckuVar).setDrawingCacheEnabled(false);
                    ImageView imageView3 = new ImageView(activity);
                    this.zzm = imageView3;
                    imageView3.setImageBitmap(bitmapCreateBitmap3);
                    this.zzl = zzckuVar.zzN();
                    this.zzr.addView(this.zzm);
                } else {
                    popupWindow.dismiss();
                }
                RelativeLayout relativeLayout4 = new RelativeLayout(activity);
                this.zzq = relativeLayout4;
                relativeLayout4.setBackgroundColor(0);
                this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzE, iZzE2));
                com.google.android.gms.ads.internal.zzt.zzc();
                PopupWindow popupWindow6 = new PopupWindow((View) this.zzq, iZzE, iZzE2, false);
                this.zzp = popupWindow6;
                popupWindow6.setOutsideTouchable(false);
                this.zzp.setTouchable(true);
                this.zzp.setClippingEnabled(!this.zzb);
                this.zzq.addView((View) zzckuVar, -1, -1);
                this.zzn = new LinearLayout(activity);
                com.google.android.gms.ads.internal.client.zzay.zza();
                int iZzE7 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50);
                com.google.android.gms.ads.internal.client.zzay.zza();
                layoutParams = new RelativeLayout.LayoutParams(iZzE7, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, 50));
                str = this.zza;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (!str.equals(TtmlNode.CENTER)) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(13);
                        }
                        break;
                    case -1012429441:
                        if (!str.equals("top-left")) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                        }
                        break;
                    case -655373719:
                        if (!str.equals("bottom-left")) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(12);
                            layoutParams.addRule(9);
                        }
                        break;
                    case 1163912186:
                        if (!str.equals("bottom-right")) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(12);
                            layoutParams.addRule(11);
                        }
                        break;
                    case 1288627767:
                        if (!str.equals("bottom-center")) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(12);
                            layoutParams.addRule(14);
                        }
                        break;
                    case 1755462605:
                        if (!str.equals("top-center")) {
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                        } else {
                            layoutParams.addRule(10);
                            layoutParams.addRule(14);
                        }
                        break;
                    default:
                        layoutParams.addRule(10);
                        layoutParams.addRule(11);
                        break;
                }
                this.zzn.setOnClickListener(new zzbxy(this));
                this.zzn.setContentDescription("Close button");
                this.zzq.addView(this.zzn, layoutParams);
                PopupWindow popupWindow7 = this.zzp;
                View decorView3 = window.getDecorView();
                com.google.android.gms.ads.internal.client.zzay.zza();
                int iZzE8 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[0]);
                com.google.android.gms.ads.internal.client.zzay.zza();
                popupWindow7.showAtLocation(decorView3, 0, iZzE8, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[1]));
                i = iArr[0];
                i2 = iArr[1];
                zzbyhVar = this.zzo;
                if (zzbyhVar != null) {
                    zzbyhVar.zza(i, i2, this.zzh, this.zze);
                }
                this.zzj.zzaf(zzcne.zzc(iZzE, iZzE2));
                int i112 = iArr[0];
                int i113 = iArr[1];
                com.google.android.gms.ads.internal.zzt.zzc();
                zzi(i112, i113 - com.google.android.gms.ads.internal.util.zzs.zzW(this.zzk)[0], this.zzh, this.zze);
                zzk("resized");
                return;
            }
            zzg("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final void zzb(final boolean z) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmk)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzf(z);
                } else {
                    zzcfr.zzf.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzf(z);
                        }
                    });
                }
            }
        }
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }
}
