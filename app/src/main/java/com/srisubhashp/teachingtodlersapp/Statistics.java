package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    private TextView statistics, level1, level2, level3;
    private Button returnBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        statistics = findViewById(R.id.statistics_view);
        level1 = findViewById(R.id.level1_view);
        level2 = findViewById(R.id.level2_view);
        level3 = findViewById(R.id.level3_view);
        returnBtn2 = findViewById(R.id.return2_button);

        level1.setText("Level 1: " + ScoreActivity.level1Score);
        level2.setText("Level 2: " + ScoreActivity.level2Score);
        level3.setText("Level 3: " + ScoreActivity.level3Score);

        returnBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}