package com.example.admin88.quanlychannuoi.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin88.quanlychannuoi.R;

public class BaoCaoActivity extends AppCompatActivity {
    RecyclerView ryc_baocao;
    FloatingActionButton fab_baocao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        ryc_baocao = findViewById(R.id.recyclerview_baocao);
        fab_baocao = findViewById(R.id.recyclerview_baocao);
        ryc_baocao.setLayoutManager(new LinearLayoutManager(BaoCaoActivity.this));
    }
}
