package com.thoughtworks.awesomesocialapp.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.chats.ChatsFragment;
import com.thoughtworks.awesomesocialapp.contacts.ContactsFragment;
import com.thoughtworks.awesomesocialapp.discover.DiscoverFragment;
import com.thoughtworks.awesomesocialapp.me.MeFragment;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        MainFragmentPagerAdapter fragmentPagerAdapter = new MainFragmentPagerAdapter(
                getSupportFragmentManager(),
                ChatsFragment.newInstance(),
                ContactsFragment.newInstance(),
                DiscoverFragment.newInstance(),
                MeFragment.newInstance());

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentPagerAdapter);

        final NavigationTabBar navigationTabBar = findViewById(R.id.navigation_tab_bar);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.navbar_chat_normal),
                        getResources().getColor(android.R.color.transparent))
                        .selectedIcon(getResources().getDrawable(R.drawable.navbar_chat_selected))
                        .title("Chats")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.navbar_contacts_normal),
                        getResources().getColor(android.R.color.transparent))
                        .selectedIcon(getResources()
                                .getDrawable(R.drawable.navbar_contacts_selected))
                        .title("Contacts")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.navbar_discover_normal),
                        getResources().getColor(android.R.color.transparent))
                        .selectedIcon(getResources()
                                .getDrawable(R.drawable.navbar_discover_selected))
                        .title("Discover")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.navbar_me_normal),
                        getResources().getColor(android.R.color.transparent))
                        .selectedIcon(getResources().getDrawable(R.drawable.navbar_me_selected))
                        .title("Me")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
    }
}
