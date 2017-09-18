package com.codekul.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    // /data/user/0/com.codekul.internalstorage/files
    // /data/user/0/com.codekul.internalstorage/shared_prefs
    // /data/user/0/com.codekul.internalstorage/database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moreMethods();

        write();

        read();
    }

    private void read() {

        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("my.txt");
            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("@codekul", "Data from internal " + builder.toString());
    }

    private void write() {

        try {
            FileOutputStream fos = openFileOutput("my.txt", MODE_PRIVATE);
            fos.write("this is codekul.com".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moreMethods() {
        File file = getFilesDir();
        Log.i("@codekul", "Internal Storage - " + file.getAbsolutePath());

        String []intStrg = fileList();
        for (String fl : intStrg) {
            Log.i("@codekul", "File "+fl);
        }
    }
}
