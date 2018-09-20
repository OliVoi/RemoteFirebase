package com.viettelpost.remoteconfig.remotefirebase.data.domain;

import java.lang.reflect.Array;

public class Version {
    private String versionNumber, updateTime, updateUser, updateOrigin, updateType;

    public Version() {
    }

    public Version(String versionNumber, String updateTime, String updateUser, String updateOrigin, String updateType) {
        this.versionNumber = versionNumber;
        this.updateTime = updateTime;
        this.updateOrigin = updateOrigin;
        this.updateType = updateType;
        this.updateUser = updateUser;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateOrigin(String updateOrigin) {
        this.updateOrigin = updateOrigin;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUpdateOrigin() {
        return updateOrigin;
    }

    public String getUpdateType() {
        return updateType;
    }

    public String getUpdateUser() {
        return updateUser;
    }
}
