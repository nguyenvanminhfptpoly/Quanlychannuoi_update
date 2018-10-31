package com.example.admin88.quanlychannuoi.Adapter_thilon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin88.quanlychannuoi.Fragment.BenhVaPhongTranhFragment;
import com.example.admin88.quanlychannuoi.Fragment.ThiTruongFragment;


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
