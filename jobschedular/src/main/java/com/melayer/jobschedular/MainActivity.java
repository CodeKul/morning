package com.melayer.jobschedular;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private JobScheduler scheduler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void onBtn(View view) {

        ComponentName componentName = new ComponentName(this, MyJobService.class);

        JobInfo.Builder builder = new JobInfo.Builder(1, componentName).setMinimumLatency(1000);

        Log.i("@codekul", "Does Job started -- "+scheduler.schedule(builder.build()));
    }
}
