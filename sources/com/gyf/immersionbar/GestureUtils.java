package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes4.dex */
class GestureUtils {
    GestureUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[PHI: r1 r2
  0x0079: PHI (r1v15 com.gyf.immersionbar.NavigationBarType) = (r1v13 com.gyf.immersionbar.NavigationBarType), (r1v26 com.gyf.immersionbar.NavigationBarType) binds: [B:66:0x00d2, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x0079: PHI (r2v14 int) = (r2v13 int), (r2v27 int) binds: [B:66:0x00d2, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef A[PHI: r1 r2
  0x00ef: PHI (r1v4 com.gyf.immersionbar.NavigationBarType) = 
  (r1v2 com.gyf.immersionbar.NavigationBarType)
  (r1v13 com.gyf.immersionbar.NavigationBarType)
  (r1v16 com.gyf.immersionbar.NavigationBarType)
  (r1v17 com.gyf.immersionbar.NavigationBarType)
  (r1v19 com.gyf.immersionbar.NavigationBarType)
  (r1v21 com.gyf.immersionbar.NavigationBarType)
  (r1v26 com.gyf.immersionbar.NavigationBarType)
 binds: [B:75:0x00ed, B:66:0x00d2, B:60:0x00ba, B:58:0x00b5, B:53:0x00a5, B:44:0x008a, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x00ef: PHI (r2v5 int) = (r2v3 int), (r2v13 int), (r2v18 int), (r2v18 int), (r2v22 int), (r2v29 int), (r2v27 int) binds: [B:75:0x00ed, B:66:0x00d2, B:60:0x00ba, B:58:0x00b5, B:53:0x00a5, B:44:0x008a, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x010d  */
    public static GestureBean getGestureBean(Context context) {
        int i;
        boolean z;
        boolean z2;
        GestureBean gestureBean = new GestureBean();
        if (context != null && context.getContentResolver() != null) {
            ContentResolver contentResolver = context.getContentResolver();
            NavigationBarType navigationBarType = NavigationBarType.UNKNOWN;
            boolean z3 = false;
            boolean z4 = true;
            if (OSUtils.isHuaWei() || OSUtils.isEMUI()) {
                if (OSUtils.isEMUI3_x()) {
                    i = Settings.System.getInt(contentResolver, "navigationbar_is_min", -1);
                } else {
                    i = Settings.Global.getInt(contentResolver, "navigationbar_is_min", -1);
                }
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                i = Settings.Global.getInt(contentResolver, "force_fsg_nav_bar", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    if (Settings.Global.getInt(contentResolver, "hide_gesture_line", -1) != 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                i = Settings.Secure.getInt(contentResolver, "navigation_gesture_on", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else {
                    if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                    } else if (i == 2) {
                        navigationBarType = NavigationBarType.GESTURES;
                    }
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                i = Settings.Secure.getInt(contentResolver, "hide_navigationbar_enable", -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1 || i == 2 || i == 3) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isSamsung()) {
                i = Settings.Global.getInt(contentResolver, "navigation_bar_gesture_while_hidden", -1);
                if (i != -1) {
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        if (Settings.Global.getInt(contentResolver, "navigation_bar_gesture_detail_type", 1) == 1) {
                            navigationBarType = NavigationBarType.GESTURES;
                        } else {
                            navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                        }
                        if (Settings.Global.getInt(contentResolver, "navigation_bar_gesture_hint", 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                } else {
                    i = Settings.Global.getInt(contentResolver, "navigationbar_hide_bar_enabled", -1);
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES;
                        z = false;
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
                i = -1;
            }
            if (i != -1) {
                z4 = z;
                z3 = z2;
            } else {
                int i2 = Settings.Secure.getInt(contentResolver, "navigation_mode", -1);
                if (i2 == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i2 == 1) {
                    navigationBarType = NavigationBarType.DOUBLE;
                } else if (i2 == 2) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z3 = true;
                } else {
                    z4 = z;
                    z3 = z2;
                }
                z4 = z;
            }
            gestureBean.isGesture = z3;
            gestureBean.checkNavigation = z4;
            gestureBean.type = navigationBarType;
        }
        return gestureBean;
    }

    static class GestureBean {
        public NavigationBarType type;
        public boolean isGesture = false;
        public boolean checkNavigation = false;

        GestureBean() {
        }

        public String toString() {
            return "GestureBean{isGesture=" + this.isGesture + ", checkNavigation=" + this.checkNavigation + ", type=" + this.type + '}';
        }
    }
}
