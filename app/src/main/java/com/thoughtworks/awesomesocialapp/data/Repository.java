package com.thoughtworks.awesomesocialapp.data;

import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.network.ServerApiInterface;

import java.util.List;

public class Repository {
    private static volatile Repository instance = null;

    private final ServerApiInterface api;

    private final AppDatabase database;

    private Repository(ServerApiInterface api, AppDatabase database) {
        this.api = api;
        this.database = database;
    }

    public static Repository getInstance(ServerApiInterface api, AppDatabase database) {
        if (instance == null) {
            instance = new Repository(api, database);
        }
        return instance;
    }

    public List<ChatsItem> getChatsItem() {
        return api.getChatsItems().getData();
    }
}
