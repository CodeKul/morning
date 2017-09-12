package com.melayer.uithread;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    // 1). handlers
    // 2). Async Task
    // 3). Observables

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }

    public void onBtnStart(View view) {
        final TextView txt = findViewById(R.id.textView);
        //txt.setOnClickListener(btn -> Log.i("@codekul", "Clicked"));

        //new Thread(() -> cntr(txt)).start();

        //new MyTask(txt).execute(0, 100);

        cntrObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(num -> txt.setText("" + num))
                .doOnError(err -> Log.i("@codekul", err.getMessage()))
                .doOnComplete(() -> Log.i("@codekul", "Counter Completed"))
                .subscribe();
    }

    int i = 0;

    private void cntr(TextView txt) {
        for (i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(() -> txt.setText(String.valueOf(i)));
            //txt.setText(String.valueOf(i));
        }
    }

    private class MyTask extends AsyncTask<Integer/*params*/, String/*Progress*/, Boolean/*Result*/> {

        private TextView txt;

        public MyTask(TextView txt) {
            this.txt = txt;
        }

        @Override
        protected void onPreExecute() {
            //Ui thread
            super.onPreExecute();
        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*Params*/) {

            // worker thread

            for (int i = params[0]; i < params[1]; i++) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("" + i/*progress*/);
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            //ui thread
        }

        @Override
        protected void onProgressUpdate(String... values/*Progress*/) {
            super.onProgressUpdate(values);

            txt.setText(values[0]);

            //ui thread
        }
    }

    private Observable<Integer> cntrObservable() {
        return Observable.create(this::obEm);
    }

    private void obEm(ObservableEmitter<Integer> emmiter) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            emmiter.onNext(i);
        }
        emmiter.onComplete();
    }
}
