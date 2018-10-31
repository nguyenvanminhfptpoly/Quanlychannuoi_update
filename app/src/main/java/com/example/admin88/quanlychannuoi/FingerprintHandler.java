package com.example.admin88.quanlychannuoi;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;


@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    private Context context;

    public FingerprintHandler(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){
        CancellationSignal cancellationSignal = new CancellationSignal();

        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("đã xảy ra lỗi xác thực. "+errString,false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Lỗi đã xảy ra",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Lỗi"+helpString,false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("bạn đăng nhập thành công",true);
    }

    @SuppressLint("ResourceAsColor")
    private void update(String s, boolean b){
        TextView xacthuc = (TextView) ((Activity)context).findViewById(R.id.tv_xacthuc);
        ImageView img_touch = (ImageView) ((Activity)context).findViewById(R.id.img_touchid);
        ImageView img_backdroud = (ImageView) ((Activity)context).findViewById(R.id.img_backgroud);

        xacthuc.setText(s);

        if (b==false){
            xacthuc.setTextColor(ContextCompat.getColor(context,R.color.white));
        }else {
            xacthuc.setTextColor(ContextCompat.getColor(context,R.color.white));
            img_touch.setImageResource(R.mipmap.ic_done);
            img_backdroud.setBackgroundColor(R.color.colorAccent);
            Intent intent = new Intent(context, ManHinhChinhActivity.class);
            context.startActivity(intent);
        }
    }
}
