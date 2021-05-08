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

public class Profile extends AppCompatActivity {

    private TextView profile, firstName, lastName, email, phone, age;
    private Button returnBtn, editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//grab the Fauth id of the current User.;
        DocumentReference docRef = fStore.collection("users").document(userID);

        profile = findViewById(R.id.profile_text);
        firstName = findViewById(R.id.firstname_text);
        lastName = findViewById(R.id.lastname_text);
        email = findViewById(R.id.email_text);
        phone = findViewById(R.id.phone_text);
        age = findViewById(R.id.age_text);

        returnBtn = findViewById(R.id.return_button);
        editBtn = findViewById(R.id.edit_button);

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                firstName.setText("First Name: " + user.getFirstName());
                lastName.setText("Last Name: " + user.getLastName());
                email.setText("Email: " + user.getEmail());
                age.setText("Age: " + user.getAge());
                phone.setText("Phone: " + user.getPhone());
            }
        });



        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), editProfile.class));
            }
        });
    }

}