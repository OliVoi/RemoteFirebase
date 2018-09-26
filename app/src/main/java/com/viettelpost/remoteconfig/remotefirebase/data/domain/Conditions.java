package com.viettelpost.remoteconfig.remotefirebase.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Conditions implements Serializable {
    private String name, expression, tagColor;

    public Conditions() {
    }

    public Conditions(String name, String expression, String tagColor) {
        this.name = name;
        this.expression = expression;
        this.tagColor = tagColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setTagColor(String tagColor) {
        this.tagColor = tagColor;
    }

    public String getName() {
        return name;
    }

    public String getExpression() {
        return expression;
    }

    public String getTagColor() {
        return tagColor;
    }

}
