package com.brentvatne.exoplayer;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.ui.LegacyPlayerControlView;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.toolbox.DebugLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullScreenPlayerView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00017B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020 H\u0014J\b\u0010\"\u001a\u00020 H\u0002J\u0006\u0010#\u001a\u00020 J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020(H\u0002J=\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\u001c2\b\u0010.\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u00100J3\u00101\u001a\u00020 2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u001c2\b\u00105\u001a\u0004\u0018\u00010\u001c2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u00106J\b\u00101\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d¨\u00068"}, d2 = {"Lcom/brentvatne/exoplayer/FullScreenPlayerView;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "exoPlayerView", "Lcom/brentvatne/exoplayer/ExoPlayerView;", "reactExoplayerView", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "playerControlView", "Landroidx/media3/ui/LegacyPlayerControlView;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "controlsConfig", "Lcom/brentvatne/common/api/ControlsConfig;", "<init>", "(Landroid/content/Context;Lcom/brentvatne/exoplayer/ExoPlayerView;Lcom/brentvatne/exoplayer/ReactExoplayerView;Landroidx/media3/ui/LegacyPlayerControlView;Landroidx/activity/OnBackPressedCallback;Lcom/brentvatne/common/api/ControlsConfig;)V", "parent", "Landroid/view/ViewGroup;", "containerView", "Landroid/widget/FrameLayout;", "mKeepScreenOnHandler", "Landroid/os/Handler;", "mKeepScreenOnUpdater", "Lcom/brentvatne/exoplayer/FullScreenPlayerView$KeepScreenOnUpdater;", "initialSystemBarsBehavior", "", "Ljava/lang/Integer;", "initialNavigationBarIsVisible", "", "Ljava/lang/Boolean;", "initialNotificationBarIsVisible", "onStart", "", "onStop", "restoreSystemUI", "hideWithoutPlayer", "getFullscreenIconResource", "isFullscreen", "onAttachedToWindow", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "updateBarVisibility", "inset", "Landroidx/core/view/WindowInsetsControllerCompat;", "type", "shouldHide", "initialVisibility", "systemBarsBehavior", "(Landroidx/core/view/WindowInsetsControllerCompat;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "updateNavigationBarVisibility", "window", "Landroid/view/Window;", "hideNavigationBarOnFullScreenMode", "hideNotificationBarOnFullScreenMode", "(Landroid/view/Window;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "KeepScreenOnUpdater", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullScreenPlayerView extends Dialog {
    private final FrameLayout containerView;
    private final ControlsConfig controlsConfig;
    private final ExoPlayerView exoPlayerView;
    private Boolean initialNavigationBarIsVisible;
    private Boolean initialNotificationBarIsVisible;
    private Integer initialSystemBarsBehavior;
    private final Handler mKeepScreenOnHandler;
    private final KeepScreenOnUpdater mKeepScreenOnUpdater;
    private final OnBackPressedCallback onBackPressedCallback;
    private ViewGroup parent;
    private final LegacyPlayerControlView playerControlView;
    private final ReactExoplayerView reactExoplayerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayerView(Context context, ExoPlayerView exoPlayerView, ReactExoplayerView reactExoplayerView, LegacyPlayerControlView legacyPlayerControlView, OnBackPressedCallback onBackPressedCallback, ControlsConfig controlsConfig) {
        super(context, R.style.Theme.Black.NoTitleBar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exoPlayerView, "exoPlayerView");
        Intrinsics.checkNotNullParameter(reactExoplayerView, "reactExoplayerView");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Intrinsics.checkNotNullParameter(controlsConfig, "controlsConfig");
        this.exoPlayerView = exoPlayerView;
        this.reactExoplayerView = reactExoplayerView;
        this.playerControlView = legacyPlayerControlView;
        this.onBackPressedCallback = onBackPressedCallback;
        this.controlsConfig = controlsConfig;
        FrameLayout frameLayout = new FrameLayout(context);
        this.containerView = frameLayout;
        this.mKeepScreenOnHandler = new Handler(Looper.getMainLooper());
        this.mKeepScreenOnUpdater = new KeepScreenOnUpdater(this);
        setContentView(frameLayout, generateDefaultLayoutParams());
        Window window = getWindow();
        if (window != null) {
            this.initialSystemBarsBehavior = Integer.valueOf(new WindowInsetsControllerCompat(window, window.getDecorView()).getSystemBarsBehavior());
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window.getDecorView());
            this.initialNavigationBarIsVisible = Boolean.valueOf(rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars()));
            WindowInsetsCompat rootWindowInsets2 = ViewCompat.getRootWindowInsets(window.getDecorView());
            this.initialNotificationBarIsVisible = Boolean.valueOf(rootWindowInsets2 != null && rootWindowInsets2.isVisible(WindowInsetsCompat.Type.statusBars()));
        }
    }

    /* JADX INFO: compiled from: FullScreenPlayerView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/brentvatne/exoplayer/FullScreenPlayerView$KeepScreenOnUpdater;", "Ljava/lang/Runnable;", "fullScreenPlayerView", "Lcom/brentvatne/exoplayer/FullScreenPlayerView;", "<init>", "(Lcom/brentvatne/exoplayer/FullScreenPlayerView;)V", "mFullscreenPlayer", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "run", "", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class KeepScreenOnUpdater implements Runnable {
        private static final long UPDATE_KEEP_SCREEN_ON_FLAG_MS = 200;
        private final WeakReference<FullScreenPlayerView> mFullscreenPlayer;

        public KeepScreenOnUpdater(FullScreenPlayerView fullScreenPlayerView) {
            Intrinsics.checkNotNullParameter(fullScreenPlayerView, "fullScreenPlayerView");
            this.mFullscreenPlayer = new WeakReference<>(fullScreenPlayerView);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FullScreenPlayerView fullScreenPlayerView = this.mFullscreenPlayer.get();
                if (fullScreenPlayerView != null) {
                    Window window = fullScreenPlayerView.getWindow();
                    if (window != null) {
                        if (fullScreenPlayerView.exoPlayerView.isPlaying()) {
                            window.addFlags(128);
                        } else {
                            window.clearFlags(128);
                        }
                    }
                    fullScreenPlayerView.mKeepScreenOnHandler.postDelayed(this, UPDATE_KEEP_SCREEN_ON_FLAG_MS);
                }
            } catch (Exception e) {
                DebugLog.e("ExoPlayer Exception", "Failed to flag FLAG_KEEP_SCREEN_ON on fullscreen.");
                DebugLog.e("ExoPlayer Exception", e.toString());
            }
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        ViewGroup viewGroup = (ViewGroup) this.exoPlayerView.getParent();
        this.parent = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeView(this.exoPlayerView);
        }
        this.containerView.addView(this.exoPlayerView, generateDefaultLayoutParams());
        LegacyPlayerControlView legacyPlayerControlView = this.playerControlView;
        if (legacyPlayerControlView != null) {
            ViewGroup viewGroup2 = this.parent;
            if (viewGroup2 != null) {
                viewGroup2.removeView(legacyPlayerControlView);
            }
            this.containerView.addView(legacyPlayerControlView, generateDefaultLayoutParams());
        }
        updateNavigationBarVisibility();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mKeepScreenOnHandler.removeCallbacks(this.mKeepScreenOnUpdater);
        this.containerView.removeView(this.exoPlayerView);
        ViewGroup viewGroup = this.parent;
        if (viewGroup != null) {
            viewGroup.addView(this.exoPlayerView, generateDefaultLayoutParams());
        }
        LegacyPlayerControlView legacyPlayerControlView = this.playerControlView;
        if (legacyPlayerControlView != null) {
            LegacyPlayerControlView legacyPlayerControlView2 = legacyPlayerControlView;
            this.containerView.removeView(legacyPlayerControlView2);
            ViewGroup viewGroup2 = this.parent;
            if (viewGroup2 != null) {
                viewGroup2.addView(legacyPlayerControlView2, generateDefaultLayoutParams());
            }
        }
        ViewGroup viewGroup3 = this.parent;
        if (viewGroup3 != null) {
            viewGroup3.requestLayout();
        }
        this.parent = null;
        this.onBackPressedCallback.handleOnBackPressed();
        restoreSystemUI();
    }

    private final void restoreSystemUI() {
        Window window = getWindow();
        if (window != null) {
            updateNavigationBarVisibility(window, this.initialNavigationBarIsVisible, this.initialNotificationBarIsVisible, this.initialSystemBarsBehavior);
        }
    }

    public final void hideWithoutPlayer() {
        int childCount = this.containerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.containerView.getChildAt(i) != this.exoPlayerView) {
                this.containerView.getChildAt(i).setVisibility(8);
            }
        }
    }

    private final int getFullscreenIconResource(boolean isFullscreen) {
        if (isFullscreen) {
            return androidx.media3.ui.R.drawable.exo_icon_fullscreen_exit;
        }
        return androidx.media3.ui.R.drawable.exo_icon_fullscreen_enter;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.reactExoplayerView.getPreventsDisplaySleepDuringVideoPlayback()) {
            this.mKeepScreenOnHandler.post(this.mKeepScreenOnUpdater);
        }
    }

    private final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        return layoutParams;
    }

    static /* synthetic */ void updateBarVisibility$default(FullScreenPlayerView fullScreenPlayerView, WindowInsetsControllerCompat windowInsetsControllerCompat, int i, Boolean bool, Boolean bool2, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        fullScreenPlayerView.updateBarVisibility(windowInsetsControllerCompat, i, bool, bool2, num);
    }

    private final void updateBarVisibility(WindowInsetsControllerCompat inset, int type, Boolean shouldHide, Boolean initialVisibility, Integer systemBarsBehavior) {
        if (shouldHide != null) {
            if (Intrinsics.areEqual(Boolean.valueOf(shouldHide.booleanValue()), initialVisibility)) {
                shouldHide = null;
            }
            if (shouldHide != null) {
                if (shouldHide.booleanValue()) {
                    inset.hide(type);
                    if (systemBarsBehavior != null) {
                        inset.setSystemBarsBehavior(systemBarsBehavior.intValue());
                        return;
                    }
                    return;
                }
                inset.show(type);
            }
        }
    }

    private final void updateNavigationBarVisibility(Window window, Boolean hideNavigationBarOnFullScreenMode, Boolean hideNotificationBarOnFullScreenMode, Integer systemBarsBehavior) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        updateBarVisibility(windowInsetsControllerCompat, WindowInsetsCompat.Type.navigationBars(), hideNavigationBarOnFullScreenMode, this.initialNavigationBarIsVisible, systemBarsBehavior);
        updateBarVisibility$default(this, windowInsetsControllerCompat, WindowInsetsCompat.Type.statusBars(), hideNotificationBarOnFullScreenMode, this.initialNotificationBarIsVisible, null, 16, null);
    }

    private final void updateNavigationBarVisibility() {
        Window window = getWindow();
        if (window != null) {
            updateNavigationBarVisibility(window, Boolean.valueOf(this.controlsConfig.getHideNavigationBarOnFullScreenMode()), Boolean.valueOf(this.controlsConfig.getHideNotificationBarOnFullScreenMode()), 2);
        }
    }
}
