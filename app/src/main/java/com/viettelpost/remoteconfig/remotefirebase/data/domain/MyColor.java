package com.viettelpost.remoteconfig.remotefirebase.data.domain;

public class MyColor {
    private String colorName, colorCode;

    public MyColor(String colorName, String colorCode) {
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public String getColorCode() {
        return colorCode;
    }
}
