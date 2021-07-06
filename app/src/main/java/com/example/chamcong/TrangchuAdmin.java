package com.example.chamcong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangchuAdmin extends AppCompatActivity {

    Button scanBtn, logoutBtn, historyBtn, infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        scanBtn = findViewById(R.id.scanBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        historyBtn = findViewById(R.id.historyBtn);
        infoBtn = findViewById(R.id.infoBtn);

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, ScanQR.class);
                startActivity(i);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Lichsuchamcong.class);
                startActivity(i);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Thongtinuser.class);
                startActivity(i);
            }
        });
    }
}