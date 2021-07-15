package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Adapter.DSNVAdapter;
import com.example.chamcong.Object.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Quanlynhanvien extends AppCompatActivity {
    private static final String URL = "http://chamcong.somee.com/api/Users";

    private RequestQueue requestQueue;
    private Button themNhanvienBtn;

    SearchView timNhanvienBtn;
    ListView ds_nhanvien;
    List<User> userList;
    ArrayList<String> list;
    ArrayAdapter<String > userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);

        ds_nhanvien = (ListView) findViewById(R.id.dsnv);
        userList = new ArrayList<>();
        load_dsnv();
//        userAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,list);
//        ds_nhanvien.setAdapter(userAdapter);

        timNhanvienBtn = (SearchView) findViewById(R.id.btnTimnv);
        themNhanvienBtn = (Button) findViewById(R.id.btnThemnv);


        themNhanvienBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quanlynhanvien.this, ThemNhanVien.class);
                startActivity(i);
            }
        });

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

    }

    private void load_dsnv() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray userArray = obj.getJSONArray("User");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < userArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject userObject = userArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                User user =
                                        new User(userObject.getString("hoten"), userObject.getString("email"));

                                //adding the hero to herolist
                                userList.add(user);
                            }

                            //creating custom adapter object
                            DSNVAdapter adapter = new DSNVAdapter(userList, getApplicationContext());

                            //adding the adapter to listview
                            ds_nhanvien.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}

