package com.example.pcetsnmiet.HelperClass;

public class userHelperClass {

    String FullName,MobNo,Email,Password;

    public userHelperClass(String fullName, String mobNo, String email, String password) {
        FullName = fullName;
        MobNo = mobNo;
        Email = email;
        Password = password;
    }

    public userHelperClass() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String mobNo) {
        MobNo = mobNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
