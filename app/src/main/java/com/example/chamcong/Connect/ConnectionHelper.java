package com.example.chamcong.Connect;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    static String username = "sa";
    static String password = "bplan311";
    static String db = "Db_chamcong";
    static String ip = "192.168.0.115";

    @SuppressLint("NewApi")
    public static Connection CONN() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName= " + db
                    + ";user= " + username
                    + ";password= " + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
//    private static String TAG = ConnectionHelper.class.getSimpleName();
//     public ConnectionHelper(){}
//
//    public String makeServiceCall(String reqUrl) {
//        String response = null;
//        try {
//            URL url = new URL(reqUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            // read the response
//            InputStream in = new BufferedInputStream(conn.getInputStream());
//            response = convertStreamToString(in);
//        } catch (MalformedURLException e) {
//            Log.e(TAG, "MalformedURLException: " + e.getMessage());
//        } catch (ProtocolException e) {
//            Log.e(TAG, "ProtocolException: " + e.getMessage());
//        } catch (IOException e) {
//            Log.e(TAG, "IOException: " + e.getMessage());
//        } catch (Exception e) {
//            Log.e(TAG, "Exception: " + e.getMessage());
//        }
//        return response;
//    }

//    private String convertStreamToString(InputStream is) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//
//        String line;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append('\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return sb.toString();
//    }

}

