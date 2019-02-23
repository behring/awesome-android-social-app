package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

public interface ServerApiInterface {
    ResponseResult login(String accountName, String password);

    ResponseResult getChatsItems();
}
