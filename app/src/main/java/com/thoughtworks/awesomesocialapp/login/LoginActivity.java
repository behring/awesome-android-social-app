package com.thoughtworks.awesomesocialapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thoughtworks.awesomesocialapp.R;

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
