package com.brentvatne.react;

import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.exoplayer.DRMManagerSpec;
import com.brentvatne.exoplayer.RNVExoplayerPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeVideoManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001eJ \u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0018\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$J\u000e\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010(\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/brentvatne/react/ReactNativeVideoManager;", "Lcom/brentvatne/react/RNVPlugin;", "<init>", "()V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "customDRMManager", "Lcom/brentvatne/exoplayer/DRMManagerSpec;", "instanceList", "", "registerView", "", "newInstance", "unregisterView", "registerPlugin", "plugin", "unregisterPlugin", "onInstanceCreated", "id", "", "player", "onInstanceRemoved", "getDRMManager", "overrideDrmSessionManager", "Landroidx/media3/exoplayer/drm/DrmSessionManager;", "source", "Lcom/brentvatne/common/api/Source;", "drmSessionManager", "overrideMediaDataSourceFactory", "Landroidx/media3/datasource/DataSource$Factory;", "mediaDataSourceFactory", "overrideMediaSourceFactory", "Landroidx/media3/exoplayer/source/MediaSource$Factory;", "mediaSourceFactory", "overrideMediaItemBuilder", "Landroidx/media3/common/MediaItem$Builder;", "mediaItemBuilder", "shouldDisableCache", "", "maybeRegisterExoplayerPlugin", "maybeUnregisterExoplayerPlugin", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeVideoManager implements RNVPlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ReactNativeVideoManager";
    private static volatile ReactNativeVideoManager instance;
    private DRMManagerSpec customDRMManager;
    private final ArrayList<RNVPlugin> pluginList = new ArrayList<>();
    private ArrayList<Object> instanceList = new ArrayList<>();

    /* JADX INFO: compiled from: ReactNativeVideoManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/brentvatne/react/ReactNativeVideoManager$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/brentvatne/react/ReactNativeVideoManager;", "getInstance", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactNativeVideoManager getInstance() {
            ReactNativeVideoManager reactNativeVideoManager;
            ReactNativeVideoManager reactNativeVideoManager2 = ReactNativeVideoManager.instance;
            if (reactNativeVideoManager2 != null) {
                return reactNativeVideoManager2;
            }
            synchronized (this) {
                reactNativeVideoManager = ReactNativeVideoManager.instance;
                if (reactNativeVideoManager == null) {
                    reactNativeVideoManager = new ReactNativeVideoManager();
                    Companion companion = ReactNativeVideoManager.INSTANCE;
                    ReactNativeVideoManager.instance = reactNativeVideoManager;
                }
            }
            return reactNativeVideoManager;
        }
    }

    public final void registerView(Object newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        if (this.instanceList.size() > 2) {
            DebugLog.d(TAG, "multiple Video displayed ?");
        }
        this.instanceList.add(newInstance);
    }

    public final void unregisterView(Object newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        this.instanceList.remove(newInstance);
    }

    public final void registerPlugin(RNVPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.pluginList.add(plugin);
        maybeRegisterExoplayerPlugin(plugin);
    }

    public final void unregisterPlugin(RNVPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.pluginList.remove(plugin);
        maybeUnregisterExoplayerPlugin(plugin);
    }

    @Override // com.brentvatne.react.RNVPlugin
    public void onInstanceCreated(String id, Object player) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).onInstanceCreated(id, player);
        }
    }

    @Override // com.brentvatne.react.RNVPlugin
    public void onInstanceRemoved(String id, Object player) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).onInstanceRemoved(id, player);
        }
    }

    /* JADX INFO: renamed from: getDRMManager, reason: from getter */
    public final DRMManagerSpec getCustomDRMManager() {
        return this.customDRMManager;
    }

    public final DrmSessionManager overrideDrmSessionManager(Source source, DrmSessionManager drmSessionManager) {
        DrmSessionManager drmSessionManagerOverrideDrmSessionManager;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(drmSessionManager, "drmSessionManager");
        Iterator<RNVPlugin> it = this.pluginList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RNVPlugin next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (drmSessionManagerOverrideDrmSessionManager = ((RNVExoplayerPlugin) rNVPlugin).overrideDrmSessionManager(source, drmSessionManager)) != null) {
                return drmSessionManagerOverrideDrmSessionManager;
            }
        }
        return null;
    }

    public final DataSource.Factory overrideMediaDataSourceFactory(Source source, DataSource.Factory mediaDataSourceFactory) {
        DataSource.Factory factoryOverrideMediaDataSourceFactory;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaDataSourceFactory, "mediaDataSourceFactory");
        Iterator<RNVPlugin> it = this.pluginList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RNVPlugin next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (factoryOverrideMediaDataSourceFactory = ((RNVExoplayerPlugin) rNVPlugin).overrideMediaDataSourceFactory(source, mediaDataSourceFactory)) != null) {
                return factoryOverrideMediaDataSourceFactory;
            }
        }
        return null;
    }

    public final MediaSource.Factory overrideMediaSourceFactory(Source source, MediaSource.Factory mediaSourceFactory, DataSource.Factory mediaDataSourceFactory) {
        MediaSource.Factory factoryOverrideMediaSourceFactory;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaSourceFactory, "mediaSourceFactory");
        Intrinsics.checkNotNullParameter(mediaDataSourceFactory, "mediaDataSourceFactory");
        Iterator<RNVPlugin> it = this.pluginList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RNVPlugin next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (factoryOverrideMediaSourceFactory = ((RNVExoplayerPlugin) rNVPlugin).overrideMediaSourceFactory(source, mediaSourceFactory, mediaDataSourceFactory)) != null) {
                return factoryOverrideMediaSourceFactory;
            }
        }
        return null;
    }

    public final MediaItem.Builder overrideMediaItemBuilder(Source source, MediaItem.Builder mediaItemBuilder) {
        MediaItem.Builder builderOverrideMediaItemBuilder;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(mediaItemBuilder, "mediaItemBuilder");
        Iterator<RNVPlugin> it = this.pluginList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RNVPlugin next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && (builderOverrideMediaItemBuilder = ((RNVExoplayerPlugin) rNVPlugin).overrideMediaItemBuilder(source, mediaItemBuilder)) != null) {
                return builderOverrideMediaItemBuilder;
            }
        }
        return null;
    }

    public final boolean shouldDisableCache(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Iterator<RNVPlugin> it = this.pluginList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RNVPlugin next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RNVPlugin rNVPlugin = next;
            if ((rNVPlugin instanceof RNVExoplayerPlugin) && ((RNVExoplayerPlugin) rNVPlugin).shouldDisableCache(source)) {
                return true;
            }
        }
        return false;
    }

    private final void maybeRegisterExoplayerPlugin(RNVPlugin plugin) {
        DRMManagerSpec dRMManager;
        if ((plugin instanceof RNVExoplayerPlugin) && (dRMManager = ((RNVExoplayerPlugin) plugin).getDRMManager()) != null) {
            if (this.customDRMManager != null) {
                DebugLog.w(TAG, "Multiple DRM managers registered. This is not supported. Using first registered manager.");
            } else {
                this.customDRMManager = dRMManager;
            }
        }
    }

    private final void maybeUnregisterExoplayerPlugin(RNVPlugin plugin) {
        if ((plugin instanceof RNVExoplayerPlugin) && ((RNVExoplayerPlugin) plugin).getDRMManager() == this.customDRMManager) {
            this.customDRMManager = null;
        }
    }
}
