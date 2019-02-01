package com.thoughtworks.awesomesocialapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.test.filters.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thoughtworks.awesomesocialapp.login.LoginActivity;
import com.thoughtworks.awesomesocialapp.login.LoginFragment;
import com.thoughtworks.awesomesocialapp.login.LoginViewModel;
import com.thoughtworks.awesomesocialapp.main.MainActivity;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.support.v4.SupportFragmentController;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@SmallTest
public class LoginFragmentTest {
    private static final String DEFAULT_ACCOUNT_NAME = "behring";
    private static final String DEFAULT_PASSWORD = "111111";

    private LoginActivity activity = getActivity();

    @Test
    public void onCreateView_shouldDisplayAccountNameEditText() {
        View accountNameEditText = getRootView().findViewById(R.id.account_name_input);
        assertTrue(accountNameEditText instanceof EditText);
        assertEquals(accountNameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayPasswordEditText() {
        View accountNameEditText = getRootView().findViewById(R.id.password_input);
        assertTrue(accountNameEditText instanceof EditText);
        assertEquals(accountNameEditText.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onCreateView_shouldDisplayLoginButton() {
        View loginButton = getRootView().findViewById(R.id.login_button);
        assertTrue(loginButton instanceof Button);
        assertEquals(loginButton.getVisibility(), View.VISIBLE);
    }

    @Test
    public void onClickLoginButton_shouldShowLoading() {
        ((EditText) getRootView().findViewById(R.id.account_name_input)).setText(DEFAULT_ACCOUNT_NAME);
        ((EditText) getRootView().findViewById(R.id.password_input)).setText(DEFAULT_PASSWORD);
        getRootView().findViewById(R.id.login_button).performClick();
//        Intent expectedIntent = new Intent(activity, MainActivity.class);
//        Intent actualIntent = Shadows.shadowOf(activity).getNextStartedActivity();
//        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

    @Test
    public void testLoginApiSuccess() throws IOException {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(0);

        LoginViewModel loginViewModel = ViewModelProviders.of(activity).get(LoginViewModel.class);
        loginViewModel.login(DEFAULT_ACCOUNT_NAME, DEFAULT_PASSWORD, new LoginViewModel.OnLoginListener() {
            @Override
            public void onLoginSuccess(User user) {
                assertNotNull(user);
                assertEquals(user.getAccountName(), DEFAULT_ACCOUNT_NAME);
                Intent expectedIntent = new Intent(activity, MainActivity.class);
                Intent actualIntent = Shadows.shadowOf(activity).getNextStartedActivity();
                assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
            }

            @Override
            public void onLoginFailure(Throwable throwable) {

            }
        });
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