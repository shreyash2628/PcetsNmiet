package com.example.pcetsnmiet.walkthrough;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pcetsnmiet.DashBoardActivity;
import com.example.pcetsnmiet.HelperClass.SliderAdapter;
import com.example.pcetsnmiet.R;

public class Walkthrough extends AppCompatActivity {

    ViewPager viewPager2;
    LinearLayout dotsLayout;
    Button next;
    TextView[] dots;
    Button get_started,nextButton;
    TextView swipe;
    int current;
    Animation animation;

    SliderAdapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);


       next = findViewById(R.id.next_button);
//            swipe = findViewById(R.id.swipe);
        get_started = findViewById(R.id.getstartbutton);
        viewPager2 = findViewById(R.id.viewpager);
        dotsLayout = findViewById(R.id.dots);
        sliderAdapter = new SliderAdapter(this);
        viewPager2.setAdapter(sliderAdapter);

        addDots(0);
        viewPager2.addOnPageChangeListener(changeListener);

        get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Walkthrough.this,DashBoardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private  void addDots(int position)
    {
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);

            dotsLayout.addView(dots[i]);

        }

        if (dots.length>0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.design_default_color_primary_dark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            current=position;



            if (position==0 || position==1 )
            {
                get_started.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            }
            else{
                animation = AnimationUtils.loadAnimation(Walkthrough.this,R.anim.side);
                get_started.setVisibility(View.VISIBLE);
                get_started.setAnimation(animation);

                next.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


    };




    public void skip(View view) {
        Intent intent = new Intent(Walkthrough.this, DashBoardActivity.class);
        startActivity(intent);
        finish();
    }

    public void next(View view) {
        viewPager2.setCurrentItem(current+1);

    }
}