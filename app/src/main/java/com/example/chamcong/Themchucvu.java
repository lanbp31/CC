package com.example.chamcong;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chamcong.Adapter.DSCVAdapter;
import com.example.chamcong.Object.Chucvu;

import java.util.ArrayList;
import java.util.List;

public class Themchucvu extends AppCompatActivity {
    EditText tencv;
    Button themcvBtn;
    List<Chucvu> chucvuList = new ArrayList<>();
    DSCVAdapter dscvAdapter;
    String ten_cv;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themchucvu);

        tencv = (EditText) findViewById(R.id.tencv);
        themcvBtn = (Button) findViewById(R.id.btnThemcv);

        dscvAdapter = new DSCVAdapter(chucvuList);

        themcvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten_cv = tencv.getText().toString();

                    Chucvu chucvu = new Chucvu();

                    chucvu.setCv_ten(ten_cv);

                chucvuList.add(chucvu);
                dscvAdapter.notifyDataSetChanged();
                Toast.makeText(Themchucvu.this, "Them chuc vu thanh cong",
                                                        Toast.LENGTH_LONG).show();
                tencv.setText("");
            }
        });
    }
}
