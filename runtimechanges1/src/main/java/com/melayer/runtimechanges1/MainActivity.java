package com.melayer.runtimechanges1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mt("onCreate");
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("timestamp", ((TextView)findViewById(R.id.textView))
                .getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            ((TextView)findViewById(R.id.textView)).setText(savedInstanceState.getString("timestamp"));
        }
    }

    public void onBtn(View view) {
        ((TextView) findViewById(R.id.textView)).setText(String.valueOf(System.currentTimeMillis()));
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
