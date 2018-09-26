package com.viettelpost.remoteconfig.remotefirebase.data.api.rest;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.viettelpost.remoteconfig.remotefirebase.app.model.GetJson;
import com.viettelpost.remoteconfig.remotefirebase.data.domain.KeyRest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class GetJsonHttp {
    private static Context context;
    private static GetJsonHttp jsonHttp;
    private static String viewJsonHttp;
    private static KeyRest keyRest = KeyRest.getKeyRest();
    private static String BASE_URL = keyRest.getBaseUrl();
    private static String REMOTE_CONFIG_ENDPOINT = keyRest.getRemoteConfigEndpoint();

    private GetJsonHttp(Context a) {
        this.context = a;
    }

    public static GetJsonHttp getJsonSpi(Context a) {
        if (jsonHttp == null) {
            jsonHttp = new GetJsonHttp(a);
        }
        return jsonHttp;
    }

    public String getTemplate() {
        try {
            HttpURLConnection httpURLConnection = getCommonConnection(BASE_URL + REMOTE_CONFIG_ENDPOINT);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");

            int code = httpURLConnection.getResponseCode();
            if (code == 200) {
                InputStream inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                String response = inputstreamToString(inputStream);

                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse(response);

                Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                viewJsonHttp = gson.toJson(jsonElement);

//            File file = new File("config.json");
//            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
//            printWriter.print(jsonStr);
//            printWriter.flush();
//            printWriter.close();

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("myData.json", context.MODE_PRIVATE));
                outputStreamWriter.write(viewJsonHttp);
                outputStreamWriter.close();

                // Print ETag


            } else {
                System.out.println(inputstreamToString(httpURLConnection.getErrorStream()));
            }
        } catch (Exception e) {
        }

        return viewJsonHttp;
    }

    private static String inputstreamToString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

    private static HttpURLConnection getCommonConnection(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + GetTokenApi.CallGetTokenApi(context).viewToken());
        httpURLConnection.setRequestProperty("Content-Type", "application/json; UTF-8");
        return httpURLConnection;
    }

    public String GetEtag() {
        String etag = "";
        try {
            HttpURLConnection httpURLConnection = getCommonConnection(BASE_URL + REMOTE_CONFIG_ENDPOINT);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            etag = httpURLConnection.getHeaderField("ETag");
        } catch (Exception e) {
        }

        return etag;
    }

    public interface callBack {
        public void getMyJson(String json);
    }
}
