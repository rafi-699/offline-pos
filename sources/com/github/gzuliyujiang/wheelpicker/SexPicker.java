package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import com.facebook.appevents.AppEventsConstants;
import com.github.gzuliyujiang.dialog.DialogLog;
import com.github.gzuliyujiang.wheelpicker.entity.SexEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SexPicker extends OptionPicker {
    public static String JSON = "[{\"id\":0,\"name\":\"保密\",\"english\":\"Secrecy\"},\n{\"id\":1,\"name\":\"男\",\"english\":\"Male\"},\n{\"id\":2,\"name\":\"女\",\"english\":\"Female\"}]";
    private boolean includeSecrecy;

    public SexPicker(Activity activity) {
        super(activity);
    }

    public SexPicker(Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    public void setIncludeSecrecy(boolean includeSecrecy) {
        this.includeSecrecy = includeSecrecy;
        setData(provideData());
    }

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    public void setDefaultValue(Object item) {
        if (item instanceof String) {
            setDefaultValueByName(item.toString());
        } else {
            super.setDefaultValue(item);
        }
    }

    public void setDefaultValueByName(String name) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setName(name);
        super.setDefaultValue(sexEntity);
    }

    public void setDefaultValueByEnglish(String english) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setEnglish(english);
        super.setDefaultValue(sexEntity);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.OptionPicker
    protected List<?> provideData() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(JSON);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                SexEntity sexEntity = new SexEntity();
                sexEntity.setId(jSONObject.getString("id"));
                sexEntity.setName(jSONObject.getString("name"));
                sexEntity.setEnglish(jSONObject.getString("english"));
                if (this.includeSecrecy || !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(sexEntity.getId())) {
                    arrayList.add(sexEntity);
                }
            }
            return arrayList;
        } catch (JSONException e) {
            DialogLog.print(e);
            return arrayList;
        }
    }
}
