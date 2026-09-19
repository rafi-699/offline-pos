package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.gamingservices.GamingPayload;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CloudGameLoginHandler {
    private static final int DEFAULT_TIMEOUT_IN_SEC = 5;
    private static boolean IS_RUNNING_IN_CLOUD = false;
    private static SDKLogger mLogger;

    public static synchronized AccessToken init(Context context) throws FacebookException {
        return init(context, 5);
    }

    public static synchronized AccessToken init(Context context, int i) throws FacebookException {
        AccessToken currentAccessToken;
        if (i <= 0) {
            i = 5;
        }
        if (!isCloudEnvReady(context, i)) {
            throw new FacebookException("Not running in Cloud environment.");
        }
        mLogger = SDKLogger.getInstance(context);
        GraphResponse graphResponseExecuteAndWait = DaemonRequest.executeAndWait(context, null, SDKMessageEnum.GET_ACCESS_TOKEN, i);
        if (graphResponseExecuteAndWait == null || graphResponseExecuteAndWait.getGraphObject() == null) {
            throw new FacebookException("Cannot receive response.");
        }
        if (graphResponseExecuteAndWait.getError() != null) {
            throw new FacebookException(graphResponseExecuteAndWait.getError().getErrorMessage());
        }
        setPackageName(graphResponseExecuteAndWait.getGraphObject(), context);
        try {
            currentAccessToken = setCurrentAccessToken(graphResponseExecuteAndWait.getGraphObject());
            GamingPayload.loadPayloadFromCloudGame(graphResponseExecuteAndWait.getGraphObject().optString("payload"));
            Profile.fetchProfileForCurrentAccessToken();
            IS_RUNNING_IN_CLOUD = true;
            mLogger.logLoginSuccess();
        } catch (JSONException e) {
            throw new FacebookException("Cannot properly handle response.", e);
        }
        return currentAccessToken;
    }

    public static boolean isRunningInCloud() {
        return IS_RUNNING_IN_CLOUD;
    }

    private static boolean isCloudEnvReady(Context context, int i) {
        GraphResponse graphResponseExecuteAndWait = DaemonRequest.executeAndWait(context, null, SDKMessageEnum.IS_ENV_READY, i);
        return (graphResponseExecuteAndWait == null || graphResponseExecuteAndWait.getGraphObject() == null || graphResponseExecuteAndWait.getError() != null) ? false : true;
    }

    public static void gameLoadComplete(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.MARK_GAME_LOADED);
    }

    private static void setPackageName(JSONObject jSONObject, Context context) {
        String strOptString = jSONObject.optString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME);
        if (strOptString.isEmpty()) {
            throw new FacebookException("Could not establish a secure connection.");
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).edit();
        editorEdit.putString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, strOptString);
        editorEdit.commit();
    }

    private static AccessToken setCurrentAccessToken(JSONObject jSONObject) throws JSONException {
        String str;
        long j;
        Date date;
        String strOptString = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN);
        String strOptString2 = jSONObject.optString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE);
        String strOptString3 = jSONObject.optString(SDKConstants.PARAM_APP_ID);
        String strOptString4 = jSONObject.optString(SDKConstants.PARAM_DECLINED_PERMISSIONS);
        String strOptString5 = jSONObject.optString(SDKConstants.PARAM_EXPIRED_PERMISSIONS);
        String strOptString6 = jSONObject.optString(SDKConstants.PARAM_EXPIRATION_TIME);
        String strOptString7 = jSONObject.optString(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME);
        String strOptString8 = jSONObject.optString(SDKConstants.PARAM_GRAPH_DOMAIN);
        String strOptString9 = jSONObject.optString(SDKConstants.PARAM_LAST_REFRESH_TIME);
        String strOptString10 = jSONObject.optString("permissions");
        String strOptString11 = jSONObject.optString(SDKConstants.PARAM_USER_ID);
        String strOptString12 = jSONObject.optString(SDKConstants.PARAM_SESSION_ID);
        if (strOptString.isEmpty() || strOptString3.isEmpty() || strOptString11.isEmpty()) {
            return null;
        }
        SDKLogger sDKLogger = mLogger;
        if (sDKLogger != null) {
            sDKLogger.setAppID(strOptString3);
            mLogger.setUserID(strOptString11);
            mLogger.setSessionID(strOptString12);
        }
        List<String> listConvertPermissionsStringIntoPermissionsList = convertPermissionsStringIntoPermissionsList(strOptString10);
        List<String> listConvertPermissionsStringIntoPermissionsList2 = convertPermissionsStringIntoPermissionsList(strOptString4);
        List<String> listConvertPermissionsStringIntoPermissionsList3 = convertPermissionsStringIntoPermissionsList(strOptString5);
        AccessTokenSource accessTokenSourceValueOf = !strOptString2.isEmpty() ? AccessTokenSource.valueOf(strOptString2) : null;
        if (strOptString6.isEmpty()) {
            str = null;
            j = 1000;
            date = null;
        } else {
            str = null;
            j = 1000;
            date = new Date(((long) Integer.parseInt(strOptString6)) * 1000);
        }
        AccessToken accessToken = new AccessToken(strOptString, strOptString3, strOptString11, listConvertPermissionsStringIntoPermissionsList, listConvertPermissionsStringIntoPermissionsList2, listConvertPermissionsStringIntoPermissionsList3, accessTokenSourceValueOf, date, !strOptString9.isEmpty() ? new Date(((long) Integer.parseInt(strOptString9)) * j) : str, !strOptString7.isEmpty() ? new Date(((long) Integer.parseInt(strOptString7)) * j) : str, !strOptString8.isEmpty() ? strOptString8 : str);
        AccessToken.setCurrentAccessToken(accessToken);
        return accessToken;
    }

    private static List<String> convertPermissionsStringIntoPermissionsList(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!str.isEmpty()) {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
        }
        return arrayList;
    }
}
