package com.example.trucktrans;

public class ReadwriteUserDetails {
    public String dob,country,mobile;
    public String fullname;
    public ReadwriteUserDetails(){}
    public ReadwriteUserDetails(String textDob,String textcountry,String textMobile,String textFullname){
        this.dob = textDob;
        this.country = textcountry;
        this.mobile = textMobile;
        this.fullname=textFullname;
    }
}

