package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button uProfileBtn, uLevelOneBtn, uLevelTwoBtn, uLevelThreeBtn, uLevelTrackingBtn, uStatsBtn;
    ImageButton uSettingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uProfileBtn = findViewById(R.id.profileBtn);
        uLevelOneBtn = findViewById(R.id.levelOneBtn);
        uLevelTwoBtn = findViewById(R.id.levelTwoBtn);
        uLevelThreeBtn = findViewById(R.id.levelThreeBtn);
        uLevelTrackingBtn = findViewById(R.id.levelTrackingBtn);
        uStatsBtn = findViewById(R.id.levelStatsBtn);
        uSettingsBtn = findViewById(R.id.settingsBtn);

        uProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to profile page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        uLevelOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to level one page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelOne.class));
            }
        });

        uLevelTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to level two page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelTwo.class));
            }
        });

        uLevelThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to level three page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelThree.class));
            }
        });

        uLevelTrackingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to level tracking page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelTracking.class));
            }
        });

        uStatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to stats page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });

        uSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Changing to settings page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });

    }
}