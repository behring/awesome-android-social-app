package com.thoughtworks.awesomesocialapp.chats;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.constants.ServerCode;
import com.thoughtworks.awesomesocialapp.data.FetchDataCallback;
import com.thoughtworks.awesomesocialapp.data.Repository;
import com.thoughtworks.awesomesocialapp.network.models.ResponseResult;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ChatsViewModel extends AndroidViewModel {
    private final Repository repository;

    public ChatsViewModel(@NonNull Application application, Repository repository) {
        super(application);
        this.repository = repository;
    }

    void getData(FetchDataCallback<List<ChatsItem>> fetchDataCallback) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable = Observable.create(
                (ObservableOnSubscribe<ResponseResult<List<ChatsItem>>>) emitter -> {
                    ResponseResult<List<ChatsItem>> responseResult = repository.getChatsItem();
                    emitter.onNext(responseResult);
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseResult -> {
                    int responseCode = responseResult.getCode();
                    if (responseCode == ServerCode.SUCCESS) {
                        fetchDataCallback.onFetchDataSuccess(responseResult.getData());
                    } else {
                        fetchDataCallback.onFetchDataFailure(new Exception(
                                responseResult.getMessage() + responseResult.getCode()));
                    }
                }, fetchDataCallback::onFetchDataFailure);
        compositeDisposable.add(disposable);
    }
}
