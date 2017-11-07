package com.example.maurits.universo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.maurits.universo.R;


public class CelestialBodyDbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "celestialbody.db";

    private static final int DATABASE_VERSION = 34;

    public CelestialBodyDbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PLANET_TABLE = "CREATE TABLE " + CelestialBodyContract.PlanetEntry.TABLE_NAME + "("
                + CelestialBodyContract.PlanetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER + " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR + " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE + " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME +  " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED + " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS + " TEXT NOT NULL, "
                + CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_PLANET_TABLE);

        String SQL_CREATE_STAR_TABLE = "CREATE TABLE " + CelestialBodyContract.StarEntry.TABLE_NAME + "("
                + CelestialBodyContract.StarEntry.COLUMN_STAR_AGE + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_MASS + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_NAME + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_STAR_TABLE);

        String SQL_CREATE_GALAXY_TABLE = "CREATE TABLE " + CelestialBodyContract.GalaxyEntry.TABLE_NAME + "("
                + CelestialBodyContract.GalaxyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CelestialBodyContract.GalaxyEntry.COLUMN_GAL_NAME + " TEXT NOT NULL, "
                + CelestialBodyContract.GalaxyEntry.COLUMN_GAL_AGE + " TEXT NOT NULL, "
                + CelestialBodyContract.GalaxyEntry.COLUMN_GAL_MASS + " TEXT NOT NULL, "
                + CelestialBodyContract.GalaxyEntry.COLUMN_GAL_SIZE + " TEXT NOT NULL, "
                + CelestialBodyContract.GalaxyEntry.COLUMN_IMAGE_ID+ " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_GALAXY_TABLE);

        populatePlanetEntries(db);
        populateStarEntries(db);
        populateGalaxyEntries(db);

    }

    private void populateEarthEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Earth");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.earth);

        db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);
    }

    private void populateMarsEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Mars");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.mars);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);
    }

    private void populateJupiterEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_NAME, "Jupiter");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DIAMETER, "40k km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_DISTANCEFROMSTAR, "150milj km");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_MASS, "5000m ton");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_ROTASPEED, "150km/u");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_PLANET_TEMPERATURE, "30g");
        values.put(CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID, R.drawable.jupiter);

        long newRowId = db.insert(CelestialBodyContract.PlanetEntry.TABLE_NAME, null, values);
    }

    private void populateSaturnEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

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

    private void populateVenusEntry(SQLiteDatabase db) {
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

    private void populateMercuryEntry(SQLiteDatabase db) {
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

    private void populateSunEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "The Sun");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, "8B");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, "454664km");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, "11212");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, "121313milj TON");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, "5k kelvin");
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.sun);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateBetelgeuseEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "Betelgeuse");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, "4B");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, "4123km");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, "11212");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, "113milj TON");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, "3k kelvin");
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.betelgeuse);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateUyscutiEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "UY Scuti");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, "3B");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, "8878km");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, "125");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, "7853milj TON");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, "2k kelvin");
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.uyscuti);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateSDoradusEntry(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_NAME, "SDoradus");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_AGE, "6B");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER, "1212km");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY, "568");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_MASS, "185milj TON");
        values.put(CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE, "5k kelvin");
        values.put(CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID, R.drawable.sdoradus);

        db.insert(CelestialBodyContract.StarEntry.TABLE_NAME, null, values);
    }

    private void populateMilkyWayEntry(SQLiteDatabase db){
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_AGE, "10B");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_MASS, "105M");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_NAME, "Milky Way");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_SIZE, "546B");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_IMAGE_ID, R.drawable.milkyway);

        db.insert(CelestialBodyContract.GalaxyEntry.TABLE_NAME, null, values);
    }

    private void populateAndromedaEntry(SQLiteDatabase db){
        ContentValues values = new ContentValues();

        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_AGE, "12B");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_MASS, "500M");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_NAME, "Andromeda");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_GAL_SIZE, "546B");
        values.put(CelestialBodyContract.GalaxyEntry.COLUMN_IMAGE_ID, R.drawable.andromeda);

        db.insert(CelestialBodyContract.GalaxyEntry.TABLE_NAME, null, values);
    }

    private void populatePlanetEntries(SQLiteDatabase db) {
        populateEarthEntry(db);
        populateMarsEntry(db);
        populateJupiterEntry(db);
        populateMercuryEntry(db);
        populateSaturnEntry(db);
        populateVenusEntry(db);
    }

    private void populateStarEntries(SQLiteDatabase db){
        populateSunEntry(db);
        populateBetelgeuseEntry(db);
        populateSDoradusEntry(db);
        populateUyscutiEntry(db);
    }

    private void populateGalaxyEntries(SQLiteDatabase db){
        populateMilkyWayEntry(db);
        populateAndromedaEntry(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CelestialBodyContract.PlanetEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CelestialBodyContract.StarEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CelestialBodyContract.GalaxyEntry.TABLE_NAME);
        onCreate(db);
    }
}
