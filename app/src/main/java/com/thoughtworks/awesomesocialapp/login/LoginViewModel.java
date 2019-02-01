package com.thoughtworks.awesomesocialapp.login;

import android.arch.lifecycle.ViewModel;

import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.ServerApi;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    public interface OnLoginListener {
        void onLoginSuccess(User user);

        void onLoginFailure(Throwable throwable);
    }

    public void login(@NonNull final String accountName, @NonNull final String password,
                      @NonNull final OnLoginListener loginListener) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = Observable.create(new ObservableOnSubscribe<ResponseResult<User>>() {
            @Override
            public void subscribe(ObservableEmitter<ResponseResult<User>> emitter) throws Exception {
                ResponseResult<User> responseResult = ServerApi.login(accountName, password);
                emitter.onNext(responseResult);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseResult<User>>() {
                    @Override
                    public void accept(ResponseResult<User> responseResult) throws Exception {
                        loginListener.onLoginSuccess(responseResult.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        loginListener.onLoginFailure(throwable);
                    }
                });
        compositeDisposable.add(disposable);

    }

}
