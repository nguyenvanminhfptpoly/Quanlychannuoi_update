package com.example.admin88.quanlychannuoi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin88.quanlychannuoi.R;

public class CaTheActivity extends AppCompatActivity {
    RecyclerView recyclerview_cathe;
    Button btn_dan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_the);
        btn_dan = findViewById(R.id.btn_dan);

        btn_dan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaTheActivity.this, DanActivity.class);
                startActivity(intent);
            }
        });
        recyclerview_cathe = findViewById(R.id.recyclerview_cathe);
        recyclerview_cathe.setLayoutManager(new LinearLayoutManager(CaTheActivity.this));

    }
}
