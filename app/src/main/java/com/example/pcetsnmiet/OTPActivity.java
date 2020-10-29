package com.example.pcetsnmiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OTPActivity extends AppCompatActivity {
    String codeBySystem;
    EditText otpCodeEntered;

    Button otpButton;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        otpButton = findViewById(R.id.verifyOTP);
        otpCodeEntered = findViewById(R.id.otp_entered);

        final String entered_phone_no=getIntent().getStringExtra("Entered_Phone_No");

        final String entered_emailId=getIntent().getStringExtra("Entered_Email");
        final String entered_password=getIntent().getStringExtra("Entered_Password");
        final String entered_Name=getIntent().getStringExtra("Entered_Name");


        verifyPhoneNo(entered_phone_no);

        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String OtpEntered = otpCodeEntered.getText().toString();


                if(OtpEntered.isEmpty() )
                {
                    Toast.makeText(OTPActivity.this, "Enter correct OTP ", Toast.LENGTH_SHORT).show();
                }else
                    {
//                        String OtpEntered = otpCodeEntered.getText().toString();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, OtpEntered);
                        signInWithPhoneAuthCredential(credential);
//                        Toast.makeText(OTPActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();

                        insertingIntoDB(entered_phone_no,entered_Name,entered_password,entered_emailId);
                        
                        Intent intent = new Intent(OTPActivity.this,DashBoardActivity.class);
                        startActivity(intent);
                        finish();

                    }



            }
        });


    }




    private void insertingIntoDB(String phone,String name,String pw,String mail)
    {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("Phone", phone);
        user.put("Name", name);
        user.put("Password", pw);
        user.put("Mail",mail);

// Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                        Toast.makeText(OTPActivity.this, "Successful", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                        Toast.makeText(OTPActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });

        db.collection("Accounts").document(phone).set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(OTPActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(OTPActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });




    }










    private void verifyPhoneNo(String entered_phone_no) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+entered_phone_no,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
            codeBySystem = s;
            Toast.makeText(OTPActivity.this, "Code Sent", Toast.LENGTH_SHORT).show();
        }

       @Override
       public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

       }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(OTPActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }
    };

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(OTPActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(OTPActivity.this, "Verification Failed! Try in Again", Toast.LENGTH_SHORT).show();


                        }
                    }
                });
    }


}