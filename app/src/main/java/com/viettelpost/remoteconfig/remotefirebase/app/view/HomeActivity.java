package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetData;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetJson;
import com.viettelpost.remoteconfig.remotefirebase.data.api.rest.GetJsonHttp;

public class HomeActivity extends AppCompatActivity {

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogOut = findViewById(R.id.btnOut);

        EvenActivityMain fid = EvenActivityMain.getFind(this);
        fid.getLogOut(btnLogOut);


        String etag = GetJsonHttp.getJsonSpi(this).GetEtag();
        GetData data = GetData.CallGetData(this);



        Log.e("yyy",data.showVersion().toString() +" : "+ data.showParamater().get(3).getConditionalValues().get(0).getKey());

    }

}