package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class editProfile extends AppCompatActivity {

    EditText editFirstName, editLastName, editEmail, editPhone, editAge;
    Button saveBtn, returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();//grab the Fauth id of the current User.;
        DocumentReference docRef = fStore.collection("users").document(userID);

        editFirstName = findViewById(R.id.edit_firstname_text);
        editLastName = findViewById(R.id.edit_lastname_text);
        editEmail = findViewById(R.id.edit_email_text);
        editPhone = findViewById(R.id.edit_phone_text);
        editAge = findViewById(R.id.edit_age_text);

        saveBtn = findViewById(R.id.save_button);
        returnBtn = findViewById(R.id.return2_button);

        String firstName, lastName, email, phone, age;
        firstName = editFirstName.getText().toString().trim();
        lastName = editLastName.getText().toString().trim();
        email = editEmail.getText().toString().trim();
        phone = editPhone.getText().toString().trim();
        age = editAge.getText().toString().trim();
    }
}