package com.viettelpost.remoteconfig.remotefirebase.data.domain;

public class ConditionaValues {
    private String value, key;

    public ConditionaValues() {
    }

    public ConditionaValues(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
