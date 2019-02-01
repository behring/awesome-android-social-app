package com.thoughtworks.awesomesocialapp.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("account_name")
    private String accountName;

    private String token;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
