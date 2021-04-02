package com.example.pcetsnmiet.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pcetsnmiet.QuizCard.QuestionsAcivity;
import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.cardsActivity.Faculty;
import com.example.pcetsnmiet.cardsActivity.ErpCardActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DashBoardFragment extends Fragment {

    CardView erp,faculty,quiz;
    ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);

        imageSlider = (ImageSlider) view.findViewById(R.id.image_slider);
        erp = view.findViewById(R.id.erp_card);
        quiz = view.findViewById(R.id.quiz_card);

        faculty = view.findViewById(R.id.faculty_cardview);





        //................................CARDS OPERATION STARTS...........................//

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quiz_intent = new Intent(getActivity(), QuestionsAcivity.class);
                startActivity(quiz_intent);
            }
        });

        erp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_erp = new Intent(getActivity(), ErpCardActivity.class);
                startActivity(intent_erp);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Faculty.class);
                startActivity(intent);
            }
        });



        //................................CARDS OPERATION ENDS...........................//








        final List<SlideModel> remoteimages = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("Slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString(), data.child("title").getValue().toString(), ScaleTypes.FIT));
                        }
                        imageSlider.setImageList(remoteimages, ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "error"+error, Toast.LENGTH_SHORT).show();

                    }
                });
        return view;
    }
}