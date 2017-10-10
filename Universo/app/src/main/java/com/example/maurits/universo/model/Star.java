package com.example.maurits.universo.model;

/**
 * Created by Maurits on 9-10-2017.
 */

public class Star {

    private final static int NO_IMAGE_PROVIDED = -1;
    private int mResourceId = NO_IMAGE_PROVIDED;
    private String mName;
    private String mTemperature;
    private String mDiameter;
    private String mLuminosity;
    private String mAge;
    private String mMass;

    public Star(int mResourceId, String mName, String mTemperature, String mDiameter, String mLuminosity, String mAge, String mMass) {
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

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmDiameter() {
        return mDiameter;
    }

    public void setmDiameter(String mDiameter) {
        this.mDiameter = mDiameter;
    }

    public String getmLuminosity() {
        return mLuminosity;
    }

    public void setmLuminosity(String mLuminosity) {
        this.mLuminosity = mLuminosity;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmMass() {
        return mMass;
    }

    public void setmMass(String mMass) {
        this.mMass = mMass;
    }

    public boolean hasImage() {
        return mResourceId != NO_IMAGE_PROVIDED;
    }
}
