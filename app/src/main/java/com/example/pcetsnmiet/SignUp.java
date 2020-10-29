package com.example.pcetsnmiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUp extends AppCompatActivity {
    TextView login;
    Button submit;
    TextInputLayout nameET,emailET,passwordET,mobnoET;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //hooks
        mAuth = FirebaseAuth.getInstance();

        nameET = findViewById(R.id.name);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        mobnoET = findViewById(R.id.phoneNo);

        submit = findViewById(R.id.signup_button);
        login = findViewById(R.id.login_text);


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

                if(!validateName() || !validateMobNo() || !validateEmail() || !validatePassWord())
                {
                        return;
                }
                else{

                    String phoneNumberEntered = mobnoET.getEditText().getText().toString();
                    String name = nameET.getEditText().getText().toString();
                    String email = emailET.getEditText().getText().toString();
                    String password = passwordET.getEditText().getText().toString();


                    //sendVFCode(phoneNumberEntered);


                    Intent intent = new Intent(SignUp.this,OTPActivity.class);

                    intent.putExtra("Entered_Phone_No",phoneNumberEntered);
                    intent.putExtra("Entered_Name",name);
                    intent.putExtra("Entered_Email",email);
                    intent.putExtra("Entered_Password",password);
                    startActivity(intent);


                    finish();
                }


            }
        });







    }








    private boolean validateName() {
        String name ;
        name = nameET.getEditText().getText().toString();

        if(name.length()<8)
        {
            nameET.setError("Password is too short");
            return  false;
        }else if(name.isEmpty())
        {
            nameET.setError("This field can not be empty");
            return false;
        }else {
            nameET.setError(null);
            nameET.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validateMobNo() {
        String mob;
        mob = mobnoET.getEditText().getText().toString();

        if(mob.length()<10)
        {
            mobnoET.setError("Invalid Mobile Number");
            return  false;
        }else if(mob.isEmpty())
        {
            mobnoET.setError("This field can not be empty");
            return false;
        }else {
            mobnoET.setError(null);
            mobnoET.setErrorEnabled(false);

            return true;
        }
    }



    private boolean validateEmail() {
        String email ;
        email = emailET.getEditText().getText().toString();

        if(email.isEmpty())
        {
            emailET.setError("This field can not be empty");
            return false;
        }else {
            emailET.setError(null);
            emailET.setErrorEnabled(false);

            return true;
        }
    }



    private boolean validatePassWord() {
        String password ;
        password = passwordET.getEditText().getText().toString();

        if(password.length()<8)
        {
            passwordET.setError("Password is too short");
            return  false;
        }else if(password.isEmpty())
        {
            passwordET.setError("This field can not be empty");
            return false;
        }else {
            passwordET.setError(null);
            passwordET.setErrorEnabled(false);

            return true;
        }
    }













}