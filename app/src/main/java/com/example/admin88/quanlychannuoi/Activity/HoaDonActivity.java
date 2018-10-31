package com.example.admin88.quanlychannuoi.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.admin88.quanlychannuoi.R;

public class HoaDonActivity extends AppCompatActivity {
    RecyclerView recyclerView_hoadon;
    FloatingActionButton fab_hoadon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        recyclerView_hoadon = findViewById(R.id.recyclerview_hoadon);
        fab_hoadon = findViewById(R.id.fab_hoadon);
    }
}
