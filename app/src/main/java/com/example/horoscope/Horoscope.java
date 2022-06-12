package com.example.horoscope;

import android.widget.ImageView;

public class Horoscope {

    String ssname;
    String ssimagename;
    ImageView ssimage;

    public Horoscope(String ssname, String ssimagename, ImageView ssimage) {
        this.ssname = ssname;
        this.ssimagename = ssimagename;
        this.ssimage = ssimage;
    }
}
