package com.google.ads.interactivemedia.v3.api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AdErrorEvent {

    public interface AdErrorListener {
        void onAdError(AdErrorEvent adErrorEvent);
    }

    public abstract AdError getError();
}
