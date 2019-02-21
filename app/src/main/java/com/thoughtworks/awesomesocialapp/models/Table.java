package com.thoughtworks.awesomesocialapp.models;

import android.arch.persistence.room.PrimaryKey;

public class Table {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
