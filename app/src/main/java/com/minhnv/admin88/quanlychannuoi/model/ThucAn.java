package com.minhnv.admin88.quanlychannuoi.model;

public class ThucAn {
    private String mDot;
    private int mSoluongthucan;
    private double mDongiathucan;

    public ThucAn(String mDot, int mSoluongthucan, double mDongiathucan) {
        this.mDot = mDot;
        this.mSoluongthucan = mSoluongthucan;
        this.mDongiathucan = mDongiathucan;
    }

    public ThucAn() {
    }

    public String getmDot() {
        return mDot;
    }

    public void setmDot(String mDot) {
        this.mDot = mDot;
    }

    public int getmSoluongthucan() {
        return mSoluongthucan;
    }

    public void setmSoluongthucan(int mSoluongthucan) {
        this.mSoluongthucan = mSoluongthucan;
    }

    public double getmDongiathucan() {
        return mDongiathucan;
    }

    public void setmDongiathucan(double mDongiathucan) {
        this.mDongiathucan = mDongiathucan;
    }
}
