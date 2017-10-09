package com.example.maurits.universo.model;

import com.example.maurits.universo.data.ObjectImage;

public class Planet {
    private int mId;
    private String mName;
    private int mResourceId = ObjectImage.NO_IMAGE_PROVIDED;
    private String mDiameter;
    private String mMass;
    private String mRotationSpeed;
    private String mTemperature;
    private String mDistance;

    public Planet(int id, String mName, int mResourceId, String mDiameter, String mMass, String mRotationSpeed, String mTemperature, String mDistance) {
        this.mId = id;
        this.mName = mName;
        this.mResourceId = mResourceId;
        this.mDiameter = mDiameter;
        this.mMass = mMass;
        this.mRotationSpeed = mRotationSpeed;
        this.mTemperature = mTemperature;
        this.mDistance = mDistance;
    }

    public Planet(String mName, int mResourceId) {
        this.mName = mName;
        this.mResourceId = mResourceId;
    }

    public int getId() { return mId; }

    public String getmName() {
        return mName;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public String getmDiameter() {
        return mDiameter;
    }

    public String getmMass() {
        return mMass;
    }

    public String getmRotationSpeed() {
        return mRotationSpeed;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public String getmDistance() {
        return mDistance;
    }

    public boolean hasImage()
    {
        return mResourceId != ObjectImage.NO_IMAGE_PROVIDED;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmResourceId(int mResourceId) {
        this.mResourceId = mResourceId;
    }

    public void setmDiameter(String mDiameter) {
        this.mDiameter = mDiameter;
    }

    public void setmMass(String mMass) {
        this.mMass = mMass;
    }

    public void setmRotationSpeed(String mRotationSpeed) {
        this.mRotationSpeed = mRotationSpeed;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public void setmDistance(String mDistance) {
        this.mDistance = mDistance;
    }
}
