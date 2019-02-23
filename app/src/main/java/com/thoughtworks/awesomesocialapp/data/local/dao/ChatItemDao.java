package com.thoughtworks.awesomesocialapp.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatsItem;

@Dao
public interface ChatItemDao {

    @Query("SELECT * FROM chat_item")
    List<ChatsItem> getChatItems();
}
