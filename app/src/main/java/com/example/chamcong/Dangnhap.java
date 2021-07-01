package com.example.chamcong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dangnhap extends AppCompatActivity {

    private TextView EtUsername, EtPassword;
    private Button BtnDN;
    private int counter = 5;

    String username = "";
    String password = "";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        EtUsername = (TextView) findViewById(R.id.username);
        EtPassword = (TextView) findViewById(R.id.pw);
        BtnDN = (Button) findViewById(R.id.btnDN);

        BtnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL = "";
                String username = EtUsername.getText().toString();
                String password = EtPassword.getText().toString();

                if (EtUsername.getText().length() != 0 && EtPassword.getText().length() != 0){
                    if(EtUsername.getText().toString().equals(username) &&
                            EtPassword.getText().toString().equals(password)){
                        Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thành công!",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Dangnhap.this, Trangchu.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Dangnhap.this, "Đăng nhập thất bại, hãy thử lại.",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Dangnhap.this, "Hãy nhập đủ thông tin.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}