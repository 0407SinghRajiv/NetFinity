package com.example.netfinity;

import java.util.List;



public class JobSeeker {
    public String name;
    public String email;
    public String mobileNumber;
    public List<String> skills;
    public String profileImage;


    public JobSeeker() {
    }


    public JobSeeker(String name, String email, String mobileNumber, List<String> skills, String profileImage) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.skills = skills;
        this.profileImage = profileImage;
    }
}



