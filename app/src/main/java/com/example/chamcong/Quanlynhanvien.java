package com.example.chamcong;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Adapter.DSCVAdapter;
import com.example.chamcong.Adapter.DSNVAdapter;
import com.example.chamcong.Connect.ConnectionHelper;
import com.example.chamcong.Object.Chucvu;
import com.example.chamcong.Object.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quanlynhanvien extends AppCompatActivity {

    private Button themNhanvienBtn;
    SearchView timNhanvienBtn;


    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    List<User> userList;

    RequestQueue rq;

    String request_url = "http://chamcong.somee.com/api/users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);
        setTitle("Quản lý nhân viên");

        timNhanvienBtn = (SearchView) findViewById(R.id.btnTimnv);
//        dsnvArrayAdapter = new DSNVAdapter(this, dsnvArraylist);
        //        timNhanvienBtn.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if(userList.contains(query)){
//                    userAdapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(Quanlynhanvien.this, "No Match found",Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        load_dsnv();


        themNhanvienBtn = (Button) findViewById(R.id.btnThemnv);
        themNhanvienBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quanlynhanvien.this, ThemNhanVien.class);
                startActivity(i);
            }
        });


        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.nvRecycleview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        userList = new ArrayList<>();

        sendRequest();
    }

    public void sendRequest() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {

                            User user = new User();

                            try {
                                JSONObject jsonObject = response.getJSONObject(i);

                                user.setUser_hoten(jsonObject.getString("hoten"));
                                user.setUser_email(jsonObject.getString("email"));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            userList.add(user);

                        }

                        mAdapter = new DSCVAdapter(Quanlynhanvien.this, userList);

                        recyclerView.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });
    }
}