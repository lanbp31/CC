package com.example.chamcong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;

public class Dangnhap extends AppCompatActivity {

    private Button BtnDangnhap;
    private EditText EtUsername, EtPassword;
    String Username, Password;
    ConnectionHelper connection;

    private static final String DATABASE_NAME = "Db_chamcong.db";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        BtnDangnhap = (Button) findViewById(R.id.btnlogin);

        EtUsername = (EditText) findViewById(R.id.username);
        EtPassword = (EditText) findViewById(R.id.password);

        BtnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = EtUsername.getText().toString();
                String Password = EtPassword.getText().toString();
                Connection connection = ConnectionHelper.CONN();

                if (connection == null) {
                    String message = "Kết nối Server thất bại.";
                }
                else{

                }

            }
        });
    }

    private void CheckQuyenTruyCap (String qpu_id) {
    }

}