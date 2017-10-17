package com.example.maurits.universo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsPlanetActivity extends AppCompatActivity {

    private CelestialBodyDbhelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_planet);
        // show all details of planet(x)
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String name = extras.getString("name");

            Toast.makeText(getApplicationContext(), "Details of: " + name, Toast.LENGTH_SHORT).show();
            String mass = extras.getString("mass");
            String temp = extras.getString("temp");
            String distance = extras.getString("distance");
            String diameter = extras.getString("diameter");
            String rotationspeed = extras.getString("rotationspeed");

            TextView nameView = (TextView) findViewById(R.id.edit_name);
            TextView massView = (TextView) findViewById(R.id.edit_mass);
            TextView tempView = (TextView) findViewById(R.id.planet_temperature);
            TextView distanceView = (TextView) findViewById(R.id.edit_distance);
            TextView diameterView = (TextView) findViewById(R.id.edit_diameter);
            TextView rotaSpeedView = (TextView) findViewById(R.id.planet_rotation);

            nameView.setText(name);
            massView.setText(mass + "");
            tempView.setText(temp + "");
            distanceView.setText(distance + "");
            diameterView.setText(diameter + "");
            rotaSpeedView.setText(rotationspeed + "");
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_body);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent editIntent = new Intent(DetailsPlanetActivity.this, EditPlanetActivity.class);
                    editIntent.putExtra("name", name);
                    startActivity(editIntent);
                }
            });
        }

        mDbHelper = new CelestialBodyDbhelper(this);

    }

}
