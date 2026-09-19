package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyv {
    public static final zzgwm zza;
    public static final zzgwm zzb;
    private final String zzc;
    private final zzdyu zzd;
    private final zzdyu zze;

    static {
        zzdyu zzdyuVar = zzdyu.PUBLIC_API_CALL;
        zzdyu zzdyuVar2 = zzdyu.PUBLIC_API_CALLBACK;
        zzdyv zzdyvVar = new zzdyv("tqgt", zzdyuVar, zzdyuVar2);
        zzdyu zzdyuVar3 = zzdyu.DYNAMITE_ENTER;
        zzdyv zzdyvVar2 = new zzdyv("l.dl", zzdyuVar, zzdyuVar3);
        zzdyu zzdyuVar4 = zzdyu.READ_FROM_DISK_START;
        zzdyv zzdyvVar3 = new zzdyv("l.rccde", zzdyuVar3, zzdyuVar4);
        zzdyv zzdyvVar4 = new zzdyv("l.rfd", zzdyuVar4, zzdyu.READ_FROM_DISK_END);
        zzdyu zzdyuVar5 = zzdyu.CLIENT_SIGNALS_START;
        zzdyv zzdyvVar5 = new zzdyv("l.rcc", zzdyuVar3, zzdyuVar5);
        zzdyu zzdyuVar6 = zzdyu.CLIENT_SIGNALS_END;
        zzdyv zzdyvVar6 = new zzdyv("l.cs", zzdyuVar5, zzdyuVar6);
        zzdyv zzdyvVar7 = new zzdyv("l.cts", zzdyuVar6, zzdyu.SERVICE_CONNECTED);
        zzdyu zzdyuVar7 = zzdyu.GMS_SIGNALS_START;
        zzdyu zzdyuVar8 = zzdyu.GMS_SIGNALS_END;
        zzdyv zzdyvVar8 = new zzdyv("l.gs", zzdyuVar7, zzdyuVar8);
        zzdyu zzdyuVar9 = zzdyu.GET_SIGNALS_SDKCORE_START;
        zzdyv zzdyvVar9 = new zzdyv("l.jse", zzdyuVar8, zzdyuVar9);
        zzdyu zzdyuVar10 = zzdyu.GET_SIGNALS_SDKCORE_END;
        zzdyv zzdyvVar10 = new zzdyv("l.gs-sdkcore", zzdyuVar9, zzdyuVar10);
        zzdyv zzdyvVar11 = new zzdyv("l.gs-pp", zzdyuVar10, zzdyuVar2);
        zzdyu zzdyuVar11 = zzdyu.RENDERING_START;
        zzdyv zzdyvVar12 = new zzdyv("l.render", zzdyuVar11, zzdyuVar2);
        zzdyu zzdyuVar12 = zzdyu.RENDERING_WEBVIEW_CREATION_START;
        zzdyv zzdyvVar13 = new zzdyv("l.render.pre", zzdyuVar11, zzdyuVar12);
        zzdyu zzdyuVar13 = zzdyu.RENDERING_WEBVIEW_CREATION_END;
        zzdyv zzdyvVar14 = new zzdyv("l.render.wvc", zzdyuVar12, zzdyuVar13);
        zzdyv zzdyvVar15 = new zzdyv("l.render.acc", zzdyuVar13, zzdyu.RENDERING_AD_COMPONENT_CREATION_END);
        zzdyv zzdyvVar16 = new zzdyv("l.render.cfg-wv", zzdyu.RENDERING_CONFIGURE_WEBVIEW_START, zzdyu.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdyu zzdyuVar14 = zzdyu.RENDERING_WEBVIEW_LOAD_HTML_START;
        zzdyu zzdyuVar15 = zzdyu.RENDERING_WEBVIEW_LOAD_HTML_END;
        zza = zzgwm.zzo(zzdyvVar, zzdyvVar2, zzdyvVar3, zzdyvVar4, zzdyvVar5, zzdyvVar6, zzdyvVar7, zzdyvVar8, zzdyvVar9, zzdyvVar10, zzdyvVar11, zzdyvVar12, zzdyvVar13, zzdyvVar14, zzdyvVar15, zzdyvVar16, new zzdyv("l.render.wvlh", zzdyuVar14, zzdyuVar15), new zzdyv("l.render.post", zzdyuVar15, zzdyuVar2), new zzdyv("l.sodv", zzdyu.SIGNAL_ON_DISK_VALIDATION_START, zzdyu.SIGNAL_ON_DISK_VALIDATION_END), new zzdyv("l.sodck", zzdyu.SIGNAL_ON_DISK_CACHE_KEY_START, zzdyu.SIGNAL_ON_DISK_CACHE_KEY_END), new zzdyv("l.sodrar", zzdyu.SIGNAL_ON_DISK_READ_AND_REMOVE_START, zzdyu.SIGNAL_ON_DISK_READ_AND_REMOVE_END), new zzdyv("l.soddc", zzdyu.SIGNAL_ON_DISK_DECODE_START, zzdyu.SIGNAL_ON_DISK_DECODE_END));
        zzdyu zzdyuVar16 = zzdyu.PUBLIC_API_CALL;
        zzdyu zzdyuVar17 = zzdyu.PUBLIC_API_CALLBACK;
        zzdyv zzdyvVar17 = new zzdyv("l.al", zzdyuVar16, zzdyuVar17);
        zzdyu zzdyuVar18 = zzdyu.DYNAMITE_ENTER;
        zzdyv zzdyvVar18 = new zzdyv("l.al2", zzdyuVar18, zzdyuVar17);
        zzdyv zzdyvVar19 = new zzdyv("l.dl", zzdyuVar16, zzdyuVar18);
        zzdyu zzdyuVar19 = zzdyu.CLIENT_SIGNALS_START;
        zzdyv zzdyvVar20 = new zzdyv("l.rcc", zzdyuVar18, zzdyuVar19);
        zzdyu zzdyuVar20 = zzdyu.CLIENT_SIGNALS_END;
        zzdyv zzdyvVar21 = new zzdyv("l.cs", zzdyuVar19, zzdyuVar20);
        zzdyv zzdyvVar22 = new zzdyv("l.cts", zzdyuVar20, zzdyu.SERVICE_CONNECTED);
        zzdyu zzdyuVar21 = zzdyu.GMS_SIGNALS_START;
        zzdyu zzdyuVar22 = zzdyu.GMS_SIGNALS_END;
        zzdyv zzdyvVar23 = new zzdyv("l.gs", zzdyuVar21, zzdyuVar22);
        zzdyu zzdyuVar23 = zzdyu.GET_AD_DICTIONARY_SDKCORE_START;
        zzdyv zzdyvVar24 = new zzdyv("l.jse", zzdyuVar22, zzdyuVar23);
        zzdyu zzdyuVar24 = zzdyu.GET_AD_DICTIONARY_SDKCORE_END;
        zzdyv zzdyvVar25 = new zzdyv("l.gad-js", zzdyuVar23, zzdyuVar24);
        zzdyu zzdyuVar25 = zzdyu.HTTP_RESPONSE_READY;
        zzdyv zzdyvVar26 = new zzdyv("l.http", zzdyuVar24, zzdyuVar25);
        zzdyu zzdyuVar26 = zzdyu.SCAR_PRELOADER_READY;
        zzdyv zzdyvVar27 = new zzdyv("l.slas.pre", zzdyuVar16, zzdyuVar26);
        zzdyu zzdyuVar27 = zzdyu.SCAR_PRELOADER_PROCESSING_DONE;
        zzdyv zzdyvVar28 = new zzdyv("l.slas.prel.p", zzdyuVar26, zzdyuVar27);
        zzdyu zzdyuVar28 = zzdyu.NORMALIZATION_AD_RESPONSE_START;
        zzdyv zzdyvVar29 = new zzdyv("l.jse-nml", zzdyuVar25, zzdyuVar28);
        zzdyv zzdyvVar30 = new zzdyv("l.jse-nml", zzdyuVar27, zzdyuVar28);
        zzdyu zzdyuVar29 = zzdyu.NORMALIZATION_AD_RESPONSE_END;
        zzdyv zzdyvVar31 = new zzdyv("l.nml-js", zzdyuVar28, zzdyuVar29);
        zzdyu zzdyuVar30 = zzdyu.BINDER_CALL_START;
        zzdyv zzdyvVar32 = new zzdyv("l.nml-gmsg", zzdyuVar29, zzdyuVar30);
        zzdyu zzdyuVar31 = zzdyu.SERVER_RESPONSE_PARSE_START;
        zzdyv zzdyvVar33 = new zzdyv("l.nml-gmsg.s2s", zzdyuVar29, zzdyuVar31);
        zzdyv zzdyvVar34 = new zzdyv("l.binder", zzdyuVar30, zzdyuVar31);
        zzdyu zzdyuVar32 = zzdyu.RENDERING_START;
        zzdyv zzdyvVar35 = new zzdyv("l.sr", zzdyuVar31, zzdyuVar32);
        zzdyv zzdyvVar36 = new zzdyv("l.render", zzdyuVar32, zzdyuVar17);
        zzdyv zzdyvVar37 = new zzdyv("l.t2", zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_START, zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_END);
        zzdyu zzdyuVar33 = zzdyu.RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START;
        zzdyu zzdyuVar34 = zzdyu.RENDERING_NATIVE_ADS_PREPROCESS_START;
        zzdyv zzdyvVar38 = new zzdyv("l.render.na.js", zzdyuVar33, zzdyuVar34);
        zzdyv zzdyvVar39 = new zzdyv("l.render.na.prep", zzdyuVar34, zzdyu.RENDERING_NATIVE_ADS_PREPROCESS_END);
        zzdyv zzdyvVar40 = new zzdyv("l.render.na.lna", zzdyu.RENDERING_NATIVE_ASSETS_LOADING_START, zzdyu.RENDERING_NATIVE_ASSETS_LOADING_END);
        zzdyu zzdyuVar35 = zzdyu.RENDERING_WEBVIEW_CREATION_START;
        zzdyu zzdyuVar36 = zzdyu.RENDERING_WEBVIEW_CREATION_END;
        zzdyv zzdyvVar41 = new zzdyv("l.render.wvc", zzdyuVar35, zzdyuVar36);
        zzdyv zzdyvVar42 = new zzdyv("l.render.acc", zzdyuVar36, zzdyu.RENDERING_AD_COMPONENT_CREATION_END);
        zzdyu zzdyuVar37 = zzdyu.RENDERING_CONFIGURE_WEBVIEW_START;
        zzdyu zzdyuVar38 = zzdyu.RENDERING_CONFIGURE_WEBVIEW_END;
        zzdyv zzdyvVar43 = new zzdyv("l.render.cfg-wv", zzdyuVar37, zzdyuVar38);
        zzdyv zzdyvVar44 = new zzdyv("l.render.pre", zzdyuVar32, zzdyuVar35);
        zzdyu zzdyuVar39 = zzdyu.RENDERING_WEBVIEW_LOAD_HTML_END;
        zzdyv zzdyvVar45 = new zzdyv("l.render.post", zzdyuVar39, zzdyuVar17);
        zzdyv zzdyvVar46 = new zzdyv("l.render.na.post", zzdyuVar38, zzdyuVar17);
        zzdyv zzdyvVar47 = new zzdyv("l.render.wvlh", zzdyu.RENDERING_WEBVIEW_LOAD_HTML_START, zzdyuVar39);
        zzdyv zzdyvVar48 = new zzdyv("l.na.b", zzdyu.NATIVE_ASSETS_LOADING_BASIC_START, zzdyu.NATIVE_ASSETS_LOADING_BASIC_END);
        zzdyv zzdyvVar49 = new zzdyv("l.na.im", zzdyu.NATIVE_ASSETS_LOADING_IMAGE_START, zzdyu.NATIVE_ASSETS_LOADING_IMAGE_END);
        zzdyv zzdyvVar50 = new zzdyv("l.na.imc", zzdyu.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START, zzdyu.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END);
        zzdyv zzdyvVar51 = new zzdyv("l.na.l", zzdyu.NATIVE_ASSETS_LOADING_LOGO_START, zzdyu.NATIVE_ASSETS_LOADING_LOGO_END);
        zzdyv zzdyvVar52 = new zzdyv("l.na.ic", zzdyu.NATIVE_ASSETS_LOADING_ICON_START, zzdyu.NATIVE_ASSETS_LOADING_ICON_END);
        zzdyv zzdyvVar53 = new zzdyv("l.na.a", zzdyu.NATIVE_ASSETS_LOADING_ATTRIBUTION_START, zzdyu.NATIVE_ASSETS_LOADING_ATTRIBUTION_END);
        zzdyu zzdyuVar40 = zzdyu.NATIVE_ASSETS_LOADING_VIDEO_START;
        zzdyu zzdyuVar41 = zzdyu.NATIVE_ASSETS_LOADING_VIDEO_END;
        zzb = zzgwm.zzo(zzdyvVar17, zzdyvVar18, zzdyvVar19, zzdyvVar20, zzdyvVar21, zzdyvVar22, zzdyvVar23, zzdyvVar24, zzdyvVar25, zzdyvVar26, zzdyvVar27, zzdyvVar28, zzdyvVar29, zzdyvVar30, zzdyvVar31, zzdyvVar32, zzdyvVar33, zzdyvVar34, zzdyvVar35, zzdyvVar36, zzdyvVar37, zzdyvVar38, zzdyvVar39, zzdyvVar40, zzdyvVar41, zzdyvVar42, zzdyvVar43, zzdyvVar44, zzdyvVar45, zzdyvVar46, zzdyvVar47, zzdyvVar48, zzdyvVar49, zzdyvVar50, zzdyvVar51, zzdyvVar52, zzdyvVar53, new zzdyv("l.na.v", zzdyuVar40, zzdyuVar41), new zzdyv("l.na.vc", zzdyu.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START, zzdyuVar41), new zzdyv("l.na.m", zzdyu.NATIVE_ASSETS_LOADING_MEDIA_START, zzdyu.NATIVE_ASSETS_LOADING_MEDIA_END), new zzdyv("l.na.c", zzdyu.NATIVE_ASSETS_LOADING_CUSTOM_START, zzdyu.NATIVE_ASSETS_LOADING_CUSTOM_END), new zzdyv("l.na.o", zzdyu.NATIVE_ASSETS_LOADING_OMID_START, zzdyu.NATIVE_ASSETS_LOADING_OMID_END));
    }

    public zzdyv(String str, zzdyu zzdyuVar, zzdyu zzdyuVar2) {
        this.zzc = str;
        this.zzd = zzdyuVar;
        this.zze = zzdyuVar2;
    }

    public final String zza() {
        return this.zzc;
    }

    public final zzdyu zzb() {
        return this.zzd;
    }

    public final zzdyu zzc() {
        return this.zze;
    }
}
