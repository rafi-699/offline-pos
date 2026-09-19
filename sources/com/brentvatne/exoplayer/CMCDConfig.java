package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.brentvatne.common.api.CMCDProps;
import com.brentvatne.common.toolbox.DebugLog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.collect.ImmutableListMultimap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CMCDConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J>\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00190\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/brentvatne/exoplayer/CMCDConfig;", "", "props", "Lcom/brentvatne/common/api/CMCDProps;", "<init>", "(Lcom/brentvatne/common/api/CMCDProps;)V", "toCmcdConfigurationFactory", "Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;", "createCmcdConfiguration", "Landroidx/media3/exoplayer/upstream/CmcdConfiguration;", "mediaItem", "Landroidx/media3/common/MediaItem;", "intToCmcdMode", "", "mode", "buildCustomData", "Lcom/google/common/collect/ImmutableListMultimap;", "", "addFormattedData", "", "builder", "Lcom/google/common/collect/ImmutableListMultimap$Builder;", SDKConstants.PARAM_KEY, "dataList", "", "Lkotlin/Pair;", "formatKeyValue", "value", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CMCDConfig {
    private final CMCDProps props;

    public CMCDConfig(CMCDProps props) {
        Intrinsics.checkNotNullParameter(props, "props");
        this.props = props;
    }

    public final CmcdConfiguration.Factory toCmcdConfigurationFactory() {
        return new CmcdConfiguration.Factory() { // from class: com.brentvatne.exoplayer.CMCDConfig$$ExternalSyntheticLambda0
            @Override // androidx.media3.exoplayer.upstream.CmcdConfiguration.Factory
            public final CmcdConfiguration createCmcdConfiguration(MediaItem mediaItem) {
                return this.f$0.createCmcdConfiguration(mediaItem);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CmcdConfiguration createCmcdConfiguration(MediaItem mediaItem) {
        return new CmcdConfiguration(UUID.randomUUID().toString(), mediaItem.mediaId, new CmcdConfiguration.RequestConfig() { // from class: com.brentvatne.exoplayer.CMCDConfig.createCmcdConfiguration.1
            @Override // androidx.media3.exoplayer.upstream.CmcdConfiguration.RequestConfig
            public ImmutableListMultimap<String, String> getCustomData() {
                return CMCDConfig.this.buildCustomData();
            }
        }, intToCmcdMode(this.props.getMode()));
    }

    private final int intToCmcdMode(int mode) {
        if (mode == 0) {
            return 0;
        }
        if (mode == 1) {
            return 1;
        }
        DebugLog.e("CMCDConfig", "Unsupported mode: " + mode + ", fallback on MODE_REQUEST_HEADER");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImmutableListMultimap<String, String> buildCustomData() {
        ImmutableListMultimap.Builder<String, String> builder = ImmutableListMultimap.builder();
        Intrinsics.checkNotNull(builder);
        addFormattedData(builder, CmcdConfiguration.KEY_CMCD_OBJECT, this.props.getCmcdObject());
        addFormattedData(builder, CmcdConfiguration.KEY_CMCD_REQUEST, this.props.getCmcdRequest());
        addFormattedData(builder, CmcdConfiguration.KEY_CMCD_SESSION, this.props.getCmcdSession());
        addFormattedData(builder, CmcdConfiguration.KEY_CMCD_STATUS, this.props.getCmcdStatus());
        ImmutableListMultimap<String, String> immutableListMultimapBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(immutableListMultimapBuild, "build(...)");
        return immutableListMultimapBuild;
    }

    private final void addFormattedData(ImmutableListMultimap.Builder<String, String> builder, String key, List<? extends Pair<String, ? extends Object>> dataList) {
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builder.put(key, formatKeyValue((String) pair.component1(), pair.component2()));
        }
    }

    private final String formatKeyValue(String key, Object value) {
        if (value instanceof String) {
            return key + "=\"" + value + "\"";
        }
        if (value instanceof Number) {
            return key + "=" + value;
        }
        throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
    }
}
