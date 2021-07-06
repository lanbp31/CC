package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BtnDangnhap;
        BtnDangnhap = findViewById(R.id.btnDN);

        BtnDangnhap.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Dangnhap.class);
            startActivity(intent);
        });

    }
}