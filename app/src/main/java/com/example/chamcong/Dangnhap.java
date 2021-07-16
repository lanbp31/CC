package com.example.chamcong;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamcong.Connect.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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


                if(Username.trim().equals("")|| Password.trim().equals(""))
                    Toast.makeText(Dangnhap.this, "Hãy nhập tên đăng nhập và mật khẩu",
                                                        Toast.LENGTH_LONG).show();
                else
                {
                    try {
                        Connection con = ConnectionHelper.CONN();
                        if (con == null) {
                            Toast.makeText(Dangnhap.this, "Lỗi kết nối",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            String query = "SELECT * FROM *****";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(query);

                            if(rs.next())
                            {

                                Toast.makeText(Dangnhap.this, "Đăng nhập thành công",
                                        Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(Dangnhap.this, "Đăng nhập thất bại",
                                        Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                    catch (Exception e)
                    {
                        Log.e("ERRO", e.getMessage());
                    }
                }
                Toast.makeText(Dangnhap.this, "Hãy nhập tên đăng nhập và mật khẩu",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}