package com.example.chamcong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamcong.Connect.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Thongtinuser extends AppCompatActivity {

    Connection connect;
    EditText hoten, sdt, gioitinh, email, diachi, phuong, quan, tp;
    TextView chucvu, bophan;
    Button btnnewpw, btnSave;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinuser);

        hoten = (EditText) findViewById(R.id.hoten);
        sdt = (EditText) findViewById(R.id.sdt);
        gioitinh = (EditText) findViewById(R.id.gioitinh);
        email = (EditText) findViewById(R.id.email);
        diachi = (EditText) findViewById(R.id.diachi);
        phuong = (EditText) findViewById(R.id.phuong);
        quan = (EditText) findViewById(R.id.quan);
        tp = (EditText) findViewById(R.id.tp);

        chucvu = (TextView) findViewById(R.id.chucvu);
        bophan = (TextView) findViewById(R.id.bophan);

        btnnewpw = (Button) findViewById(R.id.btnnewpw);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u_hoten, u_sdt, u_gioitinh, u_email, u_phuong, u_quan, u_tp;
                u_hoten = hoten.getText().toString();
                u_sdt = sdt.getText().toString();
                u_gioitinh = gioitinh.getText().toString();
                u_email = email.getText().toString();
                u_phuong = phuong.getText().toString();
                u_quan = quan.getText().toString();
                u_tp = tp.getText().toString();

                ConnectionHelper conn = new ConnectionHelper();
                connect = conn.CONN();
            }
        });

        btnnewpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Thongtinuser.this, Doimatkhau.class);
                startActivity(i);
            }
        });
    }

    public void insertdata ( String u_hoten, String u_sdt, String u_gioitinh, String u_email, String u_phuong, String u_quan, String u_tp){
        try {
            ConnectionHelper conHelper = new ConnectionHelper();
            connect = conHelper.CONN();
            if(connect != null){
                String query = "INSERT INTO users VALUES ('" + u_hoten + "','" + u_sdt + "','" + u_gioitinh + "','" + u_email + "','" + u_phuong + "','"+ u_quan +"'" +
                        ",'"+ u_tp +"');";
                Statement st = connect.createStatement();
                ResultSet result = st.executeQuery(query);
                if(result.next())
                {

                    Toast.makeText(Thongtinuser.this, "Cập nhật thành công.",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Thongtinuser.this, "Lỗi! Vui lòng thử lại.",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
        catch (Exception ex){
            Log.e("Error:", ex.getMessage());
        }
    }

    public void showdata (View v){
        try {
            ConnectionHelper connHelper = new ConnectionHelper();
            connect = connHelper.CONN();
            if(connect != null){

                String query1 = "SELECT cv_ten FROM Phongbans WHERE cv_id = u_id";
                Statement st1 = connect.createStatement();
                ResultSet result1 = st1.executeQuery(query1);

                String query2 = "SELECT pb_ten FROM Phongbans WHERE pb_id = u_id";
                Statement st2 = connect.createStatement();
                ResultSet result2 = st1.executeQuery(query2);

                while (result1.next() && result2.next()){
                    chucvu.setText(result1.getString(String.valueOf(chucvu)));
                    bophan.setText(result2.getString(String.valueOf(bophan)));
                }
            }
        }catch (Exception e){

        }
    }
}