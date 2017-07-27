package com.melayer.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goNext(View view) {

        Class cls = ImageActivity.class;

        Bundle bundle = new Bundle();
        bundle.putString("imgNm",
                ((EditText)(findViewById(R.id.etImgNm))).getText().toString());

        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
