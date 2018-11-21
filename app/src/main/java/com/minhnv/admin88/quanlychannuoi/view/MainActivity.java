package com.minhnv.admin88.quanlychannuoi.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minhnv.admin88.quanlychannuoi.R;

public class MainActivity extends AppCompatActivity {
    private static int Splash_time_out = 1400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);

                startActivity(intent);
                finish();
            }
        },Splash_time_out);
    }

}
