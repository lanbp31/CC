package com.example.chamcong;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.chamcong.Adapter.DSNVAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Quanlynhanvien extends AppCompatActivity {
    ListView lstData;
    DSNVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);

        lstData = findViewById(R.id.nvListview);

        new MyAsyncTask().execute();

        lstData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(Quanlynhanvien.this, Thongtinuser.class);
                intent.putExtra("userdata",i);
                startActivity(intent);

            }
        });
    }

    class MyAsyncTask extends AsyncTask {

        ProgressDialog dialog;
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Quanlynhanvien.this);
            dialog.show();

        }

        @Override
        protected Object doInBackground(Object[] objects) {

            StringBuffer response = new StringBuffer();

            try {
                URL url = new URL(MyUtil.URL_USER);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStreamReader ir = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(ir);
                String inputLine = null;

                while ((inputLine = br.readLine()) != null ){
                    response.append(inputLine);
                }
                br.close();
                ir.close();

                MyUtil.jsonArrayUser = new JSONArray(response.toString());

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            /* ----------- End Using Internet this method ----------- */

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            adapter = new DSNVAdapter(Quanlynhanvien.this,  MyUtil.jsonArrayUser);
            lstData.setAdapter(adapter);

            if (dialog.isShowing())dialog.dismiss();
        }

    }

}

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quanlynhanvien);
//
//        // Khởi tạo RecyclerView.
//        final RecyclerView nvRecycleview = (RecyclerView) findViewById(R.id.nvRecycleview);
//        nvRecycleview.setLayoutManager(new LinearLayoutManager(this));
//
//        // Khởi tạo OkHttpClient để lấy dữ liệu.
//        OkHttpClient client = new OkHttpClient();
//
//        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
//        Moshi moshi = new Moshi.Builder().build();
//        Type usersType = Types.newParameterizedType(List.class, User.class);
//        final JsonAdapter<List<User>> jsonAdapter = moshi.adapter(usersType);
//
//        // Tạo request lên server.
//        okhttp3.Request request = new Request.Builder()
//                .url("http://chamcong.somee.com/api/Users")
//                .build();
//
//        // Thực thi request.
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("Error", "Network Error");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
//                String json = response.body().string();
//                final List<User> user = jsonAdapter.fromJson(json);
//
//                // Cho hiển thị lên RecyclerView.
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        nvRecycleview.setAdapter(new DSNVAdapter(user, Quanlynhanvien.this));
//                    }
//                });
//            }
//        });
//    }
//}

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