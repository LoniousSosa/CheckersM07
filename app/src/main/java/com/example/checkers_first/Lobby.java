package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.SQLOutput;

public class Lobby extends AppCompatActivity {

    Button onlineButton,customButton,profileButton,puzzleButton;
    ImageButton tiendaButton,puzzledosButton,reglasDeUsoButton;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Intent intentUsername = getIntent();
        username = intentUsername.getStringExtra("username");

        if (username == null || username.isEmpty()){
            username = "default_username";
        }

        onlineButton = findViewById(R.id.onlineButton);
        customButton = findViewById(R.id.customButton);
        profileButton = findViewById(R.id.profileButton);
        puzzleButton = findViewById(R.id.puzzleLobby);
        tiendaButton = findViewById(R.id.tienda);
        puzzledosButton = findViewById(R.id.);

        System.out.println(username);

        Intent intentTablero = new Intent(Lobby.this,Tablero.class);

        onlineButton.setOnClickListener(v -> {
            startActivity(intentTablero);
        });

        customButton.setOnClickListener(v -> {
            startActivity(intentTablero);
        });

        profileButton.setOnClickListener(v -> {
            Intent intentProfile = new Intent(Lobby.this,Profile.class);
            intentProfile.putExtra("username",username);
            startActivity(intentProfile);
        });

        puzzleButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,PuzzleSelection.class);
            startActivity(intent);
        });

        /**tiendaButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,Shop.class);
            startActivity(intent);
        });
         */

        puzzledosButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,Puzzles.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_activity1:
                startActivity(new Intent(this, Lobby.class));
                return true;
            case R.id.action_activity2:
                startActivity(new Intent(this, Profile.class));
                return true;
            case R.id.action_activity3:
                startActivity(new Intent(this, PuzzleSelection.class));
                return true;
            case R.id.action_activity4:
                startActivity(new Intent(this, Friends.class));
                return true;
            case R.id.action_logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void logout() {
        // Redirigir al usuario a la pantalla de inicio de sesión
        Intent intent = new Intent(this, LogIn.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}