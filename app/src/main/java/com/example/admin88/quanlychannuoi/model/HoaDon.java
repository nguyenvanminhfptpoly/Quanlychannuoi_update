package com.example.admin88.quanlychannuoi.model;

public class HoaDon {
    private String mMahoadon;
    private String mTenDan_hoadon;
    private int mSoluongHoadon;
    private double mGiaThitLon;


    public HoaDon(String mMahoadon, String mTenDan_hoadon, int mSoluongHoadon, double mGiaThitLon) {
        this.mMahoadon = mMahoadon;
        this.mTenDan_hoadon = mTenDan_hoadon;
        this.mSoluongHoadon = mSoluongHoadon;
        this.mGiaThitLon = mGiaThitLon;
    }

    public HoaDon() {
    }

    public String getmMahoadon() {
        return mMahoadon;
    }

    public void setmMahoadon(String mMahoadon) {
        this.mMahoadon = mMahoadon;
    }

    public String getmTenDan_hoadon() {
        return mTenDan_hoadon;
    }

    public void setmTenDan_hoadon(String mTenDan_hoadon) {
        this.mTenDan_hoadon = mTenDan_hoadon;
    }

    public int getmSoluongHoadon() {
        return mSoluongHoadon;
    }

    public void setmSoluongHoadon(int mSoluongHoadon) {
        this.mSoluongHoadon = mSoluongHoadon;
    }

    public double getmGiaThitLon() {
        return mGiaThitLon;
    }

    public void setmGiaThitLon(double mGiaThitLon) {
        this.mGiaThitLon = mGiaThitLon;
    }
}
