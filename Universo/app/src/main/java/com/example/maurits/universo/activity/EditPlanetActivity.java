package com.example.maurits.universo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.maurits.universo.R;

public class EditPlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_planet);

        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");
        EditText nameText = (EditText) findViewById(R.id.edit_name);
        nameText.setText(name);

        String mass = extras.getString("mass");
        EditText massText = (EditText) findViewById(R.id.edit_mass);
        massText.setText(mass);

        String temp = extras.getString("temp");
        EditText tempText = (EditText) findViewById(R.id.edit_temp);
        tempText.setText(temp);

        String distance = extras.getString("distance");
        EditText distanceText = (EditText) findViewById(R.id.edit_distance);
        distanceText.setText(distance);

        String diameter = extras.getString("diameter");
        EditText diameterText = (EditText) findViewById(R.id.edit_diameter);
        diameterText.setText(diameter);

        String rota = extras.getString("rotationspeed");
        EditText rotaText = (EditText) findViewById(R.id.edit_rota);
        rotaText.setText(rota);

    }

}
