package com.example.maurits.universo.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsGalaxyActivity extends AppCompatActivity {

    private CelestialBodyDbhelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_galaxy);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_body);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDbHelper = new CelestialBodyDbhelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("name");
            String mass = extras.getString("mass");
            String size = extras.getString("size");
            String age = extras.getString("age");

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
