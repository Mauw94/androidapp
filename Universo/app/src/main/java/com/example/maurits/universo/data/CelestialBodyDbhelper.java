package com.example.maurits.universo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CelestialBodyDbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "celestialbody.db";

    private static final int DATABASE_VERSION = 15;

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
                + CelestialBodyContract.PlanetEntry.COLUMN_IMAGE_ID + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_PLANET_TABLE);

        String SQL_CREATE_STAR_TABLE = "CREATE TABLE " + CelestialBodyContract.StarEntry.TABLE_NAME + "("
                + CelestialBodyContract.StarEntry.COLUMN_STAR_AGE + " FLOAT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_DIAMETER + " FLOAT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_LUMINOSITY + " FLOAT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_MASS + " FLOAT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_NAME + " TEXT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_STAR_TEMPERATURE + " FLOAT NOT NULL, "
                + CelestialBodyContract.StarEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_STAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CelestialBodyContract.PlanetEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CelestialBodyContract.StarEntry.TABLE_NAME);
        onCreate(db);
    }
}
