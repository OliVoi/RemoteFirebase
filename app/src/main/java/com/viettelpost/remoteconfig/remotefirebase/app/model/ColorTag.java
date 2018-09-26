package com.viettelpost.remoteconfig.remotefirebase.app.model;

import com.viettelpost.remoteconfig.remotefirebase.data.domain.MyColor;

import java.util.ArrayList;

public class ColorTag {
    private static ColorTag colorTag;
    private static ArrayList<MyColor> tagsArray;
    private MyColor myColor;
    private String arrColor[] = {"ORANGE", "PINK", "LIME","PURPLE", "LOVE" , "INDIGO", "BLUE", "CYAN" , "TEAL" , "GREEN" , "BROWN" };
    private String arrCodeColor[] = {"#ff7410", "#d00057", "#5c9909", "#8900a1", "#ff0000" , "#4431ab", "#197fe5", "#00b2c2" , "#00917c" , "#00ad4a" , "#714840"};

    public static ColorTag getColorTag() {
        if (colorTag == null) {
            colorTag = new ColorTag();
        }
        return colorTag;
    }


    public ArrayList<MyColor> dataColor() {
        tagsArray = new ArrayList<MyColor>();
        for (int i = 0 ;i < arrColor.length; i++) {
            myColor = new MyColor(arrColor[i], arrCodeColor[i]);
            tagsArray.add(myColor);
        }


        return tagsArray;
    }

}
