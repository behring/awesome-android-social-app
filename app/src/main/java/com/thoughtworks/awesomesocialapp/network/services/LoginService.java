package com.thoughtworks.awesomesocialapp.network.services;

import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseResult> login(@Field("uname") String username,@Field("pwd") String password);
}
