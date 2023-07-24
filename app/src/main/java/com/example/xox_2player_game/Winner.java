package com.example.xox_2player_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Winner extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        TextView textView1 = findViewById(R.id.textView1);
        Button button = findViewById(R.id.button);
        String check = getIntent().getStringExtra("hi");
        if(Objects.equals(check, "X"))
        {
            textView1.setText("First player won");
        }
        else
        {
            textView1.setText("Second player won");
        }
        Intent intent = new Intent(this,MainActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(intent);
            }
        });

    }
}