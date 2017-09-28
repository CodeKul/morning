package com.codekul.contactapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
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

        readMyData();
    }

    private void readContacts() {
        List<String> dataSet = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, dataSet);
        ((ListView)findViewById(R.id.listContact)).setAdapter(adapter);

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
        while(cursor.moveToNext()) {
            String nm = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            dataSet.add(nm+"\n"+num);
            adapter.notifyDataSetChanged();
        }

        cursor.close();
    }

    private void readMyData() {
        List<String> dataSet = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, dataSet);
        ((ListView)findViewById(R.id.listContact)).setAdapter(adapter);

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
        while(cursor.moveToNext()) {
            String nm = cursor.getString(cursor.getColumnIndex("nm"));
            String num = cursor.getString(cursor.getColumnIndex("mob"));

            dataSet.add(nm+"\n"+num);
            adapter.notifyDataSetChanged();
        }

        cursor.close();
    }
}
