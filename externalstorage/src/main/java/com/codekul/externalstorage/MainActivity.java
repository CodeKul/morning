package com.codekul.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // private sector -  /storage/emulated/0/Android/data/com.codekul.externalstorage/files/codekul/my.txt
    // public sector - /storage/emulated/0/codekul/my.txt
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Environment.getExternalStoragePublicDirectory("codekul").mkdir();

        file = new File(
                //getExternalFilesDir("codekul"), private
                Environment.getExternalStoragePublicDirectory("codekul"), // public
                "my.txt"
        );
        Log.i("@codekul", "File Path - " + file.getAbsolutePath());

        if (isEsAvailable()) {
            writeFile();
            readFile();
        }
        else Log.i("@codekul","External storage not available");
    }

    private Boolean isEsAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("Welcome to codekul".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
            Log.i("@codekul", "File Data - " + builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
