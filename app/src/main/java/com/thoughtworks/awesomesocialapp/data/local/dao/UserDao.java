package com.thoughtworks.awesomesocialapp.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.thoughtworks.awesomesocialapp.models.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User WHERE token = :token")
    User getUserByToken(String token);
}
