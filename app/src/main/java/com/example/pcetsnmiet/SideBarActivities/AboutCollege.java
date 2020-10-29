package com.example.pcetsnmiet.SideBarActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.model.modelCourseOffered;

import java.util.ArrayList;
import java.util.List;


public class AboutCollege extends AppCompatActivity {

    RecyclerView recyclerView;
    private ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);


        recyclerView = findViewById(R.id.recylerview_courses_offered);

         map = findViewById(R.id.map_view_img);


         map.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri uri = Uri.parse("geo:0,0?q=Nutan Maharashtra Institute of Engineering and Technology");
                 Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                 intent.setPackage("com.google.android.apps.maps");
                 startActivity(intent);
             }
         });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);

        List<modelCourseOffered> modelCourseOfferedList = new ArrayList<>();
//
//      modelCourseOfferedList.add(new modelCourseOffered("631024510","120","COMPUTER ENGINEERING"));
//        modelCourseOfferedList.add(new modelCourseOffered(" 631024610 ","60","INFORMATION TECHNOLOGY"));
//        modelCourseOfferedList.add(new modelCourseOffered("631037210","60","ELECTRONICS N TELECOMMUNICATION"));
//        modelCourseOfferedList.add(new modelCourseOffered("631061210","120","MECHANICAL ENGINEERING"));
//
//        Adapter adapter = new Adapter() {


    }
}