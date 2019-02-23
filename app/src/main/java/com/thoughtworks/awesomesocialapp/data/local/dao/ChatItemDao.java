package com.thoughtworks.awesomesocialapp.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;
import com.thoughtworks.awesomesocialapp.chats.models.ChatItem;

@Dao
public interface ChatItemDao {

    @Query("SELECT * FROM chat_item")
    List<ChatItem> getChatItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChatItems(List<ChatItem> chatItems);
}
