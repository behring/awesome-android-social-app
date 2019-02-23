package com.thoughtworks.awesomesocialapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;
import com.thoughtworks.awesomesocialapp.data.local.converters.DateTypeConverter;
import com.thoughtworks.awesomesocialapp.data.local.dao.ChatItemDao;
import com.thoughtworks.awesomesocialapp.data.local.dao.UserDao;
import com.thoughtworks.awesomesocialapp.models.User;

@Database(entities = {User.class, ChatItem.class}, version = 1, exportSchema = false)
@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao getUserDao();
    public abstract ChatItemDao getChatItemDao();

    public static AppDatabase getInstance(Context context) {
        synchronized (AppDatabase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "app.db")
                        .build();

            }
            return instance;
        }
    }
}
