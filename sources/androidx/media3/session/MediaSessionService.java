package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.legacy.MediaSessionManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    private static final String TAG = "MSessionService";
    private DefaultActionFactory actionFactory;
    private Listener listener;
    private MediaNotificationManager mediaNotificationManager;
    private MediaNotification.Provider mediaNotificationProvider;
    private MediaSessionServiceStub stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<String, MediaSession> sessions = new ArrayMap();
    private boolean defaultMethodCalled = false;

    public interface Listener {
        default void onForegroundServiceStartNotAllowedException() {
        }
    }

    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (this.lock) {
            this.stub = new MediaSessionServiceStub(this);
        }
    }

    public final void addSession(final MediaSession mediaSession) {
        MediaSession mediaSession2;
        Assertions.checkNotNull(mediaSession, "session must not be null");
        boolean z = true;
        Assertions.checkArgument(!mediaSession.isReleased(), "session is already released");
        synchronized (this.lock) {
            mediaSession2 = this.sessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z = false;
            }
            Assertions.checkArgument(z, "Session ID should be unique");
            this.sessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
            Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m492lambda$addSession$0$androidxmedia3sessionMediaSessionService(mediaNotificationManager, mediaSession);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addSession$0$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m492lambda$addSession$0$androidxmedia3sessionMediaSessionService(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.addSession(mediaSession);
        mediaSession.setListener(new MediaSessionListener());
    }

    public final void removeSession(final MediaSession mediaSession) {
        Assertions.checkNotNull(mediaSession, "session must not be null");
        synchronized (this.lock) {
            Assertions.checkArgument(this.sessions.containsKey(mediaSession.getId()), "session not found");
            this.sessions.remove(mediaSession.getId());
        }
        final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.lambda$removeSession$1(mediaNotificationManager, mediaSession);
            }
        });
    }

    static /* synthetic */ void lambda$removeSession$1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.removeSession(mediaSession);
        mediaSession.clearListener();
    }

    public final List<MediaSession> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaSession mediaSession) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(mediaSession.getId());
        }
        return zContainsKey;
    }

    public final void setListener(Listener listener) {
        synchronized (this.lock) {
            this.listener = listener;
        }
    }

    public final void clearListener() {
        synchronized (this.lock) {
            this.listener = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        MediaSession mediaSessionOnGetSession;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        action.hashCode();
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (mediaSessionOnGetSession = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(mediaSessionOnGetSession);
        return mediaSessionOnGetSession.getLegacyBrowserServiceBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        String customAction;
        if (intent == null) {
            return 1;
        }
        DefaultActionFactory actionFactory = getActionFactory();
        Uri data = intent.getData();
        MediaSession session = data != null ? MediaSession.getSession(data) : null;
        if (actionFactory.isMediaAction(intent)) {
            if (session == null) {
                session = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (session == null) {
                    return 1;
                }
                addSession(session);
            }
            final MediaSessionImpl impl = session.getImpl();
            impl.getApplicationHandler().post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionService.lambda$onStartCommand$2(impl, intent);
                }
            });
        } else {
            if (session == null || !actionFactory.isCustomAction(intent) || (customAction = actionFactory.getCustomAction(intent)) == null) {
                return 1;
            }
            getMediaNotificationManager().onCustomAction(session, customAction, actionFactory.getCustomActionExtras(intent));
        }
        return 1;
    }

    static /* synthetic */ void lambda$onStartCommand$2(MediaSessionImpl mediaSessionImpl, Intent intent) {
        MediaSession.ControllerInfo mediaNotificationControllerInfo = mediaSessionImpl.getMediaNotificationControllerInfo();
        if (mediaNotificationControllerInfo == null) {
            mediaNotificationControllerInfo = createFallbackMediaButtonCaller(intent);
        }
        if (mediaSessionImpl.onMediaButtonEvent(mediaNotificationControllerInfo, intent)) {
            return;
        }
        Log.d(TAG, "Ignored unrecognized media button intent.");
    }

    private static MediaSession.ControllerInfo createFallbackMediaButtonCaller(Intent intent) {
        String packageName;
        ComponentName component = intent.getComponent();
        if (component != null) {
            packageName = component.getPackageName();
        } else {
            packageName = SERVICE_INTERFACE;
        }
        return new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo(packageName, -1, -1), MediaLibraryInfo.VERSION_INT, 6, false, null, Bundle.EMPTY);
    }

    public boolean isPlaybackOngoing() {
        return getMediaNotificationManager().isStartedInForeground();
    }

    public void pauseAllPlayersAndStopSelf() {
        List<MediaSession> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).getPlayer().setPlayWhenReady(false);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (isPlaybackOngoing()) {
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            MediaSessionServiceStub mediaSessionServiceStub = this.stub;
            if (mediaSessionServiceStub != null) {
                mediaSessionServiceStub.release();
                this.stub = null;
            }
        }
    }

    @Deprecated
    public void onUpdateNotification(MediaSession mediaSession) {
        this.defaultMethodCalled = true;
    }

    public void onUpdateNotification(MediaSession mediaSession, boolean z) {
        onUpdateNotification(mediaSession);
        if (this.defaultMethodCalled) {
            getMediaNotificationManager().updateNotification(mediaSession, z);
        }
    }

    protected final void setMediaNotificationProvider(MediaNotification.Provider provider) {
        Assertions.checkNotNull(provider);
        synchronized (this.lock) {
            this.mediaNotificationProvider = provider;
        }
    }

    IBinder getServiceBinder() {
        IBinder iBinderAsBinder;
        synchronized (this.lock) {
            iBinderAsBinder = ((MediaSessionServiceStub) Assertions.checkStateNotNull(this.stub)).asBinder();
        }
        return iBinderAsBinder;
    }

    boolean onUpdateNotificationInternal(MediaSession mediaSession, boolean z) {
        try {
            onUpdateNotification(mediaSession, getMediaNotificationManager().shouldRunInForeground(mediaSession, z));
            return true;
        } catch (IllegalStateException e) {
            if (Util.SDK_INT >= 31 && Api31.instanceOfForegroundServiceStartNotAllowedException(e)) {
                Log.e(TAG, "Failed to start foreground", e);
                onForegroundServiceStartNotAllowedException();
                return false;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaNotificationManager getMediaNotificationManager() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.lock) {
            if (this.mediaNotificationManager == null) {
                if (this.mediaNotificationProvider == null) {
                    this.mediaNotificationProvider = new DefaultMediaNotificationProvider.Builder(getApplicationContext()).build();
                }
                this.mediaNotificationManager = new MediaNotificationManager(this, this.mediaNotificationProvider, getActionFactory());
            }
            mediaNotificationManager = this.mediaNotificationManager;
        }
        return mediaNotificationManager;
    }

    private DefaultActionFactory getActionFactory() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.lock) {
            if (this.actionFactory == null) {
                this.actionFactory = new DefaultActionFactory(this);
            }
            defaultActionFactory = this.actionFactory;
        }
        return defaultActionFactory;
    }

    private Listener getListener() {
        Listener listener;
        synchronized (this.lock) {
            listener = this.listener;
        }
        return listener;
    }

    private void onForegroundServiceStartNotAllowedException() {
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m493xf9903c0b();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onForegroundServiceStartNotAllowedException$3$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m493xf9903c0b() {
        Listener listener = getListener();
        if (listener != null) {
            listener.onForegroundServiceStartNotAllowedException();
        }
    }

    private final class MediaSessionListener implements MediaSession.Listener {
        private MediaSessionListener() {
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public void onNotificationRefreshRequired(MediaSession mediaSession) {
            MediaSessionService.this.onUpdateNotificationInternal(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public boolean onPlayRequested(MediaSession mediaSession) {
            if (Util.SDK_INT < 31 || Util.SDK_INT >= 33 || MediaSessionService.this.getMediaNotificationManager().isStartedInForeground()) {
                return true;
            }
            return MediaSessionService.this.onUpdateNotificationInternal(mediaSession, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class MediaSessionServiceStub extends IMediaSessionService.Stub {
        private final Handler handler;
        private final MediaSessionManager mediaSessionManager;
        private final Set<IMediaController> pendingControllers;
        private final WeakReference<MediaSessionService> serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.serviceReference = new WeakReference<>(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.handler = new Handler(applicationContext.getMainLooper());
            this.mediaSessionManager = MediaSessionManager.getSessionManager(applicationContext);
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        @Override // androidx.media3.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                return;
            }
            try {
                final ConnectionRequest connectionRequestFromBundle = ConnectionRequest.fromBundle(bundle);
                if (this.serviceReference.get() == null) {
                    try {
                        iMediaController.onDisconnected(0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequestFromBundle.pid;
                }
                final MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequestFromBundle.packageName, callingPid, callingUid);
                final boolean zIsTrustedForMediaControl = this.mediaSessionManager.isTrustedForMediaControl(remoteUserInfo);
                this.pendingControllers.add(iMediaController);
                try {
                    this.handler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$MediaSessionServiceStub$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            this.f$0.m494x7a28fad4(iMediaController, remoteUserInfo, connectionRequestFromBundle, zIsTrustedForMediaControl);
                        }
                    });
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (RuntimeException e) {
                Log.w(MediaSessionService.TAG, "Ignoring malformed Bundle for ConnectionRequest", e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:37:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
        /* JADX INFO: renamed from: lambda$connect$0$androidx-media3-session-MediaSessionService$MediaSessionServiceStub, reason: not valid java name */
        /* synthetic */ void m494x7a28fad4(IMediaController iMediaController, MediaSessionManager.RemoteUserInfo remoteUserInfo, ConnectionRequest connectionRequest, boolean z) throws Throwable {
            Throwable th;
            Exception exc;
            this.pendingControllers.remove(iMediaController);
            boolean z2 = true;
            try {
                MediaSessionService mediaSessionService = this.serviceReference.get();
                if (mediaSessionService != null) {
                    MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, connectionRequest.libraryVersion, connectionRequest.controllerInterfaceVersion, z, new MediaSessionStub.Controller2Cb(iMediaController), connectionRequest.connectionHints);
                    try {
                        MediaSession mediaSessionOnGetSession = mediaSessionService.onGetSession(controllerInfo);
                        if (mediaSessionOnGetSession != null) {
                            mediaSessionService.addSession(mediaSessionOnGetSession);
                            try {
                                mediaSessionOnGetSession.handleControllerConnectionFromService(iMediaController, controllerInfo);
                                z2 = false;
                            } catch (Exception e) {
                                exc = e;
                                z2 = false;
                                Log.w(MediaSessionService.TAG, "Failed to add a session to session service", exc);
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = false;
                                if (z2) {
                                    try {
                                        iMediaController.onDisconnected(0);
                                        throw th;
                                    } catch (RemoteException unused) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                            if (z2) {
                                try {
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused2) {
                                    return;
                                }
                            }
                            return;
                        }
                        try {
                            iMediaController.onDisconnected(0);
                            return;
                        } catch (RemoteException unused3) {
                            return;
                        }
                    } catch (Exception e2) {
                        exc = e2;
                    }
                    Log.w(MediaSessionService.TAG, "Failed to add a session to session service", exc);
                    if (z2) {
                        iMediaController.onDisconnected(0);
                        return;
                    }
                    return;
                }
                try {
                    iMediaController.onDisconnected(0);
                } catch (RemoteException unused4) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public void release() {
            this.serviceReference.clear();
            this.handler.removeCallbacksAndMessages(null);
            Iterator<IMediaController> it = this.pendingControllers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static boolean instanceOfForegroundServiceStartNotAllowedException(IllegalStateException illegalStateException) {
            return illegalStateException instanceof ForegroundServiceStartNotAllowedException;
        }
    }
}
