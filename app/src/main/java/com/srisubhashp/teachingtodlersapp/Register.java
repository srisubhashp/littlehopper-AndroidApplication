package com.srisubhashp.teachingtodlersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText uFirstName, uLastName, uEmail, uPassword;
    Button uRegisterBtn;

    TextView uLoginView;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uFirstName = findViewById(R.id.firstNameText);
        uLastName = findViewById(R.id.lastNameText);
        uEmail = findViewById(R.id.emailText);
        uPassword = findViewById(R.id.passwordText);
        uRegisterBtn = findViewById(R.id.registerBtn);
        uLoginView = findViewById(R.id.loginView);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        // Ahmed ------------------------------------------------------------------
        if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        uRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notValid = 0;
                String firstName = uFirstName.getText().toString().trim();
                String lastName = uLastName.getText().toString().trim();
                String email = uEmail.getText().toString().trim();
                String password = uPassword.getText().toString().trim();

                if(TextUtils.isEmpty(firstName)) {
                    uFirstName.setError("Must enter a first name.");
                    notValid++;
                }
                if(TextUtils.isEmpty(lastName)) {
                    uLastName.setError("Must enter a last name.");
                    notValid++;
                }
                if(TextUtils.isEmpty(email)) {
                    uEmail.setError("Must enter an email.");
                    notValid++;
                }

                if(password.length() > 16 || password.length() < 8) {
                    uPassword.setError("Password must be between 8 and 16 characters.");
                    notValid++;
                }

                if(notValid > 0) {
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Registration Failed! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }


                    }
                });
            }
        });

        uLoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this, "Changing to login page complete", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }


}