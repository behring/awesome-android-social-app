package com.thoughtworks.awesomesocialapp.network;

import org.junit.Test;

import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class RetrofitHelperTest {

    @Test
    public void getRetrofit() {
        assertNotNull(RetrofitHelper.getRetrofit());
    }
}