package com.example.maurits.universo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maurits.universo.activity.DetailsPlanetActivity;
import com.example.maurits.universo.activity.MainActivity;
import com.example.maurits.universo.adapter.PlanetAdapter;
import com.example.maurits.universo.activity.DetailsStarActivity;
import com.example.maurits.universo.R;
import com.example.maurits.universo.model.Planet;

import java.io.Serializable;
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

        MainActivity activity = (MainActivity)getActivity();
        final ArrayList<Planet> planets = activity.getPlanetsList();

        PlanetAdapter planetAdapter = new PlanetAdapter(getActivity(), planets, R.color.planet);
        ListView listView = rootView.findViewById(R.id.object_list);

        listView.setAdapter(planetAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Planet planet = planets.get(position);
                Intent detailsIntent = new Intent(getActivity(), DetailsPlanetActivity.class);
                detailsIntent.putExtra("name", planet.getmName());
                detailsIntent.putExtra("mass", planet.getmMass());
                detailsIntent.putExtra("temp", planet.getmTemperature());
                detailsIntent.putExtra("distance", planet.getmDistance());
                detailsIntent.putExtra("diameter", planet.getmDiameter());
                detailsIntent.putExtra("rotationspeed", planet.getmRotationSpeed());
                startActivity(detailsIntent);
            }
        });
        return rootView;
    }

}
