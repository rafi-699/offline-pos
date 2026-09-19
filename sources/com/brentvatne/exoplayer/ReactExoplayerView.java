package com.brentvatne.exoplayer;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.dash.DashUtil;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.session.MediaSessionService;
import androidx.media3.ui.PlayerView;
import com.brentvatne.common.api.AdsProps;
import com.brentvatne.common.api.BufferConfig;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.DRMProps;
import com.brentvatne.common.api.SideLoadedTextTrack;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.api.TimedMetadata;
import com.brentvatne.common.api.Track;
import com.brentvatne.common.api.VideoTrack;
import com.brentvatne.common.react.VideoEventEmitter;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.brentvatne.react.R;
import com.brentvatne.react.ReactNativeVideoManager;
import com.brentvatne.receiver.AudioBecomingNoisyReceiver;
import com.brentvatne.receiver.BecomingNoisyListener;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.common.util.UriUtil;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.common.collect.ImmutableList;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.imagepicker.Utils$$ExternalSyntheticBackport0;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ReactExoplayerView extends FrameLayout implements LifecycleEventListener, Player.Listener, BandwidthMeter.EventListener, BecomingNoisyListener, DrmSessionEventListener, AdEvent.AdEventListener, AdErrorEvent.AdErrorListener {
    private static final CookieManager DEFAULT_COOKIE_MANAGER;
    public static final double DEFAULT_MAX_HEAP_ALLOCATION_PERCENT = 1.0d;
    public static final double DEFAULT_MIN_BUFFER_MEMORY_RESERVE = 0.0d;
    private static final int SHOW_PROGRESS = 1;
    private static final String TAG = "ReactExoplayerView";
    private static final String TAG_EVENT_LOGGER = "RNVExoplayer";
    private ImaAdsLoader adsLoader;
    private final AudioBecomingNoisyReceiver audioBecomingNoisyReceiver;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final AudioManager audioManager;
    private AudioOutput audioOutput;
    private String audioTrackType;
    private String audioTrackValue;
    private float audioVolume;
    private DefaultBandwidthMeter bandwidthMeter;
    private BufferingStrategy.BufferingStrategyEnum bufferingStrategy;
    private CmcdConfiguration.Factory cmcdConfigurationFactory;
    private final ReactExoplayerConfig config;
    private boolean controls;
    private ControlsConfig controlsConfig;
    private EventLogger debugEventLogger;
    private boolean disableCache;
    private boolean disableDisconnectError;
    private boolean disableFocus;
    private boolean enableDebug;
    public boolean enterPictureInPictureOnLeave;
    protected final VideoEventEmitter eventEmitter;
    private Player.Listener eventListener;
    private ExoPlayerView exoPlayerView;
    private boolean focusable;
    private FullScreenPlayerView fullScreenPlayerView;
    private boolean hasAudioFocus;
    private boolean hasDrmFailed;
    private boolean hasVideoEnded;
    private final String instanceId;
    private boolean isBuffering;
    private boolean isFullscreen;
    private boolean isInBackground;
    private boolean isPaused;
    private boolean isSeeking;
    private boolean isUsingContentResolution;
    private long lastBufferDuration;
    private long lastDuration;
    private long lastPos;
    private boolean loadVideoStarted;
    private float mProgressUpdateInterval;
    private boolean mReportBandwidth;
    private final Handler mainHandler;
    private Runnable mainRunnable;
    private int maxBitRate;
    private DataSource.Factory mediaDataSourceFactory;
    private boolean muted;
    private PictureInPictureParams.Builder pictureInPictureParamsBuilder;
    private final PictureInPictureReceiver pictureInPictureReceiver;
    private Runnable pipListenerUnsubscribe;
    protected boolean playInBackground;
    private PlaybackServiceBinder playbackServiceBinder;
    private ServiceConnection playbackServiceConnection;
    private ExoPlayer player;
    private boolean playerNeedsSource;
    private boolean preventsDisplaySleepDuringVideoPlayback;
    private final Handler progressHandler;
    private float rate;
    private boolean repeat;
    private long resumePosition;
    private int resumeWindow;
    private ArrayList<Integer> rootViewChildrenOriginalVisibility;
    private long seekPosition;
    private boolean selectTrackWhenReady;
    private int selectedSpeedIndex;
    private boolean showNotificationControls;
    private Source source;
    private String textTrackType;
    private String textTrackValue;
    private final ThemedReactContext themedReactContext;
    private DefaultTrackSelector trackSelector;
    private boolean useCache;
    private String videoTrackType;
    private String videoTrackValue;
    private boolean viewHasDropped;

    static /* synthetic */ DrmSessionManager lambda$buildMediaSource$10(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsLoadingChanged(boolean z) {
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTimelineChanged(Timeline timeline, int i) {
    }

    static {
        CookieManager cookieManager = new CookieManager();
        DEFAULT_COOKIE_MANAGER = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
        this.cmcdConfigurationFactory = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        if (this.player != null) {
            if (this.exoPlayerView != null && isPlayingAd() && this.controls) {
                this.exoPlayerView.hideController();
            }
            long bufferedPercentage = (((long) this.player.getBufferedPercentage()) * this.player.getDuration()) / 100;
            long duration = this.player.getDuration();
            long currentPosition = this.player.getCurrentPosition();
            if (currentPosition > duration) {
                currentPosition = duration;
            }
            if (this.lastPos == currentPosition && this.lastBufferDuration == bufferedPercentage && this.lastDuration == duration) {
                return;
            }
            this.lastPos = currentPosition;
            this.lastBufferDuration = bufferedPercentage;
            this.lastDuration = duration;
            this.eventEmitter.onVideoProgress.invoke(Long.valueOf(currentPosition), Long.valueOf(bufferedPercentage), Long.valueOf(this.player.getDuration()), Double.valueOf(getPositionInFirstPeriodMsForCurrentWindow(currentPosition)));
        }
    }

    public double getPositionInFirstPeriodMsForCurrentWindow(long j) {
        Timeline.Window window = new Timeline.Window();
        if (!this.player.getCurrentTimeline().isEmpty()) {
            this.player.getCurrentTimeline().getWindow(this.player.getCurrentMediaItemIndex(), window);
        }
        return window.windowStartTimeMs + j;
    }

    public ReactExoplayerView(ThemedReactContext themedReactContext, ReactExoplayerConfig reactExoplayerConfig) {
        super(themedReactContext);
        this.debugEventLogger = null;
        this.enableDebug = false;
        this.muted = false;
        this.enterPictureInPictureOnLeave = false;
        this.hasAudioFocus = false;
        this.rate = 1.0f;
        this.audioOutput = AudioOutput.SPEAKER;
        this.audioVolume = 1.0f;
        this.maxBitRate = 0;
        this.hasDrmFailed = false;
        this.isUsingContentResolution = false;
        this.selectTrackWhenReady = false;
        this.useCache = false;
        this.disableCache = false;
        this.controlsConfig = new ControlsConfig();
        this.rootViewChildrenOriginalVisibility = new ArrayList<>();
        this.isSeeking = false;
        this.seekPosition = -1L;
        this.hasVideoEnded = false;
        this.source = new Source();
        this.textTrackType = "disabled";
        this.focusable = true;
        this.preventsDisplaySleepDuringVideoPlayback = true;
        this.mProgressUpdateInterval = 250.0f;
        this.playInBackground = false;
        this.mReportBandwidth = false;
        this.controls = false;
        this.showNotificationControls = false;
        this.lastPos = -1L;
        this.lastBufferDuration = -1L;
        this.lastDuration = -1L;
        this.viewHasDropped = false;
        this.selectedSpeedIndex = 1;
        this.instanceId = String.valueOf(UUID.randomUUID());
        this.progressHandler = new Handler(Looper.getMainLooper()) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    ReactExoplayerView.this.updateProgress();
                    sendMessageDelayed(obtainMessage(1), Math.round(ReactExoplayerView.this.mProgressUpdateInterval));
                }
            }
        };
        this.themedReactContext = themedReactContext;
        this.eventEmitter = new VideoEventEmitter();
        this.config = reactExoplayerConfig;
        this.bandwidthMeter = reactExoplayerConfig.getBandWidthMeter();
        if (Build.VERSION.SDK_INT >= 26 && this.pictureInPictureParamsBuilder == null) {
            this.pictureInPictureParamsBuilder = new PictureInPictureParams.Builder();
        }
        this.mainHandler = new Handler();
        createViews();
        this.audioManager = (AudioManager) themedReactContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        themedReactContext.addLifecycleEventListener(this);
        this.audioBecomingNoisyReceiver = new AudioBecomingNoisyReceiver(themedReactContext);
        this.audioFocusChangeListener = new OnAudioFocusChangedListener(themedReactContext);
        this.pictureInPictureReceiver = new PictureInPictureReceiver(this, themedReactContext);
    }

    private boolean isPlayingAd() {
        ExoPlayer exoPlayer = this.player;
        return exoPlayer != null && exoPlayer.isPlayingAd();
    }

    private void createViews() {
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = DEFAULT_COOKIE_MANAGER;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ExoPlayerView exoPlayerView = new ExoPlayerView(getContext());
        this.exoPlayerView = exoPlayerView;
        exoPlayerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda15
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$createViews$0(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        this.exoPlayerView.setLayoutParams(layoutParams);
        addView(this.exoPlayerView, 0, layoutParams);
        this.exoPlayerView.setFocusable(this.focusable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createViews$0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PictureInPictureUtil.applySourceRectHint(this.themedReactContext, this.pictureInPictureParamsBuilder, this.exoPlayerView);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cleanupPlaybackService();
        super.onDetachedFromWindow();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        if (!this.playInBackground || !this.isInBackground) {
            setPlayWhenReady(!this.isPaused);
        }
        this.isInBackground = false;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.isInBackground = true;
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        boolean z = Util.SDK_INT >= 24 && currentActivity != null && currentActivity.isInPictureInPictureMode();
        boolean z2 = Util.SDK_INT >= 24 && currentActivity != null && currentActivity.isInMultiWindowMode();
        if (this.playInBackground || z || z2) {
            return;
        }
        setPlayWhenReady(false);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        cleanUpResources();
    }

    public void cleanUpResources() {
        stopPlayback();
        this.themedReactContext.removeLifecycleEventListener(this);
        releasePlayer();
        this.viewHasDropped = true;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener
    public void onBandwidthSample(int i, long j, long j2) {
        int i2;
        if (this.mReportBandwidth) {
            ExoPlayer exoPlayer = this.player;
            int i3 = 0;
            if (exoPlayer == null) {
                this.eventEmitter.onVideoBandwidthUpdate.invoke(Long.valueOf(j2), 0, 0, null);
                return;
            }
            Format videoFormat = exoPlayer.getVideoFormat();
            boolean z = videoFormat != null && (videoFormat.rotationDegrees == 90 || videoFormat.rotationDegrees == 270);
            if (videoFormat != null) {
                i2 = z ? videoFormat.height : videoFormat.width;
            } else {
                i2 = 0;
            }
            if (videoFormat != null) {
                i3 = z ? videoFormat.width : videoFormat.height;
            }
            this.eventEmitter.onVideoBandwidthUpdate.invoke(Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i2), videoFormat != null ? videoFormat.id : null);
        }
    }

    private void togglePlayerControlVisibility() {
        if (this.player == null) {
            return;
        }
        if (this.exoPlayerView.isControllerVisible()) {
            this.exoPlayerView.hideController();
        } else {
            this.exoPlayerView.showController();
        }
    }

    private void initializePlayerControl() {
        this.exoPlayerView.setPlayer(this.player);
        this.exoPlayerView.setControllerVisibilityListener(new PlayerView.ControllerVisibilityListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda10
            @Override // androidx.media3.ui.PlayerView.ControllerVisibilityListener
            public final void onVisibilityChanged(int i) {
                this.f$0.lambda$initializePlayerControl$1(i);
            }
        });
        this.exoPlayerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda11
            @Override // androidx.media3.ui.PlayerView.FullscreenButtonClickListener
            public final void onFullscreenButtonClick(boolean z) {
                this.f$0.lambda$initializePlayerControl$2(z);
            }
        });
        updateControllerConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$1(int i) {
        this.eventEmitter.onControlsVisibilityChange.invoke(Boolean.valueOf(i == 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayerControl$2(boolean z) {
        setFullscreen(!this.isFullscreen);
    }

    private void updateControllerConfig() {
        ExoPlayerView exoPlayerView = this.exoPlayerView;
        if (exoPlayerView == null) {
            return;
        }
        exoPlayerView.setControllerShowTimeoutMs(5000);
        this.exoPlayerView.setControllerAutoShow(true);
        this.exoPlayerView.setControllerHideOnTouch(true);
        updateControllerVisibility();
    }

    private void updateControllerVisibility() {
        ExoPlayerView exoPlayerView = this.exoPlayerView;
        if (exoPlayerView == null) {
            return;
        }
        exoPlayerView.setUseController(this.controls && !this.controlsConfig.getHideFullscreen());
    }

    private void openSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.themedReactContext);
        builder.setTitle(R.string.settings);
        builder.setItems(new String[]{this.themedReactContext.getString(R.string.playback_speed)}, new DialogInterface.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$openSettings$3(dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openSettings$3(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            showPlaybackSpeedOptions();
        }
    }

    private void showPlaybackSpeedOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.themedReactContext);
        builder.setTitle(R.string.select_playback_speed);
        builder.setSingleChoiceItems(new String[]{"0.5x", "1.0x", "1.5x", "2.0x"}, this.selectedSpeedIndex, new DialogInterface.OnClickListener() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPlaybackSpeedOptions$4(dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPlaybackSpeedOptions$4(DialogInterface dialogInterface, int i) {
        float f;
        this.selectedSpeedIndex = i;
        if (i == 0) {
            f = 0.5f;
        } else if (i != 2) {
            f = i != 3 ? 1.0f : 2.0f;
        } else {
            f = 1.5f;
        }
        setRateModifier(f);
    }

    private void addPlayerControl() {
        updateControllerConfig();
    }

    private void reLayout(View view) {
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void refreshControlsStyles() {
        if (this.exoPlayerView == null || this.player == null || !this.controls) {
            return;
        }
        updateControllerVisibility();
    }

    private void reLayoutControls() {
        reLayout(this.exoPlayerView);
    }

    public boolean isUsingVideoABR() {
        String str = this.videoTrackType;
        return str == null || "auto".equals(str);
    }

    public void setDebug(boolean z) {
        this.enableDebug = z;
        refreshDebugState();
    }

    private void refreshDebugState() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return;
        }
        if (this.enableDebug) {
            EventLogger eventLogger = new EventLogger(TAG_EVENT_LOGGER);
            this.debugEventLogger = eventLogger;
            this.player.addAnalyticsListener(eventLogger);
        } else {
            EventLogger eventLogger2 = this.debugEventLogger;
            if (eventLogger2 != null) {
                exoPlayer.removeAnalyticsListener(eventLogger2);
                this.debugEventLogger = null;
            }
        }
    }

    public void setViewType(int i) {
        this.exoPlayerView.updateSurfaceView(i);
    }

    private class RNVLoadControl extends DefaultLoadControl {
        private final int availableHeapInBytes;
        private final Runtime runtime;

        public RNVLoadControl(DefaultAllocator defaultAllocator, BufferConfig bufferConfig) {
            super(defaultAllocator, bufferConfig.getMinBufferMs() != BufferConfig.INSTANCE.getBufferConfigPropUnsetInt() ? bufferConfig.getMinBufferMs() : 50000, bufferConfig.getMaxBufferMs() != BufferConfig.INSTANCE.getBufferConfigPropUnsetInt() ? bufferConfig.getMaxBufferMs() : 50000, bufferConfig.getBufferForPlaybackMs() != BufferConfig.INSTANCE.getBufferConfigPropUnsetInt() ? bufferConfig.getBufferForPlaybackMs() : 2500, bufferConfig.getBufferForPlaybackAfterRebufferMs() != BufferConfig.INSTANCE.getBufferConfigPropUnsetInt() ? bufferConfig.getBufferForPlaybackAfterRebufferMs() : 5000, -1, true, bufferConfig.getBackBufferDurationMs() != BufferConfig.INSTANCE.getBufferConfigPropUnsetInt() ? bufferConfig.getBackBufferDurationMs() : 0, false);
            this.runtime = Runtime.getRuntime();
            this.availableHeapInBytes = (int) Math.floor(((double) ((ActivityManager) ReactExoplayerView.this.themedReactContext.getSystemService("activity")).getMemoryClass()) * (bufferConfig.getMaxHeapAllocationPercent() != BufferConfig.INSTANCE.getBufferConfigPropUnsetDouble() ? bufferConfig.getMaxHeapAllocationPercent() : 1.0d) * 1024.0d * 1024.0d);
        }

        @Override // androidx.media3.exoplayer.LoadControl
        public boolean shouldContinueLoading(long j, long j2, float f) {
            if (ReactExoplayerView.this.bufferingStrategy == BufferingStrategy.BufferingStrategyEnum.DisableBuffering) {
                return false;
            }
            if (ReactExoplayerView.this.bufferingStrategy == BufferingStrategy.BufferingStrategyEnum.DependingOnMemory) {
                int totalBytesAllocated = getAllocator().getTotalBytesAllocated();
                int i = this.availableHeapInBytes;
                if (i > 0 && totalBytesAllocated >= i) {
                    return false;
                }
                long j3 = j2 / 1000;
                if (((long) (ReactExoplayerView.this.source.getBufferConfig().getMinBufferMemoryReservePercent() != BufferConfig.INSTANCE.getBufferConfigPropUnsetDouble() ? ReactExoplayerView.this.source.getBufferConfig().getMinBufferMemoryReservePercent() : ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE)) * this.runtime.maxMemory() > this.runtime.maxMemory() - (this.runtime.totalMemory() - this.runtime.freeMemory()) && j3 > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                    return false;
                }
                if (this.runtime.freeMemory() == 0) {
                    DebugLog.w(ReactExoplayerView.TAG, "Free memory reached 0, forcing garbage collection");
                    this.runtime.gc();
                    return false;
                }
            }
            return super.shouldContinueLoading(j, j2, f);
        }
    }

    private void initializePlayer() {
        this.disableCache = ReactNativeVideoManager.INSTANCE.getInstance().shouldDisableCache(this.source);
        final Activity currentActivity = this.themedReactContext.getCurrentActivity();
        final Source source = this.source;
        Runnable runnable = new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initializePlayer$7(source, this, currentActivity);
            }
        };
        this.mainRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$7(final Source source, final ReactExoplayerView reactExoplayerView, final Activity activity) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        try {
            if (source.getUri() == null) {
                return;
            }
            if (this.player == null) {
                initializePlayerCore(reactExoplayerView);
                this.pipListenerUnsubscribe = PictureInPictureUtil.addLifecycleEventListener(this.themedReactContext, this);
                PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, this.enterPictureInPictureOnLeave);
            }
            if (!this.source.getIsLocalAssetFile() && !this.source.getIsAsset() && this.source.getBufferConfig().getCacheSize() > 0) {
                RNVSimpleCache.INSTANCE.setSimpleCache(getContext(), this.source.getBufferConfig().getCacheSize());
                this.useCache = true;
            } else {
                this.useCache = false;
            }
            if (this.playerNeedsSource) {
                this.exoPlayerView.invalidateAspectRatio();
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$initializePlayer$6(source, activity, reactExoplayerView);
                    }
                });
            } else if (source == this.source) {
                initializePlayerSource(source);
            }
        } catch (Exception e) {
            reactExoplayerView.playerNeedsSource = true;
            DebugLog.e(TAG, "Failed to initialize Player! 2");
            DebugLog.e(TAG, e.toString());
            e.printStackTrace();
            this.eventEmitter.onVideoError.invoke(e.toString(), e, "1001");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$6(final Source source, Activity activity, final ReactExoplayerView reactExoplayerView) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        if (activity == null) {
            DebugLog.e(TAG, "Failed to initialize Player!, null activity");
            this.eventEmitter.onVideoError.invoke("Failed to initialize Player!", new Exception("Current Activity is null!"), "1001");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initializePlayer$5(source, reactExoplayerView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$5(Source source, ReactExoplayerView reactExoplayerView) {
        if (this.viewHasDropped && source == this.source) {
            return;
        }
        try {
            initializePlayerSource(source);
        } catch (Exception e) {
            reactExoplayerView.playerNeedsSource = true;
            DebugLog.e(TAG, "Failed to initialize Player! 1");
            DebugLog.e(TAG, e.toString());
            e.printStackTrace();
            this.eventEmitter.onVideoError.invoke(e.toString(), e, "1001");
        }
    }

    public void getCurrentPosition(Promise promise) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            promise.resolve(Float.valueOf(exoPlayer.getCurrentPosition() / 1000.0f));
        } else {
            promise.reject("PLAYER_NOT_AVAILABLE", "Player is not initialized.");
        }
    }

    private void initializePlayerCore(ReactExoplayerView reactExoplayerView) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(getContext(), new AdaptiveTrackSelection.Factory());
        reactExoplayerView.trackSelector = defaultTrackSelector;
        DefaultTrackSelector.Parameters.Builder builderBuildUponParameters = this.trackSelector.buildUponParameters();
        int i = this.maxBitRate;
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        defaultTrackSelector.setParameters(builderBuildUponParameters.setMaxVideoBitrate(i));
        RNVLoadControl rNVLoadControl = new RNVLoadControl(new DefaultAllocator(true, 65536), this.source.getBufferConfig());
        long initialBitrate = this.source.getBufferConfig().getInitialBitrate();
        if (initialBitrate > 0) {
            this.config.setInitialBitrate(initialBitrate);
            this.bandwidthMeter = this.config.getBandWidthMeter();
        }
        DefaultRenderersFactory defaultRenderersFactoryForceEnableMediaCodecAsynchronousQueueing = new DefaultRenderersFactory(getContext()).setExtensionRendererMode(0).setEnableDecoderFallback(true).forceEnableMediaCodecAsynchronousQueueing();
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.mediaDataSourceFactory);
        if (this.useCache && !this.disableCache) {
            defaultMediaSourceFactory.setDataSourceFactory(RNVSimpleCache.INSTANCE.getCacheFactory(buildHttpDataSourceFactory(true)));
        }
        defaultMediaSourceFactory.setLocalAdInsertionComponents(new AdsLoader.Provider() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda3
            @Override // androidx.media3.exoplayer.source.ads.AdsLoader.Provider
            public final AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration) {
                return this.f$0.lambda$initializePlayerCore$8(adsConfiguration);
            }
        }, this.exoPlayerView.getPlayerView());
        this.player = new ExoPlayer.Builder(getContext(), defaultRenderersFactoryForceEnableMediaCodecAsynchronousQueueing).setTrackSelector(reactExoplayerView.trackSelector).setBandwidthMeter(this.bandwidthMeter).setLoadControl(rNVLoadControl).setMediaSourceFactory(defaultMediaSourceFactory).build();
        ReactNativeVideoManager.INSTANCE.getInstance().onInstanceCreated(this.instanceId, this.player);
        refreshDebugState();
        this.player.addListener(reactExoplayerView);
        this.player.setVolume(this.muted ? 0.0f : this.audioVolume * 1.0f);
        this.exoPlayerView.setPlayer(this.player);
        this.audioBecomingNoisyReceiver.setListener(reactExoplayerView);
        this.pictureInPictureReceiver.setListener();
        this.bandwidthMeter.addEventListener(new Handler(), reactExoplayerView);
        setPlayWhenReady(!this.isPaused);
        this.playerNeedsSource = true;
        this.player.setPlaybackParameters(new PlaybackParameters(this.rate, 1.0f));
        changeAudioOutput(this.audioOutput);
        if (this.showNotificationControls) {
            setupPlaybackService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdsLoader lambda$initializePlayerCore$8(MediaItem.AdsConfiguration adsConfiguration) {
        return this.adsLoader;
    }

    private AdsMediaSource initializeAds(MediaSource mediaSource, Source source) {
        Uri adTagUrl;
        AdsProps adsProps = source.getAdsProps();
        Uri uri = source.getUri();
        if (adsProps == null || uri == null || (adTagUrl = adsProps.getAdTagUrl()) == null) {
            return null;
        }
        ImaAdsLoader.Builder adErrorListener = new ImaAdsLoader.Builder(this.themedReactContext).setAdEventListener(this).setAdErrorListener(this);
        if (adsProps.getAdLanguage() != null) {
            ImaSdkSettings imaSdkSettingsCreateImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
            imaSdkSettingsCreateImaSdkSettings.setLanguage(adsProps.getAdLanguage());
            adErrorListener.setImaSdkSettings(imaSdkSettingsCreateImaSdkSettings);
        }
        ImaAdsLoader imaAdsLoaderBuild = adErrorListener.build();
        this.adsLoader = imaAdsLoaderBuild;
        imaAdsLoaderBuild.setPlayer(this.player);
        if (this.adsLoader != null) {
            return new AdsMediaSource(mediaSource, new DataSpec(adTagUrl), ImmutableList.of(uri, adTagUrl), new DefaultMediaSourceFactory(this.mediaDataSourceFactory).setLocalAdInsertionComponents(new AdsLoader.Provider() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda17
                @Override // androidx.media3.exoplayer.source.ads.AdsLoader.Provider
                public final AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration) {
                    return this.f$0.lambda$initializeAds$9(adsConfiguration);
                }
            }, this.exoPlayerView.getPlayerView()), this.adsLoader, this.exoPlayerView.getPlayerView());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdsLoader lambda$initializeAds$9(MediaItem.AdsConfiguration adsConfiguration) {
        return this.adsLoader;
    }

    private DrmSessionManager buildDrmSessionManager(UUID uuid, DRMProps dRMProps) throws UnsupportedDrmException {
        if (Util.SDK_INT < 18) {
            return null;
        }
        try {
            DRMManagerSpec customDRMManager = ReactNativeVideoManager.INSTANCE.getInstance().getCustomDRMManager();
            if (customDRMManager == null) {
                customDRMManager = new DRMManager(buildHttpDataSourceFactory(false));
            }
            DrmSessionManager drmSessionManagerBuildDrmSessionManager = customDRMManager.buildDrmSessionManager(uuid, dRMProps);
            if (drmSessionManagerBuildDrmSessionManager == null) {
                this.eventEmitter.onVideoError.invoke("Failed to build DRM session manager", new Exception("DRM session manager is null"), "3007");
            }
            DrmSessionManager drmSessionManagerOverrideDrmSessionManager = ReactNativeVideoManager.INSTANCE.getInstance().overrideDrmSessionManager(this.source, drmSessionManagerBuildDrmSessionManager);
            return drmSessionManagerOverrideDrmSessionManager != null ? drmSessionManagerOverrideDrmSessionManager : drmSessionManagerBuildDrmSessionManager;
        } catch (UnsupportedDrmException e) {
            throw e;
        } catch (Exception e2) {
            this.eventEmitter.onVideoError.invoke(e2.toString(), e2, "3006");
            return null;
        }
    }

    private void initializePlayerSource(Source source) {
        ExoPlayer exoPlayer;
        if (source.getUri() == null) {
            return;
        }
        DrmSessionManager drmSessionManagerInitializePlayerDrm = initializePlayerDrm();
        if (drmSessionManagerInitializePlayerDrm == null && source.getDrmProps() != null && source.getDrmProps().getDrmType() != null) {
            DebugLog.e(TAG, "Failed to initialize DRM Session Manager Framework!");
            return;
        }
        MediaSource mediaSourceBuildMediaSource = buildMediaSource(source.getUri(), source.getExtension(), drmSessionManagerInitializePlayerDrm, source.getCropStartMs(), source.getCropEndMs());
        MediaSource mediaSource = (MediaSource) Utils$$ExternalSyntheticBackport0.m(initializeAds(mediaSourceBuildMediaSource, source), mediaSourceBuildMediaSource);
        while (true) {
            exoPlayer = this.player;
            if (exoPlayer != null) {
                break;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                DebugLog.e(TAG, e.toString());
            }
        }
        int i = this.resumeWindow;
        if (i != -1) {
            exoPlayer.seekTo(i, this.resumePosition);
            this.player.setMediaSource(mediaSource, false);
        } else if (source.getStartPositionMs() > 0) {
            this.player.setMediaSource(mediaSource, source.getStartPositionMs());
        } else {
            this.player.setMediaSource(mediaSource, true);
        }
        this.player.prepare();
        this.playerNeedsSource = false;
        reLayoutControls();
        this.eventEmitter.onVideoLoadStart.invoke();
        this.loadVideoStarted = true;
        finishPlayerInitialization();
    }

    private DrmSessionManager initializePlayerDrm() {
        UUID drmUuid;
        int i;
        DRMProps drmProps = this.source.getDrmProps();
        if (drmProps == null || drmProps.getDrmType() == null || (drmUuid = Util.getDrmUuid(drmProps.getDrmType())) == null) {
            return null;
        }
        try {
            DebugLog.d(TAG, "drm buildDrmSessionManager");
            return buildDrmSessionManager(drmUuid, drmProps);
        } catch (UnsupportedDrmException e) {
            if (Util.SDK_INT < 18) {
                i = R.string.error_drm_not_supported;
            } else {
                i = e.reason == 1 ? R.string.error_drm_unsupported_scheme : R.string.error_drm_unknown;
            }
            this.eventEmitter.onVideoError.invoke(getResources().getString(i), e, "3003");
            return null;
        }
    }

    private void finishPlayerInitialization() {
        initializePlayerControl();
        setControls(this.controls);
        applyModifiers();
    }

    private void setupPlaybackService() {
        if (!this.showNotificationControls || this.player == null) {
            return;
        }
        this.playbackServiceConnection = new ServiceConnection() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ReactExoplayerView.this.playbackServiceBinder = (PlaybackServiceBinder) iBinder;
                try {
                    Activity currentActivity = ReactExoplayerView.this.themedReactContext.getCurrentActivity();
                    if (currentActivity == null) {
                        DebugLog.w(ReactExoplayerView.TAG, "Could not register ExoPlayer: currentActivity is null");
                    } else {
                        ReactExoplayerView.this.playbackServiceBinder.getService().registerPlayer(ReactExoplayerView.this.player, currentActivity.getClass());
                    }
                } catch (Exception e) {
                    DebugLog.e(ReactExoplayerView.TAG, "Could not register ExoPlayer: " + e.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                try {
                    if (ReactExoplayerView.this.playbackServiceBinder != null) {
                        ReactExoplayerView.this.playbackServiceBinder.getService().unregisterPlayer(ReactExoplayerView.this.player);
                    }
                } catch (Exception unused) {
                }
                ReactExoplayerView.this.playbackServiceBinder = null;
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                DebugLog.e(ReactExoplayerView.TAG, "Could not register ExoPlayer");
            }
        };
        Intent intent = new Intent(this.themedReactContext, (Class<?>) VideoPlaybackService.class);
        intent.setAction(MediaSessionService.SERVICE_INTERFACE);
        if (Build.VERSION.SDK_INT >= 26) {
            this.themedReactContext.startForegroundService(intent);
        } else {
            this.themedReactContext.startService(intent);
        }
        this.themedReactContext.bindService(intent, this.playbackServiceConnection, Build.VERSION.SDK_INT >= 29 ? FragmentTransaction.TRANSIT_FRAGMENT_OPEN : 1);
    }

    private void cleanupPlaybackService() {
        PlaybackServiceBinder playbackServiceBinder;
        try {
            if (this.player != null && (playbackServiceBinder = this.playbackServiceBinder) != null) {
                playbackServiceBinder.getService().unregisterPlayer(this.player);
            }
            this.playbackServiceBinder = null;
            ServiceConnection serviceConnection = this.playbackServiceConnection;
            if (serviceConnection != null) {
                this.themedReactContext.unbindService(serviceConnection);
            }
        } catch (Exception unused) {
            DebugLog.w(TAG, "Cloud not cleanup playback service");
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0168  */
    /* JADX WARN: Code duplicated, block: B:66:0x0199  */
    /* JADX WARN: Code duplicated, block: B:67:0x019e  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01db  */
    /* JADX WARN: Code duplicated, block: B:79:0x01df  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ea A[RETURN] */
    private MediaSource buildMediaSource(Uri uri, String str, final DrmSessionManager drmSessionManager, long j, long j2) {
        int iInferContentType;
        DrmSessionManagerProvider defaultDrmSessionManagerProvider;
        MediaSource.Factory factory;
        MediaSource.Factory cmcdConfigurationFactory;
        final CmcdConfiguration.Factory factory2;
        MediaItem.Builder builderOverrideMediaItemBuilder;
        MediaItem mediaItemBuild;
        MediaSource mediaSourceCreateMediaSource;
        Uri adTagUrl;
        if (uri == null) {
            throw new IllegalStateException("Invalid video uri");
        }
        if ("rtsp".equals(str)) {
            iInferContentType = 3;
        } else {
            iInferContentType = Util.inferContentType(!TextUtils.isEmpty(str) ? "." + str : uri.getLastPathSegment());
        }
        this.config.setDisableDisconnectError(this.disableDisconnectError);
        MediaItem.Builder uri2 = new MediaItem.Builder().setUri(uri);
        MediaMetadata mediaMetadataBuildCustomMetadata = ConfigurationUtils.buildCustomMetadata(this.source.getMetadata());
        if (mediaMetadataBuildCustomMetadata != null) {
            uri2.setMediaMetadata(mediaMetadataBuildCustomMetadata);
        }
        List<MediaItem.SubtitleConfiguration> listBuildSubtitleConfigurations = buildSubtitleConfigurations();
        if (listBuildSubtitleConfigurations != null) {
            uri2.setSubtitleConfigurations(listBuildSubtitleConfigurations);
        }
        if (this.source.getAdsProps() != null && (adTagUrl = this.source.getAdsProps().getAdTagUrl()) != null) {
            uri2.setAdsConfiguration(new MediaItem.AdsConfiguration.Builder(adTagUrl).build());
        }
        uri2.setLiveConfiguration(ConfigurationUtils.getLiveConfiguration(this.source.getBufferConfig()).build());
        ArrayList arrayList = new ArrayList();
        if (drmSessionManager != null) {
            defaultDrmSessionManagerProvider = new DrmSessionManagerProvider() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda12
                @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
                public final DrmSessionManager get(MediaItem mediaItem) {
                    return ReactExoplayerView.lambda$buildMediaSource$10(drmSessionManager, mediaItem);
                }
            };
        } else {
            defaultDrmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
        }
        if (iInferContentType == 0) {
            factory = new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory(false));
        } else {
            if (iInferContentType == 1) {
                factory = new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory(false));
            } else if (iInferContentType == 2) {
                DataSource.Factory cacheFactory = this.mediaDataSourceFactory;
                if (this.useCache && !this.disableCache) {
                    cacheFactory = RNVSimpleCache.INSTANCE.getCacheFactory(buildHttpDataSourceFactory(true));
                }
                cmcdConfigurationFactory = new HlsMediaSource.Factory(cacheFactory).setAllowChunklessPreparation(this.source.getTextTracksAllowChunklessPreparation());
            } else {
                if (iInferContentType == 3) {
                    DebugLog.e("Exo Player Exception", "RTSP is not enabled!");
                    throw new IllegalStateException("RTSP is not enabled!");
                }
                if (iInferContentType == 4) {
                    if (UriUtil.LOCAL_ASSET_SCHEME.equals(uri.getScheme())) {
                        try {
                            cmcdConfigurationFactory = new ProgressiveMediaSource.Factory(DataSourceUtil.buildAssetDataSourceFactory(this.themedReactContext, uri));
                        } catch (Exception unused) {
                            throw new IllegalStateException("cannot open input file:" + uri);
                        }
                    } else if ("file".equals(uri.getScheme()) || !this.useCache) {
                        cmcdConfigurationFactory = new ProgressiveMediaSource.Factory(this.mediaDataSourceFactory);
                    } else {
                        cmcdConfigurationFactory = new ProgressiveMediaSource.Factory(RNVSimpleCache.INSTANCE.getCacheFactory(buildHttpDataSourceFactory(true)));
                    }
                } else {
                    throw new IllegalStateException("Unsupported type: " + iInferContentType);
                }
            }
            factory2 = this.cmcdConfigurationFactory;
            if (factory2 != null) {
                Objects.requireNonNull(factory2);
                cmcdConfigurationFactory = cmcdConfigurationFactory.setCmcdConfigurationFactory(new CmcdConfiguration.Factory() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda13
                    @Override // androidx.media3.exoplayer.upstream.CmcdConfiguration.Factory
                    public final CmcdConfiguration createCmcdConfiguration(MediaItem mediaItem) {
                        return factory2.createCmcdConfiguration(mediaItem);
                    }
                });
            }
            MediaSource.Factory factory3 = (MediaSource.Factory) Utils$$ExternalSyntheticBackport0.m(ReactNativeVideoManager.INSTANCE.getInstance().overrideMediaSourceFactory(this.source, cmcdConfigurationFactory, this.mediaDataSourceFactory), cmcdConfigurationFactory);
            uri2.setStreamKeys(arrayList);
            builderOverrideMediaItemBuilder = ReactNativeVideoManager.INSTANCE.getInstance().overrideMediaItemBuilder(this.source, uri2);
            if (builderOverrideMediaItemBuilder != null) {
                mediaItemBuild = builderOverrideMediaItemBuilder.build();
            } else {
                mediaItemBuild = uri2.build();
            }
            mediaSourceCreateMediaSource = factory3.setDrmSessionManagerProvider(defaultDrmSessionManagerProvider).setLoadErrorHandlingPolicy(this.config.buildLoadErrorHandlingPolicy(this.source.getMinLoadRetryCount())).createMediaSource(mediaItemBuild);
            if (j < 0 && j2 >= 0) {
                return new ClippingMediaSource(mediaSourceCreateMediaSource, j * 1000, j2 * 1000);
            }
            if (j >= 0) {
                return new ClippingMediaSource(mediaSourceCreateMediaSource, 1000 * j, Long.MIN_VALUE);
            }
            if (j2 >= 0) {
                return new ClippingMediaSource(mediaSourceCreateMediaSource, 0L, j2 * 1000);
            }
            return mediaSourceCreateMediaSource;
        }
        cmcdConfigurationFactory = factory;
        factory2 = this.cmcdConfigurationFactory;
        if (factory2 != null) {
            Objects.requireNonNull(factory2);
            cmcdConfigurationFactory = cmcdConfigurationFactory.setCmcdConfigurationFactory(new CmcdConfiguration.Factory() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda13
                @Override // androidx.media3.exoplayer.upstream.CmcdConfiguration.Factory
                public final CmcdConfiguration createCmcdConfiguration(MediaItem mediaItem) {
                    return factory2.createCmcdConfiguration(mediaItem);
                }
            });
        }
        MediaSource.Factory factory4 = (MediaSource.Factory) Utils$$ExternalSyntheticBackport0.m(ReactNativeVideoManager.INSTANCE.getInstance().overrideMediaSourceFactory(this.source, cmcdConfigurationFactory, this.mediaDataSourceFactory), cmcdConfigurationFactory);
        uri2.setStreamKeys(arrayList);
        builderOverrideMediaItemBuilder = ReactNativeVideoManager.INSTANCE.getInstance().overrideMediaItemBuilder(this.source, uri2);
        if (builderOverrideMediaItemBuilder != null) {
            mediaItemBuild = builderOverrideMediaItemBuilder.build();
        } else {
            mediaItemBuild = uri2.build();
        }
        mediaSourceCreateMediaSource = factory4.setDrmSessionManagerProvider(defaultDrmSessionManagerProvider).setLoadErrorHandlingPolicy(this.config.buildLoadErrorHandlingPolicy(this.source.getMinLoadRetryCount())).createMediaSource(mediaItemBuild);
        if (j < 0) {
        }
        if (j >= 0) {
            return new ClippingMediaSource(mediaSourceCreateMediaSource, 1000 * j, Long.MIN_VALUE);
        }
        if (j2 >= 0) {
            return new ClippingMediaSource(mediaSourceCreateMediaSource, 0L, j2 * 1000);
        }
        return mediaSourceCreateMediaSource;
    }

    private List<MediaItem.SubtitleConfiguration> buildSubtitleConfigurations() {
        String str;
        if (this.source.getSideLoadedTextTracks() == null || this.source.getSideLoadedTextTracks().getTracks().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (SideLoadedTextTrack sideLoadedTextTrack : this.source.getSideLoadedTextTracks().getTracks()) {
            try {
                String str2 = "external-subtitle-" + i;
                String title = sideLoadedTextTrack.getTitle();
                if (title == null || title.isEmpty()) {
                    title = "External " + (i + 1);
                    if (sideLoadedTextTrack.getLanguage() != null && !sideLoadedTextTrack.getLanguage().isEmpty()) {
                        title = title + " (" + sideLoadedTextTrack.getLanguage() + ")";
                    }
                }
                MediaItem.SubtitleConfiguration.Builder roleFlags = new MediaItem.SubtitleConfiguration.Builder(sideLoadedTextTrack.getUri()).setId(str2).setMimeType(sideLoadedTextTrack.getType()).setLabel(title).setRoleFlags(128);
                if (sideLoadedTextTrack.getLanguage() != null && !sideLoadedTextTrack.getLanguage().isEmpty()) {
                    roleFlags.setLanguage(sideLoadedTextTrack.getLanguage());
                }
                if (i == 0 && ((str = this.textTrackType) == null || "disabled".equals(str))) {
                    roleFlags.setSelectionFlags(1);
                } else {
                    roleFlags.setSelectionFlags(0);
                }
                arrayList.add(roleFlags.build());
                DebugLog.d(TAG, "Created subtitle configuration: " + str2 + " - " + title + " (" + sideLoadedTextTrack.getType() + ")");
                i++;
            } catch (Exception e) {
                DebugLog.e(TAG, "Error creating SubtitleConfiguration for URI " + sideLoadedTextTrack.getUri() + ": " + e.getMessage());
            }
        }
        if (!arrayList.isEmpty()) {
            DebugLog.d(TAG, "Built " + arrayList.size() + " external subtitle configurations");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private void releasePlayer() {
        Runnable runnable;
        if (this.player != null) {
            PlaybackServiceBinder playbackServiceBinder = this.playbackServiceBinder;
            if (playbackServiceBinder != null) {
                playbackServiceBinder.getService().unregisterPlayer(this.player);
                this.themedReactContext.unbindService(this.playbackServiceConnection);
            }
            updateResumePosition();
            this.player.release();
            this.player.removeListener(this);
            PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, false);
            Runnable runnable2 = this.pipListenerUnsubscribe;
            if (runnable2 != null) {
                runnable2.run();
            }
            this.trackSelector = null;
            ReactNativeVideoManager.INSTANCE.getInstance().onInstanceRemoved(this.instanceId, this.player);
            this.player = null;
        }
        ImaAdsLoader imaAdsLoader = this.adsLoader;
        if (imaAdsLoader != null) {
            imaAdsLoader.release();
            this.adsLoader = null;
        }
        this.progressHandler.removeMessages(1);
        this.audioBecomingNoisyReceiver.removeListener();
        this.pictureInPictureReceiver.removeListener();
        this.bandwidthMeter.removeEventListener(this);
        Handler handler = this.mainHandler;
        if (handler == null || (runnable = this.mainRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.mainRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class OnAudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        private final ThemedReactContext themedReactContext;
        private final ReactExoplayerView view;

        private OnAudioFocusChangedListener(ReactExoplayerView reactExoplayerView, ThemedReactContext themedReactContext) {
            this.view = reactExoplayerView;
            this.themedReactContext = themedReactContext;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Activity currentActivity = this.themedReactContext.getCurrentActivity();
            if (i == -2) {
                this.view.eventEmitter.onAudioFocusChanged.invoke(false);
            } else if (i == -1) {
                this.view.hasAudioFocus = false;
                this.view.eventEmitter.onAudioFocusChanged.invoke(false);
                if (currentActivity != null) {
                    final ReactExoplayerView reactExoplayerView = this.view;
                    Objects.requireNonNull(reactExoplayerView);
                    currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            reactExoplayerView.pausePlayback();
                        }
                    });
                }
                this.view.audioManager.abandonAudioFocus(this);
            } else if (i == 1) {
                this.view.hasAudioFocus = true;
                this.view.eventEmitter.onAudioFocusChanged.invoke(true);
            }
            if (this.view.player == null || currentActivity == null) {
                return;
            }
            if (i == -3) {
                if (this.view.muted) {
                    return;
                }
                currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAudioFocusChange$0();
                    }
                });
            } else {
                if (i != 1 || this.view.muted) {
                    return;
                }
                currentActivity.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$OnAudioFocusChangedListener$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAudioFocusChange$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAudioFocusChange$0() {
            this.view.player.setVolume(this.view.audioVolume * 0.8f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAudioFocusChange$1() {
            this.view.player.setVolume(this.view.audioVolume * 1.0f);
        }
    }

    private boolean requestAudioFocus() {
        return this.disableFocus || this.source.getUri() == null || this.hasAudioFocus || this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1;
    }

    private void setPlayWhenReady(boolean z) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return;
        }
        if (z) {
            boolean zRequestAudioFocus = requestAudioFocus();
            this.hasAudioFocus = zRequestAudioFocus;
            if (zRequestAudioFocus) {
                this.player.setPlayWhenReady(true);
                return;
            }
            return;
        }
        exoPlayer.setPlayWhenReady(false);
    }

    private void resumePlayback() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            if (!exoPlayer.getPlayWhenReady()) {
                setPlayWhenReady(true);
            }
            setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayback() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null && exoPlayer.getPlayWhenReady()) {
            setPlayWhenReady(false);
        }
        setKeepScreenOn(false);
    }

    private void stopPlayback() {
        onStopPlayback();
        releasePlayer();
    }

    private void onStopPlayback() {
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    }

    private void updateResumePosition() {
        this.resumeWindow = this.player.getCurrentMediaItemIndex();
        this.resumePosition = this.player.isCurrentMediaItemSeekable() ? Math.max(0L, this.player.getCurrentPosition()) : C.TIME_UNSET;
    }

    private void clearResumePosition() {
        this.resumeWindow = -1;
        this.resumePosition = C.TIME_UNSET;
    }

    private DataSource.Factory buildDataSourceFactory(boolean z) {
        return DataSourceUtil.getDefaultDataSourceFactory(this.themedReactContext, z ? this.bandwidthMeter : null, this.source.getHeaders());
    }

    private HttpDataSource.Factory buildHttpDataSourceFactory(boolean z) {
        return DataSourceUtil.getDefaultHttpDataSourceFactory(this.themedReactContext, z ? this.bandwidthMeter : null, this.source.getHeaders());
    }

    @Override // com.brentvatne.receiver.BecomingNoisyListener
    public void onAudioBecomingNoisy() {
        this.eventEmitter.onVideoAudioBecomingNoisy.invoke();
    }

    @Override // androidx.media3.common.Player.Listener
    public void onEvents(Player player, Player.Events events) {
        String str;
        String str2;
        if (events.contains(4) || events.contains(5)) {
            int playbackState = player.getPlaybackState();
            boolean playWhenReady = player.getPlayWhenReady();
            String str3 = "onStateChanged: playWhenReady=" + playWhenReady + ", playbackState=";
            this.eventEmitter.onPlaybackRateChange.invoke(Float.valueOf((playWhenReady && playbackState == 3) ? 1.0f : 0.0f));
            if (playbackState == 1) {
                str = str3 + "idle";
                this.eventEmitter.onVideoIdle.invoke();
                clearProgressMessageHandler();
                if (!player.getPlayWhenReady()) {
                    setKeepScreenOn(false);
                }
            } else {
                if (playbackState == 2) {
                    str2 = str3 + "buffering";
                    onBuffering(true);
                    clearProgressMessageHandler();
                    setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
                } else if (playbackState == 3) {
                    str = str3 + "ready";
                    this.hasVideoEnded = false;
                    this.eventEmitter.onReadyForDisplay.invoke();
                    onBuffering(false);
                    clearProgressMessageHandler();
                    startProgressHandler();
                    videoLoaded();
                    if (this.selectTrackWhenReady && this.isUsingContentResolution) {
                        this.selectTrackWhenReady = false;
                        setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
                    }
                    ExoPlayerView exoPlayerView = this.exoPlayerView;
                    if (exoPlayerView != null) {
                        exoPlayerView.showController();
                    }
                    setKeepScreenOn(this.preventsDisplaySleepDuringVideoPlayback);
                } else if (playbackState == 4) {
                    str2 = str3 + "ended";
                    updateProgress();
                    if (!this.hasVideoEnded) {
                        this.hasVideoEnded = true;
                        this.eventEmitter.onVideoEnd.invoke();
                    }
                    onStopPlayback();
                    setKeepScreenOn(false);
                } else {
                    str2 = str3 + "unknown";
                }
                DebugLog.d(TAG, str2);
            }
            str2 = str;
            DebugLog.d(TAG, str2);
        }
    }

    private void startProgressHandler() {
        this.progressHandler.sendEmptyMessage(1);
    }

    private void clearProgressMessageHandler() {
        this.progressHandler.removeMessages(1);
    }

    private void videoLoaded() {
        final int i;
        if (this.player.isPlayingAd() || !this.loadVideoStarted) {
            return;
        }
        int i2 = 0;
        this.loadVideoStarted = false;
        String str = this.audioTrackType;
        if (str != null) {
            setSelectedAudioTrack(str, this.audioTrackValue);
        }
        String str2 = this.videoTrackType;
        if (str2 != null) {
            setSelectedVideoTrack(str2, this.videoTrackValue);
        }
        String str3 = this.textTrackType;
        if (str3 != null) {
            setSelectedTextTrack(str3, this.textTrackValue);
        }
        Format videoFormat = this.player.getVideoFormat();
        boolean z = videoFormat != null && (videoFormat.rotationDegrees == 90 || videoFormat.rotationDegrees == 270);
        if (videoFormat != null) {
            i = z ? videoFormat.height : videoFormat.width;
        } else {
            i = 0;
        }
        if (videoFormat != null) {
            i2 = z ? videoFormat.width : videoFormat.height;
        }
        final int i3 = i2;
        final String str4 = videoFormat != null ? videoFormat.id : null;
        final long duration = this.player.getDuration();
        final long currentPosition = this.player.getCurrentPosition();
        final ArrayList<Track> audioTrackInfo = getAudioTrackInfo();
        final ArrayList<Track> textTrackInfo = getTextTrackInfo();
        if (this.source.getContentStartTime() != -1) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$videoLoaded$11(duration, currentPosition, i, i3, audioTrackInfo, textTrackInfo, str4);
                }
            });
            return;
        }
        this.eventEmitter.onVideoLoad.invoke(Long.valueOf(duration), Long.valueOf(currentPosition), Integer.valueOf(i), Integer.valueOf(i3), audioTrackInfo, textTrackInfo, getVideoTrackInfo(), str4);
        updateSubtitleButtonVisibility();
        refreshControlsStyles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$videoLoaded$11(long j, long j2, int i, int i2, ArrayList arrayList, ArrayList arrayList2, String str) {
        ArrayList<VideoTrack> videoTrackInfoFromManifest = getVideoTrackInfoFromManifest();
        if (videoTrackInfoFromManifest != null) {
            this.isUsingContentResolution = true;
        }
        this.eventEmitter.onVideoLoad.invoke(Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), arrayList, arrayList2, videoTrackInfoFromManifest, str);
        updateSubtitleButtonVisibility();
    }

    private static boolean isTrackSelected(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return (trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true;
    }

    private ArrayList<Track> getAudioTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
            int trackRendererIndex = getTrackRendererIndex(1);
            if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                TrackSelection trackSelection = this.player.getCurrentTrackSelections().get(1);
                for (int i = 0; i < trackGroups.length; i++) {
                    TrackGroup trackGroup = trackGroups.get(i);
                    Format format = trackGroup.getFormat(0);
                    boolean z = trackSelection != null && trackSelection.getTrackGroup() == trackGroup;
                    Track trackExoplayerTrackToGenericTrack = exoplayerTrackToGenericTrack(format, i, trackSelection, trackGroup);
                    trackExoplayerTrackToGenericTrack.setBitrate(format.bitrate == -1 ? 0 : format.bitrate);
                    trackExoplayerTrackToGenericTrack.setSelected(z);
                    arrayList.add(trackExoplayerTrackToGenericTrack);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoTrack exoplayerVideoTrackToGenericVideoTrack(Format format, int i) {
        VideoTrack videoTrack = new VideoTrack();
        videoTrack.setWidth(format.width == -1 ? 0 : format.width);
        videoTrack.setHeight(format.height == -1 ? 0 : format.height);
        videoTrack.setBitrate(format.bitrate != -1 ? format.bitrate : 0);
        videoTrack.setRotation(format.rotationDegrees);
        if (format.codecs != null) {
            videoTrack.setCodecs(format.codecs);
        }
        videoTrack.setTrackId(format.id == null ? String.valueOf(i) : format.id);
        videoTrack.setIndex(i);
        return videoTrack;
    }

    private ArrayList<VideoTrack> getVideoTrackInfo() {
        ArrayList<VideoTrack> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
            int trackRendererIndex = getTrackRendererIndex(2);
            if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                for (int i = 0; i < trackGroups.length; i++) {
                    TrackGroup trackGroup = trackGroups.get(i);
                    for (int i2 = 0; i2 < trackGroup.length; i2++) {
                        Format format = trackGroup.getFormat(i2);
                        if (isFormatSupported(format)) {
                            arrayList.add(exoplayerVideoTrackToGenericVideoTrack(format, i2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<VideoTrack> getVideoTrackInfoFromManifest() {
        return getVideoTrackInfoFromManifest(0);
    }

    private ArrayList<VideoTrack> getVideoTrackInfoFromManifest(int i) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            ArrayList<VideoTrack> arrayList = (ArrayList) executorServiceNewSingleThreadExecutor.submit(new Callable(this.mediaDataSourceFactory.createDataSource(), this.source.getUri(), (this.source.getContentStartTime() * 1000) - 100) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.3
                final DataSource ds;
                final long startTimeUs;
                final Uri uri;
                final /* synthetic */ DataSource val$dataSource;
                final /* synthetic */ Uri val$sourceUri;
                final /* synthetic */ long val$startTime;

                {
                    this.val$dataSource = dataSource;
                    this.val$sourceUri = uri;
                    this.val$startTime = j;
                    this.ds = dataSource;
                    this.uri = uri;
                    this.startTimeUs = j * 1000;
                }

                @Override // java.util.concurrent.Callable
                public ArrayList<VideoTrack> call() {
                    int i2;
                    ArrayList<VideoTrack> arrayList2 = new ArrayList<>();
                    try {
                        DashManifest dashManifestLoadManifest = DashUtil.loadManifest(this.ds, this.uri);
                        int periodCount = dashManifestLoadManifest.getPeriodCount();
                        int i3 = 0;
                        while (i3 < periodCount) {
                            Period period = dashManifestLoadManifest.getPeriod(i3);
                            int i4 = 0;
                            while (i4 < period.adaptationSets.size()) {
                                AdaptationSet adaptationSet = period.adaptationSets.get(i4);
                                if (adaptationSet.type != 2) {
                                    i2 = i3;
                                } else {
                                    int i5 = 0;
                                    boolean z = false;
                                    while (true) {
                                        if (i5 >= adaptationSet.representations.size()) {
                                            i2 = i3;
                                            break;
                                        }
                                        Representation representation = adaptationSet.representations.get(i5);
                                        Format format = representation.format;
                                        if (ReactExoplayerView.this.isFormatSupported(format)) {
                                            i2 = i3;
                                            if (representation.presentationTimeOffsetUs <= this.startTimeUs) {
                                                break;
                                            }
                                            arrayList2.add(ReactExoplayerView.this.exoplayerVideoTrackToGenericVideoTrack(format, i5));
                                            z = true;
                                        } else {
                                            i2 = i3;
                                        }
                                        i5++;
                                        i3 = i2;
                                    }
                                    if (z) {
                                        return arrayList2;
                                    }
                                }
                                i4++;
                                i3 = i2;
                            }
                            i3++;
                        }
                        return null;
                    } catch (Exception e) {
                        DebugLog.w(ReactExoplayerView.TAG, "error in getVideoTrackInfoFromManifest:" + e.getMessage());
                        return null;
                    }
                }
            }).get(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
            if (arrayList == null && i < 1) {
                return getVideoTrackInfoFromManifest(i + 1);
            }
            executorServiceNewSingleThreadExecutor.shutdown();
            return arrayList;
        } catch (Exception e) {
            DebugLog.w(TAG, "error in getVideoTrackInfoFromManifest handling request:" + e.getMessage());
            return null;
        }
    }

    private Track exoplayerTrackToGenericTrack(Format format, int i, TrackSelection trackSelection, TrackGroup trackGroup) {
        Track track = new Track();
        track.setIndex(i);
        if (format.sampleMimeType != null) {
            track.setMimeType(format.sampleMimeType);
        }
        if (format.language != null) {
            track.setLanguage(format.language);
        }
        if (format.label != null) {
            track.setTitle(format.label);
        }
        track.setSelected(isTrackSelected(trackSelection, trackGroup, i));
        return track;
    }

    private ArrayList<Track> getTextTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
            int trackRendererIndex = getTrackRendererIndex(3);
            if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
                TrackSelection trackSelection = this.player.getCurrentTrackSelections().get(3);
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                for (int i = 0; i < trackGroups.length; i++) {
                    TrackGroup trackGroup = trackGroups.get(i);
                    for (int i2 = 0; i2 < trackGroup.length; i2++) {
                        Format format = trackGroup.getFormat(i2);
                        Track trackExoplayerTrackToGenericTrack = exoplayerTrackToGenericTrack(format, i2, trackSelection, trackGroup);
                        boolean z = format.id != null && format.id.startsWith("external-subtitle-");
                        isTrackSelected(trackSelection, trackGroup, i2);
                        trackExoplayerTrackToGenericTrack.setIndex(arrayList.size());
                        if (trackExoplayerTrackToGenericTrack.getTitle() == null || trackExoplayerTrackToGenericTrack.getTitle().isEmpty()) {
                            if (z) {
                                trackExoplayerTrackToGenericTrack.setTitle("External " + (i2 + 1));
                            } else {
                                trackExoplayerTrackToGenericTrack.setTitle("Track " + (arrayList.size() + 1));
                            }
                        }
                        arrayList.add(trackExoplayerTrackToGenericTrack);
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<Track> getBasicAudioTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
            int trackRendererIndex = getTrackRendererIndex(1);
            if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                for (int i = 0; i < trackGroups.length; i++) {
                    Format format = trackGroups.get(i).getFormat(0);
                    Track track = new Track();
                    track.setIndex(i);
                    track.setLanguage(format.language != null ? format.language : "unknown");
                    track.setTitle(format.label != null ? format.label : "Track " + (i + 1));
                    track.setSelected(false);
                    if (format.sampleMimeType != null) {
                        track.setMimeType(format.sampleMimeType);
                    }
                    track.setBitrate(format.bitrate == -1 ? 0 : format.bitrate);
                    arrayList.add(track);
                }
                DebugLog.d(TAG, "getBasicAudioTrackInfo: returning " + arrayList.size() + " audio tracks (no selection status)");
            }
        }
        return arrayList;
    }

    private ArrayList<Track> getBasicTextTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo();
            int trackRendererIndex = getTrackRendererIndex(3);
            if (currentMappedTrackInfo != null && trackRendererIndex != -1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                for (int i = 0; i < trackGroups.length; i++) {
                    TrackGroup trackGroup = trackGroups.get(i);
                    for (int i2 = 0; i2 < trackGroup.length; i2++) {
                        Format format = trackGroup.getFormat(i2);
                        Track track = new Track();
                        track.setIndex(arrayList.size());
                        if (format.sampleMimeType != null) {
                            track.setMimeType(format.sampleMimeType);
                        }
                        if (format.language != null) {
                            track.setLanguage(format.language);
                        }
                        boolean z = format.id != null && format.id.startsWith("external-subtitle-");
                        if (format.label != null && !format.label.isEmpty()) {
                            track.setTitle(format.label);
                        } else if (z) {
                            track.setTitle("External " + (i2 + 1));
                        } else {
                            track.setTitle("Track " + (arrayList.size() + 1));
                        }
                        track.setSelected(false);
                        arrayList.add(track);
                    }
                }
            }
        }
        return arrayList;
    }

    private void onBuffering(boolean z) {
        if (this.isBuffering == z) {
            return;
        }
        if (this.isPaused && this.isSeeking && !z) {
            this.eventEmitter.onVideoSeek.invoke(Long.valueOf(this.player.getCurrentPosition()), Long.valueOf(this.seekPosition));
            this.isSeeking = false;
        }
        this.isBuffering = z;
        this.eventEmitter.onVideoBuffer.invoke(Boolean.valueOf(z));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        if (i == 1) {
            this.isSeeking = true;
            this.seekPosition = positionInfo2.positionMs;
            if (this.isUsingContentResolution) {
                setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
            }
        }
        if (this.playerNeedsSource) {
            updateResumePosition();
        }
        if (this.isUsingContentResolution) {
            setSelectedTrack(2, this.videoTrackType, this.videoTrackValue);
            this.selectTrackWhenReady = true;
        }
        if (i == 0 && this.player.getRepeatMode() == 1) {
            updateProgress();
            if (this.hasVideoEnded) {
                return;
            }
            this.hasVideoEnded = true;
            this.eventEmitter.onVideoEnd.invoke();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTracksChanged(Tracks tracks) {
        DebugLog.d(TAG, "onTracksChanged called - updating track information, controls=" + this.controls);
        if (this.controls) {
            ArrayList<Track> basicTextTrackInfo = getBasicTextTrackInfo();
            ArrayList<Track> basicAudioTrackInfo = getBasicAudioTrackInfo();
            ArrayList<VideoTrack> videoTrackInfo = getVideoTrackInfo();
            this.eventEmitter.onTextTracks.invoke(basicTextTrackInfo);
            this.eventEmitter.onAudioTracks.invoke(basicAudioTrackInfo);
            this.eventEmitter.onVideoTracks.invoke(videoTrackInfo);
        } else {
            ArrayList<Track> textTrackInfo = getTextTrackInfo();
            ArrayList<Track> audioTrackInfo = getAudioTrackInfo();
            ArrayList<VideoTrack> videoTrackInfo2 = getVideoTrackInfo();
            this.eventEmitter.onTextTracks.invoke(textTrackInfo);
            this.eventEmitter.onAudioTracks.invoke(audioTrackInfo);
            this.eventEmitter.onVideoTracks.invoke(videoTrackInfo2);
            Iterator<Track> it = audioTrackInfo.iterator();
            while (it.hasNext()) {
                it.next().getIsSelected();
            }
        }
        updateSubtitleButtonVisibility();
    }

    private boolean hasBuiltInTextTracks() {
        DefaultTrackSelector defaultTrackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        int trackRendererIndex;
        if (this.player == null || (defaultTrackSelector = this.trackSelector) == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null || (trackRendererIndex = getTrackRendererIndex(3)) == -1) {
            return false;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
        for (int i = 0; i < trackGroups.length; i++) {
            TrackGroup trackGroup = trackGroups.get(i);
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                if (format.id == null || !format.id.startsWith("external-subtitle-")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void updateSubtitleButtonVisibility() {
        if (this.exoPlayerView == null) {
            return;
        }
        this.exoPlayerView.setShowSubtitleButton(!(this.source.getSideLoadedTextTracks() == null || this.source.getSideLoadedTextTracks().getTracks().isEmpty()) || hasBuiltInTextTracks());
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.eventEmitter.onPlaybackRateChange.invoke(Float.valueOf(playbackParameters.speed));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVolumeChanged(float f) {
        this.eventEmitter.onVolumeChange.invoke(Float.valueOf(f));
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        if (z && this.isSeeking) {
            this.eventEmitter.onVideoSeek.invoke(Long.valueOf(this.player.getCurrentPosition()), Long.valueOf(this.seekPosition));
        }
        PictureInPictureUtil.applyPlayingStatus(this.themedReactContext, this.pictureInPictureParamsBuilder, this.pictureInPictureReceiver, !z);
        this.eventEmitter.onVideoPlaybackStateChanged.invoke(Boolean.valueOf(z), Boolean.valueOf(this.isSeeking));
        if (z) {
            this.isSeeking = false;
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException playbackException) {
        String str = "ExoPlaybackException: " + PlaybackException.getErrorCodeName(playbackException.errorCode);
        String str2 = ExifInterface.GPS_MEASUREMENT_2D + playbackException.errorCode;
        int i = playbackException.errorCode;
        if ((i == 6000 || i == 6002 || i == 6004 || i == 6006 || i == 6007) && !this.hasDrmFailed) {
            this.hasDrmFailed = true;
            this.playerNeedsSource = true;
            updateResumePosition();
            initializePlayer();
            setPlayWhenReady(true);
            return;
        }
        this.eventEmitter.onVideoError.invoke(str, playbackException, str2);
        this.playerNeedsSource = true;
        if (isBehindLiveWindow(playbackException)) {
            clearResumePosition();
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.seekToDefaultPosition();
                this.player.prepare();
                return;
            }
            return;
        }
        updateResumePosition();
    }

    private static boolean isBehindLiveWindow(PlaybackException playbackException) {
        return playbackException.errorCode == 1002;
    }

    public int getTrackRendererIndex(int i) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null) {
            return -1;
        }
        int rendererCount = exoPlayer.getRendererCount();
        for (int i2 = 0; i2 < rendererCount; i2++) {
            if (this.player.getRendererType(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onMetadata(Metadata metadata) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) metadata.get(i);
                if (!(id3Frame instanceof TextInformationFrame)) {
                    str = "";
                } else {
                    str = ((TextInformationFrame) id3Frame).value;
                }
                arrayList.add(new TimedMetadata(id3Frame.id, str));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                arrayList.add(new TimedMetadata(eventMessage.schemeIdUri, eventMessage.value));
            } else {
                DebugLog.d(TAG, "unhandled metadata " + entry);
            }
        }
        this.eventEmitter.onTimedMetadata.invoke(arrayList);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onCues(CueGroup cueGroup) {
        if (cueGroup.cues.isEmpty() || cueGroup.cues.get(0).text == null) {
            return;
        }
        this.eventEmitter.onTextTrackDataChanged.invoke(cueGroup.cues.get(0).text.toString());
    }

    public void setSrc(Source source) {
        if (source.getUri() != null) {
            clearResumePosition();
            boolean zIsEquals = source.isEquals(this.source);
            this.hasDrmFailed = false;
            this.source = source;
            DataSource.Factory defaultDataSourceFactory = DataSourceUtil.getDefaultDataSourceFactory(this.themedReactContext, this.bandwidthMeter, source.getHeaders());
            this.mediaDataSourceFactory = (DataSource.Factory) Utils$$ExternalSyntheticBackport0.m(ReactNativeVideoManager.INSTANCE.getInstance().overrideMediaDataSourceFactory(source, defaultDataSourceFactory), defaultDataSourceFactory);
            if (source.getCmcdProps() != null) {
                setCmcdConfigurationFactory(new CMCDConfig(source.getCmcdProps()).toCmcdConfigurationFactory());
            } else {
                setCmcdConfigurationFactory(null);
            }
            if (zIsEquals) {
                return;
            }
            this.hasVideoEnded = false;
            this.playerNeedsSource = true;
            initializePlayer();
            return;
        }
        clearSrc();
    }

    public void clearSrc() {
        ExoPlayer exoPlayer;
        if (this.source.getUri() != null && (exoPlayer = this.player) != null) {
            exoPlayer.stop();
            this.player.clearMediaItems();
        }
        this.source = new Source();
        this.mediaDataSourceFactory = null;
        clearResumePosition();
    }

    public void setProgressUpdateInterval(float f) {
        this.mProgressUpdateInterval = f;
    }

    public void setReportBandwidth(boolean z) {
        this.mReportBandwidth = z;
    }

    public void setResizeModeModifier(int i) {
        ExoPlayerView exoPlayerView = this.exoPlayerView;
        if (exoPlayerView != null) {
            exoPlayerView.setResizeMode(i);
        }
    }

    private void applyModifiers() {
        setRepeatModifier(this.repeat);
        setMutedModifier(this.muted);
    }

    public void setRepeatModifier(boolean z) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            if (z) {
                exoPlayer.setRepeatMode(1);
            } else {
                exoPlayer.setRepeatMode(0);
            }
        }
        this.repeat = z;
    }

    public void setPreventsDisplaySleepDuringVideoPlayback(boolean z) {
        this.preventsDisplaySleepDuringVideoPlayback = z;
    }

    public void disableTrack(int i) {
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return;
        }
        this.trackSelector.setParameters(defaultTrackSelector.getParameters().buildUpon().setRendererDisabled(i, true).build());
    }

    private void selectTextTrackInternal(String str, String str2) {
        int trackRendererIndex;
        if (this.player == null || this.trackSelector == null) {
            return;
        }
        DebugLog.d(TAG, "selectTextTrackInternal: type=" + str + ", value=" + str2);
        DefaultTrackSelector.Parameters.Builder builderBuildUpon = this.trackSelector.getParameters().buildUpon();
        if ("disabled".equals(str) || str2 == null) {
            builderBuildUpon.setTrackTypeDisabled(3, true);
        } else {
            builderBuildUpon.setTrackTypeDisabled(3, false);
            builderBuildUpon.clearOverridesOfType(3);
            MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
            if (currentMappedTrackInfo != null && (trackRendererIndex = getTrackRendererIndex(3)) != -1) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
                boolean z = false;
                for (int i = 0; i < trackGroups.length; i++) {
                    TrackGroup trackGroup = trackGroups.get(i);
                    int i2 = 0;
                    while (i2 < trackGroup.length) {
                        Format format = trackGroup.getFormat(i2);
                        if (("language".equals(str) && format.language != null && format.language.equals(str2)) || ("title".equals(str) && format.label != null && format.label.equals(str2)) || (FirebaseAnalytics.Param.INDEX.equals(str) && ReactBridgeUtils.safeParseInt(str2, -1) == i2)) {
                            builderBuildUpon.addOverride(new TrackSelectionOverride(trackGroup, (List<Integer>) Arrays.asList(Integer.valueOf(i2))));
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    DebugLog.w(TAG, "Text track not found for type=" + str + ", value=" + str2 + ". Keeping current selection.");
                }
            }
        }
        try {
            this.trackSelector.setParameters(builderBuildUpon.build());
            this.mainHandler.postDelayed(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$selectTextTrackInternal$12();
                }
            }, 100L);
        } catch (Exception e) {
            DebugLog.e(TAG, "Error setting text track parameters: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectTextTrackInternal$12() {
        if (this.exoPlayerView != null) {
            updateSubtitleButtonVisibility();
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0180  */
    /* JADX WARN: Code duplicated, block: B:35:0x007c A[EDGE_INSN: B:35:0x007c->B:122:0x01ae BREAK  A[LOOP:0: B:27:0x005f->B:34:0x0079]] */
    /* JADX WARN: Code duplicated, block: B:86:0x012d A[PHI: r21
  0x012d: PHI (r21v7 int) = (r21v6 int), (r21v8 int) binds: [B:85:0x012b, B:82:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    public void setSelectedTrack(int i, String str, String str2) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        int groupIndexForDefaultLocale;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        if (this.player == null || this.trackSelector == null || this.controls) {
            return;
        }
        int trackRendererIndex = getTrackRendererIndex(i);
        int i7 = -1;
        if (trackRendererIndex == -1 || (currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(trackRendererIndex);
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        arrayList.add(0);
        String str3 = TextUtils.isEmpty(str) ? Constants.COLLATION_DEFAULT : str;
        if ("disabled".equals(str3)) {
            disableTrack(trackRendererIndex);
            return;
        }
        if ("language".equals(str3)) {
            groupIndexForDefaultLocale = 0;
            while (true) {
                if (groupIndexForDefaultLocale >= trackGroups.length) {
                    groupIndexForDefaultLocale = -1;
                    break;
                }
                Format format = trackGroups.get(groupIndexForDefaultLocale).getFormat(0);
                if (format.language != null && format.language.equals(str2)) {
                    break;
                } else {
                    groupIndexForDefaultLocale++;
                }
            }
        } else if ("title".equals(str3)) {
            groupIndexForDefaultLocale = 0;
            while (true) {
                if (groupIndexForDefaultLocale >= trackGroups.length) {
                    groupIndexForDefaultLocale = -1;
                    break;
                }
                Format format2 = trackGroups.get(groupIndexForDefaultLocale).getFormat(0);
                if (format2.label != null && format2.label.equals(str2)) {
                    break;
                } else {
                    groupIndexForDefaultLocale++;
                }
            }
        } else if (FirebaseAnalytics.Param.INDEX.equals(str3)) {
            int iSafeParseInt = ReactBridgeUtils.safeParseInt(str2, -1);
            if (iSafeParseInt == -1) {
                groupIndexForDefaultLocale = -1;
                break;
            }
            if (i == 2 && trackGroups.length == 1) {
                if (iSafeParseInt < trackGroups.get(0).length) {
                    arrayList.set(0, Integer.valueOf(iSafeParseInt));
                }
                groupIndexForDefaultLocale = 0;
            } else {
                if (iSafeParseInt >= trackGroups.length) {
                    groupIndexForDefaultLocale = -1;
                    break;
                }
                groupIndexForDefaultLocale = iSafeParseInt;
            }
        } else if ("resolution".equals(str3)) {
            int iSafeParseInt2 = ReactBridgeUtils.safeParseInt(str2, -1);
            if (iSafeParseInt2 != -1) {
                int i9 = -1;
                int i10 = 0;
                while (i10 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i10);
                    Format format3 = null;
                    int i11 = i7;
                    int i12 = i8;
                    Format format4 = null;
                    while (true) {
                        if (i12 >= trackGroup.length) {
                            i2 = i10;
                            format3 = format4;
                            i3 = i11;
                            z = false;
                            break;
                        }
                        Format format5 = trackGroup.getFormat(i12);
                        if (format5.height == iSafeParseInt2) {
                            arrayList.set(0, Integer.valueOf(i12));
                            i2 = i10;
                            i9 = i2;
                            z = true;
                            i3 = -1;
                            break;
                        }
                        if (!this.isUsingContentResolution) {
                            i4 = i10;
                        } else if (format4 != null) {
                            i4 = i10;
                            if ((format5.bitrate > format4.bitrate || format5.height > format4.height) && format5.height < iSafeParseInt2) {
                                format4 = format5;
                                i11 = i12;
                            }
                        } else {
                            i4 = i10;
                            if (format5.height < iSafeParseInt2) {
                                format4 = format5;
                                i11 = i12;
                            }
                        }
                        i12++;
                        i10 = i4;
                    }
                    if (format3 == null && this.isUsingContentResolution && !z) {
                        int i13 = Integer.MAX_VALUE;
                        for (int i14 = 0; i14 < trackGroup.length; i14++) {
                            Format format6 = trackGroup.getFormat(i14);
                            if (format6.height < i13) {
                                i13 = format6.height;
                                arrayList.set(0, Integer.valueOf(i14));
                                i9 = i2;
                            }
                        }
                    }
                    if (format3 != null && i3 != -1) {
                        arrayList.set(0, Integer.valueOf(i3));
                        i9 = i2;
                    }
                    i10 = i2 + 1;
                    i7 = -1;
                    i8 = 0;
                }
                groupIndexForDefaultLocale = i9;
            } else {
                groupIndexForDefaultLocale = -1;
            }
            i7 = -1;
        } else {
            if (i == 3 && Util.SDK_INT > 18) {
                CaptioningManager captioningManager = (CaptioningManager) this.themedReactContext.getSystemService("captioning");
                if (captioningManager == null || !captioningManager.isEnabled()) {
                    groupIndexForDefaultLocale = -1;
                } else {
                    groupIndexForDefaultLocale = getGroupIndexForDefaultLocale(trackGroups);
                }
            } else if (i == 1) {
                groupIndexForDefaultLocale = getGroupIndexForDefaultLocale(trackGroups);
            } else {
                i7 = -1;
                groupIndexForDefaultLocale = -1;
            }
            i7 = -1;
        }
        if (groupIndexForDefaultLocale == i7 && i == 2 && trackGroups.length != 0) {
            TrackGroup trackGroup2 = trackGroups.get(0);
            arrayList = new ArrayList(trackGroup2.length);
            for (int i15 = 0; i15 < trackGroup2.length; i15++) {
                arrayList.add(Integer.valueOf(i15));
            }
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                if (isFormatSupported(trackGroup2.getFormat(i17))) {
                    i16++;
                }
            }
            if (arrayList.size() != 1) {
                ArrayList arrayList2 = new ArrayList(i16 + 1);
                for (int i18 = 0; i18 < arrayList.size(); i18++) {
                    if (isFormatSupported(trackGroup2.getFormat(i18))) {
                        arrayList2.add((Integer) arrayList.get(i18));
                    }
                }
                arrayList = arrayList2;
            }
            i6 = -1;
            i5 = 0;
        } else {
            i5 = groupIndexForDefaultLocale;
            i6 = -1;
        }
        if (i5 == i6) {
            disableTrack(trackRendererIndex);
            return;
        }
        try {
            TrackSelectionOverride trackSelectionOverride = new TrackSelectionOverride(trackGroups.get(i5), arrayList);
            DefaultTrackSelector.Parameters.Builder rendererDisabled = this.trackSelector.getParameters().buildUpon().setExceedAudioConstraintsIfNecessary(true).setExceedRendererCapabilitiesIfNecessary(true).setExceedVideoConstraintsIfNecessary(true).setRendererDisabled(trackRendererIndex, false);
            if (i != 1 || !str3.equals(Constants.COLLATION_DEFAULT)) {
                rendererDisabled.clearOverridesOfType(trackSelectionOverride.getType());
            }
            if (i == 2 && isUsingVideoABR()) {
                int i19 = this.maxBitRate;
                rendererDisabled.setMaxVideoBitrate(i19 == 0 ? Integer.MAX_VALUE : i19);
            } else {
                rendererDisabled.addOverride(trackSelectionOverride);
            }
            if (i == 1) {
                rendererDisabled.setForceHighestSupportedBitrate(false);
                rendererDisabled.setForceLowestBitrate(false);
                DebugLog.d(TAG, "Audio track selection: group=" + i5 + ", tracks=" + arrayList + ", override=" + trackSelectionOverride);
            }
            this.trackSelector.setParameters(rendererDisabled.build());
            DebugLog.d(TAG, "Applied track selection for type: " + i + ", group: " + i5);
        } catch (Exception e) {
            DebugLog.e(TAG, "Error applying track selection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormatSupported(Format format) {
        int i = format.width == -1 ? 0 : format.width;
        int i2 = format.height == -1 ? 0 : format.height;
        float f = format.frameRate == -1.0f ? 0.0f : format.frameRate;
        String str = format.sampleMimeType;
        if (str == null) {
            return true;
        }
        try {
            return MediaCodecUtil.getDecoderInfo(str, false, false).isVideoSizeAndRateSupportedV21(i, i2, f);
        } catch (Exception unused) {
            return true;
        }
    }

    private int getGroupIndexForDefaultLocale(TrackGroupArray trackGroupArray) {
        if (trackGroupArray.length == 0) {
            return -1;
        }
        String language = Locale.getDefault().getLanguage();
        String iSO3Language = Locale.getDefault().getISO3Language();
        for (int i = 0; i < trackGroupArray.length; i++) {
            String str = trackGroupArray.get(i).getFormat(0).language;
            if (str != null && (str.equals(language) || str.equals(iSO3Language))) {
                return i;
            }
        }
        return 0;
    }

    public void setSelectedVideoTrack(String str, String str2) {
        this.videoTrackType = str;
        this.videoTrackValue = str2;
        if (this.loadVideoStarted) {
            return;
        }
        setSelectedTrack(2, str, str2);
    }

    public void setSelectedAudioTrack(String str, String str2) {
        this.audioTrackType = str;
        this.audioTrackValue = str2;
        if (this.controls || this.player == null || this.trackSelector == null) {
            return;
        }
        setSelectedTrack(1, str, str2);
    }

    public void setSelectedTextTrack(String str, String str2) {
        this.textTrackType = str;
        this.textTrackValue = str2;
        selectTextTrackInternal(str, str2);
    }

    public void setPausedModifier(boolean z) {
        this.isPaused = z;
        if (this.player != null) {
            if (!z) {
                resumePlayback();
            } else {
                pausePlayback();
            }
        }
    }

    public void setEnterPictureInPictureOnLeave(boolean z) {
        this.enterPictureInPictureOnLeave = z;
        if (this.player != null) {
            PictureInPictureUtil.applyAutoEnterEnabled(this.themedReactContext, this.pictureInPictureParamsBuilder, z);
        }
    }

    protected void setIsInPictureInPicture(boolean z) {
        this.eventEmitter.onPictureInPictureStatusChanged.invoke(Boolean.valueOf(z));
        FullScreenPlayerView fullScreenPlayerView = this.fullScreenPlayerView;
        if (fullScreenPlayerView != null && fullScreenPlayerView.isShowing()) {
            if (z) {
                this.fullScreenPlayerView.hideWithoutPlayer();
                return;
            }
            return;
        }
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            ViewGroup viewGroup2 = (ViewGroup) this.exoPlayerView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.exoPlayerView);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) != this.exoPlayerView) {
                    this.rootViewChildrenOriginalVisibility.add(Integer.valueOf(viewGroup.getChildAt(i).getVisibility()));
                    viewGroup.getChildAt(i).setVisibility(8);
                }
            }
            viewGroup.addView(this.exoPlayerView, layoutParams);
            return;
        }
        viewGroup.removeView(this.exoPlayerView);
        if (this.rootViewChildrenOriginalVisibility.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            viewGroup.getChildAt(i2).setVisibility(this.rootViewChildrenOriginalVisibility.get(i2).intValue());
        }
        addView(this.exoPlayerView, 0, layoutParams);
        reLayoutControls();
    }

    public void enterPictureInPictureMode() {
        PictureInPictureParams pictureInPictureParamsBuild;
        if (Build.VERSION.SDK_INT >= 26) {
            this.pictureInPictureParamsBuilder.setActions(PictureInPictureUtil.getPictureInPictureActions(this.themedReactContext, this.isPaused, this.pictureInPictureReceiver));
            if (this.player.getPlaybackState() == 3) {
                this.pictureInPictureParamsBuilder.setAspectRatio(PictureInPictureUtil.calcPictureInPictureAspectRatio(this.player));
            }
            pictureInPictureParamsBuild = this.pictureInPictureParamsBuilder.build();
        } else {
            pictureInPictureParamsBuild = null;
        }
        PictureInPictureUtil.enterPictureInPictureMode(this.themedReactContext, pictureInPictureParamsBuild);
    }

    public void exitPictureInPictureMode() {
        Activity currentActivity = this.themedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        if (!this.rootViewChildrenOriginalVisibility.isEmpty()) {
            if (this.exoPlayerView.getParent().equals(viewGroup)) {
                viewGroup.removeView(this.exoPlayerView);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).setVisibility(this.rootViewChildrenOriginalVisibility.get(i).intValue());
            }
            this.rootViewChildrenOriginalVisibility.clear();
        }
        if (currentActivity.isInPictureInPictureMode()) {
            currentActivity.moveTaskToBack(false);
        }
    }

    public void setMutedModifier(boolean z) {
        this.muted = z;
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setVolume(z ? 0.0f : this.audioVolume);
        }
    }

    private void changeAudioOutput(AudioOutput audioOutput) {
        if (this.player != null) {
            int streamType = audioOutput.getStreamType();
            this.player.setAudioAttributes(new AudioAttributes.Builder().setUsage(Util.getAudioUsageForStreamType(streamType)).setContentType(Util.getAudioContentTypeForStreamType(streamType)).build(), false);
            AudioManager audioManager = (AudioManager) this.themedReactContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            boolean z = audioOutput == AudioOutput.SPEAKER;
            audioManager.setMode(z ? 0 : 3);
            audioManager.setSpeakerphoneOn(z);
        }
    }

    public void setAudioOutput(AudioOutput audioOutput) {
        if (this.audioOutput != audioOutput) {
            this.audioOutput = audioOutput;
            changeAudioOutput(audioOutput);
        }
    }

    public void setVolumeModifier(float f) {
        this.audioVolume = f;
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setVolume(f);
        }
    }

    public void seekTo(long j) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(j);
        }
    }

    public void setRateModifier(float f) {
        if (f <= 0.0f) {
            DebugLog.w(TAG, "cannot set rate <= 0");
            return;
        }
        this.rate = f;
        if (this.player != null) {
            this.player.setPlaybackParameters(new PlaybackParameters(this.rate, 1.0f));
        }
    }

    public void setMaxBitRateModifier(int i) {
        this.maxBitRate = i;
        if (this.player == null || !isUsingVideoABR()) {
            return;
        }
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        DefaultTrackSelector.Parameters.Builder builderBuildUponParameters = defaultTrackSelector.buildUponParameters();
        int i2 = this.maxBitRate;
        if (i2 == 0) {
            i2 = Integer.MAX_VALUE;
        }
        defaultTrackSelector.setParameters(builderBuildUponParameters.setMaxVideoBitrate(i2));
    }

    public void setPlayInBackground(boolean z) {
        this.playInBackground = z;
    }

    public void setDisableFocus(boolean z) {
        this.disableFocus = z;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.focusable = z;
        this.exoPlayerView.setFocusable(z);
    }

    public void setShowNotificationControls(boolean z) {
        this.showNotificationControls = z;
        ServiceConnection serviceConnection = this.playbackServiceConnection;
        if (serviceConnection == null && z) {
            setupPlaybackService();
        } else {
            if (z || serviceConnection == null) {
                return;
            }
            cleanupPlaybackService();
        }
    }

    public void setBufferingStrategy(BufferingStrategy.BufferingStrategyEnum bufferingStrategyEnum) {
        this.bufferingStrategy = bufferingStrategyEnum;
    }

    public boolean getPreventsDisplaySleepDuringVideoPlayback() {
        return this.preventsDisplaySleepDuringVideoPlayback;
    }

    public void setDisableDisconnectError(boolean z) {
        this.disableDisconnectError = z;
    }

    public void setFullscreen(boolean z) {
        if (z == this.isFullscreen) {
            return;
        }
        this.isFullscreen = z;
        if (this.themedReactContext.getCurrentActivity() == null) {
            return;
        }
        if (this.isFullscreen) {
            this.fullScreenPlayerView = new FullScreenPlayerView(getContext(), this.exoPlayerView, this, null, new OnBackPressedCallback(true) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.4
                @Override // androidx.activity.OnBackPressedCallback
                public void handleOnBackPressed() {
                    ReactExoplayerView.this.setFullscreen(false);
                }
            }, this.controlsConfig);
            this.eventEmitter.onVideoFullscreenPlayerWillPresent.invoke();
            FullScreenPlayerView fullScreenPlayerView = this.fullScreenPlayerView;
            if (fullScreenPlayerView != null) {
                fullScreenPlayerView.show();
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFullscreen$13();
                }
            });
            return;
        }
        this.eventEmitter.onVideoFullscreenPlayerWillDismiss.invoke();
        FullScreenPlayerView fullScreenPlayerView2 = this.fullScreenPlayerView;
        if (fullScreenPlayerView2 != null) {
            fullScreenPlayerView2.dismiss();
            reLayoutControls();
            setControls(this.controls);
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.brentvatne.exoplayer.ReactExoplayerView$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setFullscreen$14();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFullscreen$13() {
        this.eventEmitter.onVideoFullscreenPlayerDidPresent.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFullscreen$14() {
        this.eventEmitter.onVideoFullscreenPlayerDidDismiss.invoke();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysLoaded");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        DebugLog.d("DRM Info", "onDrmSessionAcquired");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmSessionReleased");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        DebugLog.d("DRM Info", "onDrmSessionManagerError");
        this.eventEmitter.onVideoError.invoke("onDrmSessionManagerError", exc, "3002");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysRestored");
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.d("DRM Info", "onDrmKeysRemoved");
    }

    public void setControls(boolean z) {
        this.controls = z;
        ExoPlayerView exoPlayerView = this.exoPlayerView;
        if (exoPlayerView != null) {
            exoPlayerView.setUseController(z);
            if (z) {
                this.exoPlayerView.setControllerAutoShow(true);
                this.exoPlayerView.setControllerHideOnTouch(true);
                this.exoPlayerView.setControllerShowTimeoutMs(5000);
            }
        }
        if (z) {
            addPlayerControl();
        }
        refreshControlsStyles();
    }

    public void setSubtitleStyle(SubtitleStyle subtitleStyle) {
        this.exoPlayerView.setSubtitleStyle(subtitleStyle);
    }

    public void setShutterColor(Integer num) {
        this.exoPlayerView.setShutterColor(num.intValue());
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public void onAdEvent(AdEvent adEvent) {
        if (adEvent.getAdData() != null) {
            this.eventEmitter.onReceiveAdEvent.invoke(adEvent.getType().name(), adEvent.getAdData());
        } else {
            this.eventEmitter.onReceiveAdEvent.invoke(adEvent.getType().name(), null);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public void onAdError(AdErrorEvent adErrorEvent) {
        AdError error = adErrorEvent.getError();
        this.eventEmitter.onReceiveAdEvent.invoke("ERROR", Utils$$ExternalSyntheticBackport0.m(new Map.Entry[]{new AbstractMap.SimpleEntry("message", error.getMessage()), new AbstractMap.SimpleEntry("code", String.valueOf(error.getErrorCode())), new AbstractMap.SimpleEntry("type", String.valueOf(error.getErrorType()))}));
    }

    public void setControlsStyles(ControlsConfig controlsConfig) {
        this.controlsConfig = controlsConfig;
        refreshControlsStyles();
    }
}
