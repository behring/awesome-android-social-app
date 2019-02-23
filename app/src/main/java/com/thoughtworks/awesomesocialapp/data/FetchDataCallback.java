package com.thoughtworks.awesomesocialapp.data;

public interface FetchDataCallback<T> {
    void onFetchDataSuccess(T data);

    void onFetchDataFailure(Throwable throwable);
}