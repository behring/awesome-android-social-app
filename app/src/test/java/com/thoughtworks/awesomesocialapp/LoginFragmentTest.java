package com.thoughtworks.awesomesocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.filters.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.support.v4.SupportFragmentController;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@SmallTest
public class LoginFragmentTest {
    private static final String DEFAULT_USERNAME = "behring";
    private static final String DEFAULT_PASSWORD = "111111";

    private LoginActivity activity = getActivity();

    @Test
    public void onCreateView_shouldDisplayUserNameEditText() {
        View usernameEditText = getRootView().findViewById(R.id.username_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayPasswordEditText() {
        View usernameEditText = getRootView().findViewById(R.id.password_input);
        assertTrue(usernameEditText instanceof EditText);
        assertEquals(usernameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayLoginButton() {
        View loginButton = getRootView().findViewById(R.id.login_button);
        assertTrue(loginButton instanceof Button);
        assertEquals(loginButton.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onClickLoginButton_shouldLoginSuccessToMainActivity() {
        ((EditText) getRootView().findViewById(R.id.username_input)).setText(DEFAULT_USERNAME);
        ((EditText) getRootView().findViewById(R.id.password_input)).setText(DEFAULT_PASSWORD);
        getRootView().findViewById(R.id.login_button).performClick();
        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actualIntent = Shadows.shadowOf(activity).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

    private View getRootView() {
        return setupLoginFragment().getView();
    }

    private LoginFragment setupLoginFragment() {
        return SupportFragmentController
                .of(LoginFragment.newInstance(), LoginActivity.class)
                .create(R.id.fragment_container, new Bundle()).start().resume().get();
    }

    private LoginActivity getActivity() {
        return (LoginActivity) setupLoginFragment().getActivity();
    }
}