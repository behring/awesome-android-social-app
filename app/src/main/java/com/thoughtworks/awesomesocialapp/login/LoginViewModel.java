package com.thoughtworks.awesomesocialapp.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import com.thoughtworks.awesomesocialapp.constants.NetworkConstants;
import com.thoughtworks.awesomesocialapp.constants.ServerCode;
import com.thoughtworks.awesomesocialapp.data.Repository;
import com.thoughtworks.awesomesocialapp.exceptions.LoginException;
import com.thoughtworks.awesomesocialapp.models.User;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {
    private Repository repository;

    public LoginViewModel(Application application, Repository repository) {
        super(application);
        this.repository = repository;
    }

    public interface OnLoginListener {
        void onLoginSuccess(User user);

        void onLoginFailure(Throwable throwable);
    }

    public void login(@NonNull final String accountName, @NonNull final String password,
                      @NonNull final OnLoginListener loginListener) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = Observable.create((ObservableOnSubscribe<ResponseResult<User>>)
                emitter -> {
                    ResponseResult<User> responseResult = repository.getApi()
                            .login(accountName, password);
                    emitter.onNext(responseResult);

                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResult -> {
                    int responseCode = responseResult.getCode();
                    if (responseCode == ServerCode.SUCCESS) {
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
