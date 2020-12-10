package com.example.doancmpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button btnLogin,btnRegister,btnOK,btnCancel;
    DatabaseHelperTK db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelperTK(getApplicationContext());
        edtUsername = findViewById(R.id.editTextUser);
        edtPassword = findViewById(R.id.editTextPass);
        btnLogin = findViewById(R.id.buttonlogin);
        btnRegister = findViewById(R.id.buttonregister);
        btnCancel = findViewById(R.id.buttoncancel);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                Boolean dangnhap = db.CheckDangNhap(account,pass);
                if(dangnhap==true)
                {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( LoginActivity.this, TrangChu.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Tài khoản không hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        /*btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.doancmpm.LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent, 100);
            }
        });*/
    }
}