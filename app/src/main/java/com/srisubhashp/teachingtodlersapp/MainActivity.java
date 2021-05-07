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

//    private void loadData() {
//        levelsList.clear();//clearing any previous contents.
//
//        fireStore.collection("Todlers-Quiz").document("QuizQuestions").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task)
//            {
//                if(task.isSuccessful())// if successfully retrieved the data
//                {
//                    DocumentSnapshot doc = task.getResult();
//                    if(doc.exists())// another security check
//                    {
//                        long levelCount=(long)doc.get("Levels");
//
//                        for(int i=1;i<=levelCount;i++)
//                        {
//                            String levelName=doc.getString("Level"+String.valueOf(i));//we are getting the keys
//                            levelsList.add(levelName);
//                        }
//
////                        Intent intent= new Intent(MainActivity.this,MainActivity.class);
////                        startActivity(intent);// we are making sure to load  the application only after all the data is received.
////                        MainActivity.this.finish();
//                    }
//                    else {
//                        Toast.makeText(MainActivity.this,"No Level Document Exists !",Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else
//                {   //if query was successful.
//                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//                // we are adding onCompleteListener because this executes when its loaded even though it passes or fails.
//    }


}