package com.thoughtworks.awesomesocialapp.common;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.thoughtworks.awesomesocialapp.DataInjection;
import com.thoughtworks.awesomesocialapp.chats.ChatsViewModel;
import com.thoughtworks.awesomesocialapp.data.Repository;
import com.thoughtworks.awesomesocialapp.login.LoginViewModel;

public final class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static ViewModelFactory instance;
    private final Application application;
    private Repository repository;

    private ViewModelFactory(Application application) {
        this.application = application;
    }

    public static ViewModelFactory getInstance(Application application) {
        synchronized (ViewModelFactory.class) {
            if (instance == null) {
                instance = new ViewModelFactory(application);
            }
            instance.repository = DataInjection.provideRepository(application);
            return instance;
        }
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ChatsViewModel.class)) {
            return (T) new ChatsViewModel(application, repository);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(application);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }
    }
}
