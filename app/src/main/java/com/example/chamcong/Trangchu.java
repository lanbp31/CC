package com.example.chamcong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseUser;

public class Trangchu extends AppCompatActivity {
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
                startActivity(new Intent(getApplicationContext(),ScanQR.class));
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trangchu.this, Lichsuchamcong.class);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trangchu.this, Thongtinuser.class);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to logout our user.
                ParseUser.logOutInBackground(e -> {
                    if (e == null) {
                        Toast.makeText(Trangchu.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Trangchu.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });
    }
}
