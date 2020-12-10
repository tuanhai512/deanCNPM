package com.example.doancmpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelperTK db;
    EditText editTextUsername;
    EditText editTextPass;
    EditText editTextPass2;
    Button btnOK;
    Button btnCancel;
    /*Button btnLogin;
    Button btnthoat;
    DatabaseHelperTK dbtk;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelperTK(getApplicationContext());
        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPass = (EditText)findViewById(R.id.editTextPass);
        editTextPass2 = (EditText)findViewById(R.id.editTextPass2);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        //dbtk = new DatabaseHelperTK(getApplicationContext());
        //db.insert("admin","123");
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = editTextUsername.getText().toString();
                String s2 = editTextPass.getText().toString();
                String s3 = editTextPass2.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Tài khoản và mật khẩu không được để trống", Toast.LENGTH_SHORT).show();

                }
                else {
                    if(s2.equals(s3)){
                        Boolean checkTK = db.checkTK(s1);
                        if(checkTK)
                        {
                            Boolean insert = db.insert(s1,s2);
                            if(insert)
                            {
                                Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Tài khoản không hợp lệ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        /*buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });*/
    }
}