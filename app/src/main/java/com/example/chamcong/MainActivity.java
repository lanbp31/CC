package com.example.chamcong;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String DB_NAME = "dbchamcong.db";
    Button btnlogin, btnmagr;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}