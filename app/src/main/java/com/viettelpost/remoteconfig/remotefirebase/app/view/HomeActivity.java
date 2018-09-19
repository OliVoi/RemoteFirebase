package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetTokenApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class HomeActivity extends AppCompatActivity {

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogOut = findViewById(R.id.btnOut);

        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);

        String tokenApi = GetTokenApi.CallGetTokenApi(this).viewToken();
        String json = GetJsonHttp.getJsonSpi(this).getJsonHttp();
        Log.e("----", tokenApi + "oooo" + json);

        OutputStream outputStream = null;
        try {
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.setIndent("  ");
            writer.close();
        }
        catch (Exception e){

        }



    }


}