package com.thoughtworks.awesomesocialapp.login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.test.filters.SmallTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.common.view.ProgressDialog;
import com.thoughtworks.awesomesocialapp.main.MainActivity;
import com.thoughtworks.awesomesocialapp.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowDialog;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.shadows.support.v4.SupportFragmentController;
import java.util.Objects;
import androidx.test.core.app.ApplicationProvider;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.robolectric.Shadows.shadowOf;

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
        Dialog actualDialog = ShadowDialog.getLatestDialog();
        assertTrue(actualDialog instanceof ProgressDialog);
    }

    @Test
    public void testLoginFailure() {
        LoginViewModel mockLoginViewModel = mock(LoginViewModel.class);

        LoginFragment loginFragment = setupLoginFragment();
        loginFragment.setViewModel(mockLoginViewModel);

        doAnswer(invocation -> {
            ((LoginViewModel.OnLoginListener) invocation.getArguments()[2]).onLoginFailure(mock(Throwable.class));
            return null;
        }).when(mockLoginViewModel).login(anyString(), anyString(), any(LoginViewModel.OnLoginListener.class));

        Objects.requireNonNull(loginFragment.getView()).findViewById(R.id.login_button).performClick();

        assertEquals(ShadowToast.getTextOfLatestToast(), ApplicationProvider.getApplicationContext()
                .getString(R.string.login_failure));
    }

    @Test
    public void testLoginSuccess() {
        LoginViewModel mockLoginViewModel = mock(LoginViewModel.class);

        LoginFragment loginFragment = setupLoginFragment();
        loginFragment.setViewModel(mockLoginViewModel);

        doAnswer(invocation -> {
            ((LoginViewModel.OnLoginListener) invocation.getArguments()[2]).onLoginSuccess(mock(User.class));
            return null;
        }).when(mockLoginViewModel).login(anyString(), anyString(), any(LoginViewModel.OnLoginListener.class));

        Objects.requireNonNull(loginFragment.getView()).findViewById(R.id.login_button).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actualIntent = shadowOf(activity).getNextStartedActivity();
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