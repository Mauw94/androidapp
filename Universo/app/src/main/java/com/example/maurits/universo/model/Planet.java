package com.example.maurits.universo.model;

/**
 * Created by Maurits on 3-10-2017.
 */

public class Planet {
    private String mName;
    private int mResourceId = NO_IMAGE_PROVIDED;
    private float mDiameter;
    private float mPerimeter;
    private float mMass;
    private float mRotationSpeed;
    private float mTemperature;
    private float mDistance;
    private final static int NO_IMAGE_PROVIDED = -1;

    public Planet(String mName, int mResourceId, float mDiameter, float mPerimeter, float mMass, float mRotationSpeed, float mTemperature, float mDistance) {
        this.mName = mName;
        this.mResourceId = mResourceId;
        this.mDiameter = mDiameter;
        this.mPerimeter = mPerimeter;
        this.mMass = mMass;
        this.mRotationSpeed = mRotationSpeed;
        this.mTemperature = mTemperature;
        this.mDistance = mDistance;
    }

    public Planet(String mName, int mResourceId) {
        this.mName = mName;
        this.mResourceId = mResourceId;
    }

    public String getmName() {
        return mName;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public float getmDiameter() {
        return mDiameter;
    }

    public float getmPerimeter() {
        return mPerimeter;
    }

    public float getmMass() {
        return mMass;
    }

    public float getmRotationSpeed() {
        return mRotationSpeed;
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public float getmDistance() {
        return mDistance;
    }

    public boolean hasImage()
    {
        return mResourceId != NO_IMAGE_PROVIDED;
    }
}
