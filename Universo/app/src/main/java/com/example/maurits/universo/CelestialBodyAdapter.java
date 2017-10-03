package com.example.maurits.universo;

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

import java.util.ArrayList;

/**
 * Created by Maurits on 3-10-2017.
 */

public class CelestialBodyAdapter extends ArrayAdapter<CelestialBody> {

    private int mColorResourceId;

    public CelestialBodyAdapter(Context context, ArrayList<CelestialBody> bodies, int colorResourceId) {
        super(context, 0, bodies);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        CelestialBody celestialBody = getItem(position);

        TextView bodyName = (TextView) listItemView.findViewById(R.id.body_name);
        bodyName.setText(celestialBody.getName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (celestialBody.hasImage()) {
            imageView.setImageResource(celestialBody.getResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
