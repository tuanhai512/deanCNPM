package com.example.doancmpm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TrangChu extends AppCompatActivity {
    DatabaseBook db;
    ImageView timSach, yeuCauMuon, ds, ama, inf, acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        timSach = (ImageView) findViewById(R.id.Timsach);
        yeuCauMuon = (ImageView) findViewById(R.id.yeuCauMuon);
        ds = (ImageView) findViewById(R.id.nganhHoc);
        ama = (ImageView) findViewById(R.id.amazing);
        inf = (ImageView) findViewById(R.id.info);
        acc = (ImageView) findViewById(R.id.account);
        timSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrangChu.this, ListSearch.class);
                startActivity(intent);
            }
        });
        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrangChu.this, ListBookActivity.class);
                startActivity(intent);
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TrangChu.this, AccountActivity.class);
                startActivity(intent);
            }
        });

    }
}