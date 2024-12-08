package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword, etConfirmPassword;
    private DataBaseAPP db;
    Button registerButton;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intentUsername = getIntent();
        username = intentUsername.getStringExtra("username");

        db = new DataBaseAPP(this);

        etUsername = findViewById(R.id.username_input);
        etEmail = findViewById(R.id.email_input);
        etPassword = findViewById(R.id.password_input);
        etConfirmPassword = findViewById(R.id.repeat_passwd_input);
        registerButton = findViewById(R.id.registerInButton);

        registerButton.setOnClickListener(v -> {
          Intent intent = new Intent(Register.this,Lobby.class);
        });
        /*
        registerButton.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast toast = Toast.makeText(Register.this, "Please fill all the fields", Toast.LENGTH_SHORT);
                View view = toast.getView();
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(Color.rgb(255,255,255));
                toast.show();
            } else if (!password.equals(confirmPassword)) {
                Toast toast = Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT);
                View view = toast.getView();
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(Color.rgb(255,255,255));
                toast.show();
            } else {
                if(db.checkUser(username, password)) {
                    Toast toast = Toast.makeText(Register.this, "User already exists", Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(Color.rgb(255,255,255));
                    toast.show();
                }
                else{
                    db.addUser(username, email, password);
                    Toast toast = Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    TextView text = view.findViewById(android.R.id.message);
                    text.setTextColor(Color.rgb(255,255,255));
                    toast.show();
                    finish();
                    Intent intent = new Intent(Register.this, Lobby.class);
                    startActivity(intent);
                }
            }
        });

         */
    }
}