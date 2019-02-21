package com.thoughtworks.awesomesocialapp;

public class DataInjection {
    public static Repository provideRepository(@NonNull Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        ServerApi api = ServerApi.getInstance();
        return Repository.getInstance(api, database);

    }
}