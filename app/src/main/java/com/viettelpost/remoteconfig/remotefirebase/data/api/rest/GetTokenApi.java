package com.viettelpost.remoteconfig.remotefirebase.data.api.rest;

//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import android.app.Activity;
import android.content.Context;
import android.os.StrictMode;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.KeyRest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class GetTokenApi {
    private static GetTokenApi getTokenApi;
    private static KeyRest keyRest = KeyRest.getKeyRest();
    private static Activity activity;

    private GetTokenApi(Activity a) {
        this.activity = a;
    }

    public static GetTokenApi CallGetTokenApi(Activity a) {
        if (getTokenApi == null) {
            getTokenApi = new GetTokenApi(a);
        }
        return getTokenApi;
    }


    public String showToken() throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        InputStream inputStream = activity.getApplicationContext().getResources().getAssets()
                .open("keyAdmin.json", Context.MODE_WORLD_READABLE);
        String SCOPES = keyRest.getSCOPES();
        GoogleCredential googleCredential = GoogleCredential
                .fromStream(inputStream)
                .createScoped(Arrays.asList(SCOPES));
        googleCredential.refreshToken();
        System.out.println(googleCredential.getAccessToken());
        return googleCredential.getAccessToken();
    }
}
