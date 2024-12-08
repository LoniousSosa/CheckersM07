package com.example.checkers_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PuzzleChallengeSelection extends AppCompatActivity {

    Button clockButton;
    Button classicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_challenge_selection);
        clockButton = findViewById(R.id.playClock);
        classicButton = findViewById(R.id.playClassic);
        clockButton.setOnClickListener(v -> {
            Intent intent = new Intent(PuzzleChallengeSelection.this,PuzzleTablero.class);
            startActivity(intent);
        });
        clockButton.setOnClickListener(v -> {
            Intent intent = new Intent(PuzzleChallengeSelection.this,PuzzleTablero.class);
            startActivity(intent);
        });

    }
}