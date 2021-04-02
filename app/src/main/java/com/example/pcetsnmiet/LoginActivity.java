package com.example.pcetsnmiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcetsnmiet.walkthrough.Walkthrough;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    TextView forgot_pw,signup_text;
    Button login_button;
    TextInputLayout mobileNo,Password;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

            login_button = findViewById(R.id.login_button);
        forgot_pw = findViewById(R.id.forgot_password);
        signup_text = findViewById(R.id.sign_up_text);


        mobileNo = findViewById(R.id.mob_no);
        Password = findViewById(R.id.password);

        String mobNoEntered = mobileNo.getEditText().getText().toString();
        String passwordEntered = Password.getEditText().getText().toString();

        FirebaseDatabase root = FirebaseDatabase.getInstance();
        DatabaseReference ref = root.getReference("Users");


        Query checkUser = ref.orderByChild("mobNo").equalTo(mobNoEntered);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















//        if(FirebaseAuth.getInstance().getCurrentUser() != null)
//      {
//         Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
//         startActivity(intent);
//          finish();
//       }

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  String username =


                Intent intent = new Intent(LoginActivity.this, Walkthrough.class);
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