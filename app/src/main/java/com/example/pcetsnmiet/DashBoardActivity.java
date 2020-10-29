package com.example.pcetsnmiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pcetsnmiet.Fragments.DashBoardFragment;
import com.example.pcetsnmiet.Fragments.MyProfileFragment;
import com.example.pcetsnmiet.Fragments.NotificationFragment;
import com.example.pcetsnmiet.SideBarActivities.AboutCollege;
import com.example.pcetsnmiet.SideBarActivities.ReportAnIssue;
import com.example.pcetsnmiet.cardsActivity.ErpCardActivity;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class DashBoardActivity extends AppCompatActivity {

    CardView erp;
    DrawerLayout drawerLayout;
    NavigationView side_nav_view;
    Toolbar toolbar;
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dash_board);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();


                //hooks
        erp = (CardView) findViewById(R.id.erp_card);
        drawerLayout = findViewById(R.id.drawer_side);
        side_nav_view = findViewById(R.id.navigation_side);
        toolbar = findViewById(R.id.toolbar);
        chipNavigationBar = findViewById(R.id.chip_navigation_bar);




















        chipNavigationBar.setItemSelected(R.id.dashboard_bottom_navigation_bar,true);

        setSupportActionBar(toolbar);


                            //..........................SIDE NAVIGATION BAR STARTS..........................//

        //to and fro action

//        side_nav_view.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();



         //side navigation
         side_nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId())
                 {
                     case R.id.about_colg:
                           Intent about_colg_intent = new Intent(DashBoardActivity.this, AboutCollege.class);
                           startActivity(about_colg_intent);
                            break;

                     case R.id.website:

                         String s="https://www.nmiet.edu.in/";
                         Uri uri = Uri.parse(s);
                        startActivity(new Intent(Intent.ACTION_VIEW,uri));
                         break;

                     case R.id.theme:

                         break;

                     case R.id.report_issue:
                         Intent report_intent = new Intent(DashBoardActivity.this, ReportAnIssue.class);
                         startActivity(report_intent);
                         break;


                     case R.id.share:
                         Toast.makeText(DashBoardActivity.this, "Third Selected", Toast.LENGTH_SHORT).show();
                         break;

                     case R.id.rate_us:
                         Toast.makeText(DashBoardActivity.this, "Fourth Selected", Toast.LENGTH_SHORT).show();
                         break;

                     case R.id.log_out:
                         Toast.makeText(DashBoardActivity.this, "Fifth Selected", Toast.LENGTH_SHORT).show();
                         break;




                 }
                 drawerLayout.closeDrawer(GravityCompat.START);
                 return true;
             }
         });



                            //..........................SIDE NAVIGATION BAR ENDS..........................//






        //..........................BOTTOM NAVIGATION BAR STARTS..........................//


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashBoardFragment()).commit();



        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
             @Override
             public void onItemSelected(int i) {

                 Fragment fragment = null;

                 switch (i)
                 {
                     case R.id.my_profile_bottom_navigation_bar: fragment=new MyProfileFragment();
                         break;

                     case R.id.dashboard_bottom_navigation_bar: fragment = new DashBoardFragment();
                         break;

                     case R.id.notification_bottom_navigation_bar: fragment= new NotificationFragment();
                         break;
                 }

                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                 }



         });



                        //..........................BOTTOM NAVIGATION BAR ENDS..........................//








    }//oncreate end


    //to avoid closing of app when pressed back once drawer is open
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();

        }
    }
}