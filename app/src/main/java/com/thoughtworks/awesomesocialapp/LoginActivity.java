package com.thoughtworks.awesomesocialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG_LOGIN_FRAGMENT = "login_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addLoginFragment();
    }

    private void addLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, LoginFragment.newInstance(), TAG_LOGIN_FRAGMENT)
                .commit();
    }
}
