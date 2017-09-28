package com.codekul.jsonparsing;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseUsingGson();
    }

    private void parseUsingGson() {

        Gson gson = new Gson();
        MyJson my = gson.fromJson(readJson(), MyJson.class);
        Log.i("@codekul", " Name - " + my.getNm());
        Log.i("@codekul", " Topic - " + my.getTopic());
        SubTopic sub = my.getSubTopic();
        Log.i("@codekul", "Http - " + sub.getHttp());
    }

    private void parseJson() {

        try {
            JSONObject obj = new JSONObject(readJson());
            String name = obj.getString("nm");
            int topicNum = obj.getInt("topicNum");

            Log.i("@codekul", "Name - " + name + " Topic Num - " + topicNum);

            JSONObject subTopic = obj.getJSONObject("subTopic");
            String http = subTopic.getString("http");
            Log.i("@codekul", "Http - " + http);

            JSONArray topics = obj.getJSONArray("topics");
            for (int i = 0; i < topics.length(); i++) {
                Log.i("@codekul", " Topic is " + topics.get(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String readJson() {
        AssetManager mgr = getAssets();
        StringBuilder builder = new StringBuilder();
        try {
            InputStream fis = mgr.open("prog.json");
            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
