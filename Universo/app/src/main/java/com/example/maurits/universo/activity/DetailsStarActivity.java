package com.example.maurits.universo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsStarActivity extends AppCompatActivity {

    private String name;
    private String mass;
    private String temp;
    private String age;
    private String diameter;
    private String luminosity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_star);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");

            Toast.makeText(getApplicationContext(), "Details of: " + name, Toast.LENGTH_SHORT).show();
            mass = extras.getString("mass");
            temp = extras.getString("temp");
            age = extras.getString("age");
            diameter = extras.getString("diameter");
            luminosity = extras.getString("luminosity");

            TextView nameView = (TextView) findViewById(R.id.star_name);
            TextView massView = (TextView) findViewById(R.id.star_mass);
            TextView tempView = (TextView) findViewById(R.id.star_temperature);
            TextView ageView = (TextView) findViewById(R.id.star_age);
            TextView luminosityView = (TextView) findViewById(R.id.star_luminosity);
            TextView diameterView = (TextView) findViewById(R.id.star_diameter);

            nameView.setText(name);
            massView.setText(mass + "");
            tempView.setText(temp + "");
            ageView.setText(age+"");
            diameterView.setText(diameter+"");
            luminosityView.setText(luminosity+"");
        }

    }

}
