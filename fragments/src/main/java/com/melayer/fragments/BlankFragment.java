package com.melayer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public static final String KEY_IMG = "img";

    public static BlankFragment getInstance(int img) {
        BlankFragment frag = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_IMG, img);
        frag.setArguments(bundle);

        return frag;
    }

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_blank, container, false);

        int img = getArguments().getInt(KEY_IMG);
        ((ImageView) view.findViewById(R.id.imgVw)).setImageResource(img);

        return view;
    }
}
