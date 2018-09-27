package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.ChildViewHoder;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.DataAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.EditItemAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetJson;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.ConditionaValues;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.Conditions;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.parameters;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class EditItemActivity extends AppCompatActivity {

    private ArrayList<Conditions> conditionaValues;
    private ArrayList<parameters> data;
    private Context context;
    private EditText editTitle, editDess, editDefau;
    private int cusor;
    private RecyclerView recyclerView;
    Button btnSave;
    EditItemAdapter adapter;
    ChildViewHoder chi;
    private GetJson getJson = GetJson.getJsonConditions(this);
    JSONObject jsonObject;
    JSONObject j = new JSONObject();
    JSONObject jDefau = null;
    JSONObject jCondition = null;
    JSONObject jChildCondition = null;
    int e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        findId();

        if (data.get(cusor).getTitle().length() != 0) {
            editTitle.setText(data.get(cusor).getTitle());
        }
        if (data.get(cusor).getDescription().length() != 0) {
            editDess.setText(data.get(cusor).getDescription());
        }
        if (data.get(cusor).getDefaultValue().length() != 0) {
            editDefau.setText(data.get(cusor).getDefaultValue());
        }
        if (data.get(cusor).getConditionalValues().size() != 0) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            adapter = new EditItemAdapter(data.get(cusor).getConditionalValues(), this, conditionaValues);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } else if (data.get(cusor).getConditionalValues().size() == 0) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMyJson();


            }
        });
    }

    private void findId() {
        data = (ArrayList<parameters>) getIntent().getSerializableExtra("data");
        cusor = getIntent().getIntExtra("cusor", 0);

        GetData dataa = GetData.CallGetData(this);
        conditionaValues = dataa.showDataConditions();

        editTitle = findViewById(R.id.edit_title);
        editDess = findViewById(R.id.edit_dess);
        editDefau = findViewById(R.id.edit_defau);
        recyclerView = findViewById(R.id.recy_item);
        btnSave = findViewById(R.id.btn_save);
    }

    public void getMyJson() {
        String mJson = "";
        try {

            jsonObject = new JSONObject(getJson.getJsonParamater());
            Iterator<String> iter = jsonObject.keys();
            while (iter.hasNext()) {

                String title = "";
                title = iter.next();

                if (data.get(cusor).getTitle().equals(title)) {

                    String vTitle = editTitle.getText().toString();
                    String vDess = editDess.getText().toString();
                    String vDefau = editDefau.getText().toString();

                    JSONObject jsonObject2 = jsonObject.getJSONObject(title);
                    JSONObject jsonObject3 = new JSONObject(jsonObject2.toString());
                    JSONObject jsonObject4 = jsonObject3.getJSONObject("defaultValue");
                    JSONObject jsonObject5 = null;


                    String o = myObjectJson(jsonObject2, jsonObject3, jsonObject4, jsonObject5);

                    GetJsonHttp g = GetJsonHttp.getJsonSpi(EditItemActivity.this);
                    g.upLoad(o);

                }
            }
        } catch (Exception e) {
        }
    }


    private String myObjectJson(JSONObject jsonObject2, JSONObject jsonObject3, JSONObject jsonObject4, JSONObject jsonObject5) {
        String myAdd = "";
        try {

            if (jsonObject3.has("description")) {
                j.put("description", editDess.getText().toString());
            }


            jDefau = new JSONObject();
            jDefau.put("value", editDefau.getText().toString());


            jCondition = new JSONObject();
            if (jsonObject3.has("conditionalValues")) {
                jsonObject5 = new JSONObject(jsonObject3.getJSONObject("conditionalValues").toString());
                for (int i = 0; i < adapter.getItemCount(); i++) {
                    jChildCondition = new JSONObject();
                    chi = (ChildViewHoder)
                            recyclerView.findViewHolderForAdapterPosition(i);
                    String value = chi.editConditionValue.getText().toString();
                    String key = chi.txtConditionKey.getText().toString();
                    JSONObject jsonObject6 = jsonObject5.getJSONObject(key);
                    jChildCondition.put("value", value);
                    jCondition.put(key, jChildCondition);
                }
                j.put("conditionalValues", jCondition);
            }
            j.put("defaultValue", jDefau);

            jsonObject.remove(data.get(cusor).getTitle());
            jsonObject.put(editTitle.getText().toString(), j);

            myAdd = "\"parameters\":" + jsonObject.toString();
        } catch (Exception e) {
        }
        return myAdd;
    }
}
