package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.app.Activity;

import com.google.gson.JsonObject;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetJson {
    private static GetJson jsonConditions;
    private static String thisJsonCondition, thisJsonVersion, thisJsonParamater;
    private static Activity activity;
    private static String http = GetJsonHttp.getJsonSpi(activity).getJsonHttp();
    private static JSONObject jsonObject;

    public GetJson(Activity a) {
        this.activity = a;
    }

    public static GetJson getJsonConditions(Activity a) {
        if (jsonConditions == null) {
            jsonConditions = new GetJson(a);
        }
        return jsonConditions;
    }

    public String getJsonCondition() {
        try {
            jsonObject = new JSONObject(http);
            JSONArray jsonArray = jsonObject.getJSONArray("conditions");
            thisJsonCondition = jsonArray.toString();
        } catch (Exception e) {
        }
        return thisJsonCondition;
    }

    public String getJsonVersion() {
        try {
            jsonObject = new JSONObject(http);
            JSONObject jsonObject2 = jsonObject.getJSONObject("version");
            thisJsonVersion = jsonObject2.toString();
        } catch (Exception e) {
        }
        return thisJsonVersion;
    }

    public String getJsonParamater() {
        try {
            jsonObject = new JSONObject(http);
            JSONObject jsonObject2 = jsonObject.getJSONObject("parameters");
            thisJsonParamater = jsonObject2.toString();
        } catch (Exception e) {
        }
        return thisJsonParamater;
    }


}
