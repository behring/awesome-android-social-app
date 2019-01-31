package com.thoughtworks.awesomesocialapp;

import android.os.Bundle;
import android.support.test.filters.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentController;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@SmallTest
public class LoginFragmentTest {

    @Test
    public void onCreateView_shouldDisplayUserNameEditText() {
        View rootView = getRootView();
        assertNotNull(rootView);
        View usernameEditText = rootView.findViewById(R.id.username_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayPasswordEditText() {
        View rootView = getRootView();
        assertNotNull(rootView);
        View usernameEditText = rootView.findViewById(R.id.password_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayLoginButton() {
        View rootView = getRootView();
        assertNotNull(rootView);
        View loginButton = rootView.findViewById(R.id.login_button);
        assertTrue(loginButton instanceof Button);
        assertEquals(loginButton.getVisibility(), View.VISIBLE);
    }

    private View getRootView() {
        LoginFragment loginFragment = SupportFragmentController
                .of(LoginFragment.newInstance(), LoginActivity.class)
                .create(R.id.fragment_container, new Bundle()).start().get();
        return loginFragment.getView();
    }
}