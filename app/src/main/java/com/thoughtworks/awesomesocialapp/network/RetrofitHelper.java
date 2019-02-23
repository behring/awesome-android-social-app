package com.thoughtworks.awesomesocialapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

final class RetrofitHelper {
    private static Retrofit retrofit;

    private RetrofitHelper() {
    }

    static Retrofit getRetrofit() {
        synchronized (Retrofit.class) {
            if (retrofit == null) {
                Gson gson = new GsonBuilder()
                        .setDateFormat(NetworkConstants.DATE_FORMAT)
                        .create();

                retrofit = new Retrofit.Builder()
                        .baseUrl(NetworkConstants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
        }
        return retrofit;
    }
}
