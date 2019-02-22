package com.thoughtworks.awesomesocialapp.chats;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;
import com.thoughtworks.awesomesocialapp.data.Repository;

public class ChatsViewModel extends AndroidViewModel {
    private final Repository repository;

    public ChatsViewModel(@NonNull Application application, Repository repository) {
        super(application);
        this.repository = repository;
    }

    List<ChatsItem> getData() {
        return repository.getChatsItem();
    }
}
