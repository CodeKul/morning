package com.melayer.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    public void onNew(View view) {
        LinearLayout container = findViewById(R.id.llContainer);

        final View inflatedView = inflater.inflate(R.layout.custom_item, container, false );
        container.addView(inflatedView);

        CheckBox chk = inflatedView.findViewById(R.id.chk);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    TextView txt = inflatedView.findViewById(R.id.txt);
                    txt.setText("Checked");
                }
                else {
                    TextView txt = inflatedView.findViewById(R.id.txt);
                    txt.setText("Hello");
                }
            }
        });
    }
}
