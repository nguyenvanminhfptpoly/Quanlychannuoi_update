package com.minhnv.admin88.quanlychannuoi.model;

public class User {
    private String mName,mAddress;
    private String mSdt;

    public User(String mName, String mAddress, String mSdt) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mSdt = mSdt;
    }

    public User() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmSdt() {
        return mSdt;
    }

    public void setmSdt(String mSdt) {
        this.mSdt = mSdt;
    }
}
