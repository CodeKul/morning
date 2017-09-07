package com.melayer.dialogs;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAlert(View view) {
        sh(MyDialog.TAG_ALERT);
    }

    public void onDate(View view) {
        sh(MyDialog.TAG_DATE);
    }

    public void onTime(View view) {
        sh(MyDialog.TAG_TIME);
    }

    public void onProgress(View view) {
        sh(MyDialog.TAG_PROGRESS);
    }

    public void sh(String tag) {
        MyDialog dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(), tag);
    }

    private void natural() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
