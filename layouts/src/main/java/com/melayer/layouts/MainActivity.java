package com.melayer.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        /*MainActivity main = this;
        Context context = main;*/
        Button btn = new Button(this);
        btn.setText("CodeKul");

        FrameLayout frame = findViewById(R.id.frameDynamic);
        frame.addView(btn);
    }
}
