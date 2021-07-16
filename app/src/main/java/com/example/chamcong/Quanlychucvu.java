package com.example.chamcong;

import android.app.Activity;
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
import com.example.chamcong.Object.Chucvu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Quanlychucvu extends AppCompatActivity {

    Button themChucvuBtn;

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<Chucvu> chucvuList;

    RequestQueue rq;

    String request_url = "https://run.mocky.io/v3/1f5fad2e-9949-4f2b-a9d6-52d93035459c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlychucvu);
        setTitle("Quản lý chức vụ");


        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.cvRecycleview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        chucvuList = new ArrayList<>();

        sendRequest();

        themChucvuBtn = (Button) findViewById(R.id.btnThemcv);
        themChucvuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quanlychucvu.this, Themchucvu.class);
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

                    Chucvu chucvu = new Chucvu();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        chucvu.setCv_ten(jsonObject.getString("Chuc vu"));
//                        chucvu.setPersonLastName(jsonObject.getString("lastname"));
//                        personUtils.setJobProfile(jsonObject.getString("jobprofile"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    chucvuList.add(chucvu);

                }

                mAdapter = new DSCVAdapter(Quanlychucvu.this, chucvuList);

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
