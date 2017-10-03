package com.example.maurits.universo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class StarFragment extends Fragment {


    public StarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.object,container,false);
        ArrayList<CelestialBody> stars = new ArrayList();
        stars.add(new CelestialBody("Sun", R.drawable.noimage));
        stars.add(new CelestialBody("Test", R.drawable.earth));

        CelestialBodyAdapter adapter = new CelestialBodyAdapter(getActivity(), stars, R.color.star);

        ListView listView = (ListView) rootView.findViewById(R.id.object_list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
