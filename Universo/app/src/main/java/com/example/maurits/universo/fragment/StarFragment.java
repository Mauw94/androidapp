package com.example.maurits.universo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        ArrayList<Star> stars = new ArrayList();
        stars.add(new Star("Sun", R.drawable.noimage));
        stars.add(new Star("Test", R.drawable.earth));

        StarAdapter adapter = new StarAdapter(getActivity(), stars, R.color.star);

        ListView listView = (ListView) rootView.findViewById(R.id.object_list);

        listView.setAdapter(adapter);

        return rootView;
    }

}
