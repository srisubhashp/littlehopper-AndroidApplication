package com.srisubhashp.teachingtodlersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button uProfileBtn, uLevelOneBtn, uLevelTwoBtn, uLevelThreeBtn, uStatsBtn;

    //creating an Array List for getting data from Firebase
    public static List<String> levelsList=new ArrayList<>();
    private FirebaseFirestore fireStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uProfileBtn = findViewById(R.id.profileBtn);
        uLevelOneBtn = findViewById(R.id.levelOneBtn);
        uLevelTwoBtn = findViewById(R.id.levelTwoBtn);
        uLevelThreeBtn = findViewById(R.id.levelThreeBtn);
        uStatsBtn = findViewById(R.id.levelStatsBtn);



        uProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Changing to profile page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        uLevelOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Changing to level one page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelOne.class));
            }
        });

        uLevelTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Changing to level two page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelTwo.class));
            }
        });

        uLevelThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Changing to level three page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LevelThree.class));
            }
        });

        uStatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Changing to stats page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Statistics.class));
            }
        });
    }
}