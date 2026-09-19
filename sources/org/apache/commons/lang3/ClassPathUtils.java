package org.apache.commons.lang3;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class ClassPathUtils {
    public static String packageToPath(String str) {
        return ((String) Objects.requireNonNull(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)).replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/');
    }

    public static String pathToPackage(String str) {
        return ((String) Objects.requireNonNull(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)).replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r1, String str) {
        Objects.requireNonNull(r1, "context");
        Objects.requireNonNull(str, "resourceName");
        return r1.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Package r1, String str) {
        Objects.requireNonNull(r1, "context");
        Objects.requireNonNull(str, "resourceName");
        return packageToPath(r1.getName()) + DomExceptionUtils.SEPARATOR + str;
    }

    @Deprecated
    public ClassPathUtils() {
    }
}
