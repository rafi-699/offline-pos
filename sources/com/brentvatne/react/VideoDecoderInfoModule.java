package com.brentvatne.react;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.media.MediaFormat;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VideoDecoderInfoModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J,\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0013"}, d2 = {"Lcom/brentvatne/react/VideoDecoderInfoModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "getWidevineLevel", "", "p", "Lcom/facebook/react/bridge/Promise;", "isCodecSupported", "mimeType", "width", "", "height", "isHEVCSupported", "Companion", "react-native-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDecoderInfoModule extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "VideoDecoderInfoModule";
    private static final String SECURITY_LEVEL_PROPERTY = "securityLevel";
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    public VideoDecoderInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @ReactMethod
    public final void getWidevineLevel(Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        int i = 0;
        try {
            String propertyString = new MediaDrm(WIDEVINE_UUID).getPropertyString(SECURITY_LEVEL_PROPERTY);
            Intrinsics.checkNotNullExpressionValue(propertyString, "getPropertyString(...)");
            switch (propertyString.hashCode()) {
                case 2405:
                    if (propertyString.equals("L1")) {
                        i = 1;
                    }
                    break;
                case 2406:
                    if (propertyString.equals("L2")) {
                        i = 2;
                    }
                    break;
                case 2407:
                    if (propertyString.equals("L3")) {
                        i = 3;
                    }
                    break;
            }
        } catch (UnsupportedSchemeException e) {
            e.printStackTrace();
        }
        p.resolve(Integer.valueOf(i));
    }

    @ReactMethod
    public final void isCodecSupported(String mimeType, double width, double height, Promise p) {
        boolean z = false;
        MediaCodecList mediaCodecList = new MediaCodecList(0);
        Intrinsics.checkNotNull(mimeType);
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(mimeType, (int) width, (int) height);
        Intrinsics.checkNotNullExpressionValue(mediaFormatCreateVideoFormat, "createVideoFormat(...)");
        String strFindDecoderForFormat = mediaCodecList.findDecoderForFormat(mediaFormatCreateVideoFormat);
        if (strFindDecoderForFormat == null) {
            if (p != null) {
                p.resolve("unsupported");
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            if (p != null) {
                p.resolve("software");
                return;
            }
            return;
        }
        MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
        Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (StringsKt.equals(mediaCodecInfo.getName(), strFindDecoderForFormat, true) && mediaCodecInfo.isHardwareAccelerated()) {
                z = true;
                break;
            }
        }
        if (p != null) {
            p.resolve(z ? "software" : "hardware");
        }
    }

    @ReactMethod
    public final void isHEVCSupported(Promise p) {
        Intrinsics.checkNotNullParameter(p, "p");
        isCodecSupported(MimeTypes.VIDEO_H265, 1920.0d, 1080.0d, p);
    }
}
