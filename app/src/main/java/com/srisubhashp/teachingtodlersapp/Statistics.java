package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Statistics extends AppCompatActivity {

    private TextView level1, level2, level3, level1A, level2A, level3A;
    private Button returnBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//grab the Fauth id of the current User.;
        DocumentReference docRef = fStore.collection("users").document(userID);

        level1 = findViewById(R.id.level1_view);
        level1A = findViewById(R.id.level1_attempts_view);
        level2 = findViewById(R.id.level2_view);
        level2A = findViewById(R.id.level2_attempts_view);
        level3 = findViewById(R.id.level3_view);
        level3A = findViewById(R.id.level3_attempts_view);
        returnBtn2 = findViewById(R.id.return2_button);

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                level1.setText("Last Level 1 Attempt: " + user.getLevelOneScore());
                level2.setText("Last Level 2 Attempt: " + user.getLevelTwoScore());
                level3.setText("Last Level 3 Attempt: " + user.getLevelThreeScore());
                level1A.setText("Total attempts: " + user.getLevelOneAttempts());
                level2A.setText("Total attempts: " + user.getLevelTwoAttempts());
                level3A.setText("Total attempts: " + user.getLevelThreeAttempts());
            }
        });

        returnBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}