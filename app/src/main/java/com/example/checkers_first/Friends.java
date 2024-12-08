package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Friends extends AppCompatActivity {

    RecyclerView recView;
    ArrayList<Friend> datos;
    ReciclerAdapter adaptador;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        datos = new ArrayList<>();
        add = findViewById(R.id.addButton);
        recView = findViewById(R.id.friendsList);
        recView.setHasFixedSize(true);
        recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recView.setLayoutManager((new GridLayoutManager(this,1)));
        for (int i =0; i < 15; i++) {
            datos.add(i,new Friend("Carles Pons",true));
        }
        adaptador = new ReciclerAdapter(datos);
        recView.setAdapter(adaptador);

        add.setOnClickListener(v -> {
            int size = datos.size();
            TextView usernameView = findViewById(R.id.newUsername);
            String username = usernameView.getText().toString();
            datos.add(size,new Friend(username,false));
            adaptador = new ReciclerAdapter(datos);
            recView.setAdapter(adaptador);
        });
    }
}