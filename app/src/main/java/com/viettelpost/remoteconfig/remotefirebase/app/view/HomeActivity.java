package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Button;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.DataAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetJson;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;

public class HomeActivity extends AppCompatActivity {

    private Button btnLogOut;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogOut = findViewById(R.id.btnOut);
        recyclerView = (RecyclerView) findViewById(R.id.recycel);


        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);


        String etag = GetJsonHttp.getJsonSpi(this).GetEtag();
        GetData data = GetData.CallGetData(this);
        data.showParamater();


        Log.e("yyy", data.showVersion().toString() + " : " + data.showParamater().get(3).getConditionalValues().get(0).getKey());
        view();
    }

    public void view() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GetData data = GetData.CallGetData(this);
        Log.e("iiiii", data.showParamater().toString());
        DataAdapter adapter = new DataAdapter(data.showParamater(), this);
        Log.e("view", adapter.getData().get(0).getTitle());
        recyclerView.setAdapter(adapter);
    }

}