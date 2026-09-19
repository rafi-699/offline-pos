package com.brentvatne.exoplayer;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Process;
import android.util.Rational;
import androidx.activity.ComponentActivity;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.R;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PictureInPictureUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J*\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u0018H\u0007J\"\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J0\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0003J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/brentvatne/exoplayer/PictureInPictureUtil;", "", "<init>", "()V", "FLAG_SUPPORTS_PICTURE_IN_PICTURE", "", "TAG", "", "addLifecycleEventListener", "Ljava/lang/Runnable;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", ViewHierarchyConstants.VIEW_KEY, "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "enterPictureInPictureMode", "", "pictureInPictureParams", "Landroid/app/PictureInPictureParams;", "applyPlayingStatus", "pipParamsBuilder", "Landroid/app/PictureInPictureParams$Builder;", "receiver", "Lcom/brentvatne/receiver/PictureInPictureReceiver;", "isPaused", "", "applyAutoEnterEnabled", "autoEnterEnabled", "applySourceRectHint", "playerView", "Lcom/brentvatne/exoplayer/ExoPlayerView;", "updatePictureInPictureActions", "pipParams", "getPictureInPictureActions", "Ljava/util/ArrayList;", "Landroid/app/RemoteAction;", "Lkotlin/collections/ArrayList;", "calcRectHint", "Landroid/graphics/Rect;", "calcPictureInPictureAspectRatio", "Landroid/util/Rational;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "isSupportPictureInPicture", "isSupportPictureInPictureAction", "checkIsApiSupport", "checkIsSystemSupportPIP", "checkIsUserAllowPIP", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PictureInPictureUtil {
    private static final int FLAG_SUPPORTS_PICTURE_IN_PICTURE = 4194304;
    public static final PictureInPictureUtil INSTANCE = new PictureInPictureUtil();
    private static final String TAG = "PictureInPictureUtil";

    private final boolean checkIsApiSupport() {
        return true;
    }

    private PictureInPictureUtil() {
    }

    @JvmStatic
    public static final Runnable addLifecycleEventListener(ThemedReactContext context, final ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        final ComponentActivity componentActivityFindActivity = PictureInPictureUtilKt.findActivity(context);
        final Consumer<PictureInPictureModeChangedInfo> consumer = new Consumer() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                PictureInPictureUtil.addLifecycleEventListener$lambda$0(view, componentActivityFindActivity, (PictureInPictureModeChangedInfo) obj);
            }
        };
        final Runnable runnable = new Runnable() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PictureInPictureUtil.addLifecycleEventListener$lambda$1(view);
            }
        };
        componentActivityFindActivity.addOnPictureInPictureModeChangedListener(consumer);
        if (Build.VERSION.SDK_INT < 31) {
            componentActivityFindActivity.addOnUserLeaveHintListener(runnable);
        }
        return new Runnable() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PictureInPictureUtil.addLifecycleEventListener$lambda$3(componentActivityFindActivity, consumer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$0(ReactExoplayerView reactExoplayerView, ComponentActivity componentActivity, PictureInPictureModeChangedInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        reactExoplayerView.setIsInPictureInPicture(info.getIsInPictureInPictureMode());
        if (info.getIsInPictureInPictureMode() || componentActivity.getLifecycle().getState() != Lifecycle.State.CREATED || reactExoplayerView.playInBackground) {
            return;
        }
        reactExoplayerView.setPausedModifier(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$1(ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView.enterPictureInPictureOnLeave) {
            reactExoplayerView.enterPictureInPictureMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$3(ComponentActivity componentActivity, Consumer consumer, Runnable runnable) {
        componentActivity.removeOnPictureInPictureModeChangedListener(consumer);
        componentActivity.removeOnUserLeaveHintListener(runnable);
    }

    @JvmStatic
    public static final void enterPictureInPictureMode(ThemedReactContext context, PictureInPictureParams pictureInPictureParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        if (pictureInPictureUtil.isSupportPictureInPicture(context)) {
            if (pictureInPictureUtil.isSupportPictureInPictureAction() && pictureInPictureParams != null) {
                try {
                    PictureInPictureUtilKt.findActivity(context).enterPictureInPictureMode(pictureInPictureParams);
                    return;
                } catch (IllegalStateException e) {
                    DebugLog.e(TAG, e.toString());
                    return;
                }
            }
            try {
                PictureInPictureUtilKt.findActivity(context).enterPictureInPictureMode();
            } catch (IllegalStateException e2) {
                DebugLog.e(TAG, e2.toString());
            }
        }
    }

    @JvmStatic
    public static final void applyPlayingStatus(ThemedReactContext context, PictureInPictureParams.Builder pipParamsBuilder, PictureInPictureReceiver receiver, boolean isPaused) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        if (pipParamsBuilder == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        pipParamsBuilder.setActions(getPictureInPictureActions(context, isPaused, receiver));
        PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
    }

    @JvmStatic
    public static final void applyAutoEnterEnabled(ThemedReactContext context, PictureInPictureParams.Builder pipParamsBuilder, boolean autoEnterEnabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (pipParamsBuilder == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        pipParamsBuilder.setAutoEnterEnabled(autoEnterEnabled);
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
    }

    @JvmStatic
    public static final void applySourceRectHint(ThemedReactContext context, PictureInPictureParams.Builder pipParamsBuilder, ExoPlayerView playerView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        if (pipParamsBuilder == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        pipParamsBuilder.setSourceRectHint(calcRectHint(playerView));
        PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
    }

    private final void updatePictureInPictureActions(ThemedReactContext context, PictureInPictureParams pipParams) {
        if (isSupportPictureInPictureAction() && isSupportPictureInPicture(context)) {
            try {
                PictureInPictureUtilKt.findActivity(context).setPictureInPictureParams(pipParams);
            } catch (IllegalStateException e) {
                DebugLog.e(TAG, e.toString());
            }
        }
    }

    @JvmStatic
    public static final ArrayList<RemoteAction> getPictureInPictureActions(ThemedReactContext context, boolean isPaused, PictureInPictureReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        PendingIntent pipActionIntent = receiver.getPipActionIntent(isPaused);
        Icon iconCreateWithResource = Icon.createWithResource(context, isPaused ? R.drawable.exo_icon_play : R.drawable.exo_icon_pause);
        Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
        String str = isPaused ? "play" : "pause";
        return CollectionsKt.arrayListOf(new RemoteAction(iconCreateWithResource, str, str, pipActionIntent));
    }

    @JvmStatic
    private static final Rect calcRectHint(ExoPlayerView playerView) {
        Rect rect = new Rect();
        playerView.getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        playerView.getLocationOnScreen(iArr);
        int i = rect.bottom - rect.top;
        rect.top = iArr[1];
        rect.bottom = rect.top + i;
        return rect;
    }

    @JvmStatic
    public static final Rational calcPictureInPictureAspectRatio(ExoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        Rational rational = new Rational(player.getVideoSize().width, player.getVideoSize().height);
        Rational rational2 = new Rational(239, 100);
        Rational rational3 = new Rational(100, 239);
        if (rational.floatValue() > rational2.floatValue()) {
            return rational2;
        }
        return rational.floatValue() < rational3.floatValue() ? rational3 : rational;
    }

    private final boolean isSupportPictureInPicture(ThemedReactContext context) {
        return checkIsApiSupport() && checkIsSystemSupportPIP(context) && checkIsUserAllowPIP(context);
    }

    private final boolean isSupportPictureInPictureAction() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final boolean checkIsSystemSupportPIP(ThemedReactContext context) {
        boolean z;
        ComponentActivity componentActivityFindActivity = PictureInPictureUtilKt.findActivity(context);
        if (componentActivityFindActivity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = componentActivityFindActivity.getPackageManager().getActivityInfo(componentActivityFindActivity.getComponentName(), 128);
            Intrinsics.checkNotNullExpressionValue(activityInfo, "getActivityInfo(...)");
            z = (activityInfo.flags & 4194304) != 0;
        } catch (Exception unused) {
        }
        return z && componentActivityFindActivity.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    private final boolean checkIsUserAllowPIP(ThemedReactContext context) {
        Activity currentActivity = context.getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return AppOpsManagerCompat.noteOpNoThrow(currentActivity, "android:picture_in_picture", Process.myUid(), currentActivity.getPackageName()) == 0;
        }
        return Build.VERSION.SDK_INT < 26;
    }
}
