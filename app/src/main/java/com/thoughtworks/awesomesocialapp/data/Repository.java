package com.thoughtworks.awesomesocialapp.data;

import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.network.ServerApiInterface;

import java.util.List;

public final class Repository {
    private static Repository instance = null;

    private final ServerApiInterface api;

    private final AppDatabase database;

    private Repository(ServerApiInterface api, AppDatabase database) {
        this.api = api;
        this.database = database;
    }

    public static Repository getInstance(ServerApiInterface api, AppDatabase database) {
        synchronized (Repository.class) {
            if (instance == null) {
                instance = new Repository(api, database);
            }
            return instance;
        }
    }

    public List<ChatsItem> getChatsItem() {
        database.getUserDao().getUserByToken("1231");
        return api.getChatsItems().getData();
    }
}
