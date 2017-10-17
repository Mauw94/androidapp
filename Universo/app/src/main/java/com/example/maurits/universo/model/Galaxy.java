package com.example.maurits.universo.model;

/**
 * Created by Maurits on 9-10-2017.
 */

public class Galaxy {
    private String mName;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mResourceId;
    private String mSize;
    private String mAge;
    private String mMass;

    public Galaxy(String mName, int mResourceId, String mSize, String mAge, String mMass) {
        this.mName = mName;
        this.mResourceId = mResourceId;
        this.mSize = mSize;
        this.mAge = mAge;
        this.mMass = mMass;
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

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
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

    public boolean hasImage(){
        return NO_IMAGE_PROVIDED != mResourceId;
    }
}
