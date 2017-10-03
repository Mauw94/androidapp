package com.example.maurits.universo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PlanetFragment extends Fragment {


    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.object, container, false);

        final ArrayList<CelestialBody> planets = new ArrayList<>();
        planets.add(new CelestialBody("Earth", R.drawable.earth));
        planets.add(new CelestialBody("Mars", R.drawable.noimage));

        CelestialBodyAdapter adapter = new CelestialBodyAdapter(getActivity(), planets, R.color.planet);

        ListView listView = (ListView) rootView.findViewById(R.id.object_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CelestialBody celestialBody = planets.get(position);
            }
        });
        return rootView;
    }


}
