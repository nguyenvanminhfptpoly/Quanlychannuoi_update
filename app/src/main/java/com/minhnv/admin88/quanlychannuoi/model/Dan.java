package com.minhnv.admin88.quanlychannuoi.model;

public class Dan {
    private String mSohieudan;
    private int mSoluongdan;
    private String mTinhTrang;

    public Dan(String mSohieudan, int mSoluongdan, String mTinhTrang) {
        this.mSohieudan = mSohieudan;
        this.mSoluongdan = mSoluongdan;
        this.mTinhTrang = mTinhTrang;
    }

    public Dan() {
    }

    public String getmSohieudan() {
        return mSohieudan;
    }

    public void setmSohieudan(String mSohieudan) {
        this.mSohieudan = mSohieudan;
    }

    public int getmSoluongdan() {
        return mSoluongdan;
    }

    public void setmSoluongdan(int mSoluongdan) {
        this.mSoluongdan = mSoluongdan;
    }

    public String getmTinhTrang() {
        return mTinhTrang;
    }

    public void setmTinhTrang(String mTinhTrang) {
        this.mTinhTrang = mTinhTrang;
    }

    @Override
    public String toString() {
        return "Đàn : "+getmSohieudan()+ " có "+getmSoluongdan()+ " cá thể";
    }
}
