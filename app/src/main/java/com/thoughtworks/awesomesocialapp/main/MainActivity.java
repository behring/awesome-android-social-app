package com.thoughtworks.awesomesocialapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
