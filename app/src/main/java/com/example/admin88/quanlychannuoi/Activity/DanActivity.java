package com.example.admin88.quanlychannuoi.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin88.quanlychannuoi.R;

public class DanActivity extends AppCompatActivity {
    RecyclerView recyclerview_dan;
    FloatingActionButton fab_dan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dan);
        recyclerview_dan = findViewById(R.id.recyclerview_dan);
        fab_dan = findViewById(R.id.fab_dan);
        recyclerview_dan.setLayoutManager(new LinearLayoutManager(DanActivity.this));
    }

    public void thucanchodan(View view) {
        Intent intent = new Intent(DanActivity.this, ThucAnActivity.class);
        startActivity(intent);
    }
}
