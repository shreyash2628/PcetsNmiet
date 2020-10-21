package com.example.pcetsnmiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    TextView login;
    Button submit;
    TextInputLayout nameET,emailET,passwordET,mobnoET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //hooks

        nameET = findViewById(R.id.name);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        mobnoET = findViewById(R.id.phoneNo);

        submit = findViewById(R.id.signup_button);
        login = findViewById(R.id.login_text);

       String name = nameET.getEditText().getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(!validateName() )
//                {
//
//                }
                Intent intent = new Intent(SignUp.this,DashBoardActivity.class);
                startActivity(intent);
                finish();

            }
        });







    }


    private boolean validateName() {
        String name ;
        return false;
    }









}