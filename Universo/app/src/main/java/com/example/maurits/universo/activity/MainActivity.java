package com.example.maurits.universo.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import com.example.maurits.universo.R;
import com.example.maurits.universo.adapter.CategoryAdapter;
import com.example.maurits.universo.data.CelestialBodyContract;
import com.example.maurits.universo.data.CelestialBodyDbhelper;
import com.example.maurits.universo.model.Planet;
import com.example.maurits.universo.model.Star;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Planet> planets = new ArrayList<>();
    private final ArrayList<Star> stars = new ArrayList<>();
    private CelestialBodyDbhelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        populateEarthEntry();
        populateMarsEntry();
        populateJupiterEntry();
        populateMercuryEntry();
        populateSaturnEntry();
        populateVenusEntry();
        populateSunEntry();
        populateBetelgeuseEntry();
        populateSDoradusEntry();
        populateUyscutiEntry();

        getAllPlanets();
        getAllStars();

        Log.v("MainActivity", "stars count " + stars.size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
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

            while (cursor.moveToNext()) {
                int imageId = cursor.getInt(imageIdColumn);
                String name = cursor.getString(nameColumn);

                stars.add(new Star(name, imageId));
            }
        }finally {
            cursor.close();
        }
    }

    private void populateEarthEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // earth
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Earth");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.earth);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "newRowId " + newRowId);
    }

    private void populateMarsEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // mars
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Mars");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.mars);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "newRowId " + newRowId);
    }

    private void populateJupiterEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // jupiter
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Jupiter");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.jupiter);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "newRowId " + newRowId);
    }

    private void populateSaturnEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // jupiter
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Saturn");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.saturn);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "newRowId " + newRowId);
    }

    private void populateVenusEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // jupiter
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Venus");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.venus);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);

        Log.v("MainActivity", "newRowId " + newRowId);
    }

    private void populateMercuryEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // jupiter
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Mercury");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.mercury);

        db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);
    }

    private void populateSunEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "The Sun");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, 8000000000f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, 4546456);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, 4546);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, 45645646);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, 456464456f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.sun);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateBetelgeuseEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "Betelgeuse");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, 8000000000f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, 4546456);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, 4546);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, 45645646);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, 456464456f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.betelgeuse);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateUyscutiEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "UY Scuti");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, 8000000000f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, 4546456);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, 4546);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, 45645646);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, 456464456f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.uyscuti);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateSDoradusEntry() {
        mDbHelper = new CelestialBodyDbhelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "SDoradus");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, 8000000000f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, 4546456);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, 4546);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, 45645646);
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, 456464456f);
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.sdoradus);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    public ArrayList<Planet> getPlanetsList()
    {
        return planets;
    }

    public ArrayList<Star> getStarsList() {
        return stars;
    }

}
