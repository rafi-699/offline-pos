package com.brentvatne.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioBecomingNoisyReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/brentvatne/receiver/AudioBecomingNoisyReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/brentvatne/receiver/BecomingNoisyListener;", "appContext", "onReceive", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", InAppPurchaseConstants.METHOD_SET_LISTENER, "removeListener", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioBecomingNoisyReceiver extends BroadcastReceiver {
    private final Context appContext;
    private BecomingNoisyListener listener;

    public AudioBecomingNoisyReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = BecomingNoisyListener.INSTANCE.getNO_OP();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !Intrinsics.areEqual("android.media.AUDIO_BECOMING_NOISY", intent.getAction())) {
            return;
        }
        this.listener.onAudioBecomingNoisy();
    }

    public final void setListener(BecomingNoisyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        ContextCompat.registerReceiver(this.appContext, this, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"), 4);
    }

    public final void removeListener() {
        this.listener = BecomingNoisyListener.INSTANCE.getNO_OP();
        try {
            this.appContext.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }
}
