package com.example.chamcong;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doimatkhau extends AppCompatActivity {

    Connection connect;
    EditText newpw, newpw2;
    Button btnSavepw;
    final int MIN_PASSWORD_LENGTH = 6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau);

        newpw = (EditText) findViewById(R.id.newpw);
        newpw2 = (EditText) findViewById(R.id.newpw2);
        btnSavepw = (Button) findViewById(R.id.btnSavepw);

        btnSavepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newpw1 = newpw.getText().toString();
                String rpnewpw = newpw2.getText().toString();

                ConnectionHelper conn = new ConnectionHelper();
                connect = conn.CONN();

                if (newpw.getText().toString().equals("")) {
                    newpw.setError("Vui lòng nhập mật khẩu");
                }

                if (newpw2.getText().toString().equals("")) {
                    newpw2.setError("Vui lòng nhập lại mật khẩu");
                }

                // checking minimum password Length
                if (newpw.getText().length() < MIN_PASSWORD_LENGTH) {
                    newpw.setError("Mật khẩu ít nhất " + MIN_PASSWORD_LENGTH + "ký tự");
                }

                if (!newpw.getText().toString().equalsIgnoreCase(newpw2.getText().toString())){
                    newpw2.setError("Mật khẩu không đúng");
                }else {
                    try {
                        ConnectionHelper conHelper = new ConnectionHelper();
                        connect = conHelper.CONN();

                        if (connect != null){
                            String query = " ";
                            Statement st = connect.createStatement();
                            ResultSet result = st.executeQuery(query);
                            if(result.next())
                            {
                                Toast.makeText(Doimatkhau.this, "Đổi mật khẩu thành công.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }catch (Exception ex){
                        Log.e("Error:", ex.getMessage());
                    }
                }
            }
        });
    }

//    public void putPW (View v) {
//        if (updatePW()) {
//
//            // Input is valid, here send data to your server
//
//            String newpw1 = newpw.getText().toString();
//            String rpnewpw = newpw2.getText().toString();
//
//            Toast.makeText(this,"Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
//            // Here you can call you API
//
//        }
//    }
}

