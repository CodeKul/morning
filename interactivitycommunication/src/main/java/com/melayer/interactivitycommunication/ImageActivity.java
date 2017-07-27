package com.melayer.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent resInt = getIntent();
        if(resInt != null) {
            Bundle bundle = resInt.getExtras();
            if(bundle != null) {
                String imgNm = bundle.getString("imgNm");
                if(imgNm.equals("a")) {
                    ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_buses);
                }
                else if(imgNm.equals("b")){
                    ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_cycle);
                }
                else {
                    ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_airport_shuttle_black_24dp);
                }
            }
        }
    }

    public void goBack(View view) {

    }
}
