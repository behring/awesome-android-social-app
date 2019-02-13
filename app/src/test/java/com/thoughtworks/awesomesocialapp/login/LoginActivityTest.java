package com.thoughtworks.awesomesocialapp.login;

import android.support.test.filters.SmallTest;
import android.support.v4.app.Fragment;

import com.thoughtworks.awesomesocialapp.login.LoginActivity;
import com.thoughtworks.awesomesocialapp.login.LoginFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@SmallTest
public class LoginActivityTest {
    private static final String TAG_LOGIN_FRAGMENT = "login_fragment";

    @Test
    public void onCreate_shouldAddLoginFragment() {
        LoginActivity loginActivity = Robolectric.buildActivity(LoginActivity.class).create().get();
        Fragment loginFragment = loginActivity.getSupportFragmentManager().findFragmentByTag(TAG_LOGIN_FRAGMENT);
        assertNotNull(loginFragment);
        assertTrue(loginFragment instanceof LoginFragment);
    }
}