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

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Adapter.DSCVAdapter;
import com.example.chamcong.Object.Chucvu;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Quanlychucvu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlychucvu);

        // Khởi tạo RecyclerView.
        final RecyclerView cvRecycleview = (RecyclerView) findViewById(R.id.cvRecycleview);
        cvRecycleview.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Chucvu.class);
        final JsonAdapter<List<Chucvu>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        okhttp3.Request request = new Request.Builder()
                .url("http://chamcong.somee.com/api/Chucvus")
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<Chucvu> chucvu = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cvRecycleview.setAdapter(new DSCVAdapter(chucvu, Quanlychucvu.this));
                    }
                });
            }
        });
    }
}

//    Button themChucvuBtn;
//
//    RecyclerView recyclerView;
//    RecyclerView.Adapter mAdapter;
//    RecyclerView.LayoutManager layoutManager;
//
//    List<Chucvu> chucvuList;
//
//    RequestQueue rq;
//
//    String request_url = "https://run.mocky.io/v3/1f5fad2e-9949-4f2b-a9d6-52d93035459c";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quanlychucvu);
//        setTitle("Quản lý chức vụ");
//
//
//        rq = Volley.newRequestQueue(this);
//
//        recyclerView = (RecyclerView) findViewById(R.id.cvRecycleview);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//        chucvuList = new ArrayList<>();
//
//        sendRequest();
//
//        // Them chuc vu
//        themChucvuBtn = (Button) findViewById(R.id.btnThemcv);
//        themChucvuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Quanlychucvu.this, Themchucvu.class);
//                startActivity(i);
//            }
//        });
//    }
//
//    // In danh sach chuc vu
//    public void sendRequest(){
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null,
//                new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for(int i = 0; i < response.length(); i++){
//
//                    Chucvu chucvu = new Chucvu();
//
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//
//                        chucvu.setCv_ten(jsonObject.getString("cv_ten"));
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    chucvuList.add(chucvu);
//
//                }
//
//                mAdapter = new DSCVAdapter(Quanlychucvu.this, chucvuList);
//
//                recyclerView.setAdapter(mAdapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("Volley Error: ", String.valueOf(error));
//            }
//        });
//
//        rq.add(jsonArrayRequest);
//
//    }
//
//}
