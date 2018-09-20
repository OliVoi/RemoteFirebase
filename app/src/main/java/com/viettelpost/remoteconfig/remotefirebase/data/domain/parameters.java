package com.viettelpost.remoteconfig.remotefirebase.data.domain;

import java.util.ArrayList;

public class parameters {
    private String title, description, defaultValue;
    private ArrayList<ConditionaValues> conditionalValues;

    public parameters() {
    }

    public parameters(String title, String description, String defaultValue, ArrayList<ConditionaValues> conditionalValues) {
        this.title = title;
        this.description = description;
        this.defaultValue = defaultValue;
        this.conditionalValues = conditionalValues;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public ArrayList<ConditionaValues> getConditionalValues() {
        return conditionalValues;
    }

}
