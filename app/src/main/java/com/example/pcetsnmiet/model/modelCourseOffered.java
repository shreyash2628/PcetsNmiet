package com.example.pcetsnmiet.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class modelCourseOffered extends RecyclerView.ViewHolder {
    private String dteCode;
    private String intake;
   private String courseName;

    public modelCourseOffered(@NonNull View itemView) {
        super(itemView);
    }

//
//    public modelCourseOffered(String dteCode, String intake,String courseName) {
//        this.dteCode = dteCode;
//        this.intake = intake;
//        this.courseName = courseName;
//    }



    public String getCourseName() {
        return courseName;
    }

    public String getDteCode() {
        return dteCode;
    }

    public String getIntake() {
        return intake;
    }
}
