package com.melayer.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 1/8/17.
 */

public class MyAdapter extends BaseAdapter {

    private final Context context;
    private final List<MyItem> items;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MyItem> items) {
        this.context = context;
        this.items = items;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int pos) {
        return items.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos * 2;
    }

    @Override
    public View getView(int pos, View viewConvert, ViewGroup viewGroup) {

        View viewInflated = null;
        if (viewConvert == null) {
            viewInflated = inflater.inflate(R.layout.list_item, null, false);
        } else viewInflated = viewConvert;

        ((ImageView) viewInflated.findViewById(R.id.img)).setImageResource(items.get(pos).img);
        ((TextView) viewInflated.findViewById(R.id.txt)).setText(items.get(pos).nm);

        return viewInflated;
    }
}
