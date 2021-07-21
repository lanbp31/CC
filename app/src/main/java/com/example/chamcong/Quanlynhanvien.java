package com.example.chamcong;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chamcong.Adapter.DSNVAdapter;
import com.example.chamcong.Object.User;
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

public class Quanlynhanvien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);

        // Khởi tạo RecyclerView.
        final RecyclerView nvRecycleview = (RecyclerView) findViewById(R.id.nvRecycleview);
        nvRecycleview.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, User.class);
        final JsonAdapter<List<User>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        okhttp3.Request request = new Request.Builder()
                .url("http://chamcong.somee.com/api/Users")
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
                final List<User> user = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nvRecycleview.setAdapter(new DSNVAdapter(user, Quanlynhanvien.this));
                    }
                });
            }
        });
    }
}

//    Button themNhanvienBtn;
//    SearchView timNhanvienBtn;
//
//
//    RecyclerView recyclerView;
//    RecyclerView.Adapter mAdapter;
//    RecyclerView.LayoutManager layoutManager;
//
//    List<User> userList;
//
//    RequestQueue rq;
//
//    String request_url = "http://chamcong.somee.com/api/users";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quanlynhanvien);
//        setTitle("Quản lý nhân viên");
//
//        rq = Volley.newRequestQueue(this);
//
//        recyclerView = (RecyclerView) findViewById(R.id.nvRecycleview);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(mAdapter);
//
//
//        userList = new ArrayList<>();
//
//        sendRequest();
//
////        @Override
////        public boolean onCreateOptionsMenu(Menu menu) {
////            getMenuInflater().inflate(R.menu.menu, menu);
////
////            MenuItem menuItem = menu.findItem(R.id.btnTimnv);
////
////            SearchView searchView = (SearchView) menuItem.getActionView();
////
////            searchView.setMaxWidth(Integer.MAX_VALUE);
////
////            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
////                @Override
////                public boolean onQueryTextSubmit(String query) {
////                    return false;
////                }
////
////                @Override
////                public boolean onQueryTextChange(String newText) {
////
////                    DSNVAdapter.getFilter().filter(newText);
////                    return true;
////                }
////            });
////
////
////
////            return  true;
////        }
//
//
//        themNhanvienBtn = (Button) findViewById(R.id.btnThemnv);
//        themNhanvienBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Quanlynhanvien.this, ThemNhanVien.class);
//                startActivity(i);
//            }
//        });
//
//    }
//
//    public void sendRequest() {
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url,null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        for (int i = 0; i < response.length(); i++) {
//
//                            User user = new User();
//
//                            try {
//                                JSONObject jsonObject = response.getJSONObject(i);
//
//                                user.setUser_hoten("Ho ten: " + jsonObject.getString("Hoten"));
//                                user.setUser_email("Email: " + jsonObject.getString("Email"));
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                            userList.add(user);
//
//                        }
//
////                        mAdapter = new DSCVAdapter(Quanlynhanvien.this, userList);
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
//        rq.add(jsonArrayRequest);
//    }
//}