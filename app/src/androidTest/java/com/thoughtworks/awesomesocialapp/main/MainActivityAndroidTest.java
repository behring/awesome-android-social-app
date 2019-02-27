package com.thoughtworks.awesomesocialapp.main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.thoughtworks.awesomesocialapp.BuildConfig;
import com.thoughtworks.awesomesocialapp.R;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import devlight.io.library.ntb.NavigationTabBar;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityAndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void navigationBarHas4Items() {
        NavigationTabBar navigationTabBar = activityRule.getActivity().findViewById(R.id.navigation_tab_bar);
        assertEquals(4, navigationTabBar.getModels().size());
    }

    @Test
    public void enterMainActivity_shouldDisplayChatItems() {
        if (BuildConfig.FLAVOR.equals("prod")) {
            onView(withId(R.id.recycler_view)).check(matches(hasDescendant(withText("zhaolin1"))));
        } else {
            onView(withId(R.id.recycler_view)).check(matches(hasDescendant(withText("behring1"))));
        }
    }
}