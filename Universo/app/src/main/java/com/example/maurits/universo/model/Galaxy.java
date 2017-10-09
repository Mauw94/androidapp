package com.example.maurits.universo.model;

/**
 * Created by Maurits on 9-10-2017.
 */

public class Galaxy {
    private String mName;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mResourceId;
    private float mDiameter;
    private int mAmountOfStars;

    public Galaxy(String mName, int mResourceId, float mDiameter, int mAmountOfStars) {
        this.mName = mName;
        this.mResourceId = mResourceId;
        this.mDiameter = mDiameter;
        this.mAmountOfStars = mAmountOfStars;
    }

    public Galaxy(String name, int mResourceId) {
        this.mName = name;
        this.mResourceId = mResourceId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(int mResourceId) {
        this.mResourceId = mResourceId;
    }

    public float getmDiameter() {
        return mDiameter;
    }

    public void setmDiameter(float mDiameter) {
        this.mDiameter = mDiameter;
    }

    public int getmAmountOfStars() {
        return mAmountOfStars;
    }

    public void setmAmountOfStars(int mAmountOfStars) {
        this.mAmountOfStars = mAmountOfStars;
    }

    public boolean hasImage() {
        return mResourceId != NO_IMAGE_PROVIDED;
    }
}
