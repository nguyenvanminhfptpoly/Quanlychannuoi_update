package com.minhnv.admin88.quanlychannuoi;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    TextInputEditText ed_user, ed_pass;
    TextView tv_changepass, tv_signup;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ed_pass = findViewById(R.id.ed_passs);
        ed_user = findViewById(R.id.ed_user);
        tv_changepass = findViewById(R.id.dmk);
        tv_signup = findViewById(R.id.signup);
        btn_Login = findViewById(R.id.login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_user.getText().toString();
                String pass = ed_pass.getText().toString();
                if (name.equals("") && pass.equals("")){
                    Toast.makeText(SigninActivity.this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }else {
                Intent intent = new Intent(SigninActivity.this, ManHinhChinhActivity.class);
                    Toast.makeText(SigninActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                }
            }
        });
    }

    public void sign_up(View view) {
        Intent intent = new Intent(SigninActivity.this, SignUpActivity.class);
        startActivity(intent);
    }


}
