package com.melayer.fragbackstk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragament extends Fragment {


    public static DashboardFragament getInstance() {
        return new DashboardFragament();
    }

    public DashboardFragament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_dashboard_fragament, container, false);

        rootView.findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFrag(NotificataionsFragment.getInstance());
            }
        });

        return rootView;
    }
}
