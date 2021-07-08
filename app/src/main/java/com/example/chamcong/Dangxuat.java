package com.example.chamcong;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

public class Dangxuat extends Dangnhap {

    Button logoutBtn;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangxuat);
        logoutBtn = (Button) findViewById(R.id.logoutBtn);

        Intent in = getIntent();
        String string = in.getStringExtra("message");
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dangxuat.this);
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
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });
    }
}