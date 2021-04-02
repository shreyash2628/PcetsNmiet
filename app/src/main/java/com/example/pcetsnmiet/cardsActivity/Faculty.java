package com.example.pcetsnmiet.cardsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pcetsnmiet.Fragments.DashBoardFragment;
import com.example.pcetsnmiet.R;
import com.example.pcetsnmiet.facultuy_department_fragments_.FeDepartmentFragment;
import com.example.pcetsnmiet.facultuy_department_fragments_.ITDepartmentFragment;

public class Faculty extends AppCompatActivity {
    CardView fe,it,comp,entc,mech;

    LinearLayout hori_LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

hori_LL = findViewById(R.id.hori_layout_department);

fe = findViewById(R.id.feDepartmentCard);
it = findViewById(R.id.ITDepartmentCard);
comp = findViewById(R.id.compDepartmentCard);
entc = findViewById(R.id.EntcDepartmentCard);
mech = findViewById(R.id.mechanicalDepartmentCard);






        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ITDepartmentFragment()).commit();

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Faculty.this, "IT card clicked", Toast.LENGTH_SHORT).show();
                Fragment itfragment = new ITDepartmentFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,itfragment).commit();


            }
        });

        fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment =new FeDepartmentFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

            }
        });

//
//        hori_LL.setOnItemSelectedListener(new hori_LL.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int i) {
//
//                Fragment fragment = null;
//
//                switch (i)
//                {
//                    case R.id.my_profile_bottom_navigation_bar: fragment=new MyProfileFragment();
//                        break;
//
//                    case R.id.dashboard_bottom_navigation_bar: fragment = new DashBoardFragment();
//                        break;
//
//                    case R.id.notification_bottom_navigation_bar: fragment= new NotificationFragment();
//                        break;
//                }
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
//            }
//
//
//
//        });

    }
}