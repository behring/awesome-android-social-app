package com.thoughtworks.awesomesocialapp.network;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import com.thoughtworks.awesomesocialapp.constants.ServerCode;

public final class MockServerApi implements ServerApiInterface {
    private static MockServerApi instance = new MockServerApi();

    private MockServerApi() {
    }

    public static MockServerApi getInstance() {
        return instance;
    }

    @Override
    public ResponseResult<User> login(String accountName, String password) {
        User user = new User();
        if (accountName.equals("behring") && password.equals("111111")) {
            user.setAccountName(accountName);
            user.setToken("qazxswedcvfr");
            return getSuccessResponseResult(user);
        } else {
            return getFailureResponseResult(ServerCode.LOGIN_ACCOUNT_OR_PASSWORD_ERROR,
                    "用户名或密码错误", new User());
        }
    }

    @Override
    public ResponseResult<List<ChatsItem>> getChatsItems() {
        return getSuccessResponseResult(mockChatsItems());
    }

    private <T> ResponseResult<T> getSuccessResponseResult(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(ServerCode.SUCCESS);
        responseResult.setData(data);
        return responseResult;
    }

    private <T> ResponseResult<T> getFailureResponseResult(int code, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setData(data);
        responseResult.setMessage(message);
        return responseResult;
    }

    private List<ChatsItem> mockChatsItems() {
        List<ChatsItem> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ChatsItem item = new ChatsItem();
            item.setAvatarUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000" +
                    "&sec=1550774291648&di=d021d4fec92c4af2474b8bd79af89ea4&imgtype=0&src=" +
                    "http%3A%2F%2Ftupian.qqjay.com%2Ftou3%2F2015%2F1030%2F64d8430af77d66c80" +
                    "254092965e98398.jpg");
            item.setName("behring" + i);
            item.setNewMessage("this is a new message " + i);
            item.setNewMessageCount(i + 1);
            item.setTime(new Date());
            data.add(item);
        }
        return data;
    }
}

