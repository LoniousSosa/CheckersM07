package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button signIn;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.signInButtonMain);
        register = findViewById(R.id.registerButtonMain);

        signIn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,LogIn.class);
            startActivity(intent);
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });
    }
}