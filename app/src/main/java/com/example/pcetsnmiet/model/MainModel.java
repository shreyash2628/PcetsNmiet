package com.example.pcetsnmiet.model;

public class MainModel {
    Integer img;
    String course_name;

    public MainModel(Integer img,String name)
    {
        this.img=img;
        this.course_name=name;
    }

    public Integer getImg() {
        return img;
    }

    public String getCourse_name() {
        return course_name;
    }
}
