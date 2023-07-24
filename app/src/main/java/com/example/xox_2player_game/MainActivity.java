package com.example.xox_2player_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.Objects;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String[][] memory = new String[3][3];
    TextView textView;
    String status = "X";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        TableLayout table = (TableLayout)findViewById(R.id.table);
        int i;
        int j;
        final int[] count = {0};
        for(i=0;i<table.getChildCount();i++)
        {
            TableRow tableRow = (TableRow) table.getChildAt(i);
            for(j=0;j<tableRow.getChildCount();j++)
            {
                View child = tableRow.getChildAt(j);
                if(child instanceof Button)
                {
                   @SuppressLint("DiscouragedApi") Button button = (Button) findViewById(getResources().getIdentifier("button" + (j+3*i+1), "id",
                            this.getPackageName()));
                    int finalI1 = i;
                    int finalJ1 = j;
                    Intent intent = new Intent(this,Winner.class);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(button.getText()!=""){
                                textView.setText("Dont act smart loser");
                            }
                            else if (Objects.equals(status, "X")) {
                                button.setText("X");
                                button.setBackgroundColor(0xFFFFFF00);
                                button.setTextSize(34);
                                status = "O";
                                textView.setText("Second player please play");
                                count[0]++;
                            } else {
                                button.setText("O");
                                button.setBackgroundColor(0xFFFF0000);
                                button.setTextSize(34);
                                status = "X";
                                textView.setText("First player its your turn");
                                count[0]++;
                            }
                            memory[finalI1][finalJ1] = (String) button.getText();
                            String check="O";
                            for (int k = 0; k < 2; k++) {
                                intent.putExtra("hi",check);
                                if (Objects.equals(memory[finalI1][0], check) && Objects.equals(memory[finalI1][1], check) && Objects.equals(memory[finalI1][2], check)) {
                                    startActivity(intent);
                                }
                                if (Objects.equals(memory[0][finalJ1], check) && Objects.equals(memory[1][finalJ1], check) && Objects.equals(memory[2][finalJ1], check)) {
                                    startActivity(intent);
                                }
                                if ((Objects.equals(memory[0][0], check) && Objects.equals(memory[1][1], check) && Objects.equals(memory[2][2], check)) || (Objects.equals(memory[1][2], check) && Objects.equals(memory[0][2], check) && Objects.equals(memory[2][0], check))) {
                                    startActivity(intent);
                                }
                                if (count[0] ==9)
                                {
                                    Toast.makeText(MainActivity.this,"Its a tie King",Toast.LENGTH_SHORT).show();
                                    fun(view);
                                }
                                check = "X";
                            }
                        }
                    });
                }
            }
        }
    }
    public void fun(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}