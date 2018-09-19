package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetTokenApi;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogOut = findViewById(R.id.btnOut);

        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);

        GetTokenApi tokenApi = GetTokenApi.CallGetTokenApi(this);

        try {
            tokenApi.showToken();
            Log.e("----", tokenApi.showToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
