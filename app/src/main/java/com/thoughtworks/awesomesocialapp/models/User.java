package com.thoughtworks.awesomesocialapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;
@Entity
public class User extends Table {
    public User(String accountName, String token) {
        this.accountName = accountName;
        this.token = token;
    }

    @ColumnInfo(name = "account_name")
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
