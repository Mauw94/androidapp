package com.example.maurits.universo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.maurits.universo.R;
import com.example.maurits.universo.data.CelestialBodyDbhelper;

public class DetailsStarActivity extends AppCompatActivity {

    private CelestialBodyDbhelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_star);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_body);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDbHelper = new CelestialBodyDbhelper(this);

        //testShowPlanet();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text = extras.getString("Star");
            TextView textView = (TextView) findViewById(R.id.planet_name);
            textView.setText(text);
        }

    }

}
