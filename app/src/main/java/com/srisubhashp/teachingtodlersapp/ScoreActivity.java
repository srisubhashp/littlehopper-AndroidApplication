package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class ScoreActivity extends AppCompatActivity {

    private TextView score;
    private Button cont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//grab the Fauth id of the current User.;
        DocumentReference documentReference = fStore.collection("users").document(userID);

        score = findViewById(R.id.sa_scoreView);
        cont = findViewById(R.id.sa_continueButton);

        String score_str = getIntent().getStringExtra("SCORE");
        int level=getIntent().getIntExtra("LEVEL",0);
        score.setText(score_str);

        if(level==1)
        {
            documentReference.update("levelOneScore", score_str);
            documentReference.update("levelOneAttempts", FieldValue.increment(1));
        }
        else if(level==2)
        {
            documentReference.update("levelTwoScore", score_str);
            documentReference.update("levelTwoAttempts", FieldValue.increment(1));
        }
        else if(level==3)
        {
            documentReference.update("levelThreeScore", score_str);
            documentReference.update("levelThreeAttempts", FieldValue.increment(1));
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