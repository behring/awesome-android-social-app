package com.thoughtworks.awesomesocialapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.thoughtworks.awesomesocialapp.data.local.dao.UserDao;
import com.thoughtworks.awesomesocialapp.models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao getUserDao();

    public static AppDatabase getInstance(Context context) {
        synchronized (AppDatabase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "Tasks.db")
                        .build();

            }
            return instance;
        }
    }
}
