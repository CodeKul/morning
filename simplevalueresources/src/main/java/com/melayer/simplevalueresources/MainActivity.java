package com.melayer.simplevalueresources;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String []mobiles = getResources().getStringArray(R.array.mobiles);

        int color = getResources().getColor(R.color.bkCl);
        color = ContextCompat.getColor(this, R.color.bkCl);

        String txtOkay = getResources().getString(R.string.btnOkay);
    }
}
