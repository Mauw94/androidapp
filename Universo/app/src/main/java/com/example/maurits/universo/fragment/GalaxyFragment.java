package com.example.maurits.universo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maurits.universo.R;
import com.example.maurits.universo.activity.DetailsGalaxyActivity;
import com.example.maurits.universo.activity.MainActivity;
import com.example.maurits.universo.adapter.GalaxyAdapter;
import com.example.maurits.universo.model.Galaxy;

import java.util.ArrayList;


public class GalaxyFragment extends Fragment {

    public GalaxyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.object, container, false);

        MainActivity activity = (MainActivity)getActivity();

        final ArrayList<Galaxy> galaxies = activity.getGalaxyList();

        GalaxyAdapter adapter = new GalaxyAdapter(getContext(), galaxies, R.color.galaxy);
        ListView listView = rootView.findViewById(R.id.object_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Galaxy galaxy = galaxies.get(i);
                Intent detailsIntent = new Intent(getActivity(), DetailsGalaxyActivity.class);
                detailsIntent.putExtra("name", galaxy.getmName());
                detailsIntent.putExtra("age", galaxy.getmAge());
                detailsIntent.putExtra("mass", galaxy.getmMass());
                detailsIntent.putExtra("size", galaxy.getmSize());
                startActivity(detailsIntent);
            }
        });
        return rootView;
    }

}
