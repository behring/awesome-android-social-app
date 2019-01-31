package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import com.thoughtworks.awesomesocialapp.network.services.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerApi {

    public static void login(String username, String password) {
        LoginService loginService = RetrofitHelper.getRetrofit().create(LoginService.class);
        Call<ResponseResult> call = loginService.login(username,password);
        call.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                response.body();
            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {

            }
        });

    }
}
