package com.codekul.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeData();

        readData();
    }

    void writeData() {
        prefs = getSharedPreferences("my", MODE_APPEND);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("_int", 10);
        editor.putFloat("_float", 45.6f);
        editor.apply();
    }

    void readData() {
        prefs = getSharedPreferences("my", MODE_APPEND);
        Log.i("@codekul", "Int val "+prefs.getInt("_int", -1));
        Log.i("@codekul", "Float val "+prefs.getFloat("_float", -1.0f));
    }
}
