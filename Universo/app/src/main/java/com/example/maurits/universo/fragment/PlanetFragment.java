package com.example.maurits.universo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maurits.universo.adapter.PlanetAdapter;
import com.example.maurits.universo.activity.DetailActivity;
import com.example.maurits.universo.R;
import com.example.maurits.universo.model.Planet;

import java.util.ArrayList;


public class PlanetFragment extends Fragment {


    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.object, container, false);

        final ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Earth", R.drawable.earth));
        planets.add(new Planet("Mars", R.drawable.noimage));
        planets.add(new Planet("Jupiter", R.drawable.noimage));
        planets.add(new Planet("Saturn", R.drawable.noimage));
        planets.add(new Planet("Pluto", R.drawable.noimage));
        planets.add(new Planet("Venus", R.drawable.noimage));
        planets.add(new Planet("Mercury", R.drawable.noimage));

        PlanetAdapter planetAdapter = new PlanetAdapter(getActivity(), planets, R.color.planet);
        ListView listView = (ListView) rootView.findViewById(R.id.object_list);

        listView.setAdapter(planetAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //CelestialBody celestialBody = planets.get(position);
                Intent editIntent = new Intent(getActivity(), DetailActivity.class);
                startActivity(editIntent);
            }
        });
        return rootView;
    }

}
