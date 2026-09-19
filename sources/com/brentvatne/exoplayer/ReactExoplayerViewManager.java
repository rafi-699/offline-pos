package com.brentvatne.exoplayer;

import android.content.Context;
import androidx.core.view.ViewCompat;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.react.EventTypes;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.brentvatne.react.ReactNativeVideoManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactExoplayerViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001RB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0007J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001cH\u0007J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001cH\u0007J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u001cH\u0007J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\bH\u0007J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/H\u0007J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00101\u001a\u00020/H\u0007J\u0018\u00102\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u001cH\u0007J\u0018\u00104\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00105\u001a\u00020/H\u0007J\u0018\u00106\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00107\u001a\u00020/H\u0007J\u0018\u00108\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u001cH\u0007J\u0018\u0010:\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u001cH\u0007J\u0018\u0010<\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u001cH\u0007J\u0018\u0010>\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\bH\u0007J\u0018\u0010@\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001cH\u0007J\u0018\u0010B\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u001cH\u0007J\u0018\u0010D\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010E\u001a\u00020FH\u0007J\u0018\u0010G\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u001cH\u0007J\u001a\u0010I\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010J\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010K\u001a\u00020FH\u0007J\u0018\u0010L\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u001cH\u0007J\u001a\u0010N\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010O\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010P\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/brentvatne/exoplayer/ReactExoplayerViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "config", "Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "<init>", "(Lcom/brentvatne/exoplayer/ReactExoplayerConfig;)V", "getName", "", "createViewInstance", "themedReactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", ViewHierarchyConstants.VIEW_KEY, "getExportedCustomDirectEventTypeConstants", "", "", "addEventEmitters", "reactContext", "setSrc", "videoView", ReactExoplayerViewManager.PROP_SRC, "Lcom/facebook/react/bridge/ReadableMap;", "setResizeMode", "resizeMode", "setRepeat", ReactExoplayerViewManager.PROP_REPEAT, "", "setPreventsDisplaySleepDuringVideoPlayback", "preventsSleep", "setSelectedVideoTrack", ReactExoplayerViewManager.PROP_SELECTED_VIDEO_TRACK, "setSelectedAudioTrack", ReactExoplayerViewManager.PROP_SELECTED_AUDIO_TRACK, "setSelectedTextTrack", ReactExoplayerViewManager.PROP_SELECTED_TEXT_TRACK, "setPaused", ReactExoplayerViewManager.PROP_PAUSED, "setMuted", ReactExoplayerViewManager.PROP_MUTED, "setEnterPictureInPictureOnLeave", ReactExoplayerViewManager.PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE, "setAudioOutput", ReactExoplayerViewManager.PROP_AUDIO_OUTPUT, "setVolume", ReactExoplayerViewManager.PROP_VOLUME, "", "setProgressUpdateInterval", ReactExoplayerViewManager.PROP_PROGRESS_UPDATE_INTERVAL, "setReportBandwidth", ReactExoplayerViewManager.PROP_REPORT_BANDWIDTH, "setRate", ReactExoplayerViewManager.PROP_RATE, "setMaxBitRate", ReactExoplayerViewManager.PROP_MAXIMUM_BIT_RATE, "setPlayInBackground", ReactExoplayerViewManager.PROP_PLAY_IN_BACKGROUND, "setDisableFocus", ReactExoplayerViewManager.PROP_DISABLE_FOCUS, "setFocusable", ReactExoplayerViewManager.PROP_FOCUSABLE, "setBufferingStrategy", ReactExoplayerViewManager.PROP_BUFFERING_STRATEGY, "setDisableDisconnectError", ReactExoplayerViewManager.PROP_DISABLE_DISCONNECT_ERROR, "setFullscreen", ReactExoplayerViewManager.PROP_FULLSCREEN, "setViewType", ReactExoplayerViewManager.PROP_VIEW_TYPE, "", "setControls", ReactExoplayerViewManager.PROP_CONTROLS, "setSubtitleStyle", "setShutterColor", "color", "setShowNotificationControls", ReactExoplayerViewManager.PROP_SHOW_NOTIFICATION_CONTROLS, "setDebug", "debugConfig", "setControlsStyles", ReactExoplayerViewManager.PROP_CONTROLS_STYLES, "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactExoplayerViewManager extends ViewGroupManager<ReactExoplayerView> {
    private static final String PROP_AUDIO_OUTPUT = "audioOutput";
    private static final String PROP_BUFFERING_STRATEGY = "bufferingStrategy";
    private static final String PROP_CONTROLS = "controls";
    private static final String PROP_CONTROLS_STYLES = "controlsStyles";
    private static final String PROP_DEBUG = "debug";
    private static final String PROP_DISABLE_DISCONNECT_ERROR = "disableDisconnectError";
    private static final String PROP_DISABLE_FOCUS = "disableFocus";
    private static final String PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE = "enterPictureInPictureOnLeave";
    private static final String PROP_FOCUSABLE = "focusable";
    private static final String PROP_FULLSCREEN = "fullscreen";
    private static final String PROP_MAXIMUM_BIT_RATE = "maxBitRate";
    private static final String PROP_MUTED = "muted";
    private static final String PROP_PAUSED = "paused";
    private static final String PROP_PLAY_IN_BACKGROUND = "playInBackground";
    private static final String PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK = "preventsDisplaySleepDuringVideoPlayback";
    private static final String PROP_PROGRESS_UPDATE_INTERVAL = "progressUpdateInterval";
    private static final String PROP_RATE = "rate";
    private static final String PROP_REPEAT = "repeat";
    private static final String PROP_REPORT_BANDWIDTH = "reportBandwidth";
    private static final String PROP_RESIZE_MODE = "resizeMode";
    private static final String PROP_SELECTED_AUDIO_TRACK = "selectedAudioTrack";
    private static final String PROP_SELECTED_AUDIO_TRACK_TYPE = "type";
    private static final String PROP_SELECTED_AUDIO_TRACK_VALUE = "value";
    private static final String PROP_SELECTED_TEXT_TRACK = "selectedTextTrack";
    private static final String PROP_SELECTED_TEXT_TRACK_TYPE = "type";
    private static final String PROP_SELECTED_TEXT_TRACK_VALUE = "value";
    private static final String PROP_SELECTED_VIDEO_TRACK = "selectedVideoTrack";
    private static final String PROP_SELECTED_VIDEO_TRACK_TYPE = "type";
    private static final String PROP_SELECTED_VIDEO_TRACK_VALUE = "value";
    private static final String PROP_SHOW_NOTIFICATION_CONTROLS = "showNotificationControls";
    private static final String PROP_SHUTTER_COLOR = "shutterColor";
    private static final String PROP_SRC = "src";
    private static final String PROP_SUBTITLE_STYLE = "subtitleStyle";
    private static final String PROP_VIEW_TYPE = "viewType";
    private static final String PROP_VOLUME = "volume";
    private static final String REACT_CLASS = "RCTVideo";
    private static final String TAG = "ExoViewManager";
    private final ReactExoplayerConfig config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactExoplayerViewManager(ReactExoplayerConfig config) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactExoplayerView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "themedReactContext");
        ReactNativeVideoManager.INSTANCE.getInstance().registerView(this);
        return new ReactExoplayerView(themedReactContext, this.config);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.cleanUpResources();
        view.exitPictureInPictureMode();
        ReactNativeVideoManager.INSTANCE.getInstance().unregisterView(this);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return EventTypes.INSTANCE.toMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.eventEmitter.addEventEmitters(reactContext, view);
    }

    @ReactProp(name = PROP_SRC)
    public final void setSrc(ReactExoplayerView videoView, ReadableMap src) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Context applicationContext = videoView.getContext().getApplicationContext();
        Source.Companion companion = Source.INSTANCE;
        Intrinsics.checkNotNull(applicationContext);
        videoView.setSrc(companion.parse(src, applicationContext));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r5.equals("none") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r4.setResizeModeModifier(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r5.equals("contain") == false) goto L22;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "resizeMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setResizeMode(com.brentvatne.exoplayer.ReactExoplayerView r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "videoView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "resizeMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case -1881872635: goto L38;
                case 3387192: goto L2c;
                case 94852023: goto L1e;
                case 951526612: goto L15;
                default: goto L14;
            }
        L14:
            goto L47
        L15:
            java.lang.String r0 = "contain"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L34
            goto L47
        L1e:
            java.lang.String r0 = "cover"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L27
            goto L47
        L27:
            r5 = 4
            r4.setResizeModeModifier(r5)
            return
        L2c:
            java.lang.String r0 = "none"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L47
        L34:
            r4.setResizeModeModifier(r1)
            return
        L38:
            java.lang.String r0 = "stretch"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L42
            goto L47
        L42:
            r5 = 3
            r4.setResizeModeModifier(r5)
            return
        L47:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported resize mode: "
            r0.<init>(r2)
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = " - falling back to fit"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "ExoViewManager"
            com.brentvatne.common.toolbox.DebugLog.w(r0, r5)
            r4.setResizeModeModifier(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerViewManager.setResizeMode(com.brentvatne.exoplayer.ReactExoplayerView, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPEAT)
    public final void setRepeat(ReactExoplayerView videoView, boolean repeat) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRepeatModifier(repeat);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK)
    public final void setPreventsDisplaySleepDuringVideoPlayback(ReactExoplayerView videoView, boolean preventsSleep) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPreventsDisplaySleepDuringVideoPlayback(preventsSleep);
    }

    @ReactProp(name = PROP_SELECTED_VIDEO_TRACK)
    public final void setSelectedVideoTrack(ReactExoplayerView videoView, ReadableMap selectedVideoTrack) {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedVideoTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedVideoTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedVideoTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedVideoTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(name = PROP_SELECTED_AUDIO_TRACK)
    public final void setSelectedAudioTrack(ReactExoplayerView videoView, ReadableMap selectedAudioTrack) {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedAudioTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedAudioTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedAudioTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedAudioTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(name = PROP_SELECTED_TEXT_TRACK)
    public final void setSelectedTextTrack(ReactExoplayerView videoView, ReadableMap selectedTextTrack) {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedTextTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedTextTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedTextTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedTextTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PAUSED)
    public final void setPaused(ReactExoplayerView videoView, boolean paused) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPausedModifier(paused);
    }

    @ReactProp(defaultBoolean = false, name = PROP_MUTED)
    public final void setMuted(ReactExoplayerView videoView, boolean muted) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMutedModifier(muted);
    }

    @ReactProp(defaultBoolean = false, name = PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE)
    public final void setEnterPictureInPictureOnLeave(ReactExoplayerView videoView, boolean enterPictureInPictureOnLeave) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setEnterPictureInPictureOnLeave(enterPictureInPictureOnLeave);
    }

    @ReactProp(name = PROP_AUDIO_OUTPUT)
    public final void setAudioOutput(ReactExoplayerView videoView, String audioOutput) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        videoView.setAudioOutput(AudioOutput.INSTANCE.get(audioOutput));
    }

    @ReactProp(defaultFloat = 1.0f, name = PROP_VOLUME)
    public final void setVolume(ReactExoplayerView videoView, float volume) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setVolumeModifier(volume);
    }

    @ReactProp(defaultFloat = 250.0f, name = PROP_PROGRESS_UPDATE_INTERVAL)
    public final void setProgressUpdateInterval(ReactExoplayerView videoView, float progressUpdateInterval) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setProgressUpdateInterval(progressUpdateInterval);
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPORT_BANDWIDTH)
    public final void setReportBandwidth(ReactExoplayerView videoView, boolean reportBandwidth) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setReportBandwidth(reportBandwidth);
    }

    @ReactProp(name = PROP_RATE)
    public final void setRate(ReactExoplayerView videoView, float rate) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRateModifier(rate);
    }

    @ReactProp(name = PROP_MAXIMUM_BIT_RATE)
    public final void setMaxBitRate(ReactExoplayerView videoView, float maxBitRate) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMaxBitRateModifier((int) maxBitRate);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PLAY_IN_BACKGROUND)
    public final void setPlayInBackground(ReactExoplayerView videoView, boolean playInBackground) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPlayInBackground(playInBackground);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_FOCUS)
    public final void setDisableFocus(ReactExoplayerView videoView, boolean disableFocus) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableFocus(disableFocus);
    }

    @ReactProp(defaultBoolean = true, name = PROP_FOCUSABLE)
    public final void setFocusable(ReactExoplayerView videoView, boolean focusable) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFocusable(focusable);
    }

    @ReactProp(name = PROP_BUFFERING_STRATEGY)
    public final void setBufferingStrategy(ReactExoplayerView videoView, String bufferingStrategy) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(bufferingStrategy, "bufferingStrategy");
        videoView.setBufferingStrategy(BufferingStrategy.INSTANCE.parse(bufferingStrategy));
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_DISCONNECT_ERROR)
    public final void setDisableDisconnectError(ReactExoplayerView videoView, boolean disableDisconnectError) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableDisconnectError(disableDisconnectError);
    }

    @ReactProp(defaultBoolean = false, name = PROP_FULLSCREEN)
    public final void setFullscreen(ReactExoplayerView videoView, boolean fullscreen) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFullscreen(fullscreen);
    }

    @ReactProp(defaultInt = 1, name = PROP_VIEW_TYPE)
    public final void setViewType(ReactExoplayerView videoView, int viewType) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setViewType(viewType);
    }

    @ReactProp(defaultBoolean = false, name = PROP_CONTROLS)
    public final void setControls(ReactExoplayerView videoView, boolean controls) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControls(controls);
    }

    @ReactProp(name = PROP_SUBTITLE_STYLE)
    public final void setSubtitleStyle(ReactExoplayerView videoView, ReadableMap src) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setSubtitleStyle(SubtitleStyle.INSTANCE.parse(src));
    }

    @ReactProp(defaultInt = ViewCompat.MEASURED_STATE_MASK, name = PROP_SHUTTER_COLOR)
    public final void setShutterColor(ReactExoplayerView videoView, int color) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShutterColor(Integer.valueOf(color));
    }

    @ReactProp(name = PROP_SHOW_NOTIFICATION_CONTROLS)
    public final void setShowNotificationControls(ReactExoplayerView videoView, boolean showNotificationControls) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShowNotificationControls(showNotificationControls);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DEBUG)
    public final void setDebug(ReactExoplayerView videoView, ReadableMap debugConfig) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        boolean zSafeGetBool = ReactBridgeUtils.safeGetBool(debugConfig, "enable", false);
        boolean zSafeGetBool2 = ReactBridgeUtils.safeGetBool(debugConfig, "thread", false);
        if (zSafeGetBool) {
            DebugLog.setConfig(2, zSafeGetBool2);
        } else {
            DebugLog.setConfig(5, zSafeGetBool2);
        }
        videoView.setDebug(zSafeGetBool);
    }

    @ReactProp(name = PROP_CONTROLS_STYLES)
    public final void setControlsStyles(ReactExoplayerView videoView, ReadableMap controlsStyles) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControlsStyles(ControlsConfig.INSTANCE.parse(controlsStyles));
    }
}
