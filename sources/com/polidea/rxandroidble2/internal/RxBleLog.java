package com.polidea.rxandroidble2.internal;

import android.util.Log;
import com.polidea.rxandroidble2.LogOptions;
import com.polidea.rxandroidble2.internal.logger.LoggerSetup;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class RxBleLog {

    @Deprecated
    public static final int DEBUG = 3;

    @Deprecated
    public static final int ERROR = 6;

    @Deprecated
    public static final int INFO = 4;
    private static final LogOptions.Logger LOGCAT_LOGGER;

    @Deprecated
    public static final int NONE = Integer.MAX_VALUE;

    @Deprecated
    public static final int VERBOSE = 2;

    @Deprecated
    public static final int WARN = 5;
    private static LoggerSetup loggerSetup;
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");
    private static final ThreadLocal<String> NEXT_TAG = new ThreadLocal<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        void log(int i, String str, String str2);
    }

    static {
        LogOptions.Logger logger = new LogOptions.Logger() { // from class: com.polidea.rxandroidble2.internal.RxBleLog.1
            @Override // com.polidea.rxandroidble2.LogOptions.Logger
            public void log(int i, String str, String str2) {
                Log.println(i, str, str2);
            }
        };
        LOGCAT_LOGGER = logger;
        loggerSetup = new LoggerSetup(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false, true, logger);
    }

    private RxBleLog() {
    }

    @Deprecated
    public static void setLogger(final Logger logger) {
        LogOptions.Logger logger2;
        if (logger == null) {
            logger2 = LOGCAT_LOGGER;
        } else {
            logger2 = new LogOptions.Logger() { // from class: com.polidea.rxandroidble2.internal.RxBleLog.2
                @Override // com.polidea.rxandroidble2.LogOptions.Logger
                public void log(int i, String str, String str2) {
                    logger.log(i, str, str2);
                }
            };
        }
        updateLogOptions(new LogOptions.Builder().setLogger(logger2).build());
    }

    @Deprecated
    public static void setLogLevel(int i) {
        updateLogOptions(new LogOptions.Builder().setLogLevel(Integer.valueOf(i)).build());
    }

    public static void updateLogOptions(LogOptions logOptions) {
        LoggerSetup loggerSetup2 = loggerSetup;
        LoggerSetup loggerSetupMerge = loggerSetup2.merge(logOptions);
        d("Received new options (%s) and merged with old setup: %s. New setup: %s", logOptions, loggerSetup2, loggerSetupMerge);
        loggerSetup = loggerSetupMerge;
    }

    private static String createTag() {
        String strSubstring;
        ThreadLocal<String> threadLocal = NEXT_TAG;
        String str = threadLocal.get();
        if (str != null) {
            threadLocal.remove();
            return str;
        }
        int i = 0;
        List listAsList = Arrays.asList(RxBleLog.class.getName(), LoggerUtil.class.getName(), LoggerUtilBluetoothServices.class.getName());
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        while (i < stackTrace.length && listAsList.contains(stackTrace[i].getClassName())) {
            i++;
        }
        if (stackTrace.length <= i) {
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?", th);
        }
        String className = stackTrace[i].getClassName();
        Matcher matcher = ANONYMOUS_CLASS.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String strReplace = className.replace("Impl", "").replace("RxBle", "");
        int iIndexOf = strReplace.indexOf(36);
        if (iIndexOf <= 0) {
            strSubstring = strReplace.substring(strReplace.lastIndexOf(46) + 1);
        } else {
            strSubstring = strReplace.substring(strReplace.lastIndexOf(46) + 1, iIndexOf);
        }
        return "RxBle#" + strSubstring;
    }

    private static String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static void v(String str, Object... objArr) {
        throwShade(2, null, str, objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        throwShade(2, th, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        throwShade(3, null, str, objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        throwShade(3, th, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        throwShade(4, null, str, objArr);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        throwShade(4, th, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        throwShade(5, null, str, objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        throwShade(5, th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        throwShade(6, null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        throwShade(6, th, str, objArr);
    }

    private static void throwShade(int i, Throwable th, String str, Object... objArr) {
        if (i < loggerSetup.logLevel) {
            return;
        }
        String string = formatString(str, objArr);
        if (string == null || string.length() == 0) {
            if (th == null) {
                return;
            } else {
                string = Log.getStackTraceString(th);
            }
        } else if (th != null) {
            string = string + "\n" + Log.getStackTraceString(th);
        }
        println(i, createTag(), string);
    }

    private static void println(int i, String str, String str2) {
        if (str2.length() < 4000) {
            loggerSetup.logger.log(i, str, str2);
            return;
        }
        for (String str3 : str2.split("\n")) {
            loggerSetup.logger.log(i, str, str3);
        }
    }

    public static boolean isAtLeast(int i) {
        return loggerSetup.logLevel <= i;
    }

    public static int getMacAddressLogSetting() {
        return loggerSetup.macAddressLogSetting;
    }

    public static int getUuidLogSetting() {
        return loggerSetup.uuidLogSetting;
    }

    public static boolean getShouldLogAttributeValues() {
        return loggerSetup.shouldLogAttributeValues;
    }

    public static boolean getShouldLogScannedPeripherals() {
        return loggerSetup.shouldLogScannedPeripherals;
    }
}
