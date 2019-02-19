package com.thoughtworks.awesomesocialapp.constants;

import com.thoughtworks.awesomesocialapp.BuildConfig;

public class NetworkConstants {
    private NetworkConstants() {

    }

    public static final String BASE_URL = BuildConfig.BASE_URL;

    public static class Code {
        private Code() {

        }

        public static final int SUCCESS = 0;
    }
}
