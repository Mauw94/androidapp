package com.example.maurits.universo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsPlanetActivity extends AppCompatActivity {

    private CelestialBodyDbhelper mDbHelper;
    private String name;
    private String mass;
    private String temp;
    private String distance;
    private String diameter;
    private String rotationspeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_planet);
        // show all details of planet(x)
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");

            Toast.makeText(getApplicationContext(), "Details of: " + name, Toast.LENGTH_SHORT).show();
            mass = extras.getString("mass");
            temp = extras.getString("temp");
            distance = extras.getString("distance");
            diameter = extras.getString("diameter");
            rotationspeed = extras.getString("rotationspeed");

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
        }

        mDbHelper = new CelestialBodyDbhelper(this);

    }

}
