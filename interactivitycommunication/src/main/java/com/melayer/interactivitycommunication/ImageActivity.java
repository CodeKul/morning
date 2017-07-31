package com.melayer.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private final StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent resInt = getIntent();
        if (resInt != null) {
            Bundle bundle = resInt.getExtras();
            if (bundle != null) {
                String imgNm = bundle.getString("imgNm");
                if (imgNm.equals("a")) {
                    ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.ic_buses);
                } else if (imgNm.equals("b")) {
                    ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.ic_cycle);
                } else {
                    ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.ic_airport_shuttle_black_24dp);
                }
            }
        }

        ((CheckBox) findViewById(R.id.cbAnd)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) builder.append("Android");
            }
        });

        ((CheckBox) findViewById(R.id.cbApl)).setOnCheckedChangeListener(this::aplChng);

        ((CheckBox) findViewById(R.id.cbWin)).setOnCheckedChangeListener((cb, b) -> {
            if(b) builder.append("Windows");
        });
    }

    private void aplChng(CompoundButton cb, boolean b) {
        if (b) builder.append("Apple");
    }

    public void goBack(View view) {

        Bundle bundle = new Bundle();
        bundle.putString("chkData", builder.toString());

        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);
        finish();
    }
}
