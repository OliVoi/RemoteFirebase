package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.app.Activity;
import android.util.Log;

import com.google.gson.JsonObject;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Version;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class GetData {
    private static GetData getData;
    private String key;
    private static Activity activity;
    private static ArrayList<parameters> getParamater;
    private static ArrayList<Conditions> getConditions;
    private static ArrayList<Version> getVersion;
    private static ArrayList<ConditionaValues> conditionaValues;
    private static GetJson getJson = GetJson.getJsonConditions(activity);

    private GetData(Activity a) {
        this.activity = a;
    }

    public GetData() {
    }

    public static GetData CallGetData(Activity a) {
        if (getData == null) {
            getData = new GetData(a);
        }
        return getData;
    }

    public ArrayList<Conditions> showDataConditions() {
        int i = 0;
        getConditions = new ArrayList<Conditions>();
        try {
            JSONArray jsonArray = new JSONArray(getJson.getJsonCondition());
            if (!jsonArray.isNull(0)) {
                for (; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String expression = jsonObject.getString("expression");
                    String tagColor = jsonObject.getString("tagColor");
                    Conditions conditions = new Conditions(name, expression, tagColor);
                    getConditions.add(conditions);
                    Log.e("lll", getConditions.get(i).getName());
                }
            }
        } catch (Exception e) {
        }
        return getConditions;
    }

    public ArrayList<Version> showVersion() {
        int i = 0;
        getVersion = new ArrayList<Version>();
        try {
            JSONObject jsonObject = new JSONObject(getJson.getJsonVersion());
            String updateUser = jsonObject.getJSONObject("updateUser").getString("email");
            String versionNumber = jsonObject.getString("versionNumber");
            String updateTime = jsonObject.getString("updateTime");
            String updateOrigin = jsonObject.getString("updateOrigin");
            String updateType = jsonObject.getString("updateType");

            Version version = new Version(versionNumber, updateTime, updateUser, updateOrigin, updateType);

            getVersion.add(version);
            Log.e("lll", getVersion.get(i).getUpdateTime());

        } catch (Exception e) {
        }
        return getVersion;
    }

    public ArrayList<parameters> showParamater() {

        getParamater = new ArrayList<parameters>();
        parameters parameters = null;

        try {
            Log.v("hung: ", getJson.getJsonParamater().toString());
            JSONObject jsonObject = new JSONObject(getJson.getJsonParamater());
            Iterator<String> iter = jsonObject.keys();

            while (iter.hasNext()) {
                String description = "";
                String title = "";
                String defaultValue = "";
                String conditionalValues = "";
                String conditionalKey = "";

                title = iter.next();
                JSONObject jsonObject2 = jsonObject.getJSONObject(title);

                JSONObject jsonObject3 = new JSONObject(jsonObject2.toString());


                if (jsonObject3.has("description")) {
                    description = jsonObject3.getString("description");
                }
                Log.e("hhhh", description);

                if (jsonObject3.has("conditionalValues")) {
                    conditionaValues = new ArrayList<ConditionaValues>();
                    JSONObject jsonObject5 = new JSONObject(jsonObject3.getJSONObject("conditionalValues").toString());
                    Iterator<String> iter2 = jsonObject5.keys();
                    while (iter2.hasNext()) {
                        conditionalKey = iter2.next();
                        JSONObject jsonObject6 = jsonObject5.getJSONObject(conditionalKey);
                        conditionalValues = jsonObject6.getString("value");
                        ConditionaValues co = new ConditionaValues(conditionalValues, conditionalKey);
                        conditionaValues.add(co);
                        Log.e("value", conditionalKey + " : " + jsonObject6.getString("value"));
                    }
                }
                JSONObject jsonObject4 = jsonObject3.getJSONObject("defaultValue");
                defaultValue = jsonObject4.getString("value");

                Log.e("value thuc: ", title + " : " + description + " : " + defaultValue + " : " + conditionalValues + " : " + conditionalKey);
                parameters = new parameters(title, description, defaultValue, conditionaValues);
                getParamater.add(parameters);

            }


        } catch (Exception e)

        {
        }
        return getParamater;
    }

}
