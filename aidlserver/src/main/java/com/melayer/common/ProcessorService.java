package com.melayer.common;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class ProcessorService extends Service {

    MyDataProcessor processor = new MyDataProcessor();

    @Override
    public IBinder onBind(Intent intent) {
        return processor;
    }

    private class MyDataProcessor extends ICommon.Stub {

        @Override
        public boolean checkValidity(String mobileNum) throws RemoteException {
            return mobileNum.length() == 10;
        }
    }
}
