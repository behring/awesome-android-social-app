package com.thoughtworks.awesomesocialapp.data;

import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;
import com.thoughtworks.awesomesocialapp.constants.LocalCode;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.network.ServerApiInterface;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

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

    public ServerApiInterface getApi() {
        return api;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public ResponseResult<List<ChatItem>> getChatItems() {
        ResponseResult<List<ChatItem>> responseResult = new ResponseResult<>();
        List<ChatItem> chatItems = database.getChatItemDao().getChatItems();
        if (chatItems != null && !chatItems.isEmpty()) {
            responseResult.setData(chatItems);
            responseResult.setCode(LocalCode.QUERY_SUCCESS);
        } else {
            responseResult = api.getChatItems();
        }
        return responseResult;
    }
}
