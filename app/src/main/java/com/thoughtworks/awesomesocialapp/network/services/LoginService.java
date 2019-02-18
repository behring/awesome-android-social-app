package com.thoughtworks.awesomesocialapp.network.services;

import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseResult<User>> login(@Field("account_name") String accountName,
                                     @Field("password") String password);
}
