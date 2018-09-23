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

    private static Button btnLogOut;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findId();
        viewre();
    }

    private void viewre() {

        GetData data = GetData.CallGetData(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DataAdapter adapter = new DataAdapter(data.showParamater(), this, data.showDataConditions());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void findId() {
        btnLogOut = findViewById(R.id.btnOut);
        recyclerView = findViewById(R.id.recycel);
        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);
        GetJsonHttp jsonHttp = GetJsonHttp.getJsonSpi(this);
    }

}