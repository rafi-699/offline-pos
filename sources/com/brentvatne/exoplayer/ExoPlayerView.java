package com.brentvatne.exoplayer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.R;
import androidx.media3.ui.SubtitleView;
import com.brentvatne.common.api.SubtitleStyle;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExoPlayerView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001;\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020 J\u000e\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020 J\u0010\u0010-\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020 J\u0006\u00102\u001a\u00020 J\u0010\u00103\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u000104J\u0010\u00105\u001a\u00020\u00132\u0006\u0010.\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020 H\u0016J\b\u00109\u001a\u00020\u0013H\u0002J\b\u0010?\u001a\u00020\u0013H\u0016J0\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/brentvatne/exoplayer/ExoPlayerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "localStyle", "Lcom/brentvatne/common/api/SubtitleStyle;", "pendingResizeMode", "Ljava/lang/Integer;", "liveBadge", "Landroid/widget/TextView;", "playerView", "Landroidx/media3/ui/PlayerView;", "setPlayer", "", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "getPlayerView", "setResizeMode", ViewProps.RESIZE_MODE, "setSubtitleStyle", "style", "setShutterColor", "color", "updateSurfaceView", "viewType", "isPlaying", "", "()Z", "invalidateAspectRatio", "setUseController", "useController", "showController", "hideController", "setControllerShowTimeoutMs", "showTimeoutMs", "setControllerAutoShow", "autoShow", "setControllerHideOnTouch", "hideOnTouch", "setFullscreenButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/media3/ui/PlayerView$FullscreenButtonClickListener;", "setShowSubtitleButton", "show", "isControllerVisible", "setControllerVisibilityListener", "Landroidx/media3/ui/PlayerView$ControllerVisibilityListener;", "addOnLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "setFocusable", "focusable", "updateLiveUi", "playerListener", "com/brentvatne/exoplayer/ExoPlayerView$playerListener$1", "Lcom/brentvatne/exoplayer/ExoPlayerView$playerListener$1;", "layoutRunnable", "Ljava/lang/Runnable;", "requestLayout", "onLayout", "changed", "left", "top", "right", ViewProps.BOTTOM, "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExoPlayerView extends FrameLayout {
    private static final String TAG = "ExoPlayerView";
    private final Runnable layoutRunnable;
    private final TextView liveBadge;
    private SubtitleStyle localStyle;
    private Integer pendingResizeMode;
    private final ExoPlayerView$playerListener$1 playerListener;
    private final PlayerView playerView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoPlayerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void updateSurfaceView(int viewType) {
    }

    public /* synthetic */ ExoPlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.localStyle = new SubtitleStyle();
        TextView textView = new TextView(context);
        textView.setText("LIVE");
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(SupportMenu.CATEGORY_MASK);
        gradientDrawable.setCornerRadius(6.0f);
        textView.setBackground(gradientDrawable);
        textView.setPadding(12, 4, 12, 4);
        textView.setVisibility(8);
        this.liveBadge = textView;
        PlayerView playerView = new PlayerView(context);
        playerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        playerView.setShutterBackgroundColor(0);
        playerView.setUseController(true);
        playerView.setControllerAutoShow(true);
        playerView.setControllerHideOnTouch(true);
        playerView.setControllerShowTimeoutMs(5000);
        playerView.setShowSubtitleButton(false);
        playerView.setUseArtwork(false);
        playerView.setDefaultArtwork(null);
        playerView.setResizeMode(0);
        this.playerView = playerView;
        addView(playerView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(16, 16, 16, 16);
        addView(textView, layoutParams);
        this.playerListener = new ExoPlayerView$playerListener$1(this);
        this.layoutRunnable = new Runnable() { // from class: com.brentvatne.exoplayer.ExoPlayerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerView.layoutRunnable$lambda$5(this.f$0);
            }
        };
    }

    public final void setPlayer(ExoPlayer player) {
        Player player2 = this.playerView.getPlayer();
        if (player2 != null) {
            player2.removeListener(this.playerListener);
        }
        this.playerView.setPlayer(player);
        if (player != null) {
            player.addListener(this.playerListener);
            Integer num = this.pendingResizeMode;
            if (num != null) {
                this.playerView.setResizeMode(num.intValue());
            }
        }
    }

    public final PlayerView getPlayerView() {
        return this.playerView;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0010 A[PHI: r1
  0x0010: PHI (r1v1 int) = (r1v0 int), (r1v2 int), (r1v3 int), (r1v4 int) binds: [B:5:0x0004, B:7:0x0007, B:9:0x000a, B:11:0x000d] A[DONT_GENERATE, DONT_INLINE]] */
    public final void setResizeMode(int resizeMode) {
        int i = 0;
        if (resizeMode != 0) {
            int i2 = 1;
            if (resizeMode != 1) {
                i2 = 2;
                if (resizeMode != 2) {
                    i2 = 3;
                    if (resizeMode != 3) {
                        i2 = 4;
                        if (resizeMode == 4) {
                            i = i2;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    i = i2;
                }
            } else {
                i = i2;
            }
        }
        this.playerView.setResizeMode(i);
        this.pendingResizeMode = Integer.valueOf(i);
        this.playerView.requestLayout();
        requestLayout();
    }

    public final void setSubtitleStyle(SubtitleStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        SubtitleView subtitleView = this.playerView.getSubtitleView();
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
            if (style.getFontSize() > 0) {
                subtitleView.setFixedTextSize(2, style.getFontSize());
            }
            subtitleView.setPadding(style.getPaddingLeft(), style.getPaddingTop(), style.getPaddingRight(), style.getPaddingBottom());
            if (style.getOpacity() != 0.0f) {
                subtitleView.setAlpha(style.getOpacity());
                subtitleView.setVisibility(0);
            } else {
                subtitleView.setVisibility(8);
            }
        }
        this.localStyle = style;
    }

    public final void setShutterColor(int color) {
        this.playerView.setShutterBackgroundColor(color);
    }

    public final boolean isPlaying() {
        Player player = this.playerView.getPlayer();
        if (player != null) {
            return player.isPlaying();
        }
        return false;
    }

    public final void invalidateAspectRatio() {
        this.playerView.requestLayout();
        Integer num = this.pendingResizeMode;
        if (num != null) {
            this.playerView.setResizeMode(num.intValue());
        }
    }

    public final void setUseController(boolean useController) {
        this.playerView.setUseController(useController);
        if (useController) {
            this.playerView.setControllerAutoShow(true);
            this.playerView.setControllerHideOnTouch(true);
            this.playerView.showController();
        }
    }

    public final void showController() {
        this.playerView.showController();
    }

    public final void hideController() {
        this.playerView.hideController();
    }

    public final void setControllerShowTimeoutMs(int showTimeoutMs) {
        this.playerView.setControllerShowTimeoutMs(showTimeoutMs);
    }

    public final void setControllerAutoShow(boolean autoShow) {
        this.playerView.setControllerAutoShow(autoShow);
    }

    public final void setControllerHideOnTouch(boolean hideOnTouch) {
        this.playerView.setControllerHideOnTouch(hideOnTouch);
    }

    public final void setFullscreenButtonClickListener(PlayerView.FullscreenButtonClickListener listener) {
        this.playerView.setFullscreenButtonClickListener(listener);
    }

    public final void setShowSubtitleButton(boolean show) {
        this.playerView.setShowSubtitleButton(show);
    }

    public final boolean isControllerVisible() {
        return this.playerView.isControllerFullyVisible();
    }

    public final void setControllerVisibilityListener(PlayerView.ControllerVisibilityListener listener) {
        this.playerView.setControllerVisibilityListener(listener);
    }

    @Override // android.view.View
    public void addOnLayoutChangeListener(View.OnLayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.playerView.addOnLayoutChangeListener(listener);
    }

    @Override // android.view.View
    public void setFocusable(boolean focusable) {
        this.playerView.setFocusable(focusable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLiveUi() {
        Player player = this.playerView.getPlayer();
        if (player == null) {
            return;
        }
        boolean zIsCurrentMediaItemLive = player.isCurrentMediaItemLive();
        boolean zIsCurrentMediaItemSeekable = player.isCurrentMediaItemSeekable();
        this.liveBadge.setVisibility(zIsCurrentMediaItemLive ? 0 : 8);
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) this.playerView.findViewById(R.id.exo_progress);
        if (defaultTimeBar != null) {
            defaultTimeBar.setEnabled(!zIsCurrentMediaItemLive || zIsCurrentMediaItemSeekable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutRunnable$lambda$5(ExoPlayerView exoPlayerView) {
        exoPlayerView.measure(View.MeasureSpec.makeMeasureSpec(exoPlayerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(exoPlayerView.getHeight(), 1073741824));
        exoPlayerView.layout(exoPlayerView.getLeft(), exoPlayerView.getTop(), exoPlayerView.getRight(), exoPlayerView.getBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.layoutRunnable);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Integer num;
        super.onLayout(changed, left, top, right, bottom);
        if (!changed || (num = this.pendingResizeMode) == null) {
            return;
        }
        this.playerView.setResizeMode(num.intValue());
    }
}
