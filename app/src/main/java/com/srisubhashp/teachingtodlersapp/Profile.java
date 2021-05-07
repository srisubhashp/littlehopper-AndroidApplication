package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView profile, firstName, lastName, email;
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile_text);
        firstName = findViewById(R.id.firstname_text);
        lastName = findViewById(R.id.lastname_text);
        email = findViewById(R.id.email_text);
        returnBtn = findViewById(R.id.return_button);

        firstName.setText(Register.firstName);
        lastName.setText(Register.lastName);
        email.setText(Register.email);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

}