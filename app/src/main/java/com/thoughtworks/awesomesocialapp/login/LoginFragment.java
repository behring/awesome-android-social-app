package com.thoughtworks.awesomesocialapp.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.network.ServerApi;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        rootView.findViewById(R.id.login_button).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                ServerApi.login("behring", "111111");
                break;
            default:
                break;
        }
    }
}
