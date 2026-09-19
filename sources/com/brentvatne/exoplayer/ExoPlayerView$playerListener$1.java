package com.brentvatne.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.ui.PlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExoPlayerView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/brentvatne/exoplayer/ExoPlayerView$playerListener$1", "Landroidx/media3/common/Player$Listener;", "onTimelineChanged", "", "timeline", "Landroidx/media3/common/Timeline;", "reason", "", "onEvents", "player", "Landroidx/media3/common/Player;", "events", "Landroidx/media3/common/Player$Events;", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExoPlayerView$playerListener$1 implements Player.Listener {
    final /* synthetic */ ExoPlayerView this$0;

    ExoPlayerView$playerListener$1(ExoPlayerView exoPlayerView) {
        this.this$0 = exoPlayerView;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onTimelineChanged(Timeline timeline, int reason) {
        Intrinsics.checkNotNullParameter(timeline, "timeline");
        PlayerView playerView = this.this$0.playerView;
        final ExoPlayerView exoPlayerView = this.this$0;
        playerView.post(new Runnable() { // from class: com.brentvatne.exoplayer.ExoPlayerView$playerListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerView$playerListener$1.onTimelineChanged$lambda$1(exoPlayerView);
            }
        });
        this.this$0.updateLiveUi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTimelineChanged$lambda$1(ExoPlayerView exoPlayerView) {
        exoPlayerView.playerView.requestLayout();
        Integer num = exoPlayerView.pendingResizeMode;
        if (num != null) {
            exoPlayerView.playerView.setResizeMode(num.intValue());
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onEvents(Player player, Player.Events events) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(events, "events");
        if (events.contains(1) || events.contains(7)) {
            this.this$0.updateLiveUi();
        }
        if (events.contains(25)) {
            Integer num = this.this$0.pendingResizeMode;
            if (num != null) {
                ExoPlayerView exoPlayerView = this.this$0;
                exoPlayerView.playerView.setResizeMode(num.intValue());
            }
            this.this$0.playerView.requestLayout();
            this.this$0.requestLayout();
        }
    }
}
