package com.codekul.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private RequestQueue q; // write this in the application class
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q = Volley.newRequestQueue(this);
        gson = new Gson();
    }

    public void onWeather(View view) {
        q.add(new StringRequest(
                "http://api.openweathermap.org/data/2.5/weather?q=" + getCity() + "&APPID=7406c21bb1cb9f59d936a59c4e890279",
                this::onResponse,
                this::onError
        ));
    }

    private void onResponse(String res) {
        Log.i("@codekul", res);

        MyWeather weather = gson.fromJson(res, MyWeather.class);
        ((TextView) findViewById(R.id.txtTmp)).setText("" + weather.getMain().getTemp() + ", " + weather.getWeather().get(0).getDescription());
    }

    private void onError(VolleyError err) {

    }

    private String getCity() {
        return ((EditText) findViewById(R.id.etCty)).getText().toString();
    }
}
