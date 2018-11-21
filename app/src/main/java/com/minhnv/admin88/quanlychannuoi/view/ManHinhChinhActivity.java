package com.minhnv.admin88.quanlychannuoi.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.minhnv.admin88.quanlychannuoi.R;
import com.minhnv.admin88.quanlychannuoi.activity.BaoCaoActivity;
import com.minhnv.admin88.quanlychannuoi.activity.CaTheActivity;
import com.minhnv.admin88.quanlychannuoi.activity.DanActivity;
import com.minhnv.admin88.quanlychannuoi.activity.HoaDonActivity;
import com.minhnv.admin88.quanlychannuoi.activity.NguoiDungActivity;
import com.minhnv.admin88.quanlychannuoi.activity.ThitLonSachActivity;

public class ManHinhChinhActivity extends AppCompatActivity {
    private RelativeLayout red;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        red = findViewById(R.id.rela2);
        red.setNestedScrollingEnabled(false);
    }

    public void avatar_cathe(View view) {
        Intent intent = new Intent(ManHinhChinhActivity.this, CaTheActivity.class);
        startActivity(intent);
    }

    public void avatar_dan(View view) {
        Intent intent = new Intent(ManHinhChinhActivity.this, DanActivity.class);
        startActivity(intent);
    }

    public void avatar_hoadon(View view) {
        Intent intent = new Intent(ManHinhChinhActivity.this, HoaDonActivity.class);
        startActivity(intent);
    }

    public void avatar_baocao(View view) {
        Intent intent = new Intent(ManHinhChinhActivity.this, BaoCaoActivity.class);
        startActivity(intent);
    }

    public void avatar_thilon(View view) {
        Toast.makeText(this, "Vui lòng sử dụng mạng !!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ManHinhChinhActivity.this, ThitLonSachActivity.class);
        startActivity(intent);
    }

    public void avatar_user(View view) {
        Intent intent = new Intent(ManHinhChinhActivity.this, NguoiDungActivity.class);
        startActivity(intent);
    }
}
