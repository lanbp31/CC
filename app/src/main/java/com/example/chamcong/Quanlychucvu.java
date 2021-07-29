package com.example.chamcong;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.chamcong.Adapter.DSCVAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Quanlychucvu extends AppCompatActivity {
    ListView lstData;
    DSCVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlychucvu);

        lstData = findViewById(R.id.cvListview);

        new MyAsyncTask().execute();

        lstData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(Quanlychucvu.this, Thongtinchucvu.class);
                intent.putExtra("chucvudata",i);
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
            dialog = new ProgressDialog(Quanlychucvu.this);
            dialog.show();

        }

        @Override
        protected Object doInBackground(Object[] objects) {

            StringBuffer response = new StringBuffer();

            try {
                URL url = new URL(MyUtil.URL_CHUCVU);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStreamReader ir = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(ir);
                String inputLine = null;

                while ((inputLine = br.readLine()) != null ){
                    response.append(inputLine);
                }
                br.close();
                ir.close();

                MyUtil.jsonArrayChucvu = new JSONArray(response.toString());

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            /* ----------- End Using Internet this method ----------- */

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            adapter = new DSCVAdapter(Quanlychucvu.this,  MyUtil.jsonArrayChucvu);
            lstData.setAdapter(adapter);

            if (dialog.isShowing())dialog.dismiss();
        }

    }

}

//    //
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
//    EditText edtSearch;
//    ListView listView;
//    public static List<Chucvu> chucvuModelList = new ArrayList<>();
//    Chucvu chucvu;
//    DSCVAdapter dscvAdapter;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quanlychucvu);
//        listView = findViewById(R.id.cvListview);
//        edtSearch = findViewById(R.id.cvSearch);
//
//
//        getSupportActionBar().setTitle("Quan ly chuc vu");
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        fetchData();
////        listView.setOnItemClickListener((parent, view, position, id) -> {
////            startActivity(new Intent(getApplicationContext(), Thongtinchucvu.class).putExtra("position", position));
////        });
//        edtSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                dscvAdapter.getFilter().filter(s);
//                dscvAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

