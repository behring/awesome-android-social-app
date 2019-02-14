package com.thoughtworks.awesomesocialapp.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.thoughtworks.awesomesocialapp.R;
import com.thoughtworks.awesomesocialapp.common.view.ProgressDialog;
import com.thoughtworks.awesomesocialapp.main.MainActivity;
import com.thoughtworks.awesomesocialapp.models.User;

public class LoginFragment extends Fragment implements View.OnClickListener, LoginViewModel.OnLoginListener {
    private LoginViewModel viewModel;
    private EditText accountNameEditText;
    private EditText passwordEditText;
    private ProgressDialog progressDialog;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    public void setViewModel(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        accountNameEditText = rootView.findViewById(R.id.account_name_input);
        passwordEditText = rootView.findViewById(R.id.password_input);
        rootView.findViewById(R.id.login_button).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViewModel(ViewModelProviders.of(this).get(LoginViewModel.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                showProgressDialog();
                viewModel.login(accountNameEditText.getText().toString(),
                        passwordEditText.getText().toString(), this);
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        hideProgressDialog();
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        hideProgressDialog();
        Toast.makeText(getActivity(), getString(R.string.login_failure), Toast.LENGTH_SHORT).show();
    }

    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog.Builder(getActivity()).setText("Logging in...").create();
        }
        progressDialog.show();
    }

    private void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.hide();
            progressDialog = null;
        }
    }
}