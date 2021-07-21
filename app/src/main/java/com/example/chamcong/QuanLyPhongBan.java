package com.example.chamcong;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.chamcong.Adapter.DSPBAdapter;
import com.example.chamcong.Object.Phongban;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuanLyPhongBan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyphongban);

        // Khởi tạo RecyclerView.
        final RecyclerView pbRecycleview = (RecyclerView) findViewById(R.id.pbRecycleview);
        pbRecycleview.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Phongban.class);
        final JsonAdapter<List<Phongban>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        okhttp3.Request request = new Request.Builder()
                .url("http://chamcong.somee.com/api/Phongbans")
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
                final List<Phongban> phongban = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pbRecycleview.setAdapter(new DSPBAdapter(QuanLyPhongBan.this, phongban));
                    }
                });
            }
        });
    }
}

//    Button themPhongbanBtn;
//
//    RecyclerView recyclerView;
//    RecyclerView.Adapter mAdapter;
//    RecyclerView.LayoutManager layoutManager;
//
//    List<Phongban> phongbanList;
//
//    RequestQueue rq;
//
//    String request_url = "https://run.mocky.io/v3/1f5fad2e-9949-4f2b-a9d6-52d93035459c";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quan_ly_phong_ban);
//        setTitle("Quản lý Phòng ban");
//
//        themPhongbanBtn = (Button) findViewById(R.id.btnThemcv);
//        themPhongbanBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(QuanLyPhongBan.this, ThemPhongBan.class);
//                startActivity(i);
//            }
//        });
//
//        rq = Volley.newRequestQueue(this);
//
//        recyclerView = (RecyclerView) findViewById(R.id.pbRecycleview);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//        phongbanList = new ArrayList<>();
//
//        sendRequest();
//
//    }
//
//    public void sendRequest(){
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        for (int i = 0; i < response.length(); i++){
//
//                            Phongban phongban = new Phongban();
//
//                            try {
//                                JSONObject jsonObject = response.getJSONObject(i);
//
//                                phongban.setPb_ten(jsonObject.getString("Phong ban"));
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                            phongbanList.add(phongban);
//
//                        }
//
//                        mAdapter = new DSPBAdapter(QuanLyPhongBan.this, phongbanList);
//
//                        recyclerView.setAdapter(mAdapter);
//
//                    }
//                }, new Response.ErrorListener() {
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
