package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import com.thoughtworks.awesomesocialapp.data.remote.services.LoginService;

import java.io.IOException;

import retrofit2.Call;
import timber.log.Timber;

public final class ServerApi implements ServerApiInterface {
    private static ServerApi instance = new ServerApi();

    private ServerApi() {
    }

    public static ServerApi getInstance() {
        return instance;
    }

    @Override
    public ResponseResult<User> login(String accountName, String password) {
        LoginService loginService = RetrofitHelper.getRetrofit().create(LoginService.class);
        Call<ResponseResult<User>> call = loginService.login(accountName, password);
        try {
            return call.execute().body();
        } catch (IOException e) {
            Timber.e(e);
            return null;
        }
    }
}