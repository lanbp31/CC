package com.example.chamcong;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.Method.GET;

public class Quanlynhanvien extends AppCompatActivity {
    String URL = "http://chamcong.somee.com/api/Users";
    String data = "";
    private TextView ds_nhanvien;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);

        requestQueue = Volley.newRequestQueue(this);

        ds_nhanvien = (TextView) findViewById(R.id.dsnv);

        JsonObjectRequest jsonObjectRequestRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("users");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String user_hoten = jsonObject.getString("User_hoten");
                                String user_email = jsonObject.getString("User_email");
                                String chucvu = jsonObject.getString("cv_ten");
                                String phongban = jsonObject.getString("Pb_ten");

                                data += user_hoten + "\n" + user_email + "\n" + chucvu + "\n" + phongban;
                            }
                            ds_nhanvien.setText(data);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        requestQueue.add(jsonObjectRequestRequest);
    }
}

