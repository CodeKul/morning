package com.melayer.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        complexList();
    }

    private void complexList() {
        List<MyItem> items = new ArrayList<>(); // IoC -> DI
        items.add(new MyItem(R.drawable.ic_launcher_background, "Android"));
        items.add(new MyItem(R.drawable.ic_launcher_background, "iOS"));
        items.add(new MyItem(R.drawable.ic_launcher_background, "Game"));
        items.add(new MyItem(R.drawable.ic_launcher_background, "Windows"));
        items.add(new MyItem(R.drawable.ic_launcher_background, "Rim"));


        MyAdapter adapter = new MyAdapter(this, items);
        ((ListView)findViewById(R.id.mobiles)).setAdapter(adapter);
    }

    private void simpleList() {
        List<String> dataSet = new ArrayList<>();
        dataSet.add("Android");
        dataSet.add("iOS");
        dataSet.add("Rim");
        dataSet.add("bada");
        dataSet.add("Windows");
        dataSet.add("Symbians");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataSet
        );

        ((ListView) findViewById(R.id.mobiles)).setAdapter(adapter);
    }
}
