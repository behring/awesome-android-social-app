package com.thoughtworks.awesomesocialapp.network.services;

import retrofit2.http.POST;

public interface LoginService {
    @POST("login")
    void login(String username, String password);
}
