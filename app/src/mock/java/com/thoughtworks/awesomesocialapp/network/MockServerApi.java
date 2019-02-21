package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import com.thoughtworks.awesomesocialapp.data.remote.services.LoginService;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import java.io.IOException;

import retrofit2.Call;
import timber.log.Timber;

public final class MockServerApi implements ServerApiInterface {
    private static MockServerApi instance = new MockServerApi();

    private MockServerApi() {
    }

    public static MockServerApi getInstance() {
        return instance;
    }

    @Override
    public ResponseResult<User> login(String accountName, String password) {
        ResponseResult<User> responseResult = new ResponseResult<>();
        responseResult.setCode(NetworkConstants.Code.SUCCESS);
        responseResult.setMessage("Login success");
        User user = new User("zhaolin", "qazxswedcvfr");
        responseResult.setData(user);
        return responseResult;
    }
}