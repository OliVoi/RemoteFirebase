package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.app.Activity;
import android.app.Application;
import android.support.multidex.MultiDexApplication;

public class MultiApplication extends Activity{
    private static MultiApplication sInstance;

    public static MultiApplication getsInstance() {
        if(sInstance == null){
            sInstance = new MultiApplication();
        }
        return sInstance;
    }
}
