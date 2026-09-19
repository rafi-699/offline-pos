package androidx.media3.exoplayer.ima;

import android.content.Context;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Player;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ImaAdsLoader implements AdsLoader {
    private final ImaSdkSettings imaSdkSettings;

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2) {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException) {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void release() {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void setPlayer(Player player) {
    }

    public void setPlayer(ExoPlayer exoPlayer) {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void setSupportedContentTypes(int... iArr) {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, AdsLoader.EventListener eventListener) {
    }

    @Override // androidx.media3.exoplayer.source.ads.AdsLoader
    public void stop(AdsMediaSource adsMediaSource, AdsLoader.EventListener eventListener) {
    }

    public ImaAdsLoader(ImaSdkSettings imaSdkSettings) {
        this.imaSdkSettings = imaSdkSettings;
    }

    public static class Builder {
        private ImaSdkSettings imaSdkSettings;

        public ImaAdsLoader build() {
            return null;
        }

        public Builder setAdErrorListener(Object obj) {
            return this;
        }

        public Builder setAdEventListener(Object obj) {
            return this;
        }

        public Builder(Context context) {
        }

        public Builder setImaSdkSettings(ImaSdkSettings imaSdkSettings) {
            this.imaSdkSettings = imaSdkSettings;
            return this;
        }
    }
}
