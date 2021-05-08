package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class editProfile extends AppCompatActivity {

    private EditText editFirstName, editLastName, editEmail, editPhone, editAge;
    private Button saveBtn, returnBtn;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//grab the Fauth id of the current User.;
        DocumentReference docRef = fStore.collection("users").document(userID);

        editFirstName = findViewById(R.id.edit_firstname_text);
        editLastName = findViewById(R.id.edit_lastname_text);
        editPhone = findViewById(R.id.edit_phone_text);
        editAge = findViewById(R.id.edit_age_text);

        saveBtn = findViewById(R.id.save_button);
        returnBtn = findViewById(R.id.return_profile_button);

        pbar = findViewById(R.id.progressBar3);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbar.setVisibility(View.VISIBLE);
                Map<String, Object> data = new HashMap<>();
                String firstName, lastName, phone, age;
                firstName = editFirstName.getText().toString().trim();
                lastName = editLastName.getText().toString().trim();
                phone = editPhone.getText().toString().trim();
                age = editAge.getText().toString().trim();

                if(!TextUtils.isEmpty(firstName)) {
                    data.put("firstName", firstName);
                }
                if(!TextUtils.isEmpty(lastName)) {
                    data.put("lastName", lastName);
                }
                if(!TextUtils.isEmpty(phone)) {
                    data.put("phone", phone);
                }
                if(!TextUtils.isEmpty(age)) {
                    data.put("age", age);
                }

                docRef.update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                finish();
            }
        });



    }
}