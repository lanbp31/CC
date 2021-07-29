package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamcong.R;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.chamcong.MyUtil.jsonArrayChucvu;

public class Thongtinchucvu extends AppCompatActivity {
    TextView cvId,cvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinchucvu);
        setTitle("Thông tin chức vụ");

        cvId = findViewById(R.id.cv_id);
        cvName = findViewById(R.id.cv_ten);


        Intent intent = getIntent();
        int i = intent.getIntExtra("chucvudata",0);
        int id = intent.getIntExtra("chucvuData",0);

        try {
            JSONObject userObj = jsonArrayChucvu.getJSONObject(i);

            cvId.setText("ID: "+ userObj.getString("cv_id"));
            cvName.setText("Chức vụ: "+ userObj.getString("cv_ten"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}