package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import com.thoughtworks.awesomesocialapp.network.services.LoginService;

import java.io.IOException;

import retrofit2.Call;

public final class ServerApi {
    private ServerApi() {

    }

    public static ResponseResult<User> login(String accountName, String password)
            throws IOException {
        LoginService loginService = RetrofitHelper.getRetrofit().create(LoginService.class);
        Call<ResponseResult<User>> call = loginService.login(accountName, password);
        return call.execute().body();
    }
}
