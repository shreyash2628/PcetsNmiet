package com.example.pcetsnmiet.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pcetsnmiet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MyProfileFragment extends Fragment {

     EditText name;
    private EditText mob;
    private EditText emailID;
    private EditText year_branch;
    private EditText idNo;

    private FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_my_profile, container, false);


    //  EditText  name = (EditText) view.findViewById(R.id.names);
       // name = (EditText) getView().findViewById(R.id.name);
//        mob = getView().findViewById(R.id.mob_no);
//        emailID = getView().findViewById(R.id.email);
//        year_branch = getView().findViewById(R.id.branch_name);
//        idNo = getView().findViewById(R.id.idNO);


//        String namest = name.getText().toString();
//        String mobSt = mob.getText().toString();
//        String emailSt = emailID.getText().toString();
//        String yearSt= year_branch.getText().toString();
//        String idSt = idNo.getText().toString();
//
//
//        Map<String,Object> userMap = new HashMap<>();
//
//        userMap.put("Name",namest);
//        userMap.put("MobileNumber",mobSt);
//        userMap.put("EmailID",emailSt);
//        userMap.put("Branch",yearSt);
//        userMap.put("ID_NO",idSt);

//        firebaseFirestore.collection("USERS").add(userMap)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(getActivity(), "Failed"+e, Toast.LENGTH_SHORT).show();
//                    }
//                });
//


        return view;
    }


}