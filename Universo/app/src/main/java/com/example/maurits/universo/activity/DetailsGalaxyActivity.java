package com.example.maurits.universo.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsGalaxyActivity extends AppCompatActivity {

    private CelestialBodyDbhelper mDbHelper;
    private String name;
    private String mass;
    private String size;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_galaxy);

        mDbHelper = new CelestialBodyDbhelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            name = extras.getString("name");
            Toast.makeText(getApplicationContext(), "Details of: " + name, Toast.LENGTH_SHORT).show();
            mass = extras.getString("mass");
            size = extras.getString("size");
            age = extras.getString("age");

            TextView nameView = (TextView) findViewById(R.id.gal_name);
            nameView.setText(name);

            TextView massView = (TextView) findViewById(R.id.gal_mass);
            massView.setText(mass);

            TextView sizeView = (TextView) findViewById(R.id.gal_size);
            sizeView.setText(size);

            TextView ageView = (TextView) findViewById(R.id.gal_age);
            ageView.setText(age);

        }
    }
}
