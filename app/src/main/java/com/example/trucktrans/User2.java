package com.example.trucktrans;

import android.widget.ImageView;
import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class User2 {
    private String td2;
    private String mob2;
    private String name2;
    private String type2;
    private String size2;
    private String varea2;
    private String vcity2;
    private String vstate2;
    private String desti2;
    private String body2;
    private String profilePicUrl;
    public User2() {
    }
    public User2(String mob2, String name2, String type2,String size2,String varea2, String vcity2, String vstate2,
                 String desti2,String body2, String td2,String profilePicUrl) {
        this.td2=td2;
        this.mob2 = mob2;
        this.name2= name2;
        this.type2 = type2;
        this.size2= size2;
        this.varea2 = varea2;
        this.vcity2 = vcity2;
        this.vstate2 = vstate2;
        this.desti2 = desti2;
        this.body2=body2;
        this.profilePicUrl = profilePicUrl;
    }
    public String getmob2() {
        return mob2;
    }
    public String getname2() {
        return name2;
    }
    public String gettype2() {
        return type2;
    }
    public String getsize2() {
        return size2;
    }
    public String getvarea2() {
        return varea2;
    }
    public String getvcity2() {
        return vcity2;
    }
    public String getvstate2() {
        return vstate2;
    }
    public String getdesti2() {
        return desti2;
    }
    public String getbody2() {
        return body2;
    }
    public String gettd2(){return td2;}
    public String getProfilePicUrl() {
        return profilePicUrl;
    }
    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePicUrl = profilePictureUrl;

    }

}

