package com.thoughtworks.awesomesocialapp.exceptions;


import timber.log.Timber;

public class LoginException extends Exception {
    public LoginException(String message, int code, Throwable cause) {
        super(message, cause);
        Timber.e(cause, message, code);
    }
}
