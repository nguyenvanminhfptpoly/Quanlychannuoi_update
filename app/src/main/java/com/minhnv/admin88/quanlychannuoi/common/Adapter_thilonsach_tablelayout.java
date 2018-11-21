package com.minhnv.admin88.quanlychannuoi.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.minhnv.admin88.quanlychannuoi.fragment.BenhVaPhongTranhFragment;
import com.minhnv.admin88.quanlychannuoi.fragment.ThiTruongFragment;


public class Adapter_thilonsach_tablelayout extends FragmentStatePagerAdapter {
    public Adapter_thilonsach_tablelayout(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ThiTruongFragment();
            case 1:
                return new BenhVaPhongTranhFragment();
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "THỊ TRƯỜNG";
            case 1:
                return "BỆNH VÀ CÁCH PHÒNG";
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}
