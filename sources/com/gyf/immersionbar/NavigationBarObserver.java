package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class NavigationBarObserver extends ContentObserver {
    private Application mApplication;
    private boolean mIsRegister;
    private ArrayList<OnNavigationBarListener> mListeners;

    static NavigationBarObserver getInstance() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    private NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = false;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    void register(Application application) {
        Uri uriFor;
        Uri uriFor2;
        this.mApplication = application;
        Application application2 = this.mApplication;
        if (application2 == null || application2.getContentResolver() == null || this.mIsRegister) {
            return;
        }
        Uri uriFor3 = null;
        if (OSUtils.isHuaWei() || OSUtils.isEMUI()) {
            if (OSUtils.isEMUI3_x()) {
                uriFor = Settings.System.getUriFor("navigationbar_is_min");
            } else {
                uriFor = Settings.Global.getUriFor("navigationbar_is_min");
            }
        } else {
            if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
                uriFor2 = null;
                uriFor3 = Settings.Global.getUriFor("hide_gesture_line");
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                uriFor = Settings.Secure.getUriFor("navigation_gesture_on");
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                uriFor = Settings.Secure.getUriFor("hide_navigationbar_enable");
            } else if (OSUtils.isSamsung()) {
                if (Settings.Global.getInt(this.mApplication.getContentResolver(), "navigationbar_hide_bar_enabled", -1) == -1) {
                    uriFor = Settings.Global.getUriFor("navigation_bar_gesture_while_hidden");
                    uriFor3 = Settings.Global.getUriFor("navigation_bar_gesture_detail_type");
                    uriFor2 = Settings.Global.getUriFor("navigation_bar_gesture_hint");
                } else {
                    uriFor = Settings.Global.getUriFor("navigationbar_hide_bar_enabled");
                }
            } else {
                uriFor = Settings.Secure.getUriFor("navigation_mode");
            }
            if (uriFor != null) {
                this.mApplication.getContentResolver().registerContentObserver(uriFor, true, this);
                this.mIsRegister = true;
            }
            if (uriFor3 != null) {
                this.mApplication.getContentResolver().registerContentObserver(uriFor3, true, this);
            }
            if (uriFor2 != null) {
                this.mApplication.getContentResolver().registerContentObserver(uriFor2, true, this);
            }
        }
        uriFor2 = null;
        if (uriFor != null) {
            this.mApplication.getContentResolver().registerContentObserver(uriFor, true, this);
            this.mIsRegister = true;
        }
        if (uriFor3 != null) {
            this.mApplication.getContentResolver().registerContentObserver(uriFor3, true, this);
        }
        if (uriFor2 != null) {
            this.mApplication.getContentResolver().registerContentObserver(uriFor2, true, this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        ArrayList<OnNavigationBarListener> arrayList = this.mListeners;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        GestureUtils.GestureBean gestureBean = GestureUtils.getGestureBean(this.mApplication);
        boolean z2 = true;
        if (gestureBean.isGesture && (!gestureBean.checkNavigation || BarConfig.getNavigationBarHeightInternal(this.mApplication) <= 0)) {
            z2 = false;
        }
        Iterator<OnNavigationBarListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onNavigationBarChange(z2, gestureBean.type);
        }
    }

    void addOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        if (this.mListeners.contains(onNavigationBarListener)) {
            return;
        }
        this.mListeners.add(onNavigationBarListener);
    }

    void removeOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        ArrayList<OnNavigationBarListener> arrayList;
        if (onNavigationBarListener == null || (arrayList = this.mListeners) == null) {
            return;
        }
        arrayList.remove(onNavigationBarListener);
    }

    private static class NavigationBarObserverInstance {
        private static final NavigationBarObserver INSTANCE = new NavigationBarObserver();

        private NavigationBarObserverInstance() {
        }
    }
}
