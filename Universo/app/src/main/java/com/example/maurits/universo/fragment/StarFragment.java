package com.example.maurits.universo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maurits.universo.activity.DetailsStarActivity;
import com.example.maurits.universo.activity.MainActivity;
import com.example.maurits.universo.adapter.StarAdapter;
import com.example.maurits.universo.R;
import com.example.maurits.universo.model.Star;

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

        MainActivity activity = (MainActivity) getActivity();
        final ArrayList<Star> stars = activity.getStarsList();

        StarAdapter adapter = new StarAdapter(getActivity(), stars, R.color.star);

        ListView listView = rootView.findViewById(R.id.object_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Star star = stars.get(position);
                Intent detailsIntent = new Intent(getActivity(), DetailsStarActivity.class);
                detailsIntent.putExtra("name", star.getmName());
                detailsIntent.putExtra("mass", star.getmMass());
                detailsIntent.putExtra("temp", star.getmTemperature());
                detailsIntent.putExtra("diameter", star.getmDiameter());
                detailsIntent.putExtra("age", star.getmAge());
                detailsIntent.putExtra("luminosity", star.getmLuminosity());
                startActivity(detailsIntent);
            }
        });

        return rootView;
    }

}
