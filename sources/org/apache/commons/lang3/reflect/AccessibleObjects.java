package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes5.dex */
class AccessibleObjects {
    AccessibleObjects() {
    }

    static boolean isAccessible(AccessibleObject accessibleObject) {
        return accessibleObject == null || accessibleObject.isAccessible();
    }

    static boolean setAccessible(AccessibleObject accessibleObject) {
        if (isAccessible(accessibleObject)) {
            return false;
        }
        accessibleObject.setAccessible(true);
        return true;
    }
}
