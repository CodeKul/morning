package com.melayer.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        //startActivity(intent);
        startActivityForResult(intent, 4568);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 4568) {
            if(resultCode == RESULT_OK) {
                if(data != null) {
                    Bundle bundle = data.getExtras();
                    ((TextView)findViewById(R.id.textView)).setText(bundle.getString("chkData"));
                }
            }
        }
    }
}
