package com.melayer.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadFrag(int img) {
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction txn = mgr.beginTransaction();

        BlankFragment frag = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("img", img);
        frag.setArguments(bundle);

        txn.replace(R.id.frameLayout, frag);
        txn.commit();
    }
}
