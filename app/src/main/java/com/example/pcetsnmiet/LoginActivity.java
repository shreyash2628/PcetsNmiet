package com.example.pcetsnmiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView forgot_pw,signup_text;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

            login_button = findViewById(R.id.login_button);
        forgot_pw = findViewById(R.id.forgot_password);
        signup_text = findViewById(R.id.sign_up_text);



        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
                startActivity(intent);

            }
        });





        forgot_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fpw = new Intent(LoginActivity.this,ForgotPw.class);
                startActivity(fpw);
            }
        });

        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup_intent = new Intent(LoginActivity.this,SignUp.class);
                startActivity(signup_intent);

            }
        });

        String n = forgot_pw.getText().toString();

    }
}