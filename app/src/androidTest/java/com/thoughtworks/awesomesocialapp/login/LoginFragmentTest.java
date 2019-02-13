package com.thoughtworks.awesomesocialapp.login;

import com.thoughtworks.awesomesocialapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class LoginFragmentTest {
    private static final String DEFAULT_ACCOUNT_NAME = "behring";
    private static final String DEFAULT_PASSWORD = "111111";

    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void onClickLoginButton_shouldLoginSuccess() {
        onView(withId(R.id.account_name_input)).perform(typeText(DEFAULT_ACCOUNT_NAME));
        onView(withId(R.id.password_input)).perform(typeText(DEFAULT_PASSWORD));
        onView(withText(R.string.login)).perform(click());
        onView(withText("MainFragment")).check(matches(isDisplayed()));
    }
}