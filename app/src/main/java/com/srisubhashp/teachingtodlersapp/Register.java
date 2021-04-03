package com.srisubhashp.teachingtodlersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText uFirstName, uLastName, uEmail, uPassword;
    Button uRegisterBtn;

    TextView uLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uFirstName=findViewById(R.id.firstName);
        uLastName=findViewById(R.id.lastName);
        uEmail=findViewById(R.id.email);
        uPassword=findViewById(R.id.password);
        uRegisterBtn=findViewById(R.id.registerBtn);
        uLoginBtn=findViewById(R.id.loginBtn);


    }


}