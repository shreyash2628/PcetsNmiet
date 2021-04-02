package com.example.pcetsnmiet.QuizCard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pcetsnmiet.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class QuestionsAcivity extends AppCompatActivity {

    private TextView questions,no_of_que_indicator;
    private FloatingActionButton bookmark;
    private Button share,next;
    private LinearLayout options_container;
    private  int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_acivity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //hooks

        questions = findViewById(R.id.questions_textview);
        no_of_que_indicator = findViewById(R.id.no_of_que_textview);
        bookmark = findViewById(R.id.floatingActionButton);

        share = findViewById(R.id.share_button);
        next = findViewById(R.id.next_button);

        options_container = findViewById(R.id.options_container);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                playAnim(questions,0);


            }
        });

    }



    void playAnim(final View view, final int value)
    {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                if(value ==0 && count<4)
                {
                playAnim(options_container.getChildAt(count),0);
                count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                    if (value==0)
                    {
                        playAnim(view,1);
                    }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}