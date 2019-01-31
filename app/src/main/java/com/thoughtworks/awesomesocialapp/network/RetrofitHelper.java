package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.constants.NetworkContants;

import retrofit2.Retrofit;

public class RetrofitHelper {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkContants.BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
