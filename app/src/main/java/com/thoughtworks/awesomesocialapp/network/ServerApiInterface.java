package com.thoughtworks.awesomesocialapp.network;

import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

public interface ServerApiInterface {
    ResponseResult<User> login(String accountName, String password);
}
