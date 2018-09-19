package com.viettelpost.remoteconfig.remotefirebase.app.controll;

import android.app.ActionBar;
import android.app.Activity;
import android.view.View;


public class ControlActionBar {
    private static ControlActionBar actionBar;

    public static ControlActionBar getActionBar() {
        if (actionBar == null) {
            actionBar = new ControlActionBar();
        }
        return actionBar;
    }

    public void hideSystemUI(Activity activity) {

        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void showSystemUI(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    //    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        ControlActionBar c = ControlActionBar.getActionBar();
//        if (hasFocus) {
//            c.hideSystemUI(this);
//        }
//    }

}
