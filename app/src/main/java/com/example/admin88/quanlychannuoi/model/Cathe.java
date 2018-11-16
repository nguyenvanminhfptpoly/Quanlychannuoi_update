package com.example.admin88.quanlychannuoi.model;

public class Cathe {
    private String mSohieudan,mGiong,mTinhtranglon,mTenbenh,mXuatchuong;
    private String mSohieucathe;
    private double mCannang;

    public Cathe(String mSohieudan, String mGiong, String mTinhtranglon, String mTenbenh, String mXuatchuong, String mSohieucathe, double mCannang) {
        this.mSohieudan = mSohieudan;
        this.mGiong = mGiong;
        this.mTinhtranglon = mTinhtranglon;
        this.mTenbenh = mTenbenh;
        this.mXuatchuong = mXuatchuong;
        this.mSohieucathe = mSohieucathe;
        this.mCannang = mCannang;
    }

    public String getmSohieucathe() {
        return mSohieucathe;
    }

    public void setmSohieucathe(String mSohieucathe) {
        this.mSohieucathe = mSohieucathe;
    }

    public Cathe() {
    }

    public String getmSohieudan() {
        return mSohieudan;
    }

    public void setmSohieudan(String mSohieudan) {
        this.mSohieudan = mSohieudan;
    }

    public String getmGiong() {
        return mGiong;
    }

    public void setmGiong(String mGiong) {
        this.mGiong = mGiong;
    }

    public String getmTinhtranglon() {
        return mTinhtranglon;
    }

    public void setmTinhtranglon(String mTinhtranglon) {
        this.mTinhtranglon = mTinhtranglon;
    }

    public String getmTenbenh() {
        return mTenbenh;
    }

    public void setmTenbenh(String mTenbenh) {
        this.mTenbenh = mTenbenh;
    }

    public String getmXuatchuong() {
        return mXuatchuong;
    }

    public void setmXuatchuong(String mXuatchuong) {
        this.mXuatchuong = mXuatchuong;
    }

    public double getmCannang() {
        return mCannang;
    }

    public void setmCannang(double mCannang) {
        this.mCannang = mCannang;
    }
}
