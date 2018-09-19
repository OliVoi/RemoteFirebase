package com.viettelpost.remoteconfig.remotefirebase.data.domain;

public class KeyRest {
    private final static String PROJECT_ID = "newlocation-31a4a";
    private final static String BASE_URL = "https://firebaseremoteconfig.googleapis.com";
    private final static String REMOTE_CONFIG_ENDPOINT = "/v1/projects/" + PROJECT_ID + "/remoteConfig";
    private final static String SCOPES = "https://www.googleapis.com/auth/firebase.remoteconfig";
    private static KeyRest keyRest;

    public KeyRest() {
    }

    public static KeyRest getKeyRest() {
        if(keyRest == null){
            keyRest = new KeyRest();
        }
        return keyRest;
    }

    public String getProjectId() {
        return PROJECT_ID;
    }

    public String getBaseUrl() {
        return BASE_URL;
    }

    public String getRemoteConfigEndpoint() {
        return REMOTE_CONFIG_ENDPOINT;
    }

    public String getSCOPES() {
        return SCOPES;
    }
}
