package com.thoughtworks.awesomesocialapp.models;

import com.google.gson.annotations.SerializedName;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class User extends Table {
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
