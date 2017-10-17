package com.example.maurits.universo.data;

import android.provider.BaseColumns;

/**
 * Created by Maurits on 9-10-2017.
 */

public final class CelestialBodyContract {

    private CelestialBodyContract() {}

    public static final class PlanetEntry implements BaseColumns {

        public final static String TABLE_NAME = "Planets";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PLANET_NAME = "name";
        public final static String COLUMN_IMAGE_ID = "imageid";
        public final static String COLUMN_PLANET_DIAMETER = "diameter";
        public final static String COLUMN_PLANET_MASS = "mass";
        public final static String COLUMN_PLANET_ROTASPEED = "rotationspeed";
        public final static String COLUMN_PLANET_TEMPERATURE = "temperature";
        public final static String COLUMN_PLANET_DISTANCEFROMSTAR = "distancefromstar";
    }

    public static final class StarEntry implements BaseColumns {

        public final static String TABLE_NAME = "Stars";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_STAR_NAME = "name";
        public final static String COLUMN_IMAGE_ID = "imageid";
        public final static String COLUMN_STAR_TEMPERATURE = "temperature";
        public final static String COLUMN_STAR_DIAMETER = "diameter";
        public final static String COLUMN_STAR_LUMINOSITY = "luminosity";
        public final static String COLUMN_STAR_AGE = "age";
        public final static String COLUMN_STAR_MASS = "mass";
    }

    public static final class GalaxyEntry implements BaseColumns {

        public final static String TABLE_NAME = "Galaxies";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_GAL_NAME = "name";
        public final static String COLUMN_IMAGE_ID = "imageid";
        public final static String COLUMN_GAL_SIZE = "size";
        public final static String COLUMN_GAL_AGE = "age";
        public final static String COLUMN_GAL_MASS = "mass";
    }
}
