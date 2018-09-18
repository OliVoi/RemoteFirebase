package com.viettelpost.remoteconfig.remotefirebase.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.viettelpost.remoteconfig.remotefirebase.Controll.ControlActionBar;
import com.viettelpost.remoteconfig.remotefirebase.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        ControlActionBar c = ControlActionBar.getActionBar();
//        if (hasFocus) {
//            c.hideSystemUI(this);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}