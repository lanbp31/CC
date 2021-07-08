package com.example.chamcong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


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
                startActivity(i);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trangchu.this, Thongtinuser.class);
                startActivity(i);
            }
        });

        Intent in = getIntent();
        String string = in.getStringExtra("message");
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Trangchu.this);
                builder.setTitle("Xác nhận đăng xuất").
                        setMessage("Bạn muốn đăng xuất?");
                builder.setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });    }
}
