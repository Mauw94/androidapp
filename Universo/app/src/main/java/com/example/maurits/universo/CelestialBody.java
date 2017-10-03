package com.example.maurits.universo;

/**
 * Created by Maurits on 3-10-2017.
 */

public class CelestialBody {

    private String mName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private final static int NO_IMAGE_PROVIDED = -1;

    public CelestialBody(String name, int imageResourceId) {
        this.mName = name;
        this.mImageResourceId = imageResourceId;
    }

    public CelestialBody(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }


    public int getResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
