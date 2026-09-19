package com.brentvatne.exoplayer;

import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactExoplayerConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H&R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "", "buildLoadErrorHandlingPolicy", "Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;", "minLoadRetryCount", "", "disableDisconnectError", "", "getDisableDisconnectError", "()Z", "setDisableDisconnectError", "(Z)V", "bandwidthMeter", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "getBandwidthMeter", "()Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "initialBitrate", "", "getInitialBitrate", "()Ljava/lang/Long;", "setInitialBitrate", "(Ljava/lang/Long;)V", "", "bitrate", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReactExoplayerConfig {
    LoadErrorHandlingPolicy buildLoadErrorHandlingPolicy(int minLoadRetryCount);

    DefaultBandwidthMeter getBandwidthMeter();

    boolean getDisableDisconnectError();

    Long getInitialBitrate();

    void setDisableDisconnectError(boolean z);

    void setInitialBitrate(long bitrate);

    void setInitialBitrate(Long l);
}
