package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.chamcong.MyUtil.jsonArrayPhongban;

public class Thongtinphongban extends AppCompatActivity {
    TextView pbId,pbName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinphongban);
        setTitle("Thông tin phòng ban");

        pbId = findViewById(R.id.pb_id);
        pbName = findViewById(R.id.pb_ten);


        Intent intent = getIntent();
        int i = intent.getIntExtra("phongbandata",0);
        int id = intent.getIntExtra("phongbandata",0);

        try {
            JSONObject userObj = jsonArrayPhongban.getJSONObject(i);

            pbId.setText("ID: "+ userObj.getString("Pb_id"));
            pbName.setText("Phòng ban: "+ userObj.getString("Pb_ten"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}