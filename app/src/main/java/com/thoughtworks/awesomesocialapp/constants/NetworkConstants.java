package com.thoughtworks.awesomesocialapp.constants;

import com.thoughtworks.awesomesocialapp.BuildConfig;

public class NetworkConstants {
    public static final String BASE_URL = BuildConfig.BASE_URL;

    private NetworkConstants() {

    }

    public static class Code {
        public static final int SUCCESS = 0;
        public static final int LOGIN_ACCOUNT_OR_PASSWORD_ERROR = 10001;

        private Code() {

        }

    }
}
