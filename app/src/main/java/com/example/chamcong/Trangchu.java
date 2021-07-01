package com.example.chamcong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Trangchu extends AppCompatActivity {
    private Button scanBtn, userinfoBtn, historyBtn, logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        scanBtn = findViewById(R.id.scanBtn);
        userinfoBtn = findViewById(R.id.userinfoBtn);
        historyBtn = findViewById(R.id.historyBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, ScanQR.class);
                startActivity(intent);
            }
        });
        userinfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, Thongtinuser.class);
                startActivity(intent);
            }
        });
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, Lichsuchamcong.class);
                startActivity(intent);
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, Dangxuat.class);
                startActivity(intent);
            }
        });
    }
}