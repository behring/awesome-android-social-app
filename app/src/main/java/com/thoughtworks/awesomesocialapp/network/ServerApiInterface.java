package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import java.util.List;

public interface ServerApiInterface {
    ResponseResult<User> login(String accountName, String password);
    ResponseResult<List<ChatsItem>> getChatsItems();
}