//        searchStr.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });
//
//        String url = "http://chamcong.somee.com/api/Chucvus";
//
//        //initialize progress dialog
//        final ProgressDialog dialog = new ProgressDialog(this);
//
//        dialog.setMessage("please wait...");
//        //setcancelable true
//        dialog.setCancelable(true);
//
//        dialog.show();
//
//        StringRequest request = new StringRequest(Request.Method.GET,
//                url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        if (response != null) {
//
//                            dialog.dismiss();
//
//                            try {
//                                JSONArray jsonArray = new JSONArray(response);
//                                parseArray(jsonArray);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//
//                            }
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
//    }
//
//    private void filter(String text) {
//        ArrayList<Chucvu> arrayList = new ArrayList<>();
//        for (Chucvu chucvu: dataArrayList) {
//            if(chucvu.getCv_ten().toLowerCase().contains(text.toLowerCase()));
//            arrayList.add(chucvu);
//        }
//    }
//
//    private void parseArray(JSONArray jsonArray) {
//
//        for (int i = 1; i <= jsonArray.length(); i++) {
//            try {
//                //initialize jsonobject
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                //initialize main data
//
//                Chucvu data = new Chucvu();
//
//                //set name
//                data.setCv_ten(jsonObject.getString("cv_ten"));
//
//                //
////                    data.setAvatar(jsonObject.getString("User_hinhanh"));
//                //adding data in arraylist
//
//                dataArrayList.add(data);
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            listView.setAdapter(new BaseAdapter() {
//                @Override
//                public int getCount() {
//                    return dataArrayList.size();
//                }
//
//                @Override
//                public Object getItem(int position) {
//                    return 0;
//                }
//
//                @Override
//                public long getItemId(int position) {
//                    return 0;
//                }
//
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = getLayoutInflater().inflate(
//                            R.layout.dscv, null);
//                    //initialize main data
//                    Chucvu data = dataArrayList.get(position);
//
//                    //initialize and assign variables
//
//                    ImageView imageView = view.findViewById(R.id.imageview);
//                    TextView textView = view.findViewById(R.id.cv_ten);
//
//                    //set image with imageview
//
////                        Glide.with(getApplicationContext())
////                                .load(data.get()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
//                    textView.setText(data.getCv_ten());
//
//                    return view;
//                }
//            });
//        }


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
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//
//                        Chucvu chucvu = new Chucvu();
//
//                        chucvu.setCv_ten(jsonObject.getString("cv_ten"));
////                        chucvu.setPersonLastName(jsonObject.getString("lastname"));
//    SearchView searchView;
//    DSCVAdapter dscvAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quanlychucvu);
//
//        // Khởi tạo RecyclerView.
//        final RecyclerView cvRecycleview = (RecyclerView) findViewById(R.id.cvRecycleview);
//        cvRecycleview.setLayoutManager(new LinearLayoutManager(this));
//
//        // Khởi tạo OkHttpClient để lấy dữ liệu.
//        OkHttpClient client = new OkHttpClient();
//
//        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
//        Moshi moshi = new Moshi.Builder().build();
//        Type usersType = Types.newParameterizedType(List.class, Chucvu.class);
//        final JsonAdapter<List<Chucvu>> jsonAdapter = moshi.adapter(usersType);
//
//        // Tạo request lên server.
//        okhttp3.Request request = new Request.Builder()
//                .url("http://chamcong.somee.com/api/Chucvus")
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
//                final List<Chucvu> chucvu = jsonAdapter.fromJson(json);
//
//                // Cho hiển thị lên RecyclerView.
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        cvRecycleview.setAdapter(new DSCVAdapter(chucvu, Quanlychucvu.this));
//                    }
//                });
//            }
//        });
//    }
//    public boolean onCreateOptionMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem menuItem = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//
////        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
////        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
////        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
////        searchView.setMaxWidth(MAX_VALUE);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
////                dscvAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                dscvAdapter.getFilter().filter(newText.toString());
//                return false;
//            }
//        });
////       return true;
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if(!searchView.isIconified()){
//            searchView.setIconified(true);
//            return;
//        }
//        super.onBackPressed();
//    }
//    }
//
//    private void fetchData() {
//        String url = "http://chamcong.somee.com/api/Chucvus";
//
//        StringRequest request = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//
//                            for(int i=0;i<jsonArray.length();i++){
//
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//
//                                String ChucvuID = jsonObject.getString("cv_id");
//                                String ChucvuTen = jsonObject.getString("cv_ten");
//
////                                String cases = jsonObject.getString("cases");
////                                String todayCases = jsonObject.getString("todayCases");
////                                String deaths = jsonObject.getString("deaths");
////                                String todayDeaths = jsonObject.getString("todayDeaths");
////                                String recovered = jsonObject.getString("recovered");
////                                String active = jsonObject.getString("active");
////                                String critical = jsonObject.getString("critical");
//
////                                JSONObject object = jsonObject.getJSONObject("countryInfo");
////                                String flagUrl = object.getString("flag");
//
////                                countryModel = new CountryModel(flagUrl,countryName,cases,todayCases,deaths,todayDeaths,recovered,active,critical);
//                                chucvu = new Chucvu(ChucvuID, ChucvuTen);
////                                countryModelsList.add(countryModel);
//                                chucvuModelList.add(chucvu);
//
//
//                            }
//
////                            myCustomAdapter = new MyCustomAdapter(AffectedCountries.this,countryModelsList);
////                            listView.setAdapter(myCustomAdapter);
//                            dscvAdapter = new DSCVAdapter(Quanlychucvu.this, chucvuModelList);
//                            listView.setAdapter(dscvAdapter);
////                            simpleArcLoader.stop();
////                            simpleArcLoader.setVisibility(View.GONE);
//
//
//
//
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
////                            simpleArcLoader.stop();
////                            simpleArcLoader.setVisibility(View.GONE);
//                        }
//
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                simpleArcLoader.stop();
////                simpleArcLoader.setVisibility(View.GONE);
//                Toast.makeText(Quanlychucvu.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(request);
//
//
//    }

//}
