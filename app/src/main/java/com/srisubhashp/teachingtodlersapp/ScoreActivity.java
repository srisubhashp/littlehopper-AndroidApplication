package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ScoreActivity extends AppCompatActivity {

    private TextView score;
    private Button cont;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;

    public static String level1Score="0/15";
    public static String level2Score="0/15";
    public static String level3Score="0/15";

    public static String getScore1()
    {
        return level1Score;
    }
    public static String getScore2()
    {
        return level2Score;
    }
    public static String getScore3()
    {
        return level3Score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = findViewById(R.id.sa_scoreView);
        cont = findViewById(R.id.sa_continueButton);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        String score_str = getIntent().getStringExtra("SCORE");
        int level=getIntent().getIntExtra("LEVEL",0);
        score.setText(score_str);

        userID=fAuth.getCurrentUser().getUid();//grab the fAuth ID of the current user.
        //Document

        if(level==1)
        {
            level1Score=score_str;
        }
        else if(level==2)
        {
            level2Score=score_str;
        }
        else if(level==3)
        {
            level3Score=score_str;
        }



        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
                ScoreActivity.this.startActivity(intent);
                ScoreActivity.this.finish();
            }
        });
    }
}