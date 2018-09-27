package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.adapter.DataAdapter;
import com.viettelpost.remoteconfig.remotefirebase.app.model.ColorTag;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetJson;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;

public class HomeActivity extends AppCompatActivity {

    private static Button btnLogOut, btnLoad;
    private static RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GetJsonHttp jsonHttp = GetJsonHttp.getJsonSpi(this);

        Log.e("cocuocuocuoc", String.valueOf(0));

        findId();
        viewre();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_favorite) {
            Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void viewre() {
        GetData data = GetData.CallGetData(HomeActivity.this);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        DataAdapter adapter = new DataAdapter(data.showParamater(), HomeActivity.this, data.showDataConditions());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));

        Log.e("cocuocuocuoc222222", String.valueOf(recyclerView.getAdapter().getItemCount()));

    }

    private void findId() {
        btnLogOut = findViewById(R.id.btnOut);
        btnLoad = findViewById(R.id.btn_load);
        recyclerView = findViewById(R.id.recycel);
        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);
        fid.OverLoad(btnLoad, this);
    }


}