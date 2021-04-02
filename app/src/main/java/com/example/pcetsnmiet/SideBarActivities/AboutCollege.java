package com.example.pcetsnmiet.SideBarActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pcetsnmiet.Adapter.AdapterH;
import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.model.MainModel;

import java.util.ArrayList;


public class AboutCollege extends AppCompatActivity {

    ArrayList<MainModel> mainModels;
   AdapterH adapterH;
    RecyclerView recyclerView;
    private ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);


        recyclerView = findViewById(R.id.recycler_view_abcolg);

         map = findViewById(R.id.map_view_img);


         Integer img[] = {R.drawable.entc,R.drawable.mech,R.drawable.pix,R.drawable.it,R.drawable.bvoc};

         String course_name[] = {"","","","",""};




         mainModels = new ArrayList<>();
         for (int i=0;i<img.length;i++)
         {
                MainModel model = new MainModel(img[i],course_name[i]);
                mainModels.add(model);
         }


        LinearLayoutManager layoutManager = new LinearLayoutManager(
                AboutCollege.this,LinearLayoutManager.HORIZONTAL,false
        );
         recyclerView.setLayoutManager(layoutManager);

         recyclerView.setItemAnimator(new DefaultItemAnimator());


         adapterH = new AdapterH(AboutCollege.this,mainModels);
         recyclerView.setAdapter(adapterH);












         map.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri uri = Uri.parse("geo:0,0?q=Nutan Maharashtra Institute of Engineering and Technology");
                 Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                 intent.setPackage("com.google.android.apps.maps");
                 startActivity(intent);
             }
         });

    }
}