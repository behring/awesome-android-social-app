package com.thoughtworks.awesomesocialapp.login;

import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.ToastMatcher;

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

@RunWith(AndroidJUnit4.class)
@MediumTest
public class LoginFragmentAndroidTest {
    private static final String DEFAULT_ACCOUNT_NAME = "behring";
    private static final String DEFAULT_PASSWORD = "111111";

    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void typeCorrectLoginInfo_shouldLoginSuccess() {
        onView(withId(R.id.account_name_input)).perform(typeText(DEFAULT_ACCOUNT_NAME));
        onView(withId(R.id.password_input)).perform(typeText(DEFAULT_PASSWORD));
        onView(withText(R.string.login)).perform(click());
        onView(withId(R.id.navigation_tab_bar)).check(matches(isDisplayed()));
    }

    @Test
    public void typeIncorrectLoginInfo_shouldLoginFailure() {
        onView(withId(R.id.account_name_input)).perform(typeText(DEFAULT_ACCOUNT_NAME));
        onView(withId(R.id.password_input)).perform(typeText("error password"));
        onView(withText(R.string.login)).perform(click());
        onView(withText(R.string.login_failure)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

    }
}