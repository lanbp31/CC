package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.chamcong.MyUtil.jsonArrayUser;

public class Thongtinuser extends AppCompatActivity {

    TextView nv_hoten, nv_sdt, nv_gioitinh, nv_email, nv_diachi, nv_chucvu, nv_phongban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinuser);
        setTitle("Thông tin nhân viên");

        nv_hoten = findViewById(R.id.hoten);
        nv_sdt = findViewById(R.id.sdt);
        nv_gioitinh = findViewById(R.id.gioitinh);
        nv_email = findViewById(R.id.email);
        nv_diachi = findViewById(R.id.diachi);
        nv_chucvu = findViewById(R.id.chucvu);
        nv_phongban = findViewById(R.id.phongban);


        Intent intent = getIntent();
        int i = intent.getIntExtra("userdata",0);
        int id = intent.getIntExtra("userData",0);

        try {
            JSONObject userObj = jsonArrayUser.getJSONObject(i);

            nv_hoten.setText(userObj.getString("User_hoten"));
            nv_sdt.setText(userObj.getString("User_sdt"));
            nv_gioitinh.setText(userObj.getString("User_gioitinh"));
            nv_email.setText(userObj.getString("User_email"));
            nv_diachi.setText(userObj.getString("User_diachi"));
            nv_chucvu.setText(userObj.getString("Chucvu"));
            nv_phongban.setText(userObj.getString("Phongban"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}