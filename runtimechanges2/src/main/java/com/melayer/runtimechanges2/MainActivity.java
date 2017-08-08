package com.melayer.runtimechanges2;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mt("onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mt("onConfigurationChanged");

        Locale lcl = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            lcl = newConfig.getLocales().get(0);
        } else {
            lcl = newConfig.locale;
        }
        if (lcl.equals(Locale.forLanguageTag("hi")))
            ((TextView) findViewById(R.id.textView)).setText("नमस्कार");
        else ((TextView) findViewById(R.id.textView)).setText("Hello");
    }
}
