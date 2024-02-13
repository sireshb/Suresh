package com.example.trucktrans;
import android.widget.ImageView;
import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class User {
    private String td;
    private String mob;
    private String name;
    private String req;
    private String larea;
    private String lcity;
    private String lstate;
    private String uarea;
    private String ucity;
    private String ustate;
    private String disc;
    private String rate;
    private String profilePicUrl; // New field for profile picture URL
    public User() {
    }
    public User(String mob, String name, String req, String larea, String lcity, String lstate, String uarea,
                String ucity, String ustate, String disc, String rate, String td, String profilePicUrl) {
        this.td = td;
        this.mob = mob;
        this.name = name;
        this.req = req;
        this.larea = larea;
        this.lcity = lcity;
        this.lstate = lstate;
        this.uarea = uarea;
        this.ucity = ucity;
        this.ustate = ustate;
        this.disc = disc;
        this.rate = rate;
        this.profilePicUrl = profilePicUrl;
    }
    public String getmob() {
        return mob;
    }
    public String getname() {
        return name;
    }
    public String getreq() {
        return req;
    }
    public String getlarea() {
        return larea;
    }
    public String getlcity() {
        return lcity;
    }
    public String getlstate() {
        return lstate;
    }
    public String getuarea() {
        return uarea;
    }
    public String getucity() {
        return ucity;
    }
    public String getustate() {
        return ustate;
    }
    public String getdisc() {
        return disc;
    }
    public String getrate() {
        return rate;
    }
    public String gettd() {
        return td;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }
    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePicUrl = profilePictureUrl;

    }
}
