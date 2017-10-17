package com.example.maurits.universo.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.maurits.universo.R;
import com.example.maurits.universo.adapter.CategoryAdapter;
import com.example.maurits.universo.data.CelestialBodyContract;
import com.example.maurits.universo.data.CelestialBodyDbhelper;
import com.example.maurits.universo.model.Galaxy;
import com.example.maurits.universo.model.Planet;
import com.example.maurits.universo.model.Star;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Planet> planets = new ArrayList<>();
    private final ArrayList<Star> stars = new ArrayList<>();
    private final ArrayList<Galaxy> galaxies = new ArrayList<>();
    private CelestialBodyDbhelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getDbDate();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_back_to_start:
                Intent startIntent = new Intent(MainActivity.this, StartUpActivity.class);
                startActivity(startIntent);
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    private void getDbDate(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getAllGalaxies();
                getAllPlanets();
                getAllStars();
            }
        };
        new Thread(runnable).start();
    }

    private void getAllPlanets(){
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String [] projection = {
                CelestialBodyContract.PlanetEntry._ID,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME,
                CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED,
                CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE
        };

        Cursor cursor = db.query(
                CelestialBodyContract.PlanetEntry.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        try {

            int idColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry._ID);
            int imageIdColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID);
            int nameColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME);
            int massColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS);
            int tempColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE);
            int diameterColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER);
            int rotaSpeedColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED);
            int distanceColumn = cursor.getColumnIndex(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumn);
                int imageId = cursor.getInt(imageIdColumn);
                String name = cursor.getString(nameColumn);
                String mass = cursor.getString(massColumn);
                String temp = cursor.getString(tempColumn);
                String diameter = cursor.getString(diameterColumn);
                String rotaSpeed = cursor.getString(rotaSpeedColumn);
                String distance = cursor.getString(distanceColumn);

                planets.add(new Planet(id, name, imageId, diameter, mass, rotaSpeed, temp, distance));
            }
        } finally {
            cursor.close();
        }
    }

    private void getAllStars() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE,
                CelestialBodyContract.StarEntry.COLUMN_STAR_NAME,
                CelestialBodyContract.StarEntry.COLUMN_STAR_MASS,
                CelestialBodyContract.StarEntry.COLUMN_STAR_AGE,
                CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER,
                CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY,
                CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID
        };

        Cursor cursor = db.query(
                CelestialBodyContract.StarEntry.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        try {
            int imageIdColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID);
            int nameColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME);
            int massColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS);
            int tempColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE);
            int ageColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE);
            int diameterColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER);
            int luminosityColumn = cursor.getColumnIndex(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY);

            while (cursor.moveToNext()) {
                int imageId = cursor.getInt(imageIdColumn);
                String name = cursor.getString(nameColumn);
                String mass = cursor.getString(massColumn);
                String temp = cursor.getString(tempColumn);
                String age = cursor.getString(ageColumn);
                String diameter = cursor.getString(diameterColumn);
                String lumi = cursor.getString(luminosityColumn);
                stars.add(new Star(imageId, name, temp, diameter, lumi, age, mass));
            }
        }finally {
            cursor.close();
        }
    }

    private void getAllGalaxies() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                CelestialBodyContract.GalaxyEntry.COLUMN_IMAGE_ID,
                CelestialBodyContract.GalaxyEntry.COLUMN_GAL_SIZE,
                CelestialBodyContract.GalaxyEntry.COLUMN_GAL_AGE,
                CelestialBodyContract.GalaxyEntry.COLUMN_GAL_MASS,
                CelestialBodyContract.GalaxyEntry.COLUMN_GAL_NAME
        };

        Cursor cursor = db.query(
                CelestialBodyContract.GalaxyEntry.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        try {
            int imageIdColumn = cursor.getColumnIndex(CelestialBodyContract.GalaxyEntry.COLUMN_IMAGE_ID);
            int nameColumn = cursor.getColumnIndex(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_NAME);
            int sizeColumn = cursor.getColumnIndex(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_SIZE);
            int ageColumn = cursor.getColumnIndex(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_AGE);
            int massColumn = cursor.getColumnIndex(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_MASS);


            while (cursor.moveToNext()) {
                int imageId = cursor.getInt(imageIdColumn);
                String name = cursor.getString(nameColumn);
                String size = cursor.getString(sizeColumn);
                String age = cursor.getString(ageColumn);
                String mass = cursor.getString(massColumn);
                galaxies.add(new Galaxy(name, imageId, size, age, mass));
            }
        }finally {
            cursor.close();
        }
    }

    public ArrayList<Planet> getPlanetsList()
    {
        return planets;
    }

    public ArrayList<Star> getStarsList() {
        return stars;
    }

    public ArrayList<Galaxy> getGalaxyList() {return galaxies;}
}
