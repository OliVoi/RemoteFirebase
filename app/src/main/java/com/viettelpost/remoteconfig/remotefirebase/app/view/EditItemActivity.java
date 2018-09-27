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


//                GetJsonHttp g = GetJsonHttp.getJsonSpi(EditItemActivity.this);
//                g.upLoad("");


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

    public String getMyJson() {
        String mJson = "";
        try {

            jsonObject = new JSONObject(getJson.getJsonParamater());
            Iterator<String> iter = jsonObject.keys();
            while (iter.hasNext()) {

                String title = "";
                title = iter.next();
                Log.e("ititrititi", title);

                if (editTitle.getText().toString().equals(title)) {

                    JSONObject jsonObject2 = jsonObject.getJSONObject(title);
                    Log.e("33333333333", jsonObject2.toString());

                    JSONObject jsonObject3 = new JSONObject(jsonObject2.toString());

                    if (jsonObject3.has("description") && jsonObject3.getString("description") != editDess.toString()) {
                        jsonObject3.put("description", editDess);
                        Log.e("33333333333", jsonObject3.toString());
                    }

                    if (jsonObject3.has("defaultValue")) {
                        JSONObject jsonObject4 = jsonObject3.getJSONObject("defaultValue");
                        jsonObject4.put("value", editDefau);
                        Log.e("4444444444", jsonObject4.toString());
                    }

                    if (jsonObject3.has("conditionalValues")) {

                        JSONObject jsonObject5 = new JSONObject(jsonObject3.getJSONObject("conditionalValues").toString());
                        Log.e("iiiiiiooioioio", jsonObject5.toString());

                        for (int i = 0; i < adapter.getItemCount(); i++) {
                            chi = (ChildViewHoder)
                                    recyclerView.findViewHolderForAdapterPosition(i);
                            String value = chi.editConditionValue.toString();
                            String key = chi.txtConditionKey.toString();
                            JSONObject jsonObject6 = jsonObject5.getJSONObject(key);
                           // jsonObject6.put("value", value);

                            Log.e("666666666", jsonObject6.toString());
                        }
                    }

                    Log.e("tptptptp", jsonObject3.toString());
                    jsonObject.remove(title);
                }
            }
        } catch (Exception e) {
        }
        return mJson;
    }


    public void upLoad() {

    }

}
