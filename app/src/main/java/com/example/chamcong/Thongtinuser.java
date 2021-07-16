package com.example.chamcong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                String ht, dt, gt, eml, dc, phg, qun, tpho;
                ht = hoten.getText().toString();
                dt = sdt.getText().toString();
                gt = gioitinh.getText().toString();
                eml = email.getText().toString();
                phg = phuong.getText().toString();
                qun = quan.getText().toString();
                tpho = tp.getText().toString();

                ConnectionHelper conn = new ConnectionHelper();
            }
        });

        btnnewpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
            }
        }
        catch (Exception e){

        }
    }
}