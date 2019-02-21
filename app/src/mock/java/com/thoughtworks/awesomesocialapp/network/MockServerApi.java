package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class MockServerApi implements ServerApiInterface {
    private static MockServerApi instance = new MockServerApi();

    private MockServerApi() {
    }

    public static MockServerApi getInstance() {
        return instance;
    }

    @Override
    public ResponseResult<User> login(String accountName, String password) {
        User user = new User("zhaolin", "qazxswedcvfr");
        return getSuccessResponseResult(user);
    }

    @Override
    public ResponseResult<List<ChatsItem>> getChatsItems() {
        return getSuccessResponseResult(mockChatsItems());
    }

    private <T> ResponseResult<T> getSuccessResponseResult(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(NetworkConstants.Code.SUCCESS);
        responseResult.setData(data);
        return responseResult;
    }

    private List<ChatsItem> mockChatsItems() {
        List<ChatsItem> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ChatsItem item = new ChatsItem();
            item.setAvatarUrl("");
            item.setName("behring" + i);
            item.setNewMessage("this is a new message " + i);
            item.setNewMessageCount(i + 1);
            item.setTime(new Date());
            data.add(item);
        }
        return data;
    }
}

