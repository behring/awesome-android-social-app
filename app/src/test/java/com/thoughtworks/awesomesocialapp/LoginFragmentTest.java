package com.thoughtworks.awesomesocialapp;

import android.os.Bundle;
import android.support.test.filters.SmallTest;
import android.view.View;
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
        LoginFragment loginFragment = SupportFragmentController
                .of(LoginFragment.newInstance(), LoginActivity.class)
                .create(R.id.fragment_container, new Bundle()).start().get();

        View rootView = loginFragment.getView();
        assertNotNull(rootView);
        View usernameEditText = rootView.findViewById(R.id.username_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayPasswordEditText() {
        LoginFragment loginFragment = SupportFragmentController
                .of(LoginFragment.newInstance(), LoginActivity.class)
                .create(R.id.fragment_container, new Bundle()).start().get();

        View rootView = loginFragment.getView();
        assertNotNull(rootView);
        View usernameEditText = rootView.findViewById(R.id.password_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }
}