package com.thoughtworks.awesomesocialapp;

import android.content.Context;
import android.support.annotation.NonNull;
import com.thoughtworks.awesomesocialapp.data.Repository;
import com.thoughtworks.awesomesocialapp.data.local.AppDatabase;
import com.thoughtworks.awesomesocialapp.network.MockServerApi;

public class DataInjection {
    public static Repository provideRepository(@NonNull Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        MockServerApi api = MockServerApi.getInstance();
        return Repository.getInstance(api, database);

    }
}
