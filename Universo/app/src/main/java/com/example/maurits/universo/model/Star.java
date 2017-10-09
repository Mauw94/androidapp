package com.example.maurits.universo.model;

/**
 * Created by Maurits on 9-10-2017.
 */

public class Star {

    private final static int NO_IMAGE_PROVIDED = -1;
    private int mResourceId = NO_IMAGE_PROVIDED;
    private String mName;
    private float mTemperature;
    private float mDiameter;
    private float mLuminosity;
    private int mAge;
    private float mMass;

    public Star(int mResourceId, String mName, float mTemperature, float mDiameter, float mLuminosity, int mAge, float mMass) {
        this.mResourceId = mResourceId;
        this.mName = mName;
        this.mTemperature = mTemperature;
        this.mDiameter = mDiameter;
        this.mLuminosity = mLuminosity;
        this.mAge = mAge;
        this.mMass = mMass;
    }

    public Star(String name, int resourceId) {
        this.mName = name;
        this.mResourceId = resourceId;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(int mResourceId) {
        this.mResourceId = mResourceId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(float mTemperature) {
        this.mTemperature = mTemperature;
    }

    public float getmDiameter() {
        return mDiameter;
    }

    public void setmDiameter(float mDiameter) {
        this.mDiameter = mDiameter;
    }

    public float getmLuminosity() {
        return mLuminosity;
    }

    public void setmLuminosity(float mLuminosity) {
        this.mLuminosity = mLuminosity;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public float getmMass() {
        return mMass;
    }

    public void setmMass(float mMass) {
        this.mMass = mMass;
    }

    public boolean hasImage() {
        return mResourceId != NO_IMAGE_PROVIDED;
    }
}
