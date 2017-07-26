package com.melayer.viewprops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean isVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOkay(View view){
        if(isVisible)
            findViewById(R.id.btnOkay).setVisibility(View.GONE);
        else findViewById(R.id.btnOkay).setVisibility(View.VISIBLE);
        isVisible = !isVisible;
    }
}
