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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Adapter.DSNVAdapter;
import com.example.chamcong.Connect.ConnectionHelper;
import com.example.chamcong.Object.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quanlynhanvien extends AppCompatActivity {

    private RequestQueue requestQueue;
    private Button themNhanvienBtn;

    private String TAG = Quanlynhanvien.class.getSimpleName();

    SearchView timNhanvienBtn;
    ListView dsnvListview;
//    ArrayList<HashMap<String, String>> dsnvArraylist;

    List<User> userDataList;
    RecyclerView recyclerView;

//    ArrayAdapter<String> dsnvArrayAdapter;
    DSNVAdapter dsnvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlynhanvien);


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

        setTitle("Quản lý nhân viên");

        userDataList=new ArrayList<>();

        recyclerView=findViewById(R.id.dsnv);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MakeVolleyConnection();
    }
    private void MakeVolleyConnection() {
        userDataList = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "http://chamcong.somee.com/api/users", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray dataArray = response.getJSONArray("data");
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject userData = dataArray.getJSONObject(i);
                        User user = new User();
//                        user.setId(userData.getInt("id"));
                        user.setUser_hoten(userData.getString("ho ten"));
                        user.setUser_email(userData.getString("email"));
//                        user.setAvatar(userData.getString("avatar"));
                        userDataList.add(user);

                    }
                    dsnvAdapter = new DSNVAdapter(userDataList, Quanlynhanvien.this);
                    recyclerView.setAdapter(dsnvAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Quanlynhanvien.this, ""+error.networkResponse,Toast.LENGTH_SHORT).show();
            }
        });

//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}
//        dsnvListview = (ListView) findViewById(R.id.dsnv);
//        requestQueue = Volley.newRequestQueue(this);
//        jsonParse();
//    }
//
//    private void jsonParse() {
//       String URL = "https://run.mocky.io/v3/77647083-b72a-48f6-81d9-c085d9da4169";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("User");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject employee = jsonArray.getJSONObject(i);
//                        String User_hoten = employee.getString("Hoten");
////                        int age = employee.getInt("age");
//                        String User_email = employee.getString("Email");
//                        dsnvListview.setFilterText(User_hoten + ", " + User_email +"\n\n");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        requestQueue.add(request);
//    }
//}


//        dsnvListview = (ListView) findViewById(R.id.dsnv);
//        dsnvArraylist = new ArrayList<>();

//        new GetDSNV().execute();
//        userAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,list);
//        ds_nhanvien.setAdapter(userAdapter);

//    }

//    private class GetDSNV extends AsyncTask<Void, Void, Void> {
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(Quanlynhanvien.this,"Dang tai du lieu",
//                                                            Toast.LENGTH_LONG).show();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            ConnectionHelper sh = new ConnectionHelper();
//            // Making a request to url and getting response
//            String url = "http://chamcong.somee.com/api/Users";
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    // Getting JSON Array node
//                    JSONArray dsnvArray = jsonObj.getJSONArray("Users");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < dsnvArray.length(); i++) {
//                        JSONObject c = dsnvArray.getJSONObject(i);
//                        String user_hoten = c.getString("User_hoten");
//                        String user_email = c.getString("User_email");
////
////                        // Phone node is JSON Object
////                        JSONObject phone = c.getJSONObject("phone");
////                        String mobile = phone.getString("mobile");
////                        String home = phone.getString("home");
////                        String office = phone.getString("office");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> dsnvHashmap = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
////                        dsnvHashmap.put("id", id);
//                        dsnvHashmap.put("user_hoten", user_hoten);
//                        dsnvHashmap.put("user_email", user_email);
////                        dsnvHashmap.put("mobile", mobile);
//
//                        // adding contact to contact list
//                        dsnvArraylist.add(dsnvHashmap);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//                }
//
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            ListAdapter adapter =
//                    new SimpleAdapter(Quanlynhanvien.this, dsnvArraylist,
//                    R.layout.dsnv, new String[]{ "user_hoten","user_email"},
//                    new int[]{R.id.hoten, R.id.email});
//            dsnvListview.setAdapter(adapter);
//        }
//    }
//}

//    private void load_dsnv() {
//        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
//
//        //making the progressbar visible
//        progressBar.setVisibility(View.VISIBLE);
//
//        //creating a string request to send request to the url
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //hiding the progressbar after completion
//                        progressBar.setVisibility(View.INVISIBLE);
//
//
//                        try {
//                            //getting the whole json object from the response
//                            JSONObject obj = new JSONObject(response);
//
//                            //we have the array named hero inside the object
//                            //so here we are getting that json array
//                            JSONArray userArray = obj.getJSONArray("User");
//
//                            //now looping through all the elements of the json array
//                            for (int i = 0; i < userArray.length(); i++) {
//                                //getting the json object of the particular index inside the array
//                                JSONObject userObject = userArray.getJSONObject(i);
//
//                                //creating a hero object and giving them the values from json object
//                                User user =
//                                        new User(userObject.getString("hoten"), userObject.getString("email"));
//
//                                //adding the hero to herolist
//                                userList.add(user);
//                            }
//
//                            //creating custom adapter object
//                            DSNVAdapter adapter = new DSNVAdapter(userList, getApplicationContext());
//
//                            //adding the adapter to listview
//                            ds_nhanvien.setAdapter(adapter);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //displaying the error in toast if occurrs
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        //creating a request queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        //adding the string request to request queue
//        requestQueue.add(stringRequest);
//    }
//}
//
