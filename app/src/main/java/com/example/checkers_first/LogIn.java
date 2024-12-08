package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    private EditText etUsername, etPassword;
    Button singInButton;
    /*
    private DataBaseAPP db;

     */
    String username;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Intent intentUsername = getIntent();
        username = intentUsername.getStringExtra("username");

        System.out.println(username);

        /**
         * If con SQL
         */


        etUsername = findViewById(R.id.username_input);
        etPassword = findViewById(R.id.password_input);

        singInButton = findViewById(R.id.signInButton);
        singInButton.setOnClickListener(v -> {
            Intent intent = new Intent(LogIn.this,Lobby.class);
            startActivity(intent);
        });

        /*
        db = new DataBaseAPP(this);
        singInButton.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast toast = Toast.makeText(LogIn.this, "Please fill all the fields", Toast.LENGTH_SHORT);
                View view = toast.getView();
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(Color.rgb(255,255,255));
                toast.show();
            } else {
                if (db.checkUser(username, password)) {
                    Toast toast = Toast.makeText(LogIn.this, "Login successful", Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(Color.rgb(255,255,255));
                    toast.show();
                    Intent intent = new Intent(LogIn.this,Lobby.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(LogIn.this, "Login failed", Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(Color.rgb(255,255,255));
                    toast.show();
                }
            }
        });

         */
    }
}