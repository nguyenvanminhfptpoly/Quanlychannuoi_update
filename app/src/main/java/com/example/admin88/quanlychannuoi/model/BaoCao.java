package com.example.admin88.quanlychannuoi.model;

public class BaoCao {
    private String mTimeBaoCao;
    private double mDoanhthu;
    private double mChiPhi;

    public BaoCao(String mTimeBaoCao, double mDoanhthu, double mChiPhi) {
        this.mTimeBaoCao = mTimeBaoCao;
        this.mDoanhthu = mDoanhthu;
        this.mChiPhi = mChiPhi;
    }

    public BaoCao() {
    }

    public String getmTimeBaoCao() {
        return mTimeBaoCao;
    }

    public void setmTimeBaoCao(String mTimeBaoCao) {
        this.mTimeBaoCao = mTimeBaoCao;
    }

    public double getmDoanhthu() {
        return mDoanhthu;
    }

    public void setmDoanhthu(double mDoanhthu) {
        this.mDoanhthu = mDoanhthu;
    }

    public double getmChiPhi() {
        return mChiPhi;
    }

    public void setmChiPhi(double mChiPhi) {
        this.mChiPhi = mChiPhi;
    }
}
