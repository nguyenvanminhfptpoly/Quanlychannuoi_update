package com.minhnv.admin88.quanlychannuoi.model;

public class ChitietBenh {
    private String mTenBenh;
    private String mCachPhongTranh;

    public ChitietBenh(String mTenBenh, String mCachPhongTranh) {
        this.mTenBenh = mTenBenh;
        this.mCachPhongTranh = mCachPhongTranh;
    }

    public ChitietBenh() {
    }

    public String getmTenBenh() {
        return mTenBenh;
    }

    public void setmTenBenh(String mTenBenh) {
        this.mTenBenh = mTenBenh;
    }

    public String getmCachPhongTranh() {
        return mCachPhongTranh;
    }

    public void setmCachPhongTranh(String mCachPhongTranh) {
        this.mCachPhongTranh = mCachPhongTranh;
    }
}
