package com.brentvatne.exoplayer;

import android.content.Context;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultReactExoplayerConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\n\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/brentvatne/exoplayer/DefaultReactExoplayerConfig;", "Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "context", "Landroid/content/Context;", "initialBitrate", "", "<init>", "(Landroid/content/Context;Ljava/lang/Long;)V", "getInitialBitrate", "()Ljava/lang/Long;", "setInitialBitrate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "bandWidthMeter", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "disableDisconnectError", "", "getDisableDisconnectError", "()Z", "setDisableDisconnectError", "(Z)V", "bandwidthMeter", "getBandwidthMeter", "()Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "createBandwidthMeter", "bitrate", "(Ljava/lang/Long;)Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "", "buildLoadErrorHandlingPolicy", "Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;", "minLoadRetryCount", "", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReactExoplayerConfig implements ReactExoplayerConfig {
    private DefaultBandwidthMeter bandWidthMeter;
    private final Context context;
    private boolean disableDisconnectError;
    private Long initialBitrate;

    public DefaultReactExoplayerConfig(Context context, Long l) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.initialBitrate = l;
        this.bandWidthMeter = createBandwidthMeter(getInitialBitrate());
    }

    public /* synthetic */ DefaultReactExoplayerConfig(Context context, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : l);
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public Long getInitialBitrate() {
        return this.initialBitrate;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public void setInitialBitrate(Long l) {
        this.initialBitrate = l;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public boolean getDisableDisconnectError() {
        return this.disableDisconnectError;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public void setDisableDisconnectError(boolean z) {
        this.disableDisconnectError = z;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    /* JADX INFO: renamed from: getBandwidthMeter, reason: from getter */
    public DefaultBandwidthMeter getBandWidthMeter() {
        return this.bandWidthMeter;
    }

    private final DefaultBandwidthMeter createBandwidthMeter(Long bitrate) {
        DefaultBandwidthMeter defaultBandwidthMeterBuild = new DefaultBandwidthMeter.Builder(this.context).setInitialBitrateEstimate(bitrate != null ? bitrate.longValue() : 1000000L).build();
        Intrinsics.checkNotNullExpressionValue(defaultBandwidthMeterBuild, "build(...)");
        return defaultBandwidthMeterBuild;
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public void setInitialBitrate(long bitrate) {
        Long initialBitrate = getInitialBitrate();
        if (initialBitrate != null && initialBitrate.longValue() == bitrate) {
            return;
        }
        setInitialBitrate(Long.valueOf(bitrate));
        this.bandWidthMeter = createBandwidthMeter(Long.valueOf(bitrate));
    }

    @Override // com.brentvatne.exoplayer.ReactExoplayerConfig
    public LoadErrorHandlingPolicy buildLoadErrorHandlingPolicy(int minLoadRetryCount) {
        if (getDisableDisconnectError()) {
            return new ReactExoplayerLoadErrorHandlingPolicy(minLoadRetryCount);
        }
        return new DefaultLoadErrorHandlingPolicy(minLoadRetryCount);
    }
}
