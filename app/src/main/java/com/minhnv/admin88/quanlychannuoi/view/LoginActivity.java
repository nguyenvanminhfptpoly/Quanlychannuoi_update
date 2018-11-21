package com.minhnv.admin88.quanlychannuoi.view;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhnv.admin88.quanlychannuoi.R;

public class LoginActivity extends AppCompatActivity {
    private TextView tv_title, tv_xacthuc, tv_login;
    private ImageView img_touchid;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img_touchid = findViewById(R.id.img_touchid);
        tv_xacthuc = findViewById(R.id.tv_xacthuc);
        tv_login = findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            if (!fingerprintManager.isHardwareDetected()) {
                tv_xacthuc.setText("thiết bị của bạn không thuộc android 6.0");
            } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                tv_xacthuc.setText("Quyền không được cấp để sử dụng dấu vân tay");
            }else if (!keyguardManager.isKeyguardSecure()){
                tv_xacthuc.setText("thêm khóa vào điện thoại của bạn trong cài đặt");
            }else {
                tv_xacthuc.setText("Sử dụng cảm biến trên máy để truy cập");

                FingerprintHandler fingerprintHandler = new FingerprintHandler(this);
                fingerprintHandler.startAuth(fingerprintManager,null);
            }
        }
    }
}
