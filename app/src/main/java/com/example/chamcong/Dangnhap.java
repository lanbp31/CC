package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Dangnhap extends AppCompatActivity {

    private Button BtnDangnhap;
    private EditText EtUsername, EtPassword;
    public Connection connection;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        BtnDangnhap = (Button) findViewById(R.id.btnDN);

        EtUsername = (EditText) findViewById(R.id.username);
        EtPassword = (EditText) findViewById(R.id.password);

        BtnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = EtUsername.getText().toString();
                String Password = EtPassword.getText().toString();

                if(TextUtils.isEmpty(Username) && TextUtils.isEmpty(Password)) {
                    Toast.makeText(Dangnhap.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        ConnectionHelper connectionHelper = new ConnectionHelper();
                        connection = connectionHelper.conn();
                        if(connection != null){
                            String = "SELECT pqu_id FROM phanquyenuser"
                        }
                    }
                    catch (SQLException e){
                    }
                }
            }
        });
    }

    private void CheckQuyenTruyCap (String qpu_id) {
    }

}