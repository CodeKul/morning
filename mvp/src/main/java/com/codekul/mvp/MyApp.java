package com.codekul.mvp;

import android.app.Application;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by aniruddha on 14/9/17.
 */

public class MyApp extends Application {

    private Socket socket;

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            socket = new Socket("localhost", 8089);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
