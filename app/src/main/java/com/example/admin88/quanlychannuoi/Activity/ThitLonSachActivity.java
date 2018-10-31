package com.example.admin88.quanlychannuoi.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin88.quanlychannuoi.Adapter_thilon.Adapter_thilonsach_tablelayout;
import com.example.admin88.quanlychannuoi.R;

public class ThitLonSachActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Adapter_thilonsach_tablelayout adapter_thilonsach_tablelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thit_lon_sach);
        tabLayout = findViewById(R.id.table_layout);
        viewPager = findViewById(R.id.vp_danhsach);
        adapter_thilonsach_tablelayout = new Adapter_thilonsach_tablelayout(getSupportFragmentManager());
        viewPager.setAdapter(adapter_thilonsach_tablelayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
