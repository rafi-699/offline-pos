package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxf extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcxf(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcxf zza(Context context, View view, zzfkf zzfkfVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcxf zzcxfVar = new zzcxf(context);
        List list = zzfkfVar.zzu;
        if (!list.isEmpty() && (resources = zzcxfVar.zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            zzfkg zzfkgVar = (zzfkg) list.get(0);
            zzcxfVar.setLayoutParams(new FrameLayout.LayoutParams((int) (zzfkgVar.zza * displayMetrics.density), (int) (zzfkgVar.zzb * displayMetrics.density)));
        }
        zzcxfVar.zzb = view;
        zzcxfVar.addView(view);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcge.zzb(zzcxfVar, zzcxfVar);
        com.google.android.gms.ads.internal.zzt.zzC();
        zzcge.zza(zzcxfVar, zzcxfVar);
        JSONObject jSONObject = zzfkfVar.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcxfVar.zza);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("header");
        if (jSONObjectOptJSONObject != null) {
            zzcxfVar.zzb(jSONObjectOptJSONObject, relativeLayout, 10);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("footer");
        if (jSONObjectOptJSONObject2 != null) {
            zzcxfVar.zzb(jSONObjectOptJSONObject2, relativeLayout, 12);
        }
        zzcxfVar.addView(relativeLayout);
        return zzcxfVar;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int iZzc = zzc(jSONObject.optDouble(ViewProps.PADDING, ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE));
        textView.setPadding(0, iZzc, 0, iZzc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzc(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzc(double d) {
        com.google.android.gms.ads.internal.client.zzay.zza();
        return com.google.android.gms.ads.internal.util.client.zzf.zzE(this.zza, (int) d);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY(-iArr[1]);
    }
}
