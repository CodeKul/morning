package com.codekul.contactapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkPermissionAndGo();
    }

    private void checkPermissionAndGo() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) showExplanation();
            else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        1234);
            }
        } else readContacts();
    }

    private void onYes(DialogInterface dialogInterface, int which) {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_CONTACTS},
                1234);
    }

    private void onNo(DialogInterface dialogInterface, int which) {
        dialogInterface.dismiss();
    }

    private void showExplanation() {
        new AlertDialog.Builder(this)
                .setTitle("Permission")
                .setMessage("We will not steal your contacts, just give me permission :)")
                .setPositiveButton("Yes", this::onYes)
                .setNegativeButton("No", this::onNo)
                .create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1234) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readContacts();
            }
        }
    }

    private void readContacts() {
        List<String> dataSet = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.listContact)).setAdapter(adapter);

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                uri,
                projection,
                selection,
                selectionArgs,
                sortOrder
        );
        while (cursor.moveToNext()) {
            String nm = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            dataSet.add(nm + "\n" + num);
            adapter.notifyDataSetChanged();
        }

        cursor.close();
    }

    private void readMyData() {
        List<String> dataSet = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.listContact)).setAdapter(adapter);

        Uri uri = Uri.parse("content://com.codekul.data.my");
        String[] projection = {
                "nm",
                "mob"
        };
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                uri,
                projection,
                selection,
                selectionArgs,
                sortOrder
        );
        while (cursor.moveToNext()) {
            String nm = cursor.getString(cursor.getColumnIndex("nm"));
            String num = cursor.getString(cursor.getColumnIndex("mob"));

            dataSet.add(nm + "\n" + num);
            adapter.notifyDataSetChanged();
        }

        cursor.close();
    }
}
