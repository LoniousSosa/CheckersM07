package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Puzzles extends AppCompatActivity {
    Button playPuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzles);
        playPuzzle = findViewById(R.id.playPuzzleButton);
        playPuzzle.setOnClickListener(v -> {
            Intent intent = new Intent(Puzzles.this,PuzzleTablero.class);
            startActivity(intent);
        });
    }
}