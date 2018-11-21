package com.minhnv.admin88.quanlychannuoi;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextInputLayout tvFirstname;
    private TextInputEditText edFirstname;
    private TextInputLayout tvName;
    private TextInputEditText edName;
    private TextInputLayout tvEmail;
    private TextInputEditText edEmail;
    private TextInputLayout tvPassword;
    private TextInputEditText edPaswword;
    private Button btnSignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvFirstname = (TextInputLayout) findViewById(R.id.tv_firstname);
        edFirstname = (TextInputEditText) findViewById(R.id.ed_firstname);
        tvName = (TextInputLayout) findViewById(R.id.tv_name);
        edName = (TextInputEditText) findViewById(R.id.ed_name);
        tvEmail = (TextInputLayout) findViewById(R.id.tv_email);
        edEmail = (TextInputEditText) findViewById(R.id.ed_email);
        tvPassword = (TextInputLayout) findViewById(R.id.tv_password);
        edPaswword = (TextInputEditText) findViewById(R.id.ed_paswword);
        btnSignup = (Button) findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mFirstName = edFirstname.getText().toString();
                String mName = edName.getText().toString();
                String mMail = edEmail.getText().toString();
                String mPass = edPaswword.getText().toString();
                if (mFirstName.isEmpty() && mName.isEmpty() && mMail.isEmpty() && mPass.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
