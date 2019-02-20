package com.thoughtworks.awesomesocialapp.main;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.thoughtworks.awesomesocialapp.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 27)
public class MainActivityTest {

    private final MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);

    @Test
    public void testExistNavigationBar() {
        assertNotNull(mainActivity.findViewById(R.id.navigation_tab_bar));
    }

    @Test
    public void testExistViewPager() {
        assertNotNull(mainActivity.findViewById(R.id.view_pager));
    }

    @Test
    public void testViewPagerHasFragmentPagerAdapter() {
        ViewPager viewPager = mainActivity.findViewById(R.id.view_pager);
        assertTrue(viewPager.getAdapter() instanceof FragmentPagerAdapter);
    }

    @Test
    public void testViewPagerHasFourFragments() {
        ViewPager viewPager = mainActivity.findViewById(R.id.view_pager);
        PagerAdapter adapter = viewPager.getAdapter();
        assertNotNull(adapter);
        assertEquals(4, adapter.getCount());
    }
}