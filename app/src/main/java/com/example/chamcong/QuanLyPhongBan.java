package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Adapter.DSCVAdapter;
import com.example.chamcong.Adapter.DSPBAdapter;
import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.Object.Phongban;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuanLyPhongBan extends AppCompatActivity {

    Button themPhongbanBtn;

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Phongban> phongbanList;

    RequestQueue rq;

    String request_url = "https://run.mocky.io/v3/1f5fad2e-9949-4f2b-a9d6-52d93035459c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phong_ban);
        setTitle("Quản lý Phòng ban");


        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.pbRecycleview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        phongbanList = new ArrayList<>();

        sendRequest();

        themPhongbanBtn = (Button) findViewById(R.id.btnThemcv);
        themPhongbanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuanLyPhongBan.this, ThemPhongBan.class);
                startActivity(i);
            }
        });
    }

    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i = 0; i < response.length(); i++){

                            Phongban phongban = new Phongban();

                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                phongban.setPb_ten(jsonObject.getString("Phong ban"));
//                        chucvu.setPersonLastName(jsonObject.getString("lastname"));
//                        personUtils.setJobProfile(jsonObject.getString("jobprofile"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            phongbanList.add(phongban);

                        }

                        mAdapter = new DSPBAdapter(QuanLyPhongBan.this, phongbanList);

                        recyclerView.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);

    }

}
