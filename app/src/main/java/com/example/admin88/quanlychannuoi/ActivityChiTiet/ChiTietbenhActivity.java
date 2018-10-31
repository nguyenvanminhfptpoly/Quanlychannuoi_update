package com.example.admin88.quanlychannuoi.ActivityChiTiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin88.quanlychannuoi.R;

public class ChiTietbenhActivity extends AppCompatActivity {
    TextView tv_tenbenh,tv_cachphong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tietbenh);
        tv_cachphong = findViewById(R.id.tv_phongtranh);
        tv_tenbenh = findViewById(R.id.tv_tenbenh);

        tv_tenbenh.setText(getIntent().getStringExtra("tenbenh"));
        tv_cachphong.setText(getIntent().getStringExtra("cachphong"));
    }
}
