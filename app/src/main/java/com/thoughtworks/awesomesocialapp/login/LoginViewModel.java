package com.thoughtworks.awesomesocialapp.login;

import android.arch.lifecycle.ViewModel;

import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import com.thoughtworks.awesomesocialapp.exceptions.LoginException;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.ServerApi;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    public interface OnLoginListener {
        void onLoginSuccess(User user);

        void onLoginFailure(Throwable throwable);
    }

    public void login(@NonNull final String accountName, @NonNull final String password,
                      @NonNull final OnLoginListener loginListener) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = Observable.create((ObservableOnSubscribe<ResponseResult<User>>)
                emitter -> {
                    ResponseResult<User> responseResult = ServerApi.login(accountName, password);
                    emitter.onNext(responseResult);

                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResult -> {
                    int responseCode = responseResult.getCode();
                    if (responseCode == NetworkConstants.Code.SUCCESS) {
                        loginListener.onLoginSuccess(responseResult.getData());
                    } else {
                        loginListener.onLoginFailure(
                                new LoginException(responseResult.getMessage(),
                                        responseResult.getCode(),
                                        null));
                    }
                }, loginListener::onLoginFailure);
        compositeDisposable.add(disposable);

    }

}
