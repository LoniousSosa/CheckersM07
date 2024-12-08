package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Lobby extends AppCompatActivity {

    Button onlineButton,customButton, tiendaButton,puzzleButton;
    ImageButton ayudaButton,puzzledosButton,reglasDeUsoButton,settingsButton,profileButton;
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
        tiendaButton = findViewById(R.id.tiendaButton);
        puzzleButton = findViewById(R.id.puzzleLobby);
        ayudaButton = findViewById(R.id.imageHelp);
        puzzledosButton = findViewById(R.id.imagePuzzle);
        reglasDeUsoButton = findViewById(R.id.imageRules);
        settingsButton = findViewById(R.id.settings);
        profileButton = findViewById(R.id.profile);

        System.out.println(username);

        Intent intentTablero = new Intent(Lobby.this,Tablero.class);

        onlineButton.setOnClickListener(v -> {
            startActivity(intentTablero);
        });

        customButton.setOnClickListener(v -> {
            startActivity(intentTablero);
        });

        puzzleButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,PuzzleSelection.class);
            startActivity(intent);
        });

        tiendaButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,Shop.class);
            startActivity(intent);
        });


        puzzledosButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,Puzzles.class);
            startActivity(intent);
        });

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            /**
             * Todavia no se como plantear la pantalla de configuración.
             * Si poner opciones de idiomas, estilos y demás.
             */
            startActivity(intent);
        });

        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(Lobby.this,Profile.class);
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