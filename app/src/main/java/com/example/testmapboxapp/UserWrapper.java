package com.example.testmapboxapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserWrapper {
    @SerializedName("result")
    private List<User> mData;
    @SerializedName("code")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<User> getUser() {
        return mData;
    }

    public void setUser(List<User> data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }
}

