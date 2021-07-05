package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

public class Dangnhap extends AppCompatActivity {

    private Button BtnDangnhap;
    private EditText EtUsername, EtPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        BtnDangnhap = (Button) findViewById(R.id.btnDN);

        EtUsername = (EditText) findViewById(R.id.username);
        EtPassword = (EditText) findViewById(R.id.password);

        BtnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username = EtUsername.getText().toString();
                String Password = EtPassword.getText().toString();

                if(TextUtils.isEmpty(Username) && TextUtils.isEmpty(Password)) {
                    Toast.makeText(Dangnhap.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }

                // calling a method to login our user.
                loginUser(Username, Password);
            }
        });
    }

    private void loginUser(String userName, String password) {
        // calling a method to login a user.
        ParseUser.logInInBackground(userName, password, (parseUser, e) -> {
            // after login checking if the user is null or not.
            if (parseUser != null) {
                // if the user is not null then we will display a toast message
                // with user login and passing that user to new activity.

                Toast.makeText(this, "Login Successful ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Dangnhap.this, Trangchu.class);
                i.putExtra("username", userName);
                startActivity(i);
            } else {
                // display an toast message when user logout of the app.
                ParseUser.logOut();
                Toast.makeText(Dangnhap.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}