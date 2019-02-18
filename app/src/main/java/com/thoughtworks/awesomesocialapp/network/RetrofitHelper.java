package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RetrofitHelper() {
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
