package com.brentvatne.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import com.brentvatne.common.api.Source;
import com.brentvatne.react.RNVPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNVExoplayerPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/brentvatne/exoplayer/RNVExoplayerPlugin;", "Lcom/brentvatne/react/RNVPlugin;", "getDRMManager", "Lcom/brentvatne/exoplayer/DRMManagerSpec;", "overrideDrmSessionManager", "Landroidx/media3/exoplayer/drm/DrmSessionManager;", "source", "Lcom/brentvatne/common/api/Source;", "drmSessionManager", "overrideMediaDataSourceFactory", "Landroidx/media3/datasource/DataSource$Factory;", "mediaDataSourceFactory", "overrideMediaSourceFactory", "Landroidx/media3/exoplayer/source/MediaSource$Factory;", "mediaSourceFactory", "overrideMediaItemBuilder", "Landroidx/media3/common/MediaItem$Builder;", "mediaItemBuilder", "shouldDisableCache", "", "onInstanceCreated", "", "id", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "onInstanceRemoved", "", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RNVExoplayerPlugin extends RNVPlugin {
    DRMManagerSpec getDRMManager();

    void onInstanceCreated(String id, ExoPlayer player);

    @Override // com.brentvatne.react.RNVPlugin
    void onInstanceCreated(String id, Object player);

    void onInstanceRemoved(String id, ExoPlayer player);

    @Override // com.brentvatne.react.RNVPlugin
    void onInstanceRemoved(String id, Object player);

    DrmSessionManager overrideDrmSessionManager(Source source, DrmSessionManager drmSessionManager);

    DataSource.Factory overrideMediaDataSourceFactory(Source source, DataSource.Factory mediaDataSourceFactory);

    MediaItem.Builder overrideMediaItemBuilder(Source source, MediaItem.Builder mediaItemBuilder);

    MediaSource.Factory overrideMediaSourceFactory(Source source, MediaSource.Factory mediaSourceFactory, DataSource.Factory mediaDataSourceFactory);

    boolean shouldDisableCache(Source source);

    /* JADX INFO: compiled from: RNVExoplayerPlugin.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static DRMManagerSpec getDRMManager(RNVExoplayerPlugin rNVExoplayerPlugin) {
            return null;
        }

        public static DrmSessionManager overrideDrmSessionManager(RNVExoplayerPlugin rNVExoplayerPlugin, Source source, DrmSessionManager drmSessionManager) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(drmSessionManager, "drmSessionManager");
            return null;
        }

        public static DataSource.Factory overrideMediaDataSourceFactory(RNVExoplayerPlugin rNVExoplayerPlugin, Source source, DataSource.Factory mediaDataSourceFactory) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(mediaDataSourceFactory, "mediaDataSourceFactory");
            return null;
        }

        public static MediaItem.Builder overrideMediaItemBuilder(RNVExoplayerPlugin rNVExoplayerPlugin, Source source, MediaItem.Builder mediaItemBuilder) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(mediaItemBuilder, "mediaItemBuilder");
            return null;
        }

        public static MediaSource.Factory overrideMediaSourceFactory(RNVExoplayerPlugin rNVExoplayerPlugin, Source source, MediaSource.Factory mediaSourceFactory, DataSource.Factory mediaDataSourceFactory) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(mediaSourceFactory, "mediaSourceFactory");
            Intrinsics.checkNotNullParameter(mediaDataSourceFactory, "mediaDataSourceFactory");
            return null;
        }

        public static boolean shouldDisableCache(RNVExoplayerPlugin rNVExoplayerPlugin, Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return false;
        }

        public static void onInstanceCreated(RNVExoplayerPlugin rNVExoplayerPlugin, String id, Object player) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(player, "player");
            if (player instanceof ExoPlayer) {
                rNVExoplayerPlugin.onInstanceCreated(id, (ExoPlayer) player);
            }
        }

        public static void onInstanceRemoved(RNVExoplayerPlugin rNVExoplayerPlugin, String id, Object player) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(player, "player");
            if (player instanceof ExoPlayer) {
                rNVExoplayerPlugin.onInstanceRemoved(id, (ExoPlayer) player);
            }
        }
    }
}
