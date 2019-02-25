package com.thoughtworks.awesomesocialapp.network;

import org.junit.Test;

import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class RetrofitHelperTest {

    @Test
    public void getRetrofit() {
        assertNotNull(RetrofitHelper.getRetrofit());
    }

    @Test
    public void getRetrofit_whenRetrofitInstanceNotNull_NotRecreateInstance() {
        Retrofit retrofit1 = RetrofitHelper.getRetrofit();
        Retrofit retrofit2 = RetrofitHelper.getRetrofit();
        assertEquals(retrofit1, retrofit2);

    }
}