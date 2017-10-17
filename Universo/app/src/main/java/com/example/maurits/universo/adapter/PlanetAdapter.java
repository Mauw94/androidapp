package com.example.maurits.universo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maurits.universo.R;
import com.example.maurits.universo.model.Planet;

import java.util.ArrayList;

/**
 * Created by Maurits on 9-10-2017.
 */

public class PlanetAdapter extends ArrayAdapter<Planet> {


    private int mColorResourceId;

    public PlanetAdapter(Context context, ArrayList<Planet> planets, int colorResourceId) {
        super(context, 0, planets);
        this.mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Planet planet = getItem(position);

        TextView bodyName = listView.findViewById(R.id.edit_name);
        bodyName.setText(planet.getmName());

        ImageView imageView = listView.findViewById(R.id.image);
        if (planet.hasImage()) {
            imageView.setImageResource(planet.getmResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listView;
    }
}
